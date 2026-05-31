/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_Budget;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEconomy_SliderDesc_Research
extends Text {
    private String sText2;
    private int iText2Width;
    private String sText_Progress;
    private int iText_ProgressWidth;
    private String sText_ProgressPerc;
    private int iText_ProgressPercWidth;
    private String sText_CurrentProgress;
    private int iText_CurrentProgressWidth;
    private String sText_Spendings = "";
    private int iText_SpendingsWidth = 0;
    private Color colorSpendings = Color.WHITE;
    private float fResearchPerc;

    public TextEconomy_SliderDesc_Research(String sText, String sText2, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText2, CFG.PADD, iPosX, iPosY, iWidth, iHeight);
        this.sText2 = sText;
    }

    public TextEconomy_SliderDesc_Research(String sText, String sText_CurrentProgress, String sText_Progress, String sText_ProgressPerc, String sText2, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText2, CFG.PADD, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
        this.fResearchPerc = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getResearchProgressT() / (float)TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        this.sText2 = sText;
        this.sText_Progress = sText_Progress;
        this.sText_ProgressPerc = sText_ProgressPerc;
        this.sText_CurrentProgress = sText_CurrentProgress;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText2);
        this.iText2Width = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText_Progress);
        this.iText_ProgressWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText_CurrentProgress);
        this.iText_CurrentProgressWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText_ProgressPerc);
        this.iText_ProgressPercWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() * 2 / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + this.getWidthE() + CFG.PADD * 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        float spendingsProgress = CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) / (float)TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (this.fResearchPerc + spendingsProgress > 1.0f) {
            spendingsProgress = 1.0f - this.fResearchPerc;
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.research).drawO(oSB, this.getPosXE() + CFG.PADD + (Menu_InGame_Budget.maxIconWidth - (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(1.0f, Images.research))) / 2 + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.research).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(1.0f, Images.research))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.research).getWidth() * this.getImageScale(1.0f, Images.research)), (int)((float)IMGManager.getIMG(Images.research).getHeight() * this.getImageScale(1.0f, Images.research)));
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(1.0f, Images.technology)) + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.technology).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(1.0f, Images.technology))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(1.0f, Images.technology)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(1.0f, Images.technology)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText2, this.getPosXE() + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        int progressW = CFG.BUTTON_W;
        this.drawProgress(oSB, this.getPosXE() + this.iText2Width + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, progressW, CFG.TEXT_HEIGHT_DEFAULT, this.fResearchPerc, Math.min(1.0f, this.fResearchPerc + spendingsProgress));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText_CurrentProgress, this.getPosXE() + progressW + CFG.PADD + this.iText2Width + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText_Spendings, this.getPosXE() + progressW + CFG.PADD + this.iText2Width + this.iText_CurrentProgressWidth + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.colorSpendings);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText_Progress, this.getPosXE() + progressW + CFG.PADD + this.iText2Width + this.iText_SpendingsWidth + this.iText_CurrentProgressWidth + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.getTextWidthU() - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(1.0f, Images.technology)) + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText_ProgressPerc, this.getPosXE() + progressW + CFG.PADD + this.iText2Width + this.iText_SpendingsWidth + this.iText_CurrentProgressWidth + this.iText_ProgressWidth + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
    }

    public void drawProgress(SpriteBatch oSB, int nX, int nY, int nW, int nH, float fProgress, float extraProgress) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, nH);
        oSB.setColor(new Color(CFG.COLOR_RESEARCH.r, CFG.COLOR_RESEARCH.g, CFG.COLOR_RESEARCH.b, 0.7f));
        if ((int)((float)nW * extraProgress) > 0) {
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, (int)((float)nW * extraProgress), nH - 2);
        }
        if ((int)((float)nW * fProgress) > 0) {
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, (int)((float)nW * fProgress), nH - 2);
        }
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.65f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, 1);
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 1, nW, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, nW, 1);
        IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 2, nW, 1);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(float fScale, int nImageID) {
        return (float)this.iTextHeight * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void setMin(int iMin) {
        String percText = "";
        try {
            percText = " [+" + CFG.getPrecision2((float)iMin / (float)TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%]";
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.sText_Spendings = " + " + CFG.getNumberWthSpaces("" + iMin) + percText;
        this.colorSpendings = iMin <= 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_RESEARCH;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText_Spendings);
        this.iText_SpendingsWidth = (int)CFG.glyphLay.width;
    }
}

