
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Static;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Text_Desc
extends Text_Static {
    public List<String> sLines = new ArrayList<String>();
    public int iLineSize = 0;

    public Text_Desc(String sText, int iPosX, int iPosY, int iWidth) {
        this.init(sText, iPosX, iPosY, iWidth, CFG.FONT_REGULAR_SMALL);
    }

    public Text_Desc(String sText, int iPosX, int iPosY, int iWidth, int nFontID) {
        this.init(sText, iPosX, iPosY, iWidth, nFontID);
    }

    public void init(String sText, int iPosX, int iPosY, int iWidth, int nFontID) {
        GlyphLayout_Game glyphLayout;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = nFontID;
        this.iTextPositionX = 0;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.updateTextPosition();
        String[] words = sText.split(" ");
        int textPosX = 0;
        int maxW = iWidth - this.getPadding() * 2;
        String currentLine = "";
        int iSize = words.length;
        for (int i = 0; i < iSize; ++i) {
            GlyphLayout_Game glyphLayout2 = new GlyphLayout_Game();
            glyphLayout2.setText(CFG.fontMain.get(this.fontID), words[i] + " ");
            this.iTextWidth = (int)glyphLayout2.width;
            if ((textPosX += this.iTextWidth) < maxW) {
                currentLine = currentLine + words[i] + " ";
                continue;
            }
            if (currentLine.length() > 0) {
                this.sLines.add(currentLine);
            }
            currentLine = words[i] + " ";
            textPosX = this.iTextWidth;
        }
        if (currentLine.length() > 0) {
            this.sLines.add(currentLine);
        }
        if (this.sLines.size() > 0 && this.sLines.get(0).length() > 0) {
            glyphLayout = new GlyphLayout_Game();
            glyphLayout.setText(CFG.fontMain.get(this.fontID), this.sLines.get(0));
            this.iTextHeight = (int)glyphLayout.height;
        } else {
            glyphLayout = new GlyphLayout_Game();
            glyphLayout.setText(CFG.fontMain.get(this.fontID), "ABC");
            this.iTextHeight = (int)glyphLayout.height;
        }
        this.iLineSize = this.sLines.size();
        for (int i = 0; i < this.iLineSize; ++i) {
            GlyphLayout_Game glyphLayout3 = new GlyphLayout_Game();
            glyphLayout3.setText(CFG.fontMain.get(this.fontID), this.sLines.get(i));
            if (!(glyphLayout3.width > (float)this.getWidthE())) continue;
            this.setWidthE((int)glyphLayout3.width);
        }
        this.setHeightE(this.iTextHeight * this.sLines.size() + (this.sLines.size() - 1) * CFG.PADD * 2 + this.getPaddingY() * 2);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        for (int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, this.sLines.get(i), this.getPosXE() + this.getPadding() + iTranslateX, this.getPosY() + this.getPaddingY() + (this.iTextHeight + CFG.PADD * 2) * i + iTranslateY, this.getColor(isActive));
        }
    }

    public void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, Text_Desc.getBoxAlpha(this.getIsClickable(), this.getIsHovered(), isActive)));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 0.8f);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.175f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.3f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
    }

    public static final float getBoxAlpha(boolean clickable, boolean isHovered, boolean isActive) {
        return clickable ? (isActive ? 0.85f : (isHovered ? 0.7f : 0.5f)) : 0.2f;
    }

    @Override
    protected Color getColor(boolean isActive) {
        if (isActive) {
            return Colors.BUTTON_TEXT_ACTIVE;
        }
        if (this.getIsHovered()) {
            return Colors.BUTTON_TEXT_HOVERED;
        }
        return this.getIsClickable() ? Colors.BUTTON_TEXT : Colors.BUTTON_TEXT_DISABLED;
    }

    public final int getPadding() {
        return CFG.PADD * 2;
    }

    public final int getPaddingY() {
        return CFG.PADD * 3;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        String text = "";
        for (int i = 0; i < this.sLines.size(); ++i) {
            text = text + this.sLines.get(i);
        }
        nData.add(new ME_Hover_2Type_TextDesc(text, CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

