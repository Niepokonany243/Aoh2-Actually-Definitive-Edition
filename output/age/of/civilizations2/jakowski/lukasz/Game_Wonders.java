/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class Game_Wonders {
    public final List<age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder> loadWonders() {
        ArrayList<age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder> nMountains = new ArrayList<age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder>();
        Config mountainsData = new Config();
        try {
            mountainsData = this.readWonders();
            for (Object e : mountainsData.wonders) {
                Wonder oMountainData = (Wonder)e;
                nMountains.add(new age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder(oMountainData.Name, oMountainData.Image, oMountainData.x, oMountainData.y, oMountainData.SinceYear, oMountainData.UntilYear, oMountainData.Wiki));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        return nMountains;
    }

    private final Config readWonders() {
        FileHandle handle = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "wonders/" + "wonders.json");
        String fileContent = handle.readString();
        Json json = new Json();
        json.setElementType(Config.class, "wonders", Wonder.class);
        return json.fromJson(Config.class, fileContent);
    }

    public static class Config {
        private ArrayList wonders;
        private String name;
    }

    public static class Wonder {
        public String Name;
        public int x;
        public int y;
        public int SinceYear;
        public int UntilYear;
        public String Image;
        public String Wiki;
    }
}

