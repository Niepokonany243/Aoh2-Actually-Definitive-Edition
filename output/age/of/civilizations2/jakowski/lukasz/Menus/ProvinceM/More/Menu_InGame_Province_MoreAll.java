/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_BuildAll;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent_WithHoverEnabled;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Wonder_2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Button_Icon;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Merce.Menu_InGame_Mercenaries;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_More;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Army.Menu_InGame_SendArmy;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Province_MoreAll
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static boolean toTheBottom = false;
    public static boolean moreTopAction = false;
    public static int provinceID = 0;
    public static int extraPosX = 0;

    public static int getExtraW() {
        return CFG.BUTTON_W * 3 / 4;
    }

    public Menu_InGame_Province_MoreAll() {
        int extraW = Menu_InGame_Province_MoreAll.getExtraW();
        int tempW = CFG.CIV_INFO_MENU_WIDTH + Menu_InGame_Province_MoreAll.getExtraW();
        int tPosY = 0;
        int buttonH = CFG.BUTTON_H * 4 / 5;
        int row = 0;
        provinceID = CFG.core.getActiveProvID();
        Menu_InGame_Province_More.IN_BUILD_MENU = false;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (!moreTopAction) {
            menuElements.add(new Button_BuildAll(CFG.lang.get("More") + ": " + CFG.lang.get("Back"), Images.buildAll, 0, tPosY, tempW){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.setVisible_InGame_MoreAll(false, false);
                    CFG.menus.setVisible_InGame_ProvinceMore(true, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("More") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Back"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.buildAll, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else if (GameValues.gvInGame.MORE_ALL_ARMY_BUTTONS) {
            menuElements.add(new TextBuildTitle(CFG.lang.get("Army"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            if (GameValues.gvInGame.MORE_ALL_RECRUIT_MERCENARIES_BUTTON) {
                menuElements.add(new Button_Build(CFG.lang.get("RecruitMercenaries"), Images.mercenaries, 0, 0, 0, tPosY, tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_Mercenaries.hireID = -1;
                        CFG.menus.rebuildInGame_Mercenaries(BuildingsManager.iBuildInProvinceID);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitMercenaries"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.mercenaries, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
                ++row;
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            menuElements.add(new Button_Build(CFG.lang.get("RegroupArmies") + ": " + CFG.core.getProv(provinceID).getProvName(), Images.diploArmyMove, 0, 0, 0, tPosY, tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_RegroupArmies(provinceID);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RegroupArmies") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public boolean getIsClickable() {
                    return true;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            menuElements.add(new Button_Build(CFG.lang.get("CancelAllArmyMovements"), Images.diploArmy, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_CancelMoveArmies();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Cancel") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MoveTheArmies"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public boolean getIsClickable() {
                    return true;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ++row;
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            if (GameValues.gvInGame.MORE_ALL_SEND_VOLUNTEER_ARMY_BUTTON) {
                menuElements.add(new Button_Build(CFG.lang.get("SendVolunteerArmy"), Images.diploArmySend, 0, 0, 0, tPosY, tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_SendArmy.toProvinceID = -1;
                        CFG.menus.rebuildInGame_SendArmy(provinceID);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendVolunteerArmy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmySend, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SendVolunteerArmyText")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(provinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(provinceID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
                ++row;
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("Decrees") + ": " + CFG.lang.get("AllProvinces"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        int tempElemH = CFG.BUTTON_H * 4 / 5;
        menuElements.add(new Button_CNG_Options2(CFG.lang.get("AutomaticAssimilation") + ": " + (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.PADD * 2, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.BUTTON_H * 3 / 4, true, CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.AUTO_ASSIMILATE){

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
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Stability"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.assimilateAllProvinces_CostDiplomacy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topDiplomacyPoints, CFG.COLOR_DIPLOMACY_POINTS, Images.diploStability, CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f), 100, 1.0f), 0, tPosY, tempW - 2 - extraW, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_ASSIMILATE);
            }

            @Override
            public void actionElemPPM() {
                CFG.assimilateAll();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
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
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.diploStability).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploStability).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploStability).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.assimilateAll();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.investEconomyAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.investEconomyAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.investEconomyAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.investEco, CFG.COLOR_ECONOMY, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_INVEST_ECO);
            }

            @Override
            public void actionElemPPM() {
                CFG.investAllEconomy();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.investEco).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investEco).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investEco).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Invest") + ", " + CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.investAllEconomy();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DEVELOPMENT_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Development"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.investDevAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.investDevAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.investDevAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.investDev, CFG.COLOR_DEVELOPMENT, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_INVEST_DEV);
            }

            @Override
            public void actionElemPPM() {
                CFG.investAllDevelopment();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.investDev).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investDev).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investDev).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Invest") + ", " + CFG.lang.get("Development") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.investAllDevelopment();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_HAPPINESS_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Happiness"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.happiness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.festivalAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.festivalAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.festivalAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.diploFestival, CFG.COLOR_TEXT_HAPPINESS_ACTIVE, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_INVEST_FESTIVAL);
            }

            @Override
            public void actionElemPPM() {
                CFG.festivalAll();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.diploFestival).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploFestival).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploFestival).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploFestival, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Festival") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.festivalAll();
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new TextBuildTitle(CFG.lang.get("Build") + ": " + CFG.lang.get("AllProvinces"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (GameValues.gvCommands.PROV_MORE_ALL_SHOW_BUILDINGS) {
            int nX = 0;
            int nW = tempW / 8;
            menuElements.add(new Button_Icon(nX, tPosY, nW, buttonH, Images.bFort){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Fort"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bFort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bTower){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WatchTower"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bTower, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bPort){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_PORT_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Port"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bFarm){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_FARM_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Farm"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bWorkshop){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Workshop"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bWorkshop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bMarket){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_MARKET_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Market"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bMarket, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, nW, buttonH, Images.bLibrary){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Library"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bLibrary, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Icon(nX += nW, tPosY, tempW - nX, buttonH, Images.bArmoury){

                @Override
                public void actionElem(int iID) {
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Armoury"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bArmoury, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nX += nW;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY, ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Fort"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bFort, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getFort_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.fortAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.fortAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.fortAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bFort, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_FORT);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.fortAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bFort).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bFort).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bFort).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bFort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.fortAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WatchTower"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bTower, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getTower_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.towerAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.towerAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.towerAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bTower, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_TOWER);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.towerAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bTower).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bTower).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bTower).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bTower, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.towerAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_PORT_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Port"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getPort_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.portAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.portAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.portAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bPort, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_PORT);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.pALPR(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bPort).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bPort).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bPort).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.pALPR(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_FARM_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Farm"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getFarm_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.farmAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.farmAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.farmAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bFarm, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_FARM);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.farmAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bFarm).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bFarm).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bFarm).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.farmAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Workshop"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bWorkshop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getWorkshop_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.workshopAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.workshopAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.workshopAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bWorkshop, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_WORKSHOP);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.workshopAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bWorkshop).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bWorkshop).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bWorkshop).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bWorkshop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.workshopAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_MARKET_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Market"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bMarket, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getMarket_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.marketAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.marketAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.marketAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bMarket, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_MARKET);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.marketAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bMarket).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bMarket).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bMarket).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bMarket, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.marketAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Library"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bLibrary, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getLibrary_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.libraryAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.libraryAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.libraryAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bLibrary, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_LIBRARY);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.libraryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bLibrary).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bLibrary).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bLibrary).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bLibrary, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.libraryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Armoury"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bArmoury, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getArmoury_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.armouryAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.armouryAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.armouryAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bArmoury, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_ARMOURY);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.armouryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bArmoury).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bArmoury).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bArmoury).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bArmoury, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.armouryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, tempElemH, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE, false);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SupplyCamp"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bSupply, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get(BuildingsManager.getSupply_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.suppliesAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.suppliesAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.suppliesAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bSupply, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tPosY, tempW - extraW - 2, tempElemH){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.ALL_SUPPLIES);
            }

            @Override
            public void actionElemPPM() {
                CFG.core.suppliesAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW + 2, tempElemH, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.bSupply).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bSupply).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bSupply).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bSupply, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(1)) + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.suppliesAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.setVisible_InGame_MoreAll(true, true);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
        ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
        ++row;
        menuElements.add(new TextBuildTitle(CFG.lang.get("Wonders"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int elementsBefore = menuElements.size();
        for (int i = 0; i < CFG.core.wondersMgr.wondersProvinceIDs.size(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getWonderSize(); ++j) {
                if (CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || !CFG.core.getProv((int)CFG.core.wondersMgr.wondersProvinceIDs.get((int)i).intValue()).getWonder((int)j).isAvailable) continue;
                menuElements.add(new ButtonN_Wonder_2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)) ? new Color((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId()).getB() / 255.0f, 1.0f) : new Color(0.09411765f, 0.3137255f, 0.43137255f, 0.5f), CFG.core.wondersMgr.wondersProvinceIDs.get(i), j, 0, tPosY, tempW, CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getPop().getPops()), Images.pop, CFG.COLOR_POPULATION){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            CFG.menus.rebuildInGame_BuildWonder(this.getCurr());
                        } else if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getCurr())) {
                            CFG.core.setActiveProvID(this.getCurr());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        } else {
                            CFG.toastM.addM(CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        }
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        if (elementsBefore == menuElements.size()) {
            menuElements.add(new TextScale(CFG.lang.get("None"), -1, 0, tPosY, tempW - CFG.PADD * 2, CFG.BUTTON_H * 3 / 4, 0.75f){});
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - Core.PADDING - this.getHeightT(), Menu_InGame_Province_MoreAll.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_Province_MoreAll.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_Province_MoreAll.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + Menu_InGame_Province_MoreAll.this.getWidthM() - Menu_InGame_Province_MoreAll.this.getWidthM() / 4 + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_Province_MoreAll.this.getWidthM() / 4, 1, true, false);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                }
                oSB.setColor(Color.WHITE);
                Core.drawFlagRect(oSB, Menu_InGame_Province_MoreAll.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Province_MoreAll.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + buttonH, tempW, Math.min(tPosY, CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4) - CFG.PADD * 3), menuElements, false, true);
        if (BuildingsManager.iBuildInProvinceID < 0) {
            this.setVisibleM(false);
        }
        this.updateLang();
        toTheBottom = this.getPosY() + this.getHeightM() + CFG.BUTTON_H + CFG.PADD * 3 > CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight();
        extraPosX = -this.getWidthM();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName());
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            if (hideAnimation) {
                extraPosX = -((int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
                iTranslateX += extraPosX;
            } else {
                extraPosX = -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME));
                iTranslateX += extraPosX;
            }
            CFG.setRenderO(true);
        } else {
            if (hideAnimation) {
                super.setVisibleM(false);
                extraPosX = 0;
                return;
            }
            extraPosX = 0;
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
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + CFG.PADD, true, true);
        }
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

