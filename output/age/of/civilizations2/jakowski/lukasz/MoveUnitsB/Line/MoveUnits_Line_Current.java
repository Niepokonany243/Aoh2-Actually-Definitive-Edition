/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MoveUnits_Line_Current
extends MoveUnits_Line {
    public MoveUnits_Line_Current(int fromProvinceID, int toProvinceID) {
        super(fromProvinceID, toProvinceID);
        MOVE_WIDTH = this.getImageID().getWidth();
    }

    @Override
    public void updateColor(SpriteBatch oSB) {
        try {
            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID)).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID)).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID)).getB() / 255.0f, 1.0f);
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(Color.WHITE);
        }
    }
}

