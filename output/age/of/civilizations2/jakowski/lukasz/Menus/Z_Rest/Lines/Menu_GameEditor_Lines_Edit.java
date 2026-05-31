
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Lines;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_GameEditor_Lines_Edit
extends Menu {
    private String sName = null;

    public Menu_GameEditor_Lines_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_GameEditor_Lines_Edit.this.sName + ": \"" + super.getTextToDrawElem() + ".png\"";
            }
        });
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * 2 + CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.BUTTON_H, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.editorLine_GameData.getRapeatImage();
            }

            @Override
            public String getTextToDrawElem() {
                return super.getTextToDrawElem() + ": " + this.getCheckboxSt();
            }
        });
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * 3 + CFG.BUTTON_H * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.editorLine_GameData.getFlipX();
            }

            @Override
            public String getTextToDrawElem() {
                return super.getTextToDrawElem() + ": " + this.getCheckboxSt();
            }
        });
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * 4 + CFG.BUTTON_H * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.editorLine_GameData.getMovable();
            }

            @Override
            public String getTextToDrawElem() {
                return super.getTextToDrawElem() + ": " + this.getCheckboxSt();
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG(null, -1, CFG.GAMEWIDTH / 2, CFG.PADD, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.getMenuElem(this.getMenuElemsSize() - 1).setPosY(this.getMenuElem(0).getPosY());
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("ImageName");
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.editorLine_GameData.getImageName());
        this.getMenuElem(2).setTextE(CFG.lang.get("Repeat"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Flip") + "X");
        this.getMenuElem(4).setTextE(CFG.lang.get("Moveable"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Save"));
        this.getTitleM().setText(CFG.lang.get("AddNewStyle"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.showKeyboard();
                return;
            }
            case 2: {
                CFG.editorLine_GameData.setReapeatImage(!CFG.editorLine_GameData.getRapeatImage());
                return;
            }
            case 3: {
                CFG.editorLine_GameData.setFlipX(!CFG.editorLine_GameData.getFlipX());
                return;
            }
            case 4: {
                CFG.editorLine_GameData.setMovable(!CFG.editorLine_GameData.getMovable());
                return;
            }
            case 5: {
                if (this.getMenuElem(1).getTextE().length() > 0) {
                    CFG.editorLine_GameData.setImageName(this.getMenuElem(1).getTextE());
                    CFG.core.saveLinesData();
                    this.onBackPressed();
                } else {
                    CFG.showKeyboard(1);
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR_LINES);
        CFG.menus.setBackAnimation(true);
    }
}

