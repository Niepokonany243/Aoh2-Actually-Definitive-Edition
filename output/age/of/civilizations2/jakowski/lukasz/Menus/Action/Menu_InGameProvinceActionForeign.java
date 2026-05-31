package age.of.civilizations2.jakowski.lukasz.Menus.Action;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_GameInvestForeign;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_GameNuke;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.MissileManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_InGameProvAction;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_BuildForeign;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Actions;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_More;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGameProvinceActionForeign extends Menu {
    @Override
    public int getPosX() {
        if (CFG.menus.getInGame_ProvincemMore_Visible() && Menu_InGame_Province_More.toTheBottom) return super.getPosX() + CFG.CIV_INFO_MENU_WIDTH + Menu_InGame_Province_More.getExtraW() + Menu_InGame_Province_More.extraPosX;
        if (CFG.menus.getInGame_Civ_Info().getVisibleM() && CFG.menus.getInGame_Civ_Info_Actions().getVisibleM() && Menu_InGame_Civ_Actions.toTheBottom) return super.getPosX() + Menu_InGame_Civ.getMenuCivInfoWidth() + Menu_InGame_Civ_Actions.extraPosX;
        return super.getPosX();
    }

    @Override
    public int getMenuPosX() {
        if (CFG.menus.getInGame_ProvincemMore_Visible() && Menu_InGame_Province_More.toTheBottom) return super.getMenuPosX() + CFG.CIV_INFO_MENU_WIDTH + Menu_InGame_Province_More.getExtraW() + Menu_InGame_Province_More.extraPosX;
        if (CFG.menus.getInGame_Civ_Info().getVisibleM() && CFG.menus.getInGame_Civ_Info_Actions().getVisibleM() && Menu_InGame_Civ_Actions.toTheBottom) return super.getMenuPosX() + Menu_InGame_Civ.getMenuCivInfoWidth() + Menu_InGame_Civ_Actions.extraPosX;
        return super.getMenuPosX();
    }

    public Menu_InGameProvinceActionForeign() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int btnStep = CFG.BUTTON_W + CFG.PADD;
        
        // 0: Invest
        menuElements.add(new Button_GameInvestForeign(null, -1, CFG.PADD + 0 * btnStep, CFG.PADD, true, Images.investF1){
            public String sKey = "1";
            public int iKeyWidth;
            @Override
            public void setTextE(String sText) {
                super.setTextE(sText);
                try {
                    CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sKey);
                    this.iKeyWidth = (int)CFG.glyphLay.width;
                } catch (Exception e) { this.iKeyWidth = 0; }
            }
            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawTextWithShadowAlpha(oSB, CFG.FONT_REGULAR_SMALL, this.sKey, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iKeyWidth + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getColorE(isActive));
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }
            @Override
            public void actionElem(int iID) { Menu_InGameProvinceActionForeign.investForeign(); }
        });

        // 1: Build
        menuElements.add(new Button_GameInvestForeign(null, -1, CFG.PADD + 1 * btnStep, CFG.PADD, true, Images.investB1){
            public String sKey = "2";
            public int iKeyWidth;
            @Override
            public void setTextE(String sText) {
                super.setTextE(sText);
                try {
                    CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sKey);
                    this.iKeyWidth = (int)CFG.glyphLay.width;
                } catch (Exception e) { this.iKeyWidth = 0; }
            }
            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawTextWithShadowAlpha(oSB, CFG.FONT_REGULAR_SMALL, this.sKey, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iKeyWidth + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getColorE(isActive));
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }
            @Override
            public void actionElem(int iID) { Menu_InGameProvinceActionForeign.buildForeign(); }
        });

        // 2: Strike (Missile)
        menuElements.add(new Button_GameNuke(null, -1, CFG.PADD + 2 * btnStep, CFG.PADD, true){
            public String sKey = "S";
            @Override
            public boolean getVisibleE() {
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                return CFG.settingsGD.MISSILES && (CFG.core.getCiv(civID).civGD.iMissiles > 0 || CFG.core.getCiv(civID).civGD.iMissiles_T2 > 0 || CFG.core.getCiv(civID).civGD.iMissiles_T3 > 0);
            }
            @Override
            public void actionElem(int iID) {
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                int targetProvID = CFG.core.getActiveProvID();
                if (targetProvID >= 0) {
                    age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.strikeProvince(civID, targetProvID);
                }
                CFG.menus.updateInGameTopAll(civID);
            }
            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Missile Strike", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });

        // 3: Nuke
        menuElements.add(new Button_GameNuke(null, -1, CFG.PADD + 3 * btnStep, CFG.PADD, true){
            public String sKey = "U";
            @Override
            public boolean getVisibleE() { return CFG.ENABLE_NUKES && (GameValues.gvAtomic.PROVINCE_ACTION_NUKE_VISIBLE_ALL_THE_TIME || CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes > 0 || NukeManager.canBuildNuke_TechLvl(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())); }
            @Override
            public void actionElem(int iID) { Menu_InGameProvinceActionForeign.useNuke(); }
        });

        // 4: Attack
        menuElements.add(new Button_Game(null, -1, CFG.PADD + 4 * btnStep, CFG.PADD, true){
            public String sKey = "Y";
            @Override
            public boolean getVisibleE() {
                try {
                    if (TouchManager.lMABX.size() > 1) return true;
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getArmyCivID1(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0) {
                        for (int a = 0; a < CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvincesSize(); ++a) {
                            if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(a)).getCivId())) continue;
                            return true;
                        }
                    }
                    return false;
                } catch (Exception ex) { return false; }
            }
            @Override
            public void actionElem(int iID) { Menu_InGameProvAction.clickOffensive(); }
        });

        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Invest"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Build"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Strike"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Nuke"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Attack"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int totalW = (CFG.PADD + CFG.BUTTON_W) * 5 + CFG.PADD;
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.bgGameAction).getHeight() + -1 + iTranslateY, totalW, this.getHeightM() + 1, true, false);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public static void buildForeign() {
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            Menu_InGame_BuildForeign.buildBuildList();
            CFG.menus.rebuildInGame_BuildForeign(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.core.getActiveProvID());
        }
    }

    public static void investForeign() {
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            CFG.menus.rebuildInGame_InvestForeign(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.core.getActiveProvID());
        }
    }

    public static void useNuke() {
        if (CFG.ENABLE_NUKES) NukeManager.dropNuke(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getActiveProvID());
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
    }
}
