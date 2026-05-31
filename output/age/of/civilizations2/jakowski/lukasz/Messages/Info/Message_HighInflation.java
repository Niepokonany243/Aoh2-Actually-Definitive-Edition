
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Message_HighInflation
extends Message {
    public Message_HighInflation(int fromCivID, int iValue) {
        super(fromCivID, iValue);
        this.messageType = MessageType.HIGH_INFLATION;
        this.numOfTurnsLeft = 1;
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
            lMess.add(CFG.lang.get("InflationH1"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            lMess.add(CFG.lang.get("InflationH2"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("InflationH1"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            lMess.add(CFG.lang.get("InflationH2"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
        }
    }

    @Override
    public int getImageID() {
        return Images.developmentDown;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HighInflation") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("[" + (float)((int)(CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10000.0f)) / 100.0f + "%]", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image_Big(Images.developmentDown, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InflationH1"), CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InflationH2"), CFG.COLOR_NEUTRAL));
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

