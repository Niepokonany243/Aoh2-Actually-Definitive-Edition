
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

public class Menu_FlagEditor
extends Menu {
    public Menu_FlagEditor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Slider("", CFG.PADD, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H, 0, 255, 128));
        menuElements.add(new Slider("", CFG.PADD + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H, 0, 255, 128));
        menuElements.add(new Slider("", CFG.PADD + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3 * 2, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H, 0, 255, 128));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * 2 + CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("Tool: Pencil", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * 3 + CFG.BUTTON_H * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM("Flag Editor", CFG.BUTTON_H, false, false), 0, CFG.BUTTON_H + (CFG.GAMEWIDTH - CFG.PADD * 6) / CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT + CFG.PADD + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - (CFG.GAMEWIDTH - CFG.PADD * 6) / CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT - CFG.PADD - CFG.PADD * 2, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(4).setTextE(CFG.lang.get("RandomFlag"));
    }

    @Override
    public final void drawTitle(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive, int nPosY) {
        super.drawTitle(oSB, iTranslateX, iTranslateY, sliderMenuIsActive, this.getTitleM().getHeightT());
        this.drawIconFlag(oSB, iTranslateX, CFG.GAMEWIDTH / 2 - this.getTitleM().getTextWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, this.getTitleM().getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
    }

    public final void drawIconFlag(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            oSB.setColor(CFG.flagPixelColor.getR(i), CFG.flagPixelColor.getG(i), CFG.flagPixelColor.getB(i), CFG.flagPixelColor.getA(i));
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX + 1 * x++, nPosY + 1 * y);
            oSB.setColor(Color.WHITE);
            if (x < CFG.CIV_FLAG_WIDTH) continue;
            ++y;
            x = 0;
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.flagR = this.getMenuElem(iID).getCurr();
                break;
            }
            case 2: {
                CFG.flagG = this.getMenuElem(iID).getCurr();
                break;
            }
            case 3: {
                CFG.flagB = this.getMenuElem(iID).getCurr();
                break;
            }
            case 4: {
                this.randomFlag();
                break;
            }
            case 5: {
                CFG.flagEditorMode = CFG.flagEditorMode == CFG.FlagEditorMode.PENCIL ? CFG.FlagEditorMode.PAINT_BUCKET : CFG.FlagEditorMode.PENCIL;
                this.getMenuElem(iID).setTextE("Tool: " + (CFG.flagEditorMode == CFG.FlagEditorMode.PENCIL ? "Pencil" : "Paint bucket"));
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }

    private final void randomFlag() {
        Random oR = new Random();
        int res = oR.nextInt(3);
        switch (res) {
            case 0: {
                this.randomFlag0();
                break;
            }
            case 1: {
                this.randomFlag1();
                break;
            }
            case 2: {
                this.randomFlag2();
            }
        }
    }

    private final void randomFlag0() {
        int i;
        Random oR = new Random();
        int tempR = oR.nextInt(255);
        int tempG = oR.nextInt(255);
        int tempB = oR.nextInt(255);
        for (i = 0; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT / 2; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
        }
        tempR = oR.nextInt(255);
        tempG = oR.nextInt(255);
        tempB = oR.nextInt(255);
        for (i = CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT / 2; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
        }
    }

    private final void randomFlag1() {
        int i;
        Random oR = new Random();
        int tempR = oR.nextInt(255);
        int tempG = oR.nextInt(255);
        int tempB = oR.nextInt(255);
        for (i = 0; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
            if (i % (CFG.CIV_FLAG_WIDTH / 3) != CFG.CIV_FLAG_WIDTH / 3 - 1) continue;
            i += CFG.CIV_FLAG_WIDTH - CFG.CIV_FLAG_WIDTH / 3;
        }
        if (oR.nextInt(100) % 5 != 3) {
            tempR = oR.nextInt(255);
            tempG = oR.nextInt(255);
            tempB = oR.nextInt(255);
        }
        for (i = CFG.CIV_FLAG_WIDTH / 3 * 2; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
            if (i % CFG.CIV_FLAG_WIDTH != CFG.CIV_FLAG_WIDTH - 1) continue;
            i += CFG.CIV_FLAG_WIDTH - CFG.CIV_FLAG_WIDTH / 3;
        }
        tempR = oR.nextInt(255);
        tempG = oR.nextInt(255);
        tempB = oR.nextInt(255);
        for (i = CFG.CIV_FLAG_WIDTH / 3; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
            if (i % CFG.CIV_FLAG_WIDTH != CFG.CIV_FLAG_WIDTH / 3 * 2 - 1) continue;
            i += CFG.CIV_FLAG_WIDTH - CFG.CIV_FLAG_WIDTH / 3;
        }
    }

    private final void randomFlag2() {
        Random oR = new Random();
        int tempR = oR.nextInt(255);
        int tempG = oR.nextInt(255);
        int tempB = oR.nextInt(255);
        for (int i = 0; i < CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT; ++i) {
            CFG.flagPixelColor.setR(i, (float)tempR / 2.55f / 100.0f);
            CFG.flagPixelColor.setG(i, (float)tempG / 2.55f / 100.0f);
            CFG.flagPixelColor.setB(i, (float)tempB / 2.55f / 100.0f);
            if (i % (CFG.CIV_FLAG_WIDTH / 2 - 1) != CFG.CIV_FLAG_WIDTH / 2 - 2) continue;
            i += CFG.CIV_FLAG_WIDTH - CFG.CIV_FLAG_WIDTH / 2 + 2;
        }
    }
}

