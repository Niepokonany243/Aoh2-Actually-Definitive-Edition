
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Editor_Wasteland
extends Editor {
    @Override
    public void keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(21) || Gdx.input.isKeyPressed(22)) {
            boolean bl = CFG.bSetWasteland_AvailableProvinces = !CFG.bSetWasteland_AvailableProvinces;
        }
        if (Gdx.input.isKeyPressed(62) && CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            CFG.core.setWasteland(CFG.core.getActiveProvID(), CFG.bSetWasteland_AvailableProvinces);
        }
        if (Gdx.input.isKeyPressed(67)) {
            for (int i = 1; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setWastelandLvl(0);
            }
        }
        if (Gdx.input.isKeyPressed(66)) {
            Editor_Wasteland.actionSave();
        }
    }

    public static final void actionSave() {
        FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "wasteland_maps/" + "temp");
        fileSave.writeString("" + (CFG.core.getProv(0).getWastelandLvl() >= 0 ? (char)'1' : '0') + ";", false);
        for (int i = 1; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            fileSave.writeString("" + (CFG.core.getProv(i).getWastelandLvl() >= 0 ? (char)'1' : '0') + ";", true);
        }
    }

    @Override
    public String toString() {
        return "WASTELAND: " + CFG.bSetWasteland_AvailableProvinces;
    }
}

