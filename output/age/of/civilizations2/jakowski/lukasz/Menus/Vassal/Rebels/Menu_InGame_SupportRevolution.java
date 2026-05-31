
package age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Rebels;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ChangeGov.Button_Diplomacy_ChangeGovernment2;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion.ButtonN_Opinion;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_SupportRevolution
extends Menu {
    public static int iOnCivID = -1;
    public static int selectedIdeologyID = -1;
    private int firstIdeologyElem = -1;
    private int ideologyElems = 0;
    private int sliderElem = -1;

    public Menu_InGame_SupportRevolution(int onCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        iOnCivID = onCivID;
        selectedIdeologyID = -1;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), onCivID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_SupportRevolution.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new ButtonN_Opinion(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), onCivID, Images.diploRevolution, 0, GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_SupportRevolution.this.getElementW() * 2;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        List<Integer> ideologies = GameManager.supportRevolution_Ideologies(onCivID);
        if (ideologies.size() > 0) {
            menuElements.add(new TextBuildTitle("Select Government", -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }

                @Override
                public int getPosXE() {
                    return 0;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_SupportRevolution.this.getW() + 4;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            this.firstIdeologyElem = menuElements.size();
            for (int i = 0; i < ideologies.size(); ++i) {
                final int ideologyID = ideologies.get(i);
                if (selectedIdeologyID < 0) {
                    selectedIdeologyID = ideologyID;
                }
                menuElements.add(new Button_Diplomacy_ChangeGovernment2(ideologyID, 2, tY, CFG.BUTTON_W * 2, true, onCivID){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_SupportRevolution.this.getElementW() * 2;
                    }

                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_SupportRevolution.this.selectIdeology(ideologyID);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCheckboxSt(ideologyID == selectedIdeologyID);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                ++this.ideologyElems;
            }
            this.sliderElem = menuElements.size();
            long maxGold = Math.max(0L, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold());
            menuElements.add(new Slider_InGame_Gold("Funding", CFG.PADD * 2, tY + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0L, maxGold, maxGold, 0.65f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SupportRevolution.this.getElementW() * 2 - CFG.PADD * 4;
                }

                @Override
                public int getSliderHeight() {
                    return CFG.PADD * 2;
                }

                @Override
                public Color getColorLEFT() {
                    return new Color(CFG.COLOR_GOLD.r, CFG.COLOR_GOLD.g, CFG.COLOR_GOLD.b, 0.65f);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        } else {
            menuElements.add(new TextScale("No governments available", -1, 2, tY, tempWidth - 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SupportRevolution.this.getElementW() * 2;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_SupportRevolution.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction("Support Revolution", -1, 2, tY, CFG.BUTTON_W, ideologies.size() > 0){

            @Override
            public int getPosXE() {
                return Menu_InGame_SupportRevolution.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_SupportRevolution.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Support Revolution", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRevolution, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (selectedIdeologyID >= 0) {
                    nData.add(new ME_Hover_2Type_Text("Government: "));
                    nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(selectedIdeologyID).getName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.gov, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Civil war chance: "));
                nData.add(new ME_Hover_2Type_Text(Menu_InGame_SupportRevolution.this.sliderElem >= 0 ? GameManager.supportRevolution_Chance(iOnCivID, Menu_InGame_SupportRevolution.this.getMenuElem(Menu_InGame_SupportRevolution.this.sliderElem).getCurrLong()) + "%" : "-", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc("Funds an ideological revolution. If the roll succeeds, rebel provinces rise in a civil war."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.diploRevolution).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploRevolution).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploRevolution).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.diploRevolution).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(Images.diploRevolution).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return selectedIdeologyID >= 0 && Menu_InGame_SupportRevolution.this.sliderElem >= 0 && GameManager.canSupportRevolution(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iOnCivID, selectedIdeologyID, Menu_InGame_SupportRevolution.this.getMenuElem(Menu_InGame_SupportRevolution.this.sliderElem).getCurrLong()) && super.getIsClickable();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.getSend();
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall("Support Revolution", CFG.BUTTON_H * 3 / 4, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
    }

    private void selectIdeology(int ideologyID) {
        selectedIdeologyID = ideologyID;
        for (int i = 0; i < this.ideologyElems; ++i) {
            this.getMenuElem(this.firstIdeologyElem + i).setCheckboxSt(this.getMenuElem(this.firstIdeologyElem + i).getCurr() == selectedIdeologyID);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            long funding = this.getMenuElem(this.sliderElem).getCurrLong();
            int chance = GameManager.supportRevolution_Chance(iOnCivID, funding);
            if (GameManager.supportRevolution(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iOnCivID, selectedIdeologyID, funding)) {
                if (GameManager.supportRevolutionCivilWarStarted) {
                    CFG.toastM.addM("Civil war started: " + CFG.ideologiesMgr.getIdeologyID(selectedIdeologyID).getName(), CFG.COLOR_POSITIVE);
                } else {
                    CFG.toastM.addM("Revolution funded: " + chance + "% chance", CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                CFG.toastM.setTimeInView(3500);
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.menus.rebuildInGame_Messages();
            }
            this.setVisibleM(false);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            this.setVisibleM(false);
            return;
        }
        if (this.firstIdeologyElem >= 0 && iID >= this.firstIdeologyElem && iID < this.firstIdeologyElem + this.ideologyElems) {
            this.getMenuElem(iID).actionElem(iID);
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
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 3);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
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
