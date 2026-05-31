/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class Plagues_GameData {
    private String Name;
    public int BeginningYear;
    public int EndYear;
    public float OUTBREAK_CHANCE;
    public int OUTBREAK_PROVINCES;
    public int OUTBREAK_PROVINCES_EXTRA;
    public float OUTBREAK_SCORE_POPULATION;
    public float OUTBREAK_SCORE_ECONOMY;
    public float OUTBREAK_SCORE_DEVELOPMENT_LOW;
    public float OUTBREAK_SCORE_DEVELOPMENT;
    public float OUTBREAK_SCORE_HAPPINESS_LOW;
    public float OUTBREAK_SCORE_HAPPINESS;
    public int DURATION_TURNS_MIN;
    public int DURATION_TURNS_EXTRA;
    public float DEATH_RATE_MIN;
    public float DEATH_RATE_EXTRA;
    public float EXPANSION_MODIFIER;
    public float EXPANSION_MODIFIER_EXTRA;
    public float fR;
    public float fG;
    public float fB;
    public boolean Radiation = false;

    public Plagues_GameData(String Name, int BeginningYear, int EndYear, int DURATION_TURNS_MIN, int DURATION_TURNS_EXTRA, float DEATH_RATE_MIN, float DEATH_RATE_EXTRA, float EXPANSION_MODIFIER, float EXPANSION_MODIFIER_EXTRA, int R, int G, int B2, float OUTBREAK_CHANCE, int OUTBREAK_PROVINCES, int OUTBREAK_PROVINCES_EXTRA, float OUTBREAK_SCORE_POPULATION, float OUTBREAK_SCORE_ECONOMY, float OUTBREAK_SCORE_DEVELOPMENT, float OUTBREAK_SCORE_HAPPINESS, float OUTBREAK_SCORE_DEVELOPMENT_LOW, float OUTBREAK_SCORE_HAPPINESS_LOW, boolean Radiation) {
        this.Name = Name;
        if (EndYear < BeginningYear) {
            int tData = BeginningYear;
            BeginningYear = EndYear;
            EndYear = tData;
        }
        this.BeginningYear = BeginningYear;
        this.EndYear = EndYear;
        this.DURATION_TURNS_MIN = Math.max(DURATION_TURNS_MIN, 1);
        this.DURATION_TURNS_EXTRA = Math.max(DURATION_TURNS_EXTRA, 0);
        this.DEATH_RATE_MIN = Math.max(DEATH_RATE_MIN, 0.01f);
        this.DEATH_RATE_EXTRA = Math.max(DEATH_RATE_EXTRA, 0.0f);
        this.EXPANSION_MODIFIER = Math.max(EXPANSION_MODIFIER, 0.01f);
        this.EXPANSION_MODIFIER_EXTRA = Math.max(EXPANSION_MODIFIER_EXTRA, 0.0f);
        this.fR = (float)R / 255.0f;
        this.fG = (float)G / 255.0f;
        this.fB = (float)B2 / 255.0f;
        this.OUTBREAK_CHANCE = Math.max(OUTBREAK_CHANCE, 0.0f);
        this.OUTBREAK_PROVINCES = Math.min(Math.max(OUTBREAK_PROVINCES, 1), 10);
        this.OUTBREAK_PROVINCES_EXTRA = Math.max(OUTBREAK_PROVINCES_EXTRA, 0);
        this.OUTBREAK_SCORE_POPULATION = Math.min(Math.max(OUTBREAK_SCORE_POPULATION, -2.0f), 2.0f);
        this.OUTBREAK_SCORE_ECONOMY = Math.min(Math.max(OUTBREAK_SCORE_ECONOMY, -2.0f), 2.0f);
        this.OUTBREAK_SCORE_DEVELOPMENT = Math.min(Math.max(OUTBREAK_SCORE_DEVELOPMENT, -2.0f), 2.0f);
        this.OUTBREAK_SCORE_HAPPINESS = Math.min(Math.max(OUTBREAK_SCORE_HAPPINESS, -2.0f), 2.0f);
        this.OUTBREAK_SCORE_DEVELOPMENT_LOW = Math.min(Math.max(OUTBREAK_SCORE_DEVELOPMENT_LOW, -2.0f), 2.0f);
        this.OUTBREAK_SCORE_HAPPINESS_LOW = Math.min(Math.max(OUTBREAK_SCORE_HAPPINESS_LOW, -2.0f), 2.0f);
        this.Radiation = Radiation;
    }

    public final String getName() {
        return CFG.lang.get(this.Name);
    }

    public final String getName_Real() {
        return this.Name;
    }

    public final void setName(String Name) {
        this.Name = Name;
    }
}

