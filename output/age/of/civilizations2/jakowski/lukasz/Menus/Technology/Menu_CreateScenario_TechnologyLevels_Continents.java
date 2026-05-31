
package age.of.civilizations2.jakowski.lukasz.Menus.Technology;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_TechnologyLevels_Continents
extends Menu {
    private List<Integer> lContinents = this.getContinentsOfCiv();

    public Menu_CreateScenario_TechnologyLevels_Continents() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.createScenarioAssignProvsCiv > 0) {
            this.lContinents = this.getContinentsOfCiv();
            for (int i = 0; i < this.lContinents.size(); ++i) {
                menuElements.add(new Slider_InGame_Clear(CFG.map.getMapRegions().getName(this.lContinents.get(i)), CFG.PADD * 2, CFG.PADD + tempElemH * i, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 5, 150, CFG.getCreateScenario_TechnologyLevelsByContinents_Continent(CFG.createScenarioAssignProvsCiv - 1, this.lContinents.get(i))){

                    @Override
                    public String getDrawText() {
                        return "" + (float)((int)(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getTechLevel() * (float)this.getCurr())) / 100.0f;
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.createScenarioAssignProvsCiv));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DevelopmentLevelIn", this.getTextE()) + ".", CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            this.menuElemHover = null;
                        }
                    }
                });
            }
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosX() - 2 + iTranslateX, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_CreateScenario_TechnologyLevels_Continents.this.getWidthM() + 2, this.getHeightT(), false, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_CreateScenario_TechnologyLevels_Continents.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_CreateScenario_TechnologyLevels_Continents.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Continents.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_CreateScenario_TechnologyLevels_Continents.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(tempElemH * menuElements.size(), CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H - CFG.PADD * 2), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Development"));
    }

    private final List<Integer> getContinentsOfCiv() {
        ArrayList<Integer> tempContinents = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getNumOfProvs(); ++i) {
            boolean addN = true;
            for (int j = 0; j < tempContinents.size(); ++j) {
                if (((Integer)tempContinents.get(j)).intValue() != CFG.core.getProv(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getProvID(i)).getRegion()) continue;
                addN = false;
                break;
            }
            if (!addN) continue;
            tempContinents.add(CFG.core.getProv(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getProvID(i)).getRegion());
        }
        return tempContinents;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        CFG.setCreateScenario_TechnologyLevelsByContinents_Continent(CFG.createScenarioAssignProvsCiv - 1, this.lContinents.get(iID), this.getMenuElem(iID).getCurr());
    }
}

