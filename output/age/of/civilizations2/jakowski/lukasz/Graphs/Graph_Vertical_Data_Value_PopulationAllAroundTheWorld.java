
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graph_Vertical_Data_Value_PopulationAllAroundTheWorld
extends Graph_Vertical_Data_Value {
    public Graph_Vertical_Data_Value_PopulationAllAroundTheWorld(int iValue, int iColorDataID) {
        super(iValue, iColorDataID);
    }

    @Override
    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, Color nColor) {
        oSB.setColor(this.getColor(0.35f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - nHeight - this.iHeight, nWidth, this.iHeight);
        oSB.setColor(this.getColor(0.7f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - nHeight - this.iHeight - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.iHeight, false, true);
        oSB.setColor(this.getColor(0.2f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - nHeight - this.iHeight - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 3, this.iHeight, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 3, nPosY - nHeight - this.iHeight - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 3, this.iHeight, true, false);
    }

    @Override
    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int nAnimationHeight, Color nColor) {
        oSB.setColor(this.getColor(0.35f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - nHeight - nAnimationHeight, nWidth, nAnimationHeight);
        oSB.setColor(this.getColor(0.7f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - nHeight - nAnimationHeight - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nAnimationHeight, false, true);
        oSB.setColor(this.getColor(0.2f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - nHeight - nAnimationHeight - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 3, nAnimationHeight, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 3, nPosY - nHeight - nAnimationHeight - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 3, nAnimationHeight, true, false);
    }

    public final Color getColor(float fAlpha) {
        try {
            return new Color((float)CFG.core.getCiv(this.iColorDataID).getR() / 255.0f, (float)CFG.core.getCiv(this.iColorDataID).getG() / 255.0f, (float)CFG.core.getCiv(this.iColorDataID).getB() / 255.0f, fAlpha);
        }
        catch (IndexOutOfBoundsException ex) {
            return new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, fAlpha);
        }
    }
}

