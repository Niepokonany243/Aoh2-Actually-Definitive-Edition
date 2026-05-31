package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.civilizations2.jakowski.lukasz.Button.*;
import age.of.civilizations2.jakowski.lukasz.Button.Game.*;
import age.of.civilizations2.jakowski.lukasz.Button2.*;
import age.of.civilizations2.jakowski.lukasz.Sliders.*;
import age.of.civilizations2.jakowski.lukasz.Title.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Strategy extends Menu {
    public Menu_InGame_Strategy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int fixedStrategyWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.5f);
        int tempWidth = Math.min(CFG.GAMEWIDTH - CFG.PADD * 4, fixedStrategyWidth);
        int tY = CFG.PADD;
        final Civilization civ = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());

        if (civ.civGD == null) {
            this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
            return;
        }

        // Battle Strategy Tabs
        int tabW = (fixedStrategyWidth - CFG.PADD * 2) / 4;
        for (int i = 0; i < 4; i++) {
            final int strategyID = i;
            menuElements.add(new Button_Game(getStrategyName(i), -1, CFG.PADD + i * tabW, tY, tabW, CFG.BUTTON_H * 3 / 4, true) {
                @Override
                public void actionElem(int iID) {
                    civ.civGD.iBattleStrategy = strategyID;
                    CFG.menus.rebuildInGame_Strategy();
                }
                @Override
                public Color getColorE(boolean isActive) {
                    if (civ.civGD.iBattleStrategy == strategyID) {
                        return CFG.COLOR_TEXT_GREEN;
                    }
                    return super.getColorE(isActive);
                }
            });
        }
        tY += CFG.BUTTON_H * 3 / 4 + CFG.PADD;

        menuElements.add(new Text_Static("-------------------", -1, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        // Auto Options
        menuElements.add(new Button_Game_Checkbox("Auto-Assimilation", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoAssimilation) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoAssimilation = !civ.civGD.autoAssimilation; 
                this.setCheckboxSt(civ.civGD.autoAssimilation);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Happiness", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoHappiness) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoHappiness = !civ.civGD.autoHappiness; 
                this.setCheckboxSt(civ.civGD.autoHappiness);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Investment", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoInvest) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoInvest = !civ.civGD.autoInvest; 
                this.setCheckboxSt(civ.civGD.autoInvest);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Game_Checkbox("Auto-Building", CFG.PADD, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, true, civ.civGD.autoBuild) {
            @Override
            public void actionElem(int iID) { 
                civ.civGD.autoBuild = !civ.civGD.autoBuild; 
                this.setCheckboxSt(civ.civGD.autoBuild);
                CFG.menus.rebuildInGame_Strategy(); 
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        if (civ.civGD.autoBuild) {
            int subW = (fixedStrategyWidth - CFG.PADD * 4) / 4;
            menuElements.add(new Button_Game_Checkbox("Farm", CFG.PADD, CFG.PADD, tY, subW, true, civ.civGD.autoBuild_Farm) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Farm = !civ.civGD.autoBuild_Farm; this.setCheckboxSt(civ.civGD.autoBuild_Farm); }
            });
            menuElements.add(new Button_Game_Checkbox("Workshop", CFG.PADD, CFG.PADD + subW + CFG.PADD, tY, subW, true, civ.civGD.autoBuild_Workshop) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Workshop = !civ.civGD.autoBuild_Workshop; this.setCheckboxSt(civ.civGD.autoBuild_Workshop); }
            });
            menuElements.add(new Button_Game_Checkbox("Library", CFG.PADD, CFG.PADD + (subW + CFG.PADD) * 2, tY, subW, true, civ.civGD.autoBuild_Library) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Library = !civ.civGD.autoBuild_Library; this.setCheckboxSt(civ.civGD.autoBuild_Library); }
            });
            menuElements.add(new Button_Game_Checkbox("Port", CFG.PADD, CFG.PADD + (subW + CFG.PADD) * 3, tY, subW, true, civ.civGD.autoBuild_Port) {
                @Override
                public void actionElem(int iID) { civ.civGD.autoBuild_Port = !civ.civGD.autoBuild_Port; this.setCheckboxSt(civ.civGD.autoBuild_Port); }
            });
            tY += CFG.BUTTON_H + CFG.PADD;

            menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, civ.civGD.autoBuildTurns) {
                @Override
                public void updateSlider(int nX) {
                    super.updateSlider(nX);
                    civ.civGD.autoBuildTurns = this.getCurr();
                }
                @Override
                public String getDrawText() { return CFG.lang.get("Turns") + ": " + this.getCurr(); }
            });
            tY += CFG.BUTTON_H / 2 + CFG.PADD;
        }

        menuElements.add(new Text_Static("---------", -1, CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2));
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        // Parameters
        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoHappinessMaxMoney * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessMaxMoney = (float)this.getCurr() / 100.0f;
                civ.civGD.autoInvestMaxMoney = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Max Budget Share: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, civ.civGD.autoHappinessTurns) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessTurns = this.getCurr();
                civ.civGD.autoInvestTurns = this.getCurr();
            }
            @Override
            public String getDrawText() { return "Check Interval: " + this.getCurr() + " Turns"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoHappinessThreshold * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoHappinessThreshold = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Happiness Threshold: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;


        menuElements.add(new Slider(CFG.PADD, tY, fixedStrategyWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, 1, 100, (int)(civ.civGD.autoAssimilationThreshold * 100)) {
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                civ.civGD.autoAssimilationThreshold = (float)this.getCurr() / 100.0f;
            }
            @Override
            public String getDrawText() { return "Stability Threshold: " + this.getCurr() + "%"; }
        });
        tY += CFG.BUTTON_H / 2 + CFG.PADD;

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("Strategy"), CFG.BUTTON_H * 4 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, tY + CFG.PADD, menuElements, true, true);
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(0.1f, 0.1f, 0.1f, 0.75f));
        Images.pix.draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), false, false, false);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    private String getStrategyName(int id) {
        switch(id) {
            case 0: return "Def";
            case 1: return "Agg";
            case 2: return "Bal";
            case 3: return "Tac";
            default: return "S" + id;
        }
    }
}
