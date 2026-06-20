
package age.of.civilizations2.jakowski.lukasz.UI;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIText extends UIComponent {
    public String text = "";

    public UIText() {}
    public UIText(String id, String label) { super(id); this.text = label; }

    public UIText text(String t) { this.text = t; return this; }
    public UIText color(Color c) { this.style.textColor = c; return this; }
    public UIText size(int w, int h) { this.width = w; this.height = h; return this; }

    @Override
    public void draw(SpriteBatch oSB, int pX, int pY) {
        if (!visible || text == null || text.length() == 0) return;
        int ax = x + pX;
        int ay = y + pY;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), text);
        float tw = CFG.glyphLay.width;
        float tx = style.centerX ? ax + ((width > 0 ? width : computedW) - tw) / 2f : ax;
        float ty = ay + (height > 0 ? height : computedH) / 2f + CFG.glyphLay.height / 2f;
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, text, (int)tx, (int)ty, style.textColor);
    }
}
