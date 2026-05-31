package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BetterUI_Manager {
    public static final int THEME_DARK = 0;
    public static final int THEME_PURPLE = 1;
    public static final int THEME_RED = 2;

    public static Color getPrimaryColor() {
        if (!CFG.settingsGD.BETTER_UI) return Color.WHITE;
        switch (CFG.settingsGD.UI_THEME) {
            case THEME_PURPLE:
                return new Color(0.7f, 0.2f, 1.0f, 1.0f);
            case THEME_RED:
                return new Color(1.0f, 0.1f, 0.1f, 1.0f);
            default:
                return new Color(0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    public static Color getSecondaryColor() {
        if (!CFG.settingsGD.BETTER_UI) return Color.GRAY;
        switch (CFG.settingsGD.UI_THEME) {
            case THEME_PURPLE:
                return new Color(0.4f, 0.0f, 0.8f, 1.0f);
            case THEME_RED:
                return new Color(0.8f, 0.0f, 0.0f, 1.0f);
            default:
                return new Color(0.0f, 0.6f, 0.8f, 1.0f);
        }
    }

    public static Color getBackgroundColor(float alpha) {
        if (!CFG.settingsGD.BETTER_UI) return new Color(0,0,0, alpha);
        switch (CFG.settingsGD.UI_THEME) {
            case THEME_PURPLE:
                return new Color(0.18f, 0.02f, 0.35f, alpha);
            case THEME_RED:
                return new Color(0.25f, 0.01f, 0.01f, alpha);
            default:
                return new Color(0.01f, 0.05f, 0.12f, alpha);
        }
    }

    public static Color getTextColor() {
        if (!CFG.settingsGD.BETTER_UI) return Color.WHITE;
        Color c = getPrimaryColor();
        return new Color(Math.max(0.8f, c.r), Math.max(0.8f, c.g), Math.max(0.8f, c.b), 1.0f);
    }

    public static void drawAdvancedBackground(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean clearBG) {
        if (!CFG.settingsGD.BETTER_UI) return;
        
        if (clearBG) {
            oSB.setColor(getBackgroundColor(1.0f));
            Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        }
        
        Color primary = getPrimaryColor();
        
        // Very subtle background tint
        oSB.setColor(primary.r, primary.g, primary.b, 0.05f);
        Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        
        // Minimalist Static Grid
        oSB.setColor(primary.r, primary.g, primary.b, 0.03f);
        int gridSize = 100;
        for (int i = 0; i < CFG.GAMEWIDTH; i += gridSize) {
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, i + iTranslateX, iTranslateY, 1, CFG.GAMEHEIGHT);
        }
        for (int i = 0; i < CFG.GAMEHEIGHT; i += gridSize) {
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, iTranslateX, i + iTranslateY, CFG.GAMEWIDTH, 1);
        }

        // Clean Vignette
        oSB.setColor(primary.r, primary.g, primary.b, 0.15f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        
        CFG.setRenderO(true);
    }
    
    public static void drawBetterMenuBG(SpriteBatch oSB, int posX, int posY, int width, int height) {
        if (!CFG.settingsGD.BETTER_UI) return;
        
        Color bg = getBackgroundColor(0.92f);
        
        // Elegant glass panel without any borders (as requested)
        oSB.setColor(bg);
        Images.pix.draw(oSB, posX, posY, width, height);
        
        // Faint texture
        oSB.setColor(getPrimaryColor().r, getPrimaryColor().g, getPrimaryColor().b, 0.03f);
        for (int i=40; i<height; i+=80) {
            Images.pix.draw(oSB, posX, posY + i, width, 1);
        }
    }

    public static void drawBetterButtonBorder(SpriteBatch oSB, int posX, int posY, int width, int height, boolean isHovered, boolean isActive, boolean isClickable) {
        if (!isClickable) return;
        
        Color primary = getPrimaryColor();
        // Full solid border like the map selection button
        oSB.setColor(primary.r, primary.g, primary.b, (isHovered || isActive) ? 1.0f : 0.75f);
        Images.pix.draw(oSB, posX, posY, width, 2); // Top
        Images.pix.draw(oSB, posX, posY + height - 2, width, 2); // Bottom
        Images.pix.draw(oSB, posX, posY, 2, height); // Left
        Images.pix.draw(oSB, posX + width - 2, posY, 2, height); // Right
        
        if (isHovered || isActive) {
            oSB.setColor(primary.r, primary.g, primary.b, 0.15f);
            Images.pix.draw(oSB, posX + 2, posY + 2, width - 4, height - 4);
        }
    }

    public static void drawBetterSlider(SpriteBatch oSB, int posX, int posY, int width, int height, int currentPosX, int diffX, boolean isHovered, boolean isActive, Color colorLeft) {
        if (!CFG.settingsGD.BETTER_UI) return;
        
        Color primary = getPrimaryColor();
        Color bg = getBackgroundColor(0.8f);
        
        // Track Background
        oSB.setColor(bg);
        Images.pix.draw(oSB, posX, posY, width, height);
        
        // Track Border
        oSB.setColor(primary.r, primary.g, primary.b, (isHovered || isActive) ? 1.0f : 0.75f);
        Images.pix.draw(oSB, posX, posY, width, 2); // Top
        Images.pix.draw(oSB, posX, posY + height - 2, width, 2); // Bottom
        Images.pix.draw(oSB, posX, posY, 2, height); // Left
        Images.pix.draw(oSB, posX + width - 2, posY, 2, height); // Right

        // Filled Area
        int fillW = currentPosX + diffX;
        if (fillW > width) fillW = width;
        if (fillW < 0) fillW = 0;
        
        oSB.setColor(colorLeft.r, colorLeft.g, colorLeft.b, 0.6f);
        Images.pix.draw(oSB, posX, posY, fillW, height);
        
        // Handle / Indicator
        oSB.setColor(primary.r, primary.g, primary.b, 1.0f);
        Images.pix.draw(oSB, posX + fillW - 2, posY - 2, 4, height + 4);
        
        if (isHovered || isActive) {
            oSB.setColor(primary.r, primary.g, primary.b, 0.2f);
            Images.pix.draw(oSB, posX, posY, fillW, height);
        }
    }
    
    public static void drawBetterArrow(SpriteBatch oSB, int posX, int posY, int width, int height, boolean isHovered, boolean isActive, boolean right) {
        if (!CFG.settingsGD.BETTER_UI) return;
        
        Color primary = getPrimaryColor();
        oSB.setColor(primary.r, primary.g, primary.b, (isHovered || isActive) ? 1.0f : 0.6f);
        
        IMGManager.getIMG(Images.arrow).drawO(oSB, posX + width / 2 - IMGManager.getIMG(Images.arrow).getWidth() / 2, posY + height / 2 - IMGManager.getIMG(Images.arrow).getHeight() / 2, right, false);
        
        if (isActive) {
            oSB.setColor(primary.r, primary.g, primary.b, 0.3f);
            Images.pix.draw(oSB, posX, posY, width, height);
        }
    }
}

