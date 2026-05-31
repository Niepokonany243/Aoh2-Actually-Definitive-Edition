/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Turn.Start;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.End.Menu_InGame_EndOfGame;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_StartTheGame_Reverse
extends Menu {
    public static boolean END_GAME_MODE = true;
    private String s1;
    private int iWidth1;
    private String s2;
    private int iWidth2;

    public Menu_StartTheGame_Reverse() {
        block13: {
            block12: {
                this.s1 = "";
                this.s2 = "";
                ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
                menuElements.add(new Button_Transparent(1, 1, CFG.GAMEWIDTH - 2, CFG.GAMEHEIGHT - 2, true));
                this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
                try {
                    this.s1 = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName();
                    CFG.glyphLay.setText(CFG.fontMain.get(0), this.s1);
                    this.iWidth1 = (int)CFG.glyphLay.width;
                }
                catch (IndexOutOfBoundsException ex) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(ex);
                    }
                }
                catch (NullPointerException ex) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(ex);
                    }
                }
                catch (IllegalStateException ex) {
                    if (!CFG.LOGs) break block12;
                    CFG.exceptionStack(ex);
                }
            }
            try {
                this.s2 = GameCalendar.getDate_ByTurnID(1) + " - " + GameCalendar.getCurrDate();
                CFG.glyphLay.setText(CFG.fontMain.get(0), this.s2);
                this.iWidth2 = (int)CFG.glyphLay.width;
            }
            catch (IndexOutOfBoundsException ex) {
                if (CFG.LOGs) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (NullPointerException ex) {
                if (CFG.LOGs) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (IllegalStateException ex) {
                if (!CFG.LOGs) break block13;
                CFG.exceptionStack(ex);
            }
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            oSB.setColor(new Color(0.1f, 0.1f, 0.1f, 0.2f - 0.2f * (float)CFG.startTheGameData.getProvincesAlpha()));
            IMGManager.getIMG(Images.pattern).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.pattern).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT, 0.0f, 0);
            float nAlpha = (float)CFG.startTheGameData.getProvincesAlpha() / (float)CFG.settingsGD.PROV_ALPHA;
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, nAlpha * 0.4f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
            IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, nAlpha * 0.65f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, nAlpha * CFG.COLOR_GRADIENT_DARK_BLUE.a));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.BUTTON_H - 3 + iTranslateY, this.getWidthM() - CFG.PADD * 4, 1);
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, nAlpha * CFG.COLOR_FLAG_FRAME.a));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.BUTTON_H - 2 + iTranslateY, this.getWidthM() - CFG.PADD * 4, 1);
            oSB.setColor(Color.WHITE);
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha * 0.35f));
            IMGManager.getIMG(Images.gameLogo).draw2O(oSB, CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gameLogo).getHeight() * 2 - CFG.PADD, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha * 1.0f));
            IMGManager.getIMG(Images.gameLogo).draw2O(oSB, CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gameLogo).getHeight() * 2 - CFG.PADD, (int)((float)(IMGManager.getIMG(Images.gameLogo).getWidth() * CFG.startTheGameData.getProvincesAlpha()) / 100.0f), IMGManager.getIMG(Images.gameLogo).getHeight());
            CFG.drawTextDefault(oSB, this.s1, CFG.GAMEWIDTH / 2 - this.iWidth1 / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + iTranslateY, new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, nAlpha * CFG.COLOR_TEXT_NUM_OF_PROVINCES.a));
            CFG.fontMain.get(0).getData().setScale(0.8f);
            CFG.drawTextDefault(oSB, this.s2, CFG.GAMEWIDTH / 2 - (int)((float)this.iWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.b, nAlpha * CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.a));
            CFG.fontMain.get(0).getData().setScale(1.0f);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            if (CFG.startTheGameData.getIsDone()) {
                this.onBackPressed();
            }
        }
        catch (NullPointerException ex) {
            this.onBackPressed();
        }
        catch (IndexOutOfBoundsException ex) {
            this.onBackPressed();
        }
        oSB.setColor(Color.WHITE);
        CFG.setRenderO(true);
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.startTheGameData.getIsDone()) {
            this.onBackPressed();
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_StartTheGame_Reverse.done();
    }

    public static final void done() {
        if (END_GAME_MODE) {
            CFG.menus.setMenuID(View.eGAMES);
            CFG.map.getMpB().updateWorldMap_Shaders();
            CFG.mapModesManager.disableAllViews();
            CFG.tutorialManager.updateDrawTutorial(false);
            SaveGameManager.gameCanBeContinued = false;
            CFG.PLAYER_TURN_ID = 0;
            CFG.FOG_OF_WAR = 2;
            RenderProvince.updateDrawProvinces();
            CFG.core.loadScenario(false);
            CFG.core.initPlayers();
        } else {
            try {
                if (!CFG.SPECTATOR_MODE) {
                    int i;
                    int tNumOfPlayersInGame = 0;
                    for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0 || i == CFG.PLAYER_TURN_ID) continue;
                        ++tNumOfPlayersInGame;
                    }
                    if (tNumOfPlayersInGame == 0) {
                        CFG.menus.setMenuID(View.eINGAME);
                        CFG.gameAction.hideExtraViews();
                        CFG.mapModesManager.disableAllViews();
                        CFG.gameNewGame.newGame_InitPlayers_SpectatorMode();
                        CFG.SPECTATOR_MODE = true;
                        CFG.PLAYER_TURN_ID = 0;
                        Render.updateDrawCivRegionNames_FogOfWar();
                        Render.updateDrawMoveUnits();
                        CFG.core.updateDrawMoveUnitsArmy();
                        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                            CFG.core.getProv(i).updateProvinceBorder();
                            CFG.core.getProv(i).updateDrawArmyInProv();
                        }
                        CFG.map.getMpB().disposeMinimapOfCivilizations();
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
            }
            catch (IndexOutOfBoundsException ex) {
                CFG.exceptionStack(ex);
            }
            catch (NullPointerException ex) {
                CFG.exceptionStack(ex);
            }
            Menu_InGame_EndOfGame.clickBack();
        }
    }
}

