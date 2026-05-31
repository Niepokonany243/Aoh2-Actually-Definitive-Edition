/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.FormableCivs;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_Diplomacy_Action_Government;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_MapEditor_FormableCivs_Claimants
extends Menu {
    private List<Image> lFlags = new ArrayList<Image>();

    public Menu_MapEditor_FormableCivs_Claimants() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = CFG.BUTTON_H;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_InGameBox(null, -1, CFG.PADD + 2, tY, tempW - CFG.PADD * 2 - 2, true){

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("FormableHelp0"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException e) {
                    this.menuElemHover = null;
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (i = 0; i < CFG.formableCivs_GameData.getClaimantsSize(); ++i) {
            menuElements.add(new Button_NewGameStyle_Left(CFG.lang.getCiv(CFG.formableCivs_GameData.getClaimant(i)) + " [" + CFG.formableCivs_GameData.getClaimant(i) + "]", CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH, CFG.PADD + 2, tY, tempW - 2 - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.75f), (int)((float)CFG.BUTTON_H * 0.75f), true));
            menuElements.add(new Button_In_Game_Players_Box_RIGHT("", -1, tempW - 2 - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), tY, (int)((float)CFG.BUTTON_H * 0.75f), true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        for (i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
            menuElements.add(new Button_Diplomacy_Action_Government(i, CFG.lang.get(CFG.ideologiesMgr.getIdeologyID(i).getName()) + (CFG.ideologiesMgr.getIdeologyID(i).getExtraTag().length() > 0 ? " [" + CFG.ideologiesMgr.getIdeologyID(i).getExtraTag() + "]" : ""), 0, 2, tY, tempW - 4, (int)((float)CFG.BUTTON_H * 0.8f), true){

                @Override
                public void actionElem(int iID) {
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChangeTypeOfGovernment"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Ideology_Big(this.getCurr(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_MapEditor_FormableCivs_Claimants.this.getPosX() - 2 + iTranslateX, Menu_MapEditor_FormableCivs_Claimants.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_MapEditor_FormableCivs_Claimants.this.getWidthM() + 2, this.getHeightT(), false, false);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_MapEditor_FormableCivs_Claimants.this.getPosX() + iTranslateX, Menu_MapEditor_FormableCivs_Claimants.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_MapEditor_FormableCivs_Claimants.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_MapEditor_FormableCivs_Claimants.this.getPosX() + iTranslateX, Menu_MapEditor_FormableCivs_Claimants.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD, Menu_MapEditor_FormableCivs_Claimants.this.getWidthM(), CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_MapEditor_FormableCivs_Claimants.this.getPosX() + iTranslateX, Menu_MapEditor_FormableCivs_Claimants.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_MapEditor_FormableCivs_Claimants.this.getWidthM());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_MapEditor_FormableCivs_Claimants.this.getPosX() + iTranslateX, Menu_MapEditor_FormableCivs_Claimants.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_MapEditor_FormableCivs_Claimants.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H - CFG.PADD * 3), menuElements);
        this.updateLang();
        this.loadFlags();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddCivilization"));
        this.getTitleM().setText(CFG.lang.get("Claimants") + (CFG.formableCivs_GameData.getFormableCivTag() != null ? " [" + CFG.formableCivs_GameData.getFormableCivTag() + "]" : ""));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2, this.getHeightM(), false, true);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 0; i < this.lFlags.size(); ++i) {
            this.lFlags.get(i).drawO(oSB, this.getPosX() + this.getMenuElem(i * 2 + 1).getPosXE() + CFG.PADD * 2 + iTranslateX, this.getMenuPosY() + this.getMenuElem(i * 2 + 1).getPosY() + this.getMenuElem(i * 2 + 1).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - this.lFlags.get(i).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosX() + this.getMenuElem(i * 2 + 1).getPosXE() + CFG.PADD * 2 + iTranslateX, this.getMenuPosY() + this.getMenuElem(i * 2 + 1).getPosY() + this.getMenuElem(i * 2 + 1).getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 + iTranslateY);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        if (iID >= this.getMenuElemsSize() - CFG.ideologiesMgr.getIdeologiesSize()) {
            if (CFG.formableCivs_GameData.getFormableCivTag() != null) {
                CFG.formableCivs_GameData.setFormableCivTag(CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag()) + CFG.ideologiesMgr.getIdeologyID(this.getMenuElem(iID).getCurr()).getExtraTag());
                CFG.menus.setMenuIDWithoutAnim(View.eMAP_EDITOR_FORMABLE_CIVS_EDIT);
            }
            return;
        }
        if (iID == 0) {
            CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS_SELECT_CLAIMANT);
        }
        if ((iID - 1) % 2 == 1) {
            CFG.formableCivs_GameData.removeClaimant((iID - 1) / 2);
            CFG.menus.rebuildMapEditor_FormableCivs_Claimants();
        } else {
            CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
    }

    @Override
    public void onBackPressed() {
        this.disposeFlags();
    }

    private final void loadFlags() {
        this.disposeFlags();
        for (int i = 0; i < CFG.formableCivs_GameData.getClaimantsSize(); ++i) {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.formableCivs_GameData.getClaimant(i) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getClaimant(i)) + ".png")), Texture.TextureFilter.Nearest));
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.formableCivs_GameData.getClaimant(i) + "/" + CFG.formableCivs_GameData.getClaimant(i) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.formableCivs_GameData.getClaimant(i) + "/" + CFG.formableCivs_GameData.getClaimant(i) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            continue;
                        }
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.formableCivs_GameData.getClaimant(i) + "/" + CFG.formableCivs_GameData.getClaimant(i) + "_FL.png")), Texture.TextureFilter.Nearest));
                    }
                }
                continue;
            }
            catch (GdxRuntimeException e) {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
            }
        }
    }

    public final void disposeFlags() {
        for (int i = 0; i < this.lFlags.size(); ++i) {
            this.lFlags.get(i).getTexture().dispose();
        }
        this.lFlags.clear();
    }
}

