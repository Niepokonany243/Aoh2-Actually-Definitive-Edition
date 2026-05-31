/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
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
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Menu_CreateCiv
extends Menu {
    private String sName;

    public Menu_CreateCiv() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tempH = 100 + CFG.PADD * 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic("", 0, 154 + CFG.PADD * 4, CFG.PADD * 2, tempW - (154 + CFG.PADD * 4) - CFG.PADD, tempH - CFG.PADD * 4, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_CreateCiv.this.sName + ": " + super.getTextToDrawElem();
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, this.getColorE(isActive));
                } else {
                    CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, this.getColorE(isActive));
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationName") + (this.getTextE().length() > 0 ? ": " : "")));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD * 2, CFG.PADD * 2, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        this.initMenu(null, AoCGame.LEFT, CFG.BUTTON_H / 2, tempW, tempH, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("Name");
        try {
            try {
                FileHandle file = CFG.readLocalFiles() ? Gdx.files.local("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_NM") : FileManager.loadFile("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_NM");
                this.getMenuElem(0).setTextE(file.readString());
            }
            catch (GdxRuntimeException ex) {
                FileHandle file = CFG.readLocalFiles() ? FileManager.loadFile("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_NM") : Gdx.files.local("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_NM");
                this.getMenuElem(0).setTextE(file.readString());
            }
        }
        catch (GdxRuntimeException e) {
            this.getMenuElem(0).setTextE("");
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.dialog_title).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight(), this.getWidthM() + 2, this.getHeightM(), true, false);
        oSB.setColor(new Color((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, 0.165f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), this.getHeightM() - 2, false, true);
        oSB.setColor(new Color((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, 0.375f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - this.getHeightM() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), this.getHeightM() * 2 / 3, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), CFG.PADD, false, true);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 2 + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM() / 2, 1, true, false);
        oSB.setColor(Color.WHITE);
        oSB.setColor(Color.WHITE);
        CFG.flagManager.drawFlag_FlagFrameSize(oSB, this.getPosX() + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.showKeyboard();
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
        }
    }
}

