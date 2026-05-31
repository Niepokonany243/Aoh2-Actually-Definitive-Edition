
package age.of.civilizations2.jakowski.lukasz.Menus.War.Declare;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_War;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction_War;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_CallAlly;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_CallAlly_Right;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextAlliesNotInWar;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_DeclareWar
extends Menu {
    private int iOnCivID = -1;
    public int alliesBeginID = 0;
    public int alliesEndID = 0;

    public Menu_InGame_DeclareWar() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 4 / 5;
        this.initMenu(new TitleM(CFG.lang.get("DeclareWar"), CFG.BUTTON_H * 4 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_DeclareWar(int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), onCivID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_DeclareWar.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Button_Diplomacy_War(onCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_DeclareWar.this.getElementW() * 2;
            }
        });
        menuElements.add(new Text_Desc(GameManager.getWarMessage(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - 4){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_DeclareWar.this.getElementW() * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()) {
            menuElements.add(new Text_Desc(CFG.lang.get("VassalLordWarDesc") + " " + CFG.lang.get("Wars") + ": " + CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.WARS_DECLARED_AS_VASSAL_AND_LORD_JOINED_WAR + " / " + GameValues.gvAiWar.AI_LORD_MAX_WARS_JOINED_WHEN_PLAYER_IS_VASSAL, 2, tY += CFG.PADD, tempWidth - 4){

                @Override
                protected Color getColor(boolean isActive) {
                    return this.getIsHovered() || isActive ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEGATIVE_2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_DeclareWar.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).haveLoansFromCiv(onCivID)) {
            menuElements.add(new Text_Desc(CFG.lang.get("LoanRequestWarDesc"), 2, tY += CFG.PADD, tempWidth - 4){

                @Override
                protected Color getColor(boolean isActive) {
                    return this.getIsHovered() || isActive ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEGATIVE_2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_DeclareWar.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        ArrayList<Integer> lAlliesAggressor = new ArrayList<Integer>();
        ArrayList<Integer> lAlliesDefender = new ArrayList<Integer>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == this.iOnCivID || i == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            if (CFG.core.getCiv(i).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == i) {
                lAlliesAggressor.add(i);
                continue;
            }
            if (CFG.core.getCiv(i).getPuppetOfCiv() == this.iOnCivID) {
                lAlliesDefender.add(i);
                continue;
            }
            if (i == CFG.core.getCiv(this.iOnCivID).getPuppetOfCiv()) {
                lAlliesDefender.add(i);
                continue;
            }
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() == CFG.core.getCiv(i).getAlliance()) {
                lAlliesAggressor.add(i);
                continue;
            }
            if (CFG.core.getCiv(this.iOnCivID).getAlliance() > 0 && CFG.core.getCiv(this.iOnCivID).getAlliance() == CFG.core.getCiv(i).getAlliance()) {
                lAlliesDefender.add(i);
                continue;
            }
            if (CFG.core.getDefensivePact(this.iOnCivID, i) > 0) {
                lAlliesDefender.add(i);
                continue;
            }
            if (CFG.core.getGuarantee(i, this.iOnCivID) <= 0) continue;
            lAlliesDefender.add(i);
        }
        if (!lAlliesDefender.isEmpty() || !lAlliesAggressor.isEmpty()) {
            int i;
            menuElements.add(new TextAlliesNotInWar(CFG.lang.get("Allies"), -1, CFG.PADD, tY += CFG.PADD, tempWidth - CFG.PADD * 2, (int)Math.max((float)CFG.BUTTON_H * 0.8f, (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3))){

                @Override
                public int getPosXE() {
                    return 0;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_DeclareWar.this.getW() + 4;
                }

                @Override
                public void actionElem(int iID) {
                    try {
                        for (int i = Menu_InGame_DeclareWar.this.alliesBeginID; i < Menu_InGame_DeclareWar.this.alliesEndID; ++i) {
                            Menu_InGame_DeclareWar.this.getMenuElem(i).setCheckboxSt(!Menu_InGame_DeclareWar.this.getMenuElem(i).getCheckboxSt());
                        }
                    }
                    catch (Exception exception) {
                        
                    }
                }
            });
            int titleElemID = menuElements.size() - 1;
            int tempAdded = 0;
            int tempYAllies = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            this.alliesBeginID = menuElements.size() - 1;
            this.alliesEndID = menuElements.size() - 1;
            for (i = 0; i < lAlliesAggressor.size(); ++i) {
                menuElements.add(new Button_Stats_CallAlly_Right((int)((Integer)lAlliesAggressor.get(i)), 0, tY, CFG.BUTTON_W * 2, false, false){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_DeclareWar.this.getElementW();
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_DeclareWar.this.getElementW();
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclareWarOn") + ":", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName()));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tempAdded++ % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                this.alliesEndID = menuElements.size();
            }
            if (this.alliesBeginID != this.alliesEndID) {
                ((MenuElemUI)menuElements.get(titleElemID)).setTextE(CFG.lang.get("CallAllies") + ": " + CFG.lang.get("All"));
            }
            tempAdded = 0;
            tY = tempYAllies;
            for (i = 0; i < lAlliesDefender.size(); ++i) {
                menuElements.add(new Button_Stats_CallAlly((int)((Integer)lAlliesDefender.get(i)), 0, tY, CFG.BUTTON_W * 2, false, true){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_DeclareWar.this.getElementW();
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tempAdded++ % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i = 0; i < menuElements.size(); ++i) {
                if (((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE() <= tY) continue;
                tY = ((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE();
            }
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_DeclareWar.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction_War(CFG.lang.get("DeclareWar"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_DeclareWar.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_DeclareWar.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclareWar") + ":", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_DeclareWar.this.iOnCivID, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(Menu_InGame_DeclareWar.this.iOnCivID).getCivName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                        if (i == Menu_InGame_DeclareWar.this.iOnCivID || i == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getDefensivePact(i, Menu_InGame_DeclareWar.this.iOnCivID) <= 0) continue;
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefensivePact") + ":"));
                        nData.add(new ME_Hover_2Type_Flag(i, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(i).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploDefensivePact, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) + ".", CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public boolean getIsClickable() {
                return GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS;
            }

            @Override
            public int getSFXElem() {
                return this.getIsClickable() ? SFXManager.SFX_WAR2 : super.getSFXElem();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("DeclareWar"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.375f));
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
                int imgID = Images.diploWar;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_DeclareWar.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
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
            int playerID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            int targetID = this.iOnCivID;
            if (targetID <= 0) targetID = CFG.getActiveCivID_Any();
            if (targetID <= 0) targetID = CFG.getActiveCivInfoId();
            if (targetID <= 0) targetID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();

            if (targetID > 0 && playerID > 0 && playerID != targetID) {
                CFG.customDeclareWar(playerID, targetID);
                for (int i = 2; i < this.getMenuElemsSize() - 2; ++i) {
                    if (!this.getMenuElem(i).getCheckboxSt() || !this.getMenuElem(i).getIsClickable()) continue;
                    int allyID = this.getMenuElem(i).getCurr();
                    if (allyID > 0) {
                        if (CFG.core.getCiv(allyID).getPuppetOfCiv() == playerID || 
                            playerID == CFG.core.getCiv(allyID).getPuppetOfCiv() || 
                            (CFG.core.getCiv(playerID).getAlliance() > 0 && CFG.core.getCiv(playerID).getAlliance() == CFG.core.getCiv(allyID).getAlliance())) {
                            GameManager.sendCallToArms(allyID, playerID, targetID);
                        } else {
                            CFG.customDeclareWar(playerID, allyID);
                        }
                    }
                }
            } else {
                CFG.toastM.addM("           WAR ERROR: Target not found!           ", CFG.COLOR_NEGATIVE_2);
            }
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
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

