
package age.of.civilizations2.jakowski.lukasz.Menus.Population;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_2_PopChange;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_DeathsInAllWars
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static long totalDeaths = 0L;

    public Menu_InGame_View_DeathsInAllWars() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W * 3 / 4;
        int tY = 0;
        int playerPos = -1;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        totalDeaths = 0L;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            totalDeaths += CFG.core.getCiv((int)i).civGD.ttWC;
            CFG.core.getCiv((int)i).freeValue = CFG.core.getCiv((int)i).civGD.ttWC;
        }
        menuElements.add(new Button_DiplomacyAction(Images.skull, CFG.lang.get("Total") + ": " + CFG.getNumberWthSpaces("" + totalDeaths), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeathsInAllWars") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + totalDeaths), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.skull, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilizations"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int elemBefore = menuElements.size();
        for (int a = 0; a < GameValues.gvInGame.TOTAL_DEATHS_CIV_VIEW_LIMIT; ++a) {
            boolean metCiv;
            int bestID = 0;
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv((int)bestID).freeValue >= CFG.core.getCiv((int)i).freeValue) continue;
                bestID = i;
            }
            if (CFG.core.getCiv((int)bestID).freeValue == 0L) break;
            boolean bl = metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(bestID);
            if (bestID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                playerPos = a + 1;
            }
            menuElements.add(new ButtonN_Pop_2_PopChange(new Color((float)CFG.core.getCiv(bestID).getR() / 255.0f, (float)CFG.core.getCiv(bestID).getG() / 255.0f, (float)CFG.core.getCiv(bestID).getB() / 255.0f, 1.0f), a + 1 + ". " + (metCiv ? CFG.core.getCiv(bestID).getCivName() : CFG.lang.get("Undiscovered")), metCiv ? bestID : -1, "" + CFG.getPrecision2(Math.min(100.0f, (float)CFG.core.getCiv((int)bestID).civGD.ttWC / (float)totalDeaths * 100.0f), 100) + "%", "" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(bestID).countPop()), Images.pop, CFG.COLOR_POPULATION, 0, tY, tempW, CFG.core.getCiv((int)bestID).civGD.ttWC, true, Images.skull){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = CFG.core.getHover_PopulationOfCiv(this.iCivID);
                }

                @Override
                public void actionElem(int iID) {
                    if (this.iCivID > 0) {
                        int provinceID = CFG.map.getMpC().getCapital_OrMetProvinceCivID(this.iCivID);
                        CFG.core.setActiveProvID(provinceID);
                    }
                }

                @Override
                public void actionElemPPM() {
                    if (this.iCivID > 0) {
                        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(a % 2);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            CFG.core.getCiv((int)bestID).freeValue = 0L;
        }
        if (elemBefore == menuElements.size()) {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("DeathsInAllWars") + (playerPos > 0 ? " #" + playerPos : ""), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_DeathsInAllWars.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.37254903f, 0.039215688f, 0.039215688f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.37254903f, 0.039215688f, 0.039215688f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_DeathsInAllWars.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_DeathsInAllWars.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_DeathsInAllWars.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_DeathsInAllWars.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_DeathsInAllWars.this.getPosX() + Menu_InGame_View_DeathsInAllWars.this.getWidthM() - Menu_InGame_View_DeathsInAllWars.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_DeathsInAllWars.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.skull).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_DeathsInAllWars.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.skull).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.09803922f, 0.05882353f, 0.37254903f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() + CFG.PADD, this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }
}

