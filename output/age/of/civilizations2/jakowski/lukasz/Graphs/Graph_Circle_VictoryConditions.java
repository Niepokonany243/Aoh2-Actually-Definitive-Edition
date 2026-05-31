
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Graph_Circle_VictoryConditions
extends Graph_Circle {
    private String sTitle;
    private int iTitleWidth;
    public int iPaddingGraph = 0;
    public boolean row;
    public Color colorTitle;
    public int iCivID;
    public String sTopLeft;
    public int iTopLeftWidth;
    public String sTopRight;
    public int iTopRightWidth;
    public String sBot;
    public int iBotWidth;
    public String sDisabled;
    public int iDisabledWidth;
    public boolean disabled;
    public int iImageID;
    public int fontID2 = CFG.FONT_BOLD_SMALL;

    private static List<Long> convertList(List<Integer> nValues) {
        List<Long> nValuesLong = new ArrayList<Long>();
        for (Integer i : nValues) {
            nValuesLong.add(i.longValue());
        }
        return nValuesLong;
    }

    public Graph_Circle_VictoryConditions(boolean disabled, int iImageID, boolean row, String nTitle, Color colorTitle, int iPosX, int iPosY, List<Integer> nValues, List<Integer> nCivIDs, int nCivID, String nTopLeft, String nTopRight, String nBot) {
        super(iPosX, iPosY, convertList(nValues), nCivIDs, null);
        this.row = row;
        this.disabled = disabled;
        this.iPaddingGraph = CFG.PADD + CFG.PADD / 2;
        this.iImageID = iImageID;
        this.iCivID = nCivID;
        this.sTitle = nTitle;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTitle);
        this.iTitleWidth = (int)CFG.glyphLay.width;
        this.colorTitle = colorTitle;
        this.sTopLeft = nTopLeft;
        this.sTopRight = nTopRight;
        this.sBot = nBot;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTopLeft);
        this.iTopLeftWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTopRight);
        this.iTopRightWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sBot);
        this.iBotWidth = (int)CFG.glyphLay.width;
        this.sDisabled = CFG.lang.get("Disabled");
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDisabled);
        this.iDisabledWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.disabled) {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.075f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.125f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        if (!this.disabled) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.25f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - (CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth()) + iTranslateX, this.getPosY() + this.getHeight_Title() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth(), this.getHeightE() - this.getHeight_Title());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth()) + iTranslateX, this.getPosY() + this.getHeight_Title() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - this.getHeight_Title(), false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeight_Title() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - this.getHeight_Title(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - (CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth()) + iTranslateX, this.getPosY() + this.getHeight_Title() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - this.getHeight_Title());
        }
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, 0.225f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeight_Title());
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, this.getIsHovered() || isActive ? 0.155f : 0.125f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeight_Title(), false, true);
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, 0.125f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, ButtonDiplomacy.iDiploWidth + CFG.PADD * 2, this.getHeight_Title());
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - ButtonDiplomacy.iDiploWidth + CFG.PADD * 2) * 0.25f), this.getHeight_Title());
        oSB.setColor(new Color(this.getColorLeft().r, this.getColorLeft().g, this.getColorLeft().b, 0.1425f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeight_Title(), false, true);
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, 0.045f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, ButtonDiplomacy.iDiploWidth + CFG.PADD * 2, this.getHeight_Title());
        oSB.setColor(new Color(this.colorTitle.r, this.colorTitle.g, this.colorTitle.b, 0.105f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, ButtonDiplomacy.iDiploWidth + CFG.PADD * 2, this.getHeight_Title());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.425f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeight_Title(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth + CFG.PADD * 2) - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeight_Title(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeight_Title() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeight_Title() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeight_Title() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeight_Title() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeight_Title() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeight_Title() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        if (!this.disabled) {
            Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeight_Title() + (this.getHeightE() - this.getHeight_Title()) / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        }
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeight_Title() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTitle, this.getPosXE() + CFG.PADD * 3 + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeight_Title() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.getColor(isActive));
        if (this.disabled) {
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDisabled, this.getPosXE() + this.getWidthE() / 2 - this.iDisabledWidth / 2 + iTranslateX, this.getPosY() + this.getHeight_Title() + (this.getHeightE() - this.getHeight_Title()) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65f));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTopRight, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 2 - this.iTopRightWidth - CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeight_Title() + (this.getHeightE() - this.getHeight_Title()) / 2 - CFG.PADD / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTopLeft, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 2 - this.iTopRightWidth - CFG.PADD * 3 - this.iTopLeftWidth + iTranslateX, this.getPosY() + this.getHeight_Title() + (this.getHeightE() - this.getHeight_Title()) / 2 - CFG.PADD / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, Color.WHITE);
            Renderer.drawTextWithShadow(oSB, this.fontID2, this.sBot, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 2 - this.iBotWidth - CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeight_Title() + (this.getHeightE() - this.getHeight_Title()) / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
            this.drawGraph(oSB, iTranslateX, iTranslateY, isActive, scrollableY, this.getPosXE() + CFG.PADD * 2, this.getPosY() + this.getHeight_Title() + this.iPaddingGraph, this.getWidth_PercStrings(CFG.graphCircleDraw.getWidth()), CFG.graphCircleDraw.getWidth(), CFG.graphCircleDraw.getWidth());
        }
    }

    @Override
    public int getHeightE() {
        return CFG.graphCircleDraw.getWidth() + this.iPaddingGraph * 2 + this.getHeight_Title();
    }

    public int getHeight_Title() {
        return Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.BUTTON_H / 2);
    }

    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : Color.WHITE) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    public Color getColorLeft() {
        return new Color(0.19607843f, 0.39215687f, 0.7647059f, 1.0f);
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        this.isDescriptionActive = true;
    }
}

