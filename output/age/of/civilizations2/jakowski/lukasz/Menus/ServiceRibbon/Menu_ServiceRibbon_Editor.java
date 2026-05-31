
package age.of.civilizations2.jakowski.lukasz.Menus.ServiceRibbon;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_GameData;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Overlay_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.IOException;
import java.util.ArrayList;

public class Menu_ServiceRibbon_Editor
extends Menu {
    public Menu_ServiceRibbon_Editor() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i2 = 0; i2 < CFG.serviceRibbonMgr.getSRSize(); ++i2) {
            menuElements.add(new Button_Classic_LR("ID: " + CFG.serviceRibbonMgr.getTag(i2), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i2 + 1) + CFG.PADD * (i2 + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true){

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    CFG.fontMain.get(0).getData().setScale(0.8f);
                    if (isActive) {
                        CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColorE(isActive));
                    } else {
                        CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColorE(isActive));
                    }
                    CFG.fontMain.get(0).getData().setScale(1.0f);
                }
            });
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.editorServiceRibbon_Colors = new ArrayList<Color>();
        int tempMax = 1;
        for (i = 0; i < CFG.serviceRibbonMgr.getSRSize(); ++i) {
            if (tempMax >= CFG.serviceRibbonMgr.getSR(i).getSize()) continue;
            tempMax = CFG.serviceRibbonMgr.getSR(i).getSize();
        }
        for (i = 0; i < tempMax; ++i) {
            CFG.editorServiceRibbon_Colors_Add();
        }
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddNewServiceRibbon"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempWidth = CFG.SERVICE_RIBBON_WIDTH * 6 + CFG.PADD * 5;
        for (int i = 1; i < CFG.serviceRibbonMgr.getSRSize() + 1; ++i) {
            for (int j = 0; j < 6; ++j) {
                CFG.serviceRibbonMgr.drawSRLevel(oSB, CFG.GAMEWIDTH / 2 - tempWidth / 2 + (CFG.SERVICE_RIBBON_WIDTH + CFG.PADD) * j + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 + this.getMenuPosY(), j, 0, 0, i - 1, CFG.editorServiceRibbon_Colors);
            }
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editorServiceRibbon_GameData = new ServiceRibbon_GameData();
                CFG.editorServiceRibbon_GameData.addServiceRibbonOverlay(new ServiceRibbon_Overlay_GameData(0, CFG.SERVICE_RIBBON_WIDTH, false));
                CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT);
                break;
            }
            default: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.serviceRibbonMgr.getTag(iID - 1);
                FileHandle fileData = FileManager.loadFile("game/service_ribbons/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                try {
                    CFG.editorServiceRibbon_GameData = (ServiceRibbon_GameData)CFG.deserialize(fileData.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                    
                }
                CFG.toastM.addM(CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT);
            }
        }
    }
}

