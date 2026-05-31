
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextProvincesTech
extends Text {
    public int civID = 0;
    public TextD provincesNum;
    public TextD attack;
    public TextD defense;

    public TextProvincesTech(String sText, int iPosX, int iPosY, int fontID) {
        super(sText, iPosX, iPosY, fontID);
        this.setCurr(0);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.civID = nCurrent;
        this.provincesNum = new TextD(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.civID).getNumOfProvs()));
        this.attack = new TextD("" + CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(this.civID), 1) + "%");
        this.defense = new TextD("" + CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(this.civID), 1) + "%");
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        int pX = this.getPosXE() + iTranslateX;
        int img = Images.provinces;
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX, this.getPosY() + this.getHeightE() / 2 - imgH / 2 + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.provincesNum.text, pX += imgW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        img = Images.attack;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.provincesNum.textW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - imgH / 2 + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.attack.text, pX += imgW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
        img = Images.defense;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.attack.textW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - imgH / 2 + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.defense.text, pX += imgW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
        pX += this.defense.textW + CFG.PADD;
    }

    public float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public class TextD {
        public String text;
        public int textW;

        public TextD(String nText) {
            this.text = nText;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.text);
            this.textW = (int)CFG.glyphLay.width;
        }
    }
}

