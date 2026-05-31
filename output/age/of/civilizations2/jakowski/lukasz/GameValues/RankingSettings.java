package age.of.civilizations2.jakowski.lukasz.GameValues;

import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.OutputStream;
import java.util.Properties;

public class RankingSettings {
    public static boolean RANKING_MILITARY = true;
    public static boolean RANKING_PRESTIGE = true;
    public static boolean RANKING_POPULATION = false;
    public static boolean RANKING_ECONOMY = false;
    public static boolean RANKING_HAPPINESS = false;

    private static final String FILE_NAME = "game/RankingSettings.properties";

    public static void save() {
        try {
            Properties properties = new Properties();
            properties.setProperty("RANKING_MILITARY", String.valueOf(RANKING_MILITARY));
            properties.setProperty("RANKING_PRESTIGE", String.valueOf(RANKING_PRESTIGE));
            properties.setProperty("RANKING_POPULATION", String.valueOf(RANKING_POPULATION));
            properties.setProperty("RANKING_ECONOMY", String.valueOf(RANKING_ECONOMY));
            properties.setProperty("RANKING_HAPPINESS", String.valueOf(RANKING_HAPPINESS));

            FileHandle file = Gdx.files.local(FILE_NAME);
            OutputStream out = file.write(false);
            properties.store(out, "Ranking System Settings");
            out.close();
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void load() {
        try {
            FileHandle file = Gdx.files.local(FILE_NAME);
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(file.read());
                RANKING_MILITARY = Boolean.parseBoolean(properties.getProperty("RANKING_MILITARY", "true"));
                RANKING_PRESTIGE = Boolean.parseBoolean(properties.getProperty("RANKING_PRESTIGE", "true"));
                RANKING_POPULATION = Boolean.parseBoolean(properties.getProperty("RANKING_POPULATION", "false"));
                RANKING_ECONOMY = Boolean.parseBoolean(properties.getProperty("RANKING_ECONOMY", "false"));
                RANKING_HAPPINESS = Boolean.parseBoolean(properties.getProperty("RANKING_HAPPINESS", "false"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}
