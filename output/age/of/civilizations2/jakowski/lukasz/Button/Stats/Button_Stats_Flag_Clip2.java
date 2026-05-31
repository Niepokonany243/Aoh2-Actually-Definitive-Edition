/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_Stats_Flag_Clip2
extends Button_Stats_Flag {
    public int rankIMG = 0;
    public int iconWidth;
    public int iconHeight;
    public int iconWidth_Religion = 1;
    public int iconHeight_Religion = 1;

    public Button_Stats_Flag_Clip2(int iCivID, String sText, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight, int nRankIMG) {
        super(iCivID, sText, iTextPosX, iPosX, iPosY, iWidth, iHeight);
        this.rankIMG = nRankIMG;
        float iconScale = this.getImageScale(this.rankIMG) * 1.25f;
        this.iconWidth = (int)((float)IMGManager.getIMG(this.rankIMG).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(this.rankIMG).getHeight() * iconScale);
        if (iCivID > 0) {
            iconScale = (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.religionManager.religionImages.get(CFG.core.getCiv(iCivID).getReligionID()).getHeight() * 1.1f;
            this.iconWidth_Religion = (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(iCivID).getReligionID()).getWidth() * iconScale);
            this.iconHeight_Religion = (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(iCivID).getReligionID()).getHeight() * iconScale);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        IMGManager.getIMG(this.rankIMG).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.iconHeight) / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        try {
            if (this.iCivID >= 0) {
                oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 0.85f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                oSB.setColor(Color.WHITE);
                Core.drawFlagRect(oSB, 2 + this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
            } else {
                oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                oSB.setColor(Color.WHITE);
                Core.drawFlagRect(oSB, 2 + this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
            }
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            oSB.setColor(Color.WHITE);
            Core.drawFlagRect(oSB, 2 + this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        }
        if (this.iCivID > 0) {
            CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivID).getReligionID()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iconWidth_Religion + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iconHeight_Religion / 2 + iTranslateY, this.iconWidth_Religion, this.iconHeight_Religion);
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + (CFG.PADD * 2 + this.iconWidth) + this.textPosition.getTextPosition() + 2 + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
    }

    private final float getImageScale() {
        return Math.min(1.0f, (float)(this.getHeightE() - CFG.PADD) / (float)CFG.CIV_FLAG_HEIGHT);
    }

    private final float getImageScale(int iImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (this.iCivID > 0) {
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(this.iCivID).getIdeology(), CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(this.iCivID).getReligionID(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).getNumOfProvs()), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_PROVINCES, this.iCivID));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countPop()), CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_POPULATION, this.iCivID));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countEco()), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, this.iCivID));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else {
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

