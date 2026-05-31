/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.FormableCivs;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Menu_MapEditor_FormableCivs_Edit
extends Menu {
    private Image lFlag = null;

    public Menu_MapEditor_FormableCivs_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Text(null, -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, false){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.selectMode;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
            }
        });
        menuElements.add(new Slide(CFG.PADD + IMGManager.getIMG(Images.slideBG).getHeight() / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() / 2 - IMGManager.getIMG(Images.slideBG).getHeight() * 2, CFG.brushMode));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                }
                try {
                    Menu_MapEditor_FormableCivs_Edit.this.lFlag.drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - Menu_MapEditor_FormableCivs_Edit.this.lFlag.getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                catch (NullPointerException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
                super.drawTextE(oSB, CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, iTranslateY, isActive);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 2 + CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                }
                IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.wikipedia).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                if (CFG.formableCivs_GameData.getFormableCivTag() != null) {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException e) {
                        this.menuElemHover = null;
                    }
                    catch (NullPointerException ex) {
                        this.menuElemHover = null;
                    }
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public boolean getIsClickable() {
                return CFG.formableCivs_GameData.getFormableCivTag() != null;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("FormableCivilization") + ": " + (CFG.formableCivs_GameData.getFormableCivTag() == null ? CFG.lang.get("None") : CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag()) + " [" + CFG.formableCivs_GameData.getFormableCivTag() + "] " + CFG.lang.get(CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID(CFG.formableCivs_GameData.getFormableCivTag())).getName())));
        this.getMenuElem(4).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Select"));
        this.getMenuElem(6).setTextE(CFG.lang.get("DeselectAll"));
        this.getMenuElem(7).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Map"));
        this.getMenuElem(10).setTextE(CFG.lang.get("SetCapital"));
        this.updateButtonWidth(5, CFG.PADD, CFG.BUTTON_W * 2);
        for (int i = 5; i < 9; ++i) {
            this.updateButtonWidth(i, CFG.PADD, CFG.BUTTON_W);
        }
        this.updateButtonWidth(10, CFG.PADD, CFG.BUTTON_W);
        this.updateButtonWidth(11, this.getMenuElem(10).getPosXE() + this.getMenuElem(10).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(6).getWidthE() - CFG.PADD;
        this.getMenuElem(6).setPosX(tempX);
        tempX = tempX - this.getMenuElem(7).getWidthE() - CFG.PADD;
        this.getMenuElem(7).setPosX(tempX);
        tempX = tempX - this.getMenuElem(8).getWidthE() - CFG.PADD;
        this.getMenuElem(8).setPosX(tempX);
        this.loadFlag();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(8).getPosXE() - CFG.PADD + iTranslateX, CFG.BUTTON_H + CFG.PADD * 2 + this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(8).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, this.getMenuElem(10).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(10).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(11).getPosXE() + this.getMenuElem(11).getWidthE() + CFG.PADD, this.getMenuElem(10).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            this.lFlag.drawO(oSB, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() / 2 + this.getMenuElem(3).getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - this.lFlag.getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() / 2 + this.getMenuElem(3).getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
        }
        catch (NullPointerException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() / 2 + this.getMenuElem(3).getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() / 2 + this.getMenuElem(3).getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                CFG.brushMode = false;
                CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS);
                CFG.menus.setBackAnimation(true);
                return;
            }
            case 1: {
                if (CFG.formableCivs_GameData.getFormableCivTag() == null) {
                    CFG.toastM.addM("-- " + CFG.lang.get("FormableCivilization") + " --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    break;
                }
                if (CFG.formableCivs_GameData.getClaimantsSize() == 0) {
                    CFG.toastM.addM("-- " + CFG.lang.get("Claimants") + " --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    break;
                }
                if (CFG.core.getProvSelected().getProvSize() == 0) {
                    CFG.toastM.addM("-- " + CFG.lang.get("Provinces") + ": 0 --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    CFG.selectMode = true;
                    CFG.VIEW_SHOW_VALUES = false;
                    break;
                }
                if (!this.getIsCapitalOfFormableCivInSelectedProvinces()) {
                    CFG.toastM.addM("-- " + CFG.lang.get("SetCapital") + " --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    break;
                }
                this.saveFormableCiv();
                this.onBackPressed();
                CFG.brushMode = false;
                CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS);
                CFG.menus.setBackAnimation(true);
                break;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 3: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS_SELECT_FORMABLE);
                break;
            }
            case 4: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(9).setVisibleE(CFG.brushMode);
                break;
            }
            case 5: {
                CFG.selectMode = !CFG.selectMode;
                break;
            }
            case 6: {
                CFG.setDialogType(DialogType.DESELET_ALL_SELECTED_PROVINCES);
                break;
            }
            case 7: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() != 0) break;
                CFG.selectMode = true;
                break;
            }
            case 8: {
                CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                break;
            }
            case 10: {
                if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                    CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                    CFG.formableCivs_GameData.setCapitalProvinceID(CFG.core.getActiveProvID());
                    CFG.toastM.addM(CFG.lang.get("CapitalMoved"), CFG.COLOR_POSITIVE);
                    break;
                }
                CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                break;
            }
            case 11: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.formableCivs_GameData.getFormableCivTag();
                CFG.setDialogType(DialogType.GO_TO_WIKI);
            }
        }
    }

    @Override
    public void onBackPressed() {
        this.disposeFlag();
    }

    public final boolean getIsCapitalOfFormableCivInSelectedProvinces() {
        if (CFG.formableCivs_GameData.getCapitalProvinceID() < 0) {
            return false;
        }
        for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
            if (CFG.core.getProvSelected().getProv(i) != CFG.formableCivs_GameData.getCapitalProvinceID()) continue;
            return true;
        }
        CFG.formableCivs_GameData.setCapitalProvinceID(-1);
        return false;
    }

    private final void saveFormableCiv() {
        OutputStream os = null;
        for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getSeaProv()) continue;
            CFG.formableCivs_GameData.addProvince(CFG.core.getProvSelected().getProv(i));
        }
        try {
            FileHandle fileData = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + CFG.formableCivs_GameData.getFormableCivTag());
            fileData.writeBytes(CFG.serialize(CFG.formableCivs_GameData), false);
        }
        catch (IOException fileData) {
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception fileData) {}
            }
        }
        try {
            FileHandle file = CFG.readLocalFiles() ? Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations") : FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
            String tempTags = file.readString();
            if (tempTags.indexOf(CFG.formableCivs_GameData.getFormableCivTag()) < 0) {
                FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                fileSave.writeString(tempTags + CFG.formableCivs_GameData.getFormableCivTag() + ";", false);
            } else {
                String[] tempTagsSplited = tempTags.split(";");
                boolean tAdd = true;
                int iSize = tempTagsSplited.length;
                for (int i = 0; i < iSize; ++i) {
                    if (!tempTagsSplited[i].equals(CFG.formableCivs_GameData.getFormableCivTag())) continue;
                    tAdd = false;
                    break;
                }
                if (tAdd) {
                    FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.formableCivs_GameData.getFormableCivTag() + ";", false);
                }
            }
        }
        catch (GdxRuntimeException ex) {
            FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
            fileSave.writeString(CFG.formableCivs_GameData.getFormableCivTag() + ";", false);
        }
    }

    private final void loadFlag() {
        block10: {
            this.disposeFlag();
            if (CFG.formableCivs_GameData.getFormableCivTag() == null) {
                this.lFlag = null;
                return;
            }
            try {
                try {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.formableCivs_GameData.getFormableCivTag() + ".png")), Texture.TextureFilter.Nearest);
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag()) + ".png")), Texture.TextureFilter.Nearest);
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.formableCivs_GameData.getFormableCivTag() + "/" + CFG.formableCivs_GameData.getFormableCivTag() + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.formableCivs_GameData.getFormableCivTag() + "/" + CFG.formableCivs_GameData.getFormableCivTag() + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            break block10;
                        }
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.formableCivs_GameData.getFormableCivTag() + "/" + CFG.formableCivs_GameData.getFormableCivTag() + "_FL.png")), Texture.TextureFilter.Nearest);
                    }
                }
            }
            catch (GdxRuntimeException e) {
                this.lFlag = null;
            }
        }
    }

    private final void disposeFlag() {
        if (this.lFlag != null) {
            this.lFlag.getTexture().dispose();
            this.lFlag = null;
        }
    }
}

