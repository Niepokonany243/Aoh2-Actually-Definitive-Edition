
package age.of.civilizations2.jakowski.lukasz.Menus.Formable.AddCiv;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_Diplomacy_Action_Government;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction_Animated;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_NewGameAddCiv;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_PopulationEconomy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CivN.Menu_CreateNewGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Technology;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_AddCiv
extends Menu {
    public static final int ANIMATION_TIME = 155;
    private long lTime = 0L;
    public static int provinceID = -1;
    public static List<Integer> provinces = new ArrayList<Integer>();
    public static float techLevel = 0.5f;
    public static String civTag = null;
    public static boolean addProvinceMode = true;

    public Menu_InGame_AddCiv() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = CFG.PADD;
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        menuElements.add(new Button_InGameBox(CFG.lang.get("Back"), -1, CFG.PADD, tY, tempW - CFG.PADD * 2, true){

            @Override
            public void actionElem(int iID) {
                CFG.brushMode = false;
                CFG.menus.setMenuID(View.eINGAME);
                RenderProvince.updateDrawProvinces();
                CFG.map.getMpB().updateWorldMap_Shaders();
            }
        });
        menuElements.add(new Button_InGameBox(CFG.lang.get("CreateaCivilization"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void actionElem(int iID) {
                CFG.brushMode = false;
                CFG.menus.getColorPicker().setPosX(CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4 + CFG.PADD * 4);
                CFG.flagManager.loadData();
                CFG.flagManager.initFlagEdit();
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editorCivilization_GameData = new Civilization_GameData3();
                CFG.backToMenu = View.eINGAME_AC;
                CFG.menus.setMenuID(View.eCREATE_CIVILIZATION);
                RenderProvince.updateDrawProvinces();
                CFG.map.getMpB().updateWorldMap_Shaders();
            }
        });
        menuElements.add(new Button_InGameBox(CFG.lang.get("SelectCivilization"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuID(View.eINGAME_ACS);
                CFG.map.getMpB().updateWorldMap_Shaders();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        if (provinceID >= 0) {
            try {
                if (CFG.core.getProv(provinceID).getSeaProv() || CFG.core.getProv(provinceID).getWastelandLvl() >= 0 || CFG.core.getProv(provinceID).getIsCapital2()) {
                    provinceID = -1;
                }
            }
            catch (Exception ex) {
                provinceID = -1;
            }
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilization"), -1, 2, tY, tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new ButtonN_NewGameAddCiv(civTag == null || civTag.isEmpty() ? CFG.lang.get("SelectCivilization") : CFG.lang.getCiv(civTag), civTag == null || civTag.isEmpty() ? "" : CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID(civTag)).getName(), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - 4){

            @Override
            public void actionElem(int iID) {
                if (civTag == null || civTag.isEmpty()) {
                    CFG.menus.setMenuID(View.eINGAME_ACS);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (civTag != null) {
            menuElements.add(new Button_Diplomacy_Action_Government(CFG.ideologiesMgr.getIdeologyID(civTag), CFG.lang.get("ChangeTypeOfGovernment"), 0, 2, tY, tempW - 4, tempElemH, true){

                @Override
                public void actionElem(int iID) {
                    if (!CFG.menus.getVisible_InGame_AddCiv_Gov()) {
                        CFG.menus.setVisible_InGame_AddCiv_Gov(true);
                    } else {
                        CFG.menus.setVisible_InGame_AddCiv_Gov(false);
                    }
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChangeTypeOfGovernment"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.ideologiesMgr.getIdeologyID(civTag), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
            menuElements.add(new Slider_InGame_Technology(CFG.lang.get("TechnologyLevel"), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, 0, (int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f), (int)(techLevel * 100.0f), 0.65f){

                @Override
                public Color getColorLEFT() {
                    return new Color(CFG.COLOR_RESEARCH.r, CFG.COLOR_RESEARCH.g, CFG.COLOR_RESEARCH.b, 0.65f);
                }

                @Override
                public void actionElem(int iID) {
                    techLevel = (float)this.getCurr() / 100.0f;
                }

                @Override
                public String getDrawText() {
                    return "" + (float)this.getCurr() / 100.0f;
                }
            });
            menuElements.add(new Button_InGameAction_Animated(CFG.lang.get("AddCivilization"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

                @Override
                public void actionElem(int iID) {
                    try {
                        Menu_InGame_AddCiv.this.addCivilization();
                    }
                    catch (Exception exception) {
                    }
                    finally {
                        CFG.menus.setMenuID(View.eINGAME);
                    }
                }

                @Override
                public boolean getIsClickable() {
                    return provinceID >= 0;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (this.getIsHovered() || isActive) {
                        return super.getColorE(isActive);
                    }
                    return CFG.COLOR_HOVER_TITLE;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        if (provinceID >= 0) {
            menuElements.add(new TextBuildTitle(CFG.lang.get("CapitalCity"), -1, 2, tY, tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            menuElements.add(new Button_View_PopulationEconomy(0, CFG.core.getProv(provinceID).getName(), provinceID, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - 4, false){

                @Override
                public void actionElem(int iID) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                        provinceID = CFG.core.getActiveProvID();
                        CFG.menus.setVisible_InGame_AddCiv(true);
                    }
                }

                @Override
                public void actionElemPPM() {
                    CFG.map.getMpC().centerToProvID(this.getCurr());
                }
            });
            menuElements.add(new TextBuildTitle(CFG.lang.get("Provinces"), -1, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            menuElements.add(new Button_InGameAction_Animated(CFG.lang.get("Add") + ": " + CFG.lang.get("SelectProvince"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - CFG.PADD * 2, true){

                @Override
                public void actionElem(int iID) {
                    addProvinceMode = true;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (addProvinceMode) {
                        return CFG.COLOR_POSITIVE;
                    }
                    return super.getColorE(isActive);
                }

                @Override
                public void buildElemHover() {
                    try {
                        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Add") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SelectProvince"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChooseAProvince"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            menuElements.add(new Button_InGameAction(CFG.lang.get("Remove"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (tempW - CFG.PADD * 3) / 2, true){

                @Override
                public void actionElem(int iID) {
                    addProvinceMode = false;
                }

                @Override
                public void buildElemHover() {
                    try {
                        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Remove") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SelectProvince"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChooseAProvince"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (!addProvinceMode) {
                        return CFG.COLOR_POSITIVE;
                    }
                    return super.getColorE(isActive);
                }
            });
            menuElements.add(new Button_InGameAction(CFG.lang.get("Brush"), -1, CFG.PADD + (tempW - CFG.PADD * 3) / 2 + CFG.PADD, tY, (tempW - CFG.PADD * 3) / 2, true){

                @Override
                public void actionElem(int iID) {
                    CFG.brushMode = !CFG.brushMode;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (CFG.brushMode) {
                        return CFG.COLOR_POSITIVE;
                    }
                    return CFG.COLOR_NEGATIVE_2;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            if (provinces.isEmpty()) {
                menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 2, tY, tempW - 4, CFG.BUTTON_H * 3 / 4, 0.75f));
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            } else {
                for (int a = 0; a < provinces.size(); ++a) {
                    menuElements.add(new Button_View_PopulationEconomy(0, CFG.core.getProv(provinces.get(a)).getName(), provinces.get(a), 2, tY, tempW - 4, false){

                        @Override
                        public void actionElem(int iID) {
                            Menu_InGame_AddCiv.removeProvince(this.getCurr());
                            CFG.menus.setVisible_InGame_AddCiv(true);
                        }

                        @Override
                        public void actionElemPPM() {
                            CFG.map.getMpC().centerToProvID(this.getCurr());
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
        } else {
            menuElements.add(new TextBuildTitle(CFG.lang.get("CapitalCity"), -1, 2, tY, tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                @Override
                public Color getColor(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince") + ": " + CFG.lang.get("Add"), -1, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW - 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public void actionElem(int iID) {
                    int nProv = CFG.core.getActiveProvID();
                    if (nProv >= 0) {
                        try {
                            if (CFG.core.getProv(nProv).getSeaProv() || CFG.core.getProv(nProv).getWastelandLvl() >= 0 || CFG.core.getProv(nProv).getIsCapital2()) {
                                nProv = -1;
                            }
                        }
                        catch (Exception ex) {
                            nProv = -1;
                        }
                        if (nProv >= 0) {
                            provinceID = nProv;
                            CFG.menus.setVisible_InGame_AddCiv(true);
                        } else {
                            CFG.toastM.addM(CFG.lang.get("ChooseAProvince"));
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"));
                    }
                }

                @Override
                public Color getColor(boolean isActive) {
                    if (!this.getIsHovered()) {
                        return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
                    }
                    return super.getColor(isActive);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("AddCivilization"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + Core.PADDING * 2 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.0f, 1.0f, 1.0f, 0.075f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.0f, 1.0f, 1.0f, 0.175f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT + CFG.PADD * 2, IMGManager.getIMG(Images.topBar2).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(CFG.GAMEHEIGHT - CFG.BUTTON_H, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + 155L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX(), CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM(), -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / 155.0f))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
            super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
            super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
        this.loadFlag();
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public static void setCivTag(String nTag) {
        civTag = nTag;
        try {
            if (Menu_CreateNewGame_AddCiv.civFlag != null) {
                Menu_CreateNewGame_AddCiv.civFlag.dispose();
                Menu_CreateNewGame_AddCiv.civFlag = null;
            }
        }
        catch (Exception exception) {
            
        }
        CFG.menus.setVisible_InGame_AddCiv(true);
    }

    public final void loadFlag() {
        block13: {
            if (Menu_CreateNewGame_AddCiv.civFlag != null || civTag == null || civTag.isEmpty()) {
                return;
            }
            try {
                try {
                    if (FileManager.loadFile("game/flagsXH/" + civTag + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + civTag + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block13;
                    }
                    if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block13;
                    }
                    if (FileManager.loadFile("game/flagsH/" + civTag + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + civTag + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block13;
                    }
                    if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block13;
                    }
                    if (FileManager.loadFile("game/flags/" + civTag + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + civTag + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        break block13;
                    }
                    if (FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(civTag) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        break block13;
                    }
                    if (CFG.isAndroid() && FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(civTag) + "/" + CFG.ideologiesMgr.getRealTag(civTag) + "_FL.png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(civTag) + "/" + CFG.ideologiesMgr.getRealTag(civTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        break block13;
                    }
                    if (FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(civTag) + "/" + CFG.ideologiesMgr.getRealTag(civTag) + "_FL.png").exists()) {
                        Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(civTag) + "/" + CFG.ideologiesMgr.getRealTag(civTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        break block13;
                    }
                    Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                }
                catch (RuntimeException ex) {
                    Menu_CreateNewGame_AddCiv.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
                }
            }
            catch (Exception exception) {
                
            }
        }
    }

    @Override
    public void actionCloseMenu() {
        super.actionCloseMenu();
        CFG.brushMode = false;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            CFG.brushMode = false;
            try {
                if (Menu_CreateNewGame_AddCiv.civFlag != null) {
                    Menu_CreateNewGame_AddCiv.civFlag.dispose();
                    Menu_CreateNewGame_AddCiv.civFlag = null;
                }
            }
            catch (Exception exception) {
                
            }
        }
    }

    public void addCivilization() {
        try {
            ArrayList<Integer> rebuildRegionsCivs = new ArrayList<Integer>();
            if (CFG.core.getProv(provinceID).getCivId() > 0) {
                rebuildRegionsCivs.add(CFG.core.getProv(provinceID).getCivId());
            }
            if (CFG.core.createScenarioAddCivilization(civTag, provinceID, false, true, false)) {
                int a;
                int civID = -1;
                for (a = CFG.core.getCivsSize() - 1; a >= 0; --a) {
                    if (!CFG.core.getCiv(a).getCivTag().equals(civTag)) continue;
                    civID = a;
                    break;
                }
                CFG.core.getCiv(civID).setTechLevel(techLevel);
                CFG.core.getCiv(civID).setGold(CFG.core.getGameScenars().getScenario_StartingMoney());
                CFG.core.getProv(provinceID).removeArmies();
                for (a = CFG.core.getProv(provinceID).getPop().getNatsSize() - 1; a >= 0; --a) {
                    CFG.core.getProv(provinceID).getPop().setPopulationOfCivID(civID, CFG.core.getProv(provinceID).getPop().getPopulationOfCivID(civID) + CFG.core.getProv(provinceID).getPop().getPopulationID(a));
                    if (CFG.core.getProv(provinceID).getPop().getCivID(a) == civID) continue;
                    CFG.core.getProv(provinceID).getPop().setPopulationOfCivID(CFG.core.getProv(provinceID).getPop().getCivID(a), 0);
                }
                try {
                    int i;
                    for (i = provinces.size() - 1; i >= 0; --i) {
                        CFG.core.getProv(provinces.get(i)).setTrueOwnerOfProv(civID);
                        CFG.core.getProv(provinces.get(i)).setCivId(civID, false, false);
                        CFG.core.getProv(provinces.get(i)).getCores().addNewCore(civID, GameCalendar.TURNID);
                        CFG.core.getProv(provinces.get(i)).removeArmies();
                        for (int a2 = CFG.core.getProv(provinces.get(i)).getPop().getNatsSize() - 1; a2 >= 0; --a2) {
                            CFG.core.getProv(provinces.get(i)).getPop().setPopulationOfCivID(civID, CFG.core.getProv(provinces.get(i)).getPop().getPopulationOfCivID(civID) + CFG.core.getProv(provinces.get(i)).getPop().getPopulationID(a2));
                            if (CFG.core.getProv(provinces.get(i)).getPop().getCivID(a2) == civID) continue;
                            CFG.core.getProv(provinces.get(i)).getPop().setPopulationOfCivID(CFG.core.getProv(provinces.get(i)).getPop().getCivID(a2), 0);
                        }
                    }
                    for (i = provinces.size() - 1; i >= 0; --i) {
                        CFG.core.getProv(provinces.get(i)).updateFogOfWar(CFG.PLAYER_TURN_ID);
                        CFG.core.getProv(provinces.get(i)).updateDrawArmyInProv();
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    Core.addSimpleTask(new Core.SimpleTask("rebuildRegionsCivs" + civID, civID){

                        @Override
                        public void update() {
                            CFG.core.buildCivilizationRegions(this.id);
                        }
                    });
                    for (int a3 = 0; a3 < rebuildRegionsCivs.size(); ++a3) {
                        Core.addSimpleTask(new Core.SimpleTask("rebuildRegionsCivs" + a3, (int)((Integer)rebuildRegionsCivs.get(a3))){

                            @Override
                            public void update() {
                                CFG.core.buildCivilizationRegions(this.id);
                            }
                        });
                    }
                }
                catch (Exception exception) {
                    
                }
                CFG.core.setActiveProvID(-1);
                CFG.core.setActiveProvID(provinceID);
                CFG.toastM.addM(CFG.lang.get("Added") + ": " + CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getCivName());
                CFG.menus.setVisible_InGame_AddCiv(false);
                CFG.menus.setVisible_InGame_AddCiv_Gov(false);
            }
            return;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.menus.setMenuID(View.eINGAME);
            return;
        }
    }

    public static void addProvince(int id) {
        if (provinceID == id) {
            return;
        }
        for (int a = provinces.size() - 1; a >= 0; --a) {
            if (provinces.get(a) != id) continue;
            return;
        }
        provinces.add(id);
    }

    public static void removeProvince(int id) {
        for (int a = provinces.size() - 1; a >= 0; --a) {
            if (provinces.get(a) != id) continue;
            provinces.remove(a);
            return;
        }
    }
}

