
package age.of.civilizations2.jakowski.lukasz.Menus.ManageDiplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

public class Menu_ManageDiplomacy_Options
extends Menu {
    public Menu_ManageDiplomacy_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W, true, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true, false){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CustomizeRelations"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 4, CFG.PADD, CFG.BUTTON_W, true, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, true, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 4 + CFG.PADD * 5, CFG.PADD, CFG.BUTTON_W, true, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 5 + CFG.PADD * 6, CFG.PADD, CFG.BUTTON_W, true, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 6 + CFG.PADD * 7, CFG.PADD, CFG.BUTTON_W, true, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 7 + CFG.PADD * 8, CFG.PADD, CFG.BUTTON_W, true, false));
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 3, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Alliances"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Relations"));
        this.getMenuElem(2).setTextE(CFG.lang.get("NonAggressionPacts"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Vassals"));
        this.getMenuElem(4).setTextE(CFG.lang.get("GuaranteedIndependence"));
        this.getMenuElem(5).setTextE(CFG.lang.get("DefensivePacts"));
        this.getMenuElem(6).setTextE(CFG.lang.get("MilitaryAccess"));
        this.getMenuElem(7).setTextE(CFG.lang.get("Truces"));
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        CFG.menus.getManageDiplomacy_Alliances().setVisibleM(false);
        CFG.menus.setVisible_ManageDiplomacy_Relations(false);
        CFG.menus.setVisible_ManageDiplomacy_Pacts3(false);
        CFG.menus.setVisible_ManageDiplomacy_Truces(false);
        CFG.menus.setVisible_ManageDiplomacy_Pacts_List(false);
        CFG.menus.setVisible_ManageDiplomacy_Vassals(false);
        CFG.menus.setVisible_ManageDiplomacy_Vassals_List(false);
        CFG.menus.setVisible_ManageDiplomacy_Guarantee(false);
        CFG.menus.setVisible_ManageDiplomacy_Guarantee_List(false);
        CFG.menus.setVisible_ManageDiplomacy_DefensivePact(false);
        CFG.menus.setVisible_ManageDiplomacy_DefensivePacts_List(false);
        CFG.menus.setVisible_ManageDiplomacy_MilitaryAccess(false);
        CFG.menus.setVisible_ManageDiplomacy_MilitaryAccess_List(false);
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.MANAGE_DIPLOMACY_HOLD_CIV_ID = 0;
        CFG.MANAGE_DIPLOMACY_HOLD_PROV_ID = -1;
        CFG.MANAGE_DIPLOMACY_PRESS_PROV_ID = -1;
        CFG.menus.getDrawCivilization().setVisible(false);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCheckboxSt(false);
        }
        this.getMenuElem(iID).setCheckboxSt(true);
        switch (iID) {
            case 0: {
                CFG.menus.getManageDiplomacy_Alliances().setVisibleM(true);
                break;
            }
            case 1: {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID_PICKED = false;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    if (!CFG.core.getProv(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID()).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                    }
                } else if (CFG.core.getPlayer(0).getCivId() > 0 && CFG.core.getPlayer(0).getCivId() < CFG.core.getCivsSize()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.core.getPlayer(0).getCivId();
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                } else {
                    Random oR = new Random();
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = oR.nextInt(CFG.core.getCivsSize() - 1) + 1;
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCapitalProvID());
                }
                CFG.menus.setVisible_ManageDiplomacy_Relations(true);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(0).setTextE(CFG.lang.get("CustomizeRelations") + " [" + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName() + "]");
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(1).setClickable(false);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setClickable(false);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setTextE("");
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(3).setClickable(false);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(4).setClickable(false);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setClickable(false);
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setTextE("");
                CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(6).setClickable(false);
                break;
            }
            case 2: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_Pacts3();
                break;
            }
            case 3: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_Vassals();
                break;
            }
            case 4: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_Guarantee();
                break;
            }
            case 5: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_Defensive();
                break;
            }
            case 6: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_MilitaryAccess();
                break;
            }
            case 7: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                }
                CFG.menus.rebuildManageDiplomacy_Truces();
            }
        }
        RenderProvince.updateDrawProvinces();
        CFG.map.getTouchMgr().ueExA();
    }
}

