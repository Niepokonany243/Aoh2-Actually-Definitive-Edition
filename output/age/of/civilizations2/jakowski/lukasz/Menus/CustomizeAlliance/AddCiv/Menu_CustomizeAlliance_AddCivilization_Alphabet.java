/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CustomizeAlliance.AddCiv;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import java.util.ArrayList;
import java.util.List;

public class Menu_CustomizeAlliance_AddCivilization_Alphabet
extends Menu {
    private List<Character> lCharacters;

    public Menu_CustomizeAlliance_AddCivilization_Alphabet() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_Classic(null, -1, 0, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        this.lCharacters = new ArrayList<Character>();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getAlliance() != 0) continue;
            boolean addChar = true;
            for (int a = 0; a < this.lCharacters.size(); ++a) {
                if (this.lCharacters.get(a).charValue() != CFG.core.getCiv(i).getCivName().charAt(0)) continue;
                addChar = false;
                break;
            }
            if (!addChar) continue;
            this.lCharacters.add(Character.valueOf(CFG.core.getCiv(i).getCivName().charAt(0)));
        }
        for (i = 0; i < this.lCharacters.size() - 1; ++i) {
            for (int j = i + 1; j < this.lCharacters.size(); ++j) {
                if (this.lCharacters.get(i).charValue() <= this.lCharacters.get(j).charValue()) continue;
                char temp = this.lCharacters.get(i).charValue();
                this.lCharacters.set(i, this.lCharacters.get(j));
                this.lCharacters.set(j, Character.valueOf(temp));
            }
        }
        for (i = 0; i < this.lCharacters.size(); ++i) {
            menuElements.add(new Button_Classic_Classic("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_H * (i + 1), CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        }
        if (((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() < CFG.GAMEWIDTH) {
            int tempElementWidth = CFG.GAMEWIDTH / menuElements.size();
            int tempPosX = 0;
            for (int i2 = 0; i2 < menuElements.size() - 1; ++i2) {
                ((MenuElemUI)menuElements.get(i2)).setPosX(tempPosX);
                ((MenuElemUI)menuElements.get(i2)).setWidthE(tempElementWidth);
                tempPosX += tempElementWidth;
            }
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setPosX(tempPosX);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setWidthE(CFG.GAMEWIDTH - tempPosX);
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE("[" + CFG.lang.get("ALL") + "]");
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.chosenAlphabetCharachter = null;
                CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE_ADD_CIVILIZATION);
                return;
            }
        }
        CFG.chosenAlphabetCharachter = "" + this.lCharacters.get(iID - 1);
        CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE_ADD_CIVILIZATION);
    }
}

