
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Disease
extends ButtonM {
    public static final float FONT_SIZE = 0.65f;
    public static final float FONT_SIZE2 = 0.6f;
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    public Color oColor;
    public String sProvinces;

    public Button_View_Disease(int iRow, Color nColor, String sText, int nOutbreakProvinceID, int nDeaths, String sProvinces, int iPosX, int iPosY, int iWidth) {
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nOutbreakProvinceID;
        this.oColor = nColor;
        this.sProvinces = sProvinces;
        this.sPopulationPerc = CFG.getNumberWthSpaces("" + nDeaths);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)(CFG.glyphLay.width * 0.6f);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.1f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.275f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        }
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() * 3 / 4, this.getHeightE());
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.075f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD + CFG.PADD / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD / 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD + CFG.PADD / 2, false, true);
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.225f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.iProvinceID >= 0 && CFG.core.getProv(this.iProvinceID).getCivId() > 0) {
            CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) / 2 - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
        } else {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() * this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight(), (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getWidth() * this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())), (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() * this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
        CFG.fontMain.get(0).getData().setScale(0.65f);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.65f / 2.0f) + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.disease).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)IMGManager.getIMG(Images.disease).getWidth() * this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())) - CFG.PADD * 2 - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.disease).getHeight() * this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.disease).getHeight(), (int)((float)IMGManager.getIMG(Images.disease).getWidth() * this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())), (int)((float)IMGManager.getIMG(Images.disease).getHeight() * this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())));
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.drawTextDefault(oSB, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.6f / 2.0f) + iTranslateY, CFG.COLOR_NEGATIVE_2);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_NEGATIVE_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_NEGATIVE_HOVER : CFG.COLOR_NEGATIVE_2) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (this.iProvinceID < 0) {
                this.menuElemHover = null;
                return;
            }
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Name") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Deaths") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sPopulationPerc, CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sProvinces, CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException e) {
            this.menuElemHover = null;
        }
        catch (NullPointerException ex) {
            this.menuElemHover = null;
        }
    }
}

