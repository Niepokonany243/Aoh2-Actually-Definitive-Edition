/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.PlayerAIPeace_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerGD
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID = -1;
    public List<Boolean> metProvin;
    public List<Boolean> metCiv;
    public int orzC = 0;
    public int challengeID = -1;
    public boolean lostNextTurn = false;
    public boolean VASSALS_CAN_DECLARE_WARS = false;
    public float VASSALS_MILITARY_SPENDINGS = -1.0f;
    public int VASSALS_RESEARCH_SPENDINGS = 0;
    public boolean VASSALS_INDEPENDENT_ARMY = false;
    public boolean VASSALS_CAN_BE_INDEPENDENT = true;
    public int ULTIMATUMS_SENT = 0;
    public int WARS_DECLARED_AS_VASSAL_AND_LORD_JOINED_WAR = 0;
    public List<PlayerAIPeace_GameData> playerAIPeace = new ArrayList<PlayerAIPeace_GameData>();
    public List<Integer> migrationF = new ArrayList<Integer>();
    public List<MigrationOrder> migrationOrders = new ArrayList<MigrationOrder>();
    public List<City> cts = new ArrayList<City>();
    public boolean AUTO_ASSIMILATE = false;
    public boolean A_E = false;
    public boolean A_D = false;
    public int INVITED_CIVS_HRE = 0;
}

