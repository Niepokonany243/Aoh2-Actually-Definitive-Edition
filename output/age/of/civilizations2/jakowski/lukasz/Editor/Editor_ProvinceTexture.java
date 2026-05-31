
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;

public class Editor_ProvinceTexture
extends Editor {
    private int button;
    private int iBrushScale = 1;
    private boolean theDoubleMode = false;

    @Override
    public void keyDown(int keycode) {
        int provID;
        if (Gdx.input.isKeyPressed(19)) {
            boolean bl = this.theDoubleMode = !this.theDoubleMode;
            if (CFG.core.getActiveProvID() != CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getActiveProvID();
            }
        }
        if (Gdx.input.isKeyPressed(67) || Gdx.input.isKeyPressed(66)) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        }
        if (Gdx.input.isKeyPressed(44)) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID == 0 ? -1 : 0;
        }
        if (Gdx.input.isKeyPressed(21)) {
            --this.iBrushScale;
            if (this.iBrushScale < 1) {
                this.iBrushScale = 1;
            }
        } else if (Gdx.input.isKeyPressed(22)) {
            ++this.iBrushScale;
            if (this.iBrushScale > 3) {
                this.iBrushScale = 3;
            }
        }
        if (Gdx.input.isKeyPressed(62)) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getActiveProvID();
        }
        if (Gdx.input.isKeyPressed(41)) {
            int tempID = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2;
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = tempID;
        }
        if (Gdx.input.isKeyPressed(20) && CFG.core.getActiveProvID() != CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getActiveProvID();
        }
        if (Gdx.input.isKeyPressed(46) && CFG.core.getActiveProvID() >= 0) {
            CFG.core.getProv(CFG.core.getActiveProvID()).buildProvinceBG(true);
            CFG.core.getProv(CFG.core.getActiveProvID()).loadProvinceBG();
        }
        if (Gdx.input.isKeyPressed(49) && CFG.core.getActiveProvID() >= 0 && (provID = CFG.core.getActiveProvID()) >= 0 && !CFG.core.getProv(provID).getSeaProv()) {
            Pixmap wtf = PixmapIO.readCIM(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN()) + "/" + provID));
            Pixmap wtf2 = PixmapIO.readCIM(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + provID));
            Pixmap pixmap = null;
            boolean screenX = false;
            boolean screenY = false;
            Pixmap omg = new Pixmap(1, 1, Pixmap.Format.LuminanceAlpha);
            omg.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
            omg.drawPixel(0, 0);
            pixmap = new Pixmap(wtf2.getWidth(), wtf2.getHeight(), Pixmap.Format.LuminanceAlpha);
            pixmap.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
            for (int yi = 0; yi < pixmap.getHeight(); ++yi) {
                for (int xi = 0; xi < pixmap.getWidth(); ++xi) {
                    if (omg.getPixel(0, 0) != wtf.getPixel((int)((float)xi * ((float)CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN()) / (float)CFG.map.getMpB().getMapSc3())), (int)((float)yi * ((float)CFG.map.getMapDefaultScale(CFG.map.getActiveMapIDN()) / (float)CFG.map.getMpB().getMapSc3())))) continue;
                    pixmap.drawPixel(xi, yi);
                }
            }
            if (pixmap == null) {
                return;
            }
            CFG.core.getProv(provID).setBG(pixmap);
            PixmapIO.writeCIM(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + provID), pixmap);
        }
    }

    @Override
    public void touchDown(int screenX, int screenY, int pointer, int button) {
        if (screenX <= CFG.BUTTON_W * 2 + CFG.PADD * 2 && screenY >= CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 || CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
            CFG.map.getMpC().setDisableMovingMap(false);
            return;
        }
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 >= 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID == 0) {
            CFG.map.getMpC().setDisableMovingMap(true);
        }
        this.button = button;
        if (this.theDoubleMode) {
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY, button == 1);
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY, button != 1);
        } else {
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY, button == 1);
        }
    }

    @Override
    public void touchDragged(int screenX, int screenY, int pointer) {
        if (screenX <= CFG.BUTTON_W * 2 + CFG.PADD * 2 && screenY >= CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 || CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
            CFG.map.getMpC().setDisableMovingMap(false);
            return;
        }
        if (this.theDoubleMode) {
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY, this.button == 1);
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY, this.button != 1);
            if (this.iBrushScale == 2) {
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
            } else if (this.iBrushScale == 3) {
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX, screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button != 1);
            }
        } else {
            this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY, this.button == 1);
            if (this.iBrushScale == 2) {
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
            } else if (this.iBrushScale == 3) {
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY - (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY, this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(1.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX - (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX, screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(1.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
                this.dragged(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, screenX + (int)(2.0f * CFG.map.getMpS().getCurrSc()), screenY + (int)(2.0f * CFG.map.getMpS().getCurrSc()), this.button == 1);
            }
        }
    }

    private final void dragged(int provID, int screenX, int screenY, boolean type) {
        if (provID >= 0) {
            Pixmap wtf = PixmapIO.readCIM(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + provID));
            Pixmap pixmap = null;
            screenX = (int)((float)screenX / CFG.map.getMpS().getCurrSc());
            screenY = (int)((float)screenY / CFG.map.getMpS().getCurrSc());
            for (int y = 0; y < wtf.getHeight(); ++y) {
                for (int x = 0; x < wtf.getWidth(); ++x) {
                    if (x != screenX - CFG.map.getMpC().getPX() - (CFG.map.getMpC().getSecondSideOfMap() ? CFG.map.getMpB().getWidthM() : 0) - CFG.core.getProv(provID).getMiX2() || y != screenY - CFG.map.getMpC().getPY() - CFG.core.getProv(provID).getMiY4()) continue;
                    if (type) {
                        pixmap = PixmapIO.readCIM(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + provID));
                        pixmap.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                        pixmap.drawPixel(x, y);
                        continue;
                    }
                    Pixmap omg = new Pixmap(1, 1, Pixmap.Format.LuminanceAlpha);
                    omg.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                    omg.drawPixel(0, 0);
                    pixmap = new Pixmap(wtf.getWidth(), wtf.getHeight(), Pixmap.Format.LuminanceAlpha);
                    pixmap.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                    for (int yi = 0; yi < pixmap.getHeight(); ++yi) {
                        for (int xi = 0; xi < pixmap.getWidth(); ++xi) {
                            if (omg.getPixel(0, 0) != wtf.getPixel(xi, yi) || xi == x && yi == y) continue;
                            pixmap.drawPixel(xi, yi);
                        }
                    }
                }
            }
            if (pixmap == null) {
                return;
            }
            CFG.core.getProv(provID).setBG(pixmap);
            PixmapIO.writeCIM(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + CFG.map.getMpB().getMapSc3() + "/" + provID), pixmap);
            CFG.core.setActiveProvID(provID);
        }
    }

    @Override
    public void touchUp(int screenX, int screenY, int pointer, int button) {
        CFG.map.getMpC().setDisableMovingMap(false);
    }

    @Override
    public String toString() {
        return "ACTIVE PROVINCE ID 1: " + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 + "\n" + (this.theDoubleMode ? "ID 2: " + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 + "\n" : "") + "\nBRUSH SCALE: " + this.iBrushScale + "\nSPACE -> SET ACTIVE PROVINCE 1\nDOWN -> SET ACTIVE PROVINCE 2\nBACKSPACE -> RESET ACTIVE PROVINCES\nP -> PAUSE: " + (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < 0) + "\nUP -> DOUBLE MODE\nLEFT, RIGHT -> BRUSH SCALE\n\nR -> REBUILD BACKGROUND\nU -> REBUILD BG BASED ON DEFAULT SCALE\nAge of History 2: Definitive Edition";
    }

    @Override
    public void setInUse(boolean inUse) {
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 0;
        this.theDoubleMode = false;
        this.iBrushScale = 1;
        super.setInUse(inUse);
    }
}

