package age.of.civilizations2.jakowski.lukasz.Messages.Province.Missile;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_Missile_Strike extends Message {
    public long populationLosses;
    public long economyLosses;
    public long armyLosses;

    public Message_Missile_Strike(int byCivID, int nProvinceID, long population, long economy, long army) {
        super(byCivID, nProvinceID);
        this.messageType = MessageType.MISSILE_STRIKE;
        this.numOfTurnsLeft = 3;
        this.populationLosses = population;
        this.economyLosses = economy;
        this.armyLosses = army;
    }

    @Override
    public void onAction(int iMessageID) {
        if ((int)this.iValue >= 0) {
            CFG.core.setActiveProvID((int)this.iValue);
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
        }
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }

    @Override
    public int getImageID() {
        return Images.bSupply;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big("Missile Strike!", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image_Big(Images.bSupply, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv((int)this.iValue).getProvName(), CFG.COLOR_NEGATIVE_2));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("Population: -", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + this.populationLosses), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("Economy: -", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + this.economyLosses), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("Army: -", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + this.armyLosses), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("Launched by: "));
        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.fromCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Flag(this.fromCivID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }
}
