/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateCivilization_Info
extends Menu {
    private String sName;
    private int iSRID = 0;

    public Menu_CreateCivilization_Info() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_CreateCivilization_Info.this.sName + ": " + super.getTextToDrawElem();
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 2 + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("", -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        this.iSRID = CFG.serviceRibbonMgr.getSRID(CFG.editorCivilization_GameData.sr_GameData.getSRTAG());
        int tempSRColorsSize = CFG.serviceRibbonMgr.getSR(CFG.editorCivilization_GameData.sr_GameData.getSRTAG()).getSize();
        for (i = 0; i < tempSRColorsSize; ++i) {
            menuElements.add(new Button_Classic(CFG.lang.get("ServiceRibbon") + " - " + CFG.lang.get("Color") + ": " + (i + 1), -1, 0, CFG.BUTTON_H * (4 + i) + CFG.PADD * (5 + i), CFG.GAMEWIDTH, CFG.BUTTON_H, true){
                int iCurrent;

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                    oSB.setColor(CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getR(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getG(), CFG.editorCivilization_GameData.sr_GameData.getColor(this.iCurrent).getB(), 1.0f);
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_CreateCivilization_Info.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU(), CFG.CIV_COLOR_W);
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        for (i = CFG.editorCivilization_GameData.sr_GameData.getColors().size(); i < tempSRColorsSize; ++i) {
            if (i == 0) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.9843137f, 0.015686275f, 0.0f));
                continue;
            }
            if (i == 1) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(1.0f, 1.0f, 1.0f));
                continue;
            }
            if (i == 2) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.15294118f, 0.3019608f, 0.60784316f));
                continue;
            }
            if (i == 3) {
                CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(0.08627451f, 0.14901961f, 0.4509804f));
                continue;
            }
            Color tempColor = CFG.getRandomColor();
            CFG.editorCivilization_GameData.sr_GameData.getColors().add(new Color_GameData(tempColor.r, tempColor.g, tempColor.b));
        }
        this.initMenu(null, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD * 2), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("CivilizationName");
        this.getMenuElem(1).setTextE(CFG.lang.get("Flag"));
        this.getMenuElem(2).setTextE(CFG.lang.get("CivilizationColor"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        ArrayList<Color> tempColors = new ArrayList<Color>();
        for (int i = 0; i < CFG.editorCivilization_GameData.sr_GameData.getColors().size(); ++i) {
            tempColors.add(new Color(CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getR(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getG(), CFG.editorCivilization_GameData.sr_GameData.getColors().get(i).getB(), 1.0f));
        }
        int tempWidth = CFG.SERVICE_RIBBON_WIDTH * 6 + CFG.PADD * 5;
        for (int j = 0; j < 6; ++j) {
            CFG.serviceRibbonMgr.drawSRLevel(oSB, CFG.GAMEWIDTH / 2 - tempWidth / 2 + (CFG.SERVICE_RIBBON_WIDTH + CFG.PADD) * j + iTranslateX, this.getMenuElem(4).getPosY() + this.getMenuElem(4).getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 + this.getMenuPosY(), j, 0, 0, this.iSRID, tempColors);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.showKeyboard();
                return;
            }
        }
    }
}

