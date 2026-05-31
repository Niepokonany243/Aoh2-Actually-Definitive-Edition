/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Vassals;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_Vassals_List
extends Menu {
    public Menu_ManageDiplomacy_Vassals_List() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = (int)((float)CFG.BUTTON_H * 0.75f);
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID > 0) {
            int multiplePosY = 0;
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID || CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getCiv(i).getPuppetOfCiv()) continue;
                menuElements.add(new Button_In_Game_Box_CivID_LEFT(i, CFG.core.getCiv(i).getCivName(), -1, CFG.PADD, CFG.PADD * (multiplePosY + 1) + tempElemH * multiplePosY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.75f), true));
                menuElements.add(new Button_In_Game_Players_Box_RIGHT("", -1, tempW - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), CFG.PADD * (multiplePosY + 1) + tempElemH * multiplePosY, (int)((float)CFG.BUTTON_H * 0.75f), true){

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ++multiplePosY;
            }
        }
        int menuHeight = Math.min((tempElemH + CFG.PADD) * (menuElements.size() / 2) + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H - CFG.PADD * 2);
        if (!menuElements.isEmpty() && menuHeight < (tempElemH + CFG.PADD) * (menuElements.size() / 2) + CFG.PADD) {
             menuHeight = Math.max(menuHeight, CFG.GAMEHEIGHT * 2 / 3);
        }
        
        // Ensure minimum stable height even with few elements to avoid flickering/unstable UI
        if (!menuElements.isEmpty()) {
            menuHeight = Math.max(menuHeight, tempElemH + CFG.PADD * 2);
        }

        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_ManageDiplomacy_Vassals_List.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Vassals_List.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_ManageDiplomacy_Vassals_List.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_ManageDiplomacy_Vassals_List.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Vassals_List.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_ManageDiplomacy_Vassals_List.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_ManageDiplomacy_Vassals_List.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Vassals_List.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_ManageDiplomacy_Vassals_List.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_ManageDiplomacy_Vassals_List.this.getPosX() + iTranslateX, Menu_ManageDiplomacy_Vassals_List.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_ManageDiplomacy_Vassals_List.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                try {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getFlagC().drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, menuHeight, menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Vassals"));
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
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        if (iID % 2 == 0) {
            this.centerVassal(iID / 2);
        } else if (iID % 2 == 1) {
            this.removeVassal(iID / 2);
            CFG.menus.rebuildManageDiplomacy_Vassals_List();
        }
    }

    private final void removeVassal(int vassalID) {
        if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID > 0) {
            int foundVassals = 0;
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID || CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getCiv(i).getPuppetOfCiv()) continue;
                if (foundVassals == vassalID) {
                    CFG.core.resetVassal_CivID(i);
                    return;
                }
                ++foundVassals;
            }
        }
    }

    private final void centerVassal(int vassalID) {
        if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID > 0) {
            int foundVassals = 0;
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID || CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getCiv(i).getPuppetOfCiv()) continue;
                if (foundVassals == vassalID) {
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(i).getCapitalProvID());
                    return;
                }
                ++foundVassals;
            }
        }
    }
}

