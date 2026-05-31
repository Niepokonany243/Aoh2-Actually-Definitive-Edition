
package age.of.civilizations2.jakowski.lukasz.Messages.Province.Nuke;

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

public class Message_Nuke_OurProvince
extends Message {
    public long populationLosses;
    public long economyLosses;
    public long armyLosses;

    public Message_Nuke_OurProvince(int byCivID, int nProvinceID, long population, long economy, long armyLosses) {
        super(byCivID, nProvinceID);
        this.messageType = MessageType.NUKE_OUR_PROVINCE;
        this.numOfTurnsLeft = 2;
        this.populationLosses = population;
        this.economyLosses = economy;
        this.armyLosses = armyLosses;
    }

    @Override
    public void onAction(int iMessageID) {
        if ((int)this.iValue >= 0) {
            CFG.core.setActiveProvID((int)this.iValue);
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
        }
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }

    @Override
    public void onAccept(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            CFG.toastM.addM(CFG.core.getProv((int)this.iValue).getProvName(), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            CFG.toastM.addM(CFG.core.getProv((int)this.iValue).getProvName(), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        }
    }

    @Override
    public int getImageID() {
        return Images.nuke;
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
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtomicBombing"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv((int)this.iValue).getProvName(), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getNumberWthSpaces("" + this.populationLosses), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + CFG.getNumberWthSpaces("" + this.economyLosses), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.armyLosses > 0 ? "-" : "") + CFG.getNumberWthSpaces("" + this.armyLosses), this.armyLosses > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
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


