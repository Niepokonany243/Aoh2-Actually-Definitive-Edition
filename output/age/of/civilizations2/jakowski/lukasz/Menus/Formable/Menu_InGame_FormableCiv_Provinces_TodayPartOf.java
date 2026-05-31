
package age.of.civilizations2.jakowski.lukasz.Menus.Formable;

import age.of.civilizations2.jakowski.lukasz.Button.Button_TodayPartOf;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_FormableCiv_Provinces_TodayPartOf
extends Menu {
    public Menu_InGame_FormableCiv_Provinces_TodayPartOf() {
        boolean tAdd;
        int i;
        int iPartOfSize;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tElementH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 2);
        int tPosY = 0;
        ArrayList<Integer> tempPartOf = new ArrayList<Integer>();
        ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
        int nFormableCivMapProvinces = 0;
        if (CFG.FOG_OF_WAR == 2) {
            iPartOfSize = 0;
            for (i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getSeaProv() || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() <= 0) continue;
                tAdd = true;
                int tempCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.formableCivs_GameData.getProvinceID(i)) ? CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() : -1;
                for (int j = 0; j < iPartOfSize; ++j) {
                    if ((Integer)tempPartOf.get(j) != tempCivID) continue;
                    tAdd = false;
                    tempProvinces.set(j, (Integer)tempProvinces.get(j) + 1);
                    break;
                }
                if (tAdd) {
                    tempPartOf.add(tempCivID);
                    tempProvinces.add(1);
                    ++iPartOfSize;
                }
                ++nFormableCivMapProvinces;
            }
        } else {
            iPartOfSize = 0;
            for (i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getSeaProv() || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() <= 0) continue;
                tAdd = true;
                for (int j = 0; j < iPartOfSize; ++j) {
                    if (((Integer)tempPartOf.get(j)).intValue() != CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId()) continue;
                    tAdd = false;
                    tempProvinces.set(j, (Integer)tempProvinces.get(j) + 1);
                    break;
                }
                if (tAdd) {
                    tempPartOf.add(CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId());
                    tempProvinces.add(1);
                    ++iPartOfSize;
                }
                ++nFormableCivMapProvinces;
            }
        }
        int iSize = tempPartOf.size();
        for (i = 0; i < iSize; ++i) {
            for (int j = i + 1; j < iSize; ++j) {
                if ((Integer)tempProvinces.get(i) >= (Integer)tempProvinces.get(j)) continue;
                int tRev = (Integer)tempPartOf.get(i);
                tempPartOf.set(i, (Integer)tempPartOf.get(j));
                tempPartOf.set(j, tRev);
                tRev = (Integer)tempProvinces.get(i);
                tempProvinces.set(i, (Integer)tempProvinces.get(j));
                tempProvinces.set(j, tRev);
            }
        }
        for (i = 0; i < tempPartOf.size(); ++i) {
            menuElements.add(new Button_TodayPartOf((Integer)tempPartOf.get(i), CFG.getPercentageOld((Integer)tempProvinces.get(i), nFormableCivMapProvinces, 4), 0, tPosY, tMenuWidth, tElementH, true));
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H / 2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, this.getHeightT(), true, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, this.getHeightT(), true, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY + 2 - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth - CFG.PADD * 2 - this.getTextWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH - tMenuWidth, Math.max(CFG.BUTTON_H * 4 / 5, Math.max(IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2 + CFG.BUTTON_H / 2, tMenuWidth, Math.min(CFG.GAMEHEIGHT - (Math.max(CFG.BUTTON_H * 4 / 5, Math.max(IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2 + CFG.BUTTON_H / 2), ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, true, false);
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("TodayPartOf") + " [" + this.getMenuElemsSize() + "]");
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        try {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == this.getMenuElem(iID).getCurr() ? CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() : this.getMenuElem(iID).getCurr();
            for (int i = 0; i < CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getNumOfProvs(); ++i) {
                CFG.core.getProv(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getProvID(i)).setFromCivID(0);
            }
            CFG.toastM.addM(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName());
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            CFG.toastM.addM(CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
    }
}

