
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_Color;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Pallet_Manager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.Random;

public class Editor_Colors
extends Editor {
    private int iActivePaletteID = 1;
    private Civilization_Color lastColor = new Civilization_Color();
    private int iActiveColorID;

    @Override
    public void keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(20) && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            boolean isAvailable;
            Random oR = new Random();
            FileHandle file = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
            String sFile = file.readString();
            String[] sRes = sFile.split(";");
            block5: do {
                this.iActiveColorID = oR.nextInt(Pallet_Manager.NUM_OF_COLORS);
                isAvailable = true;
                for (int i = 0; i < sRes.length; ++i) {
                    FileHandle fileCheckColor = null;
                    try {
                        fileCheckColor = FileManager.loadFile("game/civilizations_colors/" + this.iActivePaletteID + "/" + sRes[i]);
                        String sColorID = fileCheckColor.readString();
                        if (Integer.parseInt(sColorID) != this.iActiveColorID) continue;
                        isAvailable = false;
                        continue block5;
                    }
                    catch (GdxRuntimeException ex) {
                        
                    }
                }
            } while (!isAvailable);
            this.lastColor.iR = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getR();
            this.lastColor.iG = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getG();
            this.lastColor.iB = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getB();
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR(CFG.oR.nextInt(256));
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG(CFG.oR.nextInt(256));
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB(CFG.oR.nextInt(256));
        }
        if (Gdx.input.isKeyPressed(67) && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR(this.lastColor.iR);
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG(this.lastColor.iG);
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB(this.lastColor.iB);
        }
        if (Gdx.input.isKeyPressed(21)) {
            --this.iActivePaletteID;
            if (this.iActivePaletteID < 1) {
                this.iActivePaletteID = 1;
            }
        }
        if (Gdx.input.isKeyPressed(22)) {
            ++this.iActivePaletteID;
        }
        if (!Gdx.input.isKeyPressed(62) || CFG.core.getActiveProvID() >= 0) {
            
        }
        if (Gdx.input.isKeyPressed(19) && CFG.core.getActiveProvID() >= 0) {
            if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                CFG.palletManager.loadCivilizationsPaletteOfColors(this.iActivePaletteID);
            } else {
                try {
                    FileHandle fileCiv = FileManager.loadFile("game/civilizations/" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag());
                    Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                    CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR(tempCivGameData.getR());
                    CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG(tempCivGameData.getG());
                    CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB(tempCivGameData.getB());
                }
                catch (ClassNotFoundException fileCiv) {
                }
                catch (IOException fileCiv) {
                    
                }
            }
        }
        if (Gdx.input.isKeyPressed(66) && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            FileHandle fileSave = FileManager.getSaveType("game/civilizations_colors/" + this.iActivePaletteID + "/" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag());
            fileSave.writeString("" + this.iActiveColorID, false);
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR(CFG.oR.nextInt(256));
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG(CFG.oR.nextInt(256));
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB(CFG.oR.nextInt(256));
        }
    }

    @Override
    public String toString() {
        return "ACTIVE PALETTEID: " + this.iActivePaletteID;
    }
}

