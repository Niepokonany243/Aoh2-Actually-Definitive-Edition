/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.LeaderOfCiv_GameData;
import age.of.civilizations2.jakowski.lukasz.Leader_GameData;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ChangeLeader
extends Event_Outcome {
    private static final long serialVersionUID = 6045654316483668628L;
    public int iCivID = -1;
    public LeaderOfCiv_GameData leaderOfCiv;

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            return true;
        }
        if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        return false;
    }

    @Override
    public void outcomeAction() {
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            try {
                CFG.core.getCiv(this.getCivID()).setLeaderN(this.leaderOfCiv);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Leader") + ": " + this.leaderOfCiv.getName();
        }
        catch (Exception ex) {
            return CFG.lang.get("Leader") + ": ---";
        }
    }

    public boolean canMakeAction() {
        return false;
    }

    @Override
    public String getText() {
        try {
            return CFG.lang.get("Leader") + ": " + this.leaderOfCiv.getName();
        }
        catch (Exception ex) {
            return CFG.lang.get("Leader") + ": ---";
        }
    }

    @Override
    public void setText(String nText) {
        try {
            Leader_GameData tLeaderGD = null;
            try {
                Json json = new Json();
                json.setIgnoreUnknownFields(true);
                FileHandle jsonFile = Gdx.files.local(nText + ".json");
                if (jsonFile.exists()) {
                    try {
                        tLeaderGD = json.fromJson(Leader_GameData.class, jsonFile.readString("UTF-8"));
                    } catch (Exception ex) {}
                }
                if (tLeaderGD == null) {
                    jsonFile = FileManager.loadFile(nText + ".json");
                    if (jsonFile.exists()) {
                        try {
                            tLeaderGD = json.fromJson(Leader_GameData.class, jsonFile.readString("UTF-8"));
                        } catch (Exception ex) {}
                    }
                }
                
                if (tLeaderGD == null) {
                    FileHandle file = Gdx.files.local(nText);
                    if (file.exists()) {
                        tLeaderGD = (Leader_GameData)CFG.deserialize(file.readBytes());
                    } else {
                        file = FileManager.loadFile(nText);
                        if (file.exists()) {
                            tLeaderGD = (Leader_GameData)CFG.deserialize(file.readBytes());
                        }
                    }
                }
            }
            catch (Exception ex) {
                // empty catch block
            }
            if (tLeaderGD != null) {
                this.leaderOfCiv = tLeaderGD.getLeaderOfCiv();
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
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Leader") + ": "));
            tData.add(new ME_Hover_2Type_Text(this.leaderOfCiv.getName(), CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.editorLeaders, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
        catch (Exception ex) {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Leader") + ": "));
            tData.add(new ME_Hover_2Type_Text("---", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.editorLeaders, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_LEADER);
    }
}

