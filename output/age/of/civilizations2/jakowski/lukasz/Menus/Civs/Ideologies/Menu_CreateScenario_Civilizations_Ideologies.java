/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Civs.Ideologies;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Ideology;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Civilizations_Ideologies
extends Menu {
    private String sCivsTag;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();
    public static int ACTIVE_GOV_TYPE_ID = -1;

    public Menu_CreateScenario_Civilizations_Ideologies() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID() == CFG.core.getActiveProvID() && !CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag().equals("ran")) {
            try {
                this.sCivsTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag());
                if (ACTIVE_GOV_TYPE_ID >= 0) {
                    for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)i).GOV_GROUP_ID != ACTIVE_GOV_TYPE_ID) continue;
                        menuElements.add(new Button_Game_Ideology(i + 1 + ". " + CFG.lang.getCiv(this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(i).getExtraTag()), i, -1, CFG.GAMEWIDTH + CFG.PADD, CFG.PADD, CFG.BUTTON_W, CFG.core.isCivTagAvailable(this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(i).getExtraTag())){

                            @Override
                            public void actionElemPPM() {
                                ACTIVE_GOV_TYPE_ID = -1;
                                CFG.menus.rebuildCreateScenario_Civilizations_Ideologies();
                            }

                            @Override
                            public void buildElemHover() {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RightClickAction"), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.administration, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        });
                    }
                } else {
                    for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
                        menuElements.add(new Button_Game_Ideology(i + 1 + ". " + CFG.lang.getCiv(this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(i).getExtraTag()), i, -1, CFG.GAMEWIDTH + CFG.PADD, CFG.PADD, CFG.BUTTON_W, CFG.core.isCivTagAvailable(this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(i).getExtraTag())){

                            @Override
                            public void actionElemPPM() {
                                ACTIVE_GOV_TYPE_ID = CFG.ideologiesMgr.getIdeologyID((int)this.getCurr()).GOV_GROUP_ID;
                                CFG.menus.rebuildCreateScenario_Civilizations_Ideologies();
                            }

                            @Override
                            public void buildElemHover() {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RightClickAction"), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.administration, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        });
                    }
                }
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                // empty catch block
            }
        }
        ACTIVE_GOV_TYPE_ID = -1;
        this.initMenu(null, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2 + 1, menuElements);
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
        this.updateMenuElements_IsInView();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView_X();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            int tempTagID = this.getIsLoaded(this.getMenuElem(i).getCurr());
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag(this.getMenuElem(i).getCurr());
                continue;
            }
            if (tempTagID < 0) continue;
            this.lFlags.get(tempTagID).getTexture().dispose();
            this.lFlags.set(tempTagID, null);
            this.lFlags.remove(tempTagID);
            this.lLoadedFlags_TagsIDs.remove(tempTagID);
        }
    }

    private final int getIsLoaded(int nCivTag) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (this.lLoadedFlags_TagsIDs.get(i) != nCivTag) continue;
            return i;
        }
        return -1;
    }

    private final void loadFlag(int nCivTagID) {
        block14: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(nCivTagID).getExtraTag() + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException ex) {
                    boolean isDone = false;
                    if (CFG.ideologiesMgr.getIdeologyID((int)nCivTagID).REVOLUTIONARY) {
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/rb" + this.sCivsTag.charAt(0) % 6 + ".png")), Texture.TextureFilter.Nearest));
                        isDone = true;
                    }
                    if (isDone) break block14;
                    try {
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.sCivsTag + ".png")), Texture.TextureFilter.Nearest));
                    }
                    catch (GdxRuntimeException exr) {
                        try {
                            this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(nCivTagID).getExtraTag() + ".png")), Texture.TextureFilter.Nearest));
                            isDone = true;
                        }
                        catch (Exception exrw) {
                            try {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.sCivsTag + ".png")), Texture.TextureFilter.Nearest));
                                isDone = true;
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        if (isDone) break block14;
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.sCivsTag + "/" + this.sCivsTag + "_FL.png")), Texture.TextureFilter.Linear));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.sCivsTag + "/" + this.sCivsTag + "_FL.png")), Texture.TextureFilter.Linear));
                            }
                            break block14;
                        }
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.sCivsTag + "/" + this.sCivsTag + "_FL.png")), Texture.TextureFilter.Linear));
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
            }
        }
        this.lLoadedFlags_TagsIDs.add(nCivTagID);
    }

    private final int getFlagID(int nCivTagID) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (this.lLoadedFlags_TagsIDs.get(i) != nCivTagID) continue;
            return i;
        }
        return 0;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((CFG.fMOVE_MENU_PERCENTAGE += (float)(System.currentTimeMillis() - CFG.lMOVE_MENU_TIME) / 225.0f * 95.0f) > 100.0f) {
            CFG.fMOVE_MENU_PERCENTAGE = 100.0f;
        } else {
            CFG.setRenderO(true);
        }
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        Rectangle clipBounds = new Rectangle(this.getPosX() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightM(), this.getWidthM(), this.getHeightM());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        if (this.getMenuElemsSize() > 0) {
            CFG.drawEditorButtons_Top_Edge_R(oSB, iTranslateX, this.getMenuPosY() - (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE() + CFG.PADD, CFG.BUTTON_H + CFG.PADD * 2);
        }
        super.drawMenuM(oSB, iTranslateX, iTranslateY += -((int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f)), sliderMenuIsActive);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            if (!this.getMenuElem(i).getIsInView()) continue;
            this.lFlags.get(this.getFlagID(i)).drawO(oSB, this.getMenuElem(i).getPosXE() + (this.getMenuElem(i).getWidthE() - (this.getMenuElem(i).getTextPosElem() + CFG.PADD + CFG.CIV_FLAG_WIDTH)) / 2 + this.getMenuPosX() + iTranslateX, this.getMenuElem(i).getPosY() - this.lFlags.get(this.getFlagID(i)).getHeight() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.PADD / 2 - this.getMenuElem(i).getTextHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(i).getPosXE() + (this.getMenuElem(i).getWidthE() - (this.getMenuElem(i).getTextPosElem() + CFG.PADD + CFG.CIV_FLAG_WIDTH)) / 2 + this.getMenuPosX() + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.PADD / 2 - this.getMenuElem(i).getTextHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            CFG.core.updateCivilizationIdeology(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), this.sCivsTag + CFG.ideologiesMgr.getIdeologyID(this.getMenuElem(iID).getCurr()).getExtraTag());
        }
        this.setVisibleM(false);
        CFG.updateCreateScenario_Civilizations();
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (!visible) {
            try {
                for (int i = 0; i < this.lFlags.size(); ++i) {
                    this.lFlags.get(i).getTexture().dispose();
                }
                this.lFlags.clear();
                this.lLoadedFlags_TagsIDs.clear();
                this.sCivsTag = null;
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
        super.setVisibleM(visible);
    }
}

