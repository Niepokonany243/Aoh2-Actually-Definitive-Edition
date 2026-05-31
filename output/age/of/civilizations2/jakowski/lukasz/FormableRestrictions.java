package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import com.badlogic.gdx.utils.Json;
import java.util.HashMap;

public class FormableRestrictions {
    private static HashMap<String, Integer> formableYearLimits = new HashMap<String, Integer>();
    private static boolean restrictionsLoaded = false;

    public static final void loadRestrictions() {
        if (restrictionsLoaded) return;
        restrictionsLoaded = true;
        try {
            if (FileManager.loadFile("game/gameValues/formableRestrictions.json").exists()) {
                Json json = new Json();
                FormableRestrictionsData data = json.fromJson(FormableRestrictionsData.class, FileManager.loadFile("game/gameValues/formableRestrictions.json"));
                if (data != null && data.formableYearLimits != null) {
                    formableYearLimits = data.formableYearLimits;
                }
                if (data != null) {
                    GameValues.gvFormCiv.RESTRICT_FORMABLES_BY_YEAR = data.RESTRICT_FORMABLES_BY_YEAR;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final boolean canFormInCurrentYear(String formableTag) {
        if (!GameValues.gvFormCiv.RESTRICT_FORMABLES_BY_YEAR) return true;
        if (formableYearLimits.containsKey(formableTag)) {
            int maxYear = formableYearLimits.get(formableTag);
            if (maxYear > 0 && GameCalendar.currYear > maxYear) {
                return false;
            }
        }
        return true;
    }

    public static final int getMaxFormYear(String formableTag) {
        if (formableYearLimits.containsKey(formableTag)) {
            return formableYearLimits.get(formableTag);
        }
        return GameValues.gvFormCiv.FORMABLE_YEAR_LIMIT_DEFAULT;
    }

    private static class FormableRestrictionsData {
        public boolean RESTRICT_FORMABLES_BY_YEAR = false;
        public HashMap<String, Integer> formableYearLimits = new HashMap<String, Integer>();
    }
}
