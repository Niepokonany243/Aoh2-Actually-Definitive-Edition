/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class StatsCivGD
implements Serializable {
    private static final long serialVersionUID = 0L;
    public String sTag = "";
    private int iGamesWon = 0;
    private long iConqueredProvinces = 0L;
    private long iTurns = 0L;
    private long iRecruitedArmy = 0L;
    private long iLargestArmy = 0L;
    private long iLargestPopulation = 0L;
    private long iBiggestEconomy = 0L;
    private int iBuiltForts = 0;
    private int iBuiltTowers = 0;
    private int iBuiltPorts = 0;
    private int iBuiltLibraries = 0;
    private int iBuiltSupplies = 0;
    private int iBuiltArmories = 0;
    private int iBuiltFarms = 0;
    private int iBuiltWorkshops = 0;

    public StatsCivGD() {
    }

    public StatsCivGD(String nTag) {
        this.sTag = nTag;
    }

    public final long getConqueredProvs() {
        return this.iConqueredProvinces;
    }

    public final void setConqueredProvinces(long iConqueredProvinces) {
        this.iConqueredProvinces = iConqueredProvinces;
    }

    public final long getTurns() {
        return this.iTurns;
    }

    public final void setTurns(long iTurns) {
        this.iTurns = iTurns;
    }

    public final long getRecruitedArmy() {
        return this.iRecruitedArmy;
    }

    public final void setRecruitedArmy(long iRecruitedArmy) {
        this.iRecruitedArmy = iRecruitedArmy;
    }

    public final int getGamesWon() {
        return this.iGamesWon;
    }

    public final void setGamesWon(int iGamesWon) {
        this.iGamesWon = iGamesWon;
    }

    public final long getBiggestEconomy() {
        return this.iBiggestEconomy;
    }

    public final void setBiggestEconomy(long iBiggestEconomy) {
        this.iBiggestEconomy = iBiggestEconomy;
    }

    public final long getLargestPopulation() {
        return this.iLargestPopulation;
    }

    public final void setLargestPopulation(long iLargestPopulation) {
        this.iLargestPopulation = iLargestPopulation;
    }

    public final long getLargestArmy() {
        return this.iLargestArmy;
    }

    public final void setLargestArmy(long iLargestArmy) {
        this.iLargestArmy = iLargestArmy;
    }

    public final int getiBuiltArmories() {
        return this.iBuiltArmories;
    }

    public final void setiBuiltArmories(int iBuiltArmories) {
        this.iBuiltArmories = iBuiltArmories;
    }

    public final int getiBuiltFarms() {
        return this.iBuiltFarms;
    }

    public final void setiBuiltFarms(int iBuiltFarms) {
        this.iBuiltFarms = iBuiltFarms;
    }

    public final int getiBuiltWorkshops() {
        return this.iBuiltWorkshops;
    }

    public final void setiBuiltWorkshops(int iBuiltWorkshops) {
        this.iBuiltWorkshops = iBuiltWorkshops;
    }

    public final int getiBuiltSupplies() {
        return this.iBuiltSupplies;
    }

    public final void setiBuiltSupplies(int iBuiltSupplies) {
        this.iBuiltSupplies = iBuiltSupplies;
    }

    public final int getiBuiltPorts() {
        return this.iBuiltPorts;
    }

    public final void setiBuiltPorts(int iBuiltPorts) {
        this.iBuiltPorts = iBuiltPorts;
    }

    public final int getiBuiltTowers() {
        return this.iBuiltTowers;
    }

    public final void setiBuiltTowers(int iBuiltTowers) {
        this.iBuiltTowers = iBuiltTowers;
    }

    public final int getiBuiltForts() {
        return this.iBuiltForts;
    }

    public final void setiBuiltForts(int iBuiltForts) {
        this.iBuiltForts = iBuiltForts;
    }

    public final int getiBuiltLibraries() {
        return this.iBuiltLibraries;
    }

    public final void setiBuiltLibraries(int iBuiltLibraries) {
        this.iBuiltLibraries = iBuiltLibraries;
    }
}

