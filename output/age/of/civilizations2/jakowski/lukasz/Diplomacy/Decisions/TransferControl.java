/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Diplomacy.Decisions;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_SentMessages;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TransferControl;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TransferControl_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TransferControl_Refused;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;

public class TransferControl {
    public static final void sendTransferControl(int iToCivID, int iFromCivID, int iProvinceID) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_TransferControl(iFromCivID, iProvinceID));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipTransferControl.COST_TRANSFER_CONTROL_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.TRANSFER_CONTROL));
        }
    }

    public static final void acceptTransferControl(int iCivID, int iFromCivID, int iValue) {
        if (CFG.core.getProv(iValue).getCivId() == iFromCivID && CFG.core.getProv(iValue).isOccupied() && (CFG.core.getCivsAreAllied(iCivID, iFromCivID) || CFG.core.getCiv(iCivID).getPuppetOfCiv() == iFromCivID || CFG.core.getCiv(iFromCivID).getPuppetOfCiv() == iCivID || CFG.core.getProv(iValue).getTrueOwnerOfProv() == iCivID)) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_TransferControl_Accepted(iCivID, iValue, iFromCivID));
            long oldOwnerArmy = CFG.core.getProv(iValue).getArmyCivID1(iFromCivID);
            long newOwnerArmy = CFG.core.getProv(iValue).getArmyCivID1(iCivID);
            if (oldOwnerArmy != 0L) {
                CFG.core.getProv(iValue).updateArmy4(iFromCivID, 0L);
            }
            if (newOwnerArmy != 0L) {
                CFG.core.getProv(iValue).updateArmy4(iCivID, 0L);
            }
            CFG.core.getProv(iValue).setCivId(iCivID, false, true);
            if (oldOwnerArmy > 0L) {
                CFG.core.getProv(iValue).updateArmy4(iFromCivID, oldOwnerArmy);
            }
            if (newOwnerArmy > 0L) {
                CFG.core.getProv(iValue).updateArmy4(iCivID, newOwnerArmy);
            }
        }
    }

    public static final void declineTransferControl(int iCivID, int iFromCivID, int iValue) {
        if (CFG.core.getProv(iValue).getCivId() == iFromCivID && CFG.core.getProv(iValue).isOccupied() && (CFG.core.getCivsAreAllied(iCivID, iFromCivID) || CFG.core.getCiv(iCivID).getPuppetOfCiv() == iFromCivID || CFG.core.getCiv(iFromCivID).getPuppetOfCiv() == iCivID)) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_TransferControl_Refused(iCivID, iValue, iFromCivID));
        }
    }
}

