
package age.of.civilizations2.jakowski.lukasz.Menus.Decisions.Missions;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction_TextRight;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_SK;
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_FB;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Menus.Diplomacy.Menu_NV;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_MissionsReal
extends Menu {
    public Menu_InGame_MissionsReal() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new Button_InGameAction(CFG.lang.get("Close"), -1, CFG.PADD, tY, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_MissionsReal.this.getW2() - CFG.PADD * 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_MissionsReal.this.setVisibleM(false);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        try {
            menuElements.add(new TextBuildTitle("Classified Missions", -1, 0, tY, tempWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }
            });
            int added = 0;
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Workshop Explorer", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    CFG.GO_TO_LINK = "https://steamcommunity.com/app/3381680/workshop/";
                    CFG.setDialogType(DialogType.GO_TO_LINK);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Check out mods in the Steam Workshop", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Do Nothing.. Win", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    CFG.GO_TO_LINK = "https://lukaszjakowski.pl/nothing/";
                    CFG.setDialogType(DialogType.GO_TO_LINK);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("A true master knows when not to act.", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Who Wants to Rule the World? Quiz", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    Menu_MM.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eMM);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Who Wants to Rule the World? Quiz", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.randomCivilizationFlag, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc("Answer every question correctly and claim ultimate victory, the world awaits its new ruler."));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Win a game of Battleship", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    Menu_NV.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eNV);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Mom, can we have the navy..", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Fix the Bugs!", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    Menu_FB.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eFB);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Fix the Bugs!", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.disease, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Become the longest flag snake!", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    Menu_SK.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eSK);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Flag Snake!", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            menuElements.add(new Button_DiplomacyAction_TextRight(Images.diploMessage, "Touch Grass", 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, tempElemH, true, "", Images.key){

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM("Classified Mission: Touch Grass", CFG.COLOR_POSITIVE);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_MissionsReal.this.getW2();
                }

                @Override
                public void setMin(int iMin) {
                    this.row = iMin % 2 == 1;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("There is a whole world beyond the screen. ", CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big("It even has better graphics.", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big("Maybe I'll try it.."));
                    nData.add(new ME_Hover_2Type_Text_Big(" - Lukasz Jakowski"));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploMessage, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(added++);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall("Easter Egg Missions AoH2:DE", CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.43137255f, 0.27450982f, 0.33333334f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.43137255f, 0.27450982f, 0.33333334f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_MissionsReal.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_MissionsReal.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_MissionsReal.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_MissionsReal.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
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

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    public final int getW2() {
        return this.getWidthM();
    }
}

