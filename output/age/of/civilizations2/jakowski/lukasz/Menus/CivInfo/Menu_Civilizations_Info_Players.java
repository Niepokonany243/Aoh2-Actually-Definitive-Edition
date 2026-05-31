
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_Player;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_DiplomacyORActions;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilizations_Info_Players
extends Menu {
    public Menu_Civilizations_Info_Players() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_InGameBox(null, -1, CFG.PADD + 2, CFG.PADD, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer() ? -1 : CFG.getActiveCivInfoId());
            }

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
        menuElements.add(new Button_In_Game_Box_Player(null, -1, CFG.PADD + 2, CFG.PADD + ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(0).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Player") + " 1"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        for (int i = 1; i < CFG.core.getPlayersSize(); ++i) {
            menuElements.add(new Button_In_Game_Players_Box_LEFT(null, -1, CFG.PADD + 2, CFG.PADD + (((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD) * (i + 1), CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - 2 - (int)((float)CFG.BUTTON_H * 0.75f), true, i){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(this.getCurr()).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Player") + " " + (this.getCurr() + 1)));
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
        this.initMenu(new TitleM_TextSmall(null, Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, Menu_Civilizations_Info_Players.this.getPosX() - Core.PADDING + iTranslateX, Menu_Civilizations_Info_Players.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getHeightT(), Menu_Civilizations_Info_Players.this.getWidthM() + Core.PADDING, this.getHeightT());
                CFG.drawRect_InfoBox_Right_Title(oSB, Menu_Civilizations_Info_Players.this.getPosX() + 2 + iTranslateX, Menu_Civilizations_Info_Players.this.getPosY() - this.getHeightT(), Menu_Civilizations_Info_Players.this.getWidthM(), this.getHeightT());
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText() + CFG.core.getPlayersSize(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        }, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4 + Menu_InGame_Civ_DiplomacyORActions.getButtonHeight() + CFG.PADD * 2, CFG.CIV_INFO_MENU_WIDTH, CFG.BUTTON_H * 2 + CFG.BUTTON_H / 2 + CFG.PADD * 2 > ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() : CFG.BUTTON_H * 2 + CFG.BUTTON_H / 2 + CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Players") + ": ");
        this.getMenuElem(0).setTextE(CFG.lang.get("AddPlayer"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight(), this.getWidthM() + Core.PADDING, this.getHeightM() + CFG.PADD + 2 + Core.PADDING, false, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
        switch (iID) {
            case 0: {
                boolean bRandomCiv = false;
                if (CFG.getActiveCivInfoId() > 0) {
                    for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        if (CFG.core.getPlayer(i).getCivId() != CFG.getActiveCivInfoId()) continue;
                        bRandomCiv = true;
                        break;
                    }
                }
                CFG.core.addPlayer2(0);
                if (!bRandomCiv) {
                    CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).setCivId(CFG.getActiveCivInfoId());
                }
                CFG.toastM.addM(CFG.core.getCiv(CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).getCivId()).getCivName() + " - " + CFG.lang.get("Added"));
                return;
            }
            case 1: {
                if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(0).getCivId());
                    CFG.core.getPlayer(0).setCivId(CFG.getActiveCivInfoId());
                    CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(0).getCivId(), 0);
                } else if (CFG.core.getPlayer(0).getCivId() != CFG.getActiveCivInfoId()) {
                    for (int i = 1; i < CFG.core.getPlayersSize(); ++i) {
                        if (CFG.core.getPlayer(i).getCivId() != CFG.getActiveCivInfoId()) continue;
                        int tempCiv = CFG.core.getPlayer(0).getCivId();
                        CFG.core.getPlayer(0).setCivId(CFG.core.getPlayer(i).getCivId());
                        CFG.core.getPlayer(i).setCivId(tempCiv);
                        if (CFG.core.getPlayer(0).getCivId() > 0) {
                            CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).setIsPlayer(true);
                        }
                        if (CFG.core.getPlayer(i).getCivId() > 0) {
                            CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setIsPlayer(true);
                        }
                        return;
                    }
                } else if (CFG.core.getPlayer(0).getCivId() > 0) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(0).getCivId());
                    if (CFG.core.getPlayer(0).getCivId() > 0) {
                        CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).setIsPlayer(false);
                    }
                    CFG.core.getPlayer(0).setCivId(-1);
                }
                return;
            }
        }
        try {
            if (iID % 2 == 0) {
                if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(iID / 2).getCivId());
                    CFG.core.getPlayer(iID / 2).setCivId(CFG.getActiveCivInfoId());
                    CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(iID / 2).getCivId(), 0);
                } else if (CFG.core.getPlayer(iID / 2).getCivId() != CFG.getActiveCivInfoId()) {
                    for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        if (i == iID / 2 || CFG.core.getPlayer(i).getCivId() != CFG.getActiveCivInfoId()) continue;
                        int tempCiv = CFG.core.getPlayer(iID / 2).getCivId();
                        CFG.core.getPlayer(iID / 2).setCivId(CFG.core.getPlayer(i).getCivId());
                        CFG.core.getPlayer(i).setCivId(tempCiv);
                        if (CFG.core.getPlayer(iID / 2).getCivId() > 0) {
                            CFG.core.getCiv(CFG.core.getPlayer(iID / 2).getCivId()).setIsPlayer(true);
                        }
                        if (CFG.core.getPlayer(i).getCivId() > 0) {
                            CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setIsPlayer(true);
                        }
                        return;
                    }
                } else if (CFG.core.getPlayer(iID / 2).getCivId() > 0) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(iID / 2).getCivId());
                    if (CFG.core.getPlayer(iID / 2).getCivId() > 0) {
                        CFG.core.getCiv(CFG.core.getPlayer(iID / 2).getCivId()).setIsPlayer(false);
                    }
                    CFG.core.getPlayer(iID / 2).setCivId(-1);
                }
            } else {
                CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(iID / 2).getCivId());
                CFG.core.removePlayer(iID / 2);
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.menus.rebuildCivs_Info_Players();
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }
}

