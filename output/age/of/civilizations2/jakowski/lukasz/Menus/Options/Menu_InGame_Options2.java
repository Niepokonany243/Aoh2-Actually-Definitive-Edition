
package age.of.civilizations2.jakowski.lukasz.Menus.Options;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main_Games;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_OR;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Options2
extends Menu {
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public static final int ANIMATION_TIME = 225;
    private long lTime = 0L;
    public static final float SCALE_CHANGE = 0.175f;

    public Menu_InGame_Options2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonH = CFG.BUTTON_H;
        int buttonX = Menu_Main.getMenuPosX_Default();
        int buttonW = Menu_Main.getMenuWidth_Default();
        menuElements.add(new Text("", -1, Menu_Main.getMenuPosX_Default() + Menu_Main.getMenuWidth_Default() / 2 - (IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4) / 2, 0, IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4, Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.gameLogo).getHeight() + CFG.PADD * 4)){

            @Override
            public int getPosXE() {
                return Menu_Main.getMenuPosX_Default() + Menu_Main.getMenuWidth_Default() / 2 - (IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4) / 2;
            }

            @Override
            public int getWidthE() {
                return IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                } else if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.95f));
                }
                IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.gameLogo).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gameLogo).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Programmer and Designer"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.gLI(), Colors.HOVER_GOLD));
                nData.add(new ME_Hover_2Type_Image_Big(Images.key, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big("One Man Army!", Colors.HOVER_LEFT));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        int eGS = IMGManager.getIMG(Images.statsBox).getHeight() + IMGManager.getIMG(Images.statsBox).getWidth();
        menuElements.add(new Button_Classic_LR_Main_Games(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("JustOneMoreTurnIPromise"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SaveYourProgress") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SaveGameAsNew") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SaveScenario") + " (Standard).", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SaveScenario") + " (Custom JSON).", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F12", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){});
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true){

            @Override
            public boolean getIsClickable() {
                return !CFG.SPECTATOR_MODE;
            }
        });
        if (eGS == 306 || eGS == 278 || eGS == 550) {
            menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, 0, buttonW, buttonH, true));
        } else {
            menuElements.add(new Button_Classic_OR("Age of History 2: Definitive Edition", null, -1, buttonX, 0, buttonW, buttonH, true));
        }
        int tempElementHeight = 0;
        for (int i = 0; i < menuElements.size(); ++i) {
            tempElementHeight += ((MenuElemUI)menuElements.get(i)).getHeightE() + CFG.PADD;
        }
        int tempY = 0;
        for (int i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosY(CFG.GAMEHEIGHT / 2 - tempElementHeight / 2 + tempY);
            tempY += ((MenuElemUI)menuElements.get(i)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
        super.setVisibleM(false);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("ReturnToGame"));
        this.getMenuElem(2).setTextE(CFG.lang.get("SaveTheGame"));
        this.getMenuElem(3).setTextE(CFG.lang.get("SaveGameAsNew"));
        this.getMenuElem(4).setTextE(CFG.lang.get("SaveScenario") + " (Standard)");
        this.getMenuElem(5).setTextE(CFG.lang.get("SaveScenario") + " (Custom JSON)");
        this.getMenuElem(6).setTextE(CFG.lang.get("Audio"));
        this.getMenuElem(7).setTextE(CFG.lang.get("GameOptions"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Surrender"));
        this.getMenuElem(9).setTextE(CFG.lang.get("ExitToMainMenu"));
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
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.CIV_INFO_MENU_WIDTH / 2, this.getHeightM());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.CIV_INFO_MENU_WIDTH / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.CIV_INFO_MENU_WIDTH / 2, this.getHeightM(), true, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), CFG.CIV_INFO_MENU_WIDTH / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.CIV_INFO_MENU_WIDTH / 2 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), CFG.CIV_INFO_MENU_WIDTH / 2, false, true);
        oSB.setColor(Color.WHITE);
        if (this.lTime + 225L >= System.currentTimeMillis()) {
            iTranslateY = iTranslateY - this.getHeightM() * 4 / 5 + (int)((float)(this.getHeightM() * 4 / 5) * ((float)(System.currentTimeMillis() - this.lTime) / 225.0f));
        }
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(SparksAnimation.sparksColors);
        this.sparksAnimation.draw2(oSB, iTranslateX, CFG.GAMEHEIGHT - Images.sparkHeight + iTranslateY, CFG.GAMEWIDTH, Images.sparkHeight);
        oSB.setColor(Color.WHITE);
        Core.drawMenuBG(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, iTranslateY, this.getMenuElem(1).getWidthE(), CFG.GAMEHEIGHT);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        Renderer.drawText(oSB, CFG.FONT_BOLD, "Age of History 2: Definitive Edition", CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(1.0f, 1.0f, 1.0f, 0.27f));
    }

    public static final void clickBack() {
        MapScale.SCALE_ANIMATION_TIME = 125;
        int tX = Touch.getMousePosX();
        int tY = Touch.getMousePosY();
        Touch.setMousePosXY(CFG.GAMEWIDTH / 2, CFG.GAMEHEIGHT / 2);
        CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
        CFG.menus.setVisible_InGame_Options(false);
        Touch.setMousePosXY(tX, tY);
        CFG.core.checkProvinceActionMenu();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                this.onBackPressed();
                break;
            }
            case 2: {
                CFG.setDialogType(DialogType.SAVE_THE_GAME_OPTIONS);
                break;
            }
            case 3: {
                CFG.setDialogType(DialogType.SAVE_THE_GAME_AS_NEW);
                break;
            }
            case 4: {
                CFG.setDialogType(DialogType.SAVE_GAME_AS_SCENARIO);
                break;
            }
            case 5: {
                CFG.setDialogType(DialogType.SAVE_GAME_AS_SCENARIO_CUSTOM_JSON);
                break;
            }
            case 6: {
                this.onBackPressed();
                CFG.menus.setVisibleInGame_Playlist(!CFG.menus.getVisibleInGame_Playlist());
                break;
            }
            case 7: {
                this.onBackPressed();
                CFG.goToMenu2 = View.eINGAME;
                CFG.menus.setMenuID(View.eSETTINGS);
                break;
            }
            case 8: {
                CFG.setDialogType(DialogType.SURRENDER);
                break;
            }
            case 9: {
                CFG.setDialogType(DialogType.PAUSE_GAME);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_InGame_Options2.clickBack();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }
}

