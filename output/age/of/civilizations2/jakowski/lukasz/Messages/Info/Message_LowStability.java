
package age.of.civilizations2.jakowski.lukasz.Messages.Info;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Message_LowStability
extends Message {
    public Message_LowStability(int fromCivID, int iValue) {
        super(fromCivID, iValue);
        this.messageType = MessageType.LOW_STABILITY;
        this.numOfTurnsLeft = 1;
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
            lMess.add(CFG.lang.get("LowStability"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            lMess.add(CFG.lang.get("AssimilateTheProvincesToIncreaseStability"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                if (CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.size() > 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.get(0));
                }
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
            }
        }
    }

    @Override
    public void onDecline(int iCivID) {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == iCivID) {
            ArrayList<String> lMess = new ArrayList<String>();
            ArrayList<Color> lColors = new ArrayList<Color>();
            lMess.add(CFG.lang.get("LowStability"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            lMess.add(CFG.lang.get("AssimilateTheProvincesToIncreaseStability"));
            lColors.add(CFG.COLOR_NEGATIVE_2);
            CFG.toastM.addM(lMess, lColors);
            CFG.toastM.setTimeInView(4500);
            if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                if (CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.size() > 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.get(0));
                }
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
            }
        }
    }

    @Override
    public int getImageID() {
        return Images.diploStability;
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
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("LowStability"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Provinces") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.size(), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_STABILITY, CFG.PLAYER_TURN_ID));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AssimilateTheProvincesToIncreaseStability")));
        nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeOfProvinceIsReducedDueToLowStability"), CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        for (int i = 0; i < CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.size() && i < 10; ++i) {
            nData.add(new ME_Hover_2Type_Flag(this.fromCivID));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.get(i)).getName() + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.core.getCiv((int)this.fromCivID).provincesWithLowStability.get(i)).getProviStability() * 100.0f) + "%", CFG.COLOR_PROVINCE_STABILITY_MIN));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
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

