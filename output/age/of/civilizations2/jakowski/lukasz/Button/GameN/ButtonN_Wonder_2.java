
package age.of.civilizations2.jakowski.lukasz.Button.GameN;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonders_Manager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_Wonder_2
extends ButtonM {
    public boolean row = false;
    private int iProvinceID = 0;
    private String sDeathsTEXT;
    private int iDeathsTEXTWidth;
    public Color oColor;
    public int iImageID;
    public Color textColor;
    public int iWonderID;
    public String sPop;
    public int iPopWidth;
    public int imgPop = 0;
    public int fontID2 = 0;
    public Color colorPop;

    public ButtonN_Wonder_2(Color nColor, int nProvinceID, int nWonderID, int iPosX, int iPosY, int iWidth, String textPop, int imgPop, Color colorPop) {
        super.init(CFG.lang.get(CFG.core.getProv((int)nProvinceID).getWonder((int)nWonderID).sName), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.iProvinceID = nProvinceID;
        this.oColor = nColor;
        this.iWonderID = nWonderID;
        this.imgPop = imgPop;
        this.colorPop = colorPop;
        this.sDeathsTEXT = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID) ? (CFG.core.getProv(nProvinceID).getName().length() > 0 ? CFG.core.getProv(nProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCivName()) : CFG.lang.get("Undiscovered");
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.sPop = textPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sPop);
        this.iPopWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = Wonders_Manager.getHoverWonder(this.iProvinceID, this.iWonderID);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.core.getProv((int)this.iProvinceID).provGD.wonderBuilt) {
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.225f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonDiplomacy.iDiploWidth, this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.275f));
            IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonDiplomacy.iDiploWidth, this.getHeightE());
            IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonDiplomacy.iDiploWidth, CFG.PADD, false, true);
            IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD + iTranslateY, ButtonDiplomacy.iDiploWidth, CFG.PADD);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() / 2 - CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() + iTranslateY, CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getWidth(), CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight());
            Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId() >= 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.iProvinceID) ? CFG.core.getProv(this.iProvinceID).getCivId() : -1);
            oSB.setColor(Color.WHITE);
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDeathsTEXT, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sPop, this.getPosXE() + CFG.PADD * 2 + this.iDeathsTEXTWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.colorPop);
            IMGManager.getIMG(this.imgPop).draw(oSB, this.getPosXE() + CFG.PADD * 3 + this.iDeathsTEXTWidth + ButtonDiplomacy.iDiploWidth + this.iPopWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.imgPop).getWidth() * this.getImageScale2(this.imgPop, 1.0f)), (int)((float)IMGManager.getIMG(this.imgPop).getHeight() * this.getImageScale2(this.imgPop, 1.0f)));
            if (CFG.core.getProv((int)this.iProvinceID).provGD.wonderBuilt) {
                IMGManager.getIMG(Images.iconTrue).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.getTextWidthU() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.iconTrue).getWidth() * this.getImageScale2(Images.iconTrue, 1.0f)), (int)((float)IMGManager.getIMG(Images.btnV).getHeight() * this.getImageScale2(Images.iconTrue, 1.0f)));
            } else {
                IMGManager.getIMG(Images.iconFalse).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.getTextWidthU() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.iconFalse).getWidth() * this.getImageScale2(Images.iconFalse, 1.0f)), (int)((float)IMGManager.getIMG(Images.iconFalse).getHeight() * this.getImageScale2(Images.iconFalse, 1.0f)));
            }
        }
        catch (Exception exception) {
            
        }
    }

    public float getImageScale2(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }
}

