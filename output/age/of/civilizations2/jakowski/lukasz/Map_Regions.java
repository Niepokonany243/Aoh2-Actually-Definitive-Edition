
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Package_RegionsData;
import age.of.civilizations2.jakowski.lukasz.Region_GameData;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class Map_Regions {
    private List<String> lName;
    private List<Color> lColor;
    private int iRegionsSize;

    public Map_Regions(String nTag) {
        this.loadRegions(nTag);
    }

    public final void loadRegions(String nTag) {
        this.lName = new ArrayList<String>();
        this.lColor = new ArrayList<Color>();
        try {
            FileHandle file = FileManager.loadFile("map/data/regions/packges/" + nTag);
            Package_RegionsData tempPackageRegionGameData = (Package_RegionsData)CFG.deserialize(file.readBytes());
            for (int i = 0; i < tempPackageRegionGameData.getRegionsTagsSize(); ++i) {
                try {
                    FileHandle fileRegion = FileManager.loadFile("map/data/regions/packges_data/" + tempPackageRegionGameData.getRegionTag(i));
                    Region_GameData tempregionGameData = (Region_GameData)CFG.deserialize(fileRegion.readBytes());
                    this.lName.add(CFG.lang.get(tempregionGameData.getName()));
                    this.lColor.add(new Color(tempregionGameData.getR(), tempregionGameData.getG(), tempregionGameData.getB(), 0.45f));
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.iRegionsSize = this.lName.size();
    }

    public final String getName(int i) {
        return this.lName.get(i);
    }

    public final Color getColor(int i) {
        try {
            return this.lColor.get(i);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return Color.WHITE;
        }
    }

    public final int getRegionsSize() {
        return this.iRegionsSize;
    }
}

