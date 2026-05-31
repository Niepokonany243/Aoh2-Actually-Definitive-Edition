
package age.of.civilizations2.jakowski.lukasz.Messages.War.Spy;

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
import java.util.ArrayList;

public class Message_SpyPreparingForWar
extends Message {
    public Message_SpyPreparingForWar(int warPreparingOnCivID, int onCivID) {
        super(warPreparingOnCivID, onCivID);
        this.messageType = MessageType.SPY_PREPARING_FOR_WAR;
        this.willPauseTheGame = true;
        this.requestsResponse = true;
        this.numOfTurnsLeft = 1;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_SpyPreparingForWar(this.fromCivID);
        CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("SpyPreparingForWarDesc"), CFG.lang.get("SpyPreparingForWarDesc2"), Images.infoDiplomacy, this.fromCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
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
    public int getImageID() {
        return Images.spy;
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big((int)this.iValue));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MobilizationForWar") + ": ", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.fromCivID).getCivName()));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploWarPreparations, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SpyPreparingForWarDesc") + " " + CFG.lang.get("SpyPreparingForWarDesc2")));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.fromCivID).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop()), CFG.COLOR_POPULATION));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.fromCivID).countPop()), CFG.COLOR_POPULATION));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countEco()), CFG.COLOR_ECONOMY));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.fromCivID).countEco()), CFG.COLOR_ECONOMY));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel(), 100), CFG.COLOR_TECHNOLOGY));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(CFG.core.getCiv(this.fromCivID).getTechLevel(), 100), CFG.COLOR_TECHNOLOGY));
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
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


