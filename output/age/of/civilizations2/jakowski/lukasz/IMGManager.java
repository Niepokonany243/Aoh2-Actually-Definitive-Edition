
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class IMGManager {
    public static List<Image> images = new ArrayList<Image>();

    public static final int addIMG(String imageName) {
        return IMGManager.addIMG(imageName, Texture.TextureFilter.Linear);
    }

    public static final int addIMG(String imageName, Texture.TextureFilter nTextureFilter) {
        return IMGManager.addIMG(imageName, Pixmap.Format.RGBA8888, nTextureFilter);
    }

    public static final int addIMG(String imageName, Pixmap.Format nFormat, Texture.TextureFilter nTextureFilter) {
        images.add(new Image(new Texture(FileManager.loadFile(imageName), nFormat, true), nTextureFilter));
        return images.size() - 1;
    }

    public static final int addIMG2(String imageName) {
        return IMGManager.addIMG2(imageName, Texture.TextureFilter.Linear);
    }

    public static final int addIMG2(String imageName, Texture.TextureFilter nTextureFilter) {
        return IMGManager.addIMG2(imageName, Pixmap.Format.RGBA8888, nTextureFilter);
    }

    public static final int addIMG2(String imageName, Pixmap.Format nFormat, Texture.TextureFilter nTextureFilter) {
        images.add(new Image(new Texture(FileManager.loadFile(imageName), nFormat, true), nTextureFilter));
        return images.size() - 1;
    }

    public static final int addIMG(String imageName, Pixmap.Format nFormat, Texture.TextureFilter nTextureFilter, Texture.TextureWrap nTextureWrap) {
        block8: {
            try {
                int i;
                if (!CFG.getIsDesktop()) break block8;
                if (FileManager.IS_MAC) {
                    for (i = 0; i < sUM.sUFS; ++i) {
                        if (!Gdx.files.external(sUM.sUF.get(i) + imageName).exists()) continue;
                        images.add(new Image(new Texture(Gdx.files.external(sUM.sUF.get(i) + imageName), nFormat, false), nTextureFilter, nTextureWrap));
                        return images.size() - 1;
                    }
                } else {
                    for (i = 0; i < sUM.sUFS; ++i) {
                        if (!FileManager.loadFile(sUM.sUF.get(i) + imageName).exists()) continue;
                        images.add(new Image(new Texture(FileManager.loadFile(sUM.sUF.get(i) + imageName), nFormat, false), nTextureFilter, nTextureWrap));
                        return images.size() - 1;
                    }
                }
                for (i = 0; i < sUM.sUIIS; ++i) {
                    if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + imageName).exists()) continue;
                    images.add(new Image(new Texture(Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + imageName), nFormat, false), nTextureFilter, nTextureWrap));
                    return images.size() - 1;
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        if (FileManager.IS_MAC && Gdx.files.external(imageName).exists()) {
            images.add(new Image(new Texture(Gdx.files.external(imageName), nFormat, false), nTextureFilter, nTextureWrap));
            return images.size() - 1;
        }
        images.add(new Image(new Texture(FileManager.loadFile(imageName), nFormat, true), nTextureFilter, nTextureWrap));
        return images.size() - 1;
    }

    public static Image getIMG(int ID) {
        return images.get(ID);
    }

    public static int getImagesSize() {
        return images.size();
    }

    public static List<Image> getImages() {
        return images;
    }

    public static final int buildPix() {
        Pixmap nPix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        nPix.drawPixel(0, 0, Color.WHITE.toIntBits());
        images.add(new Image(new Texture(nPix)));
        return images.size() - 1;
    }

    public static final Image buildPix_IMG() {
        Pixmap nPix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        nPix.drawPixel(0, 0, Color.WHITE.toIntBits());
        return new Image(new Texture(nPix));
    }

    public static final Image buildPix_IMG_Empty() {
        Pixmap nPix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        nPix.drawPixel(0, 0, new Color(1.0f, 1.0f, 1.0f, 0.0f).toIntBits());
        return new Image(new Texture(nPix));
    }

    public static final Image loadImage(String imageName) {
        return IMGManager.loadImage(imageName, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear);
    }

    public static final Image loadImage(String imageName, Pixmap.Format pixmapFormat) {
        return IMGManager.loadImage(imageName, pixmapFormat, Texture.TextureFilter.Linear);
    }

    public static final Image loadImage(String imageName, Texture.TextureFilter textureFilter) {
        return IMGManager.loadImage(imageName, Pixmap.Format.RGBA8888, textureFilter);
    }

    public static final Image loadImage(String imageName, Pixmap.Format pixmapFormat, Texture.TextureFilter textureFilter) {
        return new Image(IMGManager.loadTexture(imageName, pixmapFormat), textureFilter);
    }

    public static final Image loadImage(String imageName, Pixmap.Format nFormat, Texture.TextureFilter nTextureFilter, Texture.TextureWrap nTextureWrap) {
        return new Image(IMGManager.loadTexture(imageName, nFormat), nTextureFilter, nTextureWrap);
    }

    public static final Texture loadTexture(String sFile) {
        return IMGManager.loadTexture(sFile, Pixmap.Format.RGBA8888);
    }

    public static final Texture loadTexture_RGB888(String sFile) {
        return IMGManager.loadTexture(sFile, Pixmap.Format.RGB888);
    }

    public static final Texture loadTexture(String sFile, Pixmap.Format nFormat) {
        try {
            block10: {
                try {
                    int i;
                    if (!CFG.getIsDesktop()) break block10;
                    if (FileManager.IS_MAC) {
                        for (i = 0; i < sUM.sUFS; ++i) {
                            if (!Gdx.files.external(sUM.sUF.get(i) + sFile).exists()) continue;
                            return new Texture(Gdx.files.external(sUM.sUF.get(i) + sFile), nFormat, false);
                        }
                    } else {
                        for (i = 0; i < sUM.sUFS; ++i) {
                            if (!FileManager.loadFile(sUM.sUF.get(i) + sFile).exists()) continue;
                            return new Texture(FileManager.loadFile(sUM.sUF.get(i) + sFile), nFormat, false);
                        }
                    }
                    for (i = 0; i < sUM.sUIIS; ++i) {
                        if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile).exists()) continue;
                        return new Texture(Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile), nFormat, false);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (FileManager.IS_MAC && Gdx.files.external(sFile).exists()) {
                return new Texture(Gdx.files.external(sFile), nFormat, false);
            }
            return new Texture(FileManager.loadFile(sFile), nFormat, false);
        }
        catch (GdxRuntimeException ex) {
            CFG.exceptionStack(ex);
            return new Texture(FileManager.loadFile("UI/imageNotFound.png"));
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

