
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

public class AchievementsManager {
    public static void unlockAchievement(String key) {
        try {
            sUM.sUI.setAchievement(key);
            sUM.sUI.storeStats();
        }
        catch (Exception exception) {
            
        }
    }

    public static void unlockFormable(String tag) {
        try {
            String tagReal = CFG.ideologiesMgr.getRealTag(tag);
            int len = Math.min(GameValues.gvAchievements.FROM_ACHIEVEMENT_TAG.length, GameValues.gvAchievements.FROM_CIV_TAG.length);
            for (int i = 0; i < len; ++i) {
                if (!tag.equals(GameValues.gvAchievements.FROM_CIV_TAG[i]) && !tagReal.equals(GameValues.gvAchievements.FROM_CIV_TAG[i])) continue;
                AchievementsManager.unlockAchievement(GameValues.gvAchievements.FROM_ACHIEVEMENT_TAG[i]);
            }
        }
        catch (Exception exception) {
            
        }
        try {
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.challengeID >= 0 && ChallengesManager.challengeList.get((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.challengeID).FORM_TAG.equals(tag)) {
                ChallengesManager.addChallengeCompleted(tag);
                CFG.toastM.addM(CFG.lang.get("ChallengeCompleted") + ": " + CFG.lang.getCiv(ChallengesManager.challengeList.get((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.challengeID).FORM_TAG), CFG.COLOR_POSITIVE);
                Core.addSimpleTask(new Core.SimpleTask("ChallengeCompleted"){

                    @Override
                    public void update() {
                        CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("ChallengeCompleted"), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName() + " - " + GameCalendar.getCurrDate(), Images.infoDiplomacy, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                });
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.challengeID = -1;
            }
        }
        catch (Exception exception) {
            
        }
    }
}

