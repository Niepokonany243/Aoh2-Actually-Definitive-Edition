package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_RelocatePop;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Search;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MigrationOrder;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu_InGame_ForceMigration
extends Menu {
    private int selectNatCivID = -1;
    public static String searchText = "";
    private static int searchCivID = -1;
    private static int searchNatCivID = -1;

    public static void rebuildSearchMenu() {
        if (searchCivID > 0 && searchNatCivID >= 0) {
            CFG.menus.rebuildInGameForceMigration(searchCivID, searchNatCivID);
        }
    }

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_ForceMigration(int civID) {
        this(civID, -1);
    }

    public Menu_InGame_ForceMigration(int civID, int selectNatCivID) {
        int i;
        int i2;
        this.selectNatCivID = selectNatCivID;
        if (selectNatCivID < 0) {
            searchText = "";
            Keyboard.forceMigrationSearch = false;
        } else {
            searchCivID = civID;
            searchNatCivID = selectNatCivID;
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;

        if (selectNatCivID >= 0) {
            this.buildTargetSelectionUI(menuElements, civID, selectNatCivID, tY, tempWidth);
            int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
            String titleStr = CFG.lang.get("PopulationTransfer") + " - " + CFG.lang.get("SelectTarget");
            this.initMenu(new TitleM_TextSmall(titleStr, CFG.BUTTON_H * 3 / 4, true, true){
                @Override
                public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                    oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.165f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                    oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.375f));
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
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_ForceMigration.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_ForceMigration.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_ForceMigration.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_ForceMigration.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                    Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
                }
            }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
            this.updateLang();
            Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
            return;
        }

        menuElements.add(new Text_Desc(CFG.lang.get("PopulationTransferDesc"), CFG.PADD, tY, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2() - CFG.PADD * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;

        HashMap<Integer, Long> natioMap = new HashMap<Integer, Long>();
        for (i2 = 0; i2 < CFG.core.getCiv(civID).getNumOfProvs(); ++i2) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i2)).getPop().getNatsSize(); ++j) {
                int otherCivID = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i2)).getPop().getCivID(j);
                if (civID == otherCivID) continue;
                long pop = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i2)).getPop().getPopulationID(j);
                natioMap.put(otherCivID, natioMap.getOrDefault(otherCivID, 0L) + pop);
            }
        }

        menuElements.add(new TextBuildTitle(CFG.lang.get("OngoingMigrations") + ": " + CFG.core.getCiv(civID).getCivName(), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

        java.util.List<MigrationOrder> activeOrders = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD.migrationOrders;
        if (activeOrders.isEmpty()) {
            menuElements.add(new TextScale(CFG.lang.get("None"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ForceMigration.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("None"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            for (i2 = 0; i2 < activeOrders.size(); ++i2) {
                MigrationOrder order = activeOrders.get(i2);
                long pop = natioMap.getOrDefault(order.getNationalityCivID(), 0L);
                int targetCivID = order.getTargetCivID();
                menuElements.add(new Button_RelocatePop(i2, order.getNationalityCivID(), pop, 0, tY, CFG.BUTTON_W * 2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_ForceMigration.this.getElementW2();
                    }

                    @Override
                    public void actionElem(int iID) {
                        for (int a = 0; a < CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.size(); ++a) {
                            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.get(a).getNationalityCivID() != this.getCurr()) continue;
                            CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.remove(a);
                            CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("StopMigration"), CFG.COLOR_HOVER_TITLE);
                            break;
                        }
                    }

                    @Override
                    public void actionElemSPM() {
                        try {
                            CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.clear();
                            CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("StopMigration"), CFG.COLOR_HOVER_TITLE);
                        } catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }

                    @Override
                    public boolean getCheckboxSt() {
                        return true;
                    }

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                        if (targetCivID > 0) {
                            String targetName = CFG.core.getCiv(targetCivID).getCivName();
                            Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, "-> " + targetName, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, CFG.COLOR_HOVER_TITLE);
                        }
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }

        menuElements.add(new TextBuildTitle(CFG.lang.get("AvailableNationalities") + ": " + CFG.core.getCiv(civID).getCivName(), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

        ArrayList<Map.Entry> list = new ArrayList<Map.Entry>();
        if (!natioMap.isEmpty()) {
            for (Map.Entry entry : natioMap.entrySet()) {
                list.add(entry);
            }
            for (i = 0; i < list.size() - 1; ++i) {
                int maxIndex = i;
                for (int j = i + 1; j < list.size(); ++j) {
                    if ((Long)((Map.Entry)list.get(j)).getValue() <= (Long)((Map.Entry)list.get(maxIndex)).getValue()) continue;
                    maxIndex = j;
                }
                Map.Entry temp = (Map.Entry)list.get(i);
                list.set(i, (Map.Entry)list.get(maxIndex));
                list.set(maxIndex, temp);
            }
        }

        if (!list.isEmpty()) {
            for (i = 0; i < list.size(); ++i) {
                Map.Entry entry = (Map.Entry)list.get(i);
                int natCivId = (Integer)entry.getKey();
                boolean isActive = false;
                for (MigrationOrder ord : activeOrders) {
                    if (ord.getNationalityCivID() == natCivId) {
                        isActive = true;
                        break;
                    }
                }
                if (isActive) continue;
                long population = (Long)entry.getValue();
                menuElements.add(new Button_RelocatePop(i, natCivId, population, 0, tY, CFG.BUTTON_W * 2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_ForceMigration.this.getElementW2();
                    }

                    @Override
                    public void actionElem(int iID) {
                        try {
                            int natCivId = this.getCurr();
                            CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), natCivId);
                        } catch (Exception exception) {
                            // empty catch block
                        }
                    }

                    @Override
                    public void actionElemSPM() {
                        try {
                            for (Object entryObj : natioMap.entrySet()) {
                                Map.Entry<Integer, Long> entry = (Map.Entry<Integer, Long>) entryObj;
                                int natCivId = entry.getKey();
                                boolean alreadyActive = false;
                                for (MigrationOrder ord : activeOrders) {
                                    if (ord.getNationalityCivID() == natCivId) {
                                        alreadyActive = true;
                                        break;
                                    }
                                }
                                if (alreadyActive) continue;
                                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.add(new MigrationOrder(natCivId, -1));
                            }
                            CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("PopulationTransferStatus"), CFG.COLOR_HOVER_TITLE);
                        } catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }

                    @Override
                    public boolean getCheckboxSt() {
                        return false;
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextScale(CFG.lang.get("None"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ForceMigration.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("None"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("PopulationTransfer"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_ForceMigration.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_ForceMigration.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_ForceMigration.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_ForceMigration.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    private void buildTargetSelectionUI(ArrayList<MenuElemUI> menuElements, int civID, int natCivID, int tY, int tempWidth) {
        menuElements.add(new Text_Desc(CFG.lang.get("PopulationTransferChooseNationality"), CFG.PADD, tY, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2() - CFG.PADD * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;

        menuElements.add(new TextBuildTitle(CFG.lang.get("SelectTarget") + ": " + CFG.core.getCiv(natCivID).getCivName(), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

        menuElements.add(new Button_Classic_Classic_Search(searchText, CFG.PADD * 3, CFG.PADD, tY + CFG.PADD, tempWidth - CFG.PADD * 2, CFG.BUTTON_H, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2() - CFG.PADD * 2;
            }

            @Override
            public String getTextToDrawElem() {
                return CFG.lang.get("Search") + ": " + super.getTextToDrawElem();
            }

            @Override
            public void actionElem(int iID) {
                Keyboard.forceMigrationSearch = true;
                CFG.showKeyboard(iID);
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.42f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, this.getIsHovered() || isActive ? 0.28f : 0.16f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
                oSB.setColor(Color.WHITE);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;

        ArrayList<Integer> knownCivs = new ArrayList<Integer>();
        for (int c = 1; c < CFG.core.getCivsSize(); ++c) {
            if (c == civID || CFG.core.getCiv(c).getNumOfProvs() <= 0 || CFG.core.getCiv(c).getCivId() == natCivID) continue;
            knownCivs.add(c);
        }
        knownCivs.sort((a, b) -> CFG.core.getCiv(a).getCivName().compareTo(CFG.core.getCiv(b).getCivName()));

        menuElements.add(new Button_RelocatePop(-1, -1, 0, 0, tY, CFG.BUTTON_W * 2){
            private String label = CFG.lang.get("NoTarget") + " (" + CFG.lang.get("SendHome") + ")";

            @Override
            public int getWidthE() {
                return Menu_InGame_ForceMigration.this.getElementW2();
            }

            @Override
            public void actionElem(int iID) {
                CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.add(new MigrationOrder(natCivID, -1));
                CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.toastM.addM(CFG.lang.get("PopulationTransferStatus"), CFG.COLOR_HOVER_TITLE);
            }

            @Override
            public boolean getCheckboxSt() {
                return false;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.label, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();

        String search = searchText == null ? "" : searchText.trim().toLowerCase();
        int addedTargets = 0;
        for (int c = 0; c < knownCivs.size(); ++c) {
            int targetCivID = knownCivs.get(c);
            if (search.length() > 0 && !CFG.core.getCiv(targetCivID).getCivName().toLowerCase().contains(search)) continue;
            ++addedTargets;
            menuElements.add(new Button_RelocatePop(c, targetCivID, 0, 0, tY, CFG.BUTTON_W * 2){
                private String label = CFG.core.getCiv(targetCivID).getCivName();

                @Override
                public int getWidthE() {
                    return Menu_InGame_ForceMigration.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.migrationOrders.add(new MigrationOrder(natCivID, targetCivID));
                    long totalPop = 0L;
                    for (int p = 0; p < CFG.core.getCiv(civID).getNumOfProvs(); ++p) {
                        totalPop += CFG.core.getProv(CFG.core.getCiv(civID).getProvID(p)).getPop().getPopulationOfCivID(natCivID);
                    }
                    if (totalPop > 0L) {
                        CFG.core.getCiv(targetCivID).setRelationD(civID, CFG.core.getCiv(targetCivID).getRelationD(civID) + (float)(int)GameValues.gvPopRelocate.MIGRATE_DEPORT_TARGET_RELATIONS_CHANGE);
                        CFG.core.getCiv(civID).setRelationD(targetCivID, CFG.core.getCiv(civID).getRelationD(targetCivID) + (float)(int)GameValues.gvPopRelocate.MIGRATE_DEPORT_TARGET_RELATIONS_CHANGE);
                    }
                    CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.toastM.addM(CFG.lang.get("PopulationTransferStatus"), CFG.COLOR_HOVER_TITLE);
                }

                @Override
                public boolean getCheckboxSt() {
                    return false;
                }

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    int relation = (int)CFG.core.getCiv(civID).getRelationD(targetCivID);
                    String relationText = (relation > 0 ? "+" : "") + relation;
                    CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), relationText);
                    int relationW = (int)CFG.glyphLay.width;
                    Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, targetCivID);
                    Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.label, this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
                    Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, relationText, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - relationW + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.getRelationColor(relation, 1.0f));
                }

                @Override
                public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, this.row ? 0.16f : 0.08f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
                    oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, isActive || this.getIsHovered() ? 0.30f : 0.12f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 3);
                    oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
                    oSB.setColor(Color.WHITE);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (addedTargets == 0) {
            menuElements.add(new TextScale(CFG.lang.get("None"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_ForceMigration.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("None"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
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

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }
}
