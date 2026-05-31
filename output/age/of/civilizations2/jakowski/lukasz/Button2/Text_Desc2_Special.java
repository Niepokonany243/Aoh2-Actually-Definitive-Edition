
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text_Desc2_Special
extends Text_Desc {
    public Text_Desc2_Special(String sText, int iPosX, int iPosY, int iWidth) {
        super(sText, iPosX, iPosY, iWidth);
    }

    public Text_Desc2_Special(String sText, int iPosX, int iPosY, int iWidth, int fontID) {
        super(sText, iPosX, iPosY, iWidth, fontID);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, this.getIsHovered() || isActive ? 0.5f : 0.25f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.3f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.3f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.25f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() + 2, this.getHeightE() + 2, 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.9f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        for (int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, (String)this.sLines.get(i), this.getPosXE() + this.getPadding() + iTranslateX, this.getPosY() + this.getPaddingY() + (this.iTextHeight + CFG.PADD * 2) * i + iTranslateY, this.getColor(isActive));
        }
    }

    @Override
    protected Color getColor(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }
}

