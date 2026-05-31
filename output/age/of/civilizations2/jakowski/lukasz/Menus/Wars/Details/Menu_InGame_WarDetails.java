package age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_WarDetails_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import java.util.ArrayList;

public class Menu_InGame_WarDetails extends Menu {
    public static int WAR_ID = 0;
    public static int LAST_X = -1;
    public static int LAST_Y = -1;

    public Menu_InGame_WarDetails(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
    }

    public Menu_InGame_WarDetails() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        int tempHeight = CFG.BUTTON_H * 2;

        if (CFG.core.getWarsSize() == 0 || WAR_ID < 0 || WAR_ID >= CFG.core.getWarsSize()) {
            int menuPosX = (LAST_X >= 0) ? Math.min(LAST_X, CFG.GAMEWIDTH - tempWidth) : (CFG.GAMEWIDTH / 2 - tempWidth / 2);
            int menuPosY = (LAST_Y >= 0) ? Math.min(LAST_Y, CFG.GAMEHEIGHT - tempHeight) : (CFG.GAMEHEIGHT / 2 - tempHeight / 2);
            
            menuElements.add(new Button_Stats_Title(CFG.lang.get("Error"), CFG.PADD, 0, 0, tempWidth, tempHeight));
            this.initMenu(new TitleM_TextSmall(CFG.lang.get("WarDetails"), CFG.BUTTON_H, true, true), 
                          Math.max(0, menuPosX), Math.max(0, menuPosY), tempWidth, 
                          tempHeight, menuElements, true, true);
            return;
        }

        int tY = 0;
        int titleH = CFG.BUTTON_H / 2;
        int elementH = Math.max(CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 4);

        

        
        long totalAgg = 0;
        long totalDef = 0;
        try {
            for (int i = 0; i < CFG.core.getWar(WAR_ID).getAggressorsSize(); i++) {
                totalAgg += CFG.core.getWar(WAR_ID).getAggressorID(i).getCasualties();
            }
            for (int i = 0; i < CFG.core.getWar(WAR_ID).getDefendersSize(); i++) {
                totalDef += CFG.core.getWar(WAR_ID).getDefenderID(i).getCasualties();
            }
        } catch (Exception e) {}

        
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Aggressors"), CFG.PADD * 2, 0, tY, tempWidth / 2, titleH));
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Defenders"), CFG.PADD * 2, tempWidth / 2, tY, tempWidth / 2, titleH));
        tY += titleH + CFG.PADD;

        
        String totalText = CFG.getNumber_SHORT(totalAgg) + " VS " + CFG.getNumber_SHORT(totalDef);
        menuElements.add(new Button_Stats_Title(totalText, CFG.PADD, 0, tY, tempWidth, elementH / 2));
        tY += elementH / 2 + CFG.PADD * 2;

        int startY = tY;
        
        
        try {
            for (int i = 0; i < CFG.core.getWar(WAR_ID).getAggressorsSize(); i++) {
                int civID = CFG.core.getWar(WAR_ID).getAggressorID(i).getCivID();
                long casualties = CFG.core.getWar(WAR_ID).getAggressorID(i).getCasualties();
                long deaths = CFG.core.getWar(WAR_ID).getAggressorID(i).getCivilianDeaths();
                long econ = CFG.core.getWar(WAR_ID).getAggressorID(i).getEconomicLosses();
                int part = CFG.core.getWar(WAR_ID).getParticipation_AggressorID(i);
                int provs = CFG.core.getWar(WAR_ID).getProvinces_Aggressor_Own(i);
                int provsT = CFG.core.getWar(WAR_ID).getProvinces_Aggressor_OwnTotal(i);
                
                menuElements.add(new Button_Stats_WarDetails(civID, casualties, deaths, econ, part, provs, provsT, 2, tY, tempWidth / 2 - 4, false));
                tY += elementH;
            }
        } catch (Exception e) {}

        int endY_Aggressors = tY;
        tY = startY;

        
        try {
            for (int i = 0; i < CFG.core.getWar(WAR_ID).getDefendersSize(); i++) {
                int civID = CFG.core.getWar(WAR_ID).getDefenderID(i).getCivID();
                long casualties = CFG.core.getWar(WAR_ID).getDefenderID(i).getCasualties();
                long deaths = CFG.core.getWar(WAR_ID).getDefenderID(i).getCivilianDeaths();
                long econ = CFG.core.getWar(WAR_ID).getDefenderID(i).getEconomicLosses();
                int part = CFG.core.getWar(WAR_ID).getParticipation_DefenderID(i);
                int provs = CFG.core.getWar(WAR_ID).getProvinces_Defender_Own(i);
                int provsT = CFG.core.getWar(WAR_ID).getProvinces_Defender_OwnTotal(i);
                
                menuElements.add(new Button_Stats_WarDetails_Right(civID, casualties, deaths, econ, part, provs, provsT, tempWidth / 2 + 2, tY, tempWidth / 2 - 4, false));
                tY += elementH;
            }
        } catch (Exception e) {}
        
        int maxY = Math.max(endY_Aggressors, tY);

        if (CFG.SANDBOX_MODE || CFG.core.getWar(WAR_ID).getIsInAggressors(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) || CFG.core.getWar(WAR_ID).getIsInDefenders(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
            menuElements.add(new Button_Game(CFG.lang.get("PeaceNegotiations"), -1, CFG.PADD, maxY + CFG.PADD, tempWidth - CFG.PADD * 2, elementH, true) {
                @Override
                public void actionElem(int iID) {
                    if (WAR_ID >= 0 && WAR_ID < CFG.core.getWarsSize()) {
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                        CFG.mapModesManager.disableAllViews();
                        Menu_PeaceTreaty.WAR_ID = WAR_ID;
                        CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, CFG.core.getWar(WAR_ID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        CFG.core.resetChooseProvinceData_Immediately();
                        CFG.core.resetRegroupArmy_Data();
                        CFG.menus.setMenuID(View.eINGAME_PEACE_TREATY);
                    }
                }
            });
            maxY += elementH + CFG.PADD;
        }
        
        menuElements.add(new Button_Transparent(0, 0, tempWidth, maxY, true));

        int menuHeight = Math.min(maxY + CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3);
        int menuPosY = (LAST_Y > 0 && LAST_Y < CFG.GAMEHEIGHT - menuHeight) ? LAST_Y : (CFG.GAMEHEIGHT / 2 - menuHeight / 2);
        int menuPosX = (LAST_X > 0 && LAST_X < CFG.GAMEWIDTH - tempWidth) ? LAST_X : (CFG.GAMEWIDTH / 2 - tempWidth / 2);

        this.initMenu(new TitleM_TextSmall(CFG.lang.get("WarDetails"), CFG.BUTTON_H, true, true), 
                      Math.max(0, menuPosX), Math.max(0, menuPosY), tempWidth,
                      menuHeight, menuElements, true, true);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.core.getWarsSize() == 0) {
            return;
        }
        
        LAST_X = this.getPosX();
        LAST_Y = this.getPosY();
        
        oSB.setColor(new Color(0.015f, 0.015f, 0.03f, 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.05f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.9f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), 2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 2 + iTranslateY, this.getWidthM(), 2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, 2, this.getHeightM());
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getWidthM() - 2 + iTranslateX, this.getPosY() + iTranslateY, 2, this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }
}
