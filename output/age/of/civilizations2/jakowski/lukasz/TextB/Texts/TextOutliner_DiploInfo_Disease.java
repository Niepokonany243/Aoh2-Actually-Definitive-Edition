
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextOutliner_DiploInfo_Disease
extends Text {
    public static final float FONT_SCALE = 0.7f;
    private boolean row = false;
    private int iCivLeft;
    public int iProvinceID;
    public int iTurnID;
    public String sAllianceName;

    public TextOutliner_DiploInfo_Disease(int iCivLeft, int iProvinceID, String sAllianceName, int iTurnID, int iPosX, int iPosY, int nWidth) {
        super("", CFG.PADD * 2, iPosX, iPosY, nWidth, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2);
        this.iProvinceID = CFG.FOG_OF_WAR < 2 || iProvinceID < 0 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(iProvinceID) ? iProvinceID : -1;
        this.iCivLeft = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(iCivLeft) ? iCivLeft : -iCivLeft;
        this.sAllianceName = sAllianceName;
        this.iTurnID = iTurnID;
    }

    public final int getImage() {
        return Images.disease;
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
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(this.getImage()).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(this.getImage()).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.getImage()).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        if (this.iCivLeft >= 0) {
            CFG.core.getCiv(this.iCivLeft).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(this.iCivLeft).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        } else {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.CIV_FLAG_WIDTH - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Disease") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(this.sAllianceName, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image_Big(Images.disease, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OutbreakOfDisease") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.iProvinceID >= 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag(this.iProvinceID >= 0 ? CFG.core.getProv(this.iProvinceID).getCivId() : -1, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(this.iTurnID) + " "));
        nData.add(new ME_Hover_2Type_Text("[" + CFG.lang.get("Turn") + ": " + this.iTurnID + "]", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void actionElem(int iID) {
        if (this.iProvinceID >= 0) {
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DISEASES_MODE) {
                CFG.mapModesManager.disableAllViews();
            } else {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DISEASES_MODE);
                CFG.core.setActiveProvID(this.iProvinceID);
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                    CFG.toastM.addM(CFG.lang.get("OutbreakOfDisease") + ": " + CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }
        } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DISEASES_MODE) {
            CFG.mapModesManager.disableAllViews();
        } else {
            CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DISEASES_MODE);
            CFG.toastM.addM("Diseases", CFG.COLOR_NEGATIVE_2);
        }
    }
}

