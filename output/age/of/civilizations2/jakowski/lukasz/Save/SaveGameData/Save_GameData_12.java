
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Province.ForeignInvest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_12
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<ForeignInvest> foreignInvests = new ArrayList<ForeignInvest>();
    public List<ForeignInvest> buildInvests = new ArrayList<ForeignInvest>();

    public final void buildData() {
        int i;
        for (i = 0; i < CFG.core.investForeignGold.size(); ++i) {
            this.foreignInvests.add(CFG.core.investForeignGold.get(i));
        }
        for (i = 0; i < CFG.core.buildForeignGold.size(); ++i) {
            this.buildInvests.add(CFG.core.buildForeignGold.get(i));
        }
    }
}

