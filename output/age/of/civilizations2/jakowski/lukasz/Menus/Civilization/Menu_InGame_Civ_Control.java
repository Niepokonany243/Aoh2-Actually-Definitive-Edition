package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Static;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Civ_Control extends Menu {
    private final int civID;
    private Slider[] spendingSliders = new Slider[6];
    private boolean isRebalancing = false;

    public Menu_InGame_Civ_Control(final int civID) {
        this.civID = civID;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        final Civilization civ = CFG.core.getCiv(civID);
        int fixedControlWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.9f);
        int tempWidth = Math.min(CFG.GAMEWIDTH - CFG.PADD * 4, fixedControlWidth);
        final int contentX = CFG.PADD;
        final int contentW = fixedControlWidth - CFG.PADD * 2;
        final int colGap = CFG.PADD;
        final int colW = (contentW - colGap) / 2;
        final int col2X = contentX + colW + colGap;
        int tY = CFG.PADD;

        menuElements.add(new Text_Static(civ.getCivName(), -1, contentX, tY, contentW, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        long income = CFG.gameUpdate.getIncome(civID);
        long expenses = (long)CFG.gameUpdate.getExpenses(civID);
        long netIncome = income - expenses;
        long militaryUpkeep = (long)CFG.gameUpdate.getMilitaryUpkeep_Total(civID);
        int milPerc = income > 0 ? (int)(militaryUpkeep * 100L / income) : 0;
        String incomeText = (income >= 0 ? "+" : "") + CFG.getNumberWthSpaces("" + income);
        String netText = (netIncome >= 0 ? "+" : "") + CFG.getNumberWthSpaces("" + netIncome);
        String goldText = CFG.getNumberWthSpaces("" + civ.getGold());
        menuElements.add(new Text_Static("Gold: " + goldText + "    Net: " + netText + "    Mil: " + milPerc + "%", -1, contentX, tY, contentW, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int target = civ.civGD.sandboxMilitarySpendTarget > 0.0f ? (int)(civ.civGD.sandboxMilitarySpendTarget * 100.0f) : (int)(civ.civGD.civPers.MIN_MILITARY_SPENDINGS * 100.0f);
        menuElements.add(new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 250, Math.min(250, target)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                civ.civGD.sandboxMilitarySpendTarget = (float)this.getCurr() / 100.0f;
            }

            @Override
            public String getDrawText() {
                if (civ.civGD.sandboxMilitarySpendInfinite) return "Military target: Infinite";
                if (civ.civGD.sandboxMilitarySpendTarget <= 0.0f) return "Military target: AI default (move to override)";
                return "Military target: " + this.getCurr() + "%";
            }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Infinite military", CFG.PADD, contentX, tY, colW, true, civ.civGD.sandboxMilitarySpendInfinite) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.sandboxMilitarySpendInfinite = !civ.civGD.sandboxMilitarySpendInfinite;
                if (civ.civGD.sandboxMilitarySpendInfinite && civ.civGD.sandboxMilitarySpendTarget <= 0.0f) {
                    civ.civGD.sandboxMilitarySpendTarget = 2.5f;
                }
                this.setCheckboxSt(civ.civGD.sandboxMilitarySpendInfinite);
            }
        });

        menuElements.add(new Button_Game_Checkbox("Militarise", CFG.PADD, col2X, tY, colW, true, civ.civGD.sandboxMilitarise) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.sandboxMilitarise = !civ.civGD.sandboxMilitarise;
                if (civ.civGD.sandboxMilitarise && civ.civGD.sandboxMilitarySpendTarget <= 0.0f) {
                    civ.civGD.sandboxMilitarySpendTarget = 1.0f;
                }
                this.setCheckboxSt(civ.civGD.sandboxMilitarise);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-invest", CFG.PADD, contentX, tY, colW, true, civ.civGD.autoInvest) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.autoInvest = !civ.civGD.autoInvest;
                civ.civGD.autoInvestTurns = 1;
                civ.civGD.autoInvestMaxMoney = 1.0f;
                this.setCheckboxSt(civ.civGD.autoInvest);
            }
        });

        menuElements.add(new Button_Game_Checkbox("Auto-build", CFG.PADD, col2X, tY, colW, true, civ.civGD.autoBuild) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.autoBuild = !civ.civGD.autoBuild;
                civ.civGD.autoBuildTurns = 1;
                this.setCheckboxSt(civ.civGD.autoBuild);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Build while at war", CFG.PADD, contentX, tY, colW, true, civ.civGD.sandboxBuildAtWar) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.sandboxBuildAtWar = !civ.civGD.sandboxBuildAtWar;
                this.setCheckboxSt(civ.civGD.sandboxBuildAtWar);
            }
        });

        menuElements.add(new Button_Game_Checkbox("Disable disband", CFG.PADD, col2X, tY, colW, true, civ.civGD.sandboxNoDisband) {
            @Override
            public void actionElem(int iID) {
                civ.civGD.sandboxNoDisband = !civ.civGD.sandboxNoDisband;
                civ.civGD.aiNoDisbandUntilTurnID = civ.civGD.sandboxNoDisband ? Integer.MAX_VALUE : GameCalendar.TURNID;
                this.setCheckboxSt(civ.civGD.sandboxNoDisband);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        
        final int[] spendingIncome = new int[]{Math.max(1, (int)CFG.gameUpdate.getIncome(civID))};

        int goodsTarget = civ.civGD.sandboxGoodsSpendTarget > 0.0f ? Math.max(0, Math.min(100, (int)(civ.civGD.sandboxGoodsSpendTarget * 100.0f))) : 0;
        Slider goodsSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, goodsTarget) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                civ.civGD.sandboxGoodsSpendTarget = this.getCurr() > 0 ? (float)this.getCurr() / 100.0f : -1.0f;
                if (civ.civGD.sandboxGoodsSpendTarget >= 0.0f) {
                    civ.setSpendingGoodsB(civ.civGD.sandboxGoodsSpendTarget);
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Goods: AI default/off" : "Goods: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(goodsSlider);
        spendingSliders[0] = goodsSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int researchTarget = civ.civGD.sandboxResearchSpendTarget > 0.0f ? Math.max(0, Math.min(100, (int)(civ.civGD.sandboxResearchSpendTarget * 100.0f))) : 0;
        Slider researchSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, researchTarget) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                civ.civGD.sandboxResearchSpendTarget = this.getCurr() > 0 ? (float)this.getCurr() / 100.0f : -1.0f;
                if (civ.civGD.sandboxResearchSpendTarget >= 0.0f) {
                    civ.setSpendingResearchB(civ.civGD.sandboxResearchSpendTarget);
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Research: AI default/off" : "Research: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(researchSlider);
        spendingSliders[1] = researchSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int investmentsTarget = civ.civGD.sandboxInvestmentsSpendTarget > 0.0f ? Math.max(0, Math.min(100, (int)(civ.civGD.sandboxInvestmentsSpendTarget * 100.0f))) : 0;
        Slider investmentsSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, investmentsTarget) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                civ.civGD.sandboxInvestmentsSpendTarget = this.getCurr() > 0 ? (float)this.getCurr() / 100.0f : -1.0f;
                if (civ.civGD.sandboxInvestmentsSpendTarget >= 0.0f) {
                    civ.setSpendingInvestmentsB(civ.civGD.sandboxInvestmentsSpendTarget);
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Investments: AI default/off" : "Investments: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(investmentsSlider);
        spendingSliders[2] = investmentsSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int buildingsPct = civ.civGD.sandboxBuildingSpend > 0 && spendingIncome[0] > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxBuildingSpend * 100.0f / spendingIncome[0])) : 0;
        Slider buildingsSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, buildingsPct) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                if (this.getCurr() > 0) {
                    int income = Math.max(1, (int)CFG.gameUpdate.getIncome(civID));
                    civ.civGD.sandboxBuildingSpend = (int)((float)this.getCurr() * income / 100.0f);
                } else {
                    civ.civGD.sandboxBuildingSpend = 0;
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Buildings: off" : "Buildings: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(buildingsSlider);
        spendingSliders[3] = buildingsSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int developmentPct = civ.civGD.sandboxDevelopmentSpend > 0 && spendingIncome[0] > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxDevelopmentSpend * 100.0f / spendingIncome[0])) : 0;
        Slider developmentSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, developmentPct) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                if (this.getCurr() > 0) {
                    int income = Math.max(1, (int)CFG.gameUpdate.getIncome(civID));
                    civ.civGD.sandboxDevelopmentSpend = (int)((float)this.getCurr() * income / 100.0f);
                } else {
                    civ.civGD.sandboxDevelopmentSpend = 0;
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Development: off" : "Development: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(developmentSlider);
        spendingSliders[4] = developmentSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int missilePct = civ.civGD.sandboxMissileSpend > 0 && spendingIncome[0] > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxMissileSpend * 100.0f / spendingIncome[0])) : 0;
        Slider missileSlider = new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 0, 100, missilePct) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                if (this.getCurr() > 0) {
                    int income = Math.max(1, (int)CFG.gameUpdate.getIncome(civID));
                    civ.civGD.sandboxMissileSpend = (int)((float)this.getCurr() * income / 100.0f);
                } else {
                    civ.civGD.sandboxMissileSpend = 0;
                }
            }

            @Override
            public String getDrawText() {
                return this.getCurr() == 0 ? "Missiles: off" : "Missiles: " + this.getCurr() + "% of income";
            }
        };
        menuElements.add(missileSlider);
        spendingSliders[5] = missileSlider;
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        final int[] regroupTurns = new int[]{civ.civGD.sandboxRegroupUntilTurnID == Integer.MAX_VALUE ? 5000 : Math.max(1, Math.min(5000, civ.civGD.sandboxRegroupUntilTurnID - GameCalendar.TURNID))};
        final boolean[] regroupInfinite = new boolean[]{civ.civGD.sandboxRegroupUntilTurnID == Integer.MAX_VALUE};
        menuElements.add(new Slider(contentX, tY, contentW, CFG.BUTTON_H / 2, 1, 5000, regroupTurns[0]) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                if (nX < 0) return;
                regroupTurns[0] = this.getCurr();
            }

            @Override
            public String getDrawText() {
                return regroupInfinite[0] ? "Regroup turns: Infinite" : "Regroup turns: " + this.getCurr();
            }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Infinite regroup", CFG.PADD, contentX, tY, colW, true, regroupInfinite[0]) {
            @Override
            public void actionElem(int iID) {
                regroupInfinite[0] = !regroupInfinite[0];
                this.setCheckboxSt(regroupInfinite[0]);
            }
        });

        menuElements.add(new Button_Game("Add active province", -1, col2X, tY, colW, CFG.BUTTON_H, true) {
            @Override
            public void actionElem(int iID) {
                int targetProvinceID = CFG.core.getActiveProvID();
                if (targetProvinceID >= 0 && CFG.core.getProv(targetProvinceID).getCivId() == civID) {
                    if (civ.civGD.sandboxRegroupTargetProvinceIDs == null) {
                        civ.civGD.sandboxRegroupTargetProvinceIDs = new ArrayList<Integer>();
                    }
                    if (!civ.civGD.sandboxRegroupTargetProvinceIDs.contains(targetProvinceID)) {
                        civ.civGD.sandboxRegroupTargetProvinceIDs.add(targetProvinceID);
                    }
                    civ.civGD.sandboxRegroupTargetProvinceID = targetProvinceID;
                    CFG.toastM.addM("Control: regroup province added", CFG.COLOR_POSITIVE);
                }
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game("Clear regroup", -1, contentX, tY, colW, CFG.BUTTON_H, true) {
            @Override
            public void actionElem(int iID) {
                if (civ.civGD.sandboxRegroupTargetProvinceIDs != null) {
                    civ.civGD.sandboxRegroupTargetProvinceIDs.clear();
                }
                civ.civGD.sandboxRegroupTargetProvinceID = -1;
                CFG.toastM.addM("Control: regroup provinces cleared", CFG.COLOR_POSITIVE);
            }
        });

        menuElements.add(new Button_Game("Regroup all", -1, col2X, tY, colW, CFG.BUTTON_H, true) {
            @Override
            public void actionElem(int iID) {
                if (civ.civGD.sandboxRegroupTargetProvinceIDs == null) {
                    civ.civGD.sandboxRegroupTargetProvinceIDs = new ArrayList<Integer>();
                }
                int activeProvinceID = CFG.core.getActiveProvID();
                if (activeProvinceID >= 0 && CFG.core.getProv(activeProvinceID).getCivId() == civID && !civ.civGD.sandboxRegroupTargetProvinceIDs.contains(activeProvinceID)) {
                    civ.civGD.sandboxRegroupTargetProvinceIDs.add(activeProvinceID);
                }
                if (civ.civGD.sandboxRegroupTargetProvinceIDs.isEmpty() && civ.getCapitalProvID() >= 0) {
                    civ.civGD.sandboxRegroupTargetProvinceIDs.add(civ.getCapitalProvID());
                }
                for (int i = civ.civGD.sandboxRegroupTargetProvinceIDs.size() - 1; i >= 0; --i) {
                    int provinceID = civ.civGD.sandboxRegroupTargetProvinceIDs.get(i);
                    if (provinceID < 0 || provinceID >= CFG.core.getProvinSize() || CFG.core.getProv(provinceID).getCivId() != civID) {
                        civ.civGD.sandboxRegroupTargetProvinceIDs.remove(i);
                    }
                }
                civ.civGD.sandboxRegroupTargetProvinceID = civ.civGD.sandboxRegroupTargetProvinceIDs.isEmpty() ? -1 : civ.civGD.sandboxRegroupTargetProvinceIDs.get(0);
                civ.civGD.sandboxRegroupUntilTurnID = regroupInfinite[0] ? Integer.MAX_VALUE : GameCalendar.TURNID + regroupTurns[0];
                if (civ.civGD.sandboxRegroupUntilTurnID == Integer.MAX_VALUE) {
                    civ.civGD.aiNoDisbandUntilTurnID = Integer.MAX_VALUE;
                } else {
                    civ.civGD.aiNoDisbandUntilTurnID = Math.max(civ.civGD.aiNoDisbandUntilTurnID, civ.civGD.sandboxRegroupUntilTurnID + 3);
                }
                CFG.toastM.addM("Control: regroup target set", CFG.COLOR_POSITIVE);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        int menuH = Math.min(tY + CFG.PADD, CFG.GAMEHEIGHT - tempMenuPosY - CFG.PADD * 2);
        this.initMenu(new TitleM("Control", CFG.BUTTON_H * 4 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, menuH, menuElements, true, true);
    }

    private void rebalanceSliders() {
        if (isRebalancing) return;
        isRebalancing = true;
        try {
            int income = Math.max(1, (int)CFG.gameUpdate.getIncome(civID));
            Civilization civ = CFG.core.getCiv(civID);
            int[] currentPercents = new int[6];
            currentPercents[0] = civ.civGD.sandboxGoodsSpendTarget > 0.0f ? (int)(civ.civGD.sandboxGoodsSpendTarget * 100.0f) : 0;
            currentPercents[1] = civ.civGD.sandboxResearchSpendTarget > 0.0f ? (int)(civ.civGD.sandboxResearchSpendTarget * 100.0f) : 0;
            currentPercents[2] = civ.civGD.sandboxInvestmentsSpendTarget > 0.0f ? (int)(civ.civGD.sandboxInvestmentsSpendTarget * 100.0f) : 0;
            currentPercents[3] = civ.civGD.sandboxBuildingSpend > 0 && income > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxBuildingSpend * 100.0f / income)) : 0;
            currentPercents[4] = civ.civGD.sandboxDevelopmentSpend > 0 && income > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxDevelopmentSpend * 100.0f / income)) : 0;
            currentPercents[5] = civ.civGD.sandboxMissileSpend > 0 && income > 0 ? Math.min(100, (int)((float)civ.civGD.sandboxMissileSpend * 100.0f / income)) : 0;

            int sum = 0;
            for (int i = 0; i < 6; i++) {
                sum += currentPercents[i];
            }
            if (sum == 100 || sum == 0) {
                return;
            }

            int[] newPercents = new int[6];
            int allocated = 0;
            int activeCount = 0;
            for (int i = 0; i < 6; i++) {
                if (currentPercents[i] > 0) {
                    newPercents[i] = Math.round((float)currentPercents[i] * 100.0f / sum);
                    allocated += newPercents[i];
                    activeCount++;
                } else {
                    newPercents[i] = 0;
                }
            }

            if (activeCount > 0) {
                int diff = 100 - allocated;
                if (diff != 0) {
                    for (int i = 0; i < 6 && diff != 0; i++) {
                        if (newPercents[i] > 0) {
                            newPercents[i] += diff;
                            diff = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                if (newPercents[i] != currentPercents[i] && spendingSliders[i] != null) {
                    switch (i) {
                        case 0:
                            civ.civGD.sandboxGoodsSpendTarget = (float)newPercents[i] / 100.0f;
                            civ.setSpendingGoodsB(civ.civGD.sandboxGoodsSpendTarget);
                            break;
                        case 1:
                            civ.civGD.sandboxResearchSpendTarget = (float)newPercents[i] / 100.0f;
                            civ.setSpendingResearchB(civ.civGD.sandboxResearchSpendTarget);
                            break;
                        case 2:
                            civ.civGD.sandboxInvestmentsSpendTarget = (float)newPercents[i] / 100.0f;
                            civ.setSpendingInvestmentsB(civ.civGD.sandboxInvestmentsSpendTarget);
                            break;
                        case 3:
                            civ.civGD.sandboxBuildingSpend = newPercents[i] > 0 ? (int)((float)newPercents[i] * income / 100.0f) : 0;
                            break;
                        case 4:
                            civ.civGD.sandboxDevelopmentSpend = newPercents[i] > 0 ? (int)((float)newPercents[i] * income / 100.0f) : 0;
                            break;
                        case 5:
                            civ.civGD.sandboxMissileSpend = newPercents[i] > 0 ? (int)((float)newPercents[i] * income / 100.0f) : 0;
                            break;
                    }
                    spendingSliders[i].setCurr((long)newPercents[i]);
                }
            }
        } finally {
            isRebalancing = false;
        }
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.025f, 0.03f, 0.04f, 0.96f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(0.09f, 0.11f, 0.14f, 1.0f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), Math.max(1, CFG.PADD / 2));
        BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), false, false, false);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }
}
