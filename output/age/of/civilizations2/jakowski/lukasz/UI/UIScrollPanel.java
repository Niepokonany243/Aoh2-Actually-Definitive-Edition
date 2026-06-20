
package age.of.civilizations2.jakowski.lukasz.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIScrollPanel extends UIPanel {
    public int scrollY;
    public int contentHeight;
    public int maxScroll;

    public UIScrollPanel() {}
    public UIScrollPanel(String id) { super(id); }

    public UIScrollPanel size(int w, int h) { this.width = w; this.height = h; return this; }

    @Override
    public void layout() {
        if (children.isEmpty()) return;
        int pad = style.padding;
        int gap = style.gap;
        int cx = pad;
        int cy = pad;
        int rowH = 0;
        int maxW = width - pad * 2;
        for (UIComponent c : children) {
            if (!c.visible) continue;
            c.computedW = c.width > 0 ? c.width : maxW;
            c.computedH = c.height > 0 ? c.height : style.childHeight;
            if (cx + c.computedW > maxW && cx > pad) { cx = pad; cy += rowH + gap; rowH = 0; }
            c.computedX = x + cx;
            c.computedY = y + cy;
            cx += c.computedW + gap;
            if (c.computedH > rowH) rowH = c.computedH;
            c.layout();
        }
        contentHeight = cy + rowH + pad;
        maxScroll = Math.max(0, contentHeight - height);
    }

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
        int savedScroll = scrollY;
        scrollY = Math.max(0, Math.min(maxScroll, scrollY));
        for (UIComponent c : children) c.draw(oSB, ax, ay - scrollY);
        scrollY = savedScroll;
    }
}
