/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Wasteland;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_TextTwoLines;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.WastelandMap_GameData;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_WastelandMap_List
extends Menu {
    public Menu_CreateScenario_WastelandMap_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_TextTwoLines(null, CFG.lang.get("Provinces") + ": " + CFG.core.countLandProvinces(), -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NumberOfProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        try {
            int i;
            String[] tagsSPLITED = null;
            if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
                int i2;
                List<String> tempFiles = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/");
                int iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i2);
                    break;
                }
                tagsSPLITED = new String[tempFiles.size()];
                iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    tagsSPLITED[i2] = tempFiles.get(i2);
                }
            } else {
                FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
            }
            int tempLandProvinces = 0;
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                ++tempLandProvinces;
            }
            for (i = 0; i < tagsSPLITED.length; ++i) {
                FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + tagsSPLITED[i]);
                try {
                    WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
                    menuElements.add(new Button_Game_TextTwoLines(CFG.lang.get(tempGameData.getName()), CFG.lang.get("Provinces") + ": " + (tempLandProvinces - tempGameData.getWastelandProvincesSize()), -1, CFG.PADD * (i + 2), CFG.PADD, CFG.BUTTON_W, true));
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    continue;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("World"));
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView_X();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H + CFG.PADD * 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.55f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(0.137f, 0.141f, 0.145f, 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        int i;
        for (i = 0; i < CFG.menus.getCreateScenario_WastelandContinents().getMenuElemsSize(); ++i) {
            CFG.menus.getCreateScenario_WastelandContinents().getMenuElem(i).setCheckboxSt(true);
        }
        CFG.toastM.addM(this.getMenuElem(iID).getTextE());
        if (iID == 0) {
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                CFG.core.getProv(i).setWastelandLvl(-1);
            }
        } else {
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setWastelandLvl(-1);
            }
            String[] tagsSPLITED = null;
            if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
                int i2;
                List<String> tempFiles = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/");
                int iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i2);
                    break;
                }
                tagsSPLITED = new String[tempFiles.size()];
                iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    tagsSPLITED[i2] = tempFiles.get(i2);
                }
            } else {
                FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
            }
            try {
                FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + tagsSPLITED[iID - 1]);
                WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
                int iSize = tempGameData.getWastelandProvincesSize();
                for (int i3 = 0; i3 < iSize; ++i3) {
                    CFG.core.getProv(tempGameData.getWastelandProvinceID(i3)).setWastelandLvl(0);
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IOException iOException) {
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                // empty catch block
            }
            CFG.core.buildWastelandLevels();
        }
    }
}

