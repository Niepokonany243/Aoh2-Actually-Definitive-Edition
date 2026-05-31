/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Lines;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Line_GameData;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_GameEditor_Lines
extends Menu {
    private List<Image> lImages = new ArrayList<Image>();
    private List<Boolean> lFlipX = new ArrayList<Boolean>();

    public Menu_GameEditor_Lines() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        FileHandle tempFileT = FileManager.loadFile("game/lines/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        for (int i = 0; i < tagsSPLITED.length; ++i) {
            FileHandle tGameData = FileManager.loadFile("game/lines/" + tagsSPLITED[i]);
            try {
                CFG.editorLine_GameData = (Line_GameData)CFG.deserialize(tGameData.readBytes());
                if (CFG.editorLine_GameData.getRapeatImage()) {
                    this.lImages.add(new Image(new Texture(FileManager.loadFile("game/lines/" + CFG.editorLine_GameData.getImageName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
                } else {
                    this.lImages.add(new Image(new Texture(FileManager.loadFile("game/lines/" + CFG.editorLine_GameData.getImageName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                }
                this.lFlipX.add(CFG.editorLine_GameData.getFlipX());
                menuElements.add(new Button_Classic_LR("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true));
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                continue;
            }
            catch (IOException iOException) {
                continue;
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                // empty catch block
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddNewStyle"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        try {
            for (int i = 0; i < this.getMenuElemsSize() - 1; ++i) {
                this.lImages.get(i).draw2O(oSB, this.getPosX() + this.getMenuElem(i + 1).getPosXE() + this.getMenuElem(i + 1).getWidthE() / 2 - this.getMenuElem(i + 1).getWidthE() / 4 + iTranslateX, this.getMenuPosY() + this.getMenuElem(i + 1).getPosY() + this.getMenuElem(i + 1).getHeightE() / 2 - this.lImages.get(i).getHeight() / 2 - this.lImages.get(i).getHeight(), this.getMenuElem(i + 1).getWidthE() / 2, this.lImages.get(i).getHeight(), this.lFlipX.get(i), false);
            }
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.editorLine_GameData = new Line_GameData();
                CFG.editorLine_GameData.setImageName("");
                CFG.menus.setMenuID(View.eGAME_EDITOR_LINES_EDIT);
                this.onBackPressed();
                break;
            }
            default: {
                FileHandle tempFileT = FileManager.loadFile("game/lines/Age_of_Civilizations");
                String tempT = tempFileT.readString();
                String[] tagsSPLITED = tempT.split(";");
                FileHandle tGameData = FileManager.loadFile("game/lines/" + tagsSPLITED[iID - 1]);
                try {
                    CFG.editorLine_GameData = (Line_GameData)CFG.deserialize(tGameData.readBytes());
                    CFG.menus.setMenuID(View.eGAME_EDITOR_LINES_EDIT);
                    this.onBackPressed();
                    break;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    break;
                }
                catch (IOException iOException) {
                    break;
                }
                catch (GdxRuntimeException gdxRuntimeException) {
                    // empty catch block
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        for (int i = 0; i < this.lImages.size(); ++i) {
            this.lImages.get(i).getTexture().dispose();
            this.lImages.set(i, null);
        }
        this.lImages.clear();
        this.lImages = null;
        this.lFlipX.clear();
    }
}

