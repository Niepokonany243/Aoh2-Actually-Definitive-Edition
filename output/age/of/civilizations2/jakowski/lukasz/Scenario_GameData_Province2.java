/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario_GameData_Province2
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Integer> lProvinceOwners = null;
    public List<Long> lProvincePopulation = null;
    public List<Long> lProvinceEconomy = null;
    public List<Boolean> lProvinceNatural = null;

    public final void buildProvinceOwners() {
        this.lProvinceOwners = new ArrayList<Integer>();
        this.lProvincePopulation = new ArrayList<Long>();
        this.lProvinceEconomy = new ArrayList<Long>();
        this.lProvinceNatural = new ArrayList<Boolean>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            this.lProvinceOwners.add(CFG.core.getProv(i).getCivId());
            this.lProvincePopulation.add(Long.valueOf(CFG.core.getProv(i).getPop().getPops()));
            this.lProvinceEconomy.add(CFG.core.getProv(i).getEco());
            this.lProvinceNatural.add(Boolean.FALSE);
        }
    }

    public final List<Integer> getProvinceOwners() {
        return this.lProvinceOwners;
    }
}

