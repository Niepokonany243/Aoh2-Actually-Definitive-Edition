
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TradeRequest_List
implements Serializable {
    private static final long serialVersionUID = 0L;
    public long iGold = 0L;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public List<Integer> lDeclareWarOnCivID = new ArrayList<Integer>();
    public List<Integer> lPrepareForWarCivID = new ArrayList<Integer>();
    public int iPrepareForWarTurns = 6;
    public List<Integer> lFormCoalitionAgainst = new ArrayList<Integer>();
    public boolean fightCoalitionAllNeighbors = false;
    public boolean defensivePact = false;
    public boolean nonAggressionPact = false;
    public boolean proclaimIndependence = false;
    public boolean militaryAccess = false;
    public List<Integer> lSanctionCivID = new ArrayList<Integer>();
    public int iSanctionTurns = 250;
}

