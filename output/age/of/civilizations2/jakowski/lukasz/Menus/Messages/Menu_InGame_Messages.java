
package age.of.civilizations2.jakowski.lukasz.Menus.Messages;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Message;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Messages
extends Menu {
    public static int VIEW_BEFORE = -1;
    public static long ANIMATION_TIME = 0L;
    public static long ANIMATION_TIMER = 225L;
    public static boolean START_ANIMATION = false;
    public static boolean IN_ANIMATION = false;
    public float ANIMATION_GROWTH = 1.125f;
    public float ANIMATION_GROWTH_LIMIT = 2.5f;

    public Menu_InGame_Messages() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = 0;
        int tX = 0;
        for (i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize(); ++i) {
            if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).messageType != MessageType.PEACE_TREATY_LIST_OF_DEMANDS || CFG.core.getPeaceTreaty_GameDataID(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).TAG) >= 0) continue;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(i);
        }
        for (i = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1; i >= 0; --i) {
            menuElements.add(new Button_Message(tX, tY, i, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).fromCivID, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(i).getImageID(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(i).getBGImageID()));
            tX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD;
        }
        this.initMenu(null, IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.topFlagBGPaddingButtons + CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD, CFG.GAMEWIDTH - (IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.topFlagBGPaddingButtons + CFG.PADD), (int)((float)CFG.BUTTON_H * 0.7f) + 1, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (START_ANIMATION) {
            ANIMATION_TIME = System.currentTimeMillis() - ANIMATION_TIMER * 2L / 5L;
            IN_ANIMATION = true;
            START_ANIMATION = false;
        }
        if (IN_ANIMATION) {
            if (ANIMATION_TIME + ANIMATION_TIMER >= System.currentTimeMillis()) {
                iTranslateY += -this.getHeightM() + (int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - ANIMATION_TIME) / (float)ANIMATION_TIMER));
            } else {
                IN_ANIMATION = false;
            }
        }
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawMenuElements(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        for (int i = 0; i < this.iMenuElemsSize; ++i) {
            if (!((MenuElemUI)this.menuElem.get(i)).getVisibleE() || !((MenuElemUI)this.menuElem.get(i)).getIsInView()) continue;
            long elementAnimationTime = (long)((double)ANIMATION_TIMER * Math.min((double)this.ANIMATION_GROWTH_LIMIT, Math.pow(this.ANIMATION_GROWTH, i)));
            long elapsed = System.currentTimeMillis() - ANIMATION_TIME;
            int translateY = 0;
            if (elapsed < elementAnimationTime) {
                float progress = (float)elapsed / (float)elementAnimationTime;
                translateY = -this.getHeightM() + (int)((float)this.getHeightM() * progress);
            }
            try {
                ((MenuElemUI)this.menuElem.get(i)).drawE(oSB, this.getMenuPosX() + iTranslateX, this.getMenuPosY() + translateY, this.getMenuElementIsActive(sliderMenuIsActive, i), this.scrollableY);
                continue;
            }
            catch (Exception exception) {
                
            }
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            MessageType tempMessageType = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).messageType;
            if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && tempMessageType != MessageType.HIGH_INFLATION && tempMessageType != MessageType.RECEIVING_FOREIGN_INVEST && tempMessageType != MessageType.RECEIVING_FOREIGN_INVEST_BUILD) {
                try {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getNumOfProvs() > 0) {
                        if (CFG.FOG_OF_WAR == 2) {
                            if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getCapitalProvID()).getCivId() == CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID) {
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setMetProv(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getCapitalProvID(), true);
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setMetCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID, true);
                                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getCapitalProvID());
                            } else {
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setMetProv(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getProvID(0), true);
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setMetCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID, true);
                                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getProvID(0));
                            }
                        } else if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getCapitalProvID()).getCivId() == CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID) {
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getCapitalProvID());
                        } else {
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID).getProvID(0));
                        }
                        VIEW_BEFORE = CFG.mapModesManager.getActiveMapModeID();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_DIPLOMACY_MODE) {
                            CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE);
                        }
                    }
                }
                catch (Exception exception) {
                    
                }
            }
            if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && tempMessageType != MessageType.HIGH_INFLATION) {
                try {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID)).fromCivID) {
                        CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        CFG.updateActiveCivilizationInfoInGame();
                        CFG.core.disableDrawCivilizationRegions_Active();
                        if (CFG.FOG_OF_WAR == 2) {
                            CFG.core.enableDrawCivilizationRegions_FogOfWar(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
                        } else {
                            CFG.core.enableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
                        }
                    }
                }
                catch (Exception exception) {
                    
                }
            }
            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID).onAction(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize() - 1 - iID);
        }
    }
}

