
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Clear;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Menu_CreateCiv_Data
extends Menu {
    private int iSRID = 0;

    public Menu_CreateCiv_Data() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tempH = 100 + CFG.PADD * 4;
        int tPosY = CFG.PADD;
        this.iSRID = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
        float buttonH_Mod = 0.75f;
        int tempSRColorsSize = CFG.serviceRibbonMgr.getSR(CFG.editorCivilization_GameData.sr_GameData.getSRTAG()).getSize();
        for (int i = CFG.editorCivilization_GameData.sr_GameData.getColors().size(); i < tempSRColorsSize; ++i) {
            if (i == 0) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.9843137f, 0.015686275f, 0.0f));
                continue;
            }
            if (i == 1) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(1.0f, 1.0f, 1.0f));
                continue;
            }
            if (i == 2) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.15294118f, 0.3019608f, 0.60784316f));
                continue;
            }
            if (i == 3) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.08627451f, 0.14901961f, 0.4509804f));
                continue;
            }
            Color tempColor = CFG.getRandomColor();
            CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(tempColor.r, tempColor.g, tempColor.b));
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_NewGameStyle(null, -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, true));
        menuElements.add(new Button_NewGameStyle(null, -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, 1.0f);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W, true, false);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PickColor"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        String religionName = "";
        try {
            religionName = CFG.religionManager.getReligion((int)CFG.editorCivilization_GameData.iReligionID).Name;
        }
        catch (Exception ex) {
            CFG.editorCivilization_GameData.iReligionID = 0;
            try {
                religionName = CFG.religionManager.getReligion((int)CFG.editorCivilization_GameData.iReligionID).Name;
            }
            catch (Exception exr) {
                religionName = "";
            }
        }
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("Religion") + ": " + religionName, -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        menuElements.add(new Button_NewGameStyle_Left("<<", -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (tempW - CFG.PADD * 2) / 2 + 1, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        menuElements.add(new Button_NewGameStyle_Right(">>", -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        String nGroup = "" + CFG.editorCivilization_GameData.iGroupID;
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("Group") + ": " + nGroup, -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        menuElements.add(new Button_NewGameStyle_Left("<<", -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (tempW - CFG.PADD * 2) / 2 + 1, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        menuElements.add(new Button_NewGameStyle_Right(">>", -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_NewGameStyle_Left("<<", -1, CFG.PADD, tPosY += CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 3, (tempW - CFG.PADD * 2) / 2 + 1, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        menuElements.add(new Button_NewGameStyle_Right(">>", -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true));
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 0; i < tempSRColorsSize; ++i) {
            menuElements.add(new Button_NewGameStyle_Clear(CFG.lang.get("ServiceRibbon") + " - " + CFG.lang.get("Color") + ": " + (i + 1), -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * buttonH_Mod), true){
                int iCurrent;

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                    oSB.setColor(CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getR(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getG(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getB(), 1.0f);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W, true, false);
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Data.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W);
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        menuElements.add(new Button_NewGameStyle_Left(null, -1, CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2 + 1, true));
        menuElements.add(new Button_NewGameStyle_Right(null, -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, true));
        this.initMenu(null, 0 + AoCGame.LEFT, CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4), tempW, Math.min((tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4) + CFG.PADD)), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("CustomizeFlag"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CivilizationColor"));
        this.getMenuElem(this.getMenuElemsSize() - 2).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Save"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight(), this.getWidthM() + 2, this.getHeightM(), true, false);
        oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM() * 3 / 4, this.getHeightM(), false, true);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        ArrayList<Color> tempColors = new ArrayList<Color>();
        for (int i = 0; i < CFG.editorCivilization_GameData.sr_GameData.getColors().size(); ++i) {
            tempColors.add(new Color(CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getR(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getG(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getB(), 1.0f));
        }
        int tempWidth = CFG.SERVICE_RIBBON_WIDTH * 6 + CFG.PADD * 5;
        for (int j = 0; j < 6; ++j) {
            CFG.serviceRibbonMgr.drawSRLevel(oSB, AoCGame.LEFT + this.getWidthM() / 2 - tempWidth / 2 + (CFG.SERVICE_RIBBON_WIDTH + CFG.PADD) * j + iTranslateX, this.getMenuElem(8).getPosY() - CFG.PADD * 2 - CFG.SERVICE_RIBBON_HEIGHT + this.getMenuPosY(), j, 0, 0, this.iSRID, tempColors);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 2) {
            CFG.menus.getColorPicker().setVisible(false, null);
            CFG.menus.setMenuID(CFG.backToMenu);
            CFG.map.getMpB().updateWorldMap_Shaders();
            RenderProvince.updateDrawProvinces();
            return;
        }
        if (iID == this.getMenuElemsSize() - 1) {
            if (CFG.menus.getCreateCiv_Name().getTextE().length() == 0) {
                CFG.toastM.addM("-- " + CFG.lang.get("CivilizationName") + " --", CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(2500);
            } else if (CFG.editorCivilization_GameData.getR() == 0 && CFG.editorCivilization_GameData.getG() == 0 && CFG.editorCivilization_GameData.getB() == 0) {
                CFG.toastM.addM("-- " + CFG.lang.get("CivilizationColor") + " --", CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(2500);
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                CFG.menus.getColorPicker().setActiveRGBColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_GAME_COLOR);
            } else {
                CFG.menus.getColorPicker().setVisible(false, null);
                this.saveData();
            }
            return;
        }
        switch (iID) {
            case 0: {
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.menus.setVisibleCreateCiv_Data(false);
                CFG.menus.rebuildCreateCiv_Flag();
                return;
            }
            case 1: {
                if (CFG.menus.getColorPicker().getVisible() && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == -1) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                    CFG.menus.getColorPicker().setActiveRGBColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f);
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_GAME_COLOR);
                }
                return;
            }
            case 2: {
                return;
            }
            case 3: {
                --CFG.editorCivilization_GameData.iReligionID;
                if (CFG.editorCivilization_GameData.iReligionID < 0) {
                    CFG.editorCivilization_GameData.iReligionID = Math.max(0, CFG.religionManager.lReligions.size() - 1);
                }
                CFG.menus.rebuildCreateCiv_Data();
                return;
            }
            case 4: {
                ++CFG.editorCivilization_GameData.iReligionID;
                if (CFG.editorCivilization_GameData.iReligionID >= CFG.religionManager.lReligions.size()) {
                    CFG.editorCivilization_GameData.iReligionID = 0;
                }
                CFG.menus.rebuildCreateCiv_Data();
                return;
            }
            case 5: {
                return;
            }
            case 6: {
                return;
            }
            case 7: {
                return;
            }
            case 8: {
                int tempSRID = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
                if (--tempSRID <= 0) {
                    tempSRID = CFG.serviceRibbonMgr.getSRSize() - 1;
                }
                CFG.editorCivilization_GameData.sr_GameData.setSRTAG(CFG.serviceRibbonMgr.getTag(tempSRID));
                CFG.menus.rebuildCreateCiv_Data();
                return;
            }
            case 9: {
                int tempSRID2 = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
                if (++tempSRID2 >= CFG.serviceRibbonMgr.getSRSize()) {
                    tempSRID2 = 0;
                }
                CFG.editorCivilization_GameData.sr_GameData.setSRTAG(CFG.serviceRibbonMgr.getTag(tempSRID2));
                CFG.menus.rebuildCreateCiv_Data();
                return;
            }
        }
        if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == iID - 10 && CFG.menus.getColorPicker().getVisible()) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
            CFG.menus.getColorPicker().setVisible(false, null);
        } else {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = iID - 10;
            CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getR(), CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getG(), CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getB());
            CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_GAME_COLOR_SR);
        }
    }

    
    private final void saveData() {
        FileHandle file;
        OutputStream os = null;
        try {
            CFG.editorCivilization_GameData.setCivTag(CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            while (CFG.serviceRibbonMgr.getSR(this.iSRID).getSize() > CFG.editorCivilization_GameData.sr_GameData.getColors().size()) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().remove(CFG.editorCivilization_GameData.sr_GameData.getColors().size() - 1);
            }
            file = FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            file.writeBytes(CFG.serialize(CFG.editorCivilization_GameData), false);
        }
        catch (IOException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception ex) {}
            }
        }
        os = null;
        try {
            file = FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FD");
            file.writeBytes(CFG.serialize(CFG.flagManager.flagEdit), false);
        }
        catch (IOException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception ex) {}
            }
        }
        os = null;
        FileHandle fileSaveName = FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_NM");
        fileSaveName.writeString(CFG.menus.getCreateCiv_Name().getTextE(), false);
        try {
            FileHandle file2 = CFG.readLocalFiles() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
            String tempTags = file2.readString();
            if (tempTags.indexOf(CFG.EDITOR_ACTIVE_GAMEDATA_TAG) < 0) {
                FileHandle fileSave = FileManager.getSaveType("game/civilizations_editor/Age_of_Civilizations");
                fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
            } else {
                String[] tempTagsSplited = tempTags.split(";");
                boolean tAdd = true;
                int iSize = tempTagsSplited.length;
                for (int i = 0; i < iSize; ++i) {
                    if (!tempTagsSplited[i].equals(CFG.EDITOR_ACTIVE_GAMEDATA_TAG)) continue;
                    tAdd = false;
                    break;
                }
                if (tAdd) {
                    FileHandle fileSave = FileManager.getSaveType("game/civilizations_editor/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
                }
            }
        }
        catch (GdxRuntimeException ex) {
            FileHandle fileSave = FileManager.getSaveType("game/civilizations_editor/Age_of_Civilizations");
            fileSave.writeString(CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
        }
        CFG.menus.setMenuID(View.eGENERATE_FLAG);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

