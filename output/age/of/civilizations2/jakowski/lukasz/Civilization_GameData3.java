
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Civilization_ServiceRibbon_GameData;
import java.io.Serializable;

public class Civilization_GameData3
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sCivTag;
    private int iR;
    private int iG;
    private int iB;
    public Civilization_ServiceRibbon_GameData sr_GameData = new Civilization_ServiceRibbon_GameData();
    public int iReligionID = 0;
    public int iGroupID = 0;
    public String description = "";

    public Civilization_GameData3() {
        this.sCivTag = "";
    }

    public Civilization_GameData3(String sCivTag, int iR, int iG, int iB) {
        this.sCivTag = sCivTag;
        this.iR = iR;
        this.iG = iG;
        this.iB = iB;
    }

    public final void setCivTag(String nCivTag) {
        this.sCivTag = nCivTag;
    }

    public final String getCivTag() {
        return this.sCivTag;
    }

    public final void setR(int nR) {
        this.iR = nR;
    }

    public final int getR() {
        return this.iR;
    }

    public final void setG(int nG) {
        this.iG = nG;
    }

    public final int getG() {
        return this.iG;
    }

    public final void setB(int nB) {
        this.iB = nB;
    }

    public final int getB() {
        return this.iB;
    }

    public final void setDescription(String nDescription) {
        this.description = nDescription == null ? "" : nDescription;
    }

    public final String getDescription() {
        return this.description == null ? "" : this.description;
    }
}

