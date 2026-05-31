
package age.of.civilizations2.jakowski.lukasz.Menus.Vassal;

import age.of.civilizations2.jakowski.lukasz.Button.Button_SpreadPropaganda;
import age.of.civilizations2.jakowski.lukasz.Button.Button_SpreadPropaganda_Total;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Civs;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_SpreadPropaganda
extends Menu {
    public static int civID = 0;
    public static List<Integer> provinces = new ArrayList<Integer>();
    public static int activeProvince = 0;
    public static int propagandaTurns = GameValues.gvPropaganda.PROPAGANDA_TURNS;

    public final int getElementW2() {
        return this.getWidthM();
    }

    public Menu_InGame_SpreadPropaganda(int nCivID) {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        civID = nCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new ButtonN_Civs(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), civID, 2, tY, tempWidth - 4){

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW() * 2;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new Button_SpreadPropaganda_Total(CFG.core.getCiv(civID).getCivName(), Images.propaganda, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), CFG.BUTTON_W * 2, provinces, GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces, propagandaTurns), 50){

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW2();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);

        menuElements.add(new age.of.civilizations2.jakowski.lukasz.Sliders.Slider(2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 4, CFG.BUTTON_H / 2, 1, 300, propagandaTurns) {
            private boolean bInitialization = true;
            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                propagandaTurns = this.getCurr();
                if (!this.bInitialization) {
                    CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
                }
                this.bInitialization = false;
            }
            @Override
            public String getDrawText() { return CFG.lang.get("Turns") + ": " + this.getCurr(); }
        });

        menuElements.add(new Button_Game(CFG.lang.get("AllProvinces"), -1, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - 4, true) {
            @Override
            public void actionElem(int iID) {
                provinces.clear();
                for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                    provinces.add(CFG.core.getCiv(civID).getProvID(i));
                }
                CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
            }
        });

        menuElements.add(new Text_Desc(CFG.lang.get("QuietlyReduceStabilityDesc"), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW2() - CFG.PADD * 2;
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Cancel"), -1, 2 + CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_SpreadPropaganda.this.setVisibleM(false);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("LaunchPropaganda"), -1, 2, tY, CFG.BUTTON_W, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW() + CFG.PADD / 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW() - CFG.PADD - CFG.PADD / 2;
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces, propagandaTurns)) {
                    CFG.toastM.addM(CFG.lang.get("Cost") + ": " + CFG.getNumberWthSpaces("" + GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces, propagandaTurns)), CFG.COLOR_NEGATIVE_1);
                    return;
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() < 50) {
                    CFG.toastM.addM(CFG.lang.get("DiplomacyPoints") + ": " + (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() / 10.0f + " / " + (float)50 / 10.0f, CFG.COLOR_NEGATIVE_1);
                    return;
                }
                if (GameManager.spreadPropaganda(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), civID, provinces, propagandaTurns)) {
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("SpreadPropaganda"), CFG.core.getCiv(civID).getCivName(), Images.infoDiplomacy);
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    Menu_InGame_SpreadPropaganda.this.setVisibleM(false);
                }
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SpreadPropaganda"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.propaganda, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(civID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces, propagandaTurns)), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (float)50 / 10.0f));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception ex) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                IMGManager.getIMG(Images.propaganda).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.propaganda).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.propaganda).getHeight() / 2 + iTranslateY);
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(Images.propaganda).getWidth() + CFG.PADD) / 2 + CFG.PADD + IMGManager.getIMG(Images.propaganda).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public boolean getIsClickable() {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS;
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("TargetArea") + ": " + provinces.size() + "/" + CFG.core.getCiv(civID).getNumOfProvs(), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (provinces.isEmpty()) {
            menuElements.add(new TextScale(CFG.lang.get("-----"), -1, 2, tY, tempWidth - 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SpreadPropaganda.this.getElementW() * 2;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            int iSize = provinces.size();
            for (i = 0; i < iSize; ++i) {
                menuElements.add(new Button_SpreadPropaganda(!CFG.core.getProv(provinces.get(i)).getName().isEmpty() ? CFG.core.getProv(provinces.get(i)).getName() : CFG.lang.get("Province"), Images.propaganda, 0, tY, CFG.BUTTON_W * 2, provinces.get(i), (int)GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinces.get(i), propagandaTurns), 50){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_SpreadPropaganda.this.getElementW2();
                    }

                    @Override
                    public void actionElem(int iID) {
                        for (int a = 0; a < provinces.size(); ++a) {
                            if (provinces.get(a).intValue() != this.getCurr()) continue;
                            provinces.remove(a);
                            break;
                        }
                        CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("SelectTheTargetProvincesForYourPropagandaCampaign"), -1, 0, tY, CFG.BUTTON_W, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_SpreadPropaganda.this.getElementW2();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (activeProvince >= 0 && !provinces.contains(activeProvince)) {
            menuElements.add(new Button_SpreadPropaganda(!CFG.core.getProv(activeProvince).getName().isEmpty() ? CFG.core.getProv(activeProvince).getName() : CFG.lang.get("Province"), Images.propaganda, 0, tY, CFG.BUTTON_W * 2, activeProvince, (int)GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), activeProvince, propagandaTurns), 50){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SpreadPropaganda.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    provinces.add(activeProvince);
                    CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        } else {
            menuElements.add(new TextScale(CFG.lang.get("ChooseAProvince"), -1, 2, tY, tempWidth - 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SpreadPropaganda.this.getElementW() * 2;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int added = 0;
        for (i = 0; i < CFG.core.getCiv(civID).getNumOfProvs() && added < GameValues.gvPropaganda.SELECT_PROVINCES_LIMIT_IN_MENU; ++i) {
            if (provinces.contains(CFG.core.getCiv(civID).getProvID(i))) continue;
            menuElements.add(new Button_SpreadPropaganda(!CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i)).getName().isEmpty() ? CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i)).getName() : CFG.lang.get("Province"), Images.propaganda, 0, tY, CFG.BUTTON_W * 2, CFG.core.getCiv(civID).getProvID(i), (int)GameManager.propagandaCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv(civID).getProvID(i), propagandaTurns), 50){

                @Override
                public int getWidthE() {
                    return Menu_InGame_SpreadPropaganda.this.getElementW2();
                }

                @Override
                public void actionElem(int iID) {
                    provinces.add(this.getCurr());
                    CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(++added % 2);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("SpreadPropaganda"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.20784314f, 0.24705882f, 0.28235295f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.20784314f, 0.24705882f, 0.28235295f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().draw(oSB, Menu_InGame_SpreadPropaganda.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_SpreadPropaganda.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_SpreadPropaganda.this.getPosX() + CFG.PADD * 2 + iTranslateX, Menu_InGame_SpreadPropaganda.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                CFG.core.getCiv(civID).getFlagC().draw(oSB, Menu_InGame_SpreadPropaganda.this.getPosX() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + 2 + iTranslateX, Menu_InGame_SpreadPropaganda.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, Menu_InGame_SpreadPropaganda.this.getPosX() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + 2 + iTranslateX, Menu_InGame_SpreadPropaganda.this.getPosY() - this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                IMGManager.getIMG(Images.propaganda).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.propaganda).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.propaganda).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
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
        try {
            if (CFG.core.getActiveProvID() >= 0 && CFG.core.getActiveProvID() != activeProvince && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == civID) {
                activeProvince = CFG.core.getActiveProvID();
                CFG.menus.rebuildInGame_SpreadPropaganda2(civID);
            }
        }
        catch (Exception exception) {
            
        }
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
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}


