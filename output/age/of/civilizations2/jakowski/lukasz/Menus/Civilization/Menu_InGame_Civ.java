/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Rank;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextProvincesTech;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Civ
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public String sGreatPower;
    public int iGreatPowerWidth = 0;
    public static final float FONT_SIZE_INFO = 0.8f;

    public static int getMenuCivInfoWidth() {
        return CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W / 4;
    }

    public Menu_InGame_Civ() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        menuElements.add(new Button_Rank("1", CFG.PADD + ButtonFlagBig.getButtonW() - IMGManager.getIMG(Images.top_circle).getWidth(), Menu_InGame_Civ.getMenuPadding() + ButtonFlagBig.getButtonH() - IMGManager.getIMG(Images.top_circle).getHeight()){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_RankOfCiv(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextScrollable(null, ButtonFlagBig.getButtonW() + CFG.PADD * 3, CFG.PADD * 3, menuW - ButtonFlagBig.getButtonW() - CFG.PADD * 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.COLOR_TEXT_CIV_NAME, 1.0f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("UpdateCivilizationName") + ".", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploAZ, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Lord") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassal") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName()));
                    nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getName()));
                nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Religion") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID()).getName()));
                nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                    super.draw_Element(oSB, iTranslateX + CFG.PADD + (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), iTranslateY, isActive, scrollableY);
                    CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() + (int)((float)this.getHeightE() - (float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())) / 2 + iTranslateY, (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())));
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.flagRectSmall).getHeight() + (int)((float)this.getHeightE() - (float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())) / 2 + iTranslateY, (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())));
                } else {
                    super.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                }
            }

            @Override
            public int getTextWidthU() {
                try {
                    if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                        return super.getTextWidthU() + CFG.PADD + (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_InGame_Civ.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight()));
                    }
                    return super.getTextWidthU();
                }
                catch (IndexOutOfBoundsException ex) {
                    return super.getTextWidthU();
                }
            }
        });
        menuElements.add(new ButtonFlagBig(CFG.PADD, Menu_InGame_Civ.getMenuPadding(), true, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ShowHideColorPicker"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pickerIcon, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivRank") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getRankPos() + "/" + CFG.core.getCivsSize(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(CFG.getCivilizationRanking_IMG_STAR_CIVID(CFG.getActiveCivInfoId()), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public int getFlagCivID() {
                return CFG.activeCivInfoId;
            }

            @Override
            public void actionElemPPM() {
                Menu_MM.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eMM);
            }
        });
        menuElements.add(new TextProvincesTech(null, ButtonFlagBig.getButtonW() + CFG.PADD * 3, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT, CFG.FONT_REGULAR_SMALL){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_ProvincesOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Civ.getMenuCivInfoWidth() - ButtonFlagBig.getButtonW() - CFG.PADD * 5 - 2;
            }
        });
        menuElements.add(new Text("", ButtonFlagBig.getButtonW() + CFG.PADD * 3, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT, CFG.FONT_REGULAR_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
                oSB.flush();
                ScissorStack.pushScissors(clipBounds);
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException illegalStateException) {
                    // empty catch block
                }
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LeaderOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Civ.getMenuCivInfoWidth() - ButtonFlagBig.getButtonW() - CFG.PADD * 5 - 2;
            }
        });
        menuElements.add(new Button_Transparent(0, 0, menuW - 1, ButtonFlagBig.getButtonH() + Menu_InGame_Civ.getMenuPadding() * 2 - 1, false));
        this.initMenu(new TitleM("", 0, false, false), AoCGame.LEFT, Menu_InGame_Civ.getUseMenu_UI2() ? Menu_InGame_Civ.getMenuY_UI2() : IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3, menuW, Menu_InGame_Civ.getMenuH_UI2(), menuElements, false, true);
        this.updateLang();
    }

    public static boolean getUseMenu_UI2() {
        return CFG.getUIScale() > 0;
    }

    public static int getMenuY_UI2() {
        return CFG.PADD * 3 + CFG.TEXT_HEIGHT_DEFAULT;
    }

    public static int getMenuH_UI2() {
        return ButtonFlagBig.getButtonH() + Menu_InGame_Civ.getMenuPadding() * 2;
    }

    public static int getMenuPadding() {
        return Menu_InGame_Civ.getUseMenu_UI2() ? CFG.PADD : CFG.PADD * 2;
    }

    @Override
    public void updateLang() {
        try {
            this.getMenuElem(1).setTextE(CFG.getActiveCivInfoId() > 0 ? CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName() : "");
        }
        catch (IndexOutOfBoundsException ex) {
            this.getMenuElem(1).setTextE("");
            CFG.setActiveCivInfoId(0);
        }
        this.getMenuElem(3).setTextE(CFG.lang.get("Provinces") + ": ");
        this.sGreatPower = CFG.lang.get("GreatPower");
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sGreatPower);
        this.iGreatPowerWidth = (int)CFG.glyphLay.width;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(Images.victoryPoints).getHeight();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        if (CFG.core.getCiv((int)CFG.getActiveCivInfoId()).iLeague > 7 || CFG.core.getCiv(CFG.getActiveCivInfoId()).getRankPos() < 11) {
            IMGManager.getIMG(Images.dialog_title).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) + iTranslateY, this.iGreatPowerWidth + CFG.PADD * 5 + (int)((float)IMGManager.getIMG(Images.rank).getWidth() * this.getImageScale()), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true, false);
            IMGManager.getIMG(Images.rank).drawO(oSB, 2 + this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(Images.rank).getHeight() * this.getImageScale()) / 2 + 1 + iTranslateY - IMGManager.getIMG(Images.rank).getHeight(), (int)((float)IMGManager.getIMG(Images.rank).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.rank).getHeight() * this.getImageScale()));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sGreatPower, this.getPosX() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.rank).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + 1 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + Core.PADDING, true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.275f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() - 1);
        oSB.setColor(Color.WHITE);
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
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
        switch (iID) {
            case 0: {
                if (CFG.menus.getVisibleInGame_Rank()) {
                    CFG.menus.setVisibleInGame_Rank(false);
                    break;
                }
                CFG.menus.rebuildInGame_Rank();
                break;
            }
            case 1: {
                Keyboard.commandsMode = false;
                Keyboard.changeAllianceNameMode = -1;
                Keyboard.mapModeSearch = false;
                Keyboard.rankSearch = false;
                Keyboard.changeCivilizationNameMode = CFG.getActiveCivInfoId();
                CFG.updateKeyboard_Actions();
                CFG.showKeyboard();
                break;
            }
            case 2: {
                CFG.menus.getColorPicker().setPosX(CFG.GAMEWIDTH - CFG.menus.getColorPicker().getWidth() - CFG.PADD * 4);
                CFG.menus.getColorPicker().setPosY(this.getPosY() + CFG.PADD * 2);
                CFG.menus.getColorPicker().setVisible(!CFG.menus.getColorPicker().getVisible(), ColorPicker_AoC.PickerAction.ACTIVE_CIVILIZATION_COLOR);
                if (!CFG.menus.getColorPicker().getVisible()) break;
                CFG.mapModesManager.disableAllViews();
                break;
            }
            case 3: {
                try {
                    if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs() <= 0) break;
                    Menu_InGame_CivilizationView.iCivID = CFG.getActiveCivInfoId();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosX = CFG.map.getMpC().getPX();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY = CFG.map.getMpC().getPY();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).fBefore_Scale = CFG.map.getMpS().getCurrSc();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.menus.setMenuID(View.eINGAME_CIV_VIEW);
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.core.enableDrawCivilizationRegions_FogOfWar(Menu_InGame_CivilizationView.iCivID, 0);
                    } else {
                        CFG.core.enableDrawCivilizationRegions(Menu_InGame_CivilizationView.iCivID, 0);
                    }
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.toastM.addM(CFG.core.getCiv(Menu_InGame_CivilizationView.iCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(1500);
                }
                catch (Exception ex) {
                    Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                }
                break;
            }
            case 4: {
                if (CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.leaderData.getWiki().length() <= 0) break;
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.leaderData.getWiki();
                CFG.setDialogType(DialogType.GO_TO_WIKI_SCENARIO);
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean hideAnimation) {
        if (hideAnimation != Menu_InGame_Civ.hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        Menu_InGame_Civ.hideAnimation = hideAnimation;
    }
}

