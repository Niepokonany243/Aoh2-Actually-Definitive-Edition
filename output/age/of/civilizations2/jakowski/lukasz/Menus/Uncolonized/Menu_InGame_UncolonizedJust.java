
package age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized;

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

public class Menu_InGame_UncolonizedJust
extends Menu {
    private String sUncolonized;
    private int iUncolonizedWidth;
    private int iUncolonizedHeight;

    public Menu_InGame_UncolonizedJust() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.sUncolonized = CFG.lang.get("UncolonizedProvince");
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sUncolonized);
        this.iUncolonizedWidth = (int)CFG.glyphLay.width;
        this.iUncolonizedHeight = (int)CFG.glyphLay.height;
    }

    private final int getPosX2() {
        return CFG.GAMEWIDTH / 2 - this.getWidth2() / 2;
    }

    private final int getPosY2() {
        return CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - CFG.PADD - this.getHeight2();
    }

    private final int getWidth2() {
        return (int)((float)(this.iUncolonizedWidth + CFG.PADD * 2) * 1.5f);
    }

    private final int getHeight2() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
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
        oSB.setColor(Color.WHITE);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sUncolonized, this.getPosX2() + this.getWidth2() / 2 - this.iUncolonizedWidth / 2 + iTranslateX, this.getPosY2() + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT - this.iUncolonizedHeight) / 2 + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 1.0f * tAlpha));
    }
}

