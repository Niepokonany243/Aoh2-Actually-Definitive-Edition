
package age.of.civilizations2.jakowski.lukasz.Button.Peace;

import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Province;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_PeaceTreaty_Demands_Province2
extends Button_PeaceTreaty_Demands_Province {
    public Button_PeaceTreaty_Demands_Province2(int nProvinceID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(nProvinceID, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        try {
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).isTaken > 0 && CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID > 0) {
                CFG.core.getCiv(CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID).getFlagC().drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - CFG.core.getCiv(CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
            } else {
                IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        int vpIconW = (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight()));
        int vpIconH = (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight()));
        IMGManager.getIMG(Images.victoryPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - vpIconW + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - vpIconH / 2 + iTranslateY - IMGManager.getIMG(Images.victoryPoints).getHeight(), vpIconW, vpIconH);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - CFG.PADD * 2 - this.iValueWidth - vpIconW, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + MAX_WDITH_LEFT + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        Renderer.drawText(oSB, this.fontID, this.sValue, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iValueWidth - vpIconW + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }
}

