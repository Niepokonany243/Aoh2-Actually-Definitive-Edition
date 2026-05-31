
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Relations;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Diplomacy_ImprovingRelations
extends ButtonM {
    public int iCivID = 0;
    private boolean row = false;
    private String sImprovingRelations;
    private int iImprovingRelationsWidth;
    private int iImprovingRelationsHeight;
    private String sImprovingRelations2;

    public Button_Diplomacy_ImprovingRelations(int nCivID, int nNumOfTurns, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init("", iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
        this.iCivID = nCivID;
        this.sImprovingRelations = CFG.lang.get("ImprovingRelations") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sImprovingRelations);
        this.iImprovingRelationsWidth = (int)CFG.glyphLay.width;
        this.iImprovingRelationsHeight = (int)CFG.glyphLay.height;
        this.sImprovingRelations2 = CFG.lang.get("TurnsX", nNumOfTurns);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
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
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sImprovingRelations, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iImprovingRelationsHeight / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sImprovingRelations2, this.getPosXE() + this.iImprovingRelationsWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iImprovingRelationsHeight / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        if (this.getIsHovered() || isActive) {
            IMGManager.getIMG(Images.iconFalse).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.iconFalse).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)IMGManager.getIMG(Images.iconFalse).getHeight() * this.getImageScale()) / 2.0f) - IMGManager.getIMG(Images.iconFalse).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.iconFalse).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.iconFalse).getHeight() * this.getImageScale()));
        } else {
            IMGManager.getIMG(Images.iconTrue).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.iconTrue).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)IMGManager.getIMG(Images.iconTrue).getHeight() * this.getImageScale()) / 2.0f) - IMGManager.getIMG(Images.iconTrue).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.iconTrue).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.iconTrue).getHeight() * this.getImageScale()));
        }
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WithdrawTheDiplomat"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image_Big(Images.iconFalse, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName()));
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (CFG.core.getCivRelationOfCivB(this.iCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0.0f ? "+" : "") + (float)((int)(CFG.core.getCivRelationOfCivB(this.iCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10.0f)) / 10.0f, this.getOpinionColor((int)CFG.core.getCivRelationOfCivB(this.iCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))));
            nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, CFG.core.getCiv(this.iCivID).getG() / 255, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f)));
            nData.add(new ME_Hover_2Type_Flag(this.iCivID));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (float)((int)(GameManager.getImproveRelation(CFG.core.getActiveCivID(), this.iCivID) * 100.0f)) / 100.0f, CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploRelationsInc, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    public final Color getOpinionColor(int nOpinion) {
        return nOpinion > 0 ? CFG.COLOR_POSITIVE : (nOpinion == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2);
    }

    private final float getImageScale() {
        return Math.min((float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(Images.iconFalse).getHeight(), 1.0f);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }
}

