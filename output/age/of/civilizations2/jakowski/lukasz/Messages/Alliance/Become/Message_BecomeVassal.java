
package age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Become;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
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
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Become.Message_BecomeVassalAccepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Become.Message_BecomeVassalRejected;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_BecomeVassal
extends Message {
    public Message_BecomeVassal(int fromCivID, int iValue) {
        super(fromCivID, iValue);
        this.messageType = MessageType.BECOME_VASSAL;
        this.numOfTurnsLeft = 3;
        this.requestsResponse = true;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_WantsToBecomeVassal(this.fromCivID, iMessageID);
    }

    @Override
    public void onAccept(int iCivID) {
        CFG.core.getCiv(this.fromCivID).setPuppetOfCivId(iCivID);
        CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("YouHaveGainedAVassal"), GameCalendar.getCurrDate(), Images.infoDiplomacy, iCivID, this.fromCivID);
        CFG.core.getCiv((int)this.fromCivID).getCivDiploGD().messageBox.addMessage(new Message_BecomeVassalAccepted(iCivID, (int)this.iValue));
    }

    @Override
    public void onDecline(int iCivID) {
        CFG.core.getCiv((int)this.fromCivID).getCivDiploGD().messageBox.addMessage(new Message_BecomeVassalRejected(iCivID, (int)this.iValue));
    }

    @Override
    public int getImageID() {
        return Images.diploVassal;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_w;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WantsToBecomeYourVassal") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.fromCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, CFG.PADD, 0));
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


