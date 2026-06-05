package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.MapA.MissileManager;

public class Menu_InGame_Missiles extends Menu {

    public Menu_InGame_Missiles() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        Civilization civ = CFG.core.getCiv(civID);

        menuElements.add(new Text_Desc("Program Level: Tier " + civ.civGD.iMissileTier, CFG.PADD, tY + CFG.PADD, tempWidth - CFG.PADD * 2));
        tY += menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;

        if (civ.civGD.iMissileTier < 3) {
            long upgradeCost = (long)(civ.incomeTaxation * (civ.civGD.iMissileTier == 1 ? 25.0f : 62.5f));
            menuElements.add(new Button_InGameAction("Upgrade to Tier " + (civ.civGD.iMissileTier + 1) + " (" + CFG.getNumberWthSpaces("" + upgradeCost) + ")", -1, CFG.PADD, tY, tempWidth - CFG.PADD * 2, true) {
                @Override
                public void actionElem(int iID) {
                    if (MissileManager.upgradeMissileTier(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) CFG.menus.rebuildInGame_Missiles();
                }
            });
            tY += menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;
        }

        menuElements.add(new Text_Desc("Stockpile: T1: " + civ.civGD.iMissiles + " | T2: " + civ.civGD.iMissiles_T2 + " | T3: " + civ.civGD.iMissiles_T3, CFG.PADD, tY + CFG.PADD, tempWidth - CFG.PADD * 2));
        tY += menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;

        menuElements.add(new Text_Desc("Global Rank: #" + civ.getRankPos() + " | Missile Cost: x" + MissileManager.getMissileCostRankMultiplier(civID), CFG.PADD, tY + CFG.PADD, tempWidth - CFG.PADD * 2));
        tY += menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;

        {
            int tier = civ.civGD.iMissileTier;
            long cost = MissileManager.calculateMissileCost(civID, tier);
            menuElements.add(new Button_InGameAction("Build (" + CFG.getNumberWthSpaces("" + cost) + ")", -1, CFG.PADD, tY, (tempWidth - CFG.PADD * 3) * 2 / 3, true) {
                @Override
                public void actionElem(int iID) {
                    if (MissileManager.buildMissile(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) CFG.menus.rebuildInGame_Missiles();
                }
            });
            menuElements.add(new Button_InGameAction("x10", -1, CFG.PADD * 2 + (tempWidth - CFG.PADD * 3) * 2 / 3, tY, (tempWidth - CFG.PADD * 3) / 3, true) {
                @Override
                public void actionElem(int iID) {
                    if (MissileManager.buildMissile10(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) CFG.menus.rebuildInGame_Missiles();
                }
            });
            tY += menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD;
        }

        menuElements.add(new Button_InGameAction("Close", -1, CFG.PADD, tY + CFG.PADD, tempWidth - CFG.PADD * 2, true) {
            @Override
            public void actionElem(int iID) { Menu_InGame_Missiles.this.setVisibleM(false); }
        });

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall("Missile Program", CFG.BUTTON_H * 3 / 4, true, true), 
            CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, 
            tY + menuElements.get(menuElements.size() - 1).getHeightE() + CFG.PADD * 2, menuElements, true, true);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }
}
