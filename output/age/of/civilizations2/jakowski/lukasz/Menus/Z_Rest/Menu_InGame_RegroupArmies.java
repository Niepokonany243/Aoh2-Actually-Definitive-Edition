
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.AI.AI;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_RegroupArmies
extends Menu {
    public static int iProvinceID = -1;

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_RegroupArmies(int nProvinceID) {
        ArrayList<MenuElemUI> menuElem = new ArrayList<MenuElemUI>();
        iProvinceID = nProvinceID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        int iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        AI.fFBRA(iCivID);
        menuElem.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(iCivID).getR() / 255.0f, (float)CFG.core.getCiv(iCivID).getG() / 255.0f, (float)CFG.core.getCiv(iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(iCivID).getCivName(), iCivID, CFG.lang.get("Army") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(iCivID).getNumberOfUnits()), Images.diploArmy, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempWidth){

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (this.sDeathsTEXT.length() > 0) {
                        nData.add(new ME_Hover_2Type_Text(this.sDeathsTEXT));
                        nData.add(new ME_Hover_2Type_Text(this.sDeaths, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception e) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RegroupArmies.this.getElementW2();
            }
        });
        menuElem.add(new Text_Desc(CFG.lang.get("RegroupText"), CFG.PADD, tY += ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RegroupArmies.this.getElementW2() - CFG.PADD * 2;
            }
        });
        tY += ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getHeightE();
        menuElem.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_RegroupArmies.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElem.add(new Button_InGameAction(CFG.lang.get("RegroupArmies"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_RegroupArmies.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RegroupArmies.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RegroupArmies") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(iProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploArmy).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploArmy).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploArmy).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploArmy).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_PLUNDER;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("RegroupArmies") + (CFG.core.getProv(nProvinceID).getName().length() > 0 ? ": " + CFG.core.getProv(nProvinceID).getName() : ""), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - CFG.CIV_FLAG_HEIGHT / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getPosY() + ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getPosY() + ((MenuElemUI)menuElem.get(menuElem.size() - 1)).getHeightE() + CFG.PADD, menuElem, true, true);
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
            RegroupArmy nRegroup;
            int i;
            try {
                CFG.core.resetChooseProvinceData();
                CFG.core.resetRegroupArmy_Data();
            }
            catch (Exception exception) {
                
            }
            Civilization civ = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            try {
                for (i = civ.armiesPosition.size() - 1; i >= 0; --i) {
                    try {
                        long armyToMove;
                        if (civ.armiesPosition.get(i) == iProvinceID || (armyToMove = CFG.core.getProv(civ.armiesPosition.get(i)).getArmyCivID1(civ.getCivId())) <= 0) continue;
                        nRegroup = new RegroupArmy(civ.getCivId(), civ.armiesPosition.get(i), iProvinceID);
                        if (nRegroup.getRouteSize() == 1) {
                            CFG.gameAction.moveArmyAction(civ.armiesPosition.get(i), iProvinceID, CFG.core.getProv(civ.armiesPosition.get(i)).getArmyCivID1(civ.getCivId()), civ.getCivId(), true, true);
                            continue;
                        }
                        if (nRegroup.getRouteSize() <= 0 || !CFG.gameAction.moveArmyAction(civ.armiesPosition.get(i), nRegroup.getRoute(0), CFG.core.getProv(civ.armiesPosition.get(i)).getArmyCivID1(civ.getCivId()), civ.getCivId(), true, true)) continue;
                        nRegroup.setFromProvinceID(nRegroup.getRoute(0));
                        nRegroup.removeRoute(0);
                        nRegroup.setNumOfUnits(armyToMove);
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).addRegroupArmy(nRegroup);
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                for (i = civ.armyInAnotherProv.size() - 1; i >= 0; --i) {
                    try {
                        long armyToMove;
                        if (civ.armyInAnotherProv.get(i) == iProvinceID || (armyToMove = CFG.core.getProv(civ.armyInAnotherProv.get(i)).getArmyCivID1(civ.getCivId())) <= 0) continue;
                        nRegroup = new RegroupArmy(civ.getCivId(), civ.armyInAnotherProv.get(i), iProvinceID);
                        if (nRegroup.getRouteSize() == 1) {
                            CFG.gameAction.moveArmyAction(civ.armyInAnotherProv.get(i), iProvinceID, CFG.core.getProv(civ.armyInAnotherProv.get(i)).getArmyCivID1(civ.getCivId()), civ.getCivId(), true, true);
                            continue;
                        }
                        if (!CFG.gameAction.moveArmyAction(civ.armyInAnotherProv.get(i), nRegroup.getRoute(0), CFG.core.getProv(civ.armyInAnotherProv.get(i)).getArmyCivID1(civ.getCivId()), civ.getCivId(), true, true)) continue;
                        nRegroup.setFromProvinceID(nRegroup.getRoute(0));
                        nRegroup.removeRoute(0);
                        nRegroup.setNumOfUnits(armyToMove);
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).addRegroupArmy(nRegroup);
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            CFG.toastM.addM(this.getTitleM().getText(), CFG.COLOR_POSITIVE);
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

