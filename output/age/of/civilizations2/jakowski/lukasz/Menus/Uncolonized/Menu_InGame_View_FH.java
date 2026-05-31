
package age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized.Menu_InGame_View_F;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_FH
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_FH() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        int extraW = CFG.BUTTON_W * 3 / 4;
        if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            tempW += extraW;
        }
        menuElements.add(new Button_DiplomacyAction(Images.diploRevolution, "Hall of Shame", 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("Hall of Shame", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRevolution, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Text_Desc2_Special("None, cause I love you all.", CFG.PADD, tY += CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("\u2013 Dev, Lukasz Jakowski", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        this.initMenu(new TitleM_TextSmall("Age of History Haters", CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_FH.this.getPosX() + iTranslateX, Menu_InGame_View_FH.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_FH.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.7490196f, 0.18431373f, 0.14117648f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.7490196f, 0.18431373f, 0.14117648f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_FH.this.getPosX() + iTranslateX, Menu_InGame_View_FH.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_FH.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_FH.this.getPosX() + iTranslateX, Menu_InGame_View_FH.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_FH.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_FH.this.getPosX() + iTranslateX, Menu_InGame_View_FH.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_FH.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_FH.this.getPosX() + iTranslateX, Menu_InGame_View_FH.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_FH.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_FH.this.getPosX() + Menu_InGame_View_FH.this.getWidthM() - Menu_InGame_View_FH.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_FH.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_FH.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.diploRevolution).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_FH.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.diploRevolution).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min((tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
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
        boolean bl = Menu_InGame_View_F.CLICKED = !Menu_InGame_View_F.CLICKED;
        if (Menu_InGame_View_F.CLICKED && Menu_InGame_View_F.MAX_Y == 0) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (Menu_InGame_View_F.MAX_Y >= CFG.core.getProv(i).getMaY6()) continue;
                Menu_InGame_View_F.MAX_Y = CFG.core.getProv(i).getMaY6();
            }
        }
        if (iID == 0) {
            CFG.GO_TO_LINK = "https://www.youtube.com/watch?v=irjftuyW_5M";
            CFG.setDialogType(DialogType.GO_TO_LINK);
        } else {
            CFG.GO_TO_LINK = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
            CFG.setDialogType(DialogType.GO_TO_LINK);
        }
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

