/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class Terrain_GameData3
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName = "";
    private String sIconName = "";
    private Color_GameData oColor;
    private float fMovementCost = 0.0f;
    private float fDefensiveModifier = 0.0f;
    private float fPopulationGrowthModifier = 0.0f;
    private float fEconomyGrowthModifier = 0.0f;
    private float fMilitaryUpkeepModifier = 0.0f;
    private float fBuildCostModifier = 0.0f;
    private float fBaseDevelopmentLevel = 0.0f;
    private int iBaseProvinceValue = 0;

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final String getIconName() {
        return this.sIconName;
    }

    public final void setIconName(String sIconName) {
        this.sIconName = sIconName;
    }

    public final Color_GameData getColor() {
        return this.oColor;
    }

    public final void setColor(Color_GameData oColor) {
        this.oColor = oColor;
    }

    public final float getDefensiveModifier() {
        return this.fDefensiveModifier;
    }

    public final void setDefensiveModifier(float fDefensiveModifier) {
        this.fDefensiveModifier = fDefensiveModifier;
    }

    public final float getPopulationGrowthModifier() {
        return this.fPopulationGrowthModifier;
    }

    public final void setPopulationGrowthModifier(float fPopulationGrowthModifier) {
        this.fPopulationGrowthModifier = fPopulationGrowthModifier;
    }

    public final float getEconomyGrowthModifier() {
        return this.fEconomyGrowthModifier;
    }

    public final void setEconomyGrowthModifier(float fEconomyGrowthModifier) {
        this.fEconomyGrowthModifier = fEconomyGrowthModifier;
    }

    public final float getBuildCostModifier() {
        return this.fBuildCostModifier;
    }

    public final void setBuildCostModifier(float fBuildCostModifier) {
        this.fBuildCostModifier = fBuildCostModifier;
    }

    public final float getMilitaryUpkeepModifier() {
        return this.fMilitaryUpkeepModifier;
    }

    public final void setMilitaryUpkeepModifier(float fMilitaryUpkeepModifier) {
        this.fMilitaryUpkeepModifier = fMilitaryUpkeepModifier;
    }

    public final float getMovementCost() {
        return this.fMovementCost;
    }

    public final void setMovementCost(float fMovementCost) {
        this.fMovementCost = fMovementCost;
    }

    public final float getBaseDevelopmentLevel() {
        return this.fBaseDevelopmentLevel;
    }

    public final void setBaseDevelopmentLevel(float fBaseDevelopmentLevel) {
        this.fBaseDevelopmentLevel = fBaseDevelopmentLevel;
    }

    public final int getBaseProvinceValue() {
        return this.iBaseProvinceValue;
    }

    public final void setBaseProvinceValue(int iBaseProvinceValue) {
        this.iBaseProvinceValue = iBaseProvinceValue;
    }
}

