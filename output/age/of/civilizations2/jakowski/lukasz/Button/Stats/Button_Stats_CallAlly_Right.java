/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_CallAlly;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Stats_CallAlly_Right
extends Button_Stats_CallAlly {
    private String sCallAll;
    private int iCallAllyWidth;

    public Button_Stats_CallAlly_Right(int nCivID, int iPosX, int iPosY, int iWidth, boolean isDeclareWar) {
        super(nCivID, iPosX, iPosY, iWidth, isDeclareWar);
        this.callAlly(isDeclareWar);
    }

    public Button_Stats_CallAlly_Right(int nCivID, int iPosX, int iPosY, int iWidth, boolean checkbox, boolean isDeclareWar) {
        super(nCivID, iPosX, iPosY, iWidth, checkbox, isDeclareWar);
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
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsClickable() && this.iCallAllyWidth > 0) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.175f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.iCallAllyWidth + CFG.PADD * 4, this.getHeightE());
            oSB.setColor(Color.WHITE);
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sCallAll, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + (int)((float)(this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2.0f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        }
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - 2 + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - 2 - IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - 2 - IMGManager.getIMG(Images.flagRect2).getWidth() - this.getTextWidthU() + iTranslateX, this.getPosY() + (int)((float)(this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2.0f) + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Stats_CallAlly_Right.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.2f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.15f));
                    }
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, Button_Stats_CallAlly_Right.this.getPosXE() + iTranslateX, Button_Stats_CallAlly_Right.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + iTranslateY, Button_Stats_CallAlly_Right.this.getWidthE(), Button_Stats_CallAlly_Right.this.getHeightE() - 2, false, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Stats_CallAlly_Right.this.getPosXE() + iTranslateX, Button_Stats_CallAlly_Right.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Stats_CallAlly_Right.this.getWidthE(), Button_Stats_CallAlly_Right.this.getHeightE() / 4, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Stats_CallAlly_Right.this.getPosXE() + iTranslateX, Button_Stats_CallAlly_Right.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Stats_CallAlly_Right.this.getHeightE() - 1 + iTranslateY - Button_Stats_CallAlly_Right.this.getHeightE() / 4, Button_Stats_CallAlly_Right.this.getWidthE(), Button_Stats_CallAlly_Right.this.getHeightE() / 4, false, true);
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
}

