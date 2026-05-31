/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Button_BotBar_SuppRebels
extends Button_BotBar {
    public List<Integer> lCivs = new ArrayList<Integer>();
    public List<Integer> lCivsTurnsLeft = new ArrayList<Integer>();
    public List<List<Integer>> lSupportedByCivs = new ArrayList<List<Integer>>();
    public int iCivsSize = 0;
    private int iProvinceID = 0;

    public Button_BotBar_SuppRebels(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, isClickable, isVisible);
        this.iTextPositionX = CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        for (int i = 0; i < this.iCivsSize; ++i) {
            if (this.lCivs.get(i) < 0) {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                continue;
            }
            CFG.core.getCiv(this.lCivs.get(i)).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - CFG.core.getCiv(this.lCivs.get(i)).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        }
        IMGManager.getIMG(Images.diploRevolution).draw(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)), (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution)));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    @Override
    public void setCurr(int iProvinceID) {
        this.iProvinceID = iProvinceID;
        this.lCivs.clear();
        this.lCivsTurnsLeft.clear();
        this.lSupportedByCivs.clear();
        this.iCivsSize = 0;
        for (int i = 0; i < CFG.core.getProv((int)iProvinceID).provGD.iSupportRebelsSize; ++i) {
            boolean wasAdded = false;
            int tAddID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID) ? CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID : CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID * -1;
            for (int j = this.lCivs.size() - 1; j >= 0; --j) {
                if (this.lCivs.get(j) != tAddID) continue;
                wasAdded = true;
                this.lCivsTurnsLeft.set(j, Math.max(this.lCivsTurnsLeft.get(j), CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iTurnsLeft));
                this.lSupportedByCivs.get(j).add(CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iByCivID);
                break;
            }
            if (wasAdded) continue;
            this.lCivs.add(tAddID);
            this.lCivsTurnsLeft.add(CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iTurnsLeft);
            this.lSupportedByCivs.add(new ArrayList());
            this.lSupportedByCivs.get(this.lSupportedByCivs.size() - 1).add(CFG.core.getProv((int)iProvinceID).provGD.lSupportRebels.get((int)i).iByCivID);
            if (this.lCivs.size() >= 4) break;
        }
        this.iCivsSize = this.lCivs.size();
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public int getWidthE() {
        return (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + CFG.PADD * 2 + 2 + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * this.iCivsSize + CFG.PADD + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.iProvinceID).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Text_Big(" - " + CFG.lang.get("SupportRebels"), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRevolution, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (int i = 0; i < this.iCivsSize; ++i) {
                nData.add(new ME_Hover_2Type_Flag(this.lCivs.get(i)));
                nData.add(new ME_Hover_2Type_Text(this.lCivs.get(i) > 0 ? CFG.core.getCiv(this.lCivs.get(i)).getCivName() : CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                for (int k = 0; k < this.lSupportedByCivs.get(i).size() && k < 10; ++k) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.lSupportedByCivs.get(i).get(k)) ? this.lSupportedByCivs.get(i).get(k) : -this.lSupportedByCivs.get(i).get(k).intValue(), k == 0 ? CFG.PADD : 0, 0));
                }
                nData.add(new ME_Hover_2Type_Text(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + this.lCivsTurnsLeft.get(i)), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", this.lCivsTurnsLeft.get(i)) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }
}

