
package age.of.civilizations2.jakowski.lukasz.Menus.AdmPolicy;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_AdministrationPolicy;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRight;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_AdministrationPolicy
extends Menu {
    public Menu_InGame_AdministrationPolicy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Pop_TextRight(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 1.0f), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.policyID]), "", Images.gov, CFG.COLOR_POPULATION, 0, tY, tempWidth, "" + CFG.getNumberWthSpaces("" + CFG.ideologiesMgr.getChangeAdministrationPolicyCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), Images.topGold()){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.ideologiesMgr.getHover_AdministrationPolicy(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.policyID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public Color getColorRight() {
                return CFG.COLOR_GOLD;
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_AdministrationPolicy.this.getWidthM();
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("Administration"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_AdministrationPolicy.this.getWidthM();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        try {
            for (int i = 0; i < GameValues.gvAdministrationPolicy.POLICY_NAME.length; ++i) {
                menuElements.add(new Button_Diplomacy_AdministrationPolicy(i, 0, tY, CFG.BUTTON_W * 2, true){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_AdministrationPolicy.this.getW();
                    }

                    @Override
                    public void actionElem(int iID) {
                        for (int i = 0; i < Menu_InGame_AdministrationPolicy.this.getMenuElemsSize(); ++i) {
                            Menu_InGame_AdministrationPolicy.this.getMenuElem(i).setCheckboxSt(false);
                        }
                        Menu_InGame_AdministrationPolicy.this.getMenuElem(iID).setCheckboxSt(!Menu_InGame_AdministrationPolicy.this.getMenuElem(iID).getCheckboxSt());
                        ArrayList<String> tMess = new ArrayList<String>();
                        ArrayList<Color> tColor = new ArrayList<Color>();
                        tMess.add(this.getTextE());
                        tColor.add(CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.addM(tMess, tColor);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_AdministrationPolicy.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_AdministrationPolicy.this.setVisibleM(false);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_AdministrationPolicy.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_AdministrationPolicy.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChangeAdministrationPolicy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.gov, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int toPolicyID = -1;
                for (int i = 2; i < Menu_InGame_AdministrationPolicy.this.getMenuElemsSize() - 2; ++i) {
                    if (!Menu_InGame_AdministrationPolicy.this.getMenuElem(i).getCheckboxSt()) continue;
                    toPolicyID = Menu_InGame_AdministrationPolicy.this.getMenuElem(i).getCurr();
                    break;
                }
                if (toPolicyID >= 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[toPolicyID])));
                    nData.add(new ME_Hover_2Type_Image(Images.gov, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                int tCost = CFG.ideologiesMgr.getChangeAdministrationPolicyCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + tCost), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)tCost ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                int toPolicyID = -1;
                for (int i = 2; i < Menu_InGame_AdministrationPolicy.this.getMenuElemsSize() - 2; ++i) {
                    if (!Menu_InGame_AdministrationPolicy.this.getMenuElem(i).getCheckboxSt()) continue;
                    toPolicyID = Menu_InGame_AdministrationPolicy.this.getMenuElem(i).getCurr();
                    break;
                }
                if (toPolicyID >= 0 && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.policyID != toPolicyID) {
                    if (GameManager.changeAdministrationPolicy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), toPolicyID)) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.mapModesManager.disableAllViews();
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[toPolicyID]), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                        Menu_InGame_AdministrationPolicy.this.setVisibleM(false);
                    } else {
                        ArrayList<String> tMess = new ArrayList<String>();
                        ArrayList<Color> tColor = new ArrayList<Color>();
                        tMess.add(CFG.lang.get("ChooseNewAdministrationPolicy"));
                        tColor.add(CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.addM(tMess, tColor);
                    }
                } else {
                    ArrayList<String> tMess = new ArrayList<String>();
                    ArrayList<Color> tColor = new ArrayList<Color>();
                    tMess.add(CFG.lang.get("ChooseNewAdministrationPolicy"));
                    tColor.add(CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.addM(tMess, tColor);
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)CFG.ideologiesMgr.getChangeAdministrationPolicyCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_BUILD;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("AdministrationPolicy"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.15686275f, 0.29411766f, 0.47058824f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.15686275f, 0.29411766f, 0.47058824f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_AdministrationPolicy.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_AdministrationPolicy.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_AdministrationPolicy.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_AdministrationPolicy.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
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

    public final int getW() {
        return this.getWidthM();
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

