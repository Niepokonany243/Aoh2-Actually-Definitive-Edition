/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class ReligionE {
    private int id;
    private double power;
    private boolean isStateReligion;

    public ReligionE(int id, boolean isStateReligion) {
        this.id = id;
        this.isStateReligion = isStateReligion;
        this.power = 10.0;
    }

    public void spread() {
        double delta = CFG.oR.nextDouble() * 5.0;
        this.power += delta;
        if (this.power > 100.0) {
            this.power = 100.0;
        }
    }

    public void applyEvent(int eventCode) {
        if (eventCode == 1) {
            this.power -= 3.0;
        } else if (eventCode == 2) {
            this.power += 4.0;
        }
        if (this.power < 0.0) {
            this.power = 0.0;
        }
        if (this.power > 100.0) {
            this.power = 100.0;
        }
    }

    public int getId() {
        return this.id;
    }

    public double getPower() {
        return this.power;
    }

    public boolean isStateReligion() {
        return this.isStateReligion;
    }

    public void setStateReligion(boolean stateReligion) {
        this.isStateReligion = stateReligion;
    }

    public void tick(int eventCode) {
        this.spread();
        this.applyEvent(eventCode);
    }
}

