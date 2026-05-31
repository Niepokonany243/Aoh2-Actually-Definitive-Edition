
package age.of.civilizations2.jakowski.lukasz.Messages.Relations.Summit;

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
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Message_SummitInvited
extends Message {
    public Message_SummitInvited(int fromCivID, int iValue) {
        super(fromCivID, iValue);
        this.messageType = MessageType.DIPLOMATIC_SUMMIT_INVITED;
        this.numOfTurnsLeft = 2;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_Message_SummitInvite(this.fromCivID, iMessageID, (int)this.iValue);
    }

    @Override
    public void onAccept(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("OurCivilizationHasBeenInvitedToADiplomaticSummit"));
            lColors.add(CFG.COLOR_NEUTRAL);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(2500);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("OurCivilizationHasBeenInvitedToADiplomaticSummit"));
            lColors.add(CFG.COLOR_NEUTRAL);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(2500);
        }
    }

    @Override
    public int getImageID() {
        return Images.summit;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_g;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.fromCivID).getCivName() + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OurCivilizationHasBeenInvitedToADiplomaticSummit")));
        nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        for (int i = 0; i < CFG.core.diplomaticSummits.size(); ++i) {
            if (CFG.core.diplomaticSummits.get((int)i).civHostID != this.fromCivID || !CFG.core.diplomaticSummits.get(i).isInvited(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ListOfInvitedCivilizations") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (int j = 0; j < CFG.core.diplomaticSummits.get((int)i).invitedCivs.size(); ++j) {
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.diplomaticSummits.get((int)i).invitedCivs.get(j), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.diplomaticSummits.get((int)i).invitedCivs.get(j)).getCivName()));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsInc, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            break;
        }
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


