/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;

public class Report_Data {
    public List<Integer> lAttackers_IDs = new ArrayList<Integer>();
    public List<Long> lAttackers_Armies = new ArrayList<Long>();
    public List<Long> lAttackers_Armies_Lost = new ArrayList<Long>();
    public List<Integer> lDefenders_IDs = new ArrayList<Integer>();
    public List<Long> lDefenders_Armies = new ArrayList<Long>();
    public List<Long> lDefenders_ArmiesLost = new ArrayList<Long>();
    public int iBattleOfProvinceID = 0;
    public boolean attackersWon = true;
    public float fWarScore;
    public long iPopulationLosses = 0L;
    public long iEconomyLosses = 0L;

    public final long getAttackersArmy() {
        long out = 0L;
        for (int i = 0; i < this.lAttackers_Armies.size(); ++i) {
            out += ((Number)this.lAttackers_Armies.get(i)).longValue();
        }
        return out;
    }

    public final long getAttackersArmy_Lost() {
        long out = 0L;
        for (int i = 0; i < this.lAttackers_Armies_Lost.size(); ++i) {
            out += ((Number)this.lAttackers_Armies_Lost.get(i)).longValue();
        }
        return out;
    }

    public final long getDefendersArmy() {
        long out = 0L;
        for (int i = 0; i < this.lDefenders_Armies.size(); ++i) {
            out += ((Number)this.lDefenders_Armies.get(i)).longValue();
        }
        return out;
    }

    public final long getDefendersArmy_Lost() {
        long out = 0L;
        for (int i = 0; i < this.lDefenders_ArmiesLost.size(); ++i) {
            out += ((Number)this.lDefenders_ArmiesLost.get(i)).longValue();
        }
        return out;
    }

    public final void checkReport() {
        for (int i = 0; i < this.lAttackers_Armies.size(); ++i) {
            if (((Number)this.lAttackers_Armies.get(i)).longValue() > 0L) continue;
            this.lAttackers_IDs.remove(i);
            this.lAttackers_Armies.remove(i);
            this.lAttackers_Armies_Lost.remove(i--);
        }
    }

    public final long getTotalArmy() {
        long out = 0L;
        int i;
        for (i = 0; i < this.lAttackers_Armies.size(); ++i) {
            out += ((Number)this.lAttackers_Armies.get(i)).longValue();
        }
        for (i = 0; i < this.lDefenders_Armies.size(); ++i) {
            out += ((Number)this.lDefenders_Armies.get(i)).longValue();
        }
        return out;
    }

    public final long getTotalArmy_Lost() {
        long out = 0L;
        int i;
        for (i = 0; i < this.lAttackers_Armies_Lost.size(); ++i) {
            out += ((Number)this.lAttackers_Armies_Lost.get(i)).longValue();
        }
        for (i = 0; i < this.lDefenders_ArmiesLost.size(); ++i) {
            out += ((Number)this.lDefenders_ArmiesLost.get(i)).longValue();
        }
        return out;
    }
}
