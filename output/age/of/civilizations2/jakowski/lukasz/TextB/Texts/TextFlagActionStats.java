
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextFlagActionStats
extends Text {
    private String s2;
    private int iS2Width = 0;
    private Color oColor2;

    public TextFlagActionStats(String sText, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 - 1);
        this.s2 = "";
        this.oColor2 = Color.WHITE;
        this.setTextE(sText);
        this.textPosition = new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    public TextFlagActionStats(String sText, String s2, Color oColor2, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 - 1);
        this.s2 = s2;
        this.oColor2 = oColor2;
        this.setTextE(sText);
        this.textPosition = new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.375f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
            oSB.setColor(Color.WHITE);
        }
        Renderer.drawText(oSB, this.fontID, this.sText, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawText(oSB, this.fontID, this.s2, this.getPosXE() + this.getTextPosElem() + this.iTextWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.oColor2);
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.s2);
            this.iS2Width = (int)CFG.glyphLay.width;
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth) {
                this.setWidthE(this.iTextWidth);
            }
            if (this.getHeightE() < this.iTextHeight) {
                this.setHeightE(this.iTextHeight);
            }
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    @Override
    public int getWidthE() {
        return super.getWidthE() + this.iS2Width;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

