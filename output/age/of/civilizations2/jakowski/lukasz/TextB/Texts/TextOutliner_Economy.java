/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_TechLevel;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextOutliner_Economy
extends Text {
    private boolean row = false;
    private int iCivID;
    public int iconWidth;
    public int iconHeight;
    public Color colorText;

    public TextOutliner_Economy(int nCivID, String researchProgress, int iPosX, int iPosY, int iWidth) {
        super(researchProgress, CFG.PADD * 2, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H / 2, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4)), CFG.FONT_BOLD_SMALL);
        this.iCivID = nCivID;
        this.colorText = CFG.COLOR_HAPPINESS_MAX;
        if (this.getWidthE() > iWidth) {
            this.setWidthE(iWidth);
        }
        int nIMGID = Images.economy;
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
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 - CFG.PADD - IMGManager.getIMG(Images.research).getWidth(), CFG.CIV_FLAG_HEIGHT, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 - CFG.PADD - IMGManager.getIMG(Images.research).getWidth(), 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.CIV_FLAG_HEIGHT - 1 + iTranslateY, this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 - CFG.PADD - IMGManager.getIMG(Images.research).getWidth(), 1, true, false);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        int imgID = Images.economy;
        IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() - this.iconWidth - CFG.PADD - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iconHeight / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH / 2 - CFG.PADD * 2 - this.iconWidth - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_ECONOMY_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_ECONOMY_HOVER : CFG.COLOR_ECONOMY) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            long tempTotalEco = CFG.core.getCiv(civID).countEco();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + tempTotalEco), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(civID).getCivName(), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Flag_Big(civID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)civID).civGD.startingEconomy), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
            long difference = tempTotalEco - CFG.core.getCiv((int)civID).civGD.startingEconomy;
            nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)civID).civGD.startingEconomy, CFG.core.getCiv((int)civID).civGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, civID));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OverinvestmentPenalty") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(civID) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag(civID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag(civID, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalEconomicIncrease") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)civID).civGD.iGEG), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalCost") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)civID).civGD.iGE), CFG.COLOR_GOLD));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (Exception ex) {
            this.menuElemHover = null;
        }
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (this.getHeightE() < this.iTextHeight) {
                this.setHeightE(this.iTextHeight);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void actionElem(int iID) {
        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE);
        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("Economy"));
            lColors.add(CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.addM(lMess, lColors);
        }
    }
}

