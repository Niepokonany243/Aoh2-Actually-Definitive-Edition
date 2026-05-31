
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonN_ArmyExpertise;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonN_Exp;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRightTop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Army;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_InGameProvAction;
import age.of.civilizations2.jakowski.lukasz.Menus.Merce.Menu_InGame_Mercenaries;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Army.Menu_InGame_SendArmy;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Army
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;
    public int provinceID = 0;

    public static final int getButtonHeight() {
        return (int)(CFG.isAndroid() ? Math.max((float)CFG.BUTTON_H * 0.8f, (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6)) : Math.max((float)CFG.BUTTON_H * 0.8f, (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6)));
    }

    public Menu_InGame_View_Army() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        int graphElementID = 1;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        try {
            int i;
            this.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            menuElements.add(new ButtonN_ArmyExpertise(this.iCivID, 0, tY, tempW, CFG.BUTTON_H * 4 / 5, ""){

                @Override
                public void actionElem(int iID) {
                    if (CFG.menus.getVisibleInGame_Technology()) {
                        CFG.menus.setVisibleInGame_Technology(false);
                    } else {
                        CFG.menus.rebuildInGame_MilitaryExp(Menu_InGame_View_Army.this.iCivID);
                    }
                }
            });
            menuElements.add(new ButtonN_Exp(this.iCivID, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public void actionElem(int iID) {
                    if (CFG.menus.getVisibleInGame_Technology()) {
                        CFG.menus.setVisibleInGame_Technology(false);
                    } else {
                        CFG.menus.rebuildInGame_MilitaryExp(Menu_InGame_View_Army.this.iCivID);
                    }
                }
            });
            menuElements.add(new ButtonN_Pop_TextRightTop(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(this.iCivID).getCivName(), this.iCivID, CFG.lang.get("DeathsInAllWars") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.ttWC), Images.skull, CFG.core.getCiv((int)this.iCivID).civGD.ttWC > 0L ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).getNumberOfUnits()), Images.diploArmy){

                @Override
                public Color getColorRight() {
                    return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).getNumberOfUnits()), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DeathsInAllWars") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.ttWC), CFG.core.getCiv((int)this.iCivID).civGD.ttWC > 0L ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception e) {
                        this.menuElemHover = null;
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + (GameValues.gvInGame.VIEW_ARMY_ADD_GRAPH ? 2 : 0);
            if (GameValues.gvInGame.VIEW_ARMY_ADD_GRAPH) {
                menuElements.add(new Graph2("A", "B", 0, tY, tempW - 2, CFG.BUTTON_H, true, 1, CFG.oR.nextInt(100) < 50 ? Graph2.GraphType.PLAYER_ARMY_SIZE : Graph2.GraphType.PLAYER_MILITARY_SPENDING, false, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), true){

                    @Override
                    public int getGraphWidth() {
                        return this.getWidthE() - 4;
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_ARMY_SIZE, CFG.PLAYER_TURN_ID));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) + "%", CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_MILITARY_SPENDING, CFG.PLAYER_TURN_ID));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }

                    @Override
                    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                        try {
                            int imgID = Images.diploArmy;
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.05f));
                            IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - IMGManager.getIMG(imgID).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(imgID).getHeight() + iTranslateY);
                        }
                        catch (Exception exception) {
                            
                        }
                        oSB.setColor(Color.WHITE);
                    }
                });
                graphElementID = menuElements.size() - 1;
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + 2;
            }
            if (GameValues.gvInGame.ARMY_CONTROLLED_BY_AI_ENABLE_BUTTON) {
                menuElements.add(new Button_CNG_Options2(CFG.lang.get("ArmyControlledByAI") + ": " + (CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.PADD * 2, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, true, CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI){

                    @Override
                    public boolean getCheckboxSt() {
                        return CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI;
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = !CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI;
                        this.setTextE(CFG.lang.get("ArmyControlledByAI") + ": " + (CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI ? CFG.lang.get("On") : CFG.lang.get("Off")));
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ArmyControlledByAI") + " + " + CFG.lang.get("RecruitArmy") + ": " + (CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (GameValues.gvInGame.RECRUIT_AND_COUNTERATTACK_ENABLE_BUTTON) {
                menuElements.add(new Button_CNG_Options2(CFG.lang.get("RecruitAndCounterattack") + ": " + (CFG.RECRUIT_AND_COUNTERATTACK ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.PADD * 2, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, true, CFG.RECRUIT_AND_COUNTERATTACK){

                    @Override
                    public boolean getCheckboxSt() {
                        return CFG.RECRUIT_AND_COUNTERATTACK;
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.RECRUIT_AND_COUNTERATTACK = !CFG.RECRUIT_AND_COUNTERATTACK;
                        this.setTextE(CFG.lang.get("RecruitAndCounterattack") + ": " + (CFG.RECRUIT_AND_COUNTERATTACK ? CFG.lang.get("On") : CFG.lang.get("Off")));
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitAndCounterattack") + ": " + (CFG.RECRUIT_AND_COUNTERATTACK ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RecruitsUnitsThatCanImmediatelyAttackDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            try {
                this.provinceID = CFG.core.getActiveProvID();
                int buttonH = CFG.BUTTON_H * 4 / 5;
                int row = 0;
                menuElements.add(new Button_Build(CFG.lang.get("RecruitMercenaries"), Images.mercenaries, 0, 0, 0, tY, tempW, true, false, 0, 0.0f){

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
                menuElements.add(new Button_Build(CFG.lang.get("MassRecruit"), Images.diploArmy, 0, 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        try {
                            if (CFG.core.getActiveProvID() >= 0) {
                                Menu_InGameProvAction.clickRecruit();
                                if (!Core.AMRCT.isEmpty()) {
                                    for (int i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvincesSize(); ++i) {
                                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(i)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(i)).isOccupied() || Core.ISIP(CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(i))) continue;
                                        Core.MRPRV(CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(i));
                                    }
                                    CFG.gameAction.IEU();
                                    Core.dARA(CFG.menus.getInGame_ProvRecruitSlider().getCurr());
                                    CFG.menus.updateInGame_ActionInfo_Recruit();
                                }
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MassRecruit"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MassRecruitDesc")));
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
                menuElements.add(new Button_Build(CFG.lang.get("RegroupArmies"), Images.diploArmy, 0, 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        int toProvinceID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getActiveProvID() : Menu_InGame_View_Army.this.provinceID;
                        CFG.menus.rebuildInGame_RegroupArmies(toProvinceID);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        int toProvinceID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getActiveProvID() : Menu_InGame_View_Army.this.provinceID;
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RegroupArmies") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(toProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
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
                menuElements.add(new Button_Build(CFG.lang.get("CancelAllArmyMovements"), Images.iconFalse, 0, 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

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
                menuElements.add(new Button_Build(CFG.lang.get("MoveToFrontLine"), Images.frontline, 0, 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        try {
                            CFG.LPHE.clear();
                            if (TouchManager.lMABX.size() > 1) {
                                for (int c = 0; c < TouchManager.lMABX.size(); ++c) {
                                    CFG.LPHE.add(TouchManager.lMABX.get(c));
                                }
                                CFG.OUDH = 0;
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("MoveToFrontLine"), CFG.lang.get("ChooseAProvince"), Images.infoDiplomacy);
                            } else if (CFG.core.getActiveProvID() < 0) {
                                CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                            } else if (CFG.core.getProv(CFG.core.getActiveProvID()).getArmyCivID1(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) <= 0) {
                                CFG.toastM.addM(CFG.lang.get("Army") + ": 0 - " + CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                            } else {
                                CFG.LPHE.add(CFG.core.getActiveProvID());
                                CFG.OUDH = 0;
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("MoveToFrontLine"), CFG.lang.get("ChooseAProvince"), Images.infoDiplomacy);
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        int toProvinceID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getActiveProvID() : Menu_InGame_View_Army.this.provinceID;
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MoveToFrontLine") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SelectCivilization"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.frontline, CFG.PADD, 0));
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
                menuElements.add(new Button_Build(CFG.lang.get("SendVolunteerArmy"), Images.diploArmy, 0, 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, true, false, 0, 0.0f){

                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_SendArmy.toProvinceID = -1;
                        int toProvinceID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getActiveProvID() : Menu_InGame_View_Army.this.provinceID;
                        CFG.menus.rebuildInGame_SendArmy(toProvinceID);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendVolunteerArmy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SendVolunteerArmyText")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        int toProvinceID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getActiveProvID() : Menu_InGame_View_Army.this.provinceID;
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(toProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(toProvinceID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++row % 2);
                ++row;
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
            ArrayList<Integer> tempProvs = new ArrayList<Integer>();
            for (i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getArmyCivID1(this.iCivID) <= 0) continue;
                tempProvs.add(CFG.core.getCiv(this.iCivID).getProvID(i));
            }
            for (i = 0; i < CFG.core.getCiv(this.iCivID).getArmyInAnotherProvinceSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getArmyInAnotherProviP(i)).getArmyCivID1(this.iCivID) <= 0) continue;
                tempProvs.add(CFG.core.getCiv(this.iCivID).getArmyInAnotherProviP(i));
            }
            for (i = 0; i < CFG.core.getCiv(this.iCivID).moveUnitsSize(); ++i) {
                if (CFG.core.getCiv(this.iCivID).getMoveUnits(i).getNumberOfUnits() <= 0 || tempProvs.contains(CFG.core.getCiv(this.iCivID).getMoveUnits(i).getFromProviID())) continue;
                tempProvs.add(CFG.core.getCiv(this.iCivID).getMoveUnits(i).getFromProviID());
            }
            while (!tempProvs.isEmpty()) {
                int tBest = 0;
                for (int i2 = 1; i2 < tempProvs.size(); ++i2) {
                    if (CFG.core.getProv((Integer)tempProvs.get(tBest)).getArmyCivID1(this.iCivID) + CFG.core.getCiv(this.iCivID).getMoveUnits_NumFromProvince((Integer)tempProvs.get(tBest)) >= CFG.core.getProv((Integer)tempProvs.get(i2)).getArmyCivID1(this.iCivID) + CFG.core.getCiv(this.iCivID).getMoveUnits_NumFromProvince((Integer)tempProvs.get(i2))) continue;
                    tBest = i2;
                }
                tempProvincesSorted.add((Integer)tempProvs.get(tBest));
                tempProvs.remove(tBest);
            }
            if (!tempProvincesSorted.isEmpty()) {
                for (i = 0; i < tempProvincesSorted.size(); ++i) {
                    menuElements.add(new Button_View_Army(i, i + 1 + ". " + (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(this.iCivID).getCivName()), (Integer)tempProvincesSorted.get(i), this.iCivID, (int)CFG.gameUpdate.getMilitaryUpkeep_PlusMoveUnits((Integer)tempProvincesSorted.get(i), this.iCivID), 0, tY, CFG.CIV_INFO_MENU_WIDTH){

                        @Override
                        public void actionElem(int iID) {
                            CFG.core.setActiveProvID(this.getCurr());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            } else {
                menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Army.this.getPosX() + iTranslateX, Menu_InGame_View_Army.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Army.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Army.this.getPosX() + iTranslateX, Menu_InGame_View_Army.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Army.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Army.this.getPosX() + iTranslateX, Menu_InGame_View_Army.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Army.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Army.this.getPosX() + iTranslateX, Menu_InGame_View_Army.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Army.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Army.this.getPosX() + iTranslateX, Menu_InGame_View_Army.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Army.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Army.this.getPosX() + Menu_InGame_View_Army.this.getWidthM() - Menu_InGame_View_Army.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Army.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Army.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.diploArmy).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_Army.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
        this.getMenuElem(graphElementID).setWidthE(tempW + CFG.PADD - 2);
    }

    @Override
    public void updateLang() {
        try {
            this.getTitleM().setText(CFG.lang.get("Army"));
        }
        catch (IndexOutOfBoundsException ex) {
            this.getTitleM().setText(CFG.lang.get("Army"));
        }
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

    public static ME_Hover_v2 getHoverArmyExpertise(int civID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MilitaryExpertise") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv((int)civID).civGD.armyExpertiseLevel, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text_Big(" / "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Max") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + GameValues.gvMilitary.MILITARY_EXPERTISE_MAX_LEVEL), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmyStar, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Flag_Big(civID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Attack") + ": "));
        nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)civID).civGD.armyExpertiseAttack > 0 ? "+" : "") + CFG.getPrecision2(GameValues.gvMilitary.MILITARY_EXPERTISE_ATTACK_PER_POINT * (float)CFG.core.getCiv((int)civID).civGD.armyExpertiseAttack, 100) + "%", CFG.core.getCiv((int)civID).civGD.armyExpertiseAttack > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.attack, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Defense") + ": "));
        nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)civID).civGD.armyExpertiseDefense > 0 ? "+" : "") + CFG.getPrecision2(GameValues.gvMilitary.MILITARY_EXPERTISE_DEFENSE_PER_POINT * (float)CFG.core.getCiv((int)civID).civGD.armyExpertiseDefense, 100) + "%", CFG.core.getCiv((int)civID).civGD.armyExpertiseDefense > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.defense, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MilitaryExpertiseDesc"), CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ArmyExperience") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(CFG.core.getCiv((int)civID).civGD.armyExperience, 10), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text_Big(" / "));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.armyExperienceRequired(civID), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmyStar, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MilitaryExperienceDesc"), CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
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


