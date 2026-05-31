/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Image;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Ideology {
    private String sName;
    public String extraTag;
    public int GOV_GROUP_ID;
    public String AI_TYPE;
    private Image iCrownImage = null;
    private Image iCrownVassalImage = null;
    private Image iCrownImageScaled = null;
    public float MIN_GOODS = 0.15f;
    public float MIN_INVESTMENTS = 0.1f;
    public float RESEARCH_COST = 0.15f;
    public float ACCEPTABLE_TAXATION = 0.25f;
    public float MILITARY_UPKEEP = 1.0f;
    public float ADMINISTRATION_COST = 1.0f;
    public float ADMINISTRATION_COST_DISTANCE = 1.0f;
    public float ADMINISTRATION_COST_CAPITAL = 0.6f;
    public float INCOME_TAXATION = 1.0f;
    public float INCOME_PRODUCTION = 1.0f;
    public int COST_OF_MOVE = 6;
    public int COST_OF_MOVE_SAME_PROVINCE = 4;
    public int COST_OF_MOVE_OWN_PROVINCE = 2;
    public int COST_OF_DISBAND = 20;
    public int COST_OF_PLUNDER = 12;
    public int COST_OF_RECRUIT = 2;
    public int DEFENSE_BONUS = 2;
    public int CAN_BECOME_CIVILIZED = -1;
    public float CIVILIZE_TECH_LEVEL = 1.0f;
    public int AVAILABLE_SINCE_AGE_ID = 0;
    public boolean REVOLUTIONARY = false;
    public String DESC = "";
    private Color oColor;

    public final float getMin_Goods(int nCivID) {
        return Math.max(0.01f, this.MIN_GOODS + GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[CFG.core.getCiv((int)nCivID).civGD.policyID] + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)nCivID).getReligionID()).MIN_GOODS);
    }

    public final float getMin_Goods() {
        return this.MIN_GOODS;
    }

    public Ideology(String sName, String extraTag, int iR, int iG, int iB, float MIN_GOODS, float MIN_INVESTMENTS, int COST_OF_MOVE, int COST_OF_MOVE_SAME_PROVINCE, int COST_OF_MOVE_OWN_PROVINCE, float RESEARCH_COST, float ACCEPTABLE_TAXATION, int DEFENSE_BONUS, float MILITARY_UPKEEP, float ADMINISTRATION_COST, float ADMINISTRATION_COST_DISTANCE, float INCOME_TAXATION, float INCOME_PRODUCTION, int COST_OF_RECRUIT, int COST_OF_DISBAND, int COST_OF_PLUNDER, int CAN_BECOME_CIVILIZED, int AVAILABLE_SINCE_AGE_ID, float ADMINISTRATION_COST_CAPITAL, float CIVILIZE_TECH_LEVEL, String AI_TYPE, boolean REVOLUTIONARY, int GOV_GROUP_ID, String DESC) {
        this.sName = sName;
        this.extraTag = extraTag;
        this.oColor = new Color((float)iR / 255.0f, (float)iG / 255.0f, (float)iB / 255.0f, 0.425f);
        this.GOV_GROUP_ID = GOV_GROUP_ID;
        if (RESEARCH_COST < 0.01f) {
            RESEARCH_COST = 0.01f;
        }
        if (ACCEPTABLE_TAXATION < 0.01f) {
            ACCEPTABLE_TAXATION = 0.01f;
        }
        if (ACCEPTABLE_TAXATION > 0.99f) {
            ACCEPTABLE_TAXATION = 0.99f;
        }
        if ((double)MIN_GOODS < 0.01) {
            MIN_GOODS = 0.01f;
        }
        if (MIN_GOODS > 1.0f) {
            MIN_GOODS = 1.0f;
        }
        if ((double)MIN_INVESTMENTS < 0.01) {
            MIN_INVESTMENTS = 0.01f;
        }
        if (MIN_INVESTMENTS > 1.0f) {
            MIN_INVESTMENTS = 1.0f;
        }
        this.ACCEPTABLE_TAXATION = ACCEPTABLE_TAXATION;
        this.MIN_GOODS = MIN_GOODS;
        this.MIN_INVESTMENTS = MIN_INVESTMENTS;
        this.RESEARCH_COST = RESEARCH_COST;
        if (COST_OF_MOVE < 0) {
            COST_OF_MOVE = 0;
        }
        if (COST_OF_MOVE_SAME_PROVINCE < 0) {
            COST_OF_MOVE_SAME_PROVINCE = 0;
        }
        if (COST_OF_MOVE_OWN_PROVINCE < 0) {
            COST_OF_MOVE_OWN_PROVINCE = 0;
        }
        if (COST_OF_DISBAND < 0) {
            COST_OF_DISBAND = 0;
        }
        if (COST_OF_PLUNDER < 0) {
            COST_OF_PLUNDER = 0;
        }
        this.COST_OF_MOVE = COST_OF_MOVE;
        this.COST_OF_MOVE_SAME_PROVINCE = COST_OF_MOVE_SAME_PROVINCE;
        this.COST_OF_MOVE_OWN_PROVINCE = COST_OF_MOVE_OWN_PROVINCE;
        this.COST_OF_DISBAND = COST_OF_DISBAND;
        this.COST_OF_PLUNDER = COST_OF_PLUNDER;
        if (DEFENSE_BONUS < -99) {
            DEFENSE_BONUS = -99;
        }
        if (DEFENSE_BONUS > 99) {
            DEFENSE_BONUS = 99;
        }
        this.DEFENSE_BONUS = DEFENSE_BONUS;
        if ((double)MILITARY_UPKEEP < 0.01) {
            MILITARY_UPKEEP = 0.01f;
        }
        this.MILITARY_UPKEEP = MILITARY_UPKEEP;
        if (ADMINISTRATION_COST < 0.1f) {
            ADMINISTRATION_COST = 0.1f;
        }
        this.ADMINISTRATION_COST = ADMINISTRATION_COST;
        if ((double)ADMINISTRATION_COST_DISTANCE < 0.01) {
            ADMINISTRATION_COST_DISTANCE = 0.01f;
        }
        this.ADMINISTRATION_COST_DISTANCE = ADMINISTRATION_COST_DISTANCE;
        if ((double)INCOME_TAXATION < 0.01) {
            INCOME_TAXATION = 0.01f;
        }
        this.INCOME_TAXATION = INCOME_TAXATION;
        if (INCOME_PRODUCTION < 0.01f) {
            INCOME_PRODUCTION = 0.01f;
        }
        this.INCOME_PRODUCTION = INCOME_PRODUCTION;
        if (COST_OF_RECRUIT < 1) {
            COST_OF_RECRUIT = 1;
        }
        this.COST_OF_RECRUIT = COST_OF_RECRUIT;
        this.CAN_BECOME_CIVILIZED = CAN_BECOME_CIVILIZED;
        this.AVAILABLE_SINCE_AGE_ID = AVAILABLE_SINCE_AGE_ID;
        if ((double)ADMINISTRATION_COST_CAPITAL < 0.01) {
            ADMINISTRATION_COST_CAPITAL = 0.01f;
        } else if (ADMINISTRATION_COST_CAPITAL > 1.0f) {
            ADMINISTRATION_COST_CAPITAL = 1.0f;
        }
        this.ADMINISTRATION_COST_CAPITAL = ADMINISTRATION_COST_CAPITAL;
        if ((double)CIVILIZE_TECH_LEVEL < 0.01) {
            CIVILIZE_TECH_LEVEL = 0.01f;
        }
        this.CIVILIZE_TECH_LEVEL = CIVILIZE_TECH_LEVEL;
        this.REVOLUTIONARY = REVOLUTIONARY;
        this.AI_TYPE = AI_TYPE;
        this.DESC = DESC;
        try {
            try {
                this.iCrownImage = new Image(new Texture(FileManager.loadFile("UI/icons/crowns/crown" + extraTag + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
            catch (GdxRuntimeException e) {
                this.iCrownImage = new Image(new Texture(FileManager.loadFile("UI/icons/crowns/crown.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
        }
        catch (Exception ex) {
            this.iCrownImage = new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
        }
        try {
            try {
                this.iCrownVassalImage = new Image(new Texture(FileManager.loadFile("UI/icons/crowns/crown_x" + extraTag + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
            catch (GdxRuntimeException e) {
                this.iCrownVassalImage = new Image(new Texture(FileManager.loadFile("UI/icons/crowns/crown_x.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
        }
        catch (Exception exr) {
            this.iCrownVassalImage = new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
        }
        try {
            try {
                this.iCrownImageScaled = new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "crowns/" + "crown" + extraTag + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
            catch (GdxRuntimeException e) {
                this.iCrownImageScaled = new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "crowns/" + "crown.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
            }
        }
        catch (Exception exr) {
            this.iCrownImageScaled = new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
        }
    }

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final String getExtraTag() {
        return this.extraTag;
    }

    public final void setExtraTag(String extraTag) {
        this.extraTag = extraTag;
    }

    public final Color getColor() {
        return this.oColor;
    }

    public final Image getiCrownImage() {
        return this.iCrownImage;
    }

    public final Image getiCrownVassalImage() {
        return this.iCrownVassalImage;
    }

    public final Image getCrownImageScaled() {
        return this.iCrownImageScaled;
    }
}

