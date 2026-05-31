
package age.of.civilizations2.jakowski.lukasz.Menus.RTO;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.RTO.Menu_InGame_RTO2;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_RTO_Bot2
extends Menu {
    public Menu_InGame_RTO_Bot2() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        String tempText = "";
        ArrayList<Integer> lSortedPos = new ArrayList<Integer>();
        ArrayList<Integer> lPos = new ArrayList<Integer>();
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() > 0) {
                lSortedPos.add(CFG.core.getRTO().getPositionInRTOOfCiv(CFG.core.getPlayer(i).getCivId()));
                lPos.add(i);
                continue;
            }
            lSortedPos.add(-1);
            lPos.add(i);
        }
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            for (int j = i; j < CFG.core.getPlayersSize(); ++j) {
                if ((Integer)lSortedPos.get((Integer)lPos.get(i)) <= (Integer)lSortedPos.get((Integer)lPos.get(j))) continue;
                int tempA = (Integer)lPos.get(i);
                lPos.set(i, (Integer)lPos.get(j));
                lPos.set(j, tempA);
            }
        }
        for (i = 0; i < lPos.size(); ++i) {
            if (CFG.core.getCiv(CFG.core.getPlayer((Integer)lPos.get(i)).getCivId()).getNumOfProvs() <= 0) continue;
            tempText = tempText + CFG.core.getCiv(CFG.core.getPlayer((Integer)lPos.get(i)).getCivId()).getCivName() + ": " + CFG.core.getRTO().getPositionInRTOOfCiv(CFG.core.getPlayer((Integer)lPos.get(i)).getCivId()) + " - ";
        }
        menuElements.add(new TextScrollable(CFG.lang.get("Position") + ": [" + tempText.substring(0, tempText.length() - 3 > 0 ? tempText.length() - 3 : tempText.length()) + "]", CFG.PADD * 2, CFG.PADD * 2, tempW - CFG.PADD * 2, CFG.COLOR_TEXT_CIV_INFO_TITLE, 0.8f));
        this.initMenu(null, CFG.GAMEWIDTH - tempW, 0, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_RTO2.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_RTO2.lTime) / 250.0f));
        }
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM(), false, true);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM() - 4);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }
}

