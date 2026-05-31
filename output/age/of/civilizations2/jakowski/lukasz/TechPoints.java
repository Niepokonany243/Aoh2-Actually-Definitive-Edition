/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;

public class TechPoints
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int POINTS_POP_GROWTH = 0;
    public int POINTS_ECONOMY_GROWTH = 0;
    public int POINTS_INCOME_TAXATION = 0;
    public int POINTS_INCOME_PRODUCTION = 0;
    public int POINTS_ADMINISTRATION = 0;
    public int POINTS_MILITARY_UPKEEP = 0;
    public int POINTS_RESEARCH = 0;
    public int POINTS_COLONIZATION = 0;
    public int POINTS_MOVEMENT = 0;
    public int POINTS_ASSIMILATE = 0;
    public int POINTS_RECRUITABLE = 0;

    public final int getPointsLeft(int nCivID) {
        return CFG.core.getCiv(nCivID).getTechLevelINT() - this.POINTS_POP_GROWTH - this.POINTS_ECONOMY_GROWTH - this.POINTS_INCOME_TAXATION - this.POINTS_INCOME_PRODUCTION - this.POINTS_ADMINISTRATION - this.POINTS_MILITARY_UPKEEP - this.POINTS_RESEARCH - this.POINTS_COLONIZATION - this.POINTS_MOVEMENT - this.POINTS_ASSIMILATE - this.POINTS_RECRUITABLE;
    }
}

