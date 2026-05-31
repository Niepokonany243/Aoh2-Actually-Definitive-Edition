
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.util.ArrayList;
import java.util.List;

public class AI_Build_Invest
extends AI_Build {
    private List<Integer> lProvincesToInvest = new ArrayList<Integer>();
    private float fReserve = 1.0f;
    private int iMaxPop = 1;

    public AI_Build_Invest(int nCivID, long nMoney) {
        super(nCivID, nMoney);
        this.fReserve = 1.0f - (float)CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_RESERVE_RAND / 100.0f + (float)CFG.oR.nextInt(CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_RESERVE_RAND) / 100.0f;
        try {
            for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).isOccupied() || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getProviStability() > GameValues.gvAiProvince.BUILD_MIN_STABILITY) || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getRevRisk() <= GameValues.gvAiProvince.BUILD_MAX_REV_RISK) || CFG.core.getCiv(nCivID).isInvestOrganized(CFG.core.getCiv(nCivID).getProvID(i)) || !(CFG.gameUpdate.getMaxProvEconomy(CFG.core.getCiv(nCivID).getProvID(i)) * 1.03f > (float)CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getEco())) continue;
                this.lProvincesToInvest.add(CFG.core.getCiv(nCivID).getProvID(i));
                this.iMaxDangerLevel = Math.max(this.iMaxDangerLevel, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDangerLvl());
                this.iMaxPop = (int)Math.max((long)this.iMaxPop, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPops());
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public boolean build(int nCivID, int iteration, boolean out) {
        try {
            if (this.lProvincesToInvest.isEmpty()) {
                return out;
            }
            int iBestProvinceID = this.lProvincesToInvest.get(0);
            float iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
            int randValue = CFG.oR.nextInt(100);
            if (randValue < GameValues.gvAiInvest.INVEST_IN_RANDOM_PROVINCE_CHANCE_100) {
                iBestProvinceID = this.lProvincesToInvest.get(CFG.oR.nextInt(this.lProvincesToInvest.size()));
            } else {
                for (int i = this.lProvincesToInvest.size() - 1; i > 0; --i) {
                    if (!(this.getProvinceBuildScore(nCivID, this.lProvincesToInvest.get(i)) > iBestProvinceID_Score)) continue;
                    iBestProvinceID = this.lProvincesToInvest.get(i);
                    iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
                }
            }
            if (iBestProvinceID >= 0) {
                int maxInvestmentGold = (int)Math.min(this.getMoney(nCivID), (long)GameManager.invest_MaxEconomy_Gold(iBestProvinceID, nCivID));
                int minNumOfInvests = (int)Math.min(Math.floor((float)CFG.core.getCiv(nCivID).getMovemPoints() / (float)GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS), (double)((float)CFG.core.getCiv(nCivID).getNumOfProvs() / 10.0f));
                if (iteration == 0 && minNumOfInvests > 1 && CFG.oR.nextInt(100) < CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_INVEST_SECOND_INVEST_CHANCE) {
                    maxInvestmentGold = (int)((float)maxInvestmentGold * (1.0f - (float)CFG.oR.nextInt(Math.max(2, CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_INVEST_SECOND_INVEST_MAX_PERC)) / 100.0f));
                }
                if (GameManager.invest(iBestProvinceID, nCivID, maxInvestmentGold)) {
                    out = true;
                    if (this.getMoney(nCivID) > 10L && GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS <= CFG.core.getCiv(nCivID).getMovemPoints()) {
                        int tSize = 0;
                        for (int i = this.lProvincesToInvest.size() - 1; i >= 0; --i) {
                            if (this.lProvincesToInvest.get(i) == iBestProvinceID) {
                                this.lProvincesToInvest.remove(i);
                                continue;
                            }
                            ++tSize;
                        }
                        if (tSize > 0 && iteration < GameValues.gvAiInvest.INVEST_LIMIT_PER_TURN) {
                            return this.build(nCivID, ++iteration, out);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return out;
    }

    public float getProvinceBuildScore(int nCivID, int nProvinceID) {
        return 10000.0f - (float)CFG.core.getProv(nProvinceID).getEco() / (float)CFG.core.getProv(nProvinceID).getPop().getPops();
    }

    @Override
    public long getMoney(int nCivID) {
        if (CFG.core.getCiv(nCivID).getGold() < AIPlaystyle.getMoney_MinReserve(nCivID)) {
            return 0L;
        }
        return (long)((float)CFG.core.getCiv(nCivID).getGold() - (float)AIPlaystyle.getMoney_MinReserve(nCivID) * this.fReserve);
    }
}

