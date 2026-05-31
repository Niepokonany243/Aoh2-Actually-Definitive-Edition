
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Stats_Elections
extends ButtonStats {
    private String sText2;
    private String sText3;
    private int iText2Width;
    private int iText3Width;

    public Button_Stats_Elections(String sText, String sText2, String sText3, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, CFG.PADD * 2, iPosX, iPosY, iWidth, iHeight, false, false);
        this.sText2 = sText2;
        this.sText3 = sText3;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText2);
        this.iText2Width = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText3);
        this.iText3Width = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.525f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.625f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(IMGManager.getIMG(Images.time).getHeight())) - CFG.PADD + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(IMGManager.getIMG(Images.time).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.time).getHeight(), (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(IMGManager.getIMG(Images.time).getHeight())), (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(IMGManager.getIMG(Images.time).getHeight())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText2, this.getPosXE() + this.textPosition.getTextPosition() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText3, this.getPosXE() + this.getWidthE() - this.iText3Width - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(IMGManager.getIMG(Images.time).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Image(Images.hreIcon));
        nData.add(new ME_Hover_2Type_Text(this.getTextE()));
        nData.add(new ME_Hover_2Type_Text(this.sText2, CFG.COLOR_HOVER_TITLE));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void actionElem(int iID) {
        CFG.toastM.addM(this.getTextE() + this.sText2 + " [" + this.sText3 + "]", CFG.COLOR_HOVER_TITLE);
        CFG.toastM.setTimeInView(2500);
    }
}

