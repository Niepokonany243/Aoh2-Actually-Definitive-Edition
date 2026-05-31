
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Message_Uncivilized
extends Message {
    public Message_Uncivilized(int fromCivID) {
        super(fromCivID, 0);
        this.messageType = MessageType.UNCIVILIZED;
        this.numOfTurnsLeft = 1;
    }

    @Override
    public void onAction(int iMessageID) {
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
            CFG.toastM.addM(CFG.lang.get("UncivilizedTypeOfGovernment"), CFG.COLOR_TEXT_GOLDEN_AGE);
            CFG.menus.rebuildInGame_Civilize(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
    }

    @Override
    public void onAccept(int iCivID) {
    }

    @Override
    public void onDecline(int iCivID) {
    }

    @Override
    public int getImageID() {
        return Images.diploLord;
    }

    @Override
    public int getBGImageID() {
        return CFG.core.getCiv(this.fromCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? Images.messages_g : Images.messages_r;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("UncivilizedTypeOfGovernment"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Government") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.fromCivID).getIdeology()).getName(), new Color(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).getColor().b, 1.0f)));
        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(this.fromCivID).getIdeology(), CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Uncivilized").toUpperCase(), CFG.COLOR_NEGATIVE_2));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(this.fromCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? Images.iconTrue : Images.iconFalse, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text("[", CFG.core.getCiv(this.fromCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Flag(this.fromCivID, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(this.fromCivID).getTechLevel() * 100.0f)) / 100.0f, CFG.core.getCiv(this.fromCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Text("]", CFG.core.getCiv(this.fromCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.fromCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text("" + (float)GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS / 10.0f));
        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(this.fromCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
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

