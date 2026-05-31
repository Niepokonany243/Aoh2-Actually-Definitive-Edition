/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Messages.Ultimatum;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
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
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import java.util.ArrayList;

public class Message_Ultimatum
extends Message {
    public Message_Ultimatum(int fromCivID, Ultimatum_GameData nUltimatum, long nUnits) {
        super(fromCivID, nUnits);
        nUltimatum.numOfUntis = nUnits;
        this.ultimatum = nUltimatum;
        this.requestsResponse = true;
        this.willPauseTheGame = true;
        this.messageType = MessageType.ULTIMATUM;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildInGame_Message_Ultimatum(this.fromCivID, iMessageID, (int)this.iValue, this.ultimatum);
    }

    @Override
    public void onAccept(int iCivID) {
        GameManager.acceptUltimatum(this.fromCivID, iCivID, this.ultimatum);
    }

    @Override
    public void onDecline(int iCivID) {
        GameManager.refuseUltimatum(this.fromCivID, iCivID, this.ultimatum);
    }

    @Override
    public int getBGImageID() {
        return Images.messages_r;
    }

    @Override
    public int getImageID() {
        return Images.diploRivals;
    }

    @Override
    public ME_Hover_v2 getHover() {
        int i;
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.fromCivID).getCivName() + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Ultimatum"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.ultimatum.demandAnexation) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandsAnnexationOfOurTerritory"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.ultimatum.demandVasalization) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandVassalizationOfUs"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.ultimatum.demandChangeOfGovernment) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeTypeOfGovernmentTo") + ": " + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.fromCivID).getIdeology()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.ultimatum.demandMilitaryAccess) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.ultimatum.demandLiberation.size() > 0) {
            for (i = 0; i < this.ultimatum.demandLiberation.size(); ++i) {
                nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandLiberationOfVassal") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.ultimatum.demandLiberation.get(i)).getCivName()));
                nData.add(new ME_Hover_2Type_Flag(this.ultimatum.demandLiberation.get(i), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        if (this.ultimatum.demandProvinces.size() > 0) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandsOurProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        for (i = 0; i < this.ultimatum.demandProvinces.size(); ++i) {
            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(this.ultimatum.demandProvinces.get(i)).getName()));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("XUnitsAreReadyToAttackIfWeRefuseTheirOffer", (int)this.iValue), CFG.COLOR_NEGATIVE_2));
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
