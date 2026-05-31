
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEconomy_Balance_Graph
extends Text {
    public String sText2;
    public Color textColor;
    public int iText2W;
    public Graph2 graph2;

    public TextEconomy_Balance_Graph(String sText, String sText2, int iPosX, int iPosY, int iWidth, int iHeight, Graph2.GraphType graphType) {
        super(sText, CFG.PADD, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD);
        this.sText2 = sText2;
        try {
            if (sText2 != null && sText2.length() > 0) {
                CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText2);
                this.iText2W = (int)CFG.glyphLay.width;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            this.graph2 = new Graph2("A", "B", 0, 0, Math.min(iWidth / 2, CFG.BUTTON_W + CFG.BUTTON_W / 2), iHeight - CFG.PADD * 2, true, 1, graphType, false, CFG.PLAYER_TURN_ID, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.225f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.275f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.325f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.265f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
        }
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.5f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        try {
            this.graph2.drawE(oSB, this.getPosXE() + this.getWidthE() - this.graph2.getWidthE() + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, isActive, scrollableY);
        }
        catch (Exception exception) {
            
        }
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + CFG.PADD + CFG.PADD / 2 + this.iText2W + CFG.PADD + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale()) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText2, this.getPosXE() + CFG.PADD + CFG.PADD / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + CFG.PADD / 2 + this.iText2W + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.textColor);
    }

    private final float getImageScale() {
        return (float)this.iTextHeight / (float)IMGManager.getIMG(Images.topGold()).getHeight();
    }

    @Override
    public void setMax(int iMax) {
        this.textColor = iMax == 0 ? CFG.COLOR_NEUTRAL2 : (iMax > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
    }
}

