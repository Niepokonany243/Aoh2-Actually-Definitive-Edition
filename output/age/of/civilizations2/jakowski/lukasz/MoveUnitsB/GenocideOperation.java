
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

public class GenocideOperation {
    private int nCivID;
    private int nProvinceID;
    private int targetCivID;
    private long nArmy;
    private long totalPopToRemove;
    private int turnsRemaining;

    public GenocideOperation(int nCivID, int nProvinceID, int targetCivID, long nArmy, long totalPopToRemove, int turnsRemaining) {
        this.nCivID = nCivID;
        this.nProvinceID = nProvinceID;
        this.targetCivID = targetCivID;
        this.nArmy = nArmy;
        this.totalPopToRemove = totalPopToRemove;
        this.turnsRemaining = turnsRemaining;
    }

    public final int getCivID() {
        return this.nCivID;
    }

    public final int getProvinceID() {
        return this.nProvinceID;
    }

    public final int getTargetCivID() {
        return this.targetCivID;
    }

    public final long getArmy() {
        return this.nArmy;
    }

    public final long getTotalPopToRemove() {
        return this.totalPopToRemove;
    }

    public final int getTurnsRemaining() {
        return this.turnsRemaining;
    }

    public final void setTurnsRemaining(int turns) {
        this.turnsRemaining = turns;
    }

    public final void setTotalPopToRemove(long pop) {
        this.totalPopToRemove = pop;
    }
}
