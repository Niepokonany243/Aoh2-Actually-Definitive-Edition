
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.NewTurn;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SaveTheGame
extends Menu {
    public static int iStepID = 0;
    public static int iNumOfSteps = 26;
    public static int iStepID_TEXT = 1;
    public static int fileID_Civs = 0;
    public static int fileID_Provinces = 0;
    public static boolean firstSaveOfTheGame = false;
    public static boolean pause = false;
    public static String sSaving = "";

    public Menu_SaveTheGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        sSaving = CFG.lang.get("Saving");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.loadData();
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)iStepID / (float)iNumOfSteps, " " + sSaving + " #" + iStepID_TEXT);
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        CFG.drawVersionLB(oSB, iTranslateX);
    }

    public void loadData() {
        try {
            ++iStepID_TEXT;
            if (pause) {
                pause = false;
                return;
            }
            if (iStepID == 0) {
                fileID_Civs = 0;
                fileID_Provinces = 0;
                SaveGameManager.saveGame_0();
            } else if (iStepID == 1) {
                SaveGameManager.saveGame_1();
            } else if (iStepID == 2) {
                SaveGameManager.saveGame_2();
                sSaving = CFG.lang.get("Saving") + ": " + CFG.lang.get("Civilizations");
            } else if (iStepID == 3) {
                while (SaveGameManager.saveGame_3(fileID_Civs++)) {
                }
            } else if (iStepID == 4) {
                SaveGameManager.saveGame_4();
                sSaving = CFG.lang.get("Saving") + ": " + CFG.lang.get("Provinces");
            } else if (iStepID == 5) {
                while (SaveGameManager.saveGame_5(fileID_Provinces++)) {
                }
            } else if (iStepID == 6) {
                SaveGameManager.saveGame_6();
                sSaving = CFG.lang.get("Saving");
            } else if (iStepID == 7) {
                SaveGameManager.saveGame_7();
            } else if (iStepID == 8) {
                SaveGameManager.saveGame_8();
            } else if (iStepID == 9) {
                SaveGameManager.saveGame_9();
            } else if (iStepID == 10) {
                SaveGameManager.saveGame_10();
            } else if (iStepID == 11) {
                SaveGameManager.saveGame_10_B();
            } else if (iStepID != 12 && iStepID != 13) {
                if (iStepID == 14) {
                    SaveGameManager.saveGame_11();
                } else if (iStepID == 15) {
                    SaveGameManager.saveGame_12();
                } else if (iStepID == 16) {
                    SaveGameManager.saveGame_13();
                } else if (iStepID == 17) {
                    SaveGameManager.saveGame_14();
                } else if (iStepID == 18) {
                    SaveGameManager.saveGame_15();
                } else if (iStepID == 19) {
                    SaveGameManager.saveGame_15_1();
                } else if (iStepID == 20) {
                    SaveGameManager.saveGame_15A();
                } else if (iStepID == 21) {
                    SaveGameManager.saveGame_15B();
                } else if (iStepID == 22) {
                    SaveGameManager.saveGame_15C();
                } else if (iStepID == 23) {
                    SaveGameManager.saveGame_15D();
                } else if (iStepID == 24) {
                    SaveGameManager.saveGame_15E();
                } else if (iStepID == 25) {
                    SaveGameManager.saveGame_16();
                } else if (iStepID != 26) {
                    SaveGameManager.forceShowNextPlayerTurnView = false;
                    CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
                    NewTurn.doAction_End();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        ++iStepID;
    }
}

