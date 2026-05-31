
package age.of.civilizations2.jakowski.lukasz.Menus.CivInfo;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.Difficulty_Level;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Civilizations_Info_Difficulty
extends Menu {
    public Menu_Civilizations_Info_Difficulty() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Difficulty_Level(IMGManager.getIMG(Images.difficultyHeaven).getWidth() + CFG.PADD * 2, 0, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - CFG.PADD * 4 - IMGManager.getIMG(Images.difficultyHeaven).getWidth() - IMGManager.getIMG(Images.difficultyHell).getWidth(), CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 3 - CFG.PADD * 4, 0.65f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DifficultyLevel") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + this.getCurr() + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(new TitleM_TextSmall(null, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.2f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_Civilizations_Info_Difficulty.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Difficulty.this.getPosY() + 2 - IMGManager.getIMG(Images.gradient).getHeight() - (this.getHeightT() + CFG.PADD * 2), Menu_Civilizations_Info_Difficulty.this.getWidthM() + CFG.PADD * 2 - 2, (this.getHeightT() + CFG.PADD * 2 - 4) * 3 / 4, false, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.25f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_Civilizations_Info_Difficulty.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Difficulty.this.getPosY() - this.getHeightT() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 - CFG.PADD * 2, Menu_Civilizations_Info_Difficulty.this.getWidthM() + CFG.PADD * 2 - 2, IMGManager.getIMG(Images.line32Off1).getHeight(), false, true);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_Civilizations_Info_Difficulty.this.getPosX() - CFG.PADD + 2 + iTranslateX, Menu_Civilizations_Info_Difficulty.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() - 2 - CFG.PADD * 2, Menu_Civilizations_Info_Difficulty.this.getWidthM() + CFG.PADD * 2 - 2, IMGManager.getIMG(Images.line32Off1).getHeight(), false, true);
                oSB.setColor(Color.WHITE);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.85f) / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2 - CFG.PADD * 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        }, CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH + CFG.PADD, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 2, CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 3 - CFG.PADD * 4, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Difficulty"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - CFG.PADD - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getTitleM().getHeightT() - CFG.PADD * 2, this.getWidthM() + CFG.PADD * 2 + Core.PADDING, this.getHeightM() + this.getTitleM().getHeightT() + CFG.PADD * 4);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.difficultyHeaven).drawO(oSB, this.getPosX() + CFG.PADD / 2 + iTranslateX, this.getPosY() + this.getHeightM() / 2 - IMGManager.getIMG(Images.difficultyHeaven).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.difficultyHell).drawO(oSB, this.getPosX() - CFG.PADD / 2 - IMGManager.getIMG(Images.difficultyHell).getWidth() + this.getWidthM() + iTranslateX, this.getPosY() + this.getHeightM() / 2 - IMGManager.getIMG(Images.difficultyHell).getHeight() / 2 + iTranslateY);
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

