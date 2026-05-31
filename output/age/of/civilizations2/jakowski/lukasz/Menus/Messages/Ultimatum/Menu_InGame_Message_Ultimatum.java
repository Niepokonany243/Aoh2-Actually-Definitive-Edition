
package age.of.civilizations2.jakowski.lukasz.Menus.Messages.Ultimatum;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Demands;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_War;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Menu_InGame_Messages;
import age.of.civilizations2.jakowski.lukasz.Messages.Ultimatum.Message_UltimatumRefusedWar;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Message_War;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Message_Ultimatum
extends Menu {
    public static final int ANIMATION_TIME = 200;
    public long lTime = 0L;
    private int iOnCivID = -1;
    private int iMessageID = 0;
    private Ultimatum_GameData oUltimatum;

    public Menu_InGame_Message_Ultimatum() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + (int)((float)CFG.BUTTON_H * 0.7f) + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Ultimatum"), CFG.BUTTON_H * 3 / 5, true, true), CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Message_Ultimatum(final int onCivID, int iMessageID, int iValue, Ultimatum_GameData nUltimatum) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        this.iMessageID = iMessageID;
        this.oUltimatum = nUltimatum;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs2(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), onCivID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Button_Diplomacy_War(onCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (this.oUltimatum.demandAnexation) {
            menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("DemandsAnnexationOfOurTerritory"), onCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (this.oUltimatum.demandVasalization) {
            menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("DemandVassalizationOfUs"), onCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (this.oUltimatum.demandChangeOfGovernment) {
            menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("ChangeTypeOfGovernmentTo") + ": " + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(onCivID).getIdeology()).getName(), onCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (this.oUltimatum.demandMilitaryAccess) {
            menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("DemandMilitaryAccess"), onCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (this.oUltimatum.demandLiberation.size() > 0) {
            for (int i = 0; i < this.oUltimatum.demandLiberation.size(); ++i) {
                menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("DemandLiberationOfVassal") + ": " + CFG.core.getCiv(this.oUltimatum.demandLiberation.get(i)).getCivName(), onCivID, 2, tY, CFG.BUTTON_W * 2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        if (this.oUltimatum.demandProvinces.size() > 0) {
            menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("DemandsOurProvinces"), onCivID, 2, tY, CFG.BUTTON_W * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(onCivID));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DemandsOurProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < ((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.get(i)).getName()));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public void actionElem(int iID) {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    for (int i = 0; i < ((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.size(); ++i) {
                        CFG.core.getProvSelected().addProv(((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.get(i));
                    }
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.setMenuID(View.eINGAME_SHOW_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Button_Diplomacy_Demands(CFG.lang.get("XUnitsAreReadyToAttackIfWeRefuseTheirOffer", iValue), onCivID, 2, tY, CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_Ultimatum.this.getElementW() * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(onCivID));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_InGameAction(CFG.lang.get("Refuse"), -1, CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return (Menu_InGame_Message_Ultimatum.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RefuseProposal"), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("War"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return CFG.PADD * 2 + (Menu_InGame_Message_Ultimatum.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public int getWidthE() {
                return (Menu_InGame_Message_Ultimatum.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploWar).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploWar).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploWar).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploWar).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploWar).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclareWarOn") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Message_Ultimatum.this.iOnCivID, 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(Menu_InGame_Message_Ultimatum.this.iOnCivID).getCivName()));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_WAR2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Accept"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Message_Ultimatum.this.getW() - (Menu_InGame_Message_Ultimatum.this.getW() - CFG.PADD * 4) / 3 - CFG.PADD;
            }

            @Override
            public int getWidthE() {
                return (Menu_InGame_Message_Ultimatum.this.getW() - CFG.PADD * 4) / 3;
            }

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AcceptOffer"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Message_Ultimatum.this.iOnCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WeWillSignATruceUntilX", GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + GameValues.gvUltimatum.ULTIMATUM_TRUCE_TURNS)), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", GameValues.gvUltimatum.ULTIMATUM_TRUCE_TURNS) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                nData.add(new ME_Hover_2Type_Image(Images.diploTruce, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandAnexation) {
                    nData.add(new ME_Hover_2Type_Flag(onCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandsAnnexationOfOurTerritory"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandVasalization) {
                    nData.add(new ME_Hover_2Type_Flag(onCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandVassalizationOfUs"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandMilitaryAccess) {
                    nData.add(new ME_Hover_2Type_Flag(onCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandMilitaryAccess"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandLiberation.size() > 0) {
                    for (i = 0; i < ((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandLiberation.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag(onCivID));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandLiberationOfVassal") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandLiberation.get(i)).getCivName()));
                        nData.add(new ME_Hover_2Type_Flag(((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandLiberation.get(i), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                if (((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.size() > 0) {
                    nData.add(new ME_Hover_2Type_Flag(onCivID));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandsOurProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (i = 0; i < ((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(((Menu_InGame_Message_Ultimatum)Menu_InGame_Message_Ultimatum.this).oUltimatum.demandProvinces.get(i)).getName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.getSend();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Ultimatum"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_MESSAGE_TITLE.r, CFG.COLOR_MESSAGE_TITLE.g, CFG.COLOR_MESSAGE_TITLE.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_MESSAGE_TITLE.r, CFG.COLOR_MESSAGE_TITLE.g, CFG.COLOR_MESSAGE_TITLE.b, 0.375f));
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
                IMGManager.getIMG(Images.diploMessage).drawO(oSB, Menu_InGame_Message_Ultimatum.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Message_Ultimatum.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.diploMessage).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        this.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + 200L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + 4, -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - this.lTime) / 200.0f))));
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
            int tempID2 = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)this.iMessageID).fromCivID;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(this.iMessageID).onAccept(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(this.iMessageID);
            CFG.gameAction.buildRank_Score(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.gameAction.buildRank_Score(tempID2);
            CFG.menus.rebuildInGame_Messages();
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.toastM.addM(CFG.lang.get("Accepted") + "!", CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(3500);
            Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

                @Override
                public void update() {
                    try {
                        CFG.core.buildCivilizationRegions(this.id);
                    }
                    catch (Exception exception) {
                        
                    }
                }
            });
            Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + tempID2, tempID2){

                @Override
                public void update() {
                    try {
                        CFG.core.buildCivilizationRegions(this.id);
                    }
                    catch (Exception exception) {
                        
                    }
                }
            });
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE && Menu_InGame_Messages.VIEW_BEFORE != CFG.mapModesManager.getActiveMapModeID()) {
                CFG.mapModesManager.setActiveMapModeID(Menu_InGame_Messages.VIEW_BEFORE);
            }
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            CFG.core.declareWar(this.iOnCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
            CFG.core.getCiv((int)this.iOnCivID).getCivDiploGD().messageBox.addMessage(new Message_War(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.iOnCivID));
            CFG.core.getCiv((int)this.iOnCivID).getCivDiploGD().messageBox.addMessage(new Message_UltimatumRefusedWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(this.iMessageID);
            CFG.menus.rebuildInGame_Messages();
            CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE && Menu_InGame_Messages.VIEW_BEFORE != CFG.mapModesManager.getActiveMapModeID()) {
                CFG.mapModesManager.setActiveMapModeID(Menu_InGame_Messages.VIEW_BEFORE);
            }
            CFG.toastM.addM(CFG.lang.get("War") + "!", CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 3) {
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(this.iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(this.iMessageID);
            CFG.menus.rebuildInGame_Messages();
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE && Menu_InGame_Messages.VIEW_BEFORE != CFG.mapModesManager.getActiveMapModeID()) {
                CFG.mapModesManager.setActiveMapModeID(Menu_InGame_Messages.VIEW_BEFORE);
            }
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
        this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
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

