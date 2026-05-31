/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RandomGame_Player;
import java.util.ArrayList;
import java.util.List;

public class RandomGame_Manager {
    private int iCivilizationsSize = 0;
    private long iNeutralArmy = 0;
    private List<RandomGame_Player> lPlayers = new ArrayList<RandomGame_Player>();

    public RandomGame_Manager() {
        this.lPlayers.add(new RandomGame_Player(null, -1));
    }

    public final void addPlayer() {
        this.lPlayers.add(new RandomGame_Player(null, -1));
    }

    public final void removePlayer(int i) {
        try {
            this.lPlayers.remove(i);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
    }

    public final RandomGame_Player getPlayer(int i) {
        return this.lPlayers.get(i);
    }

    public final int getPlayersSize() {
        return this.lPlayers.size();
    }

    public final boolean isTagTaken(String nTag) {
        for (int i = 0; i < this.getPlayersSize(); ++i) {
            if (this.lPlayers.get(i).getTag() == null || !nTag.equals(this.lPlayers.get(i).getTag())) continue;
            return true;
        }
        return false;
    }

    public final void checkCapitals() {
        for (int i = 0; i < this.getPlayersSize(); ++i) {
            if (this.getPlayer(i).getCapitalProvinceID() < 0) continue;
            try {
                if (!CFG.core.getProv(i).getSeaProv() && CFG.core.getProv(i).getWastelandLvl() < 0) continue;
                this.getPlayer(i).setCapitalProvinceID(-1);
                continue;
            }
            catch (IndexOutOfBoundsException ex) {
                this.getPlayer(i).setCapitalProvinceID(-1);
            }
        }
    }

    public final int getCivilizationsSize() {
        return this.iCivilizationsSize;
    }

    public final void setCivilizationsSize(int iCivilizationsSize) {
        this.iCivilizationsSize = iCivilizationsSize;
    }

    public final long getNeutralArmy() {
        return this.iNeutralArmy;
    }

    public final void setNeutralArmy(long iNeutralArmy) {
        this.iNeutralArmy = iNeutralArmy;
    }
}

