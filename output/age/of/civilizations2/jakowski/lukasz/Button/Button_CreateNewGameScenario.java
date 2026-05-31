
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.earlygrey.shapedrewer.ShapeUtils;

public class Button_CreateNewGameScenario
extends ButtonM {
    public Button_CreateNewGameScenario(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, IMGManager.getIMG(Images.gameTop).getHeight() - CFG.PADD * 2, true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(0.925f, 0.925f, 1.0f, 0.975f));
            int iBGImageID = Images.gameBox;
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), false, false);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), true, false);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), false, true);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), true, true);
        } else {
            int iBGImageID = Images.gameBoxHover;
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), false, false);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), true, false);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), false, true);
            IMGManager.getIMG(iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, this.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), true, true);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + (int)((float)this.getWidthE() / 2.0f - (float)this.getTextWidthU() / 2.0f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + (int)((float)this.getWidthE() / 2.0f - (float)this.getTextWidthU() / 2.0f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            if (sText != null && sText.length() > 0) {
                CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
                this.iTextWidth = (int)CFG.glyphLay.width;
                this.iTextHeight = (int)CFG.glyphLay.height;
                if (super.getWidthE() < this.iTextWidth) {
                    this.setWidthE(this.iTextWidth);
                }
                if (this.getHeightE() < this.iTextHeight) {
                    this.setHeightE(this.iTextHeight);
                }
                CFG.fontMain.get(-this.fontID).getData().setScale(1.0f);
            } else {
                this.iTextWidth = 0;
                this.iTextHeight = CFG.TEXT_HEIGHT_DEFAULT;
                CFG.fontMain.get(-this.fontID).getData().setScale(1.0f);
            }
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (Exception exception) {
        }
        finally {
            ShapeUtils.updateGlyphLayout(sText);
        }
    }

    @Override
    public boolean getIsClickable() {
        return super.getIsClickable();
    }

    @Override
    public boolean getVisibleE() {
        return super.getVisibleE();
    }

    @Override
    public void setCurr(int nCurrent) {
        super.setCurr(nCurrent);
    }

    @Override
    public int getCurr() {
        return super.getCurr();
    }
}

