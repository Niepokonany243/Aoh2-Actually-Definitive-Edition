
package age.of.civilizations2.jakowski.lukasz.Messages.War;

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

public class Message_JoinedAWar
extends Message {
    public Message_JoinedAWar(int fromCivID, int iValue) {
        super(fromCivID, iValue);
        this.messageType = MessageType.JOINED_A_WAR;
        this.numOfTurnsLeft = 2;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }

    @Override
    public void onAccept(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("XJoinedTheWar", CFG.core.getCiv(this.fromCivID).getCivName()));
            lColors.add(CFG.COLOR_POSITIVE);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            CFG.menus.rebuildMenu_InGame_InfoboxDate(CFG.lang.get("XJoinedTheWar", CFG.core.getCiv(this.fromCivID).getCivName()), iCivID, this.fromCivID, Images.infoWar);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("XJoinedTheWar", CFG.core.getCiv(this.fromCivID).getCivName()));
            lColors.add(CFG.COLOR_POSITIVE);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            CFG.menus.rebuildMenu_InGame_InfoboxDate(CFG.lang.get("XJoinedTheWar", CFG.core.getCiv(this.fromCivID).getCivName()), iCivID, this.fromCivID, Images.infoWar);
        }
    }

    @Override
    public int getImageID() {
        return Images.diploWar;
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
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("XJoinedTheWar", CFG.core.getCiv(this.fromCivID).getCivName()), CFG.COLOR_POSITIVE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
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

