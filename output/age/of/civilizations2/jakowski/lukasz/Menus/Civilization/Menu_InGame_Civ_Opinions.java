
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Sort;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Opinion.Button_Diplomacy_Opinion2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Civ_Opinions
extends Menu {
    public static int iACTIVE_VIEW_ID = -999;

    public Menu_InGame_Civ_Opinions() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        int nPosY = 0;
        int tempElemH = Math.max(Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.flagRect2).getHeight()) + CFG.PADD * 4, CFG.BUTTON_H / 2);
        menuElements.add(new Button_Diplomacy_Sort(Images.diploAZ, 0, CFG.PADD, nPosY, (menuW - CFG.PADD * 2) / 2, tempElemH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortByName"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploAZ, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Diplomacy_Sort(Images.diploHeart, 0, CFG.PADD + (menuW - CFG.PADD * 2) / 2, nPosY, menuW - CFG.PADD * 2 - (menuW - CFG.PADD * 2) / 2, tempElemH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortByOpinions"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploHeart, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        try {
            int i;
            int tempAddID;
            int i2;
            if (iACTIVE_VIEW_ID == -999) {
                iACTIVE_VIEW_ID = 1;
            } else if (iACTIVE_VIEW_ID == -1) {
                for (int i3 = CFG.core.getCivsSize() - 1; i3 > 0; --i3) {
                    if (CFG.core.getCiv(CFG.core.getSortedCivsAZ(i3 - 1)).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == CFG.core.getSortedCivsAZ(i3 - 1)) continue;
                    menuElements.add(new Button_Diplomacy_Opinion2(CFG.core.getSortedCivsAZ(i3 - 1), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getSortedCivsAZ(i3 - 1)), (int)CFG.core.getCivRelationOfCivB(CFG.core.getSortedCivsAZ(i3 - 1), CFG.getActiveCivInfoId()), 0, 0, nPosY, menuW - 2, tempElemH, true));
                    nPosY += tempElemH;
                }
            } else if (iACTIVE_VIEW_ID == 1) {
                for (int i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                    if (CFG.core.getCiv(CFG.core.getSortedCivsAZ(i4 - 1)).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == CFG.core.getSortedCivsAZ(i4 - 1)) continue;
                    menuElements.add(new Button_Diplomacy_Opinion2(CFG.core.getSortedCivsAZ(i4 - 1), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getSortedCivsAZ(i4 - 1)), (int)CFG.core.getCivRelationOfCivB(CFG.core.getSortedCivsAZ(i4 - 1), CFG.getActiveCivInfoId()), 0, 0, nPosY, menuW - 2, tempElemH, true));
                    nPosY += tempElemH;
                }
            } else if (iACTIVE_VIEW_ID == 2) {
                ArrayList<Integer> tempC = new ArrayList<Integer>();
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (CFG.core.getCiv(CFG.core.getSortedCivsAZ(i2 - 1)).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == CFG.core.getSortedCivsAZ(i2 - 1)) continue;
                    tempC.add(CFG.core.getSortedCivsAZ(i2 - 1));
                }
                while (tempC.size() > 0) {
                    tempAddID = 0;
                    for (i = 1; i < tempC.size(); ++i) {
                        if (!(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(tempAddID)) < CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(i)))) continue;
                        tempAddID = i;
                    }
                    menuElements.add(new Button_Diplomacy_Opinion2((Integer)tempC.get(tempAddID), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(tempAddID)), (int)CFG.core.getCivRelationOfCivB((Integer)tempC.get(tempAddID), CFG.getActiveCivInfoId()), 0, 0, nPosY, menuW - 2, tempElemH, true));
                    nPosY += tempElemH;
                    tempC.remove(tempAddID);
                }
            } else {
                ArrayList<Integer> tempC = new ArrayList<Integer>();
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (CFG.core.getCiv(CFG.core.getSortedCivsAZ(i2 - 1)).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == CFG.core.getSortedCivsAZ(i2 - 1)) continue;
                    tempC.add(CFG.core.getSortedCivsAZ(i2 - 1));
                }
                while (tempC.size() > 0) {
                    tempAddID = 0;
                    for (i = 1; i < tempC.size(); ++i) {
                        if (!(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(tempAddID)) > CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(i)))) continue;
                        tempAddID = i;
                    }
                    menuElements.add(new Button_Diplomacy_Opinion2((Integer)tempC.get(tempAddID), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempC.get(tempAddID)), (int)CFG.core.getCivRelationOfCivB((Integer)tempC.get(tempAddID), CFG.getActiveCivInfoId()), 0, 0, nPosY, menuW - 2, tempElemH, true));
                    nPosY += tempElemH;
                    tempC.remove(tempAddID);
                }
            }
        }
        catch (IndexOutOfBoundsException tempC) {
            
        }
        this.initMenu(null, 0 + AoCGame.LEFT, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, menuW, tempElemH * 8, menuElements, false, false);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_Civ.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = Menu_InGame_Civ.hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (Menu_InGame_Civ.hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, false);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + 1, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + this.getHeightM(), this.getWidthM() - 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + 2 + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + 2, true, false);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                iACTIVE_VIEW_ID = iACTIVE_VIEW_ID == 1 ? -1 : 1;
                CFG.menus.rebuildInGame_Civ_Opinions();
                return;
            }
            case 1: {
                iACTIVE_VIEW_ID = iACTIVE_VIEW_ID == 2 ? -2 : 2;
                CFG.menus.rebuildInGame_Civ_Opinions();
                return;
            }
        }
        CFG.setActiveCivInfoId(this.getMenuElem(iID).getCurr());
        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
        CFG.updateActiveCivilizationInfoInGame();
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
        }
    }

    @Override
    public void actionCloseMenu() {
        super.setVisibleM(false);
    }

    @Override
    public void setPosY(int iPosY) {
        super.setPosY(iPosY);
        if (this.getPosY() + this.getHeightM() > CFG.GAMEHEIGHT) {
            this.setHeight(Math.max(CFG.GAMEHEIGHT - this.getPosY(), CFG.BUTTON_H / 2));
        }
        int tempElemH = CFG.isAndroid() ? Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, (int)((float)CFG.BUTTON_H * 0.6f)) : CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        this.setHeight(Math.min(this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() + 1, Math.max(CFG.GAMEHEIGHT - this.getPosY() - CFG.PADD, Math.min(this.getHeightM(), tempElemH * (CFG.getIsDesktop() ? 8 : 6)))));
        this.updateMenuElements_IsInView();
    }
}

