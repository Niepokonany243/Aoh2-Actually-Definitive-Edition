/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Migrate2;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Union_GameData;
import age.of.civilizations2.jakowski.lukasz.Unions_GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;

public class UnionsManager {
    public Union_GameData createUnion_Data;
    public Unions_GameData unions;

    public UnionsManager() {
        try {
            try {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external("game/unions/data") : Gdx.files.local("game/unions/data");
                try {
                    this.unions = (Unions_GameData)CFG.deserialize(file.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                }
            }
            catch (GdxRuntimeException er) {
                FileHandle file = FileManager.loadFile("game/unions/data");
                try {
                    this.unions = (Unions_GameData)CFG.deserialize(file.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {}
            }
        }
        catch (GdxRuntimeException e) {
            this.unions = new Unions_GameData();
        }
        Button_Diplomacy_Migrate2.updateT();
    }

    public final void saveUnions() {
        if (this.unions.lUnions.size() > 0) {
            OutputStream osData = null;
            try {
                FileHandle fileUnions = FileManager.IS_MAC ? Gdx.files.external("game/unions/data") : Gdx.files.local("game/unions/data");
                fileUnions.writeBytes(CFG.serialize(this.unions), false);
            }
            catch (IOException iOException) {
            }
            finally {
                if (osData != null) {
                    try {
                        osData.close();
                    }
                    catch (Exception exception) {}
                }
            }
        }
    }

    public final String getUnionTag(String nTag) {
        int i;
        String[] tData = nTag.split(";");
        for (i = 0; i < tData.length; ++i) {
            tData[i] = CFG.ideologiesMgr.getRealTag(tData[i]);
        }
        block1: for (i = 0; i < this.unions.lUnions.size(); ++i) {
            for (int j = 0; j < this.unions.lUnions.get((int)i).lCivsTags.size(); ++j) {
                int k;
                boolean found = false;
                for (k = 0; k < tData.length; ++k) {
                    if (!tData[k].equals(this.unions.lUnions.get((int)i).lCivsTags.get(j))) continue;
                    found = true;
                    break;
                }
                if (!found) continue block1;
                if (j != this.unions.lUnions.get((int)i).lCivsTags.size() - 1 || tData.length != this.unions.lUnions.get((int)i).lCivsTags.size()) continue;
                for (k = 0; k < CFG.core.getCivsSize(); ++k) {
                    if (!this.unions.lUnions.get((int)i).lCreateCivTag.equals(CFG.core.getCiv(k).getCivTag())) continue;
                    return "";
                }
                return this.unions.lUnions.get((int)i).lCreateCivTag;
            }
        }
        return "";
    }
}

