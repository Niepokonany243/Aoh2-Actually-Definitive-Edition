/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Relations;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Active;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_ManageDiplomacy_Relations_Alphabet
extends Menu {
    private List<Character> lCharacters;

    public Menu_ManageDiplomacy_Relations_Alphabet() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        String sSelectOnMap = CFG.lang.get("SelectOnMap");
        CFG.glyphLay.setText(CFG.fontMain.get(0), sSelectOnMap);
        int iSelectOnMapWidth = (int)CFG.glyphLay.width + CFG.PADD * 4;
        menuElements.add(new Button_Classic_Classic(null, -1, 0, CFG.PADD, iSelectOnMapWidth, CFG.BUTTON_H, true));
        if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic_Active(null, -1, iSelectOnMapWidth, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        } else {
            menuElements.add(new Button_Classic_Classic(null, -1, iSelectOnMapWidth, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        }
        this.lCharacters = new ArrayList<Character>();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID) continue;
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
            if (CFG.chosenAlphabetCharachter != null && this.lCharacters.get(i).charValue() == CFG.chosenAlphabetCharachter.charAt(0)) {
                menuElements.add(new Button_Classic_Active("[" + this.lCharacters.get(i) + "]", -1, iSelectOnMapWidth + CFG.BUTTON_H * (i + 1), CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
                continue;
            }
            menuElements.add(new Button_Classic_Classic("[" + this.lCharacters.get(i) + "]", -1, iSelectOnMapWidth + CFG.BUTTON_H * (i + 1), CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("SelectOnMap"));
        this.getMenuElem(1).setTextE("[" + CFG.lang.get("ALL") + "]");
        this.getTitleM().setText(CFG.lang.get("CustomizeRelations") + " " + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName());
    }

    @Override
    public void drawTitle(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive, int nPosY) {
        super.drawTitle(oSB, iTranslateX, iTranslateY, sliderMenuIsActive, nPosY);
        CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getFlagC().drawO(oSB, this.getWidthM() / 2 + this.getTitleM().getTextWidth() / 2 + CFG.PADD + iTranslateX, this.getTitleM().getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getWidthM() / 2 + this.getTitleM().getTextWidth() / 2 + CFG.PADD + iTranslateX, this.getTitleM().getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                return;
            }
            case 1: {
                if (CFG.chosenAlphabetCharachter != null) {
                    for (int i = 0; i < this.lCharacters.size(); ++i) {
                        if (this.lCharacters.get(i).charValue() != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                        this.setMenuElem(i + 2, new Button_Classic_Classic(this.getMenuElem(i + 2).getTextE(), -1, this.getMenuElem(i + 2).getPosXE(), this.getMenuElem(i + 2).getPosY(), this.getMenuElem(i + 2).getWidthE(), this.getMenuElem(i + 2).getHeightE(), true));
                        this.setMenuElem(iID, new Button_Classic_Active(this.getMenuElem(iID).getTextE(), -1, this.getMenuElem(iID).getPosXE(), this.getMenuElem(iID).getPosY(), this.getMenuElem(iID).getWidthE(), this.getMenuElem(iID).getHeightE(), true));
                        break;
                    }
                }
                CFG.chosenAlphabetCharachter = null;
                return;
            }
        }
        int toDisable = 0;
        if (CFG.chosenAlphabetCharachter == null) {
            toDisable = 1;
        } else {
            for (int i = 0; i < this.lCharacters.size(); ++i) {
                if (this.lCharacters.get(i).charValue() != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                toDisable = i + 2;
                break;
            }
        }
        this.setMenuElem(toDisable, new Button_Classic_Classic(this.getMenuElem(toDisable).getTextE(), -1, this.getMenuElem(toDisable).getPosXE(), this.getMenuElem(toDisable).getPosY(), this.getMenuElem(toDisable).getWidthE(), this.getMenuElem(toDisable).getHeightE(), true));
        this.setMenuElem(iID, new Button_Classic_Active(this.getMenuElem(iID).getTextE(), -1, this.getMenuElem(iID).getPosXE(), this.getMenuElem(iID).getPosY(), this.getMenuElem(iID).getWidthE(), this.getMenuElem(iID).getHeightE(), true));
        CFG.chosenAlphabetCharachter = "" + this.lCharacters.get(iID - 2);
    }
}

