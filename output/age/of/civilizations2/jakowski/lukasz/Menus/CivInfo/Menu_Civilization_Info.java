
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Rank;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextProvincesTech;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilization_Info
extends Menu {
    public static final int ANIMATION_TIME = 250;
    public static long lTime = 0L;

    public Menu_Civilization_Info() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Rank("1", CFG.PADD * 2 + ButtonFlagBig.getButtonW() - IMGManager.getIMG(Images.top_circle).getWidth(), CFG.PADD * 2 + ButtonFlagBig.getButtonH() - IMGManager.getIMG(Images.top_circle).getHeight()){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_RankOfCiv(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextScrollable(null, ButtonFlagBig.getButtonW() + CFG.PADD * 4, CFG.PADD * 3, CFG.CIV_INFO_MENU_WIDTH - ButtonFlagBig.getButtonW() - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.COLOR_TEXT_CIV_NAME, 1.0f){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Lord") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassal") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName()));
                    nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                try {
                    String tText;
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag() + ".txt").exists()) {
                        String tText2 = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag() + ".txt").readString();
                        if (tText2 != null && tText2.length() > 0) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(tText2, CFG.FONT_REGULAR_SMALL));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag()) + ".txt").exists() && (tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag()) + ".txt").readString()) != null && tText.length() > 0) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(tText, CFG.FONT_REGULAR_SMALL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                catch (Exception exception) {
                    
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getName()));
                nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Religion") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID()).getName()));
                nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                    super.draw_Element(oSB, iTranslateX + CFG.PADD + (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), iTranslateY, isActive, scrollableY);
                    CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() + (int)((float)this.getHeightE() - (float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())) / 2 + iTranslateY, (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())));
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getCurr() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.flagRectSmall).getHeight() + (int)((float)this.getHeightE() - (float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())) / 2 + iTranslateY, (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())), (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight())));
                } else {
                    super.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                }
            }

            @Override
            public int getTextWidthU() {
                try {
                    if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                        return super.getTextWidthU() + CFG.PADD + (int)((float)CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getWidth() * Menu_Civilization_Info.this.getImageScale(CFG.core.getCiv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()).getFlagC().getHeight()));
                    }
                    return super.getTextWidthU();
                }
                catch (IndexOutOfBoundsException ex) {
                    return super.getTextWidthU();
                }
            }
        });
        menuElements.add(new ButtonFlagBig(CFG.PADD * 2, CFG.PADD * 2, true, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ShowHideColorPicker"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pickerIcon, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    String tText;
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag() + ".txt").exists()) {
                        String tText2 = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag() + ".txt").readString();
                        if (tText2 != null && tText2.length() > 0) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(tText2, CFG.FONT_REGULAR_SMALL));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag()) + ".txt").exists() && (tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/descriptions/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivTag()) + ".txt").readString()) != null && tText.length() > 0) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(tText, CFG.FONT_REGULAR_SMALL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                catch (Exception exception) {
                    
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                Menu_MM.goBack = View.eCREATE_NEW_GAME;
                CFG.menus.setMenuID(View.eMM);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public int getFlagCivID() {
                return CFG.activeCivInfoId;
            }
        });
        menuElements.add(new TextProvincesTech(null, ButtonFlagBig.getButtonW() + CFG.PADD * 4, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT, CFG.FONT_REGULAR_SMALL){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_ProvincesOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public int getWidthE() {
                return CFG.CIV_INFO_MENU_WIDTH - ButtonFlagBig.getButtonW() - CFG.PADD * 4;
            }
        });
        menuElements.add(new Text("", ButtonFlagBig.getButtonW() + CFG.PADD * 4, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT, CFG.FONT_REGULAR_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_LeaderOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public int getWidthE() {
                return CFG.CIV_INFO_MENU_WIDTH - ButtonFlagBig.getButtonW() - CFG.PADD * 4;
            }
        });
        this.initMenu(new TitleM("", 0, false, false), CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH, Menu_Civilization_Info.getUseMenu_UI2() ? Menu_Civilization_Info.getMenuY_UI2() : IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2, CFG.CIV_INFO_MENU_WIDTH, Menu_Civilization_Info.getMenuH_UI2(), menuElements, false, true);
        this.updateLang();
    }

    public static boolean getUseMenu_UI2() {
        return CFG.getUIScale() > 0;
    }

    public static int getMenuY_UI2() {
        return CFG.PADD;
    }

    public static int getMenuH_UI2() {
        return ButtonFlagBig.getButtonH() + CFG.PADD * 4;
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE("" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getRankPos());
        this.getMenuElem(1).setTextE(CFG.getActiveCivInfoId() > 0 ? CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName() : "");
        this.getMenuElem(3).setTextE(CFG.lang.get("Provinces") + ": ");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + Core.PADDING);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() - 1);
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.r, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.g, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.b, 1.0f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getMenuPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightM() - this.getHeightM() / 2 + iTranslateY, this.getWidthM() - 2, this.getHeightM() / 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - 2 + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - 1 + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1 + iTranslateY, this.getWidthM(), 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.sliderGradient).getHeight() - 1 + iTranslateY, this.getWidthM() / 4, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 4 + iTranslateX, this.getMenuPosY() + this.getHeightM() - IMGManager.getIMG(Images.sliderGradient).getHeight() - 1 + iTranslateY, this.getWidthM() / 4, 1, true, false);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
    }

    private final float getImageScale(int nImageHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight : 1.0f;
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_CreateNewGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 1: 
            case 3: {
                Render.drawCivNamesInCreateNewGame = !Render.drawCivNamesInCreateNewGame;
                break;
            }
            case 2: {
                CFG.menus.getColorPicker().setPosX(CFG.PADD * 4);
                CFG.menus.getColorPicker().setPosY(this.getPosY());
                CFG.menus.getColorPicker().setVisible(!CFG.menus.getColorPicker().getVisible(), ColorPicker_AoC.PickerAction.ACTIVE_CIVILIZATION_COLOR);
                if (!CFG.menus.getColorPicker().getVisible()) break;
                CFG.mapModesManager.disableAllViews();
                break;
            }
            case 4: {
                if (CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.leaderData.getWiki().length() <= 0) break;
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.leaderData.getWiki();
                CFG.setDialogType(DialogType.GO_TO_WIKI_SCENARIO);
            }
        }
    }

    @Override
    public void actionCloseMenu() {
        this.setVisibleM(false);
        CFG.menus.hideCivilizations_Info_Players();
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && !this.getVisibleM()) {
            lTime = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }
}

