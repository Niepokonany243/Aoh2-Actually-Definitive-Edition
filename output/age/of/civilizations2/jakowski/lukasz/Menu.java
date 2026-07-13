
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public List<MenuElemUI> menuElem = new ArrayList<MenuElemUI>();
    public int iMenuElemsSize;
    private int iPosX;
    private int iPosY;
    private int iWidth;
    private int iHeight;
    private boolean visible = true;
    private boolean closeable = false;
    private TitleM menuTitle = null;
    private int iMenuPosX;
    private int iNewMenuPositionX;
    private int iMaxSliderPositionX;
    private boolean scrollableX = false;
    private int iMenuPosY;
    private int iNewMenuPositionY;
    public int iMaxSliderPosY;
    public boolean scrollableY = false;
    private boolean scrollModeY = false;
    private int iScrollPosY = -1;
    private int iScrollPosY2 = -1;
    private float fScrollNewMenuPosY = 0.0f;
    private boolean scrollModeX = false;
    private int iScrollPosX = -1;
    private int iScrollPosX2 = -1;
    private float fScrollNewMenuPosX = 0.0f;
    private final Rectangle clipBounds = new Rectangle();

    public final void initMenu(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements) {
        this.initMenu(menuTitle, iPosX, iPosY, iWidth, iHeight, menuElements, true, false, false);
    }

    public final void initMenu(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements, boolean visible, boolean closeable) {
        this.initMenu(menuTitle, iPosX, iPosY, iWidth, iHeight, menuElements, visible, false, closeable);
    }

    public final void initMenuWithBackButton(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements) {
        this.initMenu(menuTitle, iPosX, iPosY, iWidth, iHeight, menuElements, true, true, false);
    }

    public final void initMenuWithBackButton(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements, boolean closeable) {
        this.initMenu(menuTitle, iPosX, iPosY, iWidth, iHeight, menuElements, true, true, closeable);
    }

    public final void initMenuWithBackButton(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements, boolean visible, boolean closeable) {
        this.initMenu(menuTitle, iPosX, iPosY, iWidth, iHeight, menuElements, visible, true, closeable);
    }

    public final void initMenu(TitleM menuTitle, int iPosX, int iPosY, int iWidth, int iHeight, List<MenuElemUI> menuElements, boolean visible, boolean backButton, boolean closeable) {
        this.iMenuPosX = this.iNewMenuPositionX = iPosX;
        this.iPosX = this.iNewMenuPositionX;
        this.iMenuPosY = this.iNewMenuPositionY = iPosY;
        this.iPosY = this.iNewMenuPositionY;
        this.iWidth = iWidth;
        this.iHeight = iHeight;
        this.closeable = closeable;
        this.visible = visible;
        this.menuTitle = menuTitle;
        this.iMenuElemsSize = menuElements.size();
        if (backButton) {
            int tempMaxY = 0;
            for (int i = 0; i < this.iMenuElemsSize; ++i) {
                if (menuElements.get(i).getPosY() + menuElements.get(i).getHeightE() <= tempMaxY) continue;
                tempMaxY = menuElements.get(i).getPosY() + menuElements.get(i).getHeightE();
            }
            menuElements.get(0).setPosY(tempMaxY + CFG.PADD);
            if (tempMaxY > iHeight - CFG.PADD - menuElements.get(0).getHeightE()) {
                menuElements.get(0).setPosY(tempMaxY + CFG.PADD);
            } else {
                menuElements.get(0).setPosY(iHeight - menuElements.get(0).getHeightE());
            }
        }
        this.menuElem = menuElements;
        this.updateScrollable();
        this.updateMenuElements_IsInView();
    }

    public final void updateScrollable() {
        this.iMaxSliderPositionX = 0;
        this.iMaxSliderPosY = 0;
        for (int i = 0; i < this.iMenuElemsSize; ++i) {
            if (this.menuElem.get(i).getPosY() + this.menuElem.get(i).getHeightE() > this.iMaxSliderPosY) {
                this.iMaxSliderPosY = this.menuElem.get(i).getPosY() + this.menuElem.get(i).getHeightE();
            }
            if (this.menuElem.get(i).getPosXE() + this.menuElem.get(i).getWidthE() <= this.iMaxSliderPositionX) continue;
            this.iMaxSliderPositionX = this.menuElem.get(i).getPosXE() + this.menuElem.get(i).getWidthE();
        }
        this.scrollableX = this.iMaxSliderPositionX > this.getWidthM();
        boolean bl = this.scrollableY = this.iMaxSliderPosY > this.iHeight;
        if (this.scrollableY) {
            this.updateMenuPosY(this.iPosY);
        }
        if (this.scrollableX) {
            this.updateMenuPosX(this.iPosX);
        }
    }

    public void updateLang() {
    }

    public void update() {
        if (this.scrollModeY) {
            if (Math.abs(this.fScrollNewMenuPosY) > 1.0f) {
                this.updateMenuPosY(this.iMenuPosY + (int)this.fScrollNewMenuPosY);
                this.fScrollNewMenuPosY *= 0.97f;
            } else {
                this.scrollModeY = false;
            }
        }
        if (this.scrollModeX) {
            if (Math.abs(this.fScrollNewMenuPosX) > 1.0f) {
                this.updateMenuPosX(this.iMenuPosX + (int)this.fScrollNewMenuPosX);
                this.fScrollNewMenuPosX *= 0.97f;
            } else {
                this.scrollModeX = false;
            }
        }
        if (this.scrollableX && this.iNewMenuPositionX != this.iMenuPosX) {
            this.iMenuPosX = this.iNewMenuPositionX;
            this.updateMenuElements_IsInView();
        }
        if (this.iNewMenuPositionY != this.iMenuPosY) {
            this.iMenuPosY = this.iNewMenuPositionY;
            this.updateMenuElements_IsInView();
        }
    }

    public void extraAction() {
    }

    public void draw(SpriteBatch oSB, int iTranslateX, boolean sliderMenuIsActive) {
        this.draw(oSB, iTranslateX, 0, sliderMenuIsActive);
    }

    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.drawBackgroundMode(oSB, sliderMenuIsActive);
        int rectW = this.getWidthM();
        int rectH = this.getHeightM();
        int rectX = this.getPosX() + iTranslateX;
        int rectY = CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - rectH;
        this.clipBounds.set(rectX, rectY, rectW, rectH);
        oSB.flush();
        ScissorStack.pushScissors(this.clipBounds);
    }

    public final void drawMenuM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.drawMenuElements(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public void endClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        this.drawTitle(oSB, iTranslateX, iTranslateY, sliderMenuIsActive, this.getPosY());
        if (this.getCloseable()) {
            this.drawCloseButton(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final void drawHoverM(SpriteBatch oSB, int iTranslateX, int iTranslateY, int nMenuElementID) {
        try {
            this.getMenuElem(nMenuElementID).drawMEH2(oSB, this.getMenuPosX() + iTranslateX, this.getMenuPosY() + iTranslateY, this.getMenuElementIsActive(true, CFG.menus.getActiveMenuElemeID()));
        }
        catch (Exception exception) {
            
        }
    }

    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            if (this.scrollableY && this.getHeightM() < this.iMaxSliderPosY) {
                if (CFG.settingsGD.BETTER_UI) {
                    Color primary = BetterUI_Manager.getPrimaryColor();
                    CFG.tmpColor.set(0.1f, 0.1f, 0.1f, 0.8f);
                    oSB.setColor(CFG.tmpColor);
                    Images.pix.draw(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, CFG.PADD * 2, this.getHeightM());
                    CFG.tmpColor.set(primary.r, primary.g, primary.b, 0.6f);
                    oSB.setColor(CFG.tmpColor);
                    int scrollH = Math.max(20, this.getHeightM() * this.getHeightM() / this.iMaxSliderPosY);
                    int scrollY = (this.getHeightM() - scrollH) * (this.getPosY() - this.getMenuPosY()) / (this.iMaxSliderPosY - this.getHeightM());
                    Images.pix.draw(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() + scrollY + iTranslateY, CFG.PADD * 2 - 2, scrollH);
                    oSB.setColor(Color.WHITE);
                    return;
                }
                CFG.tmpColor.set(0.22f, 0.22f, 0.3f, 1.0f);
                oSB.setColor(CFG.tmpColor);
                IMGManager.getIMG(Images.scrollPosition).draw2O(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.scrollPosition).getHeight() + iTranslateY, IMGManager.getIMG(Images.scrollPosition).getWidth(), this.getHeightM() - IMGManager.getIMG(Images.scrollPosition).getHeight());
                IMGManager.getIMG(Images.scrollPosition).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.scrollPosition).getHeight() + iTranslateY, false, true);
                if (CFG.menus.getSliderMenuMode()) {
                    CFG.tmpColor.set(0.0f, 0.0f, 0.08f, 1.0f);
                    oSB.setColor(CFG.tmpColor);
                } else {
                    CFG.tmpColor.set(0.098f, 0.098f, 0.16f, 1.0f);
                    oSB.setColor(CFG.tmpColor);
                }
                IMGManager.getIMG(Images.scrollPositionActive).draw2O(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + iTranslateX + 1, this.getPosY() + (this.getHeightM() - 100 * this.getHeightM() / this.iMaxSliderPosY * this.getHeightM() / 100) * (this.getPosY() - this.getMenuPosY()) / (this.iMaxSliderPosY - this.getHeightM()) - IMGManager.getIMG(Images.scrollPositionActive).getHeight() + iTranslateY, CFG.PADD * 2 - 2, this.getHeightM() * 100 / this.iMaxSliderPosY * this.getHeightM() / 100 - IMGManager.getIMG(Images.scrollPositionActive).getHeight());
                IMGManager.getIMG(Images.scrollPositionActive).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + iTranslateX + 1, this.getPosY() + (this.getHeightM() - 100 * this.getHeightM() / this.iMaxSliderPosY * this.getHeightM() / 100) * (this.getPosY() - this.getMenuPosY()) / (this.iMaxSliderPosY - this.getHeightM()) + this.getHeightM() * 100 / this.iMaxSliderPosY * this.getHeightM() / 100 - IMGManager.getIMG(Images.scrollPositionActive).getHeight() + iTranslateY, false, true);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (ArithmeticException arithmeticException) {
            
        }
    }

    public void drawMenuElements(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int menuPosY = this.getMenuPosY() + iTranslateY;
        int parentPosY = this.getPosY();
        int parentHeight = this.getHeightM();
        for (int i = this.iMenuElemsSize - 1; i >= 0; --i) {
            MenuElemUI elem = this.menuElem.get(i);
            if (!elem.getVisibleE() || !elem.getIsInView()) continue;
            
            
            if (menuPosY + elem.getPosY() + elem.getHeightE() < parentPosY || menuPosY + elem.getPosY() > parentPosY + parentHeight) {
                continue;
            }
            
            try {
                elem.drawE(oSB, this.getMenuPosX() + iTranslateX, menuPosY, this.getMenuElementIsActive(sliderMenuIsActive, i), this.scrollableY);
            }
            catch (Exception exception) {}
        }
    }

    public void updateMenuElements_IsInView() {
        for (int i = 0; i < this.iMenuElemsSize; ++i) {
            this.menuElem.get(i).setIsInView(this.getMenuElementIsInView(i));
        }
    }

    public void updateMenuElements_IsInView_X() {
        for (int i = 0; i < this.iMenuElemsSize; ++i) {
            this.menuElem.get(i).setIsInView(this.getMenuElementIsInView_X(i));
        }
    }

    private final boolean getMenuElementIsInView(int i) {
        return this.menuElem.get(i).getPosY() + this.menuElem.get(i).getHeightE() + this.getMenuPosY() >= this.getPosY() && this.menuElem.get(i).getPosY() + this.getMenuPosY() <= this.getPosY() + this.getHeightM();
    }

    private final boolean getMenuElementIsInView_X(int i) {
        return this.menuElem.get(i).getPosXE() + this.menuElem.get(i).getWidthE() + this.getMenuPosX() >= this.getPosX() && this.menuElem.get(i).getPosXE() + this.getMenuPosX() <= this.getPosX() + this.getWidthM();
    }

    public boolean getMenuElementIsActive(boolean sliderMenuIsActive, int i) {
        return sliderMenuIsActive ? i == CFG.menus.getActiveMenuElemeID() : false;
    }

    public void drawTitle(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive, int nPosY) {
        if (this.menuTitle != null) {
            this.menuTitle.drawT(oSB, iTranslateX, this.getPosX(), nPosY + iTranslateY, this.getWidthM(), sliderMenuIsActive);
        }
        if (sliderMenuIsActive) {
            if (CFG.menus.getSliderMenuResizeMode()) {
                this.drawMenuBorder(oSB);
                this.drawMenuResizeRect(oSB);
            } else if (CFG.menus.getSliderMenuTitleMode()) {
                this.drawMenuBorder(oSB);
            }
        }
    }

    public final void drawMenuBorder(SpriteBatch oSB) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            oSB.setColor(primary.r, primary.g, primary.b, 0.8f);
        } else {
            oSB.setColor(0.196f, 0.196f, 0.196f, 1.0f);
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX(), this.getPosY(), 1, this.getHeightM());
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getWidthM() - 1, this.getPosY(), 1, this.getHeightM());
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX(), this.getPosY(), this.getWidthM(), -1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX(), this.getPosY() + this.getHeightM() - 1, this.getWidthM(), -1);
        oSB.setColor(Color.WHITE);
    }

    public final void drawMenuResizeRect(SpriteBatch oSB) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            oSB.setColor(primary.r, primary.g, primary.b, 0.6f);
        } else {
            oSB.setColor(0.196f, 0.196f, 0.196f, 0.95f);
        }
        if (CFG.menus.getSliderMenuResizeLEFT()) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX(), this.getPosY() + this.getHeightM() - 1 - CFG.PADD * 6, CFG.PADD * 6, CFG.PADD * 6);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.35f);
            IMGManager.getIMG(Images.pickerEdge).drawO(oSB, this.getPosX(), this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pickerEdge).getHeight() * 2, IMGManager.getIMG(Images.pickerEdge).getWidth(), IMGManager.getIMG(Images.pickerEdge).getHeight(), true, false);
        } else {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getWidthM() - 1 - CFG.PADD * 6, this.getPosY() + this.getHeightM() - 1 - CFG.PADD * 6, CFG.PADD * 6, CFG.PADD * 6);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.35f);
            IMGManager.getIMG(Images.pickerEdge).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.pickerEdge).getWidth(), this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pickerEdge).getHeight() * 2, IMGManager.getIMG(Images.pickerEdge).getWidth(), IMGManager.getIMG(Images.pickerEdge).getHeight(), false, false);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawBackgroundMode(SpriteBatch oSB, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive && (CFG.menus.getSliderMenuResizeMode() || CFG.menus.getSliderMenuTitleMode())) {
            oSB.setColor(0.1f, 0.1f, 0.1f, 0.5f);
            IMGManager.getIMG(Images.pattern).draw2O(oSB, 0, -IMGManager.getIMG(Images.pattern).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
            oSB.setColor(Color.WHITE);
        }
    }

    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() + iTranslateX, this.getPosY() - this.menuTitle.getHeightT() + iTranslateY);
    }

    public final Image getCloseButtonImage(boolean sliderMenuIsActive) {
        if (CFG.menus.getSliderMenuCloseMode() && sliderMenuIsActive) {
            return IMGManager.getIMG(Images.btnhClose);
        }
        return IMGManager.getIMG(Images.btnClose);
    }

    public void actionEL(int nMenuElementID) {
        if (CFG.DEBUG_MODE) System.out.println("Menu: actionEL " + nMenuElementID + " elementClass:" + this.menuElem.get(nMenuElementID).getClass().getSimpleName());
        this.menuElem.get(nMenuElementID).actionElem(nMenuElementID);
    }

    public void actionELPPM(int nMenuElementID) {
        this.menuElem.get(nMenuElementID).actionElemPPM();
    }

    public void actionELSPM(int nMenuElementID) {
        this.menuElem.get(nMenuElementID).actionElemSPM();
    }

    public void onBackPressed() {
    }

    public void onMenuPressed() {
    }

    public void actionCloseMenu() {
        this.setVisibleM(false);
    }

    public void onHovered() {
    }

    public final void updateMenuPosX(int nMenuPosX) {
        try {
            if (nMenuPosX > this.getPosX()) {
                this.iNewMenuPositionX = this.getPosX();
                CFG.menus.setUpdateSliderMenuPosX(true);
            } else if (nMenuPosX < this.getWidthM() + this.getPosX() - this.iMaxSliderPositionX) {
                this.iNewMenuPositionX = this.getWidthM() + this.getPosX() - this.iMaxSliderPositionX;
                CFG.menus.setUpdateSliderMenuPosX(true);
            } else {
                this.iNewMenuPositionX = nMenuPosX;
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void updateMenuPosY(int nMenuPosY) {
        try {
            if (nMenuPosY > this.getPosY()) {
                this.iNewMenuPositionY = this.getPosY();
                CFG.menus.setUpdateSliderMenuPosY(true);
                this.scrollModeY = false;
            } else if (nMenuPosY < this.getHeightM() + this.getPosY() - this.iMaxSliderPosY) {
                this.iNewMenuPositionY = this.getHeightM() + this.getPosY() - this.iMaxSliderPosY;
                CFG.menus.setUpdateSliderMenuPosY(true);
                this.scrollModeY = false;
            } else {
                this.iNewMenuPositionY = nMenuPosY;
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void scrollTheMenu() {
        if (this.scrollableY && this.iScrollPosY > 0 && this.iScrollPosY2 > 0 && (float)Math.abs(this.iScrollPosY - this.iScrollPosY2) > 3.0f * CFG.DENSITY) {
            this.fScrollNewMenuPosY = (float)(this.iScrollPosY - this.iScrollPosY2) * 1.45f;
            this.scrollModeY = true;
        }
        if (this.scrollableX && this.iScrollPosX > 0 && this.iScrollPosX2 > 0 && Math.abs(this.iScrollPosX - this.iScrollPosX2) > 3) {
            this.fScrollNewMenuPosX = (float)(this.iScrollPosX - this.iScrollPosX2) * 1.45f;
            this.scrollModeX = true;
        }
        this.resetScrollINFO();
    }

    private final void resetScrollINFO() {
        this.iScrollPosX2 = -1;
        this.iScrollPosX = -1;
        this.iScrollPosY2 = -1;
        this.iScrollPosY = -1;
    }

    public final void stopScrolling() {
        this.resetScrollINFO();
        this.scrollModeX = false;
        this.scrollModeY = false;
    }

    public final void updatedButtonsWidth(int iStartPosX, int iMinWidth) {
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            iStartPosX += this.updateButtonWidth(i, iStartPosX, iMinWidth) + CFG.PADD;
        }
        this.updateScrollable();
    }

    public final void updatedButtonsWidth_Padding(int iStartPosX, int iMinWidth, int iPadding) {
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            iStartPosX += this.updateButtonWidth(i, iStartPosX, iMinWidth) + iPadding;
        }
        this.updateScrollable();
    }

    public final void updatedButtonsWidthFromToID(int iStartButtonID, int iEndButtonID, int iStartPosX, int iMinWidth) {
        for (int i = iStartButtonID; i < iEndButtonID; ++i) {
            iStartPosX += this.updateButtonWidth(i, iStartPosX, iMinWidth) + CFG.PADD;
        }
        this.updateScrollable();
    }

    public final int updateButtonWidth(int iButtonID, int iStartPosX, int iMinWidth) {
        if (this.getMenuElem(iButtonID).getTextWidthU() + CFG.PADD * 4 > iMinWidth) {
            this.getMenuElem(iButtonID).setWidthE(this.getMenuElem(iButtonID).getTextWidthU() + CFG.PADD * 4);
        } else {
            this.getMenuElem(iButtonID).setWidthE(iMinWidth);
        }
        this.getMenuElem(iButtonID).setPosX(iStartPosX);
        this.updateScrollable();
        return this.getMenuElem(iButtonID).getWidthE();
    }

    public final int getMenuElemsSize() {
        return this.iMenuElemsSize;
    }

    public final MenuElemUI getMenuElem(int iID) {
        return this.menuElem.get(iID);
    }

    public final void setMenuElem(int iID, MenuElemUI nMenuElement) {
        this.menuElem.set(iID, null);
        this.menuElem.set(iID, nMenuElement);
    }

    public int getPosX() {
        return this.iPosX;
    }

    public void setPosX(int iPosX) {
        this.iPosX = iPosX;
        this.iMenuPosX = iPosX;
        this.updateMenuPosX(this.iMenuPosX);
    }

    public final void setPosX_Force(int iPosX) {
        this.iPosX = iPosX;
        this.iMenuPosX = iPosX;
        this.iNewMenuPositionX = iPosX;
        CFG.menus.setUpdateSliderMenuPosX(false);
    }

    public int getPosY() {
        return this.iPosY;
    }

    public void setPosY(int iPosY) {
        this.iPosY = iPosY;
        this.iMenuPosY = iPosY;
        this.updateMenuPosY(this.iMenuPosY);
    }

    public int getWidthM() {
        return this.iWidth;
    }

    public boolean setWidth(int iWidth) {
        if (iWidth < CFG.GAMEWIDTH) {
            if (iWidth >= this.getMinWidth()) {
                this.iWidth = iWidth;
                return true;
            }
        } else {
            this.iWidth = CFG.GAMEWIDTH;
            return true;
        }
        this.iWidth = this.getMinWidth();
        return false;
    }

    public final int getMinWidth() {
        try {
            return CFG.PADD * 2;
        }
        catch (NullPointerException ex) {
            return CFG.PADD * 2;
        }
    }

    public int getHeightM() {
        return this.iHeight;
    }

    public final void autoExpandHeight(int maxHeight) {
        if (this.iMaxSliderPosY > this.iHeight) {
            int newHeight = Math.min(this.iMaxSliderPosY + CFG.PADD, maxHeight);
            if (newHeight > this.iHeight) {
                this.setHeight(newHeight);
            }
        }
    }

    public void setHeight(int iHeight) {
        this.iHeight = iHeight;
        if (iHeight < this.getMinHeight()) {
            this.iHeight = this.getMinHeight();
        }
        if (iHeight + this.getPosY() >= CFG.GAMEHEIGHT) {
            this.iHeight = CFG.GAMEHEIGHT - this.getPosY();
        }
        this.updateScrollable();
    }

    public final int getMinHeight() {
        return CFG.PADD + CFG.BUTTON_H;
    }

    public final TitleM getTitleM() {
        return this.menuTitle;
    }

    public final boolean getScrollableY() {
        return this.scrollableY;
    }

    public final void setMenuPosY(int iMenuPosY) {
        this.updateMenuPosY(iMenuPosY);
    }

    public int getMenuPosY() {
        return this.iMenuPosY;
    }

    public final int getNewMenuPosY() {
        return this.iNewMenuPositionY;
    }

    public final int getNewMenuPosX() {
        return this.iNewMenuPositionX;
    }

    public final boolean getScrollableX() {
        return this.scrollableX;
    }

    public final void setMenuPosX(int iMenuPosX) {
        this.updateMenuPosX(iMenuPosX);
    }

    public int getMenuPosX() {
        return this.iMenuPosX;
    }

    public boolean getVisibleM() {
        return this.visible;
    }

    public void setVisibleM(boolean visible) {
        this.visible = visible;
    }

    public final boolean getCloseable() {
        return this.closeable;
    }

    public final boolean getMoveable() {
        return this.menuTitle == null ? false : this.menuTitle.getMoveable();
    }

    public final boolean getResizable() {
        return this.menuTitle == null ? false : this.menuTitle.getResizable();
    }

    public final void setScrollPosY(int iScrollPosY) {
        this.iScrollPosY2 = this.iScrollPosY;
        this.iScrollPosY = iScrollPosY;
    }

    public final int getScrollPosY() {
        return this.iScrollPosY;
    }

    public final void setScrollPosX(int iScrollPosX) {
        this.iScrollPosX2 = this.iScrollPosX;
        this.iScrollPosX = iScrollPosX;
    }

    public final boolean getScrollModeY() {
        return this.scrollModeY;
    }
}

