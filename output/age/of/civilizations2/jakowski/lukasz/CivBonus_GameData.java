
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CivBonus_Type;
import java.io.Serializable;

public class CivBonus_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public CivBonus_Type BONUS_TYPE = CivBonus_Type.GOLDEN_AGE_PROSPERITY;
    public float fModifier_PopGrowth = 0.0f;
    public float fModifier_EconomyGrowth = 0.0f;
    public float fModifier_IncomeTaxation = 0.0f;
    public float fModifier_IncomeProduction = 0.0f;
    public float fModifier_Research = 0.0f;
    public float fModifier_MilitaryUpkeep = 0.0f;
    public float fModifier_AttackBonus = 0.0f;
    public float fModifier_DefenseBonus = 0.0f;
    public float fModifier_MovementPoints = 0.0f;
    public int iTurnsLeft = 0;
}

