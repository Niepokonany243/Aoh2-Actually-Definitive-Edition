
package age.of.civilizations2.jakowski.lukasz.Menus.Invest;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Invest;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_InvestOverPenalty;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Invest
extends Menu {
    public static int iProvinceID = -1;

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_Invest() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Invest"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Invest(int nProvinceID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        iProvinceID = nProvinceID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new Button_Build_Invest(CFG.lang.get("InvestIn") + ": ", CFG.core.getProv(iProvinceID).getName().length() > 0 ? CFG.core.getProv(iProvinceID).getName() : CFG.lang.get("Province"), Images.investEco, 0, GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS, 0, tY, CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW2();
            }
        });
        menuElements.add(new Button_Build_InvestOverPenalty(CFG.lang.get("OverinvestmentPenalty") + ": ", 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, "+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.numberOfInvestments, 10)){

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW2();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OverinvestmentPenalty") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.numberOfInvestments, 10), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TooMuchGoldPouredIntoTheEconomyAtOnceDrivesUpCosts")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ThisPenaltySlowlyDecreasesOverTime")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Text_Desc(CFG.lang.get("EconomyInvestDesc"), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW2() - CFG.PADD * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Gold"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, GameManager.invest_MaxEconomy_Gold(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 0.65f){

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW() * 2 - CFG.PADD * 4;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GOLD.r, CFG.COLOR_GOLD.g, CFG.COLOR_GOLD.b, 0.65f);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Invest.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Invest.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_Invest.getHoverInvest(iProvinceID);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Invest"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.96862745f, 0.40392157f, 0.30980393f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.96862745f, 0.40392157f, 0.30980393f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_Invest.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Invest.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_Invest.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Invest.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
        try {
            this.getMenuElem(3).setCurr(GameManager.invest_MaxEconomy_Gold(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
            this.getMenuElem(0).setMin(GameManager.invest_EconomyByGold(iProvinceID, this.getMenuElem(this.getMenuElemsSize() - 3).getCurr()));
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGameOfferAlliance.lTime + (long)Menu_InGame_Message_Alliance.ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2 - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + 4 + Core.PADDING * 2, -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - Menu_InGameOfferAlliance.lTime) / (float)Menu_InGame_Message_Alliance.ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            CFG.setRenderO(true);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            if (GameManager.invest(iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getMenuElem(3).getCurr())) {
                CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                CFG.toastM.setTimeInView(3500);
                CFG.gameAction.updateInGame_ProvinceInfo();
                if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                    CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                }
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                    CFG.core.getProv((int)Menu_InGame_Invest.iProvinceID).viewBool = true;
                    if (CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewEconomy(true);
                    }
                }
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE) {
                    CFG.core.getProv((int)Menu_InGame_Invest.iProvinceID).viewBool = true;
                    if (CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewIncome(true);
                    }
                }
                CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
            }
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 3) {
            this.getMenuElem(0).setMin(GameManager.invest_EconomyByGold(iProvinceID, this.getMenuElem(iID).getCurr()));
            return;
        }
        CFG.core.setActiveProvID(iProvinceID);
        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }

    public static ME_Hover_v2 getHoverInvest(int provinceID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestIn") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getName().length() > 0 ? CFG.core.getProv(provinceID).getName() : CFG.lang.get("Province")));
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(provinceID).getEco()), CFG.COLOR_ECONOMY));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConstructionWillTakeXurns", GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS)));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OverinvestmentPenalty") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.numberOfInvestments, 10), CFG.COLOR_ECONOMY));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TooMuchGoldPouredIntoTheEconomyAtOnceDrivesUpCosts")));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ThisPenaltySlowlyDecreasesOverTime")));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }
}

