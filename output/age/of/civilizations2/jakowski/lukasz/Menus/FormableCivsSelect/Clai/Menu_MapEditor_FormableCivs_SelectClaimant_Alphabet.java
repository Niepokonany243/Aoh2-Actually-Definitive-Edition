
package age.of.civilizations2.jakowski.lukasz.Menus.FormableCivsSelect.Clai;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Active;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Search;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_MapEditor_FormableCivs_SelectClaimant_Alphabet
extends Menu {
    private List<Character> lCharacters;
    private String nSearch = null;

    public Menu_MapEditor_FormableCivs_SelectClaimant_Alphabet() {
        int a;
        boolean addChar;
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.nSearch = CFG.lang.get("Search");
        menuElements.add(new Button_Classic_Classic_Search("", CFG.PADD * 2, 0, CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Search"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_MapEditor_FormableCivs_SelectClaimant_Alphabet.this.nSearch + ": " + super.getTextToDrawElem();
            }
        });
        if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic_Active(null, -1, CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        } else {
            menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }
        FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        String[] tagsSPLITED_ED = new String[]{};
        try {
            FileHandle tempFileT_ED = null;
            tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
            String tempT_ED = tempFileT_ED.readString();
            tagsSPLITED_ED = tempT_ED.split(";");
        }
        catch (GdxRuntimeException tempFileT_ED) {
            
        }
        this.lCharacters = new ArrayList<Character>();
        int iSize = tagsSPLITED.length;
        for (i = 0; i < iSize; ++i) {
            if (CFG.isInFormableCivs(tagsSPLITED[i])) continue;
            addChar = true;
            for (a = 0; a < this.lCharacters.size(); ++a) {
                if (this.lCharacters.get(a).charValue() != CFG.lang.getCiv(tagsSPLITED[i]).charAt(0)) continue;
                addChar = false;
                break;
            }
            if (!addChar) continue;
            this.lCharacters.add(Character.valueOf(CFG.lang.getCiv(tagsSPLITED[i]).charAt(0)));
        }
        iSize = tagsSPLITED_ED.length;
        for (i = 0; i < iSize; ++i) {
            if (CFG.isInFormableCivs(tagsSPLITED_ED[i])) continue;
            addChar = true;
            for (a = 0; a < this.lCharacters.size(); ++a) {
                if (this.lCharacters.get(a).charValue() != CFG.lang.getCiv(tagsSPLITED_ED[i]).charAt(0)) continue;
                addChar = false;
                break;
            }
            if (!addChar) continue;
            this.lCharacters.add(Character.valueOf(CFG.lang.getCiv(tagsSPLITED_ED[i]).charAt(0)));
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
                menuElements.add(new Button_Classic_Active("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_H * (i + 1) + CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
                continue;
            }
            menuElements.add(new Button_Classic_Classic("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_H * (i + 1) + CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true));
        }
        if (((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() < CFG.GAMEWIDTH) {
            int tempElementWidth = (CFG.GAMEWIDTH - CFG.BUTTON_W * 2) / (menuElements.size() - 1);
            int tempPosX = 0;
            for (int i2 = 0; i2 < menuElements.size() - 1; ++i2) {
                if (i2 == 0) {
                    ((MenuElemUI)menuElements.get(i2)).setPosX(tempPosX);
                    ((MenuElemUI)menuElements.get(i2)).setWidthE(CFG.BUTTON_W * 2);
                    tempPosX += ((MenuElemUI)menuElements.get(i2)).getWidthE();
                    continue;
                }
                ((MenuElemUI)menuElements.get(i2)).setPosX(tempPosX);
                ((MenuElemUI)menuElements.get(i2)).setWidthE(tempElementWidth);
                tempPosX += ((MenuElemUI)menuElements.get(i2)).getWidthE();
            }
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setPosX(tempPosX);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setWidthE(CFG.GAMEWIDTH - tempPosX);
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        if (CFG.sSearch != null) {
            this.getMenuElem(0).setTextE(CFG.sSearch);
        }
        this.getMenuElem(1).setTextE("[" + CFG.lang.get("ALL") + "]");
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.showKeyboard();
                return;
            }
            case 1: {
                if (CFG.chosenAlphabetCharachter != null || CFG.sSearch != null) {
                    CFG.chosenAlphabetCharachter = null;
                    CFG.sSearch = null;
                    CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS_SELECT_CLAIMANT);
                }
                return;
            }
        }
        if (CFG.chosenAlphabetCharachter == null || CFG.sSearch != null || CFG.chosenAlphabetCharachter.charAt(0) != this.lCharacters.get(iID - 2).charValue()) {
            CFG.chosenAlphabetCharachter = "" + this.lCharacters.get(iID - 2);
            CFG.sSearch = null;
            CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS_SELECT_CLAIMANT);
        }
    }
}

