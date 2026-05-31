/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Core;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear_Flag;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBudgetTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Cores_SetUp
extends Menu {
    private List<Integer> brushCivs = new ArrayList<Integer>();

    public Menu_CreateScenario_Cores_SetUp() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 2 / 5;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosY = CFG.PADD;
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("AddCore"), -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.brushCivs.clear();
        if (CFG.core.getProvSelected().getProvSize() < 2) {
            try {
                try {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivsSize() > 0) {
                        menuElements.add(new TextBudgetTitle(CFG.lang.get("Population"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

                            @Override
                            public Color getColor(boolean isActive) {
                                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                            }

                            @Override
                            public void buildElemHover() {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("XOfPopulationIsRequiredToGetACore", 18), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        });
                        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    }
                    for (int i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivsSize(); ++i) {
                        menuElements.add(new Slider_InGame_Clear_Flag(CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(i), "" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(i)).getCivName(), CFG.PADD, tPosY, tempW - CFG.PADD * 2 - CFG.PADD - tempElemH, tempElemH, 1, 100, (int)(CFG.province_CoresGD.getPercOfPop(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(i)) * 100.0f)){

                            @Override
                            public String getDrawText() {
                                return this.getCurr() + "%";
                            }
                        });
                        menuElements.add(new Button_InGameAction("", -1, tempW - CFG.PADD - tempElemH, tPosY, tempElemH, tempElemH, i != 0){

                            @Override
                            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                                if (!this.getIsClickable()) {
                                    oSB.setColor(1.0f, 1.0f, 1.0f, 0.3f);
                                } else if (isActive) {
                                    oSB.setColor(1.0f, 1.0f, 1.0f, 0.5f);
                                } else if (this.getIsHovered()) {
                                    oSB.setColor(1.0f, 1.0f, 1.0f, 0.7f);
                                } else {
                                    oSB.setColor(Color.WHITE);
                                }
                                IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY);
                                oSB.setColor(Color.WHITE);
                            }

                            @Override
                            public void buildElemHover() {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        });
                        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    }
                }
                catch (IndexOutOfBoundsException i) {
                }
            }
            catch (NullPointerException ex) {
                menuElements.add(new Slider_InGame_Clear_Flag(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), "" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName(), CFG.PADD, tPosY, tempW - CFG.PADD * 2, tempElemH, 1, 100, 100){

                    @Override
                    public String getDrawText() {
                        return this.getCurr() + "%";
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            }
        } else {
            int i;
            for (i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().getCivsSize(); ++j) {
                    boolean add = true;
                    for (int k = 0; k < this.brushCivs.size(); ++k) {
                        if (this.brushCivs.get(k).intValue() != CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().getCivID(j)) continue;
                        add = false;
                        break;
                    }
                    if (!add) continue;
                    this.brushCivs.add(CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().getCivID(j));
                }
            }
            for (i = 0; i < this.brushCivs.size(); ++i) {
                menuElements.add(new Button_In_Game_Box_CivID_LEFT(this.brushCivs.get(i), "" + CFG.core.getCiv(this.brushCivs.get(i)).getCivName(), -1, CFG.PADD + 2, tPosY, tempW - CFG.PADD * 2 - 2 - (int)((float)CFG.BUTTON_H * 0.75f), true));
                menuElements.add(new Button_In_Game_Players_Box_RIGHT(null, -1, tempW - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), tPosY, (int)((float)CFG.BUTTON_H * 0.75f), true){

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            }
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + 4 + Core.PADDING, this.getHeightT() + Core.PADDING);
                oSB.setColor(new Color(0.003921569f, 0.32941177f, 0.50980395f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.003921569f, 0.32941177f, 0.50980395f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tPosY, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5) - CFG.BUTTON_H - CFG.PADD * 2), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        try {
            this.getTitleM().setText(CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getName() : CFG.lang.get("Cores"));
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.lang.get("Cores");
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        if (iID == 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 35;
            CFG.menus.setMenuID(View.eCREATE_SCENARIO_CORES_ADD_CORE);
        }
        iID -= 2;
        try {
            if (this.brushCivs.size() > 0) {
                if (++iID % 2 == 0) {
                    CFG.toastM.addM(this.getMenuElem(iID + 2).getTextE(), CFG.COLOR_HOVER_TITLE);
                } else {
                    for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                        if (CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCivId() == this.brushCivs.get(iID / 2).intValue()) continue;
                        CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().removeCore(this.brushCivs.get(iID / 2));
                        CFG.province_CoresGD.removeCore(CFG.core.getProvSelected().getProv(i), this.brushCivs.get(iID / 2));
                        CFG.province_CoresGD.updatePercOfPopulation(CFG.core.getProvSelected().getProv(i), CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().getCivID(0), (int)(CFG.province_CoresGD.getPercOfPop(CFG.core.getProvSelected().getProv(i), CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getCores().getCivID(0)) * 100.0f));
                    }
                    CFG.menus.rebuildCreateScenario_Cores_SetUp();
                }
            } else if (iID % 2 == 0) {
                CFG.province_CoresGD.updatePercOfPopulation(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(iID / 2), this.getMenuElem(iID + 2).getCurr());
                for (int i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivsSize(); ++i) {
                    this.getMenuElem(2 + i * 2).setCurr((int)(CFG.province_CoresGD.getPercOfPop(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(i)) * 100.0f));
                }
            } else if (this.getMenuElem(iID + 2).getIsClickable()) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(iID / 2) != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.province_CoresGD.removeCore(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(iID / 2));
                    CFG.core.getProv(CFG.core.getActiveProvID()).getCores().removeCore(CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(iID / 2));
                    CFG.province_CoresGD.updatePercOfPopulation(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(0), (int)(CFG.province_CoresGD.getPercOfPop(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCores().getCivID(0)) * 100.0f));
                }
                CFG.menus.rebuildCreateScenario_Cores_SetUp();
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }
}

