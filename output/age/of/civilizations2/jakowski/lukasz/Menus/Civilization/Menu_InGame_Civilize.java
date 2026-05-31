
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Civilize2;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Civilize
extends Menu {
    private int iOnCivID = -1;

    public Menu_InGame_Civilize() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Civilize"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Civilize(final int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new Button_Diplomacy_Civilize2(this.iOnCivID, 2, tY, CFG.BUTTON_W * 2 - 2, true, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).CIVILIZE_TECH_LEVEL){

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_Civilize(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Civilize.this.getElementW() * 2;
            }
        });
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        menuElements.add(new Button_DiplomacyAction(Images.pop, CFG.lang.get("Capital") + ", " + CFG.lang.get("Population") + ": +" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_POPULATION_BONUS_CAPITAL), 0, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Civilize.this.getElementW() * 2;
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ", " + CFG.lang.get("Population") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_POPULATION_BONUS_CAPITAL), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.lang.get("Capital") + ", " + CFG.lang.get("Economy") + ": +" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_ECONOMY_BONUS_CAPITAL), 0, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Civilize.this.getElementW() * 2;
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ", " + CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_ECONOMY_BONUS_CAPITAL), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Civilize.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Civilize"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Civilize.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Civilize.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeTypeOfGovernment") + "..?", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WhatIsAGovernmentAnyway")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeTypeOfGovernmentTo") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CAN_BECOME_CIVILIZED).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CAN_BECOME_CIVILIZED).getColor()));
                    nData.add(new ME_Hover_2Type_Ideology(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CAN_BECOME_CIVILIZED, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ", " + CFG.lang.get("Population") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_POPULATION_BONUS_CAPITAL), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ", " + CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + GameValues.gvTribal.CIVILIZE_ECONOMY_BONUS_CAPITAL), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CIVILIZE_TECH_LEVEL * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(onCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? Images.iconTrue : Images.iconFalse, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("[", CFG.core.getCiv(onCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag(onCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(onCivID).getTechLevel() * 100.0f)) / 100.0f, CFG.core.getCiv(onCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text("]", CFG.core.getCiv(onCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)onCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text("" + (float)GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS / 10.0f));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(onCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                try {
                    CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CAN_BECOME_CIVILIZED).getCrownImageScaled().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CAN_BECOME_CIVILIZED).getCrownImageScaled().getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CAN_BECOME_CIVILIZED).getCrownImageScaled().getHeight() / 2 + iTranslateY);
                    Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CAN_BECOME_CIVILIZED).getCrownImageScaled().getWidth() + CFG.PADD) / 2 + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CAN_BECOME_CIVILIZED).getCrownImageScaled().getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                }
                catch (IndexOutOfBoundsException ex) {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(Menu_InGame_Civilize.this.iOnCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Menu_InGame_Civilize)Menu_InGame_Civilize.this).iOnCivID).getIdeology()).CIVILIZE_TECH_LEVEL <= CFG.core.getCiv(Menu_InGame_Civilize.this.iOnCivID).getTechLevel();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.getSend();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Civilize"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.23529412f, 0.39215687f, 0.5882353f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.23529412f, 0.39215687f, 0.5882353f, 0.375f));
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
                CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().drawO(oSB, Menu_InGame_Civilize.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Civilize.this.getPosY() - this.getHeightT() / 2 - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
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
            if (GameManager.civilizeCiv(this.iOnCivID)) {
                for (int i = 0; i < CFG.core.getCiv((int)this.iOnCivID).getCivDiploGD().messageBox.getMessagesSize(); ++i) {
                    if (CFG.core.getCiv((int)this.iOnCivID).getCivDiploGD().messageBox.getMessage((int)i).messageType != MessageType.UNCIVILIZED) continue;
                    CFG.core.getCiv((int)this.iOnCivID).getCivDiploGD().messageBox.removeMessage(i);
                    break;
                }
                CFG.menus.rebuildInGame_Messages();
                CFG.updateActiveCivilizationInfoInGame();
            }
            CFG.menus.updateInGameTopAll(this.iOnCivID);
            CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(3500);
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
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

