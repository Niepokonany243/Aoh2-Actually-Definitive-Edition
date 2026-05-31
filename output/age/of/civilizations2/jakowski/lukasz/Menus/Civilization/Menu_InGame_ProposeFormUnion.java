
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion.ButtonN_FlagIcon_3;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion.ButtonN_Opinion;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_ProposeFormUnion
extends Menu {
    public static int toCivID = -1;
    public static int civID2 = -1;

    public Menu_InGame_ProposeFormUnion(int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        toCivID = onCivID;
        if (civID2 == toCivID) {
            civID2 = -1;
        }
        if (civID2 == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            civID2 = -1;
        }
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        if (civID2 > 0 && toCivID > 0) {
            menuElements.add(new ButtonN_Opinion(civID2, toCivID, Images.diploUnion, 0, GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        } else {
            menuElements.add(new ButtonN_Opinion(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), toCivID, Images.diploUnion, 0, GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilizations"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
            }
        });
        menuElements.add(new ButtonN_FlagIcon_3(toCivID, Images.diploMessage, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (civID2 <= 0) {
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            menuElements.add(new ButtonN_FlagIcon_3(civID2, Images.diploMessage, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Text_Desc(CFG.lang.get("ProposeUnionBetweenCivilizationsDesc"), 2, tY, tempWidth - 4){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
            }
        });
        menuElements.add(new Text_Desc(CFG.lang.get("FormUnionDesc"), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 4){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("SendProposal"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ProposeFormUnion.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProposeUnionBetweenCivilizations"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploUnion, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (civID2 >= 0) {
                    nData.add(new ME_Hover_2Type_Flag_Big(toCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(toCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text_Big(" - "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(civID2).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(civID2, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploUnion).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploUnion).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploUnion).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploUnion).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploUnion).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS;
            }

            @Override
            public int getSFXElem() {
                return SFXManager.getSend();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("ProposeUnionBetweenCivilizations"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(toCivID).getG() / 255.0f, (float)CFG.core.getCiv(toCivID).getR() / 255.0f, (float)CFG.core.getCiv(toCivID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(toCivID).getG() / 255.0f, (float)CFG.core.getCiv(toCivID).getR() / 255.0f, (float)CFG.core.getCiv(toCivID).getB() / 255.0f, 0.375f));
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
                int imgID = Images.diploUnion;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_ProposeFormUnion.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
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
        try {
            if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != civID2 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != toCivID && toCivID != civID2) {
                civID2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                CFG.menus.rebuildInGame_ProposeFormUnion(toCivID);
            }
        }
        catch (Exception exception) {
            
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
            if (civID2 <= 0) {
                CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_POSITIVE);
                CFG.toastM.setTimeInView(3500);
            } else {
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setDiploPoints(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() - GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS);
                GameManager.sendUnionProposalFree(civID2, toCivID);
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("ProposeUnionBetweenCivilizations"), GameCalendar.getCurrDate(), Images.infoDiplomacy, toCivID, civID2);
                CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
                CFG.toastM.setTimeInView(3500);
                this.setVisibleM(false);
            }
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
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

