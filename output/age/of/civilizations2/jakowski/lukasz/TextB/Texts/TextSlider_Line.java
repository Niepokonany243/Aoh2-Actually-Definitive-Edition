
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class TextSlider_Line {
    private List<String> lText = new ArrayList<String>();
    private int iHeight;
    private Align align;

    public TextSlider_Line(String sText, int nWidth, int extraHeight, Align nAlign, float nFONT_SCALE) {
        this.align = nAlign;
        String[] tempLine = sText.split(" ");
        int currentW = 0;
        int iSize = tempLine.length;
        int last = 0;
        for (int i = 0; i < iSize; ++i) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), tempLine[i] + " ");
            if ((currentW += (int)(CFG.glyphLay.width * nFONT_SCALE)) < nWidth && (i != iSize - 1 || currentW >= nWidth)) continue;
            String addLine = "";
            for (int j = last; j < (i == iSize - 1 && currentW < nWidth ? iSize : i); ++j) {
                addLine = addLine + tempLine[j] + " ";
            }
            this.lText.add(addLine);
            last = i;
            if (currentW >= nWidth && i == iSize - 1) {
                this.lText.add(tempLine[i]);
            }
            currentW = (int)(CFG.glyphLay.width * nFONT_SCALE);
        }
        this.iHeight = (int)((float)this.lText.size() * ((float)CFG.TEXT_HEIGHT_DEFAULT * nFONT_SCALE + (float)CFG.PADD) + (float)extraHeight);
    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, Color oColor, int fontID) {
        int iSize = this.lText.size();
        for (int i = 0; i < iSize; ++i) {
            Renderer.drawText(oSB, fontID, this.lText.get(i), nPosX, nPosY + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * i, oColor);
        }
    }

    public final void setHeight(int iHeight) {
        this.iHeight = iHeight;
    }

    public final int getHeight() {
        return this.iHeight;
    }

    public static enum Align {
        LEFT,
        CENTER,
        RIGHT;

    }
}

