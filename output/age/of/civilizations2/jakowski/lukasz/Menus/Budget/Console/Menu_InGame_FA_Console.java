/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Budget.Console;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Console.Commands;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_FA_Console
extends Menu {
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public Menu_InGame_FA_Console() {
        int tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 5;
        int tempWidth = Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4;
        tempHeight = (int)((float)tempHeight * 0.375f);
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(CFG.PADD * 2, CFG.PADD * 2, tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT * 300, true));
        menuElements.add(new Button_Transparent(0, 0, tempWidth, tempHeight, true));
        this.initMenu(null, CFG.PADD * 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4, tempWidth, tempHeight, menuElements, false, false);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM(), false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM(), true, true);
        oSB.setColor(SparksAnimation.sparksColors2);
        this.sparksAnimation.draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, CFG.BUTTON_H / 4);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, CFG.BUTTON_H / 4, this.getHeightM() - 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.1f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - CFG.PADD * 2, this.getHeightM() - CFG.PADD * 2);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.15f));
        IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 5 - IMGManager.getIMG(Images.gameLogo).getWidth() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD * 5 - IMGManager.getIMG(Images.gameLogo).getHeight() + iTranslateY);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() - CFG.PADD - 1 + iTranslateY, this.getWidthM() - CFG.PADD * 2, 1);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.675f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM() - CFG.PADD - 1 + iTranslateY, this.getWidthM() - CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        Rectangle clipBounds = new Rectangle(this.getPosX() + CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - (this.getPosY() + CFG.PADD) - iTranslateY, this.getWidthM() - CFG.PADD * 2, -(this.getHeightM() - CFG.PADD * 2));
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        int i22 = Commands.sConsole.size() - 1;
        int j = 0;
        while (i22 >= 0) {
            Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, Commands.sConsole.get(i22), this.getPosX() + this.getMenuElem(0).getPosXE() + CFG.PADD + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuPosY() + CFG.TEXT_HEIGHT_DEFAULT * j + CFG.PADD * j + CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
            --i22;
            ++j;
        }
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException e) {
            // empty catch block
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        if (Commands.lFlagsParty.size() > 0) {
            for (int i = 0; i < Commands.lFlagsParty.size(); ++i) {
                CFG.core.getCiv(i % CFG.core.getCivsSize()).getFlagC().drawO(oSB, (Math.abs(CFG.map.getMpC().getPX()) + Commands.lFlagsParty.get(i).getPX()) % CFG.GAMEWIDTH - CFG.core.getCiv(0).getFlagC().getWidth() / 2, (Math.abs(CFG.map.getMpC().getPY()) + Commands.lFlagsParty.get(i).getPY()) % CFG.GAMEHEIGHT - CFG.core.getCiv(0).getFlagC().getHeight() / 2);
            }
            if (Commands.lFlagsPartyTime + 12500L < System.currentTimeMillis()) {
                Commands.lFlagsParty.clear();
            }
            CFG.setRenderO(true);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX - CFG.PADD, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        Commands.lFlagsParty.clear();
    }
}

