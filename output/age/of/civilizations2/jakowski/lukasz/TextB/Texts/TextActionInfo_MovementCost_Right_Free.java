/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_MovementCost_Right;
import com.badlogic.gdx.graphics.Color;

public class TextActionInfo_MovementCost_Right_Free
extends TextActionInfo_MovementCost_Right {
    public TextActionInfo_MovementCost_Right_Free(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_FREE_MOVE_ACTIVE : (this.getIsHovered() ? CFG.COLOR_FREE_MOVE_HOVER : CFG.COLOR_FREE_MOVE);
    }
}

