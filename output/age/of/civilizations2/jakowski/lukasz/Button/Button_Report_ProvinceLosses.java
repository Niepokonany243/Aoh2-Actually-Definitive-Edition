
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Report_Armies;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Report_ProvinceLosses
extends ButtonM {
    private long iPopulationLosses;
    private long iEconomyLosses;
    private int iEconomyLossesWidth;

    public Button_Report_ProvinceLosses(int iPosX, int iPosY, int iWidth, long nPopulationLosses, long nEconomyLosses) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.iPopulationLosses = nPopulationLosses;
        this.iEconomyLosses = nEconomyLosses;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "-" + this.iEconomyLosses);
        this.iEconomyLossesWidth = (int)CFG.glyphLay.width;
        super.init("", 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT, Math.max(IMGManager.getIMG(Images.economy).getHeight(), IMGManager.getIMG(Images.pop).getHeight())) + CFG.PADD * 4, true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.475f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.425f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5, false, true);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, this.getIsHovered() ? 0.95f : 0.745f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        CFG.drawRect(oSB, this.getPosXE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() + 2, this.getHeightE() + 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        CFG.drawRect(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() - 2, this.getHeightE() - 2);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pop).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - IMGManager.getIMG(Images.economy).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.economy).getHeight() / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, "-" + this.iPopulationLosses, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.pop).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, Button_Report_Armies.COLOR_ARMY_LOST);
        Renderer.drawText(oSB, this.fontID, "-" + this.iEconomyLosses, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.economy).getWidth() - this.iEconomyLossesWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, Button_Report_Armies.COLOR_ARMY_LOST);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilianDeaths") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iPopulationLosses, CFG.COLOR_NEGATIVE_1));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicLosses") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iEconomyLosses, CFG.COLOR_NEGATIVE_1));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

