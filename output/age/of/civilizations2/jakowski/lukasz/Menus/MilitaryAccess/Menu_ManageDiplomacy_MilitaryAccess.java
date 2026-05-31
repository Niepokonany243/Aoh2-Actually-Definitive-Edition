/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.MilitaryAccess;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add_V;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_MilitaryAccess
extends Menu {
    public Menu_ManageDiplomacy_MilitaryAccess() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Add("", -1, CFG.PADD, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() - CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getFlagC().getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
            }
        });
        menuElements.add(new Button_Add("", -1, CFG.PADD * 2 + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() - CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getFlagC().getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
            }
        });
        menuElements.add(new Button_Add_V("", -1, CFG.PADD * 3 + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3 * 2, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), this.getMenuElem(0).getHeightE() + CFG.PADD * 2, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.575f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), (this.getMenuElem(0).getHeightE() + CFG.PADD * 2) / 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0425f, 0.0475f, 0.06f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
            int tempProvincePosX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() + CFG.core.getProv(CFG.core.getActiveProvID()).getTranslateProvPosX();
            int tempButtonPosX = this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() / 2 + this.getMenuPosX() + iTranslateX;
            int tempProvincePosY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() + CFG.map.getMpC().getPY();
            int tempButtonPosY = this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 + this.getMenuPosY() + iTranslateY;
            tempProvincePosX = (int)((float)tempProvincePosX * CFG.map.getMpS().getCurrSc());
            tempProvincePosY = (int)((float)tempProvincePosY * CFG.map.getMpS().getCurrSc());
            int iWidth = (int)Math.ceil(Math.sqrt((tempButtonPosX - tempProvincePosX) * (tempButtonPosX - tempProvincePosX) + (tempProvincePosY - tempButtonPosY) * (tempProvincePosY - tempButtonPosY)));
            float fAngle = (float)(Math.atan2(tempProvincePosY - tempButtonPosY, -tempProvincePosX + tempButtonPosX) * 180.0 / Math.PI);
            float tempAngle = fAngle > 90.0f ? 90.0f - fAngle % 90.0f : (fAngle < -90.0f ? -(90.0f + fAngle % 90.0f) : fAngle);
            int offsetX = -((int)((float)IMGManager.getIMG(Images.line32).getHeight() / 2.0f * (tempAngle / 90.0f)));
            int offsetY = -((int)((float)IMGManager.getIMG(Images.line32).getHeight() / 2.0f * ((90.0f - Math.abs(fAngle)) / 90.0f)));
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.45f));
            IMGManager.getIMG(Images.line32).drawO(oSB, tempProvincePosX + offsetX, tempProvincePosY + offsetY, iWidth, IMGManager.getIMG(Images.line32).getHeight(), fAngle, 0);
            oSB.setColor(Color.WHITE);
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 2: {
                CFG.core.setMilitaryAccess(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, 5);
                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getCapitalProvID());
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_MilitaryAccess();
            }
        }
    }
}

