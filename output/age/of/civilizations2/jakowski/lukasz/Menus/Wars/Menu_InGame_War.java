
package age.of.civilizations2.jakowski.lukasz.Menus.Wars;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_War
extends Menu {
    private int iAggressorID;
    private int iDefenderID;
    private int iAggressorWidth;
    private int iDefenderWidth;
    private String sWar;
    private int iWarWidth;
    private long lTime;
    private int TIME_IN_VIEW = 4500;
    private int TIME_IN_VIEW_HIDE_ANIMATION = 500;

    public Menu_InGame_War() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.setVisibleM(false);
    }

    public Menu_InGame_War(int nCivA, int nCivB) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.sWar = CFG.lang.get("War") + "!";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), this.sWar);
        this.iWarWidth = (int)CFG.glyphLay.width;
        this.iAggressorID = nCivA;
        this.iDefenderID = nCivB;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), CFG.core.getCiv(this.iAggressorID).getCivName());
        this.iAggressorWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), CFG.core.getCiv(this.iDefenderID).getCivName());
        this.iDefenderWidth = (int)CFG.glyphLay.width;
        this.lTime = System.currentTimeMillis();
    }

    private final int getPosX2() {
        return CFG.GAMEWIDTH / 2 - this.getWidth2() / 2;
    }

    private final int getPosY2() {
        return CFG.BUTTON_H * 3 / 4;
    }

    private final int getWidth2() {
        return (int)((float)Math.max(this.iWarWidth + CFG.PADD * 2, (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) + CFG.PADD * 2 + 4 + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + CFG.PADD * 2 + Math.max(this.iAggressorWidth, this.iDefenderWidth) * 2 + CFG.PADD * 2) * 1.3f);
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
        IMGManager.getIMG(Images.diploRivals).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)) / 2 - IMGManager.getIMG(Images.diploRivals).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)), (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)));
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iAggressorID).getR() / 255.0f, (float)CFG.core.getCiv(this.iAggressorID).getG() / 255.0f, (float)CFG.core.getCiv(this.iAggressorID).getB() / 255.0f, 1.0f * tAlpha));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iDefenderID).getR() / 255.0f, (float)CFG.core.getCiv(this.iDefenderID).getG() / 255.0f, (float)CFG.core.getCiv(this.iDefenderID).getB() / 255.0f, 1.0f * tAlpha));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, tAlpha));
        CFG.core.getCiv(this.iAggressorID).getFlagC().drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iAggressorID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.core.getCiv(this.iDefenderID).getFlagC().drawO(oSB, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iDefenderID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        Renderer.drawText(oSB, CFG.FONT_BOLD, this.sWar, this.getPosX2() + this.getWidth2() / 2 - this.iWarWidth / 2 + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f * tAlpha));
        Renderer.drawText(oSB, CFG.FONT_BOLD, CFG.core.getCiv(this.iAggressorID).getCivName(), this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - CFG.PADD - this.iAggressorWidth + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a * tAlpha));
        Renderer.drawText(oSB, CFG.FONT_BOLD, CFG.core.getCiv(this.iDefenderID).getCivName(), this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + 2 + CFG.PADD + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a * tAlpha));
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

