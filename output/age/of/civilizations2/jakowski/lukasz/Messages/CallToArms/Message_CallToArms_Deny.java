
package age.of.civilizations2.jakowski.lukasz.Messages.CallToArms;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_CallToArms_Deny
extends Message {
    private int iCivID;

    public Message_CallToArms_Deny(int fromCivID, int iValue, int iCivID, int iValue2) {
        super(fromCivID, iValue);
        this.iCivID = iCivID;
        this.iValue2 = iValue2;
        this.messageType = MessageType.WAR_DECLARED_ON_ALLY_DENY;
        this.numOfTurnsLeft = 2;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_Message_CallToArms_Denied(this.fromCivID, iMessageID, (int)this.iValue);
    }

    @Override
    public void onAccept(int iCivID) {
    }

    @Override
    public void onDecline(int iCivID) {
        GameManager.callToArms_Denied_SendInsult(iCivID, this.fromCivID, (int)this.iValue);
    }

    @Override
    public int getImageID() {
        return Images.diploRivals;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CallToArms"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("XDeniedToJoinTheWar", CFG.core.getCiv(this.fromCivID).getCivName()) + ": ", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Flag((int)this.iValue, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Image(Images.diploRivals, 0, 0));
        nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if ((int)this.iValue2 >= 1 && this.iValue2 <= 6) {
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if ((int)this.iValue2 == 1) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CallToArmsDenyGold")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if ((int)this.iValue2 == 2) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CallToArmsDenyPrep")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if ((int)this.iValue2 == 3) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CallToArmsDenyAtWar")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if ((int)this.iValue2 == 4) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CallToArmsDenyLowRelations")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if ((int)this.iValue2 == 5) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CallToArmsDenyFriendly")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if ((int)this.iValue2 == 6) {
            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("VassalLordWarDesc") + " " + CFG.lang.get("Wars") + ": " + CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.WARS_DECLARED_AS_VASSAL_AND_LORD_JOINED_WAR + " / " + GameValues.gvAiWar.AI_LORD_MAX_WARS_JOINED_WHEN_PLAYER_IS_VASSAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
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


