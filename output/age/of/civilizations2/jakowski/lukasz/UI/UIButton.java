
package age.of.civilizations2.jakowski.lukasz.UI;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIButton extends UIComponent {
    public String text = "";
    public boolean hovered;
    public boolean active;
    public Runnable onClick;

    public UIButton() {}
    public UIButton(String id, String label) { super(id); this.text = label; }

    public UIButton text(String t) { this.text = t; return this; }
    public UIButton onClick(Runnable r) { this.onClick = r; return this; }
    public UIButton size(int w, int h) { this.width = w; this.height = h; return this; }

    @Override
    public void draw(SpriteBatch oSB, int pX, int pY) {
        if (!visible) return;
        int ax = x + pX;
        int ay = y + pY;
        int cw = width > 0 ? width : computedW;
        int ch = height > 0 ? height : computedH;
        Color bg = hovered ? (active ? CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE : new Color(0.3f, 0.3f, 0.3f, 0.6f)) : new Color(0.2f, 0.2f, 0.2f, 0.5f);
        oSB.setColor(bg);
        BetterUIDraw.fillRect(oSB, ax, ay, cw, ch);
        oSB.setColor(Color.WHITE);
        if (text != null && text.length() > 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), text);
            float tw = CFG.glyphLay.width;
            float tx = ax + (cw - tw) / 2f;
            float ty = ay + ch / 2f + CFG.glyphLay.height / 2f;
            Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, text, (int)tx, (int)ty, style.textColor);
        }
        for (UIComponent c : children) c.draw(oSB, ax, ay);
    }
}
