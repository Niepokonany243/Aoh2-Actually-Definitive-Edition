
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Chatbox;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Flag_JustFrame2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_FA_Top
extends Menu {
    public List<FSF> sF = new ArrayList<FSF>();
    public int boxHeight = 100;

    public static int getWindowWidth() {
        return CFG.GAMEWIDTH - AoCGame.LEFT;
    }

    public Menu_InGame_FA_Top() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Flag_JustFrame2(CFG.PADD * 2, CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                if (CFG.FLIP_Y_CIV_FLAG || CFG.FLIP_Y_CIV_FLAG_COUNTER == 3) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.FLIP_Y_CIV_FLAG_COUNTER == 3) {
                        if (CFG.FLIP_Y_CIV_FLAG) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big("Psst! ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Text_Big("Hey kid!"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text("Wanna buy some juicy DLC to flip flag back?", CFG.COLOR_NEUTRAL));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Text("Just kidding!"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text("That would be a Paradox to pay for that!", CFG.COLOR_NEUTRAL));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Text(":(", CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Chatbox(CFG.lang.get("TypeMessage") + "..", 1, "", CFG.PADD * 2, ((MenuElemUI)menuElements.get(0)).getPosXE() + ((MenuElemUI)menuElements.get(0)).getWidthE() + CFG.PADD, CFG.PADD * 2, Math.max(CFG.BUTTON_W, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - ((MenuElemUI)menuElements.get(0)).getWidthE() - ((MenuElemUI)menuElements.get(0)).getPosXE() * 2 - CFG.PADD * 7 - CFG.BUTTON_W * 7 - CFG.PADD), ((MenuElemUI)menuElements.get(0)).getHeightE(), true));
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.editorGame).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.editorGame).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.editorGame).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Options"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.editorGame, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("AoH2:DE"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W - CFG.PADD, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.icon_save).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.icon_save).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.icon_save).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SaveYourProgress"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.icon_save, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W * 2 - CFG.PADD * 2, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.stats).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.stats).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.stats).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Statistics"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.stats, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F5", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("" + CFG.core.getWarsSize(), -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W * 3 - CFG.PADD * 3, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){
            int lastWarsSize;
            {
                this.lastWarsSize = 0;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.33f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.25f));
                }
                IMGManager.getIMG(Images.diploWar).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.diploWar).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploWar).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (CFG.core.getWarsSize() != this.lastWarsSize) {
                    this.lastWarsSize = CFG.core.getWarsSize();
                    this.setTextE("" + CFG.core.getWarsSize());
                }
                if (isActive) {
                    Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                } else {
                    Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                }
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT : (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_HOVER_TITLE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CurrentWars"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big(": " + CFG.core.getWarsSize(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W * 4 - CFG.PADD * 4, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.economy).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.economy).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W * 5 - CFG.PADD * 5, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.pop).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pop).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameBox("", -1, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4 - CFG.PADD * 2 - CFG.BUTTON_W - CFG.BUTTON_W * 6 - CFG.PADD * 6, ((MenuElemUI)menuElements.get(0)).getPosY(), CFG.BUTTON_W, ((MenuElemUI)menuElements.get(0)).getHeightE(), true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                } else {
                    oSB.setColor(Color.WHITE);
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.news).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.news).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.news).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GrowthAndDecline"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.news, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        this.initMenu(null, CFG.PADD * 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2, Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4, CFG.PADD * 4 + IMGManager.getIMG(Images.topFlagFrame).getHeight(), menuElements, false, false);
        this.boxHeight = CFG.PADD * 4 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - Core.PADDING + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + Core.PADDING * 2, IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + Core.PADDING);
        IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, this.getPosX() + this.getWidthM() + Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + iTranslateX, this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + Core.PADDING, true);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 - 1 + iTranslateY, this.getWidthM() - 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (CFG.FLIP_Y_CIV_FLAG_COUNTER == 3) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE(), 1);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void endClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            if (CFG.FLIP_Y_CIV_FLAG) {
                if (CFG.oR.nextInt(1000) < 347) {
                    this.cSF();
                }
                if (!this.sF.isEmpty()) {
                    for (int i = this.sF.size() - 1; i >= 0; --i) {
                        if (this.sF.get((int)i).iH > 0) {
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f + this.sF.get((int)i).a));
                            this.sF.get(i).update(CFG.GAMEWIDTH, this.boxHeight);
                            CFG.core.getCiv(this.sF.get((int)i).c).getFlagC().draw(oSB, iTranslateX + this.sF.get((int)i).x, iTranslateY + this.sF.get((int)i).y, this.sF.get((int)i).iW, this.sF.get((int)i).iH);
                            if (this.sF.get((int)i).iH > 1) continue;
                            this.sF.remove(i);
                            continue;
                        }
                        this.sF.remove(i);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            this.sF.clear();
        }
        oSB.setColor(Color.WHITE);
    }

    public void cSF() {
        this.sF.add(new FSF(CFG.oR.nextInt(CFG.GAMEWIDTH - 44), 0, 44, 27));
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    public static final void clickOptions() {
        CFG.core.resetChooseProvinceData();
        CFG.menus.setVisible_InGame_ProviRecruit(false);
        CFG.menus.setVisible_InGame_ProvinceRecruitInstantly(false);
        CFG.menus.setVisible_InGame_ProvinceDisband(false);
        int tX = Touch.getMousePosX();
        int tY = Touch.getMousePosY();
        Touch.setMousePosXY(CFG.GAMEWIDTH / 2, CFG.GAMEHEIGHT / 2);
        MapScale.SCALE_ANIMATION_TIME = 225;
        CFG.map.getMpS().setNewCurrentScaleByButton2(-0.175f);
        Touch.setMousePosXY(tX, tY);
        CFG.menus.setVisible_InGame_FlagAction(false);
        CFG.menus.setVisible_InGame_Options(true);
    }

    public static final void clickStats() {
        if (!CFG.menus.getVisible_Menu_InGame_Outliner()) {
            CFG.menus.setVisible_InGame_FlagAction(false);
            CFG.menus.setVisible_Menu_InGame_Outliner(true);
        } else {
            CFG.menus.setVisible_InGame_FlagAction(false);
            CFG.menus.setVisible_Menu_InGame_Outliner(false);
        }
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                boolean bl = CFG.FLIP_Y_CIV_FLAG = !CFG.FLIP_Y_CIV_FLAG;
                if (CFG.FLIP_Y_CIV_FLAG) {
                    if ((CFG.FLIP_Y_CIV_FLAG_COUNTER = (byte)(CFG.FLIP_Y_CIV_FLAG_COUNTER + 1)) < 0) {
                        CFG.FLIP_Y_CIV_FLAG_COUNTER = 0;
                    } else if (CFG.FLIP_Y_CIV_FLAG_COUNTER > 10) {
                        CFG.FLIP_Y_CIV_FLAG_COUNTER = 0;
                    }
                }
                this.getMenuElem(iID).buildElemHover();
                break;
            }
            case 1: {
                CFG.showKeyboard_Commands();
                break;
            }
            case 2: {
                Menu_InGame_FA_Top.clickOptions();
                break;
            }
            case 3: {
                CFG.menus.setVisible_InGame_FlagAction(false);
                CFG.setDialogType(DialogType.SAVE_THE_GAME);
                break;
            }
            case 4: {
                if (GameValues.gvInGame.USE_IN_GAME_OLD_STATS_MENU) {
                    Menu_InGame_FA_Top.clickStats();
                    break;
                }
                CFG.menus.setVisibleInGame_Stats(!CFG.menus.getVisibleInGame_Stats());
                if (!CFG.menus.getVisibleInGame_Stats()) break;
                CFG.menus.setVisible_InGame_FlagAction(false);
                break;
            }
            case 5: {
                if (!CFG.menus.getVisibleInGame_Wars()) {
                    CFG.menus.setVisible_InGame_FlagAction(false);
                    CFG.menus.rebuildInGame_Wars();
                    break;
                }
                CFG.menus.setVisible_InGame_FlagAction(false);
                CFG.menus.setVisibleInGame_Wars(false);
                break;
            }
            case 6: {
                if (!CFG.menus.getVisibleInGame_WorldEconomy()) {
                    CFG.menus.setVisible_InGame_FlagAction(false);
                    CFG.menus.rebuildInGame_WorldEconomy();
                    break;
                }
                CFG.menus.setVisible_InGame_FlagAction(false);
                CFG.menus.setVisibleInGame_WorldEconomy(false);
                break;
            }
            case 7: {
                if (!CFG.menus.getVisibleInGame_WorldPopulation()) {
                    CFG.menus.setVisible_InGame_FlagAction(false);
                    CFG.menus.rebuildInGame_WorldPopulation();
                    break;
                }
                CFG.menus.setVisible_InGame_FlagAction(false);
                CFG.menus.setVisibleInGame_WorldPopulation(false);
                break;
            }
            case 8: {
                CFG.menus.setVisible_InGame_FlagAction(false);
                CFG.menus.rebuildInGame_WorldNewsGrowth();
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            CFG.menus.getKeyboard().setVisibleM(false);
        }
    }

    public class FSF {
        int x;
        int y;
        int iW;
        int iH;
        int c = 0;
        float a = 0.0f;

        public FSF(int x, int y, int iW, int iH) {
            this.x = x;
            this.y = y;
            float s = 0.65f + (float)CFG.oR.nextInt(700) / 1000.0f;
            this.a = -0.15f + (float)CFG.oR.nextInt(300) / 1000.0f;
            this.iW = (int)((float)iW * s);
            this.iH = (int)((float)iH * s);
            this.c = CFG.oR.nextInt(CFG.core.getCivsSize());
        }

        public void update(int boxWidth, int boxHeight) {
            this.y += 2;
            this.x += CFG.oR.nextBoolean() ? 1 : -1;
            if (this.x < 0) {
                this.x = 0;
            }
            if (this.x + this.iW > boxWidth) {
                this.x = boxWidth - this.iW;
            }
            if (this.y + this.iH >= boxHeight) {
                if (this.iH > 0) {
                    this.iH -= 2;
                }
                if (this.iW < 80) {
                    ++this.iW;
                }
            }
        }
    }
}

