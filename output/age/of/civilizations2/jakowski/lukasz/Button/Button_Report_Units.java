/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Button_Report_Units
extends ButtonM {
    private List<Integer> lCivID = new ArrayList<Integer>();
    private List<Float> lCivWidth = new ArrayList<Float>();
    private int iAttackersSize = 0;
    private int iCivsSize = 0;
    private int iAttackersEND_ID;
    private float fSplitPosX = 0.0f;
    private long iAttackers = 0;
    private long iDefenders = 0;
    private int iDefendersWidth = 0;

    public Button_Report_Units(int iPosX, int iPosY, int iWidth, int iHeight) {
        int i;
        int i2;
        this.fontID = CFG.FONT_BOLD_SMALL;
        long tempArmies_Total = CFG.reportData.getTotalArmy();
        this.iAttackers = CFG.reportData.getAttackersArmy();
        this.iDefenders = CFG.reportData.getDefendersArmy();
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.iDefenders);
        this.iDefendersWidth = (int)CFG.glyphLay.width;
        for (i2 = 0; i2 < CFG.reportData.lAttackers_Armies.size(); ++i2) {
            this.lCivID.add(CFG.reportData.lAttackers_IDs.get(i2));
            this.lCivWidth.add(Float.valueOf((float)CFG.reportData.lAttackers_Armies.get(i2).intValue() / (float)tempArmies_Total));
        }
        this.iAttackersEND_ID = CFG.reportData.lAttackers_Armies.size();
        for (i2 = 0; i2 < CFG.reportData.lDefenders_Armies.size(); ++i2) {
            this.lCivID.add(CFG.reportData.lDefenders_IDs.get(i2));
            this.lCivWidth.add(Float.valueOf((float)CFG.reportData.lDefenders_Armies.get(i2).intValue() / (float)tempArmies_Total));
        }
        int tempTotalWidth = 0;
        for (i = 0; i < this.lCivWidth.size(); ++i) {
            tempTotalWidth = (int)((float)tempTotalWidth + this.lCivWidth.get(i).floatValue());
        }
        for (i = 0; i < this.iAttackersEND_ID; ++i) {
            this.fSplitPosX += this.lCivWidth.get(i).floatValue();
        }
        this.iCivsSize = this.lCivID.size();
        super.init("" + tempArmies_Total, -1, iPosX, iPosY, iWidth, iHeight, true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        int tPosX = 0;
        for (int i = 0; i < this.iCivsSize; ++i) {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.lCivID.get(i)).getR() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getG() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getB() / 255.0f, 0.6f));
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + tPosX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)(this.lCivWidth.get(i).floatValue() * (float)this.getWidthE()), this.getHeightE());
            oSB.setColor(new Color((float)CFG.core.getCiv(this.lCivID.get(i)).getR() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getG() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getB() / 255.0f, 0.3f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + tPosX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)(this.lCivWidth.get(i).floatValue() * (float)this.getWidthE()), this.getHeightE());
            oSB.setColor(new Color((float)CFG.core.getCiv(this.lCivID.get(i)).getR() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getG() / 255.0f, (float)CFG.core.getCiv(this.lCivID.get(i)).getB() / 255.0f, 0.65f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + tPosX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)(this.lCivWidth.get(i).floatValue() * (float)this.getWidthE()), this.getHeightE() * 3 / 5);
            tPosX += (int)(this.lCivWidth.get(i).floatValue() * (float)this.getWidthE());
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, (int)(this.fSplitPosX * (float)this.getWidthE()), this.getHeightE(), false, true);
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + this.getWidthE() - (this.getWidthE() - (int)(this.fSplitPosX * (float)this.getWidthE())) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE() - (int)(this.fSplitPosX * (float)this.getWidthE()), this.getHeightE(), true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.785f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)(this.fSplitPosX * (float)this.getWidthE()) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() + 1 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.pix255).getHeight());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.3f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.line32Off1).getHeight());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.0f, 0.0f, 0.0f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(1.0f, 1.0f, 1.0f, 0.5f) : new Color(1.0f, 1.0f, 1.0f, 0.425f)) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawText(oSB, this.fontID, "" + this.iAttackers, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, this.fontID, "" + this.iDefenders, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iDefendersWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public void buildElemHover() {
        int i;
        ArrayList<Integer> added2;
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        try {
            added2 = new ArrayList<Integer>();
            for (i = 0; i < CFG.reportData.lAttackers_IDs.size(); ++i) {
                if (added2.contains(CFG.reportData.lAttackers_IDs.get(i))) continue;
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.reportData.lAttackers_IDs.get(i), 0, CFG.PADD));
                added2.add(CFG.reportData.lAttackers_IDs.get(i));
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Attackers") + ""));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + this.iAttackers + " - " + this.iDefenders, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.lang.get("Defenders")));
        try {
            added2 = new ArrayList();
            for (i = 0; i < CFG.reportData.lDefenders_IDs.size(); ++i) {
                if (added2.contains(CFG.reportData.lDefenders_IDs.get(i))) continue;
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.reportData.lDefenders_IDs.get(i), CFG.PADD, 0));
                added2.add(CFG.reportData.lDefenders_IDs.get(i));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

