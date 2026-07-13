
package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Minimap
extends MenuElemUI {
    private int iWindowPosX;
    private int iWindowPosY;
    private int iWidnowHeight;
    private final Rectangle clipBounds = new Rectangle();

    public Minimap(int nPosX, int nPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.MINIMAP;
        this.setPosX(nPosX);
        this.setPosY(nPosY);
        this.setWidthE(CFG.map.getMpB().getMinimapWidth());
        this.setHeightE(CFG.map.getMpB().getMinimapHeight());
    }

    @Override
    public final void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOfCivilizationsWidth(), CFG.map.getMpB().getMinimapOfCivilizationsHeight());
        oSB.setColor(Color.WHITE);
        CFG.map.getMpB().drawMinimapTexture(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        if (this.getIsHovered()) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.025f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOfCivilizationsWidth(), CFG.map.getMpB().getMinimapOfCivilizationsHeight());
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOfCivilizationsWidth(), CFG.map.getMpB().getMinimapOfCivilizationsHeight() / 7);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.map.getMpB().getMinimapOfCivilizationsHeight() - CFG.map.getMpB().getMinimapOfCivilizationsHeight() / 7 + iTranslateY, CFG.map.getMpB().getMinimapOfCivilizationsWidth(), CFG.map.getMpB().getMinimapOfCivilizationsHeight() / 7, false, true);
            oSB.setColor(Color.WHITE);
        }
        CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapWidth() - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapHeight() - CFG.map.getMpB().getMinimapOverlay().getHeight());
        CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosXE() + CFG.map.getMpB().getMinimapWidth() - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapHeight() - CFG.map.getMpB().getMinimapOverlay().getHeight(), true, false);
        CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.map.getMpB().getMinimapHeight() - CFG.map.getMpB().getMinimapOverlay().getHeight() * 2 + iTranslateY, CFG.map.getMpB().getMinimapWidth() - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), false, true);
        CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosXE() + CFG.map.getMpB().getMinimapWidth() - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.map.getMpB().getMinimapHeight() - CFG.map.getMpB().getMinimapOverlay().getHeight() * 2 + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), true, true);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.3f);
        if (CFG.map.getMpB().fMinimapScaled_Scale != 1.0f) {
            this.clipBounds.set(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
            oSB.flush();
            ScissorStack.pushScissors(this.clipBounds);
            this.iWindowPosX = (int)((float)(-(CFG.map.getMpC().getPX() + CFG.map.getMpB().iMinimapScaled_PosX)) / CFG.map.getMpS().getMinimapScaled_ScaleX() - (CFG.map.getMpB().minimapIsBelowZero && (float)(-CFG.map.getMpC().getPX()) > (float)CFG.map.getMpB().getWidthM() - (float)CFG.map.getMpB().getWidthM() / CFG.map.getMpB().fMinimapScaled_Scale ? (float)CFG.map.getMpB().getWidthM() / CFG.map.getMpS().getMinimapScaled_ScaleX() : 0.0f));
            this.iWindowPosY = (int)((float)(-(CFG.map.getMpC().getPY() + CFG.map.getMpB().iMinimapScaled_PosY)) / CFG.map.getMpS().getMinimapScaled_ScaleY());
            this.iWidnowHeight = (int)((float)this.iWindowPosY + (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getMinimapScaled_ScaleY() / CFG.map.getMpS().getCurrSc() > (float)(this.getHeightE() - 2) ? (float)(this.getHeightE() - 2 - this.iWindowPosY) : (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getMinimapScaled_ScaleY() / CFG.map.getMpS().getCurrSc());
            CFG.drawRect(oSB, this.getPosXE() + this.iWindowPosX - 1 + iTranslateX, 1 + this.getPosY() + this.iWindowPosY - 1 + iTranslateY, 2 + (int)((float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaled_ScaleX() / CFG.map.getMpS().getCurrSc() + (float)this.iWindowPosX > (float)this.getWidthE() ? (float)(this.getWidthE() - this.iWindowPosX) : (float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaled_ScaleX() / CFG.map.getMpS().getCurrSc()), this.iWidnowHeight + 2);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.8f);
            CFG.drawRect(oSB, this.getPosXE() + this.iWindowPosX + iTranslateX, 1 + this.getPosY() + this.iWindowPosY + iTranslateY, (int)((float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaled_ScaleX() / CFG.map.getMpS().getCurrSc() + (float)this.iWindowPosX > (float)this.getWidthE() ? (float)(this.getWidthE() - this.iWindowPosX) : (float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaled_ScaleX() / CFG.map.getMpS().getCurrSc()), this.iWidnowHeight);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {}
        } else {
            this.iWindowPosX = (int)((float)(-CFG.map.getMpC().getPX()) / CFG.map.getMpS().getMinimapScaleX());
            this.iWindowPosY = (int)((float)(-CFG.map.getMpC().getPY()) / CFG.map.getMpS().getMinimapScaleY() < 0.0f ? 0.0f : (float)(-CFG.map.getMpC().getPY()) / CFG.map.getMpS().getMinimapScaleY());
            this.iWidnowHeight = (int)((float)this.iWindowPosY + (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getMinimapScaleY() / CFG.map.getMpS().getCurrSc() > (float)(this.getHeightE() - 2) ? (float)(this.getHeightE() - 2 - this.iWindowPosY) : (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getMinimapScaleY() / CFG.map.getMpS().getCurrSc());
            CFG.drawRect(oSB, this.getPosXE() + this.iWindowPosX - 1 + iTranslateX, 1 + this.getPosY() + this.iWindowPosY - 1 + iTranslateY, 2 + (int)((float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaleX() / CFG.map.getMpS().getCurrSc() + (float)this.iWindowPosX > (float)this.getWidthE() ? (float)(this.getWidthE() - this.iWindowPosX) : (float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaleX() / CFG.map.getMpS().getCurrSc()), this.iWidnowHeight + 2);
            oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            CFG.drawRect(oSB, this.getPosXE() + this.iWindowPosX + iTranslateX, 1 + this.getPosY() + this.iWindowPosY + iTranslateY, (int)((float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaleX() / CFG.map.getMpS().getCurrSc() + (float)this.iWindowPosX > (float)this.getWidthE() ? (float)(this.getWidthE() - this.iWindowPosX) : (float)CFG.GAMEWIDTH / CFG.map.getMpS().getMinimapScaleX() / CFG.map.getMpS().getCurrSc()), this.iWidnowHeight);
            if (CFG.map.getMpC().getSecondSideOfMap()) {
                oSB.setColor(0.0f, 0.0f, 0.0f, 0.3f);
                CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + this.iWindowPosY + iTranslateY, (int)Math.abs((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() / CFG.map.getMpS().getMinimapScaleX() - (float)(CFG.map.getMpB().getWidthM() + CFG.map.getMpC().getPX()) / CFG.map.getMpS().getMinimapScaleX()), this.iWidnowHeight);
                oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + this.iWindowPosY + iTranslateY, (int)Math.abs((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() / CFG.map.getMpS().getMinimapScaleX() - (float)(CFG.map.getMpB().getWidthM() + CFG.map.getMpC().getPX()) / CFG.map.getMpS().getMinimapScaleX()), this.iWidnowHeight);
            }
        }
        oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public int getWidthE() {
        return CFG.map.getMpB().getMinimapWidth();
    }

    @Override
    public int getHeightE() {
        return CFG.map.getMpB().getMinimapHeight();
    }
}

