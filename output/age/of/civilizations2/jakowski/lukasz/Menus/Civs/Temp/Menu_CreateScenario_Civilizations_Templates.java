
package age.of.civilizations2.jakowski.lukasz.Menus.Civs.Temp;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivTemplate;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Actions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Civilizations_Templates
extends Menu {
    public int CIV_ID;
    public CivTemplate civTemplate;

    public static int getMenuX() {
        return CFG.GAMEWIDTH - Menu_CreateScenario_Civilizations_Templates.getMenuW() - CFG.PADD;
    }

    public static int getMenuW() {
        return CFG.BUTTON_W * 3 + CFG.BUTTON_W * 3 / 5;
    }

    public static int getMenuY() {
        return CFG.PADD * 5 + CFG.BUTTON_H * 2 + CFG.BUTTON_H * 3 / 4;
    }

    public Menu_CreateScenario_Civilizations_Templates() {
        int tempWidth;
        ArrayList<MenuElemUI> menuElements;
        block9: {
            this.CIV_ID = -1;
            this.civTemplate = null;
            menuElements = new ArrayList<MenuElemUI>();
            tempWidth = Menu_CreateScenario_Civilizations_Templates.getMenuW();
            int tY = 0;
            int tempElemH = Menu_InGame_Civ_Actions.getButtonH();
            try {
                if (CFG.core.getActiveProvID() < 0 || CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() <= 0 || CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID() != CFG.core.getActiveProvID()) break block9;
                this.CIV_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                String realTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag());
                FileHandle file = null;
                if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "civs_template/" + realTag).exists()) {
                    try {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "civs_template/" + realTag);
                        this.civTemplate = (CivTemplate)CFG.deserialize(file.readBytes());
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                if (this.civTemplate != null && !this.civTemplate.tag.isEmpty()) {
                    menuElements.add(new Button_DiplomacyAction(Images.iconTrue, CFG.lang.get("Confirm"), 0, 0, tY, tempWidth - 2, tempElemH, true){

                        @Override
                        public void actionElem(int iID) {
                            try {
                                int b;
                                ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                                for (b = 0; b < CFG.core.getCiv(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID).getNumOfProvs(); ++b) {
                                    if (CFG.core.getCiv(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID).getProvID(b) == CFG.core.getCiv(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID).getCapitalProvID()) continue;
                                    tempProvs.add(CFG.core.getCiv(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID).getProvID(b));
                                }
                                for (b = tempProvs.size() - 1; b >= 0; --b) {
                                    if (CFG.core.getCiv(CFG.core.getProv((Integer)tempProvs.get(b)).getCivId()).getCapitalProvID() == ((Integer)tempProvs.get(b)).intValue()) continue;
                                    CFG.core.getProv((Integer)tempProvs.get(b)).setCivId(0, false, false);
                                    CFG.core.getProv((Integer)tempProvs.get(b)).setTrueOwnerOfProv(0);
                                    CFG.core.getProv((Integer)tempProvs.get(b)).resetArmiesAll(-1);
                                    CFG.core.getProv((Integer)tempProvs.get(b)).buildProvinceCore();
                                }
                                for (b = CFG.core.getProvSelected().getProvSize() - 1; b >= 0; --b) {
                                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getProvSelected().getProv(b)).getCivId()).getCapitalProvID() == CFG.core.getProvSelected().getProv(b)) continue;
                                    CFG.core.getProv(CFG.core.getProvSelected().getProv(b)).setCivId(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID, false, false);
                                    CFG.core.getProv(CFG.core.getProvSelected().getProv(b)).setTrueOwnerOfProv(Menu_CreateScenario_Civilizations_Templates.this.CIV_ID);
                                    CFG.core.getProv(CFG.core.getProvSelected().getProv(b)).resetArmiesAll(-1);
                                    CFG.core.getProv(CFG.core.getProvSelected().getProv(b)).buildProvinceCore();
                                }
                                CFG.core.getProvSelected().clearSelectedProvinces();
                            }
                            catch (Exception exr) {
                                CFG.exceptionStack(exr);
                            }
                        }

                        @Override
                        public boolean getIsClickable() {
                            return !CFG.core.getProvSelected().getProv().isEmpty();
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    for (int a = 0; a < this.civTemplate.tag.size(); ++a) {
                        menuElements.add(new Button_DiplomacyAction(Images.frontline, CFG.lang.getCiv(this.civTemplate.tag.get(a)) + " " + this.civTemplate.year.get(a) + " | " + CFG.getNumberWthSpaces("" + this.civTemplate.provinces.get(a).size()) + " " + CFG.lang.get("Provinces"), 0, 0, tY, tempWidth - 2, tempElemH, true){
                            int id;
                            {
                                this.id = 0;
                            }

                            @Override
                            public void setMin(int iMin) {
                                this.id = iMin;
                            }

                            @Override
                            public int getCurr() {
                                return this.id;
                            }

                            @Override
                            public void actionElem(int iID) {
                                try {
                                    if (Menu_CreateScenario_Civilizations_Templates.this.civTemplate != null && Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).size() > 1) {
                                        CFG.core.getProvSelected().clearSelectedProvinces();
                                        for (int b = Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).size() - 1; b >= 0; --b) {
                                            if (CFG.core.getCiv(CFG.core.getProv(Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).get(b)).getCivId()).getCapitalProvID() == Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).get(b).intValue() && CFG.core.getProv(Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).get(b)).getCivId() != Menu_CreateScenario_Civilizations_Templates.this.CIV_ID) continue;
                                            CFG.core.getProvSelected().addProv(Menu_CreateScenario_Civilizations_Templates.this.civTemplate.provinces.get(this.id).get(b));
                                        }
                                    }
                                }
                                catch (Exception ex) {
                                    CFG.exceptionStack(ex);
                                }
                            }

                            @Override
                            public void buildElemHover() {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        });
                        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
                        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin(a);
                        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        if (menuElements.isEmpty()) {
            this.initMenu(null, 0, 0, 1, 1, menuElements, false, true);
        } else {
            int tempMenuPosY = Menu_CreateScenario_Civilizations_Templates.getMenuY();
            this.initMenu(new TitleM_TextSmall(CFG.lang.get("Templates"), CFG.BUTTON_H * 3 / 4, true, false){

                @Override
                public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + 4 - IMGManager.getIMG(Images.dialog_title).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                    IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                    oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.165f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                    oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.375f));
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
                    int imgID = Images.frontline;
                    IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_CreateScenario_Civilizations_Templates.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                    Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
                }
            }, Menu_CreateScenario_Civilizations_Templates.getMenuX(), tempMenuPosY, tempWidth, Math.min(CFG.GAMEHEIGHT / 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, !menuElements.isEmpty(), true);
            this.updateLang();
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            this.civTemplate = null;
            CFG.core.getProvSelected().clearSelectedProvinces();
        }
    }
}

