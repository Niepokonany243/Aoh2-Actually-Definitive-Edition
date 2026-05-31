
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Peace;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_WhitePeace
extends Event_Outcome {
    private static final long serialVersionUID = 6483432285845122812L;
    public int iCivID = -1;
    public int iCivID2 = -1;

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public int getCivID2() {
        return this.iCivID2;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.iCivID2 = nCivID;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        boolean out = false;
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        if (this.iCivID2 == nRemovedCivID) {
            this.iCivID2 = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID2) {
            --this.iCivID2;
        }
        return out;
    }

    @Override
    public void outcomeAction() {
        if (this.canMakeAction()) {
            try {
                if (this.getCivID2() <= 0) {
                    int a;
                    ArrayList<Integer> tC = new ArrayList<Integer>();
                    for (a = 0; a < CFG.core.getCiv((int)this.getCivID()).isAtWarWithCivs.size(); ++a) {
                        tC.add(CFG.core.getCiv((int)this.getCivID()).isAtWarWithCivs.get(a));
                    }
                    for (a = 0; a < tC.size(); ++a) {
                        CFG.core.whitePeace(this.getCivID(), (Integer)tC.get(a));
                        CFG.historyManager.addHistoryLog(new HistoryLog_Peace(this.getCivID(), (Integer)tC.get(a)));
                    }
                    tC.clear();
                } else {
                    int warID = CFG.core.getWarID(this.getCivID(), this.getCivID2());
                    if (warID >= 0) {
                        int a;
                        ArrayList<Integer> civsDef = new ArrayList<Integer>();
                        ArrayList<Integer> civsAgg = new ArrayList<Integer>();
                        for (a = 0; a < CFG.core.getWar(warID).getDefendersSize(); ++a) {
                            civsDef.add(CFG.core.getWar(warID).getDefenderID(a).getCivID());
                        }
                        for (a = 0; a < CFG.core.getWar(warID).getAggressorsSize(); ++a) {
                            civsAgg.add(CFG.core.getWar(warID).getAggressorID(a).getCivID());
                        }
                        for (a = civsDef.size() - 1; a >= 0; --a) {
                            for (int b = civsAgg.size() - 1; b >= 0; --b) {
                                CFG.core.whitePeace((Integer)civsDef.get(a), (Integer)civsAgg.get(b));
                            }
                        }
                    } else {
                        CFG.core.whitePeace(this.getCivID(), this.getCivID2());
                        CFG.historyManager.addHistoryLog(new HistoryLog_Peace(this.getCivID(), this.getCivID2()));
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public boolean canMakeAction() {
        try {
            if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
                return true;
            }
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && this.getCivID2() >= 0 && this.getCivID2() < CFG.core.getCivsSize() && (int)CFG.core.getCivRelationOfCivB(this.getCivID(), this.getCivID2()) == GameValues.gvDiplomacy.RELATION_AT_WAR;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("WhitePeace") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), 0, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName()));
                tData.add(new ME_Hover_2Type_Text(" - "));
                if (this.getCivID2() <= 0) {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations") + ": " + CFG.lang.get("AtWar")));
                } else {
                    tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID2()).getCivName()));
                    tData.add(new ME_Hover_2Type_Flag(this.getCivID2(), CFG.PADD, 0));
                }
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (Exception exception) {
            return new ArrayList<MEHover_2E>();
        }
    }

    @Override
    public String getConditionText() {
        try {
            if (this.getCivID2() <= 0) {
                return CFG.lang.get("WhitePeace") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " - " + CFG.lang.get("AllCivilizations") + ": " + CFG.lang.get("AtWar");
            }
            return CFG.lang.get("WhitePeace") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + CFG.core.getCiv(this.getCivID2()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("WhitePeace");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_WHITEPEACE);
    }
}

