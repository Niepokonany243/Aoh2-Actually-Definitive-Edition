
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_TechLevel;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextOutliner_SaveGame
extends Text {
    private boolean row = false;
    private int iCivID;
    public int iconWidth;
    public int iconHeight;

    public TextOutliner_SaveGame(int nCivID, int iPosX, int iPosY, int iWidth) {
        super(CFG.lang.get("Save"), CFG.PADD * 2, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4), CFG.FONT_BOLD_SMALL);
        this.iCivID = nCivID;
        if (this.getWidthE() > iWidth) {
            this.setWidthE(iWidth);
        }
        int nIMGID = Images.icon_save;
        float iconScale = TextOutliner_TechLevel.getImageScale(nIMGID);
        this.iconWidth = (int)((float)IMGManager.getIMG(nIMGID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(nIMGID).getHeight() * iconScale);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.row) {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.8f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(Color.WHITE);
        } else {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.325f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.CIV_FLAG_HEIGHT - 1 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, 1, true, false);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(Images.icon_save).draw(oSB, this.getPosXE() + this.getWidthE() - this.iconWidth / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iconHeight / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - this.getTextWidthU() - CFG.CIV_FLAG_WIDTH - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_NUM_OF_PROVINCES));
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GameWillBeSavedInNextTurn"), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.icon_save, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void setTextE(String sText) {
        block5: {
            this.sText = sText;
            try {
                CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
                this.iTextWidth = (int)CFG.glyphLay.width;
                this.iTextHeight = (int)CFG.glyphLay.height;
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
                if (!CFG.LOGs) break block5;
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    public void actionElem(int iID) {
        CFG.toastM.addM(CFG.lang.get("GameWillBeSavedInNextTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }
}

