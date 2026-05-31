/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Stats_Income
extends ButtonStats {
    public static long lTime;
    public int civLeft;
    public int civRight;
    public String sCivRight;
    public float sliderPerc;
    public String incomeLeft;
    public int incomeLeftWidth;
    public String incomeRight;
    public int incomeRightWidth;
    public String impactLeft;
    public String impactRight;
    public int impactRightWidth;

    public Button_Stats_Income(int nCivLeft, int nCivRight, int iPosX, int iPosY, int iWidth) {
        super(CFG.getNumber_SHORT(CFG.core.getCiv(nCivLeft).getNumOfProvs()), 0, iPosX, iPosY, iWidth, Math.max(CFG.PADD * 6 + Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.flagRect2).getHeight()), CFG.BUTTON_H * 4 / 5), CFG.FONT_BOLD);
        this.civLeft = nCivLeft;
        this.civRight = nCivRight;
        this.sCivRight = CFG.getNumber_SHORT(CFG.core.getCiv(this.civRight).getNumOfProvs());
        this.sliderPerc = 0.5f;
        this.sliderPerc = CFG.core.getCiv(this.civLeft).getNumOfProvs() > CFG.core.getCiv(this.civRight).getNumOfProvs() ? (this.sliderPerc += 0.5f * (1.0f - (float)CFG.core.getCiv(this.civRight).getNumOfProvs() / (float)CFG.core.getCiv(this.civLeft).getNumOfProvs())) : (this.sliderPerc -= 0.5f * (1.0f - (float)CFG.core.getCiv(this.civLeft).getNumOfProvs() / (float)CFG.core.getCiv(this.civRight).getNumOfProvs()));
        lTime = System.currentTimeMillis();
        this.incomeLeft = CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.civLeft).incomeTaxation);
        this.incomeRight = CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.civRight).incomeTaxation);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.incomeRight);
        this.incomeRightWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.incomeLeft);
        this.incomeLeftWidth = (int)CFG.glyphLay.width;
        float impactCivLeft = GameManager.getSanctionsImpact(this.civRight, this.civLeft);
        float impactCivRight = GameManager.getSanctionsImpact(this.civLeft, this.civRight);
        this.impactLeft = "-" + CFG.getPrecision2(impactCivLeft * 100.0f, 100) + "%";
        this.impactRight = "-" + CFG.getPrecision2(impactCivRight * 100.0f, 100) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.impactRight);
        this.impactRightWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        float drawPerc = this.sliderPerc;
        if (lTime + 375L > System.currentTimeMillis()) {
            drawPerc = 0.5f - (0.5f - this.sliderPerc) * (float)(System.currentTimeMillis() - lTime) / 375.0f;
            CFG.setRenderO(true);
        }
        int topH = this.getHeightE() - CFG.PADD * 4;
        IMGManager.getIMG(Images.provinces).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) / 2 + iTranslateX, this.getPosY() + topH / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)), (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces)));
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) / 2 - CFG.PADD - IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.civLeft);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 + (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) / 2 + CFG.PADD + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.civRight);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) / 2 - CFG.PADD * 2 - this.getTextWidthU() - IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCivRight, this.getPosXE() + this.getWidthE() / 2 + (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) / 2 + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + topH / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + topH / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.incomeLeft, this.getPosXE() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_GOLD);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.incomeRight, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) - this.incomeRightWidth + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_GOLD);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.impactLeft, this.getPosXE() + CFG.PADD * 3 + this.incomeLeftWidth + (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_NEGATIVE_2);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.impactRight, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.impactRightWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) - this.incomeRightWidth + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_NEGATIVE_2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD * 2, false, true);
        oSB.setColor(new Color((float)CFG.core.getCiv(this.civLeft).getR() / 255.0f, (float)CFG.core.getCiv(this.civLeft).getG() / 255.0f, (float)CFG.core.getCiv(this.civLeft).getB() / 255.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, true, true);
        oSB.setColor(new Color((float)CFG.core.getCiv(this.civRight).getR() / 255.0f, (float)CFG.core.getCiv(this.civRight).getG() / 255.0f, (float)CFG.core.getCiv(this.civRight).getB() / 255.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.785f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, CFG.PADD * 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD * 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return 1.0f;
    }

    private final float getImageScale2(int nImageID) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = Button_Stats_Income.getHover(this.civLeft, this.civRight);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    public static ME_Hover_v2 getHover(int civLeft, int civRight) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(civLeft, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(civLeft).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.sanctions, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(civRight).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(civRight, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civLeft, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(civLeft).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civLeft, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)civLeft).incomeTaxation), CFG.COLOR_GOLD));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civLeft, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SanctionsImpact") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getPrecision2(GameManager.getSanctionsImpact(civRight, civLeft) * 100.0f, 100) + "%", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.sanctions, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getNumberWthSpaces("" + (int)((float)CFG.core.getCiv((int)civLeft).incomeTaxation * GameManager.getSanctionsImpact(civRight, civLeft))), CFG.COLOR_NEGATIVE_1));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civRight, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(civRight).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civRight, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)civRight).incomeTaxation), CFG.COLOR_GOLD));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(civRight, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SanctionsImpact") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getPrecision2(GameManager.getSanctionsImpact(civLeft, civRight) * 100.0f, 100) + "%", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.sanctions, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getNumberWthSpaces("" + (int)((float)CFG.core.getCiv((int)civRight).incomeTaxation * GameManager.getSanctionsImpact(civLeft, civRight))), CFG.COLOR_NEGATIVE_1));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvSanctions.COST_SANCTIONS_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvSanctions.RELATIONS_CHANGE, 100), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.diploRelationsDec, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }
}

