/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.HRE;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Players_Box_RIGHT;
import age.of.civilizations2.jakowski.lukasz.Button.RandomGame.Button_RandomGame_Box_Elector;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_Manager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_HRE_Princes
extends Menu {
    public Menu_CreateScenario_HRE_Princes() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempElemH = CFG.BUTTON_H;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        for (int i = 0; i < CFG.hreMgr.getHRE().getPrincesSize(); ++i) {
            menuElements.add(new Button_In_Game_Box_CivID_LEFT(CFG.hreMgr.getHRE().getPrince(i), CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).getCivName(), CFG.PADD * 2, CFG.PADD + 2, tY, tempW - 3 - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.75f) * 2, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.hreMgr.getHRE().getIsEmperor(this.getCurr())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Emperor"), HolyRomanEmpire_Manager.oColorHRE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MakeAnEmperor"), HolyRomanEmpire_Manager.oColorHRE));
                        nData.add(new ME_Hover_2Type_Image(Images.hreFlag, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return CFG.hreMgr.getHRE().getIsEmperor(this.getCurr()) ? HolyRomanEmpire_Manager.oColorHRE : super.getColorE(isActive);
                }
            });
            menuElements.add(new Button_RandomGame_Box_Elector(CFG.hreMgr.getHRE().getPrince(i), "", -1, tempW - 2 - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f) * 2, tY, (int)((float)CFG.BUTTON_H * 0.75f), true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MakeAnElector"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.hreIcon, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_In_Game_Players_Box_RIGHT("", -1, tempW - 2 - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.75f), tY, (int)((float)CFG.BUTTON_H * 0.75f), true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Remove"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        if (menuElements.size() > 0) {
            menuElements.add(new Button_Transparent(0, 0, tempW, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, true));
        } else {
            menuElements.add(new Button_Transparent(0, 0, tempW, CFG.PADD, true));
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + 2, this.getHeightT());
                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE.r, HolyRomanEmpire_Manager.oColorHRE.g, HolyRomanEmpire_Manager.oColorHRE.b, 0.125f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE.r, HolyRomanEmpire_Manager.oColorHRE.g, HolyRomanEmpire_Manager.oColorHRE.b, 0.285f));
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
                IMGManager.getIMG(Images.hreFlag).drawO(oSB, nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 - (CFG.PADD + CFG.CIV_FLAG_WIDTH) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - CFG.CIV_FLAG_HEIGHT) / 2 - IMGManager.getIMG(Images.hreFlag).getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 - (CFG.PADD + CFG.CIV_FLAG_WIDTH) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - CFG.CIV_FLAG_HEIGHT) / 2);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 - (CFG.PADD + CFG.CIV_FLAG_WIDTH) / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.BUTTON_H - CFG.PADD * 3), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText("" + (CFG.hreMgr.getHRE().getPrincesSize() > 0 ? CFG.hreMgr.getHRE().getPrincesSize() + " " : "") + CFG.lang.get("Princes"));
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2, this.getHeightM(), false, true);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
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
        if (iID == this.getMenuElemsSize() - 1) {
            return;
        }
        if (iID % 3 == 0) {
            CFG.hreMgr.getHRE().setEmperorID(iID / 3);
            CFG.toastM.addM(CFG.lang.get("Emperor"), CFG.COLOR_HOVER_TITLE);
        } else if (iID % 3 == 1) {
            CFG.hreMgr.getHRE().setElectorID(iID / 3);
            CFG.toastM.addM(CFG.lang.get("Elector"), CFG.COLOR_HOVER_TITLE);
        } else if (iID % 3 == 2) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = iID / 3;
            CFG.setDialogType(DialogType.REMOVE_PRINCE);
        }
    }
}

