
package age.of.civilizations2.jakowski.lukasz.Menus.LeadersM;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_Special;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Middle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Leader_Edit_Data
extends Menu {
    private String sName;
    private String sImage;
    private String sBorn;
    private String sWiki;
    private String sReignB;
    private String sReignE;

    public Menu_Leader_Edit_Data() {
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.25f);
        int tempElemH = CFG.BUTTON_H;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.getLeaderOfCiv().getName(), CFG.PADD * 2, CFG.PADD + 2, tY, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sName + ": " + super.getTextE();
            }
        });
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.getLeaderOfCiv().getImage(), CFG.PADD * 2, CFG.PADD + 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sImage + ": " + super.getTextE();
            }
        });
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.getLeaderOfCiv().getDay() + " " + GameCalendar.getMonthName(CFG.leaderGameData.getLeaderOfCiv().getMonth()) + " " + CFG.gameAges.getYear(CFG.leaderGameData.getLeaderOfCiv().getYear()), CFG.PADD * 2, CFG.PADD + 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sBorn + ": " + super.getTextE();
            }
        });
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.getLeaderOfCiv().getWiki(), CFG.PADD * 2, CFG.PADD + 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sWiki + ": " + super.getTextE();
            }

            @Override
            public Color getColorE(boolean isActive) {
                if (!this.getIsHovered()) {
                    return CFG.COLOR_HOVER_TITLE;
                }
                return super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle(null, -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f), tY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, CFG.PADD + (int)((float)CFG.BUTTON_H * 0.8f) + (tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.8f) * 2), tY, (int)((float)CFG.BUTTON_H * 0.8f), (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.reignYearBegin == -9999 ? "" : "" + CFG.leaderGameData.reignYearBegin, CFG.PADD * 2, CFG.PADD + 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sReignB + ": " + super.getTextE();
            }

            @Override
            public Color getColorE(boolean isActive) {
                if (!this.getIsHovered()) {
                    return CFG.COLOR_HOVER_TITLE;
                }
                return super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_In_Game_Box_Special(CFG.leaderGameData.reignYearEnd == -9999 ? "" : "" + CFG.leaderGameData.reignYearEnd, CFG.PADD * 2, CFG.PADD + 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Leader_Edit_Data.this.sReignE + ": " + super.getTextE();
            }

            @Override
            public Color getColorE(boolean isActive) {
                if (!this.getIsHovered()) {
                    return CFG.COLOR_HOVER_TITLE;
                }
                return super.getColorE(isActive);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_Leader_Edit_Data.this.getPosX() - 2 + iTranslateX, Menu_Leader_Edit_Data.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_Leader_Edit_Data.this.getWidthM() + 2, this.getHeightT(), true, false);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.425f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_Leader_Edit_Data.this.getPosX() + iTranslateX, Menu_Leader_Edit_Data.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_Leader_Edit_Data.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_Leader_Edit_Data.this.getPosX() + iTranslateX, Menu_Leader_Edit_Data.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD, Menu_Leader_Edit_Data.this.getWidthM(), CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_Leader_Edit_Data.this.getPosX() + iTranslateX, Menu_Leader_Edit_Data.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_Leader_Edit_Data.this.getWidthM());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_Leader_Edit_Data.this.getPosX() + iTranslateX, Menu_Leader_Edit_Data.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_Leader_Edit_Data.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H / 4, tempW, Math.min(((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H / 4) - CFG.BUTTON_H / 2 - CFG.PADD * 3), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("Name");
        this.sImage = CFG.lang.get("ImageName");
        this.sBorn = CFG.lang.get("Born");
        this.sWiki = CFG.lang.get("Description");
        this.sReignB = CFG.lang.get("StartYear");
        this.sReignE = CFG.lang.get("EndYear");
        this.getTitleM().setText(CFG.lang.get("Leader"));
        this.getMenuElem(2).setTextE(GameCalendar.currDay + " " + GameCalendar.getMonthName(GameCalendar.currMonth) + " " + CFG.gameAges.getYear(GameCalendar.currYear));
        this.getMenuElem(5).setTextE(CFG.lang.get("PopulationGrowthModifier") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_PopGrowth > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_PopGrowth * 100.0f) + "%");
        this.getMenuElem(8).setTextE(CFG.lang.get("EconomyGrowthModifier") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_EconomyGrowth > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_EconomyGrowth * 100.0f) + "%");
        this.getMenuElem(11).setTextE(CFG.lang.get("IncomeTaxation") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeTaxation > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeTaxation * 100.0f) + "%");
        this.getMenuElem(14).setTextE(CFG.lang.get("IncomeProduction") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeProduction > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeProduction * 100.0f) + "%");
        this.getMenuElem(17).setTextE(CFG.lang.get("Administration") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_Administration > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_Administration * 100.0f) + "%");
        this.getMenuElem(20).setTextE(CFG.lang.get("Research") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_Research > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_Research * 100.0f) + "%");
        this.getMenuElem(23).setTextE(CFG.lang.get("MilitaryUpkeep") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_MilitaryUpkeep > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_MilitaryUpkeep * 100.0f) + "%");
        this.getMenuElem(26).setTextE(CFG.lang.get("AttackBonus") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_AttackBonus > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_AttackBonus * 100.0f) + "%");
        this.getMenuElem(29).setTextE(CFG.lang.get("DefenseBonus") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_DefenseBonus > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_DefenseBonus * 100.0f) + "%");
        this.getMenuElem(32).setTextE(CFG.lang.get("MovementPoints") + ": " + (CFG.leaderGameData.getLeaderOfCiv().fModifier_MovementPoints > 0.0f ? "+" : "") + (int)(CFG.leaderGameData.getLeaderOfCiv().fModifier_MovementPoints * 100.0f) + "%");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2, this.getHeightM(), true, true);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.showKeyboard();
                return;
            }
            case 1: {
                CFG.showKeyboard();
                return;
            }
            case 2: {
                CFG.menus.saveLeader_Edit_Data();
                CFG.backToMenu = View.eGAME_LEADERS_EDIT;
                CFG.menus.setMenuID(View.eSCENARIO_AGE);
                CFG.menus.updateSelecetScenarioAge_Slider();
                return;
            }
            case 3: {
                CFG.showKeyboard();
                return;
            }
            case 4: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_PopGrowth -= 0.01f;
                this.updateLang();
                return;
            }
            case 5: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 6: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_PopGrowth += 0.01f;
                this.updateLang();
                return;
            }
            case 7: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_EconomyGrowth -= 0.01f;
                this.updateLang();
                return;
            }
            case 8: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 9: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_EconomyGrowth += 0.01f;
                this.updateLang();
                return;
            }
            case 10: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeTaxation -= 0.01f;
                this.updateLang();
                return;
            }
            case 11: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 12: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeTaxation += 0.01f;
                this.updateLang();
                return;
            }
            case 13: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeProduction -= 0.01f;
                this.updateLang();
                return;
            }
            case 14: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 15: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_IncomeProduction += 0.01f;
                this.updateLang();
                return;
            }
            case 16: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_Administration -= 0.01f;
                this.updateLang();
                return;
            }
            case 17: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 18: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_Administration += 0.01f;
                this.updateLang();
                return;
            }
            case 19: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_Research -= 0.01f;
                this.updateLang();
                return;
            }
            case 20: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 21: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_Research += 0.01f;
                this.updateLang();
                return;
            }
            case 22: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_MilitaryUpkeep -= 0.01f;
                this.updateLang();
                return;
            }
            case 23: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 24: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_MilitaryUpkeep += 0.01f;
                this.updateLang();
                return;
            }
            case 25: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_AttackBonus -= 0.01f;
                this.updateLang();
                return;
            }
            case 26: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 27: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_AttackBonus += 0.01f;
                this.updateLang();
                return;
            }
            case 28: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_DefenseBonus -= 0.01f;
                this.updateLang();
                return;
            }
            case 29: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 30: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_DefenseBonus += 0.01f;
                this.updateLang();
                return;
            }
            case 31: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_MovementPoints -= 0.01f;
                this.updateLang();
                return;
            }
            case 32: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                return;
            }
            case 33: {
                CFG.leaderGameData.getLeaderOfCiv().fModifier_MovementPoints += 0.01f;
                this.updateLang();
                return;
            }
            case 34: {
                CFG.showKeyboard();
                return;
            }
            case 35: {
                CFG.showKeyboard();
                return;
            }
        }
    }
}

