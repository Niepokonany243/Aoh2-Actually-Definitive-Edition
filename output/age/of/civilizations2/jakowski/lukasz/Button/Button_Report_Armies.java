
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Report_Armies
extends ButtonM {
    public static final int COLOR_WIDTH = 2;
    public static final Color COLOR_ARMY = CFG.COLOR_HOVER_TITLE;
    public static final Color COLOR_ARMY_LOST = new Color(0.5803922f, 0.08627451f, 0.0f, 1.0f);
    private int iCivID;
    private long iArmy;
    private long iArmyLost;
    private int iArmyLostWidth;
    private int iArmyResultWidth;

    public Button_Report_Armies(int iPosX, int iPosY, int iWidth, int nCivID, long nArmy, long nArmyLost) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.iCivID = nCivID;
        this.iArmy = nArmy;
        this.iArmyLost = nArmyLost;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.iArmyLost > 0 ? "-" + this.iArmyLost : "" + this.iArmyLost);
        this.iArmyLostWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + (this.iArmy - this.iArmyLost));
        this.iArmyResultWidth = (int)CFG.glyphLay.width;
        super.init("", 0, iPosX, iPosY, iWidth, CFG.PADD + IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 4, true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.425f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.245f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 0.175f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2 + IMGManager.getIMG(Images.flagRectSmall).getWidth() + 2, this.getHeightE());
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5, false, true);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, this.getIsHovered() ? 0.95f : 0.675f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        CFG.drawRect(oSB, this.getPosXE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() + 2, this.getHeightE() + 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        CFG.drawRect(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() - 2, this.getHeightE() - 2);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 0.85f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, 2, CFG.CIV_FLAG_HEIGHT, true, false);
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawText(oSB, this.fontID, "" + this.iArmy, this.getPosXE() + CFG.PADD + 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, COLOR_ARMY);
        IMGManager.getIMG(Images.diploArmy).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - IMGManager.getIMG(Images.diploArmy).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.iArmyLost > 0 ? "-" + this.iArmyLost : "" + this.iArmyLost, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - this.iArmyLostWidth - CFG.PADD - IMGManager.getIMG(Images.diploArmy).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, COLOR_ARMY_LOST);
        Renderer.drawText(oSB, this.fontID, "" + (this.iArmy - this.iArmyLost), this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - this.iArmyResultWidth - CFG.PADD - IMGManager.getIMG(Images.diploArmy).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.iArmy - this.iArmyLost == 0 ? COLOR_ARMY_LOST : COLOR_ARMY);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName()));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Strength") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iArmy, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iArmyLost, this.iArmyLost > 0 ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEUTRAL));
        if (this.iArmyLost > 0) {
            nData.add(new ME_Hover_2Type_Text(" [" + (int)((float)this.iArmyLost / (float)this.iArmy * 100.0f) + "%]", CFG.COLOR_NEUTRAL));
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

