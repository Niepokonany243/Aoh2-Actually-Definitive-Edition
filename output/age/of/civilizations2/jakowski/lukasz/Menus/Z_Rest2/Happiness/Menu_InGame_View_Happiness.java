
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Happiness;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRightTop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Happiness;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_Festival;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Happiness
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static int iCivID = 0;

    public Menu_InGame_View_Happiness() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        int extraW = CFG.BUTTON_W * 3 / 4;
        tempW += extraW;
        ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempProvs = new ArrayList<Integer>();
        for (i = 0; i < CFG.core.getCiv(iCivID).getNumOfProvs(); ++i) {
            if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(iCivID).getProvID(i))) continue;
            tempProvs.add(CFG.core.getCiv(iCivID).getProvID(i));
        }
        while (!tempProvs.isEmpty()) {
            int tBest = 0;
            for (int i2 = 1; i2 < tempProvs.size(); ++i2) {
                if (!(CFG.core.getProv((Integer)tempProvs.get(tBest)).getHappi() < CFG.core.getProv((Integer)tempProvs.get(i2)).getHappi())) continue;
                tBest = i2;
            }
            tempProvincesSorted.add((Integer)tempProvs.get(tBest));
            tempProvs.remove(tBest);
        }
        menuElements.add(new Button_DiplomacyAction(Images.happiness, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("Happiness"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewHappinessAll(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopCivilizations"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.happiness, CFG.PADD, 0));
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
            menuElements.add(new ButtonN_Pop_TextRightTop(new Color((float)CFG.core.getCiv(iCivID).getR() / 255.0f, (float)CFG.core.getCiv(iCivID).getG() / 255.0f, (float)CFG.core.getCiv(iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(iCivID).getCivName(), iCivID, CFG.lang.get("TotalCost") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)Menu_InGame_View_Happiness.iCivID).civGD.fECG), Images.topGold(), CFG.COLOR_GOLD, 0, tY, tempW, CFG.core.getCiv(iCivID).getHappiness() + "%", Images.happiness){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.setVisible_InGame_ViewHappinessAll(true);
                }

                @Override
                public Color getColorRight() {
                    return CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, CFG.core.getCiv(this.iCivID).getHappiness(), 100, 1.0f);
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getPrecision2(CFG.core.getCiv(this.iCivID).getHappiness(), 10) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Festivals") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.fE), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.diploFestival, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.fECG), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Happiness1"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes1"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes2"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes3"), CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Festival1"), CFG.COLOR_NEUTRAL));
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
            if (iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"), iCivID, CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.festivalAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.festivalAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.festivalAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.diploFestival, CFG.COLOR_TEXT_HAPPINESS_ACTIVE, 0, tY, tempW - extraW, CFG.BUTTON_H * 4 / 5){

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.ALL_INVEST_FESTIVAL);
                    }

                    @Override
                    public void actionElemPPM() {
                        CFG.festivalAll();
                    }
                });
                menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, CFG.BUTTON_H * 4 / 5, true, 0){

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.getIsHovered()) {
                            IMGManager.getIMG(Images.diploFestival).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploFestival).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploFestival).getHeight() / 2 + iTranslateY);
                        } else {
                            super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.festivalAll();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"), Colors.COLOR_TEXT_GOLD));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploFestival, CFG.PADD, 0));
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
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            } else {
                menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("SpreadPropaganda") + ": " + CFG.lang.get("AllProvinces"), iCivID, CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(iCivID).getNumOfProvs()), CFG.getNumber_SHORT(GameManager.propagandaCost_AllProvinces(iCivID)), CFG.getPrecision2(GameManager.propagandaCostDiplomacy_AllProvinces(iCivID), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.propaganda, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW, CFG.BUTTON_H * 4 / 5){

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.ALL_PROPAGANDA);
                    }

                    @Override
                    public void actionElemPPM() {
                        GameManager.spreadPropaganda_AllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iCivID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i = tempProvincesSorted.size() - 1; i >= 0; --i) {
                boolean investButton = CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                menuElements.add(new Button_View_Happiness(i, i + 1 + ". " + (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(iCivID).getCivName()), (Integer)tempProvincesSorted.get(i), 0, tY, tempW - extraW, CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iCivID) ? CFG.core.getCiv(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId()).isFestivalOrganized((Integer)tempProvincesSorted.get(i)) : false){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && this.getCurr() == CFG.core.getActiveProvID() && CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isFestivalOrganized(this.getCurr())) {
                            if (this.getCurr() >= 0) {
                                CFG.menus.rebuildInGame_Festival(this.getCurr());
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
                                IMGManager.getIMG(Images.diploFestival).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploFestival).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploFestival).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(this.getCurr()).isOccupied()) {
                                int actionDone = 0;
                                if (Festival.addFestival(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr())) {
                                    ++actionDone;
                                    CFG.gameAction.updateInGame_ProvinceInfo();
                                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                                    }
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                                            CFG.menus.setVisible_InGame_ViewHappiness(true);
                                        }
                                    }
                                }
                                if (actionDone > 0) {
                                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                    CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                                    CFG.toastM.setTimeInView(3500);
                                }
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            this.menuElemHover = Menu_InGame_Festival.getHoverFestival(this.getCurr());
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                } else {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                IMGManager.getIMG(Images.propaganda).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.propaganda).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.propaganda).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                ArrayList<Integer> provinces = new ArrayList<Integer>();
                                provinces.add(this.getCurr());
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces)) {
                                    CFG.toastM.addM(CFG.lang.get("Cost") + ": " + CFG.getNumberWthSpaces("" + GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces)), CFG.COLOR_NEGATIVE_1);
                                    return;
                                }
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() < GameManager.propagandaCostDiplomacy(provinces)) {
                                    CFG.toastM.addM(CFG.lang.get("DiplomacyPoints") + ": " + (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() / 10.0f + " / " + (float)GameManager.propagandaCostDiplomacy(provinces) / 10.0f, CFG.COLOR_NEGATIVE_1);
                                    return;
                                }
                                if (GameManager.spreadPropaganda(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(this.getCurr()).getCivId(), provinces)) {
                                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("SpreadPropaganda"), CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).getCivName(), Images.infoDiplomacy);
                                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                }
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            try {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                ArrayList<Integer> provinces = new ArrayList<Integer>();
                                provinces.add(this.getCurr());
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SpreadPropaganda"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.propaganda, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces)), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + (float)GameManager.propagandaCostDiplomacy(provinces) / 10.0f));
                                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                            catch (Exception ex) {
                                this.menuElemHover = null;
                            }
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                }
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            menuElements.add(new Text_Desc2_Special(CFG.lang.get("Happiness1"), CFG.PADD, tY += CFG.PADD, tempW - CFG.PADD * 2){

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
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Happiness"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Happiness.this.getPosX() + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Happiness.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.5647059f, 0.93333334f, 0.5647059f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.5647059f, 0.93333334f, 0.5647059f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Happiness.this.getPosX() + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Happiness.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Happiness.this.getPosX() + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Happiness.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Happiness.this.getPosX() + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Happiness.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Happiness.this.getPosX() + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Happiness.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Happiness.this.getPosX() + Menu_InGame_View_Happiness.this.getWidthM() - Menu_InGame_View_Happiness.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Happiness.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.happiness).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_Happiness.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.happiness).getHeight() / 2);
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

