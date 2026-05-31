/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest.Menu_InGame_TradeRequest_SelectCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_TradeRequest_Side
extends Menu {
    public boolean left = false;
    public int iOnCivID = -1;

    public Menu_InGame_TradeRequest_Side() {
    }

    public Menu_InGame_TradeRequest_Side(int onCivID, final boolean left) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        this.left = left;
        int tempWidth = Math.min(CFG.GAMEWIDTH / 3, Math.max(CFG.CIV_INFO_MENU_WIDTH / 2, CFG.CIV_INFO_MENU_WIDTH * 3 / 4));
        int tY = 0;
        
        // 0: Gold
        menuElements.add(new ButtonStats(CFG.lang.get("Gold"), CFG.PADD * 2, 2, tY, CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.iGold > 0 : CFG.tradeRequest.listRight.iGold > 0; }
            @Override
            public void actionElemPPM() {
                if (left && CFG.tradeRequest.listLEFT.iGold > 0) {
                    CFG.tradeRequest.listLEFT.iGold = GameValues.gvTrade.DECLARE_WAR_MAGIC_NUM_ALWAYS_ACCEPT;
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            }
        });
        if (left) {
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() > 0L);
        }
        if (left ? CFG.tradeRequest.listLEFT.iGold > 0 : CFG.tradeRequest.listRight.iGold > 0) {
            long maxGold = CFG.core.getCiv(left ? CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() : onCivID).getGold();
            menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Gold"), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), 0L, Math.max(100000L, maxGold), left ? (long)CFG.tradeRequest.listLEFT.iGold : (long)CFG.tradeRequest.listRight.iGold){
                @Override
                public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
                @Override
                public void updateSlider(int nPosX) {
                    super.updateSlider(nPosX);
                    if (left) CFG.tradeRequest.listLEFT.iGold = this.getCurrLong();
                    else CFG.tradeRequest.listRight.iGold = this.getCurrLong();
                }
            });
        }
        
        // 1: Provinces
        menuElements.add(new ButtonStats(CFG.lang.get("Provinces"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.lProvinces.size() > 0 : CFG.tradeRequest.listRight.lProvinces.size() > 0; }
        });
        
        // 2: Declare War
        menuElements.add(new ButtonStats(CFG.lang.get("DeclareWar"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.size() > 0 : CFG.tradeRequest.listRight.lDeclareWarOnCivID.size() > 0; }
        });
        
        // 3: Form Coalition
        menuElements.add(new ButtonStats(CFG.lang.get("FormACoalitionAgainst"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.size() > 0 : CFG.tradeRequest.listRight.lFormCoalitionAgainst.size() > 0; }
        });
        
        // 3b: Fight Coalition Against All Neighbors
        menuElements.add(new ButtonStats(CFG.lang.get("FightCoalitionAll"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.fightCoalitionAllNeighbors : CFG.tradeRequest.listRight.fightCoalitionAllNeighbors; }
        });
        
        // 4: Defensive Pact
        menuElements.add(new ButtonStats(CFG.lang.get("DefensivePact"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.defensivePact : CFG.tradeRequest.listRight.defensivePact; }
        });
        
        // 5: NonAggression Pact
        menuElements.add(new ButtonStats(CFG.lang.get("NonAggressionPact"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.nonAggressionPact : CFG.tradeRequest.listRight.nonAggressionPact; }
        });
        
        // 6: Proclaim Independence
        menuElements.add(new ButtonStats(CFG.lang.get("ProclaimIndependence"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.proclaimIndependence : CFG.tradeRequest.listRight.proclaimIndependence; }
        });
        
        // 7: Military Access
        menuElements.add(new ButtonStats(CFG.lang.get("MilitaryAccess"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.militaryAccess : CFG.tradeRequest.listRight.militaryAccess; }
        });
        
        // 8: Prepare For War
        java.util.List<Integer> prepList = left ? CFG.tradeRequest.listLEFT.lPrepareForWarCivID : CFG.tradeRequest.listRight.lPrepareForWarCivID;
        menuElements.add(new ButtonStats(CFG.lang.get("PrepareForWar"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.lPrepareForWarCivID.size() > 0 : CFG.tradeRequest.listRight.lPrepareForWarCivID.size() > 0; }
        });
        if (prepList.size() > 0) {
            StringBuilder prepNames = new StringBuilder();
            for (int i = 0; i < prepList.size() && i < 3; i++) {
                if (i > 0) prepNames.append(", ");
                prepNames.append(CFG.core.getCiv(prepList.get(i)).getCivName());
            }
            if (prepList.size() > 3) prepNames.append("...");
            menuElements.add(new ButtonStats(prepNames.toString(), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), true){
                @Override
                public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            });
            menuElements.add(new Slider_InGame_Clear(CFG.lang.get("Turns"), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, CFG.BUTTON_H, 1, 250, left ? CFG.tradeRequest.listLEFT.iPrepareForWarTurns : CFG.tradeRequest.listRight.iPrepareForWarTurns){
                @Override
                public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
                @Override
                public String getDrawText() { return CFG.lang.get("Turns") + ": " + this.getCurr(); }
                @Override
                public void updateSlider(int nPosX) {
                    super.updateSlider(nPosX);
                    if (left) CFG.tradeRequest.listLEFT.iPrepareForWarTurns = this.getCurr();
                    else CFG.tradeRequest.listRight.iPrepareForWarTurns = this.getCurr();
                }
            });
        }
        
        // 9: Sanctions
        java.util.List<Integer> sanList = left ? CFG.tradeRequest.listLEFT.lSanctionCivID : CFG.tradeRequest.listRight.lSanctionCivID;
        menuElements.add(new ButtonStats(CFG.lang.get("Sanctions"), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), false){
            @Override
            public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            @Override
            public boolean getCheckboxSt() { return left ? CFG.tradeRequest.listLEFT.lSanctionCivID.size() > 0 : CFG.tradeRequest.listRight.lSanctionCivID.size() > 0; }
        });
        if (sanList.size() > 0) {
            StringBuilder sanNames = new StringBuilder();
            for (int i = 0; i < sanList.size() && i < 3; i++) {
                if (i > 0) sanNames.append(", ");
                sanNames.append(CFG.core.getCiv(sanList.get(i)).getCivName());
            }
            if (sanList.size() > 3) sanNames.append("...");
            menuElements.add(new ButtonStats(sanNames.toString(), CFG.PADD * 2, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, (int)((float)CFG.BUTTON_H * 0.75f), true){
                @Override
                public int getWidthE() { return Menu_InGame_TradeRequest_Side.this.getElementW(); }
            });
        }
        
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.core.getCiv(onCivID).getCivName(), CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight(), nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_TradeRequest_Side.this.iOnCivID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + (nWidth - 2) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, false);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuBorder(oSB);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_TradeRequest();
    }

    @Override
    public final void actionEL(int iID) {
        int tempPosY = this.getMenuPosY();
        MenuElemUI clickedElem = this.getMenuElem(iID);
        if (clickedElem instanceof Slider) {
            return;
        }
        
        String text = clickedElem.getTextE();
        
        if (text.equals(CFG.lang.get("Gold"))) {
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.iGold > 0) {
                    CFG.tradeRequest.listLEFT.iGold = 0;
                } else {
                    CFG.tradeRequest.listLEFT.iGold = 100;
                    if ((long)CFG.tradeRequest.listLEFT.iGold > CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold()) {
                        CFG.tradeRequest.listLEFT.iGold = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold();
                    }
                }
            } else {
                if (CFG.tradeRequest.listRight.iGold > 0) {
                    CFG.tradeRequest.listRight.iGold = 0;
                } else {
                    CFG.tradeRequest.listRight.iGold = 100;
                    if ((long)CFG.tradeRequest.listRight.iGold > CFG.core.getCiv(CFG.tradeRequest.iCivRIGHT).getGold()) {
                        CFG.tradeRequest.listRight.iGold = CFG.core.getCiv(CFG.tradeRequest.iCivRIGHT).getGold();
                    }
                }
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("Provinces"))) {
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.lProvinces.size() == 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.tradeRequest.iCivLEFT;
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT;
                    CFG.VIEW_SHOW_VALUES = false;
                    CFG.selectMode = true;
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    CFG.menus.setMenuID(View.eINGAME_SELECT_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.tradeRequest.listLEFT.lProvinces.clear();
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            } else if (CFG.tradeRequest.listRight.lProvinces.size() == 0) {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.tradeRequest.iCivRIGHT;
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.core.setActiveProvID(-1);
                Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT;
                CFG.VIEW_SHOW_VALUES = false;
                CFG.selectMode = true;
                CFG.core.getProvSelected().clearSelectedProvinces();
                CFG.menus.setMenuID(View.eINGAME_SELECT_PROVINCES);
                RenderProvince.updateDrawProvinces();
            } else {
                CFG.tradeRequest.listRight.lProvinces.clear();
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("DeclareWar"))) {
            System.out.println("TRADE_DEBUG: SidePanel clicked DeclareWar, left=" + this.left);
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.size() == 0) {
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_DECLAREWAR;
                    System.out.println("TRADE_DEBUG: typeOfAction set to TRADE_LEFT_DECLAREWAR");
                    CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                    CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.clear();
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            } else if (CFG.tradeRequest.listRight.lDeclareWarOnCivID.size() == 0) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.core.setActiveProvID(-1);
                Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_DECLAREWAR;
                CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                RenderProvince.updateDrawProvinces();
            } else {
                CFG.tradeRequest.listRight.lDeclareWarOnCivID.clear();
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("FormACoalitionAgainst"))) {
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.size() == 0) {
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_COALITION;
                    CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                    CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.clear();
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            } else if (CFG.tradeRequest.listRight.lFormCoalitionAgainst.size() == 0) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.core.setActiveProvID(-1);
                Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_COALITION;
                CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                RenderProvince.updateDrawProvinces();
            } else {
                CFG.tradeRequest.listRight.lFormCoalitionAgainst.clear();
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("FightCoalitionAll"))) {
            if (this.left) {
                CFG.tradeRequest.listLEFT.fightCoalitionAllNeighbors = !CFG.tradeRequest.listLEFT.fightCoalitionAllNeighbors;
            } else {
                CFG.tradeRequest.listRight.fightCoalitionAllNeighbors = !CFG.tradeRequest.listRight.fightCoalitionAllNeighbors;
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("DefensivePact"))) {
            if (this.left) {
                CFG.tradeRequest.listLEFT.defensivePact = !CFG.tradeRequest.listLEFT.defensivePact;
            } else {
                CFG.tradeRequest.listRight.defensivePact = !CFG.tradeRequest.listRight.defensivePact;
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("NonAggressionPact"))) {
            if (this.left) {
                CFG.tradeRequest.listLEFT.nonAggressionPact = !CFG.tradeRequest.listLEFT.nonAggressionPact;
            } else {
                CFG.tradeRequest.listRight.nonAggressionPact = !CFG.tradeRequest.listRight.nonAggressionPact;
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("ProclaimIndependence"))) {
            if (this.left) {
                CFG.tradeRequest.listLEFT.proclaimIndependence = !CFG.tradeRequest.listLEFT.proclaimIndependence;
            } else {
                CFG.tradeRequest.listRight.proclaimIndependence = !CFG.tradeRequest.listRight.proclaimIndependence;
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("MilitaryAccess"))) {
            if (this.left) {
                CFG.tradeRequest.listLEFT.militaryAccess = !CFG.tradeRequest.listLEFT.militaryAccess;
            } else {
                CFG.tradeRequest.listRight.militaryAccess = !CFG.tradeRequest.listRight.militaryAccess;
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("PrepareForWar"))) {
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.lPrepareForWarCivID.size() == 0) {
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_PREPAREFORWAR;
                    CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                    CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.tradeRequest.listLEFT.lPrepareForWarCivID.clear();
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            } else if (CFG.tradeRequest.listRight.lPrepareForWarCivID.size() == 0) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.core.setActiveProvID(-1);
                Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_PREPAREFORWAR;
                CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                RenderProvince.updateDrawProvinces();
            } else {
                CFG.tradeRequest.listRight.lPrepareForWarCivID.clear();
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
            this.setMenuPosY(tempPosY);
        } else if (text.equals(CFG.lang.get("Sanctions"))) {
            if (this.left) {
                if (CFG.tradeRequest.listLEFT.lSanctionCivID.size() == 0) {
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_SANCTION;
                    CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                    CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.tradeRequest.listLEFT.lSanctionCivID.clear();
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                }
            } else if (CFG.tradeRequest.listRight.lSanctionCivID.size() == 0) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.core.setActiveProvID(-1);
                Menu_InGame_TradeRequest_SelectCiv.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_SANCTION;
                CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
                CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                RenderProvince.updateDrawProvinces();
            } else {
                CFG.tradeRequest.listRight.lSanctionCivID.clear();
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
            this.setMenuPosY(tempPosY);
        }
    }

    public final int getW() {
        return this.getWidthM();
    }
    public final int getElementW() {
        return Math.max(this.getW() - CFG.PADD * 2, CFG.BUTTON_W);
    }
}
