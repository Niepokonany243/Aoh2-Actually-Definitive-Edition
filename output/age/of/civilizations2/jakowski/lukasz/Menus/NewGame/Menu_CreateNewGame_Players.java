
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateNewGame_Players
extends Menu {
    public Menu_CreateNewGame_Players() {
        this.initMenu();
    }

    private void initMenu() {
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, this.buildMenuElements());
        this.updateLang();
    }

    public List<MenuElemUI> buildMenuElements() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, CFG.core.getPlayersSize() < CFG.core.getAvailableCivilizations() && CFG.core.getPlayersSize() < CFG.core.getGameScenars().getScenarioNumOfCivs(CFG.core.getScenarioID())));
        menuElements.add(new Button_Flag(CFG.core.getPlayer(0).getCivId(), 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG_COLOR));
        menuElements.add(new Button_Classic_Classic("P1 | " + CFG.lang.get("Civilization") + ": " + (CFG.core.getPlayer(0).getCivId() < 0 ? CFG.lang.get("RandomCivilization") : CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCivName()), CFG.PADD * 2, CFG.PADD * 4 + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.CIV_FLAG_WIDTH, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH - CFG.PADD * 4 - (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) - CFG.CIV_FLAG_WIDTH, CFG.BUTTON_H, true));
        for (int i = 1; i < CFG.core.getPlayersSize(); ++i) {
            menuElements.add(new Button_Flag(CFG.core.getPlayer(i).getCivId(), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG_COLOR));
            menuElements.add(new Button_Classic_Classic("P" + (i + 1) + " | " + CFG.lang.get("Civilization") + ": " + (CFG.core.getPlayer(i).getCivId() < 0 ? CFG.lang.get("RandomCivilization") : CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getCivName()), CFG.PADD * 2, CFG.PADD * 4 + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.CIV_FLAG_WIDTH, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2 - CFG.PADD * 4 - (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) - CFG.CIV_FLAG_WIDTH, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        }
        return menuElements;
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AddPlayer"));
        this.getTitleM().setText(CFG.lang.get("Players"));
    }

    @Override
    public final void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.core.addPlayer2(0);
                CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).getCivId(), 0);
                this.initMenu();
                return;
            }
            case 2: {
                return;
            }
            case 3: {
                CFG.menus.setMenuID(View.eSELECT_CIVILIZATION);
                CFG.iSelectCivilizationPlayerID = 0;
                if (CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId() > 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId()).getCapitalProvID());
                } else {
                    CFG.core.setActiveProvID(-1);
                }
                return;
            }
        }
        switch (iID % 3) {
            case 0: {
                if (CFG.core.getPlayer((iID - 6) / 3 + 1).getCivId() > 0) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer((iID - 6) / 3 + 1).getCivId());
                }
                CFG.core.removePlayer((iID - 6) / 3 + 1);
                this.initMenu();
                return;
            }
            case 1: {
                CFG.iSelectCivilizationPlayerID = (iID - 4) / 3 + 1;
                return;
            }
            case 2: {
                CFG.menus.setMenuID(View.eSELECT_CIVILIZATION);
                CFG.iSelectCivilizationPlayerID = (iID - 5) / 3 + 1;
                if (CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId() > 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId()).getCapitalProvID());
                } else {
                    CFG.core.setActiveProvID(-1);
                }
                return;
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
        CFG.menus.setBackAnimation(true);
    }
}

