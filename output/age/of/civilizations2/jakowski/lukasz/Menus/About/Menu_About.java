/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.About;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_About
extends Menu {
    public boolean flagsE = false;
    public List<FSF> sF = new ArrayList<FSF>();

    public Menu_About() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.BUTTON_W / 2;
        menuElements.add(new TextScale("Age of History 2: Definitive Edition", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 1.0f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void actionElem(int iID) {
                Menu_About.this.flagsE = !Menu_About.this.flagsE;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("www.AgeofCivilizationsGame.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                } else if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.925f));
                }
                IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return IMGManager.getIMG(Images.gameLogo).getWidth();
            }

            @Override
            public int getHeightE() {
                return IMGManager.getIMG(Images.gameLogo).getHeight();
            }
        });
        menuElements.add(new TextScale("Age of History 2: Definitive Edition", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, 0.9f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "http://www.AgeofCivilizationsGame.com";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("www.AgeofCivilizationsGame.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new TextScale("Programmer and Designer", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 1.0f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("Developer", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "http://www.LukaszJakowski.pl";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        menuElements.add(new TextScale(CFG.gLI(), 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, 0.9f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.gLI(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("One man army"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("www.LukaszJakowski.pl", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Contact") + ": jakowskidev@gmail.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "http://www.LukaszJakowski.pl";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                float fScale = (float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f / (float)IMGManager.getIMG(Images.flagRectSmall).getHeight();
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)this.getTextWidthU() * 0.9f) + CFG.PADD + iTranslateX, this.getPosY() + 1 + (int)((float)this.getHeightE() / 2.0f - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f / 2.0f) - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * fScale), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * fScale));
                oSB.setColor(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)this.getTextWidthU() * 0.9f) + CFG.PADD + iTranslateX, this.getPosY() + 1 + (int)((float)this.getHeightE() / 2.0f - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f / 2.0f) - IMGManager.getIMG(Images.pix255).getHeight() + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * fScale) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * fScale), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * fScale) - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * fScale) / 2);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + (int)((float)this.getTextWidthU() * 0.9f) + CFG.PADD + iTranslateX, this.getPosY() + 1 + (int)((float)this.getHeightE() / 2.0f - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * fScale), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * fScale));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new TextScale("Publisher", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 1.0f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.gLG(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("Poland"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("www.LukaszJakowski.pl", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Contact") + ": jakowskidev@gmail.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "http://www.LukaszJakowski.pl";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        menuElements.add(new TextScale(CFG.gLG(), 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, 0.9f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.gLG(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("Poland"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("www.LukaszJakowski.pl", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Contact") + ": jakowskidev@gmail.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "http://www.LukaszJakowski.pl";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new TextScale(CFG.lang.get("Music"), 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 1.0f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Music"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextScale("Kevin Macleod", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, 0.9f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Color(new Color(0.23529412f, 0.23137255f, 0.43137255f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.69803923f, 0.13333334f, 0.20392157f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("Kevin Macleod", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("https://www.youtube.com/user/kmmusic", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://www.youtube.com/user/kmmusic";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new TextScale(CFG.lang.get("Contact") + ": jakowskidev@gmail.com", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 0.9f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.gLI(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Color(new Color(1.0f, 1.0f, 1.0f, 1.0f), 0, 0));
                nData.add(new ME_Hover_2Type_Color(new Color(0.8509804f, 0.11764706f, 0.23921569f, 1.0f), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("One man army"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("www.LukaszJakowski.pl", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Contact") + ": jakowskidev@gmail.com", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new TextScale("Special thanks to", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 0.8f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextScale("You!", 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, 0.75f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void actionElem(int iID) {
                CFG.showKeyboard(iID);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        if (GameValues.gvAbout.TITLE != null && GameValues.gvAbout.TITLE.length() > 0) {
            menuElements.add(new TextScale(GameValues.gvAbout.TITLE, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 0.8f){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            if (GameValues.gvAbout.TEXT_1 != null && GameValues.gvAbout.TEXT_1.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT_1, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT_2 != null && GameValues.gvAbout.TEXT_2.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT_2, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT_3 != null && GameValues.gvAbout.TEXT_3.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT_3, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT_4 != null && GameValues.gvAbout.TEXT_4.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT_4, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
        }
        if (GameValues.gvAbout.TITLE2 != null && GameValues.gvAbout.TITLE2.length() > 0) {
            menuElements.add(new TextScale(GameValues.gvAbout.TITLE2, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY += CFG.BUTTON_H / 4, 0.8f){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            if (GameValues.gvAbout.TEXT2_1 != null && GameValues.gvAbout.TEXT2_1.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT2_1, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT2_2 != null && GameValues.gvAbout.TEXT2_2.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT2_2, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT2_3 != null && GameValues.gvAbout.TEXT2_3.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT2_3, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
            if (GameValues.gvAbout.TEXT2_4 != null && GameValues.gvAbout.TEXT2_4.length() > 0) {
                menuElements.add(new TextScale(GameValues.gvAbout.TEXT2_4, 0, AoCGame.LEFT + CFG.BUTTON_W / 2, tY, 0.75f){

                    @Override
                    public Color getColor(boolean isActive) {
                        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.showKeyboard(iID);
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
            }
        }
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true){

            @Override
            public void actionElem(int iID) {
                Menu_About.this.onBackPressed();
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, iTranslateY - IMGManager.getIMG(Images.gradient).getHeight(), CFG.GAMEWIDTH, CFG.BUTTON_H * 3 / 4);
        oSB.setColor(new Color(0.0123f, 0.0123f, 0.0123f, 0.3f));
        IMGManager.getIMG(Images.patternSquareTiny).drawO(oSB, iTranslateX, iTranslateY - IMGManager.getIMG(Images.patternSquareTiny).getHeight(), CFG.GAMEWIDTH, this.getHeightM(), 0.0f, 0);
        oSB.setColor(Color.WHITE);
        CFG.drawLogo_Square(oSB, CFG.GAMEWIDTH - (CFG.BUTTON_H * 3 + CFG.PADD * 2) - CFG.BUTTON_W / 2 + iTranslateX, CFG.BUTTON_W / 2 + iTranslateY, CFG.BUTTON_H * 3 + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void endClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            if (this.flagsE) {
                if (CFG.oR.nextInt(1000) < 347) {
                    this.cSF();
                }
                if (!this.sF.isEmpty()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
                    for (int i = this.sF.size() - 1; i >= 0; --i) {
                        if (this.sF.get((int)i).iH > 0) {
                            this.sF.get(i).update(CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H);
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
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
        try {
            this.sF.clear();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public class FSF {
        int x;
        int y;
        int iW;
        int iH;
        int c = 0;

        public FSF(int x, int y, int iW, int iH) {
            this.x = x;
            this.y = y;
            float s = 0.65f + (float)CFG.oR.nextInt(700) / 1000.0f;
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
            if (this.y + this.iH >= CFG.GAMEHEIGHT - CFG.BUTTON_H) {
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

