/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Civ_GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalletOfCivsColors_Data {
    private List<PalletOfCivsColors_Civ_GameData> lData = new ArrayList<PalletOfCivsColors_Civ_GameData>();
    private List<String> lCivsTags = new ArrayList<String>();
    private int iDataSize = 0;
    private String UPDATE_KEY = null;

    public final void setCivColor(String nTag, Color_GameData nColor) {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (!this.lCivsTags.get(i).equals(nTag)) continue;
            this.lData.get(i).setColor(nColor);
            return;
        }
        this.lData.add(new PalletOfCivsColors_Civ_GameData(nColor));
        this.lCivsTags.add(nTag);
        this.iDataSize = this.lData.size();
    }

    public final void readData(boolean isInternal) {
        this.lData = new ArrayList<PalletOfCivsColors_Civ_GameData>();
        this.lCivsTags = new ArrayList<String>();
        this.iDataSize = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            FileHandle file = null;
            try {
                if (isInternal) {
                    file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                } else {
                    try {
                        file = Gdx.files.local("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                    }
                    catch (Exception ex) {
                        file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                    }
                }
                try {
                    PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                    CFG.core.getCiv(i).setR((int)(nCivColor.getColor().getR() * 255.0f));
                    CFG.core.getCiv(i).setG((int)(nCivColor.getColor().getG() * 255.0f));
                    CFG.core.getCiv(i).setB((int)(nCivColor.getColor().getB() * 255.0f));
                }
                catch (ClassNotFoundException e) {
                    CFG.palletManager.loadCivilizationStandardColor(0);
                }
                catch (IOException e) {
                    CFG.palletManager.loadCivilizationStandardColor(0);
                }
                continue;
            }
            catch (GdxRuntimeException ex) {
                CFG.palletManager.loadCivilizationStandardColor(0);
            }
        }
    }

    /*
     * Exception decompiling
     */
    public final void saveData() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 18[CATCHBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final int getDataSize() {
        return this.iDataSize;
    }

    public final String getUPDATE_KEY() {
        return this.UPDATE_KEY;
    }

    public final void setUPDATE_KEY(String nUPDATE_KEY) {
        this.UPDATE_KEY = nUPDATE_KEY;
    }
}

