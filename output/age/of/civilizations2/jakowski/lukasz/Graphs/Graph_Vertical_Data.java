/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_ArmyPerCapita;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_Continent;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_Population;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_PopulationAllAroundTheWorld;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_PopulationByProvinces;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Value_TechnologyLevels;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Graph_Vertical_Data {
    private int iCivID;
    private List<Graph_Vertical_Data_Value> lValues = new ArrayList<Graph_Vertical_Data_Value>();
    private boolean inView = true;
    private long lTime = 0L;
    private static final int ANIMATION_TIME = 725;

    public Graph_Vertical_Data(int iCivID) {
        this.iCivID = iCivID;
    }

    public final void drawData(SpriteBatch oSB, int iPosX, int iPosY, int iWidth, int iHeight, List<Color> nColors) {
        if (this.lTime == 0L) {
            this.lTime = System.currentTimeMillis();
        }
        int tempValuesHeight = 0;
        if (this.lTime + 725L > System.currentTimeMillis()) {
            int i;
            int tempHeight = 0;
            for (i = 0; i < this.lValues.size(); ++i) {
                tempHeight += this.lValues.get(i).getHeight();
            }
            tempValuesHeight = tempHeight = (int)((float)tempHeight * ((float)(System.currentTimeMillis() - this.lTime) / 725.0f));
            int tempAnimationHeight = 0;
            for (i = 0; i < this.lValues.size(); ++i) {
                try {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempAnimationHeight, tempHeight >= this.lValues.get(i).getHeight() ? this.lValues.get(i).getHeight() : tempHeight, nColors.get(this.lValues.get(i).getDataTypeID()));
                }
                catch (IndexOutOfBoundsException ex) {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempAnimationHeight, tempHeight >= this.lValues.get(i).getHeight() ? this.lValues.get(i).getHeight() : tempHeight, Color.WHITE);
                }
                tempAnimationHeight += this.lValues.get(i).getHeight();
                if ((tempHeight -= this.lValues.get(i).getHeight()) <= 0) break;
            }
            CFG.setRenderO(true);
        } else {
            for (int i = 0; i < this.lValues.size(); ++i) {
                try {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempValuesHeight, nColors.get(this.lValues.get(i).getDataTypeID()));
                }
                catch (IndexOutOfBoundsException ex) {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempValuesHeight, Color.WHITE);
                }
                tempValuesHeight += this.lValues.get(i).getHeight();
            }
        }
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextRotated(oSB, "" + this.getValue(), iPosX + iWidth / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / 2.0f), iPosY + iHeight - CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.45f), 90.0f);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, iPosX, iPosY + iHeight - tempValuesHeight - CFG.PADD - CFG.CIV_FLAG_HEIGHT - CFG.core.getCiv(this.iCivID).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, iPosX, iPosY + iHeight - tempValuesHeight - CFG.PADD - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() - CFG.CIV_FLAG_HEIGHT, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX, iPosY + iHeight - tempValuesHeight - CFG.PADD - CFG.CIV_FLAG_HEIGHT);
    }

    public final void drawData_ONLY_SPLTTED(SpriteBatch oSB, int iPosX, int iPosY, int iWidth, int iHeight, List<Color> nColors) {
        if (this.lTime == 0L) {
            this.lTime = System.currentTimeMillis();
        }
        int tempValuesHeight = 0;
        if (this.lTime + 725L > System.currentTimeMillis()) {
            int i;
            int tempHeight = 0;
            for (i = 0; i < this.lValues.size(); ++i) {
                tempHeight += this.lValues.get(i).getHeight();
            }
            tempValuesHeight = tempHeight = (int)((float)tempHeight * ((float)(System.currentTimeMillis() - this.lTime) / 725.0f));
            int tempAnimationHeight = 0;
            for (i = 0; i < this.lValues.size(); ++i) {
                try {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempAnimationHeight, tempHeight >= this.lValues.get(i).getHeight() ? this.lValues.get(i).getHeight() : tempHeight, nColors.get(this.lValues.get(i).getDataTypeID()));
                }
                catch (IndexOutOfBoundsException ex) {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempAnimationHeight, tempHeight >= this.lValues.get(i).getHeight() ? this.lValues.get(i).getHeight() : tempHeight, Color.WHITE);
                }
                tempAnimationHeight += this.lValues.get(i).getHeight();
                if ((tempHeight -= this.lValues.get(i).getHeight()) <= 0) break;
            }
            CFG.setRenderO(true);
        } else {
            for (int i = 0; i < this.lValues.size(); ++i) {
                try {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempValuesHeight, nColors.get(this.lValues.get(i).getDataTypeID()));
                }
                catch (IndexOutOfBoundsException ex) {
                    this.lValues.get(i).draw(oSB, iPosX, iPosY + iHeight, iWidth, tempValuesHeight, Color.WHITE);
                }
                tempValuesHeight += this.lValues.get(i).getHeight();
            }
        }
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextRotated(oSB, "" + (float)this.getValue() / 100.0f, iPosX + iWidth / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / 2.0f), iPosY + iHeight - CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.45f), 90.0f);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, iPosX, iPosY + iHeight - tempValuesHeight - CFG.PADD - CFG.CIV_FLAG_HEIGHT - CFG.core.getCiv(this.iCivID).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX, iPosY + iHeight - tempValuesHeight - CFG.PADD - CFG.CIV_FLAG_HEIGHT);
    }

    public final void buildHeights(int nGraphHeight, int nMaxValue) {
        for (int i = 0; i < this.lValues.size(); ++i) {
            this.lValues.get(i).setHeight((int)((float)this.lValues.get(i).getValue() / (float)nMaxValue * (float)nGraphHeight));
        }
    }

    public final void buildContintentData() {
        int i;
        this.lValues.clear();
        ArrayList<Integer> numOfProvincesByContinents = new ArrayList<Integer>();
        for (i = 0; i < CFG.map.getMapContinents().getContinentsSize(); ++i) {
            numOfProvincesByContinents.add(0);
        }
        for (i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            numOfProvincesByContinents.set(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getContinent(), (Integer)numOfProvincesByContinents.get(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getContinent()) + 1);
        }
        ArrayList<Graph_Vertical_Data_Value_Continent> tempValues = new ArrayList<Graph_Vertical_Data_Value_Continent>();
        for (int i2 = 0; i2 < CFG.map.getMapContinents().getContinentsSize(); ++i2) {
            if ((Integer)numOfProvincesByContinents.get(i2) <= 0) continue;
            tempValues.add(new Graph_Vertical_Data_Value_Continent((Integer)numOfProvincesByContinents.get(i2), i2));
        }
        while (tempValues.size() > 0) {
            int tempMaxID = 0;
            for (int i3 = 1; i3 < tempValues.size(); ++i3) {
                if (((Graph_Vertical_Data_Value)tempValues.get(tempMaxID)).getValue() >= ((Graph_Vertical_Data_Value)tempValues.get(i3)).getValue()) continue;
                tempMaxID = i3;
            }
            this.lValues.add((Graph_Vertical_Data_Value)tempValues.get(tempMaxID));
            tempValues.remove(tempMaxID);
        }
    }

    public final void buildPopulationData() {
        int i;
        int i2;
        this.lValues.clear();
        ArrayList<Long> numOfPopulation = new ArrayList<Long>();
        for (i2 = 0; i2 < CFG.core.getCivsSize(); ++i2) {
            numOfPopulation.add(0L);
        }
        for (i2 = 0; i2 < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i2) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getPop().getNatsSize(); ++j) {
                numOfPopulation.set(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getPop().getCivID(j), numOfPopulation.get(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getPop().getCivID(j)) + CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getPop().getPopulationID(j));
            }
        }
        int nSecondBiggestPopulationID = 0;
        long nRestOfPopulation = 0L;
        for (i = nSecondBiggestPopulationID + 1; i < CFG.core.getCivsSize(); ++i) {
            if (numOfPopulation.get(nSecondBiggestPopulationID) >= numOfPopulation.get(i) || i == this.iCivID) continue;
            nSecondBiggestPopulationID = i;
        }
        for (i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (i == nSecondBiggestPopulationID || i == this.iCivID) continue;
            nRestOfPopulation += (long)numOfPopulation.get(i).longValue();
        }
        this.lValues.add(new Graph_Vertical_Data_Value_Population((int)numOfPopulation.get(this.iCivID).longValue(), this.iCivID));
        this.lValues.add(new Graph_Vertical_Data_Value_Population((int)numOfPopulation.get(nSecondBiggestPopulationID).longValue(), nSecondBiggestPopulationID));
        this.lValues.add(new Graph_Vertical_Data_Value_Population((int)nRestOfPopulation, 0));
    }

    public final void buildPopulationOfCivilizationAllAroundTheWorldData(int nOfCivID) {
        this.lValues.clear();
        int nPopulation = 0;
        for (int i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            nPopulation += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getPop().getPopulationOfCivID(nOfCivID);
        }
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationAllAroundTheWorld(nPopulation, nOfCivID));
    }

    public final void buildArmiesData() {
        this.lValues.clear();
        long nNumOfUnits = CFG.core.getCiv(this.iCivID).getNumberOfUnits();
        for (int i = 0; i < CFG.core.getCiv(this.iCivID).getArmyInAnotherProvinceSize(); ++i) {
            nNumOfUnits += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getArmyInAnotherProviP(i)).getArmyCivID1(this.iCivID);
        }
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationAllAroundTheWorld((int)nNumOfUnits, this.iCivID));
    }

    public final void buildArmyPerCapitaData() {
        int i;
        this.lValues.clear();
        long nPopulation = 0L;
        long nNumOfUnits = CFG.core.getCiv(this.iCivID).getNumberOfUnits();
        for (i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            nPopulation += (long)CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getPop().getPopulationOfCivID(this.iCivID);
        }
        for (i = 0; i < CFG.core.getCiv(this.iCivID).getArmyInAnotherProvinceSize(); ++i) {
            nNumOfUnits += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getArmyInAnotherProviP(i)).getArmyCivID1(this.iCivID);
        }
        this.lValues.add(new Graph_Vertical_Data_Value_ArmyPerCapita((int)((float)nNumOfUnits * 100.0f / (float)(nPopulation += nNumOfUnits) * 100.0f), this.iCivID));
    }

    public final void buildTechnologyLevelsData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_TechnologyLevels((int)(CFG.core.getCiv(this.iCivID).getTechLevel() * 100.0f), this.iCivID));
    }

    public final void buildPopulationByProvincesData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces((int)CFG.core.getProv(this.iCivID).getPop().getPops(), this.iCivID));
        this.iCivID = CFG.core.getProv(this.iCivID).getCivId();
    }

    public final void buildEconomyByProvincesData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces((int)CFG.core.getProv(this.iCivID).getEco(), this.iCivID));
        this.iCivID = CFG.core.getProv(this.iCivID).getCivId();
    }

    public final void buildConqueredProvincesData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces(CFG.core.getCiv((int)this.iCivID).civGD.numOfConqueredProvinces, this.iCivID));
    }

    public final void buildConstructedBuildingsData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces(CFG.core.getCiv((int)this.iCivID).civGD.numOfBuildingsConstructed, this.iCivID));
    }

    public final void buildArmyByProvincesData() {
        this.lValues.clear();
        int nArmySize = 0;
        for (int i = 0; i < CFG.core.getProv(this.iCivID).getCivsSize(); ++i) {
            nArmySize += CFG.core.getProv(this.iCivID).getArmyID(i);
        }
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces(nArmySize, this.iCivID));
        this.iCivID = CFG.core.getProv(this.iCivID).getCivId();
    }

    public final void buildTechnologyLevelsByProvincesData() {
        this.lValues.clear();
        this.lValues.add(new Graph_Vertical_Data_Value_PopulationByProvinces((int)(CFG.core.getProv(this.iCivID).getDeveLvl() * 100.0f), this.iCivID));
        this.iCivID = CFG.core.getProv(this.iCivID).getCivId();
    }

    public final void buildEconomyData() {
        this.lValues.clear();
        int nEconomy = 0;
        for (int i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            nEconomy += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getEco();
        }
        this.lValues.add(new Graph_Vertical_Data_Value_Population(nEconomy, this.iCivID));
    }

    public final void buildPopulationOfCivByNationalitiesData(int nCivID) {
        this.lValues.clear();
        int nPopulation = 0;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            nPopulation += CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPopulationOfCivID(this.iCivID);
        }
        this.lValues.add(new Graph_Vertical_Data_Value_Population(nPopulation, this.iCivID));
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final int getValue() {
        int tOut = 0;
        for (int i = 0; i < this.lValues.size(); ++i) {
            tOut += this.lValues.get(i).getValue();
        }
        return tOut;
    }

    public final boolean getInView() {
        return this.inView;
    }

    public final void setInView(boolean inView) {
        this.inView = inView;
    }

    public final void resetAnimation() {
        this.lTime = 0L;
    }

    public final int getValuesSize() {
        return this.lValues.size();
    }

    public final int getValue(int i) {
        return this.lValues.get(i).getValue();
    }

    public final int getValueDataTypeID(int i) {
        return this.lValues.get(i).getDataTypeID();
    }
}

