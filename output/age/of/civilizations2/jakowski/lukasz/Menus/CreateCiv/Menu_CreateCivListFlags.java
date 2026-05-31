
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateCivListFlags
extends Menu {
    public static int getMenuX() {
        return CFG.GAMEWIDTH - Menu_CreateCivListFlags.getMenuW() - CFG.PADD;
    }

    public static int getMenuW() {
        return 462 + CFG.PADD * 4;
    }

    public static int getMenuY() {
        return CFG.PADD;
    }

    public Menu_CreateCivListFlags() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = Menu_CreateCivListFlags.getMenuW();
        int tY = 0;
        int tX = CFG.PADD;
        try {
            for (i = 0; i < CFG.flagManager.divisionLayersAll.size(); ++i) {
                menuElements.add(new Button_NewGameStyle("", -1, tX, tY, 154, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){
                    int iCurrent;

                    @Override
                    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                    }

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        CFG.flagManager.drawDivision_FlagFrameSize2(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY, this.iCurrent);
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.iCurrent = nCurrent;
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Select"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.flagManager.updateDivision(this.iCurrent);
                        CFG.toastM.addM("ID: [" + this.iCurrent + "/" + (CFG.flagManager.lDivisions.size() - 1) + "]", CFG.COLOR_HOVER_TITLE);
                        CFG.menus.getColorPicker().setVisible(false, null);
                        CFG.menus.setMenuIDWithoutAnim(View.eCREATE_CIVILIZATION);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
                if ((i + 1) % 3 == 0) {
                    tX = CFG.PADD;
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    continue;
                }
                tX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (!menuElements.isEmpty()) {
                tY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            }
            tX = CFG.PADD;
            for (i = 0; i < CFG.flagManager.lOverlaysImagesAll.size(); ++i) {
                menuElements.add(new Button_NewGameStyle("", -1, tX, tY, 154, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){
                    int iCurrent;

                    @Override
                    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                    }

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        oSB.setColor(Color.WHITE);
                        CFG.flagManager.lOverlaysImagesAll.get((int)this.iCurrent).imageOverlay.draw(oSB, this.getPosXE() + this.getWidthE() / 2 - CFG.flagManager.lOverlaysImagesAll.get((int)this.iCurrent).imageOverlay.getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.flagManager.lOverlaysImagesAll.get((int)this.iCurrent).imageOverlay.getHeight() / 2 + iTranslateY);
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.iCurrent = nCurrent;
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Select"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.flagManager.addOverlay(this.iCurrent);
                        CFG.toastM.addM("ID: [" + this.iCurrent + "/" + (CFG.flagManager.lOverlaysImagesAll.size() - 1) + "]", CFG.COLOR_HOVER_TITLE);
                        CFG.menus.getColorPicker().setVisible(false, null);
                        CFG.menus.setMenuIDWithoutAnim(View.eCREATE_CIVILIZATION);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
                if ((i + 1) % 3 == 0) {
                    tX = CFG.PADD;
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    continue;
                }
                tX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (menuElements.isEmpty()) {
            this.initMenu(null, 0, 0, 1, 1, menuElements, false, true);
        } else {
            int tempMenuPosY = Menu_CreateCivListFlags.getMenuY();
            this.initMenu(new TitleM_TextSmall(CFG.lang.get("Flags"), CFG.BUTTON_H * 3 / 4, true, false){

                @Override
                public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + 4 - IMGManager.getIMG(Images.dialog_title).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                    oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.165f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                    oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.375f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                    oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                    IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                    oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                    oSB.setColor(Color.WHITE);
                    int imgID = Images.diploLord;
                    IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_CreateCivListFlags.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                    Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
                }
            }, Menu_CreateCivListFlags.getMenuX(), tempMenuPosY + CFG.BUTTON_H * 3 / 4, tempWidth, CFG.GAMEHEIGHT - tempMenuPosY * 2 - CFG.BUTTON_H * 3 / 4, menuElements, !menuElements.isEmpty(), true);
            this.updateLang();
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }
}

