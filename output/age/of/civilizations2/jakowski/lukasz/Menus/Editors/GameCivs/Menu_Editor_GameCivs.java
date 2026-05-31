/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
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
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Editor_GameCivs
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_Editor_GameCivs() {
        int nPosY;
        int i;
        this.lCivsTags = new ArrayList<String>();
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        String[] tagsSPLITED = null;
        if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
            int i2;
            List<String> tempFiles = CFG.getFileNames_O("game/civilizations/");
            int iSize = tempFiles.size();
            for (i2 = 0; i2 < iSize; ++i2) {
                if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                tempFiles.remove(i2);
                break;
            }
            tagsSPLITED = new String[tempFiles.size()];
            iSize = tempFiles.size();
            for (i2 = 0; i2 < iSize; ++i2) {
                tagsSPLITED[i2] = tempFiles.get(i2);
            }
        } else {
            FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            tagsSPLITED = tempT.split(";");
        }
        ArrayList<String> lTempNames = new ArrayList<String>();
        ArrayList<String> lTempTags = new ArrayList<String>();
        if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED[i]).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            nPosY = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i3 = 1; i3 < lTempNames.size(); ++i3) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i3))) continue;
                    toAddID = i3;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", 50, 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else if (CFG.chosenAlphabetCharachter == null) {
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            nPosY = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i4 = 1; i4 < lTempNames.size(); ++i4) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i4))) continue;
                    toAddID = i4;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", 50, 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else {
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED[i]).charAt(0) != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            nPosY = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i5 = 1; i5 < lTempNames.size(); ++i5) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i5))) continue;
                    toAddID = i5;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", 50, 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD - (CFG.BUTTON_H + CFG.PADD * 2), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddCivilization"));
    }

    @Override
    public void updateMenuElements_IsInView() {
        int tempRandomButton;
        super.updateMenuElements_IsInView();
        for (int i = tempRandomButton = 1; i < this.getMenuElemsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get((i - tempRandomButton) / 2));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag((i - tempRandomButton) / 2);
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
            try {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
            }
            catch (GdxRuntimeException e) {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
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
        int tempRandomButton = 1;
        try {
            for (int i = tempRandomButton; i < this.getMenuElemsSize(); i += 2) {
                if (!this.getMenuElem(i).getIsInView()) continue;
                this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.editorCivilization_GameData = new Civilization_GameData3();
                CFG.menus.setMenuID(View.eEDITOR_GAME_CIVS_EDIT);
                RenderProvince.updateDrawProvinces();
                CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 3 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 8);
                return;
            }
        }
        if (iID % 2 == 1) {
            String tempCivTag = this.lCivsTags.get((iID - 1) / 2);
            FileHandle file = FileManager.loadFile("game/civilizations/" + tempCivTag);
            try {
                CFG.editorCivilization_GameData = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                CFG.menus.setMenuID(View.eEDITOR_GAME_CIVS_EDIT);
                RenderProvince.updateDrawProvinces();
                CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 3 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 8);
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IOException iOException) {}
        } else {
            String tempCivTag = this.lCivsTags.get((iID - 1) / 2);
            try {
                FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + tempCivTag);
                String sLine = readFile.readString();
                Gdx.net.openURI("https://en.wikipedia.org/wiki/" + sLine);
            }
            catch (GdxRuntimeException ex) {
                FileHandle fileSave = FileManager.getSaveType("game/civilizations_informations/" + tempCivTag);
                fileSave.writeString("" + this.getMenuElem(iID - 1).getTextE().substring(this.getMenuElem(iID - 1).getTextE().indexOf(45) + 2, this.getMenuElem(iID - 1).getTextE().length()).replace(' ', '_'), false);
                Gdx.net.openURI("https://en.wikipedia.org/wiki/" + this.getMenuElem(iID - 1).getTextE().substring(this.getMenuElem(iID - 1).getTextE().indexOf(45) + 2, this.getMenuElem(iID - 1).getTextE().length()).replace(' ', '_'));
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eEDITOR);
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

