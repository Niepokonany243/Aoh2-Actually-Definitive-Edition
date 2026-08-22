
package age.of.civilizations2.jakowski.lukasz.Menus.Relations;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_Add;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy.Slider_Relations;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy.Slider_Relations2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_Relations_Interactive
extends Menu {
    public Menu_ManageDiplomacy_Relations_Interactive() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Add("", -1, CFG.PADD, CFG.PADD, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.BUTTON_H, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                int textLeft = this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX;
                int textRight = this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + iTranslateX;
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getFlagC().drawO(oSB, textLeft - CFG.PADD - CFG.CIV_FLAG_WIDTH, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, textLeft - CFG.PADD - CFG.CIV_FLAG_WIDTH, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 > 0) {
                    CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2).getFlagC().drawO(oSB, textRight + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, textRight + CFG.PADD, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                }
            }
        });
        menuElements.add(new Button_Game("-", -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3, true));
        menuElements.add(new Slider_Relations(CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 4, CFG.BUTTON_H, -100, 100, 0){

            @Override
            public void buildElemHover() {
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 > 0) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName() + " - " + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (this.getCurr() > 0 ? "+" + this.getCurr() : Integer.valueOf(this.getCurr())), this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                this.menuElemHover = null;
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3, true));
        menuElements.add(new Button_Game("-", -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 - CFG.PADD * 4, true));
        menuElements.add(new Slider_Relations2(CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 - CFG.PADD * 4, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 4, CFG.BUTTON_H, -100, 100, 0){

            @Override
            public void buildElemHover() {
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 > 0) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2).getCivName() + " - " + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Opinion") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (this.getCurr() > 0 ? "+" + this.getCurr() : Integer.valueOf(this.getCurr())), this.getCurr() == 0 ? CFG.COLOR_NEUTRAL : (this.getCurr() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                this.menuElemHover = null;
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 - CFG.PADD * 4, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), this.getMenuElem(0).getHeightE() + CFG.PADD * 2, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.575f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), (this.getMenuElem(0).getHeightE() + CFG.PADD * 2) / 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0425f, 0.0475f, 0.06f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuElem(0).getHeightE() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.bgGameMenu).draw2O(oSB, this.getPosX() + iTranslateX, this.getMenuElem(4).getPosY() - CFG.PADD - IMGManager.getIMG(Images.bgGameMenu).getHeight() + iTranslateY, this.getWidthM(), this.getMenuElem(4).getHeightE() + CFG.PADD * 2);
        IMGManager.getIMG(Images.bgGameMenu).draw2O(oSB, this.getPosX() + iTranslateX, this.getMenuElem(1).getPosY() - CFG.PADD - IMGManager.getIMG(Images.bgGameMenu).getHeight() + iTranslateY, this.getWidthM(), this.getMenuElem(1).getHeightE() + CFG.PADD * 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuElem(1).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 4, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 4 + iTranslateX, this.getMenuElem(1).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 4, 1, true, false);
        oSB.setColor(new Color(0.0425f, 0.0475f, 0.06f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getMenuElem(1).getPosY() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() - 1 + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                break;
            }
            case 1: {
                this.getMenuElem(2).setCurr(this.getMenuElem(2).getCurr() - 1);
                this.updateRelation();
                break;
            }
            case 3: {
                this.getMenuElem(2).setCurr(this.getMenuElem(2).getCurr() + 1);
                this.updateRelation();
                break;
            }
            case 2: {
                this.updateRelation();
                break;
            }
            case 4: {
                this.getMenuElem(5).setCurr(this.getMenuElem(5).getCurr() - 1);
                this.updateRelation();
                break;
            }
            case 6: {
                this.getMenuElem(5).setCurr(this.getMenuElem(5).getCurr() + 1);
                this.updateRelation();
                break;
            }
            case 5: {
                this.updateRelation();
            }
        }
    }

    private final void updateRelation() {
        CFG.core.setCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2, this.getMenuElem(2).getCurr());
        CFG.core.setCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, this.getMenuElem(5).getCurr());
        RenderProvince.updateDrawProvinces();
    }
}

