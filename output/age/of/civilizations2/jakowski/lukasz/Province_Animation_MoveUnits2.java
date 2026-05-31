/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Province_Animation_MoveUnits2 {
    private long lTimeLine;
    private int iLineOffset = 0;
    public int iLineOffsetInterval = 75;

    public final void resetData() {
        this.lTimeLine = System.currentTimeMillis();
        this.iLineOffset = 0;
    }

    public Province_Animation_MoveUnits2() {
        this.resetData();
    }

    public final void update() {
        if (this.lTimeLine < System.currentTimeMillis() - (long)this.iLineOffsetInterval) {
            ++this.iLineOffset;
            this.lTimeLine = System.currentTimeMillis();
            CFG.setRenderO(true);
        }
    }

    public void updateColor(SpriteBatch oSB, int nProvinceID) {
        if (CFG.core.getProv(nProvinceID).getSeaProv()) {
            oSB.setColor(new Color(CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), (float)CFG.core.getProvinceAnimation_Active_Data().getAlpha() / (nProvinceID == CFG.chosenProvinceID ? 1.75f : 4.0f) / 255.0f * (CFG.core.fDashedLine_Percentage_HighlitedProvinceBorder / 100.0f)));
        } else {
            oSB.setColor(new Color(CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), CFG.getColorStep(255, 55, CFG.core.getProvinceAnimation_Active_Data().getColorStepID(), 30), (float)CFG.core.getProvinceAnimation_Active_Data().getAlpha() / (nProvinceID == CFG.chosenProvinceID ? 1.0f : 2.0f) / 255.0f * (CFG.core.fDashedLine_Percentage_HighlitedProvinceBorder / 100.0f)));
        }
    }

    public int getLineOffset() {
        return this.iLineOffset;
    }

    public void setLineOffsetInterval(int iLineOffsetInterval) {
        this.iLineOffsetInterval = iLineOffsetInterval;
    }
}

