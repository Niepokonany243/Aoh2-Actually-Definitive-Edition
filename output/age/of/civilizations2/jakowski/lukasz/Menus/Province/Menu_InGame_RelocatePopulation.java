/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Province;

import age.of.civilizations2.jakowski.lukasz.Button.Button_RelocatePop;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Population;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Gold;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Population;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_RelocatePopulation
extends Menu {
    public static List<Integer> fromProvinceIDs = new ArrayList<Integer>();
    public static int toProvinceID = -1;
    public static int popToRelocate = 0;
    public static List<Boolean> relocate = new ArrayList<Boolean>();

    public final int getElementW2() {
        return this.getWidthM();
    }

    public static void addFromProvince(int provinceID) {
        if (provinceID >= 0 && !fromProvinceIDs.contains(provinceID) && provinceID != toProvinceID) {
            fromProvinceIDs.add(provinceID);
        }
    }

    public Menu_InGame_RelocatePopulation(int nFromProvinceID) {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (fromProvinceIDs.isEmpty() && nFromProvinceID >= 0) {
            fromProvinceIDs.add(nFromProvinceID);
        }
        int maxPopulation = 0;
        int sliderButtonID = -1;
        
        // Use the first province for nationality selection template
        int mainFromID = fromProvinceIDs.isEmpty() ? nFromProvinceID : fromProvinceIDs.get(0);
        
        if (relocate.isEmpty() && mainFromID >= 0) {
            for (i = 0; i < CFG.core.getProv(mainFromID).getPop().getNatsSize(); ++i) {
                relocate.add(true);
            }
        }
        
        try {
            for (Integer fID : fromProvinceIDs) {
                for (i = 0; i < CFG.core.getProv(fID).getPop().getNatsSize(); ++i) {
                    // Logic for multiple provinces: if nationality matches index in template? 
                    // This is tricky. Simplification: relocate all selected provinces' population.
                    maxPopulation += CFG.core.getProv(fID).getPop().getPopulationID(i);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (maxPopulation < popToRelocate || popToRelocate == 0) {
            popToRelocate = maxPopulation;
        }
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new TextBuildTitle(CFG.lang.get("FromProvince"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW2();
            }
        });
        menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(CFG.core.getProv(mainFromID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(mainFromID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(mainFromID).getCivId()).getB() / 255.0f, 1.0f), (fromProvinceIDs.size() > 1 ? CFG.lang.get("Provinces") + ": " + fromProvinceIDs.size() : CFG.core.getProv(mainFromID).getProvName()), CFG.core.getProv(mainFromID).getCivId(), CFG.lang.get("Population") + ": ", CFG.getNumberWthSpaces("" + maxPopulation), Images.pop, CFG.COLOR_POPULATION, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Button_View_Population.getHoverPopulation(mainFromID);
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW2();
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("DestinationProvince"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (toProvinceID < 0) {
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 0, tY, CFG.BUTTON_W, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_RelocatePopulation.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getB() / 255.0f, 1.0f), CFG.core.getProv(toProvinceID).getProvName(), CFG.core.getProv(toProvinceID).getCivId(), CFG.lang.get("Population") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getProv(toProvinceID).getPop().getPops()), Images.pop, CFG.COLOR_POPULATION, 0, tY, CFG.BUTTON_W){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = Button_View_Population.getHoverPopulation(toProvinceID);
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_RelocatePopulation.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            menuElements.add(new Slider_InGame_Population(CFG.lang.get("PopulationToRelocate"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6), 0, maxPopulation, popToRelocate, 0.65f){

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_RelocatePopulation.this.getMenuElem(iID + 1).setCurr(Menu_InGame_RelocatePopulation.this.getCostRelocate(this.getCurr()));
                    popToRelocate = this.getCurr();
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_RelocatePopulation.this.getElementW2() - CFG.PADD * 4;
                }

                @Override
                public int getSliderHeight() {
                    return CFG.PADD * 2;
                }

                @Override
                public Color getColorLEFT() {
                    return new Color(CFG.COLOR_POPULATION.r, CFG.COLOR_POPULATION.g, CFG.COLOR_POPULATION.b, 0.65f);
                }
            });
            sliderButtonID = menuElements.size() - 1;
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            menuElements.add(new Slider_InGame_Gold(CFG.lang.get("Cost"), CFG.PADD * 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6), 0, this.getCostRelocate(maxPopulation), 0, 0.65f){

                @Override
                public void actionElem(int iID) {
                    this.setCurr(Menu_InGame_RelocatePopulation.this.getCostRelocate(popToRelocate));
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_RelocatePopulation.this.getElementW2() - CFG.PADD * 4;
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
        }
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_RelocatePopulation.this.setVisibleM(false);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Confirm"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_RelocatePopulation.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_RelocatePopulation.this.relocatePopulation();
                Menu_InGame_RelocatePopulation.this.setVisibleM(false);
            }

            @Override
            public boolean getIsClickable() {
                return toProvinceID >= 0;
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("PopulationByOrigin") + (fromProvinceIDs.size() > 1 ? "" : ": " + CFG.core.getProv(mainFromID).getProvName()), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_RelocatePopulation.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        if (fromProvinceIDs.size() <= 1) {
            for (int i2 = 0; i2 < CFG.core.getProv(mainFromID).getPop().getNatsSize(); ++i2) {
                menuElements.add(new Button_RelocatePop(i2, CFG.core.getProv(mainFromID).getPop().getCivID(i2), CFG.core.getProv(mainFromID).getPop().getPopulationID(i2), 0, tY, CFG.BUTTON_W * 2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_RelocatePopulation.this.getElementW2();
                    }

                    @Override
                    public void actionElem(int iID) {
                        try {
                            relocate.set(this.id, relocate.get(this.id) == false);
                            CFG.menus.rebuildInGame_Build_RelocatePopulation(fromProvinceIDs.get(0));
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }

                    @Override
                    public boolean getCheckboxSt() {
                        try {
                            return relocate.get(this.id);
                        }
                        catch (Exception exception) {
                            return false;
                        }
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("RelocatePopulation"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_POPULATION_GROWTHRATE_MAX.r, CFG.COLOR_POPULATION_GROWTHRATE_MAX.g, CFG.COLOR_POPULATION_GROWTHRATE_MAX.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_POPULATION_GROWTHRATE_MAX.r, CFG.COLOR_POPULATION_GROWTHRATE_MAX.g, CFG.COLOR_POPULATION_GROWTHRATE_MAX.b, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, Menu_InGame_RelocatePopulation.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_RelocatePopulation.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_RelocatePopulation.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_RelocatePopulation.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
        if (sliderButtonID >= 0) {
            ((MenuElemUI)menuElements.get(sliderButtonID)).setCurr(popToRelocate);
            ((MenuElemUI)menuElements.get(sliderButtonID + 1)).setCurr(this.getCostRelocate(popToRelocate));
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
        try {
            if (!(CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() == toProvinceID || fromProvinceIDs.contains(CFG.core.getActiveProvID()) || GameValues.gvPopRelocate.CAN_RELOCATE_TO_ONLY_OWN_PROVINCE && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                toProvinceID = CFG.core.getActiveProvID();
                CFG.menus.rebuildInGame_Build_RelocatePopulation(fromProvinceIDs.get(0));
            }
        }
        catch (Exception exception) {
            // empty catch block
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

    public int getCostRelocate(int population) {
        return (int)Math.ceil(GameValues.gvPopRelocate.COST_RELOCATE_BASE + GameValues.gvPopRelocate.COST_RELOCATE_PER_POP * (float)population);
    }

    public void relocatePopulation() {
        if (toProvinceID < 0) {
            CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
        } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < 0L) {
            CFG.toastM.addM(CFG.lang.get("Treasury") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold(), CFG.COLOR_NEGATIVE_2);
        } else if (popToRelocate <= 0) {
            CFG.toastM.addM(CFG.lang.get("PopulationToRelocate") + ": " + popToRelocate, CFG.COLOR_NEGATIVE_2);
        } else {
            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setGold(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() - (long)this.getCostRelocate(popToRelocate));
            
            int donePopulation = 0;
            int totalToRelocate = popToRelocate;

            for (Integer fID : fromProvinceIDs) {
                if (totalToRelocate <= 0) break;
                
                ArrayList<Integer> civs = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getProv(fID).getPop().getNatsSize(); ++i) {
                    civs.add(CFG.core.getProv(fID).getPop().getCivID(i));
                }

                for (int i = 0; i < civs.size() && totalToRelocate > 0; ++i) {
                    // If multiple provinces, we might want to move everyone or follow the 'relocate' template for the first province
                    // For multiple selection, moving everyone is safer logic unless we merge nationalities
                    if (fromProvinceIDs.size() > 1 || (i < relocate.size() && relocate.get(i))) {
                        int possiblePop = (int)CFG.core.getProv(fID).getPop().getPopulationOfCivID((Integer)civs.get(i));
                        int move = Math.min(possiblePop, totalToRelocate);
                        CFG.core.getProv(fID).getPop().setPopulationOfCivID((Integer)civs.get(i), possiblePop - move);
                        CFG.core.getProv(toProvinceID).getPop().setPopulationOfCivID((Integer)civs.get(i), CFG.core.getProv(toProvinceID).getPop().getPopulationOfCivID((Integer)civs.get(i)) + move);
                        donePopulation += move;
                        totalToRelocate -= move;
                    }
                }
            }

            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("RelocatePopulation"), CFG.lang.get("Population") + ": " + CFG.getNumberWthSpaces("" + donePopulation), Images.infoDiplomacy);
        }
    }
}

