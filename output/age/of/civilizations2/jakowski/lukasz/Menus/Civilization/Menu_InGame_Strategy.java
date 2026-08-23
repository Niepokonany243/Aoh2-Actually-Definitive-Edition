
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.*;
import age.of.civilizations2.jakowski.lukasz.Button.*;
import age.of.civilizations2.jakowski.lukasz.Button.Game.*;
import age.of.civilizations2.jakowski.lukasz.Button2.*;
import age.of.civilizations2.jakowski.lukasz.Sliders.*;
import age.of.civilizations2.jakowski.lukasz.Title.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Strategy extends Menu {
    public static boolean mobilizationExpanded = false;
    public Menu_InGame_Strategy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int fixedStrategyWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.5f);
        int tempWidth = Math.min(CFG.GAMEWIDTH - CFG.PADD * 4, fixedStrategyWidth);
        int tY = CFG.PADD;
        final Civilization civ = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());

        if (civ.civGD == null) {
            this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
            return;
        }

        menuElements.add(new Text_Static("-------------------", -1, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        if (MilitaryRealism.isEnabled()) {
            String currName = civ.civGD.mobilizationManualLevel <= 0 ? "Auto" : GameValues.gvMilitaryRealism.MOBILIZATION_NAME[civ.civGD.mobilizationManualLevel - 1];
            menuElements.add(new Button_Game_Checkbox("Mobilisation: " + currName, CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, Menu_InGame_Strategy.mobilizationExpanded) {
                @Override
                public void actionElem(int iID) {
                    Menu_InGame_Strategy.mobilizationExpanded = !Menu_InGame_Strategy.mobilizationExpanded;
                    CFG.menus.rebuildInGame_Strategy();
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    try {
                        int civID = civ.getCivId();
                        nData.add(new ME_Hover_2Type_Text_Big("Mobilisation", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(civID, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Level: "));
                        nData.add(new ME_Hover_2Type_Text(MilitaryRealism.getMobilizationName(civID), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Mode: "));
                        nData.add(new ME_Hover_2Type_Text(MilitaryRealism.getManualMobilizationName(civID), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Recruit: "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(MilitaryRealism.getRecruitCostFactor(civID) * 100.0f) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Upkeep: "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(MilitaryRealism.getMilitaryUpkeepFactor(civID) * 100.0f) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        float atk = MilitaryRealism.getAttackBonusPercent(civID);
                        float def = MilitaryRealism.getDefenseBonusPercent(civID);
                        nData.add(new ME_Hover_2Type_Text("Attack: "));
                        nData.add(new ME_Hover_2Type_Text((atk >= 0.0f ? "+" : "") + CFG.getPrecision2(atk, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Defense: "));
                        nData.add(new ME_Hover_2Type_Text((def >= 0.0f ? "+" : "") + CFG.getPrecision2(def, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text("Army: "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(civID).getNumberOfUnits()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                        this.menuElemHover = null;
                    }
                }
            });
            tY += CFG.BUTTON_H + CFG.PADD;

            if (Menu_InGame_Strategy.mobilizationExpanded) {
                for (int mi = -1; mi < GameValues.gvMilitaryRealism.MOBILIZATION_NAME.length; ++mi) {
                    final int mobIdx = mi;
                    int currManual = civ.civGD.mobilizationManualLevel;
                    boolean isSelected = mobIdx < 0 ? currManual == 0 : currManual == mobIdx + 1;
                    float rCost = mobIdx < 0 ? 1.0f : (mobIdx < GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST.length ? GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST[mobIdx] : 1.0f);
                    float upkeep = mobIdx < 0 ? 1.0f : (mobIdx < GameValues.gvMilitaryRealism.MOBILIZATION_UPKEEP.length ? GameValues.gvMilitaryRealism.MOBILIZATION_UPKEEP[mobIdx] : 1.0f);
                    float atk = mobIdx < 0 ? 0.0f : (mobIdx < GameValues.gvMilitaryRealism.MOBILIZATION_ATTACK_BONUS.length ? GameValues.gvMilitaryRealism.MOBILIZATION_ATTACK_BONUS[mobIdx] : 0.0f);
                    float def = mobIdx < 0 ? 0.0f : (mobIdx < GameValues.gvMilitaryRealism.MOBILIZATION_DEFENSE_BONUS.length ? GameValues.gvMilitaryRealism.MOBILIZATION_DEFENSE_BONUS[mobIdx] : 0.0f);
                    String label = mobIdx < 0 ? "Auto" : GameValues.gvMilitaryRealism.MOBILIZATION_NAME[mobIdx];
                    menuElements.add(new Button_Game_Checkbox(label, CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, isSelected) {
                        @Override
                        public void actionElem(int iID) {
                            MilitaryRealism.setManualMobilization(civ.getCivId(), mobIdx);
                            Menu_InGame_Strategy.mobilizationExpanded = false;
                            CFG.menus.rebuildInGame_Strategy();
                        }
                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            try {
                                nData.add(new ME_Hover_2Type_Text_Big(label, CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text("Recruit: "));
                                nData.add(new ME_Hover_2Type_Text("" + (int)(rCost * 100.0f) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text("Upkeep: "));
                                nData.add(new ME_Hover_2Type_Text("" + (int)(upkeep * 100.0f) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text("Attack: "));
                                nData.add(new ME_Hover_2Type_Text((atk >= 0.0f ? "+" : "") + CFG.getPrecision2(atk, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text("Defense: "));
                                nData.add(new ME_Hover_2Type_Text((def >= 0.0f ? "+" : "") + CFG.getPrecision2(def, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text("Demobilization: "));
                                nData.add(new ME_Hover_2Type_Text("" + GameValues.gvMilitaryRealism.DEMOBILIZATION_TURNS + " " + CFG.lang.get("Turns"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                                this.menuElemHover = null;
                            }
                        }
                    });
                    tY += CFG.BUTTON_H + CFG.PADD / 2;
                }
            }
        }

        
        menuElements.add(new Button_Game_Checkbox("Auto-Assimilation", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoAssimilation) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoAssimilation = !civ.civGD.autoAssimilation; 
                this.setCheckboxSt(civ.civGD.autoAssimilation);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Happiness", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoHappiness) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoHappiness = !civ.civGD.autoHappiness; 
                this.setCheckboxSt(civ.civGD.autoHappiness);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Investment", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoInvest) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoInvest = !civ.civGD.autoInvest; 
                this.setCheckboxSt(civ.civGD.autoInvest);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Building", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoBuild) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoBuild = !civ.civGD.autoBuild; 
                this.setCheckboxSt(civ.civGD.autoBuild);
                CFG.menus.rebuildInGame_Strategy(); 
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        if (civ.civGD.autoBuild) {
            int subW = (fixedStrategyWidth - CFG.PADD * 4) / 4;
            menuElements.add(new Button_Game_Checkbox("Farm", CFG.PADD, CFG.PADD, tY, subW, true, civ.civGD.autoBuild_Farm) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Farm = !civ.civGD.autoBuild_Farm; this.setCheckboxSt(civ.civGD.autoBuild_Farm); }
            });
            menuElements.add(new Button_Game_Checkbox("Workshop", CFG.PADD, CFG.PADD + subW + CFG.PADD, tY, subW, true, civ.civGD.autoBuild_Workshop) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Workshop = !civ.civGD.autoBuild_Workshop; this.setCheckboxSt(civ.civGD.autoBuild_Workshop); }
            });
            menuElements.add(new Button_Game_Checkbox("Library", CFG.PADD, CFG.PADD + (subW + CFG.PADD) * 2, tY, subW, true, civ.civGD.autoBuild_Library) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Library = !civ.civGD.autoBuild_Library; this.setCheckboxSt(civ.civGD.autoBuild_Library); }
            });
            menuElements.add(new Button_Game_Checkbox("Port", CFG.PADD, CFG.PADD + (subW + CFG.PADD) * 3, tY, subW, true, civ.civGD.autoBuild_Port) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Port = !civ.civGD.autoBuild_Port; this.setCheckboxSt(civ.civGD.autoBuild_Port); }
            });
            tY += CFG.BUTTON_H + CFG.PADD;

            menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, civ.civGD.autoBuildTurns) {
                @Override
                public void updateSlider(int nX) {
                    super.updateSlider(nX);
                    civ.civGD.autoBuildTurns = this.getCurr();
                }
                @Override
                public String getDrawText() { return CFG.lang.get("Turns") + ": " + this.getCurr(); }
            });
            tY += CFG.BUTTON_H / 2 + CFG.PADD;
        }

        menuElements.add(new Text_Static("---------", -1, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        
        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoHappinessMaxMoney * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessMaxMoney = (float)this.getCurr() / 100.0f;
                civ.civGD.autoInvestMaxMoney = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Max Budget Share: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, civ.civGD.autoHappinessTurns) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessTurns = this.getCurr();
                civ.civGD.autoInvestTurns = this.getCurr();
            }
            @Override
            public String getDrawText() { return "Check Interval: " + this.getCurr() + " Turns"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoHappinessThreshold * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessThreshold = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Happiness Threshold: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;


        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoAssimilationThreshold * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoAssimilationThreshold = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Stability Threshold: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("Strategy"), CFG.BUTTON_H * 4 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, tY + CFG.PADD, menuElements, true, true);
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(0.1f, 0.1f, 0.1f, 0.75f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), false, false, false);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }
}