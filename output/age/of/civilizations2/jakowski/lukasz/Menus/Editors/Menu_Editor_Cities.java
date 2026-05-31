/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Search;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Editor_Cities
extends Menu {
    public static String searchText = "";
    private List<String> lTags;

    public Menu_Editor_Cities() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(CFG.map.getActiveMapIDN()), CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic_Search(searchText, CFG.PADD * 3, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return CFG.lang.get("Search") + ": " + super.getTextToDrawElem();
            }

            @Override
            public void actionElem(int iID) {
                Keyboard.cityEditorSearch = true;
                CFG.showKeyboard(iID);
            }
        });
        this.lTags = new ArrayList<String>();
        try {
            FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                this.lTags.add(tagsSPLITED[i]);
            }
        }
        catch (GdxRuntimeException tempFileT) {
            // empty catch block
        }
        ArrayList<String> visibleTags = new ArrayList<String>();
        for (int i = 0; i < this.lTags.size(); ++i) {
            FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + this.lTags.get(i));
            try {
                City nData = (City)CFG.deserialize(fileData.readBytes());
                if (searchText != null && searchText.length() > 0 && !nData.getCityName().toLowerCase().contains(searchText.toLowerCase()) && !this.lTags.get(i).toLowerCase().contains(searchText.toLowerCase())) continue;
                int visibleID = visibleTags.size();
                visibleTags.add(this.lTags.get(i));
                menuElements.add(new Button_Classic(nData.getCityName(), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (visibleID + 3) + CFG.PADD * (visibleID + 5), CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H * (visibleID + 3) + CFG.PADD * (visibleID + 5), CFG.BUTTON_W, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.lTags = visibleTags;
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(2).setTextE(CFG.lang.get("CreateaCity"));
        this.getMenuElem(3).setTextE(searchText);
        this.getTitleM().setText(CFG.lang.get("CitiesEditor") + " - Age of History 2: Definitive Edition");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getMenuElem(1).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        int iSize = this.lTags.size() * 2;
        for (int i = 0; i < iSize; i += 2) {
            if (!this.getMenuElem(i + 4).getIsInView()) continue;
            CFG.fontMain.get(0).getData().setScale(0.7f);
            CFG.drawTextDefault(oSB, this.lTags.get(i / 2), this.getMenuElem(i + 4).getTextPosElem() + this.getMenuElem(i + 4).getTextWidthU() + CFG.PADD + iTranslateX, this.getMenuElem(i + 4).getPosY() + this.getMenuElem(i + 4).getHeightE() / 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + this.getMenuPosY() + iTranslateY, CFG.COLOR_BUTTON_EXTRA_DESCRIPTION);
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.backToMenu = View.eEDITOR_CITIES;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                return;
            }
            case 2: {
                CFG.backToMenu = View.eEDITOR_CITIES;
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editorCity = new City("", -1, -1, Images.city3);
                CFG.core.setActiveProvID(-1);
                CFG.menus.setMenuID(View.eCC);
                CFG.updateKeyboard_Actions();
                return;
            }
            case 3: {
                Keyboard.cityEditorSearch = true;
                CFG.showKeyboard(iID);
                return;
            }
        }
        if ((iID - 4) % 2 == 0) {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lTags.get((iID - 4) / 2);
            FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            try {
                CFG.editorCity = (City)CFG.deserialize(fileData.readBytes());
                CFG.editorCity.setCityLevel(CFG.getEditorCityLevel(CFG.editorCity.getCityLevel()));
                CFG.core.setProvinceID(CFG.map.getMpC().getPX() + CFG.editorCity.getPoX() * CFG.map.getMpB().getMapSc3(), CFG.map.getMpC().getPY() + CFG.editorCity.getPosY() * CFG.map.getMpB().getMapSc3());
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            CFG.menus.setMenuID(View.eCC);
            CFG.updateKeyboard_Actions();
            CFG.menus.getCreateCity_UpdateSaveButton();
        } else {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lTags.get((iID - 4) / 2);
            CFG.setDialogType(DialogType.REMOVE_CITY);
        }
    }

    @Override
    public void onBackPressed() {
        Keyboard.cityEditorSearch = false;
        CFG.menus.setMenuID(View.eEDITOR);
        CFG.menus.setBackAnimation(true);
    }
}

