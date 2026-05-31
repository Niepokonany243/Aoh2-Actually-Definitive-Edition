
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<Long>> lPlayers_Treasury = new ArrayList<List<Long>>();
    public List<List<Integer>> lPlayers_Income = new ArrayList<List<Integer>>();
    public List<List<Integer>> lPlayers_Expenses = new ArrayList<List<Integer>>();
    public List<List<Integer>> lPlayers_MilitarySpendings = new ArrayList<List<Integer>>();
    public List<List<Long>> lPlayers_ArmySize = new ArrayList<List<Long>>();
    public List<List<Integer>> lPlayers_Balance = new ArrayList<List<Integer>>();
    public List<List<Integer>> lPlayers_Happiness = new ArrayList<List<Integer>>();
    public List<List<Integer>> lPlayers_Stability = new ArrayList<List<Integer>>();
}
