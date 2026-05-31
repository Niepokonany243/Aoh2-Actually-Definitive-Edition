
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.Unions;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Union_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Editor_Unions_List
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_Editor_Unions_List() {
        this.lCivsTags = new ArrayList<String>();
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.unionsManager.unions.lUnions.size(); ++i) {
            String tTags = ", ";
            for (int j = 0; j < CFG.unionsManager.unions.lUnions.get((int)i).lCivsTags.size(); ++j) {
                tTags = tTags + "" + CFG.lang.getCiv(CFG.unionsManager.unions.lUnions.get((int)i).lCivsTags.get(j)) + (CFG.unionsManager.unions.lUnions.get((int)i).lCivsTags.size() - 1 == j ? "" : "-");
            }
            menuElements.add(new Button_Classic(CFG.lang.get("Civilization") + ": " + CFG.lang.getCiv(CFG.unionsManager.unions.lUnions.get((int)i).lCreateCivTag) + tTags, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * (i + 2) + CFG.BUTTON_H * (i + 1), CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2, CFG.PADD * (i + 2) + CFG.BUTTON_H * (i + 1), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
            this.lCivsTags.add(CFG.unionsManager.unions.lUnions.get((int)i).lCreateCivTag);
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - (CFG.BUTTON_H + CFG.PADD), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddUnion"));
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
                this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 - this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
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
                CFG.unionsManager.createUnion_Data = new Union_GameData();
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
                CFG.menus.setMenuID(View.eEDITOR_UNIONS_EDIT);
                return;
            }
        }
        if (--iID % 2 == 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = iID / 2;
            CFG.unionsManager.createUnion_Data = CFG.unionsManager.unions.lUnions.get(iID / 2);
            CFG.unionsManager.saveUnions();
            CFG.menus.setMenuID(View.eEDITOR_UNIONS_EDIT);
        } else {
            CFG.unionsManager.unions.lUnions.remove(iID / 2);
            CFG.unionsManager.saveUnions();
            CFG.menus.setMenuID(View.eEDITOR_UNIONS);
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

