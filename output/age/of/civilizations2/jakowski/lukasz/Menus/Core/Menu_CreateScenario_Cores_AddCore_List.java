
package age.of.civilizations2.jakowski.lukasz.Menus.Core;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
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
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Cores_AddCore_List
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_CreateScenario_Cores_AddCore_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivsTags = new ArrayList<String>();
        ArrayList<String> lTempNames = new ArrayList<String>();
        ArrayList<String> lTempTags = new ArrayList<String>();
        menuElements.add(new Button_Classic_LR_Line(CFG.lang.get("AddNewCivilization"), -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Slider_BG(CFG.lang.get("PercentageOfPopulation"), 0, CFG.BUTTON_H + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, 1, 99, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID){

            @Override
            public String getDrawText() {
                return this.getTextE() + ": " + this.getCurr() + "%";
            }
        });
        if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.lang.getCiv(CFG.core.getCiv(i).getCivName()).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0) continue;
                lTempNames.add(CFG.lang.getCiv(CFG.core.getCiv(i).getCivName()));
                lTempTags.add(CFG.core.getCiv(i).getCivTag());
            }
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateScenario_Cores_AddCore_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
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
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                lTempNames.add(CFG.lang.getCiv(CFG.core.getCiv(i).getCivName()));
                lTempTags.add(CFG.core.getCiv(i).getCivTag());
            }
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateScenario_Cores_AddCore_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
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
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.lang.getCiv(CFG.core.getCiv(i).getCivName()).charAt(0) != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                lTempNames.add(CFG.lang.getCiv(CFG.core.getCiv(i).getCivName()));
                lTempTags.add(CFG.core.getCiv(i).getCivTag());
            }
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i = 1; i < lTempNames.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i))) continue;
                    toAddID = i;
                }
                menuElements.add(new Button_Classic(CFG.lang.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Classic_Wiki(tID++, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), CFG.BUTTON_H * (nPosY + 2) + CFG.PADD * (nPosY + 4), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear((String)Menu_CreateScenario_Cores_AddCore_List.this.lCivsTags.get(this.getTextPosElem())), CFG.COLOR_HOVER_TITLE));
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
        int tempRandomButton;
        super.updateMenuElements_IsInView();
        for (int i = tempRandomButton = 2; i < this.getMenuElemsSize(); i += 2) {
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
        block9: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            break block9;
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
        int tempRandomButton = 2;
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
            
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_CORES_ADD_CIV);
                return;
            }
            case 1: {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = this.getMenuElem(iID).getCurr();
                return;
            }
        }
        if ((iID -= 2) % 2 == 0) {
            CFG.chosenAlphabetCharachter = null;
            CFG.sSearch = null;
            for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                CFG.province_CoresGD.addCore(CFG.core.getProvSelected().getProv(i), CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId(), 100);
                int tID = this.getCivID(this.lCivsTags.get(iID / 2));
                CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().addNewCore(tID, 1);
                CFG.province_CoresGD.addCore(CFG.core.getProvSelected().getProv(i), tID, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
            }
            CFG.core.getProvSelected().clearSelectedProvinces();
            if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
            }
            this.onBack();
            this.onBackPressed();
        } else {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lCivsTags.get(iID / 2);
            CFG.setDialogType(DialogType.GO_TO_WIKI);
        }
    }

    private final int getCivID(String nTag) {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (!CFG.core.getCiv(i).getCivTag().equals(nTag)) continue;
            return i;
        }
        return 0;
    }

    private final void onBack() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_CORES);
        CFG.menus.rebuildCreateScenario_Cores_SetUp();
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

