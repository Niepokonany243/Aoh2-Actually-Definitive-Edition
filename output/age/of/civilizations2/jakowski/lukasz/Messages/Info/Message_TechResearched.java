
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
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

public class Message_TechResearched
extends Message {
    public Message_TechResearched(int fromCivID) {
        super(fromCivID, 0);
        this.messageType = MessageType.TECHNOLOGY_RESEARCHED;
        this.numOfTurnsLeft = 2;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.menus.rebuildMenu_InGame_InfoBox_TechResearched();
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
        CFG.menus.rebuildInGame_Messages();
        for (int i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i) {
            if (!CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getDrawProv()) continue;
            CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).setFromCivID(0);
        }
        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
    }

    @Override
    public void onAccept(int iCivID) {
    }

    @Override
    public void onDecline(int iCivID) {
    }

    @Override
    public int getImageID() {
        return Images.research;
    }

    @Override
    public int getBGImageID() {
        return Images.messages;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TechnologyLevelResearched") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCiv(this.fromCivID).getTechLevel() * 100.0f)) / 100.0f));
        nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllProvinces") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + " +" + CFG.getPrecision2(GameValues.gvTechnology.TECH_RESEARCHED_HAPPINESS_ALL_PROVINCES_BONUS * 100.0f, 100), CFG.COLOR_POSITIVE));
        nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + " +" + CFG.getPrecision2(GameValues.gvTribal.TECH_RESEARCHED_ECONOMY_CAPITAL, 100), CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + " +" + CFG.getPrecision2(GameValues.gvTribal.TECH_RESEARCHED_DEVELOPMENT_CAPITAL, 1000), CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + " +" + CFG.getPrecision2(GameValues.gvTribal.TECH_RESEARCHED_HAPPINESS_CAPITAL * 100.0f, 100), CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
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

