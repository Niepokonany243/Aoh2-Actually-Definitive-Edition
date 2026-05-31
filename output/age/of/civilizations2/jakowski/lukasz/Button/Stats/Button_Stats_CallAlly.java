
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
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

public class Button_Stats_CallAlly
extends ButtonStats {
    public int iCivID;
    private String sCallAll;
    private int iCallAllyWidth;

    public Button_Stats_CallAlly(int nCivID, int iPosX, int iPosY, int iWidth, boolean isDeclareWar) {
        super("" + (nCivID < 0 ? CFG.lang.get("Undiscovered") : CFG.core.getCiv(nCivID).getCivName()), 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.BUTTON_H * 3 / 4));
        this.iCivID = nCivID;
        this.callAlly(isDeclareWar);
    }

    public Button_Stats_CallAlly(int nCivID, int iPosX, int iPosY, int iWidth, boolean checkbox, boolean isDeclareWar) {
        super("" + (nCivID < 0 ? CFG.lang.get("Undiscovered") : CFG.core.getCiv(nCivID).getCivName()), 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.BUTTON_H * 3 / 4), checkbox);
        this.iCivID = nCivID;
        this.callAlly(isDeclareWar);
    }

    private final void callAlly(boolean isDeclareWar) {
        if (isDeclareWar) {
            this.sCallAll = "";
            this.iCallAllyWidth = 0;
        } else {
            this.sCallAll = this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() ? CFG.lang.get("JoinAWar") : CFG.lang.get("CallAlly");
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sCallAll);
            this.iCallAllyWidth = (int)CFG.glyphLay.width;
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.05f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        }
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, isActive ? 0.345f : 0.265f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        }
        if (this.row) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.625f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        }
        oSB.setColor(Color.WHITE);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsClickable() && this.iCallAllyWidth > 0) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.175f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - this.iCallAllyWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.iCallAllyWidth + CFG.PADD * 4, this.getHeightE());
            oSB.setColor(Color.WHITE);
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sCallAll, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iCallAllyWidth + iTranslateX, this.getPosY() + (int)((float)(this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2.0f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        }
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + CFG.PADD * 2 + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + (int)((float)(this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2.0f) + iTranslateY, this.getColorE(isActive));
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.475f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Stats_CallAlly.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.2f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.15f));
                    }
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, Button_Stats_CallAlly.this.getPosXE() + iTranslateX, Button_Stats_CallAlly.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + iTranslateY, Button_Stats_CallAlly.this.getWidthE(), Button_Stats_CallAlly.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Stats_CallAlly.this.getPosXE() + iTranslateX, Button_Stats_CallAlly.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Stats_CallAlly.this.getWidthE(), Button_Stats_CallAlly.this.getHeightE() / 4, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Stats_CallAlly.this.getPosXE() + iTranslateX, Button_Stats_CallAlly.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Stats_CallAlly.this.getHeightE() - 1 + iTranslateY - Button_Stats_CallAlly.this.getHeightE() / 4, Button_Stats_CallAlly.this.getWidthE(), Button_Stats_CallAlly.this.getHeightE() / 4, false, true);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    public final float getImageScale(int nImageID) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : CFG.COLOR_TEXT_GRAY_NS_HOVER);
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void buildElemHover() {
        if (this.getIsClickable()) {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (this.sCallAll.length() == 0) {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclareWarOn") + ":", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName()));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("JoinAWar"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CallAlly") + ":", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        } else {
            this.menuElemHover = null;
        }
    }
}

