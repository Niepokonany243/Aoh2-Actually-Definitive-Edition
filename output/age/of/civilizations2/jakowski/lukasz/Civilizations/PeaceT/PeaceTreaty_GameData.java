/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT;

import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Civs;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Demands;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeaceTreaty_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iWarID;
    public String WAR_TAG;
    public int TRUCE_LENGTH;
    public List<PeaceTreaty_Civs> civsDataDefenders;
    public List<PeaceTreaty_Civs> civsDataAggressors;
    public List<PeaceTreaty_Demands> civsDemandsDefenders;
    public List<PeaceTreaty_Demands> civsDemandsAggressors;

    public PeaceTreaty_GameData() {
        this.TRUCE_LENGTH = GameValues.gvPeaceTreaty.PEACE_TREATY_DEFAULT_DURATION;
        this.civsDataDefenders = new ArrayList<PeaceTreaty_Civs>();
        this.civsDataAggressors = new ArrayList<PeaceTreaty_Civs>();
        this.civsDemandsDefenders = new ArrayList<PeaceTreaty_Demands>();
        this.civsDemandsAggressors = new ArrayList<PeaceTreaty_Demands>();
    }
}

