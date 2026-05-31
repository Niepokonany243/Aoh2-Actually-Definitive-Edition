/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_BuildAll;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Decrees;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Destroy;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_DiplomacyCost;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_DiplomacyCost_Decrees;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Level;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent_WithHoverEnabled;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Wonder_2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_FlagDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Missiles;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Province_Claims;
import age.of.civilizations2.jakowski.lukasz.Province_Core;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Armoury;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Farm;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Fort;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Library;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Market;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Port;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Supply;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_AirDefense;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Tower;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Workshop;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Invest.Menu_InGame_Invest;
import age.of.civilizations2.jakowski.lukasz.Menus.Invest.Menu_InGame_Invest_Development;
import age.of.civilizations2.jakowski.lukasz.Menus.Merce.Menu_InGame_Mercenaries;
import age.of.civilizations2.jakowski.lukasz.Menus.Province.Menu_InGame_RelocatePopulation;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_MoreAll;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Army.Menu_InGame_SendArmy;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_Festival;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Province_More
extends Menu {
    public static boolean IN_BUILD_MENU = true;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static boolean toTheBottom = false;
    public static int extraPosX = 0;

    public static int getExtraW() {
        return CFG.BUTTON_W * 3 / 4;
    }

    public Menu_InGame_Province_More() {
        int tRow = 0;
        int extraW = Menu_InGame_Province_More.getExtraW();
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tPosY = 0;
        int buttonH = CFG.BUTTON_H * 4 / 5;
        int row = 0;
        IN_BUILD_MENU = true;
        boolean ownProvince = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (ownProvince) {
            menuElements.add(new Button_BuildAll(CFG.lang.get("More") + ": " + CFG.lang.get("AllProvinces"), Images.buildAll, 0, tPosY, tempW + extraW){

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_MoreAll.moreTopAction = false;
                    CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                    CFG.menus.setVisible_InGame_MoreAll(true, false);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("More") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AllProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.buildAll, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            menuElements.add(new TextIcon_FlagDiplomacy(CFG.core.getCiv(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId()).getCivName(), CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), 0, tPosY, tempW + extraW){

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void buildElemHover() {
                    this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvinceOwner(this.getCurr());
                }

                @Override
                public int getSFXElem() {
                    return SFXManager.SFX_CLICK2;
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        // ── Occupation Status Banner ─────────────────────────────────────────
        if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied()) {
            final int occupierCivID = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId();
            final int trueOwnerCivID = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv();
            final int turnsLeft = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getOccupationTurnsLeft();
            // Section header
            menuElements.add(new TextBuildTitle("OCCUPIED", -1, 0, tPosY, tempW + extraW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3){
                @Override
                public Color getColor(boolean isActive) {
                    return new com.badlogic.gdx.graphics.Color(1.0f, 0.35f, 0.2f, 1.0f);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            // Occupier row
            menuElements.add(new TextIcon_FlagDiplomacy(CFG.core.getCiv(occupierCivID).getCivName(), occupierCivID, 0, tPosY, tempW + extraW){
                @Override
                public Color getColorE(boolean isActive) {
                    return CFG.COLOR_NEGATIVE_1;
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(occupierCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big("Occupied by:", CFG.COLOR_NEGATIVE_1));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(occupierCivID).getCivName(), CFG.COLOR_NEGATIVE_1));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            // True owner row
            menuElements.add(new TextIcon_FlagDiplomacy(CFG.core.getCiv(trueOwnerCivID).getCivName(), trueOwnerCivID, 0, tPosY, tempW + extraW){
                @Override
                public Color getColorE(boolean isActive) {
                    return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(trueOwnerCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big("True Owner:", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(trueOwnerCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            // Occupation timer row
            menuElements.add(new Button_Build_Text(
                turnsLeft > 0 ? "Occupied: " + turnsLeft + " turn" + (turnsLeft != 1 ? "s" : "") + " ago" : "Occupied",
                0, tPosY, tempW + extraW, false, BuildingsManager.iBuildInProvinceID){
                @Override
                public Color getColorE(boolean isActive) {
                    return new com.badlogic.gdx.graphics.Color(1.0f, 0.65f, 0.1f, 1.0f);
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Occupation Status", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (turnsLeft > 0) {
                        nData.add(new ME_Hover_2Type_Text("Province occupied for: "));
                        nData.add(new ME_Hover_2Type_Text("" + turnsLeft + " turn" + (turnsLeft != 1 ? "s" : ""), CFG.COLOR_NEGATIVE_1));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Text("Occupier: "));
                    nData.add(new ME_Hover_2Type_Flag(occupierCivID, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(occupierCivID).getCivName(), CFG.COLOR_NEGATIVE_1));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text("True owner: "));
                    nData.add(new ME_Hover_2Type_Flag(trueOwnerCivID, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(trueOwnerCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        // ── Genocide Status Banner ─────────────────────────────────────────
        if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getDisplayTimerTurns() > 0 && !CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied()) {
            final int genCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            final int genTurnsLeft = GameManager.getGenocideTurnsLeft(genCivID, BuildingsManager.iBuildInProvinceID);
            menuElements.add(new TextBuildTitle("GENOCIDE", -1, 0, tPosY, tempW + extraW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3){
                @Override
                public Color getColor(boolean isActive) {
                    return new com.badlogic.gdx.graphics.Color(0.8f, 0.2f, 0.2f, 1.0f);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            menuElements.add(new Button_Build_Text(
                genTurnsLeft > 0 ? "Genocide: " + genTurnsLeft + " turn" + (genTurnsLeft != 1 ? "s" : "") + " remaining" : "Genocide",
                0, tPosY, tempW + extraW, false, BuildingsManager.iBuildInProvinceID){
                @Override
                public Color getColorE(boolean isActive) {
                    return new com.badlogic.gdx.graphics.Color(1.0f, 0.65f, 0.1f, 1.0f);
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Genocide Status", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (genTurnsLeft > 0) {
                        nData.add(new ME_Hover_2Type_Text("Genocide active for: "));
                        nData.add(new ME_Hover_2Type_Text("" + genTurnsLeft + " turn" + (genTurnsLeft != 1 ? "s" : ""), CFG.COLOR_NEGATIVE_1));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_TextDesc("Population being eliminated in this province.", CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        // ────────────────────────────────────────────────────────────────────
        if (BuildingsManager.iBuildInProvinceID >= 0) {
            boolean canDestroy = false;
            canDestroy = ownProvince && CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() > 0;
            tRow = 0;
            for (int i = 0; i < CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getWonderSize(); ++i) {
                menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY, ButtonDiplomacy.iDiploWidth, CFG.BUTTON_H, true){

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
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_WONDERS_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wonders"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.wonders, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new ButtonN_Wonder_2(new Color(0.09411765f, 0.3137255f, 0.43137255f, 1.0f), BuildingsManager.iBuildInProvinceID, i, 0, tPosY, tempW + extraW, CFG.getNumberWthSpaces("" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getPop().getPops()), Images.pop, CFG.COLOR_POPULATION){

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
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        if (ownProvince) {
            menuElements.add(new TextBuildTitle(CFG.lang.get("Buildings"), -1, 0, tPosY, tempW + extraW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Fort
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() + 1)), Images.bFort, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort(), BuildingsManager.getFort_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() == BuildingsManager.getFort_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.FORT), BuildingsManager.getFort_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFort() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildFort(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.FORT);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Air Defense
            menuElements.add(new Button_Build_Level(BuildingsManager.getAirDefense_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense + 1), Images.bSupply, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense, BuildingsManager.getAirDefense_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getAirDefense_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense == BuildingsManager.getAirDefense_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.AIR_DEFENSE), BuildingsManager.getAirDefense_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).provGD.iAirDefense + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildAirDefense(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.AIR_DEFENSE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Tower
            // Tower
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower() + 1)), Images.bTower, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower(), BuildingsManager.getTower_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getTower_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower() == BuildingsManager.getTower_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.TOWER), BuildingsManager.getTower_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWatchTower() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildTower(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.TOWER);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Port
            if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getNeighSeaProvincesSize() > 0) {
                menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getPort_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort() + 1)), Images.bPort, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort(), BuildingsManager.getPort_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getPort_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort() == BuildingsManager.getPort_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.PORT), BuildingsManager.getPort_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfPort() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildPort(BuildingsManager.iBuildInProvinceID);
                }
            });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
                menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.PORT);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
                tRow = (tRow + 1) % 2;
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }

            // Farm
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm() + 1)), Images.bFarm, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm(), BuildingsManager.getFarm_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getFarm_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm() == BuildingsManager.getFarm_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.FARM), BuildingsManager.getFarm_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfFarm() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildFarm(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.FARM);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Workshop
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop() + 1)), Images.bWorkshop, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop(), BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getWorkshop_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop() == BuildingsManager.getWorkshop_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.WORKSHOP), BuildingsManager.getWorkshop_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfWorkshop() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildWorkshop(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.WORKSHOP);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Market
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getMarket_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket() + 1)), Images.bMarket, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket(), BuildingsManager.getMarket_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getMarket_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket() == BuildingsManager.getMarket_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.MARKET), BuildingsManager.getMarket_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfMarket() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildMarket(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.MARKET);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Library
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary() + 1)), Images.bLibrary, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary(), BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getLibrary_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary() == BuildingsManager.getLibrary_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.LIBRARY), BuildingsManager.getLibrary_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfLibrary() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildLibrary(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.LIBRARY);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Armoury
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury() + 1)), Images.bArmoury, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury(), BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getArmoury_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury() == BuildingsManager.getArmoury_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.ARMOURY), BuildingsManager.getArmoury_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfArmoury() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildArmoury(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.ARMOURY);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

            // Supply
            menuElements.add(new Button_Build_Level(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply() + 1)), Images.bSupply, "" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply(), BuildingsManager.getSupply_BuildCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply() + 1, BuildingsManager.iBuildInProvinceID), BuildingsManager.getSupply_BuildMovementCost(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply() + 1), 0, tPosY, tempW, true, CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply() == BuildingsManager.getSupply_MaxLevel(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(BuildingsManager.iBuildInProvinceID, ConstructionType.SUPPLY), BuildingsManager.getSupply_TechLevel(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getLvlOfSupply() + 1)){
                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BuildSupply(BuildingsManager.iBuildInProvinceID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Province_More.quickBuild(BuildingsManager.iBuildInProvinceID, ConstructionType.SUPPLY);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }

        int tempBuildings = menuElements.size();
        tRow = 0;
        menuElements.add(new TextBuildTitle(CFG.lang.get("Decrees"), -1, 0, tPosY, tempW + extraW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){});
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, buttonH, true){

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
        menuElements.add(new Button_Build_Decrees(CFG.lang.get("Festival"), Images.diploFestival, Festival.festivalCost(BuildingsManager.iBuildInProvinceID), GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS, 0, tPosY, tempW, true, false, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isFestivalOrganized_TurnsLeft(BuildingsManager.iBuildInProvinceID), 0.0f, CFG.lang.get("Happiness") + ": ", "" + CFG.getPrecision2(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getHappi() * 100.0f, 100) + "%", CFG.getHappinessImage((int)CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getHappi()), CFG.COLOR_TEXT_HAPPINESS_HOVER){

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isFestivalOrganized_TurnsLeft(BuildingsManager.iBuildInProvinceID) > 0) {
                    CFG.toastM.addM(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                } else {
                    CFG.menus.rebuildInGame_Festival(BuildingsManager.iBuildInProvinceID);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OrganizeAFestivalIn") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("Province")));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (float)((int)(Festival.festivalHappinessPerTurn(BuildingsManager.iBuildInProvinceID) * 10000.0f)) / 100.0f, CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NeighboringProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (float)((int)(Festival.festivalHappinessPerTurn_NeighboringProvinces() * 10000.0f)) / 100.0f, CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + Festival.festivalCost(BuildingsManager.iBuildInProvinceID), CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS / 10.0f, CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){

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
                if (Festival.addFestival(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr())) {
                    CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Festival"), CFG.core.getProv(this.getCurr()).getName(), Images.infoFestival);
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
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_Festival.getHoverFestival(this.getCurr());
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        tRow = (tRow + 1) % 2;
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        
        int nMax = 1;
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(BuildingsManager.iBuildInProvinceID, GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX)) {
            nMax = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX;
        } else {
            int i = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX - 1;
            while (i >= 5) {
                nMax = i--;
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(BuildingsManager.iBuildInProvinceID, nMax)) break;
            }
        }
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY, ButtonDiplomacy.iDiploWidth, buttonH, true){

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
        menuElements.add(new Button_Build_DiplomacyCost_Decrees(CFG.lang.get("Assimilate"), Images.diploStability, GameManager.assimilateCost(BuildingsManager.iBuildInProvinceID, nMax), GameValues.gvAssimilate.COST_ASSIMILATE_MOVEMENT, 0, tPosY, tempW, !CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied(), false, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isAssimilateOrganized_TurnsLeft(BuildingsManager.iBuildInProvinceID), 0.0f, CFG.lang.get("Stability") + ": ", "" + CFG.getPrecision2(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProviStability() * 100.0f, 10) + "%", Images.diploStability, (int)(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProviStability() * 100.0f) == 0 ? CFG.COLOR_PROVINCE_STABILITY_MAX : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProviStability() * 100.0f), 100, 1.0f)){

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isAssimilateOrganized(BuildingsManager.iBuildInProvinceID)) {
                    CFG.toastM.addM(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                } else {
                    CFG.menus.rebuildInGame_Assimilate(BuildingsManager.iBuildInProvinceID);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (!this.getIsClickable() && CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied()) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OccupiedProvince"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Assimilate") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("Province")));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
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
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + GameManager.assimilateCost(BuildingsManager.iBuildInProvinceID, 1), CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvAssimilate.COST_ASSIMILATE_MOVEMENT / 10.0f, CFG.COLOR_DIPLOMACY_POINTS));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvAssimilate.ASSIMILATE_HAPPINESS_CHANGE_PER_TURN * 100.0f, 100) + " " + CFG.lang.get("PerTurn"), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){

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
                int nMax = 1;
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
                    CFG.toastM.addM(CFG.lang.get("Assimilate") + ": " + CFG.core.getProv(this.getCurr()).getName(), CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Assimilate"), CFG.core.getProv(this.getCurr()).getName(), Images.infoStability);
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
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
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
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvAssimilate.ASSIMILATE_HAPPINESS_CHANGE_PER_TURN * 100.0f, 100) + " " + CFG.lang.get("PerTurn"), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        tRow = (tRow + 1) % 2;
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, buttonH, true){

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
        menuElements.add(new Button_Build_Decrees(CFG.lang.get("Invest"), Images.investEco, 0, GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS, 0, tPosY, tempW, true, false, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestOrganized_TurnsLeft(BuildingsManager.iBuildInProvinceID), 0.0f, CFG.lang.get("Economy") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getEco()), Images.economy, CFG.COLOR_ECONOMY){

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestOrganized_TurnsLeft(BuildingsManager.iBuildInProvinceID) > 0) {
                    CFG.toastM.addM(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                } else {
                    CFG.menus.rebuildInGame_Invest(BuildingsManager.iBuildInProvinceID);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestIn") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("Province")));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getEco()), CFG.COLOR_ECONOMY));
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
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.investEco).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investEco).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investEco).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void actionElem(int iID) {
                if (GameManager.invest(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), GameManager.invest_MaxEconomy_Gold(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))) {
                    CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest") + ": " + CFG.lang.get("Economy"), CFG.core.getProv(this.getCurr()).getName(), Images.infoEconomy);
                    CFG.gameAction.updateInGame_ProvinceInfo();
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewEconomy(true);
                        }
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE) {
                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewIncome(true);
                        }
                    }
                    CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_Invest.getHoverInvest(this.getCurr());
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        tRow = (tRow + 1) % 2;
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), ButtonDiplomacy.iDiploWidth, buttonH, true){

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
        menuElements.add(new Button_Build_Decrees(CFG.lang.get("Invest"), Images.investDev, 0, GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS, 0, tPosY, tempW, true, false, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestOrganized_TurnsLeft_Devel(BuildingsManager.iBuildInProvinceID), 0.0f, CFG.lang.get("Development") + ": ", "" + String.format("%.2f", Float.valueOf(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getDeveLvl())).replace(',', '.'), Images.development, CFG.COLOR_NEUTRAL2){

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestOrganized_TurnsLeft_Devel(BuildingsManager.iBuildInProvinceID) > 0) {
                    CFG.toastM.addM(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                } else {
                    CFG.menus.rebuildInGame_InvestDevelopment(BuildingsManager.iBuildInProvinceID);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestIn") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("Province")));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + String.format("%.2f", Float.valueOf(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getDeveLvl())).replace(',', '.'), CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" / "));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS / 10.0f, CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConstructionWillTakeXurns", GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_NUM_OF_TURNS)));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() - 0.01f <= CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getDeveLvl()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tech5"), CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tech5"), CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        menuElements.add(new Button_Build_Text(">>", tempW, tPosY, extraW, true, BuildingsManager.iBuildInProvinceID){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    IMGManager.getIMG(Images.investDev).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investDev).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investDev).getHeight() / 2 + iTranslateY);
                } else {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void actionElem(int iID) {
                if (GameManager.investDevelopment(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), GameManager.investMaxDevGold(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))) {
                    CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest") + ": " + CFG.lang.get("Development"), CFG.core.getProv(this.getCurr()).getName(), Images.infoDev);
                    CFG.gameAction.updateInGame_ProvinceInfo();
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewEconomy(true);
                        }
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE) {
                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewIncome(true);
                        }
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewDevelopment(true);
                        }
                    }
                    CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_Invest_Development.getHoverInvestDev(this.getCurr());
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
        tRow = (tRow + 1) % 2;
        menuElements.add(new Button_Build(CFG.lang.get("RelocatePopulation"), Images.pop, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW + extraW, true, false, 0, 0.0f){

            @Override
            public void actionElem(int iID) {
                Menu_InGame_RelocatePopulation.toProvinceID = -1;
                Menu_InGame_RelocatePopulation.relocate.clear();
                CFG.menus.rebuildInGame_Build_RelocatePopulation(BuildingsManager.iBuildInProvinceID);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RelocatePopulation"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RedistributeYourPopulation")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_Build(CFG.lang.get("ManageCoresAndClaims"), Images.core, 0, 0, 0, tPosY, tempW + extraW, true, false, 0, 0.0f){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuID(View.eINGAME);
                CFG.menus.rebuildInGame_Cores_Claims(BuildingsManager.iBuildInProvinceID);
                CFG.toastM.addM(CFG.lang.get("ManageCoresAndClaims"), CFG.COLOR_HOVER_TITLE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ManageCoresAndClaims"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.core, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ManageCoresAndClaimsDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                Province_Core cores = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCores();
                if (cores != null && cores.getCivsSize() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cores") + ": ", CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int c = 0; c < cores.getCivsSize(); ++c) {
                        nData.add(new ME_Hover_2Type_Flag(cores.getCivID(c), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(cores.getCivID(c)).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                Province_Claims claims = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getClaims();
                if (claims != null && claims.getCivsSize() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Claims") + ": ", CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int c = 0; c < claims.getCivsSize(); ++c) {
                        nData.add(new ME_Hover_2Type_Flag(claims.getCivID(c), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(claims.getCivID(c)).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied()) {
            menuElements.add(new Button_Build_DiplomacyCost(CFG.lang.get("TransferControl"), Images.transferControl, 0, GameValues.gvDipTransferControl.COST_TRANSFER_CONTROL_DIPLOMACY_POINTS, 0, tPosY, tempW + extraW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_TransferControl(BuildingsManager.iBuildInProvinceID);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TransferControlOverProvince") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("Province")));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDipTransferControl.COST_TRANSFER_CONTROL_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_DIPLOMACY_POINTS));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow);
            tRow = (tRow + 1) % 2;
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        tempW += extraW;
        if (ownProvince) {
            menuElements.add(new TextBuildTitle(CFG.lang.get("Army"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            menuElements.add(new Button_Build(CFG.lang.get("Conscript"), Images.diploArmy, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    if (BuildingsManager.iBuildInProvinceID >= 0) {
                        if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            CFG.core.setActiveProvID(BuildingsManager.iBuildInProvinceID);
                            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT) {
                                CFG.menus.setVisible_InGame_ActionInfo_NoMovementPoints();
                            } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)CFG.getCostOfRecruitArmyMoney_Instantly(BuildingsManager.iBuildInProvinceID)) {
                                CFG.menus.setVisible_InGame_ActionInfo_TreasuryIsEmpty();
                            } else {
                                CFG.core.resetChooseProvinceData();
                                CFG.menus.setVisible_InGame_ProvinceAction(false);
                                CFG.gameAction.updateRecruitSlider_Instantly();
                                CFG.menus.setVisible_InGame_ProvinceRecruitInstantly(true);
                                CFG.menus.setVisible_InGame_ActionInfo_RecruitInstantly();
                                Menu_InGame_Province_More.this.setVisibleM(false);
                            }
                        } else {
                            CFG.menus.setVisible_InGame_ActionInfo_RecruitOccupied();
                        }
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitArmyInstantly"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruitingWillBeDoubled"), CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OneUnitCostsXGold", CFG.getCostOfRecruitArmyMoney_Instantly(BuildingsManager.iBuildInProvinceID)), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT / 10.0f, CFG.COLOR_MOVEMENT));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public int getSFXElem() {
                    try {
                        return CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() ? super.getSFXElem() : SFXManager.SFX_RECRUIT;
                    }
                    catch (IndexOutOfBoundsException ex) {
                        return super.getSFXElem();
                    }
                }

                @Override
                public boolean getIsClickable() {
                    try {
                        if (BuildingsManager.iBuildInProvinceID >= 0) {
                            return CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        }
                        return super.getIsClickable();
                    }
                    catch (IndexOutOfBoundsException ex) {
                        return super.getIsClickable();
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
            menuElements.add(new Button_Build(CFG.lang.get("RecruitMercenaries"), Images.mercenaries, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

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
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            menuElements.add(new Button_Build(CFG.lang.get("DisbandArmy"), Images.diploArmyDisband, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_DISBAND) {
                        CFG.toastM.addM(CFG.lang.get("NoMovementPoints") + ".", CFG.COLOR_NEGATIVE_2);
                    } else {
                        CFG.core.resetChooseProvinceData();
                        CFG.menus.setVisible_InGame_ProvinceAction(false);
                        CFG.activeCivilizationArmyID = Math.max(0, CFG.gameAction.getControlledArmyIDInProvince(BuildingsManager.iBuildInProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        CFG.gameAction.updateDisbandSlider();
                        CFG.menus.setVisible_InGame_ProvinceDisband(true);
                        CFG.menus.setVisible_InGame_ActionInfo_Disband();
                        CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DisbandArmy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    long controlledArmy = CFG.gameAction.getControlledArmySizeInProvince(BuildingsManager.iBuildInProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (controlledArmy > 0L) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Army") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + controlledArmy, CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NoUnits"), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_DISBAND / 10.0f, CFG.COLOR_MOVEMENT));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public boolean getIsClickable() {
                    return !CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).civGD.sandboxNoDisband && CFG.gameAction.getControlledArmySizeInProvince(BuildingsManager.iBuildInProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0L;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            menuElements.add(new Button_Build(CFG.lang.get("Plunder"), Images.diploPlunder, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isPlundred(BuildingsManager.iBuildInProvinceID) ? 1 : 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_Plunder(BuildingsManager.iBuildInProvinceID);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied()) {
                        if (CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Plunder") + ": ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getTrueOwnerOfProv()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Plunder"), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OccupiedProvince")));
                        nData.add(new ME_Hover_2Type_Image(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied() ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_PLUNDER / 10.0f, CFG.COLOR_MOVEMENT));
                        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OnlyOccupiedProvinceCanBePlundered"), CFG.COLOR_NEGATIVE_2));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public boolean getIsClickable() {
                    return CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            menuElements.add(new Button_Build(CFG.lang.get("RegroupArmies") + ": " + CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProvName(), Images.diploArmyMove, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_RegroupArmies(BuildingsManager.iBuildInProvinceID);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RegroupArmies") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
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
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            menuElements.add(new Button_Build(CFG.lang.get("SendVolunteerArmy"), Images.diploArmySend, 0, 0, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_SendArmy.toProvinceID = -1;
                    CFG.menus.rebuildInGame_SendArmy(BuildingsManager.iBuildInProvinceID);
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
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ++row;
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
            menuElements.add(new TextBuildTitle(CFG.lang.get("Decrees") + ": " + CFG.lang.get("AllProvinces"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            int tempElemH = CFG.BUTTON_H;
            menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.assimilateAllProvinces_CostDiplomacy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topDiplomacyPoints, CFG.COLOR_DIPLOMACY_POINTS, Images.diploStability, CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f), 100, 1.0f), 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - 2 - extraW, tempElemH){

                @Override
                public void actionElem(int iID) {
                    CFG.setDialogType(DialogType.ALL_ASSIMILATE);
                }

                @Override
                public void actionElemPPM() {
                    CFG.assimilateAll();
                }
            });
            menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW, tempElemH, true, BuildingsManager.iBuildInProvinceID){

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
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
            menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.investEconomyAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.investEconomyAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.investEconomyAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.investEco, CFG.COLOR_ECONOMY, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - extraW - 2, tempElemH){

                @Override
                public void actionElem(int iID) {
                    CFG.setDialogType(DialogType.ALL_INVEST_ECO);
                }

                @Override
                public void actionElemPPM() {
                    CFG.investAllEconomy();
                }
            });
            menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW, tempElemH, true, BuildingsManager.iBuildInProvinceID){

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
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
            menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.investDevAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.investDevAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.investDevAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.investDev, CFG.COLOR_DEVELOPMENT, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - extraW - 2, tempElemH){

                @Override
                public void actionElem(int iID) {
                    CFG.setDialogType(DialogType.ALL_INVEST_DEV);
                }

                @Override
                public void actionElemPPM() {
                    CFG.investAllDevelopment();
                }
            });
            menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW, tempElemH, true, BuildingsManager.iBuildInProvinceID){

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
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
            menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.festivalAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.festivalAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.festivalAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.diploFestival, CFG.COLOR_TEXT_HAPPINESS_ACTIVE, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - extraW - 2, tempElemH){

                @Override
                public void actionElem(int iID) {
                    CFG.setDialogType(DialogType.ALL_INVEST_FESTIVAL);
                }

                @Override
                public void actionElemPPM() {
                    CFG.festivalAll();
                }
            });
            menuElements.add(new Button_Build_Text(">>", tempW - 2 - extraW, tPosY, extraW, tempElemH, true, BuildingsManager.iBuildInProvinceID){

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
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 2)).setCurr(row % 2);
            ++row;
            menuElements.add(new TextBuildTitle(CFG.lang.get("AtomicBomb"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            try {
                menuElements.add(new Button_Build(CFG.lang.get("BuildAnAtomicBomb"), Images.nuke, 0, 0, 0, tPosY, tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_Build_Nuke();
                    }

                    @Override
                    public void buildElemHover() {
                        this.menuElemHover = NukeManager.getHoverNuke();
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            menuElements.add(new TextBuildTitle(CFG.lang.get("Province"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            try {
                menuElements.add(new Button_Build(CFG.lang.get("Abandon"), Images.provinces, 0, 0, 0, tPosY, tempW, BuildingsManager.iBuildInProvinceID != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() && !CFG.core.getProv(BuildingsManager.iBuildInProvinceID).isOccupied(), false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        if (BuildingsManager.iBuildInProvinceID >= 0) {
                            CFG.menus.rebuildInGame_Abadon(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), BuildingsManager.iBuildInProvinceID);
                        }
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_Province_More.this.getPosX() + iTranslateX, Menu_InGame_Province_More.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_Province_More.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                int civID = CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getCivId();
                oSB.setColor(new Color((float)CFG.core.getCiv(civID).getR() / 255.0f, (float)CFG.core.getCiv(civID).getG() / 255.0f, (float)CFG.core.getCiv(civID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(civID).getR() / 255.0f, (float)CFG.core.getCiv(civID).getG() / 255.0f, (float)CFG.core.getCiv(civID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_Province_More.this.getPosX() + iTranslateX, Menu_InGame_Province_More.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_Province_More.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_Province_More.this.getPosX() + iTranslateX, Menu_InGame_Province_More.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_Province_More.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_Province_More.this.getPosX() + Menu_InGame_Province_More.this.getWidthM() - Menu_InGame_Province_More.this.getWidthM() / 4 + iTranslateX, Menu_InGame_Province_More.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_Province_More.this.getWidthM() / 4, 1, true, false);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_InGame_Province_More.this.getPosX() + iTranslateX, Menu_InGame_Province_More.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                }
                oSB.setColor(Color.WHITE);
                Core.drawFlagRect(oSB, Menu_InGame_Province_More.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Province_More.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2, civID);
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
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName().length() > 0 ? CFG.core.getProv(BuildingsManager.iBuildInProvinceID).getName() : CFG.lang.get("More"));
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

    public static boolean quickBuild(int provinceID, ConstructionType constructionType) {
        int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        boolean built = false;
        if (constructionType == ConstructionType.FORT) built = BuildingsManager.constructFort(provinceID, civID);
        else if (constructionType == ConstructionType.AIR_DEFENSE) built = BuildingsManager.constructAirDefense(provinceID, civID);
        else if (constructionType == ConstructionType.TOWER) built = BuildingsManager.constructTower(provinceID, civID);
        else if (constructionType == ConstructionType.PORT) built = BuildingsManager.constructPort(provinceID, civID);
        else if (constructionType == ConstructionType.FARM) built = BuildingsManager.constructFarm(provinceID, civID);
        else if (constructionType == ConstructionType.WORKSHOP) built = BuildingsManager.constructWorkshop(provinceID, civID);
        else if (constructionType == ConstructionType.MARKET) built = BuildingsManager.constructMarket(provinceID, civID);
        else if (constructionType == ConstructionType.LIBRARY) built = BuildingsManager.constructLibrary(provinceID, civID);
        else if (constructionType == ConstructionType.ARMOURY) built = BuildingsManager.constructArmoury(provinceID, civID);
        else if (constructionType == ConstructionType.SUPPLY) built = BuildingsManager.constructSupply(provinceID, civID);

        if (built) {
            CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(3500);
            CFG.gameAction.updateInGame_ProvinceInfo();
            CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ARMY_MODE) {
                CFG.updateMAX_Army();
            }
        }
        CFG.menus.updateInGameTopAll(civID);
        return built;
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

