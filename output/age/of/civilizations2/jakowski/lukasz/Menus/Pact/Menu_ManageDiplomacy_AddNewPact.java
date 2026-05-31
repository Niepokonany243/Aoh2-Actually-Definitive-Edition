/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Pact;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add_V;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_AddNewPact
extends Menu {
    public Menu_ManageDiplomacy_AddNewPact() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Add("", -1, CFG.PADD, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
            }
        });
        menuElements.add(new Button_Add("", -1, CFG.PADD * 2 + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
            }
        });
        menuElements.add(new Button_Add_V("", -1, CFG.PADD * 3 + (CFG.GAMEWIDTH - CFG.PADD * 4) / 3 * 2, CFG.PADD, (CFG.GAMEWIDTH - CFG.PADD * 4) / 3, CFG.BUTTON_H + CFG.BUTTON_H / 2, false));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("AddNewPact"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight(), this.getWidthM(), this.getMenuElem(1).getHeightE() + CFG.PADD * 2, false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
            int tempProvincePosX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() + CFG.core.getProv(CFG.core.getActiveProvID()).getTranslateProvPosX();
            int tempButtonPosX = this.getMenuElem(1).getPosXE() + this.getMenuElem(1).getWidthE() / 2 + this.getMenuPosX() + iTranslateX;
            int tempProvincePosY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY() + CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() + CFG.map.getMpC().getPY();
            int tempButtonPosY = this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 + this.getMenuPosY() + iTranslateY;
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

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 3: {
                CFG.core.setCivNonAggressionPact(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, 5);
                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getCapitalProvID());
                this.onBackPressed();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
        CFG.menus.setBackAnimation(true);
        RenderProvince.updateDrawProvinces();
        CFG.map.getTouchMgr().ueExA();
    }
}

