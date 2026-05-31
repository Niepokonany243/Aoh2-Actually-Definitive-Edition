
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_GameData;
import java.io.Serializable;

public class Save_GameData_10
implements Serializable {
    private static final long serialVersionUID = 0L;
    public HolyRomanEmpire_GameData holyRomanEmpire_GameData;

    public final void buildData() {
        this.holyRomanEmpire_GameData = CFG.hreMgr.getHRE();
    }
}

