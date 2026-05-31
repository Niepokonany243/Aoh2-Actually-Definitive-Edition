
package age.of.civilizations2.jakowski.lukasz.Messages;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import java.io.Serializable;
import java.util.ArrayList;

public class Message
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int fromCivID = -1;
    public long iValue = 1;
    public long iValue2 = 1;
    public int numOfTurnsLeft = 4;
    public TradeRequest_GameData tradeRequest = null;
    public Ultimatum_GameData ultimatum = null;
    public String TAG = null;
    public MessageType messageType = MessageType.JOIN_ALLIANCE;
    public boolean requestsResponse = false;
    public boolean willPauseTheGame = false;

    public Message(int fromCivID, long iValue) {
        this.fromCivID = fromCivID;
        this.iValue = iValue;
    }

    public Message(int fromCivID, int iValue) {
        this.fromCivID = fromCivID;
        this.iValue = (long)iValue;
    }

    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_MessageAlliance(this.fromCivID, iMessageID, (int)this.iValue);
    }

    public void onAccept(int iCivID) {
        GameManager.acceptAllianceProposal(iCivID, this.fromCivID);
    }

    public void onDecline(int iCivID) {
        GameManager.declineAllianceProposal(iCivID, this.fromCivID);
    }

    public int getImageID() {
        return Images.diploAlliance;
    }

    public int getBGImageID() {
        return Images.messages;
    }

    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Alliance"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(this.getImageID(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CivAWantsToJoinAlliance", CFG.core.getCiv(this.fromCivID).getCivName())));
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
        return new ME_Hover_v2(nElements);
    }

    public final boolean updateNextTurn() {
        return --this.numOfTurnsLeft <= 0;
    }
}
