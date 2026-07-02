package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;
import java.util.Map;

public class ProvinceAtlas {
    private static PixmapPacker packer;
    private static TextureAtlas atlas;
    private static Map<Integer, TextureRegion> provinceRegions = new HashMap<>();
    private static boolean initialized = false;
    private static int packedCount = 0;
    private static int packFailures = 0;
    private static int packFailuresLogged = 0;
    private static final int PACK_FAILURE_LOG_LIMIT = 12;

    public static void init() {
        if (packer != null) {
            packer.dispose();
        }
        
        int pageSize = CFG.isAndroid() ? 4096 : 2048;
        int padding = CFG.isAndroid() ? 8 : 16;
        packer = new PixmapPacker(pageSize, pageSize, Pixmap.Format.RGBA8888, padding, true);
        provinceRegions.clear();
        packedCount = 0;
        packFailures = 0;
        packFailuresLogged = 0;
        initialized = true;
        log("Init page=" + pageSize + " format=RGBA8888 padding=" + padding);
    }

    public static synchronized void addProvince(int provinceID, Pixmap pixmap) {
        if (!initialized) init();
        if (pixmap != null) {
            try {
                packer.pack(String.valueOf(provinceID), pixmap);
                ++packedCount;
            }
            catch (Exception ex) {
                ++packFailures;
                if (packFailuresLogged < PACK_FAILURE_LOG_LIMIT) {
                    ++packFailuresLogged;
                    log("Pack failed province=" + provinceID + " size=" + pixmap.getWidth() + "x" + pixmap.getHeight() + " error=" + ex.getClass().getSimpleName() + " " + ex.getMessage());
                }
            }
        }
    }

    public static void finalise() {
        if (atlas != null) {
            atlas.dispose();
        }
        if (packer == null) {
            log("Finalise skipped: packer is null");
            return;
        }
        atlas = packer.generateTextureAtlas(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest, false);
        for (Texture texture : atlas.getTextures()) {
            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
            texture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
        }
        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            TextureAtlas.AtlasRegion region = atlas.findRegion(String.valueOf(i));
            if (region != null) {
                provinceRegions.put(i, region);
            }
        }
        log("Finalise packed=" + packedCount + " failures=" + packFailures + " textures=" + getTextureCount() + " regions=" + provinceRegions.size());
        if (getTextureCount() == 0 || provinceRegions.size() == 0) {
            log("Finalise produced no drawable province regions; check ProvinceTexture preload logs above");
        }
    }

    public static TextureRegion getRegion(int provinceID) {
        return provinceRegions.get(provinceID);
    }

    public static Texture getTexture() {
        if (atlas != null && atlas.getTextures().size > 0) {
            return atlas.getTextures().first();
        }
        return null;
    }

    public static int getTextureCount() {
        return atlas == null ? 0 : atlas.getTextures().size;
    }

    public static int getRegionCount() {
        return provinceRegions.size();
    }

    public static int getPackedCount() {
        return packedCount;
    }

    public static boolean usesSingleTexture() {
        return getTextureCount() == 1;
    }
    
    public static void dispose() {
        if (packer != null) packer.dispose();
        if (atlas != null) atlas.dispose();
        packer = null;
        atlas = null;
        provinceRegions.clear();
        packedCount = 0;
        packFailures = 0;
        packFailuresLogged = 0;
        initialized = false;
    }

    private static void log(String message) {
        try {
            Gdx.app.log("ProvinceAtlas", message);
        }
        catch (Exception ex) {
            System.out.println("ProvinceAtlas: " + message);
        }
    }
}
