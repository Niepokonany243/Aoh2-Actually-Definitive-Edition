
package age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_F
extends Menu {
    public static boolean CLICKED = false;
    public static int MAX_Y = 0;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_F() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        int extraW = CFG.BUTTON_W * 3 / 4;
        if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            tempW += extraW;
        }
        menuElements.add(new TextBuildTitle("Age of History 2: Definitive Edition", -1, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Text_Desc2_Special("Made with Love by the Lukasz Jakowski.", CFG.PADD, tY += CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("One man army, one dream, Age of History games since 2013.", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new TextBuildTitle("Age of History Games", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Text_Desc2_Special("Age of Civilizations 2014", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("Age of History II 2018", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("Age of History 3 2024", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("Age of History 2: Definitive Edition 2026", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("Thanks for playing!", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://www.youtube.com/watch?v=rU0WHjHCYLQ";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        this.initMenu(new TitleM_TextSmall("Age of History Fans", CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_F.this.getPosX() + iTranslateX, Menu_InGame_View_F.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_F.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.007843138f, 0.5176471f, 0.011764706f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.007843138f, 0.5176471f, 0.011764706f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_F.this.getPosX() + iTranslateX, Menu_InGame_View_F.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_F.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_F.this.getPosX() + iTranslateX, Menu_InGame_View_F.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_F.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_F.this.getPosX() + iTranslateX, Menu_InGame_View_F.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_F.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_F.this.getPosX() + iTranslateX, Menu_InGame_View_F.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_F.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_F.this.getPosX() + Menu_InGame_View_F.this.getWidthM() - Menu_InGame_View_F.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_F.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_F.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.iconTrue).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_F.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.iconTrue).getHeight() / 2);
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
        boolean bl = CLICKED = !CLICKED;
        if (CLICKED && MAX_Y == 0) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (MAX_Y >= CFG.core.getProv(i).getMaY6()) continue;
                MAX_Y = CFG.core.getProv(i).getMaY6();
            }
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

