package age.of.civilizations2.jakowski.lukasz.Menus.Settings;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import com.badlogic.gdx.utils.Json;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_Settings_GameValues extends Menu {
    public static class VariableEntry {
        public Object parentObj;
        public Field field;
        public String parentName;
        public String name;
        public String jsonPath;
        public String category;
        public Class<?> fieldType;
        
        public VariableEntry(Object parentObj, Field field, String parentName, String jsonPath, String category) {
            this.parentObj = parentObj;
            this.field = field;
            this.parentName = parentName;
            this.name = field.getName();
            this.jsonPath = jsonPath;
            this.category = category;
            this.fieldType = field.getType();
        }
        
        public String getValue() {
            try {
                Class<?> t = fieldType;
                if (t == int[].class) {
                    int[] arr = (int[])field.get(parentObj);
                    if (arr == null) return "";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arr.length; i++) {
                        if (i > 0) sb.append(", ");
                        sb.append(arr[i]);
                    }
                    return sb.toString();
                }
                if (t == float[].class) {
                    float[] arr = (float[])field.get(parentObj);
                    if (arr == null) return "";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arr.length; i++) {
                        if (i > 0) sb.append(", ");
                        sb.append(arr[i]);
                    }
                    return sb.toString();
                }
                if (t == String[].class) {
                    String[] arr = (String[])field.get(parentObj);
                    if (arr == null) return "";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arr.length; i++) {
                        if (i > 0) sb.append(", ");
                        sb.append(arr[i]);
                    }
                    return sb.toString();
                }
                return String.valueOf(field.get(parentObj));
            } catch (Exception e) {
                return "";
            }
        }
        
        public void setValue(String val) {
            try {
                Class<?> t = fieldType;
                if (t == int.class) {
                    field.setInt(parentObj, Integer.parseInt(val));
                } else if (t == float.class) {
                    field.setFloat(parentObj, Float.parseFloat(val));
                } else if (t == boolean.class) {
                    field.setBoolean(parentObj, Boolean.parseBoolean(val));
                } else if (t == String.class) {
                    field.set(parentObj, val);
                } else if (t == int[].class) {
                    String[] parts = val.split(",");
                    int[] arr = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        arr[i] = Integer.parseInt(parts[i].trim());
                    }
                    field.set(parentObj, arr);
                } else if (t == float[].class) {
                    String[] parts = val.split(",");
                    float[] arr = new float[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        arr[i] = Float.parseFloat(parts[i].trim());
                    }
                    field.set(parentObj, arr);
                } else if (t == String[].class) {
                    String[] parts = val.split(",");
                    String[] arr = new String[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        arr[i] = parts[i].trim();
                    }
                    field.set(parentObj, arr);
                }
            } catch (Exception e) {
                CFG.exceptionStack(e);
            }
        }
        
        public void save() {
            try {
                Json json = new Json();
                String jsonStr = json.toJson(parentObj);
                FileManager.getSaveType(jsonPath).writeString(jsonStr, false);
            } catch (Exception e) {
                CFG.exceptionStack(e);
            }
        }
    }

    private static List<VariableEntry> allVars = new ArrayList<VariableEntry>();
    private List<VariableEntry> filteredVars = new ArrayList<VariableEntry>();
    public static String searchQuery = "";
    public static String selectedCategory = "";
    public static String categorySearchQuery = "";

    private static final Map<String, String> CATEGORY_MAP = new HashMap<String, String>();
    static {
        CATEGORY_MAP.put("gvMilitary", "Military & Warfare");
        CATEGORY_MAP.put("gvDefensivePosition", "Military & Warfare");
        CATEGORY_MAP.put("gvArmyRecruit", "Military & Warfare");
        CATEGORY_MAP.put("gvArmyRecruitable", "Military & Warfare");
        CATEGORY_MAP.put("gvArmyDisband", "Military & Warfare");
        CATEGORY_MAP.put("gvBattle", "Military & Warfare");
        CATEGORY_MAP.put("gvDices", "Military & Warfare");
        CATEGORY_MAP.put("gvWar", "Military & Warfare");
        CATEGORY_MAP.put("gvWarPreparations", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvWarWeariness", "Military & Warfare");
        CATEGORY_MAP.put("gvPlunder", "Military & Warfare");
        CATEGORY_MAP.put("gvMissiles", "Military & Warfare");
        CATEGORY_MAP.put("gvAtomic", "Military & Warfare");
        CATEGORY_MAP.put("gvShips", "Military & Warfare");
        CATEGORY_MAP.put("gvAirDefense", "Military & Warfare");
        CATEGORY_MAP.put("gvProvinceNotSupplied", "Military & Warfare");
        CATEGORY_MAP.put("gvMovementPoints", "Military & Warfare");

        CATEGORY_MAP.put("gvDiplomacy", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDiplomacyPoints", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvRelations", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvRelationDecrease", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvRelationImprove", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvRelationsReactions", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvAllianceOffer", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvCapitulation", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvCeasefire", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipCallToArms", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipDefensivePact", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipGuarantee", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipMilitaryAccess", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipNonAggression", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipTransferControl", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipTruce", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipUnion", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvDipVassalization", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvEnforcePeace", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvGift", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvPeaceTreaty", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvSanctions", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvSummit", "Diplomacy & Relations");
        CATEGORY_MAP.put("gvUltimatum", "Diplomacy & Relations");

        CATEGORY_MAP.put("gvEconomy", "Economy & Trade");
        CATEGORY_MAP.put("gvEconomyGrowth", "Economy & Trade");
        CATEGORY_MAP.put("gvIncome", "Economy & Trade");
        CATEGORY_MAP.put("gvIncomeTaxation", "Economy & Trade");
        CATEGORY_MAP.put("gvIncomeProduction", "Economy & Trade");
        CATEGORY_MAP.put("gvInflation", "Economy & Trade");
        CATEGORY_MAP.put("gvTaxation", "Economy & Trade");
        CATEGORY_MAP.put("gvLoan", "Economy & Trade");
        CATEGORY_MAP.put("gvTrade", "Economy & Trade");
        CATEGORY_MAP.put("gvGoods", "Economy & Trade");
        CATEGORY_MAP.put("gvOverInvestment", "Economy & Trade");
        CATEGORY_MAP.put("gvInvestDevelopment", "Economy & Trade");
        CATEGORY_MAP.put("gvInvestEconomy", "Economy & Trade");
        CATEGORY_MAP.put("gvInvestForeign", "Economy & Trade");

        CATEGORY_MAP.put("gvDevelopment", "Population & Development");
        CATEGORY_MAP.put("gvPopulationGrowth", "Population & Development");
        CATEGORY_MAP.put("gvMigrate", "Population & Development");
        CATEGORY_MAP.put("gvPopRelocate", "Population & Development");
        CATEGORY_MAP.put("gvProvince", "Population & Development");
        CATEGORY_MAP.put("gvProvinceValue", "Population & Development");
        CATEGORY_MAP.put("gvCapital", "Population & Development");
        CATEGORY_MAP.put("gvColonize", "Population & Development");
        CATEGORY_MAP.put("gvAssimilate", "Population & Development");
        CATEGORY_MAP.put("gvCivilize", "Population & Development");
        CATEGORY_MAP.put("gvFormCiv", "Population & Development");

        CATEGORY_MAP.put("gvHappiness", "Happiness & Stability");
        CATEGORY_MAP.put("gvStability", "Happiness & Stability");
        CATEGORY_MAP.put("gvRevolutionaryRisk", "Happiness & Stability");
        CATEGORY_MAP.put("gvRebels", "Happiness & Stability");
        CATEGORY_MAP.put("gvRebelsSupport", "Happiness & Stability");
        CATEGORY_MAP.put("gvRebelsIndependence", "Happiness & Stability");
        CATEGORY_MAP.put("gvFestival", "Happiness & Stability");
        CATEGORY_MAP.put("gvPropaganda", "Happiness & Stability");

        CATEGORY_MAP.put("gvTechnology", "Technology & Research");
        CATEGORY_MAP.put("gvResearch", "Technology & Research");

        CATEGORY_MAP.put("gvBuildings", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingArmoury", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingFarm", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingFort", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingLibrary", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingMarket", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingPort", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingSupplyCamp", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingWatchTower", "Buildings & Improvements");
        CATEGORY_MAP.put("gvBuildingWorkshop", "Buildings & Improvements");

        CATEGORY_MAP.put("gvGovernment", "Government & Administration");
        CATEGORY_MAP.put("gvAdministration", "Government & Administration");
        CATEGORY_MAP.put("gvAdministrationPolicy", "Government & Administration");
        CATEGORY_MAP.put("gvLeader", "Government & Administration");

        CATEGORY_MAP.put("gvGoldenAge", "Golden Age");
        CATEGORY_MAP.put("gvGoldenAgeMilitary", "Golden Age");
        CATEGORY_MAP.put("gvGoldenAgeProsperity", "Golden Age");
        CATEGORY_MAP.put("gvGoldenAgeScience", "Golden Age");

        CATEGORY_MAP.put("gvVassal", "Vassals & Liberty");
        CATEGORY_MAP.put("gvVassalLiberty", "Vassals & Liberty");

        CATEGORY_MAP.put("gvCore", "Core & Claims");

        CATEGORY_MAP.put("gvDifficulty", "Difficulty");

        CATEGORY_MAP.put("gvRankingSystem", "Ranking & Score");
        CATEGORY_MAP.put("gvRankStars", "Ranking & Score");
        CATEGORY_MAP.put("gvRankScore", "Ranking & Score");

        CATEGORY_MAP.put("gvAiNuke", "AI Behavior");
        CATEGORY_MAP.put("gvAiDeclareWar", "AI Behavior");
        CATEGORY_MAP.put("gvAiRivals", "AI Behavior");
        CATEGORY_MAP.put("gvAiRelations", "AI Behavior");
        CATEGORY_MAP.put("gvAiCivsInRange", "AI Behavior");
        CATEGORY_MAP.put("gvAiFormCiv", "AI Behavior");
        CATEGORY_MAP.put("gvAiVassals", "AI Behavior");
        CATEGORY_MAP.put("gvAiAlliance", "AI Behavior");
        CATEGORY_MAP.put("gvAiColonization", "AI Behavior");
        CATEGORY_MAP.put("gvAiLoan", "AI Behavior");
        CATEGORY_MAP.put("gvAiArmy", "AI Behavior");
        CATEGORY_MAP.put("gvAiProvince", "AI Behavior");
        CATEGORY_MAP.put("gvAiDiplomacy", "AI Behavior");
        CATEGORY_MAP.put("gvAiInvest", "AI Behavior");
        CATEGORY_MAP.put("gvAiCivPersonality", "AI Behavior");
        CATEGORY_MAP.put("gvAiCivPersonalityType", "AI Behavior");
        CATEGORY_MAP.put("gvAiWar", "AI Behavior");
        CATEGORY_MAP.put("gvAiBudget", "AI Behavior");

        CATEGORY_MAP.put("gvInGame", "UI & Display");
        CATEGORY_MAP.put("gvMapOverlays", "UI & Display");
        CATEGORY_MAP.put("gvMapScroll", "UI & Display");
        CATEGORY_MAP.put("gvOutliner", "UI & Display");
        CATEGORY_MAP.put("gvProvinceAnimation", "UI & Display");
        CATEGORY_MAP.put("gvProvinceBorder", "UI & Display");
        CATEGORY_MAP.put("gvServiceRibbon", "UI & Display");
        CATEGORY_MAP.put("gvTimelapse", "UI & Display");

        CATEGORY_MAP.put("gvMove", "Miscellaneous");
        CATEGORY_MAP.put("gvMoveCapital", "Miscellaneous");
        CATEGORY_MAP.put("gvUpdate", "Miscellaneous");
        CATEGORY_MAP.put("gvLogs", "Miscellaneous");
        CATEGORY_MAP.put("gvAchievements", "Miscellaneous");
        CATEGORY_MAP.put("gvCommands", "Miscellaneous");
        CATEGORY_MAP.put("gvAbout", "Miscellaneous");
        CATEGORY_MAP.put("gvWonder", "Miscellaneous");
        CATEGORY_MAP.put("gvTribal", "Miscellaneous");
        CATEGORY_MAP.put("gvHre", "Miscellaneous");
    }

    private static String getCategoryFor(String parentName) {
        String cat = CATEGORY_MAP.get(parentName);
        return cat != null ? cat : "Other";
    }

    private static void initVars() {
        if (!allVars.isEmpty()) return;
        try {
            for (Field gvField : GameValues.class.getFields()) {
                Object gvObj = gvField.get(null);
                if (gvObj != null) {
                    String pName = gvField.getName();
                    String jsonPath = "game/gameValues/" + pName + ".json";
                    String category = getCategoryFor(pName);
                    for (Field valField : gvObj.getClass().getFields()) {
                        Class<?> type = valField.getType();
                        if (type == int.class || type == float.class || type == boolean.class ||
                            type == String.class || type == int[].class || type == float[].class || type == String[].class) {
                            allVars.add(new VariableEntry(gvObj, valField, pName, jsonPath, category));
                        }
                    }
                }
            }
        } catch (Exception e) {}
    }

    private static List<String> getCategories() {
        ArrayList<String> cats = new ArrayList<String>();
        for (int i = 0; i < allVars.size(); i++) {
            String c = allVars.get(i).category;
            if (!cats.contains(c)) cats.add(c);
        }
        return cats;
    }

    private static int getCategoryCount(String category) {
        int count = 0;
        for (int i = 0; i < allVars.size(); i++) {
            if (allVars.get(i).category.equals(category)) count++;
        }
        return count;
    }

    private static int getAllCount() {
        return allVars.size();
    }

    public Menu_Settings_GameValues() {
        initVars();

        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;

        if (selectedCategory.length() == 0) {
            buildCategoryList(menuElements, tY);
        } else {
            buildValueList(menuElements, tY);
        }

        String title = selectedCategory.length() == 0 ? "Game Values - Categories" : "Game Values - " + selectedCategory;
        this.initMenu(new TitleM(title, CFG.BUTTON_H * 3 / 4, true, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    private void buildCategoryList(ArrayList<MenuElemUI> menuElements, int tY) {
        menuElements.add(new Button_Classic(CFG.lang.get("Back"), -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Classic("Search Categories: " + categorySearchQuery, -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Classic("* All Categories (" + getAllCount() + " values)", -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
        tY += CFG.BUTTON_H + CFG.PADD;

        List<String> categories = getCategories();
        String q = categorySearchQuery.toLowerCase();
        for (int i = 0; i < categories.size(); i++) {
            String cat = categories.get(i);
            if (q.length() > 0 && !cat.toLowerCase().contains(q)) continue;
            int count = getCategoryCount(cat);
            menuElements.add(new Button_Classic(cat + " (" + count + ")", -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
            tY += CFG.BUTTON_H + CFG.PADD;
        }
    }

    private void buildValueList(ArrayList<MenuElemUI> menuElements, int tY) {
        menuElements.add(new Button_Classic(CFG.lang.get("Back") + " to Categories", -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
        tY += CFG.BUTTON_H + CFG.PADD;

        menuElements.add(new Button_Classic("Search: " + searchQuery, -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
        tY += CFG.BUTTON_H + CFG.PADD;

        filteredVars.clear();
        String q = searchQuery.toLowerCase();
        boolean allCats = selectedCategory.equals("*");
        for (int i = 0; i < allVars.size(); i++) {
            VariableEntry v = allVars.get(i);
            boolean catMatch = allCats || v.category.equals(selectedCategory);
            boolean textMatch = q.length() == 0 || v.name.toLowerCase().contains(q) || v.parentName.toLowerCase().contains(q);
            if (catMatch && textMatch) {
                filteredVars.add(v);
            }
        }

        for (int i = 0; i < filteredVars.size(); i++) {
            VariableEntry v = filteredVars.get(i);
            String prefix = allCats ? "[" + v.category + "] " : "";
            menuElements.add(new Button_Classic(prefix + v.name + ": " + v.getValue(), -1, CFG.PADD, tY, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true));
            tY += CFG.BUTTON_H + CFG.PADD;
        }
    }

    @Override
    public void actionEL(int iID) {
        if (iID == 0) {
            this.onBackPressed();
            return;
        }
        if (selectedCategory.length() == 0) {
            handleCategoryAction(iID);
        } else {
            handleValueAction(iID);
        }
    }

    private void handleCategoryAction(int iID) {
        if (iID == 1) {
            CFG.showKeyboard();
            CFG.keybMess = categorySearchQuery;
            Keyboard.numbers = false;
            CFG.keyboardSave = new CFG.Keyboard_Action() {
                @Override
                public void action() {
                    categorySearchQuery = CFG.keybMess;
                    CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
                }
            };
            return;
        }
        if (iID == 2) {
            selectedCategory = "*";
            categorySearchQuery = "";
            CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
            return;
        }
        int index = iID - 3;
        List<String> categories = getCategories();
        String q = categorySearchQuery.toLowerCase();
        int catIndex = 0;
        for (int i = 0; i < categories.size(); i++) {
            if (q.length() > 0 && !categories.get(i).toLowerCase().contains(q)) continue;
            if (catIndex == index) {
                selectedCategory = categories.get(i);
                break;
            }
            catIndex++;
        }
        if (selectedCategory.length() > 0) {
            searchQuery = "";
            categorySearchQuery = "";
            CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
        }
    }

    private void handleValueAction(int iID) {
        if (iID == 1) {
            CFG.showKeyboard();
            CFG.keybMess = searchQuery;
            Keyboard.numbers = false;
            CFG.keyboardSave = new CFG.Keyboard_Action() {
                @Override
                public void action() {
                    searchQuery = CFG.keybMess;
                    CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
                }
            };
            return;
        }
        int index = iID - 2;
        if (index >= 0 && index < filteredVars.size()) {
            final VariableEntry v = filteredVars.get(index);
            if (v.fieldType == boolean.class) {
                boolean val = false;
                try { val = v.field.getBoolean(v.parentObj); } catch(Exception e){}
                v.setValue(String.valueOf(!val));
                v.save();
                String prefix = selectedCategory.equals("*") ? "[" + v.category + "] " : "";
                this.getMenuElem(iID).setTextE(prefix + v.name + ": " + v.getValue());
            } else {
                CFG.showKeyboard();
                CFG.keybMess = v.getValue();
                Keyboard.numbers = (v.fieldType == int.class || v.fieldType == float.class);
                CFG.keyboardSave = new CFG.Keyboard_Action() {
                    @Override
                    public void action() {
                        v.setValue(CFG.keybMess);
                        v.save();
                        CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
                    }
                };
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (selectedCategory.length() > 0) {
            selectedCategory = "";
            searchQuery = "";
            CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
        } else {
            CFG.menus.setMenuID(View.eSETTINGS);
            CFG.menus.setBackAnimation(true);
        }
    }
}
