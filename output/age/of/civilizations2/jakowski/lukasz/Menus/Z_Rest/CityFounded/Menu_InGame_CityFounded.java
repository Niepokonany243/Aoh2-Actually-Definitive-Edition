
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.CityFounded;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CityFounded
extends Menu {
    private int iCivA;
    private String sWar;
    private int iWarWidth;
    private String sDate;
    private int iDateWidth;
    private long lTime;
    private int TIME_IN_VIEW = 5250;
    private int TIME_IN_VIEW_HIDE_ANIMATION = 500;

    public Menu_InGame_CityFounded() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.setVisibleM(false);
    }

    public Menu_InGame_CityFounded(int nProvinceID, int nCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.iCivA = nCivID;
        this.sWar = CFG.core.getProv(nProvinceID).getCitSize() > 0 ? CFG.lang.get("CityHasBeenFounded", CFG.core.getProv(nProvinceID).getCit(0).getCityName()) : CFG.lang.get("CityHasBeenFounded", CFG.core.getProv(nProvinceID).getName());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sWar);
        this.iWarWidth = (int)CFG.glyphLay.width;
        this.sDate = GameCalendar.getCurrDate();
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sDate);
        this.iDateWidth = (int)CFG.glyphLay.width;
        this.lTime = System.currentTimeMillis();
    }

    private final int getPosX2() {
        return CFG.GAMEWIDTH / 2 - this.getWidth2() / 2;
    }

    private final int getPosY2() {
        return CFG.BUTTON_H * 3 / 4;
    }

    private final int getWidth2() {
        return (int)((float)Math.max(this.iWarWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + CFG.PADD, this.iDateWidth + CFG.PADD * 2) * 1.3f);
    }

    private final int getHeight2() {
        return (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2 + CFG.PADD * 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
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
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, tAlpha));
        CFG.core.getCiv(this.iCivA).getFlagC().drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (this.iWarWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + CFG.PADD) / 2 + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 + iTranslateY - CFG.core.getCiv(this.iCivA).getFlagC().getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (this.iWarWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + CFG.PADD) / 2 + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 + iTranslateY - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sWar, this.getPosX2() + this.getWidth2() / 2 - (this.iWarWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + CFG.PADD) / 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + CFG.PADD + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(CFG.COLOR_NEUTRAL2.r, CFG.COLOR_NEUTRAL2.g, CFG.COLOR_NEUTRAL2.b, 1.0f * tAlpha));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sDate, this.getPosX2() + this.getWidth2() / 2 - this.iDateWidth / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a * tAlpha));
        CFG.setRenderO(true);
        if (System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW) {
            this.setVisibleM(false);
        }
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    private final float getAlpha() {
        if (System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION) {
            return Math.max(0.0f, 1.0f - (float)(System.currentTimeMillis() - (this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION)) / (float)this.TIME_IN_VIEW_HIDE_ANIMATION);
        }
        return 1.0f;
    }
}

