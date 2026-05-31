
package age.of.civilizations2.jakowski.lukasz.Menus.Disband;

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
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Cost_Right_Balance_Disband;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Move;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_MovementCost_Right;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Menu_InGame_ActionInfo_Disband
extends Menu {
    public Menu_InGame_ActionInfo_Disband() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextActionInfo_Move("", 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_NEGATIVE_1 : (this.getIsHovered() ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEGATIVE_2);
            }
        });
        menuElements.add(new TextActionInfo_MovementCost_Right("-" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_DISBAND / 10.0f, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_DISBAND / 10.0f, CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextActionInfo_Cost_Right_Balance_Disband(CFG.lang.get("Balance") + ": ", 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2 - CFG.PADD - CFG.BUTTON_H - CFG.PADD * 2){});
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

