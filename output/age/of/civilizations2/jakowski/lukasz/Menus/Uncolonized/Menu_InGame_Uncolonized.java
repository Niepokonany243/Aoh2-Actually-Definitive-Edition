/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized;

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

public class Menu_InGame_Uncolonized
extends Menu {
    private String sUncolonized;
    private int iUncolonizedWidth;
    private String sRequiredTech;
    private int isRequiredTechWidth;
    private String sRequiredTech2;
    private int isRequiredTechWidth2;

    public Menu_InGame_Uncolonized() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.sUncolonized = CFG.lang.get("UncolonizedProvince");
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sUncolonized);
        this.iUncolonizedWidth = (int)CFG.glyphLay.width;
        this.sRequiredTech = CFG.lang.get("RequiredTechnologyLevel") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sRequiredTech);
        this.isRequiredTechWidth = (int)CFG.glyphLay.width;
        this.sRequiredTech2 = "" + (float)((int)(GameCalendar.COLONIZATION_TECH_LEVEL * 100.0f)) / 100.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sRequiredTech2);
        this.isRequiredTechWidth2 = (int)CFG.glyphLay.width;
    }

    private final int getPosX2() {
        return CFG.GAMEWIDTH / 2 - this.getWidth2() / 2;
    }

    private final int getPosY2() {
        return CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - CFG.PADD - this.getHeight2();
    }

    private final int getWidth2() {
        return (int)((float)Math.max(this.iUncolonizedWidth + CFG.PADD * 2, this.isRequiredTechWidth + this.isRequiredTechWidth2 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + CFG.PADD * 3) * 1.5f);
    }

    private final int getHeight2() {
        return (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2 + CFG.PADD * 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        float tAlpha = 1.0f;
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.85f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), this.getHeight2());
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.8f * tAlpha));
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
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (this.isRequiredTechWidth + this.isRequiredTechWidth2 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + CFG.PADD) / 2 + this.isRequiredTechWidth + this.isRequiredTechWidth2 + CFG.PADD + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology)) / 2 - IMGManager.getIMG(Images.technology).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology)));
        oSB.setColor(Color.WHITE);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sUncolonized, this.getPosX2() + this.getWidth2() / 2 - this.iUncolonizedWidth / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 1.0f * tAlpha));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sRequiredTech, this.getPosX2() + this.getWidth2() / 2 - (this.isRequiredTechWidth + this.isRequiredTechWidth2 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + CFG.PADD) / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a * tAlpha));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sRequiredTech2, this.getPosX2() + this.getWidth2() / 2 + this.isRequiredTechWidth - (this.isRequiredTechWidth + this.isRequiredTechWidth2 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + CFG.PADD) / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 + CFG.PADD + iTranslateY, new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, CFG.COLOR_NEGATIVE_2.a * tAlpha));
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }
}

