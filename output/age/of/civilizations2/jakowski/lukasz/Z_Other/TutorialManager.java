/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Gift.Message_Gift;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.TutorialBox;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Tutorial_ActionType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class TutorialManager {
    public boolean IN_TUTORIAL = false;
    public int STEP_ID = 0;
    public int INNER_STEP = 0;
    public TutStep tutStep;
    private List<ME_Hover> textBox = new ArrayList<ME_Hover>();
    private int iDrawPosX = 0;
    private int iDrawPosY = 0;
    private List<List<TutorialBox>> tutBoxes = new ArrayList<List<TutorialBox>>();
    public static final Color COLOR_TITLE = new Color(0.9137255f, 0.9137255f, 0.9137255f, 1.0f);
    public static final Color COLOR_TEXT = new Color(0.78431374f, 0.8235294f, 0.78431374f, 1.0f);

    public TutorialManager() {
        this.updateDrawTutorial(false);
    }

    public final void startTutorial() {
        this.STEP_ID = 0;
        this.updateDrawTutorial(true);
    }

    public final void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
        this.tutStep.draw(oSB, iTranslateX, iTranslateY);
    }

    public final void updateDrawTutorial(boolean enable) {
        this.IN_TUTORIAL = enable;
        this.INNER_STEP = 0;
        if (enable) {
            if (this.STEP_ID == 0) {
                int i;
                this.iDrawPosX = CFG.PADD * 2;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WelcomeToTheTutorial"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("t0"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t1"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t2"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.15f));
                            IMGManager.getIMG(Images.patternReversed).draw2O(oSB, 0, 0 - IMGManager.getIMG(Images.patternReversed).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
                            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, 0 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.CIV_INFO_MENU_WIDTH / 4, CFG.GAMEHEIGHT);
                            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0 + CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH / 4, 0 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.CIV_INFO_MENU_WIDTH / 4, CFG.GAMEHEIGHT, true, false);
                            IMGManager.getIMG(Images.gradient).drawO(oSB, 0, 0 - IMGManager.getIMG(Images.gradient).getHeight(), CFG.GAMEWIDTH, CFG.CIV_INFO_MENU_WIDTH / 4);
                            IMGManager.getIMG(Images.gradient).drawO(oSB, 0, 0 + CFG.GAMEHEIGHT - CFG.CIV_INFO_MENU_WIDTH / 4 - IMGManager.getIMG(Images.gradient).getHeight(), CFG.GAMEWIDTH, CFG.CIV_INFO_MENU_WIDTH / 4, false, true);
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, (CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX) + AoCGame.LEFT, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 1) {
                this.iDrawPosX = CFG.PADD * 2;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OpenCivilizationView"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationTreasury"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NumberOfMovementPointsInThisTurn"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("cw1"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("5. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheDiplomacyView"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("6. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MoreMapViews"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("7. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CurrentDateAndTurnOfTheGame"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("8. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("cw0"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HoverAnElementToGetMoreInformations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Age of History 2: Definitive Edition"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(7).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(2).getPosY() + CFG.menus.getInGameMenu().getMenuElem(2).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(3).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(3).getPosY() + CFG.menus.getInGameMenu().getMenuElem(3).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("5")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("6")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(9).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(9).getPosY() + CFG.menus.getInGameMenu().getMenuElem(9).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("7")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(5).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(5).getPosY() + CFG.menus.getInGameMenu().getMenuElem(5).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("8")){

                    @Override
                    public void draw(SpriteBatch oSB) {
                        if (CFG.menus.getMenu_InGame_CurrentWars().getVisibleM()) {
                            super.draw(oSB);
                        }
                    }

                    @Override
                    public int getPosX() {
                        return CFG.menus.getMenu_InGame_CurrentWars().getPosX();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getMenu_InGame_CurrentWars().getPosY() + CFG.menus.getMenu_InGame_CurrentWars().getHeightM() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, (CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX) + AoCGame.LEFT, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(2).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(2).getPosY() + CFG.menus.getInGameMenu().getMenuElem(2).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(2).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(3).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(3).getPosY() + CFG.menus.getInGameMenu().getMenuElem(3).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(3).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(5).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(5).getPosY() + CFG.menus.getInGameMenu().getMenuElem(5).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(5).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(7).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(7).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(8).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(9).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(9).getPosY() + CFG.menus.getInGameMenu().getMenuElem(9).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(9).getWidthE());
                                if (CFG.menus.getMenu_InGame_CurrentWars().getVisibleM()) {
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getMenu_InGame_CurrentWars().getPosX(), CFG.PADD / 2 + CFG.menus.getMenu_InGame_CurrentWars().getPosY() + CFG.menus.getMenu_InGame_CurrentWars().getHeightM(), CFG.menus.getMenu_InGame_CurrentWars().getWidthM());
                                }
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            int fromCiv = 0;
                            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                                if (i == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCivsAtWar(i, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                                fromCiv = i;
                                break;
                            }
                            CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.civDiploGD.messageBox.addMessage(new Message_Gift(fromCiv, 1500));
                            CFG.menus.rebuildInGame_Messages();
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 2) {
                int i;
                this.iDrawPosX = CFG.PADD * 2;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("m0"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploMessage, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CapitalOfYourCivilization"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("t7"));
                for (i = 0; i < tempText.size(); ++i) {
                    if (i == 0) {
                        nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()));
                    }
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t8", "" + GameValues.gvCapital.BONUS_CAPITAL_DEFENSE, "" + GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("s1"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return (int)((float)(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCeX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getShPX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - this.getWidth() / 2;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.core.getDrawProvinceArmy_EndPosY(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID(), CFG.map.getMpS().getCurrSc()) + (CFG.ARMY_HEIGHT + CFG.ARMY_BG_EXTRA_HEIGHT * 2) / 2 + CFG.ARMY_BG_EXTRA_HEIGHT;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public void draw(SpriteBatch oSB) {
                        if (CFG.menus.getInGame_Messages().getVisibleM()) {
                            super.draw(oSB);
                        }
                    }

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Messages().getPosX();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Messages().getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, (CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX) + AoCGame.LEFT, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                if (CFG.menus.getInGame_Messages().getVisibleM()) {
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Messages().getPosX(), -CFG.PADD / 2 + CFG.menus.getInGame_Messages().getPosY(), CFG.menus.getInGame_Messages().getWidthM());
                                }
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 3) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("t6"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t6a"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t3"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t4"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("t5"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 4) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("b0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Minimap"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InformationAboutSelectedProvince"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EndTurnOrContinue"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox("3 - " + CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(0).getPosXE() + CFG.PADD;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY(), CFG.menus.getInGameProvInfo().getWidthM() - CFG.menus.getInGameProvInfo().getMenuElem(0).getWidthE() - CFG.PADD * 2);
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(0).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY(), CFG.menus.getInGameMenu().getMenuElem(0).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 5) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("b1"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenCloseCivilizationInformationsView"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CoreIsALegitimatePartOfCivilization"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("b2"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceValue"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TerrainType"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Terrain(1, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("b3"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(2).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(3).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(8).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(6).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(6).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                if (CFG.core.getActiveProvID() < 0 || CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                }
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 2;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 3;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 8;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 6;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 6) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("u0"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("u0a"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("u0b"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("g0"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("g1"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ha0"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ha1"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(4).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(4).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(9).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(11).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(11).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(5).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(5).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                if (CFG.core.getActiveProvID() < 0 || CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                }
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 4;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 9;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 5;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 11;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 7) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyOfProvince"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevel"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("Tech4"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("Tech5"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceStability"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RevolutionaryRisk"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("5. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Buildings"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("6. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceName"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(7).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(7).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(10).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(13).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(15).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("5")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(14).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(14).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("6")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() || CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                }
                                int tElemID = 7;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 10;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 15;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 13;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 14;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                tElemID = 1;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(-1);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 8) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("a0"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("a1"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("a2"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a2a"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a2b"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("ArmyRecruitmentWillTakeOneTurn"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("a3"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a3a"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("PlunderOccupiedProvince"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a3b"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Conscript") + ": ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a3c"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("a4"));
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(2).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(4).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(4).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox("4. " + CFG.lang.get("chPr")){

                    @Override
                    public int getPosX() {
                        return CFG.PADD;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return (int)((float)(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCeX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getShPX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - this.getWidth() / 2;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.core.getDrawProvinceArmy_EndPosY(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID(), CFG.map.getMpS().getCurrSc()) + (CFG.ARMY_HEIGHT + CFG.ARMY_BG_EXTRA_HEIGHT * 2) / 2 + CFG.ARMY_BG_EXTRA_HEIGHT;
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                if (CFG.core.getActiveProvID() < 0 || !CFG.menus.getVisible_InGame_ProvinceAction()) {
                                    TutorialManager.this.INNER_STEP = 1;
                                } else {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    int tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                    tElemID = 2;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                    tElemID = 4;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                }
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.core.getActiveProvID() < 0 || !CFG.menus.getVisible_InGame_ProvinceAction()) {
                                CFG.toastM.addM(CFG.lang.get("chPr"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                            } else {
                                ++TutorialManager.this.STEP_ID;
                                TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            }
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 9) {
                int i;
                int i2;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("r0"));
                for (i2 = 0; i2 < tempText.size(); ++i2) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i2), COLOR_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("RecruitOccupiedDesc"));
                for (i2 = 0; i2 < tempText.size(); ++i2) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i2), COLOR_TEXT));
                    if (i2 == tempText.size() - 1) {
                        nData.add(new ME_Hover_2Type_Image(Images.patternReversed, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image(Images.patternReversed, 0, 0));
                        nData.add(new ME_Hover_2Type_Image(Images.patternReversed, 0, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("r1"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("r2"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                nData2.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("Cancel"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.iconFalse, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                nData2.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("Accept"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.iconTrue, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("RequiredMovementPoints") + ": " + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT / 10.0f);
                nData2.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    if (i == tempText.size() - 1) {
                        nData2.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    }
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                nData2.add(new ME_Hover_2Type_Space());
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("ArmyRecruitmentWillTakeOneTurn"));
                nData2.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    if (i == tempText.size() - 1) {
                        nData2.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                    }
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("OneUnitCostsXGold", GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT));
                nData2.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    if (i == tempText.size() - 1) {
                        nData2.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    }
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox("2. " + CFG.lang.get("chPr")){

                    @Override
                    public int getPosX() {
                        return CFG.PADD;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return (int)((float)(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCeX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getShPX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - this.getWidth() / 2;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.core.getDrawProvinceArmy_EndPosY(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID(), CFG.map.getMpS().getCurrSc()) + (CFG.ARMY_HEIGHT + CFG.ARMY_BG_EXTRA_HEIGHT * 2) / 2 + CFG.ARMY_BG_EXTRA_HEIGHT;
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                ArrayList<TutorialBox> tempBoxes3 = new ArrayList<TutorialBox>();
                tempBoxes3.add(new TutorialBox("2"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(0).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(0).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("3"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(1).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("1"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(2).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(2).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("4"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ActionInfo_Province().getPosX() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ActionInfo_Province().getPosY() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes3);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                int tElemID;
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isRAIP(CFG.core.getActiveProvID()) >= 0) {
                                    ++TutorialManager.this.STEP_ID;
                                    TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                                    return;
                                }
                                if (CFG.menus.getInGame_ProvinceRecruit().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 2;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getWidthE());
                                    tElemID = 2;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceRecruit().getPosX() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceRecruit().getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceRecruit().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ActionInfo_Province().getPosX() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ActionInfo_Province().getPosY() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getWidthE());
                                } else if (CFG.core.getActiveProvID() < 0 || !CFG.menus.getVisible_InGame_ProvinceAction() || CFG.core.getProv(CFG.core.getActiveProvID()).getTrueOwnerOfProv() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                } else {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                }
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.core.getActiveProvID() < 0 || !CFG.menus.getVisible_InGame_ProvinceAction()) {
                                CFG.toastM.addM(CFG.lang.get("chPr"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 10) {
                int i;
                int i3;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("n0"));
                for (i3 = 0; i3 < tempText.size(); ++i3) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i3), COLOR_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("n0a"));
                for (i3 = 0; i3 < tempText.size(); ++i3) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i3), COLOR_TEXT));
                    if (i3 == tempText.size() - 1) {
                        nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, 0));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("n1"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("n2"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                nData2.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("Cancel"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.iconFalse, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                nData2.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData2.add(new ME_Hover_2Type_Text(CFG.lang.get("Accept"), COLOR_TITLE));
                nData2.add(new ME_Hover_2Type_Image(Images.iconTrue, CFG.PADD, 0));
                nElements2.add(new MEHover_2E(nData2));
                nData2.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("n3a"));
                nData2.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("RequiredMovementPoints"));
                nData2.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    if (i == tempText.size() - 1) {
                        nData2.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    }
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<MEHover_2E> nElements3 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData3 = new ArrayList<ME_Hover_2Type>();
                nData3.add(new ME_Hover_2Type_Text(CFG.lang.get("n3"), COLOR_TITLE));
                nData3.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements3.add(new MEHover_2E(nData3));
                nData3.clear();
                this.textBox.add(new ME_Hover_v2(nElements3));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return (int)((float)(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCeX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getShPX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - this.getWidth() / 2;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.core.getDrawProvinceArmy_EndPosY(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID(), CFG.map.getMpS().getCurrSc()) + (CFG.ARMY_HEIGHT + CFG.ARMY_BG_EXTRA_HEIGHT * 2) / 2 + CFG.ARMY_BG_EXTRA_HEIGHT;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox("2. " + CFG.lang.get("chPr")){

                    @Override
                    public int getPosX() {
                        return CFG.PADD;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return (int)((float)(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCeX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getShPX() + CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc()) - this.getWidth() / 2;
                    }

                    @Override
                    public int getPosY() {
                        return CFG.core.getDrawProvinceArmy_EndPosY(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID(), CFG.map.getMpS().getCurrSc()) + (CFG.ARMY_HEIGHT + CFG.ARMY_BG_EXTRA_HEIGHT * 2) / 2 + CFG.ARMY_BG_EXTRA_HEIGHT;
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                ArrayList<TutorialBox> tempBoxes3 = new ArrayList<TutorialBox>();
                tempBoxes3.add(new TutorialBox("2"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(0).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(0).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("3"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(1).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("1"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(2).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(2).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes3.add(new TutorialBox("4"){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ActionInfo_Province().getPosX() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ActionInfo_Province().getPosY() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes3);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                int tElemID;
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isMovingUnitsFromProvID(CFG.core.getActiveProvID())) {
                                    ++TutorialManager.this.STEP_ID;
                                    TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                                    return;
                                }
                                if (CFG.menus.getInGame_ProvinceMoveUnits().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 2;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getWidthE());
                                    tElemID = 2;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceMoveUnits().getPosX() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_ProvinceMoveUnits().getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_ProvinceMoveUnits().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ActionInfo_Province().getPosX() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ActionInfo_Province().getPosY() + CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ActionInfo_Province().getMenuElem(tElemID).getWidthE());
                                } else if (!(CFG.core.getActiveProvID() >= 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() || CFG.chooseProvinceMode)) {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                } else {
                                    if (CFG.chooseProvinceMode && CFG.chosenProvinceID < 0) {
                                        TutorialManager.this.INNER_STEP = 3;
                                        ((ME_Hover)TutorialManager.this.textBox.get(2)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                        return;
                                    }
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                }
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.core.getActiveProvID() < 0 || !CFG.menus.getVisible_InGame_ProvinceAction()) {
                                CFG.toastM.addM(CFG.lang.get("chPr"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 11) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("a3a2"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(1) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsToSeeTheArmyInNeighboringProvinces"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getTower_DefenseBonus(1) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsYourArmyGoToTheSea"), COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getPort_IncomeProduction(1) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bLibrary, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("+1"), CFG.COLOR_RESEARCH));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchPerTurnForEveryXPeopleInProvince", BuildingsManager.getLibrary_ResearchPerPopulation(1)), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("5. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(1) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("6. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bWorkshop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getWorkshop_IncomeProduction(1) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("7. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ReducesTheCostOfRecruitmentPerUnitByOneGold"), COLOR_TEXT));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("8. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(1)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": ", COLOR_TEXT));
                nData.add(new ME_Hover_2Type_Text("-" + (int)(BuildingsManager.getSupply_Bonus(1) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(2).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() || CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                }
                                int tElemID = 2;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_ProvinceAction().getPosX() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_ProvinceAction().getPosY() + CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_ProvinceAction().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getInGame_Budget().setVisibleM(false);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 12) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("tx0"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Inflation"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("InflationH1"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("InflationH2"));
                nData.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                boolean tElemID = false;
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                                if (CFG.menus.getInGame_Budget().getVisibleM()) {
                                    ++TutorialManager.this.STEP_ID;
                                    TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            CFG.toastM.addM(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 13) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.GAMEHEIGHT;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("in1"));
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("in2"));
                nData2.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("hAdm0"));
                nData2.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("hAdministrationCost"));
                nData2.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("tx"));
                nData2.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("txa"));
                nData2.add(new ME_Hover_2Type_Text(" - ", COLOR_TITLE));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox("1. " + CFG.lang.get("OpenTheViewOfYourCivilizationsBudget")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(1).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(2).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(2).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(2).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(6).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(6).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(11).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(11).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(11).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                if (!CFG.menus.getInGame_Budget().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                } else {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    int tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                    tElemID = 1;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 2;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 6;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 11;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.menus.getInGame_Budget().getVisibleM()) {
                                ++TutorialManager.this.STEP_ID;
                                TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            } else {
                                CFG.toastM.addM(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 14) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.GAMEHEIGHT;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("hGoods"));
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("hGoods2"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("hGoods3", (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f)));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("hGoods4"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox("1. " + CFG.lang.get("OpenTheViewOfYourCivilizationsBudget")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(13).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(13).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                if (!CFG.menus.getInGame_Budget().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                } else {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    int tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                    tElemID = 13;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 14;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.menus.getInGame_Budget().getVisibleM()) {
                                ++TutorialManager.this.STEP_ID;
                                TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            } else {
                                CFG.toastM.addM(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 15) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.GAMEHEIGHT;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("Tech1"));
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("Tech2"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("Tech3"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("Tech4"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox("1. " + CFG.lang.get("OpenTheViewOfYourCivilizationsBudget")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(15).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(15).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                if (!CFG.menus.getInGame_Budget().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                } else {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    int tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                    tElemID = 15;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 16;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.menus.getInGame_Budget().getVisibleM()) {
                                ++TutorialManager.this.STEP_ID;
                                TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            } else {
                                CFG.toastM.addM(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 16) {
                int i;
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.GAMEHEIGHT;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<MEHover_2E> nElements2 = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData2 = new ArrayList<ME_Hover_2Type>();
                List<String> tempText = this.getTextSplited(CFG.lang.get("BuildYourEconomicPowerBySpendingGoldOnInvestments"));
                nData2.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("DevelopmentLevelAndEconomyWillBeIncreased"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("Tech5"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData2.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements2.add(new MEHover_2E(nData2));
                    nData2.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements2));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox("1. " + CFG.lang.get("OpenTheViewOfYourCivilizationsBudget")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                ArrayList<TutorialBox> tempBoxes2 = new ArrayList<TutorialBox>();
                tempBoxes2.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                tempBoxes2.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(17).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(17).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes2);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                if (!CFG.menus.getInGame_Budget().getVisibleM()) {
                                    TutorialManager.this.INNER_STEP = 0;
                                    ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(1).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getPosY() + CFG.menus.getInGameMenu().getMenuElem(1).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(1).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                } else {
                                    TutorialManager.this.INNER_STEP = 1;
                                    ((ME_Hover)TutorialManager.this.textBox.get(1)).drawHoverWithoutAnim(oSB, TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                    int tElemID = 0;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                    tElemID = 17;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    tElemID = 18;
                                    TutorialManager.this.drawLine(oSB, CFG.menus.getInGame_Budget().getPosX() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGame_Budget().getMenuPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getPosY() + CFG.menus.getInGame_Budget().getMenuElem(tElemID).getHeightE(), CFG.menus.getInGame_Budget().getMenuElem(tElemID).getWidthE());
                                    for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                        ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                    }
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            if (CFG.menus.getInGame_Budget().getVisibleM()) {
                                CFG.menus.setVisible_InGame_Budget(false);
                                CFG.menus.setVisible_InGame_CivInfo(false);
                                ++TutorialManager.this.STEP_ID;
                                TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            } else {
                                CFG.toastM.addM(CFG.lang.get("OpenTheViewOfYourCivilizationsBudget"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 17) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("d0"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(8).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                                if (CFG.menus.getVisible_InGame_CivInfo()) {
                                    ++TutorialManager.this.STEP_ID;
                                    TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            CFG.toastM.addM(CFG.lang.get("d0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 18) {
                int i;
                this.iDrawPosX = CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("d0a"), COLOR_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                List<String> tempText = this.getTextSplited(CFG.lang.get("d1"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("d2"));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("d3"));
                nData.add(new ME_Hover_2Type_Text("2. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("d4"));
                nData.add(new ME_Hover_2Type_Text("3. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                tempText.clear();
                tempText = this.getTextSplited(CFG.lang.get("d5"));
                nData.add(new ME_Hover_2Type_Text("4. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                for (i = 0; i < tempText.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(tempText.get(i), COLOR_TEXT));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("1")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE() + CFG.PADD / 2 + CFG.PADD;
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("2")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Civ_Info().getPosX() + CFG.menus.getInGame_Civ_Info().getWidthM() - this.getWidth();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Civ_Info().getPosY();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("3")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Civ_Info_Diplomacy().getPosX() + CFG.menus.getInGame_Civ_Info_Diplomacy().getWidthM() - this.getWidth();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Civ_Info_Diplomacy().getPosY();
                    }
                });
                tempBoxes.add(new TutorialBox(CFG.lang.get("4")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGame_Civ_Info_Actions().getPosX() + CFG.menus.getInGame_Civ_Info_Actions().getWidthM() - this.getWidth();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGame_Civ_Info_Actions().getPosY();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameMenu().getPosX() + CFG.menus.getInGameMenu().getMenuElem(8).getPosXE(), CFG.PADD / 2 + CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getPosY() + CFG.menus.getInGameMenu().getMenuElem(8).getHeightE(), CFG.menus.getInGameMenu().getMenuElem(8).getWidthE());
                                TutorialManager.this.drawLineVertical(oSB, CFG.menus.getInGame_Civ_Info_Diplomacy().getPosX() + CFG.menus.getInGame_Civ_Info_Diplomacy().getWidthM() + CFG.PADD, CFG.menus.getInGame_Civ_Info_Diplomacy().getPosY(), CFG.menus.getInGame_Civ_Info_Diplomacy().getHeightM());
                                TutorialManager.this.drawLineVertical(oSB, CFG.menus.getInGame_Civ_Info().getPosX() + CFG.menus.getInGame_Civ_Info().getWidthM() + CFG.PADD, CFG.menus.getInGame_Civ_Info().getPosY(), CFG.menus.getInGame_Civ_Info().getHeightM());
                                TutorialManager.this.drawLineVertical(oSB, CFG.menus.getInGame_Civ_Info_Actions().getPosX() + CFG.menus.getInGame_Civ_Info_Actions().getWidthM() + CFG.PADD, CFG.menus.getInGame_Civ_Info_Actions().getPosY(), CFG.menus.getInGame_Civ_Info_Actions().getHeightM());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                                if (!CFG.menus.getVisible_InGame_CivInfo()) {
                                    ++TutorialManager.this.STEP_ID;
                                    TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            CFG.toastM.addM(CFG.lang.get("d0a"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            return true;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 19) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("q0"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("1. ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EndTurn"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Next")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView()) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            return false;
                        }
                        return false;
                    }
                };
            } else if (this.STEP_ID == 20) {
                this.iDrawPosX = CFG.PADD * 2 + AoCGame.LEFT;
                this.iDrawPosY = CFG.menus.getInGameMenu().getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getPosY() + CFG.menus.getInGameMenu().getMenuElem(7).getHeightE() + CFG.PADD / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD;
                this.textBox.clear();
                this.tutBoxes.clear();
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EndOfTutorial"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GoodLuck"), COLOR_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.textBox.add(new ME_Hover_v2(nElements));
                ArrayList<TutorialBox> tempBoxes = new ArrayList<TutorialBox>();
                tempBoxes.add(new TutorialBox(CFG.lang.get("Finish")){

                    @Override
                    public int getPosX() {
                        return CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE();
                    }

                    @Override
                    public int getPosY() {
                        return CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(0).getPosY() - CFG.PADD / 2 - CFG.PADD - this.getHeight();
                    }
                });
                this.tutBoxes.add(tempBoxes);
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                        if (CFG.menus.getInGameView() && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            try {
                                ((ME_Hover)TutorialManager.this.textBox.get(0)).drawHoverWithoutAnim(oSB, CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_CivInfo().getVisibleM() ? CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 : TutorialManager.this.iDrawPosX, TutorialManager.this.iDrawPosY);
                                int tElemID = 0;
                                TutorialManager.this.drawLine(oSB, CFG.menus.getInGameProvInfo().getPosX() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosXE(), -CFG.PADD / 2 + CFG.menus.getInGameProvInfo().getPosY() + CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getPosY(), CFG.menus.getInGameProvInfo().getMenuElem(tElemID).getWidthE());
                                for (int i = 0; i < ((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).size(); ++i) {
                                    ((TutorialBox)((List)TutorialManager.this.tutBoxes.get(TutorialManager.this.INNER_STEP)).get(i)).draw(oSB);
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            }
                            catch (NullPointerException nullPointerException) {
                                // empty catch block
                            }
                        }
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        if (actionType == Tutorial_ActionType.NEXT_TURN && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                            ++TutorialManager.this.STEP_ID;
                            TutorialManager.this.updateDrawTutorial(TutorialManager.this.IN_TUTORIAL);
                            CFG.menus.setMenuID(View.eGAMES);
                            TutorialManager.this.IN_TUTORIAL = false;
                            SaveGameManager.gameCanBeContinued = false;
                            return true;
                        }
                        return false;
                    }
                };
            } else {
                this.tutStep = new TutStep(){

                    @Override
                    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                    }

                    @Override
                    public boolean action(Tutorial_ActionType actionType) {
                        return false;
                    }
                };
            }
        } else {
            this.tutStep = new TutStep(){

                @Override
                public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
                }

                @Override
                public boolean action(Tutorial_ActionType actionType) {
                    return false;
                }
            };
        }
    }

    public final void drawLine(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.325f));
        IMGManager.getIMG(Images.line33).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line33).getHeight(), nWidth, 1);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.95f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.685f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + nWidth / 4, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth / 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + nWidth / 4, nPosY + 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth / 2, 1);
        oSB.setColor(Color.WHITE);
    }

    public final void drawLineVertical(SpriteBatch oSB, int nPosX, int nPosY, int nHeight) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.325f));
        IMGManager.getIMG(Images.line32Vertical).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, nHeight);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.95f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, nHeight);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.685f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, nPosX - 1, nPosY + nHeight / 4 - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, nHeight / 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, nPosX + 1, nPosY + nHeight / 4 - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, nHeight / 2);
        oSB.setColor(Color.WHITE);
    }

    public List<String> getTextSplited(String nText) {
        ArrayList<String> out = new ArrayList<String>();
        String[] tempLine = nText.split(" ");
        int currentW = 0;
        int iSize = tempLine.length;
        int last = 0;
        for (int i = 0; i < iSize; ++i) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), tempLine[i] + " ");
            if ((currentW += (int)CFG.glyphLay.width) < CFG.GAMEWIDTH - this.iDrawPosX - CFG.PADD * 8 && (i != iSize - 1 || currentW >= CFG.GAMEWIDTH - this.iDrawPosX - CFG.PADD * 8)) continue;
            String addLine = "";
            for (int j = last; j < (i == iSize - 1 && currentW < CFG.GAMEWIDTH - this.iDrawPosX - CFG.PADD * 8 ? iSize : i); ++j) {
                addLine = addLine + tempLine[j] + " ";
            }
            out.add(addLine);
            last = i;
            if (currentW >= CFG.GAMEWIDTH - this.iDrawPosX - CFG.PADD * 8 && i == iSize - 1) {
                out.add(tempLine[i]);
            }
            currentW = (int)CFG.glyphLay.width;
        }
        return out;
    }

    public static interface TutStep {
        public void draw(SpriteBatch var1, int var2, int var3);

        public boolean action(Tutorial_ActionType var1);
    }
}



