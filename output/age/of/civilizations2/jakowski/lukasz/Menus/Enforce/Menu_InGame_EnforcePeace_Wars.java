
package age.of.civilizations2.jakowski.lukasz.Menus.Enforce;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_War_Enforce;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_EnforcePeace_Wars
extends Menu {
    public int civID = 0;

    public Menu_InGame_EnforcePeace_Wars(int nCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.civID = nCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        int tY = 0;
        menuElements.add(new ButtonN_Civs(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.civID, 0, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_EnforcePeace_Wars.this.getElementW();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.core.getCiv(this.civID).getCivName() + ": " + CFG.lang.get("CurrentWars"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_EnforcePeace_Wars.this.getElementW();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EnforcePeace"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_EnforcePeace_Wars.this.civID, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandThatTheAggressorEndTheirWar")));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceText1")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceText2")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < CFG.core.getWarsSize(); ++i) {
            int a;
            boolean rebels = false;
            if (!CFG.core.getWar(i).getIsInAggressors(this.civID)) {
                rebels = true;
            } else if (CFG.core.getWar(i).getWarScore() > 0) {
                rebels = true;
            }
            if (!rebels) {
                for (a = 0; a < CFG.core.getWar(i).getDefendersSize(); ++a) {
                    if (!CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getWar((int)i).getDefenderID((int)a).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                    rebels = true;
                    break;
                }
            }
            if (!rebels) {
                for (a = 0; a < CFG.core.getWar(i).getAggressorsSize(); ++a) {
                    if (!CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getWar((int)i).getAggressorID((int)a).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                    rebels = true;
                    break;
                }
            }
            if (rebels) continue;
            menuElements.add(new Button_Stats_War_Enforce(CFG.core.getWar(i).getAggressorID(0).getCivID(), CFG.core.getWar(i).getDefenderID(0).getCivID(), i, 0, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_EnforcePeace_Wars.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_EnforcePeace_War(Menu_InGame_EnforcePeace_Wars.this.civID, this.getCurr());
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        if (menuElements.size() <= 2) {
            menuElements.add(new TextScale(CFG.lang.get("NoWars"), -1, 0, tY, tempWidth - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_EnforcePeace_Wars.this.getElementW();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        }
        boolean addNotAvailable = true;
        for (int i = 0; i < CFG.core.getWarsSize(); ++i) {
            int a;
            boolean rebels = false;
            if (!CFG.core.getWar(i).getIsInDefenders(this.civID)) {
                rebels = true;
            }
            if (CFG.core.getWar(i).getIsInAggressors(this.civID) && CFG.core.getWar(i).getWarScore() > 0) {
                rebels = false;
            }
            if (!rebels) {
                for (a = 0; a < CFG.core.getWar(i).getDefendersSize(); ++a) {
                    if (!CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getWar((int)i).getDefenderID((int)a).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                    rebels = true;
                    break;
                }
            }
            if (!rebels) {
                for (a = 0; a < CFG.core.getWar(i).getAggressorsSize(); ++a) {
                    if (!CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getWar((int)i).getAggressorID((int)a).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                    rebels = true;
                    break;
                }
            }
            if (rebels) continue;
            if (addNotAvailable) {
                addNotAvailable = false;
                menuElements.add(new TextBuildTitle(CFG.lang.get("NotAvailable"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_EnforcePeace_Wars.this.getElementW();
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EnforcePeaceDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            menuElements.add(new Button_Stats_War_Enforce(CFG.core.getWar(i).getAggressorID(0).getCivID(), CFG.core.getWar(i).getDefenderID(0).getCivID(), i, 0, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_EnforcePeace_Wars.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void actionElem(int iID) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall(CFG.core.getCiv(this.civID).getCivName() + ": " + CFG.lang.get("EnforcePeace"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.69803923f, 0.13333334f, 0.13333334f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.69803923f, 0.13333334f, 0.13333334f, 0.375f));
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
                int imgID = Images.diploTruce;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_EnforcePeace_Wars.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
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
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
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

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getElementW() {
        return this.getW();
    }
}

