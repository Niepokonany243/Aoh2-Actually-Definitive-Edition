/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Move;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_ArmyBonus;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Move;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_MovementCost_Right;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_MovementCost_Right_Free;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Right_ArmyBonues;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_ActionInfo_Move
extends Menu {
    public Menu_InGame_ActionInfo_Move() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int moveCivID = CFG.gameAction.getControlledArmyCivIDInProvince(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        int movementPayerCivID = CFG.gameAction.getArmyMovementPayerCivID(CFG.core.getActiveProvID(), moveCivID);
        menuElements.add(new TextActionInfo_Move("", 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2));
        if (CFG.gameAction.getIsFreeMove(movementPayerCivID, CFG.core.getActiveProvID(), CFG.chosenProvinceID)) {
            menuElements.add(new TextActionInfo_MovementCost_Right_Free("-0.0", 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text("0.0", CFG.COLOR_FREE_MOVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        } else {
            menuElements.add(new TextActionInfo_MovementCost_Right("-" + (float)CFG.gameAction.costOfMoveArmy(CFG.core.getActiveProvID(), CFG.chosenProvinceID, movementPayerCivID) / 10.0f, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)CFG.gameAction.costOfMoveArmy(CFG.core.getActiveProvID(), CFG.chosenProvinceID, movementPayerCivID) / 10.0f, CFG.COLOR_MOVEMENT));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }
        int tRes = CFG.gameAction.moveArmyModifiers_Attackers(CFG.core.getActiveProvID(), CFG.chosenProvinceID, moveCivID);
        if (tRes != 0) {
            menuElements.add(new TextActionInfo_ArmyBonus(CFG.lang.get("Attackers") + ": ", "" + (tRes > 0 ? "+" : "") + tRes + "%", 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.PADD){

                @Override
                public void buildElemHover() {
                    try {
                        java.util.List<MEHover_2E> nElements = CFG.gameAction.getMoveArmyModifiers_Attackers_Hover(CFG.core.getActiveProvID(), CFG.chosenProvinceID, moveCivID);
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                    }
                }
            });
        }
        if ((tRes = CFG.gameAction.moveArmyModifiers_Defenders(CFG.core.getActiveProvID(), CFG.chosenProvinceID)) != 0) {
            menuElements.add(new TextActionInfo_Right_ArmyBonues(CFG.lang.get("Defenders") + ": ", "" + (tRes > 0 ? "+" : "") + tRes + "%", 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.PADD){
                boolean isPositive;
                {
                    this.isPositive = true;
                }

                @Override
                public void buildElemHover() {
                    try {
                        java.util.List<MEHover_2E> nElements = CFG.gameAction.getMoveArmyModifiers_Defenders_Hover(CFG.core.getActiveProvID(), CFG.chosenProvinceID);
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), this.getPosY());
                    }
                }

                @Override
                public Color getColorValue() {
                    return this.isPositive ? super.getColorValue() : CFG.COLOR_NEGATIVE_2;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.isPositive = nCurrent >= 0;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRes);
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements, false, false);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                break;
            }
            case 1: {
                CFG.toastM.addM(CFG.lang.get("MovementPoints") + ": " + this.getMenuElem(1).getTextE(), CFG.COLOR_MOVEMENT_ZERO);
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_Recruit();
    }
}

