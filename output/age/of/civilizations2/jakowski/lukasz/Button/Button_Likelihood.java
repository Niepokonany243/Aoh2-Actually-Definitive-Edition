
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Likelihood
extends ButtonM {
    private long lTime;
    public static final int ANIMATION_TIME = 375;
    private float fPerc = 1.0f;
    private String sLikelihood;
    private int iLikelihoodwidth;
    private String sRes;
    private int iResWidth;

    public Button_Likelihood(float fPerc, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init("", 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2), true, true, false, false, null);
        this.fPerc = fPerc;
        this.lTime = System.currentTimeMillis();
        this.sLikelihood = CFG.lang.get("LikelihoodOfSuccess") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sLikelihood);
        this.iLikelihoodwidth = (int)CFG.glyphLay.width;
        this.sRes = fPerc > 0.5f ? CFG.lang.get("High") : CFG.lang.get("Low");
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sRes);
        this.iResWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        float drawPerc = this.fPerc;
        if (this.lTime + 375L > System.currentTimeMillis()) {
            drawPerc = this.fPerc * (float)(System.currentTimeMillis() - this.lTime) / 375.0f;
            CFG.setRenderO(true);
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.2f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.175f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.375f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 4 / 5);
        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, this.getIsHovered() || isActive ? 0.4f : 0.475f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.8f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getWidthE() / 10 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 10, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 10, this.getHeightE(), false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.625f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.375f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        Renderer.drawText(oSB, this.fontID, this.sLikelihood, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iLikelihoodwidth - this.iResWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.getColorE(isActive));
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, this.getIsHovered() || isActive ? 0.85f : 0.7f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, this.getIsHovered() || isActive ? 0.425f : 0.325f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE2.r, CFG.COLOR_NEW_GAME_EDGE_LINE2.g, CFG.COLOR_NEW_GAME_EDGE_LINE2.b, this.getIsHovered() || isActive ? 0.55f : 0.425f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE2.r, CFG.COLOR_NEW_GAME_EDGE_LINE2.g, CFG.COLOR_NEW_GAME_EDGE_LINE2.b, 0.375f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE() - 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - 2);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sRes, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iResWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.fPerc > 0.5f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
        oSB.setColor(Color.WHITE);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : new Color(CFG.COLOR_BUTTON_MENU_TEXT.r, CFG.COLOR_BUTTON_MENU_TEXT.g, CFG.COLOR_BUTTON_MENU_TEXT.b, 0.75f)) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LikelihoodOfSuccess") + ": "));
        nData.add(new ME_Hover_2Type_Text((float)this.getCurr() / 100.0f >= 0.5f ? CFG.lang.get("High") : CFG.lang.get("Low"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return (int)(this.fPerc * 100.0f);
    }
}

