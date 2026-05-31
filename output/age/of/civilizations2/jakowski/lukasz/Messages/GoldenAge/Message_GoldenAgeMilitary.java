
package age.of.civilizations2.jakowski.lukasz.Messages.GoldenAge;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivBonus_Type;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import java.util.ArrayList;

public class Message_GoldenAgeMilitary
extends Message {
    public Message_GoldenAgeMilitary(int fromCivID, int iNumOfTurns) {
        super(fromCivID, 0);
        this.messageType = MessageType.GOLDEN_AGE_MILITARY;
        this.numOfTurnsLeft = iNumOfTurns;
    }

    @Override
    public void onAction(int iMessageID) {
        CFG.toastM.addM(CFG.lang.get("OurCivilizationIsInAGoldenAgeOf") + ": " + CFG.lang.get("GAMilitary"), CFG.COLOR_TEXT_GOLDEN_AGE);
        CFG.menus.rebuildMenu_InGame_InfoboxDate(CFG.lang.get("OurCivilizationIsInAGoldenAgeOf") + ": " + CFG.lang.get("GAMilitary"), this.fromCivID, -1, Images.infoDiplomacy);
        try {
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(iMessageID);
            CFG.menus.rebuildInGame_Messages();
        }
        catch (Exception exception) {
            
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
        return Images.diploGoldenAgeM;
    }

    @Override
    public ME_Hover_v2 getHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.fromCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OurCivilizationIsInAGoldenAgeOf") + ": ", CFG.COLOR_TEXT_GOLDEN_AGE));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GAMilitary")));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        int nID = -1;
        for (int i = 0; i < CFG.core.getCiv(this.fromCivID).getBonusesSize(); ++i) {
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)i).BONUS_TYPE != CivBonus_Type.GOLDEN_AGE_MILITARY) continue;
            nID = i;
            break;
        }
        if (nID >= 0) {
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_Research != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_Research > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_Research * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_Research > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_AttackBonus != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AttackBonus") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_AttackBonus > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_AttackBonus * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_AttackBonus > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_DefenseBonus != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_DefenseBonus > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_DefenseBonus * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_DefenseBonus > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_PopGrowth != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_PopGrowth > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_PopGrowth * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_PopGrowth > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_EconomyGrowth != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_EconomyGrowth > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_EconomyGrowth * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_EconomyGrowth > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeTaxation != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeTaxation > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeTaxation * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeTaxation > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeProduction != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeProduction > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeProduction * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_IncomeProduction > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MilitaryUpkeep != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MilitaryUpkeep > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MilitaryUpkeep * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MilitaryUpkeep < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MovementPoints != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MovementPoints > 0.0f ? "+" : "") + (int)(CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MovementPoints * 100.0f) + "%", CFG.core.getCiv((int)this.fromCivID).getBonus((int)nID).fModifier_MovementPoints > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
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

