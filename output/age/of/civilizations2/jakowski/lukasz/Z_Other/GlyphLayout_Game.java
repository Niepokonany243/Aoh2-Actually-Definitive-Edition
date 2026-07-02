package age.of.civilizations2.jakowski.lukasz.Z_Other;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class GlyphLayout_Game extends GlyphLayout {
    private static final Object lock = new Object();

    public GlyphLayout_Game() {
        super();
    }

    @Override
    public void setText(BitmapFont font, CharSequence str) {
        if (font == null || font.getData() == null) return;
        if (str == null) str = "";
        synchronized (lock) {
            super.setText(font, str);
        }
    }

    @Override
    public void setText(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        if (font == null || font.getData() == null) return;
        if (str == null) str = "";
        synchronized (lock) {
            super.setText(font, str, color, targetWidth, halign, wrap);
        }
    }

    @Override
    public void setText(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, String truncate) {
        if (font == null || font.getData() == null) return;
        if (str == null) str = "";
        synchronized (lock) {
            super.setText(font, str, start, end, color, targetWidth, halign, wrap, truncate);
        }
    }
}
