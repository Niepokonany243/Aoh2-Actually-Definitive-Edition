
package age.of.civilizations2.jakowski.lukasz.Menus.DiplomacyC;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_DiplomacyColors_Create_Colors
extends Menu {
    public Menu_DiplomacyColors_Create_Colors() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempPosY = CFG.PADD;
        menuElements.add(new Button_Game("OWN PROVINCES", -1, CFG.PADD, tempPosY, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("ALLIANCE", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("AT WAR", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("VASSAL", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("PACT", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("PACT MAX", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("INDEPENDENCE", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("MILITARY ACCESS", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game("DEFENSIVE PACT", -1, CFG.PADD, tempPosY += CFG.BUTTON_H + CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.PADD);
                oSB.setColor(Color.WHITE);
            }
        });
        tempPosY += CFG.BUTTON_H + CFG.PADD;
        this.initMenu(null, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4), menuElements);
        this.updateLang();
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorButtons_Top_Edge_R(oSB, iTranslateX, this.getPosY() + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE() + CFG.PADD, this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() + CFG.PADD);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W * 2 + CFG.PADD * 5);
        CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
        switch (iID) {
            case 0: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_OWN_PROVINCES);
                return;
            }
            case 1: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_ALLIANCE);
                return;
            }
            case 2: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_AT_WAR);
                return;
            }
            case 3: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_VASSAL);
                return;
            }
            case 4: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_PACT);
                return;
            }
            case 5: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_PACT_MAX);
                return;
            }
            case 6: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_INDEPENDENCE);
                return;
            }
            case 7: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_MILITARY_ACCESS);
                return;
            }
            case 8: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_DEFENSIVE_PACT);
                return;
            }
        }
    }
}

