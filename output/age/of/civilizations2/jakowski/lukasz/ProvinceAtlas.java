package age.of.civilizations2.jakowski.lukasz;

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

    public static void init() {
        if (packer != null) {
            packer.dispose();
        }
        
        packer = new PixmapPacker(2048, 2048, Pixmap.Format.RGBA8888, 2, true);
        provinceRegions.clear();
        initialized = true;
    }

    public static void addProvince(int provinceID, Pixmap pixmap) {
        if (!initialized) init();
        if (pixmap != null) {
            packer.pack(String.valueOf(provinceID), pixmap);
        }
    }

    public static void finalise() {
        if (atlas != null) {
            atlas.dispose();
        }
        atlas = packer.generateTextureAtlas(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest, false);
        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            TextureAtlas.AtlasRegion region = atlas.findRegion(String.valueOf(i));
            if (region != null) {
                provinceRegions.put(i, region);
            }
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
    
    public static void dispose() {
        if (packer != null) packer.dispose();
        if (atlas != null) atlas.dispose();
        provinceRegions.clear();
        initialized = false;
    }
}
