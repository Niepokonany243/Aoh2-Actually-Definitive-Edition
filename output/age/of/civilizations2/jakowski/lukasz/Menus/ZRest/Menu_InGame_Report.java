
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Report_Armies;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Report_Armies_Right;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Report_ProvinceLosses;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Report_Units;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Battle;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_Report;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Report
extends Menu {
    private long lTime = 0L;

    public Menu_InGame_Report() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)((float)CFG.BUTTON_W * 6.5f);
        int tempHeight = CFG.BUTTON_H * 4 + CFG.BUTTON_H * 3 / 4;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        CFG.reportData.checkReport();
        int tY = 0;
        menuElements.add(new Button_Report_Units(2, tY, tempWidth - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Report.this.getW() - 4;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        try {
            menuElements.add(new ButtonN_Battle(CFG.lang.get("Battle") + ": " + CFG.core.getProv(Math.max(0, CFG.reportData.iBattleOfProvinceID)).getProvName(), CFG.reportData.lAttackers_IDs.get(0), CFG.reportData.lDefenders_IDs.get(0), 2, tY, CFG.BUTTON_W * 2, 0, CFG.reportData.getAttackersArmy(), CFG.reportData.getDefendersArmy(), CFG.reportData.getAttackersArmy_Lost(), CFG.reportData.getDefendersArmy_Lost()){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Report.this.getW() - 4;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BattleReports();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        catch (Exception exception) {
            
        }
        menuElements.add(new Button_Report_ProvinceLosses(CFG.PADD * 2, tY, tempWidth - CFG.PADD * 4, CFG.reportData.iPopulationLosses, CFG.reportData.iEconomyLosses){

            @Override
            public int getWidthE() {
                return Menu_InGame_Report.this.getW() - CFG.PADD * 4;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tH = 0;
        for (i = 0; i < CFG.reportData.lAttackers_IDs.size(); ++i) {
            menuElements.add(new Button_Report_Armies(CFG.PADD * 2, tY + CFG.PADD + tH, (tempWidth - CFG.PADD * 6) / 2, CFG.reportData.lAttackers_IDs.get(i), CFG.reportData.lAttackers_Armies.get(i), CFG.reportData.lAttackers_Armies_Lost.get(i)){

                @Override
                public int getWidthE() {
                    return (Menu_InGame_Report.this.getW() - CFG.PADD * 6) / 2;
                }
            });
            tH += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        tH = 0;
        for (i = 0; i < CFG.reportData.lDefenders_IDs.size(); ++i) {
            menuElements.add(new Button_Report_Armies_Right(tempWidth - CFG.PADD * 2 - (tempWidth - CFG.PADD * 6) / 2, tY + CFG.PADD + tH, (tempWidth - CFG.PADD * 6) / 2, CFG.reportData.lDefenders_IDs.get(i), CFG.reportData.lDefenders_Armies.get(i), CFG.reportData.lDefenders_ArmiesLost.get(i)){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Report.this.getW() - CFG.PADD * 2 - (Menu_InGame_Report.this.getW() - CFG.PADD * 6) / 2;
                }

                @Override
                public int getWidthE() {
                    return (Menu_InGame_Report.this.getW() - CFG.PADD * 6) / 2;
                }
            });
            tH += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        int tempMaxH = 0;
        for (int i2 = 0; i2 < menuElements.size(); ++i2) {
            if (((MenuElemUI)menuElements.get(i2)).getPosY() + ((MenuElemUI)menuElements.get(i2)).getHeightE() <= tempMaxH) continue;
            tempMaxH = ((MenuElemUI)menuElements.get(i2)).getPosY() + ((MenuElemUI)menuElements.get(i2)).getHeightE();
        }
        menuElements.add(new Button_In_Game_Box_Report(CFG.reportData.attackersWon ? CFG.reportData.lAttackers_IDs.get(0) : CFG.reportData.lDefenders_IDs.get(0), CFG.lang.get("IsVictorious", CFG.core.getCiv(CFG.reportData.attackersWon ? CFG.reportData.lAttackers_IDs.get(0) : CFG.reportData.lDefenders_IDs.get(0)).getCivName()) + "!", -1, CFG.PADD, tempMaxH + CFG.PADD * 2, tempWidth - CFG.PADD * 2, CFG.BUTTON_H * 3 / 4, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_INFO_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_INFO_HOVER : new Color(0.4509804f, 0.45882353f, 0.4745098f, 1.0f));
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.getIsHovered() ? 0.75f : 0.5f));
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.battle, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Report.this.getW() - CFG.PADD * 2;
            }
        });
        if (tempHeight > ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) {
            tempHeight = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM_TextSmall(CFG.core.getProv(CFG.reportData.iBattleOfProvinceID).getName().length() > 0 ? this.getRandomBattleName(CFG.core.getProv(CFG.reportData.iBattleOfProvinceID).getName()) : CFG.lang.get("Battle"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT() + Core.PADDING, true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (this.getHeightT() - 2) * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, (this.getHeightT() - 2) * 2 / 3, false, true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (int)((float)this.getHeightT() / 2.5f) - IMGManager.getIMG(Images.gradient).getHeight() + 2, nWidth - 4, (int)((float)this.getHeightT() / 2.5f) - 2, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, IMGManager.getIMG(Images.pix255).getHeight());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, 1);
                oSB.setColor(Color.WHITE);
                try {
                    IMGManager.getIMG(Images.battle).drawO(oSB, nPosX + nWidth / 2 - this.getTextWidth() / 2 - CFG.PADD - IMGManager.getIMG(Images.battle).getWidth() + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.battle).getHeight() / 2);
                }
                catch (Exception exception) {
                    
                }
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, (CFG.GAMEWIDTH - tempWidth) / 2, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempWidth, tempHeight, menuElements, false, true);
    }

    public final String getRandomBattleName(String sBattleOf) {
        int nR = CFG.oR.nextInt(1000);
        switch (nR % 4) {
            case 1: {
                return CFG.lang.get("ScrambleFor", sBattleOf);
            }
            case 2: {
                return CFG.lang.get("InvasionOf", sBattleOf);
            }
            case 3: {
                return CFG.lang.get("AttackOn", sBattleOf);
            }
        }
        return CFG.lang.get("BattleOf", sBattleOf);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + Core.PADDING * 2, -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
        }
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
        if (iID == this.getMenuElemsSize() - 1) {
            this.setVisibleM(false);
        } else {
            super.actionEL(iID);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }

    public final int getW() {
        return this.getWidthM();
    }
}

