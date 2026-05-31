
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.Difficulty_Level;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Horizontal;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_DiplomacyORActions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextCivInfo;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Happiness;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Icon;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Ideology;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Religion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilization_Info_Stats
extends Menu {
    public Menu_Civilization_Info_Stats() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2 + 2, CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextLeftSide_Icon("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, CFG.PADD * 2, Images.pop){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_POPULATION) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2 + 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD)){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextLeftSide_Icon("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD), Images.city){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2 + 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LargestCity(Menu_Civilization_Info_Stats.this.getMenuElem(7).getCurr());
            }
        });
        menuElements.add(new TextLeftSide("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){
            int iCurrent;

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LargestCity(this.getCurr());
            }
        });
        ArrayList<Long> lData = new ArrayList<Long>();
        ArrayList<Integer> lCivs = new ArrayList<Integer>();
        lData.add(18L);
        lCivs.add(1);
        lData.add(7L);
        lCivs.add(2);
        menuElements.add(new Graph_Circle(IMGManager.getIMG(Images.noLeader).getWidth() + CFG.PADD * 3 + 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD, lData, lCivs, null){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }
        });
        int tier2_H = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tier2_W = (CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 4 - 2 - CFG.PADD * 2) / 3;
        menuElements.add(new TextIcon_Horizontal("3.2", CFG.FONT_BOLD_SMALL, Images.topMovementPoints, CFG.PADD * 2 + tier2_W * 2 + CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_MOVEMENT_ACTIVE : (this.getIsHovered() ? CFG.COLOR_MOVEMENT_HOVER : CFG.COLOR_MOVEMENT);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MovementPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.core.getCiv(CFG.getActiveCivInfoId()).getMovemPoints() / 10.0f, CFG.COLOR_MOVEMENT));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseValue") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (float)CFG.gameAction.getMovementPoints_BaseValue(CFG.getActiveCivInfoId()) / 10.0f, CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationSize") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0.84", CFG.FONT_BOLD_SMALL, Images.technology, CFG.PADD * 2 + tier2_W + CFG.PADD, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_TechnologyLevel(CFG.getActiveCivInfoId());
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TECHNOLOGY);
            }
        });
        menuElements.add(new TextCivInfo("", CFG.PADD * 2 + 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 4 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 3){

            @Override
            public boolean getVisibleE() {
                return false;
            }
        });
        menuElements.add(new TextIcon_Horizontal("11k", CFG.FONT_BOLD_SMALL, Images.economy, CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_ECONOMY_ACTIVE : (this.getIsHovered() ? CFG.COLOR_ECONOMY_HOVER : CFG.COLOR_ECONOMY);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.getActiveCivInfoId()).countEco()), CFG.COLOR_ECONOMY));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        });
        menuElements.add(new Text(null, -1, 0, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 5 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 4, CFG.CIV_INFO_MENU_WIDTH, Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - 2, this.getHeightE());
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        menuElements.add(new Difficulty_Level(IMGManager.getIMG(Images.difficultyHeaven).getWidth() + CFG.PADD * 3 + 2, CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 6 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 6 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) + Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), CFG.CIV_INFO_MENU_WIDTH - (IMGManager.getIMG(Images.difficultyHeaven).getWidth() + CFG.PADD * 3 + 2) - IMGManager.getIMG(Images.difficultyHell).getWidth() - CFG.PADD * 3, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 3 - CFG.PADD * 4, 0.65f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DifficultyLevel") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + this.getCurr() + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.difficultyHeaven).drawO(oSB, this.getPosXE() - CFG.PADD - IMGManager.getIMG(Images.difficultyHeaven).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.difficultyHeaven).getHeight() / 2 + iTranslateY);
                IMGManager.getIMG(Images.difficultyHell).drawO(oSB, this.getPosXE() + this.getWidthE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.difficultyHell).getHeight() / 2 + iTranslateY);
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }
        });
        menuElements.add(new TextLeftSide_Happiness("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 3 - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextLeftSide_Ideology("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 2 - CFG.PADD){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextLeftSide_Religion("", CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.religionManager.getReligionHover(this.getCurr());
            }
        });
        menuElements.add(new Button_Transparent(0, 0, CFG.CIV_INFO_MENU_WIDTH, ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getHeightE() + CFG.PADD, true));
        this.initMenu(null, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH, (Menu_Civilization_Info.getUseMenu_UI2() ? Menu_Civilization_Info.getMenuY_UI2() + Menu_Civilization_Info.getMenuH_UI2() : IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, CFG.CIV_INFO_MENU_WIDTH, CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 7 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 8 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) + Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), menuElements, false, false);
        this.updateLang();
        try {
            float fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)IMGManager.getIMG(Images.noLeader).getHeight();
            this.getMenuElem(6).setPosX((int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale + (float)(CFG.PADD * 2)));
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Capital"));
        this.getMenuElem(4).setTextE(CFG.lang.get("LargestCity"));
        this.getMenuElem(11).setTextE(CFG.lang.get("Difficulty"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        CFG.drawRect_InfoBox_Right(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(1).getPosXE() - this.getMenuElem(0).getPosXE() + this.getMenuElem(1).getWidthE() + CFG.PADD * 2, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2);
        try {
            if (!CFG.activeCivLeader.isEmpty()) {
                if (CFG.leaderTime + CFG.leaderFrame < CFG.currentTimeMillis) {
                    CFG.leaderTime = CFG.currentTimeMillis;
                    if (++CFG.leaderFrameID >= CFG.leaderFrameSize) {
                        CFG.leaderFrameID = 0;
                    }
                }
                try {
                    float fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)CFG.activeCivLeader.get(CFG.leaderFrameID).getHeight();
                    CFG.activeCivLeader.get(CFG.leaderFrameID).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + 1 + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.575f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), CFG.PADD);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + (this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2) - CFG.PADD + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), CFG.PADD, false, true);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale) - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2, true, false);
                    oSB.setColor(new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.175f));
                    CFG.drawRect(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale) - 1, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    oSB.setColor(Color.WHITE);
                }
                catch (Exception fScale) {}
            } else {
                float fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)IMGManager.getIMG(Images.noLeader).getHeight();
                IMGManager.getIMG(Images.noLeader).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + 1 + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.575f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), CFG.PADD);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + (this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2) - CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), CFG.PADD, false, true);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale) - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2, true, false);
                oSB.setColor(new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.175f));
                CFG.drawRect(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale) - 1, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (Exception exception) {
            
        }
        CFG.drawRect_InfoBox_Right(oSB, this.getPosX() + CFG.PADD + 2 + iTranslateX, this.getMenuPosY() + this.getMenuElem(10).getPosY() - CFG.PADD + iTranslateY, this.getWidthM() - CFG.PADD * 2 - 2, this.getMenuElem(10).getHeightE() + CFG.PADD * 2);
        CFG.drawRect_InfoBox_Right(oSB, this.getPosX() + CFG.PADD + 2 + iTranslateX, this.getMenuPosY() + this.getMenuElem(12).getPosY() - CFG.PADD + iTranslateY, this.getWidthM() - CFG.PADD * 2 - 2, this.getMenuElem(12).getHeightE() + CFG.PADD * 2);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_CreateNewGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: 
            case 1: {
                break;
            }
            case 2: 
            case 3: {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                break;
            }
            case 4: 
            case 5: {
                int nLargestCity = CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(0);
                for (int i = 1; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs(); ++i) {
                    if (CFG.core.getProv(nLargestCity).getPop().getPops() >= CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i)).getPop().getPops()) continue;
                    nLargestCity = CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i);
                }
                CFG.map.getMpC().centerToProvID(nLargestCity);
                CFG.core.setActiveProvID(nLargestCity);
                break;
            }
        }
    }
}

