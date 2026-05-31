/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Alliances;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Alliance;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ColorPicker;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_Alliances
extends Menu {
    public Menu_ManageDiplomacy_Alliances() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Add(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CreateNewAlliance") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        int tPosX = 0;
        int tWidth = 0;
        for (int i = 1; i < CFG.core.getAlliancesSize(); ++i) {
            tWidth = CFG.BUTTON_W * 2;
            if ((CFG.CIV_FLAG_WIDTH + CFG.PADD) * CFG.core.getAlliance(i).getCivilizationsSize() + CFG.PADD > CFG.BUTTON_W * 2) {
                tWidth = (CFG.CIV_FLAG_WIDTH + CFG.PADD) * CFG.core.getAlliance(i).getCivilizationsSize() + CFG.PADD;
            }
            menuElements.add(new Button_Alliance(i, CFG.core.getAlliance(i).getAllianceName(), -1, CFG.PADD + CFG.BUTTON_W * 2 + CFG.PADD + tPosX, CFG.PADD, tWidth, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getAlliance(this.getCurr()).getAllianceName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.countAlliance_Provinces(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.countAlliance_Population(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.countAlliance_Economy(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        for (int i = 0; i < CFG.core.getAlliance(this.getCurr()).getCivilizationsSize(); ++i) {
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getAlliance(this.getCurr()).getCivilization(i)));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getAlliance(this.getCurr()).getCivilization(i)).getCivName()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            tPosX += (((MenuElemUI)menuElements.get(menuElements.size() - 1)).getTextWidthU() + CFG.PADD * 2 > tWidth ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getTextWidthU() + CFG.PADD * 2 : tWidth) + CFG.PADD;
        }
        menuElements.add(new Button_Game_ColorPicker(CFG.PADD, CFG.BUTTON_H + CFG.BUTTON_H / 2 + CFG.PADD * 3, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                CFG.drawEditorButtons_Top_Edge_R(oSB, this.getPosXE() - CFG.PADD + iTranslateX + iTranslateY, this.getPosY() - CFG.PADD, this.getWidthE() + CFG.PADD * 2, this.getHeightE() + CFG.PADD * 2);
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID <= 0 && (CFG.core.getActiveProvID() < 0 || CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() <= 0)) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ShowHideColorPicker"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.pickerIcon, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.BUTTON_H / 2 + CFG.PADD * 5 + CFG.BUTTON_H, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("NewAlliance"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), this.getMenuElem(0).getHeightE() + CFG.PADD * 2, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.575f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), (this.getMenuElem(0).getHeightE() + CFG.PADD * 2) / 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.675f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 2, 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 2, 1, true, false);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
            int tempProvincePosX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() + CFG.core.getProv(CFG.core.getActiveProvID()).getTranslateProvPosX();
            int tempButtonPosX = this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() / 2 + this.getMenuPosX() + iTranslateX;
            int tempProvincePosY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() + CFG.map.getMpC().getPY();
            int tempButtonPosY = this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 + this.getMenuPosY() + iTranslateY;
            tempProvincePosX = (int)((float)tempProvincePosX * CFG.map.getMpS().getCurrSc());
            tempProvincePosY = (int)((float)tempProvincePosY * CFG.map.getMpS().getCurrSc());
            int iWidth = (int)Math.ceil(Math.sqrt((tempButtonPosX - tempProvincePosX) * (tempButtonPosX - tempProvincePosX) + (tempProvincePosY - tempButtonPosY) * (tempProvincePosY - tempButtonPosY)));
            float fAngle = (float)(Math.atan2(tempProvincePosY - tempButtonPosY, -tempProvincePosX + tempButtonPosX) * 180.0 / Math.PI);
            float tempAngle = fAngle > 90.0f ? 90.0f - fAngle % 90.0f : (fAngle < -90.0f ? -(90.0f + fAngle % 90.0f) : fAngle);
            int offsetX = -((int)((float)IMGManager.getIMG(Images.line32).getHeight() / 2.0f * (tempAngle / 90.0f)));
            int offsetY = -((int)((float)IMGManager.getIMG(Images.line32).getHeight() / 2.0f * ((90.0f - Math.abs(fAngle)) / 90.0f)));
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.45f));
            IMGManager.getIMG(Images.line32).drawO(oSB, tempProvincePosX + offsetX, tempProvincePosY + offsetY, iWidth, IMGManager.getIMG(Images.line32).getHeight(), fAngle, 0);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            if (CFG.menus.getColorPicker().getVisible()) {
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
            } else if (CFG.core.getActiveProvID() >= 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() > 0) {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance();
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getB());
                CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.BUTTON_H / 2 + CFG.PADD * 7);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.CUSTOMIZE_ALLIANCE_COLOR);
            } else {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
            }
            return;
        }
        switch (iID) {
            case 0: {
                CFG.core.addAlliance("");
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getAlliancesSize() - 1;
                CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE);
                CFG.core.disableDrawCivilizationRegions_ActiveProvince();
                break;
            }
            default: {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = iID;
                CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE);
                CFG.core.disableDrawCivilizationRegions_ActiveProvince();
            }
        }
        CFG.menus.getColorPicker().setVisible(false, null);
    }
}

