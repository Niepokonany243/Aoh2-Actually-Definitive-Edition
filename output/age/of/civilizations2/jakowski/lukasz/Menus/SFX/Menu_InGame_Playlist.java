/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.SFX;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Stats;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Playlist
extends Menu {
    public Menu_InGame_Playlist() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH;
        menuElements.add(new Button_InGameAction(">>", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, CFG.PADD, CFG.BUTTON_W * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Playlist.this.getElementW() - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Next"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NowPlaying") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.SFXManager.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("MusicVolume"), CFG.PADD, CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, 100, (int)(CFG.SFXManager.getMusicVolume() * 100.0f)){

            @Override
            public String getDrawText() {
                return super.getDrawText() + "%";
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Playlist.this.getElementW() - CFG.PADD * 3 - CFG.BUTTON_W * 3 / 4;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }
        });
        menuElements.add(new Button_InGameAction("<<", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Playlist.this.getElementW() - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Previous"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NowPlaying") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.SFXManager.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("EffectVolume"), CFG.PADD, ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, 100, (int)(CFG.SFXManager.getSoundsVolume() * 100.0f)){

            @Override
            public String getDrawText() {
                return super.getDrawText() + "%";
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Playlist.this.getElementW() - CFG.PADD * 3 - CFG.BUTTON_W * 3 / 4;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }
        });
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("MasterVolume"), CFG.PADD, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, 100, (int)(CFG.SFXManager.getMasterVolume() * 100.0f)){

            @Override
            public String getDrawText() {
                return super.getDrawText() + "%";
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Playlist.this.getElementW() - CFG.PADD * 2;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }
        });
        int tY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        if (CFG.SFXManager.lTitles.size() > 1) {
            menuElements.add(new TextBuildTitle(CFG.lang.get("Radio"), -1, 1, tY, tempWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Playlist.this.getElementW() - 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (i = 0; i < CFG.SFXManager.lTitles.size(); ++i) {
                menuElements.add(new Button_DiplomacyAction(Images.bLibrary, CFG.SFXManager.lStations.get(i), 1, 0, tY, tempWidth - 2, tempElemH, true){
                    int id;
                    {
                        this.id = 0;
                    }

                    @Override
                    public int getCurr() {
                        return this.id;
                    }

                    @Override
                    public void setMax(int iMax) {
                        this.id = iMax;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_Playlist.this.getElementW() - 2;
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (this.getCurr() != CFG.SFXManager.stationID) {
                            CFG.SFXManager.stationID = this.getCurr();
                            CFG.SFXManager.iCurrentMusicID = 0;
                            CFG.SFXManager.randomizePlayList();
                            CFG.SFXManager.loadNextMusic_Default(CFG.SFXManager.lTitles.get(CFG.SFXManager.stationID).get(0));
                            if (CFG.menus.getInSettings()) {
                                CFG.menus.rebuildSettings_Audio();
                            } else if (CFG.menus.getInGameView()) {
                                CFG.menus.setVisibleInGame_Playlist(true);
                            }
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Radio") + ": "));
                        nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(i);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            menuElements.add(new TextBuildTitle(CFG.SFXManager.lStations.get(CFG.SFXManager.stationID), -1, 1, tY, tempWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Playlist.this.getElementW() - 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        for (i = 0; i < CFG.SFXManager.lTitles.get(CFG.SFXManager.stationID).size(); ++i) {
            menuElements.add(new Button_DiplomacyAction(Images.arrow, CFG.SFXManager.lTitles.get(CFG.SFXManager.stationID).get(i).replace(".ogg", "").replace(".mp3", "").replace("_", " "), 1, 0, tY, tempWidth - 2, tempElemH, true){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public int getCurr() {
                    return this.id;
                }

                @Override
                public void setMax(int iMax) {
                    this.id = iMax;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Playlist.this.getElementW() - 2;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.SFXManager.loadNextMusic_Default(CFG.SFXManager.lTitles.get(CFG.SFXManager.stationID).get(Menu_InGame_Playlist.this.getMenuElem(iID).getCurr()));
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(i);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Audio"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.2627451f, 0.30980393f, 0.45490196f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.2627451f, 0.30980393f, 0.45490196f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, Menu_InGame_Stats.getMenuX() - tempWidth - CFG.PADD * 2 - Core.PADDING * 2, Menu_InGame_Stats.getMenuY(), tempWidth, Math.min(CFG.GAMEHEIGHT / 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, false, true);
        this.updateLang();
        for (int i2 = 1; i2 < 5; ++i2) {
            this.getMenuElem(i2).setCurr(this.getMenuElem(i2).getCurr());
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.SFXManager.loadNextMusic();
                return;
            }
            case 1: {
                CFG.SFXManager.setMusicVolume((float)this.getMenuElem(iID).getCurr() / 100.0f);
                CFG.settingsGD.VOLUME_MUSIC = CFG.SFXManager.getMusicVolume();
                CFG.saveSettings();
                return;
            }
            case 2: {
                CFG.SFXManager.loadPreviousMusic();
                return;
            }
            case 3: {
                CFG.SFXManager.setSoundsVolume((float)this.getMenuElem(iID).getCurr() / 100.0f);
                CFG.settingsGD.VOLUME_SOUNDS = CFG.SFXManager.getSoundsVolume();
                CFG.saveSettings();
                return;
            }
            case 4: {
                CFG.SFXManager.setMasterVolume((float)this.getMenuElem(iID).getCurr() / 100.0f);
                CFG.settingsGD.VOLUME_MASTER = CFG.SFXManager.getMasterVolume();
                CFG.saveSettings();
                return;
            }
        }
        super.actionEL(iID);
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getElementW() {
        return this.getW();
    }
}

