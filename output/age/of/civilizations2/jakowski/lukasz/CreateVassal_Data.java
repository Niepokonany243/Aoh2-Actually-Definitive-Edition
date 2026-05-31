/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CreateVassal_Data {
    public int iCapitalProvinceID = -1;
    public String sCivTag = null;
    public Color oColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public boolean playAsVassal = false;
    private Image flagOfCivilization = null;
    private Image flagOfCivilizationH = null;

    public final void setCivTag(String nTag) {
        this.sCivTag = nTag;
        this.loadFlag();
    }

    public final void loadFlag() {
        block30: {
            block29: {
                this.dispose();
                if (this.sCivTag == null) {
                    return;
                }
                try {
                    try {
                        this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/flagsH/" + this.sCivTag + ".png")), Texture.TextureFilter.Linear);
                    }
                    catch (GdxRuntimeException e) {
                        try {
                            try {
                                this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".png")), Texture.TextureFilter.Linear);
                            }
                            catch (Exception exr) {
                                try {
                                    this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.sCivTag + ".png")), Texture.TextureFilter.Linear);
                                }
                                catch (Exception exrrr) {
                                    this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".png")), Texture.TextureFilter.Linear);
                                }
                            }
                        }
                        catch (GdxRuntimeException exr) {
                            if (CFG.isAndroid()) {
                                try {
                                    this.flagOfCivilizationH = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FLH.png")), Texture.TextureFilter.Linear);
                                }
                                catch (GdxRuntimeException eq) {
                                    this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FLH.png")), Texture.TextureFilter.Linear);
                                }
                                break block29;
                            }
                            this.flagOfCivilizationH = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FLH.png")), Texture.TextureFilter.Linear);
                        }
                    }
                }
                catch (Exception ex) {
                    this.dispose();
                }
                catch (OutOfMemoryError e) {
                    this.dispose();
                }
            }
            try {
                try {
                    this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flags/" + this.sCivTag + ".png")), Texture.TextureFilter.Linear);
                }
                catch (GdxRuntimeException e) {
                    try {
                        try {
                            this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".png")), Texture.TextureFilter.Linear);
                        }
                        catch (Exception exr) {
                            try {
                                this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.sCivTag + ".png")), Texture.TextureFilter.Linear);
                            }
                            catch (Exception exrr) {
                                this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".png")), Texture.TextureFilter.Linear);
                            }
                        }
                    }
                    catch (GdxRuntimeException exr) {
                        if (CFG.isAndroid()) {
                            try {
                                this.flagOfCivilization = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FL.png")), Texture.TextureFilter.Linear);
                            }
                            catch (GdxRuntimeException eq) {
                                this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FL.png")), Texture.TextureFilter.Linear);
                            }
                            break block30;
                        }
                        this.flagOfCivilization = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + "_FL.png")), Texture.TextureFilter.Linear);
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.dispose();
            }
            catch (OutOfMemoryError e) {
                this.dispose();
            }
        }
    }

    public final Image getFlagOfCiv() {
        return this.flagOfCivilization;
    }

    public final Image getFlagOfCivH() {
        if (this.flagOfCivilizationH == null) {
            return this.flagOfCivilization;
        }
        return this.flagOfCivilizationH;
    }

    public final void dispose() {
        if (this.flagOfCivilizationH != null) {
            this.flagOfCivilizationH.getTexture().dispose();
            this.flagOfCivilizationH = null;
        }
        if (this.flagOfCivilization != null) {
            this.flagOfCivilization.getTexture().dispose();
            this.flagOfCivilization = null;
        }
    }
}

