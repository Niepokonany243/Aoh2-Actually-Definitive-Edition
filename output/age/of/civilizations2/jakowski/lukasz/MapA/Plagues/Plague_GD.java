/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.PlagueProvince_GameData;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_Disease;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plague_GD
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName;
    private int iPlagueID_InGame = 0;
    public List<Integer> provinces = new ArrayList<Integer>();
    public int iProvincesSize = 0;
    public List<Integer> lProvinces_Active = new ArrayList<Integer>();
    public float deathRate = 0.0f;
    public int iDurationTurnsLeft = 0;
    private int deaths = 0;
    public int iDurationTurnsLeft_BEGINNING = 0;
    public float fR;
    public float fG;
    public float fB;
    public float EXPANSION_MODIFIER;
    public float EXPANSION_SCORE;

    public Plague_GD(int outbreakProvince, String sName, float fR, float fG, float fB, int nPlagueID_InGame, float deathRate, int iDurationTurnsLeft, float EXPANSION_MODIFIER) {
        this.sName = sName;
        this.iPlagueID_InGame = nPlagueID_InGame;
        this.fR = fR;
        this.fG = fG;
        this.fB = fB;
        this.deathRate = deathRate;
        this.iDurationTurnsLeft = iDurationTurnsLeft;
        this.iDurationTurnsLeft_BEGINNING = iDurationTurnsLeft;
        this.EXPANSION_MODIFIER = EXPANSION_MODIFIER;
        this.addProvince(outbreakProvince);
    }

    public final void runDisease() {
        for (int i = this.lProvinces_Active.size() - 1; i >= 0; --i) {
            if (CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague == null || CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague.iPlagueID_InGame != this.getPlagueID_InGame()) continue;
            long nPopBefore = CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getPops();
            int nDeaths = (int)Math.ceil((float)nPopBefore * (this.deathRate * (1.0f + CFG.core.getGameScenars().getScenario_DiseasesDeathRate_Modifier()) * (0.225f + 0.325f * this.getDurationPercLEFT() + 0.55f * (float)CFG.oR.nextInt(100) / 100.0f)));
            for (int k = CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getNatsSize() - 1; k >= 0; --k) {
                CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().setPopulationOfCivID(CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getCivID(k), (int)((double)CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getPopulationID(k) - Math.floor((float)nDeaths * ((float)CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getPopulationID(k) / (float)nPopBefore))));
            }
            CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague.iDeaths += (nPopBefore -= CFG.core.getProv(this.lProvinces_Active.get(i)).getPop().getPops());
            CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.iPlaguesDeaths += nPopBefore;
            this.deaths += nPopBefore;
            CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague.iDurationTurnsLeft -= 0.875f - 0.065f * CFG.core.getProv(this.lProvinces_Active.get(i)).getGrowthRate_Pop_WithFarm() + (float)CFG.oR.nextInt(825) / 1000.0f;
            if (!(CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague.iDurationTurnsLeft <= 0.0f)) continue;
            CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.iLastPlagueTurnID = GameCalendar.TURNID;
            CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).provGD.provincePlague = null;
            this.lProvinces_Active.remove(i);
        }
        this.deathRate = this.deathRate * (1.0f + CFG.core.getGameScenars().getScenario_DiseasesDeathRate_Modifier()) * (0.965f - (float)CFG.oR.nextInt(875) / 10000.0f);
    }

    public final void spreadDisease() {
        if (this.iDurationTurnsLeft > 0 && !this.lProvinces_Active.isEmpty()) {
            int nRand;
            if ((float)this.provinces.size() / (float)CFG.core.getProvinSize() > 0.35f) {
                return;
            }
            this.EXPANSION_SCORE += (float)this.lProvinces_Active.size() * 0.425f * this.EXPANSION_MODIFIER * (0.1f + 0.9f * this.getDurationPercLEFT());
            this.EXPANSION_MODIFIER *= 0.925f - (float)CFG.oR.nextInt(17850) / 100000.0f;
            if (this.EXPANSION_SCORE >= 1.0f && (nRand = CFG.oR.nextInt((int)this.EXPANSION_SCORE)) > 0) {
                this.EXPANSION_SCORE -= (float)nRand;
                this.spreadDisease(nRand);
            }
        }
    }

    public final void spreadDisease(int nNumOfProvinces) {
        try {
            nNumOfProvinces = (int)Math.min((float)nNumOfProvinces, Math.max((float)CFG.core.getProvinSize() * 0.01425f, 16.0f));
            ArrayList<Integer> tPossibleSpreadProvinces = new ArrayList<Integer>();
            ArrayList<Integer> tPossibleSpreadProvinces_Scores = new ArrayList<Integer>();
            for (int i = 0; i < this.lProvinces_Active.size(); ++i) {
                int k;
                if (CFG.core.getProv(this.lProvinces_Active.get(i)).getSeaProv()) {
                    for (k = 0; k < CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvincesSize(); ++k) {
                        if (CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighProvinces((int)k)).provGD.provincePlague != null || GameCalendar.TURNID - CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighProvinces((int)k)).provGD.iLastPlagueTurnID <= 38) continue;
                        tPossibleSpreadProvinces.add(CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvinces(k));
                    }
                    continue;
                }
                for (k = 0; k < CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvincesSize(); ++k) {
                    if (CFG.core.getProv(CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvinces(k)).getWastelandLvl() >= 0 || CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighProvinces((int)k)).provGD.provincePlague != null || GameCalendar.TURNID - CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighProvinces((int)k)).provGD.iLastPlagueTurnID <= 38) continue;
                    tPossibleSpreadProvinces.add(CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvinces(k));
                }
                if (CFG.core.getProv(this.lProvinces_Active.get(i)).getLvlOfPort() <= 0 && CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighProvincesSize() >= 2) continue;
                for (k = 0; k < CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighSeaProvincesSize(); ++k) {
                    if (CFG.core.getProv(CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighSeaProvinces(k)).getWastelandLvl() >= 0 || CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighSeaProvinces((int)k)).provGD.provincePlague != null || GameCalendar.TURNID - CFG.core.getProv((int)CFG.core.getProv((int)this.lProvinces_Active.get((int)i).intValue()).getNeighSeaProvinces((int)k)).provGD.iLastPlagueTurnID <= 38) continue;
                    tPossibleSpreadProvinces.add(CFG.core.getProv(this.lProvinces_Active.get(i)).getNeighSeaProvinces(k));
                }
            }
            if (!tPossibleSpreadProvinces.isEmpty()) {
                int tTotalScore = 0;
                for (int i = tPossibleSpreadProvinces.size() - 1; i >= 0; --i) {
                    int tempScore = this.getSpreadScore((Integer)tPossibleSpreadProvinces.get(i)) * 3 + 1;
                    tPossibleSpreadProvinces_Scores.add(tempScore);
                    tTotalScore += tempScore;
                }
                if (tTotalScore > 0) {
                    block7: while (!tPossibleSpreadProvinces_Scores.isEmpty() && nNumOfProvinces > 0) {
                        int tRandScore = CFG.oR.nextInt(tTotalScore);
                        int tCurrentScore = 0;
                        for (int i = 0; i < tPossibleSpreadProvinces_Scores.size(); ++i) {
                            if ((tCurrentScore += ((Integer)tPossibleSpreadProvinces_Scores.get(i)).intValue()) <= tRandScore) continue;
                            this.addProvince((Integer)tPossibleSpreadProvinces.get(i));
                            tTotalScore -= ((Integer)tPossibleSpreadProvinces_Scores.get(i)).intValue();
                            tPossibleSpreadProvinces_Scores.remove(i);
                            tPossibleSpreadProvinces.remove(i);
                            --nNumOfProvinces;
                            continue block7;
                        }
                    }
                    if (nNumOfProvinces > 0) {
                        this.spreadDisease(nNumOfProvinces);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final int getSpreadScore(int nProvinceID) {
        int k;
        int tempScore = 0;
        for (k = 0; k < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++k) {
            if (CFG.core.getProv((int)CFG.core.getProv((int)nProvinceID).getNeighProvinces((int)k)).provGD.provincePlague != null) continue;
            tempScore += CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(k)).getSeaProv() ? 1 : 2;
        }
        for (k = 0; k < CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize(); ++k) {
            if (CFG.core.getProv((int)CFG.core.getProv((int)nProvinceID).getNeighSeaProvinces((int)k)).provGD.provincePlague != null) continue;
            tempScore += CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighSeaProvinces(k)).getSeaProv() ? 1 : 2;
        }
        return tempScore;
    }

    public final void addProvince(int nProvinceID) {
        for (int i = 0; i < this.iProvincesSize; ++i) {
            if (this.provinces.get(i) != nProvinceID) continue;
            return;
        }
        CFG.core.getProv((int)nProvinceID).provGD.iLastPlagueTurnID = GameCalendar.TURNID;
        if (CFG.core.getProv((int)nProvinceID).provGD.provincePlague != null) {
            return;
        }
        CFG.core.getProv((int)nProvinceID).provGD.provincePlague = new PlagueProvince_GameData(this.iPlagueID_InGame, GameCalendar.TURNID, (float)this.iDurationTurnsLeft * (0.625f + (float)CFG.oR.nextInt(6000) / 10000.0f), 0);
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getIsPlayer()) {
            CFG.core.getCiv((int)CFG.core.getProv((int)nProvinceID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Disease(CFG.core.getProv(nProvinceID).getCivId(), nProvinceID));
        }
        this.provinces.add(nProvinceID);
        this.lProvinces_Active.add(nProvinceID);
        this.iProvincesSize = this.provinces.size();
    }

    public final String getPlagueName() {
        try {
            return this.sName;
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Plague");
        }
    }

    public final void setPlagueID_InGame(int iPlagueID_InGame) {
        this.iPlagueID_InGame = iPlagueID_InGame;
    }

    public final int getPlagueID_InGame() {
        return this.iPlagueID_InGame;
    }

    public final float getDurationPercLEFT() {
        return (float)this.iDurationTurnsLeft / (float)this.iDurationTurnsLeft_BEGINNING;
    }

    public final float getDurationPercLEFT(int nNumOfTurns) {
        return (float)nNumOfTurns / (float)this.iDurationTurnsLeft_BEGINNING;
    }

    public final int getOutbreakProvinceID() {
        try {
            return this.provinces.get(0);
        }
        catch (IndexOutOfBoundsException ex) {
            return -1;
        }
    }

    public final int getDeaths() {
        return this.deaths;
    }

    public final int getNumOfProvinces_Total() {
        return this.provinces.size();
    }

    public final int getNumOfProvinces_Active() {
        return this.lProvinces_Active.size();
    }
}

