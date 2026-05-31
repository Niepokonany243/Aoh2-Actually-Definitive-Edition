/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Menu_RandomGame_Settings
extends Menu {
    public static long lTime = 0L;

    public Menu_RandomGame_Settings() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)((float)CFG.GAMEWIDTH * 0.8f);
        int tempHeight = CFG.BUTTON_H + CFG.PADD * 6 + CFG.BUTTON_H * 3 / 4 * 4;
        menuElements.add(new Button_InGameAction("-", -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, true));
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("Civilizations"), CFG.PADD * 3 + CFG.BUTTON_W, CFG.PADD, tempWidth - CFG.PADD * 4 - CFG.BUTTON_W * 2 - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, Menu_RandomGame_Settings.getCivMax(), CFG.randomGameManager.getCivilizationsSize()){

            @Override
            public int getWidthE() {
                return Menu_RandomGame_Settings.this.getW() - this.getPosXE() * 2;
            }

            @Override
            public int getPosXE() {
                return CFG.PADD * 3 + CFG.BUTTON_W;
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.PADD - CFG.BUTTON_W, CFG.PADD, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, true){

            @Override
            public int getPosXE() {
                return Menu_RandomGame_Settings.this.getW() - CFG.PADD - this.getWidthE();
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("StartingPopulation"), CFG.PADD * 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5), tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 1, 20000, CFG.core.getGameScenars().getScenario_StartingPopulation() / 100){

            @Override
            public String getDrawText() {
                return "" + this.getCurr() * 100;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_POP_GRADIENT[CFG.COLOR_POP_GRADIENT.length - 1].r, CFG.COLOR_POP_GRADIENT[CFG.COLOR_POP_GRADIENT.length - 1].g, CFG.COLOR_POP_GRADIENT[CFG.COLOR_POP_GRADIENT.length - 1].b, 0.65f);
            }

            @Override
            public void setCurr(int nCurrent) {
                CFG.core.getGameScenars().setScenarioStartingPopulation(nCurrent * 100);
                super.setCurr(nCurrent);
            }

            @Override
            public int getWidthE() {
                return Menu_RandomGame_Settings.this.getW() - this.getPosXE() * 2;
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("StartingEconomy"), CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5) * 2, tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 1, 10000, CFG.core.getGameScenars().getScenario_StartingEconomy() / 100){

            @Override
            public String getDrawText() {
                return "" + this.getCurr() * 100;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_ECONOMY_GRADIENT[CFG.COLOR_ECONOMY_GRADIENT.length - 1].r, CFG.COLOR_ECONOMY_GRADIENT[CFG.COLOR_ECONOMY_GRADIENT.length - 1].g, CFG.COLOR_ECONOMY_GRADIENT[CFG.COLOR_ECONOMY_GRADIENT.length - 1].b, 0.65f);
            }

            @Override
            public void setCurr(int nCurrent) {
                CFG.core.getGameScenars().setScenarioStartingEconomy(nCurrent * 100);
                super.setCurr(nCurrent);
            }

            @Override
            public int getWidthE() {
                return Menu_RandomGame_Settings.this.getW() - this.getPosXE() * 2;
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("StartingArmyInCapitals"), CFG.PADD * 2, CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5) * 3, tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 200, CFG.core.getGameScenars().getScenario_StartingArmyInCapitals() / 25){

            @Override
            public String getDrawText() {
                return "" + this.getCurr() * 25;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.65f);
            }

            @Override
            public void setCurr(int nCurrent) {
                CFG.core.getGameScenars().setScenarioStartingArmyInCapitals(nCurrent * 25);
                super.setCurr(nCurrent);
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_RandomGame_Settings.this.getW() - this.getPosXE() * 2;
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("NeutralArmy"), CFG.PADD * 2, CFG.PADD * 5 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5) * 4, tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 200, CFG.randomGameManager.getNeutralArmy() / 25){

            @Override
            public String getDrawText() {
                return "" + this.getCurr() * 25;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.65f);
            }

            @Override
            public void setCurr(int nCurrent) {
                CFG.randomGameManager.setNeutralArmy(nCurrent * 25);
                super.setCurr(nCurrent);
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_RandomGame_Settings.this.getW() - this.getPosXE() * 2;
            }
        });
        if (tempHeight > ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) {
            tempHeight = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM(CFG.lang.get("Settings"), CFG.BUTTON_H * 3 / 5, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + iTranslateX, nPosY - IMGManager.getIMG(Images.dialog_title).getHeight() - this.getHeightT(), nWidth - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT());
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - IMGManager.getIMG(Images.dialog_title).getHeight() - this.getHeightT(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT(), true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (this.getHeightT() - 2) * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, (this.getHeightT() - 2) * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, IMGManager.getIMG(Images.pix255).getHeight());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight() * 2, nWidth - 4, 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefaultWithShadow(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), CFG.COLOR_TEXT_GRAY_LEFT_NS);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, (CFG.GAMEWIDTH - (int)((float)CFG.GAMEWIDTH * 0.8f)) / 2, (CFG.GAMEHEIGHT * 4 / 5 - tempHeight - CFG.BUTTON_H * 3 / 5) / 2 > 0 ? (CFG.GAMEHEIGHT * 4 / 5 - tempHeight - CFG.BUTTON_H * 3 / 5) / 2 : CFG.PADD, tempWidth, tempHeight, menuElements, false, true);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            long tOld = this.getMenuElem(i).getCurr();
            this.getMenuElem(i).setCurr(-1);
            this.getMenuElem(i).setCurr(tOld);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + Core.PADDING * 2, -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, CFG.PADD);
            oSB.setColor(Color.WHITE);
            super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
            super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, CFG.PADD);
            oSB.setColor(Color.WHITE);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public int getW() {
        return this.getWidthM();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                CFG.randomGameManager.setCivilizationsSize((int)this.getMenuElem(iID + 1).getCurr());
                break;
            }
            case 1: {
                CFG.randomGameManager.setCivilizationsSize((int)this.getMenuElem(iID).getCurr());
                break;
            }
            case 2: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                CFG.randomGameManager.setCivilizationsSize((int)this.getMenuElem(iID - 1).getCurr());
                break;
            }
            case 3: {
                CFG.core.getGameScenars().setScenarioStartingPopulation(this.getMenuElem(iID).getCurr() * 100);
                break;
            }
            case 4: {
                CFG.core.getGameScenars().setScenarioStartingEconomy(this.getMenuElem(iID).getCurr() * 100);
                break;
            }
            case 5: {
                CFG.core.getGameScenars().setScenarioStartingArmyInCapitals(this.getMenuElem(iID).getCurr() * 25);
                break;
            }
            case 6: {
                CFG.randomGameManager.setNeutralArmy(this.getMenuElem(iID).getCurr() * 25);
            }
        }
    }

    public static final int getCivMax() {
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
            // empty catch block
        }
        int nNumOfPlayableProvinces = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            ++nNumOfPlayableProvinces;
        }
        return Math.min(nNumOfPlayableProvinces, tagsSPLITED.length + tagsSPLITED_ED.length);
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
    }
}

