/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario_Title;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.SaveLoad.LoadManager;
import age.of.civilizations2.jakowski.lukasz.Ships.ShipManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_LoadMap
extends Menu {
    private int iStepID = 0;
    private int iNumOfSteps = 23;
    public static int loadMapBG_FileID = 0;

    public Menu_LoadMap() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)this.iStepID / (float)(this.iNumOfSteps + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        new Thread(new Runnable(){

            @Override
            public void run() {
                Gdx.app.postRunnable(new Runnable(){

                    @Override
                    public void run() {
                        Menu_LoadMap.this.loadMap();
                    }
                });
            }
        }).start();
        CFG.drawVersionLB(oSB, iTranslateX);
        CFG.setRenderO(true);
    }

    private final void loadMap() {
        block10: {
            block40: {
                block39: {
                    block38: {
                        block37: {
                            block36: {
                                block35: {
                                    block34: {
                                        block33: {
                                            block32: {
                                                block31: {
                                                    block30: {
                                                        block29: {
                                                            block28: {
                                                                block27: {
                                                                    block26: {
                                                                        block25: {
                                                                            block24: {
                                                                                block23: {
                                                                                    block22: {
                                                                                        block21: {
                                                                                            block20: {
                                                                                                block19: {
                                                                                                    block18: {
                                                                                                        block17: {
                                                                                                            block16: {
                                                                                                                block15: {
                                                                                                                    block14: {
                                                                                                                        block13: {
                                                                                                                            block12: {
                                                                                                                                block11: {
                                                                                                                                    block9: {
                                                                                                                                        if (this.iStepID != 0) break block9;
                                                                                                                                        SaveGameManager.gameCanBeContinued = false;
                                                                                                                                        CFG.map.getMpB().loadGameMap();
                                                                                                                                        CFG.map.getMpSl().stopScrollingTheMap();
                                                                                                                                        CFG.map.getMpS().setCurrScale(MapScale.MINSCALE);
                                                                                                                                        CFG.map.getMpC().setNewPosX(-((int)((float)(CFG.map.getMpB().getWidthM() / 2) - (float)CFG.GAMEWIDTH / MapScale.MINSCALE / 2.0f)));
                                                                                                                                        CFG.map.getMpC().setNewPosY(-((int)((float)(CFG.map.getMpB().getHeightM() / 2) - (float)CFG.GAMEHEIGHT / MapScale.MINSCALE / 2.0f)));
                                                                                                                                        CFG.map.getMpC().updateMapPos();
                                                                                                                                        CFG.sLoading = CFG.lang.get("LoadingGraphics");
                                                                                                                                        ++this.iStepID;
                                                                                                                                        break block10;
                                                                                                                                    }
                                                                                                                         if (this.iStepID != 1) break block11;
                                                                                                                                     CFG.core.disposeMapData();
                                                                                                                                     CFG.map.mpOv.dispose();
                                                                                                                                     CFG.map.initMapContinents();
                                                                                                                                     CFG.map.initMapRegions();
                                                                                                                                                                                                     CFG.core.preloadProvinceCache();
                                                                                                                                     CFG.sLoading = CFG.lang.get("LoadingMap");
                                                                                                                                     ++this.iStepID;
                                                                                                                                     ShipManager.clearShips();
                                                                                                                                     break block10;
                                                                                                                                 }
                                                                                                                                 if (this.iStepID < 2 || this.iStepID >= 2 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())) break block12;
                                                                                                                                 CFG.sLoading = CFG.lang.get("LoadingMap");
                                                                                                                                 int nProvinces = CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN());
                                                                                                                                 for (int pv = 0; pv < nProvinces; ++pv) {
                                                                                                                                     CFG.core.loadProvince(pv);
                                                                                                                                 }
                                                                                                                                 CFG.core.updateProvincesSize();
                                                                                                                                 this.iStepID = 2 + nProvinces;
                                                                                                                                 break block10;
                                                                                                                             }
                                                                                                                             if (this.iStepID != 2 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())) break block13;
                                                                                                                             CFG.sLoading = CFG.lang.get("LoadingProvinces");
                                                                                                                             ++this.iStepID;
                                                                                                                             break block10;
                                                                                                                         }
                                                                                                                         if (this.iStepID != 3 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())) break block14;
                                                                                                                         CFG.sLoading = CFG.lang.get("LoadingProvinces");
                                                                                                                         CFG.core.loadProvinceTextures();
                                                                                                                         this.iStepID = 3 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2;
                                                                                                                         break block10;
                                                                                                                     }
                                                                                                                     if (this.iStepID != 3 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block15;
                                                                                                                     CFG.core.updateProvincesSize();
                                                                                                                     CFG.core.buildBasinsOfSeaProvinces();
                                                                                                                     CFG.core.loadRegions();
                                                                                                                     CFG.sLoading = CFG.lang.get("LoadingGameData");
                                                                                                                     ++this.iStepID;
                                                                                                                     break block10;
                                                                                                                }
                                                                                                                if (this.iStepID != 4 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block16;
                                                                                                                CFG.core.loadProvinceNames_ALL();
                                                                                                                CFG.core.checkLandBySeaProvincesBorders();
                                                                                                                CFG.core.checkSeaBySeaProvincesBorders();
                                                                                                                ++this.iStepID;
                                                                                                                break block10;
                                                                                                            }
                                                                                                            if (this.iStepID != 5 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block17;
                                                                                                            CFG.core.buildProvinceBorder();
                                                                                                            ++this.iStepID;
                                                                                                            break block10;
                                                                                                        }
                                                                                                        if (this.iStepID != 6 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block18;
                                                                                                        CFG.sLoading = CFG.lang.get("Loading");
                                                                                                        CFG.core.getGameScenars().loadGame_Scenarios(true);
                                                                                                        ++this.iStepID;
                                                                                                        break block10;
                                                                                                    }
                                                                                                    if (this.iStepID != 7 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block19;
                                                                                                    CFG.PLAYER_TURN_ID = 0;
                                                                                                    CFG.core.getPlayer(0).initMetProvince(true);
                                                                                                    ++this.iStepID;
                                                                                                    break block10;
                                                                                                }
                                                                                                if (this.iStepID != 8 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block20;
                                                                                                CFG.core.loadScenario_1(false);
                                                                                                ++this.iStepID;
                                                                                                break block10;
                                                                                            }
                                                                                            if (this.iStepID != 9 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block21;
                                                                                            CFG.core.loadScenario_2(false);
                                                                                            ++this.iStepID;
                                                                                            break block10;
                                                                                        }
                                                                                        if (this.iStepID != 10 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block22;
                                                                                        ++this.iStepID;
                                                                                        break block10;
                                                                                    }
                                                                                    if (this.iStepID != 11 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block23;
                                                                                    ChallengesManager.loadChallenges();
                                                                                    ++this.iStepID;
                                                                                    break block10;
                                                                                }
                                                                                if (this.iStepID != 12 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block24;
                                                                                ++this.iStepID;
                                                                                break block10;
                                                                            }
                                                                            if (this.iStepID != 13 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block25;
                                                                            CFG.core.loadScenario_2_Flags();
                                                                            ++this.iStepID;
                                                                            break block10;
                                                                        }
                                                                        if (this.iStepID != 14 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block26;
                                                                        CFG.core.loadScenario_3(false);
                                                                        ++this.iStepID;
                                                                        break block10;
                                                                    }
                                                                    if (this.iStepID != 15 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block27;
                                                                    CFG.core.loadScenario_4(false);
                                                                    ++this.iStepID;
                                                                    break block10;
                                                                }
                                                                if (this.iStepID != 16 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block28;
                                                                CFG.core.loadScenario_5(false);
                                                                ++this.iStepID;
                                                                break block10;
                                                            }
                                                            if (this.iStepID != 17 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block29;
                                                            CFG.core.loadScenario_6(false);
                                                            ++this.iStepID;
                                                            break block10;
                                                        }
                                                        if (this.iStepID != 18 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block30;
                                                        CFG.core.loadScenario_7(false);
                                                        ++this.iStepID;
                                                        break block10;
                                                    }
                                                    if (this.iStepID != 19 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block31;
                                                    CFG.core.loadScenario_8(false);
                                                    ++this.iStepID;
                                                    break block10;
                                                }
                                                if (this.iStepID != 20 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block32;
                                                CFG.core.loadScenario_9(false);
                                                ++this.iStepID;
                                                break block10;
                                            }
                                            if (this.iStepID != 21 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block33;
                                            CFG.core.loadScenario_10(false);
                                            ++this.iStepID;
                                            break block10;
                                        }
                                        if (this.iStepID != 22 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block34;
                                        CFG.core.loadScenario_11(false);
                                        ++this.iStepID;
                                        break block10;
                                    }
                                    if (this.iStepID != 23 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block35;
                                    CFG.core.loadScenario_12(false);
                                    ++this.iStepID;
                                    break block10;
                                }
                                if (this.iStepID != 24 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block36;
                                CFG.core.loadScenario_13(false);
                                ++this.iStepID;
                                break block10;
                            }
                            if (this.iStepID != 25 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block37;
                            CFG.core.loadScenario_14(false);
                            ++this.iStepID;
                            break block10;
                        }
                        if (this.iStepID != 26 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block38;
                        CFG.core.initPlayers();
                        CFG.core.buildDrawArmy();
                        if (Menu_LoadMap.loadMapOverlays()) {
                            loadMapBG_FileID = 0;
                            CFG.map.mpOv.lO("Overlays.json");
                        }
                        ++this.iStepID;
                        break block10;
                    }
                    if (this.iStepID != 27 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block39;
                    if (Menu_LoadMap.loadMapOverlays()) {
                        while (CFG.map.mpOv.lOI()) {}
                        loadMapBG_FileID = 0;
                    }
                    ++this.iStepID;
                    break block10;
                }
                if (this.iStepID != 28 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block40;
                if (Menu_LoadMap.loadMapOverlays()) {
                    while (CFG.map.mpOv.lOI2()) {}
                    loadMapBG_FileID = 0;
                }
                ++this.iStepID;
                break block10;
            }
            if (this.iStepID != 29 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) break block10;
            CFG.core.loadCities();
            CFG.core.buildProvincesNames();
            CFG.core.loadMountains();
            LoadManager.loadProvinceNamesPoints();
            Core.addSimpleTask(new Core.SimpleTask("buildProvNameData"){

                @Override
                public void update() {
                    PNM.bPND();
                }
            });
            CFG.map.getMpSl().stopScrollingTheMap();
            CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
            CFG.map.getMpC().centerToRandomMapPos();
            Menu_ChooseScenario_Title.iPreviewScenarioID = 0;
            CFG.menus.setMenuID(CFG.goToMenu);
            CFG.saveSettings_ActiveMap();
            CFG.map.load_DeleteStatusFile();
            try {
                CFG.core.clearPropaganda();
                CFG.core.cleanForeignInvestmentBuild();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static boolean loadMapOverlays() {
        return CFG.getIsDesktop() || CFG.settingsGD.ANDROID_LOAD_MAP_OVERLAYS;
    }
}

