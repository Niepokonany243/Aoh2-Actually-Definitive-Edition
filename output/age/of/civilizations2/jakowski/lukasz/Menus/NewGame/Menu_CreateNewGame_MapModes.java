/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModes;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModes2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_CreateNewGame_MapModes
extends Menu {
    public static final int ANIMATION_TIME = 155;
    private long lTime = 0L;

    public Menu_CreateNewGame_MapModes() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempElemH = Math.max(CFG.BUTTON_H * 4 / 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6);
        for (int i = 0; i < 7; ++i) {
            if (i % 2 == 0) {
                menuElements.add(new Button_Opt_MapModes(-2, null, -1, CFG.PADD * 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true){

                    @Override
                    public int getWidthE() {
                        return Menu_CreateNewGame_MapModes.this.getW();
                    }
                });
                continue;
            }
            menuElements.add(new Button_Opt_MapModes2(-2, null, -1, CFG.PADD * 2, tempElemH * i, CFG.BUTTON_W - CFG.PADD * 4, tempElemH, true, true){

                @Override
                public int getWidthE() {
                    return Menu_CreateNewGame_MapModes.this.getW();
                }
            });
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.0f, 0.21960784f, 0.61960787f, 0.075f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.0f, 0.21960784f, 0.61960787f, 0.175f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, -1, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, Math.min(Math.min(tempElemH * 5 + tempElemH / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H), menuElements.size() * tempElemH), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("MapModes"));
        this.getMenuElem(0).setTextE(CFG.lang.get("Political"));
        this.getMenuElem(0).setCurr(-1);
        this.getMenuElem(1).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(1).setCurr(MapModesManager.VIEW_POPULATION_MODE);
        this.getMenuElem(2).setTextE(CFG.lang.get("Economy"));
        this.getMenuElem(2).setCurr(MapModesManager.VIEW_ECONOMY_MODE);
        this.getMenuElem(3).setTextE(CFG.lang.get("Diplomacy"));
        this.getMenuElem(3).setCurr(MapModesManager.VIEW_DIPLOMACY_MODE);
        this.getMenuElem(4).setTextE(CFG.lang.get("GrowthRate"));
        this.getMenuElem(4).setCurr(MapModesManager.VIEW_GROWTH_RATE_MODE);
        this.getMenuElem(5).setTextE(CFG.lang.get("Development"));
        this.getMenuElem(5).setCurr(MapModesManager.VIEW_DEVELOPMENT_MODE);
        this.getMenuElem(6).setTextE(CFG.lang.get("TerrainType"));
        this.getMenuElem(6).setCurr(MapModesManager.VIEW_TERRAIN_TYPE_MODE);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + 155L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX(), CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM(), -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / 155.0f))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
            super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
            super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        CFG.mapModesManager.setActiveMapModeID(this.getMenuElem(iID).getCurr());
    }

    private final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            CFG.mapModesManager.disableAllViews();
        }
        this.lTime = System.currentTimeMillis();
    }
}

