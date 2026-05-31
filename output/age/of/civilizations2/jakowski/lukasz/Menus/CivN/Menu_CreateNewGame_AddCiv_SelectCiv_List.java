
package age.of.civilizations2.jakowski.lukasz.Menus.CivN;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
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
import age.of.civilizations2.jakowski.lukasz.Menus.CivN.Menu_CreateNewGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateNewGame_AddCiv_SelectCiv_List
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_CreateNewGame_AddCiv_SelectCiv_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        String[] tagsSPLITED_ED = new String[]{};
        try {
            FileHandle tempFileT_ED = null;
            tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
            String tempT_ED = tempFileT_ED.readString();
            tagsSPLITED_ED = tempT_ED.split(";");
        }
        catch (GdxRuntimeException tempFileT_ED) {
            
        }
        this.lCivsTags = new ArrayList<String>();
        ArrayList<String> lTempNames = new ArrayList<String>();
        ArrayList<String> lTempTags = new ArrayList<String>();
        if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
            int i;
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED[i]).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED[i])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED_ED[i]).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED_ED[i])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED_ED[i]));
                lTempTags.add(tagsSPLITED_ED[i]);
            }
            try {
                int i2;
                for (i2 = 0; i2 < sUM.sUFS; ++i2) {
                    FileHandle[] files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i2) + "game/" + "civilizations_editor/").list() : Gdx.files.internal(sUM.sUF.get(i2) + "game/" + "civilizations_editor/").list();
                    for (FileHandle file : files) {
                        if (file.name().indexOf("Age_of_Civilizations") >= 0 || CFG.lang.getCiv(file.name()).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame_OrIsFormableCiv(file.name())) continue;
                        lTempNames.add(CFG.lang.getCiv(file.name()));
                        lTempTags.add(file.name());
                    }
                }
                for (i2 = 0; i2 < sUM.sUIIS; ++i2) {
                    FileHandle[] files;
                    for (FileHandle file : files = Gdx.files.absolute(sUM.sUII.get(i2).getFolder() + "/" + "game/" + "civilizations_editor/").list()) {
                        if (file.name().indexOf("Age_of_Civilizations") >= 0 || CFG.lang.getCiv(file.name()).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame_OrIsFormableCiv(file.name())) continue;
                        lTempNames.add(CFG.lang.getCiv(file.name()));
                        lTempTags.add(file.name());
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            CFG.menus.menuNewGame_AddCiv_SelectCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i3 = 1; i3 < lTempNames.size(); ++i3) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i3))) continue;
                    toAddID = i3;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateNewGame_AddCiv_SelectCiv_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else if (CFG.chosenAlphabetCharachter == null) {
            int i;
            int i4;
            int iSize = tagsSPLITED.length;
            for (i4 = 0; i4 < iSize; ++i4) {
                if (CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED[i4])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i4]));
                lTempTags.add(tagsSPLITED[i4]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i4 = 0; i4 < iSize; ++i4) {
                if (CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED_ED[i4])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED_ED[i4]));
                lTempTags.add(tagsSPLITED_ED[i4]);
            }
            try {
                FileHandle file;
                int n;
                FileHandle[] toAddID;
                int i5;
                for (i5 = 0; i5 < sUM.sUFS; ++i5) {
                    FileHandle[] files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i5) + "game/" + "civilizations/").list() : Gdx.files.internal(sUM.sUF.get(i5) + "game/" + "civilizations/").list();
                    toAddID = files;
                    i = toAddID.length;
                    for (n = 0; n < i; ++n) {
                        file = toAddID[n];
                        if (file.name().indexOf("Age_of_Civilizations") >= 0 || CFG.isInTheGame_OrIsFormableCiv(file.name())) continue;
                        lTempNames.add(CFG.lang.getCiv(file.name()));
                        lTempTags.add(file.name());
                    }
                }
                for (i5 = 0; i5 < sUM.sUIIS; ++i5) {
                    FileHandle[] files;
                    toAddID = files = Gdx.files.absolute(sUM.sUII.get(i5).getFolder() + "/" + "game/" + "civilizations/").list();
                    i = toAddID.length;
                    for (n = 0; n < i; ++n) {
                        file = toAddID[n];
                        if (file.name().indexOf("Age_of_Civilizations") >= 0 || CFG.isInTheGame_OrIsFormableCiv(file.name())) continue;
                        lTempNames.add(CFG.lang.getCiv(file.name()));
                        lTempTags.add(file.name());
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            CFG.menus.menuNewGame_AddCiv_SelectCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateNewGame_AddCiv_SelectCiv_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else {
            int i;
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED[i]).charAt(0) != CFG.chosenAlphabetCharachter.charAt(0) || CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED[i])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.lang.getCiv(tagsSPLITED_ED[i]).charAt(0) != CFG.chosenAlphabetCharachter.charAt(0) || CFG.isInTheGame_OrIsFormableCiv(tagsSPLITED_ED[i])) continue;
                lTempNames.add(CFG.lang.getCiv(tagsSPLITED_ED[i]));
                lTempTags.add(tagsSPLITED_ED[i]);
            }
            CFG.menus.menuNewGame_AddCiv_SelectCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i6 = 1; i6 < lTempNames.size(); ++i6) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i6))) continue;
                    toAddID = i6;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateNewGame_AddCiv_SelectCiv_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.BUTTON_H - CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView();
        for (int i = 0; i < this.getMenuElemsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get(i / 2));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag(i / 2);
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
        block13: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException e) {
                    try {
                        try {
                            this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                        }
                        catch (Exception exr) {
                            try {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                            }
                            catch (Exception err) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                            }
                        }
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            break block13;
                        }
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                    }
                }
            }
            catch (GdxRuntimeException e) {
                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
            }
        }
        this.lLoadedFlags_TagsIDs.add(nCivTagID);
    }

    
    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            for (int i = 0; i < this.getMenuElemsSize(); i += 2) {
                if (!this.getMenuElem(i).getIsInView()) continue;
                int posX = this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - IMGManager.getIMG(Images.flagRect2).getWidth() / 2 + iTranslateX;
                int posY = this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY;
                try {
                    oSB.setShader(Renderer.shaderAlpha);
                    try {
                        this.lFlags.get(this.getFlagID(i / 2)).getTexture().bind(1);
                    }
                    catch (Exception ex) {
                        IMGManager.getIMG(Images.randomCivilizationFlag).getTexture().bind(1);
                    }
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagRect2Mask).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight());
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    continue;
                }
                finally {
                    oSB.flush();
                    oSB.setShader(AoCGame.shaderDef);
                    IMGManager.getIMG(Images.flagRect2).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2).getWidth(), IMGManager.getIMG(Images.flagRect2).getHeight());
                }
            }
        }
        catch (Exception exception) {
            
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID % 2 == 0) {
            Menu_CreateNewGame_AddCiv.setCivTag(this.lCivsTags.get(iID / 2));
            this.onBack();
            CFG.chosenAlphabetCharachter = null;
            CFG.sSearch = null;
            this.onBackPressed();
        } else {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lCivsTags.get(iID / 2);
            CFG.setDialogType(DialogType.GO_TO_WIKI);
        }
    }

    private final void onBack() {
        CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
        CFG.map.getMpB().updateWorldMap_Shaders();
    }

    @Override
    public void onBackPressed() {
        for (int i = 0; i < this.lFlags.size(); ++i) {
            this.lFlags.get(i).getTexture().dispose();
        }
        this.lFlags.clear();
        this.lLoadedFlags_TagsIDs.clear();
        this.lCivsTags.clear();
    }
}

