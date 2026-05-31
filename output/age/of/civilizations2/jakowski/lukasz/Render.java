
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuManager;
import age.of.civilizations2.jakowski.lukasz.Menus.CivN.Menu_CreateNewGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Formable.AddCiv.Menu_InGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.MapEditor.Menu_MapEditor_OptimizationRegions;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response.Menu_PeaceTreaty_Response;
import age.of.civilizations2.jakowski.lukasz.Provinces.DiploAnimation;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Ships.ShipManager;
import age.of.civilizations2.jakowski.lukasz.Timelapse.TimelapseManager;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import java.util.ArrayList;
import java.util.List;

public class Render {
    public static boolean DISABLE_CIVS_NAMES = false;
    public static boolean DISABLE_CITIES = false;
    public static boolean drawCivNamesInCreateNewGame = false;
    private static Renderer oRenderer;
    public static DrawMoveUnits oDrawMoveUnits;
    public static float DISABLE_INNER_BORDERS;
    public static float DISABLE_SEA_ARMIES;
    public static float CIV_NAMES_START_DRAWING_NAMES_MAP_SCALE;
    public static float CIVILIZATION_NAMES_ALPHA;
    private static long CIVILIZATIONS_NAMES_TIME;
    private static RendererCivRegionNames rendererCivRegionNames;
    private static List<Integer> lRegions_Civs;
    private static List<List<Integer>> lRegions_Civs_RegionsID;
    public static List<DiploAnimation> diploAnimations;
    public static int iDiploAnimationsSize;
    public static Matrix4 oldTransformMatrix;

    private static int[] cachedTempCivs = new int[0];
    private static int lastCivsSize = 0;

