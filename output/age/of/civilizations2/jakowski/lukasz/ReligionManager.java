/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.SaveLoad.LoadManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class ReligionManager {
    public List<Religion> lReligions = null;
    public List<Image> religionImages = new ArrayList<Image>();
    private int iReligionsSize = 0;
    public int maxWidth = 0;
    public int maxHeight = 0;

    public final void loadReligions() {
        int i;
        if (this.lReligions != null) {
            this.lReligions.clear();
        }
        this.lReligions = new ArrayList<Religion>();
        try {
            FileHandle fileList = FileManager.loadFile("game/Religions.json");
            String fileContent = fileList.readString();
            Json json = new Json();
            json.setElementType(LoadManager.ConfigJson.class, "Data", Religion.class);
            LoadManager.ConfigJson data = json.fromJson(LoadManager.ConfigJson.class, fileContent);
            for (Object e : data.Data) {
                Religion tempData = (Religion)e;
                tempData.Name = CFG.lang.get(tempData.Name);
                this.lReligions.add(tempData);
            }
            this.iReligionsSize = this.lReligions.size();
            for (int i2 = 0; i2 < this.iReligionsSize; ++i2) {
                this.lReligions.get((int)i2).Color[0] = this.lReligions.get((int)i2).Color[0] / 255.0f;
                this.lReligions.get((int)i2).Color[1] = this.lReligions.get((int)i2).Color[1] / 255.0f;
                this.lReligions.get((int)i2).Color[2] = this.lReligions.get((int)i2).Color[2] / 255.0f;
            }
            data = null;
        }
        catch (GdxRuntimeException ex) {
            CFG.LOG(ex);
        }
        for (i = 0; i < this.iReligionsSize; ++i) {
            try {
                if (FileManager.loadFile("UI/religion/" + CFG.getResPathS() + this.lReligions.get((int)i).Icon).exists()) {
                    this.religionImages.add(new Image(IMGManager.loadTexture("UI/religion/" + CFG.getResPathS() + this.lReligions.get((int)i).Icon)));
                    continue;
                }
                this.religionImages.add(new Image(IMGManager.loadTexture("UI/religion/" + CFG.getResPathSH() + this.lReligions.get((int)i).Icon)));
                continue;
            }
            catch (GdxRuntimeException ex) {
                this.religionImages.add(new Image(IMGManager.loadTexture("UI/religion/" + CFG.getResPathS() + "notfound.png")));
            }
        }
        for (i = 0; i < this.iReligionsSize; ++i) {
            if (this.religionImages.get(i).getWidth() > this.maxWidth) {
                this.maxWidth = this.religionImages.get(i).getWidth();
            }
            if (this.religionImages.get(i).getHeight() <= this.maxHeight) continue;
            this.maxHeight = this.religionImages.get(i).getHeight();
        }
    }

    public final int getReligionsSize() {
        return this.iReligionsSize;
    }

    public final Religion getReligion(int i) {
        if (i >= this.iReligionsSize) {
            return this.lReligions.get(0);
        }
        return this.lReligions.get(i);
    }

    public final ME_Hover_v2 getReligionHover(int religionID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (religionID >= this.lReligions.size()) {
            religionID = 0;
        }
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Religion") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(this.getReligion(religionID).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Religion_Big(religionID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        try {
            if (this.getReligion((int)religionID).ACCEPTABLE_TAXATION != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).ACCEPTABLE_TAXATION > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).ACCEPTABLE_TAXATION * 100.0f) + "%", this.getReligion((int)religionID).ACCEPTABLE_TAXATION > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MIN_GOODS != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MIN_GOODS > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MIN_GOODS * 100.0f) + "%", this.getReligion((int)religionID).MIN_GOODS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MIN_INVESTMENTS != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MIN_INVESTMENTS > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MIN_INVESTMENTS * 100.0f) + "%", this.getReligion((int)religionID).MIN_INVESTMENTS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).RESEARCH_COST != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).RESEARCH_COST > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).RESEARCH_COST * 100.0f) + "%", this.getReligion((int)religionID).RESEARCH_COST < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MILITARY_UPKEEP != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MILITARY_UPKEEP > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MILITARY_UPKEEP * 100.0f) + "%", this.getReligion((int)religionID).MILITARY_UPKEEP < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new ME_Hover_v2(nElements);
    }

    public final ME_Hover_v2 getReligionHover(int religionID, int civID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (religionID >= this.lReligions.size()) {
            religionID = 0;
        }
        nData.add(new ME_Hover_2Type_Flag_Big(civID, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Religion") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(this.getReligion(religionID).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Religion_Big(religionID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        try {
            if (this.getReligion((int)religionID).ACCEPTABLE_TAXATION != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).ACCEPTABLE_TAXATION > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).ACCEPTABLE_TAXATION * 100.0f) + "%", this.getReligion((int)religionID).ACCEPTABLE_TAXATION > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MIN_GOODS != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MIN_GOODS > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MIN_GOODS * 100.0f) + "%", this.getReligion((int)religionID).MIN_GOODS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MIN_INVESTMENTS != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MIN_INVESTMENTS > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MIN_INVESTMENTS * 100.0f) + "%", this.getReligion((int)religionID).MIN_INVESTMENTS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).RESEARCH_COST != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).RESEARCH_COST > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).RESEARCH_COST * 100.0f) + "%", this.getReligion((int)religionID).RESEARCH_COST < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (this.getReligion((int)religionID).MILITARY_UPKEEP != 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text((this.getReligion((int)religionID).MILITARY_UPKEEP > 0.0f ? "+" : "") + (int)(this.getReligion((int)religionID).MILITARY_UPKEEP * 100.0f) + "%", this.getReligion((int)religionID).MILITARY_UPKEEP < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new ME_Hover_v2(nElements);
    }

    public static class Religion {
        public String Name;
        public String Icon;
        public int ReligionGroupID;
        public float[] Color;
        public boolean Tribal = false;
        public float ACCEPTABLE_TAXATION = 0.0f;
        public float MIN_GOODS = 0.0f;
        public float MIN_INVESTMENTS = 0.0f;
        public float RESEARCH_COST = 0.0f;
        public float MILITARY_UPKEEP = 0.0f;

        public final String getName() {
            return this.Name;
        }

        public final Color getColor() {
            return new Color(this.Color[0], this.Color[1], this.Color[2], 0.425f);
        }
    }
}

