/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_GlobalHappinessPerc
extends Event_Outcome {
    private static final long serialVersionUID = 350429450684878796L;
    public int iCivID = -1;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public long iValue = 0;

    @Override
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long nValue) {
        this.iValue = nValue;
    }

    @Override
    public void outcomeAction() {
        try {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setHappi(CFG.core.getProv(i).getHappi() * (1.0f + (float)this.iValue / 1000.0f));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Happiness") + ": " + CFG.getPrecision2((float)this.getValue() / 10.0f, 100) + "%";
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Happiness");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            tData.add(new ME_Hover_2Type_Image(Images.editorMap, 0, CFG.PADD));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("GlobalEvent") + ": ", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
            tData.add(new ME_Hover_2Type_Text((this.getValue() > 0 ? "+" : "") + CFG.getPrecision2((float)this.getValue() / 10.0f, 100) + "%", this.getValue() > 0 ? CFG.COLOR_POSITIVE : (this.getValue() == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
            tData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
        catch (Exception exception) {
            return new ArrayList<MEHover_2E>();
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_GLOBAL_HAPPINESS_PERC);
    }
}

