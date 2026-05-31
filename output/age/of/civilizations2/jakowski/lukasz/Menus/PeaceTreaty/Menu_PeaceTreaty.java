
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Casualties;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response.Menu_PeaceTreaty_Response;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty
extends Menu {
    public static int WAR_ID = 0;
    private String sScore;
    private int iScoreWidth = 0;

    public Menu_PeaceTreaty() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.peaceTreatyData.drawProvOwners.get((int)i).iProvinceValue);
        }
        menuElements.add(new Button_PeaceTreaty(CFG.lang.get("PeaceNegotiations"), WAR_ID, 0, 0, CFG.GAMEWIDTH, Math.max(Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 2), Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)), true, false){});
        menuElements.add(new Text(null, 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.275f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() * 4 / 5, this.getHeightE() - 2);
                oSB.setColor(Color.WHITE);
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + 1 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }

            @Override
            public int getPosY() {
                return CFG.GAMEHEIGHT - this.getHeightE();
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 4);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Casualties(WAR_ID, 0, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.topBar).getHeight() - CFG.PADD - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        menuElements.add(new Text(null, 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.275f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() * 4 / 5 + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() * 4 / 5, this.getHeightE() - 2, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + 1 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }

            @Override
            public int getPosY() {
                return CFG.GAMEHEIGHT - this.getHeightE();
            }

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH - this.getWidthE();
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 4);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        String tempCityName = "";
        int tempScore = CFG.core.getWar(WAR_ID).getWarScore();
        int tempProvinceID = -1;
        try {
            if (tempScore != 0) {
                if (tempScore < 0) {
                    int iBest = 0;
                    for (int i = 1; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                        if (CFG.core.getWar(WAR_ID).getDefenderID(CFG.core.getWar(WAR_ID).getDefenderID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)iBest).iCivID)).getCasualties() >= CFG.core.getWar(WAR_ID).getDefenderID(CFG.core.getWar(WAR_ID).getDefenderID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID)).getCasualties()) continue;
                        iBest = i;
                    }
                    tempProvinceID = CFG.core.getCiv(CFG.core.getWar(WAR_ID).getDefenderID(CFG.core.getWar(WAR_ID).getDefenderID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)iBest).iCivID)).getCivID()).getCapitalProvID();
                } else {
                    int iBest = 0;
                    for (int i = 1; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
                        if (CFG.core.getWar(WAR_ID).getAggressorID(CFG.core.getWar(WAR_ID).getAggressorID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)iBest).iCivID)).getCasualties() >= CFG.core.getWar(WAR_ID).getAggressorID(CFG.core.getWar(WAR_ID).getAggressorID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID)).getCasualties()) continue;
                        iBest = i;
                    }
                    tempProvinceID = CFG.core.getCiv(CFG.core.getWar(WAR_ID).getAggressorID(CFG.core.getWar(WAR_ID).getAggressorID_ByCivID(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)iBest).iCivID)).getCivID()).getCapitalProvID();
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
        if (tempProvinceID >= 0 && CFG.core.getProv(tempProvinceID).getName().length() > 0) {
            tempCityName = " - " + CFG.core.getProv(tempProvinceID).getName();
        }
        this.sScore = GameCalendar.getCurrDate() + tempCityName;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sScore);
        this.iScoreWidth = (int)CFG.glyphLay.width;
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(3).setTextE(CFG.lang.get("SendDemands"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2, false, true);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, this.getMenuElem(1).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(1).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        if (this.getMenuElem(1).getIsHovered()) {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, this.getMenuElem(1).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(1).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        } else {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, this.getMenuElem(1).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(1).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        }
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD * 3 + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(3).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), false, true);
        if (this.getMenuElem(1).getIsHovered()) {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD * 3 + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(3).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), false, true);
        } else {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD * 3 + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, CFG.PADD * 3 + this.getMenuElem(3).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight(), false, true);
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, this.getMenuElem(0).getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, CFG.GAMEWIDTH / 2 - this.iScoreWidth - CFG.PADD * 2 + iTranslateX, this.getMenuElem(0).getHeightE() + iTranslateY, this.iScoreWidth * 2 + CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
        oSB.setColor(CFG.COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, CFG.GAMEWIDTH / 2 - this.iScoreWidth - CFG.PADD * 2 + iTranslateX, this.getMenuElem(0).getHeightE() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 - 2 + iTranslateY, this.iScoreWidth * 2 + CFG.PADD * 4, 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sScore, CFG.GAMEWIDTH / 2 - this.iScoreWidth / 2 + iTranslateX, CFG.PADD * 2 + this.getMenuElem(0).getHeightE() + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.55f));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES = !Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES;
                Render.updateRenderer();
                if (Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES) {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.peaceTreatyData.drawProvOwners.get((int)i).iProvinceValue);
                    }
                } else {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
                    }
                }
                break;
            }
            case 1: {
                int i;
                boolean someoneMadeDemands = false;
                for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                    if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size() <= 0) continue;
                    someoneMadeDemands = true;
                    i = CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size();
                    break;
                }
                if (!someoneMadeDemands) {
                    for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                        if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size() <= 0) continue;
                        someoneMadeDemands = true;
                        i = CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size();
                        break;
                    }
                }
                if (someoneMadeDemands) {
                    CFG.setDialogType(DialogType.PEACE_TREATY_BACK_ARE_YOU_SURE);
                    break;
                }
                this.onBackPressed();
                break;
            }
            case 3: {
                this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
                CFG.setDialogType(DialogType.SEND_DEMANDS);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_PeaceTreaty.backToInGame();
    }

    public static final void backToInGame() {
        CFG.menus.setMenuID(View.eINGAME);
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
        CFG.core.checkProvinceActionMenu();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
        CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
    }
}

