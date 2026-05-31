
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
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

public class Message_Disease
extends Message {
    public Message_Disease(int byCivID, int nProvinceID) {
        super(byCivID, nProvinceID);
        this.messageType = MessageType.DISEASE;
        this.numOfTurnsLeft = 3;
    }

    @Override
    public void onAction(int iMessageID) {
        if ((int)this.iValue >= 0) {
            CFG.core.setActiveProvID((int)this.iValue);
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
        }
        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_DISEASES_MODE) {
            CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DISEASES_MODE);
        }
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }

    @Override
    public void onAccept(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            CFG.toastM.addM(this.getPlagueName(), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            CFG.toastM.addM(this.getPlagueName(), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        }
    }

    public final String getPlagueName() {
        try {
            return CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)this.iValue).provGD.provincePlague.iPlagueID_InGame).getPlagueName();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        return CFG.lang.get("Plague");
    }

    public final int getPlagueDeaths() {
        try {
            return CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)this.iValue).provGD.provincePlague.iPlagueID_InGame).getDeaths();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        return 0;
    }

    @Override
    public int getImageID() {
        return Images.disease;
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
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Disease"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Name") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.getPlagueName(), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getPlagueDeaths() > 0) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Deaths") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + this.getPlagueDeaths()), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
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


