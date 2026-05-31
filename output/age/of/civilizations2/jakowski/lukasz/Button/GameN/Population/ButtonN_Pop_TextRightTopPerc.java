
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Population;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_Pop_TextRightTopPerc
extends ButtonN_Pop {
    public String sTime;
    public int iTimeWidth;
    public int imageRight = 0;
    public float fPerc = 1.0f;

    public ButtonN_Pop_TextRightTopPerc(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, String textRight, int imageRight, float fPerc) {
        super(nColor, sText, nCivID, sTextLeft, nPop, iImageID, textColor, iPosX, iPosY, iWidth);
        this.imageRight = imageRight;
        this.fPerc = fPerc;
        this.sTime = textRight;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTime);
        this.iTimeWidth = (int)CFG.glyphLay.width;
    }

    public Color getColorProgress() {
        return new Color(CFG.COLOR_NEUTRAL2.r, CFG.COLOR_NEUTRAL2.g, CFG.COLOR_NEUTRAL2.b, 0.7f);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        int nX = this.getPosXE() + ButtonN_Pop_TextRightTopPerc.getLeftFlagWidth() + CFG.PADD + iTranslateX;
        int nY = this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD + iTranslateY;
        int nW = this.getWidthE() - ButtonN_Pop_TextRightTopPerc.getLeftFlagWidth() - CFG.PADD * 2;
        int nH = CFG.PADD;
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, nH);
        oSB.setColor(this.getColorProgress());
        if ((int)((float)nW * this.fPerc) > 0) {
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, (int)((float)nW * this.fPerc), nH - 2);
        }
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.65f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, 1);
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 1, nW, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, nW, 1);
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 2, nW, 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.imageRight).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f)) - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)), (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTime, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iTimeWidth - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD / 2 + iTranslateY, this.getColorRight());
    }

    public Color getColorRight() {
        return CFG.COLOR_TEXT_GRAY_NS_HOVER;
    }
}

