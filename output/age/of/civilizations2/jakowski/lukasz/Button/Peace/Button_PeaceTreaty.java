
package age.of.civilizations2.jakowski.lukasz.Button.Peace;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_PeaceTreaty
extends ButtonM {
    private String sDate = "";
    private int iDateWidth;

    public Button_PeaceTreaty(String nText, int nWarID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkbox) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(nText, -1, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, checkbox, null);
        int tempScore = CFG.core.getWar(nWarID).getWarScore_PeaceTreaty();
        this.sDate = "" + (tempScore == 0 ? CFG.lang.get("Balanced") : (tempScore < 0 ? CFG.lang.get("XInFavorOfAggressors", Math.abs(tempScore) + "%") : CFG.lang.get("XInFavorOfDefenders", Math.abs(tempScore) + "%")));
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sDate);
        this.iDateWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.275f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.675f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.8f));
        } else {
            oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
        }
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.2f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        if (this.getCheckboxSt()) {
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.175f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.175f));
        }
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.525f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightE() / 3 + iTranslateY, this.getWidthE(), this.getHeightE() / 3, false, true);
        oSB.setColor(CFG.COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            int i;
            int tX = this.getWidthE() / 2 - Math.max(this.iDateWidth, this.getTextWidthU()) / 2 - CFG.PADD * 2;
            for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
                Core.drawFlagDiplomacy(oSB, this.getPosXE() + tX - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() * (i + 1) - CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2 + iTranslateY, CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID);
            }
            tX = this.getWidthE() / 2 + Math.max(this.iDateWidth, this.getTextWidthU()) / 2 + CFG.PADD * 2;
            for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                Core.drawFlagDiplomacy(oSB, this.getPosXE() + tX + IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2 + iTranslateY, CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDate, this.getPosXE() + (this.getWidthE() - this.iDateWidth) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.475f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + (this.getWidthE() - this.iDateWidth) / 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.iTextHeight + iTranslateY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iDateWidth + CFG.PADD * 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.525f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + (this.getWidthE() - this.iDateWidth) / 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.iTextHeight + 1 + iTranslateY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iDateWidth + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void buildElemHover() {
        try {
            int i;
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
                nData.add(new ME_Hover_2Type_Flag(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getCivName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            nData.add(new ME_Hover_2Type_Image(Images.diploTruce, 0, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                nData.add(new ME_Hover_2Type_Flag(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getCivName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }
}

