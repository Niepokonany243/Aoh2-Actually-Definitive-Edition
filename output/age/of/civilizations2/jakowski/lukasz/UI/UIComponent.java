
package age.of.civilizations2.jakowski.lukasz.UI;

import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class UIComponent {
    public UIComponent parent;
    public List<UIComponent> children = new ArrayList<UIComponent>(0);
    public UIStyle style = new UIStyle();
    public int x, y, width, height;
    public int computedX, computedY, computedW, computedH;
    public boolean visible = true;
    public boolean dirty = true;
    public Object tag;

    public UIComponent() {}

    public UIComponent(String id) { style.id = id; }

    public UIComponent add(UIComponent child) {
        child.parent = this;
        children.add(child);
        return child;
    }

    public UIComponent remove(UIComponent child) {
        children.remove(child);
        child.parent = null;
        return child;
    }

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
            c.computedW = c.width > 0 ? c.width : (int)(maxW * c.style.weight);
            c.computedH = c.height > 0 ? c.height : style.childHeight;
            if (cx + c.computedW > maxW && cx > pad) { cx = pad; cy += rowH + gap; rowH = 0; }
            c.computedX = x + cx;
            c.computedY = y + cy;
            cx += c.computedW + gap;
            if (c.computedH > rowH) rowH = c.computedH;
            c.layout();
        }
    }

    public void draw(SpriteBatch oSB, int pX, int pY) {
        if (!visible) return;
        int ax = x + pX;
        int ay = y + pY;
        if (style.bgColor != null) {
            oSB.setColor(style.bgColor);
            BetterUIDraw.fillRect(oSB, ax, ay, width > 0 ? width : computedW, height > 0 ? height : computedH);
            oSB.setColor(Color.WHITE);
        }
        for (UIComponent c : children) c.draw(oSB, ax, ay);
    }

    public UIComponent findById(String id) {
        if (id.equals(style.id)) return this;
        for (UIComponent c : children) { UIComponent r = c.findById(id); if (r != null) return r; }
        return null;
    }

    public void invalidate() { dirty = true; for (UIComponent c : children) c.invalidate(); }
}
