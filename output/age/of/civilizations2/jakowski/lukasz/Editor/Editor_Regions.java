
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menus.MapEditor.Menu_MapEditor_OptimizationRegions;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.GameE.Menu_GameEditor_Regions;
import age.of.civilizations2.jakowski.lukasz.Region;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.UndoOptimizationRegions;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;
import java.util.List;

public class Editor_Regions
extends Editor {
    public static int activeRegion = 0;
    public static List<UndoOptimizationRegions> lUndo;

    private static final void addUndo(int nProvinceID) {
        if (nProvinceID < 0) {
            return;
        }
        if (lUndo.size() > 0) {
            if (Editor_Regions.lUndo.get((int)(Editor_Regions.lUndo.size() - 1)).iProvinceID != nProvinceID && activeRegion != CFG.core.getRegionID(nProvinceID)) {
                if (lUndo.size() > 50) {
                    lUndo.remove(0);
                    lUndo.add(new UndoOptimizationRegions(nProvinceID, CFG.core.getRegionID(nProvinceID)));
                } else {
                    lUndo.add(new UndoOptimizationRegions(nProvinceID, CFG.core.getRegionID(nProvinceID)));
                }
            }
        } else if (activeRegion != CFG.core.getRegionID(nProvinceID)) {
            lUndo.add(new UndoOptimizationRegions(nProvinceID, CFG.core.getRegionID(nProvinceID)));
        }
    }

    public static void popUndo() {
        if (lUndo.size() > 0) {
            CFG.core.setActiveProvID(Editor_Regions.lUndo.get((int)(Editor_Regions.lUndo.size() - 1)).iProvinceID);
            activeRegion = Editor_Regions.lUndo.get((int)(Editor_Regions.lUndo.size() - 1)).iRegionID;
            Editor_Regions.actionUpdateRegionID(false);
            if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
            }
            lUndo.remove(lUndo.size() - 1);
        }
    }

    public Editor_Regions() {
        lUndo = new ArrayList<UndoOptimizationRegions>();
    }

    @Override
    public void keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(21)) {
            if (--activeRegion < 0) {
                activeRegion = CFG.core.getRegions().size();
            }
        } else if (Gdx.input.isKeyPressed(22) && ++activeRegion > CFG.core.getRegions().size()) {
            activeRegion = 0;
        }
        if ((Gdx.input.isKeyPressed(20) || Gdx.input.isKeyPressed(19)) && CFG.core.getActiveProvID() >= 0) {
            activeRegion = CFG.core.getRegionID(CFG.core.getActiveProvID());
        }
        if (Gdx.input.isKeyPressed(62)) {
            Editor_Regions.actionUpdateRegionID(true);
        }
        if (Gdx.input.isKeyPressed(66)) {
            Editor_Regions.saveRegions();
        }
    }

    public static final void actionUpdateRegionID(boolean addUndo) {
        if (CFG.core.getActiveProvID() >= 0) {
            if (addUndo) {
                Editor_Regions.addUndo(CFG.core.getActiveProvID());
            }
            for (int i = 0; i < CFG.core.getRegions().size(); ++i) {
                for (int j = 0; j < CFG.core.getRegions().get(i).getProvincesSize(); ++j) {
                    if (CFG.core.getRegions().get(i).getProvince(j) != CFG.core.getActiveProvID()) continue;
                    CFG.core.getRegions().get(i).removeProvince(j);
                    CFG.core.getRegions().get(i).buildRegionBounds();
                }
            }
            if (activeRegion >= CFG.core.getRegions().size()) {
                Menu_GameEditor_Regions.lColors.add(CFG.getRandomColor());
                CFG.core.getRegions().add(new Region());
                CFG.core.getRegions().get(CFG.core.getRegions().size() - 1).addProvince(CFG.core.getActiveProvID());
                CFG.core.getRegions().get(CFG.core.getRegions().size() - 1).buildRegionBounds();
                CFG.core.updateRegionsSize();
            } else {
                CFG.core.getRegions().get(activeRegion).addProvince(CFG.core.getActiveProvID());
                CFG.core.getRegions().get(activeRegion).buildRegionBounds();
            }
            if (Menu_MapEditor_OptimizationRegions.showValues) {
                CFG.core.getProv(CFG.core.getActiveProvID()).getArmyObject(0).updateArmyWidth(CFG.core.getRegionID(CFG.core.getActiveProvID()));
            }
            CFG.setRenderO(true);
        }
    }

    public static final void saveRegions() {
        int i;
        FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "regions");
        String sLine = "";
        for (i = 0; i < CFG.core.getRegions().size(); ++i) {
            if (CFG.core.getRegions().get(i).getProvincesSize() != 0) continue;
            Menu_GameEditor_Regions.lColors.remove(i);
            CFG.core.getRegions().remove(i--);
        }
        for (i = 0; i < CFG.core.getRegions().size(); ++i) {
            for (int j = 0; j < CFG.core.getRegions().get(i).getProvincesSize(); ++j) {
                sLine = sLine + CFG.core.getRegions().get(i).getProvince(j) + ";";
            }
            if (i == CFG.core.getRegions().size() - 1) continue;
            sLine = sLine + "\n";
        }
        fileSave.writeString(sLine, false);
        CFG.core.loadRegions();
    }

    @Override
    public String toString() {
        return "SET TO REGION ID: " + activeRegion + (CFG.core.getActiveProvID() >= 0 ? "\n\nACTIVE PROVINCE REGION ID: " + CFG.core.getRegionID(CFG.core.getActiveProvID()) + "\nNUMBER OF PROVINCES: " + CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getProvincesSize() + "\nWIDTH: " + (CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX()) + " [" + (int)((float)(CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX()) * 100.0f / (float)CFG.map.getMpB().getWidthM()) + "%]\nHEIGHT:" + (CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY()) + " [" + (int)((float)(CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY()) * 100.0f / (float)CFG.map.getMpB().getHeightM()) + "%]" : "");
    }
}

