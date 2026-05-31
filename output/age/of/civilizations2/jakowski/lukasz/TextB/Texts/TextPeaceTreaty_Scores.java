
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextPeaceTreaty_Scores
extends Text {
    private boolean row = false;
    private int iCivID;
    private Color colorWarScore;

    public TextPeaceTreaty_Scores(int nCivID, int iVicPointsLeft, int iPosX, int iPosY, int iWidth) {
        super("" + iVicPointsLeft, CFG.PADD * 2, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4), CFG.FONT_BOLD_SMALL);
        this.iCivID = nCivID;
        this.colorWarScore = iVicPointsLeft > 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : (iVicPointsLeft < 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL);
        if (this.getWidthE() > iWidth) {
            this.setWidthE(iWidth);
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.row) {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.8f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, false);
            this.drawActive(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), false, false);
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            oSB.setColor(Color.WHITE);
        } else {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, false);
            this.drawActive(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), false, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
            oSB.setColor(Color.WHITE);
        }
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(Images.victoryPoints).drawO(oSB, this.getPosXE() + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.victoryPoints).getHeight(), (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())));
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.colorWarScore);
    }

    public void drawActive(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.peaceTreatyData.brushCivID == this.getCurr()) {
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() * 3 / 4, this.getHeightE(), false, false);
        }
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 1.1f / (float)nHeight;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void buildElemHover() {
        int j;
        int i;
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(this.iCivID).getIdeology(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.getTextE(), this.colorWarScore));
        nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != this.iCivID) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size(); ++j) {
                nData.add(new ME_Hover_2Type_Flag(this.iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getName()));
                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + CFG.peaceTreatyData.drawProvOwners.get((int)CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).iProvinceValue, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            break;
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != this.iCivID) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size(); ++j) {
                nData.add(new ME_Hover_2Type_Flag(this.iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getName()));
                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + CFG.peaceTreatyData.drawProvOwners.get((int)CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).iProvinceValue, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            break;
        }
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
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void actionElem(int iID) {
        CFG.peaceTreatyData.brushCivID = this.getCurr();
        try {
            CFG.toastM.addM(CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getCivName(), CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(1500);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }
}

