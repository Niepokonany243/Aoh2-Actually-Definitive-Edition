/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.I18NBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

public class LangManager {
    public static boolean translationsKeysMode = false;
    public int iLNOT = 0;
    private FileHandle fileHandleCivs;
    private Locale localeCivs;
    private I18NBundle bundleCivs;
    private FileHandle fileHandleLoading;
    private Locale localeLoading;
    private I18NBundle bundleLoading;
    private FileHandle fileHandle;
    private Locale locale;
    private I18NBundle bundle;
    private FileHandle fileHandleFormable;
    private Locale localeFormable;
    private I18NBundle bundleFormable;
    private KeyOutput keyOutput;
    public List<I18NBundle> modsBundles = new ArrayList<I18NBundle>();
    public int modsBundlesSize = 0;

    public String get(String key) {
        return this.keyOutput.get(key);
    }

    public String get(String key, int nValue) {
        return this.keyOutput.get(key, nValue);
    }

    public String get(String key, long nValue) {
        return this.keyOutput.get(key, nValue);
    }

    public String get(String key, String nValue) {
        return this.keyOutput.get(key, nValue);
    }

    public String get(String key, String nValue, String nValue2) {
        return this.keyOutput.get(key, nValue, nValue2);
    }

    public String getCiv(String key) {
        String out = key;
        try {
            if (key != null) {
                int i;
                for (i = 0; i < this.modsBundlesSize; ++i) {
                    try {
                        out = this.modsBundles.get(i).get(key);
                        return this.stripBOM(out);
                    }
                    catch (Exception ex2_3) {
                        continue;
                    }
                }
                for (i = 0; i < this.modsBundlesSize; ++i) {
                    try {
                        if (key.indexOf(95) <= 0) continue;
                        try {
                            out = this.modsBundles.get(i).get(key);
                            return this.stripBOM(out);
                        }
                        catch (Exception ex2_1) {
                            try {
                                out = this.modsBundles.get(i).get(key.substring(0, key.indexOf(95)));
                                return this.stripBOM(out);
                            }
                            catch (Exception ex2_2) {
                                continue;
                            }
                        }
                    }
                    catch (Exception exr) {
                        // empty catch block
                    }
                }
                if (key.indexOf(95) > 0) {
                    try {
                        out = this.bundleCivs.get(key);
                        if (out != null && !out.isEmpty()) return this.stripBOM(out);
                    }
                    catch (Exception i22_1) {
                        try {
                            out = this.bundleCivs.get(key.substring(0, key.indexOf(95)));
                            if (out != null && !out.isEmpty()) return this.stripBOM(out);
                        }
                        catch (Exception i22_2) {
                        }
                    }
                } else {
                    out = this.bundleCivs.get(key);
                    if (out != null && !out.isEmpty()) return this.stripBOM(out);
                }
            }
            out = this.bundleCivs.get(key);
            if (out != null && !out.isEmpty()) return this.stripBOM(out);
            return key;
        }
        catch (MissingResourceException ex) {
            if (key.indexOf(95) > 0) {
                try {
                    out = this.bundleCivs.get(key.substring(0, key.indexOf(95)));
                    if (out != null && !out.isEmpty()) return this.stripBOM(out);
                }
                catch (MissingResourceException exr) {
                    // empty catch block
                }
            }
            try {
                if (CFG.isAndroid()) {
                    try {
                        FileHandle file = Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(key) + "/" + CFG.ideologiesMgr.getRealTag(key) + "_NM");
                        out = file.readString();
                        if (out != null && !out.isEmpty()) return this.stripBOM(out);
                    }
                    catch (GdxRuntimeException er) {
                        FileHandle file = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(key) + "/" + CFG.ideologiesMgr.getRealTag(key) + "_NM");
                        out = file.readString();
                        if (out != null && !out.isEmpty()) return this.stripBOM(out);
                    }
                }
                FileHandle file = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(key) + "/" + CFG.ideologiesMgr.getRealTag(key) + "_NM");
                out = file.readString();
                if (out != null && !out.isEmpty()) return this.stripBOM(out);
                return key;
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                String fallback = this.stripBOM(key);
                return (fallback == null || fallback.isEmpty()) ? key : fallback;
            }
        }
    }

    public final String stripBOM(String s) {
        if (s == null) return "";
        String out = s.replace("\ufeff", "").trim();
        return out;
    }

    public String getForm(String key) {
        try {
            if (key != null) {
                int i;
                key = this.stripBOM(key);
                for (i = 0; i < this.modsBundlesSize; ++i) {
                    try {
                        return this.stripBOM(this.modsBundles.get(i).get(key));
                    }
                    catch (Exception ex2_3) {
                        continue;
                    }
                }
                for (i = 0; i < this.modsBundlesSize; ++i) {
                    try {
                        if (key.indexOf(95) <= 0) continue;
                        try {
                            return this.stripBOM(this.modsBundles.get(i).get(key));
                        }
                        catch (Exception ex2_1) {
                            try {
                                return this.stripBOM(this.modsBundles.get(i).get(key.substring(0, key.indexOf(95))));
                            }
                            catch (Exception ex2_2) {
                                continue;
                            }
                        }
                    }
                    catch (Exception exr) {
                        // empty catch block
                    }
                }
                if (key.indexOf(95) > 0) {
                    try {
                        return this.stripBOM(this.bundleFormable.get(key));
                    }
                    catch (Exception i22_3) {
                        try {
                            return this.stripBOM(this.bundleFormable.get(key.substring(0, key.indexOf(95))));
                        }
                        catch (Exception i22_4) {
                        }
                    }
                } else {
                    return this.stripBOM(this.bundleFormable.get(key));
                }
            }
            return this.stripBOM(this.bundleFormable.get(key));
        }
        catch (MissingResourceException ex) {
            if (key.indexOf(95) > 0) {
                try {
                    return this.stripBOM(this.bundleFormable.get(key.substring(0, key.indexOf(95))));
                }
                catch (MissingResourceException missingResourceException) {
                    // empty catch block
                }
            }
            return this.stripBOM(key);
        }
    }

    public String getLOA(String key) {
        try {
            return this.stripBOM(this.bundleLoading.get(key));
        }
        catch (MissingResourceException ex) {
            return this.stripBOM("");
        }
        catch (NullPointerException ex) {
            CFG.loaTM = 0L;
            return this.stripBOM("");
        }
    }

    public final void updateKeyOutput() {
        this.keyOutput = translationsKeysMode ? new KeyOutput(){

            @Override
            public String get(String key) {
                return "[" + key + "]";
            }

            @Override
            public String get(String key, int iValue) {
                return "[" + key + "]";
            }

            @Override
            public String get(String key, long iValue) {
                return "[" + key + "]";
            }

            @Override
            public String get(String key, String sValue) {
                return "[" + key + "]";
            }

            @Override
            public String get(String key, String sValue, String sValue2) {
                return "[" + key + "]";
            }
        } : new KeyOutput(){

            @Override
            public String get(String key) {
                try {
                    if (key == null) return "null";
                    String out = key;
                    key = LangManager.this.stripBOM(key);
                    for (int i = 0; i < LangManager.this.modsBundlesSize; ++i) {
                        try {
                            out = LangManager.this.stripBOM(LangManager.this.modsBundles.get(i).get(key));
                            if (out != null && !out.isEmpty()) return out;
                        }
                        catch (Exception ex) {}
                    }
                    out = LangManager.this.stripBOM(LangManager.this.bundle.get(key));
                    if (out.isEmpty()) CFG.logText("LangEmpty", key);
                    return out.isEmpty() ? key : out;
                }
                catch (Exception ex) {
                    return key;
                }
            }

            @Override
            public String get(String key, int iValue) {
                try {
                    String out;
                    for (int i = 0; i < LangManager.this.modsBundlesSize; ++i) {
                        try {
                            out = LangManager.this.stripBOM(LangManager.this.modsBundles.get(i).format(key, iValue));
                            if (!out.isEmpty()) return out;
                        }
                        catch (Exception ex) {}
                    }
                    out = LangManager.this.stripBOM(LangManager.this.bundle.format(key, iValue));
                    return out.isEmpty() ? key : out;
                }
                catch (Exception ex) {
                    return key;
                }
            }

            @Override
            public String get(String key, long iValue) {
                try {
                    String out;
                    for (int i = 0; i < LangManager.this.modsBundlesSize; ++i) {
                        try {
                            out = LangManager.this.stripBOM(LangManager.this.modsBundles.get(i).format(key, iValue));
                            if (!out.isEmpty()) return out;
                        }
                        catch (Exception ex) {}
                    }
                    out = LangManager.this.stripBOM(LangManager.this.bundle.format(key, iValue));
                    return out.isEmpty() ? key : out;
                }
                catch (Exception ex) {
                    return key;
                }
            }

            @Override
            public String get(String key, String sValue) {
                try {
                    String out;
                    for (int i = 0; i < LangManager.this.modsBundlesSize; ++i) {
                        try {
                            out = LangManager.this.stripBOM(LangManager.this.modsBundles.get(i).format(key, sValue));
                            if (!out.isEmpty()) return out;
                        }
                        catch (Exception ex) {}
                    }
                    out = LangManager.this.stripBOM(LangManager.this.bundle.format(key, sValue));
                    return out.isEmpty() ? key : out;
                }
                catch (Exception ex) {
                    return key;
                }
            }

            @Override
            public String get(String key, String sValue, String sValue2) {
                try {
                    String out;
                    for (int i = 0; i < LangManager.this.modsBundlesSize; ++i) {
                        try {
                            out = LangManager.this.stripBOM(LangManager.this.modsBundles.get(i).format(key, sValue, sValue2));
                            if (!out.isEmpty()) return out;
                        }
                        catch (Exception ex) {}
                    }
                    out = LangManager.this.stripBOM(LangManager.this.bundle.format(key, sValue, sValue2));
                    return out.isEmpty() ? key : out;
                }
                catch (Exception ex) {
                    return key;
                }
            }
        };
    }

    public LangManager(String nTag) {
        this.fileHandle = FileManager.loadFile("game/languages/Bundle");
        this.locale = new Locale(nTag);
        this.bundle = I18NBundle.createBundle(this.fileHandle, this.locale);
        this.initCivsBundle(nTag);
        this.initLoadingBundle(nTag);
        this.loadModsLanguages(nTag);
        this.updateKeyOutput();
    }

    public final void initCivsBundle(String nTag) {
        this.fileHandleCivs = FileManager.loadFile("game/languages/civilizations/Bundle");
        this.localeCivs = new Locale(nTag);
        this.bundleCivs = I18NBundle.createBundle(this.fileHandleCivs, this.localeCivs);
        this.fileHandleFormable = FileManager.loadFile("game/languages/formable/Bundle");
        this.localeFormable = new Locale(nTag);
        this.bundleFormable = I18NBundle.createBundle(this.fileHandleFormable, this.localeFormable);
    }

    public final void initLoadingBundle(String nTag) {
        this.fileHandleLoading = FileManager.loadFile("game/languages/loading/Bundle");
        this.localeLoading = new Locale(nTag);
        this.bundleLoading = I18NBundle.createBundle(this.fileHandleLoading, this.localeLoading);
        try {
            this.iLNOT = Integer.parseInt(this.getLOA("NumOfTexts"));
        }
        catch (IllegalArgumentException ex) {
            this.iLNOT = 0;
        }
    }

    public final void dispose() {
        this.fileHandle = null;
        this.locale = null;
        this.bundle = null;
        this.fileHandleCivs = null;
        this.localeCivs = null;
        this.bundleCivs = null;
        this.fileHandleLoading = null;
        this.localeLoading = null;
        this.bundleLoading = null;
        this.fileHandleFormable = null;
        this.localeFormable = null;
        this.bundleFormable = null;
    }

    public void loadModsLanguages(String nTag) {
        try {
            Locale localeCivs;
            FileHandle fileHandleCivs;
            int i;
            this.modsBundles.clear();
            for (i = 0; i < sUM.sUFS; ++i) {
                if (Gdx.files.external(sUM.sUF.get(i) + "languages/Bundle" + "_" + nTag + ".properties").exists()) {
                    fileHandleCivs = Gdx.files.external(sUM.sUF.get(i) + "languages/Bundle");
                    localeCivs = new Locale(nTag);
                    this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
                    continue;
                }
                if (Gdx.files.external(sUM.sUF.get(i) + "languages/Bundle" + ".properties").exists()) {
                    fileHandleCivs = Gdx.files.external(sUM.sUF.get(i) + "languages/Bundle");
                    localeCivs = new Locale("");
                    this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
                    continue;
                }
                if (Gdx.files.internal(sUM.sUF.get(i) + "languages/Bundle" + "_" + nTag + ".properties").exists()) {
                    fileHandleCivs = Gdx.files.internal(sUM.sUF.get(i) + "languages/Bundle");
                    localeCivs = new Locale(nTag);
                    this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
                    continue;
                }
                if (!Gdx.files.internal(sUM.sUF.get(i) + "languages/Bundle" + ".properties").exists()) continue;
                fileHandleCivs = Gdx.files.internal(sUM.sUF.get(i) + "languages/Bundle");
                localeCivs = new Locale("");
                this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
            }
            for (i = 0; i < sUM.sUIIS; ++i) {
                if (Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "languages/Bundle" + "_" + nTag + ".properties").exists()) {
                    fileHandleCivs = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "languages/Bundle");
                    localeCivs = new Locale(nTag);
                    this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
                    continue;
                }
                if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "languages/Bundle" + ".properties").exists()) continue;
                fileHandleCivs = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "languages/Bundle");
                localeCivs = new Locale("");
                this.modsBundles.add(I18NBundle.createBundle(fileHandleCivs, localeCivs));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.modsBundlesSize = this.modsBundles.size();
    }

    static interface KeyOutput {
        public String get(String var1);

        public String get(String var1, int var2);

        public String get(String var1, long var2);

        public String get(String var1, String var2);

        public String get(String var1, String var2, String var3);
    }
}

