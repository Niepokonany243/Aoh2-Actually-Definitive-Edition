
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

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
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_RelocateCapital
extends Message {
    public Message_RelocateCapital(int fromCivID) {
        super(fromCivID, 0);
        this.messageType = MessageType.CAPITAL_LOST_RELOCATE;
    }

    @Override
    public void onAction(int iMessageID) {
        if (CFG.core.getCiv(this.fromCivID).getNumOfProvs() > 0 && (CFG.core.getCiv(this.fromCivID).getCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(this.fromCivID).getCapitalProvID()).getCivId() != this.fromCivID)) {
            CFG.toastM.addM(CFG.lang.get("TheCapitalCityIsLost"), CFG.COLOR_NEGATIVE_2);
            int iBest = -1;
            for (int i = 0; i < CFG.core.getCiv(this.fromCivID).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(this.fromCivID).getProvID(i)).isOccupied()) continue;
                if (iBest < 0) {
                    iBest = CFG.core.getCiv(this.fromCivID).getProvID(i);
                    continue;
                }
                if (CFG.core.getProv(CFG.core.getCiv(this.fromCivID).getProvID(i)).getPop().getPops() <= CFG.core.getProv(iBest).getPop().getPops()) continue;
                iBest = CFG.core.getCiv(this.fromCivID).getProvID(i);
            }
            if (iBest >= 0) {
                CFG.menus.rebuildInGame_MoveCapital(iBest);
            }
        }
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }

    @Override
    public void onAccept(int iCivID) {
    }

    @Override
    public void onDecline(int iCivID) {
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public int getImageID() {
        return Images.editorCity;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TheCapitalCityIsLost"), CFG.COLOR_NEGATIVE_2));
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

