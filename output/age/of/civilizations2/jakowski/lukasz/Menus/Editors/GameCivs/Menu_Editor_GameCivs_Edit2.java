/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Menu_Editor_GameCivs_Edit2
extends Menu {
    private final String sCivTAG = "Civilization TAG";
    private int iSRID = 0;

    public Menu_Editor_GameCivs_Edit2() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return "Civilization TAG: " + super.getTextToDrawElem();
            }
        });
        menuElements.add(new Button_Classic("", -1, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, 1.0f);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W, true, false);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }
        });
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
        int tY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tY, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(CFG.lang.get("Religion") + ": " + religionName, -1, CFG.BUTTON_W * 2, tY, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, tY, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(CFG.lang.get("Group") + ": " + CFG.editorCivilization_GameData.iGroupID, -1, CFG.BUTTON_W * 2, tY, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, tY, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("", -1, CFG.BUTTON_W * 2, tY, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, tY, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(CFG.editorCivilization_GameData.getDescription(), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return "Description: " + super.getTextToDrawElem();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.iSRID = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
        int tempSRColorsSize = CFG.serviceRibbonMgr.getSR(CFG.editorCivilization_GameData.sr_GameData.getSRTAG()).getSize();
        for (i = 0; i < tempSRColorsSize; ++i) {
            menuElements.add(new Button_Classic(CFG.lang.get("ServiceRibbon") + " - " + CFG.lang.get("Color") + ": " + (i + 1), -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true){
                int iCurrent;

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                    oSB.setColor(CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getR(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getG(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getB(), 1.0f);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W, true, false);
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + Menu_Editor_GameCivs_Edit2.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W);
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        for (i = CFG.editorCivilization_GameData.sr_GameData.getColors().size(); i < tempSRColorsSize; ++i) {
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
        menuElements.add(new Button_Classic_LR_Line(null, -1, CFG.GAMEWIDTH / 2, CFG.PADD, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.getMenuElem(this.getMenuElemsSize() - 1).setPosY(this.getMenuElem(0).getPosY());
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        if (CFG.editorCivilization_GameData == null) {
            this.getMenuElem(1).setTextE("");
            this.getMenuElem(2).setTextE(CFG.lang.get("CivilizationColor"));
            this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Save"));
            this.getTitleM().setText("Age of History 2: Definitive Edition - " + CFG.lang.get("GameCivilizations"));
            return;
        }
        this.getMenuElem(1).setTextE(CFG.editorCivilization_GameData.getCivTag());
        this.getMenuElem(2).setTextE(CFG.lang.get("CivilizationColor"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Save"));
        this.getTitleM().setText("Age of History 2: Definitive Edition - " + CFG.lang.get("GameCivilizations"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        ArrayList<Color> tempColors = new ArrayList<Color>();
        for (int i = 0; i < CFG.editorCivilization_GameData.sr_GameData.getColors().size(); ++i) {
            tempColors.add(new Color(CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getR(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getG(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getB(), 1.0f));
        }
        int tempWidth = CFG.SERVICE_RIBBON_WIDTH * 6 + CFG.PADD * 5;
        for (int j = 0; j < 6; ++j) {
            CFG.serviceRibbonMgr.drawSRLevel(oSB, CFG.GAMEWIDTH / 2 - tempWidth / 2 + (CFG.SERVICE_RIBBON_WIDTH + CFG.PADD) * j + iTranslateX, this.getMenuElem(10).getPosY() + this.getMenuElem(10).getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 + this.getMenuPosY(), j, 0, 0, this.iSRID, tempColors);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.showKeyboard();
                break;
            }
            case 2: {
                if (CFG.menus.getColorPicker().getVisible() && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == -1) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                    break;
                }
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                CFG.menus.getColorPicker().setActiveRGBColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_GAME_COLOR);
                break;
            }
            case 3: {
                CFG.editorCivilization_GameData.setCivTag(this.getMenuElem(1).getTextE());
                CFG.editorCivilization_GameData.setDescription(this.getMenuElem(12).getTextE());
                --CFG.editorCivilization_GameData.iReligionID;
                if (CFG.editorCivilization_GameData.iReligionID < 0) {
                    CFG.editorCivilization_GameData.iReligionID = Math.max(0, CFG.religionManager.lReligions.size() - 1);
                }
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR_GAME_CIVS_EDIT);
                return;
            }
            case 4: {
                return;
            }
            case 5: {
                CFG.editorCivilization_GameData.setCivTag(this.getMenuElem(1).getTextE());
                CFG.editorCivilization_GameData.setDescription(this.getMenuElem(12).getTextE());
                ++CFG.editorCivilization_GameData.iReligionID;
                if (CFG.editorCivilization_GameData.iReligionID >= CFG.religionManager.lReligions.size()) {
                    CFG.editorCivilization_GameData.iReligionID = 0;
                }
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR_GAME_CIVS_EDIT);
                return;
            }
            case 6: {
                return;
            }
            case 7: {
                return;
            }
            case 8: {
                return;
            }
            case 9: {
                int tempSRID = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
                if (--tempSRID <= 0) {
                    tempSRID = CFG.serviceRibbonMgr.getSRSize() - 1;
                }
                CFG.editorCivilization_GameData.setCivTag(this.getMenuElem(1).getTextE());
                CFG.editorCivilization_GameData.setDescription(this.getMenuElem(12).getTextE());
                CFG.editorCivilization_GameData.sr_GameData.setSRTAG(CFG.serviceRibbonMgr.getTag(tempSRID));
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR_GAME_CIVS_EDIT);
                break;
            }
            case 10: {
                CFG.toastM.addM("ID: " + CFG.serviceRibbonMgr.getTag(this.iSRID), CFG.COLOR_HOVER_TITLE);
                break;
            }
            case 11: {
                int tempSRID2 = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
                if (++tempSRID2 >= CFG.serviceRibbonMgr.getSRSize()) {
                    tempSRID2 = 0;
                }
                CFG.editorCivilization_GameData.setCivTag(this.getMenuElem(1).getTextE());
                CFG.editorCivilization_GameData.setDescription(this.getMenuElem(12).getTextE());
                CFG.editorCivilization_GameData.sr_GameData.setSRTAG(CFG.serviceRibbonMgr.getTag(tempSRID2));
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR_GAME_CIVS_EDIT);
                break;
            }
            case 12: {
                CFG.showKeyboard(iID);
                break;
            }
            default: {
                if (iID == this.getMenuElemsSize() - 1) {
                    if (this.getMenuElem(1).getTextE().length() == 0) {
                        CFG.showKeyboard(1);
                        CFG.toastM.addM("Civilization TAG");
                        break;
                    }
                    CFG.editorCivilization_GameData.setCivTag(this.getMenuElem(1).getTextE());
                    CFG.editorCivilization_GameData.setDescription(this.getMenuElem(12).getTextE());
                    this.saveData();
                    break;
                }
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == iID - 13 && CFG.menus.getColorPicker().getVisible()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                    CFG.menus.getColorPicker().setVisible(false, null);
                    break;
                }
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = iID - 13;
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getR(), CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getG(), CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_GAME_COLOR_SR);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void saveData() {
        block30: {
            FileHandle file;
            OutputStream os = null;
            try {
                while (CFG.serviceRibbonMgr.getSR(this.iSRID).getSize() > CFG.editorCivilization_GameData.sr_GameData.getColors().size()) {
                    CFG.editorCivilization_GameData.sr_GameData.getColors().remove(CFG.editorCivilization_GameData.sr_GameData.getColors().size() - 1);
                }
                file = FileManager.getSaveType("game/civilizations/" + CFG.editorCivilization_GameData.getCivTag());
                file.writeBytes(CFG.serialize(CFG.editorCivilization_GameData), false);
                Json json = new Json();
                json.setOutputType(JsonWriter.OutputType.json);
                FileHandle fileJSON = FileManager.getSaveType("game/civilizations/" + CFG.editorCivilization_GameData.getCivTag() + ".json");
                fileJSON.writeString(json.prettyPrint(CFG.editorCivilization_GameData), false, "UTF-8");
            }
            catch (GdxRuntimeException ex) {
                CFG.toastM.addM("----- " + CFG.lang.get("Error") + " -----", CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(4500);
            }
            catch (IOException ex) {
                if (CFG.LOGs) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (NullPointerException ex) {
                CFG.toastM.addM("----- " + CFG.lang.get("Error") + " -----", CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(4500);
                return;
            }
            finally {
                if (os != null) {
                    try {
                        os.close();
                    }
                    catch (Exception ex) {}
                }
            }
            try {
                file = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
                String tempTags = file.readString();
                if (tempTags.indexOf(CFG.editorCivilization_GameData.getCivTag()) < 0) {
                    FileHandle fileSave = FileManager.getSaveType("game/civilizations/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.editorCivilization_GameData.getCivTag() + ";", false);
                    break block30;
                }
                String[] tempTagsSplited = tempTags.split(";");
                boolean tAdd = true;
                int iSize = tempTagsSplited.length;
                for (int i = 0; i < iSize; ++i) {
                    if (!tempTagsSplited[i].equals(CFG.editorCivilization_GameData.getCivTag())) continue;
                    tAdd = false;
                    break;
                }
                if (tAdd) {
                    FileHandle fileSave = FileManager.getSaveType("game/civilizations/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.editorCivilization_GameData.getCivTag() + ";", false);
                    break block30;
                }
                this.onBackPressed();
                return;
            }
            catch (GdxRuntimeException ex) {
                FileHandle fileSave = FileManager.getSaveType("game/civilizations/Age_of_Civilizations");
                fileSave.writeString(CFG.editorCivilization_GameData.getCivTag() + ";", false);
            }
        }
        try {
            FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + CFG.editorCivilization_GameData.getCivTag());
            readFile.readString();
        }
        catch (GdxRuntimeException ex) {
            FileHandle fileSave2 = FileManager.getSaveType("game/civilizations_informations/" + CFG.editorCivilization_GameData.getCivTag());
            fileSave2.writeString("" + CFG.lang.get(this.getMenuElem(1).getTextE()).substring(CFG.lang.get(this.getMenuElem(1).getTextE()).indexOf(45) + 2, CFG.lang.get(this.getMenuElem(1).getTextE()).length()).replace(' ', '_'), false);
        }
        this.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eEDITOR_GAME_CIVS);
        CFG.menus.setBackAnimation(true);
        CFG.menus.getColorPicker().setVisible(false, null);
        RenderProvince.updateDrawProvinces();
    }
}

