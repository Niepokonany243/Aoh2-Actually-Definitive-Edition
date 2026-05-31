/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI;

public class AI_BordersWith {
    public int iWithCivID;
    public int iNumOfConnections = 0;

    public AI_BordersWith(int iWithCivID) {
        this.iWithCivID = iWithCivID;
        this.iNumOfConnections = 1;
    }

    public AI_BordersWith(int iWithCivID, int iNumOfConnections) {
        this.iWithCivID = iWithCivID;
        this.iNumOfConnections = iNumOfConnections;
    }
}

