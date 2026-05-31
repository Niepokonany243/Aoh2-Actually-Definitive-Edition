/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line_Migrate;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MoveUnits_Line_MigrateHighlighted
extends MoveUnits_Line_Migrate {
    public MoveUnits_Line_MigrateHighlighted(int fromProvinceID, int toProvinceID) {
        super(fromProvinceID, toProvinceID);
    }

    @Override
    public void updateColor(SpriteBatch oSB) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)((CFG.core.getProv(this.getFromProvinceID()).getSeaProv() ? 45 : 75) + (CFG.core.getProvinceAnimation_Active_Data().getBackAnimation() ? 30 - CFG.core.getProvinceAnimation_Active_Data().getStepID() : CFG.core.getProvinceAnimation_Active_Data().getStepID())) / 255.0f));
    }
}

