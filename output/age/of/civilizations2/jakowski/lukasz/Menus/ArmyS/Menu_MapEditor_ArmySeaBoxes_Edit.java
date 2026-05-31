/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyS;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.ArmyS.Menu_MapEditor_ArmySeaBoxes_Add;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.Province_ArmyBox;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_ArmySeaBoxes_Edit
extends Menu {
    public Menu_MapEditor_ArmySeaBoxes_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Text(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.GAMEWIDTH - (CFG.BUTTON_W * 2 + CFG.PADD * 2) * 2, CFG.BUTTON_H){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AddNewBox"));
        this.getMenuElem(2).setTextE(CFG.lang.get("SeaArmyBoxesEditor") + ": " + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint = new Point_XY2(-1, -1);
                Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint = new Point_XY2(-1, -1);
                CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES_ADD);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES);
        CFG.menus.setBackAnimation(true);
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null && CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size() > 0) {
            FileHandle file = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "army_boxes/" + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
            String sInput = "";
            for (int i = 0; i < CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size(); ++i) {
                if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getIsBelowZero()) {
                    if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX() >= CFG.map.getMpB().getWidthM() / 2) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().set(i, new Province_ArmyBox(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX() - CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosY()));
                    }
                    if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX() >= CFG.map.getMpB().getWidthM() / 2) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().set(i, new Province_ArmyBox(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX() - CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosY()));
                    }
                } else {
                    if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX() > CFG.map.getMpB().getWidthM()) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().set(i, new Province_ArmyBox(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX() - CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosY()));
                    }
                    if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX() > CFG.map.getMpB().getWidthM()) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().set(i, new Province_ArmyBox(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX() - CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosY()));
                    }
                }
                sInput = sInput + "" + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosX() / CFG.map.getMpB().getMapSc3() + ";";
                sInput = sInput + "" + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getStartPosY() / CFG.map.getMpB().getMapSc3() + ";";
                sInput = sInput + "" + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosX() / CFG.map.getMpB().getMapSc3() + ";";
                sInput = sInput + "" + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i).getEndPosY() / CFG.map.getMpB().getMapSc3() + ";";
            }
            file.writeString(sInput, false);
        } else {
            try {
                Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "army_boxes/" + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).delete();
            }
            catch (Exception ex) {
                try {
                    Gdx.files.external("map/" + CFG.map.getFileActiveMapPath() + "army_boxes/" + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).delete();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}

