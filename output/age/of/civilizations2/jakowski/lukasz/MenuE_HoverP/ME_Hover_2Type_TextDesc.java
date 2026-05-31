/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class ME_Hover_2Type_TextDesc
implements ME_Hover_2Type {
    public List<String> sLines = new ArrayList<String>();
    public int iLineSize = 0;
    private String sText;
    private int iTextWidth;
    private Color oColor;
    public int fontID;
    public int iTextHeight;

    public ME_Hover_2Type_TextDesc(String sText) {
        this.init(sText, new Color(0.9843137f, 0.9843137f, 0.9843137f, 1.0f));
    }

    public ME_Hover_2Type_TextDesc(String sText, int fontID) {
        this.init(sText, new Color(0.9843137f, 0.9843137f, 0.9843137f, 1.0f), fontID);
    }

    public ME_Hover_2Type_TextDesc(String sText, Color nColor) {
        this.init(sText, nColor);
    }

    public ME_Hover_2Type_TextDesc(String sText, Color nColor, int fontID) {
        this.init(sText, nColor, fontID);
    }

    private final void init(String sText, Color oColor) {
        this.init(sText, oColor, CFG.FONT_BOLD_SMALL);
    }

    private final void init(String sText, Color oColor, int fontID) {
        int i;
        this.oColor = oColor;
        this.fontID = fontID;
        this.iTextHeight = fontID == CFG.FONT_BOLD ? CFG.TEXT_HEIGHT_DEFAULT : CFG.TEXT_HEIGHT_DEFAULT_SMALL;
        String[] words = sText.split(" ");
        int textPosX = 0;
        int maxW = (int)((float)CFG.BUTTON_W * 4.0f);
        String currentLine = "";
        int tTextWidth = 0;
        int iSize = words.length;
        for (i = 0; i < iSize; ++i) {
            Renderer.glyphLayout.setText(CFG.fontMain.get(fontID), words[i] + " ");
            tTextWidth = (int)Renderer.glyphLayout.width;
            if ((textPosX += tTextWidth) < maxW) {
                currentLine = currentLine + words[i] + " ";
                this.iTextWidth = Math.max(this.iTextWidth, Math.min(textPosX, maxW));
                continue;
            }
            this.sLines.add(currentLine);
            currentLine = words[i] + " ";
            textPosX = tTextWidth;
        }
        if (currentLine.length() > 0) {
            this.sLines.add(currentLine);
        }
        if (this.sLines.size() > 0 && this.sLines.get(0).length() > 0) {
            Renderer.glyphLayout.setText(CFG.fontMain.get(fontID), this.sLines.get(0));
            this.iTextHeight = (int)Renderer.glyphLayout.height;
        }
        this.iLineSize = this.sLines.size();
        for (i = 0; i < this.iLineSize; ++i) {
            GlyphLayout glyphLayout = new GlyphLayout();
            glyphLayout.setText(CFG.fontMain.get(fontID), this.sLines.get(i));
            if (!(glyphLayout.width > (float)this.iTextWidth)) continue;
            this.iTextWidth = (int)glyphLayout.width;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        for (int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, this.sLines.get(i), nPosX, nPosY + CFG.PADD + (this.iTextHeight + CFG.PADD * 2) * i, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        for (int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, this.sLines.get(i), nPosX, nPosY + CFG.PADD + (this.iTextHeight + CFG.PADD * 2) * i, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        }
    }

    @Override
    public int getWidth() {
        return this.iTextWidth;
    }

    @Override
    public int getHeight() {
        return CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT * this.iLineSize + CFG.PADD * 2 * (this.iLineSize - 1);
    }
}

