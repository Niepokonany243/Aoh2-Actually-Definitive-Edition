/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Title;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleM_TextSmallOpinion
extends TitleM {
    public String sOpinion;
    public int iOpinionWidth;
    public Color opinionColor;
    public String sDiplomacy;

    public TitleM_TextSmallOpinion(String sText, int iHeight, boolean moveable, boolean resizable, int iOpinion, String sDiplomacy) {
        super(sText, iHeight, moveable, resizable);
        this.sDiplomacy = sDiplomacy;
        this.sOpinion = iOpinion == GameValues.gvDiplomacy.RELATION_AT_WAR ? CFG.lang.get("AtWar") : "" + (iOpinion > 0 ? "+" : "") + iOpinion;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sOpinion);
        this.iOpinionWidth = (int)CFG.glyphLay.width;
        this.opinionColor = iOpinion == 0 ? CFG.COLOR_NEUTRAL : (iOpinion > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
    }

    @Override
    public void drawText(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
    }

    @Override
    public void setText(String sText) {
        this.sText = sText;
        this.setTextWidth(-1);
        if (sText != null && this.getTextWidth() < 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), sText);
            this.setTextWidth((int)CFG.glyphLay.width);
            this.setTextHeight((int)CFG.glyphLay.height);
        }
    }
}

