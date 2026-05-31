/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Keyboard;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Keyboard
extends Menu {
    private List<String> keys = new ArrayList<String>();
    private List<String> keysSHIFT = new ArrayList<String>();
    private List<String> keysNUM = new ArrayList<String>();
    private List<String> keys123 = new ArrayList<String>();
    private int animationStepID = 0;
    private int animationChangePosY;
    private boolean closeMenu = false;
    private long barTime;
    private boolean drawBar;
    public static boolean shift = false;
    public static boolean numbers = false;
    private int iTextW;
    private int iTextH;
    public static boolean colorPickerMode = false;
    public static int activeColor_RGB_ID = -1;
    public static boolean commandsMode = false;
    public static boolean rankSearch = false;
    public static boolean forceMigrationSearch = false;
    public static boolean cityEditorSearch = false;
    public static int changeCivilizationNameMode = 0;
    public static int changeAllianceNameMode = 0;
    public static boolean mapModeSearch = false;
    public static int changeProvinceNameMode = -1;
    public static int changeCityNameIDToo = -1;

    public Keyboard() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.keys.add("q");
        this.keys.add("w");
        this.keys.add("e");
        this.keys.add("r");
        this.keys.add("t");
        this.keys.add("y");
        this.keys.add("u");
        this.keys.add("i");
        this.keys.add("o");
        this.keys.add("p");
        this.keys.add("a");
        this.keys.add("s");
        this.keys.add("d");
        this.keys.add("f");
        this.keys.add("g");
        this.keys.add("h");
        this.keys.add("j");
        this.keys.add("k");
        this.keys.add("l");
        this.keys.add("z");
        this.keys.add("x");
        this.keys.add("c");
        this.keys.add("v");
        this.keys.add("b");
        this.keys.add("n");
        this.keys.add("m");
        this.keys.add("SH");
        this.keys.add("<<");
        this.keys.add("123");
        this.keys.add("Space");
        this.keys.add(",");
        this.keys.add(".");
        this.keysSHIFT.add("Q");
        this.keysSHIFT.add("W");
        this.keysSHIFT.add("E");
        this.keysSHIFT.add("R");
        this.keysSHIFT.add("T");
        this.keysSHIFT.add("Y");
        this.keysSHIFT.add("U");
        this.keysSHIFT.add("I");
        this.keysSHIFT.add("O");
        this.keysSHIFT.add("P");
        this.keysSHIFT.add("A");
        this.keysSHIFT.add("S");
        this.keysSHIFT.add("D");
        this.keysSHIFT.add("F");
        this.keysSHIFT.add("G");
        this.keysSHIFT.add("H");
        this.keysSHIFT.add("J");
        this.keysSHIFT.add("K");
        this.keysSHIFT.add("L");
        this.keysSHIFT.add("Z");
        this.keysSHIFT.add("X");
        this.keysSHIFT.add("C");
        this.keysSHIFT.add("V");
        this.keysSHIFT.add("B");
        this.keysSHIFT.add("N");
        this.keysSHIFT.add("M");
        this.keysNUM.add("1");
        this.keysNUM.add("2");
        this.keysNUM.add("3");
        this.keysNUM.add("4");
        this.keysNUM.add("5");
        this.keysNUM.add("6");
        this.keysNUM.add("7");
        this.keysNUM.add("8");
        this.keysNUM.add("9");
        this.keysNUM.add("0");
        this.keys123.add("@");
        this.keys123.add("*");
        this.keys123.add("#");
        this.keys123.add(":");
        this.keys123.add(";");
        this.keys123.add("&");
        this.keys123.add("_");
        this.keys123.add("(");
        this.keys123.add(")");
        this.keys123.add("-");
        this.keys123.add("+");
        this.keys123.add("'");
        this.keys123.add("\"");
        this.keys123.add("%");
        this.keys123.add("!");
        this.keys123.add("?");
        for (i = 0; i < 10; ++i) {
            menuElements.add(new Button_Keyboard(this.keys.get(i), (Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 11) / 10 * i + CFG.PADD * i, CFG.PADD * 2 + CFG.PADD * 2 + (int)((float)CFG.BUTTON_H * 0.8f), (Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 11) / 10, CFG.BUTTON_H, ButtonM.TypeOfButton.KEYBOARD, true));
        }
        for (i = 0; i < 10; ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosX(((MenuElemUI)menuElements.get(i)).getPosXE() + (Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE()) / 2);
        }
        for (i = 0; i < 9; ++i) {
            menuElements.add(new Button_Keyboard(this.keys.get(i + 10), ((MenuElemUI)menuElements.get(0)).getWidthE() * i + CFG.PADD * i, CFG.PADD * 2 + CFG.PADD * 4 + CFG.BUTTON_H + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(0)).getWidthE(), CFG.BUTTON_H, ButtonM.TypeOfButton.KEYBOARD, true));
        }
        for (i = 10; i < 19; ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosX(((MenuElemUI)menuElements.get(i)).getPosXE() + (Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE()) / 2);
        }
        for (i = 0; i < 7; ++i) {
            menuElements.add(new Button_Keyboard(this.keys.get(i + 19), ((MenuElemUI)menuElements.get(0)).getWidthE() * i + CFG.PADD * i, CFG.PADD * 2 + CFG.PADD * 6 + CFG.BUTTON_H * 2 + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(0)).getWidthE(), CFG.BUTTON_H, ButtonM.TypeOfButton.KEYBOARD, true));
        }
        for (i = 19; i < 26; ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosX(((MenuElemUI)menuElements.get(i)).getPosXE() + (Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE()) / 2);
        }
        menuElements.add(new Button_Keyboard(this.keys.get(26), CFG.PADD, CFG.PADD * 2 + CFG.PADD * 6 + CFG.BUTTON_H * 2 + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(19)).getPosXE() - CFG.PADD * 2, CFG.BUTTON_H, ButtonM.TypeOfButton.KEYBOARD_OPTIONS, true));
        menuElements.add(new Button_Keyboard(this.keys.get(27), ((MenuElemUI)menuElements.get(25)).getPosXE() + ((MenuElemUI)menuElements.get(25)).getWidthE() + CFG.PADD, CFG.PADD * 2 + CFG.PADD * 6 + CFG.BUTTON_H * 2 + (int)((float)CFG.BUTTON_H * 0.8f), Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(25)).getPosXE() - ((MenuElemUI)menuElements.get(25)).getWidthE() - CFG.PADD * 2, CFG.BUTTON_H, ButtonM.TypeOfButton.KEYBOARD_OPTIONS, true));
        menuElements.add(new Button_Keyboard(this.keys.get(28), CFG.PADD, CFG.PADD * 2 + CFG.PADD * 8 + CFG.BUTTON_H * 3 + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(0)).getWidthE() * 2, (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_OPTIONS, true));
        menuElements.add(new Button_Keyboard(this.keys.get(29), CFG.PADD * 2 + ((MenuElemUI)menuElements.get(0)).getWidthE() * 2, CFG.PADD * 2 + CFG.PADD * 8 + CFG.BUTTON_H * 3 + (int)((float)CFG.BUTTON_H * 0.8f), Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 4 - CFG.PADD * 5, (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD, true));
        menuElements.add(new Button_Keyboard(this.keys.get(30), CFG.PADD * 3 + ((MenuElemUI)menuElements.get(0)).getWidthE() * 2 + Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 4 - CFG.PADD * 5, CFG.PADD * 2 + CFG.PADD * 8 + CFG.BUTTON_H * 3 + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(0)).getWidthE(), (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_OPTIONS, true));
        menuElements.add(new Button_Keyboard(this.keys.get(31), CFG.PADD * 4 + ((MenuElemUI)menuElements.get(0)).getWidthE() * 3 + Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 4 - CFG.PADD * 5, CFG.PADD * 2 + CFG.PADD * 8 + CFG.BUTTON_H * 3 + (int)((float)CFG.BUTTON_H * 0.8f), ((MenuElemUI)menuElements.get(0)).getWidthE(), (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_OPTIONS, true));
        menuElements.add(new Button_Keyboard(null, Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 2 - CFG.PADD, CFG.PADD, ((MenuElemUI)menuElements.get(0)).getWidthE() * 2, (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_SAVE, true));
        menuElements.add(new Button_Keyboard(null, Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 4 - CFG.PADD * 3, CFG.PADD, ((MenuElemUI)menuElements.get(0)).getWidthE(), (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_SAVE, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("CTRL + V: " + CFG.lang.get("Paste"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Keyboard(null, Menu_InGame_FA_Top.getWindowWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() * 3 - CFG.PADD * 2, CFG.PADD, ((MenuElemUI)menuElements.get(0)).getWidthE(), (int)((float)CFG.BUTTON_H * 0.8f), ButtonM.TypeOfButton.KEYBOARD_SAVE, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("CTRL + C: " + CFG.lang.get("Copy"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(null, 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.PADD * 2 - ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getPosY() - ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getHeightE(), Menu_InGame_FA_Top.getWindowWidth(), CFG.PADD * 2 + ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 4)).getHeightE(), menuElements, false, false);
        this.updateLang();
        CFG.updateKeyboard_Actions();
    }

    @Override
    public void updateLang() {
        this.keys.set(26, CFG.lang.get("Shift"));
        this.getMenuElem(26).setTextE(this.keys.get(26));
        this.getMenuElem(32).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(34).setTextE("Ctrl + C");
        this.getMenuElem(33).setTextE("Ctrl + V");
    }

    @Override
    public final void draw(SpriteBatch oSB, int iTranslateX, boolean sliderMenuIsActive) {
        this.updateChangePosY();
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX(), this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + this.animationChangePosY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM());
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + this.animationChangePosY, IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM(), true, false);
        oSB.setColor(new Color(0.025f, 0.03f, 0.092f, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX(), this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.animationChangePosY + this.getMenuElem(32).getHeightE() + CFG.PADD * 2, this.getWidthM(), this.getHeightM() - this.getMenuElem(32).getHeightE() - CFG.PADD * 2);
        oSB.setColor(new Color(0.14901961f, 0.1764706f, 0.21568628f, 0.65f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosX(), this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + this.animationChangePosY + this.getMenuElem(32).getHeightE() + CFG.PADD * 2, this.getWidthM(), this.getHeightM() - this.getMenuElem(32).getHeightE() - CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.28f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX(), this.getPosY() + this.animationChangePosY + 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), this.getMenuElem(32).getHeightE() + CFG.PADD * 2 - 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.425f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2, this.getPosY() + this.animationChangePosY + 2 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM() - 4, CFG.PADD * 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2, this.getPosY() + this.getMenuElem(32).getHeightE() + CFG.PADD * 2 - 4 - CFG.PADD * 2 + this.animationChangePosY + 2 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM() - 4, CFG.PADD * 2, false, true);
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE2.r, CFG.COLOR_NEW_GAME_EDGE_LINE2.g, CFG.COLOR_NEW_GAME_EDGE_LINE2.b, 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX(), this.getPosY() + this.animationChangePosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, this.getWidthM(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2, this.getPosY() + this.animationChangePosY - IMGManager.getIMG(Images.pix255).getHeight() + this.getMenuElem(32).getHeightE() + CFG.PADD * 2 - 2, this.getWidthM() - 4, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX(), this.getPosY() + this.animationChangePosY - IMGManager.getIMG(Images.line32Off1).getHeight() + 1, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX(), this.getPosY() + this.animationChangePosY - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(32).getHeightE() + CFG.PADD * 2 - 2, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getWidthM() / 4, this.getPosY() + this.animationChangePosY - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(32).getHeightE() + CFG.PADD * 2 - 2, this.getWidthM() / 2, 1);
        oSB.setColor(Color.WHITE);
        this.drawMenuElements(oSB, 0, this.animationChangePosY, sliderMenuIsActive);
        CFG.drawTextDefault(oSB, CFG.keybMess, this.getPosX() + CFG.PADD * 2 + iTranslateX, this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() / 2 - this.iTextH / 2 + this.animationChangePosY + this.getPosY(), new Color(0.8156863f, 0.67058825f, 0.44313726f, 1.0f));
        if (this.barTime + (long)(this.drawBar ? 700 : 650) < System.currentTimeMillis()) {
            this.drawBar = !this.drawBar;
            this.barTime = System.currentTimeMillis();
        }
        if (this.drawBar) {
            CFG.drawTextDefault(oSB, "|", this.getPosX() + CFG.PADD * 2 + this.iTextW + iTranslateX, this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() / 2 - this.iTextH / 2 + this.animationChangePosY + this.getPosY(), Color.WHITE);
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 26: {
                this.shiftAction();
                return;
            }
            case 27: {
                CFG.keyboardDelete.action();
                break;
            }
            case 28: {
                if (activeColor_RGB_ID < 0) {
                    numbers = !numbers;
                    this.actionCloseMenu();
                }
                return;
            }
            case 29: {
                if (CFG.keybMess.length() <= 0 || CFG.keybMess.charAt(CFG.keybMess.length() - 1) == ' ') break;
                CFG.keyboardWrite.action(" ");
                break;
            }
            case 32: {
                CFG.keyboardSave.action();
                this.closeMenu();
                activeColor_RGB_ID = -1;
                return;
            }
            case 34: {
                Gdx.app.getClipboard().setContents(CFG.keybMess);
                CFG.toastM.addM(CFG.lang.get("Copy") + ": " + CFG.keybMess);
                return;
            }
            case 33: {
                CFG.keybMess = Gdx.app.getClipboard().getContents();
                CFG.toastM.addM(CFG.lang.get("Paste") + ": " + CFG.keybMess);
                return;
            }
            default: {
                if (shift && iID < 26) {
                    if (numbers) {
                        if (iID < 10) {
                            this.writeNumber(iID);
                            break;
                        }
                        if (activeColor_RGB_ID >= 0) break;
                        CFG.keyboardWrite.action(this.keys123.get(iID - 10));
                        break;
                    }
                    if (activeColor_RGB_ID >= 0) break;
                    CFG.keyboardWrite.action(this.keysSHIFT.get(iID));
                    if (!shift) break;
                    this.shiftAction();
                    break;
                }
                if (numbers) {
                    if (iID < 10) {
                        this.writeNumber(iID);
                        break;
                    }
                    if (activeColor_RGB_ID >= 0) break;
                    CFG.keyboardWrite.action(this.keys123.get(iID - 10));
                    break;
                }
                if (activeColor_RGB_ID >= 0) break;
                CFG.keyboardWrite.action(this.keys.get(iID));
                if (!shift) break;
                this.shiftAction();
            }
        }
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.keybMess);
        this.iTextW = (int)CFG.glyphLay.width;
        this.iTextH = (int)CFG.glyphLay.height;
        this.barTime = System.currentTimeMillis();
        this.drawBar = true;
    }

    public final void shiftAction() {
        boolean bl = shift = !shift;
        if (numbers) {
            numbers = false;
            this.actionCloseMenu();
        }
        this.getMenuElem(26).setTypeOfButton(shift ? ButtonM.TypeOfButton.KEYBOARD_ACTIVE : ButtonM.TypeOfButton.KEYBOARD_OPTIONS);
        if (shift) {
            int i;
            int n = i = numbers ? this.keysNUM.size() : 0;
            while (i < this.keysSHIFT.size()) {
                this.getMenuElem(i).setTextE(this.keysSHIFT.get(i));
                ++i;
            }
        } else {
            int i;
            int n = i = numbers ? this.keysNUM.size() : 0;
            while (i < this.keysSHIFT.size()) {
                this.getMenuElem(i).setTextE(this.keys.get(i));
                ++i;
            }
        }
    }

    private final void writeNumber(int iID) {
        CFG.keyboardWrite.action(this.keysNUM.get(iID));
    }

    @Override
    public final void onBackPressed() {
        this.closeMenu();
    }

    @Override
    public void actionCloseMenu() {
        this.getMenuElem(28).setTypeOfButton(numbers ? ButtonM.TypeOfButton.KEYBOARD_ACTIVE : ButtonM.TypeOfButton.KEYBOARD_OPTIONS);
        if (numbers) {
            int i;
            for (i = 0; i < this.keysNUM.size(); ++i) {
                this.getMenuElem(i).setTextE(this.keysNUM.get(i));
                this.getMenuElem(i).setTypeOfButton(ButtonM.TypeOfButton.KEYBOARD_NUM);
            }
            int keysNum = this.keysNUM.size();
            for (i = 0; i < this.keys123.size(); ++i) {
                this.getMenuElem(keysNum + i).setTextE(this.keys123.get(i));
            }
        } else {
            int i;
            for (i = 0; i < this.keysNUM.size(); ++i) {
                this.getMenuElem(i).setTextE(shift ? this.keysSHIFT.get(i) : this.keys.get(i));
                this.getMenuElem(i).setTypeOfButton(ButtonM.TypeOfButton.KEYBOARD);
            }
            for (i = this.keysNUM.size(); i < this.keysNUM.size() + this.keys123.size(); ++i) {
                this.getMenuElem(i).setTextE(shift ? this.keysSHIFT.get(i) : this.keys.get(i));
                this.getMenuElem(i).setTypeOfButton(ButtonM.TypeOfButton.KEYBOARD);
            }
        }
    }

    private final void updateChangePosY() {
        switch (this.animationStepID) {
            case 0: 
            case 1: 
            case 12: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)this.getHeightM() * 2.5f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 2: 
            case 3: 
            case 10: 
            case 11: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)this.getHeightM() * 5.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)this.getHeightM() * 10.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 6: 
            case 7: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)this.getHeightM() * 15.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 13: {
                this.animationChangePosY = 0;
            }
        }
        if (CFG.iNumOfFPS < 22) {
            this.animationStepID = 13;
            this.animationChangePosY = 0;
        }
        if (this.closeMenu && this.animationStepID == 13) {
            this.animationChangePosY = this.getHeightM();
            super.setVisibleM(false);
        }
        ++this.animationStepID;
        CFG.setRenderO(true);
    }

    public final void closeMenu() {
        this.closeMenu = true;
        this.resetAnimation();
    }

    @Override
    public void onMenuPressed() {
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.keybMess);
        this.iTextW = (int)CFG.glyphLay.width;
    }

    @Override
    public final void setVisibleM(boolean visible) {
        if (visible) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.keybMess);
            this.iTextW = (int)CFG.glyphLay.width;
            this.iTextH = (int)CFG.glyphLay.height;
            this.barTime = System.currentTimeMillis();
            this.drawBar = true;
            super.setVisibleM(visible);
        }
        this.closeMenu = !visible;
        this.resetAnimation();
    }

    private final void resetAnimation() {
        this.animationStepID = 0;
        if (!this.closeMenu) {
            this.animationChangePosY = this.getHeightM();
        }
    }
}

