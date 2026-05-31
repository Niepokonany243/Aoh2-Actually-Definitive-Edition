
package age.of.civilizations2.jakowski.lukasz.Menus.Messages;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Message.Button_Diplomacy_MessageAlliance;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Message.Button_Diplomacy_MessageAlliance_Center;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Gold;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Menu_InGame_Messages;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Message_TradeRequest
extends Menu {
    public static final int ANIMATION_TIME = 200;
    public long lTime = 0L;
    private int iOnCivID = -1;
    private int iMessageID = 0;

    public Menu_InGame_Message_TradeRequest() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + (int)((float)CFG.BUTTON_H * 0.7f) + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("TradeRequest"), CFG.BUTTON_H * 3 / 5, true, true), CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Message_TradeRequest(int onCivID, int nMessageID, TradeRequest_GameData tradeRequest) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iOnCivID = onCivID;
        this.iMessageID = nMessageID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new Button_Diplomacy_MessageAlliance_Center(CFG.core.getCiv(this.iOnCivID).getCivName(), this.iOnCivID, 2, tY, CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW();
            }
        });
        menuElements.add(new Button_Diplomacy_MessageAlliance_Center(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 2, tY, CFG.BUTTON_W * 2){

            @Override
            public int getPosXE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        if (tradeRequest.listLEFT.iGold > 0) {
            menuElements.add(new Button_Stats_Gold(CFG.lang.get("Gold") + ": ", "" + tradeRequest.listLEFT.iGold, CFG.PADD * 2, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.lProvinces.size() > 0) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("Provinces") + ": " + tradeRequest.listLEFT.lProvinces.size(), tradeRequest.iCivLEFT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listLEFT.lProvinces.size(); ++i) {
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listLEFT.lProvinces.get(i)).getCivId()));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listLEFT.lProvinces.get(i)).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (nElements.size() == 0) {
                            this.menuElemHover = null;
                            return;
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                    catch (NullPointerException ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listLEFT.lProvinces.size(); ++i) {
                        CFG.core.getProvSelected().addProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listLEFT.lProvinces.get(i));
                    }
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.setMenuID(View.eINGAME_SHOW_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.lDeclareWarOnCivID.size() > 0) {
            int targetCivID = tradeRequest.listLEFT.lDeclareWarOnCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("DeclareWar") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.lFormCoalitionAgainst.size() > 0) {
            int targetCivID = tradeRequest.listLEFT.lFormCoalitionAgainst.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("FormACoalitionAgainst") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.lPrepareForWarCivID.size() > 0) {
            int targetCivID = tradeRequest.listLEFT.lPrepareForWarCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("PrepareForWar") + ": " + CFG.core.getCiv(targetCivID).getCivName() + " (" + tradeRequest.listLEFT.iPrepareForWarTurns + ")", targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.lSanctionCivID.size() > 0) {
            int targetCivID = tradeRequest.listLEFT.lSanctionCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("Sanctions") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.defensivePact) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("DefensivePact"), tradeRequest.iCivLEFT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.nonAggressionPact) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("NonAggressionPact"), tradeRequest.iCivLEFT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.proclaimIndependence) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("ProclaimIndependence"), tradeRequest.iCivLEFT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listLEFT.militaryAccess) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("MilitaryAccess"), tradeRequest.iCivLEFT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        tY = ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD;
        if (tradeRequest.listRight.iGold > 0) {
            menuElements.add(new Button_Stats_Gold(CFG.lang.get("Gold") + ": ", "" + tradeRequest.listRight.iGold, CFG.PADD * 2, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.lProvinces.size() > 0) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("Provinces") + ": " + tradeRequest.listRight.lProvinces.size(), tradeRequest.iCivRIGHT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listRight.lProvinces.size(); ++i) {
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listRight.lProvinces.get(i)).getCivId()));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listRight.lProvinces.get(i)).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (nElements.size() == 0) {
                            this.menuElemHover = null;
                            return;
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                    catch (NullPointerException ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listRight.lProvinces.size(); ++i) {
                        CFG.core.getProvSelected().addProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)((Menu_InGame_Message_TradeRequest)Menu_InGame_Message_TradeRequest.this).iMessageID).tradeRequest.listRight.lProvinces.get(i));
                    }
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.setMenuID(View.eINGAME_SHOW_PROVINCES);
                    RenderProvince.updateDrawProvinces();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.lDeclareWarOnCivID.size() > 0) {
            int targetCivID = tradeRequest.listRight.lDeclareWarOnCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("DeclareWar") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.lFormCoalitionAgainst.size() > 0) {
            int targetCivID = tradeRequest.listRight.lFormCoalitionAgainst.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("FormACoalitionAgainst") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.lPrepareForWarCivID.size() > 0) {
            int targetCivID = tradeRequest.listRight.lPrepareForWarCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("PrepareForWar") + ": " + CFG.core.getCiv(targetCivID).getCivName() + " (" + tradeRequest.listRight.iPrepareForWarTurns + ")", targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.lSanctionCivID.size() > 0) {
            int targetCivID = tradeRequest.listRight.lSanctionCivID.get(0);
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("Sanctions") + ": " + CFG.core.getCiv(targetCivID).getCivName(), targetCivID, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.defensivePact) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("DefensivePact"), tradeRequest.iCivRIGHT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.nonAggressionPact) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("NonAggressionPact"), tradeRequest.iCivRIGHT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.proclaimIndependence) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("ProclaimIndependence"), tradeRequest.iCivRIGHT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (tradeRequest.listRight.militaryAccess) {
            menuElements.add(new Button_Diplomacy_MessageAlliance(CFG.lang.get("MilitaryAccess"), tradeRequest.iCivRIGHT, 2, tY, CFG.BUTTON_W * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW() + 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Message_TradeRequest.this.getElementW();
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        for (int i = 0; i < menuElements.size(); ++i) {
            if (((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE() <= tY) continue;
            tY = ((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE();
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Refuse"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RefuseProposal"), CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Accept"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Message_TradeRequest.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptOffer"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.getSend();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("TradeRequest"), CFG.BUTTON_H * 3 / 4, true, true){

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
                IMGManager.getIMG(Images.diploMessage).drawO(oSB, Menu_InGame_Message_TradeRequest.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_Message_TradeRequest.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.diploMessage).getHeight() / 2);
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
            CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(this.iMessageID).onDecline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(this.iMessageID);
            CFG.menus.rebuildInGame_Messages();
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE && Menu_InGame_Messages.VIEW_BEFORE != CFG.mapModesManager.getActiveMapModeID()) {
                CFG.mapModesManager.setActiveMapModeID(Menu_InGame_Messages.VIEW_BEFORE);
            }
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

