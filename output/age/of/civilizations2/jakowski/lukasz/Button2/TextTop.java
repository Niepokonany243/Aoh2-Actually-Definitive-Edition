/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextTop
extends MenuElemUI {
    public static final int EXTRA_WIDTH_BOX_PADDING = CFG.PADD * 3;
    public String sText = null;
    public String sText2 = null;
    public int iTextWidth = -1;
    public int iTextHeight = -1;
    public int iTextPosX;
    public int fontID2 = 1;
    public int iTextWidth2 = -1;
    public int iTextHeight2 = -1;
    public int imageID;
    public int textPosY;
    protected static long lTimeAnimation = 0L;
    protected static int animationState = 0;
    public static final int ANIMATION_T = 1000;
    public SparksAnimation sparksAnimationTop = new SparksAnimation();
    public float lastValue = -997654.3f;
    public int WIDTH_LAST_TURN_UPDATE = 0;

    public TextTop(int imageID, String sText, String sText2, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.imageID = imageID;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(TextTop.getButtonHeight());
        this.iTextPosX = EXTRA_WIDTH_BOX_PADDING + IMGManager.getIMG(imageID).getWidth() + CFG.PADD * 2;
        this.fontID = CFG.FONT_BOLD;
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.setTextE(sText);
        this.setText2(sText2);
        this.textPosY = (this.getHeightE() - (this.iTextHeight + this.iTextHeight2 + CFG.PADD)) / 2;
    }

    public static final int getButtonHeight() {
        return Menu_InGame_2.topStatsHeight - TextTop.getButtonPadding() * 2;
    }

    public static final int getButtonPadding() {
        return CFG.PADD;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        iTranslateX = this.getPosXE() + iTranslateX;
        iTranslateY = this.getPosY() + iTranslateY;
        if (!Menu_InGame_2.MENU_AOC_1) {
            oSB.setColor(Menu_InGame_2.btnCLR);
            oSB.getColor().a = 0.65f;
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.getColor().a = 0.3f;
            IMGManager.getIMG(Images.gradientXY).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
            IMGManager.getIMG(Images.gradientXY).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
            IMGManager.getIMG(Images.gradientXY).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() - CFG.PADD * 2, this.getWidthE(), CFG.PADD * 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
            Renderer.drawBox2(oSB, Images.statsRectBGBorder, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() - 1, this.getWidthE(), 1);
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), 1);
            oSB.setColor(Menu_InGame_2.btnCLR);
            oSB.getColor().a = 0.85f;
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() - 2, this.getWidthE(), 1);
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + 1, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() - 1, this.getWidthE(), 1);
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), 1);
            oSB.setColor(Menu_InGame_2.btnCLR);
            oSB.getColor().a = 0.9f;
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() - 2, this.getWidthE(), 1);
            IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY + 1, this.getWidthE(), 1);
            oSB.setColor(Color.WHITE);
            this.drawExtra(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            if (this.getIsHovered() || isActive || this.getIsActiveButton()) {
                oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.8f));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(CFG.sparksColors);
                this.sparksAnimationTop.draw2(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
                Renderer.drawBox2(oSB, Images.statsRectBGBorder, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
                oSB.setColor(Color.WHITE);
            }
            if (this.getIsClickable() && this.getIsHovered() && animationState >= 0) {
                if (animationState == 0) {
                    float drawPerc = Math.min(1.0f * (float)(CFG.currentTimeMillis - lTimeAnimation) / 1000.0f, 1.0f);
                    oSB.setColor(CFG.getColorLine());
                    IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX + CFG.PADD, iTranslateY + 1, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX + CFG.PADD, iTranslateY + this.getHeightE() - 2, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    if (lTimeAnimation < CFG.currentTimeMillis - 1000L) {
                        ++animationState;
                        lTimeAnimation = CFG.currentTimeMillis;
                    }
                } else {
                    float drawPerc = Math.min(1.0f * (float)(CFG.currentTimeMillis - lTimeAnimation) / 1000.0f, 1.0f);
                    oSB.setColor(CFG.getColorLine());
                    IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), iTranslateY + 1, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), iTranslateY + this.getHeightE() - 2, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    if (lTimeAnimation < CFG.currentTimeMillis - 1000L) {
                        animationState = 0;
                        lTimeAnimation = CFG.currentTimeMillis;
                    }
                }
                oSB.setColor(Color.WHITE);
            }
        }
        IMGManager.getIMG(this.getImageID()).draw(oSB, iTranslateX + EXTRA_WIDTH_BOX_PADDING, iTranslateY + (this.getHeightE() - IMGManager.getIMG(this.getImageID()).getHeight()) / 2);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), iTranslateX + this.iTextPosX, iTranslateY + this.textPosY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sText2, iTranslateX + this.iTextPosX, iTranslateY + this.textPosY + this.iTextHeight + CFG.PADD, this.getColor2(isActive));
    }

    public void drawExtra(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
    }

    protected Color getColor(boolean isActive) {
        return Colors.getColorTopStats(isActive, this.getIsHovered());
    }

    protected Color getColor2(boolean isActive) {
        return Colors.TEXT_TOP_BOT;
    }

    public int getImageID() {
        return this.imageID;
    }

    @Override
    public String getTextToDrawElem() {
        return this.sText;
    }

    @Override
    public final String getTextE() {
        return this.sText;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            Renderer.glyphLayout.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)Renderer.glyphLayout.width;
            this.iTextHeight = (int)Renderer.glyphLayout.height;
            if (super.getWidthE() < this.iTextWidth + this.extraWidth()) {
                this.setWidthE(this.iTextWidth + this.extraWidth());
            }
            if (GameCalendar.TURNID > this.WIDTH_LAST_TURN_UPDATE) {
                this.setWidthE(Math.max(this.iTextWidth, this.iTextWidth2) + this.extraWidth());
                this.WIDTH_LAST_TURN_UPDATE = GameCalendar.TURNID;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void setText2(String sText2) {
        this.sText2 = sText2;
        try {
            Renderer.glyphLayout.setText(CFG.fontMain.get(this.fontID2), sText2);
            this.iTextWidth2 = (int)Renderer.glyphLayout.width;
            this.iTextHeight2 = (int)Renderer.glyphLayout.height;
            if (super.getWidthE() < this.iTextWidth2 + this.extraWidth()) {
                this.setWidthE(this.iTextWidth2 + this.extraWidth());
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void setWidthOfButton() {
        this.setWidthE(this.extraWidth());
    }

    public final int extraWidth() {
        return IMGManager.getIMG(this.imageID).getWidth() + CFG.PADD * 2 + EXTRA_WIDTH_BOX_PADDING * 2;
    }

    @Override
    public int getTextWidthU() {
        return this.iTextWidth;
    }

    @Override
    public int getTextHeight() {
        return this.iTextHeight;
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        lTimeAnimation = CFG.currentTimeMillis;
        animationState = 0;
    }

    public boolean getIsActiveButton() {
        return false;
    }
}

