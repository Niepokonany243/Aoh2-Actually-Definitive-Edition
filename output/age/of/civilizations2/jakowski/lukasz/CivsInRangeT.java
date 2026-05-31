
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class CivsInRangeT
extends Thread {
    public static int DONE_CIVS = 1;

    @Override
    public void run() {
        try {
            DONE_CIVS = 1;
            int i = 1;
            while (i < CFG.core.getCivsSize()) {
                if (CFG.core.getCiv(i).getNumOfProvs() > 0) {
                    CFG.oAI.getAIStyle(CFG.core.getCiv(i).getAIStyleID()).diplomacyActions_BuildCivsInRange(i);
                }
                DONE_CIVS = i++;
            }
        }
        finally {
            DONE_CIVS = CFG.core.getCivsSize();
        }
        CFG.setRenderO(true);
    }
}

