
package age.of.civilizations2.jakowski.lukasz.Ships;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrewer.JoinType;

public class ShipLine {
    public int fromProvinceID = -1;
    public int toProvinceID = -1;
    public List<Point_XY2> points = new ArrayList<Point_XY2>();
    public int pointsSize = 0;
    public Vector2[] vPoints;
    public List<Integer> width = new ArrayList<Integer>();

    public void addNewPoint() {
        this.points.add(new Point_XY2((int)((float)CFG.map.getMpC().getPX() - (float)Touch.getMousePosX() / CFG.map.getMpS().getCurrSc()) * -1, (int)((float)CFG.map.getMpC().getPY() - (float)Touch.getMousePosY() / CFG.map.getMpS().getCurrSc()) * -1));
        this.pointsSize = this.points.size();
        this.buildData();
    }

    public void removePoint() {
        if (this.pointsSize > 0) {
            this.points.remove(this.pointsSize - 1);
            this.pointsSize = this.points.size();
        }
        this.buildData();
    }

    public void addNewPoint_Just(int nX, int nY) {
        this.points.add(new Point_XY2(nX, nY));
        this.pointsSize = this.points.size();
    }

    public final void buildData() {
        if (this.pointsSize > 2) {
            int j;
            this.width.clear();
            this.vPoints = new Vector2[GameValues.gvShips.SHIP_LINE_PRECISION];
            Vector[] dataSet = new Vector2[this.pointsSize + 2];
            dataSet[0] = new Vector2(this.points.get(0).getPX(), this.points.get(0).getPY());
            for (int i = 0; i < this.pointsSize; ++i) {
                dataSet[i + 1] = new Vector2(this.points.get(i).getPX(), this.points.get(i).getPY());
            }
            dataSet[this.pointsSize + 1] = new Vector2(this.points.get(this.pointsSize - 1).getPX(), this.points.get(this.pointsSize - 1).getPY());
            CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
            for (j = 0; j < GameValues.gvShips.SHIP_LINE_PRECISION; ++j) {
                this.vPoints[j] = new Vector2();
                oCatmull.valueAt(this.vPoints[j], (float)j / ((float)GameValues.gvShips.SHIP_LINE_PRECISION - 1.0f));
            }
            for (j = 0; j < GameValues.gvShips.SHIP_LINE_PRECISION - 1; ++j) {
                this.width.add((int)Math.ceil(Math.sqrt((this.vPoints[j + 1].x - this.vPoints[j].x) * (this.vPoints[j + 1].x - this.vPoints[j].x) + (this.vPoints[j].y - this.vPoints[j + 1].y) * (this.vPoints[j].y - this.vPoints[j + 1].y))));
            }
            this.width.add(1);
        }
    }

    public void draw(SpriteBatch oSB) {
        try {
            if (this.pointsSize > 2) {
                Array<Vector2> nPath = new Array<Vector2>();
                for (int j = 0; j < GameValues.gvShips.SHIP_LINE_PRECISION; ++j) {
                    nPath.add(new Vector2((this.vPoints[j].x + (float)CFG.map.getMpC().getPX()) * CFG.map.getMpS().getCurrSc(), (-this.vPoints[j].y - (float)CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc()));
                }
                
                
                Renderer.oSBBorder2.end();
                Renderer.oSBBorder2.begin();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

