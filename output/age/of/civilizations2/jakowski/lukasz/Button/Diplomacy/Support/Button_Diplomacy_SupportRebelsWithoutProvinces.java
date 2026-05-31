
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Support;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Support.Button_Diplomacy_SupportRebels;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_SupportRebelsWithoutProvinces
extends Button_Diplomacy_SupportRebels {
    public Button_Diplomacy_SupportRebelsWithoutProvinces(int i, int iCivA, long iPopulation, int iRevolutionaryRisk, int nProvinces, int iPosX, int iPosY, int iWidth) {
        super(i, iCivA, iPopulation, iRevolutionaryRisk, nProvinces, iPosX, iPosY, iWidth);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivA);
        IMGManager.getIMG(Images.diploRevolution).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iRevolutionaryRiskWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution)) / 2 - IMGManager.getIMG(Images.diploRevolution).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)), (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution)));
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 5 - this.iRevolutionaryRiskWidth - this.iPopulationWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)) / 2 - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iRevolutionaryRisk + "%", this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iRevolutionaryRiskWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, this.iRevolutionaryRisk, 2000, 1.0f));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.sPopulation, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - this.iRevolutionaryRiskWidth - this.iPopulationWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.COLOR_POPULATION);
        oSB.setColor(Color.WHITE);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}


