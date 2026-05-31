
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Disease;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Diseases;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Diseases
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_Diseases(int init) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Diseases"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_View_Diseases() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        ArrayList<Integer> tempSorted = new ArrayList<Integer>();
        try {
            for (i = 0; i < CFG.plagueManager.plaguesActive.size(); ++i) {
                tempIDs.add(i);
            }
            while (tempIDs.size() > 0) {
                int tBestID = 0;
                for (int i2 = tBestID + 1; i2 < tempIDs.size(); ++i2) {
                    if (CFG.plagueManager.plaguesActive.get((Integer)tempIDs.get(tBestID)).getDeaths() >= CFG.plagueManager.plaguesActive.get((Integer)tempIDs.get(i2)).getDeaths()) continue;
                    tBestID = i2;
                }
                tempSorted.add((Integer)tempIDs.get(tBestID));
                tempIDs.remove(tBestID);
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new ButtonN_Diseases(0, tY, tempW){});
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (tempSorted.size() > 0) {
            for (i = 0; i < tempSorted.size(); ++i) {
                menuElements.add(new ButtonN_Disease((Integer)tempSorted.get(i), CFG.plagueManager.getPlagueColor_InGame((Integer)tempSorted.get(i), 0.275f), CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getPlagueName(), CFG.FOG_OF_WAR < 2 || CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getOutbreakProvinceID() < 0 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getOutbreakProvinceID()) ? CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getOutbreakProvinceID() : -1, CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getDeaths(), CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getNumOfProvinces_Active() + "/" + CFG.plagueManager.plaguesActive.get((Integer)tempSorted.get(i)).getNumOfProvinces_Total(), 0, tY, CFG.CIV_INFO_MENU_WIDTH){

                    @Override
                    public void actionElem(int iID) {
                        CFG.core.setActiveProvID(this.getCurr());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                            CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        }
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Diseases"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Diseases.this.getPosX() + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Diseases.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.627451f, 0.11764706f, 0.09803922f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.627451f, 0.11764706f, 0.09803922f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Diseases.this.getPosX() + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Diseases.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Diseases.this.getPosX() + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Diseases.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Diseases.this.getPosX() + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Diseases.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Diseases.this.getPosX() + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Diseases.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Diseases.this.getPosX() + Menu_InGame_View_Diseases.this.getWidthM() - Menu_InGame_View_Diseases.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Diseases.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Diseases.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
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
    public void actionEL(int nID) {
        this.getMenuElem(nID).actionElem(nID);
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

