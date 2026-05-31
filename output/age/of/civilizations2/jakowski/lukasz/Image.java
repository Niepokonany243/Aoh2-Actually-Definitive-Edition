
package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image {
    private Texture texture;
    private int iWidth;
    private int iHeight;

    public Image(Texture texture) {
        this.init(texture, Texture.TextureFilter.Linear, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
    }

    public Image(Texture texture, Texture.TextureFilter nTextureFilter) {
        this.init(texture, nTextureFilter, nTextureFilter, Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
    }

    public Image(Texture texture, Texture.TextureFilter nTextureFilter, Texture.TextureWrap nTextureWrap) {
        this.init(texture, nTextureFilter, nTextureFilter, nTextureWrap, nTextureWrap);
    }

    public Image(Texture texture, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter) {
        this.init(texture, minFilter, magFilter, Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
    }

    public Image(Texture texture, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap wrapU, Texture.TextureWrap wrapV) {
        this.init(texture, minFilter, magFilter, wrapU, wrapV);
    }

    public final void init(Texture texture, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap wrapU, Texture.TextureWrap wrapV) {
        this.texture = texture;
        this.texture.setFilter(minFilter, magFilter);
        this.texture.setWrap(wrapU, wrapV);
        this.iWidth = texture.getWidth();
        this.iHeight = texture.getHeight();
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int originX, int originY, int nWidth, int nHeight, float scaleX, float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
        oSB.draw(this.texture, nPosX, -nPosY - this.iHeight, originX, originY, nWidth, nHeight, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY) {
        oSB.draw(this.texture, (float)nPosX, (float)(-(nPosY + this.iHeight)));
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, boolean flipX, boolean flipY) {
        this.draw_1(oSB, nPosX, nPosY, this.iWidth, this.iHeight, 0, 0, this.iWidth, this.iHeight, flipX, flipY);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, float scale) {
        this.draw(oSB, nPosX, nPosY + (int)((float)this.iHeight * scale - (float)this.iHeight), 0, 0, this.iWidth, this.iHeight, scale, scale, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void drawProvince(SpriteBatch oSB, int nPosX, int nPosY, float scale) {
        this.draw(oSB, nPosX, nPosY, 0, 0, this.iWidth, this.iHeight, scale, scale, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, float scale, float rotation) {
        this.draw(oSB, nPosX, nPosY + (int)((float)this.iHeight * scale - (float)this.iHeight), 0, 0, this.iWidth, this.iHeight, scale, scale, rotation, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        oSB.draw(this.texture, (float)nPosX, (float)(-nPosY - this.iHeight), (float)nWidth, (float)this.iHeight);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.draw(this.texture, (float)nPosX, (float)(-(nPosY + nHeight)), (float)nWidth, (float)nHeight);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, srcX, srcY, this.iWidth, this.iHeight, false, false);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, rotation, 0, 0, nWidth, nHeight, false, false);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, boolean flipX, boolean flipY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, this.iHeight, 0, 0, this.iWidth, this.iHeight, flipX, flipY);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX, boolean flipY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, 0, 0, this.iWidth, this.iHeight, flipX, flipY);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation, int srcX) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, rotation, srcX, 0, nWidth, nHeight, false, false);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation, int srcX, boolean flipX) {
        this.draw(oSB, nPosX, nPosY, 0, 0, nWidth, -nHeight, 1.0f, 1.0f, rotation, srcX, 0, nWidth, nHeight, flipX, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        this.draw_1(oSB, nPosX, nPosY, nWidth, this.iHeight, 0, 0, nWidth, this.iHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, 0, 0, nWidth, nHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, srcX, 0, nWidth, nHeight, false, false);
    }

    public final void draw2_Scale(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fScale) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, fScale, fScale, 0.0f, 0, 0, nWidth, nHeight, false, false);
    }

    public final void draw2_Scale(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX, boolean flipY, float fScale) {
        this.draw(oSB, nPosX, nPosY + (int)((float)nHeight * fScale) - this.iHeight, 0, 0, nWidth, nHeight, fScale, fScale, 0.0f, 0, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fRotate) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, 0, 0, nWidth, nHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fRotate, int srcX) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, 0, nWidth, nHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fRotate, boolean flipX, boolean flipY) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, 0, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fRotate, boolean flipX, boolean flipY, int srcX) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, srcX, srcY, nWidth, nHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, float fRotate) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, srcY, nWidth, nHeight, false, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, float fRotate, boolean flipX, boolean flipY) {
        this.draw2(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, srcY, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, 0, 0, nWidth, nHeight, flipX, false);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX, boolean flipY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, 0, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, boolean flipX, boolean flipY) {
        this.draw2_2(oSB, nPosX, nPosY, nWidth, nHeight, srcX, srcY, nWidth, nHeight, flipX, flipY);
    }

    public final void drawO(SpriteBatch oSB) {
        this.drawO(oSB, 0, 0, 0, 0, this.iWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, this.iWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, boolean flipX) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, this.iWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, flipX, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, boolean flipX, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, this.iWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, flipX, flipY);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, boolean flipX, boolean flipY, int nWidth, int nHeight) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, float scale) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, this.iWidth, this.iHeight, scale, scale, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, this.iHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, this.iHeight, false, flipY);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, boolean flipX, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, this.iHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, this.iHeight, flipX, flipY);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, flipX, flipY);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, nHeight, false, false);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, srcX, srcY, nWidth, nHeight, false, false);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, float fRotate) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, srcY, nWidth, nHeight, false, false);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, float fRotate, boolean flipX, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, fRotate, srcX, srcY, nWidth, nHeight, flipX, flipY);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, nHeight, flipX, false);
    }

    public final void draw2O(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, boolean flipX, boolean flipY) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, nWidth, nHeight, flipX, flipY);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, -nHeight, 1.0f, 1.0f, rotation, 0, 0, nWidth, nHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation, int srcX) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, -nHeight, 1.0f, 1.0f, rotation, srcX, 0, nWidth, nHeight, false, false);
    }

    public final void drawO(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float rotation, int srcX, boolean flipX) {
        this.drawO(oSB, nPosX, nPosY, 0, 0, nWidth, -nHeight, 1.0f, 1.0f, rotation, srcX, 0, nWidth, nHeight, flipX, false);
    }

    public final void draw3(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.drawO(oSB, nPosX, nPosY + nHeight, 0, 0, nWidth, nHeight, 1.0f, 1.0f, 0.0f, 0, 0, this.iWidth, this.iHeight, false, false);
    }

    private final void draw(SpriteBatch oSB, int nPosX, int nPosY, int originX, int originY, int nWidth, int nHeight, float scaleX, float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
        oSB.draw(this.texture, nPosX, -(nPosY + this.iHeight), originX, originY, nWidth, nHeight, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    private final void draw_1(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
        oSB.draw(this.texture, (float)nPosX, (float)(-(nPosY + this.iHeight)), (float)nWidth, (float)nHeight, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    private final void draw2(SpriteBatch oSB, int nPosX, int nPosY, int originX, int originY, int nWidth, int nHeight, float scaleX, float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
        oSB.draw(this.texture, nPosX, -(nPosY + nHeight), originX, originY, nWidth, nHeight, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    private final void draw2_2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
        oSB.draw(this.texture, (float)nPosX, (float)(-(nPosY + nHeight)), (float)nWidth, (float)nHeight, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    public final Texture getTexture() {
        return this.texture;
    }

    public final void setTexture(Texture texture) {
        this.texture = texture;
    }

    public final int getWidth() {
        return this.iWidth;
    }

    public final int getHeight() {
        return this.iHeight;
    }

    public final void dispose() {
        if (this.texture != null) {
            this.texture.dispose();
        }
        this.texture = null;
    }
}

