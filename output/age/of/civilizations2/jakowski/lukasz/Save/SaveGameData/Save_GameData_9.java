
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.DiplomaticSummitA.DiplomaticSummit;
import age.of.civilizations2.jakowski.lukasz.Civilizations.DiplomaticSummitA.DiplomaticSummitCooldown;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Province.Propaganda;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Plague_GD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_9
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Plague_GD> lPlagues_INGAME = new ArrayList<Plague_GD>();
    public List<DiplomaticSummit> diplomaticSummits = new ArrayList<DiplomaticSummit>();
    public List<DiplomaticSummitCooldown> diplomaticSummitCooldowns = new ArrayList<DiplomaticSummitCooldown>();
    public List<Propaganda> propagandas = new ArrayList<Propaganda>();

    public final void buildData() {
        int i;
        for (i = 0; i < CFG.plagueManager.plaguesActive.size(); ++i) {
            this.lPlagues_INGAME.add(CFG.plagueManager.plaguesActive.get(i));
        }
        for (i = 0; i < CFG.core.diplomaticSummits.size(); ++i) {
            this.diplomaticSummits.add(CFG.core.diplomaticSummits.get(i));
        }
        for (i = 0; i < CFG.core.diplomaticSummitCooldowns.size(); ++i) {
            this.diplomaticSummitCooldowns.add(CFG.core.diplomaticSummitCooldowns.get(i));
        }
        for (i = 0; i < CFG.core.propaganda.size(); ++i) {
            this.propagandas.add(CFG.core.propaganda.get(i));
        }
    }
}

