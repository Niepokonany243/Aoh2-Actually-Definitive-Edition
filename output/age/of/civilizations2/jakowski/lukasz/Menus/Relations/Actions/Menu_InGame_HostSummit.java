
package age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion.ButtonN_Opinion_2;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_HostSummit
extends Menu {
    public static String summitName = "";
    public static int provinceID = 0;
    public static List<Integer> invitedCivs = new ArrayList<Integer>();
    public static int activeInviteCiv = 0;

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_HostSummit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new TextBuildTitle(CFG.lang.get("SummitLocation"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2();
            }

            @Override
            public void actionElem(int iID) {
                CFG.map.getMpC().centerToProvID(provinceID);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SummitLocation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(invitedCivs.get(0), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        String locationName = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() >= 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getProvName() : CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName();
        menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 1.0f), locationName, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Population") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getPop().getPops()), Images.pop, CFG.COLOR_POPULATION, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth){

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(summitName, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                for (int i = 0; i < invitedCivs.size() && i < 8; ++i) {
                    nData.add(new ME_Hover_2Type_Flag_Big(invitedCivs.get(i), CFG.PADD, 0));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SummitLocation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(invitedCivs.get(0), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("HostDiplomaticSummitDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_Desc(CFG.lang.get("SummitText"), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2() - CFG.PADD * 2;
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("ListOfInvitedCivilizations") + ": " + invitedCivs.size(), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HostDiplomaticSummitDesc")));
                nData.add(new ME_Hover_2Type_Image(Images.diploRelationsInc, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < invitedCivs.size(); ++i) {
            if (i == 0) {
                menuElements.add(new ButtonN_Opinion_2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs.get(i), Images.diploMessage, GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs), GameManager.hostSummitCostDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs), 2, tY, CFG.BUTTON_W * 2, ""){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_HostSummit.this.getElementW() * 2;
                    }
                });
            } else {
                menuElements.add(new ButtonN_Opinion_2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs.get(i), Images.diploMessage, GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs.get(i)), GameValues.gvSummit.SUMMIT_DIPLOMACY_POINTS_COST_PER_CIVILIZATION, 2, tY, CFG.BUTTON_W * 2, "+"){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_HostSummit.this.getElementW() * 2;
                    }

                    @Override
                    public void actionElem(int iID) {
                        for (int i = 1; i < invitedCivs.size(); ++i) {
                            if (invitedCivs.get(i).intValue() != this.getCurr()) continue;
                            invitedCivs.remove(i);
                            break;
                        }
                        CFG.menus.rebuildInGame_HostSummit2();
                    }
                });
            }
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("InviteCivilization"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && !invitedCivs.contains(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId())) {
            activeInviteCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
            if (CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeInviteCiv)) {
                menuElements.add(new ButtonN_Opinion_2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeInviteCiv, Images.diploWar, GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeInviteCiv), GameValues.gvSummit.SUMMIT_DIPLOMACY_POINTS_COST_PER_CIVILIZATION, 2, tY, CFG.BUTTON_W * 2, "+"){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_HostSummit.this.getElementW() * 2;
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.toastM.addM(CFG.lang.get("AtWar"), CFG.COLOR_NEGATIVE_1);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            } else {
                menuElements.add(new ButtonN_Opinion_2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeInviteCiv, Images.summit, GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeInviteCiv), GameValues.gvSummit.SUMMIT_DIPLOMACY_POINTS_COST_PER_CIVILIZATION, 2, tY, CFG.BUTTON_W * 2, "+"){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_HostSummit.this.getElementW() * 2;
                    }

                    @Override
                    public void actionElem(int iID) {
                        invitedCivs.add(this.getCurr());
                        CFG.menus.rebuildInGame_HostSummit2();
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InviteCivilization") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            activeInviteCiv = CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : 0;
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_HostSummit.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Text_Desc(CFG.lang.get("HostDiplomaticSummitDesc"), CFG.PADD, tY += CFG.PADD, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW2() - CFG.PADD * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_HostSummit.this.setVisibleM(false);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("HostDiplomaticSummit"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_HostSummit.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_HostSummit.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs)) {
                    CFG.toastM.addM(CFG.lang.get("Cost") + ": " + CFG.getNumberWthSpaces("" + GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs)), CFG.COLOR_NEGATIVE_1);
                    return;
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() < GameManager.hostSummitCostDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs)) {
                    CFG.toastM.addM(CFG.lang.get("DiplomacyPoints") + ": " + (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() / 10.0f + " / " + (float)GameManager.hostSummitCostDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs) / 10.0f, CFG.COLOR_NEGATIVE_1);
                    return;
                }
                if (GameManager.hostSummit(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs)) {
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("HostDiplomaticSummit"), summitName, Images.infoDiplomacy);
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    Menu_InGame_HostSummit.this.setVisibleM(false);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(summitName, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                    for (int i = 0; i < invitedCivs.size() && i < 8; ++i) {
                        nData.add(new ME_Hover_2Type_Flag_Big(invitedCivs.get(i), CFG.PADD, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SummitLocation") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(invitedCivs.get(0), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("HostDiplomaticSummitDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameManager.hostSummitCostGold(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs)), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)GameManager.hostSummitCostDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), invitedCivs) / 10.0f));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception ex) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.summit).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.summit).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.summit).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.summit).getWidth() + CFG.PADD) / 2 + CFG.PADD + IMGManager.getIMG(Images.summit).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(summitName, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.4f, 0.2f, 0.6f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.4f, 0.2f, 0.6f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().draw(oSB, Menu_InGame_HostSummit.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_HostSummit.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_HostSummit.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_HostSummit.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                IMGManager.getIMG(Images.summit).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.summit).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.summit).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != activeInviteCiv) {
                activeInviteCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                CFG.menus.rebuildInGame_HostSummit2();
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