    private static final void updateRegionsInView() {
        if (CIVILIZATIONS_NAMES_TIME == 0L) {
            CIVILIZATIONS_NAMES_TIME = System.currentTimeMillis();
            CIVILIZATION_NAMES_ALPHA = 0.1f;
        } else if (CIVILIZATION_NAMES_ALPHA < 1.0f && (CIVILIZATION_NAMES_ALPHA = 0.1f + 0.9f * (float)(System.currentTimeMillis() - CIVILIZATIONS_NAMES_TIME) / (float)CFG.settingsGD.CIVILIZATIONS_NAMES_INTERVAL) > 1.0f) {
            CIVILIZATION_NAMES_ALPHA = 1.0f;
        }
        lRegions_Civs.clear();
        int civsSize = CFG.core.getCivsSize();
        if (civsSize > cachedTempCivs.length) {
            cachedTempCivs = new int[civsSize + 64];
            lastCivsSize = civsSize;
            for (int i = 0; i < lRegions_Civs_RegionsID.size(); ++i) {
                lRegions_Civs_RegionsID.get(i).clear();
            }
            lRegions_Civs_RegionsID.clear();
        } else {
            java.util.Arrays.fill(cachedTempCivs, 0, civsSize, 0);
            for (int i = 0; i < lRegions_Civs_RegionsID.size(); ++i) {
                lRegions_Civs_RegionsID.get(i).clear();
            }
            lRegions_Civs_RegionsID.clear();
        }
        try {
            int[] tempCivs = cachedTempCivs;
            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                int provCivId = CFG.core.getProv(CFG.core.getPIV(i)).getCivId();
                if (provCivId <= 0) continue;
                int tempIdx = tempCivs[provCivId];
                if (tempIdx > 0) {
                    int regionID = CFG.core.getProv(CFG.core.getPIV(i)).getCivRegionID();
                    boolean tempAdd = true;
                    List<Integer> regionList = lRegions_Civs_RegionsID.get(tempIdx - 1);
                    for (int j = regionList.size() - 1; j >= 0; --j) {
                        if (regionList.get(j).intValue() == regionID) { tempAdd = false; break; }
                    }
                    if (!tempAdd) continue;
                    regionList.add(regionID);
                    continue;
                }
                lRegions_Civs.add(provCivId);
                tempCivs[provCivId] = lRegions_Civs.size();
                ArrayList<Integer> newRegionList = new ArrayList<Integer>();
                newRegionList.add(CFG.core.getProv(CFG.core.getPIV(i)).getCivRegionID());
                lRegions_Civs_RegionsID.add(newRegionList);
            }
            CFG.NUM_OF_REGIONS_IN_VIEW = lRegions_Civs.size();
        }
        catch (Exception exception) {}
    }

    public static final void draw(SpriteBatch oSB) {
        CFG.map.drawMap(oSB);
        if (CFG.menus.getInGameView() && CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > CFG.cloudsAnimation.cloudsSettings.drawCloudsMinScale) {
            ShipManager.drawCurrentScale(oSB);
        }
        oRenderer.drawRenderer(oSB);
        if (CFG.map.getMpS().getCurrSc() < CIV_NAMES_START_DRAWING_NAMES_MAP_SCALE || Core.DRAW_PROVINCE_NAMES_ALPHA < 0.99f) {
            rendererCivRegionNames.update();
            rendererCivRegionNames.drawCRN(oSB);
        } else {
            CIVILIZATIONS_NAMES_TIME = 0L;
        }
    }

    public static final void drawWithoutScale(SpriteBatch oSB, SpriteBatch oSBNames) {
        CFG.unionFlagsToGenerate_Manager.generateFlags(oSB);
        CFG.core.updateLoadArmiesWidth_ErrorIDs(oSB);
        if (!CFG.menus.getIn_InitMenu() || !CFG.menus.getIn_SaveTheGame()) {
            if (CFG.map.getMapProvinceNames(CFG.map.getActiveMapIDN())) {
                PNM.dPN.dPNA(oSBNames);
            } else {
                PNM.uDPNA();
            }
        }
        try {
            Core.drawDiplomacyLines_Just(oSB, CFG.map.getMpS().getCurrSc());
            Core.drawProvinceDots_Just(oSB, CFG.map.getMpS().getCurrSc());
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (CFG.menus.getInGameView() && CFG.map.getMpS().getCurrSc() >= 1.0f) {
            ShipManager.draw(oSB);
        }
        age.of.civilizations2.jakowski.lukasz.Renderer.dNAI(oSB);
        Render.drawDiploAnimation(oSB);
        oRenderer.drawRendererWithoutScale(oSB);
        if (Render.drawInGame_ZoomOutArmyDetails()) {
            CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
        }
        CFG.map.getTouchMgr().dSMD(oSB);
    }

    public static void addDiploAnimation(int civID, int iProvinceID, int imageID) {
        try {
            if (CFG.settingsGD.DRAW_WAR_ON_MAP && GameValues.gvProvinceAnimation.ENABLE_DIPLOMACY_ANIMATION && (CFG.FOG_OF_WAR < 2 || CFG.FOG_OF_WAR == 2 && CFG.getMetProv(iProvinceID)) && iProvinceID >= 0 && iProvinceID < CFG.core.getProvinSize()) {
                for (int a = diploAnimations.size() - 1; a >= 0; --a) {
                    if (Render.diploAnimations.get((int)a).iProvinceID != iProvinceID) continue;
                    return;
                }
                diploAnimations.add(new DiploAnimation(civID, iProvinceID, imageID));
                iDiploAnimationsSize = diploAnimations.size();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void drawDiploAnimation(SpriteBatch oSB) {
        try {
            int i = iDiploAnimationsSize - 1;
            while (i >= 0) {
                diploAnimations.get(i).draw(oSB);
                if (Render.diploAnimations.get((int)i).remove) {
                    diploAnimations.remove(i);
                    iDiploAnimationsSize = diploAnimations.size();
                }
                --i;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void drawMapDetails(SpriteBatch oSB) {
        oRenderer.drawRendererMapDetails(oSB);
    }

    public static final void drawCivRegions_Names(SpriteBatch oSB) {
        try {
            oldTransformMatrix = oSB.getTransformMatrix().cpy();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            CFG.fontBorder.setColor(new Color(1.0f, 1.0f, 1.0f, CFG.settingsGD.PROVINCE_NAMES_ALPHA * (1.0f - Core.DRAW_PROVINCE_NAMES_ALPHA)));
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (!DISABLE_CIVS_NAMES || Core.DRAW_PROVINCE_NAMES_ALPHA < 0.99f) {
                for (int i = 0; i < CFG.NUM_OF_REGIONS_IN_VIEW; ++i) {
                    try {
                        for (int j = lRegions_Civs_RegionsID.get(i).size() - 1; j >= 0; --j) {
                            try {
                                if (!CFG.core.getCiv((int)Render.lRegions_Civs.get((int)i).intValue()).getCivRegion((int)Render.lRegions_Civs_RegionsID.get((int)i).get((int)j).intValue()).drawName || !(CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getFontScale() * (GameValues.gvInGame.DISABLE_DRAW_CIV_NAMES_SCALE_BASE + GameValues.gvInGame.DISABLE_DRAW_CIV_NAMES_SCALE_CURR_SCALE * CFG.map.getMpS().getCurrSc()) > CFG.settingsGD.CIV_NAMES_MIN_SCALE_OF_FONT)) continue;
                                if (CFG.map.getMpC().getSecondSideOfMap()) {
                                    CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).drawCivilizationName(oSB, CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getProvince(CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getShortestPath().get(0)), CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getFontScale());
                                    CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).drawCivilizationName_SecondSideOfMap(oSB, CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getProvince(CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getShortestPath().get(0)), CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getFontScale());
                                    continue;
                                }
                                CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).drawCivilizationName(oSB, CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getProvince(CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getShortestPath().get(0)), CFG.core.getCiv(lRegions_Civs.get(i)).getCivRegion(lRegions_Civs_RegionsID.get(i).get(j)).getFontScale());
                                continue;
                            }
                            catch (Exception ex) {
                                
                            }
                        }
                        continue;
                    }
                    catch (Exception exception) {
                        
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        oSB.setTransformMatrix(oldTransformMatrix);
    }

    public static final void updateDrawCivRegionNames_FogOfWar() {
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            try {
                for (int j = 0; j < CFG.core.getCiv(i).getCivRegionsSize(); ++j) {
                    CFG.core.getCiv(i).getCivRegion(j).updateDrawRegionName();
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void drawInGame(SpriteBatch oSB) {
        RenderProvince.drawProvincesInGame(oSB);
        if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
            CFG.core.drawActiveProvince(oSB);
            CFG.core.drawHighlightProvince(oSB);
            CFG.core.updateHighlitghtProvinceBorder(oSB);
            RenderProvince.drawProvincesBorder(oSB);
        } else {
            RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
        }
        CFG.core.drawActiveProvinceBorder(oSB);
    }

    
    public static final boolean drawInGame_WithoutScale_MapDetails() {
        if (!(CFG.map.getMpS().getCurrSc() >= 1.0f)) return false;
        float f = CFG.map.getMpS().getCurrSc();
        float f2 = CFG.getIsDesktop() ? CFG.settingsGD.STOP_SCALING_ARMY : CFG.settingsGD.STOP_SCALING_ARMY_MOBILE;
        if (!(f < f2)) return false;
        return true;
    }

    public static final boolean drawInGame_MapDetails() {
        return CFG.map.getMpS().getCurrSc() >= (CFG.getIsDesktop() ? CFG.settingsGD.STOP_SCALING_ARMY : CFG.settingsGD.STOP_SCALING_ARMY_MOBILE);
    }

    public static final boolean drawInGame_ZoomOutArmyDetails() {
        if (!CFG.menus.getInGameView()) {
            return false;
        }
        float f = CFG.map.getMpS().getCurrSc();
        if (f >= 1.0f) {
            return false;
        }
        return f > Render.getArmyVisibilityMinScale();
    }

    private static final float getArmyVisibilityMinScale() {
        int visRange = Math.max(0, Math.min(CFG.settingsGD.ARMY_VISIBILITY_RANGE, 4));
        switch (visRange) {
            case 1: {
                return 0.85f;
            }
            case 2: {
                return DISABLE_SEA_ARMIES;
            }
            case 3: {
                return DISABLE_INNER_BORDERS;
            }
            case 4: {
                return 0.15f;
            }
        }
        return 1.0f;
    }

    public static final void updateDrawMoveUnits() {
        block8: {
            try {
                if (CFG.menus.getInGameView()) {
                    if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.TURN_ACTIONS) {
                        oDrawMoveUnits = new DrawMoveUnits(){

                            @Override
                            public void drawMoveUnits(SpriteBatch oSB) {
                                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES && CFG.gameAction.getCurrentMoveunits() != null) {
                                    for (int i = 0; i < CFG.gameAction.getCurrentMoveunits().getMoveUnitsSize(); ++i) {
                                        CFG.gameAction.getCurrentMoveunits().getMoveUnits(i).draw(oSB, 1.0f);
                                    }
                                }
                            }

                            @Override
                            public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                                if (CFG.map.getMpS().getCurrSc() >= 1.0f && CFG.gameAction.getCurrentMoveunits() != null) {
                                    for (int i = 0; i < CFG.gameAction.getCurrentMoveunits().getMoveUnitsSize(); ++i) {
                                        CFG.gameAction.getCurrentMoveunits().getMoveUnits(i).draw(oSB, CFG.map.getMpS().getCurrSc());
                                    }
                                }
                            }
                        };
                        break block8;
                    }
                    try {
                        if (CFG.mapModesManager.getActiveMapModeID() == -1 || CFG.mapModesManager.getActiveMapModeID() >= 0 && CFG.mapModesManager.getActiveView().canMoveArmy()) {
                            oDrawMoveUnits = CFG.SPECTATOR_MODE ? new DrawMoveUnits(){

                                @Override
                                public void drawMoveUnits(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                                        CFG.core.drawMoveUnits_Spectactor(oSB, 1.0f);
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                                    }
                                }

                                @Override
                                public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                                        CFG.core.drawMoveUnits_Spectactor(oSB, CFG.map.getMpS().getCurrSc());
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                                    }
                                }
                            } : new DrawMoveUnits(){

                                @Override
                                public void drawMoveUnits(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                                        CFG.core.drawMoveUnits(oSB, 1.0f);
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                                    }
                                }

                                @Override
                                public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                                        CFG.core.drawMoveUnits(oSB, CFG.map.getMpS().getCurrSc());
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                                    }
                                }
                            };
                            break block8;
                        }
                        oDrawMoveUnits = new DrawMoveUnits(){

                            @Override
                            public void drawMoveUnits(SpriteBatch oSB) {
                            }

                            @Override
                            public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                            }
                        };
                    }
                    catch (NullPointerException e) {
                        if (CFG.SPECTATOR_MODE) {
                            oDrawMoveUnits = new DrawMoveUnits(){

                                @Override
                                public void drawMoveUnits(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                                        CFG.core.drawMoveUnits_Spectactor(oSB, 1.0f);
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                                    }
                                }

                                @Override
                                public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                                    if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                                        CFG.core.drawMoveUnits_Spectactor(oSB, CFG.map.getMpS().getCurrSc());
                                        CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                                    }
                                }
                            };
                            break block8;
                        }
                        oDrawMoveUnits = new DrawMoveUnits(){

                            @Override
                            public void drawMoveUnits(SpriteBatch oSB) {
                                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                                    CFG.core.drawMoveUnits(oSB, 1.0f);
                                    CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                                }
                            }

                            @Override
                            public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                                if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                                    CFG.core.drawMoveUnits(oSB, CFG.map.getMpS().getCurrSc());
                                    CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                                }
                            }
                        };
                    }
                    break block8;
                }
                oDrawMoveUnits = CFG.SPECTATOR_MODE ? new DrawMoveUnits(){

                    @Override
                    public void drawMoveUnits(SpriteBatch oSB) {
                        if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                            CFG.core.drawMoveUnits_Spectactor(oSB, 1.0f);
                            CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                        }
                    }

                    @Override
                    public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                        if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                            CFG.core.drawMoveUnits_Spectactor(oSB, CFG.map.getMpS().getCurrSc());
                            CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                        }
                    }
                } : new DrawMoveUnits(){

                    @Override
                    public void drawMoveUnits(SpriteBatch oSB) {
                        if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                            CFG.core.drawMoveUnits(oSB, 1.0f);
                            CFG.core.drawMoveUnits_CurrentMove(oSB, 1.0f);
                        }
                    }

                    @Override
                    public void drawMoveUnits_WithoutScale(SpriteBatch oSB) {
                        if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                            CFG.core.drawMoveUnits(oSB, CFG.map.getMpS().getCurrSc());
                            CFG.core.drawMoveUnits_CurrentMove(oSB, CFG.map.getMpS().getCurrSc());
                        }
                    }
                };
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void updateRenderer_CivNames() {
        PNM.uDPN();
        try {
            rendererCivRegionNames = CFG.menus.getInGameView() && !CFG.menus.getVisible_InGame_FlagAction() && CFG.settingsGD.DRAW_CIVILIZATIONS_NAMES_OVER_PROVINCES_IN_GAME && (CFG.menus.getInGameView() && (CFG.mapModesManager.getActiveMapModeID() < 0 || CFG.mapModesManager.getActiveView().drawCivNamesOver) || RTS.isEnabled() && !RTS.PAUSE) || CFG.menus.getInCreateNewGame() || CFG.menus.getInSettingsProvince() ? new RendererCivRegionNames(){

                @Override
                public void drawCRN(SpriteBatch oSB) {
                    Render.drawCivRegions_Names(oSB);
                }

                @Override
                public void update() {
                    Render.updateRegionsInView();
                }
            } : new RendererCivRegionNames(){

                @Override
                public void drawCRN(SpriteBatch oSB) {
                }

                @Override
                public void update() {
                }
            };
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void updateRenderer() {
        Render.updateRenderer_CivNames();
        oRenderer = CFG.menus.getInGameView() || CFG.menus.getInGame_PeaceTreaty() || CFG.menus.getInGame_PeaceTreaty_Response() || SaveGameManager.gameCanBeContinued && (CFG.menus.getInSettingsProvince() || CFG.menus.getInSettings()) ? (CFG.menus.getInGame_PeaceTreaty() && Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES || CFG.menus.getInGame_PeaceTreaty_Response() && Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_PeaceTreaty_FogOfWarDiscovery(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_PeaceTreaty_FogOfWarDiscovery(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvinces_Army_PeaceTreaty_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    CFG.core.drawProvinces_Army_PeaceTreaty_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_PeaceTreaty(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_PeaceTreaty(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_PeaceTreaty_Only_CivilizationBorder(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvinces_Army_PeaceTreaty(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities(oSB, 1.0f);
                    CFG.core.drawProvinces_Army_PeaceTreaty(oSB, 1.0f);
                }
            }
        }) : (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOAD_AI_RTO && CFG.gameAction.showNextPlayerTurnView() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_LoadAI_RTO(oSB);
                RenderProvince.drawProvincesBorder_LoadAI_RTO(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_LoadAI_RTO(oSB);
                RenderProvince.drawProvincesBorder_LoadAI_RTO(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        }) : (CFG.mapModesManager.getActiveMapModeID() >= 0 ? CFG.mapModesManager.getActiveView().oRenderer : (!CFG.getIsDesktop() && CFG.menus.getVisible_InGame_FlagAction() && !CFG.menus.getVisible_InGame_FlagAction_Console() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    if (CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery_Sea(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                    }
                }
                oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (TouchManager.bSMD) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    if (CFG.map.getMpS().getCurrSc() > DISABLE_SEA_ARMIES) {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Sea(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    }
                }
                oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (CFG.map.getMpS().getCurrSc() >= 1.0f) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                }
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (TouchManager.bSMD) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }))))) : (CFG.menus.getInGame_CreateAVassal() ? (CFG.mapModesManager.getActiveMapModeID() >= 0 ? CFG.mapModesManager.getActiveView().oRenderer : (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw_CreateAVassal(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All_FogOfWarDiscovery(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw_CreateAVassal(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }
        })) : (CFG.menus.getInGame_Timeline() || CFG.menus.getInVictory() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_Timeline_FogOfWar(oSB);
                if (TimelapseManager.PAUSE) {
                    CFG.core.drawActiveProvince(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_Timeline(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Timeline_OnlyCivilizationBorder(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline_FogOfWar(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_Timeline_FogOfWar(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline_FogOfWar(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f) {
                    CFG.core.drawCities_Timeline_FogOfWar_OnlyCapitalsImages(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_Timeline_FogOfWar(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline_FogOfWar(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_Timeline(oSB);
                if (TimelapseManager.PAUSE) {
                    CFG.core.drawActiveProvince(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_Timeline(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Timeline_OnlyCivilizationBorder(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_Timeline(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f) {
                    CFG.core.drawCities_Timeline_OnlyCapitalsImages(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_Timeline(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_Timeline(oSB, 1.0f);
                }
            }
        }) : (CFG.menus.getInGame_SelectProvinces() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All_FogOfWarDiscovery(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }
        }) : (CFG.menus.getInGame_ShowProvinces() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }
        }) : (CFG.menus.getInGame_TradeSelectCiv() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (CFG.map.getMpS().getCurrSc() < 1.0f && !DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }
        }) : (CFG.menus.getInStartGameMenu() || CFG.menus.getInEndGameMenu() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInStartGame_FogOfWarDiscovery(oSB);
                RenderProvince.drawProvincesBorderInStartGame_FogOfWar(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_StartTheGame_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_StartTheGame_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInStartGame(oSB);
                RenderProvince.drawProvincesBorderInStartGame(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_StartTheGame(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_StartTheGame(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        }) : (CFG.menus.getInGame_Formable_Civ_Provinces() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_FormableCiv_FogOfWarDiscovery(oSB);
                try {
                    if (CFG.getIsInFormableCiv(MenuManager.iHoveredProvinceID)) {
                        CFG.core.drawActiveProvince_HoverJust_WithoutDrawingActiveProvince(oSB);
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    try {
                        if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0) {
                            CFG.core.drawCities_OnlyFormableCivCapital(oSB, CFG.map.getMpS().getCurrSc());
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    try {
                        if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0) {
                            CFG.core.drawCities_OnlyFormableCivCapital(oSB, 1.0f);
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_FormableCiv(oSB);
                try {
                    if (CFG.getIsInFormableCiv(MenuManager.iHoveredProvinceID)) {
                        CFG.core.drawActiveProvince_HoverJust_WithoutDrawingActiveProvince(oSB);
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    try {
                        if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0) {
                            CFG.core.drawCities_OnlyFormableCivCapital(oSB, CFG.map.getMpS().getCurrSc());
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    try {
                        if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0) {
                            CFG.core.drawCities_OnlyFormableCivCapital(oSB, 1.0f);
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            }
        }) : (CFG.menus.getInGame_FormAnimation() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }) : (CFG.menus.getInGameAC() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                try {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)CFG.settingsGD.PROV_ALPHA * 0.6f / 255.0f));
                    if (Menu_InGame_AddCiv.provinceID >= 0 && CFG.core.getProv(Menu_InGame_AddCiv.provinceID).getDrawProv()) {
                        CFG.core.getProv(Menu_InGame_AddCiv.provinceID).drawProv_ActiveProv(oSB);
                    }
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)CFG.settingsGD.PROV_ALPHA * 0.5f / 255.0f));
                    for (int i = Menu_InGame_AddCiv.provinces.size() - 1; i >= 0; --i) {
                        CFG.core.getProv(Menu_InGame_AddCiv.provinces.get(i)).drawProv_ActiveProv(oSB);
                    }
                }
                catch (Exception exception) {
                    
                }
                oSB.setColor(Color.WHITE);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    if (CFG.map.getMpS().getCurrSc() > 0.65f) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    }
                }
            }
        } : (CFG.menus.getInCreateNewGame() ? (CFG.mapModesManager.getActiveMapModeID() >= 0 ? CFG.mapModesManager.getActiveView().oRenderer : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                try {
                    if (CFG.menus.getVisible_CreateNewGame_AddCiv() && Menu_CreateNewGame_AddCiv.provinceID >= 0) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)CFG.settingsGD.PROV_ALPHA * 0.6f / 255.0f));
                        if (CFG.core.getProv(Menu_CreateNewGame_AddCiv.provinceID).getDrawProv()) {
                            CFG.core.getProv(Menu_CreateNewGame_AddCiv.provinceID).drawProv_ActiveProv(oSB);
                        }
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)CFG.settingsGD.PROV_ALPHA * 0.5f / 255.0f));
                        for (int i = Menu_CreateNewGame_AddCiv.provinces.size() - 1; i >= 0; --i) {
                            CFG.core.getProv(Menu_CreateNewGame_AddCiv.provinces.get(i)).drawProv_ActiveProv(oSB);
                        }
                    }
                }
                catch (Exception exception) {
                    
                }
                oSB.setColor(Color.WHITE);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > DISABLE_INNER_BORDERS) {
                    if (CFG.map.getMpS().getCurrSc() > 0.65f) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    if (drawCivNamesInCreateNewGame) {
                        CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Vassals(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    }
                }
            }
        }) : (CFG.menus.getInRandomGame() || (CFG.menus.getInCreateScenario_Available_Provinces() || CFG.menus.getCreateScenario_ScenarioAge()) && CFG.backToMenu == View.eCREATE_RANDOM_GAME || CFG.menus.getInRandomGame_Civilizations_Select() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInCreateRandomGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                try {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                    for (int i = 0; i < CFG.randomGameManager.getPlayersSize(); ++i) {
                        if (CFG.randomGameManager.getPlayer(i).getCapitalProvinceID() < 0) continue;
                        CFG.core.getProv(CFG.randomGameManager.getPlayer(i).getCapitalProvinceID()).drawProvFlag_CreateRandomGame(oSB, i);
                    }
                }
                catch (NullPointerException nullPointerException) {
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
                oSB.setColor(Color.WHITE);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_CreateRandomGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInManageDiplomacy() || CFG.menus.getIn_CustomizeAlliance() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f) {
                    if (CFG.map.getMpS().getCurrSc() > 0.4f) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).isCapital()) {
                        CFG.core.drawCivilization_Name_Flag(oSB, CFG.core.getActiveProvID(), 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).isCapital()) {
                        CFG.core.drawCivilization_Name_Flag(oSB, CFG.core.getActiveProvID(), CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInNewGamePlayers() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() <= 0.25f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 0.25f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInSelectCiv() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                CFG.core.drawActiveProvinceFlag(oSB);
                oSB.setColor(Color.WHITE);
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getPlayer(i).getCivId() <= 0) continue;
                    CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getCapitalProvID()).drawProvFlag(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 0.25f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 0.25f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateScenario_Civilizations() || CFG.menus.getInCreateScenario_Civilizations_Select() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Crowns(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals_Crowns(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCrScAs() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    if (!CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawAllProvinces_Name_Flag(oSB, 1.0f);
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals(oSB, 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    if (!CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawAllProvinces_Name_Flag(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawAllCivilizations_Flag_InCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateScenario_Assign_Select() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateScenario_WastelandMap() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawLandProvincesBorder(oSB);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateScenario_SetUpArmy() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvincesArmy_SetUpArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    CFG.core.drawProvincesArmy_SetUpArmy(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInCreateScenario_Events_SelectProvinces() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInCreateScenario_Cores() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawCores_Flags(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    CFG.core.drawCores_Flags(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInMapEditor_FormableCivs_Edit() || CFG.menus.getInMapEditor_FormableCivs_SelectFormable() || CFG.menus.getInMapEditor_FormableCivs_SelectClaimant() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                if (CFG.VIEW_SHOW_VALUES) {
                    RenderProvince.drawProvincesInGame(oSB);
                } else {
                    CFG.core.updateProvincesInView();
                }
                CFG.core.getProvSelected().draw(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_DrawJustInnerBorder(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities_OnlyFormableCivCapital(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities_OnlyFormableCivCapital(oSB, 1.0f);
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_HolyRomanEmpire() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                if (CFG.VIEW_SHOW_VALUES) {
                    RenderProvince.drawProvincesInGame(oSB);
                } else {
                    CFG.core.updateProvincesInView();
                }
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.getProvSelected().draw_HolyRomanEmpire(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder_DrawJustInnerBorder(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    } else {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawCities_All(oSB, 1.0f);
                    } else {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    }
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInCreateScenario_Available_Provinces() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInSelectAvailableCivilizations() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInCreateNewGameSelectAvailableCivs(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawAllProvinces_Name_Flag(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawAllProvinces_Name_Flag(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getIn_MainMenu() || CFG.menus.getInGamesMenu() || CFG.menus.getInEditorMenu() || CFG.menus.getIn_AboutMenu() || CFG.menus.getIn_SKMenu() || CFG.menus.getIn_MMMenu() || CFG.menus.getIn_FBMenu() || CFG.menus.getIn_NVMenu() || CFG.menus.getIn_InitMenu() || CFG.menus.getInLoadMap() || CFG.menus.getInLoadSave() || CFG.menus.getIn_SaveTheGame() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInPalletOfCivsColorsEdit() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals_AvailableCivs(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawAllCivilizations_Name_Flag_InCapitals_AvailableCivs(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateCity() ? (CFG.backToMenu == View.eINGAME && CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                        RenderProvince.drawProvincesBorder(oSB);
                    } else {
                        RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                    }
                } else if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawEditorCity(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    CFG.core.drawEditorCity(oSB, 1.0f);
                }
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawEditorCity(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    CFG.core.drawEditorCity(oSB, 1.0f);
                }
            }
        }) : (CFG.menus.getInMapEditor_Create_NewContinent() || CFG.menus.getInMapEditor_Create_NewRegion() || CFG.menus.getInGameEditor_Create_DiplomacyPackage() || CFG.menus.getInGameEditor_ReligionAdd() || CFG.menus.getInGameEditor_TerrainAdd() || CFG.menus.getInEditor_GameCivs() || CFG.menus.getInCreateCivilization() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_Terrain() || CFG.menus.getInMapEditor_Continents() || CFG.menus.getInMapEditor_Regions() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_GrowthRate() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince_HoverJust_WithoutDrawingActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_GrowthRate(oSB, 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_GrowthRate(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInCreateScenario_TechnologyLevels() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_TechnologyLevels(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_TechnologyLevels(oSB, 1.0f);
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_Happiness() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_Happiness(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_Happiness(oSB, 1.0f);
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_StartingMoney() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_StartingMoney(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    if (CFG.VIEW_SHOW_VALUES) {
                        CFG.core.drawProvinces_StartingMoney(oSB, 1.0f);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_ArmyPosition() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince_HoverJust_WithoutDrawingActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvinces_ArmyPosition(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                    CFG.core.drawProvinces_ArmyPosition(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInMapEditor_PortPosition() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawProvinces_Ports(oSB, 1.0f);
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawProvinces_Ports(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_ProvinceBackground() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.VIEW_SHOW_VALUES) {
                    RenderProvince.drawProvincesBorder(oSB);
                    CFG.core.drawActiveProvinceBorder(oSB);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_LoadPreDefinedBorders() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_InLoad_PreDefinedBorders(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_LoadSuggestedOwners() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInSelectLanguage() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_WastelandMaps_Edit() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesIn_MapEditor_WastelandMaps(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_All(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_All(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInGameEditor_Regions() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGameEditorRegions(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f && Menu_MapEditor_OptimizationRegions.showValues) {
                    CFG.core.drawProvinces_OptimizationRegions(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f && Menu_MapEditor_OptimizationRegions.showValues) {
                    CFG.core.drawProvinces_OptimizationRegions(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_SeaProvinces() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInMapEditor_SeaProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawProvinces_SeaProvincesLevels(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawProvinces_SeaProvincesLevels(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_ArmySeaBoxes() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInMapEditor_ArmySeaBoxes(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawProvinces_SeaArmyBoxes(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawProvinces_SeaArmyBoxes(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_Connections() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInMapEditor_Connections(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawProvinces_ArmyPosition(oSB, 1.0f);
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 >= 0 && CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getDrawProv()) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).drawArmyPosition_Active(oSB, 1.0f);
                    }
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawProvinces_ArmyPosition(oSB, CFG.map.getMpS().getCurrSc());
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 >= 0 && CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getDrawProv()) {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).drawArmyPosition_Active(oSB, CFG.map.getMpS().getCurrSc());
                    }
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInSettingsProvince() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                if (CFG.FOG_OF_WAR == 2) {
                    RenderProvince.drawOccupiedProvinces_FogOfWar(oSB);
                } else {
                    RenderProvince.drawOccupiedProvinces(oSB);
                }
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvinces_ArmyPosition_Capitals(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities(oSB, 1.0f);
                    CFG.core.drawProvinces_ArmyPosition_Capitals(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInMapEditor_ArmySeaBoxes_Edit() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInMapEditor_ArmySeaBoxes_Edit(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawProvinces_SeaArmyBoxes_Edit(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawProvinces_SeaArmyBoxes_Edit(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_ArmySeaBoxes_Add() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInMapEditor_ArmySeaBoxes_Add(oSB);
                CFG.core.drawActiveProvince(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInNextPlayerTurn() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_NextPlayer_Turn(oSB);
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery_Old(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery_Old(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_NextPlayer_Turn(oSB);
                RenderProvince.drawProvincesBorder_NextPlayer(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_Old(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_Old(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        }) : (CFG.menus.getIn_Game_CivilizationView() ? (CFG.FOG_OF_WAR == 2 ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_CivilizationView_FogOfWar(oSB);
                RenderProvince.drawProvincesBorder_CivilizationView(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery_Old(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery_Old(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces_CivilizationView(oSB);
                RenderProvince.drawProvincesBorder_CivilizationView(oSB);
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities_OnlyCapitals_Old(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities_OnlyCapitals_Old(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        }) : (CFG.menus.getInCreateScenario_Preview() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                CFG.core.drawActiveProvince(oSB);
                RenderProvince.drawProvincesBorder(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                }
            }
        } : (CFG.menus.getInPrintAMap() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                oSB.setColor(new Color(0.06666667f, 0.11764706f, 0.19607843f, 1.0f));
                IMGManager.getIMG(Images.pix255).draw2O(oSB, 0, -IMGManager.getIMG(Images.pix255).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(Color.WHITE);
                RenderProvince.drawProvinces_PrintAMap(oSB);
                RenderProvince.drawProvincesBorder_PrintAMap(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : (CFG.menus.getInMapEditor_ProvinceName() ? new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities(oSB, 1.0f);
                }
                if (CFG.core.getActiveProvID() >= 0) {
                    PNM.dPNP(oSB, CFG.core.getActiveProvID());
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        } : new Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= DISABLE_INNER_BORDERS) {
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                if (CFG.map.getMpS().getCurrSc() <= 1.0f && CFG.map.getMpS().getCurrSc() > 0.4f) {
                    CFG.core.drawCities(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                    CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        })))))))))))))))))))))))))))))))))))))))))))))))))))));
    }

    static {
        DISABLE_INNER_BORDERS = 0.4f;
        DISABLE_SEA_ARMIES = 0.65f;
        CIV_NAMES_START_DRAWING_NAMES_MAP_SCALE = 1.0f;
        CIVILIZATION_NAMES_ALPHA = 1.0f;
        CIVILIZATIONS_NAMES_TIME = 0L;
        lRegions_Civs = new ArrayList<Integer>();
        lRegions_Civs_RegionsID = new ArrayList<List<Integer>>();
        diploAnimations = new ArrayList<DiploAnimation>();
        iDiploAnimationsSize = 0;
    }

    public static interface Renderer {
        public void drawRenderer(SpriteBatch var1);

        public void drawRendererWithoutScale(SpriteBatch var1);

        public void drawRendererMapDetails(SpriteBatch var1);
    }

    public static interface RendererCivRegionNames {
        public void drawCRN(SpriteBatch var1);

        public void update();
    }

    public static interface DrawMoveUnits {
        public void drawMoveUnits(SpriteBatch var1);

        public void drawMoveUnits_WithoutScale(SpriteBatch var1);
    }
}
