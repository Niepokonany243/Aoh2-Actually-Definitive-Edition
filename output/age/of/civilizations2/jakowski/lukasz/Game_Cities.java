
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class Game_Cities {
    public final List<City> loadCities() {
        GameCity oCityData;
        ArrayList<City> nCities = new ArrayList<City>();
        Config citiesData = new Config();
        try {
            citiesData = this.readCities("cities.json");
            for (Object e : citiesData.cities) {
                oCityData = (GameCity)e;
                nCities.add(new City(oCityData.Name, oCityData.x, oCityData.y, Images.city));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        try {
            citiesData = this.readCities("cities_1.json");
            for (Object e : citiesData.cities) {
                oCityData = (GameCity)e;
                nCities.add(new City(oCityData.Name, oCityData.x, oCityData.y, Images.city2));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        try {
            citiesData = this.readCities("cities_2.json");
            for (Object e : citiesData.cities) {
                oCityData = (GameCity)e;
                nCities.add(new City(oCityData.Name, oCityData.x, oCityData.y, Images.city3));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        try {
            citiesData = this.readCities("cities_3.json");
            for (Object e : citiesData.cities) {
                oCityData = (GameCity)e;
                nCities.add(new City(oCityData.Name, oCityData.x, oCityData.y, Images.city4));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        try {
            citiesData = this.readCities("cities_4.json");
            for (Object e : citiesData.cities) {
                oCityData = (GameCity)e;
                nCities.add(new City(oCityData.Name, oCityData.x, oCityData.y, Images.city5));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        return nCities;
    }

    private final Config readCities(String nFileName) {
        Json json = new Json();
        json.setElementType(Config.class, "cities", GameCity.class);
        return json.fromJson(Config.class, FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "cities/" + nFileName).reader("UTF8"));
    }

    public static class Config {
        private ArrayList cities;
        private String name;
    }

    public static class GameCity {
        public String Name;
        public int x;
        public int y;
        public int p;
    }
}

