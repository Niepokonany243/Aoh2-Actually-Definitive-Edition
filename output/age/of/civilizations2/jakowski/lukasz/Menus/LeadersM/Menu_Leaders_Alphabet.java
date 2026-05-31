/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.LeadersM;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Active;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Search;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Leader_GameData;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Leaders_Alphabet
extends Menu {
    private List<Character> lCharacters;
    private String nSearch = null;

    public Menu_Leaders_Alphabet() {
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
                return Menu_Leaders_Alphabet.this.nSearch + ": " + super.getTextToDrawElem();
            }
        });
        if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic_Active(null, -1, CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("All"), CFG.COLOR_HOVER_TITLE));
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
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("All"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }
        try {
            int i;
            String[] tagsSPLITED = null;
            if (CFG.getIsDesktop()) {
                int i2;
                List<String> tempFiles = CFG.getFileNames_O("game/leaders/");
                int iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i2);
                    break;
                }
                tagsSPLITED = new String[tempFiles.size()];
                iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    tagsSPLITED[i2] = tempFiles.get(i2);
                }
            } else {
                FileHandle tempFileT = FileManager.loadFile("game/leaders/Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
            }
            this.lCharacters = new ArrayList<Character>();
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                boolean addChar = true;
                try {
                    FileHandle file;
                    try {
                        file = Gdx.files.local("game/leaders/" + tagsSPLITED[i]);
                        CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                    }
                    catch (GdxRuntimeException ex) {
                        file = FileManager.loadFile("game/leaders/" + tagsSPLITED[i]);
                        CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                    }
                }
                catch (Exception ex) {
                    // empty catch block
                }
                if (CFG.leaderGameData.getLeaderOfCiv().getName().length() <= 0) continue;
                for (int a = 0; a < this.lCharacters.size(); ++a) {
                    if (this.lCharacters.get(a).charValue() != CFG.leaderGameData.getLeaderOfCiv().getName().charAt(0)) continue;
                    addChar = false;
                    break;
                }
                if (!addChar) continue;
                this.lCharacters.add(Character.valueOf(CFG.leaderGameData.getLeaderOfCiv().getName().charAt(0)));
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
                for (int i3 = 0; i3 < menuElements.size() - 1; ++i3) {
                    if (i3 == 0) {
                        ((MenuElemUI)menuElements.get(i3)).setPosX(tempPosX);
                        ((MenuElemUI)menuElements.get(i3)).setWidthE(CFG.BUTTON_W * 2);
                        tempPosX += ((MenuElemUI)menuElements.get(i3)).getWidthE();
                        continue;
                    }
                    ((MenuElemUI)menuElements.get(i3)).setPosX(tempPosX);
                    ((MenuElemUI)menuElements.get(i3)).setWidthE(tempElementWidth);
                    tempPosX += ((MenuElemUI)menuElements.get(i3)).getWidthE();
                }
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setPosX(tempPosX);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setWidthE(CFG.GAMEWIDTH - tempPosX);
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
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
                    CFG.menus.setMenuID(View.eGAME_LEADERS);
                }
                return;
            }
        }
        if (CFG.chosenAlphabetCharachter == null || CFG.sSearch != null || CFG.chosenAlphabetCharachter.charAt(0) != this.lCharacters.get(iID - 2).charValue()) {
            CFG.chosenAlphabetCharachter = "" + this.lCharacters.get(iID - 2);
            CFG.sSearch = null;
            CFG.menus.setMenuID(View.eGAME_LEADERS);
        }
    }
}

