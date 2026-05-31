
package age.of.civilizations2.jakowski.lukasz.Messages;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageBox_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Message> lMessages = new ArrayList<Message>();
    public int iMessagesSize = 0;

    public synchronized final void updateNextTurn(int nCivID) {
        for (int i = 0; i < this.getMessagesSize(); ++i) {
            if (!this.lMessages.get(i).updateNextTurn()) continue;
            if (!this.lMessages.get((int)i).requestsResponse) {
                if (this.lMessages.get((int)i).messageType == MessageType.GIFT) {
                    this.lMessages.get(i).onAccept(nCivID);
                }
                this.lMessages.remove(i--);
                this.iMessagesSize = this.lMessages.size();
                continue;
            }
            if (CFG.core.getCiv(nCivID).getIsPlayer() || this.lMessages.get((int)i).numOfTurnsLeft >= -25) continue;
            this.lMessages.remove(i--);
            this.iMessagesSize = this.lMessages.size();
        }
    }

    public synchronized final void addMessage(Message nMessage) {
        if (nMessage.messageType == MessageType.DISEASE) {
            int nNumOfDisseaseMessages = 0;
            for (int i = 0; i < this.getMessagesSize(); ++i) {
                if (this.lMessages.get((int)i).messageType != MessageType.DISEASE) continue;
                ++nNumOfDisseaseMessages;
            }
            if (nNumOfDisseaseMessages > 2) {
                return;
            }
        } else if (nMessage.messageType != MessageType.NUKE_OUR_PROVINCE) {
            if (nMessage.messageType == MessageType.NEIGH_WAR || nMessage.messageType == MessageType.NEIGH_TRUCE) {
                for (int i = 0; i < this.getMessagesSize(); ++i) {
                    if (this.lMessages.get((int)i).fromCivID != nMessage.fromCivID || this.lMessages.get((int)i).iValue != nMessage.iValue || this.lMessages.get((int)i).messageType != nMessage.messageType) continue;
                    return;
                }
            } else {
                for (int i = 0; i < this.getMessagesSize(); ++i) {
                    if (this.lMessages.get((int)i).fromCivID != nMessage.fromCivID || this.lMessages.get((int)i).messageType != nMessage.messageType) continue;
                    if (nMessage.messageType == MessageType.TECHNOLOGY_RESEARCHED) {
                        this.lMessages.get((int)i).numOfTurnsLeft = nMessage.numOfTurnsLeft;
                        return;
                    }
                    if (nMessage.messageType == MessageType.UNCIVILIZED) {
                        this.lMessages.get((int)i).numOfTurnsLeft = nMessage.numOfTurnsLeft;
                        return;
                    }
                    if (nMessage.messageType != MessageType.GIFT && nMessage.messageType != MessageType.LOAN_REQUEST && nMessage.messageType != MessageType.LOAN_REQUEST_ACCEPTED && nMessage.messageType != MessageType.LOAN_REQUEST_REJECTED && nMessage.messageType != MessageType.WE_CAN_SIGN_PEACE && nMessage.messageType != MessageType.WE_CAN_SIGN_PEACE_STATUS_QUO && nMessage.messageType != MessageType.GIFT_REFUSED && nMessage.messageType != MessageType.GIFT_ACCEPTED && nMessage.messageType != MessageType.PLUNDER_REPORT && nMessage.messageType != MessageType.PLUNDER_REPORT_PLUNDRED && nMessage.messageType != MessageType.REVOLT && nMessage.messageType != MessageType.JOINED_A_WAR && nMessage.messageType != MessageType.TRANSFER_CONTROL && nMessage.messageType != MessageType.VASSALIZATION_ACCEPTED && nMessage.messageType != MessageType.VASSALIZATION_REJECTED && nMessage.messageType != MessageType.TRANSFER_CONTROL_REFUSED && nMessage.messageType != MessageType.TRANSFER_CONTROL_ACCEPTED && nMessage.messageType != MessageType.PROVINCES_NOT_SUPPLIED_STRAVES && nMessage.messageType != MessageType.PROVINCES_NOT_SUPPLIED_LOST_CONTROL && nMessage.messageType != MessageType.PROVINCES_NOT_SUPPLIED_LOST_CONTROL_ENEMY_LOST && nMessage.messageType != MessageType.PROVINCES_LOST_CONTROL && nMessage.messageType != MessageType.TRUCE && nMessage.messageType != MessageType.TRUCE_EXPIRED && nMessage.messageType != MessageType.LOAN_REPAID && nMessage.messageType != MessageType.WAR_DECLARED_ON_ALLY_DENY && nMessage.messageType != MessageType.WAR_DECLARED_ON_ALLY_JOINED && nMessage.messageType != MessageType.BULIT_FARM && nMessage.messageType != MessageType.BULIT_PORT && nMessage.messageType != MessageType.BULIT_TOWER && nMessage.messageType != MessageType.BULIT_FORT && nMessage.messageType != MessageType.BULIT_LIBRARY && nMessage.messageType != MessageType.BUILT_ARMOURY && nMessage.messageType != MessageType.BUILT_WORKSHOP && nMessage.messageType != MessageType.FESTIVAL_IS_OVER && nMessage.messageType != MessageType.ASSIMILATION_IS_OVER && nMessage.messageType != MessageType.INVEST_IS_OVER && nMessage.messageType != MessageType.INVEST_IS_OVER_FOREIGN && nMessage.messageType != MessageType.INVEST_IS_OVER_FOREIGN_BUILD && nMessage.messageType != MessageType.RECEIVING_FOREIGN_INVEST && nMessage.messageType != MessageType.RECEIVING_FOREIGN_INVEST_BUILD && nMessage.messageType != MessageType.INVEST_IS_OVER_DEVELOPMENT) {
                        return;
                    }
                    if (nMessage.messageType != MessageType.TRANSFER_CONTROL || nMessage.iValue != this.lMessages.get((int)i).iValue) continue;
                    return;
                }
            }
        }
        this.lMessages.add(nMessage);
        this.iMessagesSize = this.lMessages.size();
    }

    public final void removeMessage(int i) {
        try {
            this.lMessages.remove(i);
            this.iMessagesSize = this.lMessages.size();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final void removeMessage_TypeFrom(int nFromCivID, MessageType nType) {
        try {
            for (int i = this.getMessagesSize() - 1; i >= 0; --i) {
                if (this.getMessage((int)i).fromCivID != nFromCivID || this.getMessage((int)i).messageType != nType) continue;
                this.removeMessage(i);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public Message getMessage(int i) {
        return this.lMessages.get(i);
    }

    public final void clearMessages() {
        this.lMessages.clear();
        this.iMessagesSize = 0;
    }

    public final int getMessagesSize() {
        return this.iMessagesSize;
    }
}

