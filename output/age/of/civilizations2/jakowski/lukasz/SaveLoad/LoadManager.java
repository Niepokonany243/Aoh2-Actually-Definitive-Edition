/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.SaveLoad;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PND;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.util.ArrayList;

public class LoadManager {
    public static final void loadProvinceNamesPoints() {
        try {
            if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "ProvinceNamePoints.json").exists()) {
                FileHandle fileList = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "ProvinceNamePoints.json");
                PNM.pND.clear();
                Json json = new Json();
                JsonValue tempArrayData = new JsonReader().parse(fileList);
                for (JsonValue jValue : tempArrayData) {
                    PND nData;
                    ProvinceNamesPoints tempData = json.readValue(ProvinceNamesPoints.class, jValue);
                    if (tempData.fX == (float)PNM.NULL_INDICATOR) {
                        nData = null;
                    } else {
                        nData = new PND();
                        nData.fX = tempData.fX * (float)CFG.map.getMpB().getMapSc3();
                        nData.fX2 = tempData.fX2 * (float)CFG.map.getMpB().getMapSc3();
                        nData.fY = tempData.fY * (float)CFG.map.getMpB().getMapSc3();
                        nData.fY2 = tempData.fY2 * (float)CFG.map.getMpB().getMapSc3();
                        nData.fCenterX = tempData.cx * (float)CFG.map.getMpB().getMapSc3();
                        nData.fCenterY = tempData.cy * (float)CFG.map.getMpB().getMapSc3();
                    }
                    PNM.pND.add(nData);
                    tempData = null;
                }
                Object var2_3 = null;
            }
        }
        catch (GdxRuntimeException ex) {
            CFG.LOG(ex);
        }
    }

    protected static class ProvinceNamesPoints {
        int pid;
        float fX;
        float fY;
        float fX2;
        float fY2;
        float cx;
        float cy;

        protected ProvinceNamesPoints() {
        }
    }

    public static class ConfigJson {
        public String Age_of_History;
        public ArrayList Data;
    }
}

