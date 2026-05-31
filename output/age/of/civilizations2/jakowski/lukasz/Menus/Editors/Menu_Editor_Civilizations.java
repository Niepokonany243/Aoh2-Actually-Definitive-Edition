
package age.of.civilizations2.jakowski.lukasz.Menus.Editors;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Editor_Civilizations
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_Editor_Civilizations() {
        this.lCivsTags = new ArrayList<String>();
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0 + AoCGame.LEFT, 0, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        try {
            FileHandle tempFileT = null;
            tempFileT = CFG.readLocalFiles() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            int iSize = tagsSPLITED.length;
            for (int i = 0; i < iSize; ++i) {
                try {
                    FileHandle file;
                    if (CFG.readLocalFiles()) {
                        try {
                            file = Gdx.files.local("game/civilizations_editor/" + tagsSPLITED[i] + "/" + tagsSPLITED[i] + "_NM");
                            menuElements.add(new Button_Classic(file.readString(), (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
                        }
                        catch (GdxRuntimeException eq) {
                            FileHandle file2 = FileManager.loadFile("game/civilizations_editor/" + tagsSPLITED[i] + "/" + tagsSPLITED[i] + "_NM");
                            menuElements.add(new Button_Classic(file2.readString(), (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
                        }
                    } else {
                        file = FileManager.loadFile("game/civilizations_editor/" + tagsSPLITED[i] + "/" + tagsSPLITED[i] + "_NM");
                        menuElements.add(new Button_Classic(file.readString(), (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
                    }
                    this.lCivsTags.add(tagsSPLITED[i]);
                    continue;
                }
                catch (GdxRuntimeException e) {
                    menuElements.add(new Button_Classic(tagsSPLITED[i], (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
                    this.lCivsTags.add(tagsSPLITED[i]);
                }
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewCivilization"));
        this.getTitleM().setText(CFG.lang.get("CivilizationEditor") + " - Age of History 2: Definitive Edition");
    }

    @Override
    public void updateMenuElements_IsInView() {
        int tempRandomButton;
        super.updateMenuElements_IsInView();
        for (int i = tempRandomButton = 2; i < this.getMenuElemsSize(); ++i) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get(i - tempRandomButton));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag(i - tempRandomButton);
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

    private final int getFlagID(int nCivTagID) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (this.lLoadedFlags_TagsIDs.get(i) != nCivTagID) continue;
            return i;
        }
        return 0;
    }

    private final void loadFlag(int nCivTagID) {
        try {
            if (CFG.readLocalFiles()) {
                try {
                    this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException erq) {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                }
            } else {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
            }
        }
        catch (GdxRuntimeException e) {
            this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
        }
        this.lLoadedFlags_TagsIDs.add(nCivTagID);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempRandomButton = 2;
        try {
            for (int i = tempRandomButton; i < this.getMenuElemsSize(); ++i) {
                if (!this.getMenuElem(i).getIsInView()) continue;
                this.lFlags.get(this.getFlagID(i - tempRandomButton)).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() - this.lFlags.get(this.getFlagID(i - tempRandomButton)).getHeight() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.backToMenu = View.eEDITOR_CIVILIZATIONS;
                CFG.menus.getColorPicker().setPosX(CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4 + CFG.PADD * 4);
                CFG.flagManager.loadData();
                CFG.flagManager.initFlagEdit();
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editorCivilization_GameData = new Civilization_GameData3();
                CFG.menus.setMenuID(View.eCREATE_CIVILIZATION);
                RenderProvince.updateDrawProvinces();
                return;
            }
        }
        CFG.backToMenu = View.eEDITOR_CIVILIZATIONS;
        CFG.menus.getColorPicker().setPosX(CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4 + CFG.PADD * 4);
        CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lCivsTags.get(iID - 2);
        CFG.flagManager.loadData();
        CFG.flagManager.loadFlagEdit();
        CFG.menus.setMenuID(View.eCREATE_CIVILIZATION);
        RenderProvince.updateDrawProvinces();
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eEDITOR);
        CFG.menus.setBackAnimation(true);
        this.disposeData();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            this.disposeData();
        }
    }

    public void disposeData() {
        for (int i = 0; i < this.lFlags.size(); ++i) {
            this.lFlags.get(i).getTexture().dispose();
        }
        this.lFlags.clear();
        this.lLoadedFlags_TagsIDs.clear();
        this.lCivsTags.clear();
    }
}

