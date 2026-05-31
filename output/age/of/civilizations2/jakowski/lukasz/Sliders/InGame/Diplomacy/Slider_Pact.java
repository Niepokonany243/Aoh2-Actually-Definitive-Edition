/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Slider_Pact
extends Slider_BG {
    public int iCivA = 0;
    public int iCivB = 0;

    public Slider_Pact(int iCivA, int iCivB, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.iCivA = iCivA;
        this.iCivB = iCivB;
    }

    public Slider_Pact(int iCivA, int iCivB, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iCivA, iCivB, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_Pact(int iCivA, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.iCivA = iCivA;
    }

    public Slider_Pact(int iCivA, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iCivA, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE());
        oSB.setColor(CFG.getPactColor((int)this.getCurr(), 0.68f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(0.97f, 0.97f, 0.97f, 0.68f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_SLIDER_BORDER.r, CFG.COLOR_SLIDER_BORDER.g, CFG.COLOR_SLIDER_BORDER.b, this.getIsClickable() ? 1.0f : 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, 1, this.getHeightE());
        this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(Color.WHITE);
        this.drawSliderBorder(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    @Override
    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * ((float)this.getTextHeight() / (float)IMGManager.getIMG(Images.time).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.time).getHeight() / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.time).getWidth() * ((float)this.getTextHeight() / (float)IMGManager.getIMG(Images.time).getHeight())), (int)((float)IMGManager.getIMG(Images.time).getHeight() * ((float)this.getTextHeight() / (float)IMGManager.getIMG(Images.time).getHeight())));
        Renderer.drawText(oSB, this.fontID, "" + this.getCurr(), this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * ((float)this.getTextHeight() / (float)IMGManager.getIMG(Images.time).getHeight())) - (int)CFG.glyphLay.width + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.16862746f, 0.3019608f, 0.5137255f, 1.0f));
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NonAggressionPact") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.getCurr(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}
