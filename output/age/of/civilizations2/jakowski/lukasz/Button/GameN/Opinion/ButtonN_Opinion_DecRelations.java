
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion.ButtonN_Opinion;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextD;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_Opinion_DecRelations
extends ButtonN_Opinion {
    public TextD decrease = new TextD(CFG.lang.get("DecreaseRelations") + ": ", CFG.FONT_BOLD_SMALL);
    public TextD decreaseValue;

    public ButtonN_Opinion_DecRelations(int iCivA, int iCivB, int nImageID, int nCost, int nDiploCost, int iPosX, int iPosY, int iWidth) {
        super(iCivA, iCivB, nImageID, nCost, nDiploCost, iPosX, iPosY, iWidth);
        this.decreaseValue = new TextD(CFG.getPrecision2(GameManager.getDecreaseRelation(iCivA, iCivB), 10), CFG.FONT_BOLD_SMALL);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
        int pX = this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.iCurrentRelationWidth + CFG.PADD * 3 / 4 + this.getTextWidthU() + IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.diploRelations).getWidth() * this.getImageScale(Images.diploRelations, 1.0f)) + iTranslateX;
        int pYI = this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 + iTranslateY;
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.decrease.text, pX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.decreaseValue.text, pX += this.decrease.textW, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_NEGATIVE_2);
        IMGManager.getIMG(Images.diploRelationsDec).draw(oSB, pX += this.decreaseValue.textW + CFG.PADD, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.diploRelationsDec).getHeight() * this.getImageScale(Images.diploRelationsDec, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRelationsDec).getWidth() * this.getImageScale(Images.diploRelationsDec, 1.0f)), (int)((float)IMGManager.getIMG(Images.diploRelationsDec).getHeight() * this.getImageScale(Images.diploRelationsDec, 1.0f)));
    }
}

