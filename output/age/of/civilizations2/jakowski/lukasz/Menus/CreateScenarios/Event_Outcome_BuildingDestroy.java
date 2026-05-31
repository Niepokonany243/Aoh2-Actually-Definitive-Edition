
package age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_BuildingDestroy
extends Event_Outcome {
    private static final long serialVersionUID = 6256813467866475732L;
    public int iCivID = -1;
    public int buildingID = -1;
    public List<Integer> lProvinces = new ArrayList<Integer>();

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
        return this.buildingID;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.buildingID = nCivID;
    }

    @Override
    public List<Integer> getProvinces() {
        return this.lProvinces;
    }

    @Override
    public void setProvinces(List<Integer> nProvinces) {
        this.lProvinces.clear();
        for (int i = 0; i < nProvinces.size(); ++i) {
            this.lProvinces.add(nProvinces.get(i));
        }
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
        return out;
    }

    @Override
    public void outcomeAction() {
        try {
            for (int i = 0; i < this.lProvinces.size(); ++i) {
                try {
                    if (!this.canMakeAction(i)) continue;
                    switch (this.buildingID) {
                        case 0: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfFort(0);
                            break;
                        }
                        case 1: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfWatchTower(0);
                            break;
                        }
                        case 2: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfFarm(0);
                            break;
                        }
                        case 3: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfWorkshop(0);
                            break;
                        }
                        case 4: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfMarket(0);
                            break;
                        }
                        case 5: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfLibrary(0);
                            break;
                        }
                        case 6: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfArmoury(0);
                            break;
                        }
                        case 7: {
                            CFG.core.getProv(this.lProvinces.get(i)).setLvlOfSupply(0);
                        }
                    }
                    continue;
                }
                catch (Exception exception) {
                    
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    public boolean canMakeAction(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv() && CFG.core.getProv(this.getProvinces().get(i)).getWastelandLvl() < 0 && (CFG.core.getProv(this.getProvinces().get(i)).getCivId() == this.getCivID() || this.getCivID() <= 0);
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
        if (this.getProvinces().size() < 5) {
            for (int i = 0; i < this.getProvinces().size(); ++i) {
                if (!this.canMakeAction(i)) continue;
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("DestroyBuilding") + ": "));
                switch (this.buildingID) {
                    case 0: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 1: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 2: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 3: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 4: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 5: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 6: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(1)), CFG.COLOR_HOVER_TITLE));
                        break;
                    }
                    case 7: {
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(1)), CFG.COLOR_HOVER_TITLE));
                    }
                }
                tData.add(new ME_Hover_2Type_Text(": " + CFG.core.getProv(this.getProvinces().get(i)).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                tData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.getProvinces().get(i)).getCivId(), CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
        } else {
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("DestroyBuilding") + ": "));
            switch (this.buildingID) {
                case 0: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 1: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 2: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 3: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 4: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 5: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 6: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(1)), CFG.COLOR_HOVER_TITLE));
                    break;
                }
                case 7: {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(1)), CFG.COLOR_HOVER_TITLE));
                }
            }
            tData.add(new ME_Hover_2Type_Text(" -> " + CFG.lang.get("Provinces") + ": "));
            tData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + this.getProvinces().size()), CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
        }
        return tElements;
    }

    @Override
    public String getConditionText() {
        try {
            String out = CFG.lang.get("DestroyBuilding") + ": ";
            switch (this.buildingID) {
                case 0: {
                    out = out + CFG.lang.get(BuildingsManager.getFort_Name(1));
                    break;
                }
                case 1: {
                    out = out + CFG.lang.get(BuildingsManager.getTower_Name(1));
                    break;
                }
                case 2: {
                    out = out + CFG.lang.get(BuildingsManager.getFarm_Name(1));
                    break;
                }
                case 3: {
                    out = out + CFG.lang.get(BuildingsManager.getWorkshop_Name(1));
                    break;
                }
                case 4: {
                    out = out + CFG.lang.get(BuildingsManager.getMarket_Name(1));
                    break;
                }
                case 5: {
                    out = out + CFG.lang.get(BuildingsManager.getLibrary_Name(1));
                    break;
                }
                case 6: {
                    out = out + CFG.lang.get(BuildingsManager.getArmoury_Name(1));
                    break;
                }
                case 7: {
                    out = out + CFG.lang.get(BuildingsManager.getSupply_Name(1));
                }
            }
            return out;
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("DestroyBuilding");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDINGDESTROY);
    }
}

