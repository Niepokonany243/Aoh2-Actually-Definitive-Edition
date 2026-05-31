/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

public class HolyRomanEmpire_Manager {
    public static final String HOLY_ROMAN_EMPRIE_TAG = "holy";
    public static final int MAX_NUM_OF_ELECTORS = 7;
    public HolyRomanEmpire_GameData holyRomanEmpire;
    public static final Color oColorHRE = new Color(1.0f, 0.8f, 0.11764706f, 1.0f);
    public static final Color oColorHRE_BG = new Color(1.0f, 1.0f, 0.0f, 1.0f);
    public static final Color oColorHRE_Emperor = new Color(1.0f, 1.0f, 0.0f, 1.0f);
    public static final Color oColorHRE_Electors = new Color(0.91764706f, 0.74509805f, 0.1764706f, 1.0f);
    public static final Color oColorHRE_NotControledByEmpire = new Color(0.92156863f, 0.039215688f, 0.039215688f, 1.0f);
    private String sHRE_Name;

    public HolyRomanEmpire_Manager() {
        this.updateHREName();
    }

    public final void initHolyRomanEmpire() {
        this.holyRomanEmpire = null;
        this.holyRomanEmpire = new HolyRomanEmpire_GameData();
    }

    public final void loadHolyRomanEmpire_ScenarioData() {
        FileHandle file;
        this.holyRomanEmpire = null;
        if (Game_Scenarios.loadedCustomJSON != null) {
            this.loadHolyRomanEmpire_CustomJSON();
            return;
        }
        if (CFG.core.getGameScenars().getScenarioIsInternal(CFG.core.getScenarioID())) {
            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "_HRE");
        } else {
            try {
                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "_HRE");
            }
            catch (Exception ex) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "/" + CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID()) + "_HRE");
            }
        }
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    this.holyRomanEmpire = json.fromJson(HolyRomanEmpire_GameData.class, jsonFile.readString("UTF-8"));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (this.holyRomanEmpire == null && file.exists()) {
                this.holyRomanEmpire = (HolyRomanEmpire_GameData)CFG.deserialize(file.readBytes());
                try {
                    jsonFile.writeString(json.prettyPrint(this.holyRomanEmpire), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            
            if (this.holyRomanEmpire == null) {
                this.initHolyRomanEmpire();
                return;
            }

            int i;
            for (i = 0; i < CFG.hreMgr.getHRE().getProvincesSize(); ++i) {
                try {
                    if (CFG.core.getProv(CFG.hreMgr.getHRE().getProvinces(i)).getSeaProv()) continue;
                    CFG.core.getProv(CFG.hreMgr.getHRE().getProvinces(i)).setIsPartOfHolyRomanEmpire(true);
                    continue;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
            }
            for (i = 0; i < CFG.hreMgr.getHRE().getPrincesSize(); ++i) {
                try {
                    CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).setIsPartOfHolyRomanEmpire(true);
                    continue;
                }
                catch (IndexOutOfBoundsException ex) {
                    CFG.hreMgr.getHRE().removePrinceID(i--);
                }
            }
            return;
        }
        catch (Exception exception) {
            this.initHolyRomanEmpire();
            return;
        }
    }

    public final HolyRomanEmpire_GameData getHRE() {
        return this.holyRomanEmpire;
    }

    private int getCustomCivID(String tag) {
        if (tag == null || tag.length() == 0) return -1;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (tag.equals(CFG.core.getCiv(i).getCivTag())) return i;
        }
        return -1;
    }

    private void loadHolyRomanEmpire_CustomJSON() {
        this.initHolyRomanEmpire();
        try {
            Scenario_CustomJSON.HREData hreData = Game_Scenarios.loadedCustomJSON.hre;
            if (hreData == null) return;
            int provinces = 0;
            int princes = 0;
            if (hreData.provinceIDs != null && hreData.provinceIDs.size() > 0) {
                for (int i = 0; i < hreData.provinceIDs.size(); ++i) {
                    int provinceID = hreData.provinceIDs.get(i);
                    if (provinceID >= 0 && provinceID < CFG.core.getProvinSize() && !CFG.core.getProv(provinceID).getSeaProv()) {
                        this.holyRomanEmpire.addProvince(provinceID);
                        ++provinces;
                    }
                }
            }
            if (hreData.memberTags != null) {
                for (int i = 0; i < hreData.memberTags.size(); ++i) {
                    int civID = this.getCustomCivID(hreData.memberTags.get(i));
                    if (civID > 0) {
                        this.holyRomanEmpire.addPrince(civID);
                        ++princes;
                        if (hreData.provinceIDs == null || hreData.provinceIDs.size() == 0) {
                            for (int j = 0; j < CFG.core.getCiv(civID).getNumOfProvs(); ++j) {
                                this.holyRomanEmpire.addProvince(CFG.core.getCiv(civID).getProvID(j));
                            }
                        }
                    }
                }
            }
            if (hreData.electorTags != null) {
                for (int i = 0; i < hreData.electorTags.size(); ++i) {
                    int civID = this.getCustomCivID(hreData.electorTags.get(i));
                    if (civID > 0) this.holyRomanEmpire.addElector(civID);
                }
            }
            int emperorID = this.getCustomCivID(hreData.emperorTag);
            if (emperorID > 0) this.holyRomanEmpire.setEmperor(emperorID);
            CFG.LOG("[customJSON] Applied HRE provinces=" + provinces + " princes=" + princes);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final boolean addProvince(int nProvinceID) {
        if (this.holyRomanEmpire.addProvince(nProvinceID) && CFG.core.getProv(nProvinceID).getCivId() > 0 && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCapitalProvID() == nProvinceID) {
            int i;
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(nProvinceID).getCivId()) {
                if (this.holyRomanEmpire.getIsPrince(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv())) {
                    for (int i2 = 0; i2 < this.holyRomanEmpire.getPrincesSize(); ++i2) {
                        if (this.holyRomanEmpire.getPrince(i2) != CFG.core.getProv(nProvinceID).getCivId()) continue;
                        return false;
                    }
                    this.holyRomanEmpire.addPrince(CFG.core.getProv(nProvinceID).getCivId());
                    return true;
                }
                return false;
            }
            for (i = 0; i < this.holyRomanEmpire.getPrincesSize(); ++i) {
                if (this.holyRomanEmpire.getPrince(i) != CFG.core.getProv(nProvinceID).getCivId()) continue;
                return false;
            }
            for (i = 0; i < this.holyRomanEmpire.getProvincesSize(); ++i) {
                if (CFG.core.getProv(this.holyRomanEmpire.getProvinces(i)).getCivId() == CFG.core.getProv(nProvinceID).getCivId() || CFG.core.getCiv(CFG.core.getProv(this.holyRomanEmpire.getProvinces(i)).getCivId()).getPuppetOfCiv() != CFG.core.getProv(nProvinceID).getCivId() || CFG.core.getProv(this.holyRomanEmpire.getProvinces(i)).getCivId() <= 0 || !this.holyRomanEmpire.getIsImperialProvince(CFG.core.getCiv(CFG.core.getProv(this.holyRomanEmpire.getProvinces(i)).getCivId()).getCapitalProvID())) continue;
                this.holyRomanEmpire.addPrince(CFG.core.getProv(this.holyRomanEmpire.getProvinces(i)).getCivId());
            }
            this.holyRomanEmpire.addPrince(CFG.core.getProv(nProvinceID).getCivId());
            return true;
        }
        return false;
    }

    public final boolean removeProvince(int nProvinceID) {
        if (this.holyRomanEmpire.removeProvince(nProvinceID) && CFG.core.getProv(nProvinceID).getCivId() > 0 && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCapitalProvID() == nProvinceID) {
            for (int i = 0; i < this.holyRomanEmpire.getPrincesSize(); ++i) {
                if (this.holyRomanEmpire.getPrince(i) != CFG.core.getProv(nProvinceID).getCivId()) continue;
                this.holyRomanEmpire.removePrince(CFG.core.getProv(nProvinceID).getCivId());
                return true;
            }
        }
        return false;
    }

    public final String getHRE_Name() {
        return this.sHRE_Name;
    }

    public final void updateHREName() {
        this.sHRE_Name = CFG.lang.getCiv(HOLY_ROMAN_EMPRIE_TAG);
    }
}

