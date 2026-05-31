/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import com.badlogic.gdx.Gdx;

public class Editor_ShiftArmy
extends Editor {
    @Override
    public void keyDown(int keycode) {
        if (CFG.core.getActiveProvID() >= 0) {
            if (Gdx.input.isKeyPressed(21)) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyX(CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() - 1);
            }
            if (Gdx.input.isKeyPressed(22)) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyX(CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() + 1);
            }
            if (Gdx.input.isKeyPressed(19)) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyY(CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() - 1);
            }
            if (Gdx.input.isKeyPressed(20)) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyY(CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() + 1);
            }
            Editor_ShiftArmy.saveArmyPosition();
        }
    }

    public static final void saveArmyPosition() {
        CFG.core.saveProvince_Info_GameData_SHIFTXY(CFG.core.getActiveProvID());
    }

    @Override
    public String toString() {
        return "SHIFT ARMY: " + CFG.core.getActiveProvID();
    }
}

