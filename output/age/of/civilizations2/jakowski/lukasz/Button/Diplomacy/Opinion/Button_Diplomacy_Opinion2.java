/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Opinion;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Opinion.Button_Diplomacy_Opinion;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Diplomacy_Opinion2
extends Button_Diplomacy_Opinion {
    private String sText2;
    private int iText2Width = 0;
    public Color textColor2;

    public Button_Diplomacy_Opinion2(int nCivID, int nOpinion, int nOpinion2, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(nCivID, nOpinion, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.sText2 = "" + nOpinion2;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sText2);
        this.iText2Width = (int)CFG.glyphLay.width;
        this.textColor2 = this.getOpinionColor(nOpinion2);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawText(oSB, this.fontID, CFG.core.getCiv(this.iCivID).getCivName(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.textColor);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.iCivID) * 10.0f)) / 10.0f, CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.iCivID) > 0.0f ? CFG.COLOR_POSITIVE : (CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), this.iCivID) == 0.0f ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_1)));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCivRelationOfCivB(this.iCivID, CFG.getActiveCivInfoId()) * 10.0f)) / 10.0f, CFG.core.getCivRelationOfCivB(this.iCivID, CFG.getActiveCivInfoId()) > 0.0f ? CFG.COLOR_POSITIVE : (CFG.core.getCivRelationOfCivB(this.iCivID, CFG.getActiveCivInfoId()) == 0.0f ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_1)));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }
}

