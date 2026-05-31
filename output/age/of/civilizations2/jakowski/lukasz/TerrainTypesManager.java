
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Terrain_GameData3;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TerrainTypesManager {
    private List<String> lNames;
    private List<String> lTerrainTags;
    private List<Color> lColors;
    private List<Image> lTerrainIcons;
    private List<Float> lDefense;
    private List<Float> lMilitaryUpkeep;
    private List<Float> lPopulationGrowth;
    private List<Float> lEconomyGrowth;
    private List<Float> lBuildCost;
    private List<Float> lMovementCost;
    private List<Float> lBaseDevelopment;
    private List<Integer> lBaseProvinceValue;
    private int iTerrainTypesSize;

    public TerrainTypesManager() {
        this.loadTerrainTypes();
    }

    public final void loadTerrainTypes() {
        if (this.lTerrainIcons != null) {
            int i = 0;
            while (i < this.lTerrainIcons.size()) {
                this.lTerrainIcons.get(i).getTexture().dispose();
                this.lTerrainIcons.remove(i);
            }
        }
        this.lNames = new ArrayList<String>();
        this.lTerrainTags = new ArrayList<String>();
        this.lTerrainIcons = new ArrayList<Image>();
        this.lColors = new ArrayList<Color>();
        this.lDefense = new ArrayList<Float>();
        this.lMilitaryUpkeep = new ArrayList<Float>();
        this.lPopulationGrowth = new ArrayList<Float>();
        this.lEconomyGrowth = new ArrayList<Float>();
        this.lBuildCost = new ArrayList<Float>();
        this.lMovementCost = new ArrayList<Float>();
        this.lBaseDevelopment = new ArrayList<Float>();
        this.lBaseProvinceValue = new ArrayList<Integer>();
        try {
            FileHandle tempFileT = FileManager.loadFile("game/terrain_types/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            this.iTerrainTypesSize = tagsSPLITED.length;
            this.addSea();
            for (int i = 0; i < this.iTerrainTypesSize; ++i) {
                FileHandle fileData = FileManager.loadFile("game/terrain_types/" + tagsSPLITED[i]);
                try {
                    Terrain_GameData3 tempData = (Terrain_GameData3)CFG.deserialize(fileData.readBytes());
                    this.lNames.add(CFG.lang.get(tempData.getName()));
                    this.lTerrainTags.add(tagsSPLITED[i]);
                    this.lColors.add(new Color(tempData.getColor().getR(), tempData.getColor().getG(), tempData.getColor().getB(), 0.55f));
                    this.lDefense.add(Float.valueOf(tempData.getDefensiveModifier()));
                    this.lMilitaryUpkeep.add(Float.valueOf(tempData.getMilitaryUpkeepModifier()));
                    this.lPopulationGrowth.add(Float.valueOf(tempData.getPopulationGrowthModifier()));
                    this.lEconomyGrowth.add(Float.valueOf(tempData.getEconomyGrowthModifier()));
                    this.lBuildCost.add(Float.valueOf(tempData.getBuildCostModifier()));
                    this.lMovementCost.add(Float.valueOf(tempData.getMovementCost()));
                    this.lBaseDevelopment.add(Float.valueOf(tempData.getBaseDevelopmentLevel()));
                    this.lBaseProvinceValue.add(tempData.getBaseProvinceValue());
                    try {
                        this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + tempData.getIconName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear));
                    }
                    catch (GdxRuntimeException ex) {
                        this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "notfound.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear));
                    }
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    continue;
                }
                catch (IOException iOException) {
                    
                }
            }
            Object var4_7 = null;
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.iTerrainTypesSize = this.lNames.size();
    }

    private void addSea() {
        this.lNames.add(CFG.lang.get("Sea"));
        this.lTerrainTags.add("");
        this.lColors.add(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        this.lDefense.add(Float.valueOf(0.0f));
        this.lMilitaryUpkeep.add(Float.valueOf(0.08f));
        this.lPopulationGrowth.add(Float.valueOf(0.0f));
        this.lEconomyGrowth.add(Float.valueOf(0.0f));
        this.lBuildCost.add(Float.valueOf(0.0f));
        this.lMovementCost.add(Float.valueOf(0.0f));
        this.lBaseDevelopment.add(Float.valueOf(0.0f));
        this.lBaseProvinceValue.add(0);
        try {
            this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "sea.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear));
        }
        catch (GdxRuntimeException ex) {
            this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "notfound.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear));
        }
    }

    public final int getTerrainTypeID(String sTag) {
        for (int i = 1; i < this.iTerrainTypesSize; ++i) {
            if (!this.getTag(i).equals(sTag)) continue;
            return i;
        }
        return 1;
    }

    
    public final void saveTerrainData() {
        OutputStream os = null;
        try {
            FileHandle fileData = FileManager.getSaveType("game/terrain_types/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            fileData.writeBytes(CFG.serialize(CFG.editorTerrain_Data2), false);
            try {
                FileHandle file = FileManager.loadFile("game/terrain_types/Age_of_Civilizations");
                String tempTags = file.readString();
                if (tempTags.indexOf(CFG.EDITOR_ACTIVE_GAMEDATA_TAG) < 0) {
                    FileHandle fileSave = FileManager.getSaveType("game/terrain_types/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
                }
            }
            catch (GdxRuntimeException ex) {
                FileHandle fileSave = FileManager.getSaveType("game/terrain_types/Age_of_Civilizations");
                fileSave.writeString(CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
            }
        }
        catch (IOException iOException) {
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    public final String getName(int i) {
        return this.lNames.get(i);
    }

    public final String getTag(int i) {
        return this.lTerrainTags.get(i);
    }

    public final Color getColor(int i) {
        return this.lColors.get(i);
    }

    public final Image getIcon(int i) {
        return this.lTerrainIcons.get(i);
    }

    public final int getTerrainsSize() {
        return this.iTerrainTypesSize;
    }

    public final float getDefense(int i) {
        return this.lDefense.get(i).floatValue();
    }

    public final float getMilitaryUpkeep(int i) {
        return this.lMilitaryUpkeep.get(i).floatValue();
    }

    public final float getPopulationGrowth(int i) {
        return this.lPopulationGrowth.get(i).floatValue();
    }

    public final float getEconomyGrowth(int i) {
        return this.lEconomyGrowth.get(i).floatValue();
    }

    public final float getBuildCost(int i) {
        return this.lBuildCost.get(i).floatValue();
    }

    public final float getMovementCost(int i) {
        return this.lMovementCost.get(i).floatValue();
    }

    public final float getBaseDevelopmentModifier(int i) {
        return this.lBaseDevelopment.get(i).floatValue();
    }

    public final int getBaseProvinceValue(int i) {
        return this.lBaseProvinceValue.get(i);
    }
}

