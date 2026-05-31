
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_Stats_Alliance_Clip
extends Button_Stats_Flag {
    public Button_Stats_Alliance_Clip(int iAllianceID, String sText, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(iAllianceID, sText, iTextPosX, iPosX, iPosY, iWidth, iHeight);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        try {
            oSB.setColor(new Color(CFG.core.getAlliance(this.iCivID).getColorOfAlliance().getR(), CFG.core.getAlliance(this.iCivID).getColorOfAlliance().getG(), CFG.core.getAlliance(this.iCivID).getColorOfAlliance().getB(), 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            oSB.setColor(Color.WHITE);
            if (CFG.FOG_OF_WAR == 2) {
                int i;
                int n = i = CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1 > 5 ? 5 : CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1;
                while (i >= 0) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getAlliance(this.iCivID).getCivilization(i))) {
                        CFG.core.getCiv(CFG.core.getAlliance(this.iCivID).getCivilization(i)).getFlagC().drawO(oSB, 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * i + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - CFG.core.getCiv(CFG.core.getAlliance(this.iCivID).getCivilization(i)).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * i + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                    }
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * i + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                    --i;
                }
            } else {
                int i;
                int n = i = CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1 > 5 ? 5 : CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1;
                while (i >= 0) {
                    CFG.core.getCiv(CFG.core.getAlliance(this.iCivID).getCivilization(i)).getFlagC().drawO(oSB, 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * i + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - CFG.core.getCiv(CFG.core.getAlliance(this.iCivID).getCivilization(i)).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * i + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                    --i;
                }
            }
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) * 3 / 4 * (CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1 > 5 ? 5 : CFG.core.getAlliance(this.iCivID).getCivilizationsSize() - 1) + 2 + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        }
        catch (Exception ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + 2 + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        }
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    private final float getImageScale() {
        return Math.min(1.0f, (float)(this.getHeightE() - CFG.PADD) / (float)CFG.CIV_FLAG_HEIGHT);
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }
}

