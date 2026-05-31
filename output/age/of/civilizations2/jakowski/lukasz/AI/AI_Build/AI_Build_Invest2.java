
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.util.ArrayList;
import java.util.List;

public class AI_Build_Invest2
extends AI_Build {
    private List<Integer> lProvincesToInvest = new ArrayList<Integer>();
    private int iMaxPop = 1;

    public AI_Build_Invest2(int nCivID, long nMoney) {
        super(nCivID, nMoney);
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
            int maxInvestmentGold;
            if (this.lProvincesToInvest.isEmpty()) {
                return out;
            }
            int iBestProvinceID = this.lProvincesToInvest.get(0);
            int bestID = 0;
            float iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
            if (CFG.oR.nextInt(100) < GameValues.gvAiInvest.INVEST_IN_RANDOM_PROVINCE_CHANCE_100) {
                bestID = CFG.oR.nextInt(this.lProvincesToInvest.size());
                iBestProvinceID = this.lProvincesToInvest.get(bestID);
            } else {
                for (int i = this.lProvincesToInvest.size() - 1; i > 0; --i) {
                    if (!(this.getProvinceBuildScore(nCivID, this.lProvincesToInvest.get(i)) > iBestProvinceID_Score)) continue;
                    bestID = i;
                    iBestProvinceID = this.lProvincesToInvest.get(bestID);
                    iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
                }
            }
            if (iBestProvinceID >= 0 && GameManager.invest(iBestProvinceID, nCivID, maxInvestmentGold = (int)Math.min(this.getMoney(nCivID), (long)GameManager.invest_MaxEconomy_Gold(iBestProvinceID, nCivID)))) {
                out = true;
                if (this.getMoney(nCivID) > 100L && GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS <= CFG.core.getCiv(nCivID).getMovemPoints()) {
                    this.lProvincesToInvest.remove(bestID);
                    if (!this.lProvincesToInvest.isEmpty()) {
                        return this.build(nCivID, ++iteration, out);
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
        return CFG.core.getCiv(nCivID).getGold();
    }
}

