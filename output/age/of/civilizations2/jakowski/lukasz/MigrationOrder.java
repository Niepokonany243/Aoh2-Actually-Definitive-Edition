package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class MigrationOrder implements Serializable {
    private static final long serialVersionUID = 0L;
    private int nationalityCivID;
    private int targetCivID;

    public MigrationOrder(int nationalityCivID, int targetCivID) {
        this.nationalityCivID = nationalityCivID;
        this.targetCivID = targetCivID;
    }

    public int getNationalityCivID() {
        return this.nationalityCivID;
    }

    public int getTargetCivID() {
        return this.targetCivID;
    }

    public void setTargetCivID(int targetCivID) {
        this.targetCivID = targetCivID;
    }
}
