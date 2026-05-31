/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateVassal.Info;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_PlayAsVassal;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextCivInfo;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Happiness;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Icon;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Ideology;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CreateAVassal_Info_Stats
extends Menu {
    public Menu_InGame_CreateAVassal_Info_Stats() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextCivInfo(null, CFG.PADD * 3, CFG.PADD * 3){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv_CreateAVassal();
            }
        });
        menuElements.add(new TextLeftSide_Icon("0", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, CFG.PADD * 3, Images.pop){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv_CreateAVassal();
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_POPULATION) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 3, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD)){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_CapitalCity_ByProvinceID(CFG.createVassalData.iCapitalProvinceID);
            }
        });
        menuElements.add(new TextLeftSide("-", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD)){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_CapitalCity_ByProvinceID(CFG.createVassalData.iCapitalProvinceID);
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 3, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LargestCity(Menu_InGame_CreateAVassal_Info_Stats.this.getMenuElem(5).getCurr());
            }
        });
        menuElements.add(new TextLeftSide("-", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){
            int iCurrent;

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LargestCity(this.getCurr());
            }
        });
        ArrayList<Long> lData = new ArrayList<Long>();
        ArrayList<Integer> lCivs = new ArrayList<Integer>();
        lData.add((long)CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        lCivs.add(1);
        menuElements.add(new Graph_Circle(CFG.PADD * 3, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD, lData, lCivs, null){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv_CreateAVassal();
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 3, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3){});
        menuElements.add(new TextLeftSide_Icon("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * GameValues.gvVassal.RELEASE_VASSAL_PERC_OF_TECH_BASE * 100.0f)) / 100.0f, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3, Images.technology){});
        menuElements.add(new TextCivInfo(null, CFG.PADD * 3, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 4 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3));
        menuElements.add(new TextLeftSide_Icon("0", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 4 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3, Images.economy){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_ECONOMY_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_ECONOMY_HOVER : CFG.COLOR_ECONOMY) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextLeftSide_Happiness("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 2 - CFG.PADD){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new TextLeftSide_Ideology("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 3 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology());
        menuElements.add(new Button_PlayAsVassal("", CFG.PADD, CFG.PADD * 2, CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 5 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, true, CFG.createVassalData != null ? CFG.createVassalData.playAsVassal : false));
        menuElements.add(new Button_Transparent(0, 0, CFG.CIV_INFO_MENU_WIDTH, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), true));
        int tempPosY = ButtonFlagBig.getButtonH() + CFG.PADD * 4 + CFG.BUTTON_H + CFG.PADD * 3;
        this.initMenu(null, 0 + AoCGame.LEFT, tempPosY, CFG.CIV_INFO_MENU_WIDTH, Math.min(CFG.GAMEHEIGHT - tempPosY - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H - CFG.PADD, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2), menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Capital"));
        this.getMenuElem(4).setTextE(CFG.lang.get("LargestCity"));
        this.getMenuElem(7).setTextE(CFG.lang.get("TechnologyLevel"));
        this.getMenuElem(9).setTextE(CFG.lang.get("Economy"));
        this.getMenuElem(13).setTextE(CFG.lang.get("PlayAsAReleasedVassal"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        CFG.drawRect_InfoBox_Left(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(1).getPosXE() - this.getMenuElem(0).getPosXE() + this.getMenuElem(1).getWidthE() + CFG.PADD * 2, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2);
        CFG.drawRect_InfoBox_Left(oSB, this.getMenuElem(7).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(7).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(8).getPosXE() - this.getMenuElem(7).getPosXE() + this.getMenuElem(8).getWidthE() + CFG.PADD * 2, this.getMenuElem(9).getPosY() + this.getMenuElem(9).getHeightE() - this.getMenuElem(7).getPosY() + CFG.PADD * 2);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + 1, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + this.getHeightM(), this.getWidthM() - 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + 2 + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + 2, true, true);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CreateAVassal_Info();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 13: {
                try {
                    this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
                    CFG.createVassalData.playAsVassal = this.getMenuElem(iID).getCheckboxSt();
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
                return;
            }
        }
    }
}

