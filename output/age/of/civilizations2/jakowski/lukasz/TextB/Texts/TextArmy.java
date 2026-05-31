
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextArmy
extends Text {
    public TextArmy() {
    }

    public TextArmy(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    public TextArmy(String sText, int iTextPositionX, int iPosX, int iPosY, int iHeight) {
        super(sText, iTextPositionX, iPosX, iPosY, iHeight);
    }

    public TextArmy(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        CFG.drawArmyText_WithShadow(oSB, this.sText, this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public void setTextE(String sText) {
        block6: {
            this.sText = sText;
            try {
                CFG.glyphLay.setText(CFG.fontArmy, sText);
                this.iTextWidth = (int)CFG.glyphLay.width;
                this.iTextHeight = (int)CFG.glyphLay.height;
                if (super.getWidthE() < this.iTextWidth) {
                    this.setWidthE(this.iTextWidth);
                }
                if (this.getHeightE() < this.iTextHeight) {
                    this.setHeightE(this.iTextHeight);
                }
            }
            catch (NullPointerException ex) {
                if (CFG.LOGs) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block6;
                CFG.exceptionStack(ex);
            }
        }
    }
}

