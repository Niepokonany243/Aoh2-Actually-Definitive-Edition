/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Pact;

import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider__CNG_Pact;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_Pacts2
extends Menu {
    public Menu_ManageDiplomacy_Pacts2() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int nAddedNum = 1;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) <= 0) continue;
                menuElements.add(new Slider__CNG_Pact(i, j, CFG.lang.get("Turns") + ": ", CFG.PADD * 2, CFG.PADD + tempElemH * nAddedNum, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 1, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT, CFG.core.getCivNonAggressionPact(i, j)));
                ++nAddedNum;
            }
        }
        menuElements.add(new Button_CNG_Options(null, -1, 0, 0, tempW, tempElemH, true));
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_ManageDiplomacy_Pacts2.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Pacts2.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_ManageDiplomacy_Pacts2.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_ManageDiplomacy_Pacts2.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Pacts2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_ManageDiplomacy_Pacts2.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_ManageDiplomacy_Pacts2.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Pacts2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_ManageDiplomacy_Pacts2.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_ManageDiplomacy_Pacts2.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Pacts2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_ManageDiplomacy_Pacts2.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0, CFG.BUTTON_H, tempW, Math.min(tempElemH * menuElements.size(), CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("NonAggressionPact"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("AddNewPact"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
            RenderProvince.updateDrawProvinces();
            CFG.map.getTouchMgr().ueExA();
            return;
        }
        this.updateNonAggressionPact(iID, this.getMenuElem(iID).getCurr());
    }

    private final void updateNonAggressionPact(int pactID, int iNumOfTurns) {
        int foundPacts = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) <= 0) continue;
                if (foundPacts == pactID) {
                    CFG.core.setCivNonAggressionPact(i, j, iNumOfTurns);
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 != i && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 != j) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(i).getCapitalProvID());
                        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = i;
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                    return;
                }
                ++foundPacts;
            }
        }
    }
}

