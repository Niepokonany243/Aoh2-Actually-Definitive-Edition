
package age.of.civilizations2.jakowski.lukasz.Menus.CustomizeAlliance;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ArrowRight;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_CivilizationAndFlag;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_UP;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CustomizeAlliance_Options
extends Menu {
    private String sName;
    private String sOptional;

    public Menu_CustomizeAlliance_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_CustomizeAlliance_Options.this.sName + (super.getTextE().equals("") ? "(" + Menu_CustomizeAlliance_Options.this.sOptional + ")" : "") + ": " + super.getTextE();
            }

            @Override
            public void setTextE(String sText) {
                if (sText != null) {
                    CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).setAllianceName(sText);
                }
                super.setTextE(sText);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllianceName") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_ArrowRight(CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.PADD, CFG.BUTTON_W, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RandomAllianceName") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG(null, -1, CFG.GAMEWIDTH / 2, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < CFG.core.getAlliancesSize()) {
                    oSB.setColor(new Color(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getB(), 1.0f));
                    IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD - 1 + iTranslateY, this.getTextWidthU(), CFG.CIV_COLOR_W);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < CFG.core.getAlliancesSize()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColorOfAlliance") + ".", CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new Button_Classic(null, -1, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AddNewCivilization") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        for (int i = 0; i < CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilizationsSize(); ++i) {
            menuElements.add(new Button_Classic_CivilizationAndFlag(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilization(i), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 2 + CFG.BUTTON_H * i + CFG.PADD * i + CFG.PADD * 3, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getNumOfProvs(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.core.getCiv(this.getCurr()).getNumOfProvs(), CFG.core.countAlliance_Provinces(CFG.core.getCiv(this.getCurr()).getAlliance()), 5) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.core.getCiv(this.getCurr()).countPop(), (float)CFG.core.countAlliance_Population(CFG.core.getCiv(this.getCurr()).getAlliance()), 5) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countEco()), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.core.getCiv(this.getCurr()).countEco(), (float)CFG.core.countAlliance_Economy(CFG.core.getCiv(this.getCurr()).getAlliance()), 5) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getTechLevel(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Classic_UP(CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 2 + CFG.BUTTON_H * i + CFG.PADD * i + CFG.PADD * 3, CFG.BUTTON_W, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H * 2 + CFG.BUTTON_H * i + CFG.PADD * i + CFG.PADD * 3, CFG.BUTTON_W, CFG.BUTTON_H, true){

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
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.BUTTON_H * 3 / 4 - CFG.PADD, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("AllianceName");
        this.sOptional = CFG.lang.get("Optional");
        if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID >= 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < CFG.core.getAlliancesSize()) {
            this.getMenuElem(0).setTextE("" + CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getAllianceName());
        } else {
            this.getMenuElem(0).setTextE("");
        }
        this.getMenuElem(2).setTextE(CFG.lang.get("ColorOfAlliance"));
        this.getMenuElem(3).setTextE(CFG.lang.get("AddCivilization"));
        this.getTitleM().setText(CFG.lang.get("CustomizeAlliance"));
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.showKeyboard();
                return;
            }
            case 1: {
                CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).setAllianceName(CFG.getRandomAllianceName(0));
                this.getMenuElem(0).setTextE("" + CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getAllianceName());
                return;
            }
            case 2: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setPosX(CFG.PADD * 4);
                    CFG.menus.getColorPicker().setPosY(this.getPosY() + this.getMenuElem(iID).getPosY());
                    CFG.menus.getColorPicker().setActiveRGBColor((int)(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getR() * 255.0f), (int)(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getG() * 255.0f), (int)(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getB() * 255.0f));
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.CUSTOMIZE_ALLIANCE_COLOR);
                }
                return;
            }
            case 3: {
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.chosenAlphabetCharachter = null;
                CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE_ADD_CIVILIZATION);
                return;
            }
        }
        if ((iID - 4) % 3 == 2) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilization((iID - 4) / 3);
            CFG.setDialogType(DialogType.MANAGE_DIPLOMACY_REMOVE_CIVILIZATION_FROM_ALLIANCE);
        } else if ((iID - 4) % 3 == 1) {
            CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).moveUp((iID - 4) / 3);
            CFG.menus.setMenuIDWithoutAnim(View.eCUSTOMIZE_ALLIANCE);
        } else {
            try {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilization((iID - 4) / 3)).getCapitalProvID());
                CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilization((iID - 4) / 3)).getCapitalProvID());
                CFG.toastM.addM("" + CFG.core.getCiv(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivilization((iID - 4) / 3)).getCivName());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
        }
    }
}

