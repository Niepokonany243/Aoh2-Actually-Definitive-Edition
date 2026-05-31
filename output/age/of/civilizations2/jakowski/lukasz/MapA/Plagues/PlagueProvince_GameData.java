/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues;

import java.io.Serializable;

public class PlagueProvince_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iPlagueID_InGame = 0;
    public int iSinceTurnID = 0;
    public int iDeaths = 0;
    public float iDurationTurnsLeft = 0.0f;

    public PlagueProvince_GameData(int iPlagueID_InGame, int iSinceTurnID, float iDurationTurnsLeft, int iDeaths) {
        this.iPlagueID_InGame = iPlagueID_InGame;
        this.iSinceTurnID = iSinceTurnID;
        this.iDurationTurnsLeft = iDurationTurnsLeft;
        this.iDeaths = iDeaths;
    }
}

