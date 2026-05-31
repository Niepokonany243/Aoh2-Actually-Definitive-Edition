
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Rank
extends ButtonM {
    private float fTEXT_SCALE = 1.0f;

    public Button_Rank(String sText, int iPosX, int iPosY) {
        super.init(sText, 0, iPosX, iPosY, IMGManager.getIMG(Images.top_circle).getWidth(), IMGManager.getIMG(Images.top_circle).getHeight(), true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.top_circle).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.fontArmy.getData().setScale(this.fTEXT_SCALE);
        CFG.drawArmyText(oSB, this.getTextE(), this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, this.getColorE(isActive));
        CFG.fontArmy.getData().setScale(1.0f);
    }

    
    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            int nPlayersCivRankPosition = Integer.parseInt(sText);
            if (nPlayersCivRankPosition < 10) {
                nPlayersCivRankPosition = 99;
            }
            this.fTEXT_SCALE = 1.0f;
            for (int i = 0; i < 70; ++i) {
                CFG.glyphLay.setText(CFG.fontArmy, "" + nPlayersCivRankPosition);
                if ((float)((int)CFG.glyphLay.width) <= (float)IMGManager.getIMG(Images.top_circle).getWidth() - 10.0f * CFG.GUI_SCALE) break;
                this.fTEXT_SCALE -= 0.01f;
                CFG.fontArmy.getData().setScale(this.fTEXT_SCALE);
            }
            if (Integer.parseInt(sText) < 10) {
                CFG.glyphLay.setText(CFG.fontArmy, "" + sText);
            }
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
        }
        catch (IndexOutOfBoundsException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        catch (NullPointerException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            CFG.fontArmy.getData().setScale(1.0f);
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : new Color(0.92f, 0.94f, 0.92f, 1.0f)) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK3;
    }
}

