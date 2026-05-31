
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.PlayerGD;
import age.of.civilizations2.jakowski.lukasz.StatsCivGD;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate_TypesOfAction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public PlayerGD playerGD = new PlayerGD();
    private Image flagOfCivilization = null;
    private boolean noOrders;
    private List<Boolean> fogOfWar;
    public StatsCivGD statsCiv = new StatsCivGD();
    public int iBefore_PosX;
    public int iBefore_PosY = -999999;
    public float fBefore_Scale;
    public int iBefore_ActiveProvince;
    public int iACTIVE_VIEW_MODE = -1;
    public int visible_CivInfo = -1;
    public boolean visible_Outliner = false;
    public int visible_CensusOfProvince = -1;
    public boolean visible_Wars = false;
    public int visible_WarStats = -1;
    public boolean visible_Alliances = false;
    public int visible_Alliance = -1;
    public boolean visible_Rank = false;
    public boolean visible_WorldPop = false;
    public boolean visible_VictoryConditions = false;
    public boolean visible_ConqueredProvinces = false;
    public boolean visible_BuildingsConstructed = false;
    public boolean visible_Stats = false;
    public boolean visible_RecruitedArmy = false;
    public boolean visible_Army = false;
    public boolean visible_Tribute = false;
    public boolean visible_Technology = false;
    public boolean visible_MapModes = false;
    public boolean visible_BuildingsMore = false;
    public boolean visible_History = false;
    public boolean visible_HRE = false;
    public boolean visible_Budget = false;

    public Player(int iCivID) {
        this.setCivId(iCivID);
        this.noOrders = true;
        this.initFogOfWar();
        this.initMetProvince(true);
        this.initMetCivilization(true);
    }

    public Player(PlayerGD savedPlayer) {
        this.setCivId(savedPlayer.iCivID);
        this.playerGD = savedPlayer;
        this.noOrders = true;
        this.initFogOfWar();
    }

    public final float buildPlayerScore() {
        float out = 1.0f;
        for (int i = 0; i < CFG.core.getCiv(this.getCivId()).getNumOfProvs(); ++i) {
            out += 2.45f * (float)CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(i)).getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation();
            out += 2.25f * (float)CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(i)).getEco() / (float)CFG.core.getGameScenars().getScenario_StartingEconomy();
        }
        return out += 0.075f * (float)CFG.core.getCiv((int)this.getCivId()).civGD.numOfConqueredProvinces;
    }

    public final void initMetProvince(boolean nValue) {
        this.playerGD.metProvin = new ArrayList<Boolean>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            this.playerGD.metProvin.add(nValue);
        }
    }

    public final void initMetCivilization(boolean nValue) {
        this.playerGD.metCiv = new ArrayList<Boolean>();
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            this.playerGD.metCiv.add(nValue);
        }
    }

    public final void initFogOfWar() {
        this.fogOfWar = new ArrayList<Boolean>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            this.fogOfWar.add(false);
        }
    }

    public final void buildMetProvsAndCivs() {
        int j;
        int i;
        this.initMetProvince(false);
        this.initMetCivilization(false);
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (!this.getFog(i)) continue;
            this.playerGD.metProvin.set(i, true);
            this.playerGD.metCiv.set(CFG.core.getProv(i).getCivId(), true);
            if ((CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getAlliance())) && !CFG.gameAction.hasArmyInProvince(i, this.getCivId()) && !CFG.gameAction.hasArmyInProvince_AllianceID(i, CFG.core.getCiv(this.getCivId()).getAlliance())) continue;
            for (j = 0; j < CFG.core.getProv(i).getNeighProvincesSize(); ++j) {
                this.playerGD.metProvin.set(CFG.core.getProv(i).getNeighProvinces(j), true);
                this.playerGD.metCiv.set(CFG.core.getProv(CFG.core.getProv(i).getNeighProvinces(j)).getCivId(), true);
            }
        }
        if (CFG.core.getCiv(this.getCivId()).getIsPartOfHolyRomanEmpire()) {
            for (i = 0; i < CFG.hreMgr.getHRE().getPrincesSize(); ++i) {
                for (j = 0; j < CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).getNumOfProvs(); ++j) {
                    if (!CFG.core.getProv(CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).getProvID(j)).getIsPartOfHolyRomanEmpire()) continue;
                    this.playerGD.metProvin.set(CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).getProvID(j), true);
                }
                this.playerGD.metCiv.set(CFG.hreMgr.getHRE().getPrince(i), true);
            }
        }
        this.buildMetProvinces_BasedOnDistance();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (j = 0; j < CFG.core.getCiv(i).getCivRegionsSize(); ++j) {
                int k;
                int regionMet = 0;
                int regionNotMet = 0;
                for (k = 0; k < CFG.core.getCiv(i).getCivRegion(j).getProvincesSize(); ++k) {
                    if (this.getMetProv(CFG.core.getCiv(i).getCivRegion(j).getProvince(k))) {
                        ++regionMet;
                        continue;
                    }
                    ++regionNotMet;
                }
                if (regionMet <= 0 || regionNotMet >= 4) continue;
                for (k = 0; k < CFG.core.getCiv(i).getCivRegion(j).getProvincesSize(); ++k) {
                    this.playerGD.metProvin.set(CFG.core.getCiv(i).getCivRegion(j).getProvince(k), true);
                }
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() != 0) continue;
            this.playerGD.metCiv.set(i, true);
        }
        for (i = 0; i < CFG.core.getCiv(this.getCivId()).getNumOfProvs(); ++i) {
            for (j = 0; j < CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(i)).getPop().getNatsSize(); ++j) {
                this.playerGD.metCiv.set(CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(i)).getPop().getCivID(j), true);
            }
        }
    }

    public final void buildMetProvinces_BasedOnDistance() {
        float tempDis = CFG.gameAges.getAge_FogOfWarDiscovery_MetProvinces(GameCalendar.CURRENT_AGEID);
        block0: for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (this.getMetProv(i)) continue;
            if (!GameCalendar.getColonizationOfWastelandIsEnabled() && CFG.core.getProv(i).getWastelandLvl() >= 0) {
                this.playerGD.metProvin.set(i, true);
                this.playerGD.metCiv.set(CFG.core.getProv(i).getCivId(), true);
            }
            for (int j = 0; j < CFG.core.getCiv(this.getCivId()).getNumOfProvs(); ++j) {
                float f = Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(this.getCivId()).getProvID(j), i);
                float f2 = CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(j)).getContinent() == CFG.core.getProv(i).getContinent() ? 0.715f : 1.0f;
                if (!(f * f2 < (tempDis + tempDis * 0.325f * (1.0f - Math.min((float)Math.abs(CFG.core.getProv(CFG.core.getCiv(this.getCivId()).getProvID(j)).getCeY() - CFG.core.getProv(i).getCeY()) / ((float)CFG.map.getMpB().getHeightM() / 10.0f), 1.0f))) * CFG.core.getCiv(this.getCivId()).getTechLevel())) continue;
                this.playerGD.metProvin.set(i, true);
                this.playerGD.metCiv.set(CFG.core.getProv(i).getCivId(), true);
                continue block0;
            }
        }
    }

    public final void loadPlayersFlag(Image tFlag) {
        this.disposePlayersFlag();
        this.flagOfCivilization = tFlag;
    }

    public final void loadPlayersFlag() {
        block14: {
            this.disposePlayersFlag();
            if (CFG.core.getCiv(this.playerGD.iCivID).getCivTag().indexOf(59) > 0) {
                CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                int tGenerateID = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                String[] tempD = CFG.core.getCiv(this.playerGD.iCivID).getCivTag().split(";");
                for (int i = 0; i < tempD.length; ++i) {
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).lTags.add(tempD[i]);
                }
                CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).typeOfAction = UnionFlagsToGenerate_TypesOfAction.PLAYER_ID;
                CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).iID = this.getCivId();
                return;
            }
            try {
                try {
                    this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.core.getCiv(this.playerGD.iCivID).getCivTag() + ".png")), Texture.TextureFilter.Linear);
                }
                catch (GdxRuntimeException e) {
                    if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.playerGD.iCivID).getIdeology()).REVOLUTIONARY) {
                        this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flagsH/rb" + (CFG.core.getCiv(this.playerGD.iCivID).getCivId() + CFG.core.getCiv(this.playerGD.iCivID).getCivTag().charAt(0)) % 6 + ".png")), Texture.TextureFilter.Nearest);
                        return;
                    }
                    try {
                        this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + ".png")), Texture.TextureFilter.Linear);
                    }
                    catch (GdxRuntimeException exr) {
                        if (CFG.isAndroid()) {
                            try {
                                this.flagOfCivilization = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                            }
                            catch (GdxRuntimeException eq) {
                                this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                            }
                            break block14;
                        }
                        this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.playerGD.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.disposePlayersFlag();
            }
            catch (OutOfMemoryError e) {
                this.disposePlayersFlag();
            }
            catch (RuntimeException e) {
                this.disposePlayersFlag();
            }
        }
    }

    public final void disposePlayersFlag() {
        block3: {
            try {
                if (this.flagOfCivilization != null) {
                    this.flagOfCivilization.getTexture().dispose();
                    this.flagOfCivilization = null;
                }
            }
            catch (RuntimeException ex) {
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final int getCivId() {
        return this.playerGD.iCivID;
    }

    public final void setCivId(int nCivID) {
        try {
            if (this.playerGD.iCivID >= 0 && this.playerGD.iCivID < CFG.core.getCivsSize()) {
                CFG.core.getCiv(this.playerGD.iCivID).setIsPlayer(false);
            }
            this.playerGD.iCivID = nCivID;
            if (this.playerGD.iCivID >= 0 && this.playerGD.iCivID < CFG.core.getCivsSize()) {
                CFG.core.getCiv(this.playerGD.iCivID).setIsPlayer(true);
                this.statsCiv = CFG.serviceRibbonMgr.loadStatistics_Civ(CFG.core.getCiv(this.playerGD.iCivID).getCivTag());
            }
        }
        catch (Exception ex) {
            this.playerGD.iCivID = nCivID;
        }
    }

    public final void tryLoadStats() {
        this.statsCiv = CFG.serviceRibbonMgr.loadStatistics_Civ(CFG.core.getCiv(this.playerGD.iCivID).getCivTag());
    }

    public final boolean getNoOrders() {
        return this.noOrders;
    }

    public final void setNoOrders(boolean noOrders) {
        this.noOrders = noOrders;
    }

    public final Image getFlag() {
        return this.flagOfCivilization == null ? CFG.core.getCiv(this.playerGD.iCivID).getFlagC() : this.flagOfCivilization;
    }

    public final boolean getMetProv(int i) {
        try {
            return this.playerGD.metProvin.get(i);
        }
        catch (Exception ex) {
            return true;
        }
    }

    public final void setMetProv(int i, boolean met) {
        try {
            if (this.playerGD.metProvin.get(i) != met) {
                this.playerGD.metProvin.set(i, met);
                CFG.core.updateSortedPIV = true;
                ProvinceMesh.needsUpdate = true;
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final boolean getMetCiv(int i) {
        try {
            return this.playerGD.metCiv.get(i);
        }
        catch (Exception ex) {
            return true;
        }
    }

    public final void setMetCiv(int i, boolean met) {
        try {
            this.playerGD.metCiv.set(i, met);
        }
        catch (Exception exception) {
            
        }
    }

    public final void addMetCiv(boolean metCiv) {
        this.playerGD.metCiv.add(metCiv);
    }

    public final boolean getMetAlliance(int nAllianceID) {
        for (int i = 0; i < CFG.core.getAlliance(nAllianceID).getCivilizationsSize(); ++i) {
            if (!this.getMetCiv(CFG.core.getAlliance(nAllianceID).getCivilization(i))) continue;
            return true;
        }
        return false;
    }

    public final boolean getFog(int i) {
        try {
            return this.fogOfWar.get(i);
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return true;
        }
    }

    public final void setFogOfWar(int i, boolean isVisible) {
        try {
            this.fogOfWar.set(i, isVisible);
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void setFogOfWar_ExtraCheck(int i, boolean isVisible) {
        try {
            this.fogOfWar.set(i, isVisible || CFG.core.getProv(i).getArmyCivID1(this.getCivId()) > 0);
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }
}

