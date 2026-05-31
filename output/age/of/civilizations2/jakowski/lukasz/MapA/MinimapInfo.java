/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MinimapInfo
extends MenuElemUI {
    private float scale;

    public MinimapInfo(int nPosX, int nPosY, int nWidth) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.MINIMAPINFO;
        this.setPosX(nPosX);
        this.setPosY(nPosY);
        this.scale = (float)nWidth / (float)CFG.map.getMpB().getWidthM();
        this.setWidthE(nWidth);
        this.setHeightE((int)((float)CFG.map.getMpB().getHeightM() * this.scale));
    }

    @Override
    public final void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.end();
        AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)this.getWidthE()), (float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)this.getHeightE()));
        AoCGame.viewport.apply();
        AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)this.getWidthE()), -((float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)this.getHeightE())));
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
        CFG.map.getMpB().drawMap(oSB, (int)((float)(this.getPosXE() + iTranslateX) * ((float)CFG.map.getMpB().getWidthM() / (float)this.getWidthE())), (int)((float)(this.getPosY() + iTranslateY) * ((float)CFG.map.getMpB().getHeightM() / (float)this.getHeightE())));
        CFG.core.drawProvinces(oSB, (int)((float)(this.getPosXE() + iTranslateX) * ((float)CFG.map.getMpB().getWidthM() / (float)this.getWidthE())), (int)((float)(this.getPosY() + iTranslateY) * ((float)CFG.map.getMpB().getHeightM() / (float)this.getHeightE())), 1.0f, 255);
        oSB.end();
        AoCGame.cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
        AoCGame.viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        AoCGame.viewport.apply();
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
    }
}

