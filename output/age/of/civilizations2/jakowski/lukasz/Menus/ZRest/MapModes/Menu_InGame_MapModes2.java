
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest.MapModes;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModes_R;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_NS_MapModes_R2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_MapModes2
extends Menu {
    private long lTime = 0L;

    public Menu_InGame_MapModes2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempElemH = Math.max(CFG.BUTTON_H * 4 / 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6);
        for (int i = 0; i < 48; ++i) {
            if (i == 47) {
                if (i % 2 == 0) {
                    menuElements.add(new Button_Opt_MapModes_R(-2, null, -1, 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true, i + 1){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_MapModes2.this.getW();
                        }

                        @Override
                        public boolean getIsClickable() {
                            return CFG.SPECTATOR_MODE;
                        }
                    });
                    continue;
                }
                menuElements.add(new Button_Opt_NS_MapModes_R2(-2, null, -1, 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true, i + 1){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MapModes2.this.getW();
                    }

                    @Override
                    public boolean getIsClickable() {
                        return CFG.SPECTATOR_MODE;
                    }
                });
                continue;
            }
            if (i % 2 == 0) {
                menuElements.add(new Button_Opt_MapModes_R(-2, null, -1, 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true, i + 1){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MapModes2.this.getW();
                    }
                });
                continue;
            }
            menuElements.add(new Button_Opt_NS_MapModes_R2(-2, null, -1, 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true, i + 1){

                @Override
                public int getWidthE() {
                    return Menu_InGame_MapModes2.this.getW();
                }
            });
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT());
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT(), true, false);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.075f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.175f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, -1, -1, CFG.BUTTON_W * 2 + CFG.BUTTON_W * 3 / 5, Math.min(Math.min(tempElemH * 6 + tempElemH / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H), menuElements.size() * tempElemH), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("MapModes"));
        int id = 0;
        try {
            this.getMenuElem(id).setTextE(CFG.lang.get("Political"));
            this.getMenuElem(id++).setCurr(-1);
            this.getMenuElem(id).setTextE(CFG.lang.get("Wars"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_WARS_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploWar);
            this.getMenuElem(id).setTextE(CFG.lang.get("Army"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_ARMY_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploArmy);
            this.getMenuElem(id).setTextE(CFG.lang.get("Income"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INCOME_MODE);
            this.getMenuElem(id++).setText2("" + Images.topGold());
            this.getMenuElem(id).setTextE(CFG.lang.get("Income") + ": " + CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INCOME_ALL_MODE);
            this.getMenuElem(id++).setText2("" + Images.topGold());
            this.getMenuElem(id).setTextE(CFG.lang.get("Technology"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_TECHNOLOGY_MODE);
            this.getMenuElem(id++).setText2("" + Images.technology);
            this.getMenuElem(id).setTextE(CFG.lang.get("Population"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_POPULATION_MODE);
            this.getMenuElem(id++).setText2("" + Images.pop);
            this.getMenuElem(id).setTextE(CFG.lang.get("PopulationChange"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_POPULATION_CHANGE_MODE);
            this.getMenuElem(id++).setText2("" + Images.pop);
            this.getMenuElem(id).setTextE(CFG.lang.get("DeathsInAllWars"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_DEATHS_IN_ALL_WARS_MODE);
            this.getMenuElem(id++).setText2("" + Images.skull);
            this.getMenuElem(id).setTextE(CFG.lang.get("Economy"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_ECONOMY_MODE);
            this.getMenuElem(id++).setText2("" + Images.economy);
            this.getMenuElem(id).setTextE(CFG.lang.get("EconomicChange"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_ECONOMY_CHANGE_MODE);
            this.getMenuElem(id++).setText2("" + Images.economy);
            this.getMenuElem(id).setTextE(CFG.lang.get("EconomicInvestments"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INVESTS_ECO_MODE);
            this.getMenuElem(id++).setText2("" + Images.investEco);
            this.getMenuElem(id).setTextE(CFG.lang.get("Development"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_DEVELOPMENT_MODE);
            this.getMenuElem(id++).setText2("" + Images.development);
            this.getMenuElem(id).setTextE(CFG.lang.get("DevelopmentInvestments"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INVESTS_DEV_MODE);
            this.getMenuElem(id++).setText2("" + Images.investDev);
            this.getMenuElem(id).setTextE(CFG.lang.get("ProvinceStability"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploStability);
            this.getMenuElem(id).setTextE(CFG.lang.get("AssimilationInProgress"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_ASSIMILATIONS_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploStability);
            this.getMenuElem(id).setTextE(CFG.lang.get("Diseases"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_DISEASES_MODE);
            this.getMenuElem(id++).setText2("" + Images.disease);
            this.getMenuElem(id).setTextE(CFG.lang.get("Buildings"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_BUILDINGS_MODE);
            this.getMenuElem(id++).setText2("" + Images.buildAll);
            this.getMenuElem(id).setTextE(CFG.lang.get("DistanceFromCapital"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_DISTANCE_MODE);
            this.getMenuElem(id++).setText2("" + Images.editorCity);
            this.getMenuElem(id).setTextE(CFG.lang.get("RecruitablePopulation"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_RECRUITABLE_ARMY_MODE);
            this.getMenuElem(id++).setText2("" + Images.actRecruit);
            this.getMenuElem(id).setTextE(CFG.lang.get("TerrainType"));
            this.getMenuElem(id++).setCurr(MapModesManager.VIEW_TERRAIN_TYPE_MODE);
            this.getMenuElem(id).setTextE(CFG.lang.get("GrowthRate"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_GROWTH_RATE_MODE);
            this.getMenuElem(id++).setText2("" + Images.popGrowth);
            this.getMenuElem(id).setTextE(CFG.lang.get("Supplies"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_SUPPLIES_MODE);
            this.getMenuElem(id++).setText2("" + Images.bSupply);
            this.getMenuElem(id).setTextE(CFG.lang.get("Happiness"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_HAPPINESS_MODE);
            this.getMenuElem(id++).setText2("" + Images.happiness);
            this.getMenuElem(id).setTextE(CFG.lang.get("Festivals"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_FESTIVALS_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploFestival);
            this.getMenuElem(id).setTextE(CFG.lang.get("Unrest"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_REVOLUTION_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploRevolution);
            this.getMenuElem(id).setTextE(CFG.lang.get("Governments"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_IDEOLOGIES_MODE);
            this.getMenuElem(id++).setText2("" + Images.administration);
            this.getMenuElem(id).setTextE(CFG.lang.get("Religion"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_RELIGION_MODE);
            this.getMenuElem(id++).setText2("" + Images.religion);
            this.getMenuElem(id).setTextE(CFG.lang.get("ImperialView"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_IMPERIAL_MODE);
            this.getMenuElem(id++).setText2("" + Images.hreIcon);
            this.getMenuElem(id).setTextE(CFG.lang.get("Cores"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_CORES_MODE);
            this.getMenuElem(id++).setText2("" + Images.core);
            this.getMenuElem(id).setTextE(CFG.lang.get("ProvinceValue"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_PROVINCE_VALUE_MODE);
            this.getMenuElem(id++).setText2("" + Images.victoryPoints);
            this.getMenuElem(id).setTextE(CFG.lang.get("Diplomacy"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_DIPLOMACY_MODE);
            this.getMenuElem(id++).setText2("" + Images.topDiplomacyPoints);
            this.getMenuElem(id).setTextE(CFG.lang.get("Alliances"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_ALLIANCES_MODE);
            this.getMenuElem(id++).setText2("" + Images.diploAlliance);
            this.getMenuElem(id).setTextE(CFG.lang.get("Fortifications"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE);
            this.getMenuElem(id++).setText2("" + Images.bFort);
            this.getMenuElem(id).setTextE(CFG.lang.get("WatchTowers"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE);
            this.getMenuElem(id++).setText2("" + Images.bTower);
            this.getMenuElem(id).setTextE(CFG.lang.get("Ports"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_PORT_MODE);
            this.getMenuElem(id++).setText2("" + Images.bPort);
            this.getMenuElem(id).setTextE(CFG.lang.get("Farm"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_FARM_MODE);
            this.getMenuElem(id++).setText2("" + Images.bFarm);
            this.getMenuElem(id).setTextE(CFG.lang.get("Workshop"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE);
            this.getMenuElem(id++).setText2("" + Images.bWorkshop);
            this.getMenuElem(id).setTextE(CFG.lang.get("Market"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_MARKET_MODE);
            this.getMenuElem(id++).setText2("" + Images.bMarket);
            this.getMenuElem(id).setTextE(CFG.lang.get("Library"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE);
            this.getMenuElem(id++).setText2("" + Images.bLibrary);
            this.getMenuElem(id).setTextE(CFG.lang.get("Armoury"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE);
            this.getMenuElem(id++).setText2("" + Images.bArmoury);
            this.getMenuElem(id).setTextE(CFG.lang.get("SupplyCamp"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE);
            this.getMenuElem(id++).setText2("" + Images.bSupply);
            this.getMenuElem(id).setTextE(CFG.lang.get("Wonders"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_WONDERS_MODE);
            this.getMenuElem(id++).setText2("" + Images.wonders);
            this.getMenuElem(id).setTextE(CFG.lang.get("IncomeTaxation"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INCOME_TAXATION_MODE);
            this.getMenuElem(id++).setText2("" + Images.topGold());
            this.getMenuElem(id).setTextE(CFG.lang.get("IncomeProduction"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_INCOME_PRODUCTION_MODE);
            this.getMenuElem(id++).setText2("" + Images.topGold());
            this.getMenuElem(id).setTextE(CFG.lang.get("Continents"));
            this.getMenuElem(id++).setCurr(MapModesManager.VIEW_CONTINENT_MODE);
            this.getMenuElem(id).setTextE(CFG.lang.get("Regions"));
            this.getMenuElem(id++).setCurr(MapModesManager.VIEW_REGIONS_MODE);
            this.getMenuElem(id).setTextE(CFG.lang.get("Balance"));
            this.getMenuElem(id).setCurr(MapModesManager.VIEW_BALANCE_MODE);
            this.getMenuElem(id++).setText2("" + Images.topGold());
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + Core.PADDING * 2, -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2, true, true);
            super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
            super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2, true, true);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        CFG.mapModesManager.setActiveMapModeID(this.getMenuElem(iID).getCurr(), false);
    }

    private final int getW() {
        return this.getWidthM() - 4;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }
}

