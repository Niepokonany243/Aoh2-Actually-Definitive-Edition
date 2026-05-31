
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest.InfoSaved;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_GameSaved
extends Menu {
    public static final float FONT_SCALE2 = 0.75f;
    public static final float FONT_SCALE = 0.75f;
    private String sWar;
    private int iWarWidth;
    private long lTime = -1L;
    private int TIME_IN_VIEW = 1750;
    private int TIME_IN_VIEW_HIDE_ANIMATION = 475;

    public Menu_InGame_GameSaved() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.setVisibleM(false);
    }

    public Menu_InGame_GameSaved(int init) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.sWar = CFG.lang.get("GameSaved");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sWar);
        this.iWarWidth = (int)(CFG.glyphLay.width * 0.75f);
        this.lTime = -1L;
    }

    private final int getPosX2() {
        return CFG.GAMEWIDTH / 2 - this.getWidth2() / 2;
    }

    private final int getPosY2() {
        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getHeight2();
    }

    private final int getWidth2() {
        return (int)((float)(this.iWarWidth + CFG.PADD * 2) * 1.65f);
    }

    private final int getHeight2() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime < 0L) {
            this.lTime = System.currentTimeMillis();
        }
        float tAlpha = this.getAlpha();
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.85f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), this.getHeight2());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - 2 + this.getHeight2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - 1 + this.getHeight2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), CFG.TEXT_HEIGHT_DEFAULT);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - 1 + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), 1);
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.75f);
        CFG.drawTextDefault(oSB, this.sWar, this.getPosX2() + this.getWidth2() / 2 - this.iWarWidth / 2 + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (int)(((float)CFG.TEXT_HEIGHT_DEFAULT - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.75f) / 2.0f) + iTranslateY, new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 1.0f * tAlpha));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        CFG.setRenderO(true);
        if (System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW) {
            this.setVisibleM(false);
        }
    }

    private final float getAlpha() {
        if (System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION) {
            return Math.max(0.0f, 1.0f - (float)(System.currentTimeMillis() - (this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION)) / (float)this.TIME_IN_VIEW_HIDE_ANIMATION);
        }
        return 1.0f;
    }
}

