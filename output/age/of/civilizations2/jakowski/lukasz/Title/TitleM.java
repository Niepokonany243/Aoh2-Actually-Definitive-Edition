
package age.of.civilizations2.jakowski.lukasz.Title;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleM {
    public String sText;
    public int iTextWidth = -1;
    public int iTextHeight = -1;
    public int iHeight;
    public boolean moveable = false;
    public boolean resizable = false;

    public TitleM(String sText, int iHeight, boolean moveable, boolean resizable) {
        this.setText(sText);
        this.iHeight = iHeight;
        this.moveable = moveable;
        this.resizable = resizable;
    }

    public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            oSB.setColor(BetterUI_Manager.getBackgroundColor(0.95f));
            Images.pix.draw(oSB, nPosX + iTranslateX, nPosY - this.iHeight, nWidth, this.iHeight);
            
            oSB.setColor(primary.r, primary.g, primary.b, 0.8f);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2, nWidth, 2);
            
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.titleEdge).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.titleEdge).getWidth() + iTranslateX, nPosY - IMGManager.getIMG(Images.titleEdge).getHeight() - this.iHeight, IMGManager.getIMG(Images.titleEdge).getWidth(), this.iHeight, true, true);
            IMGManager.getIMG(Images.titleEdge).draw2O(oSB, nPosX + iTranslateX, nPosY - IMGManager.getIMG(Images.titleEdge).getHeight() - this.iHeight, nWidth - IMGManager.getIMG(Images.titleEdge).getWidth(), this.iHeight, false, true);
        }
        this.drawText(oSB, iTranslateX, nPosX, nPosY, nWidth, sliderMenuIsActive);
    }

    public void drawText(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            CFG.drawTextDefault(oSB, this.sText, nPosX + nWidth / 2 - this.iTextWidth / 2 + iTranslateX, nPosY - this.iHeight + this.iHeight / 2 - this.iTextHeight / 2, Color.WHITE);
        } else {
            CFG.drawTextDefault(oSB, this.sText, nPosX + nWidth / 2 - this.iTextWidth / 2 + iTranslateX, nPosY - this.iHeight + this.iHeight / 2 - this.iTextHeight / 2, new Color(0.92941177f, 0.99607843f, 1.0f, 1.0f));
        }
    }

    public final String getText() {
        return this.sText;
    }

    public void setText(String sText) {
        this.sText = sText;
        this.setTextWidth(-1);
        if (sText != null && this.getTextWidth() < 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
            this.setTextWidth((int)CFG.glyphLay.width);
            this.setTextHeight((int)CFG.glyphLay.height);
        }
    }

    public final int getHeightT() {
        return this.iHeight;
    }

    public final boolean getMoveable() {
        return this.moveable;
    }

    public final int getTextWidth() {
        return this.iTextWidth;
    }

    public final int getTextHeight() {
        return this.iTextHeight;
    }

    public final void setTextWidth(int iTextWidth) {
        this.iTextWidth = iTextWidth;
    }

    public final void setTextHeight(int iTextHeight) {
        this.iTextHeight = iTextHeight;
    }

    public final boolean getResizable() {
        return this.resizable;
    }
}

