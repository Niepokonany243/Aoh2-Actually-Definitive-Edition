
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.Graphs.GraphLine;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GraphLine_Simple
extends GraphLine {
    private int iHeight;

    public GraphLine_Simple(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        super(fromPosX, fromPosY, toPosX, toPosY);
        this.setWidth(toPosX - fromPosX);
        this.iHeight = toPosY - fromPosY;
    }

    @Override
    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int i) {
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX - i, nPosY + this.getPosY(), this.getWidth());
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX - i + this.getWidth(), nPosY + this.getPosY(), 1, this.iHeight);
    }
}

