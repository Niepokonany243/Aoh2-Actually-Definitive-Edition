
package age.of.civilizations2.jakowski.lukasz.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIPanel extends UIComponent {
    public boolean drawBetterBG;

    public UIPanel() {}
    public UIPanel(String id) { super(id); }

    public UIPanel better(boolean v) { this.drawBetterBG = v; return this; }
    public UIPanel size(int w, int h) { this.width = w; this.height = h; return this; }
    public UIPanel pos(int px, int py) { this.x = px; this.y = py; return this; }

    public UIPanel bg(Color c) { this.style.bg(c); return this; }
    public UIPanel pad(int p) { this.style.pad(p); return this; }

    @Override
    public void draw(SpriteBatch oSB, int pX, int pY) {
        if (!visible) return;
        int ax = x + pX;
        int ay = y + pY;
        int cw = width > 0 ? width : computedW;
        int ch = height > 0 ? height : computedH;
        if (drawBetterBG) {
            BetterUIDraw.drawBetterPanel(oSB, ax, ay, cw, ch);
        } else if (style.bgColor != null) {
            oSB.setColor(style.bgColor);
            BetterUIDraw.fillRect(oSB, ax, ay, cw, ch);
            oSB.setColor(Color.WHITE);
        }
        if (style.borderColor != null && style.borderWidth > 0) {
            BetterUIDraw.drawBorder(oSB, ax, ay, cw, ch, style.borderColor, style.borderWidth);
        }
        for (UIComponent c : children) c.draw(oSB, ax, ay);
    }
}
