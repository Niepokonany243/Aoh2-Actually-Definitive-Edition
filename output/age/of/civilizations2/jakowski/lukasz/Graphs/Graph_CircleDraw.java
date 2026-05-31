/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_CircleData;
import age.of.civilizations2.jakowski.lukasz.Image;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ShortArray;
import java.util.List;

public class Graph_CircleDraw {
    private PolygonSpriteBatch oPB;
    private TextureRegion texture;
    private Image textureOver;
    private Image circleFrame;
    private Vector2 center;
    private Vector2 centerTop;
    private Vector2 leftTop;
    private Vector2 leftBottom;
    private Vector2 rightBottom;
    private Vector2 rightTop;
    private float[] fv;
    private IntersectAt intersectAt;

    public Graph_CircleDraw(String nFileName, String fileNameOver, String nFlieNameFrame) {
        this.texture = new TextureRegion(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "graph/" + nFileName), Pixmap.Format.RGBA8888, true));
        this.textureOver = new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "graph/" + fileNameOver), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
        this.circleFrame = new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "graph/" + nFlieNameFrame), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear);
        this.oPB = new PolygonSpriteBatch();
        this.center = new Vector2(this.texture.getRegionWidth() / 2, this.texture.getRegionHeight() / 2);
        this.centerTop = new Vector2(this.texture.getRegionWidth() / 2, this.texture.getRegionHeight());
        this.leftTop = new Vector2(0.0f, this.texture.getRegionHeight());
        this.leftBottom = new Vector2(0.0f, 0.0f);
        this.rightBottom = new Vector2(this.texture.getRegionWidth(), 0.0f);
        this.rightTop = new Vector2(this.texture.getRegionWidth(), this.texture.getRegionHeight());
        this.setPercentage(0.0f);
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, List<Graph_CircleData> nData, boolean isActive) {
        try {
            try {
                this.drawCircle100(oSB, nPosX, nPosY, new Color((float)CFG.core.getCiv(nData.get(0).getDataID()).getR() / 255.0f, (float)CFG.core.getCiv(nData.get(0).getDataID()).getG() / 255.0f, (float)CFG.core.getCiv(nData.get(0).getDataID()).getB() / 255.0f, 1.0f));
            }
            catch (IndexOutOfBoundsException ex) {
                this.drawCircle100(oSB, nPosX, nPosY, new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), 1.0f));
            }
            oSB.end();
            this.drawGraph(nPosX, nPosY, nData);
            oSB.begin();
            this.textureOver.drawO(oSB, nPosX, nPosY);
            if (isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.335f));
                this.textureOver.drawO(oSB, nPosX, nPosY);
                oSB.setColor(Color.WHITE);
            }
            this.circleFrame.drawO(oSB, nPosX, nPosY);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    private final void drawGraph(int nPosX, int nPosY, List<Graph_CircleData> nData) {
        if (this.oPB.isDrawing()) {
            this.oPB.end();
        }
        try {
            this.oPB.begin();
            float drawnPercentage = nData.get(0).getPercentage();
            for (int i = 1; i < nData.size(); ++i) {
                this.setPercentage(drawnPercentage);
                try {
                    this.drawCircle(nPosX, nPosY, new Color((float)CFG.core.getCiv(nData.get(i).getDataID()).getR() / 255.0f, (float)CFG.core.getCiv(nData.get(i).getDataID()).getG() / 255.0f, (float)CFG.core.getCiv(nData.get(i).getDataID()).getB() / 255.0f, 1.0f));
                }
                catch (IndexOutOfBoundsException ex) {
                    this.drawCircle(nPosX, nPosY, new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), 1.0f));
                }
                drawnPercentage += nData.get(i).getPercentage();
            }
            this.oPB.end();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            if (this.oPB.isDrawing()) {
                this.oPB.end();
            }
        }
    }

    private final void drawCircle100(SpriteBatch oSB, int nPosX, int nPosY, Color nColor) {
        oSB.setColor(nColor);
        oSB.draw(this.texture.getTexture(), nPosX, -nPosY - this.texture.getRegionHeight(), 0.0f, 0.0f, this.texture.getRegionWidth(), this.texture.getRegionHeight(), 1.0f, 1.0f, 0.0f, 0, 0, this.texture.getRegionWidth(), this.texture.getRegionHeight(), false, false);
        oSB.setColor(Color.WHITE);
    }

    private final void drawCircle(int nPosX, int nPosY, Color nColor) {
        if (this.fv == null) {
            return;
        }
        EarClippingTriangulator e = new EarClippingTriangulator();
        ShortArray sv = e.computeTriangles(this.fv);
        PolygonRegion polyReg = new PolygonRegion(this.texture, this.fv, sv.toArray());
        PolygonSprite poly = new PolygonSprite(polyReg);
        poly.setOrigin(0.0f, 0.0f);
        poly.setPosition(nPosX, CFG.GAMEHEIGHT - this.texture.getRegionHeight() - nPosY);
        poly.setRotation(0.0f);
        poly.setColor(nColor);
        poly.draw(this.oPB);
    }

    public final void setPercentage(float percent) {
        float angle = this.convertToRadians(90.0f);
        float len = this.texture.getRegionWidth() > this.texture.getRegionHeight() ? (float)this.texture.getRegionWidth() : (float)this.texture.getRegionHeight();
        float dy = (float)(Math.sin(angle -= this.convertToRadians(percent * 360.0f / 100.0f)) * (double)len);
        float dx = (float)(Math.cos(angle) * (double)len);
        Vector2 line = new Vector2(this.center.x + dx, this.center.y + dy);
        Vector2 v = this.IntersectPoint(line);
        this.fv = this.intersectAt == IntersectAt.TOP ? (v.x >= (float)(this.texture.getRegionWidth() / 2) ? new float[]{this.center.x, this.center.y, this.centerTop.x, this.centerTop.y, this.leftTop.x, this.leftTop.y, this.leftBottom.x, this.leftBottom.y, this.rightBottom.x, this.rightBottom.y, this.rightTop.x, this.rightTop.y, v.x, v.y} : new float[]{this.center.x, this.center.y, this.centerTop.x, this.centerTop.y, v.x, v.y}) : (this.intersectAt == IntersectAt.BOTTOM ? new float[]{this.center.x, this.center.y, this.centerTop.x, this.centerTop.y, this.leftTop.x, this.leftTop.y, this.leftBottom.x, this.leftBottom.y, v.x, v.y} : (this.intersectAt == IntersectAt.LEFT ? new float[]{this.center.x, this.center.y, this.centerTop.x, this.centerTop.y, this.leftTop.x, this.leftTop.y, v.x, v.y} : (float[])(this.intersectAt == IntersectAt.RIGHT ? new float[]{this.center.x, this.center.y, this.centerTop.x, this.centerTop.y, this.leftTop.x, this.leftTop.y, this.leftBottom.x, this.leftBottom.y, this.rightBottom.x, this.rightBottom.y, v.x, v.y} : null)));
    }

    private final Vector2 IntersectPoint(Vector2 line) {
        Vector2 v = new Vector2();
        boolean isIntersect = Intersector.intersectSegments(this.leftTop, this.rightTop, this.center, line, v);
        if (isIntersect) {
            this.intersectAt = IntersectAt.TOP;
            return v;
        }
        isIntersect = Intersector.intersectSegments(this.leftBottom, this.rightBottom, this.center, line, v);
        if (isIntersect) {
            this.intersectAt = IntersectAt.BOTTOM;
            return v;
        }
        isIntersect = Intersector.intersectSegments(this.leftTop, this.leftBottom, this.center, line, v);
        if (isIntersect) {
            this.intersectAt = IntersectAt.LEFT;
            return v;
        }
        isIntersect = Intersector.intersectSegments(this.rightTop, this.rightBottom, this.center, line, v);
        if (isIntersect) {
            this.intersectAt = IntersectAt.RIGHT;
            return v;
        }
        this.intersectAt = IntersectAt.NONE;
        return null;
    }

    private final float convertToRadians(float angleInDegrees) {
        float angleInRadians = angleInDegrees * ((float)Math.PI / 180);
        return angleInRadians;
    }

    public final int getWidth() {
        return this.circleFrame.getWidth();
    }

    public static enum IntersectAt {
        NONE,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT;

    }
}

