/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Army;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Decline2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_Flag;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_SetUpArmy_Sliders
extends Menu {
    private List<Integer> lCivs = new ArrayList<Integer>();

    public Menu_CreateScenario_SetUpArmy_Sliders() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Long> tempArmies = new ArrayList<Long>();
        if (CFG.core.getProvSelected().getProvSize() == 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            for (i = 1; i < CFG.core.getProv(CFG.core.getActiveProvID()).getCivsSize(); ++i) {
                this.lCivs.add(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(i));
                tempArmies.add(CFG.core.getProv(CFG.core.getActiveProvID()).getArmyID(i));
            }
        } else {
            for (i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivsSize(); ++j) {
                    boolean tAdd = true;
                    for (int k = 0; k < this.lCivs.size(); ++k) {
                        if (this.lCivs.get(k).intValue() != CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId(j)) continue;
                        tAdd = false;
                        break;
                    }
                    if (!tAdd) continue;
                    this.lCivs.add(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId(j));
                    tempArmies.add(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getArmyID(j));
                }
            }
        }
        for (i = 0; i < this.lCivs.size(); ++i) {
            menuElements.add(new Slider_LR_Flag(this.lCivs.get(i), CFG.PADD, CFG.PADD + CFG.BUTTON_H * i + CFG.PADD * i, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD * 3, CFG.BUTTON_H, 0L, (long)(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID / 50), (long)((Long)tempArmies.get(i) / 50)){

                @Override
                public String getDrawText() {
                    return "" + this.getCurr() * 50;
                }
            });
            menuElements.add(new Button_Game_Decline2(CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD + CFG.BUTTON_H * i + CFG.PADD * i, true));
        }
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - (CFG.BUTTON_H + CFG.PADD * 2) * (this.lCivs.size() > 1 ? 2 : 1) + (this.lCivs.size() == 2 ? CFG.PADD : 0), CFG.GAMEWIDTH, (CFG.BUTTON_H + CFG.PADD * 2) * (this.lCivs.size() > 1 ? 2 : 1) + (this.lCivs.size() == 2 ? -CFG.PADD : 0), menuElements);
        if (this.lCivs.size() == 0) {
            this.setVisibleM(false);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - CFG.PADD - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), 1, true, false);
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
        if (iID % 2 == 0) {
            if (CFG.core.getProvSelected().getProvSize() == 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(this.lCivs.get(iID / 2), this.getMenuElem(iID).getCurr() * 50);
            } else {
                CFG.core.getProvSelected().updateArmies_CivID(this.lCivs.get(iID / 2), this.getMenuElem(iID).getCurr() * 50);
            }
        } else {
            this.getMenuElem(iID - 1).setCurr(0);
            if (CFG.core.getProvSelected().getProvSize() == 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(this.lCivs.get((iID - 1) / 2), this.getMenuElem(iID - 1).getCurr() * 50);
            } else {
                CFG.core.getProvSelected().updateArmies_CivID(this.lCivs.get((iID - 1) / 2), this.getMenuElem(iID - 1).getCurr() * 50);
            }
        }
    }
}

