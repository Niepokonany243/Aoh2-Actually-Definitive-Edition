
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class LeaderOfCiv_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sTag = "";
    private String sName = "";
    private String sImage = "";
    private String sWiki = "";
    private int Year = 3;
    private int Month = 2;
    private int Day = 1;
    public float fModifier_PopGrowth = 0.0f;
    public float fModifier_EconomyGrowth = 0.0f;
    public float fModifier_IncomeTaxation = 0.0f;
    public float fModifier_IncomeProduction = 0.0f;
    public float fModifier_Administration = 0.0f;
    public float fModifier_Research = 0.0f;
    public float fModifier_MilitaryUpkeep = 0.0f;
    public float fModifier_AttackBonus = 0.0f;
    public float fModifier_DefenseBonus = 0.0f;
    public float fModifier_MovementPoints = 0.0f;

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = CFG.stripBOM(sName);
    }

    public final String getImage() {
        return this.sImage;
    }

    public final void setImage(String sImage) {
        this.sImage = sImage;
    }

    public final String getWiki() {
        return this.sWiki;
    }

    public final void setWiki(String sWiki) {
        this.sWiki = sWiki;
    }

    public final int getMonth() {
        return this.Month;
    }

    public final void setMonth(int month) {
        this.Month = month;
    }

    public final int getYear() {
        return this.Year;
    }

    public final void setYear(int year) {
        this.Year = year;
    }

    public final int getDay() {
        return this.Day;
    }

    public final void setDay(int day) {
        this.Day = day;
    }

    public final String getTag() {
        return this.sTag;
    }

    public final void setTag(String sTag) {
        this.sTag = sTag;
    }
}

