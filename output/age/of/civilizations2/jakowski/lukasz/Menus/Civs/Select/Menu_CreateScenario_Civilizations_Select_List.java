/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Civs.Select;

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

public class Menu_CreateScenario_Civilizations_Select_List
extends Menu {
    public static List<String> civsTags = new ArrayList<String>();
    public static List<String> civsNames = new ArrayList<String>();
    private List<Image> lFlagsLoaded = new ArrayList<Image>();
    private List<Integer> loadedFlags_TagsIDs = new ArrayList<Integer>();
    public static List<String> allTags = new ArrayList<String>();
    public static List<String> allNames = new ArrayList<String>();

    public Menu_CreateScenario_Civilizations_Select_List() {
        int toAddID;
        int tID;
        int iSize;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (allTags.isEmpty()) {
            int i;
            int iSize2;
            allTags.clear();
            if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
                int i2;
                List<String> tempFiles = CFG.getFileNames_O_Classic("game/civilizations/");
                int iSize3 = tempFiles.size();
                for (i2 = 0; i2 < iSize3; ++i2) {
                    if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i2);
                    break;
                }
                iSize3 = tempFiles.size();
                for (i2 = 0; i2 < iSize3; ++i2) {
                    allTags.add(tempFiles.get(i2));
                }
            } else {
                String[] tagsSPLITED = null;
                FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
                iSize2 = tagsSPLITED.length;
                for (i = 0; i < iSize2; ++i) {
                    allTags.add(tagsSPLITED[i]);
                }
            }
            if (CFG.getIsDesktop()) {
                FileHandle[] files;
                try {
                    int i3;
                    for (i3 = 0; i3 < sUM.sUFS; ++i3) {
                        try {
                            files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i3) + "game/" + "civilizations/").list() : Gdx.files.internal(sUM.sUF.get(i3) + "game/" + "civilizations/").list();
                            for (FileHandle file : files) {
                                if (file.name().indexOf("Age_of_Civilizations") >= 0 || allTags.contains(file.name())) continue;
                                allTags.add(file.name());
                            }
                            continue;
                        }
                        catch (Exception tempT) {
                            // empty catch block
                        }
                    }
                    for (i3 = 0; i3 < sUM.sUIIS; ++i3) {
                        try {
                            for (FileHandle file : files = Gdx.files.absolute(sUM.sUII.get(i3).getFolder() + "/" + "game/" + "civilizations/").list()) {
                                if (file.name().indexOf("Age_of_Civilizations") >= 0 || allTags.contains(file.name())) continue;
                                allTags.add(file.name());
                            }
                            continue;
                        }
                        catch (Exception tempT) {
                            // empty catch block
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    int i4;
                    for (i4 = 0; i4 < sUM.sUFS; ++i4) {
                        try {
                            files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i4) + "game/" + "civilizations_editor/").list() : Gdx.files.internal(sUM.sUF.get(i4) + "game/" + "civilizations_editor/").list();
                            for (FileHandle file : files) {
                                if (file.name().indexOf("Age_of_Civilizations") >= 0 || allTags.contains(file.name())) continue;
                                allTags.add(file.name());
                            }
                            continue;
                        }
                        catch (Exception tempT) {
                            // empty catch block
                        }
                    }
                    for (i4 = 0; i4 < sUM.sUIIS; ++i4) {
                        try {
                            for (FileHandle file : files = Gdx.files.absolute(sUM.sUII.get(i4).getFolder() + "/" + "game/" + "civilizations_editor/").list()) {
                                if (file.name().indexOf("Age_of_Civilizations") >= 0 || allTags.contains(file.name())) continue;
                                allTags.add(file.name());
                            }
                            continue;
                        }
                        catch (Exception tempT) {
                            // empty catch block
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            try {
                String[] tagsSPLITED_ED = new String[]{};
                FileHandle tempFileT_ED = null;
                tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
                String tempT_ED = tempFileT_ED.readString();
                tagsSPLITED_ED = tempT_ED.split(";");
                iSize2 = tagsSPLITED_ED.length;
                for (i = 0; i < iSize2; ++i) {
                    if (allTags.contains(tagsSPLITED_ED[i])) continue;
                    allTags.add(tagsSPLITED_ED[i]);
                }
            }
            catch (GdxRuntimeException tagsSPLITED_ED) {
                // empty catch block
            }
        }
        try {
            if (allNames.isEmpty() || allNames.size() != allTags.size()) {
                allNames.clear();
                int iSize4 = allTags.size();
                for (int i = 0; i < iSize4; ++i) {
                    allNames.add(CFG.lang.getCiv(allTags.get(i)));
                }
            }
        }
        catch (Exception i) {
            // empty catch block
        }
        civsTags = new ArrayList<String>();
        civsNames = new ArrayList<String>();
        ArrayList<String> lTempNames = new ArrayList<String>();
        ArrayList<String> lTempTags = new ArrayList<String>();
        if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
            iSize = allTags.size();
            for (int i = 0; i < iSize; ++i) {
                if (allNames.get(i).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheCivGameTag(allTags.get(i))) continue;
                lTempNames.add(allNames.get(i));
                lTempTags.add(allTags.get(i));
            }
            CFG.menus.menuCreateScenario_SelectCivilizations_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            tID = 0;
            while (!lTempNames.isEmpty()) {
                toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear(civsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                civsTags.add((String)lTempTags.get(toAddID));
                civsNames.add((String)lTempNames.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EverySingleTimeRandomCiv")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            iSize = allTags.size();
            for (int i = 0; i < iSize; ++i) {
                if (CFG.isInTheCivGameTag(allTags.get(i))) continue;
                lTempNames.add(allNames.get(i));
                lTempTags.add(allTags.get(i));
            }
            CFG.menus.menuCreateScenario_SelectCivilizations_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            tID = 0;
            while (!lTempNames.isEmpty()) {
                toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear(civsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                civsTags.add((String)lTempTags.get(toAddID));
                civsNames.add((String)lTempNames.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else {
            iSize = allTags.size();
            for (int i = 0; i < iSize; ++i) {
                if (allNames.get(i).charAt(0) != CFG.chosenAlphabetCharachter.charAt(0) || CFG.isInTheCivGameTag(allTags.get(i))) continue;
                lTempNames.add(allNames.get(i));
                lTempTags.add(allTags.get(i));
            }
            CFG.menus.menuCreateScenario_SelectCivilizations_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            tID = 0;
            while (!lTempNames.isEmpty()) {
                toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)) + " [" + (String)lTempTags.get(toAddID) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear(civsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElemHover();
                        }
                    }
                });
                civsTags.add((String)lTempTags.get(toAddID));
                civsNames.add((String)lTempNames.get(toAddID));
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
        if (CFG.chosenAlphabetCharachter == null && CFG.sSearch == null) {
            this.getMenuElem(0).setTextE(CFG.lang.get("RandomCivilization"));
        }
    }

    @Override
    public void updateMenuElements_IsInView() {
        int tempRandomButton;
        super.updateMenuElements_IsInView();
        for (int i = tempRandomButton = CFG.chosenAlphabetCharachter == null && CFG.sSearch == null ? 1 : 0; i < this.getMenuElemsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(civsTags.get((i - tempRandomButton) / 2));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag((i - tempRandomButton) / 2);
                continue;
            }
            if (tempTagID < 0) continue;
            this.lFlagsLoaded.get(tempTagID).getTexture().dispose();
            this.lFlagsLoaded.set(tempTagID, null);
            this.lFlagsLoaded.remove(tempTagID);
            this.loadedFlags_TagsIDs.remove(tempTagID);
        }
    }

    private final int getIsLoaded(String nCivTag) {
        for (int i = 0; i < this.loadedFlags_TagsIDs.size(); ++i) {
            if (!civsTags.get(this.loadedFlags_TagsIDs.get(i)).equals(nCivTag)) continue;
            return i;
        }
        return -1;
    }

    private final int getFlagID(int nCivTagID) {
        for (int i = 0; i < this.loadedFlags_TagsIDs.size(); ++i) {
            if (this.loadedFlags_TagsIDs.get(i) != nCivTagID) continue;
            return i;
        }
        return 0;
    }

    private final void loadFlag(int nCivTagID) {
        block13: {
            try {
                try {
                    this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/flags/" + civsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException e) {
                    try {
                        try {
                            this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(civsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                        }
                        catch (Exception ex) {
                            try {
                                this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + civsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                            }
                            catch (Exception exr) {
                                this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(civsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                            }
                        }
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlagsLoaded.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + civsTags.get(nCivTagID) + "/" + civsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + civsTags.get(nCivTagID) + "/" + civsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            break block13;
                        }
                        this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + civsTags.get(nCivTagID) + "/" + civsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                    }
                }
            }
            catch (GdxRuntimeException e) {
                this.lFlagsLoaded.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
            }
        }
        this.loadedFlags_TagsIDs.add(nCivTagID);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempRandomButton = CFG.chosenAlphabetCharachter == null && CFG.sSearch == null ? 1 : 0;
        try {
            for (int i = tempRandomButton; i < this.getMenuElemsSize(); i += 2) {
                if (!this.getMenuElem(i).getIsInView()) continue;
                int posX = this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - IMGManager.getIMG(Images.flagRect2).getWidth() / 2 + iTranslateX;
                int posY = this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY;
                try {
                    oSB.setShader(Renderer.shaderAlpha);
                    try {
                        this.lFlagsLoaded.get(this.getFlagID((i - tempRandomButton) / 2)).getTexture().bind(1);
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
            // empty catch block
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.chosenAlphabetCharachter != null || CFG.sSearch != null) break;
                this.onBack();
                CFG.core.createScenarioAddCivilization("ran", CFG.core.getActiveProvID(), true);
                CFG.core.randomCivilizationColor(CFG.core.getCivsSize() - 1);
                int iRandomCivID = 1;
                for (int i = 1; i < CFG.core.getCivsSize() - 1; ++i) {
                    if (!CFG.core.getCiv(i).getCivTag().equals("ran")) continue;
                    ++iRandomCivID;
                }
                CFG.core.getCiv(CFG.core.getCivsSize() - 1).setCivName(CFG.core.getCiv(CFG.core.getCivsSize() - 1).getCivName() + " " + iRandomCivID);
                CFG.updateCreateScenario_Civilizations();
                CFG.core.enableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
                this.onBackPressed();
                return;
            }
        }
        if ((iID -= CFG.chosenAlphabetCharachter == null && CFG.sSearch == null ? 1 : 0) % 2 == 0) {
            this.onBack();
            CFG.core.createScenarioAddCivilization(civsTags.get(iID / 2), CFG.core.getActiveProvID(), true);
            CFG.chosenAlphabetCharachter = null;
            CFG.sSearch = null;
            CFG.updateCreateScenario_Civilizations();
            CFG.core.enableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
            this.onBackPressed();
        } else {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = civsTags.get(iID / 2);
            CFG.setDialogType(DialogType.GO_TO_WIKI);
        }
    }

    private final void onBack() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_CIVILIZATIONS);
        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
            CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
        }
    }

    @Override
    public void onBackPressed() {
        for (int i = 0; i < this.lFlagsLoaded.size(); ++i) {
            this.lFlagsLoaded.get(i).getTexture().dispose();
        }
        this.lFlagsLoaded.clear();
        this.loadedFlags_TagsIDs.clear();
        civsTags.clear();
        civsNames.clear();
    }
}

