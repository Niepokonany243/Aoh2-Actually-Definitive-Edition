/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Technology;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_TechnologyLevels
extends Menu_CreateScenario {
    private String sTopText;
    private int iStepWidth;

    public Menu_CreateScenario_TechnologyLevels() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Button_Game("-", -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Slider(CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H, 5, 100, 100){

            @Override
            public String getDrawText() {
                return CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getCivName() + this.getTextE() + (float)this.getCurr() / 100.0f;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(0.043137256f, 0.07058824f, 0.43137255f, 1.0f);
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.CIV_FLAG_WIDTH + CFG.PADD;
            }

            @Override
            public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (CFG.createScenarioAssignProvsCiv >= 0) {
                    oSB.setColor(Color.WHITE);
                    CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
                CFG.drawTextDefaultWithShadow(oSB, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.GAMEWIDTH - CFG.PADD - CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.getMenuElem(2).setVisibleE(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sTopText = CFG.lang.get("TechnologyLevels");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sTopText);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(4).setTextE(": ");
        super.updateLang();
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(6).setTextE(CFG.lang.get("ShowValues"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.sTopText, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, Color.WHITE);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(6).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(6).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(6).getWidthE() + CFG.PADD * 2, this.getMenuElem(6).getHeightE() + CFG.PADD * 2);
        CFG.drawEditorTitle_Bot_Edge_LR(oSB, iTranslateX, this.getMenuElem(3).getPosY() - CFG.PADD, CFG.GAMEWIDTH, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                this.onBackPressed();
                return;
            }
            case 3: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                if (CFG.createScenarioAssignProvsCiv > 0) {
                    CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).setTechLevel((float)this.getMenuElem(iID + 1).getCurr() / 100.0f);
                    CFG.core.getProv(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getCapitalProvID()).getArmyObject(0).updateArmyWidth(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getTechLevel());
                }
                return;
            }
            case 4: {
                if (CFG.createScenarioAssignProvsCiv > 0) {
                    CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).setTechLevel((float)this.getMenuElem(iID).getCurr() / 100.0f);
                    CFG.core.getProv(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getCapitalProvID()).getArmyObject(0).updateArmyWidth(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getTechLevel());
                }
                return;
            }
            case 5: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                if (CFG.createScenarioAssignProvsCiv > 0) {
                    CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).setTechLevel((float)this.getMenuElem(iID - 1).getCurr() / 100.0f);
                    CFG.core.getProv(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getCapitalProvID()).getArmyObject(0).updateArmyWidth(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getTechLevel());
                }
                return;
            }
            case 6: {
                boolean bl = CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                if (CFG.VIEW_SHOW_VALUES) {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        if (!CFG.core.getProv(i).isCapital()) continue;
                        CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getTechLevel());
                    }
                }
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_SETTINGS);
        if (CFG.createScenarioAssignProvsCiv > 0) {
            CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
        }
        CFG.core.setActiveProvID(-1);
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (!CFG.core.getProv(i).isCapital()) continue;
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }
}

