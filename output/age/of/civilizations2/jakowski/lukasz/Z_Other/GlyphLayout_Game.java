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
        synchronized (lock) {
            super.setText(font, str == null ? "" : str);
        }
    }

    @Override
    public void setText(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        synchronized (lock) {
            super.setText(font, str == null ? "" : str, color, targetWidth, halign, wrap);
        }
    }

    @Override
    public void setText(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, String truncate) {
        synchronized (lock) {
            super.setText(font, str == null ? "" : str, start, end, color, targetWidth, halign, wrap, truncate);
        }
    }
}
