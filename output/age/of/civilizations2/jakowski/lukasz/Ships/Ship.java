
package age.of.civilizations2.jakowski.lukasz.Ships;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    public float posX;
    public float posY;
    public float moveToX;
    public float moveToY;
    public float angle;
    public Vector2[] vPoints;
    public List<Integer> width = new ArrayList<Integer>();
    public float speed = 2.0f;
    public float currentWidth = 0.0f;
    public int iPrecision = 200;
    int tID = 0;

    public Ship(int nX, int nY, int moveToX, int moveToY, int catX, int catY) {
        int j;
        this.posX = nX;
        this.posY = nY;
        this.moveToX = moveToX;
        this.moveToY = moveToY;
        this.vPoints = new Vector2[this.iPrecision];
        Vector[] dataSet = new Vector2[]{new Vector2(nX, nY), new Vector2(nX, nY), new Vector2(catX, catY), new Vector2(moveToX, moveToY), new Vector2(moveToX, moveToY)};
        CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
        for (j = 0; j < this.iPrecision; ++j) {
            this.vPoints[j] = new Vector2();
            oCatmull.valueAt(this.vPoints[j], (float)j / ((float)this.iPrecision - 1.0f));
        }
        for (j = 0; j < this.iPrecision - 1; ++j) {
            this.width.add((int)Math.ceil(Math.sqrt((this.vPoints[j + 1].x - this.vPoints[j].x) * (this.vPoints[j + 1].x - this.vPoints[j].x) + (this.vPoints[j].y - this.vPoints[j + 1].y) * (this.vPoints[j].y - this.vPoints[j + 1].y))));
        }
    }

    public void drawCurrentScale(SpriteBatch oSB) {
        this.currentWidth += this.speed;
        if (this.currentWidth >= (float)this.width.get(this.tID).intValue()) {
            this.currentWidth -= (float)this.width.get(this.tID).intValue();
            if (++this.tID > 198) {
                this.tID = 0;
            }
        }
        this.posX = this.vPoints[this.tID].x + (this.vPoints[this.tID + 1].x - this.vPoints[this.tID].x) * (this.currentWidth / (float)this.width.get(this.tID).intValue());
        this.posY = this.vPoints[this.tID].y + (this.vPoints[this.tID + 1].y - this.vPoints[this.tID].y) * (this.currentWidth / (float)this.width.get(this.tID).intValue());
        this.angle = (int)Math.abs(360.0 + Math.atan2(this.vPoints[this.tID].y - this.vPoints[this.tID + 1].y, -this.vPoints[this.tID].x + this.vPoints[this.tID + 1].x) * 180.0 / Math.PI) % 360;
    }

    public void draw(SpriteBatch oSB) {
        this.currentWidth += this.speed;
        if (this.currentWidth >= (float)this.width.get(this.tID).intValue()) {
            this.currentWidth -= (float)this.width.get(this.tID).intValue();
            if (this.tID++ > 198) {
                this.tID = 0;
            }
        }
        this.posX = this.vPoints[this.tID].x + (this.vPoints[this.tID + 1].x - this.vPoints[this.tID].x) * (this.currentWidth / (float)this.width.get(this.tID).intValue());
        this.posY = this.vPoints[this.tID].y + (this.vPoints[this.tID + 1].y - this.vPoints[this.tID].y) * (this.currentWidth / (float)this.width.get(this.tID).intValue());
        this.angle = (int)Math.abs(360.0 + Math.atan2(this.vPoints[this.tID].y - this.vPoints[this.tID + 1].y, -this.vPoints[this.tID].x + this.vPoints[this.tID + 1].x) * 180.0 / Math.PI) % 360;
    }
}

