
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.Button.RandomGame.Button_RandomGame_Box_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.RandomGame.Button_RandomGame_Box_Localization;
import age.of.civilizations2.jakowski.lukasz.Button.RandomGame.Button_RandomGame_Box_Localization_Middle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_RandomGame_Players
extends Menu {
    public static final int ANIMATION_TIME = 250;
    public static long lTime = 0L;

    public Menu_RandomGame_Players() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_InGameBox(null, -1, CFG.PADD + 2, CFG.PADD, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddaPlayerToTheGame"), CFG.COLOR_HOVER_TITLE));
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                    nData.add(new ME_Hover_2Type_Flag_Big(-1, CFG.PADD, 0));
                } else {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_RandomGame_Box_LEFT(null, -1, CFG.PADD + 2, CFG.PADD + ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2 - (int)((float)CFG.BUTTON_H * 0.75f), true, 0));
        menuElements.add(new Button_RandomGame_Box_Localization(null, -1, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), CFG.PADD + ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.75f), true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SetCapital"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        for (int i = 1; i < CFG.randomGameManager.getPlayersSize(); ++i) {
            menuElements.add(new Button_RandomGame_Box_LEFT(null, -1, CFG.PADD + 2, CFG.PADD + (((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD) * (i + 1), CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2 - (int)((float)CFG.BUTTON_H * 0.75f) * 2, true, i));
            menuElements.add(new Button_RandomGame_Box_Localization_Middle(null, -1, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f) * 2, CFG.PADD + (((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD) * (i + 1), (int)((float)CFG.BUTTON_H * 0.75f), true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SetCapital"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_In_Game_Players_Box_RIGHT(null, -1, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), CFG.PADD + (((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD) * (i + 1), (int)((float)CFG.BUTTON_H * 0.75f), true){

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
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_RandomGame_Players.this.getPosX() + iTranslateX, Menu_RandomGame_Players.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_RandomGame_Players.this.getWidthM() + 2, this.getHeightT(), false, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_RandomGame_Players.this.getPosX() + iTranslateX, Menu_RandomGame_Players.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_RandomGame_Players.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_RandomGame_Players.this.getPosX() + iTranslateX, Menu_RandomGame_Players.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_RandomGame_Players.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_RandomGame_Players.this.getPosX() + iTranslateX, Menu_RandomGame_Players.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_RandomGame_Players.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), CFG.COLOR_TEXT_GRAY_LEFT_NS);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, CFG.CIV_INFO_MENU_WIDTH, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 4 - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) ? CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 4 - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Players") + ": " + CFG.randomGameManager.getPlayersSize());
        this.getMenuElem(0).setTextE(CFG.lang.get("AddPlayer"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight(), this.getWidthM(), this.getHeightM() + CFG.PADD + 2, false, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.randomGameManager.addPlayer();
                CFG.menus.rebuildCreateRandomGame_Players();
                CFG.toastM.addM(CFG.lang.get("Added"), CFG.COLOR_HOVER_TITLE);
                return;
            }
            case 1: {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 0;
                CFG.menus.setMenuID(View.eCREATE_RANDOM_GAME_CIVILIZATIONS_SELECT);
                return;
            }
            case 2: {
                if (CFG.randomGameManager.getPlayer(0).getCapitalProvinceID() == CFG.core.getActiveProvID()) {
                    CFG.randomGameManager.getPlayer(0).setCapitalProvinceID(-1);
                    CFG.toastM.addM(CFG.lang.get("Random"), CFG.COLOR_HOVER_TITLE);
                } else if (!CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                    for (int i = 0; i < CFG.randomGameManager.getPlayersSize(); ++i) {
                        if (CFG.randomGameManager.getPlayer(i).getCapitalProvinceID() != CFG.core.getActiveProvID()) continue;
                        CFG.randomGameManager.getPlayer(i).setCapitalProvinceID(-1);
                    }
                    CFG.randomGameManager.getPlayer(0).setCapitalProvinceID(CFG.core.getActiveProvID());
                    CFG.toastM.addM(CFG.lang.get("Updated"), CFG.COLOR_HOVER_TITLE);
                }
                return;
            }
        }
        if ((iID - 3) % 3 == 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = (iID - 3) / 3 + 1;
            CFG.menus.setMenuID(View.eCREATE_RANDOM_GAME_CIVILIZATIONS_SELECT);
        } else if ((iID - 3) % 3 == 1) {
            if (CFG.randomGameManager.getPlayer((iID - 3) / 3 + 1).getCapitalProvinceID() == CFG.core.getActiveProvID()) {
                CFG.randomGameManager.getPlayer((iID - 3) / 3 + 1).setCapitalProvinceID(-1);
                CFG.toastM.addM(CFG.lang.get("Random"), CFG.COLOR_HOVER_TITLE);
            } else if (!CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                for (int i = 0; i < CFG.randomGameManager.getPlayersSize(); ++i) {
                    if (CFG.randomGameManager.getPlayer(i).getCapitalProvinceID() != CFG.core.getActiveProvID()) continue;
                    CFG.randomGameManager.getPlayer(i).setCapitalProvinceID(-1);
                }
                CFG.randomGameManager.getPlayer((iID - 3) / 3 + 1).setCapitalProvinceID(CFG.core.getActiveProvID());
                CFG.toastM.addM(CFG.lang.get("Updated"), CFG.COLOR_HOVER_TITLE);
            }
        } else if ((iID - 3) % 3 == 2) {
            CFG.randomGameManager.removePlayer((iID - 3) / 3 + 1);
            CFG.menus.rebuildCreateRandomGame_Players();
            CFG.toastM.addM(CFG.lang.get("Deleted"), CFG.COLOR_HOVER_TITLE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && !this.getVisibleM()) {
            lTime = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }
}

