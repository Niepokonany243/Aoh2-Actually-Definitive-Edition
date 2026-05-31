
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Infobox
extends Menu {
    public int iCivID = 0;
    public int iCivID2 = 0;
    public long lTime = 0L;
    public int iInfoY;
    public boolean hideAnimation = false;
    public float fAnimationPerc = 1.0f;
    public int iAnimationWidth = 1;
    public int infoIMG = 0;
    public String sText;
    public int iTextWidth;
    public int iTextHeight;
    public String sText2;
    public int iTextWidth2;
    public int iTextHeight2;
    public String sText3;
    public int iTextWidth3;
    public int iTextHeight3;
    public int fontID = CFG.FONT_BOLD;
    public boolean smallFlags = false;

    public Menu_InGame_Infobox() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.setVisibleM(false);
    }

    public Menu_InGame_Infobox(String nText, String nText2, String nText3, int civLeft, int civRight, int infoIMG) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.iInfoY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 4;
        this.iCivID = civLeft;
        this.iCivID2 = civRight;
        this.infoIMG = infoIMG;
        this.sText = nText;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
        this.iTextHeight = (int)CFG.glyphLay.height;
        this.sText2 = nText2;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText2);
        this.iTextWidth2 = (int)CFG.glyphLay.width;
        this.iTextHeight2 = (int)CFG.glyphLay.height;
        this.sText3 = nText3;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText3);
        this.iTextWidth3 = (int)CFG.glyphLay.width;
        this.iTextHeight3 = (int)CFG.glyphLay.height;
        this.lTime = CFG.currentTimeMillis;
    }

    public Menu_InGame_Infobox(String nText, String nText2, String nText3, int civLeft, int civRight, int infoIMG, boolean smallFlags) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, 1, 1, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.iInfoY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 4;
        this.smallFlags = smallFlags;
        this.iCivID = civLeft;
        this.iCivID2 = civRight;
        this.infoIMG = infoIMG;
        this.sText = nText;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
        this.iTextHeight = (int)CFG.glyphLay.height;
        this.sText2 = nText2;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText2);
        this.iTextWidth2 = (int)CFG.glyphLay.width;
        this.iTextHeight2 = (int)CFG.glyphLay.height;
        this.sText3 = nText3;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sText3);
        this.iTextWidth3 = (int)CFG.glyphLay.width;
        this.iTextHeight3 = (int)CFG.glyphLay.height;
        this.lTime = CFG.currentTimeMillis;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.hideAnimation) {
            if (this.lTime + (long)GameValues.gvInGame.INFO_BOX_ANIMATION_TIME >= CFG.currentTimeMillis) {
                this.fAnimationPerc = 1.0f - (float)(CFG.currentTimeMillis - this.lTime) / (float)GameValues.gvInGame.INFO_BOX_ANIMATION_TIME;
                this.fAnimationPerc = Math.max(0.0f, this.fAnimationPerc);
            } else {
                this.fAnimationPerc = 0.0f;
                this.setVisibleM(false);
            }
            this.iAnimationWidth = (int)((float)IMGManager.getIMG(Images.infoBox).getWidth() * this.fAnimationPerc);
        } else {
            if (this.lTime + (long)GameValues.gvInGame.INFO_BOX_ANIMATION_TIME >= CFG.currentTimeMillis) {
                this.fAnimationPerc = (float)(CFG.currentTimeMillis - this.lTime) / (float)GameValues.gvInGame.INFO_BOX_ANIMATION_TIME;
                this.fAnimationPerc = Math.min(1.0f, this.fAnimationPerc);
            } else {
                this.fAnimationPerc = 1.0f;
            }
            this.iAnimationWidth = (int)((float)IMGManager.getIMG(Images.infoBox).getWidth() * this.fAnimationPerc);
            if (this.lTime + (long)GameValues.gvInGame.INFO_BOX_TIME_IN_VIEW <= CFG.currentTimeMillis) {
                this.hideAnimation = true;
                this.lTime = CFG.currentTimeMillis;
            }
        }
        this.drawInfoBox(oSB, CFG.GAMEWIDTH / 2 - this.getInfoBoxWidthTotalAnimation() / 2, this.iInfoY);
    }

    public void drawInfoBox(SpriteBatch oSB, int iX, int iY) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f * this.fAnimationPerc));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, iX, iY - this.getInfoBoxHeightTotal() / 4, this.getInfoBoxWidthTotalAnimation(), this.getInfoBoxHeightTotal() / 2 + this.getInfoBoxHeightTotal() / 4);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, iX, iY + this.getInfoBoxHeightTotal() / 2, this.getInfoBoxWidthTotalAnimation(), this.getInfoBoxHeightTotal() * 3 / 4, false, true);
        oSB.setColor(Color.WHITE);
        if (this.hideAnimation) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f * this.fAnimationPerc));
        }
        try {
            IMGManager.getIMG(this.infoIMG).draw(oSB, iX + this.getInfoBoxWidthTotalAnimation() / 2 - (int)((float)IMGManager.getIMG(this.infoIMG).getWidth() * (0.5f + 0.5f * this.fAnimationPerc) / 2.0f), iY + this.getInfoBoxHeightTotal() / 2 - (int)((float)IMGManager.getIMG(this.infoIMG).getHeight() * (0.5f + 0.5f * this.fAnimationPerc) / 2.0f), (int)((float)IMGManager.getIMG(this.infoIMG).getWidth() * (0.5f + 0.5f * this.fAnimationPerc)), (int)((float)IMGManager.getIMG(this.infoIMG).getHeight() * (0.5f + 0.5f * this.fAnimationPerc)));
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        IMGManager.getIMG(Images.infoBox).draw(oSB, iX, iY, this.iAnimationWidth, IMGManager.getIMG(Images.infoBox).getHeight());
        oSB.setColor(Color.WHITE);
        if (this.iCivID <= 0) {
            try {
                Renderer.drawText(oSB, this.fontID, this.sText, CFG.GAMEWIDTH / 2 - this.iTextWidth / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 - this.iTextHeight - CFG.PADD, new Color(Colors.COLOR_INFO_BOX2.r, Colors.COLOR_INFO_BOX2.g, Colors.COLOR_INFO_BOX2.b, this.fAnimationPerc));
                Renderer.drawText(oSB, this.fontID, this.sText2, CFG.GAMEWIDTH / 2 - this.iTextWidth2 / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 + CFG.PADD, new Color(Colors.COLOR_INFO_BOX2_BOT.r, Colors.COLOR_INFO_BOX2_BOT.g, Colors.COLOR_INFO_BOX2_BOT.b, this.fAnimationPerc));
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        } else {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.fAnimationPerc));
            try {
                if (this.iCivID > 0) {
                    if (this.smallFlags) {
                        Core.drawFlagRect(oSB, CFG.GAMEWIDTH / 2 - IMGManager.getIMG(Images.infoBox).getWidth() / 2 + CFG.PADD * 4, iY + IMGManager.getIMG(Images.infoBox).getHeight() * 3 / 4 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2, this.iCivID);
                    } else {
                        Core.drawFlagDiplomacy(oSB, CFG.GAMEWIDTH / 2 - IMGManager.getIMG(Images.infoBox).getWidth() / 2 + CFG.PADD * 4, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2, this.iCivID);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                if (this.iCivID2 > 0) {
                    if (this.smallFlags) {
                        Core.drawFlagRect(oSB, CFG.GAMEWIDTH / 2 + IMGManager.getIMG(Images.infoBox).getWidth() / 2 - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 4, iY + IMGManager.getIMG(Images.infoBox).getHeight() * 3 / 4 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2, this.iCivID2);
                    } else {
                        Core.drawFlagDiplomacy(oSB, CFG.GAMEWIDTH / 2 + IMGManager.getIMG(Images.infoBox).getWidth() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() - CFG.PADD * 4, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2, this.iCivID2);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            oSB.setColor(Color.WHITE);
            try {
                Renderer.drawText(oSB, this.fontID, this.sText, CFG.GAMEWIDTH / 2 - this.iTextWidth / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 - this.iTextHeight - CFG.PADD, new Color(Colors.COLOR_INFO_BOX2.r, Colors.COLOR_INFO_BOX2.g, Colors.COLOR_INFO_BOX2.b, this.fAnimationPerc));
                if (this.sText3.length() == 0) {
                    Renderer.drawText(oSB, this.fontID, this.sText2, CFG.GAMEWIDTH / 2 - this.iTextWidth2 / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 + CFG.PADD, new Color(Colors.COLOR_INFO_BOX2_BOT.r, Colors.COLOR_INFO_BOX2_BOT.g, Colors.COLOR_INFO_BOX2_BOT.b, this.fAnimationPerc));
                } else {
                    Renderer.drawText(oSB, this.fontID, this.sText2, CFG.GAMEWIDTH / 2 - this.iTextWidth2 - CFG.PADD / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 + CFG.PADD, new Color(Colors.COLOR_INFO_BOX2_BOT.r, Colors.COLOR_INFO_BOX2_BOT.g, Colors.COLOR_INFO_BOX2_BOT.b, this.fAnimationPerc));
                    Renderer.drawText(oSB, this.fontID, this.sText3, CFG.GAMEWIDTH / 2 + CFG.PADD / 2, iY + IMGManager.getIMG(Images.infoBox).getHeight() / 2 + CFG.PADD, new Color(Colors.COLOR_INFO_BOX2_BOT.r, Colors.COLOR_INFO_BOX2_BOT.g, Colors.COLOR_INFO_BOX2_BOT.b, this.fAnimationPerc));
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public int getInfoBoxWidth() {
        return IMGManager.getIMG(Images.infoBox).getWidth();
    }

    public int getInfoBoxHeightTotal() {
        return IMGManager.getIMG(Images.infoBox).getHeight();
    }

    public int getInfoBoxWidthTotalAnimation() {
        return this.iAnimationWidth;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (visible) {
            this.lTime = CFG.currentTimeMillis;
            this.hideAnimation = false;
        }
    }
}

