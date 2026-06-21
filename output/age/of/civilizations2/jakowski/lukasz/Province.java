
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Achievement_Data;
import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.ColonizationManager;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.DrawArmyInProvince;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mountains.Mountain;
import age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.NotSupplied.Message_ProvincesNotSupplied_LostControl;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.NotSupplied.Message_ProvincesNotSupplied_LostControl_EnemyLost;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.ProvinceBorder;
import age.of.civilizations2.jakowski.lukasz.Province_Army;
import age.of.civilizations2.jakowski.lukasz.Province_ArmyBox;
import age.of.civilizations2.jakowski.lukasz.Province_Core;
import age.of.civilizations2.jakowski.lukasz.Province_GameData2;
import age.of.civilizations2.jakowski.lukasz.Province_Info_GameData3;
import age.of.civilizations2.jakowski.lukasz.Province_Population;
import age.of.civilizations2.jakowski.lukasz.Province_Port_Center;
import age.of.civilizations2.jakowski.lukasz.Province_SupportRebels;
import age.of.civilizations2.jakowski.lukasz.Province_SupportRebels_Help;
import age.of.civilizations2.jakowski.lukasz.Province_VolunteerArmySent;
import age.of.civilizations2.jakowski.lukasz.Save.Province_Save_GD;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Province {
    private int iProvinceID = 0;
    private int iPotential = 0;
    private int iDangerLevel = 0;
    private int iDangerLevel_WithArmy = 0;
    public int iProviBordersLandByLandSize = 0;
    public int iProviBordersLandBySeaSize = 0;
    public int iProvBordersSeaBySeaSize = 0;
    private int iCivRegionID = -1;
    public boolean wasCities = false;
    private int pointsSize;
    private int miX;
    private int miY;
    private int maX;
    private int maY;
    private int ceX;
    private int ceY;
    private int shiftX;
    private int shiftY;
    private String provinceName = "";
    private String sProvinceNameUpperCase = "";
    public int iProvinceNameLength_Minus1 = 0;
    private int iContinentID;
    private int iRegionID;
    private int iTerrainTypeID;
    private boolean seaProvince = false;
    private List<City> cities;
    private boolean drawCitiesInProv = false;
    private int citiesSize = 0;
    private List<Mountain> mountains;
    private List<Wonder> wonders;
    private int iWondersSize = 0;
    private Image provBG = null;
    private List<Short> pointsX = new ArrayList<Short>();
    private List<Short> pointsY = new ArrayList<Short>();
    private List<Province_ArmyBox> lProvince_ArmyBoxes = null;
    private boolean isBelowZeroPosX = false;
    private int iTranslateProvincePosX = 0;
    private boolean drawProvince = false;
    private Province_Port_Center provincePort = new Province_Port_Center(0, 0);
    public float incomeTaxation = 1.0f;
    public float incomeProduction = 1.0f;
    public float administrationCost = 0.0f;
    public float fPopulationGrowthRate;
            public Province_Save_GD provGD;

    public final int getOccupationTurnsLeft() { return this.provGD.iOccupationTurnsLeft; }
    public final void setOccupationTurnsLeft(int i) { this.provGD.iOccupationTurnsLeft = i; }
    private DrawArmyInProvince drawArmyInProv;
    public int freeValue = 0;
    private int fromCivID = -1;
    private long lColorTime = 0L;
    private boolean updateColorTime = false;
    public boolean viewBool = false;
    public boolean wasInProv = false;
    public List<Province_VolunteerArmySent> provinceVolunteerArmySent = new ArrayList<Province_VolunteerArmySent>();
    private byte iArmyWasRecruited = 0;
    private byte iNumOfNeighboringNeutralProvinces = 0;
    private boolean bordersWithEnemy = false;
    private float provinceStability = 1.0f;
    public List<Short> lNeighboringProvinces = new ArrayList<Short>();
    public List<Short> lNeighboringSeaProvinces = new ArrayList<Short>();
    private int iBasin = -1;
    public int neighboringProvincesSize;
    public int neighboringSeaProvincesSize;
    public List<ProvinceBorder> provinceBordersLandByLand = new ArrayList<ProvinceBorder>();
    public List<ProvinceBorder> provinceBordersLandBySea = new ArrayList<ProvinceBorder>();
    public List<ProvinceBorder> provinceBordersSeaBySea = new ArrayList<ProvinceBorder>();

    public final void drawProvinceBorder_PrintAMap(SpriteBatch oSB) {
        int i;
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            this.provinceBordersLandBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_PrintAMap_Classic(SpriteBatch oSB) {
        int i;
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            this.provinceBordersLandBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_CreateRandomGame(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getActiveProvID() == this.getProvID() || CFG.core.getActiveProvID() == this.provinceBordersLandByLand.get(i).getWithProvinceID() || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
            this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line32, 0, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_CreateRandomGameWasteland(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() && CFG.core.getActiveProvID() != this.getProvID() && CFG.core.getActiveProvID() != this.provinceBordersLandByLand.get(i).getWithProvinceID()) continue;
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public Province(int iProvinceID, Province_GameData2 nProvince_GameData) {
        int i;
        this.iProvinceID = iProvinceID;
        this.provGD = new Province_Save_GD();
        this.provGD.pops = new Province_Population();
        for (i = 0; i < nProvince_GameData.getNeighboringProvinces().size(); ++i) {
            this.lNeighboringProvinces.add(nProvince_GameData.getNeighboringProvinces().get(i));
        }
        this.neighboringProvincesSize = this.lNeighboringProvinces.size();
        for (i = 0; i < nProvince_GameData.getNeighboringSeaProvinces().size(); ++i) {
            this.lNeighboringSeaProvinces.add(nProvince_GameData.getNeighboringSeaProvinces().get(i));
        }
        this.neighboringSeaProvincesSize = this.lNeighboringSeaProvinces.size();
        short s = nProvince_GameData.getPointsX().get(0);
        this.maX = s;
        this.miX = s;
        short s2 = nProvince_GameData.getPointsY().get(0);
        this.maY = s2;
        this.miY = s2;
        int iSize = nProvince_GameData.getPointsX().size();
        for (i = 0; i < iSize; ++i) {
            this.pointsX.add(nProvince_GameData.getPointsX().get(i));
            this.pointsY.add(nProvince_GameData.getPointsY().get(i));
            if (this.miX > nProvince_GameData.getPointsX().get(i)) {
                this.miX = nProvince_GameData.getPointsX().get(i).shortValue();
            }
            if (this.maX < nProvince_GameData.getPointsX().get(i)) {
                this.maX = nProvince_GameData.getPointsX().get(i).shortValue();
            }
            if (this.miY > nProvince_GameData.getPointsY().get(i)) {
                this.miY = nProvince_GameData.getPointsY().get(i).shortValue();
            }
            if (this.maY >= nProvince_GameData.getPointsY().get(i)) continue;
            this.maY = nProvince_GameData.getPointsY().get(i).shortValue();
        }
        this.pointsX.add(nProvince_GameData.getPointsX().get(nProvince_GameData.getPointsX().size() - 1));
        this.pointsY.add(nProvince_GameData.getPointsY().get(nProvince_GameData.getPointsY().size() - 1));
        this.pointsSize = this.pointsX.size();
        this.ceX = (short)((this.miX + this.maX) / 2);
        this.ceY = (short)((this.miY + this.maY) / 2);
        boolean bl = this.isBelowZeroPosX = this.miX < 0;
        synchronized(Core.class) {
            if (Core.MAX_BELOW_ZERO_POINT_X > this.miX) {
                Core.MAX_BELOW_ZERO_POINT_X = this.miX;
            }
        }
        this.setLvlOfPort(nProvince_GameData.getLevelOfPort());
        if (nProvince_GameData.getLevelOfPort() < -1) {
            this.seaProvince = true;
        }
        if (nProvince_GameData.getProvinceBorder() != null) {
            this.provinceBordersLandByLand = new ArrayList<ProvinceBorder>();
            this.provinceBordersLandBySea = new ArrayList<ProvinceBorder>();
            this.provinceBordersSeaBySea = new ArrayList<ProvinceBorder>();
            for (i = 0; i < nProvince_GameData.getProvinceBorder().size(); ++i) {
                int j;
                if (this.provGD.iPort < -1) {
                    this.provinceBordersSeaBySea.add(new ProvinceBorder(nProvince_GameData.getProvinceBorder().get(i).getWithProvinceID(), nProvince_GameData.getProvinceBorder().get(i).getPointsX(), nProvince_GameData.getProvinceBorder().get(i).getPointsY()));
                    continue;
                }
                boolean bContinue = false;
                for (j = 0; j < this.neighboringProvincesSize; ++j) {
                    if (this.lNeighboringProvinces.get(j).shortValue() != nProvince_GameData.getProvinceBorder().get(i).getWithProvinceID()) continue;
                    this.provinceBordersLandByLand.add(new ProvinceBorder(nProvince_GameData.getProvinceBorder().get(i).getWithProvinceID(), nProvince_GameData.getProvinceBorder().get(i).getPointsX(), nProvince_GameData.getProvinceBorder().get(i).getPointsY()));
                    bContinue = true;
                    break;
                }
                if (bContinue) continue;
                for (j = 0; j < this.neighboringSeaProvincesSize; ++j) {
                    if (this.lNeighboringSeaProvinces.get(j).shortValue() != nProvince_GameData.getProvinceBorder().get(i).getWithProvinceID()) continue;
                    this.provinceBordersLandBySea.add(new ProvinceBorder(nProvince_GameData.getProvinceBorder().get(i).getWithProvinceID(), nProvince_GameData.getProvinceBorder().get(i).getPointsX(), nProvince_GameData.getProvinceBorder().get(i).getPointsY()));
                    bContinue = true;
                    break;
                }
                if (!bContinue) continue;
            }
            if (this.provinceBordersLandByLand.size() == 0) {
                this.provinceBordersLandByLand = null;
            } else {
                this.iProviBordersLandByLandSize = this.provinceBordersLandByLand.size();
            }
            if (this.provinceBordersLandBySea.size() == 0) {
                this.provinceBordersLandBySea = null;
            } else {
                this.iProviBordersLandBySeaSize = this.provinceBordersLandBySea.size();
            }
            if (this.provinceBordersSeaBySea.size() == 0) {
                this.provinceBordersSeaBySea = null;
            } else {
                this.iProvBordersSeaBySeaSize = this.provinceBordersSeaBySea.size();
            }
        }
        this.loadProvinceInfo(nProvince_GameData.provinceInfo);
        this.cities = new ArrayList<City>();
        this.mountains = new ArrayList<Mountain>();
        this.wonders = new ArrayList<Wonder>();
        this.provincePort.iShiftX = (int)((float)nProvince_GameData.iPort_ShiftX * (float)CFG.map.getMpB().getMapSc3() / (float)CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN()));
        this.provincePort.iShiftY = (int)((float)nProvince_GameData.iPort_ShiftY * (float)CFG.map.getMpB().getMapSc3() / (float)CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN()));
        this.addCiv(0, 0);
    }

    public final int getBalance_LastTurn() {
        return (int)(this.incomeTaxation + this.incomeProduction - this.administrationCost);
    }

    public final void loadProvinceInfo() {
        try {
            FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "provinces/" + this.iProvinceID);
            Province_GameData2 nProvinceGameData2 = (Province_GameData2)CFG.deserialize(file.readBytes());
            this.loadProvinceInfo(nProvinceGameData2.provinceInfo);
            return;
        }
        catch (ClassCastException e) {
            CFG.exceptionStack(e);
        }
        catch (ClassNotFoundException e) {
            CFG.exceptionStack(e);
        }
        catch (IOException e) {
            CFG.exceptionStack(e);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.iContinentID = 1;
        this.fPopulationGrowthRate = 1.0f;
        this.iTerrainTypeID = this.getLvlOfPort() >= -1 ? 1 : 0;
    }

    public final int getCivRegionID() {
        return this.iCivRegionID;
    }

    public final void setCivRegionID(int iCivRegionID) {
        this.iCivRegionID = iCivRegionID;
    }

    public final void setTerrainTypeID(int iTerrainTypeID) {
        this.iTerrainTypeID = iTerrainTypeID;
    }

    public final int getTerrainTypeID() {
        return this.iTerrainTypeID;
    }

    public final float getGrowthRate_Pop() {
        return this.fPopulationGrowthRate;
    }

    public final float getGrowthRate_Pop_WithFarm() {
        return this.fPopulationGrowthRate + BuildingsManager.getFarm_GrowthRateBonus(this.getLvlOfFarm()) + (this.provGD.wonderBuilt ? GameValues.gvWonder.GROWTH_RATE : 0.0f);
    }

    public final float getGrowthRate_NewColony() {
        return (float)this.provGD.iNewColonyBonus * (GameValues.gvColonize.NEW_COLONY_GROWTH_RATE_BONUS_BASE + GameValues.gvColonize.NEW_COLONY_GROWTH_RATE_BONUS_PERC_OF_PROVINCE_GROWTH * this.getGrowthRate_Pop());
    }

    public final float getGrowthRate_Pop_WithFarm_WithTerrain() {
        return Math.max(this.fPopulationGrowthRate + BuildingsManager.getFarm_GrowthRateBonus(this.getLvlOfFarm()) + CFG.terrainTypesManager.getPopulationGrowth(this.getTerrainTypeID()) + this.getGrowthRate_NewColony() + (this.provGD.wonderBuilt ? GameValues.gvWonder.GROWTH_RATE : 0.0f), 0.02f);
    }

    public final void setGrowthRate_Population(float fPopulationGrowthRate) {
        this.fPopulationGrowthRate = fPopulationGrowthRate;
    }

    public final void buildProvinceBG(boolean overwriteExistingFiles) {
        int i;
        int tempMapScaleBefore = CFG.map.getMapScale(CFG.map.getActiveMapIDN());
        FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + "Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        ArrayList<String> tempL = new ArrayList<String>();
        for (int i2 = 0; i2 < tagsSPLITED.length; ++i2) {
            tempL.add(tagsSPLITED[i2]);
        }
        boolean addStandardScale = true;
        boolean addScale1 = true;
        for (i = 0; i < tempL.size(); ++i) {
            if (Integer.parseInt((String)tempL.get(i)) != CFG.map.getMapScale(CFG.map.getActiveMapIDN())) continue;
            addStandardScale = false;
            break;
        }
        for (i = 0; i < tempL.size(); ++i) {
            if (Integer.parseInt((String)tempL.get(i)) != 1) continue;
            addScale1 = false;
            break;
        }
        if (addStandardScale) {
            tempL.add("" + CFG.map.getMapScale(CFG.map.getActiveMapIDN()));
        }
        if (addScale1 && CFG.map.getMapScale(CFG.map.getActiveMapIDN()) != 1) {
            tempL.add("1");
        }
        for (i = 0; i < tempL.size(); ++i) {
            CFG.map.setMapScale(CFG.map.getActiveMapIDN(), Integer.parseInt((String)tempL.get(i)));
            if (!overwriteExistingFiles && FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + this.iProvinceID).exists()) continue;
            Pixmap pixmap = new Pixmap(this.maX * CFG.map.getMpB().getMapSc3() - this.miX * CFG.map.getMpB().getMapSc3(), this.maY * CFG.map.getMpB().getMapSc3() - this.miY * CFG.map.getMpB().getMapSc3(), Pixmap.Format.LuminanceAlpha);
            pixmap.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
            for (int y = 0; y < pixmap.getHeight(); ++y) {
                for (int x = 0; x < pixmap.getWidth(); ++x) {
                    int a;
                    boolean add;
                    if (CFG.core.ptCS(this.iProvinceID, this.getMiX2() + x, this.getMiY4() + y)) {
                        add = true;
                        for (int a2 = 0; a2 < this.getNeighProvincesSize(); ++a2) {
                            if (this.iProvinceID <= this.getNeighProvinces(a2) || !CFG.core.ptCS(this.getNeighProvinces(a2), this.getMiX2() + x, this.getMiY4() + y)) continue;
                            add = false;
                        }
                        if (!add) continue;
                        pixmap.drawPixel(x, y);
                        continue;
                    }
                    add = false;
                    boolean check = false;
                    if (CFG.core.ptCS(this.iProvinceID, this.getMiX2() + x + 1, this.getMiY4() + y)) {
                        check = true;
                    }
                    if (CFG.core.ptCS(this.iProvinceID, this.getMiX2() + x, this.getMiY4() + y + 1)) {
                        check = true;
                    }
                    if (CFG.core.ptCS(this.iProvinceID, this.getMiX2() + x - 1, this.getMiY4() + y)) {
                        check = true;
                    }
                    if (CFG.core.ptCS(this.iProvinceID, this.getMiX2() + x, this.getMiY4() + y - 1)) {
                        check = true;
                    }
                    if (!check) continue;
                    boolean edn = false;
                    for (a = 0; a < this.getNeighProvincesSize(); ++a) {
                        if (!CFG.core.ptCS(this.getNeighProvinces(a), this.getMiX2() + x, this.getMiY4() + y)) continue;
                        edn = true;
                        break;
                    }
                    if (edn) continue;
                    for (a = 0; a < this.getNeighProvincesSize(); ++a) {
                        if (this.iProvinceID <= this.getNeighProvinces(a)) continue;
                        if (CFG.core.ptCS(this.getNeighProvinces(a), this.getMiX2() + x + 1, this.getMiY4() + y)) {
                            add = true;
                            continue;
                        }
                        if (CFG.core.ptCS(this.getNeighProvinces(a), this.getMiX2() + x, this.getMiY4() + y + 1)) {
                            add = true;
                            continue;
                        }
                        if (CFG.core.ptCS(this.getNeighProvinces(a), this.getMiX2() + x - 1, this.getMiY4() + y)) {
                            add = true;
                            continue;
                        }
                        if (!CFG.core.ptCS(this.getNeighProvinces(a), this.getMiX2() + x, this.getMiY4() + y - 1)) continue;
                        add = true;
                    }
                    if (!add) continue;
                    pixmap.drawPixel(x, y);
                }
            }
            PixmapIO.writeCIM(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + Integer.parseInt((String)tempL.get(i)) + "/" + this.iProvinceID), pixmap);
            pixmap.dispose();
            CFG.toastM.addM("-- PROVINCE DATA GENERATED " + this.iProvinceID + " --");
        }
        CFG.map.setMapScale(CFG.map.getActiveMapIDN(), tempMapScaleBefore);
    }

    public final void updateProvincePort(int nX, int nY) {
        this.provincePort = new Province_Port_Center(nX, nY);
    }

    public final void setProvColor_FoG_Discovery(SpriteBatch oSB) {
        try {
            if (!CFG.getMetProv(this.iProvinceID)) {
                float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                oSB.setColor(c[0], c[1], c[2], c[3]);
            } else {
                this.setProvColor(oSB);
            }
        }
        catch (Exception ex) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.0f);
        }
    }

    public final void setProvColor(SpriteBatch oSB) {
        try {
            if (this.fromCivID >= 0 && this.getCivId() > 0) {
                if (this.updateColorTime) {
                    this.lColorTime = System.currentTimeMillis();
                    this.updateColorTime = false;
                }
                int tempStepID = Math.min((int)(System.currentTimeMillis() - this.lColorTime), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL);
                if (this.fromCivID == 0) {
                    oSB.setColor((float)CFG.core.getCiv(this.getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(this.getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(this.getCivId()).getB() / 255.0f, CFG.getColorStep(25, CFG.settingsGD.PROV_ALPHA, tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL));
                } else {
                    oSB.setColor(CFG.getColorStep(CFG.core.getCiv(this.fromCivID).getR(), CFG.core.getCiv(this.getCivId()).getR(), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL), CFG.getColorStep(CFG.core.getCiv(this.fromCivID).getG(), CFG.core.getCiv(this.getCivId()).getG(), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL), CFG.getColorStep(CFG.core.getCiv(this.fromCivID).getB(), CFG.core.getCiv(this.getCivId()).getB(), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL), (float)CFG.settingsGD.PROV_ALPHA / 255.0f);
                }
                if (this.lColorTime + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_OWNER_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    this.fromCivID = -1;
                }
            } else {
                this.setCivilizationProvinceColor(oSB, this.getCivId());
            }
        }
        catch (Exception ex) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.0f);
        }
    }

    public final void drawProv_ActiveProv(SpriteBatch oSB) {
        if (this.iContinentID == CFG.map.getMapContinents().getOceanContinentID()) {
            if (this.provBG != null) {
                this.provBG.drawO(oSB, this.iTranslateProvincePosX + this.miX + this.miX * CFG.map.getMpB().getMapSc3() - this.miX, CFG.map.getMpC().getPY() + this.miY + this.miY * CFG.map.getMpB().getMapSc3() - this.miY + this.provBG.getHeight() * CFG.map.getMpB().getMapSc3() - this.provBG.getHeight(), (float)CFG.map.getMpB().getMapSc3());
            }
        } else {
            this.drawLandProv(oSB);
        }
    }

    public final void drawLandProv(SpriteBatch oSB) {
        this.drawProvMesh(oSB);
    }

    public final void drawProvMesh(SpriteBatch oSB) {
        TextureRegion region = ProvinceAtlas.getRegion(this.iProvinceID);
        if (region != null) {
            oSB.draw(region, (float)(this.iTranslateProvincePosX + this.miX * CFG.map.getMpB().getMapSc3()), (float)(-(CFG.map.getMpC().getPY() + this.miY * CFG.map.getMpB().getMapSc3() + (int)((float)region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()))), (float)((int)((float)region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale())), (float)((int)((float)region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale())));
        } else if (this.provBG != null) {
            this.provBG.draw(oSB, this.iTranslateProvincePosX + this.miX * CFG.map.getMpB().getMapSc3(), CFG.map.getMpC().getPY() + this.miY * CFG.map.getMpB().getMapSc3(), CFG.map.getMpB().getMapExtraScale());
        }
    }

    public final void drawOccupiedProv(SpriteBatch oSB) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)CFG.settingsGD.OCCUPIED_PROV_ALPHA / 255.0f));
        AoCGame.shaderAlpha3.setUniformf("u_maskScale", CFG.settingsGD.OCCUPIED_STRIPES_SIZE * Math.max((float)this.provBG.getWidth() / (float)IMGManager.getIMG(Images.patternReversed).getWidth(), (float)this.provBG.getHeight() / (float)IMGManager.getIMG(Images.patternReversed).getHeight()));
        this.provBG.getTexture().bind(1);
        Gdx.gl.glActiveTexture(33984);
        IMGManager.getIMG(Images.patternExtraAlpha).draw3(oSB, this.iTranslateProvincePosX + this.miX * CFG.map.getMpB().getMapSc3(), CFG.map.getMpC().getPY() + this.miY * CFG.map.getMpB().getMapSc3() - IMGManager.getIMG(Images.patternExtraAlpha).getHeight(), (int)((float)this.provBG.getWidth() * CFG.map.getMpB().getMapExtraScale()), (int)((float)this.provBG.getHeight() * CFG.map.getMpB().getMapExtraScale()));
        oSB.flush();
    }

    public final void drawOccupiedProv2(SpriteBatch oSB) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)(CFG.settingsGD.OCCUPIED_PROV_ALPHA * 2) / 255.0f));
        AoCGame.shaderAlpha3.setUniformf("u_maskScale", CFG.settingsGD.OCCUPIED_STRIPES_SIZE * Math.max((float)this.provBG.getWidth() / (float)IMGManager.getIMG(Images.patternReversed).getWidth(), (float)this.provBG.getHeight() / (float)IMGManager.getIMG(Images.patternReversed).getHeight()));
        this.provBG.getTexture().bind(1);
        Gdx.gl.glActiveTexture(33984);
        IMGManager.getIMG(Images.patternExtraAlpha).draw3(oSB, this.iTranslateProvincePosX + this.miX * CFG.map.getMpB().getMapSc3(), CFG.map.getMpC().getPY() + this.miY * CFG.map.getMpB().getMapSc3() - IMGManager.getIMG(Images.patternExtraAlpha).getHeight(), (int)((float)this.provBG.getWidth() * CFG.map.getMpB().getMapExtraScale()), (int)((float)this.provBG.getHeight() * CFG.map.getMpB().getMapExtraScale()));
        oSB.flush();
    }

    public final void drawWastelandProv(SpriteBatch oSB) {
        oSB.setColor(this.getWastelandColor(CFG.settingsGD.PROVINCE_ALPHA_WASTELAND));
        this.drawProvMesh(oSB);
    }

    public final void drawWastelandProv_PeaceTreaty(SpriteBatch oSB) {
        oSB.setColor(this.getWastelandColor(CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 0.25f));
        this.drawProvMesh(oSB);
    }

    public final void drawWastelandProv(SpriteBatch oSB, float nAlpha) {
        oSB.setColor(this.getWastelandColor(nAlpha));
        this.drawProvMesh(oSB);
    }

    public final void drawProvFlag(SpriteBatch oSB) {
        if (this.getDrawProv()) {
            oSB.setShader(AoCGame.shaderAlpha4);
            this.provBG.getTexture().bind(2);
            CFG.core.getCiv(this.getCivId()).getFlagC().getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            this.drawLandProv(oSB);
            oSB.setShader(AoCGame.shaderDef);
        }
    }

    public final void drawProvFlag_CreateRandomGame(SpriteBatch oSB, int nPlayerID) {
        if (this.getDrawProv()) {
            oSB.setShader(AoCGame.shaderAlpha4);
            this.provBG.getTexture().bind(2);
            CFG.randomGameManager.getPlayer(nPlayerID).getFlag().getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            this.drawLandProv(oSB);
            oSB.setShader(AoCGame.shaderDef);
        }
    }

    public final void drawProvinceInfo(SpriteBatch oSB, float nScale) {
        this.drawProvincePort(oSB, nScale);
    }

    public final void drawProvincePort(SpriteBatch oSB, float nScale) {
        if (this.getLvlOfPort() > 0) {
            this.provincePort.draw(oSB, (int)((float)(this.getCeX() + this.getTranslateProvPosX()) * nScale), (int)((float)(this.getCeY() + CFG.map.getMpC().getPY()) * nScale), nScale);
        }
    }

    public final void drawProvinceBorderTimeline(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.timelapseManager.timelineOwners.get(this.getProvID()).equals(CFG.timelapseManager.timelineOwners.get(this.provinceBordersLandByLand.get(i).getWithProvinceID()))) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorderTimeline_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.timelapseManager.timelineOwners.get(this.getProvID()).equals(CFG.timelapseManager.timelineOwners.get(this.provinceBordersLandByLand.get(i).getWithProvinceID()))) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_Timeline_Only_CivilizationBorder(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.timelapseManager.timelineOwners.get(this.getProvID()).equals(CFG.timelapseManager.timelineOwners.get(this.provinceBordersLandByLand.get(i).getWithProvinceID()))) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_Timeline_Only_CivilizationBorder_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.timelapseManager.timelineOwners.get(this.getProvID()).equals(CFG.timelapseManager.timelineOwners.get(this.provinceBordersLandByLand.get(i).getWithProvinceID()))) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_Only_CivilizationBorder(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_Only_CivilizationBorder_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                    oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                    this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                    continue;
                }
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                    oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                    this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                    continue;
                }
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) continue;
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void updateFogOfWar(int nPlayerID) {
        try {
            int j;
            boolean nState;
            int i;
            int o;
            int k;
            boolean bProvinceView = false;
            if (this.getSeaProv()) {
                if (CFG.core.haveArmy_FogOfWarCheck(this.getProvID(), CFG.core.getPlayer(nPlayerID).getCivId())) {
                    bProvinceView = true;
                    for (int j2 = 0; j2 < this.getNeighProvincesSize(); ++j2) {
                        if (CFG.core.getProv(this.getNeighProvinces(j2)).getSeaProv()) {
                            CFG.core.getPlayer(nPlayerID).setFogOfWar(this.getNeighProvinces(j2), true);
                        }
                        CFG.core.getPlayer(nPlayerID).setMetProv(this.getNeighProvinces(j2), true);
                        CFG.core.getProv(this.getNeighProvinces(j2)).updateProvinceBorder();
                        for (k = 0; k < CFG.core.getProv(this.getNeighProvinces(j2)).getNeighProvincesSize(); ++k) {
                            CFG.core.getPlayer(nPlayerID).setMetProv(CFG.core.getProv(this.getNeighProvinces(j2)).getNeighProvinces(k), true);
                            CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(j2)).getNeighProvinces(k)).updateProvinceBorder();
                            for (o = 0; o < CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(j2)).getNeighProvinces(k)).getCivsSize(); ++o) {
                                CFG.core.getPlayer(nPlayerID).setMetCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(j2)).getNeighProvinces(k)).getCivId(o), true);
                            }
                        }
                    }
                }
                if (!bProvinceView) {
                    for (i = 0; i < this.getNeighProvincesSize(); ++i) {
                        if (!CFG.core.getProv(this.getNeighProvinces(i)).getSeaProv()) continue;
                        nState = CFG.core.haveArmy_FogOfWarCheck(this.getNeighProvinces(i), CFG.core.getPlayer(nPlayerID).getCivId());
                        for (j = 0; j < CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvincesSize(); ++j) {
                            if (!CFG.core.haveArmy_FogOfWarCheck(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j), CFG.core.getPlayer(nPlayerID).getCivId())) continue;
                            nState = true;
                            break;
                        }
                        CFG.core.getPlayer(nPlayerID).setFogOfWar_ExtraCheck(this.getNeighProvinces(i), nState);
                    }
                }
            } else {
                for (i = 0; i < this.getNeighProvincesSize(); ++i) {
                    nState = false;
                    if (CFG.core.getPlayer(nPlayerID).getCivId() == CFG.core.getProv(this.getNeighProvinces(i)).getCivId() || CFG.core.getPlayer(nPlayerID).getCivId() == CFG.core.getCiv(CFG.core.getProv(this.getNeighProvinces(i)).getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() == CFG.core.getProv(this.getNeighProvinces(i)).getCivId() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getProv(this.getNeighProvinces(i)).getCivId()).getAlliance() || CFG.core.haveArmy_FogOfWarCheck(this.getNeighProvinces(i), CFG.core.getPlayer(nPlayerID).getCivId())) {
                        if (CFG.core.getProv(this.getNeighProvinces(i)).getLvlOfWatchTower() > 0 && this.getLvlOfFort() < 1) {
                            bProvinceView = true;
                        }
                        nState = true;
                    } else {
                        for (j = 0; j < CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvincesSize(); ++j) {
                            if (CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j)).getLvlOfWatchTower() <= 0 || CFG.core.getProv(this.getNeighProvinces(i)).getLvlOfFort() >= 1 || CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j)).getCivId() && CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j)).getCivId()).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j)).getCivId() && (CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j)).getCivId()).getAlliance()) && !CFG.core.haveArmy_FogOfWarCheck(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(j), CFG.core.getPlayer(nPlayerID).getCivId())) continue;
                            nState = true;
                            break;
                        }
                    }
                    if (CFG.core.getPlayer(nPlayerID).getFog(this.getNeighProvinces(i)) == nState) continue;
                    CFG.core.getPlayer(nPlayerID).setFogOfWar_ExtraCheck(this.getNeighProvinces(i), nState);
                    if (nPlayerID != CFG.PLAYER_TURN_ID) continue;
                    CFG.core.getProv(this.getNeighProvinces(i)).updateDrawArmyInProv();
                }
                for (i = 0; i < this.getNeighSeaProvincesSize(); ++i) {
                    nState = false;
                    if (CFG.core.getPlayer(nPlayerID).getCivId() == this.getCivId() || CFG.core.getPlayer(nPlayerID).getCivId() == CFG.core.getCiv(this.getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() == this.getCivId() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() == CFG.core.getCiv(this.getCivId()).getAlliance()) {
                        nState = true;
                    } else {
                        block10: for (j = 0; j < CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvincesSize(); ++j) {
                            if (CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getSeaProv()) {
                                for (int k2 = 0; k2 < CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivsSize(); ++k2) {
                                    if (CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId(k2) && CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId(k2)).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId(k2) && (CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId(k2)).getAlliance())) continue;
                                    nState = true;
                                    j = CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvincesSize();
                                    continue block10;
                                }
                                continue;
                            }
                            if (CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId() && CFG.core.getPlayer(nPlayerID).getCivId() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId()).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId() && (CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId()).getAlliance())) continue;
                            nState = true;
                            j = CFG.core.getProv(this.getNeighSeaProvinces(i)).getNeighProvincesSize();
                            break;
                        }
                    }
                    if (CFG.core.getPlayer(nPlayerID).getFog(this.getNeighSeaProvinces(i)) == nState) continue;
                    CFG.core.getPlayer(nPlayerID).setFogOfWar_ExtraCheck(this.getNeighSeaProvinces(i), nState);
                    if (nPlayerID != CFG.PLAYER_TURN_ID) continue;
                    CFG.core.getProv(this.getNeighSeaProvinces(i)).updateDrawArmyInProv();
                }
            }
            bProvinceView = bProvinceView || CFG.core.getPlayer(nPlayerID).getCivId() == this.getCivId() || CFG.core.getPlayer(nPlayerID).getCivId() == CFG.core.getCiv(this.getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() == this.getCivId() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() == CFG.core.getCiv(this.getCivId()).getAlliance() || CFG.core.haveArmy_FogOfWarCheck(this.getProvID(), CFG.core.getPlayer(nPlayerID).getCivId());
            CFG.core.getPlayer(nPlayerID).setFogOfWar_ExtraCheck(this.getProvID(), bProvinceView);
            if (bProvinceView) {
                for (i = 0; i < this.getNeighProvincesSize(); ++i) {
                    CFG.core.getPlayer(nPlayerID).setMetProv(this.getNeighProvinces(i), true);
                    CFG.core.getProv(this.getNeighProvinces(i)).updateProvinceBorder();
                    for (k = 0; k < CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvincesSize(); ++k) {
                        CFG.core.getPlayer(nPlayerID).setMetProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(k), true);
                        CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(k)).updateProvinceBorder();
                        for (o = 0; o < CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(k)).getCivsSize(); ++o) {
                            CFG.core.getPlayer(nPlayerID).setMetCiv(CFG.core.getProv(CFG.core.getProv(this.getNeighProvinces(i)).getNeighProvinces(k)).getCivId(o), true);
                        }
                    }
                    for (k = 0; k < CFG.core.getProv(this.getNeighProvinces(i)).getCivsSize(); ++k) {
                        CFG.core.getPlayer(nPlayerID).setMetCiv(CFG.core.getProv(this.getNeighProvinces(i)).getCivId(k), true);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) continue;
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_Wasteland(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getWastelandLvl() >= 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) continue;
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_PeaceTreaty_Wasteland_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getWastelandLvl() >= 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) continue;
            if (this.getWastelandLvl() >= 0 || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getWastelandLvl() >= 0) {
                oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.getProvID()).iCivID == CFG.peaceTreatyData.drawProvOwners.get((int)this.provinceBordersLandByLand.get((int)i).getWithProvinceID()).iCivID) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, this.provinceBordersLandByLand.get(i).getDashedImage(), 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_OnlyCivilizationBorder(SpriteBatch oSB) {
        block4: {
            block3: {
                if (!CFG.getIsDesktop()) break block3;
                if (!(CFG.map.getMpS().getCurrSc() > GameValues.gvProvinceBorder.PROVINCE_BORDER_STOP_DRAWING)) break block4;
                for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
                    if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
                    this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                }
                break block4;
            }
            if (CFG.map.getMpS().getCurrSc() > GameValues.gvProvinceBorder.PROVINCE_BORDER_STOP_DRAWING_MOBILE) {
                for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
                    if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
                    this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                }
            }
        }
    }

    public final void drawProvinceBorder_OnlyCivilizationBorder_Capitals(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() || this.isCapital() || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).isCapital() || CFG.core.getActiveProvID() == this.getProvID() || CFG.core.getActiveProvID() == this.provinceBordersLandByLand.get(i).getWithProvinceID()) {
                this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getCivId() != 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() != 0) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
            this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscoveryWasteland(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() || this.isCapital() || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).isCapital() || CFG.core.getActiveProvID() == this.getProvID() || CFG.core.getActiveProvID() == this.provinceBordersLandByLand.get(i).getWithProvinceID()) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            if (this.getCivId() != 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() != 0) continue;
            oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
            this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscovery(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() || this.isCapital() || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).isCapital() || CFG.core.getActiveProvID() == this.getProvID() || CFG.core.getActiveProvID() == this.provinceBordersLandByLand.get(i).getWithProvinceID()) {
                    this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                    continue;
                }
                if (this.getCivId() != 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() != 0) continue;
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscovery_Classic(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                if (this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() || this.isCapital() || CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).isCapital() || CFG.core.getActiveProvID() == this.getProvID() || CFG.core.getActiveProvID() == this.provinceBordersLandByLand.get(i).getWithProvinceID()) {
                    this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
                    continue;
                }
                if (this.getCivId() != 0 && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() != 0) continue;
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(CFG.COLOR_PROVINCE_DASHED);
                this.provinceBordersLandByLand.get(i).drawDashedBorder(oSB, Images.line33, 0, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(CFG.COLOR_PROVINCE_STRAIGHT);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_TerrainMode(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.iTerrainTypeID == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getTerrainTypeID()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_TerrainMode_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.iTerrainTypeID == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getTerrainTypeID()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_ContinentMode(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_ContinentMode_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_ContinentMode_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()) && this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_ContinentMode_FogOfWarDiscovery_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()) && this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionMode(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionMode_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionMode_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()) && this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionMode_FogOfWarDiscovery_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()) && this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID()) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.provinceBordersLandByLand.get(i).getWithProvinceID())) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void addProvBorder(int withProvinceID, List<Short> nPointsX, List<Short> nPointsY) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (withProvinceID != this.provinceBordersLandByLand.get(i).getWithProvinceID()) continue;
            return;
        }
        for (i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersLandBySea.get(i).getWithProvinceID()) continue;
            return;
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersSeaBySea.get(i).getWithProvinceID()) continue;
            return;
        }
        if (this.provinceBordersLandByLand == null) {
            this.provinceBordersLandByLand = new ArrayList<ProvinceBorder>();
        }
        this.provinceBordersLandByLand.add(new ProvinceBorder(withProvinceID, nPointsX, nPointsY));
        this.iProviBordersLandByLandSize = this.provinceBordersLandByLand.size();
        this.provinceBordersLandByLand.get(this.iProviBordersLandByLandSize - 1).updateDrawProvinceBorder(this.getProvID());
    }

    public final void removeProvBorder(int withProvinceID) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (withProvinceID != this.provinceBordersLandByLand.get(i).getWithProvinceID()) continue;
            this.provinceBordersLandByLand.remove(i);
            this.iProviBordersLandByLandSize = this.provinceBordersLandByLand.size();
            return;
        }
        for (i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersLandBySea.get(i).getWithProvinceID()) continue;
            this.provinceBordersLandBySea.remove(i);
            this.iProviBordersLandBySeaSize = this.provinceBordersLandBySea.size();
            return;
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersSeaBySea.get(i).getWithProvinceID()) continue;
            this.provinceBordersSeaBySea.remove(i);
            this.iProvBordersSeaBySeaSize = this.provinceBordersSeaBySea.size();
            return;
        }
    }

    public final ProvinceBorder getProvBordersLandBySea(int withProvinceID) {
        for (int i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersLandBySea.get(i).getWithProvinceID()) continue;
            return this.provinceBordersLandBySea.get(i);
        }
        return new ProvinceBorder(0, new ArrayList<Short>(), new ArrayList<Short>());
    }

    public final int getProvinceBordersLandBySea_ID(int withProvinceID) {
        for (int i = 0; i < this.iProviBordersLandBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersLandBySea.get(i).getWithProvinceID()) continue;
            return i;
        }
        return -1;
    }

    public final List<ProvinceBorder> getProvBordersSeaBySea() {
        return this.provinceBordersSeaBySea;
    }

    public final void drawProvinceBorder_ContinentModeWasteland(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
            if (this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_ContinentModeWasteland_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
            if (this.getContinent() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getContinent()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionModeWasteland(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
            if (this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_RegionModeWasteland_Classic(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
            if (this.getRegion() == CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getRegion()) {
                oSB.setColor(0.04f, 0.04f, 0.04f, 0.39215687f);
                this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.fTerrainMode_LinePercentage / 100.0f, this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_Classic(oSB, this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorderInStartGame(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) {
                oSB.setColor(0.0f, 0.0f, 0.0f, 1.0f);
                this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.startTheGameData.getStraightLinePercentage(), this.iTranslateProvincePosX);
                continue;
            }
            oSB.setColor(0.04f, 0.04f, 0.04f, 0.627451f);
            this.provinceBordersLandByLand.get(i).drawDashedBorder_PercentageWidth(oSB, Images.line32, 0, CFG.startTheGameData.getDashedLinePercentage(), this.iTranslateProvincePosX);
        }
        oSB.setColor(0.94f, 0.94f, 0.95f, 0.07f);
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get(i).drawStraightBorder_PercWidth(oSB, CFG.startTheGameData.getStraightLinePercentage(), this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorderInStartGame_Wasteland(SpriteBatch oSB) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder()) continue;
            oSB.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            this.provinceBordersLandByLand.get(i).drawStraightBorder_PercWidth(oSB, CFG.startTheGameData.getStraightLinePercentage(), this.iTranslateProvincePosX);
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawProvinceBorder_NextPlayerTurn(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() && this.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_CivilizationView(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() && this.getCivId() == Menu_InGame_CivilizationView.iCivID && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() == Menu_InGame_CivilizationView.iCivID) continue;
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_LoadAI_RTO(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() && CFG.core.getCiv(this.getCivId()).getIsPlayer() && CFG.core.getCiv(CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId()).getIsPlayer()) continue;
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void drawProvinceBorder_LoadAI_RTO_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        for (i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!this.provinceBordersLandByLand.get(i).getIsCivilizationBorder() && this.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            this.provinceBordersLandByLand.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
        for (i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            this.provinceBordersSeaBySea.get((int)i).drawProvBorder.drawPB(oSB, this.iTranslateProvincePosX);
        }
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, float scale, int nAlpha) {
        this.setCivilizationProvinceColor(oSB, this.provGD.armiesC.get(0).getCivID(), (float)nAlpha / 255.0f);
        this.provBG.drawO(oSB, nPosX + this.miX + (int)Math.floor((float)this.miX * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miX, nPosY + this.miY + (int)Math.floor((float)this.miY * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miY + (int)((float)this.provBG.getHeight() * scale * CFG.map.getMpB().getMapExtraScale()) - this.provBG.getHeight(), scale * CFG.map.getMpB().getMapExtraScale());
    }

    public final void draw_FogOfWarDiscovery(SpriteBatch oSB, int nPosX, int nPosY, float scale, int nAlpha) {
        try {
            if (CFG.getMetProv(this.getProvID())) {
                this.setCivilizationProvinceColor(oSB, this.provGD.armiesC.get(0).getCivID(), (float)nAlpha / 255.0f);
                this.provBG.drawO(oSB, nPosX + this.miX + (int)Math.floor((float)this.miX * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miX, nPosY + this.miY + (int)Math.floor((float)this.miY * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miY + (int)((float)this.provBG.getHeight() * scale * CFG.map.getMpB().getMapExtraScale()) - this.provBG.getHeight(), scale * CFG.map.getMpB().getMapExtraScale());
            }
        }
        catch (NullPointerException ex) {
            this.draw(oSB, nPosX, nPosY, scale, nAlpha);
        }
    }

    public final void drawWasteland(SpriteBatch oSB, int nPosX, int nPosY, float scale, int nAlpha) {
        oSB.setColor(this.getWastelandColor((float)nAlpha / 255.0f));
        this.provBG.drawO(oSB, nPosX + this.miX + (int)Math.floor((float)this.miX * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miX, nPosY + this.miY + (int)Math.floor((float)this.miY * scale * (float)CFG.map.getMpB().getMapSc3()) - this.miY + (int)((float)this.provBG.getHeight() * scale * CFG.map.getMpB().getMapExtraScale()) - this.provBG.getHeight(), scale * CFG.map.getMpB().getMapExtraScale());
    }

    public final Color getWastelandColor(float fAlpha) {
        return new Color(CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.getR() - 0.0627f * (float)this.getWastelandLvl(), CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.getG() - 0.0529f * (float)this.getWastelandLvl(), CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.getB() - 0.0443f * (float)this.getWastelandLvl(), fAlpha);
    }

    public final void setCivilizationProvinceColor(SpriteBatch oSB, int nCivID) {
        this.setCivilizationProvinceColor(oSB, nCivID, nCivID == 0 ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f);
    }

    public final void setCivilizationProvinceColor(SpriteBatch oSB, int nCivID, float nAlpha) {
        float[] c = CFG.core.getCiv(nCivID).colorFloat;
        oSB.setColor(c[0], c[1], c[2], nAlpha);
    }

    public final boolean isColorAnimated() {
        return this.fromCivID >= 0 && this.getCivId() > 0;
    }

    public final void updateDrawArmyInProv() {
        block27: {
            try {
                boolean visibilityOverride = (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR == 0) || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(this.getProvID());
                if (!visibilityOverride) {
                    int tempPlayerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    for (int vi = 0; vi < this.provGD.civsSize; ++vi) {
                        int tempArmyCivID = this.getCivId(vi);
                        if (tempArmyCivID > 0 && CFG.core.getCiv(tempArmyCivID).getPuppetOfCiv() == tempPlayerCivID) {
                            visibilityOverride = true;
                            break;
                        }
                    }
                }
                if (!visibilityOverride && CFG.FOG_OF_WAR > 0 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(this.getProvID()) && CFG.core.getCivRelationOfCivB(CFG.core.getProv(this.getProvID()).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) < (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
                    if (this.isCapital()) {
                        if (CFG.FOG_OF_WAR == 2) {
                            try {
                                if (CFG.getMetProv(this.getProvID())) {
                                    this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    } : new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    } : new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    } : new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    } : new DrawArmyInProvince(){

                                        @Override
                                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                            CFG.core.drawProvinceFlag_Capital(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                                        }
                                    })));
                                    break block27;
                                }
                                this.drawArmyInProv = new DrawArmyInProvince(){

                                    @Override
                                    public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    }
                                };
                            }
                            catch (NullPointerException ex) {
                                this.drawArmyInProv = new DrawArmyInProvince(){

                                    @Override
                                    public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    }
                                };
                            }
                            break block27;
                        }
                        this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceFlag_Capital(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        })));
                        break block27;
                    }
                    this.drawArmyInProv = CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(this.getProvID()) ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                        }
                    } : (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmy_TowerFort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmy_TowerFort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmy_Fort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmy_Fort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmy_Tower_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmy_Tower_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmy_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                        }
                    }))));
                    break block27;
                }
                if (this.getSeaProv()) {
                    if (this.getProvID() == CFG.core.getActiveProvID()) {
                        this.updateArmyWi_ALL();
                        this.drawArmyInProv = this.getProvinceArmyBoxes() == null ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                int tCenterX = (int)((float)(Province.this.getCeX() + Province.this.getShPX() + Province.this.getTranslateProvPosX()) * nScale);
                                int tCenterY = (int)((float)(Province.this.getCeY() + Province.this.getShPY() + CFG.map.getMpC().getPY()) * nScale);
                                CFG.core.drawProvinceArmy_Sea(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_TEXT_SEA_ACTIVE, nScale, tCenterX, tCenterY);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                int tCenterX = 0;
                                int tCenterY = 0;
                                Point_XY2 tempCenter = CFG.core.updateSeaProvince_CenterArmyPostion(Province.this.iProvinceID, nScale);
                                tCenterX = tempCenter.getPX();
                                tCenterY = tempCenter.getPY();
                                CFG.core.drawProvinceArmy_Sea(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_TEXT_SEA_ACTIVE, nScale, tCenterX, tCenterY);
                            }
                        };
                    } else {
                        this.drawArmyInProv = this.getProvinceArmyBoxes() == null ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                int tCenterX = (int)((float)(Province.this.getCeX() + Province.this.getShPX() + Province.this.getTranslateProvPosX()) * nScale);
                                int tCenterY = (int)((float)(Province.this.getCeY() + Province.this.getShPY() + CFG.map.getMpC().getPY()) * nScale);
                                CFG.core.drawProvinceArmy_Sea(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_TEXT_SEA, nScale, tCenterX, tCenterY);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                int tCenterX = 0;
                                int tCenterY = 0;
                                Point_XY2 tempCenter = CFG.core.updateSeaProvince_CenterArmyPostion(Province.this.iProvinceID, nScale);
                                tCenterX = tempCenter.getPX();
                                tCenterY = tempCenter.getPY();
                                CFG.core.drawProvinceArmy_Sea(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_TEXT_SEA, nScale, tCenterX, tCenterY);
                            }
                        };
                    }
                } else if (this.isCapital()) {
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && this.getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(this.getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()) {
                        if (this.iProvinceID == CFG.core.getActiveProvID() || !TouchManager.lMABX.isEmpty() && TouchManager.lMABX.contains(this.iProvinceID)) {
                            this.updateArmyWi_ALL();
                            this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Active(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                                }
                            })));
                        } else {
                            this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            } : new DrawArmyInProvince(){

                                @Override
                                public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                    CFG.core.drawProvinceArmyWithFlag_Capital(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                                }
                            })));
                        }
                    } else if (this.getCivId() > 0 && (int)CFG.core.getCivRelationOfCivB(this.getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                        this.updateArmyWi_ALL();
                        this.drawArmyInProv = this.iProvinceID == CFG.core.getActiveProvID() || !TouchManager.lMABX.isEmpty() && TouchManager.lMABX.contains(this.iProvinceID) ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        })))) : (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEGATIVE_2, nScale);
                            }
                        }))));
                    } else if (this.iProvinceID == CFG.core.getActiveProvID() || !TouchManager.lMABX.isEmpty() && TouchManager.lMABX.contains(this.iProvinceID)) {
                        this.updateArmyWi_ALL();
                        this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Active(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        })));
                    } else {
                        this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_TowerFortArmoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        } : new DrawArmyInProvince(){

                            @Override
                            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                                CFG.core.drawProvinceArmyWithFlag_Capital(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_CAPITAL_BG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        })));
                    }
                } else if (this.iProvinceID == CFG.core.getActiveProvID() || !TouchManager.lMABX.isEmpty() && TouchManager.lMABX.contains(this.iProvinceID)) {
                    this.updateArmyWi_ALL();
                    this.drawArmyInProv = this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_Active(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    })));
                } else {
                    this.drawArmyInProv = this.iProvinceID == CFG.chosenProvinceID ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
                        }
                    })))) : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == this.getCivId() ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : (this.getCivId() == 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }))))) : (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && this.getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(this.getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() ? (this.getCivsSize() > 1 ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    })))) : (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }))))) : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() != this.getCivId() && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.core.getCiv(this.getCivId()).getPuppetOfCiv() ? (this.getCivsSize() > 1 ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                        }
                    })))) : (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMY_BG_ALLIANCE, CFG.COLOR_ARMY_TEXT, nScale);
                            }
                        }
                    }))))) : (this.getCivId() > 0 && (int)CFG.core.getCivRelationOfCivB(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEGATIVE_2, nScale);
                        }
                    })))) : (this.getCivsSize() > 1 ? (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    })))) : (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    }) : (this.getLvlOfFort() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    }) : (this.getLvlOfWatchTower() > 0 ? (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    }) : (this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : (this.getCivId() == 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    }))))))))));
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (this.getLvlOfFort() > 0 && this.getLvlOfWatchTower() > 0) {
                    this.drawArmyInProv = this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvinceArmyWithFlag_TowerFort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvinceArmy_TowerFort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    };
                }
                if (this.getLvlOfFort() > 0) {
                    this.drawArmyInProv = this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Fort_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Fort(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProvArmy_Fort_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    };
                }
                if (this.getLvlOfWatchTower() > 0) {
                    this.drawArmyInProv = this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProviArmyWithFlag_Tower_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    } : new DrawArmyInProvince(){

                        @Override
                        public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                            if (Province.this.getArmyID(0) > 0) {
                                CFG.core.drawProvArmyWithFlag_Tower(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            } else {
                                CFG.core.drawProviArmy_Tower_NoArmy(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                            }
                        }
                    };
                }
                this.drawArmyInProv = this.getLvlOfArmoury() > 0 ? new DrawArmyInProvince(){

                    @Override
                    public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                        if (Province.this.getArmyID(0) > 0) {
                            CFG.core.drawProviArmyWithFlag_Armoury(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }
                } : new DrawArmyInProvince(){

                    @Override
                    public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                        if (Province.this.getArmyID(0) > 0) {
                            CFG.core.drawProvArmyWithFlag(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
                        }
                    }
                };
            }
        }
    }

    public final void updateDrawArmy_ShowsIDs() {
        this.drawArmyInProv = new DrawArmyInProvince(){

            @Override
            public void drawArmyProvince(SpriteBatch oSB, float nScale) {
                CFG.core.drawProvinceID(oSB, Province.this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
            }
        };
    }

    public final boolean isDrawArmyBlockedBySettings() {
        boolean visibilityOverride = (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR == 0) || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(this.getProvID());
        if (!visibilityOverride && CFG.FOG_OF_WAR > 0 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(this.getProvID()) && CFG.core.getCivRelationOfCivB(CFG.core.getProv(this.getProvID()).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) < (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
            return true;
        }
        return false;
    }

    public final void drawArmy(SpriteBatch oSB, float nScale) {
        this.drawArmyInProv.drawArmyProvince(oSB, nScale);
    }

    public final void drawDanger(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_Danger(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawHappiness(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_Happiness(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawStartingMoney(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_StartingMoney(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawArmyPosition_Active(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_ArmyPosition(oSB, this.iProvinceID, CFG.COLOR_ARMY_BG_ACTIVE, CFG.COLOR_ARMY_TEXT_ACTIVE, nScale);
    }

    public final void drawArmyPosition(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_ArmyPosition(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawArmyPositionSea(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_ArmyPosition(oSB, this.iProvinceID, CFG.COLOR_ARMY_BG_SEA, CFG.COLOR_ARMY_TEXT_SEA, nScale);
    }

    public final void drawArmyOptimizationRegions(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_OptimizationRegions(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawArmySeaProvincesLevels(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_SeaProvincesLevels(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final int getTrueOwnerOfProv() {
        return this.provGD.trueOwnerOfProvince;
    }

    public final void setTrueOwnerOfProv(int iTrueOwnerOfProvince) {
        this.provGD.trueOwnerOfProvince = iTrueOwnerOfProvince;
    }

    public final boolean isOccupied() {
        return this.getCivId() != this.getTrueOwnerOfProv();
    }

    public final int getCivId() {
        try {
            if (this.provGD.armiesC.get(0).getCivID() < 0) {
                if (this.getTrueOwnerOfProv() > 0) {
                    this.setCivIdJust(this.getTrueOwnerOfProv());
                    return this.getTrueOwnerOfProv();
                }
                this.setCivIdJust(0);
                return 0;
            }
            return this.provGD.armiesC.get(0).getCivID();
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final int getCivId(int i) {
        try {
            return this.provGD.armiesC.get(i).getCivID();
        }
        catch (IndexOutOfBoundsException ex) {
            return 0;
        }
    }

    public final void loadProvinceInfo(Province_Info_GameData3 tempGameData) {
        try {
            this.fPopulationGrowthRate = tempGameData.fGrowthRate;
            this.iContinentID = tempGameData.iContinentID;
            if (this.iContinentID >= CFG.map.getMapContinents().getContinentsSize()) {
                this.iContinentID = 1;
            }
            this.iRegionID = tempGameData.iRegionID;
            this.shiftX = tempGameData.iShiftX * CFG.map.getMapScale(CFG.map.getActiveMapIDN()) / CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN());
            this.shiftY = tempGameData.iShiftY * CFG.map.getMapScale(CFG.map.getActiveMapIDN()) / CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN());
            if (this.getSeaProv()) {
                this.iTerrainTypeID = 0;
                try {
                    FileHandle fileBoxes = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "army_boxes/" + this.iProvinceID);
                    String sFileBoxes = fileBoxes.readString();
                    String[] tempData = sFileBoxes.split(";");
                    this.lProvince_ArmyBoxes = new ArrayList<Province_ArmyBox>();
                    for (int i = tempData.length - 4; i >= 0; i -= 4) {
                        this.lProvince_ArmyBoxes.add(new Province_ArmyBox(Integer.parseInt(tempData[i]) * CFG.map.getMpB().getMapSc3(), Integer.parseInt(tempData[i + 1]) * CFG.map.getMpB().getMapSc3(), Integer.parseInt(tempData[i + 2]) * CFG.map.getMpB().getMapSc3(), Integer.parseInt(tempData[i + 3]) * CFG.map.getMpB().getMapSc3()));
                    }
                }
                catch (Exception fileBoxes) {}
            } else {
                this.iTerrainTypeID = CFG.terrainTypesManager.getTerrainTypeID(tempGameData.sTerrainTAG);
            }
            return;
        }
        catch (Exception ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            this.iContinentID = 1;
            this.fPopulationGrowthRate = 1.0f;
            this.iTerrainTypeID = this.getLvlOfPort() >= -1 ? 1 : 0;
            return;
        }
    }

    public final void checkLandBySeaProvinceBorders() {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (!CFG.core.getProv(this.provinceBordersLandByLand.get(i).getWithProvinceID()).getSeaProv()) continue;
            if (this.provinceBordersLandBySea == null) {
                this.provinceBordersLandBySea = new ArrayList<ProvinceBorder>();
            }
            this.provinceBordersLandBySea.add(this.provinceBordersLandByLand.get(i));
            this.provinceBordersLandByLand.remove(i);
            --i;
            this.iProviBordersLandBySeaSize = this.provinceBordersLandBySea.size();
            this.iProviBordersLandByLandSize = this.provinceBordersLandByLand.size();
        }
    }

    public final void checkSeaBySeaProvinceBorders() {
        for (int i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            if (CFG.core.getProv(this.provinceBordersSeaBySea.get(i).getWithProvinceID()).getSeaProv()) continue;
            if (this.provinceBordersLandBySea == null) {
                this.provinceBordersLandBySea = new ArrayList<ProvinceBorder>();
            }
            this.provinceBordersLandBySea.add(this.provinceBordersSeaBySea.get(i));
            this.provinceBordersSeaBySea.remove(i);
            --i;
            this.iProviBordersLandBySeaSize = this.provinceBordersLandBySea.size();
            this.iProvBordersSeaBySeaSize = this.provinceBordersSeaBySea.size();
        }
    }

    public final void loadProvinceBG() {
        block3: {
            try {
                if (!(GameValues.gvInGame.LOAD_SEA_PROVINCES_IMAGES && CFG.getIsDesktop() || !this.getSeaProv())) {
                    this.provBG = IMGManager.loadImage("UI/pixEmpty.png");
                    return;
                }
                Pixmap pixmap = PixmapIO.readCIM(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + (this.iContinentID == CFG.map.getMapContinents().getOceanContinentID() ? 1 : CFG.map.getMpB().getMapScale_PreExtra()) + "/" + this.iProvinceID));
                this.provBG = new Image(new Texture(pixmap), Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
                pixmap.dispose();
            }
            catch (GdxRuntimeException ex) {
                this.buildProvinceBG(false);
                this.loadProvinceBG();
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final Image getProvBG() {
        return this.provBG;
    }

    public final void setProvBG(Image img) {
        this.provBG = img;
    }

    public final void disposeProvinceBG() {
        if (this.provBG != null) {
            this.provBG.getTexture().dispose();
        }
    }

    public final void setBG(Pixmap pixmap) {
        this.provBG.getTexture().dispose();
        this.provBG = null;
        this.provBG = new Image(new Texture(pixmap), Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
    }

    public final void setCivIdJust(int nCivID) {
        this.provGD.armiesC.get(0).setCivID(nCivID);
        this.provGD.trueOwnerOfProvince = nCivID;
        this.fromCivID = -1;
    }

    public final void setCivId_LoadScenario(int nCivID) {
        if (nCivID != 0) {
            this.fromCivID = this.provGD.armiesC.get(0).getCivID();
            this.updateColorTime = true;
        }
        this.provGD.armiesC.get(0).setCivID(nCivID);
        this.provGD.trueOwnerOfProvince = nCivID;
    }

    public final void setCivId(int nCivID, boolean conquered) {
        this.setCivId(nCivID, conquered, true);
    }

    private final List<Integer> getUpdateView_SetCivID(int oldOwner) {
        ArrayList<Integer> tPlayers = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getPlayer(i).getCivId() != this.getCivId() && CFG.core.getPlayer(i).getCivId() != CFG.core.getCiv(this.getCivId()).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getPuppetOfCiv() != this.getCivId() && (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance() != CFG.core.getCiv(this.getCivId()).getAlliance()) && CFG.core.getPlayer(i).getCivId() != oldOwner && CFG.core.getPlayer(i).getCivId() != CFG.core.getCiv(oldOwner).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getPuppetOfCiv() != oldOwner && (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance() != CFG.core.getCiv(oldOwner).getAlliance())) continue;
            tPlayers.add(i);
        }
        return tPlayers;
    }

    public final void updateProvinceBorder() {
        if (CFG.FOG_OF_WAR == 2) {
            for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
                try {
                    Province provinceNeighI = CFG.core.getProv(this.getNeighProvinces(i));
                    if (CFG.getMetProv(this.getProvID()) && CFG.getMetProv(this.getNeighProvinces(i))) {
                        if (this.getWastelandLvl() >= 0 || provinceNeighI.getWastelandLvl() >= 0) {
                            this.setWastelandLvl(this.getWastelandLvl());
                            provinceNeighI.setWastelandLvl(provinceNeighI.getWastelandLvl());
                            continue;
                        }
                        if (this.getProvID() < this.getNeighProvinces(i)) {
                            this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder(this.getCivId() != provinceNeighI.getCivId(), this.getProvID());
                            continue;
                        }
                        provinceNeighI.getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder(this.getCivId() != provinceNeighI.getCivId(), this.getProvID());
                        continue;
                    }
                    if (this.getWastelandLvl() < 0) {
                        if (provinceNeighI.getWastelandLvl() < 0) {
                            if (this.getProvID() < this.getNeighProvinces(i)) {
                                this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder(CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i)), this.getProvID());
                                continue;
                            }
                            provinceNeighI.getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder(CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i)), this.getProvID());
                            continue;
                        }
                        if (this.getProvID() < this.getNeighProvinces(i)) {
                            this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder(CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i)), this.getProvID());
                            continue;
                        }
                        provinceNeighI.getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder(CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i)), this.getProvID());
                        continue;
                    }
                    this.setWastelandLvl(this.getWastelandLvl());
                    if (provinceNeighI.getWastelandLvl() < 0) continue;
                    provinceNeighI.setWastelandLvl(provinceNeighI.getWastelandLvl());
                    continue;
                }
                catch (Exception ex) {
                    Province provinceNeighI = CFG.core.getProv(this.getNeighProvinces(i));
                    if (this.getProvID() < this.getNeighProvinces(i)) {
                        this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder(this.getCivId() != provinceNeighI.getCivId(), this.getProvID());
                    } else {
                        provinceNeighI.getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder(this.getCivId() != provinceNeighI.getCivId(), this.getProvID());
                    }
                    CFG.exceptionStack(ex);
                }
            }
        } else {
            for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
                if (this.getProvID() < this.getNeighProvinces(i)) {
                    this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder(this.getCivId() != CFG.core.getProv(this.getNeighProvinces(i)).getCivId(), this.getProvID());
                    continue;
                }
                CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder(this.getCivId() != CFG.core.getProv(this.getNeighProvinces(i)).getCivId(), this.getProvID());
            }
        }
    }

    public final void updateProviBorder_OwnerAnimation() {
        for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
            if (this.getProvID() < this.getNeighProvinces(i)) {
                this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_OwnerAnimation(this.getCivId() != CFG.core.getProv(this.getNeighProvinces(i)).getCivId(), this.getProvID());
                continue;
            }
            CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_OwnerAnimation(this.getCivId() != CFG.core.getProv(this.getNeighProvinces(i)).getCivId(), this.getProvID());
        }
    }

    public final void addCiv(int iCivID, long iArmy) {
        this.provGD.armiesC.add(new Province_Army(iCivID, iArmy, this.getProvID()));
        this.provGD.civsSize = this.provGD.armiesC.size();
        if (this.getCivsSize() > 1 && iArmy > 0) {
            CFG.core.getCiv(iCivID).addArmyInAnotherProv(this.getProvID());
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (!CFG.core.isPlayerAlly_FogOfWarCheck(CFG.core.getPlayer(i).getCivId(), iCivID)) continue;
                this.updateFogOfWar(i);
            }
            this.updateDrawArmyInProv();
        }
    }

    public final void removeCiv(int i) {
        this.provGD.armiesC.remove(i);
        this.provGD.civsSize = this.provGD.armiesC.size();
        this.updateDrawArmyInProv();
    }

    public final void build_ArmyInAnotherProvince() {
        if (this.getCivsSize() > 1) {
            for (int i = 1; i < this.getCivsSize(); ++i) {
                CFG.core.getCiv(this.getCivId(i)).addArmyInAnotherProv(this.getProvID());
            }
        }
    }

    public final void addArmy(int iCivID, long iArmy) {
        this.addCiv(iCivID, iArmy);
    }

    public final void resetArmiesAll(long iArmy) {
        int nCivID = this.getCivId();
        for (int i = 0; i < this.provGD.armiesC.size(); ++i) {
            CFG.core.getCiv(this.provGD.armiesC.get(i).getCivID()).setNumberOfUnits(CFG.core.getCiv(this.provGD.armiesC.get(i).getCivID()).getNumberOfUnits() - this.provGD.armiesC.get(i).getArmy());
        }
        this.provGD.armiesC.clear();
        this.provGD.armiesC.add(new Province_Army(nCivID, iArmy, this.getProvID()));
        this.provGD.civsSize = this.provGD.armiesC.size();
        this.provGD.defPositionTurns = -1;
    }

    public final void resetArmiesNewGame(int iArmy) {
        int nCivID = this.getCivId();
        this.provGD.armiesC.clear();
        this.provGD.armiesC.add(new Province_Army(nCivID, iArmy, this.getProvID()));
        this.provGD.civsSize = this.provGD.armiesC.size();
        this.provGD.defPositionTurns = -1;
    }

    public final void updateArmy4(long iArmy) {
        try {
            this.provGD.armiesC.get(0).setArmy(iArmy, this.getProvID());
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void updateArmy4(int iCivID, long iArmy) {
        try {
            if (iArmy <= 0 && iCivID != this.provGD.armiesC.get(0).getCivID()) {
                this.removeArmy(iCivID);
                if (iCivID >= 0) {
                    CFG.core.getCiv(iCivID).updateNumberOfUnits();
                }
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (int i = 0; i < this.provGD.civsSize; ++i) {
                if (this.provGD.armiesC.get(i).getCivID() != iCivID) continue;
                this.provGD.armiesC.get(i).setArmy(iArmy, this.getProvID());
                if (iCivID >= 0) {
                    CFG.core.getCiv(iCivID).updateNumberOfUnits();
                }
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            this.addArmy(iCivID, iArmy);
            if (iCivID >= 0) {
                CFG.core.getCiv(iCivID).updateNumberOfUnits();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void drawBuildings(SpriteBatch oSB, float nScale) {
        int tCenterX = (int)((float)(this.getCeX() + this.getShPX() + this.getTranslateProvPosX()) * nScale);
        int tCenterY = (int)((float)(this.getCeY() + this.getShPY() + CFG.map.getMpC().getPY()) * nScale);
        CFG.core.drawProvinceBuildings(oSB, tCenterX, tCenterY, this.iProvinceID);
    }

    public final void drawArmy_SetUpArmy_Sea(SpriteBatch oSB, float nScale) {
        int tCenterX = (int)((float)(this.getCeX() + this.getShPX() + this.getTranslateProvPosX()) * nScale);
        int tCenterY = (int)((float)(this.getCeY() + this.getShPY() + CFG.map.getMpC().getPY()) * nScale);
        CFG.core.drawProvinceArmy_Sea(oSB, this.iProvinceID, CFG.COLOR_ARMY_TEXT_SEA, nScale, tCenterX, tCenterY);
    }

    public final void drawArmy_SetUpArmy(SpriteBatch oSB, float nScale) {
        if (this.getCivsSize() > 1 || this.isCapital()) {
            CFG.core.drawProvArmyWithFlag(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
        } else if (this.getArmyID(0) > 0) {
            CFG.core.drawProvinceArmy(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
        }
    }

    public final void drawGrowthRate(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_GrowthRate(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawTechnologyLevels(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_TechnologyLevels(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void drawPotential(SpriteBatch oSB, float nScale) {
        CFG.core.drawProvince_Potential(oSB, this.iProvinceID, CFG.COLOR_ARMYBG, CFG.COLOR_NEUTRAL2, nScale);
    }

    public final void removeArmy(int iCivID) {
        for (int i = 0; i < this.provGD.civsSize; ++i) {
            if (this.provGD.armiesC.get(i).getCivID() != iCivID) continue;
            this.removeCiv(i);
            CFG.core.getCiv(iCivID).removeArmyInAnotherProvinP(this.iProvinceID);
            for (int j = 0; j < CFG.core.getPlayersSize(); ++j) {
                if (!CFG.core.isPlayerAlly_FogOfWarCheck(CFG.core.getPlayer(j).getCivId(), iCivID)) continue;
                this.updateFogOfWar(j);
            }
            break;
        }
    }

    public final void removeArmies() {
        for (int i = this.provGD.civsSize - 1; i > 0; --i) {
            this.provGD.armiesC.remove(i);
            this.provGD.civsSize = this.provGD.armiesC.size();
        }
        this.updateDrawArmyInProv();
    }

    public final void removeArmy_ID(int nID) {
        block2: {
            try {
                CFG.core.getCiv(this.getCivId(nID)).removeArmyInAnotherProvinP(this.iProvinceID);
                this.removeCiv(nID);
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block2;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void addCity(City oCity) {
        this.cities.add(oCity);
        this.citiesSize = this.cities.size();
    }

    public final void addCityRename(City oCity) {
        this.cities.add(oCity);
        this.citiesSize = this.cities.size();
        this.setName2(oCity.getCityName());
    }

    public final City getCit(int i) {
        return this.cities.get(i);
    }

    public final int getCitSize() {
        return this.citiesSize;
    }

    public final void clearCities() {
        this.cities = new ArrayList<City>();
        this.citiesSize = 0;
    }

    public final boolean getDrawCitiesInProv() {
        return this.drawCitiesInProv;
    }

    public final void setDrawCitiesInProv(boolean drawCitiesInProv) {
        this.drawCitiesInProv = drawCitiesInProv;
    }

    public final void addMountain(Mountain oMountain) {
        this.mountains.add(oMountain);
    }

    public final Mountain getMountain(int i) {
        return this.mountains.get(i);
    }

    public final int getMountainsSize() {
        return this.mountains.size();
    }

    public final void addWonder(Wonder oWonder) {
        this.wonders.add(oWonder);
        this.iWondersSize = this.wonders.size();
    }

    public final Wonder getWonder(int i) {
        return this.wonders.get(i);
    }

    public final void clearWonders() {
        this.wonders.clear();
    }

    public final int getWonderSize() {
        return this.iWondersSize;
    }

    public final int getLvlOfPort() {
        return this.provGD.iPort;
    }

    public final void setLvlOfFort(int iFort) {
        this.provGD.iFort = iFort;
    }

    public final void setLvlOfWatchTower(int iWatchTower) {
        this.provGD.iWatchTower = iWatchTower;
    }

    public final int getLvlOfWatchTower() {
        return this.provGD.iWatchTower;
    }

    public final int getLvlOfFort() {
        return this.provGD.iFort;
    }

    public final boolean isCapital() {
        return this.provGD.isCapital && CFG.core.getCiv(this.getCivId()).getCapitalProvID() == this.getProvID();
    }

    public final boolean getIsCapital2() {
        return CFG.core.getCiv(this.getCivId()).getCapitalProvID() == this.getProvID();
    }

    public final boolean getIsCapital_Just() {
        return this.provGD.isCapital;
    }

    public final void setIsCapital(boolean isCapital) {
        this.provGD.isCapital = isCapital;
    }

    public final void removeCapitalCityIcon() {
        for (int i = 0; i < this.getCitSize(); ++i) {
            if (this.getCit(i).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
            this.getCit(i).setCityLevel(CFG.getEditorCityLevel(1));
        }
    }

    public final Province_Population getPop() {
        return this.provGD.pops;
    }

    public final void setPopsData(Province_Population nProvince_Population) {
        this.provGD.pops = nProvince_Population;
    }

    public final void buildProvinceCore() {
        this.provGD.oProvinceCore = null;
        this.provGD.oProvinceCore = new Province_Core();
        if (this.getCivId() > 0) {
            this.provGD.oProvinceCore.addNewCore(this.getCivId(), GameCalendar.TURNID);
            this.provGD.oProvinceCore.increaseOwnership(this.getCivId(), this.getProvID());
        }
    }

    public final void resetCore() {
        this.provGD.oProvinceCore = null;
        this.provGD.oProvinceCore = new Province_Core();
    }

    public final Province_Core getCores() {
        return this.provGD.oProvinceCore;
    }

    public final Province_Claims getClaims() {
        if (this.provGD.oProvinceClaims == null) {
            this.provGD.oProvinceClaims = new Province_Claims();
        }
        return this.provGD.oProvinceClaims;
    }

    public final void buildProvinceClaims() {
        this.provGD.oProvinceClaims = null;
        this.provGD.oProvinceClaims = new Province_Claims();
    }

    public final void resetClaims() {
        this.provGD.oProvinceClaims = null;
        this.provGD.oProvinceClaims = new Province_Claims();
    }

    public final void updateProvincePopulationLosses(int nLosses, float fLossesModifier) {
        nLosses = (int)Math.ceil((float)nLosses * fLossesModifier);
        long nStartPopulation = this.getPop().getPops();
        if (this.getPop().getPops() > GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE) {
            for (int i = 0; i < this.getPop().getNatsSize(); ++i) {
                this.getPop().setPopulationOfCivID(this.getPop().getCivID(i), (int)Math.ceil((float)this.getPop().getPopulationID(i) - (float)this.getPop().getPopulationID(i) / (float)nStartPopulation * (float)nLosses));
            }
        }
    }

    public final void updateProvinceEconomyLosses(long nLosses, float fLossesModifier) {
        nLosses = (int)Math.ceil((float)nLosses * fLossesModifier);
        nLosses = (int)Math.min((float)this.getEco() * GameValues.gvBattle.BATTLE_PROVINCE_ECONOMY_LOSSES_MAX_PERC, (float)nLosses);
        this.setEco((int)Math.max((float)GameValues.gvEconomy.ECONOMY_MIN, (float)this.getEco() - (float)nLosses));
    }

    public final long getEco() {
        return (int)this.provGD.economy;
    }

    public final void setEco(long iEconomy) {
        this.provGD.economy = iEconomy;
        if (this.provGD.economy < GameValues.gvEconomy.ECONOMY_MIN) {
            this.provGD.economy = GameValues.gvEconomy.ECONOMY_MIN;
        }
    }

    public final int getProvID() {
        return this.iProvinceID;
    }

    public final void initProvinceArmyBoxes() {
        if (this.lProvince_ArmyBoxes == null) {
            this.lProvince_ArmyBoxes = new ArrayList<Province_ArmyBox>();
        }
    }

    public final List<Province_ArmyBox> getProvinceArmyBoxes() {
        return this.lProvince_ArmyBoxes;
    }

    public final void setProvinceArmyBoxes(List<Province_ArmyBox> nSet) {
        this.lProvince_ArmyBoxes = nSet;
    }

    public final boolean getIsSupplied() {
        try {
            return CFG.core.getCiv(this.getCivId()).getCivRegion(this.getCivRegionID()).getIsSupplied();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return true;
        }
    }

    public final Province_SupportRebels_Help addSupportRebels(Province_SupportRebels nData) {
        for (int i = this.provGD.iSupportRebelsSize - 1; i >= 0; --i) {
            if (this.provGD.lSupportRebels.get((int)i).iByCivID != nData.iByCivID || this.provGD.lSupportRebels.get((int)i).iRebelsCivID != nData.iRebelsCivID) continue;
            if (this.provGD.lSupportRebels.get((int)i).iTurnsLeft + nData.iTurnsLeft > GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX) {
                int out = GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX - this.provGD.lSupportRebels.get((int)i).iTurnsLeft;
                this.provGD.lSupportRebels.get((int)i).iTurnsLeft = GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX;
                return new Province_SupportRebels_Help(out, true);
            }
            this.provGD.lSupportRebels.get((int)i).iTurnsLeft += nData.iTurnsLeft;
            return new Province_SupportRebels_Help(nData.iTurnsLeft, true);
        }
        this.provGD.lSupportRebels.add(nData);
        this.provGD.iSupportRebelsSize = this.provGD.lSupportRebels.size();
        return new Province_SupportRebels_Help(nData.iTurnsLeft, nData.iTurnsLeft >= GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX);
    }

    public final void runSupportRebels() {
        ArrayList<Integer> runCivs = new ArrayList<Integer>();
        for (int i = this.provGD.iSupportRebelsSize - 1; i >= 0; --i) {
            if (CFG.core.getCiv(this.provGD.lSupportRebels.get((int)i).iRebelsCivID).getNumOfProvs() > 0) {
                this.provGD.lSupportRebels.remove(i);
                this.provGD.iSupportRebelsSize = this.provGD.lSupportRebels.size();
                continue;
            }
            --this.provGD.lSupportRebels.get((int)i).iTurnsLeft;
            boolean alreadyDone = false;
            for (int k = runCivs.size() - 1; k >= 0; --k) {
                if (this.provGD.lSupportRebels.get((int)i).iRebelsCivID != (Integer)runCivs.get(k)) continue;
                alreadyDone = true;
                break;
            }
            if (!alreadyDone) {
                runCivs.add(this.provGD.lSupportRebels.get((int)i).iRebelsCivID);
                int iNumOfSupporters = 0;
                for (int k = this.provGD.iSupportRebelsSize - 1; k >= 0; --k) {
                    if (this.provGD.lSupportRebels.get((int)k).iRebelsCivID != this.provGD.lSupportRebels.get((int)i).iRebelsCivID) continue;
                    ++iNumOfSupporters;
                }
                int popToAssimilate = 0;
                long ownerPop = 1 + this.getPop().getPopulationOfCivID(this.provGD.lSupportRebels.get((int)i).iRebelsCivID);
                for (int j = 0; j < this.getPop().getNatsSize(); ++j) {
                    if (this.getPop().getCivID(j) == this.provGD.lSupportRebels.get((int)i).iRebelsCivID) continue;
                    popToAssimilate += this.getPop().getPopulationID(j);
                }
                int assimilatedPop = 0;
                int tCurrentPopChange = 0;
                for (int j = this.getPop().getNatsSize() - 1; j >= 0; --j) {
                    if (this.getPop().getCivID(j) == this.provGD.lSupportRebels.get((int)i).iRebelsCivID) continue;
                    float tPerc = (GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_BASE_POPULATION + (GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_BASE_RANDOM + (float)CFG.oR.nextInt(GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_RANDOM_OF_10000) / 10000.0f) * ((float)ownerPop / (float)(popToAssimilate + ownerPop)) * Math.max(GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_MIN_HAPPINESS_MODIFIER, 1.0f - this.getHappi() * GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_HAPPINESS_MODIFIER) * Math.max(GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_MIN_DEVELOPMENT_MODIFIER, Math.min(1.0f - this.getDeveLvl() * GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_DEVELOPMENT_MODIFIER, 1.0f))) * (1.0f + GameValues.gvRebelsSupport.SUPPORT_REBELS_RUN_PER_REV_RISK_MODIFIER * this.getRevRisk());
                    tCurrentPopChange = (int)((float)this.getPop().getPopulationID(j) * (tPerc *= GameManager.getSUPPORT_REBELS_ASSIMILATE_PERC(iNumOfSupporters)));
                    if (tCurrentPopChange == 0) {
                        tCurrentPopChange = CFG.oR.nextInt(2);
                    }
                    assimilatedPop += tCurrentPopChange;
                    this.getPop().setPopulationOfCivID(this.getPop().getCivID(j), this.getPop().getPopulationID(j) - tCurrentPopChange);
                }
                this.getPop().setPopulationOfCivID(this.provGD.lSupportRebels.get((int)i).iRebelsCivID, this.getPop().getPopulationOfCivID(this.provGD.lSupportRebels.get((int)i).iRebelsCivID) + assimilatedPop);
            }
            if (this.provGD.lSupportRebels.get((int)i).iTurnsLeft > 0) continue;
            this.provGD.lSupportRebels.remove(i);
            this.provGD.iSupportRebelsSize = this.provGD.lSupportRebels.size();
        }
    }

    public final float getDeveLvl() {
        return this.provGD.fDevLevel;
    }

    public final void setDevLvl(float nDevelopmentLevel) {
        this.provGD.fDevLevel = nDevelopmentLevel;
        if (this.provGD.fDevLevel > CFG.core.getCiv(this.getCivId()).getTechLevel()) {
            this.provGD.fDevLevel = CFG.core.getCiv(this.getCivId()).getTechLevel();
        } else if (this.provGD.fDevLevel < 0.01f) {
            this.provGD.fDevLevel = 0.01f;
        }
    }

    public final float getHappi() {
        return this.provGD.fHappiness;
    }

    public final void setHappi(float nHappiness) {
        this.provGD.fHappiness = nHappiness;
        if (this.provGD.fHappiness > GameValues.gvHappiness.HAPPINESS_MAX) {
            this.provGD.fHappiness = GameValues.gvHappiness.HAPPINESS_MAX;
        } else if (this.provGD.fHappiness < GameValues.gvHappiness.HAPPINESS_MIN) {
            this.provGD.fHappiness = GameValues.gvHappiness.HAPPINESS_MIN;
        }
    }

    public final float getRevRisk() {
        return this.provGD.fRevolutionaryRisk;
    }

    public final void setRevRisk(float nRevolutionaryRisk) {
        this.provGD.fRevolutionaryRisk = nRevolutionaryRisk > GameValues.gvRevolutionaryRisk.REV_RISK_MAX ? GameValues.gvRevolutionaryRisk.REV_RISK_MAX : (nRevolutionaryRisk < 0.0f ? 0.0f : nRevolutionaryRisk);
    }

    public final int getMiX2() {
        return this.miX * CFG.map.getMpB().getMapSc3();
    }

    public final int getMaX7() {
        return this.maX * CFG.map.getMpB().getMapSc3();
    }

    public final int getMiY4() {
        return this.miY * CFG.map.getMpB().getMapSc3();
    }

    public final int getMaY6() {
        return this.maY * CFG.map.getMpB().getMapSc3();
    }

    public final int getPoX9(int i) {
        return this.pointsX.get(i) * CFG.map.getMpB().getMapSc3();
    }

    public final int getPoY2(int i) {
        return this.pointsY.get(i) * CFG.map.getMpB().getMapSc3();
    }

    public final void setPoints(List<Short> nPointsX, List<Short> nPointsY) {
        int i;
        this.pointsX.clear();
        this.pointsY.clear();
        for (i = 0; i < nPointsX.size(); ++i) {
            this.pointsX.add((short)nPointsX.get(i));
            this.pointsY.add((short)nPointsY.get(i));
        }
        this.pointsSize = this.pointsX.size();
        short s = this.pointsX.get(0);
        this.maX = s;
        this.miX = s;
        short s2 = this.pointsY.get(0);
        this.maY = s2;
        this.miY = s2;
        int iSize = this.pointsX.size();
        for (i = 0; i < iSize; ++i) {
            if (this.miX > this.pointsX.get(i)) {
                this.miX = this.pointsX.get(i).shortValue();
            }
            if (this.maX < this.pointsX.get(i)) {
                this.maX = this.pointsX.get(i).shortValue();
            }
            if (this.miY > this.pointsY.get(i)) {
                this.miY = this.pointsY.get(i).shortValue();
            }
            if (this.maY >= this.pointsY.get(i)) continue;
            this.maY = this.pointsY.get(i).shortValue();
        }
    }

    public final int getCeShX() {
        return (this.ceX + this.shiftX) * CFG.map.getMpB().getMapSc3();
    }

    public final int getCeShY() {
        return (this.ceY + this.shiftY) * CFG.map.getMpB().getMapSc3();
    }

    public final int getCeX() {
        return this.ceX * CFG.map.getMpB().getMapSc3();
    }

    public final int getCeY() {
        return this.ceY * CFG.map.getMpB().getMapSc3();
    }

    public final int getCeXR() {
        return this.ceX;
    }

    public final int getCeYR() {
        return this.ceY;
    }

    public final int getShPX() {
        return this.shiftX;
    }

    public final int getShPY() {
        return this.shiftY;
    }

    public final int getPointsSize() {
        return this.pointsSize;
    }

    public final int getNeighProvincesSize() {
        return this.neighboringProvincesSize;
    }

    public final int getNeighSeaProvincesSize() {
        return this.neighboringSeaProvincesSize;
    }

    public final void addNeighboringProv(int nProvinceID) {
        this.lNeighboringProvinces.add((short)nProvinceID);
        this.neighboringProvincesSize = this.lNeighboringProvinces.size();
    }

    public final void removeNeighboringProv(int nProvinceID) {
        for (int i = 0; i < this.neighboringProvincesSize; ++i) {
            if (nProvinceID != this.getNeighProvinces(i)) continue;
            this.lNeighboringProvinces.remove(i);
            this.neighboringProvincesSize = this.lNeighboringProvinces.size();
            return;
        }
    }

    public final int getBasinID() {
        return this.iBasin;
    }

    public final void setBasin(int iBasin) {
        this.iBasin = iBasin;
    }

    public final void addNeighboringSeaProvince(int nProvinceID) {
        this.lNeighboringSeaProvinces.add((short)nProvinceID);
        this.neighboringSeaProvincesSize = this.lNeighboringSeaProvinces.size();
    }

    public final void removeNeighboringSeaProvince(int nProvinceID) {
        for (int i = 0; i < this.neighboringSeaProvincesSize; ++i) {
            if (nProvinceID != this.getNeighSeaProvinces(i)) continue;
            this.lNeighboringSeaProvinces.remove(i);
            this.neighboringSeaProvincesSize = this.lNeighboringSeaProvinces.size();
            return;
        }
    }

    public final int getNeighProvinces(int i) {
        return this.lNeighboringProvinces.get(i).shortValue();
    }

    public final int getNeighSeaProvinces(int i) {
        return this.lNeighboringSeaProvinces.get(i).shortValue();
    }

    public final boolean getIsBelowZero() {
        return this.isBelowZeroPosX;
    }

    public final List<ProvinceBorder> getProvBordersLandByLand() {
        return this.provinceBordersLandByLand;
    }

    public final ProvinceBorder getProvBordersLandByLand(int withProvinceID) {
        for (int i = 0; i < this.iProviBordersLandByLandSize; ++i) {
            if (withProvinceID != this.provinceBordersLandByLand.get(i).getWithProvinceID()) continue;
            return this.provinceBordersLandByLand.get(i);
        }
        return new ProvinceBorder(0, new ArrayList<Short>(), new ArrayList<Short>());
    }

    public final List<ProvinceBorder> getProvBordersLandBySea() {
        return this.provinceBordersLandBySea;
    }

    public final long getArmyCivID1(int nCivID) {
        long out = 0L;
        for (int i = 0; i < this.provGD.civsSize; ++i) {
            if (this.provGD.armiesC.get(i).getCivID() == nCivID) {
                out += this.provGD.armiesC.get(i).getArmy();
            }
        }
        return out;
    }

    public final int getArmyWidth1(int nCivID) {
        for (int i = 0; i < this.provGD.civsSize; ++i) {
            if (this.provGD.armiesC.get(i).getCivID() == nCivID) {
                return this.provGD.armiesC.get(i).getArmyWidth();
            }
        }
        return 0;
    }

    public final String getArmyCivIDS(int nCivID) {
        for (int i = 0; i < this.provGD.civsSize; ++i) {
            if (this.provGD.armiesC.get(i).getCivID() != nCivID) continue;
            return this.provGD.armiesC.get(i).getArmyS();
        }
        return "0";
    }

    public final ProvinceBorder getProvBordersSeaBySea(int withProvinceID) {
        for (int i = 0; i < this.iProvBordersSeaBySeaSize; ++i) {
            if (withProvinceID != this.provinceBordersSeaBySea.get(i).getWithProvinceID()) continue;
            return this.provinceBordersSeaBySea.get(i);
        }
        return new ProvinceBorder(0, new ArrayList<Short>(), new ArrayList<Short>());
    }

    public final int getTranslateProvPosX() {
        return this.iTranslateProvincePosX;
    }

    public final void setTranslateProvPosX(int iTranslateProvincePosX) {
        this.iTranslateProvincePosX = iTranslateProvincePosX;
    }

    public final boolean getDrawProv() {
        return this.drawProvince;
    }

    public final void setDrawProv(boolean drawProvince) {
        this.drawProvince = drawProvince;
    }

    public final int getCivsSize() {
        return this.provGD.civsSize;
    }

    public final int getDisplayTimerTurns() {
        int occTurns = this.getOccupationTurnsLeft();
        if (occTurns > 0) return occTurns;
        return GameManager.getGenocideTurnsLeft(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getProvID());
    }

    public final int getArmyWi(int i) {
        int out = Math.max(1, (int)((float)this.provGD.armiesC.get(i).getArmyWidth() * CFG.armyDrawScale));
        if (i == 0 && this.getDisplayTimerTurns() > 0) {
            CFG.glyphLay.setText(CFG.fontArmy, "" + this.getDisplayTimerTurns());
            float tIconScale = (float)CFG.ARMY_HEIGHT * 0.7f / (float)IMGManager.getIMG(Images.time).getHeight();
            int tIconWidth = (int)((float)IMGManager.getIMG(Images.time).getWidth() * tIconScale);
            out += tIconWidth + Math.max(1, (int)((float)CFG.glyphLay.width * CFG.armyDrawScale)) + CFG.ARMY_BG_EXTRA_WIDTH;
        }
        return out;
    }

    public final int getArmyWi_NO_TIMER(int i) {
        return Math.max(1, (int)((float)this.provGD.armiesC.get(i).getArmyWidth() * CFG.armyDrawScale));
    }

    public final void updateArmyWi(int i) {
        this.provGD.armiesC.get(i).updateArmyWidth_Just(i);
    }

    public final void updateArmyWi_ALL() {
        try {
            if (CFG.menus.getInGameView()) {
                CFG.core.addLoadArmiesWidth_ErrorIDs(this.getProvID());
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final Province_Army getArmyObject(int i) {
        return this.provGD.armiesC.get(i);
    }

    public final long getArmyID(int i) {
        return this.provGD.armiesC.get(i).getArmy();
    }

    public final String getArmyS(int i) {
        return this.provGD.armiesC.get(i).getArmyS();
    }

    public final int getProvinceBordersLandByLandSize() {
        return this.iProviBordersLandByLandSize;
    }

    public final int getProvinceBordersLandBySeaSize() {
        return this.iProviBordersLandBySeaSize;
    }

    public final int getProvinceBordersSeaBySeaSize() {
        return this.iProvBordersSeaBySeaSize;
    }

    public final void setShiftArmyX(int iShiftArmyX) {
        this.shiftX = iShiftArmyX;
    }

    public final void setShiftArmyY(int iShiftArmyY) {
        this.shiftY = iShiftArmyY;
    }

    public final boolean getSeaProv() {
        return this.seaProvince;
    }

    public final void setFromCivID(int iFromCivID) {
        this.fromCivID = iFromCivID;
        this.updateColorTime = true;
    }

    public final int getContinent() {
        return this.iContinentID;
    }

    public final void setContinent(int iContinentID) {
        this.iContinentID = iContinentID;
    }

    public final int getRegion() {
        return this.iRegionID;
    }

    public final void setRegion(int iRegionID) {
        this.iRegionID = iRegionID;
    }

    public final int getWastelandLvl() {
        return this.provGD.wastelandLevel;
    }

    public final void setWastelandLvl(int wastelandLevel) {
        this.provGD.wastelandLevel = wastelandLevel;
        for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
            if (this.getProvID() < this.getNeighProvinces(i)) {
                if (!CFG.getMetProv(this.getProvID()) || !CFG.getMetProv(this.getNeighProvinces(i))) {
                    if (CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i))) {
                        this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_Just(true, this.getNeighProvinces(i));
                    } else {
                        this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_Just(false, this.getNeighProvinces(i));
                    }
                } else if (wastelandLevel >= 0) {
                    this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_Just(CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() < 0, this.getNeighProvinces(i));
                } else if (CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() >= 0) {
                    this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_Just(true, this.getNeighProvinces(i));
                } else {
                    this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsCivilizationBorder_Just(CFG.core.getProv(this.getNeighProvinces(i)).getCivId() != CFG.core.getProv(this.getProvID()).getCivId(), this.getNeighProvinces(i));
                }
                if (!CFG.getMetProv(this.getProvID()) || !CFG.getMetProv(this.getNeighProvinces(i))) {
                    this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsWastelandBorder(false, this.getProvID());
                    continue;
                }
                this.getProvBordersLandByLand(this.getNeighProvinces(i)).setIsWastelandBorder(wastelandLevel >= 0 || CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() >= 0, this.getProvID());
                continue;
            }
            if (!CFG.getMetProv(this.getProvID()) || !CFG.getMetProv(this.getNeighProvinces(i))) {
                if (CFG.getMetProv(this.getProvID()) || CFG.getMetProv(this.getNeighProvinces(i))) {
                    CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_Just(true, this.getNeighProvinces(i));
                } else {
                    CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_Just(false, this.getNeighProvinces(i));
                }
            } else if (wastelandLevel >= 0) {
                CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_Just(CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() < 0, this.getNeighProvinces(i));
            } else if (CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() >= 0) {
                CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_Just(true, this.getNeighProvinces(i));
            } else {
                CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsCivilizationBorder_Just(CFG.core.getProv(this.getNeighProvinces(i)).getCivId() != CFG.core.getProv(this.getProvID()).getCivId(), this.getNeighProvinces(i));
            }
            if (!CFG.getMetProv(this.getProvID()) || !CFG.getMetProv(this.getNeighProvinces(i))) {
                CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsWastelandBorder(false, this.getProvID());
                continue;
            }
            CFG.core.getProv(this.getNeighProvinces(i)).getProvBordersLandByLand(this.getProvID()).setIsWastelandBorder(wastelandLevel >= 0 || CFG.core.getProv(this.getNeighProvinces(i)).getWastelandLvl() >= 0, this.getProvID());
        }
        CFG.core.setuPRV(true);
    }

    public final String getName() {
        if (this.provinceName.isEmpty() && this.getCitSize() > 0) {
            return this.getCit(0).getCityName();
        }
        return this.provinceName;
    }

    public final String getProvName() {
        if (this.provinceName.isEmpty() && this.getCitSize() > 0) {
            return this.getCit(0).getCityName();
        }
        return this.provinceName;
    }

    public final String getProvNameUpperCase() {
        return this.sProvinceNameUpperCase;
    }

    public final void buildProvinceName() {
        if (this.provinceName.length() > 0) {
            this.provinceName = this.provinceName;
        } else if (this.getCitSize() > 0) {
            this.provinceName = this.getCit(0).getCityName();
        } else {
            try {
                this.provinceName = CFG.randomProvinceNames.get(CFG.oR.nextInt(CFG.randomProvinceNames.size()));
            }
            catch (Exception ex) {
                this.provinceName = "Province";
            }
        }
        this.sProvinceNameUpperCase = this.provinceName.toUpperCase();
        this.iProvinceNameLength_Minus1 = this.sProvinceNameUpperCase.length() - 1;
    }

    public final void setName(String sProvinceName) {
        this.provinceName = sProvinceName;
    }

    public final void setName2(String sProvinceName) {
        this.provinceName = sProvinceName;
        this.sProvinceNameUpperCase = sProvinceName.toUpperCase();
        this.iProvinceNameLength_Minus1 = this.sProvinceNameUpperCase.length() - 1;
        try {
            PNM.bPND(this.getProvID(), true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void setCivId(int nCivID, boolean conquered, boolean isInGame) {
        if (nCivID == this.getCivId()) {
            return;
        }
        int oldCivID = this.getCivId();
        try {
            if (oldCivID >= 0) {
                CFG.core.getCiv(oldCivID).updateNumberOfUnits();
            }
            if (nCivID >= 0) {
                CFG.core.getCiv(nCivID).updateNumberOfUnits();
                CFG.core.getCiv(nCivID).civGD.iTurnsSinceLastAttack = 100;
            }
        } catch (Exception ex) {}
        block31: {
            try {
                if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getProvID())) {
                    this.fromCivID = -1;
                } else if (nCivID != 0) {
                    this.fromCivID = this.provGD.armiesC.get(0).getCivID();
                    this.updateColorTime = true;
                }
            }
            catch (NullPointerException ex) {
                if (nCivID != 0) {
                    this.fromCivID = this.provGD.armiesC.get(0).getCivID();
                    this.updateColorTime = true;
                }
                if (!CFG.LOGs) break block31;
                CFG.exceptionStack(ex);
            }
        }
        oldCivID = this.provGD.armiesC.get(0).getCivID();
        this.provGD.armiesC.get(0).setCivID(nCivID);
        CFG.core.updateSortedPIV = true;
        ProvinceMesh.markDirty(this.getProvID());
        if (oldCivID != 0) {
            CFG.core.getCiv(oldCivID).removeProv(this.getProvID());
            CFG.core.getCiv(oldCivID).setUpdateRegions(true);
        } else {
            this.setTrueOwnerOfProv(nCivID);
        }
        if (nCivID != 0) {
            CFG.core.getCiv(nCivID).addProv(this.getProvID());
            CFG.core.getCiv(nCivID).setUpdateRegions(true);
        }
        this.updateProviBorder_OwnerAnimation();
        this.updateDrawArmyInProv();
        CFG.core.updateAliveCivStatus(oldCivID);
        CFG.core.updateAliveCivStatus(nCivID);
        if (isInGame) {
            int i2;
            try {
                for (i2 = 0; i2 < this.getNeighProvincesSize(); ++i2) {
                    CFG.core.getCiv((int)CFG.core.getProv((int)this.getNeighProvinces((int)i2)).getCivId()).uFOL = true;
                }
            }
            catch (Exception ex) {
                
            }
            if (oldCivID != this.getCivId() && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)oldCivID).getIdeology()).REVOLUTIONARY) {
                if (CFG.core.getCiv(oldCivID).getNumOfProvs() == 0) {
                    if (CFG.core.getCiv(oldCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(oldCivID).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(oldCivID).getCapitalProvID()).getCivId() != oldCivID) {
                        for (i2 = 0; i2 < CFG.core.getProv(CFG.core.getCiv(oldCivID).getCapitalProvID()).getCitSize(); ++i2) {
                            if (CFG.core.getProv(CFG.core.getCiv(oldCivID).getCapitalProvID()).getCit(i2).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                            CFG.core.getProv(CFG.core.getCiv(oldCivID).getCapitalProvID()).getCit(i2).setCityLevel(CFG.getEditorCityLevel(1));
                        }
                    }
                    for (i2 = 0; i2 < CFG.core.getCivsSize(); ++i2) {
                        if (!CFG.core.getCivsAtWar(oldCivID, i2)) continue;
                        CFG.core.whitePeace(oldCivID, i2);
                    }
                } else {
                    CFG.core.getCiv((int)oldCivID).civGD.iRevolt_LastTurnLostProvince = GameCalendar.TURNID;
                }
            }
            if (CFG.FOG_OF_WAR > 0) {
                List<Integer> updateView = this.getUpdateView_SetCivID(oldCivID);
                for (int i3 = 0; i3 < updateView.size(); ++i3) {
                    this.updateFogOfWar(updateView.get(i3));
                }
            }
            CFG.timelapseManager.addChange(this.getProvID(), nCivID, this.isOccupied());
        }
        if (conquered && oldCivID != this.getCivId()) { 
            if (CFG.settingsGD.ANNEXATION_DELAY) {
                this.setOccupationTurnsLeft(CFG.settingsGD.ANNEXATION_DELAY_TURNS);
            } else {
                this.setOccupationTurnsLeft(1);
            }
            this.provGD.neighProvinceOfCivicWasLost = 0;
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)oldCivID).getIdeology()).REVOLUTIONARY) {
                this.setHappi(this.getHappi() * (0.96241f - (float)CFG.oR.nextInt(92) / 1000.0f));
            } else {
                this.provGD.wasConquered = (byte)(this.getCivId() == this.getTrueOwnerOfProv() ? 3 : 4);
                --CFG.core.getCiv((int)oldCivID).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn;
                ++CFG.core.getCiv((int)this.getCivId()).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn;
                if (this.isOccupied()) {
                    ++CFG.core.getCiv((int)this.getCivId()).civGD.numOfConqueredProvinces;
                    if (CFG.core.getCiv(this.getCivId()).getIsPlayer()) {
                        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                            block32: {
                                if (CFG.core.getPlayer(i).getCivId() != this.getCivId()) continue;
                                try {
                                    CFG.core.getPlayer((int)i).statsCiv.setConqueredProvinces(CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs() + 1);
                                }
                                catch (Exception ex) {
                                    CFG.core.getPlayer((int)i).statsCiv = CFG.serviceRibbonMgr.loadStatistics_Civ(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getCivTag());
                                    if (!CFG.LOGs) break block32;
                                    CFG.exceptionStack(ex);
                                }
                            }
                            if (!CFG.serviceRibbonMgr.check_Request_ConquredProvinces(CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs())) break;
                            CFG.achievementGD = new Achievement_Data(CFG.core.getPlayer(i).getCivId(), CFG.core.getPlayer((int)i).statsCiv.sTag, CFG.lang.get("ConqueredProvinces") + ": ", "" + CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs(), CFG.serviceRibbonMgr.getRequestProvinces_Level(CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs()) - 1);
                            CFG.achievementGD = new Achievement_Data(CFG.core.getPlayer(i).getCivId(), CFG.core.getPlayer((int)i).statsCiv.sTag, CFG.lang.get("ConqueredProvinces") + ": ", "" + CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs(), CFG.serviceRibbonMgr.getRequestProvinces_Level(CFG.core.getPlayer((int)i).statsCiv.getConqueredProvs()) - 1);
                            if (!GameValues.gvInGame.ACHIEVEMENT_SERVICE_RIBBON_SAVE_GAME) break;
                            SaveGameManager.saveRequest = true;
                            break;
                        }
                    }
                }
                for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv(this.getNeighProvinces(i)).getCivId() != oldCivID) continue;
                    this.provGD.neighProvinceOfCivicWasLost = (byte)2;
                }
            }
        }
    }

    public final void setLvlOfPort(int iPort) {
        this.provGD.iPort = iPort;
        if (iPort > 0) {
            this.setDrawCitiesInProv(true);
            if (this.getCivRegionID() >= 0 && this.getCivId() > 0) {
                try {
                    CFG.core.getCiv(this.getCivId()).getCivRegion(this.getCivRegionID()).setSeaAccess_HavePort(true);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        }
    }

    public final int getLvlOfFarm() {
        return this.provGD.iFarm;
    }

    public final void setLvlOfFarm(int iFarm) {
        this.provGD.iFarm = iFarm;
    }

    public final int getLvlOfWorkshop() {
        return this.provGD.iWorkshop;
    }

    public final void setLvlOfWorkshop(int iWorkshop) {
        this.provGD.iWorkshop = iWorkshop;
    }

    public final int getLvlOfMarket() {
        return this.provGD.iMarket;
    }

    public final void setLvlOfMarket(int iMarket) {
        this.provGD.iMarket = iMarket;
    }

    public final int getLvlOfLibrary() {
        return this.provGD.iLibrary;
    }

    public final void setLvlOfLibrary(int iLibrary) {
        this.provGD.iLibrary = iLibrary;
    }

    public final int getLvlOfArmoury() {
        return this.provGD.iArmoury;
    }

    public final void setLvlOfArmoury(int iArmoury) {
        this.provGD.iArmoury = iArmoury;
        if (this.provGD.iArmoury > 0) {
            this.setDrawCitiesInProv(true);
        }
    }

    public final int getLvlOfSupply() {
        return this.provGD.iSupply;
    }

    public final void setLvlOfSupply(int iSupply) {
        this.provGD.iSupply = iSupply;
    }

    public final int getPortShiftPX() {
        try {
            return this.provincePort.getShiftX();
        }
        catch (NullPointerException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            return 0;
        }
    }

    public final int getPortShiftPY() {
        try {
            return this.provincePort.getShiftY();
        }
        catch (NullPointerException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            return 0;
        }
    }

    public final int getPotential() {
        return this.iPotential;
    }

    public final int getPotentialRegion() {
        try {
            return CFG.core.getCiv((int)this.getCivId()).getCivRegion((int)this.getCivRegionID()).iAveragePotential;
        }
        catch (Exception ex) {
            return this.getPotential();
        }
    }

    public final int getRegion_NumOfProvinces() {
        try {
            return CFG.core.getCiv(this.getCivId()).getCivRegion(this.getCivRegionID()).getProvincesSize();
        }
        catch (Exception ex) {
            return 1;
        }
    }

    public final int getPotentialModified(int nCivID) {
        return (int)((float)this.iPotential * (this.getTrueOwnerOfProv() == nCivID ? CFG.core.getCiv((int)nCivID).civGD.civPers.VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE : 1.0f));
    }

    public final int getPotentialModified_WAR_MoveFrom(int nCivID) {
        int nProvinces = 0;
        int nPotential = 0;
        boolean rebels = false;
        try {
            for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
                if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.getNeighProvinces(i)).getCivId())) continue;
                if (CFG.core.getCiv(CFG.core.getProv(this.getNeighProvinces(i)).getCivId()).getCivRegion(CFG.core.getProv(this.getNeighProvinces(i)).getCivRegionID()).getProvincesSize() < CFG.core.getCiv((int)nCivID).civGD.civPers.WAR_CLOSE_REGION_PROVINCES) {
                    nPotential = (int)((float)nPotential + (float)CFG.core.getProv(this.getNeighProvinces(i)).getPotential() * CFG.core.getCiv((int)nCivID).civGD.civPers.WAR_CLOSE_REGION_EXTRA_SCORE * (CFG.core.getProv(this.getNeighProvinces(i)).getTrueOwnerOfProv() == nCivID ? CFG.core.getCiv((int)nCivID).civGD.civPers.VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE : 1.0f));
                    ++nProvinces;
                }
                if (!CFG.core.getProv(this.getNeighProvinces(i)).isOccupied() || CFG.core.getCiv(CFG.core.getProv(this.getNeighProvinces(i)).getCivId()).getIdeology() != CFG.ideologiesMgr.REBELS_ID) continue;
                rebels = true;
            }
        }
        catch (Exception ex) {
            return this.iPotential * (rebels ? 10 : 1);
        }
        if (nProvinces > 0) {
            return (this.iPotential + nPotential / nProvinces) * (rebels ? 10 : 1);
        }
        return this.iPotential * (rebels ? 10 : 1);
    }

    public final int getPotentialModified_WAR_MoveTo(int nCivID) {
        try {
            if (CFG.core.getCiv(this.getCivId()).getCivRegion(this.getCivRegionID()).getProvincesSize() < CFG.core.getCiv((int)nCivID).civGD.civPers.WAR_CLOSE_REGION_PROVINCES) {
                return (int)((float)this.getPotential() * CFG.core.getCiv((int)nCivID).civGD.civPers.WAR_CLOSE_REGION_EXTRA_SCORE * (float)(CFG.core.getCiv(this.getCivId()).getIdeology() == CFG.ideologiesMgr.REBELS_ID ? 10 : 1));
            }
            int ownProvinces = 0;
            int enemyProvinces = 0;
            for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
                if (CFG.core.isAlly(nCivID, CFG.core.getProv(this.getNeighProvinces(i)).getCivId())) {
                    ++ownProvinces;
                    continue;
                }
                if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.getNeighProvinces(i)).getCivId())) continue;
                ++enemyProvinces;
            }
            if (enemyProvinces > 1 && ownProvinces == 1) {
                return (int)((float)this.iPotential * 0.25f) * (CFG.core.getCiv(this.getCivId()).getIdeology() == CFG.ideologiesMgr.REBELS_ID ? 10 : 1);
            }
            return this.iPotential * (CFG.core.getCiv(this.getCivId()).getIdeology() == CFG.ideologiesMgr.REBELS_ID ? 10 : 1);
        }
        catch (Exception ex) {
            return this.iPotential * (CFG.core.getCiv(this.getCivId()).getIdeology() == CFG.ideologiesMgr.REBELS_ID ? 10 : 1);
        }
    }

    public final void setPotential(int iPotential) {
        this.iPotential = iPotential;
    }

    public final void addPotentialP(int iPotential) {
        this.iPotential += iPotential;
    }

    public final int getDangerLvl() {
        return this.iDangerLevel;
    }

    public final void setDangerLvl(int iDangerLevel) {
        this.iDangerLevel = iDangerLevel;
    }

    public final int getDangerLevel_WithArmy() {
        return this.iDangerLevel_WithArmy;
    }

    public final void setDangerLevel_WithArmy(int iDangerLevel_WithArmy) {
        this.iDangerLevel_WithArmy = iDangerLevel_WithArmy;
    }

    public final void addDangerLvl(int iDangerLevel) {
        this.iDangerLevel += iDangerLevel;
    }

    public final int getArmyWasRecruited() {
        return this.iArmyWasRecruited;
    }

    public final void setArmyWasRecruited(int iArmyWasRecruited) {
        this.iArmyWasRecruited = (byte)iArmyWasRecruited;
    }

    public final int getNumOfNeighboringNeutralProvinces() {
        return this.iNumOfNeighboringNeutralProvinces;
    }

    public final void setNumOfNeighboringNeutralProvinces(int iNumOfNeighboringNeutralProvinces) {
        this.iNumOfNeighboringNeutralProvinces = (byte)iNumOfNeighboringNeutralProvinces;
    }

    public final void incNumOfNeighboringNeutralProvinces() {
        this.iNumOfNeighboringNeutralProvinces = (byte)(this.iNumOfNeighboringNeutralProvinces + 1);
    }

    public final boolean getBordersWithEnemy() {
        return this.bordersWithEnemy;
    }

    public final void setBordersWithEnemy(boolean bordersWithEnemy) {
        this.bordersWithEnemy = bordersWithEnemy;
    }

    public final int getWasAttacked() {
        return this.provGD.wasAttacked;
    }

    public final void setWasAttacked(int wasAttacked) {
        this.provGD.wasAttacked = (byte)Math.max(0, wasAttacked);
    }

    public final int getWasConquered() {
        return this.provGD.wasConquered;
    }

    public final void setWasConquered(byte wasConquered) {
        this.provGD.wasConquered = wasConquered < 0 ? (byte)0 : wasConquered;
    }

    public final int getNeighProvinceOfCivWasLost() {
        return this.provGD.neighProvinceOfCivicWasLost;
    }

    public final void setNeighProvinceOfCivWasLost(byte neighProvinceOfCivWasLost) {
        this.provGD.neighProvinceOfCivicWasLost = neighProvinceOfCivWasLost < 0 ? (byte)0 : neighProvinceOfCivWasLost;
    }

    public final boolean getIsPartOfHolyRomanEmpire() {
        return this.provGD.isPartOfHolyRomaEmpire;
    }

    public final void setIsPartOfHolyRomanEmpire(boolean isPartOfHolyRomaEmpire) {
        this.provGD.isPartOfHolyRomaEmpire = isPartOfHolyRomaEmpire;
    }

    public final float getProviStability() {
        return this.provinceStability;
    }

    public final void setProvinceStability(float nProvinceStability) {
        this.provinceStability = nProvinceStability;
    }

        public final void updateOccupationTurns() {
        
        
        if (this.getOccupationTurnsLeft() > 0) {
            this.setOccupationTurnsLeft(this.getOccupationTurnsLeft() - 1);
        }
    }

    public final void updateProvStability() {
        if (this.getCivId() == 0) {
            this.provinceStability = 1.0f;
            return;
        }
        this.provinceStability = 0.0f;
        this.provinceStability += this.updateStability_Score_Population();
        this.provinceStability -= this.updateStability_Score_RevRisk();
        this.provinceStability += this.updateStability_Score_Core();
        this.provinceStability += this.updateStability_Score_Occupied();
        if (this.provinceStability < 1.0f && !this.isOccupied()) {
            this.provinceStability += this.updateStability_Score_Army();
        }
        this.provinceStability = Math.min(this.provinceStability, 1.0f);
        this.provinceStability -= this.updateStability_Score_Disease();
        this.provinceStability = Math.max(this.provinceStability, 0.01f);
        if (!this.isOccupied() && CFG.core.getCiv((int)this.getCivId()).civGD.civPers.MIN_PROVINCE_STABILITY > this.provinceStability && GameValues.gvAiProvince.MIN_HAPPINESS_TO_ASSIMILATE_PROVINCE < this.getHappi() && !CFG.core.getCiv(this.getCivId()).isAssimilateOrganized(this.getProvID())) {
            CFG.core.getCiv((int)this.getCivId()).provincesWithLowStability.add(this.getProvID());
        }
    }

    public final float updateStability_Score_Core() {
        if (this.getCores().getHaveACore(this.getCivId())) {
            return GameValues.gvStability.STABILITY_CORE;
        }
        return 0.0f;
    }

    public final float updateStability_Score_Occupied() {
        if (this.isOccupied()) {
            return GameValues.gvStability.STABILITY_OCCUPIED * (0.85f + 0.2f * CFG.core.getCiv(this.getCivId()).getTechLevel());
        }
        return 0.0f;
    }

    public final float updateStability_Score_Disease() {
        if (this.provGD.provincePlague != null) {
            return GameValues.gvStability.STABILITY_DISEASE;
        }
        return 0.0f;
    }

    public final float updateStability_Score_RevRisk() {
        return GameValues.gvStability.STABILITY_REV_RISK * this.getRevRisk() + (this.provGD.iSupportRebelsSize > 0 ? 0.05f : 0.0f);
    }

    public final float updateStability_Score_Happiness() {
        if (this.getHappi() < GameValues.gvStability.STABILITY_HAPPINESS_MIN) {
            if (this.isOccupied()) {
                return 0.0f;
            }
            return GameValues.gvStability.STABILITY_HAPPINESS_MIN_LOWER_STABILITY * (GameValues.gvStability.STABILITY_HAPPINESS_MIN - this.getHappi());
        }
        if (this.isOccupied()) {
            return GameValues.gvStability.STABILITY_HAPPINESS * this.getHappi() / 2.0f;
        }
        return GameValues.gvStability.STABILITY_HAPPINESS * this.getHappi();
    }

    public final float updateStability_Score_Army() {
        int tempNeighbooringArmy = 0;
        for (int i = 0; i < this.getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(this.getNeighProvinces(i)).getCivId() != this.getCivId()) continue;
            tempNeighbooringArmy += CFG.core.getProvinceArmy(this.getNeighProvinces(i));
        }
        return GameValues.gvStability.STABILITY_ARMY * Math.min(((float)CFG.core.getProvinceArmy(this.getProvID()) + (float)tempNeighbooringArmy * GameValues.gvStability.STABILITY_ARMY_NEIGH_ARMY) / ((float)this.getPop().getPops() / 15.97254f), 1.0f);
    }

    public final float updateStability_Score_Population() {
        float out = 0.0f;
        int nOurPeople = 0;
        long largestGroup = 0;
        int totalPop = 0;
        for (int j = 0; j < this.getPop().getNatsSize(); ++j) {
            if (this.getPop().getCivID(j) == this.getCivId()) {
                nOurPeople += this.getPop().getPopulationID(j);
            } else if (this.getPop().getCivID(j) == 0) {
                nOurPeople += (int)((float)this.getPop().getPopulationID(j) * 0.75f);
            } else if (largestGroup < this.getPop().getPopulationID(j)) {
                largestGroup = this.getPop().getPopulationID(j);
            }
            totalPop += this.getPop().getPopulationID(j);
        }
        out = nOurPeople < largestGroup ? (out += GameValues.gvStability.STABILITY_LARGEST_GROUP * ((float)nOurPeople / (float)largestGroup)) : (out += GameValues.gvStability.STABILITY_LARGEST_GROUP * ((float)largestGroup / (float)nOurPeople));
        return out += GameValues.gvStability.STABILITY_PERC_OF_TOTAL * ((float)nOurPeople / (float)totalPop) * (0.725f + 0.275f * this.getHappi());
    }

    public final int getIsNotSuppliedForXTurns() {
        return this.provGD.isNotSuppliedForYTurns;
    }

    public final void setIsNotSuppliedForXTurns(int isNotSuppliedForXTurns) {
        this.provGD.isNotSuppliedForYTurns = isNotSuppliedForXTurns;
    }

    public final void updateIsNotSuppliedForXTurns() {
        if (this.getIsSupplied() || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.getCivId()).getIdeology()).REVOLUTIONARY) {
            this.provGD.isNotSuppliedForYTurns = -1;
        } else {
            ++this.provGD.isNotSuppliedForYTurns;
            if (this.provGD.isNotSuppliedForYTurns > GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_STARVATION_START_TURN_THRESHOLD) {
                for (int i = this.getCivsSize() - 1; i >= 0; --i) {
                    if (this.getArmyID(i) <= 0) continue;
                    long armyStrave = (int)Math.max(Math.ceil((float)this.getArmyID(i) * GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_STARVATION_PENALTY_PER_TURN * (float)(this.provGD.isNotSuppliedForYTurns - GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_STARVATION_START_TURN_THRESHOLD)), 10.0);
                    if ((armyStrave = (long)Math.min(armyStrave, this.getArmyID(i))) <= 0) continue;
                    CFG.core.getCiv(this.getCivId(i)).setNumberOfUnits(CFG.core.getCiv(this.getCivId(i)).getNumberOfUnits() - armyStrave);
                    this.updateArmy4(this.getCivId(i), this.getArmyID(i) - armyStrave);
                }
            }
            if (this.provGD.isNotSuppliedForYTurns >= GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_LOSE_CONTROL_AFTER_TURNS && this.isOccupied() && CFG.core.getProvinceArmy(this.getProvID()) <= 0) {
                try {
                    if (CFG.core.getCiv(this.getCivId()).getIsPlayer()) {
                        CFG.core.getCiv((int)this.getCivId()).getCivDiploGD().messageBox.addMessage(new Message_ProvincesNotSupplied_LostControl(this.getCivId(), this.getProvID()));
                    }
                    if (CFG.core.getCiv(this.getTrueOwnerOfProv()).getIsPlayer()) {
                        CFG.core.getCiv((int)this.getTrueOwnerOfProv()).getCivDiploGD().messageBox.addMessage(new Message_ProvincesNotSupplied_LostControl_EnemyLost(this.getCivId(), this.getProvID()));
                    }
                }
                catch (Exception exception) {
                    
                }
                this.resetArmiesAll(0);
                this.setCivId(this.getTrueOwnerOfProv(), false, true);
                this.provGD.isNotSuppliedForYTurns = -1;
            }
        }
    }

    public final void updateDefensivePosition() {
        if (this.isOccupied() || !this.getIsSupplied()) {
            this.provGD.defPositionTurns = 0;
        } else if (this.getArmyID(0) > 0) {
            ++this.provGD.defPositionTurns;
            if (this.provGD.defPositionTurns > GameValues.gvDefensivePosition.MAX_DEFENSIVE_POSITION) {
                this.provGD.defPositionTurns = GameValues.gvDefensivePosition.MAX_DEFENSIVE_POSITION;
            }
        } else {
            this.provGD.defPositionTurns = 0;
        }
    }

    public final int getDefensivePosition() {
        return Math.max(this.provGD.defPositionTurns, 0);
    }

    public final void updateNewColony() {
        if (this.provGD.iNewColonyBonus > 0) {
            --this.provGD.iNewColonyBonus;
            if (this.provGD.iNewColonyBonus == 5) {
                ColonizationManager.autoExpand(this.getProvID());
            }
        }
    }

    public final boolean civSupportsRebels(int nCivID) {
        for (int i = this.provGD.iSupportRebelsSize - 1; i >= 0; --i) {
            if (this.provGD.lSupportRebels.get((int)i).iByCivID != nCivID) continue;
            return true;
        }
        return false;
    }
}

