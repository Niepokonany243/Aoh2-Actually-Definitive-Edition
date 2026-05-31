/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Civ_Mission_ChangeTypeOfGovernment;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import java.util.ArrayList;
import java.util.List;

public class AI_Playstyle_CityState
extends AIPlaystyle {
    public AI_Playstyle_CityState() {
        this.TAG = "CITYSTATE";
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.09f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 13;
        this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 77;
        this.PERSONALITY_MIN_HAPPINESS_RANDOM = 20;
        this.PERSONALITY_FORGIVENESS_DEFAULT = 0.4f;
        this.PERSONALITY_FORGIVENESS_RANDOM = 10;
    }

    @Override
    public void turnOrders(int nCivID) {
        this.shouldChangeTypeOfGovernment(nCivID);
        super.turnOrders(nCivID);
    }

    public final void sendGiftToFriendlyCiv(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC() && CFG.core.getCiv(nCivID).getGold() > 0L && CFG.core.getCiv((int)nCivID).iBudget > 0 && CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.CITY_STATE_SEND_GIFT_CHANCE_1000 && CFG.core.getCiv(nCivID).getFriendlyCivsSize() > 0) {
            GameManager.sendGift(CFG.core.getCiv((int)nCivID).getFriendlyCiv((int)CFG.oR.nextInt((int)CFG.core.getCiv((int)nCivID).getFriendlyCivsSize())).iCivID, nCivID, (int)Math.ceil((float)CFG.core.getCiv((int)nCivID).iBudget * (0.05f + (float)CFG.oR.nextInt(75) / 1000.0f)));
        }
    }

    public final void shouldChangeTypeOfGovernment(int nCivID) {
        if (CFG.core.getCiv(nCivID).getNumOfProvs() > GameValues.gvAiDiplomacy.CITY_STATE_CHANGE_GOVERNMENT_IF_PROVINCES_OVER && CFG.core.getCiv((int)nCivID).civGD.changeTypeOfGovernment == null) {
            List<Boolean> canChaneTo = CFG.ideologiesMgr.canChangeToIdeology(nCivID);
            ArrayList<Integer> possibleIdeologiesIDs = new ArrayList<Integer>();
            for (int i = 0; i < canChaneTo.size(); ++i) {
                if (!canChaneTo.get(i).booleanValue()) continue;
                possibleIdeologiesIDs.add(i);
            }
            if (!possibleIdeologiesIDs.isEmpty()) {
                CFG.core.getCiv((int)nCivID).civGD.changeTypeOfGovernment = new Civ_Mission_ChangeTypeOfGovernment((Integer)possibleIdeologiesIDs.get(CFG.oR.nextInt(possibleIdeologiesIDs.size())), nCivID);
            }
        } else {
            this.sendGiftToFriendlyCiv(nCivID);
        }
    }

    @Override
    public void buildStartingBuildings(int nCivID) {
        super.buildStartingBuildings(nCivID);
        try {
            if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0) {
                if (CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getFarm_TechLevel(1) * 0.92f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfFarm(Math.max(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getLvlOfFarm(), 1));
                }
                if (CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getLibrary_TechLevel(1) * 1.08f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfLibrary(Math.max(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getLvlOfLibrary(), 1));
                }
                if (CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getFort_TechLevel(2) * 1.08f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfLibrary(Math.max(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getLvlOfFort(), 2));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

