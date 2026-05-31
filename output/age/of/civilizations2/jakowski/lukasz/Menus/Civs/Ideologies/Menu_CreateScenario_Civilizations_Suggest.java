/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Civs.Ideologies;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Civilizations_Suggest
extends Menu {
    private List<String> lCivsTags;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_CreateScenario_Civilizations_Suggest() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivsTags = new ArrayList<String>();
        try {
            int activeProvinceID = CFG.core.getActiveProvID();
            if (activeProvinceID >= 0) {
                this.addSuggestedOwners(menuElements, activeProvinceID);
                this.addCurrentOwnerProvinceSuggestions(menuElements, activeProvinceID);
                this.addNeighborProvinceSuggestions(menuElements, activeProvinceID);
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        this.initMenu(null, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2 + 1, menuElements);
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
        this.updateMenuElements_IsInView();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    private final void addSuggestedOwners(ArrayList<MenuElemUI> menuElements, int provinceID) {
        try {
            FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/" + provinceID);
            String sOwners = file.readString();
            String[] sRes = sOwners.split(";");
            for (int i = 0; i < sRes.length && this.lCivsTags.size() < 64; i += 2) {
                this.addSuggestedOwner(menuElements, sRes[i]);
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
    }

    private final void addCurrentOwnerProvinceSuggestions(ArrayList<MenuElemUI> menuElements, int provinceID) {
        try {
            int civID = CFG.core.getProv(provinceID).getCivId();
            if (civID <= 0) {
                return;
            }
            for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs() && this.lCivsTags.size() < 64; ++i) {
                this.addSuggestedOwners(menuElements, CFG.core.getCiv(civID).getProvID(i));
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
    }

    private final void addNeighborProvinceSuggestions(ArrayList<MenuElemUI> menuElements, int provinceID) {
        try {
            for (int i = 0; i < CFG.core.getProv(provinceID).getNeighProvincesSize() && this.lCivsTags.size() < 64; ++i) {
                int neighID = CFG.core.getProv(provinceID).getNeighProvinces(i);
                this.addSuggestedOwners(menuElements, neighID);
                for (int j = 0; j < CFG.core.getProv(neighID).getNeighProvincesSize() && this.lCivsTags.size() < 64; ++j) {
                    this.addSuggestedOwners(menuElements, CFG.core.getProv(neighID).getNeighProvinces(j));
                }
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
    }

    private final void addSuggestedOwner(ArrayList<MenuElemUI> menuElements, String civTag) {
        if (!this.canAddSuggestedOwner(civTag)) {
            return;
        }
        menuElements.add(new Button_Game("" + CFG.lang.getCiv(civTag), -1, CFG.GAMEWIDTH + CFG.PADD, CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX + CFG.PADD + CFG.CIV_FLAG_WIDTH, iTranslateY, isActive);
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AddCivilization") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.lCivsTags.add(civTag);
    }

    private final boolean canAddSuggestedOwner(String civTag) {
        if (civTag == null || civTag.length() == 0) {
            return false;
        }
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (!CFG.core.getCiv(i).getCivTag().equals(civTag)) continue;
            return false;
        }
        for (int i = 0; i < this.lCivsTags.size(); ++i) {
            if (!this.lCivsTags.get(i).equals(civTag)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView_X();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get(i));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag(i);
                continue;
            }
            if (tempTagID < 0) continue;
            this.lFlags.get(tempTagID).getTexture().dispose();
            this.lFlags.set(tempTagID, null);
            this.lFlags.remove(tempTagID);
            this.lLoadedFlags_TagsIDs.remove(tempTagID);
        }
    }

    private final int getIsLoaded(String nCivTag) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (!this.lCivsTags.get(this.lLoadedFlags_TagsIDs.get(i)).equals(nCivTag)) continue;
            return i;
        }
        return -1;
    }

    private final void loadFlag(int nCivTagID) {
        block11: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException ex) {
                    try {
                        try {
                            this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                        }
                        catch (Exception exr) {
                            try {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                            }
                            catch (Exception er) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                            }
                        }
                    }
                    catch (GdxRuntimeException exr) {
                        if (CFG.isAndroid()) {
                            this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Linear));
                            break block11;
                        }
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Linear));
                    }
                }
            }
            catch (GdxRuntimeException e) {
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
            this.lFlags.get(this.getFlagID(i)).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + this.getMenuPosX() + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - this.lFlags.get(this.getFlagID(i)).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + this.getMenuPosX() + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
        }
        CFG.core.createScenarioAddCivilization(this.lCivsTags.get(iID), CFG.core.getActiveProvID(), true);
        CFG.core.enableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
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
                this.lCivsTags.clear();
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
        super.setVisibleM(visible);
    }
}

