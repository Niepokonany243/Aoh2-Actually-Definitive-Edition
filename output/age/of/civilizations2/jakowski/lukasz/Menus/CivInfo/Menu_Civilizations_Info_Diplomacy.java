
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilizations_Info_Diplomacy
extends Menu {
    public Menu_Civilizations_Info_Diplomacy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Text(null, CFG.PADD * 2, CFG.PADD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() - (float)this.getTextHeight() * 0.8f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text(null, CFG.PADD * 2, CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() - (float)this.getTextHeight() * 0.8f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text(null, CFG.PADD * 2, CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() - (float)this.getTextHeight() * 0.8f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text(null, CFG.PADD * 2, CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() - (float)this.getTextHeight() * 0.8f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
            }
        });
        this.initMenu(new TitleM(null, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.2f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_Civilizations_Info_Diplomacy.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Diplomacy.this.getPosY() + 2 - IMGManager.getIMG(Images.gradient).getHeight() - (this.getHeightT() + CFG.PADD * 2), Menu_Civilizations_Info_Diplomacy.this.getWidthM() + CFG.PADD * 2 - 2, (this.getHeightT() + CFG.PADD * 2 - 4) * 3 / 4, false, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.25f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_Civilizations_Info_Diplomacy.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Diplomacy.this.getPosY() - this.getHeightT() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 - CFG.PADD * 2, Menu_Civilizations_Info_Diplomacy.this.getWidthM() + CFG.PADD * 2 - 2, IMGManager.getIMG(Images.line32Off1).getHeight(), false, true);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_Civilizations_Info_Diplomacy.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Diplomacy.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() - 2 - CFG.PADD * 2, Menu_Civilizations_Info_Diplomacy.this.getWidthM() + CFG.PADD * 2 - 2, IMGManager.getIMG(Images.line32Off1).getHeight(), false, true);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.85f);
                CFG.drawTextDefaultWithShadow(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.85f) / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)this.getTextHeight() * 0.85f) / 2 - CFG.PADD * 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH + CFG.PADD, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 2, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT * 5 + CFG.PADD * 6 - CFG.PADD * 4, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Diplomacy"));
        this.getMenuElem(0).setTextE(CFG.lang.get("CivWars"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CivAllies"));
        this.getMenuElem(2).setTextE(CFG.lang.get("CivPacts"));
        this.getMenuElem(3).setTextE(CFG.lang.get("CivVassals"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - CFG.PADD - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getTitleM().getHeightT() - CFG.PADD * 2, this.getWidthM() + CFG.PADD * 2 + Core.PADDING, this.getHeightM() + this.getTitleM().getHeightT() + CFG.PADD * 4);
        CFG.drawRect_NewGameBoxDefault(oSB, this.getPosX() + iTranslateX, this.getPosY() - CFG.PADD, this.getWidthM(), this.getHeightM() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
    }
}

