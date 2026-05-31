
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Casualties
extends ButtonM {
    private boolean row = true;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private Color oColorCasualtiesTotal;

    public Button_Casualties(int WAR_ID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("Casualties") + ": ", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        long tempCas = CFG.core.getWar(WAR_ID).getCasualties_Aggressors() + CFG.core.getWar(WAR_ID).getCasualties_Defenders();
        this.oColorCasualtiesTotal = tempCas == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2;
        this.sPopulation = "" + CFG.getNumber_SHORT(tempCas);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
        }
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() * 4 / 5, this.getHeightE(), false, false);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.skull).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + this.getTextWidthU() + this.iPopulationWidth + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.skull).getHeight() * this.getImageScale(IMGManager.getIMG(Images.skull).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.skull).getHeight(), (int)((float)IMGManager.getIMG(Images.skull).getWidth() * this.getImageScale(IMGManager.getIMG(Images.skull).getHeight())), (int)((float)IMGManager.getIMG(Images.skull).getHeight() * this.getImageScale(IMGManager.getIMG(Images.skull).getHeight())));
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopulation, this.getPosXE() + CFG.PADD * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.oColorCasualtiesTotal);
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            long tempCas = CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getCasualties_Aggressors() + CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getCasualties_Defenders();
            this.oColorCasualtiesTotal = tempCas == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2;
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempCas), this.oColorCasualtiesTotal));
            nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (tempCas > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                boolean added = false;
                for (int i = 0; i < CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getAggressorsSize(); ++i) {
                    tempCas = CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getAggressorID(i).getCasualties() + CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getAggressorID(i).getCivilianDeaths();
                    if (tempCas <= 0L) continue;
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getAggressorID(i).getCivID()));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempCas), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    added = true;
                }
                boolean added2 = false;
                for (int i = 0; i < CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getDefendersSize(); ++i) {
                    tempCas = CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getDefenderID(i).getCasualties() + CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getDefenderID(i).getCivilianDeaths();
                    if (tempCas <= 0L) continue;
                    if (added && !added2) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        added2 = true;
                    }
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getDefenderID(i).getCivID()));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempCas), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException e) {
            this.menuElemHover = null;
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(0.82f, 0.82f, 0.82f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    private final float getImageScale(int nImageID) {
        return (float)((CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) / IMGManager.getIMG(nImageID).getHeight()) < 1.0f ? (float)((CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) / IMGManager.getIMG(nImageID).getHeight()) : 1.0f;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public int getWidthE() {
        return Math.max(super.getWidthE(), CFG.PADD * 4 + (this.getTextWidthU() + this.iPopulationWidth + (int)((float)IMGManager.getIMG(Images.skull).getWidth() * this.getImageScale(IMGManager.getIMG(Images.skull).getHeight()))) + CFG.PADD * 2);
    }
}

