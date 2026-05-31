/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Loan;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_TakeLoan_Interest;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Loans;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Date;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_RequestLoan
extends Menu {
    private int iOnCivID = -1;
    public int iFromCivID = 0;

    public Menu_InGame_RequestLoan(int fromCivID, int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iFromCivID = fromCivID;
        this.iOnCivID = onCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), fromCivID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Text_Desc(CFG.lang.get("RequestLoanDesc"), 2, tY += CFG.PADD, tempWidth - 4){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() * 2;
            }
        });
        menuElements.add(new Button_Diplomacy_TakeLoan_Interest(CFG.lang.get("Interest") + ": ", "" + (float)GameValues.gvLoan.COST_REQUEST_LOAN / 10.0f, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W * 2){

            @Override
            public int getLoanIMG() {
                return Images.loanRe;
            }

            @Override
            public Color getCostColor() {
                return CFG.COLOR_DIPLOMACY_POINTS;
            }

            @Override
            public int getCostIMG() {
                return Images.topDiplomacyPoints;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Interest") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) + "% ", CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Text("[", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("+ " + (int)((float)Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr() * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) / 100.0f), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Gold"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, GameValues.gvLoan.LOAN_MAX_DURATION, Loans.takeLoan_MaxValue(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), Loans.takeLoan_MaxValue(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0.65f){

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() * 2 - CFG.PADD * 4;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GOLD.r, CFG.COLOR_GOLD.g, CFG.COLOR_GOLD.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_RequestLoan.this.getMenuElem(2).setCurr((int)(Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) * 100.0f));
                Menu_InGame_RequestLoan.this.getMenuElem(2).setMin((int)((float)Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr() * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) / 100.0f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Slider_InGame_Date(CFG.lang.get("Duration"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, Math.max(CFG.BUTTON_H * 4 / 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4), GameValues.gvLoan.REQUEST_LOAN_MIN_DURATION, GameValues.gvLoan.REQUEST_LOAN_MAX_DURATION, GameValues.gvLoan.REQUEST_LOAN_MAX_DURATION, 0.65f){

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() * 2 - CFG.PADD * 4;
            }

            @Override
            public String getDrawText() {
                return CFG.lang.get("TurnsX", this.getCurr());
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_RequestLoan.this.getMenuElem(2).setCurr((int)(Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) * 100.0f));
                Menu_InGame_RequestLoan.this.getMenuElem(2).setMin((int)((float)Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr() * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) / 100.0f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_RequestLoan.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RequestLoan.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() < GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS) {
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_RequestLoan.this.iOnCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RequestLoan"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.loanRe, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_RequestLoan.this.iFromCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RequestLoanDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    float relation = CFG.core.getCiv(Menu_InGame_RequestLoan.this.iFromCivID).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumRelations") + ": ", relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : new Color(1.0f, 1.0f, 1.0f, 1.0f)));
                    nData.add(new ME_Hover_2Type_Text((GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION > 0 ? "+" : "") + GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION, relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.diploRelations, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_RequestLoan.this.iFromCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Treasury") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr()), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Interest") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) + "% ", CFG.COLOR_NEUTRAL2));
                    nData.add(new ME_Hover_2Type_Text("[", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("+ " + (int)((float)Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr() * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_RequestLoan.this.getMenuElem(3).getCurr(), Menu_InGame_RequestLoan.this.getMenuElem(4).getCurr()) / 100.0f), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvLoan.COST_REQUEST_LOAN / 10.0f, CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_RequestLoan.this.iOnCivID));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("YouCantHaveMoreThanXLoans", GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS), CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.loanRe).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.loanRe).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.loanRe).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.loanRe).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.loanRe).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvLoan.COST_REQUEST_LOAN && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() < GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS && CFG.core.getCiv(Menu_InGame_RequestLoan.this.iFromCivID).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) >= (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION;
            }

            @Override
            public int getSFXElem() {
                return this.getIsClickable() ? SFXManager.SFX_GOLD : super.getSFXElem();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("RequestLoan"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.75686276f, 0.29411766f, 0.25490198f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.75686276f, 0.29411766f, 0.25490198f, 0.375f));
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
                int imgID = Images.loanRe;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_RequestLoan.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        for (int i = 1; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(this.getMenuElem(i).getCurr());
        }
        this.getMenuElem(2).setCurr((int)(Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getMenuElem(3).getCurr(), this.getMenuElem(4).getCurr()) * 100.0f));
        this.getMenuElem(2).setMin((int)((float)this.getMenuElem(3).getCurr() * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getMenuElem(3).getCurr(), this.getMenuElem(4).getCurr()) / 100.0f));
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGameOfferAlliance.lTime + (long)Menu_InGame_Message_Alliance.ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2 - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + 4 + Core.PADDING * 2, -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - Menu_InGameOfferAlliance.lTime) / (float)Menu_InGame_Message_Alliance.ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            oSB.setColor(Color.WHITE);
            CFG.setRenderO(true);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
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
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() >= GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS) {
                ArrayList<String> lMess = new ArrayList<String>();
                ArrayList<Color> lColors = new ArrayList<Color>();
                lMess.add(CFG.lang.get("Loans") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() + " / " + GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS);
                lColors.add(CFG.COLOR_NEGATIVE_2);
                CFG.toastM.addM(lMess, lColors);
                CFG.toastM.setTimeInView(4500);
                this.setVisibleM(false);
                return;
            }
            GameManager.sendLoanRequest(this.iFromCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getMenuElem(3).getCurr(), this.getMenuElem(4).getCurr());
            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("LoanRequestSent"), this.iFromCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Images.infoDiplomacy);
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}

