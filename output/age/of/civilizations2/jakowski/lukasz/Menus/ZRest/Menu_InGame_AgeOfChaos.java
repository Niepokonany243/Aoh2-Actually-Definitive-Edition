
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonFlagBig_Chaos;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_AgeOfChaos
extends Menu {
    public Menu_InGame_AgeOfChaos() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonW = (int)((float)CFG.GAMEWIDTH / (float)CFG.AGE_OF_CHAOS_CIVS_LIST.size());
        int buttonH = ButtonFlagBig_Chaos.getButtonH();
        menuElements.add(new Text(CFG.lang.get("AgeOfChaos") + ": " + CFG.lang.get("SelectCivilization"), -1, 0, CFG.GAMEHEIGHT / 2 - buttonH / 2 - CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.BUTTON_H, CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        int nX = 0;
        for (int i = 0; i < CFG.AGE_OF_CHAOS_CIVS_LIST.size(); ++i) {
            menuElements.add(new ButtonFlagBig_Chaos(CFG.AGE_OF_CHAOS_CIVS_LIST.get(i), nX, CFG.GAMEHEIGHT / 2 - buttonH / 2, buttonW, buttonH, true, true){

                @Override
                public void actionElem(int iID) {
                    CFG.core.getPlayer(0).setCivId(this.civID);
                    CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
                    try {
                        int i;
                        if (CFG.FOG_OF_WAR == 2) {
                            CFG.gameAction.buildFogOfWar(0);
                            CFG.core.getPlayer(0).buildMetProvsAndCivs();
                            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                                CFG.core.getProv(i).updateProvinceBorder();
                            }
                            Render.updateDrawCivRegionNames_FogOfWar();
                        } else {
                            CFG.gameAction.buildFogOfWar(0);
                        }
                        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                            CFG.core.getProv(i).updateDrawArmyInProv();
                        }
                        CFG.map.getMpB().disposeMinimapOfCivilizations();
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        CFG.gameAction.loadActivePlayerData();
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.civID).getCapitalProvID());
                }

                @Override
                public void actionElemPPM() {
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.civID).getCapitalProvID());
                }
            });
            nX += buttonW;
        }
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setWidthE(CFG.GAMEWIDTH - ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE());
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }
}

