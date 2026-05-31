/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Army;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_SetUpArmy_Civs
extends Menu {
    private List<Integer> lCivs = new ArrayList<Integer>();

    private final void addCiv(int nCivID) {
        for (int i = 0; i < this.lCivs.size(); ++i) {
            if (this.lCivs.get(i) != nCivID) continue;
            return;
        }
        this.lCivs.add(nCivID);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public Menu_CreateScenario_SetUpArmy_Civs() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH * 4 / 5;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.core.getProvSelected().getProvSize() == 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                this.lCivs.add(CFG.core.getSortedCivsAZ(i - 1));
            }
        } else {
            for (i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                int j;
                if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()).getAlliance() > 0) {
                    for (j = 0; j < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()).getAlliance()).getCivilizationsSize(); ++j) {
                        this.addCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()).getAlliance()).getCivilization(j));
                    }
                }
                if (CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()).getPuppetOfCiv()) {
                    this.addCiv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()).getPuppetOfCiv());
                }
                for (j = 1; j < CFG.core.getCivsSize(); ++j) {
                    if (CFG.core.getCiv(j).getPuppetOfCiv() != CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId()) continue;
                }
            }
        }
        for (i = 0; i < this.lCivs.size(); ++i) {
            menuElements.add(new Button_In_Game_Box_CivID(this.lCivs.get(i), CFG.core.getCiv(this.lCivs.get(i)).getCivName(), CFG.PADD, CFG.PADD, i > 0 ? ((MenuElemUI)menuElements.get(i - 1)).getPosY() + ((MenuElemUI)menuElements.get(i - 1)).getHeightE() + CFG.PADD : CFG.PADD, tempW - CFG.PADD * 2, true));
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + 2 + Core.PADDING, this.getHeightT() + Core.PADDING);
                oSB.setColor(new Color(0.23529412f, 0.3137255f, 0.4117647f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.23529412f, 0.3137255f, 0.4117647f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD + CFG.BUTTON_H * 3 / 4, tempW, Math.min(menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD : CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H / 2) - CFG.BUTTON_H * 2 - CFG.PADD * 4 - CFG.BUTTON_H - CFG.PADD * 2), menuElements, true, true);
        if (this.lCivs.size() == 0) {
            this.setVisibleM(false);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Civilizations"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 4 + Core.PADDING, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM() + 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        boolean rebuildSliders = false;
        if (CFG.core.getProvSelected().getProvSize() == 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            if (this.tryAddArmy(CFG.core.getActiveProvID(), this.getMenuElem(iID).getCurr())) {
                rebuildSliders = true;
            }
        } else {
            for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                if (!this.tryAddArmy(CFG.core.getProvSelected().getProv(i), this.getMenuElem(iID).getCurr())) continue;
                rebuildSliders = true;
            }
        }
        if (rebuildSliders) {
            CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
        }
    }

    private final boolean tryAddArmy(int nProvinceID, int nCivID) {
        if (CFG.core.getProv(nProvinceID).getSeaProv()) {
            if (CFG.core.getProv(nProvinceID).getArmyCivID1(nCivID) == 0) {
                CFG.core.getProv(nProvinceID).updateArmy4(nCivID, 500);
                return true;
            }
        } else {
            boolean addArmy = false;
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() == CFG.core.getCiv(nCivID).getAlliance()) {
                addArmy = true;
            }
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() == nCivID) {
                addArmy = true;
            }
            if (addArmy && CFG.core.getProv(nProvinceID).getArmyCivID1(nCivID) == 0) {
                CFG.core.getProv(nProvinceID).updateArmy4(nCivID, 500);
                return true;
            }
        }
        return false;
    }
}

