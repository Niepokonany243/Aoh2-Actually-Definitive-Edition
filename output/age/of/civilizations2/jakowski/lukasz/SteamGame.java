/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

public class SteamGame {
    public boolean steamInit = false;

    public void unlockAchSt(String key) {
        try {
            sUM.sUI.setAchievement(key);
            sUM.sUI.storeStats();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public int getStatI(String name) {
        sUM.sUI.storeStats();
        return 0;
    }

    public float getStatF(String name) {
        sUM.sUI.storeStats();
        return 0.0f;
    }

    public boolean setStatI(String name, int value) {
        sUM.sUI.getStatI(name, 0);
        return true;
    }

    public void storeStats() {
        if (sUM.sUI == null) {
            return;
        }
        sUM.sUI.storeStats();
    }

    boolean requestCurrentStats() {
        sUM.sUI.storeStats();
        return true;
    }

    public boolean setAchievement(String key) {
        sUM.sUI.getStatI(key, 0);
        return true;
    }

    public boolean getAchievement(String key, boolean achieved) {
        sUM.sUI.getStatF(key, 0.0f);
        achieved = false;
        return true;
    }

    public boolean clearAchievement(String key) {
        sUM.sUI.getStatI(key, 0);
        return true;
    }

    public boolean setStatF(String name, float value) {
        sUM.sUI.getStatF(name, (int)(value * 100.0f));
        return true;
    }

    public boolean resetAllStats(boolean achievementsToo) {
        sUM.sUI.requestCurrentStats();
        return true;
    }
}

