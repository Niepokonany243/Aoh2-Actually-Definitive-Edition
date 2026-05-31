/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.io.Serializable;

public class Civilization_SentMessages
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iToCivID;
    public MessageType messageType = MessageType.GIFT;
    public int iSentInTurnID;

    public Civilization_SentMessages(int iToCivID, MessageType messageType) {
        this.iToCivID = iToCivID;
        this.messageType = messageType;
        this.iSentInTurnID = GameCalendar.TURNID;
    }
}

