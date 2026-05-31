/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs.Edit;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Workshop_Load
extends Menu {
    public int iStepID = 0;
    public int iNumOfSteps = 3600;
    public static boolean uploaded = false;

    public Menu_Workshop_Load() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Progress") + " #0");
        this.getTitleM().setText(CFG.lang.get("SteamWorkshop") + ": " + CFG.lang.get("Publish"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.loadAction();
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public final void loadAction() {
        try {
            this.getMenuElem(0).setTextE(CFG.lang.get("Progress") + " #" + this.iStepID);
            if (uploaded) {
                CFG.menus.setMenuIDWithoutAnim(View.eEDITOR);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        ++this.iStepID;
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }
}

