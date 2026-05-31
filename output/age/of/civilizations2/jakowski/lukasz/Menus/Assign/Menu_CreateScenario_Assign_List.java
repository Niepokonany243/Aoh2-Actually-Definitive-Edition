
package age.of.civilizations2.jakowski.lukasz.Menus.Assign;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_EditorFlag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Assign_List
extends Menu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    public Menu_CreateScenario_Assign_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosX = CFG.PADD;
        this.lCivsTags = new ArrayList<String>();
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            menuElements.add(new Button_EditorFlag(i, tPosX, CFG.PADD, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getNumOfProvs(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosX += IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD;
            this.lCivsTags.add(CFG.core.getCiv(i).getCivTag());
        }
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.lang.get("SelectCivilization"));
        tPosX = 0;
        tPosX = CFG.glyphLay.width + (float)(CFG.PADD * 4) > (float)CFG.BUTTON_W ? (int)(CFG.glyphLay.width + (float)(CFG.PADD * 4)) : CFG.BUTTON_W + CFG.PADD * 4;
        menuElements.add(new Button_Transparent(0, 0, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosXE() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE(), CFG.BUTTON_H + CFG.PADD * 2, true));
        this.initMenu(null, tPosX + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() - tPosX - CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H + CFG.PADD * 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                block10: {
                    if (!this.getMenuElem(i).getIsInView()) continue;
                    try {
                        this.lFlags.get(this.getFlagID(i)).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 - this.lFlags.get(this.getFlagID(i)).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
                    }
                    catch (NullPointerException ex) {
                        if (CFG.core.getCiv(i).getCivTag().equals("ran")) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f));
                            CFG.core.getCiv(i).getFlagC().drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY - CFG.core.getCiv(i).getFlagC().getHeight(), IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
                            oSB.setColor(Color.WHITE);
                        } else {
                            CFG.core.getCiv(i).getFlagC().drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY - CFG.core.getCiv(i).getFlagC().getHeight(), IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
                        }
                        if (!this.getMenuElem(i).getIsHovered()) break block10;
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0375f));
                        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.575f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 4);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + IMGManager.getIMG(Images.topFlagFrame).getHeight() - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 4 + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 4, false, true);
                        oSB.setColor(Color.WHITE);
                    }
                }
                if (this.getMenuElem(i).getIsHovered() || i == CFG.createScenarioAssignProvsCiv) {
                    IMGManager.getIMG(Images.topFlagFrameH).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY);
                } else {
                    IMGManager.getIMG(Images.topFlagFrame).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY);
                }
                oSB.setColor(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.475f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth() / 4, CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + IMGManager.getIMG(Images.topFlagFrame).getWidth() - IMGManager.getIMG(Images.topFlagFrame).getWidth() / 4 + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth() / 4, CFG.CIV_COLOR_W, true, false);
                oSB.setColor(CFG.COLOR_FLAG_FRAME);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, 1, CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getMenuPosX() + IMGManager.getIMG(Images.topFlagFrame).getWidth() - 1 + this.getMenuElem(i).getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.BUTTON_H / 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, 1, CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD * 2, this.getHeightM() - 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD * 2, this.getHeightM() - 1, true, false);
        oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.7f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightM() / 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightM() - this.getHeightM() / 2 + iTranslateY, 1, this.getHeightM() / 2, false, false);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView();
        for (int i = 0; i < this.getMenuElemsSize() - 1; ++i) {
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

    private final int getFlagID(int nCivTagID) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (this.lLoadedFlags_TagsIDs.get(i) != nCivTagID) continue;
            return i;
        }
        return 0;
    }

    private final void loadFlag(int nCivTagID) {
        block10: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Linear));
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Linear));
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "_FLH.png")), Texture.TextureFilter.Linear));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "_FLH.png")), Texture.TextureFilter.Linear));
                            }
                            break block10;
                        }
                        this.lFlags.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "/" + CFG.ideologiesMgr.getRealTag(this.lCivsTags.get(nCivTagID)) + "_FLH.png")), Texture.TextureFilter.Linear));
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.lFlags.add(null);
            }
            catch (OutOfMemoryError e) {
                this.lFlags.add(null);
            }
        }
        this.lLoadedFlags_TagsIDs.add(nCivTagID);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            return;
        }
        if (CFG.createScenarioAssignProvsCiv != this.getMenuElem(iID).getCurr()) {
            CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
            CFG.core.enableDrawCivilizationRegions(this.getMenuElem(iID).getCurr(), 0);
        } else if (this.getMenuElem(iID).getCurr() > 0) {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.getMenuElem(iID).getCurr()).getCapitalProvID());
        }
        CFG.createScenarioAssignProvsCiv = this.getMenuElem(iID).getCurr();
    }

    @Override
    public void onBackPressed() {
        try {
            for (int i = 0; i < this.lFlags.size(); ++i) {
                this.lFlags.get(i).getTexture().dispose();
            }
            this.lFlags.clear();
            this.lLoadedFlags_TagsIDs.clear();
            this.lCivsTags.clear();
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }
}

