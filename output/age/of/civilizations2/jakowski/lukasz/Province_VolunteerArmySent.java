
package age.of.civilizations2.jakowski.lukasz;

public class Province_VolunteerArmySent {
    public int fromCivID = 0;
    public int toCivID = 0;
    public long army = 0;
    public int TURN_ID = 0;

    public Province_VolunteerArmySent(int fromCivID, int toCivID, long army, int TURN_ID) {
        this.fromCivID = fromCivID;
        this.toCivID = toCivID;
        this.army = army;
        this.TURN_ID = TURN_ID;
    }
}

