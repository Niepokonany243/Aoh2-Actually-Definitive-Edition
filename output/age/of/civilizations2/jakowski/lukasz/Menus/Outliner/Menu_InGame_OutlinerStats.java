
package age.of.civilizations2.jakowski.lukasz.Menus.Outliner;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_RightRank;
import age.of.civilizations2.jakowski.lukasz.Menus.Outliner.Menu_InGame_Outliner;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_OutlinerStats
extends Menu {
    public static final int ANIMATION_TIME = 135;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public static int getMenuW() {
        return CFG.CIV_INFO_MENU_WIDTH * 6 / 10;
    }

    public Menu_InGame_OutlinerStats() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = Menu_InGame_OutlinerStats.getMenuW();
        int tElementH = Math.max(CFG.BUTTON_H / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
        int tPosY = 0;
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY, tMenuWidth - 2, tElementH){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Audio"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F12", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisibleInGame_Playlist(!CFG.menus.getVisibleInGame_Playlist());
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Wars()) {
                    CFG.menus.setVisibleInGame_Wars(false);
                } else {
                    CFG.menus.rebuildInGame_Wars();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CurrentWars"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F6", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_MilitaryAlliances()) {
                    CFG.menus.setVisibleInGame_MilitaryAlliances(false);
                } else {
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Alliances"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploAlliance, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F7", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Rank()) {
                    CFG.menus.setVisibleInGame_Rank(false);
                } else {
                    CFG.menus.rebuildInGame_Rank();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Ranking"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.rank, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F9", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Wonders()) {
                    CFG.menus.setVisibleInGame_Wonders(false);
                } else {
                    CFG.menus.rebuildInGame_Wonders();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_WorldPopulation()) {
                    CFG.menus.setVisibleInGame_WorldPopulation(false);
                } else {
                    CFG.menus.rebuildInGame_WorldPopulation();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_WorldEconomy()) {
                    CFG.menus.setVisibleInGame_WorldEconomy(false);
                } else {
                    CFG.menus.rebuildInGame_WorldEconomy();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGameHRE()) {
                    CFG.menus.setVisibleInGameHRE(false);
                } else {
                    CFG.menus.rebuildInGameHRE();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_ConquredProvinces()) {
                    CFG.menus.setVisibleInGame_ConquredProvinces(false);
                } else {
                    CFG.menus.rebuildInGame_ConqueredProvinces();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_VictoryConditions()) {
                    CFG.menus.setVisibleInGame_VictoryConditions(false);
                } else {
                    CFG.menus.rebuildInGame_VictoryConditions();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_BuildingsConstructed()) {
                    CFG.menus.setVisibleInGame_BuildingsConstructed(false);
                } else {
                    CFG.menus.rebuildInGame_BuildingsConstructed();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Army()) {
                    CFG.menus.setVisibleInGame_Army(false);
                } else {
                    CFG.menus.rebuildInGame_Army();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_RecruitedArmy()) {
                    CFG.menus.setVisibleInGame_RecruitedArmy(false);
                } else {
                    CFG.menus.rebuildInGame_RecruitedArmy();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                    CFG.menus.setVisibleInGame_CensusOfProvince(false);
                } else if (CFG.core.getActiveProvID() >= 0) {
                    CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_History()) {
                    CFG.menus.setVisibleInGame_History(false);
                } else {
                    CFG.menus.rebuildInGame_History();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                CFG.core.resetChooseProvinceData_Immediately();
                CFG.core.resetRegroupArmy_Data();
                CFG.menus.setMenuID(View.eTIMELINE);
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 0 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 0;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 1 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 1;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 2 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 2;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        menuElements.add(new TextOutliner(null, CFG.PADD * 2, 2, tPosY += tElementH, tMenuWidth - 2, tElementH){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 3 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 3;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        tPosY += tElementH;
        this.initMenu(null, CFG.GAMEWIDTH - tMenuWidth, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2, tMenuWidth, Math.min(tElementH * (CFG.isAndroid() ? 4 : 5), ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE()), menuElements, false, true);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        int tID = 0;
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Audio"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Wars"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Alliances"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Ranking"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Wonders"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Economy"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("HolyRomanEmpire"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("ConqueredProvinces"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("VictoryConditions"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("ConstructedBuildings"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Army"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("RecruitedArmy"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Demography"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("History"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Timeline"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Provinces"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("TechnologyLevel"));
        this.getMenuElem(tID++).setTextE(CFG.lang.get("RankScore"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 135L >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX += (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 135.0f))) : (iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 135.0f)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            CFG.menus.getMenu_InGame_CurrentWars().setPosY(IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2);
            CFG.menus.getMenu_InGame_CurrentWars_Info().setPosY(CFG.menus.getMenu_InGame_CurrentWars().getPosY() - 1 + CFG.menus.getMenu_InGame_CurrentWars().getHeightM());
            Menu_InGame_Outliner.lTime = System.currentTimeMillis();
            return;
        }
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX + CFG.PADD, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
            CFG.menus.getMenu_InGame_CurrentWars().setPosY(this.getPosY() + this.getHeightM());
            CFG.menus.getMenu_InGame_CurrentWars_Info().setPosY(CFG.menus.getMenu_InGame_CurrentWars().getPosY() - 1 + CFG.menus.getMenu_InGame_CurrentWars().getHeightM());
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean hideAnimation) {
        if (hideAnimation != Menu_InGame_OutlinerStats.hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - 135L ? System.currentTimeMillis() - (135L - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        Menu_InGame_OutlinerStats.hideAnimation = hideAnimation;
    }
}

