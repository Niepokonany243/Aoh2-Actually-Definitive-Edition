
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

public class GenocideOperation {
    private int nCivID;
    private int nProvinceID;
    private int targetCivID;
    private long nArmy;
    private long currentArmy;
    private long totalPopToRemove;
    private float effectivePower;
    private float resistancePower;
    private int turnsRemaining;

    public GenocideOperation(int nCivID, int nProvinceID, int targetCivID, long nArmy, long totalPopToRemove, int turnsRemaining, float effectivePower, float resistancePower, long currentArmy) {
        this.nCivID = nCivID;
        this.nProvinceID = nProvinceID;
        this.targetCivID = targetCivID;
        this.nArmy = nArmy;
        this.currentArmy = currentArmy;
        this.totalPopToRemove = totalPopToRemove;
        this.turnsRemaining = turnsRemaining;
        this.effectivePower = effectivePower;
        this.resistancePower = resistancePower;
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

    public final long getCurrentArmy() {
        return this.currentArmy;
    }

    public final void setCurrentArmy(long army) {
        this.currentArmy = army;
    }

    public final long getTotalPopToRemove() {
        return this.totalPopToRemove;
    }

    public final float getEffectivePower() {
        return this.effectivePower;
    }

    public final void setEffectivePower(float power) {
        this.effectivePower = power;
    }

    public final float getResistancePower() {
        return this.resistancePower;
    }

    public final void setResistancePower(float resistance) {
        this.resistancePower = resistance;
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
