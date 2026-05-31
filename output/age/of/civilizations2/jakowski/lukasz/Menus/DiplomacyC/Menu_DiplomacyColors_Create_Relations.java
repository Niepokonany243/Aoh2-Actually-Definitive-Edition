
package age.of.civilizations2.jakowski.lukasz.Menus.DiplomacyC;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
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
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_DiplomacyColors_Create_Relations
extends Menu {
    public Menu_DiplomacyColors_Create_Relations() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempPosX = CFG.PADD;
        menuElements.add(new Button_Game("-100", -1, tempPosX, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-90", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-80", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-70", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-60", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-50", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-40", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-30", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-20", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("-10", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("NEUTRAL", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("10", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("20", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("30", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("40", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("50", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("60", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("70", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("80", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("90", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game("100", -1, tempPosX += CFG.PADD + CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Transparent((tempPosX += CFG.PADD + CFG.BUTTON_W) - CFG.PADD, CFG.PADD, CFG.PADD, CFG.BUTTON_H, false));
        this.initMenu(null, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, this.getPosY() + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE(), CFG.BUTTON_H + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W * 2 + CFG.PADD * 5);
        CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
        if (iID < 10) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 9 - iID;
            CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9 - iID].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9 - iID].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9 - iID].getB());
            CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_NEGATIVE);
        } else if (iID > 11) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = iID - 11;
            CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[iID - 11].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[iID - 11].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[iID - 11].getB());
            CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_POSITIVE);
        } else {
            CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB());
            CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_NEUTRAL);
        }
    }
}

