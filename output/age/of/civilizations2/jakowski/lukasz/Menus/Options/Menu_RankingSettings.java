package age.of.civilizations2.jakowski.lukasz.Menus.Options;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_NS_MapModes_R2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.RankingSettings;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextTitleStyle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_RankingSettings extends Menu {
    
    public Menu_RankingSettings() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonH = CFG.BUTTON_H * 4 / 5;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2;
        
        menuElements.add(new TextTitleStyle("Ranking System Settings", -1, CFG.GAMEWIDTH / 2 - tempWidth / 2, 0, tempWidth, CFG.BUTTON_H * 3 / 4));
        
        menuElements.add(new Button_Opt_NS_MapModes_R2(RankingSettings.RANKING_MILITARY ? 1 : 0, "Military Component", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true, RankingSettings.RANKING_MILITARY, 0){
            @Override
            public void actionElem(int iID) {
                RankingSettings.RANKING_MILITARY = !RankingSettings.RANKING_MILITARY;
                RankingSettings.save();
                CFG.gameAction.buildRank_Positions();
            }
            @Override
            public boolean getCheckboxSt() {
                return RankingSettings.RANKING_MILITARY;
            }
        });
        
        menuElements.add(new Button_Opt_NS_MapModes_R2(RankingSettings.RANKING_PRESTIGE ? 1 : 0, "Prestige Component", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true, RankingSettings.RANKING_PRESTIGE, 0){
            @Override
            public void actionElem(int iID) {
                RankingSettings.RANKING_PRESTIGE = !RankingSettings.RANKING_PRESTIGE;
                RankingSettings.save();
                CFG.gameAction.buildRank_Positions();
            }
            @Override
            public boolean getCheckboxSt() {
                return RankingSettings.RANKING_PRESTIGE;
            }
        });
        
        menuElements.add(new Button_Opt_NS_MapModes_R2(RankingSettings.RANKING_POPULATION ? 1 : 0, "Population Component", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true, RankingSettings.RANKING_POPULATION, 0){
            @Override
            public void actionElem(int iID) {
                RankingSettings.RANKING_POPULATION = !RankingSettings.RANKING_POPULATION;
                RankingSettings.save();
                CFG.gameAction.buildRank_Positions();
            }
            @Override
            public boolean getCheckboxSt() {
                return RankingSettings.RANKING_POPULATION;
            }
        });
        
        menuElements.add(new Button_Opt_NS_MapModes_R2(RankingSettings.RANKING_ECONOMY ? 1 : 0, "Economy Component", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true, RankingSettings.RANKING_ECONOMY, 0){
            @Override
            public void actionElem(int iID) {
                RankingSettings.RANKING_ECONOMY = !RankingSettings.RANKING_ECONOMY;
                RankingSettings.save();
                CFG.gameAction.buildRank_Positions();
            }
            @Override
            public boolean getCheckboxSt() {
                return RankingSettings.RANKING_ECONOMY;
            }
        });
        
        menuElements.add(new Button_Opt_NS_MapModes_R2(RankingSettings.RANKING_HAPPINESS ? 1 : 0, "Happiness Component", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true, RankingSettings.RANKING_HAPPINESS, 0){
            @Override
            public void actionElem(int iID) {
                RankingSettings.RANKING_HAPPINESS = !RankingSettings.RANKING_HAPPINESS;
                RankingSettings.save();
                CFG.gameAction.buildRank_Positions();
            }
            @Override
            public boolean getCheckboxSt() {
                return RankingSettings.RANKING_HAPPINESS;
            }
        });

        menuElements.add(new Button_Opt_NS_MapModes_R2(-1, "Back", CFG.PADD, CFG.GAMEWIDTH / 2 - tempWidth / 2 + CFG.PADD, 0, tempWidth - CFG.PADD * 2, buttonH, true){
            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_RankingSettings(false);
                CFG.menus.setVisible_InGame_Options(true);
            }
        });
        
        int tempElementHeight = (menuElements.size() + 1) * CFG.PADD + CFG.PADD;
        for (int i = 0; i < menuElements.size(); ++i) {
            tempElementHeight += ((MenuElemUI)menuElements.get(i)).getHeightE();
        }
        int tempY = CFG.PADD;
        ((MenuElemUI)menuElements.get(0)).setPosY(CFG.GAMEHEIGHT / 2 - tempElementHeight / 2 + tempY);
        tempY += ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD * 2;
        for (int i = 1; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosY(CFG.GAMEHEIGHT / 2 - tempElementHeight / 2 + tempY);
            tempY += ((MenuElemUI)menuElements.get(i)).getHeightE() + CFG.PADD;
        }
        
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }
    
    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }
}
