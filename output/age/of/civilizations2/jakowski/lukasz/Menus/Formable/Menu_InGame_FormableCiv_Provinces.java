
package age.of.civilizations2.jakowski.lukasz.Menus.Formable;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_FormCivTitle;
import age.of.civilizations2.jakowski.lukasz.Button.Button_TodayPartOf_Population;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Menu_InGame_FormableCiv_Provinces
extends Menu {
    public static Image lFlag = null;

    public Menu_InGame_FormableCiv_Provinces() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_FormCivTitle(CFG.lang.get("FormX", CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag())), 0, 0, CFG.GAMEWIDTH, Math.max(CFG.BUTTON_H * 4 / 5, Math.max(IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)), true, CFG.canFormACiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.formableCivs_GameData.getFormableCivTag(), false)){

            
            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                int posX = this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() - CFG.PADD + iTranslateX;
                int posY = this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2 + iTranslateY;
                if (lFlag != null) {
                    try {
                        try {
                            oSB.setShader(Renderer.shaderAlpha);
                            lFlag.getTexture().bind(1);
                            Gdx.gl.glActiveTexture(33984);
                            IMGManager.getIMG(Images.flagDiplomacyMask).draw(oSB, posX + (IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() - IMGManager.getIMG(Images.flagDiplomacyMask).getWidth()) / 2, posY + (IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() - IMGManager.getIMG(Images.flagDiplomacyMask).getHeight()) / 2, IMGManager.getIMG(Images.flagDiplomacyMask).getWidth(), IMGManager.getIMG(Images.flagDiplomacyMask).getHeight());
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        finally {
                            oSB.flush();
                            oSB.setShader(AoCGame.shaderDef);
                            IMGManager.getIMG(Images.flagDiplomacyOver).draw(oSB, posX, posY);
                        }
                    }
                    catch (Exception exception) {
                        
                    }
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CivilizationChangesToX", CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0 && CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getCitSize() > 0) {
                        nData.add(new ME_Hover_2Type_Image(CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() ? Images.iconTrue : Images.iconFalse));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getCit(0).getCityName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS / 10.0f, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Image(CFG.core.isAtPeace(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId()) ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AtPeace")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IsNotAVassal")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Image(CFG.ownAllProvinces_FormableCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OwnsAllProvinces")));
                    nData.add(new ME_Hover_2Type_Text(": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.ownAllProvinces_FormableCiv_ControlsProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" / ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.ownAllProvinces_FormableCiv_NumOfProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" (" + (int)(CFG.formableCivs_GameData.getRequiredPerc() * 100.0f) + "%)", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Image(CFG.doesNotExists_FormableCiv(CFG.formableCivs_GameData.getFormableCivTag()) ? Images.iconTrue : Images.iconFalse));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("XDoesNotExist", CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag()))));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2));
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 2 + CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                }
                IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.wikipedia).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag()), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.wikipedia, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException e) {
                    this.menuElemHover = null;
                }
            }
        });
        long tempPop = 0L;
        for (int i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            tempPop += CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getPop().getPops();
        }
        menuElements.add(new Button_TodayPartOf_Population("" + CFG.getNumberWthSpaces("" + tempPop), CFG.getPercentageOld(tempPop, CFG.core.countWorld_Population(), 4), 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
        this.loadFlag(CFG.formableCivs_GameData.getFormableCivTag());
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2, false, true);
        oSB.setColor(Color.WHITE);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(2).getPosY() - CFG.PADD - 1 + iTranslateY, this.getMenuElem(2).getPosXE() + this.getMenuElem(2).getWidthE() + CFG.PADD + 1, CFG.BUTTON_H + CFG.PADD * 2 + 1);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        Renderer.drawText(oSB, CFG.FONT_BOLD, "Age of History 2: Definitive Edition", CFG.PADD * 4 + CFG.BUTTON_W * 2 + CFG.BUTTON_W / 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(1.0f, 1.0f, 0.98f, 0.261f));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (this.getMenuElem(iID).getCheckboxSt()) {
                    CFG.setDialogType(DialogType.FORM_A_CIV);
                    break;
                }
                try {
                    if (CFG.ownAllProvinces_FormableCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) break;
                    CFG.map.getMpC().centerToProvID(CFG.formableCivs_GameData.getCapitalProvinceID());
                }
                catch (Exception exception) {}
                break;
            }
            case 1: {
                this.onBackPressed();
                break;
            }
            case 2: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.formableCivs_GameData.getFormableCivTag();
                CFG.setDialogType(DialogType.GO_TO_WIKI);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        this.disposeFlag();
        CFG.menus.setMenuID(View.eINGAME);
        CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
        CFG.core.checkProvinceActionMenu();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
    }

    @Override
    public void onMenuPressed() {
        this.onBackPressed();
    }

    private final void loadFlag(String nTag) {
        block16: {
            this.disposeFlag();
            try {
                if (FileManager.loadFile("game/flagsXH/" + nTag + ".png").exists()) {
                    lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsH/" + nTag + ".png").exists()) {
                    lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                }
                if (lFlag != null) break block16;
                try {
                    lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + nTag + ".png")), Texture.TextureFilter.Nearest);
                }
                catch (GdxRuntimeException e) {
                    try {
                        lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Nearest);
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                lFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            catch (GdxRuntimeException erq) {
                                lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            break block16;
                        }
                        lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                    }
                }
            }
            catch (Exception e) {
                lFlag = null;
            }
        }
    }

    private final void disposeFlag() {
        if (lFlag != null) {
            lFlag.getTexture().dispose();
            lFlag = null;
        }
    }
}

