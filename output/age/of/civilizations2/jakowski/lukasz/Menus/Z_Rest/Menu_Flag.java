
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_FlagPixel;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_FlagPixel_Color;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Flag
extends Menu {
    public Menu_Flag() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int pixelWidth = (CFG.GAMEWIDTH - CFG.PADD * 6) / CFG.CIV_FLAG_WIDTH;
        for (int i = 0; i < CFG.CIV_FLAG_HEIGHT; ++i) {
            for (int j = 0; j < CFG.CIV_FLAG_WIDTH; ++j) {
                menuElements.add(new Menu_FlagPixel(CFG.PADD * 3 + pixelWidth * j + (CFG.GAMEWIDTH - pixelWidth * CFG.CIV_FLAG_WIDTH - CFG.PADD * 6) / 2, pixelWidth * i + CFG.PADD, pixelWidth, pixelWidth));
            }
        }
        CFG.flagPixelColor = new Menu_FlagPixel_Color();
        this.initMenu(null, 0, CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH, pixelWidth * CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2, menuElements);
    }

    @Override
    public final void draw(SpriteBatch oSB, int iTranslateX, boolean sliderMenuIsActive) {
        int i;
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.2f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY(), this.getWidthM(), this.getHeightM());
        oSB.setColor(Color.WHITE);
        for (i = this.getMenuElemsSize() - 1; i >= 0; --i) {
            this.getMenuElem(i).drawE(oSB, this.getMenuPosX() + iTranslateX, this.getMenuPosY(), i);
        }
        oSB.setColor(0.196f, 0.196f, 0.196f, 1.0f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        oSB.setColor(0.196f, 0.196f, 0.196f, 0.15f);
        for (i = 1; i < CFG.CIV_FLAG_HEIGHT; ++i) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() * i + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        }
        for (i = 1; i < CFG.CIV_FLAG_WIDTH; ++i) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() * i + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        }
        oSB.setColor(0.196f, 0.196f, 0.196f, 0.4f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() * (CFG.CIV_FLAG_HEIGHT / 2) + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() * (CFG.CIV_FLAG_HEIGHT / 3) + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() * (CFG.CIV_FLAG_HEIGHT / 3 * 2 + 1) + this.getPosY(), this.getMenuElem(0).getWidthE() * CFG.CIV_FLAG_WIDTH, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() * (CFG.CIV_FLAG_WIDTH / 2) + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() * (CFG.CIV_FLAG_WIDTH / 3) + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() * (CFG.CIV_FLAG_WIDTH / 3 * 2) + this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() + this.getPosY(), 1, this.getMenuElem(0).getHeightE() * CFG.CIV_FLAG_HEIGHT);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.flagEditorMode == CFG.FlagEditorMode.PENCIL) {
            CFG.flagPixelColor.setR(iID, (float)CFG.flagR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(iID, (float)CFG.flagG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(iID, (float)CFG.flagB / 2.55f / 100.0f);
        } else if (CFG.flagEditorMode == CFG.FlagEditorMode.PAINT_BUCKET && (CFG.flagPixelColor.getR(iID) != (float)CFG.flagR / 2.55f / 100.0f || CFG.flagPixelColor.getG(iID) != (float)CFG.flagG / 2.55f / 100.0f || CFG.flagPixelColor.getB(iID) != (float)CFG.flagB / 2.55f / 100.0f)) {
            float tempR = CFG.flagPixelColor.getR(iID);
            float tempG = CFG.flagPixelColor.getG(iID);
            float tempB = CFG.flagPixelColor.getB(iID);
            for (int i = 0; i < CFG.CIV_FLAG_HEIGHT * CFG.CIV_FLAG_WIDTH; ++i) {
                if (CFG.flagPixelColor.getR(i) != tempR || CFG.flagPixelColor.getG(i) != tempG || CFG.flagPixelColor.getB(i) != tempB) continue;
                CFG.flagPixelColor.setR(i, (float)CFG.flagR / 2.55f / 100.0f);
                CFG.flagPixelColor.setG(i, (float)CFG.flagG / 2.55f / 100.0f);
                CFG.flagPixelColor.setB(i, (float)CFG.flagB / 2.55f / 100.0f);
            }
        }
    }
}

