
package age.of.civilizations2.jakowski.lukasz.UI;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BetterUIDraw {
    public static final void fillRect(SpriteBatch oSB, int x, int y, int w, int h) {
        if (w > 0 && h > 0) IMGManager.getIMG(Images.pix255).drawO(oSB, x, y - IMGManager.getIMG(Images.pix255).getHeight(), w, h);
    }

    public static final void drawBorder(SpriteBatch oSB, int x, int y, int w, int h, Color c, float bw) {
        oSB.setColor(c);
        int bwI = (int)Math.max(1, bw);
        IMGManager.getIMG(Images.pix255).drawO(oSB, x, y - IMGManager.getIMG(Images.pix255).getHeight(), w, bwI);
        IMGManager.getIMG(Images.pix255).drawO(oSB, x, y + h - bwI - IMGManager.getIMG(Images.pix255).getHeight(), w, bwI);
        IMGManager.getIMG(Images.pix255).drawO(oSB, x, y - IMGManager.getIMG(Images.pix255).getHeight(), bwI, h);
        IMGManager.getIMG(Images.pix255).drawO(oSB, x + w - bwI, y - IMGManager.getIMG(Images.pix255).getHeight(), bwI, h);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawBetterPanel(SpriteBatch oSB, int x, int y, int w, int h) {
        BetterUI_Manager.drawBetterMenuBG(oSB, x, y, w, h);
    }

    public static final void drawText(SpriteBatch oSB, String text, int x, int y, Color c, int fontSize) {
        int font = fontSize > 0 ? CFG.FONT_BOLD_SMALL : CFG.FONT_BOLD_SMALL;
        Renderer.drawText(oSB, font, text, x, y, c);
    }
}
