
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Diplomacy_Relation
extends ButtonStats {
    private static final float FONT_SCALE = 0.7f;
    private int iCivA;
    private int iCivB;
    private String sCivBName;
    private String sCurrentRelation;
    private int iCurrentRelationWidth = 0;
    private String sDiploCost;
    private int iDiploCostWidth = 0;

    public Button_Diplomacy_Relation(String sText, String nDiploCost, int nAggressor, int nDefender, int iPosX, int iPosY, int iWidth) {
        super(sText, 0, iPosX, iPosY, iWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
        this.iCivA = nAggressor;
        this.iCivB = nDefender;
        this.sCivBName = CFG.core.getCiv(nDefender).getCivName();
        this.sDiploCost = nDiploCost;
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sDiploCost);
        this.iDiploCostWidth = (int)(CFG.glyphLay.width * 0.7f);
        this.sCurrentRelation = "" + (CFG.core.getCivRelationOfCivB(this.iCivB, this.iCivA) > 0.0f ? "+" : "") + (float)((int)(CFG.core.getCivRelationOfCivB(this.iCivB, this.iCivA) * 10.0f)) / 10.0f + " ";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sCurrentRelation);
        this.iCurrentRelationWidth = (int)(CFG.glyphLay.width * 0.7f);
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
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivB).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivB).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivB).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentRelationWidth + CFG.PADD * 3 + (int)((float)this.getTextWidthU() * 0.7f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        CFG.core.getCiv(this.iCivB).getFlagC().drawO(oSB, this.getPosXE() + this.iCurrentRelationWidth + CFG.PADD * 3 + (int)((float)this.getTextWidthU() * 0.7f) + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iCivB).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.iCurrentRelationWidth + CFG.PADD * 3 + (int)((float)this.getTextWidthU() * 0.7f) + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) + iTranslateY, CFG.COLOR_HOVER_TITLE);
        CFG.drawTextDefaultWithShadow(oSB, this.sCurrentRelation, this.getPosXE() + CFG.PADD * 2 + (int)((float)this.getTextWidthU() * 0.7f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) + iTranslateY, CFG.core.getCivRelationOfCivB(this.iCivB, this.iCivA) > 0.0f ? CFG.COLOR_POSITIVE : (CFG.core.getCivRelationOfCivB(this.iCivB, this.iCivA) == 0.0f ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2));
        CFG.drawTextDefaultWithShadow(oSB, this.sCivBName, this.getPosXE() + this.iCurrentRelationWidth + CFG.PADD * 4 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + (int)((float)this.getTextWidthU() * 0.7f) + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints)) / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints)));
        CFG.drawTextDefaultWithShadow(oSB, this.sDiploCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iDiploCostWidth - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS ? Color.WHITE : CFG.COLOR_NEGATIVE_2);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivA, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivA).getCivName()));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivB, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivB).getCivName()));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("-" + this.sDiploCost, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

