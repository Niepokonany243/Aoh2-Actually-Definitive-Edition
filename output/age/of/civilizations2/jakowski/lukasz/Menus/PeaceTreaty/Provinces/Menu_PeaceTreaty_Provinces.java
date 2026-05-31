
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Provinces;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Government;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Localize;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Province;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_ReleaseVassal;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Religion;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_TakeAll;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_TakeAll_VicPoints;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Vassalize;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_WarReparations;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Date;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty_Provinces
extends Menu {
    public Menu_PeaceTreaty_Provinces() {
        int j;
        int i;
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.2f);
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = 0;
        menuElements.add(new Slider_InGame_Date(CFG.lang.get("Truce"), CFG.PADD, tY, tempW - CFG.PADD * 2, Math.max(CFG.BUTTON_H * 4 / 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4), GameValues.gvPeaceTreaty.PEACE_TREATY_MIN_DURATION, GameValues.gvPeaceTreaty.PEACE_TREATY_MAX_DURATION, CFG.peaceTreatyData.peaceTreatyGD.TRUCE_LENGTH, 0.65f){

            @Override
            public String getDrawText() {
                return CFG.lang.get("TurnsX", this.getCurr());
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public void actionElem(int iID) {
                CFG.peaceTreatyData.peaceTreatyGD.TRUCE_LENGTH = this.getCurr();
            }

            @Override
            public Color getColorLEFT() {
                return new Color(0.06666667f, 0.24705882f, 0.5058824f, 0.75f);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int buttonCivH = Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.flagRect2).getHeight()) + CFG.PADD * 4;
        int buttonDemandH = Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.topGold()).getHeight()) + CFG.PADD * 4;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, 0, tY, tempW - CFG.BUTTON_W, buttonCivH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll_VicPoints(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(i).getVictoryPointsTotal(), tempW - CFG.BUTTON_W, tY, CFG.BUTTON_W, buttonCivH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Vassalize(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_WarReparations(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Government(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Religion(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_ReleaseVassal(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).iReleasesToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get(j).getScoreValue(), 0, tY, tempW, buttonDemandH, true));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (!CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).showProvinces) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_Province(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.get(j), 0, tY, tempW - CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true));
                menuElements.add(new Button_PeaceTreaty_Demands_Localize(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.get(j), tempW - CFG.BUTTON_H, tY, CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, 0, tY, tempW - CFG.BUTTON_W, buttonCivH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll_VicPoints(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(i).getVictoryPointsTotal(), tempW - CFG.BUTTON_W, tY, CFG.BUTTON_W, buttonCivH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Vassalize(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_WarReparations(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Government(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            menuElements.add(new Button_PeaceTreaty_Demands_Religion(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonDemandH, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_ReleaseVassal(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).iReleasesToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get(j).getScoreValue(), 0, tY, tempW, buttonDemandH, true));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (!CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).showProvinces) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_Province(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get(j), 0, tY, tempW - CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true));
                menuElements.add(new Button_PeaceTreaty_Demands_Localize(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get(j), tempW - CFG.BUTTON_H, tY, CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        for (i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setCurr(i % 4 / 2);
        }
        int tempPosY = Math.max(Math.max(Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 2), Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD);
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + 2 + Core.PADDING, this.getHeightT() + Core.PADDING);
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
        }, CFG.GAMEWIDTH - tempW, tempPosY + CFG.BUTTON_H * 3 / 4, tempW, Math.min(menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD : CFG.PADD, CFG.GAMEHEIGHT - (tempPosY + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H), menuElements, true, true);
        this.updateLang();
        this.getMenuElem(0).setCurr(CFG.peaceTreatyData.peaceTreatyGD.TRUCE_LENGTH);
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("MakeDemands"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
            CFG.setRenderO(true);
        }
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
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void actionCloseMenu() {
        this.setVisibleM(false);
        CFG.menus.hidePeaceTreatyProvinces();
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && !this.getVisibleM()) {
            Menu_Civilization_Info.lTime = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }
}

