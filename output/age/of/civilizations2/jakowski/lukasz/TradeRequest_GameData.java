
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.TradeRequest_List;
import java.io.Serializable;

public class TradeRequest_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivLEFT = 0;
    public int iCivRIGHT = 0;
    public TradeRequest_List listLEFT = new TradeRequest_List();
    public TradeRequest_List listRight = new TradeRequest_List();

    public final boolean canBeSend() {
        return this.listLEFT.iGold > 0 || this.listRight.iGold > 0 || this.listLEFT.lProvinces.size() > 0 || this.listRight.lProvinces.size() > 0 || this.listLEFT.lDeclareWarOnCivID.size() > 0 || this.listRight.lDeclareWarOnCivID.size() > 0 || this.listLEFT.lPrepareForWarCivID.size() > 0 || this.listRight.lPrepareForWarCivID.size() > 0 || this.listLEFT.lFormCoalitionAgainst.size() > 0 || this.listRight.lFormCoalitionAgainst.size() > 0 || this.listLEFT.fightCoalitionAllNeighbors || this.listRight.fightCoalitionAllNeighbors || this.listLEFT.defensivePact || this.listRight.defensivePact || this.listLEFT.nonAggressionPact || this.listRight.nonAggressionPact || this.listLEFT.proclaimIndependence || this.listRight.proclaimIndependence || this.listLEFT.militaryAccess || this.listRight.militaryAccess || this.listLEFT.lSanctionCivID.size() > 0 || this.listRight.lSanctionCivID.size() > 0;
    }
}
