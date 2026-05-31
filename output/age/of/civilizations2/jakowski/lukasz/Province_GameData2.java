/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Province_Border_GameData;
import age.of.civilizations2.jakowski.lukasz.Province_Info_GameData3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_GameData2
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Short> lPointsX;
    public List<Short> lPointsY;
    public List<Province_Border_GameData> lProvinceBorder;
    public int iLevelOfPort;
    public List<Short> lNeighboringProvinces;
    public List<Short> lNeighboringSeaProvinces;
    public Province_Info_GameData3 provinceInfo = new Province_Info_GameData3();
    public int iPort_ShiftX = 0;
    public int iPort_ShiftY = 0;

    public Province_GameData2() {
        this.lPointsX = new ArrayList<Short>();
        this.lPointsY = new ArrayList<Short>();
        this.lProvinceBorder = new ArrayList<Province_Border_GameData>();
        this.lNeighboringProvinces = new ArrayList<Short>();
        this.lNeighboringSeaProvinces = new ArrayList<Short>();
    }

    public Province_GameData2(int iLevelOfPort, List<Short> lPointsX, List<Short> lPointsY, List<Province_Border_GameData> lProvinceBorder, List<Short> lNeighboringProvinces, List<Short> lNeighboringSeaProvinces) {
        this.iLevelOfPort = iLevelOfPort;
        this.lPointsX = lPointsX;
        this.lPointsY = lPointsY;
        this.lProvinceBorder = lProvinceBorder;
        this.lNeighboringProvinces = lNeighboringProvinces;
        this.lNeighboringSeaProvinces = lNeighboringSeaProvinces;
    }

    public final List<Short> getPointsX() {
        return this.lPointsX;
    }

    public final List<Short> getPointsY() {
        return this.lPointsY;
    }

    public final int getLevelOfPort() {
        return this.iLevelOfPort;
    }

    public final List<Province_Border_GameData> getProvinceBorder() {
        return this.lProvinceBorder;
    }

    public final List<Short> getNeighboringProvinces() {
        return this.lNeighboringProvinces;
    }

    public final List<Short> getNeighboringSeaProvinces() {
        return this.lNeighboringSeaProvinces;
    }
}

