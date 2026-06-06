
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.GenocideOperation;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_Genocide
extends Menu {
    public static int iProvinceID = -1;
    public static int selectedTargetCivID = -1;
    private List<Integer> targetCivs = new ArrayList<Integer>();

    public Menu_InGame_Genocide(int nProvinceID) {
        iProvinceID = nProvinceID;
        selectedTargetCivID = -1;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        int tGenocideTurnsLeft = -1;
        for (int gi = 0; gi < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGenocideOperationsSize(); ++gi) {
            GenocideOperation gop = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGenocideOperation(gi);
            if (gop.getProvinceID() == nProvinceID) {
                tGenocideTurnsLeft = gop.getTurnsRemaining();
                break;
            }
        }
        menuElements.add(new Button_Classic(CFG.core.getProv(nProvinceID).getProvName() + (tGenocideTurnsLeft > 0 ? " [Genocide: " + tGenocideTurnsLeft + " turns]" : ""), -1, 2, tY, tempWidth - 4, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.core.setActiveProvID(iProvinceID);
                CFG.map.getMpC().centerToProvID(iProvinceID);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            int civID = CFG.core.getProv(nProvinceID).getPop().getCivID(i);
            long pop = CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
            if (pop <= 0L) continue;
            this.targetCivs.add(civID);
            menuElements.add(new Button_Classic((civID > 0 ? CFG.core.getCiv(civID).getCivName() : "Independent") + ": " + CFG.getNumberWthSpaces("" + pop), -1, 2, tY, tempWidth - 4, CFG.BUTTON_H, true, true){

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.getCurr());
                    Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
                }

                @Override
                public void actionElem(int iID) {
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(civID);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        long maxArmy = CFG.gameAction.getControlledArmySizeInProvince(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        long defaultArmy = Math.min(maxArmy, Math.max(1L, Math.min(Math.max(1L, maxArmy / 10L), selectedTargetCivID > 0 ? CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(selectedTargetCivID) / 1000L : 1L)));
        menuElements.add(new Slider_InGame_Clear(CFG.lang.get("Army"), CFG.PADD * 2, tY + CFG.PADD, tempWidth - CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0L, maxArmy, defaultArmy, 0.65f){

            @Override
            public int getWidthE() {
                return Menu_InGame_Genocide.this.getElementW() * 2 - CFG.PADD * 4;
            }

            @Override
            public int getSliderHeight() {
                return CFG.PADD * 2;
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65f);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Genocide.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }
        });
        menuElements.add(new Button_InGameAction("Genocide", -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_Genocide.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Genocide.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Genocide", CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Target: "));
                nData.add(new ME_Hover_2Type_Text(selectedTargetCivID >= 0 ? (selectedTargetCivID > 0 ? CFG.core.getCiv(selectedTargetCivID).getCivName() : "Independent") : "-", CFG.COLOR_HOVER_TITLE));
                if (selectedTargetCivID >= 0) {
                    nData.add(new ME_Hover_2Type_Flag(selectedTargetCivID, CFG.PADD, 0));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + Menu_InGame_Genocide.this.getMenuElem(Menu_InGame_Genocide.this.targetCivs.size() + 1).getCurr(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc("Multi-turn battle: army power vs population resistance."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc("Army takes casualties if outmatched. Province happiness and stability will decrease.", CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public boolean getIsClickable() {
                return !GameManager.isGenocideActive(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iProvinceID) && GameManager.canGenocidePopulation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iProvinceID, selectedTargetCivID, Menu_InGame_Genocide.this.getMenuElem(Menu_InGame_Genocide.this.targetCivs.size() + 1).getCurr());
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_PLUNDER;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall("Genocide" + (CFG.core.getProv(nProvinceID).getName().length() > 0 ? ": " + CFG.core.getProv(nProvinceID).getName() : ""), CFG.BUTTON_H * 3 / 4, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, Math.min(tY + CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEHEIGHT - tempMenuPosY - CFG.BUTTON_H), menuElements, true, true);
        this.updateLang();
    }

    @Override
    public final void actionEL(int iID) {
        if (iID > 0 && iID <= this.targetCivs.size()) {
            int clickedCivID = this.targetCivs.get(iID - 1);
            selectedTargetCivID = clickedCivID == selectedTargetCivID ? -1 : clickedCivID;
            for (int i = 1; i <= this.targetCivs.size(); ++i) {
                this.getMenuElem(i).setCheckboxSt(this.targetCivs.get(i - 1) == selectedTargetCivID);
            }
            return;
        }
        if (iID == this.targetCivs.size() + 2) {
            this.setVisibleM(false);
            return;
        }
        if (iID == this.targetCivs.size() + 3) {
            if (GameManager.isGenocideActive(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iProvinceID)) {
                CFG.toastM.addM("Genocide already active in this province!", CFG.COLOR_NEGATIVE_2);
                return;
            }
            long removed = GameManager.genocidePopulation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iProvinceID, selectedTargetCivID, this.getMenuElem(this.targetCivs.size() + 1).getCurr());
            if (removed > 0L) {
                CFG.gameAction.updateInGame_ProvinceInfo();
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 3);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}
