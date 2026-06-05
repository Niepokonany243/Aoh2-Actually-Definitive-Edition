
package age.of.civilizations2.jakowski.lukasz.Menus.Change;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.civilizations2.jakowski.lukasz.Button.*;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.*;
import age.of.civilizations2.jakowski.lukasz.Button.Game.*;
import age.of.civilizations2.jakowski.lukasz.Button2.*;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.*;
import age.of.civilizations2.jakowski.lukasz.Title.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_ChangeGovernment extends Menu {
    private int selectedGovID = -1;

    public Menu_InGame_ChangeGovernment(int nID) {
        this();
    }

    public Menu_InGame_ChangeGovernment() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int fixedWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.5f);
        int tempWidth = Math.min(CFG.GAMEWIDTH - CFG.PADD * 4, fixedWidth);
        int tY = CFG.PADD;
        final int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        final Civilization civ = CFG.core.getCiv(civID);
        if (civ == null || civ.civGD == null) {
            this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
            return;
        }
        final int currentIdeology = civ.getIdeology();
        selectedGovID = -1;

        List<Boolean> canChangeTo = CFG.ideologiesMgr.canChangeToIdeology(civID);
        int govButtonH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.BUTTON_H * 3 / 5);

        for (int i = 1; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
            if (CFG.ideologiesMgr.getIdeologyID(i).REVOLUTIONARY) continue;
            if (CFG.ideologiesMgr.getIdeologyID(i).CAN_BECOME_CIVILIZED >= 0) continue;
            final int govID = i;
            final Ideology govIdeology = CFG.ideologiesMgr.getIdeologyID(i);
            final boolean isCurrent = (i == currentIdeology);
            final boolean available = canChangeTo.get(i);

            String prefix = isCurrent ? "> " : "";
            menuElements.add(new Button_Game(prefix + govIdeology.getName(), -1, CFG.PADD, tY, tempWidth - CFG.PADD * 2, govButtonH, available && !isCurrent){
                @Override
                public void actionElem(int iID) {
                    if (!available || isCurrent) return;
                    selectedGovID = govID;
                }
                @Override
                public Color getColorE(boolean isActive) {
                    if (isCurrent) return CFG.COLOR_TEXT_GREEN;
                    if (!available) return new Color(0.5f, 0.5f, 0.5f, 0.6f);
                    if (selectedGovID == govID) return CFG.COLOR_TEXT_GREEN;
                    return super.getColorE(isActive);
                }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(govIdeology.getName(), govIdeology.getColor()));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.gov, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.INCOME_TAXATION * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.MIN_GOODS * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.MIN_INVESTMENTS * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.RESEARCH_COST * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.INCOME_PRODUCTION * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(govIdeology.MILITARY_UPKEEP * 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (isCurrent) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CurrentGovernment"), CFG.COLOR_TEXT_GREEN));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
            tY += govButtonH + CFG.PADD / 2;
        }

        tY += CFG.PADD;
        int btnW = (tempWidth - CFG.PADD * 3) / 2;

        menuElements.add(new Button_Game(CFG.lang.get("Cancel"), -1, CFG.PADD, tY, btnW, true){
            @Override
            public void actionElem(int iID) { Menu_InGame_ChangeGovernment.this.setVisibleM(false); }
        });
        menuElements.add(new Button_Game(CFG.lang.get("Confirm"), -1, CFG.PADD + btnW + CFG.PADD, tY, btnW, true){
            @Override
            public boolean getIsClickable() {
                return selectedGovID >= 0 && selectedGovID != currentIdeology
                    && civ.getMovemPoints() >= GameValues.gvGovernment.CHANGE_GOV_MOVEMENT_COST
                    && civ.getGold() >= (long)IdeologiesManager.getChangeGovernmentCost(civID)
                    && civ.getTechLevel() >= GameValues.gvGovernment.CHANGE_GOV_REQUIRED_TECH;
            }
            @Override
            public void actionElem(int iID) {
                if (selectedGovID < 0 || selectedGovID == currentIdeology) return;
                if (GameManager.changeGovernmentType(civID, selectedGovID)) {
                    ArrayList<String> tMess = new ArrayList<String>();
                    ArrayList<Color> tColor = new ArrayList<Color>();
                    tMess.add(civ.getCivName());
                    tColor.add(CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getColor());
                    tMess.add(CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getName());
                    tColor.add(CFG.COLOR_HOVER_TITLE);
                    CFG.toastM.addM(tMess, tColor);
                    CFG.menus.rebuildMenu_InGame_Infobox(civ.getCivName() + ": " + CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getName(), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                }
                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                CFG.setActiveCivInfoId(CFG.getActiveCivInfoId());
                CFG.updateActiveCivilizationInfoInGame();
                CFG.menus.updateInGameTopAll(civID);
                CFG.mapModesManager.disableAllViews();
                for (int i = 0; i < civ.getNumOfProvs(); ++i) {
                    CFG.core.getProv(civ.getProvID(i)).setFromCivID(0);
                }
                Menu_InGame_ChangeGovernment.this.setVisibleM(false);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;
        tY += CFG.PADD;

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("ChangeGovernment"), CFG.BUTTON_H * 4 / 5, true, true),
            CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, tY, menuElements, true, true);
    }

    @Override
    public void updateLang() {}

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}
