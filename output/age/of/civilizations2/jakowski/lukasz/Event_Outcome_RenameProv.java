/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_RenameProv
extends Event_Outcome {
    private static final long serialVersionUID = 4324417786790844898L;
    public int provID = -1;
    public String name = "";

    @Override
    public void setValue(long nValue) {
        this.provID = (int)nValue;
    }

    @Override
    public long getValue() {
        return this.provID;
    }

    @Override
    public void setText(String nText) {
        this.name = nText;
    }

    @Override
    public String getText() {
        return this.name;
    }

    @Override
    public void outcomeAction() {
        try {
            if (this.canMakeAction()) {
                CFG.core.getProv(this.provID).setName2(this.name);
                CFG.aPNC(this.provID, this.name);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.provID).getCivId()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceName") + ": "));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getProv(this.provID).getProvName() + " -> "));
                tData.add(new ME_Hover_2Type_Text(this.name, CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (Exception exception) {
            return new ArrayList<MEHover_2E>();
        }
    }

    public boolean canMakeAction() {
        try {
            return this.provID >= 0 && this.provID < CFG.core.getProvinSize() && this.name.length() > 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("ProvinceName") + ": " + CFG.core.getProv(this.provID).getProvName() + ", ID: " + this.provID;
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("ProvinceName") + ": ID: " + this.provID;
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RENAME_PROVINCE);
    }
}

