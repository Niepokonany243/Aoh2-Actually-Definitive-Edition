
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle_VictoryConditions;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_VictoryConditions
extends Menu {
    public Menu_InGame_VictoryConditions(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.75f);
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 5 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 2;
        }
        this.initMenu(null, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, CFG.GAMEHEIGHT * 4 / 5, menuElements, false, false);
    }

    public Menu_InGame_VictoryConditions() {
        float nScore;
        boolean tRow = false;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosY = CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tempWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.5f);
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 2;
        }
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = CFG.isAndroid() ? CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 : CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2;
        int tY = 0;
        ArrayList<Integer> nData2 = new ArrayList<Integer>();
        ArrayList<Integer> nCivs2 = new ArrayList<Integer>();
        VictoryManager.domination_UpdateNumOfCivs();
        nData2.add(VictoryManager.domination_NumOfCivsInGame - VictoryManager.domination_CivScore(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nCivs2.add(0);
        nData2.add(VictoryManager.domination_CivScore(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nCivs2.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        tRow = !tRow;
        menuElements.add(new Graph_Circle_VictoryConditions(false, Images.diploWar, tRow, CFG.lang.get("Domination"), new Color(0.627451f, 0.09803922f, 0.078431375f, 1.0f), 2, tY, nData2, nCivs2, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), "" + CFG.getNumberWthSpaces("" + VictoryManager.domination_CivScore(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), " / " + CFG.getNumberWthSpaces("" + VictoryManager.domination_NumOfCivsInGame), "" + CFG.getPercentageOld(VictoryManager.domination_CivScore(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), VictoryManager.domination_NumOfCivsInGame, 4) + "%"){

            @Override
            public int getWidthE() {
                return Menu_InGame_VictoryConditions.this.getElementW() - 4;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Domination"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AnnihilateAllOfYourEnemies"), Color.WHITE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": ", Color.WHITE));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + VictoryManager.domination_CivScore(this.iCivID)), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int added = 0;
                for (int i = CFG.core.getCiv((int)this.iCivID).civGD.vassals.size() - 1; i >= 0 && added < 5; --i) {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)this.iCivID).civGD.vassals.get((int)i).iCivID).getNumOfProvs() <= 0) continue;
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)this.iCivID).civGD.vassals.get((int)i).iCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getCiv((int)this.iCivID).civGD.vassals.get((int)i).iCivID).getCivName(), Color.WHITE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    ++added;
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        ArrayList<Integer> nData = new ArrayList<Integer>();
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempCivs = new ArrayList<Integer>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            tempCivs.add(i);
        }
        while (tempCivs.size() > 0) {
            int tBest = 0;
            for (int j = 1; j < tempCivs.size(); ++j) {
                if (CFG.core.getCiv((Integer)tempCivs.get(j)).getNumOfProvs() <= CFG.core.getCiv((Integer)tempCivs.get(tBest)).getNumOfProvs()) continue;
                tBest = j;
            }
            tSorted.add((Integer)tempCivs.get(tBest));
            tempCivs.remove(tBest);
        }
        int nTotal = 0;
        for (int i = tSorted.size() - 1; i >= 0; --i) {
            nTotal += CFG.core.getCiv((Integer)tSorted.get(i)).getNumOfProvs();
            if (((Integer)tSorted.get(i)).intValue() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            tSorted.remove(i);
        }
        nData.add(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs());
        nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        int tRestScore = 0;
        for (int i = 0; i < tSorted.size(); ++i) {
            if ((float)CFG.core.getCiv((Integer)tSorted.get(i)).getNumOfProvs() / (float)nTotal > 0.015f) {
                nData.add(CFG.core.getCiv((Integer)tSorted.get(i)).getNumOfProvs());
                nCivs.add(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? (Integer)tSorted.get(i) : -((Integer)tSorted.get(i)).intValue());
                continue;
            }
            tRestScore += CFG.core.getCiv((Integer)tSorted.get(i)).getNumOfProvs();
        }
        if (tRestScore > 0) {
            nData.add(tRestScore);
            nCivs.add(0);
        }
        tRow = !tRow;
        menuElements.add(new Graph_Circle_VictoryConditions(false, Images.provinces, tRow, CFG.lang.get("ControlProvinces") + ": " + VictoryManager.VICTORY_CONTROL_PROVINCES_PERC + "%", new Color(0.09803922f, 0.23529412f, 0.43137255f, 1.0f), 2, tY, nData, nCivs, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), "" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs()), " / " + CFG.getNumberWthSpaces("" + (int)Math.ceil((float)nTotal * ((float)VictoryManager.VICTORY_CONTROL_PROVINCES_PERC / 100.0f))), CFG.getPercentageOld((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() / (float)nTotal, (float)VictoryManager.VICTORY_CONTROL_PROVINCES_PERC / 1.0f, 5) + "%"){

            @Override
            public int getWidthE() {
                return Menu_InGame_VictoryConditions.this.getElementW() - 4;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ControlProvinces"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": ", Color.WHITE));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        ArrayList<Integer> nData4 = new ArrayList<Integer>();
        ArrayList<Integer> nCivs4 = new ArrayList<Integer>();
        int tempBestCivID = VictoryManager.technology_BestCiv();
        nData4.add((int)(CFG.core.getCiv(tempBestCivID).getTechLevel() * 100.0f));
        nCivs4.add(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(tempBestCivID) ? tempBestCivID : -tempBestCivID);
        if (VictoryManager.VICTORY_TECHNOLOGY > 0.0f && (nScore = Math.max(0.0f, (VictoryManager.VICTORY_TECHNOLOGY - CFG.core.getCiv(tempBestCivID).getTechLevel()) * 100.0f)) > 0.0f) {
            nData4.add((int)Math.max(1.0f, nScore));
            nCivs4.add(0);
        }
        tRow = !tRow;
        menuElements.add(new Graph_Circle_VictoryConditions(VictoryManager.VICTORY_TECHNOLOGY == 0.0f, Images.technology, tRow, CFG.lang.get("Technology") + ": " + (float)((int)(VictoryManager.VICTORY_TECHNOLOGY * 100.0f)) / 100.0f, new Color(0.11764706f, 0.17254902f, 0.33333334f, 1.0f), 2, tY, nData4, nCivs4, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), "" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, " / " + (float)((int)(VictoryManager.VICTORY_TECHNOLOGY * 100.0f)) / 100.0f, "" + CFG.getPercentageOld(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel(), VictoryManager.VICTORY_TECHNOLOGY / 100.0f, 4) + "%"){

            @Override
            public int getWidthE() {
                return Menu_InGame_VictoryConditions.this.getElementW() - 4;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology"), this.disabled ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (!this.disabled) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": ", Color.WHITE));
                    nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(this.iCivID).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_TECHNOLOGY_MODE, true);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_TECHNOLOGY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Technology"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (VictoryManager.VICTORY_LIMIT_OF_TURNS > 0) {
            ArrayList<Integer> nData3 = new ArrayList<Integer>();
            ArrayList<Integer> nCivs3 = new ArrayList<Integer>();
            nData3.add(GameCalendar.TURNID);
            nCivs3.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            if (VictoryManager.VICTORY_LIMIT_OF_TURNS > 0) {
                nData3.add(VictoryManager.VICTORY_LIMIT_OF_TURNS - GameCalendar.TURNID);
                nCivs3.add(0);
            }
            tRow = !tRow;
            menuElements.add(new Graph_Circle_VictoryConditions(VictoryManager.VICTORY_LIMIT_OF_TURNS == 0, Images.time, tRow, CFG.lang.get("TurnsLimit") + ": " + VictoryManager.VICTORY_LIMIT_OF_TURNS, new Color(0.11764706f, 0.3137255f, 0.3137255f, 1.0f), 2, tY, nData3, nCivs3, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), "" + CFG.getNumberWthSpaces("" + GameCalendar.TURNID), " / " + CFG.getNumberWthSpaces("" + VictoryManager.VICTORY_LIMIT_OF_TURNS), "" + CFG.getPercentageOld(GameCalendar.TURNID, VictoryManager.VICTORY_LIMIT_OF_TURNS, 4) + "%"){

                @Override
                public int getWidthE() {
                    return Menu_InGame_VictoryConditions.this.getElementW() - 4;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsLimit"), this.disabled ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (!this.disabled) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Turn") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + GameCalendar.TURNID, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Text(" / " + VictoryManager.VICTORY_LIMIT_OF_TURNS, CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public void actionElem(int iID) {
                    if (CFG.menus.getVisibleInGame_Rank()) {
                        CFG.menus.setVisibleInGame_Rank(false);
                    } else {
                        CFG.menus.rebuildInGame_Rank();
                    }
                    CFG.toastM.addM(CFG.lang.get("Ranking"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + Core.PADDING * 2 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.25882354f, 0.32941177f, 0.4627451f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.25882354f, 0.32941177f, 0.4627451f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.425f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.325f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        int i = 0;
        int j = 0;
        while (i < this.getMenuElemsSize()) {
            this.getMenuElem(i).setCurr(j % 2);
            i += 2;
            ++j;
        }
    }

    @Override
    public void updateLang() {
        try {
            this.getTitleM().setText(CFG.lang.get("VictoryConditions"));
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getElementW() {
        return this.getW();
    }
}

