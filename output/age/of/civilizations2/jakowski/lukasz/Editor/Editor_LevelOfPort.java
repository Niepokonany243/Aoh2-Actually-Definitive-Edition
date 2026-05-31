
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import com.badlogic.gdx.Gdx;

public class Editor_LevelOfPort
extends Editor {
    private int nLevelOfPort = -1;

    @Override
    public void keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(21)) {
            --this.nLevelOfPort;
            if (this.nLevelOfPort < -3) {
                this.nLevelOfPort = -3;
            }
        }
        if (Gdx.input.isKeyPressed(22)) {
            ++this.nLevelOfPort;
            if (this.nLevelOfPort > -1) {
                this.nLevelOfPort = -1;
            }
        }
        if (CFG.core.getActiveProvID() >= 0 && (Gdx.input.isKeyPressed(66) || Gdx.input.isKeyPressed(62))) {
            boolean reloadProvinceBG = false;
            if (CFG.core.getProv(CFG.core.getActiveProvID()).getLvlOfPort() >= -1 && this.nLevelOfPort < -1) {
                reloadProvinceBG = true;
            } else if (CFG.core.getProv(CFG.core.getActiveProvID()).getLvlOfPort() < -1 && this.nLevelOfPort >= -1) {
                reloadProvinceBG = true;
            }
            CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfPort(this.nLevelOfPort);
            if (CFG.core.getProv(CFG.core.getActiveProvID()).getLvlOfPort() < -1) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setContinent(0);
            } else if (CFG.core.getProv(CFG.core.getActiveProvID()).getContinent() == 0) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setContinent(1);
            }
            CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
            CFG.core.saveProvince_Info_GameData(CFG.core.getActiveProvID());
            CFG.core.getProv(CFG.core.getActiveProvID()).getArmyObject(0).updateArmyWidth(CFG.core.getProv(CFG.core.getActiveProvID()).getLvlOfPort());
            if (reloadProvinceBG) {
                CFG.core.getProv(CFG.core.getActiveProvID()).loadProvinceBG();
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "SET TO LEVEL: " + this.nLevelOfPort + " [" + (this.nLevelOfPort == -1 ? "LAND" : (this.nLevelOfPort == -2 ? "SEA" : "CLOSED SEA")) + "]\n\nENTER/SPACE -> SET LEVEL\nLEFT, RIGHT - > LEVEL\n\n-1 = LAND PROVINCE\n-2 = SEA PROVINCE\n-3 = CLOSED SEA, LAKES";
    }
}

