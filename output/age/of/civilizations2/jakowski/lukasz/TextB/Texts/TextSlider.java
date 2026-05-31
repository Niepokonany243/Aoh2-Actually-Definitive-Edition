/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextSlider_Line;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class TextSlider
extends MenuElemUI {
    private List<TextSlider_Line> lLine = new ArrayList<TextSlider_Line>();
    private int iSliderPosY;
    private int iHeightOfSlider;
    private boolean moveable = false;
    private int extraPosY = CFG.PADD + CFG.PADD / 2;
    private float FONT_SCALE = 1.0f;
    private int iMaxHeight = 0;
    private boolean scrollModeY = false;
    private int iScrollPosY = -1;
    private int iScrollPosY2 = -1;
    private float fScrollNewMenuPosY = 0.0f;

    public TextSlider(int nPosX, int nPosY, int nWidth, int nHeight) {
        this.init(nPosX, nPosY, nWidth, nHeight, nHeight, 1.0f);
    }

    public TextSlider(int nPosX, int nPosY, int nWidth, int nHeight, float nFONT_SCALE) {
        this.init(nPosX, nPosY, nWidth, nHeight, nHeight, nFONT_SCALE);
    }

    public TextSlider(int nPosX, int nPosY, int nWidth, int nMinHeight, int nMaxHeight, float nFONT_SCALE) {
        this.init(nPosX, nPosY, nWidth, nMinHeight, nMaxHeight, nFONT_SCALE);
    }

    public TextSlider(int nPosX, int nPosY, int nWidth, int nMinHeight, int nMaxHeight, int fontID) {
        this.fontID = fontID;
        this.init(nPosX, nPosY, nWidth, nMinHeight, nMaxHeight, 1.0f);
    }

    private final void init(int nPosX, int nPosY, int nWidth, int nHeight, int nMaxHeight, float nFONT_SCALE) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT_SLIDER;
        this.FONT_SCALE = nFONT_SCALE;
        this.iMaxHeight = nMaxHeight;
        this.setPosX(nPosX);
        this.setPosY(nPosY);
        this.setWidthE(nWidth);
        this.setHeightE(nHeight);
        this.updateMoveable();
        this.updateSlider(this.iSliderPosY);
    }

    @Override
    public final void addText(String sText, int extraHeight) {
        this.lLine.add(new TextSlider_Line(sText, this.getWidthE() - CFG.PADD * 2, extraHeight, TextSlider_Line.Align.LEFT, this.FONT_SCALE));
        this.updateMoveable();
    }

    public void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.mainMenuEdge).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.mainMenuEdge).getHeight());
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.mainMenuEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.mainMenuEdge).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.mainMenuEdge).getHeight(), true);
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.mainMenuEdge).getWidth(), IMGManager.getIMG(Images.mainMenuEdge).getHeight(), false, true);
        IMGManager.getIMG(Images.mainMenuEdge).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.mainMenuEdge).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() + iTranslateY, true, true);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        int rectW = this.getWidthE();
        int rectH = this.getHeightE() - CFG.PADD;
        int rectX = this.getPosXE() + iTranslateX;
        int rectY = CFG.GAMEHEIGHT - this.getPosY() - CFG.PADD - iTranslateY - rectH;
        Rectangle clipBounds = new Rectangle(rectX, rectY, rectW, rectH);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        oSB.setColor(new Color(0.8627451f, 0.9019608f, 0.8627451f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(this.FONT_SCALE);
        int tY = 0;
        int iSize = this.lLine.size();
        for (int i = 0; i < iSize; ++i) {
            this.lLine.get(i).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.extraPosY + tY + this.iSliderPosY + iTranslateY, this.getWidthE(), this.getColor(isActive), this.fontID);
            tY += this.lLine.get(i).getHeight();
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        if (this.scrollModeY) {
            if (Math.abs(this.fScrollNewMenuPosY) > 1.0f) {
                this.updateSlider(this.iSliderPosY + (int)this.fScrollNewMenuPosY);
                this.fScrollNewMenuPosY *= 0.97f;
            } else {
                this.scrollModeY = false;
            }
            CFG.setRenderO(true);
        }
        this.drawScrollPos(oSB, iTranslateX, iTranslateY, isActive);
    }

    public final void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            if (this.moveable && sliderMenuIsActive) {
                oSB.setColor(new Color(0.22f, 0.22f, 0.3f, 1.0f));
                IMGManager.getIMG(Images.scrollPosition).draw2O(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.scrollPosition).getHeight() + iTranslateY, IMGManager.getIMG(Images.scrollPosition).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.scrollPosition).getHeight());
                IMGManager.getIMG(Images.scrollPosition).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.scrollPosition).getHeight() + iTranslateY, false, true);
                if (CFG.menus.getSliderMenuMode()) {
                    oSB.setColor(new Color(0.0f, 0.0f, 0.08f, 1.0f));
                } else {
                    oSB.setColor(new Color(0.098f, 0.098f, 0.16f, 1.0f));
                }
                IMGManager.getIMG(Images.scrollPositionActive).draw2O(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX + 1, this.getPosY() - this.iSliderPosY - IMGManager.getIMG(Images.scrollPositionActive).getHeight() + iTranslateY, CFG.PADD * 2 - 2, this.getHeightE() * 100 / this.iHeightOfSlider * this.getHeightE() / 100 - IMGManager.getIMG(Images.scrollPositionActive).getHeight());
                IMGManager.getIMG(Images.scrollPositionActive).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX + 1, this.getPosY() - this.iSliderPosY - IMGManager.getIMG(Images.scrollPositionActive).getHeight() + this.getHeightE() * 100 / this.iHeightOfSlider * this.getHeightE() / 100 + iTranslateY, false, true);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (ArithmeticException ex) {
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void updateSlider(int nSliderPosY) {
        if (nSliderPosY > 0) {
            this.iSliderPosY = 0;
            CFG.menus.setUpdateSliderMenuPosY(true);
            this.scrollModeY = false;
        } else if (nSliderPosY < this.getHeightE() - this.iHeightOfSlider) {
            this.iSliderPosY = this.getHeightE() - this.iHeightOfSlider;
            CFG.menus.setUpdateSliderMenuPosY(true);
            this.scrollModeY = false;
        } else {
            this.iSliderPosY = nSliderPosY;
        }
    }

    public final void updateMoveable() {
        this.iHeightOfSlider = this.extraPosY + CFG.PADD * 3;
        int iSize = this.lLine.size();
        for (int i = 0; i < iSize; ++i) {
            this.iHeightOfSlider += this.lLine.get(i).getHeight();
        }
        this.moveable = this.getHeightE() < this.iHeightOfSlider;
        this.scrollModeY = false;
        this.iSliderPosY = 0;
    }

    @Override
    public final void scrollTheMenu() {
        if (this.moveable && this.iScrollPosY > 0 && this.iScrollPosY2 > 0 && (float)Math.abs(this.iScrollPosY - this.iScrollPosY2) > 3.0f * CFG.DENSITY) {
            this.fScrollNewMenuPosY = (float)(this.iScrollPosY - this.iScrollPosY2) * 1.25f;
            this.scrollModeY = true;
        }
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    @Override
    public int getCurr() {
        return this.iSliderPosY;
    }

    @Override
    public final void setScrollPosY(int iScrollPosY) {
        this.iScrollPosY2 = this.iScrollPosY;
        this.iScrollPosY = iScrollPosY;
    }

    @Override
    public int getHeightE() {
        return this.iHeightOfSlider > super.getHeightE() ? (this.iHeightOfSlider > this.iMaxHeight ? this.iMaxHeight : this.iHeightOfSlider) : super.getHeightE();
    }

    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT : Color.WHITE;
    }
}

