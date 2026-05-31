
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alliances_Names_GameData_Bundle
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<String> sWords = new ArrayList<String>();

    public Alliances_Names_GameData_Bundle(String nWord) {
        this.sWords.add(nWord);
    }

    public final void addWord(String nWord) {
        this.sWords.add(nWord);
    }

    public final void removeWord(int i) {
        this.sWords.remove(i);
    }

    public final String getWord(int i) {
        return this.sWords.get(i);
    }

    public final String setWord(int i, String nWord) {
        return this.sWords.set(i, nWord);
    }

    public final int getWordsSize() {
        return this.sWords.size();
    }
}

