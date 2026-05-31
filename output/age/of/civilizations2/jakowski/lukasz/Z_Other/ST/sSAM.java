
package age.of.civilizations2.jakowski.lukasz.Z_Other.ST;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

public class sSAM {
    public static void unlockAchievement(String key) {
        try {
            sUM.sUI.setAchievement(key);
            sUM.sUI.storeStats();
        }
        catch (Exception exception) {
            
        }
    }
}

