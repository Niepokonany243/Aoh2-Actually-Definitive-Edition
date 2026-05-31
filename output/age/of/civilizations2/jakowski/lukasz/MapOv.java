/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadMap;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class MapOv {
    public List<Overlay> lOv = new ArrayList<Overlay>();
    public int iOSi = 0;
    public List<Image> oT = new ArrayList<Image>();
    public List<Image> oM = new ArrayList<Image>();

    public final void lO(String sFile) {
        try {
            if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "overlays/" + sFile).exists()) {
                Config data = new Config();
                Json json = new Json();
                json.setElementType(Config.class, "Overlay", Overlay.class);
                data = json.fromJson(Config.class, FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "overlays/" + sFile).reader("UTF8"));
                this.lOv = new ArrayList<Overlay>();
                for (Object obj : data.Overlay) {
                    this.lOv.add((Overlay)obj);
                }
                this.iOSi = this.lOv.size();
            } else {
                this.lOv.clear();
                this.iOSi = 0;
                try {
                    this.dispose();
                }
                catch (Exception data) {}
            }
        }
        catch (Exception ex) {
            this.lOv.clear();
            this.iOSi = 0;
            try {
                this.dispose();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public final boolean lOI() {
        int i;
        if ((i = Menu_LoadMap.loadMapBG_FileID++) < this.iOSi) {
            this.oT.add(new Image(IMGManager.loadTexture_RGB888("map/" + CFG.map.getFileActiveMapPath() + "overlays/" + this.lOv.get((int)i).Tile), Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
            return true;
        }
        return false;
    }

    public final boolean lOI2() {
        int i;
        if ((i = Menu_LoadMap.loadMapBG_FileID++) < this.iOSi) {
            this.oM.add(new Image(IMGManager.loadTexture("map/" + CFG.map.getFileActiveMapPath() + "overlays/" + (CFG.getLoadHighTextureMapOverlay() ? "high/" : "low/") + this.lOv.get((int)i).Mask), Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
            this.lOv.get((int)i).u_maskScale = (float)this.oM.get(i).getWidth() / ((float)this.oT.get(i).getWidth() * this.lOv.get((int)i).Scale);
            this.lOv.get((int)i).u_maskScaleY = (float)this.oM.get(i).getHeight() / ((float)this.oT.get(i).getHeight() * this.lOv.get((int)i).Scale);
            return true;
        }
        return false;
    }

    public void dMO(SpriteBatch oSB, int nPosX, int nPosY, float fAlpha) {
        try {
            int i;
            if (this.oM.isEmpty()) {
                return;
            }
            if (CFG.map.getMpS().getCurrSc() < GameValues.gvInGame.DRAW_OV_STOP_SCALE) {
                return;
            }
            oSB.setShader(Renderer.shaderAlpha_Map);
            for (i = 0; i < this.iOSi; ++i) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (this.lOv.get((int)i).Alpha + (CFG.map.getMpS().getCurrSc() < 1.0f ? this.lOv.get((int)i).AlphaScaleZoomOut * CFG.map.getMpS().getCurrSc() : this.lOv.get((int)i).AlphaScaleZoomOut) + CFG.map.getMpS().getCurrSc() * this.lOv.get((int)i).AlphaScale) * fAlpha));
                Renderer.shaderAlpha_Map.setUniformf("u_maskScale", this.lOv.get((int)i).u_maskScale);
                Renderer.shaderAlpha_Map.setUniformf("u_maskScaleY", this.lOv.get((int)i).u_maskScaleY);
                Renderer.shaderAlpha_Map.setUniformf("u_extraColor", this.lOv.get((int)i).ExtraColor);
                this.oM.get(i).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                this.oT.get(i).draw(oSB, nPosX, nPosY, CFG.map.getMpB().getWidthM(), CFG.map.getMpB().getHeightM());
                oSB.flush();
            }
            if (CFG.map.getMpC().getSecondSideOfMap()) {
                for (i = 0; i < this.iOSi; ++i) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (this.lOv.get((int)i).Alpha + (CFG.map.getMpS().getCurrSc() < 1.0f ? this.lOv.get((int)i).AlphaScaleZoomOut * CFG.map.getMpS().getCurrSc() : this.lOv.get((int)i).AlphaScaleZoomOut) + CFG.map.getMpS().getCurrSc() * this.lOv.get((int)i).AlphaScale) * fAlpha));
                    Renderer.shaderAlpha_Map.setUniformf("u_maskScale", this.lOv.get((int)i).u_maskScale);
                    Renderer.shaderAlpha_Map.setUniformf("u_maskScaleY", this.lOv.get((int)i).u_maskScaleY);
                    Renderer.shaderAlpha_Map.setUniformf("u_extraColor", this.lOv.get((int)i).ExtraColor);
                    this.oM.get(i).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    this.oT.get(i).draw(oSB, nPosX + CFG.map.getMpB().getWidthM(), nPosY, CFG.map.getMpB().getWidthM(), CFG.map.getMpB().getHeightM());
                    oSB.flush();
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setShader(AoCGame.shaderDef);
        oSB.setColor(Color.WHITE);
    }

    public void dispose() {
        int i;
        try {
            for (i = this.oT.size() - 1; i >= 0; --i) {
                this.oT.get(i).dispose();
            }
            this.oT.clear();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (i = this.oM.size() - 1; i >= 0; --i) {
                this.oM.get(i).dispose();
            }
            this.oM.clear();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static class Config {
        public String Age_of_History;
        public ArrayList Overlay;
    }

    public static class Overlay {
        public String Tile;
        public String Mask;
        public float Scale;
        public float Alpha;
        public float AlphaScale;
        public float AlphaScaleZoomOut;
        public float ExtraColor;
        public float u_maskScale;
        public float u_maskScaleY;
    }
}

