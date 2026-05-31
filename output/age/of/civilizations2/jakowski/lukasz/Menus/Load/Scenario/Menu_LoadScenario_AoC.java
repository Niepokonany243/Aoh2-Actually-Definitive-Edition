/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Start_The_Game_Data;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_LoadScenario_AoC
extends Menu {
    public static int iStepID = 0;
    public static int iNumOfSteps = 16;
    public static int nAoCSubStep = -1;

    public Menu_LoadScenario_AoC() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.loadScenario();
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)iStepID / (float)iNumOfSteps);
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        CFG.drawVersionLB(oSB, iTranslateX);
    }

    public void loadScenario() {
        try {
            if (iStepID == 0) {
                RTS.reset();
            } else if (iStepID == 1) {
                CFG.core.loadScenario_RandomGame_1();
            } else if (iStepID == 2) {
                CFG.core.loadScenario_RandomGame_2();
            } else if (iStepID == 3) {
                CFG.core.loadScenario_RandomGame_3();
            } else if (iStepID == 4) {
                CFG.core.loadScenario_RandomGame_4();
            } else if (iStepID == 5) {
                CFG.core.loadScenario_RandomGame_5();
            } else if (iStepID == 6) {
                CFG.core.loadScenario_RandomGame_6();
            } else if (iStepID == 7) {
                CFG.core.loadScenario_RandomGame_7();
            } else if (iStepID == 8) {
                CFG.core.loadScenario_RandomGame_8();
            } else if (iStepID == 9) {
                CFG.core.loadScenario_RandomGame_9();
            } else if (iStepID == 10) {
                CFG.core.loadScenario_RandomGame_10();
            } else if (iStepID == 11) {
                CFG.core.loadScenario_RandomGame_11();
            } else if (iStepID == 12) {
                if (nAoCSubStep < 0) {
                    nAoCSubStep = 1;
                }
                int batchSize = 10;
                int processed = 0;
                while (nAoCSubStep < CFG.core.getCivsSize() && processed < batchSize) {
                    CFG.core.buildCivilizationsRegions_TextOver(nAoCSubStep);
                    nAoCSubStep++;
                    processed++;
                }
                if (nAoCSubStep >= CFG.core.getCivsSize()) {
                    nAoCSubStep = -1;
                } else {
                    return;
                }
            } else if (iStepID == 13) {
                if (nAoCSubStep < 0) {
                    CFG.gameAction.buildRank_Score();
                    nAoCSubStep = 1;
                    return;
                } else {
                    Menu_CreateNewGame.buildStartPopulationEconomy();
                    nAoCSubStep = -1;
                }
            } else if (iStepID == 14) {
                CFG.core.loadScenario_RandomGame_14();
            } else if (iStepID != 15) {
                CFG.mapModesManager.disableAllViews();
                if (CFG.map.getMpS().getCurrSc() < MapScale.STANDARD_SCALE) {
                    CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                }
                CFG.RANDOM_PLACEMENT = false;
                CFG.gameNewGame.newRandomGamePrep();
                CFG.startTheGameData = new Start_The_Game_Data(false);
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "Age of History 2: Definitive Edition";
                CFG.menus.setMenuIDWithoutAnim(View.eSTART_THE_GAME);
                CFG.map.getMpB().disposeMinimapOfCivilizations();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        ++iStepID;
    }
}

