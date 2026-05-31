/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Gor;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Scenario;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario_Title;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Legacy;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Menu_ChooseScenario
extends Menu {
    private List<List<Image>> lFlags = new ArrayList<List<Image>>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();
    public static List<Image> preview = new ArrayList<Image>();
    public static int previewW = 1;
    public static int previewH = 1;
    public static boolean UCSH = true;
    public static int iFHR = -1;

    public static void loadPreview() {
        Menu_ChooseScenario.disposePreview();
        int i = 0;
        while (true) {
            block18: {
                CFG.core.getGameScenars();
                if (i >= Game_Scenarios.SCENARIOS_SIZE) break;
                    String basePath = "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(i) + "/";
                    boolean added = false;
                    if (CFG.core.getGameScenars().getScenarioIsInternal(i)) {
                        String[] tryFiles = new String[]{"previewSpecial.png", "preview.png"};
                        for (String fn : tryFiles) {
                            try {
                                FileHandle fh = FileManager.loadFile(basePath + fn);
                                if (fh.exists()) {
                                    preview.add(new Image(new Texture(fh), Texture.TextureFilter.Linear));
                                    added = true;
                                    break;
                                }
                            } catch (Exception ignored) {}
                        }
                        if (!added) { preview.add(new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png")), Texture.TextureFilter.Linear)); added = true; }
                        break block18;
                    }
                    String[] tryFiles = new String[]{"previewSpecial.png", "preview.png"};
                    for (String fn : tryFiles) {
                        try {
                            FileHandle fh = Gdx.files.local(basePath + fn);
                            if (fh.exists()) {
                                preview.add(new Image(new Texture(fh), Texture.TextureFilter.Linear));
                                added = true;
                                break;
                            }
                        } catch (Exception ignored) {}
                    }
                    if (!added) {
                        for (String fn : tryFiles) {
                            try {
                                FileHandle fh = FileManager.loadFile(basePath + fn);
                                if (fh.exists()) {
                                    preview.add(new Image(new Texture(fh), Texture.TextureFilter.Linear));
                                    added = true;
                                    break;
                                }
                            } catch (Exception ignored) {}
                        }
                    }
                    if (!added) {
                        try {
                            preview.add(new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png")), Texture.TextureFilter.Linear));
                        } catch (Exception ignored) {}
                    }
            }
            ++i;
        }
        try {
            if (!preview.isEmpty()) {
                previewH = CFG.BUTTON_H - 2;
                previewW = (int)((float)preview.get(0).getWidth() * ((float)previewH / (float)preview.get(0).getHeight()));
            } else {
                previewW = 1;
                previewH = 1;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void disposePreview() {
        for (int i = 0; i < preview.size(); ++i) {
            if (preview.get(i) == null) continue;
            preview.get(i).getTexture().dispose();
        }
        preview.clear();
    }

    public Menu_ChooseScenario() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.map.getFile_ActiveMap_Path2().equals("Earth14K") || CFG.map.getFile_ActiveMap_Path2().equals("Earth")) {
            menuElements.add(new Button_Classic_ReflectedBG(null, -1, 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        } else {
            menuElements.add(new Button_Gor(this.getSU(), null, -1, 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        }
        try {
            Menu_ChooseScenario.loadPreview();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
            try {
                menuElements.add(new Button_Classic_Scenario(i, null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - AoCGame.LEFT - CFG.BUTTON_W, CFG.BUTTON_H, true, Menu_ChooseScenario_Title.iPreviewScenarioID == i){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getGameScenars().getScenarioDay(this.getCurr()) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(this.getCurr())) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(this.getCurr())).getName()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            try {
                                if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").exists()) {
                                    String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").readString();
                                    String[] splited = tText.split(";");
                                    String fullText = "";
                                    for (int q = 0; q < splited.length; ++q) {
                                        fullText = fullText + CFG.lang.get(splited[q]) + " ";
                                    }
                                    if (fullText != null && fullText.length() > 0) {
                                        nData.add(new ME_Hover_2Type_Space());
                                        nElements.add(new MEHover_2E(nData));
                                        nData.clear();
                                        nData.add(new ME_Hover_2Type_TextDesc(fullText, CFG.FONT_REGULAR_SMALL));
                                        nElements.add(new MEHover_2E(nData));
                                        nData.clear();
                                    }
                                }
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            this.menuElemHover = null;
                        }
                    }

                    @Override
                    public boolean getCheckboxSt() {
                        return this.getCurr() == Menu_ChooseScenario_Title.iPreviewScenarioID;
                    }
                });
                menuElements.add(new Button_Classic_Classic_Wiki(i, CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.BUTTON_W, CFG.BUTTON_H, CFG.core.getGameScenars().getScenarioWiki(i).length() > 0){

                    @Override
                    public void buildElemHover() {
                        if (this.getIsClickable()) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getGameScenars().getScenarioWiki(this.getCurr())));
                            nData.add(new ME_Hover_2Type_Image(Images.wikipedia, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            this.menuElemHover = null;
                        }
                    }
                });
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H * 3 + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H * 3 - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("RandomScenario"));
        for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
            this.getMenuElem(i * 2 + 1).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(i)));
            this.getMenuElem(i * 2 + 1).setCurr(i);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            for (int i = 1; i < this.getMenuElemsSize(); i += 2) {
                if (!this.getMenuElem(i).getIsInView()) continue;
                int nFlagsID = this.getFlagID((i - 1) / 2);
                for (int j = this.lFlags.get(nFlagsID).size() - 1; j >= 0; --j) {
                    int posX = this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() * 2 - IMGManager.getIMG(Images.flagRect2).getWidth() * 4 / 5 * (j - 1) - CFG.PADD + iTranslateX;
                    int posY = this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY;
                    oSB.setShader(Renderer.shaderAlpha);
                    this.lFlags.get(nFlagsID).get(j).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagRect2Mask).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight());
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
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView();
        for (int i = 1; i < this.getMenuElemsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(CFG.core.getGameScenars().getScenarioTagID((i - 1) / 2));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag((i - 1) / 2);
                continue;
            }
            if (tempTagID < 0) continue;
            int j = 0;
            while (j < this.lFlags.get(tempTagID).size()) {
                this.lFlags.get(tempTagID).get(j).getTexture().dispose();
                this.lFlags.get(tempTagID).set(j, null);
                this.lFlags.get(tempTagID).remove(j);
            }
            this.lFlags.remove(tempTagID);
            this.lLoadedFlags_TagsIDs.remove(tempTagID);
        }
    }

    private final int getIsLoaded(String nTag) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (!CFG.core.getGameScenars().getScenarioTagID(this.lLoadedFlags_TagsIDs.get(i)).equals(nTag)) continue;
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

    private final void loadFlag(int nTag) {
        this.lFlags.add(new ArrayList());
        try {
            Scenario_GameData tempScenarioGameData;
            block23: {
                try {
                    FileHandle file;
                    if (CFG.core.getGameScenars().getScenarioIsInternal(nTag)) {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(nTag) + "/" + CFG.core.getGameScenars().getScenarioTagID(nTag));
                        try {
                            tempScenarioGameData = (Scenario_GameData)CFG.deserialize(file.readBytes());
                        } catch (Exception _ex1) {
                            tempScenarioGameData = ((Scenario_GameData_Legacy)CFG.deserializeLegacyScenario(file.readBytes())).convertToNew();
                        }
                        break block23;
                    }
                    try {
                        file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(nTag) + "/" + CFG.core.getGameScenars().getScenarioTagID(nTag));
                    }
                    catch (Exception ex) {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(nTag) + "/" + CFG.core.getGameScenars().getScenarioTagID(nTag));
                    }
                    try {
                        tempScenarioGameData = (Scenario_GameData)CFG.deserialize(file.readBytes());
                    } catch (Exception _ex1) {
                        tempScenarioGameData = ((Scenario_GameData_Legacy)CFG.deserializeLegacyScenario(file.readBytes())).convertToNew();
                    }
                }
                catch (GdxRuntimeException ex) {
                    FileHandle file;
                    try {
                        file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(0) + "/" + CFG.core.getGameScenars().getScenarioTagID(0));
                    }
                    catch (Exception exr) {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(0) + "/" + CFG.core.getGameScenars().getScenarioTagID(0));
                    }
                    try {
                        tempScenarioGameData = (Scenario_GameData)CFG.deserialize(file.readBytes());
                    } catch (Exception _ex1) {
                        tempScenarioGameData = ((Scenario_GameData_Legacy)CFG.deserializeLegacyScenario(file.readBytes())).convertToNew();
                    }
                }
            }
            for (int i = 0; i < tempScenarioGameData.getCivSize() && i < 10; ++i) {
                try {
                    try {
                        this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/flags/" + tempScenarioGameData.getCivTag(i) + ".png")), Texture.TextureFilter.Nearest));
                    }
                    catch (GdxRuntimeException ex) {
                        try {
                            try {
                                this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + ".png")), Texture.TextureFilter.Nearest));
                            }
                            catch (Exception exr) {
                                try {
                                    this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + tempScenarioGameData.getCivTag(i) + ".png"))));
                                }
                                catch (Exception exz) {
                                    this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + ".png"))));
                                }
                            }
                        }
                        catch (GdxRuntimeException exr) {
                            if (CFG.isAndroid()) {
                                try {
                                    this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                                }
                                catch (GdxRuntimeException erq) {
                                    this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                                }
                                continue;
                            }
                            this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "/" + CFG.ideologiesMgr.getRealTag(tempScenarioGameData.getCivTag(i)) + "_FL.png")), Texture.TextureFilter.Nearest));
                        }
                    }
                    continue;
                }
                catch (GdxRuntimeException e) {
                    this.lFlags.get(this.lFlags.size() - 1).add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest));
                }
            }
            Object var2_5 = null;
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.lLoadedFlags_TagsIDs.add(nTag);
    }

    public String getSU() {
        int key = 5;
        char[] data = new char[]{'D', 'b', '`', '%', 'j', 'c', '%', 'M', 'l', 'v', 'q', 'j', 'w', '|', '%', '7', '?', '%', 'A', '`', 'c', 'l', 'k', 'l', 'q', 'l', 's', '`', '%', '@', 'a', 'l', 'q', 'l', 'j', 'k'};
        StringBuilder sb = new StringBuilder();
        for (char c : data) {
            sb.append((char)(c ^ key));
        }
        return sb.toString();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Random oR = new Random();
                if (Game_Scenarios.SCENARIOS_SIZE > 1) {
                    int nScenarioID;
                    while ((nScenarioID = oR.nextInt(Game_Scenarios.SCENARIOS_SIZE)) == CFG.core.getScenarioID()) {
                    }
                    CFG.core.setScenarioID(nScenarioID);
                }
                CFG.mapModesManager.disableAllViews();
                Menu_LoadScenario.editor = false;
                Menu_LoadScenario.goToView = null;
                Menu_LoadScenario.loadActionEND = 3;
                CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                break;
            }
            default: {
                if ((iID - 1) % 2 == 0) {
                    try {
                        this.getMenuElem(Menu_ChooseScenario_Title.iPreviewScenarioID * 2 + 1).setCheckboxSt(false);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        // empty catch block
                    }
                    Menu_ChooseScenario_Title.loadPreview((iID - 1) / 2);
                    try {
                        this.getMenuElem(Menu_ChooseScenario_Title.iPreviewScenarioID * 2 + 1).setCheckboxSt(true);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                    break;
                }
                if (CFG.core.getGameScenars().getScenarioWiki((iID - 1) / 2).length() > 0) {
                    CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.core.getGameScenars().getScenarioWiki((iID - 1) / 2);
                    CFG.setDialogType(DialogType.GO_TO_WIKI_SCENARIO);
                    break;
                }
                CFG.toastM.addM(CFG.lang.get("NoData"), CFG.COLOR_NEGATIVE_2);
            }
        }
    }

    @Override
    public void onBackPressed() {
        for (int j = 0; j < this.lFlags.size(); ++j) {
            for (int i = 0; i < this.lFlags.get(j).size(); ++i) {
                this.lFlags.get(j).get(i).getTexture().dispose();
            }
        }
        this.lFlags.clear();
        this.lLoadedFlags_TagsIDs.clear();
        Menu_ChooseScenario.disposePreview();
    }
}

