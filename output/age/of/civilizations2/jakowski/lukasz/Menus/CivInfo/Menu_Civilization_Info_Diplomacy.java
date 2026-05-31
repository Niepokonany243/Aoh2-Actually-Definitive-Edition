/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy_InGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Wiki_Civ;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Diplomacy;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_DiplomacyORActions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilization_Info_Diplomacy
extends Menu {
    public Menu_Civilization_Info_Diplomacy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosY = 0;
        ArrayList<Integer> tData = new ArrayList<Integer>();
        int buttonH = Menu_InGame_Civ_Diplomacy.getButtonHeight();
        if (CFG.getActiveCivInfoId() > 0) {
            int i;
            int i2;
            if (CFG.getIsDesktop() && !Menu_Civilization_Info.getUseMenu_UI2()) {
                menuElements.add(new Button_Diplomacy_Wiki_Civ(CFG.getActiveCivInfoId(), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2, buttonH, true){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || (int)CFG.core.getCivRelationOfCivB(i2, CFG.getActiveCivInfoId()) != GameValues.gvDiplomacy.RELATION_AT_WAR || CFG.core.getCiv(i2).getNumOfProvs() <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploWar, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance() > 0) {
                tData.clear();
                for (i2 = 0; i2 < CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilizationsSize(); ++i2) {
                    if (CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilization(i2) == CFG.getActiveCivInfoId()) continue;
                    tData.add(CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilization(i2));
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy(Images.diploAlliance, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getCiv(i2).getPuppetOfCiv() != CFG.getActiveCivInfoId()) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploVassal, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getCivTruce(i2, CFG.getActiveCivInfoId()) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploTruce, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (int a = 0; a < CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civsSize; ++a) {
                tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civs.get((int)a).civID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.frontline, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getDefensivePact(i2, CFG.getActiveCivInfoId()) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploDefensivePact, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getCivNonAggressionPact(i2, CFG.getActiveCivInfoId()) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploNonAggression, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getGuarantee(i2, CFG.getActiveCivInfoId()) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploGuaranteeHas, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getGuarantee(CFG.getActiveCivInfoId(), i2) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploGuaranteeGives, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getMilitaryAccess(i2, CFG.getActiveCivInfoId()) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploAccessHas, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (i2 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i2).getNumOfProvs() <= 0 || CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), i2) <= 0) continue;
                tData.add(i2);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploGuaranteeGives, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            ArrayList<Integer> tempOpinions = new ArrayList<Integer>();
            ArrayList<Integer> tempSortedIDs = new ArrayList<Integer>();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == i) continue;
                tempOpinions.add(i);
            }
            while (!tempOpinions.isEmpty()) {
                int highestID = 0;
                for (int i3 = 1; i3 < tempOpinions.size(); ++i3) {
                    if (!(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempOpinions.get(highestID)) > CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempOpinions.get(i3)))) continue;
                    highestID = i3;
                }
                tempSortedIDs.add((Integer)tempOpinions.get(highestID));
                tempOpinions.remove(highestID);
            }
            tData.clear();
            i = tempSortedIDs.size() - 1;
            for (int j = 0; i >= 0 && j < 4 && !(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempSortedIDs.get(i)) < 25.0f); --i, ++j) {
                tData.add((Integer)tempSortedIDs.get(i));
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy(Images.diploHeart, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 0; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getHatedCivsSize(); ++i) {
                tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getHatedCiv((int)i).iCivID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploRivals, tData, 2, tPosY, CFG.CIV_INFO_MENU_WIDTH - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        this.initMenu(new TitleM_TextSmall(null, Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, Menu_Civilization_Info_Diplomacy.this.getPosX() - Core.PADDING + iTranslateX, Menu_Civilization_Info_Diplomacy.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getHeightT(), Menu_Civilization_Info_Diplomacy.this.getWidthM() + Core.PADDING, this.getHeightT());
                CFG.drawRect_InfoBox_Right_Title(oSB, Menu_Civilization_Info_Diplomacy.this.getPosX() + 2 + iTranslateX, Menu_Civilization_Info_Diplomacy.this.getPosY() - this.getHeightT(), Menu_Civilization_Info_Diplomacy.this.getWidthM(), this.getHeightT());
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        }, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, CFG.CIV_INFO_MENU_WIDTH, (int)((float)buttonH * (CFG.getIsDesktop() && !Menu_Civilization_Info.getUseMenu_UI2() ? GameValues.gvInGame.NEW_GAME_CIV_VIEW_DIPLOMACY_BUTTONS_LIMIT : GameValues.gvInGame.NEW_GAME_CIV_VIEW_DIPLOMACY_BUTTONS_LIMIT_MOBILE)), menuElements, false, false);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setMax(i % 2);
        }
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Diplomacy"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_CreateNewGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.getMenuElem(iID).actionElem(iID);
            }
        }
    }
}

