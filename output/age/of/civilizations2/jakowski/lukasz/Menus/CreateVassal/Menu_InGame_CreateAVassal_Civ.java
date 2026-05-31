/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateVassal;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_CreateAVassal_Civ
extends Menu {
    private List<Integer> lCivs = new ArrayList<Integer>();

    public Menu_InGame_CreateAVassal_Civ() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_InGameBox(CFG.lang.get("CreateaCivilization"), -1, CFG.PADD, CFG.PADD, tempW - CFG.PADD * 2, true));
        int tY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_InGameBox(CFG.lang.get("SelectCivilization"), -1, CFG.PADD, tY, tempW - CFG.PADD * 2, true){

            @Override
            public boolean getIsClickable() {
                return true;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        ArrayList<Integer> lForeignCores = new ArrayList<Integer>();
        for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i) {
            if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).isOccupied()) continue;
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivsSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivID(j) == CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivID(j)).getNumOfProvs() != 0) continue;
                boolean tAdd = true;
                for (int k = 0; k < lForeignCores.size(); ++k) {
                    if (((Integer)lForeignCores.get(k)).intValue() != CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivID(j)) continue;
                    tAdd = false;
                    break;
                }
                if (!tAdd) continue;
                lForeignCores.add(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivID(j));
            }
        }
        for (i = 0; i < lForeignCores.size(); ++i) {
            menuElements.add(new Button_In_Game_Box_CivID((Integer)lForeignCores.get(i), CFG.core.getCiv((Integer)lForeignCores.get(i)).getCivName(), -1, CFG.PADD, tY, tempW - CFG.PADD * 2, !CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (Integer)lForeignCores.get(i))));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() + Core.PADDING, nWidth + 2 + Core.PADDING, this.getHeightT());
                oSB.setColor(new Color(0.23529412f, 0.3137255f, 0.4117647f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.23529412f, 0.3137255f, 0.4117647f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD : CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H / 2) - CFG.BUTTON_H - CFG.PADD * 2), menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("SelectVassal") + " AoH2:DE");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 4 + Core.PADDING, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM() + 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        if (iID == 0) {
            CFG.brushMode = false;
            CFG.menus.getColorPicker().setPosX(CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4 + CFG.PADD * 4);
            CFG.flagManager.loadData();
            CFG.flagManager.initFlagEdit();
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
            CFG.editorCivilization_GameData = new Civilization_GameData3();
            CFG.backToMenu = View.eINGAME_CREATE_VASSAL;
            CFG.menus.setMenuID(View.eCREATE_CIVILIZATION);
            RenderProvince.updateDrawProvinces();
            CFG.map.getMpB().updateWorldMap_Shaders();
        } else if (iID == 1) {
            CFG.menus.setMenuID(View.eINGAME_CREATE_VASSAL_SELECT_CIV);
            CFG.map.getMpB().updateWorldMap_Shaders();
        } else {
            int i;
            CFG.core.getProvSelected().clearSelectedProvinces();
            CFG.createVassalData.setCivTag(CFG.core.getCiv(this.getMenuElem(iID).getCurr()).getCivTag());
            CFG.createVassalData.iCapitalProvinceID = -1;
            block0: for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivsSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCores().getCivID(j) != this.getMenuElem(iID).getCurr() || CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getTrueOwnerOfProv() != CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getCivId()) continue;
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).isCapital()) continue block0;
                    CFG.core.getProvSelected().addProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i));
                    continue block0;
                }
            }
            if (!CFG.createVassalData.sCivTag.equals(CFG.ideologiesMgr.getRealTag(CFG.createVassalData.sCivTag) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getExtraTag()) && CFG.core.isCivTagAvailable(CFG.ideologiesMgr.getRealTag(CFG.createVassalData.sCivTag) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getExtraTag())) {
                CFG.createVassalData.setCivTag(CFG.ideologiesMgr.getRealTag(CFG.createVassalData.sCivTag) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getExtraTag());
            }
            if (CFG.core.getProvSelected().getProvSize() > 0) {
                CFG.createVassalData.iCapitalProvinceID = CFG.core.getProvSelected().getProv(0);
                for (i = 1; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                    if (CFG.core.getProv(CFG.createVassalData.iCapitalProvinceID).getPop().getPops() >= CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getPop().getPops()) continue;
                    CFG.createVassalData.iCapitalProvinceID = CFG.core.getProvSelected().getProv(i);
                }
            }
            CFG.menus.setMenuID(View.eINGAME_CREATE_VASSAL);
        }
    }
}

