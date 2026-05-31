/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Flag;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Flag
extends MenuElemUI {
    private int iCivID;
    private DrawButton drawButton;

    public Button_Flag(int nCivID, int nPosX, int nPosY, int nWidth, int nHeight, ButtonFlagType buttonFlagType) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.iCivID = nCivID;
        this.setPosX(nPosX);
        this.setPosY(nPosY);
        this.setWidthE(nWidth);
        this.setHeightE(nHeight);
        switch (buttonFlagType) {
            case FLAG_COLOR: {
                if (this.iCivID >= 0) {
                    this.drawButton = new DrawButton(){

                        @Override
                        public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(Button_Flag.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Button_Flag.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Button_Flag.this.iCivID).getB() / 255.0f, 1.0f));
                            IMGManager.getIMG(Images.pix255).drawO(oSB, Button_Flag.this.getPosXE() + iTranslateX, Button_Flag.this.getPosY() + iTranslateY - 1, (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE), Button_Flag.this.getHeightE());
                            oSB.setColor(Color.WHITE);
                            CFG.core.getCiv(Button_Flag.this.iCivID).getFlagC().drawO(oSB, Button_Flag.this.getPosXE() + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 2 + iTranslateX, Button_Flag.this.getPosY() - CFG.core.getCiv(Button_Flag.this.iCivID).getFlagC().getHeight() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Button_Flag.this.getPosXE() + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 2 + iTranslateX, Button_Flag.this.getPosY() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                        }
                    };
                    break;
                }
                this.drawButton = new DrawButton(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                        oSB.setColor(CFG.RANDOM_CIVILIZATION_COLOR);
                        IMGManager.getIMG(Images.pix255).drawO(oSB, Button_Flag.this.getPosXE() + iTranslateX, Button_Flag.this.getPosY() + iTranslateY - 1, (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE), Button_Flag.this.getHeightE());
                        oSB.setColor(Color.WHITE);
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, Button_Flag.this.getPosXE() + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 2 + iTranslateX, Button_Flag.this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Button_Flag.this.getPosXE() + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 2 + iTranslateX, Button_Flag.this.getPosY() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                    }
                };
                break;
            }
            case FLAG: {
                this.drawButton = this.iCivID > 0 ? new DrawButton(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                        CFG.core.getCiv(Button_Flag.this.iCivID).getFlagC().drawO(oSB, Button_Flag.this.getPosXE() + Button_Flag.this.getWidthE() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, Button_Flag.this.getPosY() - CFG.core.getCiv(Button_Flag.this.iCivID).getFlagC().getHeight() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Button_Flag.this.getPosXE() + Button_Flag.this.getWidthE() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, Button_Flag.this.getPosY() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                    }
                } : new DrawButton(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, Button_Flag.this.getPosXE() + Button_Flag.this.getWidthE() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, Button_Flag.this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Button_Flag.this.getPosXE() + Button_Flag.this.getWidthE() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, Button_Flag.this.getPosY() + iTranslateY + Button_Flag.this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                    }
                };
            }
        }
    }

    @Override
    public final void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive) {
            IMGManager.getIMG(Images.btnhMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
        } else {
            IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
        }
        this.drawButton.draw(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    public static enum ButtonFlagType {
        FLAG_COLOR,
        FLAG;

    }

    static interface DrawButton {
        public void draw(SpriteBatch var1, int var2, int var3, boolean var4, boolean var5);
    }
}

