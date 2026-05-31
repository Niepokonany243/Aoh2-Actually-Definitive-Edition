
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEconomy_SliderDesc_Taxes
extends Text {
    public static final float TEXT_SCALE = 0.7f;
    public static final float TEXT2_SCALE = 0.85f;
    private int iImageID;
    private String sText2 = " " + CFG.lang.get("PerTurn");
    private int iText2Width = 0;
    private Color tColor;

    public TextEconomy_SliderDesc_Taxes(String sText, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, CFG.PADD, iPosX, iPosY, iWidth, iHeight);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sText2);
        this.iText2Width = (int)(CFG.glyphLay.width * 0.7f);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(Slider_InGame.bgColor);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)this.getTextWidthU() * 0.7f) - this.iText2Width - (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(0.85f, this.iImageID)) + iTranslateX, this.getPosY() - IMGManager.getIMG(this.iImageID).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(0.85f, this.iImageID))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(0.85f, this.iImageID)), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(0.85f, this.iImageID)));
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)this.getTextWidthU() * 0.7f) - this.iText2Width + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, this.tColor);
        CFG.drawTextDefaultWithShadow(oSB, this.sText2, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iText2Width + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.7f) / 2.0f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    private final float getImageScale(float fScale, int nImageID) {
        return (float)this.iTextHeight * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void setTextE(String sText) {
        super.setTextE(sText.substring(0, sText.length() > 7 ? 7 : sText.length()));
    }

    @Override
    public void setMax(int iMax) {
        this.iImageID = iMax == 0 ? Images.happiness : (iMax == 1 ? Images.happiness1 : Images.happiness2);
        this.tColor = iMax == 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2;
    }
}

