
package age.of.civilizations2.jakowski.lukasz.Menus.Invest;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Invest;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_InvestReturn;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRight;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_InvestForeign
extends Menu {
    public static int civID = 0;
    public static int provinceID = -1;
    public int sliderElementID = -1;

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_InvestForeign(int nCivID, int nProvinceID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        civID = nCivID;
        provinceID = nProvinceID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), civID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_InvestForeign.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("InvestInForeignProvince"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_InvestForeign.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        long maxInvestGold = 0L;
        if (provinceID >= 0) {
            menuElements.add(new Button_Build_Invest(CFG.lang.get("InvestIn") + ": ", CFG.core.getProv(provinceID).getName().length() > 0 ? CFG.core.getProv(provinceID).getName() : CFG.lang.get("Province"), Images.investF1, 0, GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS, 0, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_InvestForeign.this.getElementW2();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            maxInvestGold = GameManager.invest_MaxEconomy_Gold(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Gold"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, maxInvestGold, maxInvestGold, 0.65f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_InvestForeign.this.getElementW() * 2 - CFG.PADD * 4;
                }

                @Override
                public int getSliderHeight() {
                    return CFG.PADD * 2;
                }

                @Override
                public Color getColorLEFT() {
                    return new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.65f);
                }

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_InvestForeign.this.getMenuElem(iID - 1).setMin(GameManager.invest_EconomyByGold(provinceID, this.getCurr()));
                    Menu_InGame_InvestForeign.this.getMenuElem(iID + 1).setMin(GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, this.getCurr()));
                    Menu_InGame_InvestForeign.this.getMenuElem(iID + 2).setMin(GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, this.getCurr()) - this.getCurr());
                }
            });
            this.sliderElementID = menuElements.size() - 1;
            menuElements.add(new ButtonN_Pop_TextRight(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 1.0f), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("TotalReturn") + ": ", "0", Images.topGold(), CFG.COLOR_GOLD, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, CFG.lang.get("TurnsX", GameValues.gvInvestForeign.INVEST_ECO_RETURN_TURNS), Images.time){

                @Override
                public void buildElemHover() {
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_InvestForeign.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                }
            });
            menuElements.add(new Button_Diplomacy_InvestReturn(CFG.lang.get("EstimatedReturnRate") + ": ", 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_InvestForeign.this.getElementW() * 2;
                }
            });
            if (provinceID >= 0) {
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((int)(GameManager.investForeignEconomy_ReturnRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID) * 10000.0f));
            }
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_InvestForeign.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return (Menu_InGame_InvestForeign.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_InvestForeign.this.setVisibleM(false);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm") + " " + CFG.lang.get(">>"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return CFG.PADD * 2 + (Menu_InGame_InvestForeign.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public int getWidthE() {
                return (Menu_InGame_InvestForeign.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void actionElem(int iID) {
                try {
                    if (CFG.core.getProv(provinceID).getCivId() <= 0) {
                        CFG.toastM.addM(CFG.lang.get("Civilization") + ": " + CFG.lang.get("Neutral"), CFG.COLOR_NEGATIVE_1);
                    } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).areSanctionsAdded(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(provinceID).getCivId()) || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).areSanctionsAdded(CFG.core.getProv(provinceID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        CFG.toastM.addM(CFG.lang.get("SanctionsBox1"), CFG.COLOR_NEGATIVE_1);
                    } else if (Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr() > 0) {
                        GameManager.investForeignEconomy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr());
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InvestInForeignProvince"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), civID, Images.infoEconomy);
                        CFG.menus.rebuildInGame_InvestForeign(civID, provinceID);
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Gold") + ": " + Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr(), CFG.COLOR_NEGATIVE_1);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public void buildElemHover() {
                if (provinceID >= 0) {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestInForeignProvince") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.investF1, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Gold") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + GameManager.invest_EconomyByGold(provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalReturn") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr())), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Profit") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()) - Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr())), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Duration") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", GameValues.gvInvestForeign.INVEST_ECO_RETURN_TURNS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ForeignInvestYourGoldDirectlyDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.investF1).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.investF1).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investF1).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.investF1).getWidth() + CFG.PADD) / 2 + CFG.PADD + IMGManager.getIMG(Images.investF1).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return provinceID >= 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_InvestForeign.this.getW() - (Menu_InGame_InvestForeign.this.getW() - CFG.PADD * 4) / 3 - CFG.PADD;
            }

            @Override
            public int getWidthE() {
                return (Menu_InGame_InvestForeign.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void actionElem(int iID) {
                try {
                    if (CFG.core.getProv(provinceID).getCivId() <= 0) {
                        CFG.toastM.addM(CFG.lang.get("Civilization") + ": " + CFG.lang.get("Neutral"), CFG.COLOR_NEGATIVE_1);
                    } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).areSanctionsAdded(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(provinceID).getCivId()) || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).areSanctionsAdded(CFG.core.getProv(provinceID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        CFG.toastM.addM(CFG.lang.get("SanctionsBox1"), CFG.COLOR_NEGATIVE_1);
                    } else if (Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr() > 0) {
                        Menu_InGame_InvestForeign.this.setVisibleM(false);
                        GameManager.investForeignEconomy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr());
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InvestInForeignProvince"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), civID, Images.infoEconomy);
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Gold") + ": " + Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr(), CFG.COLOR_NEGATIVE_1);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public void buildElemHover() {
                if (provinceID >= 0) {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestInForeignProvince") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.investF1, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Gold") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + GameManager.invest_EconomyByGold(provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalReturn") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr())), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Profit") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr()) - Menu_InGame_InvestForeign.this.getMenuElem(Menu_InGame_InvestForeign.this.sliderElementID).getCurr())), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Duration") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", GameValues.gvInvestForeign.INVEST_ECO_RETURN_TURNS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ForeignInvestYourGoldDirectlyDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.investF1).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.investF1).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investF1).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.investF1).getWidth() + CFG.PADD) / 2 + CFG.PADD + IMGManager.getIMG(Images.investF1).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return provinceID >= 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("ForeignInvestment"), CFG.BUTTON_H * 3 / 4, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.27450982f, 0.50980395f, 0.7058824f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.27450982f, 0.50980395f, 0.7058824f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().draw(oSB, Menu_InGame_InvestForeign.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_InvestForeign.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_InvestForeign.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_InvestForeign.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                CFG.core.getCiv(civID).getFlagC().draw(oSB, Menu_InGame_InvestForeign.this.getPosX() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + 2 + iTranslateX, Menu_InGame_InvestForeign.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_InvestForeign.this.getPosX() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + 2 + iTranslateX, Menu_InGame_InvestForeign.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                IMGManager.getIMG(Images.investF).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.investF).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.investF).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
        if (this.sliderElementID >= 0) {
            this.getMenuElem(this.sliderElementID).setCurr(maxInvestGold);
            this.getMenuElem(this.sliderElementID - 1).setMin(GameManager.invest_EconomyByGold(provinceID, maxInvestGold));
            this.getMenuElem(this.sliderElementID + 1).setMin(GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, maxInvestGold));
            this.getMenuElem(this.sliderElementID + 2).setMin(GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, maxInvestGold) - maxInvestGold);
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
        try {
            if (CFG.core.getActiveProvID() >= 0 && CFG.core.getActiveProvID() != provinceID && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == civID) {
                provinceID = CFG.core.getActiveProvID();
                CFG.menus.rebuildInGame_InvestForeign(civID, provinceID);
            }
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
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
}

