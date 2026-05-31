package age.of.civilizations2.jakowski.lukasz.Menus.Buildings;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build3;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Button_NS_Population_Buildings;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_BuildingsTop extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_InGame_View_BuildingsTop() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W * 3 / 4;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        
        ArrayList<BData> castle = new ArrayList<BData>();
        ArrayList<BData> tower = new ArrayList<BData>();
        ArrayList<BData> port = new ArrayList<BData>();
        ArrayList<BData> farm = new ArrayList<BData>();
        ArrayList<BData> workshop = new ArrayList<BData>();
        ArrayList<BData> market = new ArrayList<BData>();
        ArrayList<BData> library = new ArrayList<BData>();
        ArrayList<BData> armoury = new ArrayList<BData>();
        ArrayList<BData> supply = new ArrayList<BData>();
        ArrayList<BData> airDefense = new ArrayList<BData>();
        
        int castleNum = 0, towerNum = 0, portNum = 0, farmNum = 0, workshopNum = 0, marketNum = 0, libraryNum = 0, armouryNum = 0, supplyNum = 0, airDefenseNum = 0;

        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province prov = CFG.core.getProv(i);
            if (prov.getCivId() <= 0) continue;
            
            addBData(castle, prov.getCivId(), prov.getLvlOfFort()); castleNum += prov.getLvlOfFort();
            addBData(tower, prov.getCivId(), prov.getLvlOfWatchTower()); towerNum += prov.getLvlOfWatchTower();
            addBData(port, prov.getCivId(), Math.max(0, prov.getLvlOfPort())); portNum += Math.max(0, prov.getLvlOfPort());
            addBData(farm, prov.getCivId(), prov.getLvlOfFarm()); farmNum += prov.getLvlOfFarm();
            addBData(workshop, prov.getCivId(), prov.getLvlOfWorkshop()); workshopNum += prov.getLvlOfWorkshop();
            addBData(market, prov.getCivId(), prov.getLvlOfMarket()); marketNum += prov.getLvlOfMarket();
            addBData(library, prov.getCivId(), prov.getLvlOfLibrary()); libraryNum += prov.getLvlOfLibrary();
            addBData(armoury, prov.getCivId(), prov.getLvlOfArmoury()); armouryNum += prov.getLvlOfArmoury();
            addBData(supply, prov.getCivId(), prov.getLvlOfSupply()); supplyNum += prov.getLvlOfSupply();
            addBData(airDefense, prov.getCivId(), prov.provGD.iAirDefense); airDefenseNum += prov.provGD.iAirDefense;
        }

        int totalNum = castleNum + towerNum + portNum + farmNum + workshopNum + marketNum + libraryNum + armouryNum + supplyNum + airDefenseNum;
        menuElements.add(new Button_DiplomacyAction(Images.buildAll, CFG.lang.get("Buildings") + ": " + CFG.getNumberWthSpaces("" + totalNum), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){
            @Override public void actionElem(int iID) { CFG.menus.setVisible_InGame_View_Buildings(true); }
        });
        tY += menuElements.get(0).getHeightE();

        tY = addCategory(menuElements, castle, "Fort", Images.bFort, castleNum, tempW, tY);
        tY = addCategory(menuElements, tower, "WatchTower", Images.bTower, towerNum, tempW, tY);
        tY = addCategory(menuElements, port, "Port", Images.bPort, portNum, tempW, tY);
        tY = addCategory(menuElements, farm, "Farm", Images.bFarm, farmNum, tempW, tY);
        tY = addCategory(menuElements, workshop, "Workshop", Images.bWorkshop, workshopNum, tempW, tY);
        tY = addCategory(menuElements, market, "Market", Images.bMarket, marketNum, tempW, tY);
        tY = addCategory(menuElements, library, "Library", Images.bLibrary, libraryNum, tempW, tY);
        tY = addCategory(menuElements, armoury, "Armoury", Images.bArmoury, armouryNum, tempW, tY);
        tY = addCategory(menuElements, supply, "Supply", Images.bSupply, supplyNum, tempW, tY);
        tY = addCategory(menuElements, airDefense, "Air Defense", Images.bSupply, airDefenseNum, tempW, tY);

        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Buildings"), CFG.BUTTON_H * 3 / 5, false, false), AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4), menuElements, false, true);
    }

    private void addBData(ArrayList<BData> list, int civID, int num) {
        if (num <= 0) return;
        for (BData item : list) {
            if (item.id == civID) { item.num += num; return; }
        }
        list.add(new BData(civID, num));
    }

    private int addCategory(ArrayList<MenuElemUI> menuElements, ArrayList<BData> list, String name, int imageID, int total, int tempW, int tY) {
        if (total <= 0) return tY;
        menuElements.add(new TextBuildTitle(CFG.lang.get(name) + ": Top", -1, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4));
        tY += menuElements.get(menuElements.size()-1).getHeightE();
        menuElements.add(new Button_Build3(name, imageID, 0, tY, tempW, total));
        tY += menuElements.get(menuElements.size()-1).getHeightE();
        
        java.util.Collections.sort(list, new java.util.Comparator<BData>() {
            @Override public int compare(BData a, BData b) { return Integer.compare(b.num, a.num); }
        });
        
        for (int i = 0; i < Math.min(list.size(), 5); i++) {
            BData data = list.get(i);
            menuElements.add(new Button_NS_Population_Buildings(new Color((float)CFG.core.getCiv(data.id).getR() / 255.0f, (float)CFG.core.getCiv(data.id).getG() / 255.0f, (float)CFG.core.getCiv(data.id).getB() / 255.0f, 1.0f), (i+1) + ". " + CFG.core.getCiv(data.id).getCivName(), data.id, CFG.getNumberWthSpaces(""+data.num), "", imageID, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW, CFG.core.getCiv(data.id).getNumOfProvs()));
            tY += menuElements.get(menuElements.size()-1).getHeightE();
        }
        return tY;
    }

    @Override public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) { super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive); }
    @Override public void updateLang() {}
    @Override public void setVisibleM(boolean visible) { super.setVisibleM(visible); hideAnimation = !visible; }

    public class BData {
        int id, num;
        BData(int id, int num) { this.id = id; this.num = num; }
    }
}
