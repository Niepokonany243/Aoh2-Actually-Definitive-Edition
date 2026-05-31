
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Ideology;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class IdeologiesManager {
    private List<Ideology> lIdeologies = null;
    public int REBELS_ID = 0;
    public static int MAX_CROWN_WIDTH = 0;

    public static final int getChangeGovernmentCost(int nCivID) {
        return (int)((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvGovernment.CHANGE_GOV_BASE_COST_MULTIPLIER + GameValues.gvGovernment.CHANGE_GOV_TECH_LEVEL_COST_MULTIPLIER * CFG.core.getCiv(nCivID).getTechLevel() + GameValues.gvGovernment.CHANGE_GOV_PROVINCE_COST_MULTIPLIER * (float)Math.min(CFG.core.getCiv(nCivID).getNumOfProvs(), GameValues.gvGovernment.CHANGE_GOV_MAX_PROVINCES_FOR_COST)));
    }

    public static final int getChangeReligionCost(int nCivID) {
        return (int)((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvGovernment.CHANGE_GOV_BASE_COST_MULTIPLIER + GameValues.gvGovernment.CHANGE_GOV_TECH_LEVEL_COST_MULTIPLIER * CFG.core.getCiv(nCivID).getTechLevel() + GameValues.gvGovernment.CHANGE_GOV_PROVINCE_COST_MULTIPLIER * (float)Math.min(CFG.core.getCiv(nCivID).getNumOfProvs(), GameValues.gvGovernment.CHANGE_GOV_MAX_PROVINCES_FOR_COST)) * GameValues.gvGovernment.CHANGE_RELIGION_COST_MODIFIER);
    }

    public final void loadIdeologies() {
        List<Ideology> tempIdeologies = new ArrayList<Ideology>();
        com.badlogic.gdx.files.FileHandle fileList = null;
        String fileContent;
        Json json;
        ConfigIdeologiesData data;
        Data_Ideologies tempData;
        int i;
        int z;
        boolean add;
        String tempTag;

        try {
            fileList = null;
            if (CFG.getIsDesktop()) {
                for (i = 0; i < sUM.sUFS; ++i) {
                    if (FileManager.IS_MAC) {
                        if (!Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) continue;
                        fileList = Gdx.files.absolute(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                        break;
                    }
                    if (!Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) continue;
                    fileList = Gdx.files.absolute(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                    break;
                }
                if (fileList == null) {
                    for (i = 0; i < sUM.sUII.size(); ++i) {
                        if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json").exists()) continue;
                        fileList = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json");
                        break;
                    }
                }
            }
            if (fileList == null) {
                fileList = FileManager.loadFile("game/Governments.json");
            }
            fileContent = fileList.readString();
            json = new Json();
            json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
            data = json.fromJson(ConfigIdeologiesData.class, fileContent);
            for (Object e : data.Government) {
                tempData = (Data_Ideologies)e;
                tempIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, tempData.DESC));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            for (i = 0; i < sUM.sUFS; ++i) {
                if (FileManager.IS_MAC) {
                    if (!Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) continue;
                    fileList = Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                } else {
                    if (!Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) continue;
                    fileList = Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                }
                fileContent = fileList.readString();
                json = new Json();
                json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
                data = json.fromJson(ConfigIdeologiesData.class, fileContent);
                for (Object e : data.Government) {
                    tempData = (Data_Ideologies)e;
                    tempTag = tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "";
                    add = true;
                    for (z = tempIdeologies.size() - 1; z >= 0; --z) {
                        if (!tempIdeologies.get(z).extraTag.equals(tempTag)) continue;
                        add = false;
                        break;
                    }
                    if (!add) continue;
                    tempIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, tempData.DESC));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (i = 0; i < sUM.sUII.size(); ++i) {
                if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json").exists()) continue;
                fileList = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json");
                fileContent = fileList.readString();
                json = new Json();
                json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
                data = json.fromJson(ConfigIdeologiesData.class, fileContent);
                for (Object e : data.Government) {
                    tempData = (Data_Ideologies)e;
                    tempTag = tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "";
                    add = true;
                    for (z = tempIdeologies.size() - 1; z >= 0; --z) {
                        if (!tempIdeologies.get(z).extraTag.equals(tempTag)) continue;
                        add = false;
                        break;
                    }
                    if (!add) continue;
                    tempIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, tempData.DESC));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            fileList = Gdx.files.internal("game/Governments.json");
            fileContent = fileList.readString();
            json = new Json();
            json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
            data = json.fromJson(ConfigIdeologiesData.class, fileContent);
            for (Object e : data.Government) {
                tempData = (Data_Ideologies)e;
                tempTag = tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "";
                add = true;
                for (z = tempIdeologies.size() - 1; z >= 0; --z) {
                    if (!tempIdeologies.get(z).extraTag.equals(tempTag)) continue;
                    add = false;
                    break;
                }
                if (!add) continue;
                tempIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), tempData.Extra_Tag.length() > 0 ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, tempData.DESC));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.lIdeologies = tempIdeologies;
        for (i = 0; i < this.getIdeologiesSize(); ++i) {
            if (!this.getIdeologyID(i).REVOLUTIONARY) continue;
            this.REBELS_ID = i;
            break;
        }
        IdeologiesManager.MAX_CROWN_WIDTH = 0;
        for (i = 0; i < this.getIdeologiesSize(); ++i) {
            if (this.getIdeologyID(i).getCrownImageScaled().getWidth() <= IdeologiesManager.MAX_CROWN_WIDTH) continue;
            IdeologiesManager.MAX_CROWN_WIDTH = this.getIdeologyID(i).getCrownImageScaled().getWidth();
        }
    }

    public final String getRealTag(String sIn) {
        try {
            if (sIn.indexOf(95) > 0) {
                return sIn.substring(0, sIn.indexOf(95));
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
        return sIn;
    }

    public final int getIdeologyID(String nCivTag) {
        try {
            int lastUnderscore = nCivTag.lastIndexOf(95);
            if (lastUnderscore > 0 && lastUnderscore + 1 < nCivTag.length()) {
                String ideologyTag = nCivTag.substring(lastUnderscore);
                for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
                    if (!ideologyTag.equals(CFG.ideologiesMgr.getIdeologyID(i).getExtraTag())) continue;
                    return i;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 0;
    }

    public final ME_Hover_v2 getIdeologyHover(int nCivID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(nCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Government") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getName(), this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getColor()));
        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(nCivID).getIdeology(), CFG.PADD, this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0 ? CFG.PADD : 0));
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Uncivilized").toUpperCase(), CFG.COLOR_NEGATIVE_2));
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        try {
            if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DESC != null && this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DESC.length() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DESC)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        catch (Exception exception) {
            
        }
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).ACCEPTABLE_TAXATION * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getMin_Goods(nCivID) * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).MIN_INVESTMENTS * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_TAXATION != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_TAXATION * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_TAXATION * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_TAXATION * 100.0f) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_PRODUCTION != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_PRODUCTION * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_PRODUCTION * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_PRODUCTION * 100.0f) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).ADMINISTRATION_COST != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).ADMINISTRATION_COST * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).ADMINISTRATION_COST * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).ADMINISTRATION_COST * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).RESEARCH_COST != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).RESEARCH_COST * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).RESEARCH_COST * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).RESEARCH_COST * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfMove") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruit") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).MILITARY_UPKEEP != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).MILITARY_UPKEEP * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).MILITARY_UPKEEP * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).MILITARY_UPKEEP * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DEFENSE_BONUS > 0 ? "+" : "") + this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DEFENSE_BONUS + "%", this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DEFENSE_BONUS > 0 ? CFG.COLOR_POSITIVE : (this.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).DEFENSE_BONUS == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }

    public final ME_Hover_v2 getIdeologyHover_Just(int nIdeologyID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Government") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(this.getIdeologyID(nIdeologyID).getName(), this.getIdeologyID(nIdeologyID).getColor()));
        nData.add(new ME_Hover_2Type_Ideology_Big(nIdeologyID, CFG.PADD, this.getIdeologyID((int)nIdeologyID).CAN_BECOME_CIVILIZED >= 0 ? CFG.PADD : 0));
        if (this.getIdeologyID((int)nIdeologyID).CAN_BECOME_CIVILIZED >= 0) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Uncivilized").toUpperCase(), CFG.COLOR_NEGATIVE_2));
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        try {
            if (this.getIdeologyID((int)nIdeologyID).DESC != null && this.getIdeologyID((int)nIdeologyID).DESC.length() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(this.getIdeologyID((int)nIdeologyID).DESC)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        catch (Exception exception) {
            
        }
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID((int)nIdeologyID).ACCEPTABLE_TAXATION * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID(nIdeologyID).getMin_Goods() * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(this.getIdeologyID((int)nIdeologyID).MIN_INVESTMENTS * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID((int)nIdeologyID).INCOME_TAXATION != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)nIdeologyID).INCOME_TAXATION * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)nIdeologyID).INCOME_TAXATION * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)nIdeologyID).INCOME_TAXATION * 100.0f) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)nIdeologyID).INCOME_PRODUCTION != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)nIdeologyID).INCOME_PRODUCTION * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)nIdeologyID).INCOME_PRODUCTION * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)nIdeologyID).INCOME_PRODUCTION * 100.0f) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)nIdeologyID).ADMINISTRATION_COST != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)nIdeologyID).ADMINISTRATION_COST * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)nIdeologyID).ADMINISTRATION_COST * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)nIdeologyID).ADMINISTRATION_COST * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (this.getIdeologyID((int)nIdeologyID).RESEARCH_COST != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)nIdeologyID).RESEARCH_COST * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)nIdeologyID).RESEARCH_COST * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)nIdeologyID).RESEARCH_COST * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfMove") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)this.getIdeologyID((int)nIdeologyID).COST_OF_MOVE / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruit") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)this.getIdeologyID((int)nIdeologyID).COST_OF_RECRUIT / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID((int)nIdeologyID).MILITARY_UPKEEP != 1.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int)(this.getIdeologyID((int)nIdeologyID).MILITARY_UPKEEP * 100.0f) - 100 > 0 ? "+" : "") + ((int)(this.getIdeologyID((int)nIdeologyID).MILITARY_UPKEEP * 100.0f) - 100) + "%", (int)(this.getIdeologyID((int)nIdeologyID).MILITARY_UPKEEP * 100.0f) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.getIdeologyID((int)nIdeologyID).DEFENSE_BONUS > 0 ? "+" : "") + this.getIdeologyID((int)nIdeologyID).DEFENSE_BONUS + "%", this.getIdeologyID((int)nIdeologyID).DEFENSE_BONUS > 0 ? CFG.COLOR_POSITIVE : (this.getIdeologyID((int)nIdeologyID).DEFENSE_BONUS == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.defense, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }

    public float getAcceptableTaxation(int ideologyID, int civID) {
        return Math.max(0.01f, this.getIdeologyID((int)ideologyID).ACCEPTABLE_TAXATION + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)civID).getReligionID()).ACCEPTABLE_TAXATION + GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[CFG.core.getCiv((int)civID).civGD.policyID] + CFG.gameAction.modifierAcceptableTaxation_CivID(civID));
    }

    public float getInvestments(int ideologyID, int civID) {
        return Math.max(0.01f, this.getIdeologyID((int)ideologyID).MIN_INVESTMENTS + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)civID).getReligionID()).MIN_INVESTMENTS + GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[CFG.core.getCiv((int)civID).civGD.policyID]);
    }

    public float getResearch(int ideologyID, int civID) {
        return this.getIdeologyID((int)ideologyID).RESEARCH_COST + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)civID).getReligionID()).RESEARCH_COST + GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[CFG.core.getCiv((int)civID).civGD.policyID];
    }

    public float getAdministration(int ideologyID, int civID) {
        return this.getIdeologyID((int)ideologyID).ADMINISTRATION_COST + GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[CFG.core.getCiv((int)civID).civGD.policyID];
    }

    public float getIncomeProduction(int ideologyID, int civID) {
        return this.getIdeologyID((int)ideologyID).INCOME_PRODUCTION + GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[CFG.core.getCiv((int)civID).civGD.policyID];
    }

    public float getMilitaryUpkeep(int ideologyID, int civID) {
        return this.getIdeologyID((int)ideologyID).MILITARY_UPKEEP + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)civID).getReligionID()).MILITARY_UPKEEP + GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[CFG.core.getCiv((int)civID).civGD.policyID];
    }

    public int getChangeAdministrationPolicyCost(int civID) {
        return (int)((float)CFG.core.getCiv((int)civID).incomeTaxation * GameValues.gvAdministrationPolicy.CHANGE_COST_INCOME_TAXATION_PERC + (float)CFG.core.getCiv((int)civID).incomeProduction * GameValues.gvAdministrationPolicy.CHANGE_COST_INCOME_PRODUCTION_PERC);
    }

    public final ME_Hover_v2 getHover_AdministrationPolicy(int policyID, int civID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (civID > 0) {
            nData.add(new ME_Hover_2Type_Flag_Big(civID, 0, CFG.PADD));
        }
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AdministrationPolicy") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[policyID]), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.gov, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        try {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[policyID] * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return new ME_Hover_v2(nElements);
    }

    public boolean canBeAdded(int nCivID, int nIdeologyID) {
        String tTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getExtraTag();
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getCivTag().equals(tTag)) {
                return false;
            }
            for (int j = 0; j < CFG.core.getCiv(i).getTagsCanFormCSize(); ++j) {
                if (!CFG.core.getCiv(i).getTagsCanFormC(j).equals(tTag)) continue;
                return false;
            }
        }
        return true;
    }

    public List<Boolean> canChangeToIdeology(int nCivID) {
        ArrayList<Boolean> out = new ArrayList<Boolean>();
        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            if (i == CFG.core.getCiv(nCivID).getIdeology()) {
                out.add(false);
                continue;
            }
            if (GameCalendar.CURRENT_AGEID < CFG.ideologiesMgr.getIdeologyID((int)i).AVAILABLE_SINCE_AGE_ID) {
                out.add(false);
                continue;
            }
            if (!this.canBeAdded(nCivID, i)) {
                out.add(false);
                continue;
            }
            if (i == this.REBELS_ID) {
                out.add(false);
                continue;
            }
            out.add(true);
        }
        return out;
    }

    public List<Boolean> canChangeToIdeology_All() {
        ArrayList<Boolean> out = new ArrayList<Boolean>();
        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            out.add(true);
        }
        return out;
    }

    public final int getIdeologiesSize() {
        return this.lIdeologies.size();
    }

    public final Ideology getIdeologyID(int i) {
        return this.lIdeologies.get(i);
    }

    public static class ConfigIdeologiesData {
        public String Age_of_Civilizations;
        public ArrayList Government;
    }

    public static class Data_Ideologies {
        public String Name;
        public String Extra_Tag;
        public int GOV_GROUP_ID;
        public float ACCEPTABLE_TAXATION;
        public float MIN_GOODS;
        public float MIN_INVESTMENTS;
        public float RESEARCH_COST;
        public int COST_OF_MOVE;
        public int COST_OF_MOVE_TO_THE_SAME_PROV;
        public int COST_OF_MOVE_OWN_PROV;
        public int COST_OF_RECRUIT;
        public int COST_OF_DISBAND;
        public int COST_OF_PLUNDER;
        public int DEFENSE_BONUS;
        public float MILITARY_UPKEEP;
        public float ADMINISTRATION_COST;
        public float ADMINISTRATION_COST_DISTANCE;
        public float ADMINISTRATION_COST_CAPITAL;
        public float INCOME_TAXATION;
        public float INCOME_PRODUCTION;
        public int CAN_BECOME_CIVILIZED;
        public float CIVILIZE_TECH_LEVEL;
        public int AVAILABLE_SINCE_AGE_ID;
        public boolean REVOLUTIONARY;
        public String DESC = "";
        public String AI_TYPE;
        public int R;
        public int G;
        public int B;
    }
}



