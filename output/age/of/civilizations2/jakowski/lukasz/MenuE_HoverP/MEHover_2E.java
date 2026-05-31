
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class MEHover_2E {
    private List<ME_Hover_2Type> lElements;
    private int iMaxHeight = 0;
    public boolean drawElement = true;

    public MEHover_2E(List<ME_Hover_2Type> nElements) {
        this.lElements = new ArrayList<ME_Hover_2Type>();
        for (int i = 0; i < nElements.size(); ++i) {
            this.lElements.add(nElements.get(i));
            this.iMaxHeight = Math.max(this.iMaxHeight, nElements.get(i).getHeight());
        }
    }

    public MEHover_2E(List<ME_Hover_2Type> nElements, boolean drawElement) {
        this.drawElement = drawElement;
        this.lElements = new ArrayList<ME_Hover_2Type>();
        for (int i = 0; i < nElements.size(); ++i) {
            this.lElements.add(nElements.get(i));
            this.iMaxHeight = Math.max(this.iMaxHeight, nElements.get(i).getHeight());
        }
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        int tX = 0;
        for (int i = 0; i < this.lElements.size(); ++i) {
            this.lElements.get(i).draw(oSB, nPosX + tX, nPosY, nAlpha);
            tX += this.lElements.get(i).getWidth();
        }
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        int tX = 0;
        for (int i = 0; i < this.lElements.size(); ++i) {
            this.lElements.get(i).draw(oSB, nPosX + tX, nPosY, nAlpha, iMaxWidth);
            tX += this.lElements.get(i).getWidth();
        }
    }

    public final int getWidth() {
        int out = 0;
        for (int i = 0; i < this.lElements.size(); ++i) {
            out += this.lElements.get(i).getWidth();
        }
        return out;
    }

    public int getHeight() {
        return this.iMaxHeight;
    }
}

