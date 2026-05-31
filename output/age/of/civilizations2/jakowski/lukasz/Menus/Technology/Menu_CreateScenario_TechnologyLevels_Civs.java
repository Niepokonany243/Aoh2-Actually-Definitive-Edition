
package age.of.civilizations2.jakowski.lukasz.Menus.Technology;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_TechnologyLevels_Civs
extends Menu {
    private List<Integer> lCivs;

    public Menu_CreateScenario_TechnologyLevels_Civs() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivs = new ArrayList<Integer>();
        ArrayList<Integer> tempCivs = new ArrayList<Integer>();
        for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
            tempCivs.add(i2);
        }
        while (tempCivs.size() > 0) {
            int tBest = 0;
            for (i = 1; i < tempCivs.size(); ++i) {
                if (!(CFG.core.getCiv((Integer)tempCivs.get(i)).getTechLevel() > CFG.core.getCiv((Integer)tempCivs.get(tBest)).getTechLevel())) continue;
                tBest = i;
            }
            this.lCivs.add((Integer)tempCivs.get(tBest));
            tempCivs.remove(tBest);
        }
        int tY = CFG.PADD;
        for (i = 0; i < this.lCivs.size(); ++i) {
            menuElements.add(new Text(CFG.core.getCiv(this.lCivs.get(i)).getCivName(), -1, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                    CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                    CFG.fontMain.get(0).getData().setScale(0.6f);
                    CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.6f) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.6f) / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
                    CFG.fontMain.get(0).getData().setScale(1.0f);
                }
            });
            menuElements.add(new Slider_InGame_Clear(CFG.core.getCiv(this.lCivs.get(i)).getCivName(), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 5, 100, (int)(CFG.core.getCiv(this.lCivs.get(i)).getTechLevel() * 100.0f)){

                @Override
                public String getDrawText() {
                    return "" + (float)this.getCurr() / 100.0f;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosX() - 2 + iTranslateX, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_CreateScenario_TechnologyLevels_Civs.this.getWidthM() + 2, this.getHeightT(), false, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_CreateScenario_TechnologyLevels_Civs.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_CreateScenario_TechnologyLevels_Civs.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosX() + iTranslateX, Menu_CreateScenario_TechnologyLevels_Civs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_CreateScenario_TechnologyLevels_Civs.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(tempElemH * menuElements.size(), CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H - CFG.PADD * 2), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("TechnologyLevel"));
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
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
        if (iID % 2 == 1) {
            CFG.core.getCiv(this.lCivs.get(iID / 2)).setTechLevel((float)this.getMenuElem(iID).getCurr() / 100.0f);
        } else if (CFG.core.getCiv(this.lCivs.get(iID / 2)).getCapitalProvID() >= 0) {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.lCivs.get(iID / 2)).getCapitalProvID());
        }
    }
}

