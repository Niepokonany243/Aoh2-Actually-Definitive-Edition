/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.UndoGrowthRate;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.List;

public class Editor_GrowthRate
extends Editor {
    public static float currentGrowthRate = 1.0f;
    public static List<UndoGrowthRate> lUndo;

    private static final void addUndo(int nProvinceID) {
        if (nProvinceID < 0) {
            return;
        }
        if (lUndo.size() > 0) {
            if (Editor_GrowthRate.lUndo.get((int)(Editor_GrowthRate.lUndo.size() - 1)).iProvinceID != nProvinceID && currentGrowthRate != CFG.core.getProv(nProvinceID).getGrowthRate_Pop()) {
                if (lUndo.size() > 50) {
                    lUndo.remove(0);
                    lUndo.add(new UndoGrowthRate(nProvinceID, CFG.core.getProv(nProvinceID).getGrowthRate_Pop()));
                } else {
                    lUndo.add(new UndoGrowthRate(nProvinceID, CFG.core.getProv(nProvinceID).getGrowthRate_Pop()));
                }
            }
        } else if (currentGrowthRate != CFG.core.getProv(nProvinceID).getGrowthRate_Pop()) {
            lUndo.add(new UndoGrowthRate(nProvinceID, CFG.core.getProv(nProvinceID).getGrowthRate_Pop()));
        }
    }

    public static void popUndo() {
        if (lUndo.size() > 0) {
            CFG.core.setActiveProvID(Editor_GrowthRate.lUndo.get((int)(Editor_GrowthRate.lUndo.size() - 1)).iProvinceID);
            currentGrowthRate = Editor_GrowthRate.lUndo.get((int)(Editor_GrowthRate.lUndo.size() - 1)).fGrowthRate;
            Editor_GrowthRate.actionSave(false);
            if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
            }
            lUndo.remove(lUndo.size() - 1);
        }
    }

    public Editor_GrowthRate() {
        lUndo = new ArrayList<UndoGrowthRate>();
    }

    @Override
    public void keyDown(int keycode) {
        int tempInt;
        if (Gdx.input.isKeyPressed(21) && (currentGrowthRate = (float)(tempInt = (int)(currentGrowthRate * 100.0f) - 1) / 100.0f) < 0.02f) {
            currentGrowthRate = 0.02f;
        }
        if (Gdx.input.isKeyPressed(22) && (currentGrowthRate = (float)(tempInt = (int)(currentGrowthRate * 100.0f) + 1) / 100.0f) > 1.0f) {
            currentGrowthRate = 1.0f;
        }
        if (Gdx.input.isKeyPressed(62)) {
            Editor_GrowthRate.actionSave(true);
        }
    }

    public static final void actionSave(boolean addUndo) {
        if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            if (addUndo) {
                Editor_GrowthRate.addUndo(CFG.core.getActiveProvID());
            }
            CFG.core.getProv(CFG.core.getActiveProvID()).setGrowthRate_Population(currentGrowthRate);
            if (CFG.VIEW_SHOW_VALUES) {
                CFG.core.getProv(CFG.core.getActiveProvID()).getArmyObject(0).updateArmyWidth("" + (int)(CFG.core.getProv(CFG.core.getActiveProvID()).getGrowthRate_Pop() * 100.0f) + "%");
            }
            CFG.core.saveProvince_Info_GameData(CFG.core.getActiveProvID());
        }
    }

    @Override
    public String toString() {
        return "GROWTH RATE: " + (int)(currentGrowthRate * 100.0f) + "%";
    }
}

