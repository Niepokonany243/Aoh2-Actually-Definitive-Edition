/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CivilizationView
extends Menu {
    public static int iCivID = 0;

    public Menu_InGame_CivilizationView() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2, false, true);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
        IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        this.onBackPressed();
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eINGAME);
        CFG.map.getMpSl().stopScrollingTheMap();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.core.disableDrawCivilizationRegions(iCivID);
        CFG.map.getMpS().setCurrScale(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).fBefore_Scale);
        CFG.map.getMpC().setStartingPosX(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosX);
        CFG.map.getMpC().setStartingPosY(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY);
        CFG.map.getMpC().updateSecondSideOfMap();
        CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
    }

    @Override
    public void onMenuPressed() {
        this.onBackPressed();
    }
}

