
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Continent_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Package_ContinentsData;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map_Continents {
    private List<String> lName;
    private List<Color> lColor;
    private int iContinentsSize;
    public static final String OCEAN_CONTINENT_TAG = "1486419009922xximucak";
    private int iOceanContinentID;

    public Map_Continents(String nTag) {
        this.loadContinents(nTag);
    }

    public final void loadContinents(String nTag) {
        this.lName = new ArrayList<String>();
        this.lColor = new ArrayList<Color>();
        try {
            FileHandle file = FileManager.loadFile("map/data/continents/packges/" + nTag);
            Package_ContinentsData tempPackageContinentGameData = (Package_ContinentsData)CFG.deserialize(file.readBytes());
            for (int i = 0; i < tempPackageContinentGameData.getContinentsTagsSize(); ++i) {
                try {
                    FileHandle fileContinent = FileManager.loadFile("map/data/continents/packges_data/" + tempPackageContinentGameData.getContinentTag(i));
                    Continent_GameData tempContinentGameData = (Continent_GameData)CFG.deserialize(fileContinent.readBytes());
                    this.lName.add(CFG.lang.get(tempContinentGameData.getName()));
                    this.lColor.add(new Color(tempContinentGameData.getR(), tempContinentGameData.getG(), tempContinentGameData.getB(), 0.7f));
                    if (!tempPackageContinentGameData.getContinentTag(i).equals(OCEAN_CONTINENT_TAG)) continue;
                    this.iOceanContinentID = i;
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    continue;
                }
                catch (IOException iOException) {
                    
                }
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
            
        }
        this.iContinentsSize = this.lName.size();
    }

    public final String getName(int i) {
        return this.lName.get(i);
    }

    public final Color getColor(int i) {
        return this.lColor.get(i);
    }

    public final int getContinentsSize() {
        return this.iContinentsSize;
    }

    public final int getOceanContinentID() {
        return this.iOceanContinentID;
    }
}

