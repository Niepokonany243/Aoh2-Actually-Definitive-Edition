/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_ClosedEmbassy;
import age.of.civilizations2.jakowski.lukasz.Civilization_Diplomacy_ImproveRelations_GameData;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageBox_GameData;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Relations_Increase_Ended;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Civilization_Diplomacy_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Civilization_Diplomacy_ImproveRelations_GameData> lImproveRelations = new ArrayList<Civilization_Diplomacy_ImproveRelations_GameData>();
    public List<Civilization_ClosedEmbassy> lEmbassyClosed = new ArrayList<Civilization_ClosedEmbassy>();
    public int iEmbassyClosedSize = 0;
    public MessageBox_GameData messageBox = new MessageBox_GameData();

    public final boolean getIsImprovingRelations(int iWithCivID) {
        for (int i = 0; i < this.lImproveRelations.size(); ++i) {
            if (this.lImproveRelations.get((int)i).iWithCivID != iWithCivID) continue;
            return true;
        }
        return false;
    }

    public final int getIsImprovingRelationsTurns(int iWithCivID) {
        for (int i = 0; i < this.lImproveRelations.size(); ++i) {
            if (this.lImproveRelations.get((int)i).iWithCivID != iWithCivID) continue;
            return this.lImproveRelations.get((int)i).iNumOfTurns;
        }
        return -1;
    }

    public final void addImproveRelations(int iCivID, int iWithCivID, int iNumOfTurns) {
        if (CFG.core.getCiv(iWithCivID).getCivDiploGD().getIsEmbassyClosed(iCivID)) {
            return;
        }
        for (int i = 0; i < this.lImproveRelations.size(); ++i) {
            if (this.lImproveRelations.get((int)i).iWithCivID != iWithCivID) continue;
            this.lImproveRelations.get((int)i).iNumOfTurns = iNumOfTurns;
            return;
        }
        if (CFG.core.getCiv(iCivID).getDiploPoints() >= GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS) {
            CFG.core.getCiv(iCivID).setDiploPoints(CFG.core.getCiv(iCivID).getDiploPoints() - GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS);
            this.lImproveRelations.add(new Civilization_Diplomacy_ImproveRelations_GameData(iWithCivID, iNumOfTurns, iCivID));
            if (CFG.core.getCiv(iCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(iCivID), CFG.core.getCapitalOrProvince(iWithCivID), CFG.COLOR_POSITIVE, CFG.COLOR_POSITIVE_ACTIVE);
            } else if (CFG.core.getCiv(iWithCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(iWithCivID), CFG.core.getCapitalOrProvince(iCivID), CFG.COLOR_POSITIVE, CFG.COLOR_POSITIVE_ACTIVE);
            }
        }
    }

    public final void runImproveRelations(int iCivID) {
        for (int i = 0; i < this.lImproveRelations.size(); ++i) {
            if (!this.lImproveRelations.get(i).action(iCivID)) continue;
            if (CFG.core.getCiv(iCivID).getIsPlayer()) {
                CFG.core.getCiv((int)iCivID).getCivDiploGD().messageBox.addMessage(new Message_Relations_Increase_Ended(this.lImproveRelations.get((int)i).iWithCivID));
            }
            this.lImproveRelations.remove(i--);
        }
    }

    public final int getImproveRelationsSize() {
        return this.lImproveRelations.size();
    }

    public final Civilization_Diplomacy_ImproveRelations_GameData getImproveRelation(int i) {
        return this.lImproveRelations.get(i);
    }

    public final void removeImproveRelations(int iCivID, int i) {
        try {
            CFG.core.getCiv(iCivID).setDiploPoints(CFG.core.getCiv(iCivID).getDiploPoints() + GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS);
            this.lImproveRelations.remove(i);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void removeImproveRelations_WithCivID(int iCivID, int withCivID) {
        try {
            for (int i = 0; i < this.lImproveRelations.size(); ++i) {
                if (this.lImproveRelations.get((int)i).iWithCivID != withCivID) continue;
                CFG.core.getCiv(iCivID).setDiploPoints(CFG.core.getCiv(iCivID).getDiploPoints() + GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS);
                this.lImproveRelations.remove(i);
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void addEmbassyClosed(Civilization_ClosedEmbassy nData) {
        synchronized (this.lEmbassyClosed) {
            for (int i = 0; i < this.lEmbassyClosed.size(); ++i) {
                if (this.lEmbassyClosed.get((int)i).iCivID != nData.iCivID) continue;
                this.lEmbassyClosed.get((int)i).iNumOfTurns = Math.max(this.lEmbassyClosed.get((int)i).iNumOfTurns, nData.iNumOfTurns);
                return;
            }
            this.lEmbassyClosed.add(nData);
            this.iEmbassyClosedSize = this.lEmbassyClosed.size();
        }
    }

    public final void clearEmbassyClosed() {
        this.lEmbassyClosed.clear();
        this.iEmbassyClosedSize = 0;
    }

    public final void updateEmbassyClosed() {
        synchronized (this.lEmbassyClosed) {
            for (int i = this.lEmbassyClosed.size() - 1; i >= 0; --i) {
                if (--this.lEmbassyClosed.get((int)i).iNumOfTurns > 0) continue;
                this.lEmbassyClosed.remove(i);
            }
            this.iEmbassyClosedSize = this.lEmbassyClosed.size();
        }
    }

    public final void removeEmbassyClosedWithCivID(int nCivID) {
        synchronized (this.lEmbassyClosed) {
            for (int i = 0; i < this.lEmbassyClosed.size(); ++i) {
                if (this.lEmbassyClosed.get((int)i).iCivID != nCivID) continue;
                this.lEmbassyClosed.remove(i);
                this.iEmbassyClosedSize = this.lEmbassyClosed.size();
                return;
            }
        }
    }

    public final boolean getIsEmbassyClosed(int nCivID) {
        synchronized (this.lEmbassyClosed) {
            for (int i = 0; i < this.lEmbassyClosed.size(); ++i) {
                if (this.lEmbassyClosed.get((int)i).iCivID != nCivID) continue;
                return true;
            }
        }
        return false;
    }

    public final int isEmbassyClosed_Turns(int nCivID) {
        for (int i = 0; i < this.iEmbassyClosedSize; ++i) {
            if (this.lEmbassyClosed.get((int)i).iCivID != nCivID) continue;
            return this.lEmbassyClosed.get((int)i).iNumOfTurns;
        }
        return 0;
    }

    public int getEmbassyClosedSize() {
        return this.iEmbassyClosedSize;
    }

    public final Civilization_ClosedEmbassy getEmbassyClosed(int i) {
        return this.lEmbassyClosed.get(i);
    }
}

