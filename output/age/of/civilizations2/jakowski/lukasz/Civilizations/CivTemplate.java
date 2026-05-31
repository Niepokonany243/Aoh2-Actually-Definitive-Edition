
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CivTemplate
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<String> tag = new ArrayList<String>();
    public List<Integer> year = new ArrayList<Integer>();
    public List<List<Integer>> provinces = new ArrayList<List<Integer>>();

    public void addNewTemplate(String nTag, int nYear, List<Integer> nProvinces) {
        if (nProvinces.size() <= 1) {
            return;
        }
        if (this.isUnique(nProvinces)) {
            this.tag.add(nTag);
            this.year.add(nYear);
            this.provinces.add(nProvinces);
        }
    }

    public boolean isUnique(List<Integer> newList) {
        for (List<Integer> existing : this.provinces) {
            if (existing.size() != newList.size()) continue;
            ArrayList<Integer> temp = new ArrayList<Integer>(existing);
            boolean allMatch = true;
            for (Integer num : newList) {
                if (temp.remove(num)) continue;
                allMatch = false;
                break;
            }
            if (!allMatch || !temp.isEmpty()) continue;
            return false;
        }
        return true;
    }
}

