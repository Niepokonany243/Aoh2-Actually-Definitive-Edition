package age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_LikelihoodOfSuccess;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest.Menu_InGame_TradeRequest_SelectCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_List;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_TradeRequest extends Menu {
    public static int iOnCivID = -1;
    private static int selectedLeftOffer = -1;
    private static int selectedRightOffer = -1;
    private static final int OFFER_GOLD = 0;
    private static final int OFFER_PROVINCES = 1;
    private static final int OFFER_DECLAREWAR = 2;
    private static final int OFFER_COALITION = 3;
    private static final int OFFER_DEFENSIVEPACT = 4;
    private static final int OFFER_NONAGGRESSION = 5;
    private static final int OFFER_INDEPENDENCE = 6;
    private static final int OFFER_MILITARYACCESS = 7;
    private static final int OFFER_PREPAREFORWAR = 8;
    private static final int OFFER_SANCTIONS = 9;
    private static final int OFFER_FIGHT_COALITION_ALL_NEIGHBORS = 10;

    public Menu_InGame_TradeRequest() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
        this.updateLang();
    }

    public Menu_InGame_TradeRequest(int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (iOnCivID != onCivID) {
            selectedLeftOffer = -1;
            selectedRightOffer = -1;
        }
        iOnCivID = onCivID;
        final int tempX = Math.max(Core.PADDING + 2, CFG.PADD * 2 + Core.PADDING);
        final int tempWidth = Math.min(Math.max(1, CFG.GAMEWIDTH - tempX * 2), 800);
        final int colGap = Math.max(1, CFG.PADD);
        final int colW = Math.max(1, (tempWidth - colGap * 4) / 3);
        int tY = 0;

        
        menuElements.add(new Button_Diplomacy_LikelihoodOfSuccess(
            CFG.lang.get("LikelihoodOfSuccess") + ": ",
            GameManager.getTradeRequest_LikelihoodOfSuccess_Text(),
            "" + (float)GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS / 10.0f,
            2, tY, CFG.BUTTON_W * 2) {
            @Override
            public int getWidthE() { return tempWidth - 4; }
        });
        tY += menuElements.get(menuElements.size() - 1).getHeightE();

        
        int leftX = CFG.PADD;
        int centerX = leftX + colW + colGap;
        int rightX = centerX + colW + colGap;
        int colY = tY;

        addOfferToggle(menuElements, CFG.lang.get("Gold"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.iGold > 0, OFFER_GOLD, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("Provinces"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.lProvinces.size() > 0, OFFER_PROVINCES, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("DeclareWar"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.size() > 0, OFFER_DECLAREWAR, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("FormACoalitionAgainst"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.size() > 0, OFFER_COALITION, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("FightCoalitionAll"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.fightCoalitionAllNeighbors, OFFER_FIGHT_COALITION_ALL_NEIGHBORS, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("DefensivePact"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.defensivePact, OFFER_DEFENSIVEPACT, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("NonAggressionPact"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.nonAggressionPact, OFFER_NONAGGRESSION, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("ProclaimIndependence"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.proclaimIndependence, OFFER_INDEPENDENCE, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("MilitaryAccess"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.militaryAccess, OFFER_MILITARYACCESS, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("PrepareForWar"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.lPrepareForWarCivID.size() > 0, OFFER_PREPAREFORWAR, true);
        colY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("Sanctions"), leftX, colY, colW,
            CFG.tradeRequest.listLEFT.lSanctionCivID.size() > 0, OFFER_SANCTIONS, true);

        
        int centerDetailY = tY;
        boolean showDetail = selectedLeftOffer >= 0 || selectedRightOffer >= 0;
        if (showDetail) {
            boolean isLeft = selectedLeftOffer >= 0;
            int selectedOffer = isLeft ? selectedLeftOffer : selectedRightOffer;
            String offerName = getOfferName(selectedOffer);

            centerDetailY += CFG.PADD;

            menuElements.add(new ButtonStats(offerName, CFG.PADD * 2, 2, centerDetailY, colW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) {
                @Override
                public int getPosXE() { return centerX; }
                @Override
                public int getWidthE() { return colW; }
                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_HOVER_TITLE);
                }
            });
            centerDetailY += CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;

            switch (selectedOffer) {
                case OFFER_GOLD: {
                    long maxGold = CFG.core.getCiv(isLeft ? CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() : iOnCivID).getGold();
                    long currGold = isLeft ? (long)CFG.tradeRequest.listLEFT.iGold : (long)CFG.tradeRequest.listRight.iGold;
                    menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Gold"), 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, 0L, Math.max(100000L, maxGold), currGold) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void updateSlider(int nPosX) {
                            super.updateSlider(nPosX);
                            if (isLeft) CFG.tradeRequest.listLEFT.iGold = (int)this.getCurrLong();
                            else CFG.tradeRequest.listRight.iGold = (int)this.getCurrLong();
                            try { Menu_InGame_TradeRequest.this.getMenuElem(0).setText2(GameManager.getTradeRequest_LikelihoodOfSuccess_Text()); }
                            catch (Exception ex) { CFG.exceptionStack(ex); }
                        }
                    });
                    break;
                }
                case OFFER_PREPAREFORWAR: {
                    java.util.List<Integer> prepList = isLeft ? CFG.tradeRequest.listLEFT.lPrepareForWarCivID : CFG.tradeRequest.listRight.lPrepareForWarCivID;
                    int turns = isLeft ? CFG.tradeRequest.listLEFT.iPrepareForWarTurns : CFG.tradeRequest.listRight.iPrepareForWarTurns;
                    String targetText = prepList.size() > 0 ? prepList.size() + " " + CFG.lang.get("Civilizations") : CFG.lang.get("ClickToSelect");
                    menuElements.add(new ButtonStats(CFG.lang.get("Target") + ": " + targetText, CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void actionElem(int iID) {
                            openCivSelection(selectedOffer, isLeft);
                        }
                    });
                    centerDetailY += CFG.BUTTON_H * 3 / 4 + CFG.PADD;
                    menuElements.add(new Slider_InGame_Clear(CFG.lang.get("Turns"), 2, centerDetailY, colW, CFG.BUTTON_H, 1, 250, turns) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public String getDrawText() { return CFG.lang.get("Turns") + ": " + this.getCurr(); }
                        @Override
                        public void updateSlider(int nPosX) {
                            super.updateSlider(nPosX);
                            if (isLeft) CFG.tradeRequest.listLEFT.iPrepareForWarTurns = this.getCurr();
                            else CFG.tradeRequest.listRight.iPrepareForWarTurns = this.getCurr();
                        }
                    });
                    break;
                }
                case OFFER_SANCTIONS: {
                    java.util.List<Integer> sanList = isLeft ? CFG.tradeRequest.listLEFT.lSanctionCivID : CFG.tradeRequest.listRight.lSanctionCivID;
                    String targetText = sanList.size() > 0 ? sanList.size() + " " + CFG.lang.get("Civilizations") : CFG.lang.get("ClickToSelect");
                    menuElements.add(new ButtonStats(CFG.lang.get("Target") + ": " + targetText, CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void actionElem(int iID) {
                            openCivSelection(selectedOffer, isLeft);
                        }
                    });
                    break;
                }
                case OFFER_DECLAREWAR: {
                    java.util.List<Integer> warList = isLeft ? CFG.tradeRequest.listLEFT.lDeclareWarOnCivID : CFG.tradeRequest.listRight.lDeclareWarOnCivID;
                    String targetText = warList.size() > 0 ? warList.size() + " " + CFG.lang.get("Civilizations") : CFG.lang.get("ClickToSelect");
                    menuElements.add(new ButtonStats(CFG.lang.get("Target") + ": " + targetText, CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void actionElem(int iID) {
                            openCivSelection(selectedOffer, isLeft);
                        }
                    });
                    break;
                }
                case OFFER_COALITION: {
                    java.util.List<Integer> coalList = isLeft ? CFG.tradeRequest.listLEFT.lFormCoalitionAgainst : CFG.tradeRequest.listRight.lFormCoalitionAgainst;
                    String targetText = coalList.size() > 0 ? coalList.size() + " " + CFG.lang.get("Civilizations") : CFG.lang.get("ClickToSelect");
                    menuElements.add(new ButtonStats(CFG.lang.get("Target") + ": " + targetText, CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void actionElem(int iID) {
                            openCivSelection(selectedOffer, isLeft);
                        }
                    });
                    break;
                }
                case OFFER_PROVINCES: {
                    int numProvinces = (isLeft ? CFG.tradeRequest.listLEFT.lProvinces : CFG.tradeRequest.listRight.lProvinces).size();
                    String provText = numProvinces > 0 ? CFG.lang.get("Provinces") + ": " + numProvinces : CFG.lang.get("ClickToSelect");
                    menuElements.add(new ButtonStats(provText, CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                        @Override
                        public void actionElem(int iID) {
                            openProvinceSelection(isLeft);
                        }
                    });
                    break;
                }
                case OFFER_DEFENSIVEPACT:
                case OFFER_NONAGGRESSION:
                case OFFER_INDEPENDENCE:
                case OFFER_MILITARYACCESS: {
                    menuElements.add(new ButtonStats(CFG.lang.get("ToggleOnOff"), CFG.PADD * 2, 2, centerDetailY, colW, CFG.BUTTON_H * 3 / 4, true) {
                        @Override
                        public int getPosXE() { return centerX; }
                        @Override
                        public int getWidthE() { return colW; }
                    });
                    break;
                }
            }
            centerDetailY = menuElements.get(menuElements.size() - 1).getPosY() + menuElements.get(menuElements.size() - 1).getHeightE();
        }

        
        int rightColY = tY;
        addOfferToggle(menuElements, CFG.lang.get("Gold"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.iGold > 0, OFFER_GOLD, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("Provinces"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.lProvinces.size() > 0, OFFER_PROVINCES, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("DeclareWar"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.lDeclareWarOnCivID.size() > 0, OFFER_DECLAREWAR, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("FormACoalitionAgainst"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.lFormCoalitionAgainst.size() > 0, OFFER_COALITION, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("FightCoalitionAll"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.fightCoalitionAllNeighbors, OFFER_FIGHT_COALITION_ALL_NEIGHBORS, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("DefensivePact"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.defensivePact, OFFER_DEFENSIVEPACT, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("NonAggressionPact"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.nonAggressionPact, OFFER_NONAGGRESSION, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("ProclaimIndependence"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.proclaimIndependence, OFFER_INDEPENDENCE, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("MilitaryAccess"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.militaryAccess, OFFER_MILITARYACCESS, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("PrepareForWar"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.lPrepareForWarCivID.size() > 0, OFFER_PREPAREFORWAR, false);
        rightColY += CFG.BUTTON_H * 3 / 4 + CFG.PADD / 2;

        addOfferToggle(menuElements, CFG.lang.get("Sanctions"), rightX, rightColY, colW,
            CFG.tradeRequest.listRight.lSanctionCivID.size() > 0, OFFER_SANCTIONS, false);

        
        tY = Math.max(colY + CFG.BUTTON_H * 3 / 4, rightColY + CFG.BUTTON_H * 3 / 4);
        if (showDetail) tY = Math.max(tY, centerDetailY);
        tY += CFG.PADD;

        
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, CFG.PADD, tY, CFG.BUTTON_W, true) {
            @Override
            public int getWidthE() { return tempWidth / 2 - CFG.PADD - CFG.PADD / 2; }
            @Override
            public int getPosY() {
                return Menu_InGame_TradeRequest.this.getH() - this.getHeightE() - CFG.PADD > super.getPosY()
                    ? Menu_InGame_TradeRequest.this.getH() - this.getHeightE() - CFG.PADD
                    : super.getPosY();
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("SendProposal"), -1, 0, tY, CFG.BUTTON_W, true) {
            @Override
            public int getPosXE() { return tempWidth / 2 + CFG.PADD / 2; }
            @Override
            public int getWidthE() { return tempWidth / 2 - CFG.PADD - CFG.PADD / 2; }
            @Override
            public int getPosY() {
                return Menu_InGame_TradeRequest.this.getH() - this.getHeightE() - CFG.PADD > super.getPosY()
                    ? Menu_InGame_TradeRequest.this.getH() - this.getHeightE() - CFG.PADD
                    : super.getPosY();
            }
            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendProposal") + ":", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(iOnCivID, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(iOnCivID).getCivName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploTrade).drawO(oSB,
                    this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploTrade).getWidth() + CFG.PADD) / 2 + iTranslateX,
                    this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploTrade).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(),
                    this.getPosXE() + (this.getTextPosElem() < 0
                        ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploTrade).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploTrade).getWidth() + CFG.PADD
                        : this.getTextPosElem()) + iTranslateX,
                    this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY,
                    this.getColorE(isActive));
            }
            @Override
            public boolean getIsClickable() {
                return (CFG.SANDBOX_MODE || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS)
                    && CFG.tradeRequest.canBeSend();
            }
            @Override
            public int getSFXElem() { return SFXManager.getSend(); }
        });

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        int menuH = menuElements.get(menuElements.size() - 1).getPosY() + menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;
        if (tempMenuPosY + menuH > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2) {
            menuH = Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6);
        }
        int centeredX = (CFG.GAMEWIDTH - tempWidth) / 2;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("TradeRequest"), CFG.BUTTON_H * 3 / 4, true, true) {
            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX,
                    nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight(),
                    nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX,
                    nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight(),
                    IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.28235295f, 0.4627451f, 1.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - this.getHeightT() - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.28235295f, 0.4627451f, 1.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX,
                    nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + (nWidth - 2) - (nWidth - 4) / 2 + iTranslateX,
                    nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                try {
                    CFG.core.getCiv(CFG.tradeRequest.iCivLEFT).getFlagC().drawO(oSB,
                        Menu_InGame_TradeRequest.this.getPosX() + CFG.PADD * 2 + iTranslateX,
                        Menu_InGame_TradeRequest.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - CFG.core.getCiv(CFG.tradeRequest.iCivLEFT).getFlagC().getHeight(),
                        IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB,
                        Menu_InGame_TradeRequest.this.getPosX() + CFG.PADD * 2 + iTranslateX,
                        Menu_InGame_TradeRequest.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight(),
                        IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
                    CFG.core.getCiv(CFG.tradeRequest.iCivRIGHT).getFlagC().drawO(oSB,
                        Menu_InGame_TradeRequest.this.getPosX() + Menu_InGame_TradeRequest.this.getWidthM() - IMGManager.getIMG(Images.flagRectSmall).getWidth() - CFG.PADD * 2 + iTranslateX,
                        Menu_InGame_TradeRequest.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - CFG.core.getCiv(CFG.tradeRequest.iCivRIGHT).getFlagC().getHeight(),
                        IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB,
                        Menu_InGame_TradeRequest.this.getPosX() + Menu_InGame_TradeRequest.this.getWidthM() - IMGManager.getIMG(Images.flagRectSmall).getWidth() - CFG.PADD * 2 + iTranslateX,
                        Menu_InGame_TradeRequest.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight(),
                        IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
                } catch (IndexOutOfBoundsException ex) {
                    Menu_InGame_TradeRequest.this.setVisibleM(false);
                }
                IMGManager.getIMG(Images.diploTrade).drawO(oSB,
                    nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.diploTrade).getWidth() + iTranslateX,
                    2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.diploTrade).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(),
                    nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX,
                    2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, centeredX, tempMenuPosY, tempWidth, menuH, menuElements, true, false);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    private void addOfferToggle(ArrayList<MenuElemUI> elements, String label, int x, int y, int w, boolean active, int offerType, boolean isLeft) {
        elements.add(new ButtonStats(label, CFG.PADD * 2, 2, y, w, CFG.BUTTON_H * 3 / 4, false) {
            @Override
            public int getPosXE() { return x; }
            @Override
            public int getWidthE() { return w; }
            @Override
            public boolean getCheckboxSt() { return active; }
            @Override
            public void actionElem(int iID) {
                boolean wasSelected = isLeft ? selectedLeftOffer == offerType : selectedRightOffer == offerType;
                if (isLeft) {
                    selectedLeftOffer = wasSelected ? -1 : offerType;
                    selectedRightOffer = -1;
                } else {
                    selectedRightOffer = wasSelected ? -1 : offerType;
                    selectedLeftOffer = -1;
                }
                if (isInstantToggleOffer(offerType)) {
                    toggleOffer(offerType, isLeft);
                } else if (wasSelected && isOfferActive(offerType, isLeft)) {
                    clearOffer(offerType, isLeft);
                }
                CFG.menus.rebuildInGame_TradeRequest_Just();
            }
        });
    }

    private boolean isInstantToggleOffer(int offerType) {
        return offerType == OFFER_DEFENSIVEPACT || offerType == OFFER_NONAGGRESSION || offerType == OFFER_INDEPENDENCE || offerType == OFFER_MILITARYACCESS || offerType == OFFER_FIGHT_COALITION_ALL_NEIGHBORS;
    }

    private boolean isOfferActive(int offerType, boolean isLeft) {
        TradeRequest_List list = isLeft ? CFG.tradeRequest.listLEFT : CFG.tradeRequest.listRight;
        switch (offerType) {
            case OFFER_GOLD: return list.iGold > 0;
            case OFFER_PROVINCES: return list.lProvinces.size() > 0;
            case OFFER_DECLAREWAR: return list.lDeclareWarOnCivID.size() > 0;
            case OFFER_COALITION: return list.lFormCoalitionAgainst.size() > 0;
            case OFFER_FIGHT_COALITION_ALL_NEIGHBORS: return list.fightCoalitionAllNeighbors;
            case OFFER_DEFENSIVEPACT: return list.defensivePact;
            case OFFER_NONAGGRESSION: return list.nonAggressionPact;
            case OFFER_INDEPENDENCE: return list.proclaimIndependence;
            case OFFER_MILITARYACCESS: return list.militaryAccess;
            case OFFER_PREPAREFORWAR: return list.lPrepareForWarCivID.size() > 0;
            case OFFER_SANCTIONS: return list.lSanctionCivID.size() > 0;
        }
        return false;
    }

    private void clearOffer(int offerType, boolean isLeft) {
        TradeRequest_List list = isLeft ? CFG.tradeRequest.listLEFT : CFG.tradeRequest.listRight;
        switch (offerType) {
            case OFFER_GOLD:
                list.iGold = 0;
                break;
            case OFFER_PROVINCES:
                list.lProvinces.clear();
                break;
            case OFFER_DECLAREWAR:
                list.lDeclareWarOnCivID.clear();
                break;
            case OFFER_COALITION:
                list.lFormCoalitionAgainst.clear();
                break;
            case OFFER_FIGHT_COALITION_ALL_NEIGHBORS:
                list.fightCoalitionAllNeighbors = false;
                break;
            case OFFER_PREPAREFORWAR:
                list.lPrepareForWarCivID.clear();
                break;
            case OFFER_SANCTIONS:
                list.lSanctionCivID.clear();
                break;
        }
    }

    private void toggleOffer(int offerType, boolean isLeft) {
        TradeRequest_List list = isLeft ? CFG.tradeRequest.listLEFT : CFG.tradeRequest.listRight;
        switch (offerType) {
            case OFFER_DEFENSIVEPACT:
                list.defensivePact = !list.defensivePact;
                break;
            case OFFER_FIGHT_COALITION_ALL_NEIGHBORS:
                list.fightCoalitionAllNeighbors = !list.fightCoalitionAllNeighbors;
                break;
            case OFFER_NONAGGRESSION:
                list.nonAggressionPact = !list.nonAggressionPact;
                break;
            case OFFER_INDEPENDENCE:
                list.proclaimIndependence = !list.proclaimIndependence;
                break;
            case OFFER_MILITARYACCESS:
                list.militaryAccess = !list.militaryAccess;
                break;
            case OFFER_DECLAREWAR:
                clearOffer(offerType, isLeft);
                break;
            case OFFER_COALITION:
                clearOffer(offerType, isLeft);
                break;
            case OFFER_PREPAREFORWAR:
                clearOffer(offerType, isLeft);
                break;
            case OFFER_SANCTIONS:
                clearOffer(offerType, isLeft);
                break;
            case OFFER_PROVINCES:
                clearOffer(offerType, isLeft);
                break;
        }
    }

    private void openCivSelection(int offerType, boolean isLeft) {
        Menu_InGame_SelectProvinces.TypeOfAction actionType = null;
        switch (offerType) {
            case OFFER_DECLAREWAR:
                actionType = isLeft ? Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_DECLAREWAR : Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_DECLAREWAR;
                break;
            case OFFER_COALITION:
                actionType = isLeft ? Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_COALITION : Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_COALITION;
                break;
            case OFFER_PREPAREFORWAR:
                actionType = isLeft ? Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_PREPAREFORWAR : Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_PREPAREFORWAR;
                break;
            case OFFER_SANCTIONS:
                actionType = isLeft ? Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_SANCTION : Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_SANCTION;
                break;
        }
        if (actionType != null) {
            CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
            CFG.mapModesManager.disableAllViews();
            CFG.core.setActiveProvID(-1);
            Menu_InGame_TradeRequest_SelectCiv.typeOfAction = actionType;
            System.out.println("TRADE_DEBUG: openCivSelection setting typeOfAction=" + actionType + " offerType=" + offerType + " isLeft=" + isLeft);
            CFG.menus.setMenuID(View.eINGAME_TRADE_SELECT_CIV);
            CFG.toastM.addM(CFG.lang.get("SelectProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            RenderProvince.updateDrawProvinces();
        }
    }

    private void openProvinceSelection(boolean isLeft) {
        int targetCivID = isLeft ? CFG.tradeRequest.iCivLEFT : CFG.tradeRequest.iCivRIGHT;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = targetCivID;
        CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
        CFG.mapModesManager.disableAllViews();
        CFG.core.setActiveProvID(-1);
        Menu_InGame_SelectProvinces.typeOfAction = isLeft ? Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT : Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT;
        CFG.VIEW_SHOW_VALUES = false;
        CFG.selectMode = true;
        CFG.core.getProvSelected().clearSelectedProvinces();
        CFG.menus.setMenuID(View.eINGAME_SELECT_PROVINCES);
        RenderProvince.updateDrawProvinces();
    }

    private String getOfferName(int offerType) {
        switch (offerType) {
            case OFFER_GOLD: return CFG.lang.get("Gold");
            case OFFER_PROVINCES: return CFG.lang.get("Provinces");
            case OFFER_DECLAREWAR: return CFG.lang.get("DeclareWar");
            case OFFER_COALITION: return CFG.lang.get("FormACoalitionAgainst");
            case OFFER_FIGHT_COALITION_ALL_NEIGHBORS: return CFG.lang.get("FightCoalitionAll");
            case OFFER_DEFENSIVEPACT: return CFG.lang.get("DefensivePact");
            case OFFER_NONAGGRESSION: return CFG.lang.get("NonAggressionPact");
            case OFFER_INDEPENDENCE: return CFG.lang.get("ProclaimIndependence");
            case OFFER_MILITARYACCESS: return CFG.lang.get("MilitaryAccess");
            case OFFER_PREPAREFORWAR: return CFG.lang.get("PrepareForWar");
            case OFFER_SANCTIONS: return CFG.lang.get("Sanctions");
            default: return "";
        }
    }

    @Override
    public void updateLang() {}

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX,
            this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY,
            this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(),
            this.getHeightM() + CFG.PADD, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() + Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX,
            this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY,
            IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.15f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_TradeRequest();
    }

    @Override
    public final void actionEL(int iID) {
        int lastIdx = this.getMenuElemsSize() - 1;
        int secondLastIdx = lastIdx - 1;
        if (iID == lastIdx) {
            GameManager.sendTradeRequest(iOnCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.tradeRequest);
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(3500);
            this.setVisibleM(false);
            return;
        }
        if (iID == secondLastIdx) {
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() { return this.getWidthM(); }
    public final int getElementW() { return this.getW() / 3; }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); i++) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }

    @Override
    public void setPosX(int iPosX) {
        super.setPosX(iPosX);
    }

    @Override
    public void setPosY(int iPosY) {
        super.setPosY(iPosY);
    }

    public final int getH() { return this.getHeightM(); }
}
