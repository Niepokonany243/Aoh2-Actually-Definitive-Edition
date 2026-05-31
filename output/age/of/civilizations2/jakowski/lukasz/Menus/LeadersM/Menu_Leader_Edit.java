/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.LeadersM;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Menu_Leader_Edit
extends Menu {
    public Menu_Leader_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Text(null, -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("AddNewLeader"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                CFG.brushMode = false;
                CFG.menus.setMenuID(View.eGAME_LEADERS);
                CFG.menus.setBackAnimation(true);
                return;
            }
            case 1: {
                CFG.menus.saveLeader_Edit_Data();
                if (CFG.leaderGameData.getLeaderOfCiv().getName().length() < 1) {
                    CFG.toastM.addM("-- " + CFG.lang.get("Name") + " --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    break;
                }
                if (CFG.leaderGameData.getCivsSize() == 0) {
                    CFG.toastM.addM("-- " + CFG.lang.get("Civilizations") + " --", CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(4500);
                    break;
                }
                this.saveLeader();
                this.onBackPressed();
                CFG.brushMode = false;
                CFG.menus.setMenuID(View.eGAME_LEADERS);
                CFG.menus.setBackAnimation(true);
                break;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
        }
    }

    private final void saveLeader() {
        OutputStream os = null;
        try {
            FileHandle fileData = FileManager.getSaveType("game/leaders/" + CFG.leaderGameData.getLeaderOfCiv().getTag());
            fileData.writeBytes(CFG.serialize(CFG.leaderGameData), false);
        }
        catch (IOException fileData) {
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception fileData) {}
            }
        }
        try {
            FileHandle file = CFG.readLocalFiles() ? Gdx.files.local("game/leaders/Age_of_Civilizations") : FileManager.loadFile("game/leaders/Age_of_Civilizations");
            String tempTags = file.readString();
            if (tempTags.indexOf(CFG.leaderGameData.getLeaderOfCiv().getTag()) < 0) {
                FileHandle fileSave = FileManager.getSaveType("game/leaders/Age_of_Civilizations");
                fileSave.writeString(tempTags + CFG.leaderGameData.getLeaderOfCiv().getTag() + ";", false);
            } else {
                String[] tempTagsSplited = tempTags.split(";");
                boolean tAdd = true;
                int iSize = tempTagsSplited.length;
                for (int i = 0; i < iSize; ++i) {
                    if (!tempTagsSplited[i].equals(CFG.leaderGameData.getLeaderOfCiv().getTag())) continue;
                    tAdd = false;
                    break;
                }
                if (tAdd) {
                    FileHandle fileSave = FileManager.getSaveType("game/leaders/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.leaderGameData.getLeaderOfCiv().getTag() + ";", false);
                }
            }
        }
        catch (GdxRuntimeException ex) {
            FileHandle fileSave = FileManager.getSaveType("game/leaders/Age_of_Civilizations");
            fileSave.writeString(CFG.leaderGameData.getLeaderOfCiv().getTag() + ";", false);
        }
    }
}

