
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonFlag_CivName;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateNewGame_Civs
extends Menu {
    public Menu_CreateNewGame_Civs() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tX = 0;
        int tY = CFG.PADD;
        int menuPosX = CFG.BUTTON_W + (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2 + CFG.PADD * 5;
        int menuW = CFG.GAMEWIDTH - menuPosX - CFG.BUTTON_W * 2 - CFG.PADD * 3;
        int menuH = Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + tY * 2);
        if (CFG.getIsDesktop()) {
            ArrayList<Integer> tCivs = new ArrayList<Integer>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getCapitalProvID() < 0) continue;
                tCivs.add(i);
            }
            while (!tCivs.isEmpty()) {
                int bestID = 0;
                int iSize = tCivs.size();
                for (int i = 1; i < iSize; ++i) {
                    if (CFG.core.getCiv((Integer)tCivs.get(bestID)).getRankScore() >= CFG.core.getCiv((Integer)tCivs.get(i)).getRankScore()) continue;
                    bestID = i;
                }
                menuElements.add(new ButtonFlag_CivName((Integer)tCivs.get(bestID), tX, tY, true));
                tX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD / 2;
                tCivs.remove(bestID);
                if (menuElements.size() < 50) continue;
                break;
            }
        } else {
            menuElements.add(new ButtonFlag_CivName(0, tX, tY, true));
            tX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD / 2;
        }
        this.initMenu(null, menuPosX, CFG.GAMEHEIGHT - menuH, menuW, menuH, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            return;
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int nMenuElementID) {
        Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
        super.actionEL(nMenuElementID);
    }
}

