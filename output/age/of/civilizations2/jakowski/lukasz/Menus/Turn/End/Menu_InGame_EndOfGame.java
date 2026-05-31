
package age.of.civilizations2.jakowski.lukasz.Menus.Turn.End;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Victory.Menu_Victory;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextTitleStyle;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_EndOfGame
extends Menu {
    public static final int ANIMATION_TIME = 225;
    private long lTime = 0L;
    public static final float SCALE_CHANGE = 0.175f;

    public int getElementWidth() {
        return (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.25f);
    }

    public Menu_InGame_EndOfGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonH = CFG.BUTTON_H * 4 / 5;
        menuElements.add(new TextTitleStyle(null, -1, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2 - CFG.PADD, 0, this.getElementWidth() + CFG.PADD * 2, CFG.BUTTON_H * 3 / 4){

            @Override
            public Color getColor_BG() {
                return Menu_Victory.VICTORIOUS ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2;
            }
        });
        menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 1.0f), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Score") + ": ", "" + (int)Math.ceil(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).buildPlayerScore()), Images.victoryPoints, CFG.COLOR_NEUTRAL, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2, 0, this.getElementWidth()){});
        menuElements.add(new Button_Opt(null, -1, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2 + CFG.PADD, 0, this.getElementWidth() - CFG.PADD * 2, buttonH, true){});
        menuElements.add(new Button_Opt(null, -1, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2 + CFG.PADD, 0, this.getElementWidth() - CFG.PADD * 2, buttonH, true){});
        menuElements.add(new Button_Opt(null, -1, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2 + CFG.PADD, 0, this.getElementWidth() - CFG.PADD * 2, buttonH, true){

            @Override
            public boolean getIsClickable() {
                return !CFG.SPECTATOR_MODE;
            }
        });
        menuElements.add(new Button_Opt(null, -1, CFG.GAMEWIDTH / 2 - this.getElementWidth() / 2 + CFG.PADD, 0, this.getElementWidth() - CFG.PADD * 2, buttonH, true));
        int tempElementHeight = (menuElements.size() + 1) * CFG.PADD + CFG.PADD;
        for (int i = 0; i < menuElements.size(); ++i) {
            tempElementHeight += ((MenuElemUI)menuElements.get(i)).getHeightE();
        }
        int tempY = CFG.PADD;
        ((MenuElemUI)menuElements.get(0)).setPosY(CFG.GAMEHEIGHT * 2 / 5 - tempElementHeight / 2 + tempY);
        tempY += ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD;
        for (int i = 1; i < menuElements.size(); ++i) {
            if (i == 2) {
                tempY += CFG.PADD;
            }
            ((MenuElemUI)menuElements.get(i)).setPosY(CFG.GAMEHEIGHT * 2 / 5 - tempElementHeight / 2 + tempY);
            tempY += ((MenuElemUI)menuElements.get(i)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
        super.setVisibleM(false);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(Menu_Victory.VICTORIOUS ? CFG.lang.get("Victory") : CFG.lang.get("Defeat"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Timeline"));
        this.getMenuElem(3).setTextE(CFG.lang.get("JustOneMoreTurnIPromise"));
        this.getMenuElem(4).setTextE(CFG.lang.get("SpectatorMode"));
        this.getMenuElem(5).setTextE(CFG.lang.get("ExitToMainMenu"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.15f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.patternReversed).getHeight(), this.getWidthM(), this.getHeightM());
        if (this.lTime + 225L >= System.currentTimeMillis()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f * ((float)(System.currentTimeMillis() - this.lTime) / 225.0f)));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
        }
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getElementWidth() / 2, this.getHeightM());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getElementWidth() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getElementWidth() / 2, this.getHeightM(), true, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), this.getElementWidth() / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - this.getElementWidth() / 2 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), this.getElementWidth() / 2, false, true);
        oSB.setColor(Color.WHITE);
        if (this.lTime + 225L >= System.currentTimeMillis()) {
            iTranslateY = iTranslateY - this.getHeightM() * 4 / 5 + (int)((float)(this.getHeightM() * 4 / 5) * ((float)(System.currentTimeMillis() - this.lTime) / 225.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, -IMGManager.getIMG(Images.gameTopEdge).getHeight() + this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() + this.getMenuPosY() + iTranslateY, this.getMenuElem(0).getWidthE() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getMenuElem(this.getMenuElemsSize() - 2).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 2).getHeightE() + CFG.PADD * 2 - (this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE()), false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, -IMGManager.getIMG(Images.gameTopEdge).getHeight() + this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() + this.getMenuPosY() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getMenuElem(this.getMenuElemsSize() - 2).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 2).getHeightE() + CFG.PADD * 2 - (this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE()), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public static final void clickBack() {
        MapScale.SCALE_ANIMATION_TIME = 125;
        CFG.menus.setVisible_InGame_EndOfGame(false);
        CFG.core.checkProvinceActionMenu();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 2: {
                if (Menu_Victory.VICTORIOUS) {
                    CFG.menus.setMenuID(View.eVICTORY);
                } else {
                    CFG.menus.setMenuID(View.eDEFEAT);
                }
                CFG.map.getMpB().updateWorldMap_Shaders();
                break;
            }
            case 3: {
                CFG.setDialogType(DialogType.END_GAME_ONE_MORE_TURN);
                break;
            }
            case 4: {
                CFG.setDialogType(DialogType.END_GAME_SPECTACTOR);
                break;
            }
            case 5: {
                CFG.setDialogType(DialogType.END_GAME_EXIT_MAIN_MENU);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_InGame_EndOfGame.clickBack();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }
}

