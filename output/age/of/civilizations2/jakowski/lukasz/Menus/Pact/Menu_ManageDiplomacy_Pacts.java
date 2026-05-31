
package age.of.civilizations2.jakowski.lukasz.Menus.Pact;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy.Slider_Pact;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ManageDiplomacy_Pacts
extends Menu {
    public Menu_ManageDiplomacy_Pacts() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int multiplePosY = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) <= 0) continue;
                menuElements.add(new Button_Flag(i, 0, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1), CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG));
                menuElements.add(new Button_Flag(j, CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1), CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG));
                menuElements.add(new Button_Classic_Classic("-", -1, (CFG.CIV_FLAG_WIDTH + CFG.PADD * 4) * 2, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1), CFG.BUTTON_H, CFG.BUTTON_H, true));
                menuElements.add(new Slider_Pact(i, j, (CFG.CIV_FLAG_WIDTH + CFG.PADD * 4) * 2 + CFG.BUTTON_H, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1) + CFG.PADD, CFG.GAMEWIDTH - (CFG.CIV_FLAG_WIDTH + CFG.PADD * 4) * 2 - CFG.BUTTON_H * 3, CFG.BUTTON_H - CFG.PADD * 2, 1, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT, CFG.core.getCivNonAggressionPact(i, j)));
                menuElements.add(new Button_Classic_Classic("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_H * 2, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1), CFG.BUTTON_H, CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_H, CFG.PADD * (multiplePosY + 2) + CFG.BUTTON_H * (multiplePosY + 1), CFG.BUTTON_H, CFG.BUTTON_H, true));
                ++multiplePosY;
            }
        }
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, (CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD * 2) / 2, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("AddNewPact"));
        this.getTitleM().setText(CFG.lang.get("CustomizePacts"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.getScrollableY()) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM(), 1, false, true);
            IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), CFG.PADD * 2, false, true);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
            RenderProvince.updateDrawProvinces();
            CFG.map.getTouchMgr().ueExA();
            return;
        }
        if (iID % 6 == 0) {
            this.centerToPactID(iID / 6, true);
        } else if (iID % 6 == 1) {
            this.centerToPactID(iID / 6, false);
        } else if (iID % 6 == 2) {
            this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
            this.updateNonAggressionPact(iID / 6, this.getMenuElem(iID + 1).getCurr());
        } else if (iID % 6 == 3) {
            this.updateNonAggressionPact(iID / 6, this.getMenuElem(iID).getCurr());
        } else if (iID % 6 == 4) {
            this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
            this.updateNonAggressionPact(iID / 6, this.getMenuElem(iID - 1).getCurr());
        } else if (iID % 6 == 5) {
            this.updateNonAggressionPact(iID / 6, 0);
        }
    }

    private final void centerToPactID(int pactID, boolean civA) {
        int foundPacts = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) <= 0) continue;
                if (foundPacts == pactID) {
                    if (civA) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(i).getCapitalProvID());
                        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = i;
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                        CFG.toastM.addM(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    } else {
                        CFG.core.setActiveProvID(CFG.core.getCiv(j).getCapitalProvID());
                        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = j;
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                        CFG.toastM.addM(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    }
                    return;
                }
                ++foundPacts;
            }
        }
    }

    private final void updateNonAggressionPact(int pactID, int iNumOfTurns) {
        int foundPacts = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) <= 0) continue;
                if (foundPacts == pactID) {
                    CFG.core.setCivNonAggressionPact(i, j, iNumOfTurns);
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 != i && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 != j) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(i).getCapitalProvID());
                        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = i;
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                    return;
                }
                ++foundPacts;
            }
        }
    }
}

