/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.VProvince.Stability;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRightTop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_ProvinceStability;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameAction;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_ProvinceStability
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_ProvinceStability() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        int extraW = CFG.BUTTON_W * 3 / 4;
        if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            tempW += extraW;
        }
        ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempProvs = new ArrayList<Integer>();
        for (i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.iCivID).getProvID(i))) continue;
            tempProvs.add(CFG.core.getCiv(this.iCivID).getProvID(i));
        }
        while (!tempProvs.isEmpty()) {
            int tBest = 0;
            for (int i2 = 1; i2 < tempProvs.size(); ++i2) {
                if (!(CFG.core.getProv((Integer)tempProvs.get(tBest)).getProviStability() < CFG.core.getProv((Integer)tempProvs.get(i2)).getProviStability())) continue;
                tBest = i2;
            }
            tempProvincesSorted.add((Integer)tempProvs.get(tBest));
            tempProvs.remove(tBest);
        }
        menuElements.add(new Button_DiplomacyAction(Images.diploStability, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("Stability"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewProvinceStabilityAll(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopCivilizations"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilization"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (!tempProvincesSorted.isEmpty()) {
            menuElements.add(new ButtonN_Pop_TextRightTop(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(this.iCivID).getCivName(), this.iCivID, CFG.lang.get("TotalCost") + ": ", "" + CFG.getNumber_SHORT(CFG.core.getCiv((int)this.iCivID).civGD.aACSG), Images.topGold(), CFG.COLOR_GOLD, 0, tY, tempW, (int)(CFG.core.getCiv(this.iCivID).getStabilityCiv() * 100.0f) + "%", Images.diploStability){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.setVisible_InGame_ViewProvinceStabilityAll(true);
                }

                @Override
                public void actionElemPPM() {
                    if (this.iCivID > 0) {
                        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                    }
                }

                @Override
                public Color getColorRight() {
                    try {
                        return CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(this.iCivID).getStabilityCiv() * 100.0f), 100, 1.0f);
                    }
                    catch (Exception exception) {
                        return super.getColorRight();
                    }
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Stability") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big((int)(CFG.core.getCiv(this.iCivID).getStabilityCiv() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalAssimilationCount") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.aACS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalAssimilationCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.aACSG), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability1"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability2"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability3"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("StabilityDesc"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"), this.iCivID, CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.assimilateAllProvinces_CostDiplomacy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topDiplomacyPoints, CFG.COLOR_DIPLOMACY_POINTS, Images.diploStability, CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(this.iCivID).getStabilityCiv() * 100.0f), 100, 1.0f), 0, tY, tempW - extraW, CFG.BUTTON_H * 4 / 5){

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.ALL_ASSIMILATE);
                    }

                    @Override
                    public void actionElemPPM() {
                        CFG.assimilateAll();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), Colors.COLOR_TEXT_GOLD));
                            nData.add(new ME_Hover_2Type_Image_Big(this.iImageID, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(this.sProvincesText));
                            nData.add(new ME_Hover_2Type_Text(this.sProvinceNumText, CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                            nData.add(new ME_Hover_2Type_Text(this.sCostText, CFG.COLOR_GOLD));
                            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (this.imgCost2 == Images.topMovementPoints) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                            } else if (this.imgCost2 == Images.topDiplomacyPoints) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                            }
                            nData.add(new ME_Hover_2Type_Text(this.sCostText2, this.costColor));
                            nData.add(new ME_Hover_2Type_Image(this.imgCost2, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvAssimilate.ASSIMILATE_HAPPINESS_CHANGE_PER_TURN * 100.0f, 100) + " " + CFG.lang.get("PerTurn"), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (Exception e) {
                            this.menuElemHover = null;
                        }
                    }
                });
                menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, CFG.BUTTON_H * 4 / 5, true, 0){

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.getIsHovered()) {
                            IMGManager.getIMG(Images.diploStability).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploStability).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploStability).getHeight() / 2 + iTranslateY);
                        } else {
                            super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.assimilateAll();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"), Colors.COLOR_TEXT_GOLD));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (Exception e) {
                            this.menuElemHover = null;
                        }
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
                menuElements.add(new Button_CNG_Options2(CFG.lang.get("AutomaticAssimilation") + ": " + (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.PADD * 2, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE(), tempW, CFG.BUTTON_H * 3 / 4, true, CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE){

                    @Override
                    public boolean getCheckboxSt() {
                        return CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE;
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE = !CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE;
                        this.setTextE(CFG.lang.get("AutomaticAssimilation") + ": " + (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE ? CFG.lang.get("On") : CFG.lang.get("Off")));
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AutomaticAssimilation") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE ? CFG.lang.get("On") : CFG.lang.get("Off"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AutoDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i = tempProvincesSorted.size() - 1; i >= 0; --i) {
                boolean investButton = CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                menuElements.add(new Button_View_ProvinceStability(i, CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(this.iCivID).getCivName(), (Integer)tempProvincesSorted.get(i), 0, tY, tempW + (investButton ? -extraW : 0), CFG.core.getCiv(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId()).isAssimilateOrganized((Integer)tempProvincesSorted.get(i))){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && this.getCurr() == CFG.core.getActiveProvID() && CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isAssimilateOrganized(this.getCurr())) {
                            if (this.getCurr() >= 0) {
                                CFG.menus.rebuildInGame_Assimilate(this.getCurr());
                            }
                        } else {
                            CFG.core.setActiveProvID(this.getCurr());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        }
                    }
                });
                if (investButton) {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                IMGManager.getIMG(Images.diploStability).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploStability).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploStability).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(this.getCurr()).isOccupied()) {
                                int actionDone = 0;
                                int nMax = 0;
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(this.getCurr(), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX)) {
                                    nMax = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX;
                                } else {
                                    int i = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX - 1;
                                    while (i >= 5) {
                                        nMax = i--;
                                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(this.getCurr(), nMax)) break;
                                    }
                                }
                                if (GameManager.addAssi(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr(), nMax)) {
                                    CFG.gameAction.updateInGame_ProvinceInfo();
                                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                                    }
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                                            CFG.menus.setVisible_InGame_ViewProvinceStability(true);
                                        }
                                    }
                                    CFG.SFXManager.playSound(SFXManager.SFX_ASSIMILATE);
                                    ++actionDone;
                                }
                                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                if (actionDone > 0) {
                                    CFG.toastM.addM(CFG.lang.get("Assimilate") + ": " + CFG.core.getProv(this.getCurr()).getName(), CFG.COLOR_POSITIVE);
                                    CFG.toastM.setTimeInView(3500);
                                }
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PromoteOurTraditionsAndCulturesInThisProvince")));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("APercentageOfTheLocalsWillConvertToOurNationality")));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ProvinceStabilityWillBeIncreased"), CFG.COLOR_POSITIVE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            try {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceStability") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(this.id).getProviStability() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                int nMax = 0;
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(this.getCurr(), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX)) {
                                    nMax = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX;
                                } else {
                                    int i = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX - 1;
                                    while (i >= 5) {
                                        nMax = i--;
                                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(this.getCurr(), nMax)) break;
                                    }
                                }
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + GameManager.assimilateCost(this.id, nMax)), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvAssimilate.ASSIMILATE_HAPPINESS_CHANGE_PER_TURN * 100.0f, 100) + " " + CFG.lang.get("PerTurn"), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                }
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            menuElements.add(new Text_Desc2_Special(CFG.lang.get("Stability1") + " " + CFG.lang.get("Stability2") + CFG.lang.get("Stability3"), CFG.PADD, tY += CFG.PADD, tempW - CFG.PADD * 2){

                @Override
                protected Color getColor(boolean isActive) {
                    return Colors.getColorButton(isActive, this.getIsHovered());
                }
            });
            menuElements.add(new Text_Desc2_Special(CFG.lang.get("StabilityDesc"), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

                @Override
                protected Color getColor(boolean isActive) {
                    return Colors.getColorButton(isActive, this.getIsHovered());
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        } else {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("ProvinceStability"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_ProvinceStability.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_PROVINCE_STABILITY_MAX.r, CFG.COLOR_PROVINCE_STABILITY_MAX.g, CFG.COLOR_PROVINCE_STABILITY_MAX.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_PROVINCE_STABILITY_MAX.r, CFG.COLOR_PROVINCE_STABILITY_MAX.g, CFG.COLOR_PROVINCE_STABILITY_MAX.b, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_ProvinceStability.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_ProvinceStability.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_ProvinceStability.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_ProvinceStability.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_ProvinceStability.this.getPosX() + Menu_InGame_View_ProvinceStability.this.getWidthM() - Menu_InGame_View_ProvinceStability.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_ProvinceStability.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.diploStability).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_ProvinceStability.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.diploStability).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.09803922f, 0.05882353f, 0.37254903f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() + CFG.PADD, this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }
}

