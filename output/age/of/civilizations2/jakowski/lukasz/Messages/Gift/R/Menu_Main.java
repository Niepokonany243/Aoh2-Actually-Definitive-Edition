/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Messages.Gift.R;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LRMain_DC;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_SK;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

public class Menu_Main
extends Menu {
    public int iTitleOffset = 0;
    public long lTime = 0L;
    public int ANIMATION_TIME = 1250;
    public static float ICONS_ALPHA_PC = 0.15f;
    public static float ICONS_ALPHA = 0.1f;
    public static final float LOGO_APLHA_DEFAULT = 0.95f;
    public static SparksAnimation sparksAnimation = new SparksAnimation();
    public static boolean RATE_THE_GAME = false;
    public static int GLGO = 0;
    public static boolean SPECIAL_1 = false;
    public static boolean SPECIAL_2 = false;
    public List<FSF> sF = new ArrayList<FSF>();

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
        int gM = Images.gameLogo;
        int tempH = CFG.GAMEHEIGHT / 2 - (CFG.BUTTON_H * 6 + CFG.PADD * 7) / 2 + (CFG.BUTTON_H + CFG.PADD * 2) / 2;
        int buttonX = Menu_Main.getMenuPosX_Default();
        int buttonW = Menu_Main.getMenuWidth_Default();
        int nMN = IMGManager.getIMG(gM).getHeight() + IMGManager.getIMG(gM).getWidth();
        menuElements.add(new Button_Classic_LR_Main_Games(null, -1, buttonX, tempH, buttonW, CFG.BUTTON_H, true){

            @Override
            public void actionElemPPM() {
                Menu_MM.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eMM);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H + CFG.PADD, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 2 + CFG.PADD * 2, buttonW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 3 + CFG.PADD * 3, buttonW, CFG.BUTTON_H, true){});
        menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 4 + CFG.PADD * 4, buttonW, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.setDialogType(DialogType.START_TUTORIAL);
            }
        });
        if (nMN == 306 || nMN == 278 || nMN == 550) {
            menuElements.add(new Button_Classic_LR_Main(null, -1, buttonX, tempH + CFG.BUTTON_H * 5 + CFG.PADD * 5, buttonW, CFG.BUTTON_H, true));
        } else {
            menuElements.add(new Button_Classic_LRMain_DC("Age of History 2: Definitive Edition", null, -1, buttonX, tempH + CFG.BUTTON_H * 5 + CFG.PADD * 5, buttonW, CFG.BUTTON_H, true));
        }
        menuElements.add(new Text("", -1, Menu_Main.getMenuPosX_Default() + Menu_Main.getMenuWidth_Default() / 2 - (IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4) / 2, ((MenuElemUI)menuElements.get(0)).getPosY() - CFG.PADD - IMGManager.getIMG(Images.mainMenuEdge).getHeight() - CFG.BUTTON_H, IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4, CFG.BUTTON_H){

            @Override
            public int getPosXE() {
                return Menu_Main.getMenuPosX_Default() + Menu_Main.getMenuWidth_Default() / 2 - (IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4) / 2;
            }

            @Override
            public int getWidthE() {
                return IMGManager.getIMG(Images.gameLogo).getWidth() + CFG.PADD * 4;
            }

            @Override
            public void actionElemPPM() {
                if (++GLGO > 3) {
                    GLGO = 0;
                }
                Menu_Main.this.lTime = System.currentTimeMillis();
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
                if (GLGO > 2) {
                    if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                        float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                        if (t > 1.0f) {
                            t = 1.0f;
                        }
                        if (t < 0.0f) {
                            t = 0.0f;
                        }
                        t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                        float extraH = (float)IMGManager.getIMG(Images.gameLogoC).getHeight() * 0.425f;
                        float offsetY = extraH - extraH * t;
                        float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(Images.gameLogoC).getWidth() / 2.0f + (float)iTranslateX;
                        float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(Images.gameLogoC).getHeight() / 2.0f - offsetY + (float)iTranslateY;
                        IMGManager.getIMG(Images.gameLogoC).draw(oSB, (int)drawX, (int)drawY);
                    } else {
                        IMGManager.getIMG(Images.gameLogoC).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.gameLogoC).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gameLogoC).getHeight() / 2 + iTranslateY);
                    }
                } else if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.gameLogo).getHeight() * 0.425f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(Images.gameLogo).getWidth() / 2.0f + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(Images.gameLogo).getHeight() / 2.0f - offsetY + (float)iTranslateY;
                    IMGManager.getIMG(Images.gameLogo).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(Images.gameLogo).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.gameLogo).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gameLogo).getHeight() / 2 + iTranslateY);
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
                if (GLGO > 2) {
                    nData.add(new ME_Hover_2Type_Text_Big("Age of Civilizations 2: Definitive Edition", CFG.COLOR_HOVER_TITLE));
                } else {
                    nData.add(new ME_Hover_2Type_Text_Big("Age of History 2: Definitive Edition", CFG.COLOR_HOVER_TITLE));
                }
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
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                int imgID = Images.logo_steam;
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(imgID).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(imgID).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(imgID).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(imgID).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(imgID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(imgID).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://store.steampowered.com/app/3381680/Age_of_History_II_Definitive_Edition/", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }
        });
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(Images.logo_android).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(Images.logo_android).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(Images.logo_android).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(Images.logo_android).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.logo_android).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.logo_android).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://play.google.com/store/apps/details?id=age.of.history2.definitive.lukasz.jakowski", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }
        });
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                int imgID = Images.logo_app;
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(imgID).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(imgID).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(imgID).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(imgID).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(imgID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(imgID).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://apps.apple.com/us/app/age-of-history-2-definitive/id6759263202", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H * 4, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                int imgID = Images.logo_fb;
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(imgID).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(imgID).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(imgID).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(imgID).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(imgID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(imgID).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://facebook.com/AgeofCivilizationsJakowski/", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }
        });
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H * 5, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                int imgID = Images.logo_twit;
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(imgID).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(imgID).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(imgID).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(imgID).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(imgID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(imgID).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://twitter.com/jakowskidev", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }
        });
        menuElements.add(new Button_Classic(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.GAMEHEIGHT - CFG.BUTTON_H * 6, CFG.BUTTON_H, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ICONS_ALPHA));
                int imgID = Images.logo_yt;
                if (Menu_Main.this.lTime + (long)Menu_Main.this.ANIMATION_TIME > System.currentTimeMillis()) {
                    float t = (float)(System.currentTimeMillis() - Menu_Main.this.lTime) / (float)Menu_Main.this.ANIMATION_TIME;
                    if (t > 1.0f) {
                        t = 1.0f;
                    }
                    if (t < 0.0f) {
                        t = 0.0f;
                    }
                    t = 1.0f - (float)Math.pow(1.0f - t, 6.0);
                    float extraH = (float)IMGManager.getIMG(Images.logo_steam).getWidth() * 0.5f;
                    float offsetY = extraH - extraH * t;
                    float drawX = (float)this.getPosXE() + (float)this.getWidthE() / 2.0f - (float)IMGManager.getIMG(imgID).getWidth() / 2.0f + offsetY + (float)iTranslateX;
                    float drawY = (float)this.getPosY() + (float)this.getHeightE() / 2.0f - (float)IMGManager.getIMG(imgID).getHeight() / 2.0f + (float)iTranslateY;
                    IMGManager.getIMG(imgID).draw(oSB, (int)drawX, (int)drawY);
                } else {
                    IMGManager.getIMG(imgID).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(imgID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(imgID).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("https://www.YouTube.com/user/jakowskiuki", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_SK.goBack = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSK);
                CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                }
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
        this.iTitleOffset = CFG.XXXHDPI ? 7 : (CFG.XXHDPI ? 7 : (CFG.XHDPI ? 7 : 7));
        if (CFG.getIsDesktop()) {
            try {
                LocalDate today = LocalDate.now();
                MonthDay todayMD = MonthDay.from(today);
                MonthDay targetMD = MonthDay.of(4, 1);
                MonthDay targetMD2 = MonthDay.of(12, 25);
                if (todayMD.equals(targetMD)) {
                    if (!SPECIAL_2) {
                        SPECIAL_1 = true;
                        SPECIAL_2 = true;
                    } else {
                        SPECIAL_1 = false;
                        this.sF.clear();
                    }
                    CFG.toastM.addM("April Fools!", CFG.COLOR_HOVER_TITLE);
                } else if (todayMD.equals(targetMD2)) {
                    if (!SPECIAL_2) {
                        SPECIAL_1 = true;
                        SPECIAL_2 = true;
                    } else {
                        SPECIAL_1 = false;
                        this.sF.clear();
                    }
                    CFG.toastM.addM("Happy Holidays!", CFG.COLOR_HOVER_TITLE);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public final void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Games"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Editor"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Settings"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Tutorial"));
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
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
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
        if (SPECIAL_1) {
            if (CFG.oR.nextInt(1000) < 347) {
                this.cSF();
            }
            if (!this.sF.isEmpty()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
                for (int i = this.sF.size() - 1; i >= 0; --i) {
                    if (this.sF.get((int)i).iH > 0) {
                        this.sF.get(i).update(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                        CFG.core.getCiv(this.sF.get((int)i).c).getFlagC().draw(oSB, iTranslateX + this.sF.get((int)i).x, iTranslateY + this.sF.get((int)i).y, this.sF.get((int)i).iW, this.sF.get((int)i).iH);
                        if (this.sF.get((int)i).iH > 1) continue;
                        this.sF.remove(i);
                        continue;
                    }
                    this.sF.remove(i);
                }
            }
        }
    }

    public void cSF() {
        this.sF.add(new FSF(CFG.oR.nextInt(CFG.GAMEWIDTH - 44), 0, 44, 27));
    }

    @Override
    public final void actionEL(int iID) {
        SPECIAL_1 = false;
        switch (iID) {
            case 0: {
                CFG.menus.setMenuIDWithoutAnim(View.eGAMES);
                CFG.menus.setOrderOfMenu_Games();
                break;
            }
            case 1: {
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR);
                break;
            }
            case 3: {
                CFG.goToMenu2 = View.eMAINMENU;
                CFG.menus.setMenuID(View.eSETTINGS);
                break;
            }
            case 4: {
                this.getMenuElem(iID).actionElem(iID);
                return;
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
            case 5: {
                CFG.setDialogType(DialogType.EXIT_GAME);
                return;
            }
            case 7: {
                CFG.GO_TO_LINK = "https://store.steampowered.com/app/3381680/Age_of_History_II_Definitive_Edition/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 8: {
                CFG.GO_TO_LINK = "https://play.google.com/store/apps/details?id=age.of.history2.definitive.lukasz.jakowski";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 9: {
                CFG.GO_TO_LINK = "https://apps.apple.com/us/app/age-of-history-2-definitive/id6759263202";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 10: {
                CFG.GO_TO_LINK = "https://www.facebook.com/AgeofCivilizationsJakowski/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 11: {
                CFG.GO_TO_LINK = "https://twitter.com/jakowskidev";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 12: {
                CFG.GO_TO_LINK = "https://www.youtube.com/user/jakowskiuki";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
            case 13: {
                CFG.GO_TO_LINK = "https://store.steampowered.com/app/2772750/Age_of_History_3/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
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

    public void menuAction2() {
    }

    public class FSF {
        int x;
        int y;
        int iW;
        int iH;
        int c = 0;

        public FSF(int x, int y, int iW, int iH) {
            this.x = x;
            this.y = y;
            float s = 0.65f + (float)CFG.oR.nextInt(700) / 1000.0f;
            this.iW = (int)((float)iW * s);
            this.iH = (int)((float)iH * s);
            this.c = CFG.oR.nextInt(CFG.core.getCivsSize());
        }

        public void update(int boxWidth, int boxHeight) {
            this.y += 2;
            this.x += CFG.oR.nextBoolean() ? 1 : -1;
            if (this.x < 0) {
                this.x = 0;
            }
            if (this.x + this.iW > boxWidth) {
                this.x = boxWidth - this.iW;
            }
            if (this.y + this.iH >= CFG.GAMEHEIGHT) {
                if (this.iH > 0) {
                    this.iH -= 2;
                }
                if (this.iW < 80) {
                    ++this.iW;
                }
            }
        }
    }
}

