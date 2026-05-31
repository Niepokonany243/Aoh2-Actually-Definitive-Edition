
package age.of.civilizations2.jakowski.lukasz.Menus.Leaders;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Leader_GameData;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Leaders.Menu_CreateScenario_Leaders;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Leaders_Options
extends Menu {
    private List<String> lTags;
    private List<String> lCivsTags;
    private List<Image> lFlags;
    private List<Integer> lLoadedFlags_TagsIDs;

    public Menu_CreateScenario_Leaders_Options() {
        ArrayList<MenuElemUI> menuElements;
        block32: {
            this.lTags = null;
            this.lCivsTags = null;
            this.lFlags = new ArrayList<Image>();
            this.lLoadedFlags_TagsIDs = new ArrayList<Integer>();
            this.lCivsTags = new ArrayList<String>();
            this.lTags = new ArrayList<String>();
            menuElements = new ArrayList<MenuElemUI>();
            menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
            try {
                String[] tagsSPLITED = null;
                if (CFG.getIsDesktop()) {
                    int i;
                    List<String> tempFiles = CFG.getFileNames_O("game/leaders/");
                    int iSize = tempFiles.size();
                    for (i = 0; i < iSize; ++i) {
                        if (!tempFiles.get(i).equals("Age_of_Civilizations")) continue;
                        tempFiles.remove(i);
                        break;
                    }
                    tagsSPLITED = new String[tempFiles.size()];
                    iSize = tempFiles.size();
                    for (i = 0; i < iSize; ++i) {
                        tagsSPLITED[i] = tempFiles.get(i);
                    }
                } else {
                    FileHandle tempFileT = FileManager.loadFile("game/leaders/Age_of_Civilizations");
                    String tempT = tempFileT.readString();
                    tagsSPLITED = tempT.split(";");
                }
                ArrayList<String> lTempNames = new ArrayList<String>();
                ArrayList<String> lTempTags = new ArrayList<String>();
                ArrayList<String> lTempCivsTags = new ArrayList<String>();
                if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
                    int iSize = tagsSPLITED.length;
                    for (int i = 0; i < iSize; ++i) {
                        try {
                            FileHandle file;
                            try {
                                file = Gdx.files.local("game/leaders/" + tagsSPLITED[i]);
                                CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                            }
                            catch (GdxRuntimeException ex) {
                                file = FileManager.loadFile("game/leaders/" + tagsSPLITED[i]);
                                CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                            }
                        }
                        catch (ClassNotFoundException ex) {
                        }
                        catch (IOException ex) {
                            
                        }
                        if (CFG.leaderGameData.getLeaderOfCiv().getName().toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0) continue;
                        lTempNames.add(CFG.leaderGameData.getLeaderOfCiv().getName());
                        lTempTags.add(tagsSPLITED[i]);
                        lTempCivsTags.add(CFG.leaderGameData.getCiv(0));
                    }
                    int nPosY = 0;
                    while (lTempNames.size() > 0) {
                        int toAddID = 0;
                        for (int i = 1; i < lTempNames.size(); ++i) {
                            if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                            toAddID = i;
                        }
                        menuElements.add(new Button_Classic((String)lTempNames.get(toAddID), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                        menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                        this.lCivsTags.add((String)lTempCivsTags.get(toAddID));
                        this.lTags.add((String)lTempTags.get(toAddID));
                        lTempNames.remove(toAddID);
                        lTempTags.remove(toAddID);
                        lTempCivsTags.remove(toAddID);
                        ++nPosY;
                    }
                    break block32;
                }
                if (CFG.chosenAlphabetCharachter == null) {
                    int iSize = tagsSPLITED.length;
                    for (int i = 0; i < iSize; ++i) {
                        try {
                            FileHandle file;
                            try {
                                file = Gdx.files.local("game/leaders/" + tagsSPLITED[i]);
                                CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                            }
                            catch (GdxRuntimeException ex) {
                                file = FileManager.loadFile("game/leaders/" + tagsSPLITED[i]);
                                CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                            }
                        }
                        catch (ClassNotFoundException e) {
                            CFG.exceptionStack(e);
                        }
                        catch (IOException e) {
                            CFG.exceptionStack(e);
                        }
                        lTempNames.add(CFG.leaderGameData.getLeaderOfCiv().getName());
                        lTempTags.add(tagsSPLITED[i]);
                        lTempCivsTags.add(CFG.leaderGameData.getCiv(0));
                    }
                    int nPosY = 0;
                    while (lTempNames.size() > 0) {
                        int toAddID = 0;
                        for (int i = 1; i < lTempNames.size(); ++i) {
                            if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                            toAddID = i;
                        }
                        menuElements.add(new Button_Classic((String)lTempNames.get(toAddID), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                        menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                        this.lCivsTags.add((String)lTempCivsTags.get(toAddID));
                        this.lTags.add((String)lTempTags.get(toAddID));
                        lTempNames.remove(toAddID);
                        lTempTags.remove(toAddID);
                        lTempCivsTags.remove(toAddID);
                        ++nPosY;
                    }
                    break block32;
                }
                int iSize = tagsSPLITED.length;
                for (int i = 0; i < iSize; ++i) {
                    try {
                        FileHandle file;
                        try {
                            file = Gdx.files.local("game/leaders/" + tagsSPLITED[i]);
                            CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                        }
                        catch (GdxRuntimeException ex) {
                            file = FileManager.loadFile("game/leaders/" + tagsSPLITED[i]);
                            CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                        }
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                    }
                    catch (IOException iOException) {
                        
                    }
                    if (CFG.leaderGameData.getLeaderOfCiv().getName().charAt(0) != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                    lTempNames.add(CFG.leaderGameData.getLeaderOfCiv().getName());
                    lTempTags.add(tagsSPLITED[i]);
                    lTempCivsTags.add(CFG.leaderGameData.getCiv(0));
                }
                int nPosY = 0;
                while (lTempNames.size() > 0) {
                    int toAddID = 0;
                    for (int i = 1; i < lTempNames.size(); ++i) {
                        if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                        toAddID = i;
                    }
                    menuElements.add(new Button_Classic((String)lTempNames.get(toAddID), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                    menuElements.add(new Button_Classic_Classic_Wiki(CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
                    this.lCivsTags.add((String)lTempCivsTags.get(toAddID));
                    this.lTags.add((String)lTempTags.get(toAddID));
                    lTempNames.remove(toAddID);
                    lTempTags.remove(toAddID);
                    lTempCivsTags.remove(toAddID);
                    ++nPosY;
                }
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD - (CFG.BUTTON_H + CFG.PADD), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Leaders"));
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView();
        for (int i = 1; i < this.getMenuElemsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get((i - 1) / 2));
            if (this.getMenuElem(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag((i - 1) / 2);
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
                this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() - this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).getHeight() + this.getMenuElem(i).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
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
                return;
            }
        }
        if (iID % 2 == 1) {
            if (Menu_CreateScenario_Leaders.backTo == View.eCREATE_SCENARIO_EVENTS_COND_LEADER) {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).setText(this.getMenuElem(iID).getTextE());
            } else {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setText("game/leaders/" + this.lTags.get((iID - 1) / 2));
            }
            CFG.menus.setMenuID(Menu_CreateScenario_Leaders.backTo);
        } else {
            try {
                try {
                    FileHandle file = Gdx.files.local("game/leaders/" + this.lTags.get((iID - 1) / 2));
                    CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                }
                catch (GdxRuntimeException ex) {
                    FileHandle file = FileManager.loadFile("game/leaders/" + this.lTags.get((iID - 1) / 2));
                    CFG.leaderGameData = (Leader_GameData)CFG.deserialize(file.readBytes());
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IOException iOException) {
                
            }
            if (CFG.leaderGameData.getLeaderOfCiv().getWiki().length() > 0) {
                try {
                    Gdx.net.openURI("https://en.wikipedia.org/wiki/" + CFG.leaderGameData.getLeaderOfCiv().getWiki());
                }
                catch (GdxRuntimeException gdxRuntimeException) {}
            } else {
                CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
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

