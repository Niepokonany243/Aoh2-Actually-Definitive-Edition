
package age.of.civilizations2.jakowski.lukasz.Menus.Assign.Select;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Active;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Assign_Select_Alphabet
extends Menu {
    private List<Character> lCharacters;

    public Menu_CreateScenario_Assign_Select_Alphabet() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic_Active(null, -1, 0, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        } else {
            menuElements.add(new Button_Classic_Classic(null, -1, 0, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }
        this.lCharacters = new ArrayList<Character>();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
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
                menuElements.add(new Button_Classic_Active("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_H * (i + 1), CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
                continue;
            }
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
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
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
        this.getTitleM().setText(CFG.lang.get("SelectCivilization"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.chosenAlphabetCharachter = null;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_ASSIGN_SELECT);
                return;
            }
        }
        CFG.chosenAlphabetCharachter = "" + this.lCharacters.get(iID - 1);
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_ASSIGN_SELECT);
    }
}

