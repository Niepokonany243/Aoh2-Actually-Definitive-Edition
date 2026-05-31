/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TechResearched;

public class TechManager {
    public static float fAverageTechLevel = 0.5f;

    public static final void updateAverageTechLevel() {
        fAverageTechLevel = 1.0f;
        int numOfCivs = 1;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            fAverageTechLevel += CFG.core.getCiv(i).getTechLevel();
            ++numOfCivs;
        }
        fAverageTechLevel /= (float)numOfCivs;
    }

    public static final int getResearchNextLevel(int nCivID) {
        return (int)(Math.pow((float)GameValues.gvResearch.POINTS_REQUIRED_PER_LEVEL_BASE + GameValues.gvResearch.POINTS_REQUIRED_PER_LEVEL_PER_PROVINCE * (float)CFG.core.getCiv(nCivID).getNumOfProvs() + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvResearch.POINTS_REQUIRED_STARTING_POPULATION_MODIFIER * (CFG.core.getCiv(nCivID).getTechLevel() + GameValues.gvResearch.POINTS_REQUIRED_TECH_LEVEL_BASE + GameValues.gvResearch.POINTS_REQUIRED_TECH_LEVEL_BASE_MODIFIER * CFG.core.getCiv(nCivID).getTechLevel()), GameValues.gvResearch.POINTS_REQUIRED_POWER_BASE + GameValues.gvResearch.POINTS_REQUIRED_POWER_TECH_MODIFIER * CFG.core.getCiv(nCivID).getTechLevel() + (CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvResearch.POINTS_REQUIRED_POWER_NUMERATOR_TECH_LEVEL_MULTIPLIER + 0.01f) / GameValues.gvResearch.POINTS_REQUIRED_POWER_TECH_LEVEL_DIVISOR) * (double)CFG.core.getCiv(nCivID).getTechLevel() / (double)fAverageTechLevel * (double)CFG.ideologiesMgr.getResearch(CFG.core.getCiv(nCivID).getIdeology(), nCivID));
    }

    public static final void updateResearch() {
        int i;
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI) {
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CAN_BECOME_CIVILIZED >= 0 && CFG.core.getCiv(i).getTechLevel() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CIVILIZE_TECH_LEVEL) {
                CFG.core.getCiv(i).addResearchProgressT((float)TechManager.getResearchNextLevel(i) * (GameValues.gvResearch.BASE_TRIBAL_RESEARCH_GAIN_MIN + (float)CFG.oR.nextInt(GameValues.gvResearch.BASE_TRIBAL_RESEARCH_GAIN_RANDOM_10000) / 10000.0f) * (GameValues.gvResearch.TRIBAL_RESEARCH_SCALING_FACTOR_TECH_BASE + GameValues.gvResearch.TRIBAL_RESEARCH_SCALING_FACTOR_TECH_MODIFIER * (1.0f - CFG.core.getCiv(i).getTechLevel() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CIVILIZE_TECH_LEVEL)) * (float)GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI);
            }
            TechManager.updateResearch(i);
        }
        if (!CFG.SPECTATOR_MODE) {
            for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0 && CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getTechLevel() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getIdeology()).CIVILIZE_TECH_LEVEL) {
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).addResearchProgressT((float)TechManager.getResearchNextLevel(CFG.core.getPlayer(i).getCivId()) * (GameValues.gvResearch.BASE_TRIBAL_RESEARCH_GAIN_MIN + (float)CFG.oR.nextInt(GameValues.gvResearch.BASE_TRIBAL_RESEARCH_GAIN_RANDOM_10000) / 10000.0f) * (GameValues.gvResearch.TRIBAL_RESEARCH_SCALING_FACTOR_TECH_BASE + GameValues.gvResearch.TRIBAL_RESEARCH_SCALING_FACTOR_TECH_MODIFIER * (1.0f - CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getTechLevel() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getIdeology()).CIVILIZE_TECH_LEVEL)));
                }
                TechManager.updateResearch(CFG.core.getPlayer(i).getCivId());
            }
        }
        if (GameCalendar.TURNID % 6 == 2) {
            TechManager.updateAverageTechLevel();
        }
    }

    public static void updateResearch(int nCivID) {
        TechManager.updateResearchOfCiv(nCivID, 0);
    }

    private static void updateResearchOfCiv(int i, int iterration) {
        if (CFG.core.getCiv(i).getNumOfProvs() > 0 && CFG.core.getCiv(i).getResearchProgressT() > (float)TechManager.getResearchNextLevel(i)) {
            int tID;
            CFG.core.getCiv(i).setResearchProgressT(CFG.core.getCiv(i).getResearchProgressT() - (float)TechManager.getResearchNextLevel(i));
            CFG.core.getCiv(i).setTechLevel_INT(CFG.core.getCiv(i).getTechLevelINT() + 1);
            CFG.core.getCiv(i).setGoldenAge_Science(CFG.core.getCiv(i).getGoldenAge_Science() + GameValues.gvGoldenAgeScience.RESEARCHED_TECHNOLOGY_GOLDEN_AGE_SCIENCE_SCORE);
            CFG.core.getCiv((int)i).getCivDiploGD().messageBox.addMessage(new Message_TechResearched(i));
            if (CFG.core.getCiv(i).getIsPlayer() && (tID = CFG.core.getPlayerIDbyCivID(i)) >= 0 && tID < CFG.core.getPlayersSize()) {
                CFG.core.getPlayer(tID).buildMetProvinces_BasedOnDistance();
            }
            for (int a = 0; a < CFG.core.getCiv(i).getNumOfProvs(); ++a) {
                CFG.core.getProv(CFG.core.getCiv(i).getProvID(a)).setHappi(CFG.core.getProv(CFG.core.getCiv(i).getProvID(a)).getHappi() + GameValues.gvTechnology.TECH_RESEARCHED_HAPPINESS_ALL_PROVINCES_BONUS);
            }
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CAN_BECOME_CIVILIZED >= 0 && CFG.core.getCiv(i).getCapitalProvID() >= 0 && i == CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getCivId()) {
                CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).setEco(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getEco() + GameValues.gvTribal.TECH_RESEARCHED_ECONOMY_CAPITAL + CFG.oR.nextInt(GameValues.gvTribal.TECH_RESEARCHED_ECONOMY_RANDOM_CAPITAL));
                CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).setDevLvl(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getDeveLvl() + GameValues.gvTribal.TECH_RESEARCHED_DEVELOPMENT_CAPITAL);
                CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).setHappi(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getHappi() + GameValues.gvTribal.TECH_RESEARCHED_HAPPINESS_CAPITAL);
            }
            if (iterration++ < 5) {
                TechManager.updateResearchOfCiv(i, iterration);
            }
        }
    }

    public static final void updateCivs_ResearchProgress() {
        int j;
        int i;
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI) {
            if (CFG.core.getCiv(i).getIsPlayer() || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            CFG.core.getCiv(i).addResearchProgressT(CFG.gameUpdate.getResearchSpending(i, CFG.core.getCiv((int)i).iBudget) * (1.0f + CFG.core.getCiv(i).getModifier_Research()) * (float)GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI);
        }
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI_PROVINCES; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI_PROVINCES) {
            if (CFG.core.getCiv(i).getIsPlayer() || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            for (j = 0; j < CFG.core.getCiv(i).getNumOfProvs(); ++j) {
                if (CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).getLvlOfLibrary() <= 0 || CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).isOccupied()) continue;
                CFG.core.getCiv(i).addResearchProgressT((float)CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).getPop().getPops() / (float)BuildingsManager.getLibrary_ResearchPerPopulation(CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).getLvlOfLibrary()) * CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).getProviStability() * (float)GameValues.gvUpdate.GAME_UPDATE_RESEARCH_AI_PROVINCES);
            }
        }
        if (!CFG.SPECTATOR_MODE) {
            for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0) continue;
                CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).addResearchProgressT(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(i).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getModifier_Research()));
                for (j = 0; j < CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs(); ++j) {
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getProvID(j)).getLvlOfLibrary() <= 0 || CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getProvID(j)).isOccupied()) continue;
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).addResearchProgressT((float)CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getProvID(j)).getPop().getPops() / (float)BuildingsManager.getLibrary_ResearchPerPopulation(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getProvID(j)).getLvlOfLibrary()) * CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getProvID(j)).getProviStability());
                }
            }
        }
        TechManager.updateResearch();
    }

    public static final void updateCivs_ResearchProgress_Migrate(int nCivID, int nProvinceID) {
        if (CFG.core.getCiv(nCivID).getNumOfProvs() > 0) {
            CFG.core.getCiv(nCivID).addResearchProgressT((float)TechManager.getResearchNextLevel(nCivID) * (CFG.core.getProv(nProvinceID).isCapital() ? GameValues.gvMigrate.MIGRATE_RESEARCH_PROGRESS : GameValues.gvMigrate.MIGRATE_RESEARCH_PROGRESS_NOT_CAPITAL));
        }
        TechManager.updateResearch(nCivID);
    }
}

