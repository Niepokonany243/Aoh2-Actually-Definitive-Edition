
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Graph
implements ME_Hover_2Type {
    public int id = 0;
    private Graph2 graph2;

    public ME_Hover_2Type_Graph(Graph2.GraphType graphType, int id) {
        this.id = id;
        try {
            this.graph2 = new Graph2("A", "B", 0, 0, CFG.BUTTON_W * 2 + CFG.BUTTON_W / 2, CFG.BUTTON_H, true, 1, graphType, false, id, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public ME_Hover_2Type_Graph(Graph2.GraphType graphType, int id, boolean split) {
        this.id = id;
        try {
            this.graph2 = new Graph2("A", "B", 0, 0, CFG.BUTTON_W * 2 + CFG.BUTTON_W / 2, CFG.BUTTON_H, true, 1, graphType, split, id, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public ME_Hover_2Type_Graph(Graph2.GraphType graphType, int id, int nWidth, int nHeight) {
        this.id = id;
        try {
            this.graph2 = new Graph2("A", "B", 0, 0, nWidth, nHeight, true, 1, graphType, false, id, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public ME_Hover_2Type_Graph(Graph2.GraphType graphType, int id, int nWidth, int nHeight, boolean split) {
        this.id = id;
        try {
            this.graph2 = new Graph2("A", "B", 0, 0, nWidth, nHeight, true, 1, graphType, split, id, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        try {
            this.graph2.drawE(oSB, nPosX, nPosY + CFG.PADD, false, false);
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        try {
            this.graph2.drawE(oSB, nPosX, nPosY + CFG.PADD, false, false);
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public int getWidth() {
        return this.graph2.getWidthE() - CFG.PADD;
    }

    @Override
    public int getHeight() {
        return this.graph2.getHeightE() + CFG.PADD;
    }
}

