
package age.of.civilizations2.jakowski.lukasz.UI;

import com.badlogic.gdx.graphics.Color;

public class UIStyle {
    public String id = "";
    public Color bgColor;
    public Color textColor = Color.WHITE;
    public Color borderColor;
    public float borderWidth = 0;
    public int padding = 4;
    public int gap = 2;
    public float weight = 1.0f;
    public int childHeight = 0;
    public int fontSize;
    public boolean centerX;
    public boolean centerY;
    public float alpha = 1.0f;

    public UIStyle() {}

    public UIStyle bg(Color c) { this.bgColor = c; return this; }
    public UIStyle text(Color c) { this.textColor = c; return this; }
    public UIStyle pad(int p) { this.padding = p; return this; }
    public UIStyle gap(int g) { this.gap = g; return this; }
    public UIStyle weight(float w) { this.weight = w; return this; }
    public UIStyle childH(int h) { this.childHeight = h; return this; }
}
