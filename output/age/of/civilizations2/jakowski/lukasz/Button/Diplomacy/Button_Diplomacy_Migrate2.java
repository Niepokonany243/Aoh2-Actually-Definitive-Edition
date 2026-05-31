/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
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
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_Diplomacy_Migrate2
extends ButtonM {
    private boolean row = true;
    private int iCivID = 0;
    private int toProvinceID = 0;
    private String sToProvinceID;
    private String sTextCostGold;
    private String sTextCostDiplomacy;
    private int iTextCostGoldWidth;
    private int iTextCostDiplomacyWidth;

    public Button_Diplomacy_Migrate2(int fromProvinceID, int toProvinceID, int iCivID, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("MigrateTo") + ": ", 0, iPosX, iPosY, iWidth, Math.max(IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4, CFG.BUTTON_H), isClickable, true, false, false);
        this.iCivID = iCivID;
        this.toProvinceID = toProvinceID;
        this.sTextCostGold = "" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_MOVE / 10.0f;
        this.sTextCostDiplomacy = "+" + (int)((CFG.core.getProv(fromProvinceID).isCapital() ? GameValues.gvMigrate.MIGRATE_RESEARCH_PROGRESS : GameValues.gvMigrate.MIGRATE_RESEARCH_PROGRESS_NOT_CAPITAL) * 100.0f) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sTextCostGold);
        this.iTextCostGoldWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sTextCostDiplomacy);
        this.iTextCostDiplomacyWidth = (int)CFG.glyphLay.width;
        this.sToProvinceID = "" + (CFG.core.getProv(toProvinceID).getName().length() > 0 ? CFG.core.getProv(toProvinceID).getName() : CFG.lang.get("NewLand"));
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
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth - IMGManager.getIMG(Images.flagRect2).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        IMGManager.getIMG(Images.topMovementPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * this.getImageScale(Images.topMovementPoints) / 2.0f) - IMGManager.getIMG(Images.topMovementPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)), (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * this.getImageScale(Images.topMovementPoints)));
        IMGManager.getIMG(Images.research).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(Images.research)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(Images.research) / 2.0f) - IMGManager.getIMG(Images.research).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(Images.research)), (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(Images.research)));
        Renderer.drawText(oSB, this.fontID, this.sTextCostGold, this.getPosXE() + this.getWidthE() - this.iTextCostGoldWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).COST_OF_MOVE ? CFG.COLOR_MOVEMENT : CFG.COLOR_NEGATIVE_2);
        Renderer.drawText(oSB, this.fontID, this.sTextCostDiplomacy, this.getPosXE() + this.getWidthE() - this.iTextCostDiplomacyWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(Images.research)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, Color.WHITE);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - this.getRightWidth() - ButtonDiplomacy.iDiploWidth, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            Renderer.drawText(oSB, this.fontID, this.sToProvinceID, this.getPosXE() + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
    }

    public final int getRightWidth() {
        return Math.max(this.iTextCostGoldWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)), this.iTextCostDiplomacyWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.research)));
    }

    private final float getImageScale(int nImageID) {
        return Math.min(1.0f, (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) / (float)IMGManager.getIMG(nImageID).getHeight());
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    public static void updateT() {
        if (!CFG.jsi.equals("\u0141ukasz Jakowski")) {
            CFG.jsi = "\u0141ukasz Jakowski";
        }
        if (!CFG.jsiw.equals("Lukasz Jakowski")) {
            CFG.jsiw = "Lukasz Jakowski";
        }
        if (!CFG.jsig.equals("\u0141ukasz Jakowski")) {
            CFG.jsig = "\u0141ukasz Jakowski";
        }
        if (!CFG.jsigw.equals("\u0141ukasz Jakowski Games")) {
            CFG.jsigw = "\u0141ukasz Jakowski Games";
        }
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE()));
        nData.add(new ME_Hover_2Type_Text_Big(this.sToProvinceID, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("-" + this.sTextCostGold, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("" + this.sTextCostDiplomacy, CFG.COLOR_RESEARCH));
        nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setMax(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

