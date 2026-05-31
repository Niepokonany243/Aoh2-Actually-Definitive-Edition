
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Diplomacy;
import age.of.civilizations2.jakowski.lukasz.Menus.Population.Menu_InGame_View_Population;
import age.of.civilizations2.jakowski.lukasz.Menus.Rank.Menu_InGame_Rank_List;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class ButtonDiplomacy
extends ButtonM {
    public static int iDiploWidth = 0;
    private int iDiploImageID;
    public List<Integer> lCivs;
    private boolean row = false;
    private boolean moveable = false;
    private int iButtonsPosX;
    private boolean scrollModeY = false;
    private int iScrollPosX = -1;
    private int iScrollPosX2 = -1;
    private float fScrollNewMenuPosY = 0.0f;
    public int iHoveredID = -1;

    public static final void setMaxDiploWidth(int nDiploWidth) {
        if (nDiploWidth + ButtonDiplomacy.getMaxDiploWidth_ExtraPadding() > iDiploWidth) {
            iDiploWidth = nDiploWidth + ButtonDiplomacy.getMaxDiploWidth_ExtraPadding();
        }
    }

    public static final int getMaxDiploWidth_ExtraPadding() {
        return CFG.PADD * 4;
    }

    public ButtonDiplomacy(int iDiploImageID, List<Integer> nCivs, int iPosX, int iPosY, int iWidth) {
        this.init("", 0, iPosX, iPosY, iWidth, Menu_InGame_Civ_Diplomacy.getButtonHeight(), true, true, false, false);
        this.iDiploImageID = iDiploImageID;
        this.lCivs = new ArrayList<Integer>();
        for (int i = 0; i < nCivs.size(); ++i) {
            this.lCivs.add(nCivs.get(i));
        }
        this.updateMoveable();
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.DIPLOMACY_INFO;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.scrollModeY) {
            if (Math.abs(this.fScrollNewMenuPosY) > 1.0f) {
                this.setCurr(this.iButtonsPosX + (int)this.fScrollNewMenuPosY);
                this.fScrollNewMenuPosY *= 0.97f;
            } else {
                this.scrollModeY = false;
            }
            CFG.setRenderO(true);
        }
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.1f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.125f));
            IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.75f));
                IMGManager.getIMG(Images.line32Off1).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            }
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.45f));
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD);
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 3 + iTranslateY, this.getWidthE(), this.getHeightE() / 3, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.335f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.075f));
            IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.75f));
                IMGManager.getIMG(Images.line32Off1).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            }
            oSB.setColor(new Color(0.06f, 0.06f, 0.1f, 0.65f));
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iDiploImageID).drawO(oSB, this.getPosXE() + (iDiploWidth - IMGManager.getIMG(this.iDiploImageID).getWidth()) / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - IMGManager.getIMG(this.iDiploImageID).getHeight()) / 2 + iTranslateY);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iDiploWidth + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - iDiploWidth, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        for (int i = 0; i < this.lCivs.size(); ++i) {
            Core.drawFlagRect(oSB, this.getPosXE() + this.iButtonsPosX + iDiploWidth + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD) * i + iTranslateX, this.getPosY() + (this.getHeightE() - IMGManager.getIMG(Images.flagRect2Mask).getHeight()) / 2 + iTranslateY, this.lCivs.get(i));
        }
        if (this.getIsHovered() && this.iHoveredID >= 0) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + this.iButtonsPosX + iDiploWidth + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD) * this.iHoveredID + iTranslateX, this.getPosY() + (this.getHeightE() - IMGManager.getIMG(Images.flagRect2Mask).getHeight()) / 2 + iTranslateY, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 3);
            IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosXE() + this.iButtonsPosX + iDiploWidth + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD) * this.iHoveredID + iTranslateX, this.getPosY() + (this.getHeightE() - IMGManager.getIMG(Images.flagRect2Mask).getHeight()) / 2 + iTranslateY + IMGManager.getIMG(Images.flagRect2Mask).getHeight() - IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 3, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 3, false, true);
            oSB.setColor(Color.WHITE);
        }
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    @Override
    public void updateHover(int nPosX, int nPosY, int menuPosX, int menuPosY) {
        if (nPosX < iDiploWidth) {
            this.setHoveredID(-1);
            return;
        }
        if (nPosX >= menuPosX + this.getPosXE() && nPosX <= menuPosX + this.getPosXE() + this.getWidthE() && nPosY >= menuPosY + this.getPosY() && nPosY <= menuPosY + this.getPosY() + this.getHeightE()) {
            for (int i = 0; i < this.lCivs.size(); ++i) {
                if (nPosX < menuPosX + this.getPosXE() + this.iButtonsPosX + iDiploWidth + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD) * i || nPosX > menuPosX + this.getPosXE() + this.iButtonsPosX + iDiploWidth + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD) * i + (IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD)) continue;
                this.setHoveredID(i);
                return;
            }
        }
        this.setHoveredID(-1);
    }

    private final void setHoveredID(int nHoveredID) {
        if (this.iHoveredID != nHoveredID) {
            this.iHoveredID = nHoveredID;
            this.buildElemHover();
        }
    }

    @Override
    public void buildElemHover() {
        try {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (this.iDiploImageID == Images.diploAlliance) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AlliedWith") + ": "));
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID), CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(-1, CFG.PADD, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploWar) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtWarWith") + ": "));
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID), CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(-1, CFG.PADD, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploDefensivePact) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DefensivePact"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getDefensivePact(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getDefensivePact(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.topGold2) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WarReparations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.getActiveCivInfoId()).getWarReparationsPaysTurnsLeft(this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.getActiveCivInfoId()).getWarReparationsPaysTurnsLeft(this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRelationsInc) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImprovingRelationsWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) < 0.0f ? CFG.COLOR_NEGATIVE_2 : (CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) == 0.0f ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE)));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRelations) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImprovingRelationsFrom") + ":", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) < 0.0f ? CFG.COLOR_NEGATIVE_2 : (CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) == 0.0f ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE)));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRelationsDec) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiplomaticRelationsAreSuspended"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploLoan) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Loans") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big("" + this.lCivs.size(), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploGift) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AGiftFromCivA", CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AGiftFromCivA", CFG.lang.get("Undiscovered")), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                } else if (this.iDiploImageID == Images.hreIcon) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsPartOfHRE"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploTruce) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HasATruceWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploNonAggression) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NonAggressionPact"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivNonAggressionPact(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivNonAggressionPact(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploAccessHas) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GivesMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getMilitaryAccess(this.lCivs.get(this.iHoveredID), CFG.getActiveCivInfoId())), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getMilitaryAccess(this.lCivs.get(this.iHoveredID), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploAccessGives) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HaveMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.loanRe) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Loans"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.sanctions) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SanctionsImpact") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big("-" + CFG.getPrecision2(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).sanctionsImpact * 100.0f, 100) + "%", CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SanctionedCivilizations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        int turns = CFG.core.getCiv(CFG.getActiveCivInfoId()).sanctionsTurns(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID));
                        if (turns > GameCalendar.TURNID) {
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(turns), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", turns - GameCalendar.TURNID) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploGuaranteeGives) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeIndependence"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getGuarantee(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getGuarantee(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploGuaranteeHas) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeTheirIndependence"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName()));
                        nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getGuarantee(this.lCivs.get(this.iHoveredID), CFG.getActiveCivInfoId())), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getGuarantee(this.lCivs.get(this.iHoveredID), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploVassal) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassal") + ": "));
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID), CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(-1, CFG.PADD, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploHeart) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("+" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploHeart, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRivals) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRivals2) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals2, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.diploRivaledBy) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(this.iHoveredID)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivaledBy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.frontline) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumber_SHORT(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).countPop()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.frontline, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.neighWar) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumber_SHORT(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).countPop()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.neighWar, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else if (this.iDiploImageID == Images.pop) {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        int pop = 0;
                        for (int a = 0; a < CFG.core.getCiv(Menu_InGame_View_Population.iCivID).getNumOfProvs(); ++a) {
                            pop += CFG.core.getProv(CFG.core.getCiv(Menu_InGame_View_Population.iCivID).getProvID(a)).getPop().getPopulationOfCivID(this.lCivs.get(this.iHoveredID));
                        }
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + pop), CFG.COLOR_POPULATION));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(this.iHoveredID) >= 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(this.iHoveredID)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(this.iHoveredID)).getCivName(), CFG.COLOR_HOVER_TITLE));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
            catch (IndexOutOfBoundsException ex) {
                if (this.iDiploImageID == Images.diploAlliance) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getAllianceName()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploWar) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtWarWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploNonAggression) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HasSignedNonAggressionPactWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivNonAggressionPact(CFG.getActiveCivInfoId(), this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivNonAggressionPact(CFG.getActiveCivInfoId(), this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploTruce) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TruceWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.getActiveCivInfoId(), this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.getActiveCivInfoId(), this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploLoan) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Loans") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big("" + this.lCivs.size(), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.topGold2) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WarReparations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.getActiveCivInfoId()).getWarReparationsPaysTurnsLeft(this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.getActiveCivInfoId()).getWarReparationsPaysTurnsLeft(this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploDefensivePact) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DefensivePact"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getDefensivePact(CFG.getActiveCivInfoId(), this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getDefensivePact(CFG.getActiveCivInfoId(), this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRelationsInc) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImprovingRelationsWith"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRelations) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImprovingRelationsFrom"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRelationsDec) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiplomaticRelationsAreSuspended"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploGift) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Gift"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.hreIcon) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsPartOfHRE"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size() && i < 14; ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploAccessHas) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GivesMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getMilitaryAccess(this.lCivs.get(i), CFG.getActiveCivInfoId())), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getMilitaryAccess(this.lCivs.get(i), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.frontline) {
                    int i;
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NeighbouringCivilizations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    ArrayList<Integer> toSort = new ArrayList<Integer>();
                    ArrayList<Long> toSortPopulation = new ArrayList<Long>();
                    ArrayList<Integer> sorted = new ArrayList<Integer>();
                    ArrayList<Long> sortedPop = new ArrayList<Long>();
                    for (i = 0; i < this.lCivs.size(); ++i) {
                        toSort.add(this.lCivs.get(i));
                        toSortPopulation.add(CFG.core.getCiv(this.lCivs.get(i)).countPop());
                    }
                    while (!toSort.isEmpty()) {
                        int bestID = 0;
                        for (int i2 = toSort.size() - 1; i2 > 0; --i2) {
                            if ((Long)toSortPopulation.get(bestID) >= (Long)toSortPopulation.get(i2)) continue;
                            bestID = i2;
                        }
                        sorted.add((Integer)toSort.get(bestID));
                        sortedPop.add((Long)toSortPopulation.get(bestID));
                        toSort.remove(bestID);
                        toSortPopulation.remove(bestID);
                    }
                    for (i = 0; i < sorted.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || (Integer)sorted.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big((Integer)sorted.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv((Integer)sorted.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.provinces, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)sorted.get(i)).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.pop, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumber_SHORT((Long)sortedPop.get(i)), CFG.COLOR_POPULATION));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.neighWar) {
                    int i;
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NeighboringCivilizationIsAtWar"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    ArrayList<Integer> toSort = new ArrayList<Integer>();
                    ArrayList<Long> toSortPopulation = new ArrayList<Long>();
                    ArrayList<Integer> sorted = new ArrayList<Integer>();
                    ArrayList<Long> sortedPop = new ArrayList<Long>();
                    for (i = 0; i < this.lCivs.size(); ++i) {
                        toSort.add(this.lCivs.get(i));
                        toSortPopulation.add(CFG.core.getCiv(this.lCivs.get(i)).countPop());
                    }
                    while (!toSort.isEmpty()) {
                        int bestID = 0;
                        for (int i3 = toSort.size() - 1; i3 > 0; --i3) {
                            if ((Long)toSortPopulation.get(bestID) >= (Long)toSortPopulation.get(i3)) continue;
                            bestID = i3;
                        }
                        sorted.add((Integer)toSort.get(bestID));
                        sortedPop.add((Long)toSortPopulation.get(bestID));
                        toSort.remove(bestID);
                        toSortPopulation.remove(bestID);
                    }
                    for (i = 0; i < sorted.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || (Integer)sorted.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big((Integer)sorted.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv((Integer)sorted.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.provinces, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)sorted.get(i)).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.pop, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumber_SHORT((Long)sortedPop.get(i)), CFG.COLOR_POPULATION));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.investF) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingForeignInvestment"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.investF1) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MakingForeignInvestment"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.investB) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingForeignConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.investB1) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MakingForeignConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.propaganda) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingPropaganda"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.propaganda1) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SpreadingPropaganda"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.summit) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiplomaticSummit"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.conquered) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ConqueredCivilizations") + ": [" + this.lCivs.size() + "]", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.pop) {
                    this.menuElemHover = CFG.core.getHover_PopulationOfCiv(Menu_InGame_View_Population.iCivID);
                    return;
                }
                if (this.iDiploImageID == Images.diploAccessGives) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HaveMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.sanctions) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Loans") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big("-" + CFG.getPrecision2(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).sanctionsImpact * 100.0f, 100) + "%", CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SanctionedCivilizations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            int turns = CFG.core.getCiv(CFG.getActiveCivInfoId()).sanctionsTurns(CFG.getActiveCivInfoId(), this.lCivs.get(i));
                            if (turns > GameCalendar.TURNID) {
                                nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(turns), CFG.COLOR_NEUTRAL));
                                nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", turns - GameCalendar.TURNID) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                            }
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.loanRe) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Loans"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getLoansFromCivSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getLoanFromCiv((int)i).fromCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(i + 1 + ". "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getLoanFromCiv((int)i).fromCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploGuaranteeGives) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeIndependence"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getGuarantee(CFG.getActiveCivInfoId(), this.lCivs.get(i))), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getGuarantee(CFG.getActiveCivInfoId(), this.lCivs.get(i))) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploGuaranteeHas) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeTheirIndependence"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                            nData.add(new ME_Hover_2Type_Text_Big(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getGuarantee(this.lCivs.get(i), CFG.getActiveCivInfoId())), CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getGuarantee(this.lCivs.get(i), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploVassal) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassals"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName()));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploHeart) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FriendlyCivilizations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("+" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(i)) * 10.0f)) / 10.0f, CFG.COLOR_POSITIVE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRivals) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Enemies"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(i)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRivals2) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Rivals"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(i)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                if (this.iDiploImageID == Images.diploRivaledBy) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RivaledBy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(this.iDiploImageID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lCivs.size(); ++i) {
                        if (CFG.FOG_OF_WAR < 2 || this.lCivs.get(i) >= 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.lCivs.get(i)));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lCivs.get(i)).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.lCivs.get(i)) * 10.0f)) / 10.0f, CFG.COLOR_NEGATIVE_2));
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                this.menuElemHover = null;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }

    private final void updateMoveable() {
        if (this.getButtonsWidth() - CFG.PADD > this.getWidthE() - iDiploWidth) {
            this.moveable = true;
        } else {
            this.moveable = false;
            this.iButtonsPosX = 0;
        }
    }

    private final int getButtonsWidth() {
        return (IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD) * this.lCivs.size() + CFG.PADD + iDiploWidth;
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    @Override
    public int getCurr() {
        return this.iButtonsPosX;
    }

    @Override
    public void setCurr(int nButtonsPosX) {
        if (nButtonsPosX > 0) {
            nButtonsPosX = 0;
            CFG.menus.setUpdateSliderMenuPosX(true);
            this.scrollModeY = false;
        } else if (nButtonsPosX < -(this.getButtonsWidth() - this.getWidthE())) {
            nButtonsPosX = -(this.getButtonsWidth() - this.getWidthE());
            CFG.menus.setUpdateSliderMenuPosX(true);
            this.scrollModeY = false;
        }
        if (this.iButtonsPosX != nButtonsPosX) {
            this.iButtonsPosX = nButtonsPosX;
        }
    }

    @Override
    public void actionElem(int iID) {
        if (CFG.menus.getVisibleInGame_Rank() && Menu_InGame_Rank_List.imageID == this.iDiploImageID) {
            CFG.menus.setVisibleInGame_Rank(false);
        } else if (this.iDiploImageID == Images.investF1) {
            Menu_InGame_Rank_List.imageID = Images.investF1;
            CFG.menus.rebuildInGame_Build_ForeignInvestments(CFG.getActiveCivInfoId());
        } else if (this.iDiploImageID == Images.investF) {
            Menu_InGame_Rank_List.imageID = Images.investF;
            CFG.menus.rebuildInGame_Build_ForeignInvestments(CFG.getActiveCivInfoId());
        } else if (this.iDiploImageID == Images.investB1) {
            Menu_InGame_Rank_List.imageID = Images.investB1;
            CFG.menus.rebuildInGame_Build_ForeignInvestmentsBuild(CFG.getActiveCivInfoId());
        } else if (this.iDiploImageID == Images.investB) {
            Menu_InGame_Rank_List.imageID = Images.investB;
            CFG.menus.rebuildInGame_Build_ForeignInvestmentsBuild(CFG.getActiveCivInfoId());
        } else {
            ArrayList<Integer> nCivs = new ArrayList<Integer>();
            for (int i = 0; i < this.lCivs.size(); ++i) {
                nCivs.add(this.lCivs.get(i));
            }
            if (CFG.getActiveCivInfoId() > 0) {
                nCivs.add(CFG.getActiveCivInfoId());
            }
            if (!nCivs.contains(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
            Menu_InGame_Rank_List.imageID = this.iDiploImageID;
            CFG.menus.rebuildInGame_Rank_List(nCivs);
        }
    }

    @Override
    public boolean getIsScrollable() {
        return this.moveable;
    }

    @Override
    public void srollByWheel(int nScoll) {
        this.scrollModeY = false;
        this.setCurr(this.getCurr() + nScoll);
    }

    @Override
    public boolean getAnotherView() {
        return false;
    }

    @Override
    public final void scrollTheMenu() {
        if (this.moveable && this.iScrollPosX > 0 && this.iScrollPosX2 > 0 && (float)Math.abs(this.iScrollPosX - this.iScrollPosX2) > 3.0f * CFG.DENSITY) {
            this.fScrollNewMenuPosY = (float)(this.iScrollPosX - this.iScrollPosX2) * 1.25f;
            this.scrollModeY = true;
        }
    }

    @Override
    public final void setScrollPosY(int iScrollPosX) {
        this.iScrollPosX2 = this.iScrollPosX;
        this.iScrollPosX = iScrollPosX;
    }

    @Override
    public void setTypeOfButton(ButtonM.TypeOfButton typeOfButton) {
        this.iScrollPosX2 = -1;
        this.iScrollPosX = -1;
        this.scrollModeY = false;
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        if (this.iHoveredID >= 0) {
            if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                CFG.core.disableDrawCivilizationRegions(CFG.getActiveCivInfoId());
            }
            CFG.setActiveCivInfoId(this.lCivs.get(this.iHoveredID));
            try {
                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
            CFG.updateActiveCivInfo_CreateNewGame();
            CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 1);
        }
    }

    @Override
    public void setMax(int iMax) {
        this.row = iMax == 1;
    }
}

