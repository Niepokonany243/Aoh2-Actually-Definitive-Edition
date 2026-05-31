/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mountains.Mountain;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class Game_Mountains {
    public final List<Mountain> loadMountains() {
        ArrayList<Mountain> nMountains = new ArrayList<Mountain>();
        Config mountainsData = new Config();
        try {
            mountainsData = this.readMountains("mountains.json");
            for (Object e : mountainsData.mountains) {
                GameCity oMountainData = (GameCity)e;
                nMountains.add(new Mountain(oMountainData.Name, oMountainData.Elevation, oMountainData.x, oMountainData.y));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        return nMountains;
    }

    private final Config readMountains(String nFileName) {
        FileHandle handle = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "cities/" + nFileName);
        String fileContent = handle.readString();
        Json json = new Json();
        json.setElementType(Config.class, "mountains", GameCity.class);
        return json.fromJson(Config.class, fileContent);
    }

    public static class Config {
        private ArrayList mountains;
        private String name;
    }

    public static class GameCity {
        public String Name;
        public int Elevation;
        public int x;
        public int y;
    }
}

