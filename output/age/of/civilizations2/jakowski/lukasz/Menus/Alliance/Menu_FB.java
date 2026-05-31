/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Alliance;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main_Games;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_FB
extends Menu {
    public static List<FBData> fbData = new ArrayList<FBData>();
    public static long startTime;
    public static long lastSpawnTime;
    public static int duration;
    public static int score;
    public static boolean gameOver;
    public String[] fakeTexts = new String[]{"Feature", "Not a bug", "As intended", "Trust me"};
    public String[] bugTexts = new String[]{"Bug", "Error", "Crash", "Null", "Leak", "Glitch", "Broken", "Fail", "Missing", "Pls fix", "Invalid", "Bruh", "Freeze", "Desync", "Lag", "Fault", "Issue", "Oops", "Fix me"};
    public static int snakeW;
    public static int snakeH;
    public static View goBack;

    public Menu_FB() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Main_Games(CFG.lang.get("StartGame"), -1, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                fbData.clear();
                Menu_FB.this.startGame();
                CFG.menus.rebuildFB();
            }

            @Override
            public Color getColorE(boolean isActive) {
                if (gameOver) {
                    return CFG.COLOR_HOVER_TITLE;
                }
                return super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(CFG.lang.get("Back"), -1, CFG.GAMEWIDTH / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuIDWithoutAnim(goBack);
                fbData.clear();
            }
        });
        for (int i = 0; i < fbData.size(); ++i) {
            if (Menu_FB.fbData.get((int)i).isFeature) {
                menuElements.add(new Button_InGameBox(Menu_FB.fbData.get((int)i).text, -1, Menu_FB.fbData.get((int)i).posX, Menu_FB.fbData.get((int)i).posY, Menu_FB.fbData.get((int)i).width, Menu_FB.fbData.get((int)i).height, true){
                    int id;

                    @Override
                    public void actionElem(int iID) {
                        if (gameOver) {
                            CFG.toastM.addM("No more time. You fixed " + score + " bugs.", score > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
                        } else {
                            CFG.toastM.addM("Feature: " + this.getTextE() + " -2", CFG.COLOR_NEGATIVE_2);
                            fbData.remove(this.id);
                            score -= 2;
                            Menu_FB.this.spawnNew();
                            CFG.menus.rebuildFB();
                        }
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        if (gameOver) {
                            return CFG.COLOR_NEUTRAL;
                        }
                        return CFG.COLOR_POSITIVE;
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.id = nCurrent;
                        super.setCurr(nCurrent);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
                continue;
            }
            menuElements.add(new Button_InGameBox(Menu_FB.fbData.get((int)i).text, -1, Menu_FB.fbData.get((int)i).posX, Menu_FB.fbData.get((int)i).posY, Menu_FB.fbData.get((int)i).width, Menu_FB.fbData.get((int)i).height, true){
                int id;

                @Override
                public void actionElem(int iID) {
                    if (gameOver) {
                        CFG.toastM.addM("No more time. You fixed " + score + " bugs.", score > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
                    } else {
                        CFG.toastM.addM("Fixed: " + this.getTextE() + " +1", CFG.COLOR_POSITIVE);
                        fbData.remove(this.id);
                        ++score;
                        Menu_FB.this.spawnNew();
                        CFG.menus.rebuildFB();
                    }
                }

                @Override
                public void setIsHovered(boolean isHovered) {
                    if (!gameOver && CFG.oR.nextInt(1000) < 124) {
                        Menu_FB.fbData.get((int)this.id).posX = CFG.oR.nextInt(CFG.GAMEWIDTH - CFG.BUTTON_W);
                        Menu_FB.fbData.get((int)this.id).posY = CFG.oR.nextInt(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.BUTTON_H);
                        Menu_FB.fbData.get((int)this.id).width = CFG.BUTTON_W / 2 + CFG.oR.nextInt(CFG.BUTTON_W / 2);
                        Menu_FB.fbData.get((int)this.id).height = CFG.BUTTON_H / 2 + CFG.oR.nextInt(CFG.BUTTON_H) / 2;
                        CFG.menus.rebuildFB();
                        CFG.toastM.addM("Bugs run away!", CFG.COLOR_HOVER_TITLE);
                    }
                    super.setIsHovered(isHovered);
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (gameOver) {
                        return CFG.COLOR_NEUTRAL;
                    }
                    return CFG.COLOR_NEGATIVE_2;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                    super.setCurr(nCurrent);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    public void spawnNew() {
        boolean feature = CFG.oR.nextInt(1000) < 54;
        FBData data = new FBData(feature ? this.fakeTexts[CFG.oR.nextInt(this.fakeTexts.length)] : this.bugTexts[CFG.oR.nextInt(this.bugTexts.length)], CFG.oR.nextInt(CFG.GAMEWIDTH - CFG.BUTTON_W), CFG.oR.nextInt(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.BUTTON_H), CFG.BUTTON_W / 2 + CFG.oR.nextInt(CFG.BUTTON_W / 2), CFG.BUTTON_H / 2 + CFG.oR.nextInt(CFG.BUTTON_H) / 2, feature);
        fbData.add(data);
        if (feature) {
            this.spawnNew();
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int i;
        if (!gameOver) {
            float progress = 1.0f - (float)(System.currentTimeMillis() - startTime) / (float)duration;
            progress = Math.max(0.0f, Math.min(1.0f, progress));
            this.drawTime(oSB, CFG.GAMEWIDTH / 10, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD - CFG.BUTTON_H / 4, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 10 * 2, CFG.BUTTON_H / 4, progress);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.085f));
        IMGManager.getIMG(Images.pix255).draw(oSB, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        IMGManager.getIMG(Images.gradientVertical).draw(oSB, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.025f));
        for (i = 0; i < 500; ++i) {
            IMGManager.getIMG(Images.line32Vertical).draw2(oSB, i * snakeW, 0, 1, CFG.GAMEHEIGHT);
            if (i * snakeW > CFG.GAMEWIDTH) break;
        }
        for (i = 0; i < 500; ++i) {
            IMGManager.getIMG(Images.line32).draw2(oSB, 0, i * snakeH, CFG.GAMEWIDTH, 1);
            if (i * snakeH > CFG.GAMEHEIGHT) break;
        }
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, "Age of History 2: Definitive Edition", CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.BUTTON_H, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, 0.5f));
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
        IMGManager.getIMG(Images.gameLogo).draw(oSB, CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth(), CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H - IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
        float timeLeft = Math.max(0.0f, (float)((long)duration - (System.currentTimeMillis() - startTime)) / 1000.0f);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Fix the Bugs! Time: " + String.format("%.1f", Float.valueOf(timeLeft)), CFG.PADD * 2, CFG.PADD * 2, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Fixed bugs: " + score, CFG.PADD * 2, CFG.PADD * 2 + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT), CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Score: " + score, CFG.PADD * 2, CFG.PADD * 2 + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2, CFG.COLOR_NEUTRAL);
        if (gameOver) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - startTime > (long)duration) {
            gameOver = true;
            CFG.toastM.addM("No more time. You fixed " + score + " bugs.", score > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
            return;
        }
        if (now - lastSpawnTime > 400L) {
            this.spawnNew();
            lastSpawnTime = now;
            CFG.menus.rebuildFB();
        }
        if (fbData.size() > 250) {
            fbData.remove(0);
            CFG.menus.rebuildFB();
        }
    }

    public void drawTime(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float nProgress) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX, nPosY - CFG.PADD, nWidth, CFG.PADD);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX, nPosY + nHeight, nWidth, CFG.PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(oSB, Images.statsRectBG, nPosX, nPosY, nWidth, nHeight, 1.0f);
        oSB.setColor(new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.35f));
        Renderer.drawBox2(oSB, Images.statsRectBG, nPosX + 3, nPosY + 3, (int)((float)(nWidth - 6) * nProgress), nHeight - 6, 1.0f);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, nPosX + 1, nPosY + 1, nWidth - 2, nHeight - 2, 1.0f);
    }

    public void startGame() {
        fbData.clear();
        score = 0;
        gameOver = false;
        lastSpawnTime = startTime = System.currentTimeMillis();
        this.spawnNew();
        this.spawnNew();
        this.spawnNew();
        this.spawnNew();
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void endClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(goBack);
        CFG.menus.setBackAnimation(true);
    }

    static {
        duration = 15000;
        score = 0;
        gameOver = true;
        snakeW = 68;
        snakeH = 44;
        goBack = View.eMAINMENU;
    }

    public class FBData {
        public String text;
        public int posX;
        public int posY;
        public int width;
        public int height;
        public boolean isFeature;

        public FBData(String text, int posX, int posY, int width, int height, boolean isFeature) {
            this.text = text;
            this.posX = posX;
            this.posY = posY;
            this.width = width;
            this.height = height;
            this.isFeature = isFeature;
        }
    }
}

