
package age.of.civilizations2.jakowski.lukasz.Messages.PrepForWar;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_PrepareForWar
extends Message {
    public int iLeaderCivID;

    public Message_PrepareForWar(int fromCivID, int iValue, int iValue2, int iLeaderCivID) {
        super(fromCivID, iValue);
        this.messageType = MessageType.PREPARE_FOR_WAR;
        this.numOfTurnsLeft = 2;
        this.iValue2 = iValue2;
        this.iLeaderCivID = iLeaderCivID;
        this.requestsResponse = true;
        this.willPauseTheGame = true;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_Message_PrepareForWar(this.fromCivID, iMessageID, (int)this.iValue, (int)this.iValue2 - GameCalendar.TURNID);
    }

    @Override
    public void onAccept(int iCivID) {
        GameManager.acceptPrepareForWar(this.iLeaderCivID, iCivID, this.fromCivID, (int)this.iValue, (int)this.iValue2 - GameCalendar.TURNID);
    }

    @Override
    public void onDecline(int iCivID) {
        GameManager.declinePrepareForWar(this.iLeaderCivID, iCivID, this.fromCivID, (int)this.iValue, (int)this.iValue2 - GameCalendar.TURNID);
    }

    @Override
    public int getImageID() {
        return Images.diploWarPreparations;
    }

    @Override
    public int getBGImageID() {
        return Images.messages;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WarPreparations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PrepareForTheWarAgainst") + ": "));
        nData.add(new ME_Hover_2Type_Flag((int)this.iValue, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv((int)this.iValue).getCivName(), CFG.COLOR_HOVER_TITLE));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PreparationTime") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsX", (int)this.iValue2 - GameCalendar.TURNID), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Image(Images.diploMessage));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MessageWillExpireIn") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsX", this.numOfTurnsLeft) + " ", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Text("[" + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + this.numOfTurnsLeft) + "]", CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (CFG.core.getCiv((int)this.fromCivID).civGD.leaderData != null) {
            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv((int)this.fromCivID).civGD.leaderData.getName(), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.fromCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else {
            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.fromCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        return new ME_Hover_v2(nElements);
    }
}


