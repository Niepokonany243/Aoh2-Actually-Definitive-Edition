/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEconomy_SliderDesc
extends Text {
    public static final float TEXT2_SCALE = 0.7f;
    public static final float TEXT3_SCALE = 0.6f;
    private String sText2;
    private int iText2Width;
    private String sText_Progress;
    private int iText_ProgressWidth;
    private String sText_ProgressPerc;

    public TextEconomy_SliderDesc(String sText, String sText2, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText2, CFG.PADD, iPosX, iPosY, iWidth, iHeight);
        this.sText2 = sText;
    }

    public TextEconomy_SliderDesc(String sText, String sText_Progress, String sText_ProgressPerc, String sText2, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText2, CFG.PADD, iPosX, iPosY, iWidth, iHeight);
        this.sText2 = sText;
        this.sText_Progress = sText_Progress;
        this.sText_ProgressPerc = sText_ProgressPerc;
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sText2);
        this.iText2Width = (int)(CFG.glyphLay.width * 0.7f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sText_Progress);
        this.iText_ProgressWidth = (int)(CFG.glyphLay.width * 0.7f);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() * 2 / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + this.getWidthE() + CFG.PADD * 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.research).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.research).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(0.7f, Images.research))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(0.7f, Images.research)), (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(0.7f, Images.research)));
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(0.7f, Images.technology)) + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.technology).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(0.7f, Images.technology))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(0.7f, Images.technology)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(0.7f, Images.technology)));
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText2, this.getPosXE() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(0.7f, Images.research)) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.drawTextDefaultWithShadow(oSB, this.sText_Progress, this.getPosXE() + this.iText2Width + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(0.7f, Images.research)) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)this.getTextWidthU() * 0.7f) - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(0.7f, Images.technology)) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, CFG.COLOR_NEUTRAL);
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText_ProgressPerc, this.getPosXE() + this.iText2Width + this.iText_ProgressWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(0.7f, Images.research)) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, CFG.COLOR_NEUTRAL);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    private final float getImageScale(float fScale, int nImageID) {
        return (float)this.iTextHeight * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }
}

