/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_GameData;
import age.of.civilizations2.jakowski.lukasz.Event_SelectCivAction;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.Events_GameData;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Event;
import age.of.civilizations2.jakowski.lukasz.View;

public class EventsManager {
    public Events_GameData events = new Events_GameData();
    public Event_GameData createScenarioEvents = new Event_GameData();
    public int iCreateEvent_Day = 1;
    public int iCreateEvent_Month = 1;
    public int iCreateEvent_Year = 0;
    public int iCreateEvent_Age = 0;
    public boolean setSinceDate = true;
    public int createEvent_EditEventID = 0;
    public int createEvent_EditTriggerID = 0;
    public int createEvent_EditConditionID = 0;
    public Event_SelectCivAction eSelectCivAction = Event_SelectCivAction.SELECT_RECIPENT;

    public final void runEvents() {
        try {
            for (int i = 0; i < this.events.iEventsSize; ++i) {
                if (this.events.lEvents.get(i).getWasFired() || this.events.lEvents.get((int)i).isMission && this.events.lEvents.get(i).getCivID() >= 0 && CFG.core.getCiv(this.events.lEvents.get(i).getCivID()).getIsPlayer() || this.events.lEvents.get((int)i).getEventDate_Since().iEventYear >= GameCalendar.currYear && this.events.lEvents.get((int)i).getEventDate_Since().iEventYear != 9999999 && (this.events.lEvents.get((int)i).getEventDate_Since().iEventYear != GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Since().iEventMonth >= GameCalendar.currMonth) && (this.events.lEvents.get((int)i).getEventDate_Since().iEventYear != GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Since().iEventMonth != GameCalendar.currMonth || this.events.lEvents.get((int)i).getEventDate_Since().iEventDay > GameCalendar.currDay)) continue;
                if (!this.events.lEvents.get(i).getWasTriedToRunOnce()) {
                    this.events.lEvents.get(i).setWasTriedToRunOnce(true);
                    this.checkConditionsAndTryRun(i);
                    continue;
                }
                if (this.events.lEvents.get((int)i).getEventDate_Until().iEventYear != 9999999 && this.events.lEvents.get((int)i).getEventDate_Until().iEventYear <= GameCalendar.currYear && (this.events.lEvents.get((int)i).getEventDate_Until().iEventYear != GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Until().iEventMonth <= GameCalendar.currMonth) && (this.events.lEvents.get((int)i).getEventDate_Until().iEventYear != GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Until().iEventMonth != GameCalendar.currMonth || this.events.lEvents.get((int)i).getEventDate_Until().iEventDay < GameCalendar.currDay)) continue;
                this.checkConditionsAndTryRun(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public boolean runMissionPlayer(int i, int civID) {
        if (this.canRunMissionID(i, civID)) {
            Menu_InGame_Event.EVENT_ID = i;
            this.events.lEvents.get(i).setWasFired(!this.events.lEvents.get(i).getRepeatable());
            CFG.menus.rebuildInGame_Event();
            return true;
        }
        return false;
    }

    public final boolean canRunMissionID(int i, int civID) {
        try {
            if (!this.events.lEvents.get(i).getWasFired() && this.events.lEvents.get((int)i).isMission && (this.events.lEvents.get((int)i).getEventDate_Since().iEventYear < GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Since().iEventYear == 9999999 || this.events.lEvents.get((int)i).getEventDate_Since().iEventYear == GameCalendar.currYear && this.events.lEvents.get((int)i).getEventDate_Since().iEventMonth < GameCalendar.currMonth || this.events.lEvents.get((int)i).getEventDate_Since().iEventYear == GameCalendar.currYear && this.events.lEvents.get((int)i).getEventDate_Since().iEventMonth == GameCalendar.currMonth && this.events.lEvents.get((int)i).getEventDate_Since().iEventDay <= GameCalendar.currDay)) {
                if (!this.events.lEvents.get(i).getWasTriedToRunOnce()) {
                    this.events.lEvents.get(i).setWasTriedToRunOnce(true);
                    return this.checkConditionsAndTryRunMission(i, civID);
                }
                if (this.events.lEvents.get((int)i).getEventDate_Until().iEventYear == 9999999 || this.events.lEvents.get((int)i).getEventDate_Until().iEventYear > GameCalendar.currYear || this.events.lEvents.get((int)i).getEventDate_Until().iEventYear == GameCalendar.currYear && this.events.lEvents.get((int)i).getEventDate_Until().iEventMonth > GameCalendar.currMonth || this.events.lEvents.get((int)i).getEventDate_Until().iEventYear == GameCalendar.currYear && this.events.lEvents.get((int)i).getEventDate_Until().iEventMonth == GameCalendar.currMonth && this.events.lEvents.get((int)i).getEventDate_Until().iEventDay >= GameCalendar.currDay) {
                    return this.checkConditionsAndTryRunMission(i, civID);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final boolean checkConditionsAndTryRunMission(int i, int civID) {
        for (int j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
            if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType != Event_Type.OR || !this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) continue;
            return true;
        }
        boolean canRunEvent = true;
        boolean checked = false;
        for (int j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
            if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType == Event_Type.OR) continue;
            if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType == Event_Type.AND) {
                if (!this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) {
                    canRunEvent = false;
                    break;
                }
                checked = true;
                continue;
            }
            if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType != Event_Type.NOT) continue;
            if (this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) {
                canRunEvent = false;
                break;
            }
            checked = true;
        }
        if (!checked) {
            canRunEvent = false;
        }
        return canRunEvent;
    }

    public final void checkConditionsAndTryRun(int i) {
        boolean canRunEvent = false;
        for (int j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
            if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType != Event_Type.OR || !this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) continue;
            canRunEvent = true;
            break;
        }
        if (!canRunEvent) {
            canRunEvent = true;
            boolean checked = false;
            for (int j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
                if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType == Event_Type.OR) continue;
                if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType == Event_Type.AND) {
                    if (!this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) {
                        canRunEvent = false;
                        break;
                    }
                    checked = true;
                    continue;
                }
                if (this.events.lEvents.get((int)i).lTriggers.get((int)j).triggerType != Event_Type.NOT) continue;
                if (this.events.lEvents.get((int)i).lTriggers.get(j).getTriggerOut()) {
                    canRunEvent = false;
                    break;
                }
                checked = true;
            }
            if (!checked) {
                canRunEvent = false;
            }
        }
        if (canRunEvent) {
            this.try_RunEvent(i);
        }
    }

    public final void try_RunEvent(int i) {
        if (this.events.lEvents.get(i).getCivID() > 0) {
            try {
                CFG.core.getCiv(this.events.lEvents.get(i).getCivID()).addEventToRunId(i);
                this.events.lEvents.get(i).setWasFired(!this.events.lEvents.get(i).getRepeatable());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
        } else if (this.events.lEvents.get(i).getCivID() == 0) {
            try {
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).addEventToRunId(i);
                this.events.lEvents.get(i).setWasFired(!this.events.lEvents.get(i).getRepeatable());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                // empty catch block
            }
        }
    }

    public final void runEventTag(String nTag) {
        int tID = -1;
        for (int i = 0; i < this.getEventsSize(); ++i) {
            if (!this.getEvent(i).getEventTag().equals(nTag)) continue;
            tID = i;
            break;
        }
        if (tID >= 0) {
            CFG.core.getCiv(this.events.lEvents.get(tID).getCivID()).addEventToRunId(tID);
            this.events.lEvents.get(tID).setWasFired(!this.events.lEvents.get(tID).getRepeatable());
        }
    }

    public void FXABF() {
        try {
            int i;
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                CFG.core.getCiv((int)i).iDMAS.clear();
            }
            for (i = 0; i < this.events.iEventsSize; ++i) {
                if (!this.events.lEvents.get((int)i).isMission || this.events.lEvents.get(i).getCivID() <= 0) continue;
                CFG.core.getCiv((int)this.events.lEvents.get((int)i).getCivID()).iDMAS.add(i);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void addEvent(Event_GameData nEvent) {
        this.events.lEvents.add(nEvent);
        this.events.iEventsSize = this.events.lEvents.size();
    }

    public final void updateEventsAfterRemoveCiv(int nRemovedCivID) {
        for (int i = 0; i < this.events.iEventsSize; ++i) {
            int k;
            int j;
            if (this.events.lEvents.get(i).getCivID() == nRemovedCivID) {
                this.removeEvent(i--);
                continue;
            }
            if (this.events.lEvents.get(i).getCivID() > nRemovedCivID) {
                this.events.lEvents.get(i).setCivID(this.events.lEvents.get(i).getCivID() - 1);
            }
            for (j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
                for (k = 0; k < this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.size(); ++k) {
                    this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).updateCivIDAfterRemove(nRemovedCivID);
                }
            }
            for (j = 0; j < this.events.lEvents.get((int)i).lDecisions.size(); ++j) {
                for (k = 0; k < this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.size(); ++k) {
                    this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).updateCivIDAfterRemove(nRemovedCivID);
                }
            }
        }
    }

    public final void swapIDsOfCivs(int nID_A, int nID_B) {
        for (int i = 0; i < this.events.iEventsSize; ++i) {
            int k;
            int j;
            if (this.events.lEvents.get(i).getCivID() == nID_A) {
                this.events.lEvents.get(i).setCivID(nID_B);
            } else if (this.events.lEvents.get(i).getCivID() == nID_B) {
                this.events.lEvents.get(i).setCivID(nID_A);
            }
            for (j = 0; j < this.events.lEvents.get((int)i).lTriggers.size(); ++j) {
                for (k = 0; k < this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.size(); ++k) {
                    if (this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).getCivID() == nID_A) {
                        this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).setCivID(nID_B);
                    } else if (this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).getCivID() == nID_B) {
                        this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).setCivID(nID_A);
                    }
                    if (this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).getCivID2() == nID_A) {
                        this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).setCivID2(nID_B);
                        continue;
                    }
                    if (this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).getCivID2() != nID_B) continue;
                    this.events.lEvents.get((int)i).lTriggers.get((int)j).lConditions.get(k).setCivID2(nID_A);
                }
            }
            for (j = 0; j < this.events.lEvents.get((int)i).lDecisions.size(); ++j) {
                for (k = 0; k < this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.size(); ++k) {
                    if (this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).getCivID() == nID_A) {
                        this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).setCivID(nID_B);
                    } else if (this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).getCivID() == nID_B) {
                        this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).setCivID(nID_A);
                    }
                    if (this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).getCivID2() == nID_A) {
                        this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).setCivID2(nID_B);
                        continue;
                    }
                    if (this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).getCivID2() != nID_B) continue;
                    this.events.lEvents.get((int)i).lDecisions.get((int)j).lOutcomes.get(k).setCivID2(nID_A);
                }
            }
        }
    }

    public final void sortEventsByDate() {
        for (int i = 0; i < this.getEventsSize() - 1; ++i) {
            for (int j = i + 1; j < this.getEventsSize(); ++j) {
                Event_GameData tempD;
                if (this.getEvent((int)i).getEventDate_Since().iEventYear > this.getEvent((int)j).getEventDate_Since().iEventYear) {
                    tempD = this.getEvent(i);
                    this.setEvent(i, this.getEvent(j));
                    this.setEvent(j, tempD);
                    continue;
                }
                if (this.getEvent((int)i).getEventDate_Since().iEventYear != this.getEvent((int)j).getEventDate_Since().iEventYear) continue;
                if (this.getEvent((int)i).getEventDate_Since().iEventMonth > this.getEvent((int)j).getEventDate_Since().iEventMonth) {
                    tempD = this.getEvent(i);
                    this.setEvent(i, this.getEvent(j));
                    this.setEvent(j, tempD);
                    continue;
                }
                if (this.getEvent((int)i).getEventDate_Since().iEventMonth != this.getEvent((int)j).getEventDate_Since().iEventMonth || this.getEvent((int)i).getEventDate_Since().iEventDay <= this.getEvent((int)j).getEventDate_Since().iEventDay) continue;
                tempD = this.getEvent(i);
                this.setEvent(i, this.getEvent(j));
                this.setEvent(j, tempD);
            }
        }
    }

    public final void setEvent(int i, Event_GameData tDate) {
        this.events.lEvents.set(i, tDate);
    }

    public final void clearEvents() {
        this.events.lEvents.clear();
        this.events.iEventsSize = 0;
    }

    public final void removeEvent(int i) {
        this.events.lEvents.remove(i);
        this.events.iEventsSize = this.events.lEvents.size();
    }

    public final String getEventTypeText(Event_Type tType) {
        if (tType == Event_Type.AND) {
            return CFG.lang.get("AND");
        }
        if (tType == Event_Type.OR) {
            return CFG.lang.get("OR");
        }
        return CFG.lang.get("NOT");
    }

    public final void selectCivAction(int nCivID) {
        switch (this.eSelectCivAction) {
            case SELECT_RECIPENT: {
                this.createScenarioEvents.setCivID(nCivID);
                break;
            }
            case SELECT_COND_CIV_EXIST: 
            case COND_SELECTCIV_DECISIONTAKEN: 
            case SELECT_CIV_CONTROL_PROVINCES: 
            case SELECT_CIV_CONTROL_OCCUPIED: 
            case SELECT_CIV_HAVE_ARMY: 
            case SELECT_CIV_CORE: 
            case SELECT_CIV_ISCAPITAL: 
            case SELECT_CIV_NUMOFPROVINCES: 
            case SELECT_CIV_NUMOFPROVINCES_LOW: 
            case SELECT_CIV_NUMOFUNITS: 
            case SELECT_CIV_NUMOFUNITS_LOW: 
            case SELECT_CIV_NUMOFVASSALS: 
            case SELECT_CIV_NUMOFVASSALS_LOW: 
            case SELECT_CIV_NUMOFWARS: 
            case SELECT_CIV_NUMOFWARS_LOW: 
            case SELECT_CIV_NUMOFALLIES: 
            case SELECT_CIV_NUMOFALLIES_LOW: 
            case SELECT_CIV_NUMOFNEIGHBORS_LOW: 
            case SELECT_CIV_NUMOFNEIGHBORS: 
            case SELECT_CIV_POPULATION: 
            case SELECT_CIV_POPULATION_LOW: 
            case SELECT_CIV_ECONOMY_LOW: 
            case SELECT_CIV_ECONOMY: 
            case SELECT_CIV_RELATION_LOW: 
            case SELECT_CIV_RELATION: 
            case SELECT_CIV_ISATWAR: 
            case SELECT_CIV_ALLIES: 
            case SELECT_CIV_ATWAR: 
            case SELECT_CIV_DEFENSIVE: 
            case SELECT_CIV_INDEPENDENCE: 
            case SELECT_CIV_NONAGGRESSION: 
            case SELECT_CIV_MILITARYACCESS: 
            case SELECT_CIV_ISVASSAL: 
            case SELECT_CIV_ISVASSALOFCIV: 
            case SELECT_CIV_ISPARTOFHRE: 
            case SELECT_CIV_IDEOLOGY: 
            case SELECT_CIV_TECHNOLOGY: 
            case SELECT_CIV_TECHNOLOGY_LOW: 
            case SELECT_CIV_HAPPINESS: 
            case SELECT_CIV_HAPPINESS_LOW: 
            case SELECT_CIV_TREASURY: 
            case SELECT_CIV_TREASURY_LOW: 
            case SELECT_CIV_CONTROLLEDBYPLAYER: 
            case SELECT_CIV_RELIGION: 
            case SELECT_CIV_LEADER_COND: 
            case SELECT_CIV_COND_ADM_POLICY: 
            case SELECT_CIV_NUKES: 
            case SELECT_CIV_NUKES_LOW: 
            case SELECT_CIV_INVESTS: 
            case SELECT_CIV_INVESTSLOW: 
            case SELECT_CIV_ASSI: 
            case SELECT_CIV_ASSILOW: 
            case SELECT_CIV_FESTIVALS: 
            case SELECT_CIV_FESTIVALSLOW: 
            case SELECT_CIV_FESTIVALSCOST: 
            case SELECT_CIV_FESTIVALSCOSTLOW: 
            case SELECT_CIV_INVESTSCOST: 
            case SELECT_CIV_INVESTSCOSTLOW: 
            case SELECT_CIV_INVESTSDEVCOST: 
            case SELECT_CIV_INVESTSDEVCOSTLOW: 
            case SELECT_CIV_ECO_GAINED: 
            case SELECT_CIV_ECO_GAINEDLOW: 
            case SELECT_CIV_ASSICOST: 
            case SELECT_CIV_ASSICOSTLOW: 
            case SELECT_CIV_MILITARYEXPRERTISE: 
            case SELECT_CIV_MILITARYEXPRERTISELOW: 
            case SELECT_CIV_WAR_CASU: 
            case SELECT_CIV_WAR_CASULOW: 
            case SELECT_CIV_CONQU_PROVS: 
            case SELECT_CIV_CONQU_PROVSLOW: 
            case SELECT_CIV_BUILDINGSCONS: 
            case SELECT_CIV_BUILDINGSCONSLOW: 
            case SELECT_CIV_RECRUITEDARMY: 
            case SELECT_CIV_RECRUITEDARMYLOW: 
            case SELECT_CIV_STABILITY: 
            case SELECT_CIV_STABILITYLOW: 
            case SELECT_CIV_AVEDEV: 
            case SELECT_CIV_AVEDEVLOW: 
            case SELECT_CIV_BFORTS: 
            case SELECT_CIV_BTOWERS: 
            case SELECT_CIV_BPORTS: 
            case SELECT_CIV_BFARMS: 
            case SELECT_CIV_BWORKSHOPS: 
            case SELECT_CIV_BLIBRARIES: 
            case SELECT_CIV_BARMORIES: 
            case SELECT_CIV_BSUPPLIES: 
            case SELECT_CIV_BMARKETS: {
                this.createScenarioEvents.getTrigger((int)this.createEvent_EditTriggerID).lConditions.get(this.createEvent_EditConditionID).setCivID(nCivID);
                break;
            }
            case SELECT_CIV_RELATION2: 
            case SELECT_CIV_RELATION_LOW2: 
            case SELECT_CIV_ALLIES2: 
            case SELECT_CIV_ATWAR2: 
            case SELECT_CIV_DEFENSIVE2: 
            case SELECT_CIV_INDEPENDENCE2: 
            case SELECT_CIV_NONAGGRESSION2: 
            case SELECT_CIV_MILITARYACCESS2: 
            case SELECT_CIV_ISVASSALOFCIV2: {
                this.createScenarioEvents.getTrigger((int)this.createEvent_EditTriggerID).lConditions.get(this.createEvent_EditConditionID).setCivID2(nCivID);
                break;
            }
            case SELECT_CONTROLS_PROVINCES: 
            case SELECT_OCCUPIED_PROVINCES: 
            case SELECT_PROVINCES_HAVEARMY: 
            case SELECT_PROVINCES_HAVECORE: 
            case SELECT_PROVINCES_ISCAPITAL: 
            case SELECT_PROVINCES_DEVELOPMENT: 
            case SELECT_PROVINCES_DEVELOPMENT_LOW: 
            case SELECT_PROVINCES_WASTELAND: 
            case SELECT_PROVINCES_NEUTRAL: 
            case SELECT_PROVINCES_WATCHTOWER: 
            case SELECT_PROVINCES_FORT: 
            case SELECT_PROVINCES_FARM: 
            case SELECT_PROVINCES_PORT: {
                this.createScenarioEvents.getTrigger((int)this.createEvent_EditTriggerID).lConditions.get(this.createEvent_EditConditionID).setProvinces(CFG.core.getProvSelected().getProv());
                break;
            }
            case OUT_SELECTIDEOLOGY_COND_IDEOLOGY: 
            case OUT_SELECTRELIGION_COND_RELIGION: {
                this.createScenarioEvents.getTrigger((int)this.createEvent_EditTriggerID).lConditions.get(this.createEvent_EditConditionID).setValue(nCivID);
                break;
            }
            case OUT_SELECTCIV: 
            case OUT_SELECTCIV_ADDCORE: 
            case OUT_SELECTCIV_REMOVECORE: 
            case OUT_SELECTCIV_DECLAREWAR_A: 
            case OUT_SELECTCIV_WHITEPEACE_A: 
            case OUT_SELECTCIV_INCRELATION_A: 
            case OUT_SELECTCIV_DECRELATION_A: 
            case OUT_SELECTCIV_CREATEVASSAL_A: 
            case OUT_SELECTCIV_JOINALLIANCE_A: 
            case OUT_SELECTCIV_LEAVEALLIANCE: 
            case OUT_SELECTCIV_JOINUNION_A: 
            case OUT_SELECTCIV_NONAGGRESSION_A: 
            case OUT_SELECTCIV_MILITARY_A: 
            case OUT_SELECTCIV_DEFENSIVE_A: 
            case OUT_SELECTCIV_INDEPENDENCE_A: 
            case OUT_SELECTCIV_MOVECAPITAL: 
            case OUT_SELECTCIV_LIBERATEVASSAL: 
            case OUT_SELECTCIV_CHANGEIDEOLOGY: 
            case OUT_SELECTCIV_ADDARMY: 
            case OUT_SELECTCIV_UPDATEPOPULAION: 
            case OUT_SELECTCIV_UPDATEPOPULAION_PERC: 
            case OUT_SELECTCIV_UPDATEECONOMY_PERC: 
            case OUT_SELECTCIV_UPDATEECONOMY: 
            case OUT_SELECTCIV_UPDATEECONOMY_OFCIV: 
            case OUT_SELECTCIV_UPDATEPOPULAION_OFCIV: 
            case OUT_SELECTCIV_TECHLEVEL: 
            case OUT_SELECTCIV_DEVELOPMENT: 
            case OUT_SELECTCIV_HAPPINESS: 
            case OUT_SELECTCIV_HAPPINESS_OF_CIV: 
            case OUT_SELECTCIV_MONEY: 
            case OUT_SELECTCIV_DIPLOMACYPOINTS: 
            case OUT_SELECTCIV_MOVEMENTPOINTS: 
            case OUT_SELECTCIV_LEADER: 
            case OUT_SELECTCIV_FORMCIV: 
            case OUT_SELECTCIV_OCCUPY: 
            case OUT_SELECTCIV_CHANGERELIGION: 
            case OUT_SELECTCIV_COALITION: 
            case OUT_SELECTCIV_BUILDBUILDINGS: 
            case OUT_SELECTCIV_BUILDBUILDINGSDESTROY: 
            case OUT_SELECTCIV_REMOVE_ADD_ARMY_X: 
            case OUT_SELECTCIV_NUKES: 
            case OUT_SELECTCIV_NUKESDROP: 
            case OUT_SELECTCIV_PROVOKE_REBELS: 
            case OUT_SELECTCIV_IMPOSE_SANCTIONS: 
            case OUT_SELECTCIV_ADM_POLICY: 
            case OUT_SELECTCIV_FESTIVALALL: 
            case OUT_SELECTCIV_ASSIMILATEALL: 
            case OUT_SELECTCIV_RAND_FESTIVALS: 
            case OUT_SELECTCIV_RAND_FARMS: 
            case OUT_SELECTCIV_RAND_FORTS: 
            case OUT_SELECTCIV_RAND_TOWERS: 
            case OUT_SELECTCIV_RAND_WORKSHOPS: 
            case OUT_SELECTCIV_RAND_MARKETS: 
            case OUT_SELECTCIV_RAND_LIBRARY: 
            case OUT_SELECTCIV_RAND_ARMOURY: 
            case OUT_SELECTCIV_RAND_SUPPLY: 
            case OUT_SELECTCIV_MILITARYEXP: 
            case OUT_SELECTCIV_MILITARYATTACK: 
            case OUT_SELECTCIV_MILITARYDEFENSE: 
            case OUT_SELECTCIV_GOLDEN_PROS: 
            case OUT_SELECTCIV_GOLDEN_MILIT: 
            case OUT_SELECTCIV_GOLDEN_SCIE: 
            case OUT_SELECTCIV_RENAMECIV: 
            case OUT_SELECTCIV_PLAYERCIV: 
            case OUT_SELECTCIV_EXP: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setCivID(nCivID);
                break;
            }
            case OUT_SELECTCIV2: 
            case OUT_SELECTCIV_DECLAREWAR_B: 
            case OUT_SELECTCIV_WHITEPEACE_B: 
            case OUT_SELECTCIV_INCRELATION_B: 
            case OUT_SELECTCIV_DECRELATION_B: 
            case OUT_SELECTCIV_CREATEVASSAL_B: 
            case OUT_SELECTCIV_JOINALLIANCE_B: 
            case OUT_SELECTCIV_JOINUNION_B: 
            case OUT_SELECTCIV_NONAGGRESSION_B: 
            case OUT_SELECTCIV_MILITARY_B: 
            case OUT_SELECTCIV_DEFENSIVE_B: 
            case OUT_SELECTCIV_INDEPENDENCE_B: 
            case OUT_SELECTCIV2_OCCUPY: 
            case OUT_SELECTCIV_IMPOSE_SANCTIONS2: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setCivID2(nCivID);
                break;
            }
            case OUT_SELECTPROVINCES: 
            case OUT_SELECTPROVINCES_ADDCORE: 
            case OUT_SELECTPROVINCES_REMOVECORE: 
            case OUT_SELECTPROVINCES_CREATEVASSAL: 
            case OUT_SELECTPROVICNES_ADDARMY: 
            case OUT_SELECTPROVICNES_UPDATEPOPULAION: 
            case OUT_SELECTPROVICNES_UPDATEPOPULAION_PERC: 
            case OUT_SELECTPROVICNES_UPDATEECONOMY: 
            case OUT_SELECTPROVICNES_UPDATEECONOMY_PERC: 
            case OUT_SELECTPROVICNES_DEVELOPMENT: 
            case OUT_SELECTPROVICNES_HAPPINESS: 
            case OUT_SELECTPROVICNES_WASTELAND: 
            case OUT_SELECTPROVINCES_OCCUPY: 
            case OUT_SELECTPROVINCES_BUILDBUILDINGS: 
            case OUT_SELECTPROVINCES_BUILDBUILDINGSDESTROY: 
            case OUT_SELECTCIV_NUKESDROPPROVINCES: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setProvinces(CFG.core.getProvSelected().getProv());
                break;
            }
            case OUT_SELECTPROVICNES_MOVECAPITAL: 
            case OUT_SELECTPROVICNES_RENAMEPROV: {
                if (CFG.core.getProvSelected().getProv().size() > 0) {
                    CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setValue(CFG.core.getProvSelected().getProv().get(0));
                    break;
                }
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setValue(-1);
                break;
            }
            case OUT_SELECTIDEOLOGY_CHANGEIDEOLOGY: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setValue(nCivID);
                break;
            }
            case OUT_SELECTRELIGION_CHANGERELIGION: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setValue(nCivID);
            }
        }
    }

    public final void selectCivBack() {
        switch (this.eSelectCivAction) {
            case SELECT_RECIPENT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS);
                CFG.menus.setVisibleCreateScenario_Events_Edit(true);
                break;
            }
            case SELECT_COND_CIV_EXIST: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_CIVEXIST);
                break;
            }
            case SELECT_CIV_CONTROL_PROVINCES: 
            case SELECT_CONTROLS_PROVINCES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_CONTROLS_PROVINCES);
                break;
            }
            case SELECT_CIV_HAVE_ARMY: 
            case SELECT_PROVINCES_HAVEARMY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_HAVEARMY);
                break;
            }
            case SELECT_CIV_CORE: 
            case SELECT_PROVINCES_HAVECORE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_HAVECORE);
                break;
            }
            case SELECT_CIV_ISCAPITAL: 
            case SELECT_PROVINCES_ISCAPITAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ISCAPITAL);
                break;
            }
            case SELECT_CIV_NUMOFPROVINCES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFPROVINCES);
                break;
            }
            case SELECT_CIV_NUMOFPROVINCES_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFPROVINCES_LOW);
                break;
            }
            case SELECT_CIV_NUMOFUNITS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFUNITS);
                break;
            }
            case SELECT_CIV_NUMOFUNITS_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFUNITS_LOW);
                break;
            }
            case SELECT_CIV_NUMOFVASSALS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFVASSALS);
                break;
            }
            case SELECT_CIV_NUMOFVASSALS_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFVASSALS_LOW);
                break;
            }
            case SELECT_CIV_NUMOFWARS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFWARS);
                break;
            }
            case SELECT_CIV_NUMOFWARS_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFWARS_LOW);
                break;
            }
            case SELECT_CIV_NUMOFALLIES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFALLIES);
                break;
            }
            case SELECT_CIV_NUMOFALLIES_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFALLIES_LOW);
                break;
            }
            case SELECT_CIV_NUMOFNEIGHBORS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFNEIGHBORS);
                break;
            }
            case SELECT_CIV_NUMOFNEIGHBORS_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFNEIGHBORS_LOW);
                break;
            }
            case SELECT_CIV_ECONOMY_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ECONOMY_LOW);
                break;
            }
            case SELECT_CIV_ECONOMY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ECONOMY);
                break;
            }
            case SELECT_CIV_POPULATION: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_POPULATION);
                break;
            }
            case SELECT_CIV_POPULATION_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_POPULATION_LOW);
                break;
            }
            case SELECT_CIV_RELATION: 
            case SELECT_CIV_RELATION2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_RELATION);
                break;
            }
            case SELECT_CIV_RELATION_LOW: 
            case SELECT_CIV_RELATION_LOW2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_RELATION_LOW);
                break;
            }
            case SELECT_CIV_ISATWAR: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ISATWAR);
                break;
            }
            case SELECT_CIV_ALLIES: 
            case SELECT_CIV_ALLIES2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ALLIES);
                break;
            }
            case SELECT_CIV_ISVASSAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ISVASSAL);
                break;
            }
            case SELECT_CIV_ISVASSALOFCIV: 
            case SELECT_CIV_ISVASSALOFCIV2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ISVASSAL_OFCIV);
                break;
            }
            case SELECT_CIV_ISPARTOFHRE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ISPARTOFHRE);
                break;
            }
            case SELECT_CIV_IDEOLOGY: 
            case OUT_SELECTIDEOLOGY_COND_IDEOLOGY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_IDEOLOGY);
                break;
            }
            case SELECT_CIV_RELIGION: 
            case OUT_SELECTRELIGION_COND_RELIGION: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_RELIGION);
                break;
            }
            case SELECT_CIV_LEADER_COND: 
            case SELECT_CIV_LEADER_COND_SELECT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_LEADER);
                break;
            }
            case SELECT_CIV_TECHNOLOGY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_TECHNOLOGY);
                break;
            }
            case SELECT_CIV_TECHNOLOGY_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_TECHNOLOGY_LOW);
                break;
            }
            case SELECT_PROVINCES_DEVELOPMENT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DEVELOPMENT);
                break;
            }
            case SELECT_PROVINCES_DEVELOPMENT_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DEVELOPMENT_LOW);
                break;
            }
            case SELECT_CIV_HAPPINESS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_HAPPINESS);
                break;
            }
            case SELECT_CIV_HAPPINESS_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_HAPPINESS_LOW);
                break;
            }
            case SELECT_CIV_TREASURY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_TREASURY);
                break;
            }
            case SELECT_CIV_NUKES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUKES);
                break;
            }
            case SELECT_CIV_NUKES_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUKES_LOW);
                break;
            }
            case SELECT_CIV_COND_ADM_POLICY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ADM_POLICY);
                break;
            }
            case SELECT_CIV_TREASURY_LOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_TREASURY_LOW);
                break;
            }
            case SELECT_CIV_CONTROLLEDBYPLAYER: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_CONTROLLEDBYPLAYER);
                break;
            }
            case SELECT_PROVINCES_WASTELAND: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_WASTELAND);
                break;
            }
            case SELECT_PROVINCES_NEUTRAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NEUTRAL);
                break;
            }
            case SELECT_PROVINCES_FARM: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FARM);
                break;
            }
            case SELECT_PROVINCES_PORT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_PORT);
                break;
            }
            case SELECT_PROVINCES_FORT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FORT);
                break;
            }
            case SELECT_PROVINCES_WATCHTOWER: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_WATCHTOWER);
                break;
            }
            case SELECT_CIV_NONAGGRESSION: 
            case SELECT_CIV_NONAGGRESSION2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NONAGGRESSION);
                break;
            }
            case SELECT_CIV_DEFENSIVE: 
            case SELECT_CIV_DEFENSIVE2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DEFENSIVE);
                break;
            }
            case SELECT_CIV_MILITARYACCESS: 
            case SELECT_CIV_MILITARYACCESS2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_MILITARYACCESS);
                break;
            }
            case SELECT_CIV_INDEPENDENCE: 
            case SELECT_CIV_INDEPENDENCE2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INDEPENDENCE);
                break;
            }
            case SELECT_CIV_ATWAR: 
            case SELECT_CIV_ATWAR2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ATWAR);
                break;
            }
            case SELECT_CIV_CONTROL_OCCUPIED: 
            case SELECT_OCCUPIED_PROVINCES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_OCCUPIED_PROVINCES);
                break;
            }
            case OUT_SELECTPROVINCES_BUILDBUILDINGS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDING);
                break;
            }
            case OUT_SELECTPROVINCES_BUILDBUILDINGSDESTROY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDINGDESTROY);
                break;
            }
            case OUT_SELECTCIV: 
            case OUT_SELECTCIV2: 
            case OUT_SELECTPROVINCES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGE_OWNER);
                break;
            }
            case OUT_SELECTCIV_ADDCORE: 
            case OUT_SELECTPROVINCES_ADDCORE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ADDCORE);
                break;
            }
            case OUT_SELECTCIV_REMOVECORE: 
            case OUT_SELECTPROVINCES_REMOVECORE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ADDCORE);
                break;
            }
            case SELECT_CIV_INVESTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTS);
                break;
            }
            case SELECT_CIV_INVESTSCOSTLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTSCOSTLOW);
                break;
            }
            case SELECT_CIV_INVESTSDEVCOST: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTSDEVCOST);
                break;
            }
            case SELECT_CIV_INVESTSDEVCOSTLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTSDEVCOSTLOW);
                break;
            }
            case SELECT_CIV_ECO_GAINEDLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ECO_GAINEDLOW);
                break;
            }
            case SELECT_CIV_ECO_GAINED: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ECO_GAINED);
                break;
            }
            case SELECT_CIV_INVESTSCOST: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTSCOST);
                break;
            }
            case SELECT_CIV_ASSICOSTLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ASSICOSTLOW);
                break;
            }
            case SELECT_CIV_MILITARYEXPRERTISELOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_MILITARYEXPERTISELOW);
                break;
            }
            case SELECT_CIV_WAR_CASULOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DEATHS_ALL_WARSLOW);
                break;
            }
            case SELECT_CIV_CONQU_PROVSLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_COQNUERED_PROVS_LOW);
                break;
            }
            case SELECT_CIV_BUILDINGSCONSLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BUILDINGSCONSTRLOW);
                break;
            }
            case SELECT_CIV_RECRUITEDARMYLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_RECRUITEDARMYLOW);
                break;
            }
            case SELECT_CIV_STABILITYLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_STABILITYLOW);
                break;
            }
            case SELECT_CIV_STABILITY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_STABILITY);
                break;
            }
            case SELECT_CIV_AVEDEVLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_AVE_DEVLOW);
                break;
            }
            case SELECT_CIV_AVEDEV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_AVE_DEV);
                break;
            }
            case SELECT_CIV_BPORTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BPORTS);
                break;
            }
            case SELECT_CIV_BTOWERS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BTOWERS);
                break;
            }
            case SELECT_CIV_BFARMS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BFARMS);
                break;
            }
            case SELECT_CIV_BWORKSHOPS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BWORKSHOPS);
                break;
            }
            case SELECT_CIV_BLIBRARIES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BLIBRARIES);
                break;
            }
            case SELECT_CIV_BARMORIES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BARMORIES);
                break;
            }
            case SELECT_CIV_BSUPPLIES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BSUPPLIES);
                break;
            }
            case SELECT_CIV_BMARKETS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BMARKETS);
                break;
            }
            case SELECT_CIV_BFORTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BFORTS);
                break;
            }
            case SELECT_CIV_RECRUITEDARMY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_RECRUITEDARMY);
                break;
            }
            case SELECT_CIV_BUILDINGSCONS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_BUILDINGSCONSTR);
                break;
            }
            case SELECT_CIV_CONQU_PROVS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_COQNUERED_PROVS);
                break;
            }
            case SELECT_CIV_WAR_CASU: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DEATHS_ALL_WARS);
                break;
            }
            case SELECT_CIV_MILITARYEXPRERTISE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_MILITARYEXPERTISE);
                break;
            }
            case SELECT_CIV_ASSICOST: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ASSICOST);
                break;
            }
            case SELECT_CIV_FESTIVALSCOST: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FESTIVALSCOST);
                break;
            }
            case SELECT_CIV_FESTIVALSCOSTLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FESTIVALSCOSTLOW);
                break;
            }
            case SELECT_CIV_FESTIVALS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FESTIVALS);
                break;
            }
            case SELECT_CIV_FESTIVALSLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FESTIVALSLOW);
                break;
            }
            case SELECT_CIV_ASSI: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ASSI);
                break;
            }
            case SELECT_CIV_ASSILOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ASSILOW);
                break;
            }
            case OUT_SELECTCIV_DECLAREWAR_A: 
            case OUT_SELECTCIV_DECLAREWAR_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DECLAREWAR);
                break;
            }
            case OUT_SELECTCIV_WHITEPEACE_A: 
            case OUT_SELECTCIV_WHITEPEACE_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_WHITEPEACE);
                break;
            }
            case OUT_SELECTCIV_INCRELATION_A: 
            case OUT_SELECTCIV_INCRELATION_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_INCRELATION);
                break;
            }
            case OUT_SELECTCIV_DECRELATION_A: 
            case OUT_SELECTCIV_DECRELATION_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DECRELATION);
                break;
            }
            case OUT_SELECTCIV_CREATEVASSAL_A: 
            case OUT_SELECTCIV_CREATEVASSAL_B: 
            case OUT_SELECTPROVINCES_CREATEVASSAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CREATEVASSAL);
                break;
            }
            case OUT_SELECTCIV_JOINALLIANCE_A: 
            case OUT_SELECTCIV_JOINALLIANCE_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_JOINALLIANCE);
                break;
            }
            case OUT_SELECTCIV_LEAVEALLIANCE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_LEAVEALLIANCE);
                break;
            }
            case OUT_SELECTCIV_JOINUNION_A: 
            case OUT_SELECTCIV_JOINUNION_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_JOINUNION);
                break;
            }
            case OUT_SELECTCIV_NONAGGRESSION_A: 
            case OUT_SELECTCIV_NONAGGRESSION_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_NONAGGRESSION);
                break;
            }
            case OUT_SELECTCIV_DEFENSIVE_A: 
            case OUT_SELECTCIV_DEFENSIVE_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DEFENSIVE);
                break;
            }
            case OUT_SELECTCIV_INDEPENDENCE_A: 
            case OUT_SELECTCIV_INDEPENDENCE_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_INDEPENENCE);
                break;
            }
            case OUT_SELECTCIV_MILITARY_A: 
            case OUT_SELECTCIV_MILITARY_B: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MILITARY);
                break;
            }
            case OUT_SELECTCIV_MOVECAPITAL: 
            case OUT_SELECTPROVICNES_MOVECAPITAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MOVECAPITAL);
                break;
            }
            case OUT_SELECTCIV_RENAMECIV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RENAME_CIV);
                break;
            }
            case OUT_SELECTCIV_LIBERATEVASSAL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_LIBERATEVASSAL);
                break;
            }
            case OUT_SELECTPROVICNES_RENAMEPROV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RENAME_PROVINCE);
                break;
            }
            case OUT_SELECTCIV_CHANGEIDEOLOGY: 
            case OUT_SELECTIDEOLOGY_CHANGEIDEOLOGY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGEIDEOLOGY);
                break;
            }
            case OUT_SELECTCIV_CHANGERELIGION: 
            case OUT_SELECTRELIGION_CHANGERELIGION: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGERELIGION);
                break;
            }
            case OUT_SELECTCIV_ADDARMY: 
            case OUT_SELECTPROVICNES_ADDARMY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ADDARMY);
                break;
            }
            case OUT_SELECTCIV_UPDATEPOPULAION: 
            case OUT_SELECTPROVICNES_UPDATEPOPULAION: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEPOPULATION);
                break;
            }
            case OUT_SELECTCIV_UPDATEPOPULAION_PERC: 
            case OUT_SELECTPROVICNES_UPDATEPOPULAION_PERC: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEPOPULATION_PERC);
                break;
            }
            case SELECT_CIV_INVESTSLOW: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_INVESTSLOW);
                break;
            }
            case OUT_SELECTCIV_UPDATEECONOMY: 
            case OUT_SELECTPROVICNES_UPDATEECONOMY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEECONOMY);
                break;
            }
            case OUT_SELECTCIV_UPDATEECONOMY_PERC: 
            case OUT_SELECTPROVICNES_UPDATEECONOMY_PERC: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEECONOMYPERC);
                break;
            }
            case OUT_SELECTCIV_UPDATEECONOMY_OFCIV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEECONOMY_OFCIV);
                break;
            }
            case OUT_SELECTCIV_UPDATEPOPULAION_OFCIV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEPOPULATION_OFCIV);
                break;
            }
            case OUT_SELECTCIV_TECHLEVEL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_TECHLEVEL);
                break;
            }
            case OUT_SELECTCIV_LEADER: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_LEADER);
                break;
            }
            case OUT_SELECTCIV_DEVELOPMENT: 
            case OUT_SELECTPROVICNES_DEVELOPMENT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DEVELOPEMNT);
                break;
            }
            case OUT_SELECTCIV_HAPPINESS: 
            case OUT_SELECTPROVICNES_HAPPINESS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_HAPPINESS);
                break;
            }
            case OUT_SELECTCIV_HAPPINESS_OF_CIV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_HAPPINESS_OF_CIV);
                break;
            }
            case OUT_SELECTCIV_DIPLOMACYPOINTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DIPLOMACYPOINTS);
                break;
            }
            case OUT_SELECTCIV_RAND_FORTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_FORTS);
                break;
            }
            case OUT_SELECTCIV_RAND_WORKSHOPS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_WORKSHOP);
                break;
            }
            case OUT_SELECTCIV_RAND_MARKETS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_MARKETS);
                break;
            }
            case OUT_SELECTCIV_RAND_LIBRARY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_LIBRARY);
                break;
            }
            case OUT_SELECTCIV_RAND_ARMOURY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_ARMOURY);
                break;
            }
            case OUT_SELECTCIV_RAND_FESTIVALS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_FESTIVALS);
                break;
            }
            case OUT_SELECTCIV_RAND_SUPPLY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_SUPPLY);
                break;
            }
            case OUT_SELECTCIV_RAND_FARMS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_FARMS);
                break;
            }
            case OUT_SELECTCIV_RAND_TOWERS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_TOWERS);
                break;
            }
            case OUT_SELECTCIV_EXP: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_EXP);
                break;
            }
            case OUT_SELECTCIV_MONEY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MONEY);
                break;
            }
            case OUT_SELECTCIV_PLAYERCIV: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_PLAYERCIV);
                break;
            }
            case OUT_SELECTCIV_ADM_POLICY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ADM_POLICY);
                break;
            }
            case OUT_SELECTCIV_GOLDEN_MILIT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_GOLDEN_MILIT);
                break;
            }
            case OUT_SELECTCIV_GOLDEN_SCIE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_GOLDEN_SCIE);
                break;
            }
            case OUT_SELECTCIV_GOLDEN_PROS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_GOLDEN_PROSP);
                break;
            }
            case OUT_SELECTCIV_FESTIVALALL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_FESTIVAL_ALL);
                break;
            }
            case OUT_SELECTCIV_ASSIMILATEALL: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ASSIMILATE_ALL);
                break;
            }
            case OUT_SELECTCIV_PROVOKE_REBELS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_PROVOKE_REBELS);
                break;
            }
            case OUT_SELECTCIV_MILITARYDEFENSE: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MILITARYDEFENSE);
                break;
            }
            case OUT_SELECTCIV_MILITARYATTACK: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MILITARYATTACK);
                break;
            }
            case OUT_SELECTCIV_MILITARYEXP: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MILITARYEXP);
                break;
            }
            case OUT_SELECTCIV_NUKES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_NUKES);
                break;
            }
            case OUT_SELECTCIV_COALITION: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_COALITION);
                break;
            }
            case OUT_SELECTCIV_MOVEMENTPOINTS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MOVEMENTPOINTS);
                break;
            }
            case OUT_SELECTCIV_OCCUPY: 
            case OUT_SELECTCIV2_OCCUPY: 
            case OUT_SELECTPROVINCES_OCCUPY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_OCCUPY);
                break;
            }
            case OUT_SELECTCIV_IMPOSE_SANCTIONS: 
            case OUT_SELECTCIV_IMPOSE_SANCTIONS2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_IMPOSE_SANCTIONS);
                break;
            }
            case OUT_SELECTCIV_NUKESDROP: 
            case OUT_SELECTCIV_NUKESDROPPROVINCES: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DROPNUKES);
                break;
            }
            case OUT_SELECTCIV_BUILDBUILDINGS: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDING);
                break;
            }
            case OUT_SELECTCIV_BUILDBUILDINGSDESTROY: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDINGDESTROY);
                break;
            }
            case OUT_SELECTPROVICNES_WASTELAND: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_WASTELAND);
                break;
            }
            case OUT_SELECTCIV_REMOVE_ADD_ARMY_X: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_REMOVE_ARMY_X);
                break;
            }
            case OUT_SELECTEVENT: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_TRIGGERANOTHEREVENT);
                break;
            }
            case OUT_SELECTCIV_FORMCIV: 
            case OUT_SELECTCIV_FORMCIV2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_FORM_CIV);
                break;
            }
            case COND_SELECTCIV_DECISIONTAKEN: 
            case COND_SELECTDECISION_DECISIONTAKEN: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DECISIONTAKEN);
            }
        }
    }

    public final Event_GameData getEvent(int i) {
        return this.events.lEvents.get(i);
    }

    public final int getEventsSize() {
        return this.events.iEventsSize;
    }
}

