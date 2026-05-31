
package age.of.civilizations2.jakowski.lukasz.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;

public class WorldReactions {
    public static final void worldReactions(int iModifier, int iAggressorCivID, int iCivB) {
        if (GameValues.gvDiplomacy.USE_NEW_WORLD_REACTIONS) {
            if (GameValues.gvDiplomacy.WORLD_REACTIONS_VASSALS_REACT) {
                WorldReactions.worldReactions_New(iModifier, iAggressorCivID, iCivB);
            } else {
                WorldReactions.worldReactions_New_WithoutVassals(iModifier, iAggressorCivID, iCivB);
            }
        } else {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || i == iAggressorCivID || i == iCivB || CFG.core.getCivsAtWar(i, iAggressorCivID)) continue;
                float tDistance = Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(i).getCapitalProvID(), CFG.core.getCiv(iCivB).getCapitalProvID());
                float out = -(tDistance < GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_LIMIT ? (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_BASE_IMPACT_DIVISOR * (1.0f - tDistance) : 0.0f) + (float)iModifier * (-(CFG.core.getCivRelationOfCivB(i, iCivB) + (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_RELATION_SCALING_DIVISOR) / 100.0f) * Math.max(1.0f - tDistance * GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_MULTIPLIER, 0.01f);
                out = Math.max(-GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                out = Math.min(GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                CFG.core.setCivRelationOfCivB(i, iAggressorCivID, CFG.core.getCivRelationOfCivB(i, iAggressorCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(i, iAggressorCivID) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(i, iAggressorCivID) + out);
                CFG.core.setCivRelationOfCivB(iAggressorCivID, i, CFG.core.getCivRelationOfCivB(iAggressorCivID, i) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iAggressorCivID, i) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iAggressorCivID, i) + out);
            }
        }
    }

    public static void worldReactions_New(int iModifier, int iAggressorCivID, int iCivB) {
        try {
            for (int a = CFG.core.getCiv((int)iAggressorCivID).civsInRange.size() - 1; a >= 0; --a) {
                if (CFG.core.getCiv(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID).getNumOfProvs() <= 0 || CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID == iAggressorCivID || CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID == iCivB || CFG.core.getCivsAtWar(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID)) continue;
                float out = -(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance < GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_LIMIT ? (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_BASE_IMPACT_DIVISOR * (1.0f - CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance) : 0.0f) + (float)iModifier * (-(CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iCivB) + (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_RELATION_SCALING_DIVISOR) / 100.0f) * Math.max(1.0f - CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance * GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_MULTIPLIER, 0.01f);
                out = Math.max(-GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                out = Math.min(GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                CFG.core.setCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID, CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) + out);
                CFG.core.setCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) + out);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void worldReactions_New_WithoutVassals(int iModifier, int iAggressorCivID, int iCivB) {
        try {
            for (int a = CFG.core.getCiv((int)iAggressorCivID).civsInRange.size() - 1; a >= 0; --a) {
                if (CFG.core.getCiv(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID).getPuppetOfCiv() != CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID || CFG.core.getCiv(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID).getNumOfProvs() <= 0 || CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID == iAggressorCivID || CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID == iCivB || CFG.core.getCivsAtWar(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID)) continue;
                float out = -(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance < GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_LIMIT ? (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_BASE_IMPACT_DIVISOR * (1.0f - CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance) : 0.0f) + (float)iModifier * (-(CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iCivB) + (float)iModifier / GameValues.gvRelationsReactions.WORLD_REACTION_RELATION_SCALING_DIVISOR) / 100.0f) * Math.max(1.0f - CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).fDistance * GameValues.gvRelationsReactions.WORLD_REACTION_DISTANCE_MULTIPLIER, 0.01f);
                out = Math.max(-GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                out = Math.min(GameValues.gvRelationsReactions.WORLD_REACTION_MAX_CHANGE, out);
                CFG.core.setCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID, CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, iAggressorCivID) + out);
                CFG.core.setCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID, CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iAggressorCivID, CFG.core.getCiv((int)iAggressorCivID).civsInRange.get((int)a).iCivID) + out);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

