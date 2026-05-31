
package age.of.civilizations2.jakowski.lukasz.Menus.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Total;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Stats;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CensusOfProvince
extends Menu {
    public static int PROVINCE_ID = 0;

    public Menu_InGame_CensusOfProvince(int nProvinceID) {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH / 5;
        int tempHeight = CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        PROVINCE_ID = nProvinceID;
        menuElements.add(new Button_Stats_Title(CFG.lang.get("EthnicGroups"), CFG.PADD * 2, 2, 0, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Nationalities"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Population"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, 0, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public int getPosXE() {
                return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_CensusOfProvince.this.getW() - Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemographyOfProvince"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        for (int i2 = 0; i2 < CFG.core.getProv(PROVINCE_ID).getPop().getNatsSize(); ++i2) {
            tempIDs.add(i2);
        }
        while (tempIDs.size() > 0) {
            int tAdd = 0;
            for (i = 1; i < tempIDs.size(); ++i) {
                if (CFG.core.getProv(PROVINCE_ID).getPop().getPopulationID((Integer)tempIDs.get(tAdd)) >= CFG.core.getProv(PROVINCE_ID).getPop().getPopulationID((Integer)tempIDs.get(i))) continue;
                tAdd = i;
            }
            tSorted.add((Integer)tempIDs.get(tAdd));
            tempIDs.remove(tAdd);
        }
        int tPosY = CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        for (i = 0; i < tSorted.size(); ++i) {
            if (CFG.FOG_OF_WAR == 2) {
                if (CFG.getMetCiv(CFG.core.getProv(PROVINCE_ID).getPop().getCivID((Integer)tSorted.get(i)))) {
                    menuElements.add(new Button_Stats_Flag_Clip(CFG.core.getProv(PROVINCE_ID).getPop().getCivID((Integer)tSorted.get(i)), CFG.core.getCiv(CFG.core.getProv(PROVINCE_ID).getPop().getCivID((Integer)tSorted.get(i))).getCivName(), CFG.PADD * 2, 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                } else {
                    menuElements.add(new Button_Stats_Flag_Clip(-1, CFG.lang.get("Undiscovered"), CFG.PADD * 2, 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                }
            } else {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.core.getProv(PROVINCE_ID).getPop().getCivID((Integer)tSorted.get(i)), CFG.core.getCiv(CFG.core.getProv(PROVINCE_ID).getPop().getCivID((Integer)tSorted.get(i))).getCivName(), CFG.PADD * 2, 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }
                });
            }
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getProv(PROVINCE_ID).getPop().getPopulationID((Integer)tSorted.get(i))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_CensusOfProvince.this.getW() - Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
                }
            });
            tPosY += tElemHeight2;
        }
        if (tSorted.size() > 1) {
            menuElements.add(new Button_Stats_Total(CFG.lang.get("Total") + ":", CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_CensusOfProvince.this.getElementW() * 2;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iTextWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getProv(PROVINCE_ID).getPop().getPops()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_CensusOfProvince.this.getW() - Menu_InGame_CensusOfProvince.this.getElementW() * 2 + CFG.PADD * 2 - 2;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return CFG.COLOR_POPULATION;
                }
            });
        }
        this.initMenu(new TitleM(CFG.core.getProv(PROVINCE_ID).getName().length() > 0 ? CFG.core.getProv(PROVINCE_ID).getName() : CFG.lang.get("Demography"), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.1764706f, 0.22352941f, 0.45882353f, 0.225f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.1764706f, 0.22352941f, 0.45882353f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.pop).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * Menu_InGame_CensusOfProvince.this.getImageScale()) + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.pop).getHeight() - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * Menu_InGame_CensusOfProvince.this.getImageScale()) / 2, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * Menu_InGame_CensusOfProvince.this.getImageScale()), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * Menu_InGame_CensusOfProvince.this.getImageScale()));
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, Menu_InGame_Stats.getMenuX() - tempWidth - CFG.PADD * 2 - Core.PADDING * 2, Menu_InGame_Stats.getMenuY(), tempWidth, tempHeight, menuElements, false, true);
        this.updateLang();
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i / 2 % 2);
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() - 1 + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
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
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 3;
    }
}

