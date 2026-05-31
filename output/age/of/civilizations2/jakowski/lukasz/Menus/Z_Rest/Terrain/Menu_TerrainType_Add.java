/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Terrain;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_TerrainType_Add
extends Menu {
    private String sName;
    private int iNameWidth;
    private String sIconFileName;
    private final String sIconFileNameType = ".png";

    public Menu_TerrainType_Add() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_TerrainType_Add.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_TerrainType_Add.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TerrainTypeName") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Save") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_TerrainType_Add.this.sIconFileName + ": \"" + super.getTextE() + ".png" + "\"";
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Path") + ": "));
                nData.add(new ME_Hover_2Type_Text("UI/" + CFG.getResPath() + "terrain/", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic(null, -1, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.editorTerrain_Data2.getColor().getR(), CFG.editorTerrain_Data2.getColor().getG(), CFG.editorTerrain_Data2.getColor().getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 3 + CFG.PADD * 5, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 3 + CFG.PADD * 5, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 3 + CFG.PADD * 5, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 4 + CFG.PADD * 6, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 4 + CFG.PADD * 6, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() < 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 4 + CFG.PADD * 6, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 6 + CFG.PADD * 8, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 6 + CFG.PADD * 8, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 6 + CFG.PADD * 8, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 7 + CFG.PADD * 9, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 7 + CFG.PADD * 9, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 7 + CFG.PADD * 9, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 8 + CFG.PADD * 10, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 8 + CFG.PADD * 10, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() < 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 8 + CFG.PADD * 10, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 5 + CFG.PADD * 7, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 5 + CFG.PADD * 7, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() < 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 95) {
                    nCurrent = 95;
                } else if (nCurrent < -95) {
                    nCurrent = -95;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 5 + CFG.PADD * 7, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 9 + CFG.PADD * 11, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 9 + CFG.PADD * 11, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr(), this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 2) {
                    nCurrent = 2;
                } else if (nCurrent < 0) {
                    nCurrent = 0;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 9 + CFG.PADD * 11, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, CFG.BUTTON_H * 10 + CFG.PADD * 12, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("-1%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 10 + CFG.PADD * 12, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true){
            private int iCurrent;

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                CFG.drawTextDefaultWithShadow(oSB, (this.getCurr() > 0 ? "+" : "") + this.getCurr() + "%", this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                if (nCurrent > 0) {
                    nCurrent = 0;
                } else if (nCurrent < -40) {
                    nCurrent = -40;
                }
                this.iCurrent = nCurrent;
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 10 + CFG.PADD * 12, CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("+1%", CFG.COLOR_NEGATIVE_1));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("TerrainTypeName");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.sIconFileName = CFG.lang.get("IconName");
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.editorTerrain_Data2.getName());
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.editorTerrain_Data2.getIconName());
        this.getMenuElem(4).setTextE(CFG.lang.get("Color"));
        this.getMenuElem(6).setTextE(CFG.lang.get("DefenseModifier") + ": ");
        this.getMenuElem(9).setTextE(CFG.lang.get("MilitaryUpkeep") + ": ");
        this.getMenuElem(12).setTextE(CFG.lang.get("PopulationGrowthModifier") + ": ");
        this.getMenuElem(15).setTextE(CFG.lang.get("EconomyGrowthModifier") + ": ");
        this.getMenuElem(18).setTextE(CFG.lang.get("BuildCostModifier") + ": ");
        this.getMenuElem(21).setTextE(CFG.lang.get("MovementCostModifier") + ": ");
        this.getMenuElem(24).setTextE(CFG.lang.get("BaseProvinceValue") + ": ");
        this.getMenuElem(27).setTextE(CFG.lang.get("BaseDevelopmentLevel") + ": ");
        this.getMenuElem(6).setCurr((int)(CFG.editorTerrain_Data2.getDefensiveModifier() * 100.0f));
        this.getMenuElem(9).setCurr((int)(CFG.editorTerrain_Data2.getBuildCostModifier() * 100.0f));
        this.getMenuElem(12).setCurr((int)(CFG.editorTerrain_Data2.getPopulationGrowthModifier() * 100.0f));
        this.getMenuElem(15).setCurr((int)(CFG.editorTerrain_Data2.getEconomyGrowthModifier() * 100.0f));
        this.getMenuElem(18).setCurr((int)(CFG.editorTerrain_Data2.getBuildCostModifier() * 100.0f));
        this.getMenuElem(21).setCurr((int)(CFG.editorTerrain_Data2.getMovementCost() * 100.0f));
        this.getMenuElem(24).setCurr(CFG.editorTerrain_Data2.getBaseProvinceValue());
        this.getMenuElem(27).setCurr((int)(CFG.editorTerrain_Data2.getBaseDevelopmentLevel() * 100.0f));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.showKeyboard();
                return;
            }
            case 2: {
                if (this.getMenuElem(1).getTextE().equals("")) {
                    CFG.showKeyboard(1);
                    CFG.toastM.addM(this.sName);
                } else if (this.getMenuElem(3).getTextE().equals("")) {
                    CFG.showKeyboard(3);
                    CFG.toastM.addM("UI/" + CFG.getResPath() + "terrain/");
                    CFG.toastM.setTimeInView(3500);
                } else {
                    CFG.toastM.addM(CFG.lang.get("Saved"), CFG.COLOR_HOVER_TITLE);
                    CFG.editorTerrain_Data2.setName(this.getMenuElem(1).getTextE());
                    CFG.editorTerrain_Data2.setIconName(this.getMenuElem(3).getTextE());
                    CFG.editorTerrain_Data2.setDefensiveModifier((float)this.getMenuElem(6).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setMilitaryUpkeepModifier((float)this.getMenuElem(9).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setPopulationGrowthModifier((float)this.getMenuElem(12).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setEconomyGrowthModifier((float)this.getMenuElem(15).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setBuildCostModifier((float)this.getMenuElem(18).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setMovementCost((float)this.getMenuElem(21).getCurr() / 100.0f);
                    CFG.editorTerrain_Data2.setBaseProvinceValue(this.getMenuElem(24).getCurr());
                    CFG.editorTerrain_Data2.setBaseDevelopmentLevel((float)this.getMenuElem(27).getCurr() / 100.0f);
                    CFG.terrainTypesManager.saveTerrainData();
                    CFG.terrainTypesManager.loadTerrainTypes();
                    this.onBackPressed();
                }
                return;
            }
            case 3: {
                CFG.showKeyboard();
                CFG.toastM.addM("UI/" + CFG.getResPath() + "terrain/");
                CFG.toastM.setTimeInView(3500);
                return;
            }
            case 4: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorTerrain_Data2.getColor().getR(), CFG.editorTerrain_Data2.getColor().getG(), CFG.editorTerrain_Data2.getColor().getB());
                    CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                    CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 3 + CFG.PADD * 7);
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_TERRAIN_COLOR);
                }
                return;
            }
            case 5: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 6: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 7: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 8: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 9: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 10: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 11: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 12: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 13: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 14: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 15: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 16: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 17: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 18: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 19: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 20: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 21: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 22: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 23: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 24: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr());
                return;
            }
            case 25: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
            case 26: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                return;
            }
            case 27: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE() + (this.getMenuElem(iID).getCurr() > 0 ? "+" : "") + this.getMenuElem(iID).getCurr() + "%");
                return;
            }
            case 28: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.menus.setMenuID(View.eTERRAIN_TYPES_EDITOR);
        CFG.menus.setBackAnimation(true);
        RenderProvince.updateDrawProvinces();
    }
}

