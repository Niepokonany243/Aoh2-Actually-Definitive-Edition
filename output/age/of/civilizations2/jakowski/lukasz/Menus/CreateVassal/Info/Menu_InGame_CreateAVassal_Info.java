
package age.of.civilizations2.jakowski.lukasz.Menus.CreateVassal.Info;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig_IMG;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CreateAVassal_Info
extends Menu {
    public static boolean hideAnimation = true;

    public Menu_InGame_CreateAVassal_Info() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextScrollable(null, ButtonFlagBig.getButtonW() + CFG.PADD * 4, CFG.PADD * 3, CFG.CIV_INFO_MENU_WIDTH - ButtonFlagBig.getButtonW() - CFG.PADD * 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.COLOR_TEXT_CIV_NAME, 1.0f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectVassal"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.draw_Element(oSB, iTranslateX + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), iTranslateY, isActive, scrollableY);
                try {
                    CFG.createVassalData.getFlagOfCiv().drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - CFG.createVassalData.getFlagOfCiv().getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight()))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
                }
                catch (NullPointerException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight()))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.flagRectSmall).getHeight() + (int)((float)this.getHeightE() - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
            }

            @Override
            public int getTextWidthU() {
                try {
                    return super.getTextWidthU() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_CreateAVassal_Info.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight()));
                }
                catch (IndexOutOfBoundsException ex) {
                    return super.getTextWidthU();
                }
            }
        });
        menuElements.add(new ButtonFlagBig_IMG(CFG.PADD, CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ShowHideColorPicker"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.pickerIcon, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getFlagCivID() {
                return CFG.activeCivInfoId;
            }
        });
        menuElements.add(new Text(null, ButtonFlagBig.getButtonW() + CFG.PADD * 4, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT, CFG.FONT_REGULAR_SMALL){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, this.getColor(isActive));
                Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.getCurr(), this.getPosXE() + this.getTextWidthU() + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProvSelected().getProvSize(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }
        });
        this.initMenu(new TitleM("", 0, false, false), 0 + AoCGame.LEFT, CFG.BUTTON_H + CFG.PADD * 3, CFG.CIV_INFO_MENU_WIDTH, ButtonFlagBig.getButtonH() + CFG.PADD * 4, menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        try {
            this.getMenuElem(0).setTextE(CFG.createVassalData.sCivTag == null ? CFG.lang.get("SelectCivilization") : CFG.lang.getCiv(CFG.createVassalData.sCivTag));
        }
        catch (IndexOutOfBoundsException ex) {
            this.getMenuElem(0).setTextE(CFG.lang.get("SelectCivilization"));
        }
        catch (NullPointerException ex) {
            this.getMenuElem(0).setTextE(CFG.lang.get("SelectCivilization"));
        }
        this.getMenuElem(2).setTextE(CFG.lang.get("Provinces") + ": ");
        this.getMenuElem(2).setCurr(CFG.core.getProvSelected().getProvSize());
        int elementH2 = (this.getHeightM() - this.getMenuElem(1).getPosY() * 2 - CFG.PADD * 4) / 3;
        this.getMenuElem(0).setPosY(this.getMenuElem(1).getPosY());
        this.getMenuElem(0).setHeightE(elementH2);
        this.getMenuElem(2).setPosY(this.getMenuElem(1).getPosY() + CFG.PADD + elementH2);
        this.getMenuElem(2).setHeightE(elementH2);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + Core.PADDING, true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.r, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.g, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.b, 1.0f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightM() - this.getHeightM() / 2 + iTranslateY, this.getWidthM() - 2, this.getHeightM() / 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - 2 + iTranslateY, this.getWidthM() - 2, 1);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - 1 + iTranslateY, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1 + iTranslateY, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.sliderGradient).getHeight() - 1 + iTranslateY, this.getWidthM() / 4, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - 2 - this.getWidthM() / 4 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.sliderGradient).getHeight() - 1 + iTranslateY, this.getWidthM() / 4, 1, true, false);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM(), true, false);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
    }

    private final float getImageScale(int nImageHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight : 1.0f;
    }

    @Override
    public void actionEL(int iID) {
        CFG.menus.setOrderOfMenu_InGame_CreateAVassal_Info();
        switch (iID) {
            case 0: 
            case 2: {
                CFG.menus.setVisible_InGame_CreateVassal_Civs(!CFG.menus.getVisible_InGame_CreateVassal_Civs());
                break;
            }
            case 1: {
                CFG.menus.getColorPicker().setPosX(CFG.GAMEWIDTH - CFG.menus.getColorPicker().getWidth() - CFG.PADD * 4);
                CFG.menus.getColorPicker().setPosY(this.getPosY() + CFG.PADD * 2);
                CFG.menus.getColorPicker().setVisible(!CFG.menus.getColorPicker().getVisible(), ColorPicker_AoC.PickerAction.CREATE_VASSAL_COLOR);
                if (!CFG.menus.getColorPicker().getVisible()) break;
                CFG.mapModesManager.disableAllViews();
            }
        }
    }
}

