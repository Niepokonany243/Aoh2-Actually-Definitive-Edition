/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.SaveLoad;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.SaveLoad.LoadManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import java.util.ArrayList;

public class SPNM {
    public static final Json getJson() {
        Json json = new Json();
        json.setTypeName(null);
        json.setUsePrototypes(false);
        json.setIgnoreUnknownFields(true);
        json.setOutputType(JsonWriter.OutputType.javascript);
        return json;
    }

    public static final void saveProvinceNamesPoints() {
        ArrayList<LoadManager.ProvinceNamesPoints> tempData = new ArrayList<LoadManager.ProvinceNamesPoints>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            LoadManager.ProvinceNamesPoints provincePoints = new LoadManager.ProvinceNamesPoints();
            if (PNM.pND.get(i) != null) {
                provincePoints.pid = i;
                provincePoints.fX = PNM.pND.get((int)i).fX / (float)CFG.map.getMpB().getMapSc3();
                provincePoints.fY = PNM.pND.get((int)i).fY / (float)CFG.map.getMpB().getMapSc3();
                provincePoints.fX2 = PNM.pND.get((int)i).fX2 / (float)CFG.map.getMpB().getMapSc3();
                provincePoints.fY2 = PNM.pND.get((int)i).fY2 / (float)CFG.map.getMpB().getMapSc3();
                provincePoints.cx = PNM.pND.get((int)i).fCenterX / (float)CFG.map.getMpB().getMapSc3();
                provincePoints.cy = PNM.pND.get((int)i).fCenterY / (float)CFG.map.getMpB().getMapSc3();
            } else {
                provincePoints.pid = i;
                provincePoints.fX = PNM.NULL_INDICATOR;
                provincePoints.fY = PNM.NULL_INDICATOR;
                provincePoints.fX2 = PNM.NULL_INDICATOR;
                provincePoints.fY2 = PNM.NULL_INDICATOR;
                provincePoints.cx = PNM.NULL_INDICATOR;
                provincePoints.cy = PNM.NULL_INDICATOR;
            }
            tempData.add(provincePoints);
        }
        Json json = SPNM.getJson();
        json.setElementType(LoadManager.ConfigJson.class, "Data", LoadManager.ProvinceNamesPoints.class);
        FileHandle file = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "ProvinceNamePoints.json");
        file.writeString(json.toJson(tempData), false);
    }
}

