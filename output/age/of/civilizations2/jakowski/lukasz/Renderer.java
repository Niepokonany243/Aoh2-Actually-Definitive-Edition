
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.KNAM;
import age.of.civilizations2.jakowski.lukasz.Province_Border_Values;
import age.of.civilizations2.jakowski.lukasz.RendererSpriteBatch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrewer.ShapeDrawer;

public class Renderer {
    public static RendererSpriteBatch oSBBorder2 = new RendererSpriteBatch();
    public static TextureRegion drawerPix;
    public static ShapeDrawer shapeDrawer;
    public static float shaderTime2;
    public static ShaderProgram shaderAlpha;
    public static ShaderProgram shaderWater3;
    public static ShaderProgram shaderAlpha_Map;
    public static Province_Border_Values provinceBorderValues;
    public static String charset;
    public static GlyphLayout_Game glyphLayout;
    public static List<KNAM> aNS;
    public static int iANSS;
    public static final Vector3 textRotatedVector3;
    private static final Matrix4 tmpMatrix;
    private static final Vector3 tmpRotationAxis;
    private static int numOfScissors;
    public static Rectangle peekBounds;

    public static void init() {
        Renderer.oSBBorder2.oSBR = new SpriteBatch();
        Images.pix = IMGManager.buildPix_IMG();
        Images.pix2 = IMGManager.buildPix();
        drawerPix = new TextureRegion(Images.pix.getTexture());
        shapeDrawer = new ShapeDrawer(Renderer.oSBBorder2.oSBR, drawerPix);
        String flagFragment = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform sampler2D u_texture2;\nvoid main()    \n{\n vec4 mask = texture2D(u_texture2, v_texCoords);\n gl_FragColor = vec4(mask.rgb, mask.a * (v_color.a * texture2D(u_texture, v_texCoords).a));\n}";
        String vertexShader = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n";
        shaderAlpha = new ShaderProgram(vertexShader, flagFragment);
        ShaderProgram.pedantic = false;
        shaderAlpha.bind();
        shaderAlpha.setUniformi("u_texture", 0);
        shaderAlpha.setUniformi("u_texture2", 1);
        String defaultVertex = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}";
        String testFragment = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\n\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\n\n\nuniform sampler2D u_texture;\nuniform sampler2D u_texture2;\nuniform float time;\nuniform vec2 resolution;\nuniform float u_maskScale;\nuniform float u_maskScaleY;\nuniform float u_useMask;\nuniform vec2 u_maskOffset;\n\n\nconst float PI = 3.1415;\n// \u901f\u5ea6\nconst float speed = 0.03;\nconst float speed_x = 0.06;\nconst float speed_y = 0.06;\n\n// \u6298\u5c04\u89d2\nconst float emboss = 0.3; \t\t// \u51f9\u51f8\u5f3a\u5ea6\nconst float intensity = 2.4;\t// \u5f3a\u5ea6\nconst int steps = 8;  \t\t\t// \u6ce2\u7eb9\u5bc6\u5ea6\nconst float frequency = 4.0;  \t// \u9891\u7387\nconst float angle = 7.0;\n\nconst float delta = 50.0;  \t\t// \u589e\u5e45\uff08\u8d8a\u5c0f\u8d8a\u6fc0\u70c8\uff09\nconst float intence = 200.0;   \t// \u660e\u6697\u5f3a\u5ea6\n\n// \u9ad8\u5149\nconst float reflectionCutOff = 0.012;\nconst float reflectionIntence = 80000.0;\n\nfloat col(vec2 coord)\n{\n    float delta_theta = 2.0 * PI / angle;\n    float col = 0.0;\n    float theta = 0.0;\n    for (int i = 0; i < steps; i++)\n    {\n        vec2 adjc = coord;\n        theta = delta_theta * float(i);\n        adjc.x += cos(theta)*time*speed + time * speed_x;\n        adjc.y -= sin(theta)*time*speed - time * speed_y;\n        col = col + cos((adjc.x * cos(theta) -\n            adjc.y * sin(theta)) * frequency) * intensity;\n    }\n    return cos(col);\n}\n\n\nvoid main()\n{\n    vec2 p = v_texCoords, c1 = p, c2 = p;\n    float cc1 = col(c1);\n\n    c2.x += resolution.x/delta;\n    float dx = emboss*(cc1-col(c2))/delta;\n\n    c2.x = p.x;\n    c2.y += resolution.y/delta;\n    float dy = emboss*(cc1-col(c2))/delta;\n    c1.x = c1.x +dx;\n    c1.y =  c1.y+dy;\n\n    float alpha = 1.0+dot(dx,dy)*intence;\n\n\n    vec4 col = texture2D(u_texture,c1);\n vec2 newCoords = vec2(v_texCoords.x * u_maskScale, v_texCoords.y * u_maskScaleY);\n vec4 mask = vec4(1.0, 1.0, 1.0, 1.0); \n\tmask = texture2D(u_texture2, v_texCoords);\n  gl_FragColor = vec4(col.rgb, mask.a * col.a);\n}";
        shaderWater3 = new ShaderProgram(defaultVertex, testFragment);
        shaderWater3.bind();
        shaderWater3.setUniformi("u_texture", 0);
        shaderWater3.setUniformi("u_texture2", 1);
        shaderWater3.setUniformf("u_useMask", 1.0f);
        shaderWater3.setUniformf("u_maskScale", 20.0f);
        shaderWater3.setUniformf("u_maskOffset", 0.0f, 0.0f);
        shaderAlpha_Map = new ShaderProgram(vertexShader, FileManager.loadFile("game/shader/map_overlay_fragment.glsl").readString());
        ShaderProgram.pedantic = false;
        shaderAlpha_Map.bind();
        shaderAlpha_Map.setUniformi("u_texture", 0);
        shaderAlpha_Map.setUniformi("u_texture2", 1);
        shaderAlpha_Map.setUniformf("u_useMask", 1.0f);
        shaderAlpha_Map.setUniformf("u_maskScale", 20.0f);
        shaderAlpha_Map.setUniformf("u_maskOffset", 0.0f, 0.0f);
    }

    public static final void setShaderWater3(SpriteBatch oSB) {
        oSB.setShader(shaderWater3);
        shaderWater3.setUniformf("time", shaderTime2);
        shaderWater3.setUniformf("resolution", new Vector2(IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight()));
    }

    public static final void drawBox2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        Renderer.drawBox(oSB, Images.buttonGame, nPosX, nPosY, nWidth, nHeight);
    }

    public static final void drawBox(SpriteBatch oSB, int imageID, int nPosX, int nPosY, int nWidth, int nHeight) {
        int iHCeil = (nHeight + 1) / 2;
        int iHFloor = nHeight / 2;
        Image img = IMGManager.getIMG(imageID);
        nWidth = Math.max(nWidth, img.getWidth() * 2);
        img.draw2(oSB, nPosX, nPosY, nWidth - img.getWidth(), iHCeil);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY, img.getWidth(), iHCeil, true);
        img.draw2(oSB, nPosX, nPosY + iHCeil, nWidth - img.getWidth(), iHFloor, false, true);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY + iHCeil, img.getWidth(), iHFloor, true, true);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawBox3(SpriteBatch oSB, int imgID, int nPosX, int nPosY, int nWidth, int nHeight, float fAlpha) {
        int segmentWidth = 16;
        int gap = 1;
        int endX = nPosX + nWidth;
        for (int x = nPosX; x < endX; x += segmentWidth + gap) {
            int drawW = Math.min(segmentWidth, endX - x);
            Renderer.drawBox4(oSB, imgID, x, nPosY, drawW, nHeight, fAlpha);
        }
    }

    public static final void drawBox4(SpriteBatch oSB, int imgID, int nPosX, int nPosY, int nWidth, int nHeight, float fAlpha) {
        int iHCeil = (nHeight + 1) / 2;
        int iHFloor = nHeight / 2;
        Image img = IMGManager.getIMG(imgID);
        nWidth = Math.max(nWidth, img.getWidth() * 2);
        img.draw2(oSB, nPosX, nPosY, nWidth - img.getWidth(), iHCeil);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY, img.getWidth(), iHCeil, true);
        img.draw2(oSB, nPosX, nPosY + iHCeil, nWidth - img.getWidth(), iHFloor, false, true);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY + iHCeil, img.getWidth(), iHFloor, true, true);
    }

    public static final void drawBox2(SpriteBatch oSB, int imgID, int nPosX, int nPosY, int nWidth, int nHeight, float fAlpha) {
        int iHCeil = (nHeight + 1) / 2;
        int iHFloor = nHeight / 2;
        Image img = IMGManager.getIMG(imgID);
        nWidth = Math.max(nWidth, img.getWidth() * 2);
        img.draw2(oSB, nPosX, nPosY, nWidth - img.getWidth(), iHCeil);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY, img.getWidth(), iHCeil, true);
        img.draw2(oSB, nPosX, nPosY + iHCeil, nWidth - img.getWidth(), iHFloor, false, true);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY + iHCeil, img.getWidth(), iHFloor, true, true);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawBox2(SpriteBatch oSB, Image img, int nPosX, int nPosY, int nWidth, int nHeight, float fAlpha) {
        int iHCeil = (nHeight + 1) / 2;
        int iHFloor = nHeight / 2;
        nWidth = Math.max(nWidth, img.getWidth() * 2);
        img.draw2(oSB, nPosX, nPosY, nWidth - img.getWidth(), iHCeil);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY, img.getWidth(), iHCeil, true);
        img.draw2(oSB, nPosX, nPosY + iHCeil, nWidth - img.getWidth(), iHFloor, false, true);
        img.draw2(oSB, nPosX + nWidth - img.getWidth(), nPosY + iHCeil, img.getWidth(), iHFloor, true, true);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawText(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        Renderer.drawText(oSB, 0, sText, nPosX, nPosY, color);
    }

    public static final void drawText(SpriteBatch oSB, int fontID, String sText, int nPosX, int nPosY, Color color) {
        if (sText == null || sText.isEmpty() || CFG.fontMain.size() <= fontID) return;
        BitmapFont font = CFG.fontMain.get(fontID);
        synchronized (font.getData()) {
            try {
                font.setColor(color);
                font.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
            } catch (Throwable ex) {}
        }
    }

    public static final void drawTextWithShadow(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        Renderer.drawTextWithShadow(oSB, 0, sText, nPosX, nPosY, color);
    }

    public static final void drawTextWithShadow(SpriteBatch oSB, int fontID, String sText, int nPosX, int nPosY, Color color) {
        if (sText == null || sText.isEmpty() || CFG.fontMain.size() <= fontID) return;
        BitmapFont font = CFG.fontMain.get(fontID);
        synchronized (font.getData()) {
            try {
                font.setColor(0, 0, 0, 0.75f * color.a);
                font.draw((Batch)oSB, sText, (float)(nPosX - 1), (float)(-nPosY - 1));
                font.setColor(color);
                font.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
            } catch (Throwable ex) {
                
            }
        }
    }

    public static final void drawTextWithShadowAlpha(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        Renderer.drawTextWithShadowAlpha(oSB, 0, sText, nPosX, nPosY, color);
    }

    public static final void drawTextWithShadowAlpha(SpriteBatch oSB, int fontID, String sText, int nPosX, int nPosY, Color color) {
        try {
            if (sText != null && CFG.fontMain.size() > fontID) {
                BitmapFont font = CFG.fontMain.get(fontID);
                synchronized (font.getData()) {
                    try {
                        font.setColor(0.0f, 0.0f, 0.0f, 0.15f * color.a);
                        font.draw((Batch)oSB, sText, (float)(nPosX - 1), (float)(-nPosY - 1));
                        font.setColor(color);
                        font.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
                    } catch (Throwable ex) {
                    }
                }
            }
        }
        catch (Exception exception) {}
    }

    public static final void drawTextWithShadowRotated(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        Renderer.drawTextWithShadowRotated(oSB, 0, sText, nPosX, nPosY, color, rotate);
    }

    
    public static final void drawTextWithShadowRotated(SpriteBatch oSB, int fontID, String sText, int nPosX, int nPosY, Color color, float rotate) {
        if (sText != null && CFG.fontMain.size() > fontID) {
            Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
            try {
                BitmapFont font = CFG.fontMain.get(fontID);
                synchronized (font.getData()) {
                    try {
                        Matrix4 mx4Font = new Matrix4();
                        mx4Font.rotate(textRotatedVector3, rotate);
                        mx4Font.setTranslation(nPosX, -nPosY, 0.0f);
                        oSB.setTransformMatrix(mx4Font);
                        font.setColor(0.0f, 0.0f, 0.0f, 0.7f * color.a);
                        font.draw((Batch)oSB, sText, -1.0f, -1.0f);
                        font.setColor(color);
                        font.draw((Batch)oSB, sText, 0.0f, 0.0f);
                    } catch (Throwable ex) {
                    }
                }
            }
            catch (Exception exception) {}
            finally {
                oSB.setTransformMatrix(oldTransformMatrix);
            }
        }
    }

    public static final void drawTextRotated(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        Renderer.drawTextRotated(oSB, 0, sText, nPosX, nPosY, color, rotate);
    }

    
    public static final void drawTextRotated(SpriteBatch oSB, int fontID, String sText, int nPosX, int nPosY, Color color, float rotate) {
        if (sText != null && CFG.fontMain.size() > fontID) {
            Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
            try {
                BitmapFont font = CFG.fontMain.get(fontID);
                synchronized (font.getData()) {
                    try {
                        Matrix4 mx4Font = new Matrix4();
                        mx4Font.rotate(new Vector3(0.0f, 0.0f, 1.0f), rotate);
                        mx4Font.setTranslation(nPosX, -nPosY, 0.0f);
                        oSB.setTransformMatrix(mx4Font);
                        font.setColor(color);
                        font.draw((Batch)oSB, sText, 0.0f, 0.0f);
                    } catch (Throwable ex) {}
                }
            }
            catch (Exception exception) {}
            finally {
                oSB.setTransformMatrix(oldTransformMatrix);
            }
        }
    }

    public static void aNK(int iProvinceID) {
        aNS.add(new KNAM(iProvinceID));
        iANSS = aNS.size();
    }

    public static List<Integer> mFlash = new java.util.ArrayList<>();
    public static List<Long> mFlashTime = new java.util.ArrayList<>();
    public static void addMissileFlash(int nProvinceID) {
        mFlash.add(nProvinceID);
        mFlashTime.add(CFG.currentTimeMillis);
    }

    public static void dNAI(SpriteBatch oSB) {
        try {
            int i = iANSS - 1;
            while (i >= 0) {
                aNS.get(i).draw(oSB);
                if (Renderer.aNS.get((int)i).mRM) {
                    aNS.remove(i);
                    iANSS = aNS.size();
                }
                --i;
            }

            
            for (int k = mFlash.size() - 1; k >= 0; k--) {
                long time = CFG.currentTimeMillis - mFlashTime.get(k);
                if (time > 1000) {
                    mFlash.remove(k);
                    mFlashTime.remove(k);
                    continue;
                }
                
                int pID = mFlash.get(k);
                if (CFG.core.getProv(pID).getDrawProv()) {
                    float alpha = 0.8f * (1.0f - (float)time / 1000.0f);
                    oSB.setColor(new Color(1.0f, 0.4f, 0.0f, alpha));
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, 
                        (int)((float)(CFG.core.getProv(pID).getCeShX() + CFG.core.getProv(pID).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - 50,
                        (int)((float)(CFG.core.getProv(pID).getCeShY() + CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc()) - 50,
                        100, 100);
                    oSB.setColor(Color.WHITE);
                    CFG.setRenderO(true);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    
    public static final synchronized void drawTextRotatedBorder(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        if (sText != null && CFG.fontBorder != null) {
            Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
            try {
                Matrix4 mx4Font = new Matrix4();
                mx4Font.rotate(textRotatedVector3, rotate);
                mx4Font.setTranslation(nPosX, -nPosY, 0.0f);
                oSB.setTransformMatrix(mx4Font);
                CFG.fontBorder.setColor(color);
                CFG.fontBorder.draw((Batch)oSB, sText, 0.0f, 0.0f);
            }
            catch (Exception exception) {}
            finally {
                oSB.setTransformMatrix(oldTransformMatrix);
            }
        }
    }

    public static final synchronized void drawTextRotatedBorder(SpriteBatch oSB, String sText, int nPosX, int nPosY, Matrix4 mx4Font) {
        try {
            if (sText != null && CFG.fontBorder != null) {
                mx4Font.setTranslation(nPosX, -nPosY, 0.0f);
                oSB.setTransformMatrix(mx4Font);
                CFG.fontBorder.draw((Batch)oSB, sText, 0.0f, 0.0f);
            }
        }
        catch (Exception exception) {}
    }

    public static final synchronized void drawTextRotatedBorder_2(SpriteBatch oSB, String sText, int nPosX, int nPosY, float rotate) {
        try {
            if (sText != null && CFG.fontBorder != null) {
                tmpMatrix.idt();
                tmpMatrix.translate(nPosX, -nPosY, 0.0f);
                tmpMatrix.rotate(tmpRotationAxis, rotate);
                oSB.setTransformMatrix(tmpMatrix);
                CFG.fontBorder.draw((Batch)oSB, sText, 0.0f, 0.0f);
            }
        }
        catch (Exception exception) {}
    }

    public static final void clearUnclearedScissors(SpriteBatch oSB) {
        while (numOfScissors > 0) {
            Renderer.clipView_End(oSB);
        }
    }

    public static final void clipViewPeek() {
        try {
            peekBounds = ScissorStack.peekScissors();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void clipViewPeek_Add(SpriteBatch oSB) {
        try {
            Renderer.clearUnclearedScissors(oSB);
            if (peekBounds != null) {
                ScissorStack.pushScissors(peekBounds);
                ++numOfScissors;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final boolean clipView_Start(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        try {
            Rectangle clipBounds = new Rectangle(nPosX, nPosY, nWidth, nHeight);
            oSB.flush();
            ++numOfScissors;
            return ScissorStack.pushScissors(clipBounds);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return false;
        }
    }

    public static final void clipView_End(SpriteBatch oSB) {
        try {
            numOfScissors = Math.max(numOfScissors - 1, 0);
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (Exception exception) {
            
        }
    }

    public static final void drawBox2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float fAlpha) {
        Images.pix.draw2(oSB, nPosX, nPosY, nWidth, 1);
        Images.pix.draw2(oSB, nPosX + nWidth - 1, nPosY + 1, 1, nHeight - 2);
        Images.pix.draw2(oSB, nPosX, nPosY + 1, 1, nHeight - 2);
        Images.pix.draw2(oSB, nPosX, nPosY + nHeight - 1, nWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    static {
        provinceBorderValues = new Province_Border_Values();
        charset = "";
        glyphLayout = new GlyphLayout_Game();
        aNS = new ArrayList<KNAM>();
        iANSS = 0;
        textRotatedVector3 = new Vector3(0.0f, 0.0f, 1.0f);
        tmpMatrix = new Matrix4();
        tmpRotationAxis = new Vector3(0.0f, 0.0f, 1.0f);
        numOfScissors = 0;
        peekBounds = null;
    }
}

