/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Managers;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.util.ArrayList;
import java.util.List;

public class MercenariesManager {
    public static List<MercenaryArmy> getMercenaryArmies(int civID) {
        ArrayList<MercenaryArmy> out = new ArrayList<MercenaryArmy>();
        int goldMax = (int)Math.max(CFG.core.getCiv(civID).getGold(), 1000L);
        for (int i = GameValues.gvArmyRecruit.NUM_OF_MERCENARIES_ARMIES - 1; i >= 0; --i) {
            int fromCivID = CFG.oR.nextInt(CFG.core.getCivsSize() - 1) + 1;
            for (int a = 0; a < 15 && (CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), fromCivID) || fromCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(fromCivID)); ++a) {
                fromCivID = CFG.oR.nextInt(CFG.core.getCivsSize() - 1) + 1;
            }
            if (CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), fromCivID) || fromCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(fromCivID)) {
                fromCivID = 0;
            }
            long numOfUnits = (int)Math.max(10.0, Math.floor((float)goldMax / ((float)i + 1.0f) / (float)CFG.getCostOfRecruitArmyMoney_Mercenaries()));
            out.add(new MercenaryArmy(fromCivID, (long)numOfUnits, (long)numOfUnits * (long)CFG.getCostOfRecruitArmyMoney_Mercenaries()));
        }
        return out;
    }

    public static class MercenaryArmy {
        public int fromCivID = 0;
        public long numOfUnits = 0;
        public long iCost;

        public MercenaryArmy(int fromCivID, long numOfUnits, long iCost) {
            this.fromCivID = fromCivID;
            this.numOfUnits = numOfUnits;
            this.iCost = iCost;
        }

        public MercenaryArmy(int fromCivID, long numOfUnits, int iCost) {
            this(fromCivID, (long)numOfUnits, (long)iCost);
        }
    }
}

