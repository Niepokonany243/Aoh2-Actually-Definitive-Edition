/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Dices
extends Menu {
    public static final float FONT_SCALE = 1.0f;
    public static final float FONT_SCALE2 = 0.8f;
    private String sLeft;
    private int iLeftWidth;
    private String sRight;
    private int iRightWidth;
    private String sLeftBonus;
    private int iLeftBonusWidth;
    private String sRightBonus;
    private int iRightBonusWidth;

    public Menu_InGame_Dices() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(CFG.lang.get("Skip"), -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SkipAll"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.actMove, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SkipAllCombatMovementsThisTurn")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Transparent(0, this.getPosY2(), 1, this.getHeight2(), true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Dices.this.getPosX2() + CFG.BUTTON_W + CFG.PADD;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Dices.this.getWidth2();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("XBonusForEachPointOfTheDifferenceBetweenBalueOfDices", "" + GameValues.gvDices.DICE_ROLL_BONUS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.dice, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.gameAction.diceAggressorsCivID));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiceRoll") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.gameAction.diceAggressors));
                nData.add(new ME_Hover_2Type_Image_Big(Images.dice, CFG.PADD, Menu_InGame_Dices.this.iLeftBonusWidth > 0 ? CFG.PADD : 0));
                if (Menu_InGame_Dices.this.iLeftBonusWidth > 0) {
                    nData.add(new ME_Hover_2Type_Text(Menu_InGame_Dices.this.sLeftBonus, CFG.COLOR_POSITIVE));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.gameAction.diceDefendersCivID));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiceRoll") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.gameAction.diceDefenders));
                nData.add(new ME_Hover_2Type_Image_Big(Images.dice, CFG.PADD, Menu_InGame_Dices.this.iRightBonusWidth > 0 ? CFG.PADD : 0));
                if (Menu_InGame_Dices.this.iRightBonusWidth > 0) {
                    nData.add(new ME_Hover_2Type_Text(Menu_InGame_Dices.this.sRightBonus, CFG.COLOR_POSITIVE));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(null, 0, 0, CFG.map.getMpB().getMinimapWidth() + CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sLeft = "" + CFG.gameAction.diceAggressors;
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sLeft);
        this.iLeftWidth = (int)(CFG.glyphLay.width * 1.0f);
        this.sRight = "" + CFG.gameAction.diceDefenders;
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sRight);
        this.iRightWidth = (int)(CFG.glyphLay.width * 1.0f);
        float tBonus = CFG.gameAction.diceRollBonus(false);
        if (tBonus > 0.0f) {
            this.sLeftBonus = "+" + (float)((int)(tBonus * 100.0f)) / 100.0f + "% " + CFG.lang.get("Bonus");
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sLeftBonus);
            this.iLeftBonusWidth = (int)(CFG.glyphLay.width * 0.8f);
        } else {
            this.sLeftBonus = "";
            this.iLeftBonusWidth = 0;
        }
        tBonus = CFG.gameAction.diceRollBonus(true);
        if (tBonus > 0.0f) {
            this.sRightBonus = "+" + (float)((int)(tBonus * 100.0f)) / 100.0f + "% " + CFG.lang.get("Bonus");
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sRightBonus);
            this.iRightBonusWidth = (int)(CFG.glyphLay.width * 0.8f);
        } else {
            this.sRightBonus = "";
            this.iRightBonusWidth = 0;
        }
    }

    private final int getPosX2() {
        return CFG.BUTTON_W + CFG.PADD * 3;
    }

    private final int getPosY2() {
        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getHeight2();
    }

    private final int getWidth2() {
        return this.iLeftWidth + this.iRightWidth + (int)((float)IMGManager.getIMG(Images.dice).getWidth() * this.getImageScale(Images.dice)) + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + CFG.PADD * 4;
    }

    private final int getHeight2() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.bgGameAction).getHeight() - 1 + iTranslateY, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() + CFG.PADD + 1, this.getMenuElem(0).getHeightE() + CFG.PADD * 2 + 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.725f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX2() + iTranslateX, this.getPosY2() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth2(), this.getHeight2());
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        IMGManager.getIMG(Images.dice).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.dice).getWidth() * this.getImageScale(Images.dice)) / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)IMGManager.getIMG(Images.dice).getHeight() * this.getImageScale(Images.dice)) / 2 - IMGManager.getIMG(Images.dice).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.dice).getWidth() * this.getImageScale(Images.dice)), (int)((float)IMGManager.getIMG(Images.dice).getHeight() * this.getImageScale(Images.dice)));
        CFG.core.getCiv(CFG.gameAction.diceAggressorsCivID).getFlagC().drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - this.iLeftWidth - CFG.PADD * 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(CFG.gameAction.diceAggressorsCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - this.iLeftWidth - CFG.PADD * 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.core.getCiv(CFG.gameAction.diceDefendersCivID).getFlagC().drawO(oSB, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) / 2 + this.iRightWidth + CFG.PADD * 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(CFG.gameAction.diceDefendersCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) / 2 + this.iRightWidth + CFG.PADD * 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        CFG.drawTextDefault(oSB, this.sLeft, this.getPosX2() + this.getWidth2() / 2 - this.iLeftWidth - CFG.PADD - (int)((float)IMGManager.getIMG(Images.dice).getWidth() * this.getImageScale(Images.dice)) / 2 + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 1.0f / 2.0f) + iTranslateY, this.getMenuElem(0).getIsHovered() ? CFG.COLOR_HOVER_TITLE : (CFG.gameAction.diceAggressors > CFG.gameAction.diceDefenders ? Color.WHITE : (CFG.gameAction.diceAggressors == CFG.gameAction.diceDefenders ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEUTRAL)));
        CFG.drawTextDefault(oSB, this.sRight, this.getPosX2() + this.getWidth2() / 2 + (int)((float)IMGManager.getIMG(Images.dice).getWidth() * this.getImageScale(Images.dice)) / 2 + CFG.PADD + iTranslateX, this.getPosY2() + this.getHeight2() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 1.0f / 2.0f) + iTranslateY, this.getMenuElem(0).getIsHovered() ? CFG.COLOR_HOVER_TITLE : (CFG.gameAction.diceDefenders > CFG.gameAction.diceAggressors ? Color.WHITE : (CFG.gameAction.diceAggressors == CFG.gameAction.diceDefenders ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEUTRAL)));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void actionEL(int nMenuElementID) {
        if (nMenuElementID == 0) {
            GameAction.SKIP_ALL_COMBAT_MOVEMENT_ONCE = true;
            Menu_InGame_ProvInfo.clickEndTurn();
            Menu_InGame_ProvInfo.clickEndTurn();
        } else {
            CFG.toastM.addM("" + CFG.gameAction.diceAggressors + " " + CFG.lang.get("vs") + " " + CFG.gameAction.diceDefenders, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
    }
}

