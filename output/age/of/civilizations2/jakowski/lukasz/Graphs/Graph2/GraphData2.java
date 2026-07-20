
package age.of.civilizations2.jakowski.lukasz.Graphs.Graph2;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrewer.JoinType;

public class GraphData2 {
    private static final float ALPHA_CIV_LINE = 0.8f;
    private int iCivID;
    private List<Long> lPointsY;
    private int iPointsSize = 0;
    private Array<Vector2> lVectorPoints;
    private int iBeginTurnID;
    private boolean drawData = true;
    private boolean visible = true;
    private boolean backAnimation = false;
    protected static final int ANIMATION_TIME = 450;
    private long lTime = 0L;
    public boolean clipStarted = false;

    protected GraphData2(int iCivID, List<Long> nPointsY, int iBeginTurnID) {
        this.iCivID = iCivID;
        this.iPointsSize = nPointsY.size();
        this.lPointsY = new ArrayList<Long>();
        this.lVectorPoints = new Array();
        for (int i = 0; i < this.iPointsSize; ++i) {
            this.lPointsY.add(nPointsY.get(i));
        }
        this.iBeginTurnID = iBeginTurnID;
        this.drawData = false;
    }

    protected final void draw(SpriteBatch oSB, int iPosX, int iPosY, int iWidth, int iHeight, List<Integer> nPointsPosX, int id, boolean active, int iFixPosY) {
        this.clipStarted = false;
        try {
            Renderer.clipView_Start(oSB, iPosX, CFG.GAMEHEIGHT - iPosY, iWidth, -iHeight);
            this.clipStarted = true;
            this.drawGraphData(oSB, iPosX, iPosY - iFixPosY, nPointsPosX, id, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (this.clipStarted) {
            Renderer.clipView_End(oSB);
            this.clipStarted = false;
        }
    }

    protected final void drawAnimation(SpriteBatch oSB, int iPosX, int iPosY, int iWidth, int iHeight, List<Integer> nPointsPosX, int id, boolean active, int iFixPosY) {
        Renderer.clipView_Start(oSB, iPosX, CFG.GAMEHEIGHT - iPosY, (int)((float)iWidth * ((float)(CFG.currentTimeMillis - this.lTime) / 450.0f)), -iHeight);
        this.drawGraphData(oSB, iPosX, iPosY - iFixPosY, nPointsPosX, id, true);
        Renderer.clipView_End(oSB);
    }

    private final void drawGraphData(SpriteBatch oSB, int iPosX, int iPosY, List<Integer> nPointsPosX, int id, boolean active) {
        block13: {
            try {
                try {
                    oSB.setColor(CFG.core.getCiv(this.iCivID).getR(), CFG.core.getCiv(this.iCivID).getG(), CFG.core.getCiv(this.iCivID).getB(), active ? 1.0f : 0.8f);
                }
                catch (Exception ex) {
                    oSB.setColor(0.05882353f, 0.05882353f, 0.05882353f, active ? 1.0f : 0.8f);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    protected final void drawCivButton(SpriteBatch oSB, int iPosX, int iPosY, boolean active) {
        oSB.setColor(Graph2.GRAPH_BG_COLOR.r, Graph2.GRAPH_BG_COLOR.g, Graph2.GRAPH_BG_COLOR.b, active ? Graph2.GRAPH_BG_COLOR.a * 2.0f : (this.drawData ? Graph2.GRAPH_BG_COLOR.a : Graph2.GRAPH_BG_COLOR.a / 4.0f));
        Images.pix.draw(oSB, iPosX, iPosY, Graph2.getGraphButtonWidth(), Graph2.getGraphButtonHeight());
        oSB.setColor(Graph2.GRAPH_BORDERS_COLOR.r, Graph2.GRAPH_BORDERS_COLOR.g, Graph2.GRAPH_BORDERS_COLOR.b, this.drawData ? Graph2.GRAPH_BORDERS_COLOR.a : 0.25f);
        try {
            oSB.setColor(CFG.core.getCiv(this.iCivID).getR(), CFG.core.getCiv(this.iCivID).getG(), CFG.core.getCiv(this.iCivID).getB(), this.drawData ? 0.8f : 0.4f);
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(0.05882353f, 0.05882353f, 0.05882353f, this.drawData ? 0.8f : 0.4f);
        }
        Images.pix.draw(oSB, iPosX, iPosY, CFG.CIV_COLOR_W, Graph2.getGraphButtonHeight());
        if (this.drawData) {
            oSB.setColor(Color.WHITE);
        } else {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.25f);
        }
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().draw(oSB, iPosX + Graph2.getGraphButtonWidth() / 2 - CFG.CIV_FLAG_WIDTH / 2, iPosY + Graph2.getGraphButtonHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).draw(oSB, iPosX + Graph2.getGraphButtonWidth() / 2 - CFG.CIV_FLAG_WIDTH / 2, iPosY + Graph2.getGraphButtonHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        oSB.setColor(Color.WHITE);
    }

    protected final void buildGraph(int iHeight, long nMinPoint, long nMaxPoint, List<Integer> nPointsPosX) {
        this.lVectorPoints.clear();
        for (int i = 0; i < this.lPointsY.size(); ++i) {
            this.lVectorPoints.add(new Vector2(nPointsPosX.get(this.iBeginTurnID + i).intValue(), (float)iHeight - (float)iHeight * (100.0f * (float)this.lPointsY.get(i).longValue()) / (float)(nMaxPoint - nMinPoint) / 100.0f));
        }
    }

    protected final long getPointY(int i) {
        try {
            return this.lPointsY.get(i);
        }
        catch (Exception ex) {
            return 0L;
        }
    }

    protected final int getPointsSize() {
        return this.iPointsSize;
    }

    protected final int getCivID() {
        return this.iCivID;
    }

    protected final int getBeginTurnID() {
        return this.iBeginTurnID;
    }

    protected final boolean getDrawData() {
        return this.drawData;
    }

    protected final void setDrawData(boolean drawData) {
        this.drawData = drawData;
    }

    protected final boolean getVisible() {
        return this.visible;
    }

    protected final void setVisible(boolean visible) {
        this.visible = visible;
    }

    protected final boolean getBackAnimation() {
        return this.backAnimation;
    }

    protected final void setBackAnimation(boolean backAnimation) {
        this.backAnimation = backAnimation;
    }

    protected final long getTime() {
        return this.lTime;
    }
}

