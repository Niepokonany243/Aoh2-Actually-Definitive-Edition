
package age.of.civilizations2.jakowski.lukasz.Messages.Truce;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
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
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Message_PeaceTreaty
extends Message {
    public Message_PeaceTreaty(int fromCivID, String peaceTreatyTag) {
        super(fromCivID, 0);
        this.TAG = peaceTreatyTag;
        this.messageType = MessageType.PEACE_TREATY_LIST_OF_DEMANDS;
        this.requestsResponse = GameValues.gvPeaceTreaty.PEACE_TREATY_REQUESTS_RESPONSE;
        this.willPauseTheGame = GameValues.gvPeaceTreaty.PEACE_TREATY_REQUESTS_RESPONSE;
        this.numOfTurnsLeft = 1;
    }

    @Override
    public void onAction(int iMessageID) {
        int peaceID = CFG.core.getPeaceTreaty_GameDataID(this.TAG);
        if (peaceID >= 0) {
            boolean warFound = false;
            for (int i = 0; i < CFG.core.getWarsSize(); ++i) {
                if (!CFG.core.getWar((int)i).WAR_TAG.equals(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.WAR_TAG)) continue;
                CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.iWarID = i;
                warFound = true;
                break;
            }
            if (warFound) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                CFG.mapModesManager.disableAllViews();
                CFG.peaceTreatyData = new PeaceTreaty_Data(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData);
                CFG.core.sRespondToPeaceTreatyID = this.TAG;
                CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
                CFG.menus.rebuildInGame_Messages();
                CFG.menus.setMenuID(View.eINGAME_PEACE_TREATY_RESPONSE);
                CFG.toastM.addM(CFG.lang.get("PeaceOffer"));
                CFG.toastM.setTimeInView(2000);
            } else {
                CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
                CFG.menus.rebuildInGame_Messages();
                CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(1500);
            }
        } else {
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
            CFG.menus.rebuildInGame_Messages();
            CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(1500);
        }
    }

    @Override
    public void onAccept(int iCivID) {
        try {
            GameManager.acceptPeaceTreaty(iCivID, this.TAG);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void onDecline(int iCivID) {
        try {
            GameManager.declinePeaceTreaty(iCivID, this.TAG);
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public int getImageID() {
        return Images.peace;
    }

    @Override
    public ME_Hover_v2 getHover() {
        try {
            int j;
            int i;
            int peaceID = CFG.core.getPeaceTreaty_GameDataID(this.TAG);
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PeaceNegotiations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDataDefenders.size(); ++i) {
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDataDefenders.get((int)i).iCivID, i == 0 ? CFG.PADD : 0, 0));
            }
            nData.add(new ME_Hover_2Type_Image_Big(Images.peace, CFG.PADD, CFG.PADD));
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDataAggressors.size(); ++i) {
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDataAggressors.get((int)i).iCivID, 0, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.size(); ++i) {
                if (CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.size() <= 0) continue;
                nData.add(new ME_Hover_2Type_Flag(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(" - " + CFG.lang.get("Provinces") + ": " + CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.size()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (j = 0; j < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.size() && j < 5; ++j) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.get(j)).getTrueOwnerOfProv(), 0, 0));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).iCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.get(j)).getName(), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(" " + CFG.core.getProvinceValue(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).lDemands.get(j)), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.size(); ++i) {
                if (CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.size() <= 0) continue;
                nData.add(new ME_Hover_2Type_Flag(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).iCivID));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(" - " + CFG.lang.get("Provinces") + ": " + CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.size()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (j = 0; j < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.size() && j < 5; ++j) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.get(j)).getTrueOwnerOfProv(), 0, 0));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).iCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.get(j)).getName(), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(" " + CFG.core.getProvinceValue(CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).lDemands.get(j)), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
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
            return new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException peaceID) {
        }
        catch (NullPointerException peaceID) {
            
        }
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PeaceNegotiations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
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

