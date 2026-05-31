/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.War.Ultimatum;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Demand;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_War_Cost;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_CrossTheBorder;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Ultimatum
extends Menu {
    private int iOnCivID = -1;

    public Menu_InGame_Ultimatum() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Ultimatum"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Ultimatum(final int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Button_Diplomacy_War_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }
        });
        menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("DemandAnnexation"), CFG.getActiveCivInfoId(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            public void actionElem(int iID) {
                CFG.ultimatum.demandAnexation = !CFG.ultimatum.demandAnexation;
                CFG.ultimatum.demandProvinces.clear();
                if (CFG.ultimatum.demandAnexation) {
                    CFG.ultimatum.demandVasalization = false;
                }
            }

            @Override
            public boolean getCheckboxSt() {
                return CFG.ultimatum.demandAnexation;
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(onCivID).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            }

            @Override
            public void buildElemHover() {
                if (CFG.core.getCiv(onCivID).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                    this.menuElemHover = null;
                } else {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("YouCanDemandAnAnnexationOnlyFromYourVassal"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() != CFG.core.getCiv(onCivID).getPuppetOfCiv()) {
            menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("DemandVassalization"), CFG.getActiveCivInfoId(), 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Ultimatum.this.getElementW() * 2;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.ultimatum.demandVasalization = !CFG.ultimatum.demandVasalization;
                    CFG.ultimatum.demandProvinces.clear();
                    if (CFG.ultimatum.demandVasalization) {
                        CFG.ultimatum.demandAnexation = false;
                    }
                }

                @Override
                public boolean getCheckboxSt() {
                    return CFG.ultimatum.demandVasalization;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        try {
            menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("ChangeTypeOfGovernmentTo") + ": " + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getName(), CFG.getActiveCivInfoId(), 2, tY, tempWidth - 4){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Ultimatum.this.getElementW() * 2;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.ultimatum.demandChangeOfGovernment = !CFG.ultimatum.demandChangeOfGovernment;
                }

                @Override
                public boolean getCheckboxSt() {
                    return CFG.ultimatum.demandChangeOfGovernment;
                }

                @Override
                public boolean getIsClickable() {
                    try {
                        return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology();
                    }
                    catch (Exception exception) {
                        return super.getIsClickable();
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        catch (Exception exception) {
            // empty catch block
        }
        menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("DemandProvinces") + ": ", CFG.getActiveCivInfoId(), 2, tY, CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            public void actionElem(int iID) {
                CFG.ultimatum.demandAnexation = false;
                CFG.ultimatum.demandVasalization = false;
                if (CFG.ultimatum.demandProvinces.size() == 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = onCivID;
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.ULTIMATUM;
                    CFG.VIEW_SHOW_VALUES = false;
                    CFG.selectMode = true;
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    CFG.menus.setMenuID(View.eINGAME_SELECT_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = onCivID;
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.ULTIMATUM;
                    CFG.VIEW_SHOW_VALUES = false;
                    CFG.selectMode = true;
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                        CFG.core.getProvSelected().addProv(CFG.ultimatum.demandProvinces.get(i));
                    }
                    CFG.menus.setMenuID(View.eINGAME_SELECT_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                }
            }

            @Override
            public String getTextE() {
                return super.getTextE() + CFG.ultimatum.demandProvinces.size();
            }

            @Override
            public boolean getCheckboxSt() {
                return CFG.ultimatum.demandProvinces.size() > 0;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.ultimatum.demandProvinces.size() > 0) {
                    nData.add(new ME_Hover_2Type_Flag(onCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ultimatum.demandProvinces.get(i)).getName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (nElements.size() == 0) {
                    this.menuElemHover = null;
                    return;
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("DemandMilitaryAccess"), CFG.getActiveCivInfoId(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            public void actionElem(int iID) {
                CFG.ultimatum.demandMilitaryAccess = !CFG.ultimatum.demandMilitaryAccess;
            }

            @Override
            public boolean getCheckboxSt() {
                return CFG.ultimatum.demandMilitaryAccess;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < CFG.core.getCiv((int)onCivID).civGD.vassals.size(); ++i) {
            menuElements.add(new Button_Diplomacy_Demand(CFG.lang.get("DemandLiberationOfVassal") + ": " + CFG.core.getCiv(CFG.core.getCiv((int)onCivID).civGD.vassals.get((int)i).iCivID).getCivName(), CFG.core.getCiv((int)onCivID).civGD.vassals.get((int)i).iCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Ultimatum.this.getElementW() * 2;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.ultimatum.updateLiberationDemand(this.getCurr());
                }

                @Override
                public boolean getCheckboxSt() {
                    return CFG.ultimatum.isLiberationDemanded(this.getCurr());
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Slider_CrossTheBorder(CFG.lang.get("OrXUnitsWillInvade", 0), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits(), 0, 0.65f){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2 - CFG.PADD * 4;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.65f);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("SendUltimatum"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Ultimatum.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Ultimatum.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendUltimatum") + ":", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Ultimatum.this.iOnCivID, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(Menu_InGame_Ultimatum.this.iOnCivID).getCivName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.ultimatum.canBeSend()) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.ultimatum.demandAnexation) {
                            nData.add(new ME_Hover_2Type_Flag(onCivID));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandAnnexation"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.ultimatum.demandVasalization) {
                            nData.add(new ME_Hover_2Type_Flag(onCivID));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandVassalization"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.ultimatum.demandProvinces.size() > 0) {
                            nData.add(new ME_Hover_2Type_Flag(onCivID));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ultimatum.demandProvinces.get(i)).getName()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OrXUnitsWillInvade", Menu_InGame_Ultimatum.this.getMenuElem(Menu_InGame_Ultimatum.this.getMenuElemsSize() - 3).getCurr()), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) + ".", CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploRivals).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploRivals).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploRivals).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploRivals).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploRivals).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.ultimatum.canBeSend() && Menu_InGame_Ultimatum.this.getMenuElem(Menu_InGame_Ultimatum.this.getMenuElemsSize() - 3).getCurr() > 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvUltimatum.COST_ULTIMATUM_DIPLOMACY_POINTS;
            }

            @Override
            public int getSFXElem() {
                return this.getIsClickable() ? SFXManager.SFX_WAR : super.getSFXElem();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Ultimatum"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                int imgID = Images.diploRivals;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_Ultimatum.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGameOfferAlliance.lTime + (long)Menu_InGame_Message_Alliance.ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2 - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + 4 + Core.PADDING * 2, -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - Menu_InGameOfferAlliance.lTime) / (float)Menu_InGame_Message_Alliance.ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            CFG.setRenderO(true);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            if (GameManager.sendUltimatum(this.iOnCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.ultimatum, this.getMenuElem(this.getMenuElemsSize() - 3).getCurr())) {
                try {
                    if (CFG.ultimatum.demandAnexation || !CFG.ultimatum.demandProvinces.isEmpty()) {
                        ++CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.ULTIMATUMS_SENT;
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
                CFG.toastM.setTimeInView(3500);
            }
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}

