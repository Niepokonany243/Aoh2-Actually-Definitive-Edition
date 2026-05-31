
package age.of.civilizations2.jakowski.lukasz.Menus.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
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
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_BuildingsConstructed
extends Menu {
    public static int iSort = 1;

    public Menu_InGame_BuildingsConstructed(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH;
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 5 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4 - CFG.PADD * 2;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 2;
        }
        this.initMenu(null, Menu_InGame_Stats.getMenuX() - tempWidth - CFG.PADD * 2 - Core.PADDING * 2, Menu_InGame_Stats.getMenuY(), tempWidth, CFG.GAMEHEIGHT * 3 / 5, menuElements, false, false);
    }

    public Menu_InGame_BuildingsConstructed() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosY = CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 2;
        }
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Civilizations"), CFG.PADD * 2, 2, 0, CFG.BUTTON_W * 2, tElemHeight){

            @Override
            public int getWidthE() {
                return Menu_InGame_BuildingsConstructed.this.getElementW() * 2 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("ConstructedBuildings"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_BuildingsConstructed.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_BuildingsConstructed.this.getW() - Menu_InGame_BuildingsConstructed.this.getElementW() * 2 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 1 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void setTextE(String sText) {
                try {
                    super.setTextE(sText);
                    int tWMax = 0;
                    while (this.iTextWidth > this.getWidthE() - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
                        super.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + "..");
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConstructedBuildings"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        if (iSort == 0) {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                tSorted.add(CFG.core.getSortedCivsAZ(i - 1));
            }
        } else if (iSort == 1) {
            ArrayList<Integer> tempIDS = new ArrayList<Integer>();
            ArrayList<Integer> tempScore = new ArrayList<Integer>();
            for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                tempIDS.add(CFG.core.getSortedCivsAZ(i2 - 1));
                tempScore.add(CFG.core.getCiv((int)CFG.core.getSortedCivsAZ((int)(i2 - 1))).civGD.numOfBuildingsConstructed);
            }
            int tAddID = 0;
            while (tempIDS.size() > 0) {
                tAddID = 0;
                for (int i3 = 1; i3 < tempIDS.size(); ++i3) {
                    if ((Integer)tempScore.get(tAddID) >= (Integer)tempScore.get(i3)) continue;
                    tAddID = i3;
                }
                tSorted.add((Integer)tempIDS.get(tAddID));
                tempIDS.remove(tAddID);
                tempScore.remove(tAddID);
            }
        }
        int iSize = tSorted.size();
        for (i = 0; i < iSize; ++i) {
            if (CFG.FOG_OF_WAR == 2) {
                if (CFG.getMetCiv((Integer)tSorted.get(i))) {
                    menuElements.add(new Button_Stats_Flag_Clip((int)((Integer)tSorted.get(i)), "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName(), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_BuildingsConstructed.this.getElementW() * 2;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                } else {
                    menuElements.add(new Button_Stats_Flag_Clip(-1, "" + (i + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_BuildingsConstructed.this.getElementW() * 2;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                }
            } else {
                menuElements.add(new Button_Stats_Flag_Clip((int)((Integer)tSorted.get(i)), "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName(), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_BuildingsConstructed.this.getElementW() * 2;
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }
                });
            }
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)((Integer)tSorted.get((int)i)).intValue()).civGD.numOfBuildingsConstructed), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_BuildingsConstructed.this.getElementW() * 2 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_BuildingsConstructed.this.getW() - Menu_InGame_BuildingsConstructed.this.getElementW() * 2;
                }
            });
            tPosY += tElemHeight2;
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight(), nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.14901961f, 0.50980395f, 0.36078432f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.14901961f, 0.50980395f, 0.36078432f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.425f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.325f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        for (int i4 = 0; i4 < this.getMenuElemsSize(); ++i4) {
            this.getMenuElem(i4).setCurr(i4 / 2 % 2);
        }
    }

    @Override
    public void updateLang() {
        try {
            this.getTitleM().setText(CFG.lang.get("ConstructedBuildings"));
        }
        catch (NullPointerException nullPointerException) {
            
        }
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
        switch (iID) {
            case 0: {
                if (iSort != iID) {
                    iSort = iID;
                    CFG.menus.rebuildInGame_BuildingsConstructed();
                }
                return;
            }
            case 1: {
                if (iSort != iID) {
                    iSort = iID;
                    CFG.menus.rebuildInGame_BuildingsConstructed();
                }
                return;
            }
        }
        if (iID % 2 == 0) {
            if (this.getMenuElem(iID).getCurr() > 0) {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.getMenuElem(iID).getCurr()).getCapitalProvID());
            } else {
                CFG.toastM.addM(CFG.lang.get("UndiscoveredCivilization"), CFG.COLOR_HOVER_TITLE);
            }
        }
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 3;
    }
}

