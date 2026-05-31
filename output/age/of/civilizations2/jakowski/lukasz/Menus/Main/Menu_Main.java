/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Main;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main_Games;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_Main
extends Menu {
    public int iTitleOffset = 0;
    public long lTime = 0L;
    public int ANIMATION_TIME = 425;
    public static SparksAnimation sparksAnimation = new SparksAnimation();
    public static boolean RATE_THE_GAME = false;

    public static final int getMenuPosX_Default() {
        return CFG.GAMEWIDTH - Menu_Main.getMenuWidth_Default() - CFG.BUTTON_W * 2;
    }

    public static final int getMenuWidth_Default() {
        if (CFG.isAndroid() && !CFG.LANDSCAPE) {
            return CFG.CIV_INFO_MENU_WIDTH;
        }
        return CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH / 2;
    }

    public Menu_Main() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonW = Menu_Main.getMenuWidth_Default();
        int buttonX = CFG.settingsGD.BETTER_UI ? (CFG.GAMEWIDTH / 2 - buttonW / 2) : Menu_Main.getMenuPosX_Default();
        int tempH = CFG.GAMEHEIGHT / 2 - (CFG.BUTTON_H * 6 + CFG.PADD * 7) / 2 + (CFG.BUTTON_H + CFG.PADD * 2) / 2;

        menuElements.add(new Button_Classic_LR_Main_Games(null, -1, buttonX, tempH, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H + CFG.PADD, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 2 + CFG.PADD * 2, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 3 + CFG.PADD * 3, buttonW, CFG.BUTTON_H, true){});
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 4 + CFG.PADD * 4, buttonW, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("JoinDiscord"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                int sS = CFG.BUTTON_H / 4;
                int sX = this.getPosXE() + CFG.PADD / 2 + iTranslateX;
                int sY = this.getPosY() + iTranslateY;
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                CFG.fontMain.get(0).draw(oSB, "*", sX, sY + sS);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 5 + CFG.PADD * 5, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Text("", -1, buttonX + buttonW / 2 - (IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4) / 2, ((MenuElemUI)menuElements.get(0)).getPosY() - CFG.PADD - (CFG.settingsGD.BETTER_UI ? (CFG.BUTTON_H * 2) : (IMGManager.getIMG(Images.mainMenuEdge).getHeight() + CFG.BUTTON_H)), IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4, CFG.BUTTON_H){

            @Override
            public int getPosXE() {
                return (CFG.settingsGD.BETTER_UI ? (CFG.GAMEWIDTH / 2 - this.getWidthE() / 2) : (Menu_Main.getMenuPosX_Default() + Menu_Main.getMenuWidth_Default() / 2 - this.getWidthE() / 2));
            }

            @Override
            public int getWidthE() {
                return IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (CFG.settingsGD.BETTER_UI) {
                    float pulse = (float)(Math.sin(System.currentTimeMillis() / 500.0) * 0.1 + 0.9);
                    if (isActive) {
                        oSB.setColor(new Color(0.0f, 1.0f, 1.0f, 0.85f));
                    } else if (this.getIsHovered()) {
                        oSB.setColor(new Color(0.2f, 1.0f, 1.0f, 1.0f));
                    } else {
                        oSB.setColor(new Color(0.0f, 0.8f, 1.0f, pulse));
                    }
                    IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * pulse) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)(IMGManager.getIMG(Images.gameLogo).getHeight() * pulse) / 2 + iTranslateY, (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * pulse), (int)(IMGManager.getIMG(Images.gameLogo).getHeight() * pulse));
                } else {
                    if (isActive) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                    } else if (this.getIsHovered()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                    } else {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.95f));
                    }
                    IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.gameLogo).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gameLogo).getHeight() / 2 + iTranslateY);
                }
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
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getLukaszJakowski(), Colors.HOVER_GOLD));
                nData.add(new ME_Hover_2Type_Image_Big(Images.key, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big("One Man Army!", Colors.HOVER_LEFT));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big("Age of History 2: Definitive Edition", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        int tRebuildPosY = 0;
        for (i = 0; i < menuElements.size(); ++i) {
            if (tRebuildPosY <= ((MenuElemUI)menuElements.get(i)).getPosY()) continue;
            tRebuildPosY = ((MenuElemUI)menuElements.get(i)).getPosY();
        }
        if (tRebuildPosY < 0) {
            for (i = 0; i < menuElements.size(); ++i) {
                ((MenuElemUI)menuElements.get(i)).setPosY(((MenuElemUI)menuElements.get(i)).getPosY() - tRebuildPosY + CFG.PADD * 4);
            }
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
        this.iTitleOffset = CFG.XXXHDPI ? 7 : (CFG.XXHDPI ? 7 : (CFG.XHDPI ? 7 : 7));
    }

    @Override
    public final void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Games"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Editor"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Settings"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Community"));
        this.getMenuElem(2).setTextE(CFG.lang.get("MapType") + ": " + CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()));
        this.getMenuElem(5).setTextE(CFG.lang.get("ExitGame"));
        CFG.sTOTAL = CFG.lang.get("Total");
        CFG.sTOTAL_WORLDS_POPULATION = CFG.lang.get("WorldsPopulation");
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.sLoading);
        CFG.iLoadingWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), CFG.gLG());
        CFG.iJGW = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "presents");
        CFG.iJGPW = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "Age of History 2: Definitive Edition");
        CFG.iAgeOfCivilizationsWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(6).setTextE("Age of History 2: Definitive Edition");
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)this.ANIMATION_TIME > System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY, this.getWidthM(), -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / (float)this.ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            CFG.setRenderO(true);
        } else {
            super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawAdvancedBackground(oSB, iTranslateX, iTranslateY, true);

            this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            // Draw menu area background and full frame border
            Core.drawMenuBG(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, iTranslateY, this.getMenuElem(0).getWidthE(), CFG.GAMEHEIGHT);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.drawVersionLB(oSB, iTranslateX);
            oSB.setColor(Color.WHITE);
            return;
        }
        try {
            if (Menu_InitGame.animatedSize > 0) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.animated.get(Menu_InitGame.animatedID).draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.animatedWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.animatedHeight) / 2, Menu_InitGame.animatedWidth, Menu_InitGame.animatedHeight);
                oSB.setColor(Color.WHITE);
                if (Menu_InitGame.animatedTime + Menu_InitGame.animatedFrame < CFG.currentTimeMillis) {
                    Menu_InitGame.animatedTime = CFG.currentTimeMillis;
                    if (++Menu_InitGame.animatedID >= Menu_InitGame.animatedSize) {
                        Menu_InitGame.animatedID = 0;
                    }
                }
            } else if (Menu_InitGame.background != null) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.background.draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.backgroundWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.backgroundHeight) / 2, Menu_InitGame.backgroundWidth, Menu_InitGame.backgroundHeight);
                oSB.setColor(Color.WHITE);
                if (CFG.currentTimeMillis > Menu_InitGame.bgTIME_CHANGE + (long)GameValues.gvUpdate.MAIN_MENU_BG_CHANGE_BG_EVERY_X_MS) {
                    Menu_InitGame.bgTIME_CHANGE = CFG.currentTimeMillis;
                    Core.addSimpleTask(new Core.SimpleTask("loadBackground"){

                        @Override
                        public void update() {
                            Menu_InitGame.loadBackground();
                            Menu_InitGame.bgTIME = System.currentTimeMillis();
                            Menu_InitGame.bgTIME_CHANGE = System.currentTimeMillis();
                            Menu_InitGame.bgAlpha = 0.0f;
                        }
                    });
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.1f));
        IMGManager.getIMG(Images.patternReversed).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.patternReversed).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT, 0.0f, 0);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(SparksAnimation.sparksColors);
        sparksAnimation.draw2(oSB, iTranslateX, CFG.GAMEHEIGHT - Images.sparkHeight + iTranslateY, CFG.GAMEWIDTH, Images.sparkHeight);
        oSB.setColor(Color.WHITE);
        Core.drawMenuBG(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, iTranslateY, this.getMenuElem(0).getWidthE(), CFG.GAMEHEIGHT);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawVersionLB(oSB, iTranslateX);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setMenuID(View.eGAMES);
                CFG.menus.setOrderOfMenu_Games();
                break;
            }
            case 1: {
                SaveGameManager.gameCanBeContinued = false;
                CFG.menus.setMenuID(View.eEDITOR);
                break;
            }
            case 3: {
                CFG.goToMenu2 = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSETTINGS);
                break;
            }
            case 2: {
                CFG.backToMenu = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                break;
            }
            case 6: {
                CFG.menus.setMenuID(View.eABOUT);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
                return;
            }
            case 4: {
                CFG.GO_TO_LINK = "https://discord.gg/MpuFrKAYtK";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Open") + " " + CFG.lang.get("Community") + "?");
                return;
            }
            case 5: {
                CFG.setDialogType(DialogType.EXIT_GAME);
                return;
            }
        }
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            CFG.core.getProv(i).setFromCivID(0);
        }
        CFG.map.getMpC().centerToRandomMapPos();
    }

    @Override
    public final void onBackPressed() {
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }
}
