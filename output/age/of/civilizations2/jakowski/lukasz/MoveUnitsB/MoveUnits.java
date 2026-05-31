/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line_Current;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line_Highlighted;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;

public class MoveUnits
implements Serializable {
    private int fromProvinceID;
    private int toProvinceID;
    private long numOfUnits;
    private int iNumOfUnitsWidth;
    private MoveUnits_Line moveUnits_Line = null;

    public MoveUnits(int fromProvinceID, int toProvinceID, long numOfUnits, boolean buildLine) {
        this.fromProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.setNumberOfUnits(numOfUnits);
        if (buildLine) {
            this.buildMoveUnitsLine();
        }
    }

    public MoveUnits(int fromProvinceID, int toProvinceID, long numOfUnits, boolean buildLine, boolean migrate) {
        this.fromProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.setNumberOfUnits(numOfUnits);
        if (buildLine) {
            if (migrate) {
                this.buildMoveUnitsLine_Migrate();
            } else {
                this.buildMoveUnitsLine();
            }
        }
    }

    public void draw(SpriteBatch oSB, float nScale) {
        if (this.moveUnits_Line != null) {
            this.moveUnits_Line.drawLine(oSB, nScale);
        }
    }

    public void draw2(SpriteBatch oSB, float nScale) {
        if (this.moveUnits_Line != null) {
            this.moveUnits_Line.drawLine(oSB, nScale);
        }
    }

    public final long getNumberOfUnits() {
        return this.numOfUnits;
    }

    public final void setNumberOfUnits(long iNumOfUnits) {
        this.numOfUnits = iNumOfUnits;
        try {
            CFG.glyphLay.setText(CFG.fontArmy, CFG.getNumber_SHORT_ARMY(iNumOfUnits));
            this.iNumOfUnitsWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            this.iNumOfUnitsWidth = 0;
        }
    }

    public final int getFromProviID() {
        return this.fromProvinceID;
    }

    public final int getToProvID() {
        return this.toProvinceID;
    }

    public final MoveUnits_Line getMoveUnits_Line() {
        if (this.moveUnits_Line == null) {
            this.buildMoveUnitsLine();
        }
        return this.moveUnits_Line;
    }

    public final int getUnitsWidth() {
        return this.iNumOfUnitsWidth;
    }

    public final void buildMoveUnitsLine() {
        this.moveUnits_Line = new MoveUnits_Line_Current(this.fromProvinceID, this.toProvinceID);
    }

    public final void buildMoveUnitsLine_Migrate() {
        this.moveUnits_Line = new MoveUnits_Line_Highlighted(this.fromProvinceID, this.toProvinceID);
    }

    public static interface LittleAnimation {
        public void update();
    }
}
