
package age.of.civilizations2.jakowski.lukasz.Z_Other.ST;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;

public class sSPT implements Runnable {
    private final String key;

    public sSPT(String key) {
        this.key = key;
    }

    @Override
    public void run() {
        GameTaskScheduler.checkpoint();
        sUM.createItem(key);
    }
}

