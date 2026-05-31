/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Messages.Province;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Images;
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
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Message_Plunder_Plundred
extends Message {
    private int iEconomy;
    private long iPopulation;
    private float fHappiness;
    private float fDevelopment;

    public Message_Plunder_Plundred(int fromCivID, int iValue, int iEconomy, float fDevelopment, float fHappiness, long iPopulation) {
        super(fromCivID, iValue);
        this.iEconomy = iEconomy;
        this.fHappiness = fHappiness;
        this.fDevelopment = fDevelopment;
        this.iPopulation = iPopulation;
        this.messageType = MessageType.PLUNDER_REPORT_PLUNDRED;
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
            lMess.add(CFG.lang.get("ProvincePlundered") + (CFG.core.getProv((int)this.iValue).getName().length() > 0 ? ": " + CFG.core.getProv((int)this.iValue).getName() : ""));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            CFG.core.setActiveProvID((int)this.iValue);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("ProvincePlundered") + (CFG.core.getProv((int)this.iValue).getName().length() > 0 ? ": " + CFG.core.getProv((int)this.iValue).getName() : ""));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            CFG.core.setActiveProvID((int)this.iValue);
        }
    }

    @Override
    public int getImageID() {
        return Images.diploPlunder;
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
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvincePlundered") + (CFG.core.getProv((int)this.iValue).getName().length() > 0 ? ": " + CFG.core.getProv((int)this.iValue).getName() : ""), CFG.COLOR_NEGATIVE_2));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + this.iPopulation, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + this.iEconomy, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if ((int)(this.fDevelopment * 100.0f) > 0) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
            nData.add(new ME_Hover_2Type_Text("-" + (float)((int)(this.fDevelopment * 100.0f)) / 100.0f, CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + (int)(this.fHappiness * 100.0f) + "%", CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.happiness2, CFG.PADD, 0));
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


