/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate_TypesOfAction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class UnionFlagsToGenerate {
    public int iID = -1;
    public List<String> lTags = new ArrayList<String>();
    public UnionFlagsToGenerate_TypesOfAction typeOfAction = UnionFlagsToGenerate_TypesOfAction.ACTIVE_CIV_INFO;

    public final boolean generateFlag(SpriteBatch oSB) {
        try {
            int i;
            ArrayList<Image> tempFlags = new ArrayList<Image>();
            for (i = 0; i < this.lTags.size(); ++i) {
                if (FileManager.loadFile("game/flagsXH/" + this.lTags.get(i) + ".png").exists()) {
                    tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.lTags.get(i) + ".png")), Texture.TextureFilter.Linear));
                    continue;
                }
                if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + ".png").exists()) {
                    tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + ".png")), Texture.TextureFilter.Linear));
                    continue;
                }
                try {
                    try {
                        tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + this.lTags.get(i) + ".png")), Texture.TextureFilter.Linear));
                    }
                    catch (GdxRuntimeException e) {
                        try {
                            try {
                                try {
                                    tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + ".png")), Texture.TextureFilter.Linear));
                                }
                                catch (Exception exr) {
                                    tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.lTags.get(i) + ".png")), Texture.TextureFilter.Linear));
                                }
                            }
                            catch (Exception ex) {
                                tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + ".png")), Texture.TextureFilter.Linear));
                            }
                        }
                        catch (GdxRuntimeException er) {
                            if (CFG.isAndroid()) {
                                try {
                                    tempFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FLH.png")), Texture.TextureFilter.Linear));
                                }
                                catch (GdxRuntimeException erq) {
                                    tempFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FLH.png")), Texture.TextureFilter.Linear));
                                }
                                continue;
                            }
                            tempFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FLH.png")), Texture.TextureFilter.Linear));
                        }
                    }
                    continue;
                }
                catch (GdxRuntimeException ex) {
                    try {
                        try {
                            tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.lTags.get(i) + ".png")), Texture.TextureFilter.Nearest));
                        }
                        catch (GdxRuntimeException e) {
                            try {
                                tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + ".png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException exw) {
                                if (CFG.isAndroid()) {
                                    try {
                                        tempFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                                    }
                                    catch (GdxRuntimeException erq) {
                                        tempFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                                    }
                                    continue;
                                }
                                tempFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "/" + CFG.ideologiesMgr.getRealTag(this.lTags.get(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                        }
                    }
                    catch (GdxRuntimeException exe) {
                        tempFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
                    }
                    continue;
                }
                catch (OutOfMemoryError ex) {
                    // empty catch block
                }
            }
            if (this.typeOfAction == UnionFlagsToGenerate_TypesOfAction.CIV_ID_SMALL) {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, 0, IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
                oSB.setColor(Color.WHITE);
                for (i = 0; i < tempFlags.size() && i < 4; ++i) {
                    oSB.setShader(AoCGame.shaderAlpha4);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).getTexture().bind(2);
                    ((Image)tempFlags.get(i)).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).drawO(oSB, 0, 0, false, true);
                    oSB.setShader(AoCGame.shaderDef);
                }
                Image tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                tGenerated.drawO(oSB, 0, 0, false, true);
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException ex) {
                    // empty catch block
                }
                oSB.end();
                oSB.begin();
                oSB.setColor(Color.WHITE);
                tGenerated.getTexture().dispose();
                tGenerated = null;
                tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                CFG.core.getCiv(this.iID).setFlag(tGenerated);
            } else if (this.typeOfAction == UnionFlagsToGenerate_TypesOfAction.ACTIVE_CIV_INFO) {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, 0, IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
                oSB.setColor(Color.WHITE);
                for (i = 0; i < tempFlags.size() && i < 4; ++i) {
                    oSB.setShader(AoCGame.shaderAlpha4);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).getTexture().bind(2);
                    ((Image)tempFlags.get(i)).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).drawO(oSB, 0, 0, false, true);
                    oSB.setShader(AoCGame.shaderDef);
                }
                Image tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                tGenerated.drawO(oSB, 0, 0, false, true);
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException ex) {
                    // empty catch block
                }
                oSB.end();
                oSB.begin();
                oSB.setColor(Color.WHITE);
                tGenerated.getTexture().dispose();
                tGenerated = null;
                tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                CFG.setActiveCivInfoFlag(tGenerated);
            } else if (this.typeOfAction == UnionFlagsToGenerate_TypesOfAction.PLAYER_ID) {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, 0, IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
                oSB.setColor(Color.WHITE);
                for (i = 0; i < tempFlags.size() && i < 4; ++i) {
                    oSB.setShader(AoCGame.shaderAlpha4);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).getTexture().bind(2);
                    ((Image)tempFlags.get(i)).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.unionFlagsToGenerate_Manager.lFlags_H.get(i).drawO(oSB, 0, 0, false, true);
                    oSB.setShader(AoCGame.shaderDef);
                }
                Image tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                tGenerated.drawO(oSB, 0, 0, false, true);
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException ex) {
                    // empty catch block
                }
                oSB.end();
                oSB.begin();
                oSB.setColor(Color.WHITE);
                tGenerated.getTexture().dispose();
                tGenerated = null;
                tGenerated = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
                for (int i2 = 0; i2 < CFG.core.getPlayersSize(); ++i2) {
                    if (CFG.core.getPlayer(i2).getCivId() != this.iID) continue;
                    CFG.core.getPlayer(i2).loadPlayersFlag(tGenerated);
                    break;
                }
            }
            for (int i3 = 0; i3 < tempFlags.size(); ++i3) {
                ((Image)tempFlags.get(i3)).getTexture().dispose();
            }
            tempFlags.clear();
            tempFlags = null;
            return true;
        }
        catch (RuntimeException ex) {
            return false;
        }
    }
}

