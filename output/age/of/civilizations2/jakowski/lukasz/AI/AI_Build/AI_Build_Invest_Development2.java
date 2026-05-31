/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.util.ArrayList;
import java.util.List;

public class AI_Build_Invest_Development2
extends AI_Build {
    private List<Integer> lProvincesToInvest = new ArrayList<Integer>();
    private int iMaxPop = 1;

    public AI_Build_Invest_Development2(int nCivID, long nMoney) {
        super(nCivID, nMoney);
        try {
            for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).isOccupied() || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getProviStability() > GameValues.gvAiProvince.BUILD_MIN_STABILITY) || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getRevRisk() <= GameValues.gvAiProvince.BUILD_MAX_REV_RISK) || CFG.core.getCiv(nCivID).isInvestOrganized_Devel(CFG.core.getCiv(nCivID).getProvID(i)) || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDeveLvl() / CFG.core.getCiv(nCivID).getTechLevel() < 0.999f)) continue;
                this.lProvincesToInvest.add(CFG.core.getCiv(nCivID).getProvID(i));
                this.iMaxDangerLevel = Math.max(this.iMaxDangerLevel, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDangerLvl());
                this.iMaxPop = (int)Math.max((long)this.iMaxPop, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPops());
            }
        }
        catch (IndexOutOfBoundsException ex) {
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
            int bestID = 0;
            for (int i = this.lProvincesToInvest.size() - 1; i > 0; --i) {
                if (!(this.getProvinceBuildScore(nCivID, this.lProvincesToInvest.get(i)) > iBestProvinceID_Score)) continue;
                bestID = i;
                iBestProvinceID = this.lProvincesToInvest.get(i);
                iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
            }
            if (iBestProvinceID >= 0) {
                long maxInvestmentGold = Math.min(this.getMoney(nCivID), GameManager.investMaxDevGold(iBestProvinceID, nCivID));
                if (maxInvestmentGold > 0 && GameManager.investDevelopment(iBestProvinceID, nCivID, maxInvestmentGold)) {
                    out = true;
                    if (this.getMoney(nCivID) > 100L && GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS <= CFG.core.getCiv(nCivID).getMovemPoints()) {
                        this.lProvincesToInvest.remove(bestID);
                        if (!this.lProvincesToInvest.isEmpty()) {
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
        return (float)CFG.core.getProv(nProvinceID).getEco() * (CFG.core.getCiv(nCivID).getTechLevel() - CFG.core.getProv(nProvinceID).getDeveLvl());
    }

    @Override
    public long getMoney(int nCivID) {
        return CFG.core.getCiv(nCivID).getGold();
    }
}

