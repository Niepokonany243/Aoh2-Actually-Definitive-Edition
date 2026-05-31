
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Civ_GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalletOfCivsColors_Data {
    private List<PalletOfCivsColors_Civ_GameData> lData = new ArrayList<PalletOfCivsColors_Civ_GameData>();
    private List<String> lCivsTags = new ArrayList<String>();
    private int iDataSize = 0;
    private String UPDATE_KEY = null;

    public final void setCivColor(String nTag, Color_GameData nColor) {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (!this.lCivsTags.get(i).equals(nTag)) continue;
            this.lData.get(i).setColor(nColor);
            return;
        }
        this.lData.add(new PalletOfCivsColors_Civ_GameData(nColor));
        this.lCivsTags.add(nTag);
        this.iDataSize = this.lData.size();
    }

    public final void readData(boolean isInternal) {
        this.lData = new ArrayList<PalletOfCivsColors_Civ_GameData>();
        this.lCivsTags = new ArrayList<String>();
        this.iDataSize = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            FileHandle file = null;
            try {
                if (isInternal) {
                    file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                } else {
                    try {
                        file = Gdx.files.local("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                    }
                    catch (Exception ex) {
                        file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                    }
                }
                try {
                    PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                    CFG.core.getCiv(i).setR((int)(nCivColor.getColor().getR() * 255.0f));
                    CFG.core.getCiv(i).setG((int)(nCivColor.getColor().getG() * 255.0f));
                    CFG.core.getCiv(i).setB((int)(nCivColor.getColor().getB() * 255.0f));
                }
                catch (ClassNotFoundException e) {
                    CFG.palletManager.loadCivilizationStandardColor(0);
                }
                catch (IOException e) {
                    CFG.palletManager.loadCivilizationStandardColor(0);
                }
                continue;
            }
            catch (GdxRuntimeException ex) {
                CFG.palletManager.loadCivilizationStandardColor(0);
            }
        }
    }

    
    public final void saveData() {
        
        throw new IllegalStateException("Decompilation failed");
    }

    public final int getDataSize() {
        return this.iDataSize;
    }

    public final String getUPDATE_KEY() {
        return this.UPDATE_KEY;
    }

    public final void setUPDATE_KEY(String nUPDATE_KEY) {
        this.UPDATE_KEY = nUPDATE_KEY;
    }
}

