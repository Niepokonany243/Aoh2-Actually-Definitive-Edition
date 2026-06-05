
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_Continents;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_GrowthRate;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_MapRegions;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_Regions;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_TerrainType;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menus.ArmyS.Menu_MapEditor_ArmySeaBoxes_Add;
import age.of.civilizations2.jakowski.lukasz.Menus.CivN.Menu_CreateNewGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Formable.AddCiv.Menu_InGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Province.Menu_InGame_RelocatePopulation;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response.Menu_PeaceTreaty_Response;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.MapA.MissileManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest.Menu_InGame_TradeRequest_SelectCiv;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class TouchManager {
    private boolean actionMap = false;
    private int stMvPX;
    private int stMvPY;
    private boolean updateStartMovePosX;
    private boolean updateStartMovePosY;
    private long lSelectionTime = 0L;
    private long actDTm = 0L;
    private boolean enableScaling = false;
    private boolean actionBrushMove = false;
    private boolean actionBrush = false;
    public boolean enSMD = true;
    public static boolean bSMD = false;
    public int iSBXX;
    public int iSBXY;
    public int iSBXW;
    public int iSBXH;
    private ExtraAction mpAMEAc;
    private ExtraAction mAcUEA;
    private ExtraAction mAxDEA;
    private ExtraAction mAcUSAPEAc;
    private int actDPoX;
    private int actDPoY;
    private ReverseDirection revDirectionX;
    private ReverseDirection revDirectionY;
    private ReverseDirection2 revDirectionX2;
    private ReverseDirection2 revDirectionY2;
    public static List<Integer> lMABX = new ArrayList<Integer>();
    public static int rODS = -1;

    public TouchManager() {
        this.buildReversePosX();
        this.buildReversePosY();
        this.buildReversePosX2();
        this.buildReversePosY2();
        this.ueExA();
    }

    public final void updateEnableScaling() {
        this.enableScaling = !CFG.menus.getIn_MainMenu() && !CFG.menus.getIn_AboutMenu() && !CFG.menus.getIn_SKMenu() && !CFG.menus.getIn_MMMenu() && !CFG.menus.getIn_FBMenu() && !CFG.menus.getIn_NVMenu() && !CFG.menus.getIn_InitMenu() && !CFG.menus.getInLoadMap() && !CFG.menus.getInLoadSave();
    }

    public final void dSMD(SpriteBatch oSB) {
        if (bSMD) {
            try {
                int nX = this.iSBXX;
                if (this.iSBXW == 0) {
                    this.iSBXW = 1;
                } else if (this.iSBXW < 0) {
                    nX += this.iSBXW;
                }
                int nY = this.iSBXY;
                if (this.iSBXH == 0) {
                    this.iSBXH = 1;
                } else if (this.iSBXH < 0) {
                    nY += this.iSBXH;
                }
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.075f));
                Images.pix.draw(oSB, nX, nY, Math.abs(this.iSBXW), Math.abs(this.iSBXH));
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.275f));
                Renderer.drawBox2(oSB, nX, nY, Math.abs(this.iSBXW), Math.abs(this.iSBXH), 1.0f);
                oSB.setColor(Color.WHITE);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void actionDown(int nPosX, int nPosY, int nPointer, int button) {
        this.lSelectionTime = System.currentTimeMillis();
        this.actionMap = true;
        this.actionBrush = false;
        this.actionBrushMove = false;
        if (CFG.map.getMpSl().getScrollingTheMap()) {
            CFG.map.getMpSl().stopScrollingTheMap();
        }
        this.stMvPX = this.revDirectionX.getStartMovePos((int)((float)nPosX / CFG.map.getMpS().getCurrSc()));
        this.stMvPY = this.revDirectionY.getStartMovePos((int)((float)nPosY / CFG.map.getMpS().getCurrSc()));
        this.actDPoX = nPosX;
        this.actDPoY = nPosY;
        if (this.enSMD && button == 2) {
            this.iSBXX = nPosX;
            this.iSBXY = nPosY;
            this.iSBXW = 1;
            this.iSBXH = 1;
            CFG.brushMode = false;
            bSMD = true;
            return;
        }
        bSMD = false;
        this.mAxDEA.extraAction(nPosX, nPosY);
    }

    public final void actionMove(int nPosX, int nPosY) {
        if (CFG.brushMode) {
            this.actDPoX = nPosX;
            this.actDPoY = nPosY;
            this.actionUp_setActiveProvinceID(nPosX, nPosY);
            return;
        }
        if (bSMD) {
            this.iSBXW = nPosX - this.iSBXX;
            this.iSBXH = nPosY - this.iSBXY;
            return;
        }
        this.actionMoveMap(nPosX, nPosY);
    }

    public final void actionMoveMap(int nPosX, int nPosY) {
        if (!CFG.map.getMpC().getDisableMovingMap()) {
            if (this.updateStartMovePosX) {
                this.stMvPX = this.revDirectionX.getStartMovePos((int)((float)nPosX / CFG.map.getMpS().getCurrSc()));
                this.stMvPY = this.revDirectionY.getStartMovePos((int)((float)nPosY / CFG.map.getMpS().getCurrSc()));
                this.updateStartMovePosX = false;
            }
            if (this.updateStartMovePosY) {
                this.stMvPX = this.revDirectionX.getStartMovePos((int)((float)nPosX / CFG.map.getMpS().getCurrSc()));
                this.stMvPY = this.revDirectionY.getStartMovePos((int)((float)nPosY / CFG.map.getMpS().getCurrSc()));
                this.updateStartMovePosY = false;
            }
            CFG.map.getMpC().setNewPosX(this.revDirectionX2.getNewPos(this.stMvPX, (int)((float)nPosX / CFG.map.getMpS().getCurrSc())));
            CFG.map.getMpC().setNewPosY(this.revDirectionY2.getNewPos(this.stMvPY, (int)((float)nPosY / CFG.map.getMpS().getCurrSc())));
        } else {
            this.mpAMEAc.extraAction(nPosX, nPosY);
        }
    }

    public final void actionMove(int nPosX, int nPosY, int nPosX2, int nPosY2) {
        if (!CFG.map.getMpC().getDisableMovingMap() && this.enableScaling) {
            if (CFG.map.getMpS().getStartScalePosY() <= 0) {
                CFG.map.getMpS().startScaleTheMap(nPosX, nPosX2, nPosY, nPosY2);
            } else {
                CFG.map.getMpS().scaleTheMap(nPosX, nPosX2, nPosY, nPosY2);
            }
        }
    }

    public final void actionUp(int nPosX, int nPosY, int nPointer, int button) {
        if (CFG.MISSILE_STRIKE_MODE && button == 2 && CFG.menus.getInGameView()) {
            bSMD = false;
            if (Math.abs(nPosX - this.iSBXX) <= CFG.PADD && Math.abs(nPosY - this.iSBXY) <= CFG.PADD) {
                int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                CFG.core.setProvinceID((int)((float)nPosX / CFG.map.getMpS().getCurrSc()), (int)((float)nPosY / CFG.map.getMpS().getCurrSc()));
                int targetProvID = CFG.core.getActiveProvID();
                if (MissileManager.canStrikeProvince(playerCivID, targetProvID, true)) {
                    MissileManager.strikeProvince(playerCivID, targetProvID);
                    CFG.gameAction.updateInGame_ProvinceInfo();
                    CFG.menus.updateInGameTopAll(playerCivID);
                } else {
                    CFG.MISSILE_STRIKE_MODE = false;
                }
                return;
            }
            this.aUSM(nPosX, nPosY);
            return;
        }
        if (bSMD && (button == 2 || !CFG.getIsDesktop())) {
            bSMD = false;
            if (button == 2 && CFG.menus.getInGame_PeaceTreaty() && Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES && Math.abs(nPosX - this.iSBXX) <= CFG.PADD && Math.abs(nPosY - this.iSBXY) <= CFG.PADD) {
                this.actionUp_setActiveProvinceID(nPosX, nPosY);
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.peaceTreatyData.drawProvOwners.get((int)CFG.core.getActiveProvID()).isTaken <= 0) {
                    CFG.peaceTreatyData.takeProvince(CFG.core.getActiveProvID(), CFG.peaceTreatyData.brushCivID, CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getIsPlayer() ? CFG.peaceTreatyData.brushCivID : CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
                }
                return;
            }
            this.aUSM(nPosX, nPosY);
            return;
        }
        if (!CFG.regroupArmyMode && CFG.core.getActiveProvID() != rODS) {
            TouchManager.cMABX();
        }
        if (CFG.MISSILE_STRIKE_MODE && CFG.menus.getInGameView()) {
            int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            CFG.core.setProvinceID((int)((float)nPosX / CFG.map.getMpS().getCurrSc()), (int)((float)nPosY / CFG.map.getMpS().getCurrSc()));
            int targetProvID = CFG.core.getActiveProvID();
            if (MissileManager.canStrikeProvince(playerCivID, targetProvID, true)) {
                MissileManager.strikeProvince(playerCivID, targetProvID);
                CFG.gameAction.updateInGame_ProvinceInfo();
                CFG.menus.updateInGameTopAll(playerCivID);
            } else {
                CFG.MISSILE_STRIKE_MODE = false;
            }
            return;
        }
        this.actionUp_setActiveProvinceID(nPosX, nPosY);
        if (CFG.menus.getActiveMenuElemeID() < 0 && this.enableScaling) {
            CFG.map.getMpS().resetScaleOfMap(System.currentTimeMillis());
        }
        if (!CFG.map.getMpS().getScaleMode() && !CFG.map.getMpC().getDisableMovingMap() && CFG.menus.getActiveMenuElemeID() < 0) {
            CFG.map.getMpSl().startScrollingTheMap();
        }
        this.mAcUEA.extraAction(nPosX, nPosY);
    }

    public static final void adMABX(int provinceID) {
        try {
            if (lMABX.isEmpty()) {
                rODS = CFG.core.getActiveProvID();
            }
            int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            for (int i = 0; i < CFG.core.getProv((int)provinceID).provGD.civsSize; ++i) {
                int armyCivID = CFG.core.getProv(provinceID).getCivId(i);
                if (CFG.core.getProv(provinceID).getArmyID(i) <= 0) continue;
                if (armyCivID == playerCivID) {
                    lMABX.add(provinceID);
                    return;
                }
                if (CFG.core.getCiv(armyCivID).getPuppetOfCiv() == playerCivID) {
                    if (!CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.VASSALS_INDEPENDENT_ARMY) {
                        lMABX.add(provinceID);
                        return;
                    }
                    if (CFG.core.getProv(provinceID).getCivId() != armyCivID) {
                        lMABX.add(provinceID);
                        return;
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void mABXUP() {
        for (int i = 0; i < lMABX.size(); ++i) {
            CFG.core.getProv(lMABX.get(i)).updateDrawArmyInProv();
        }
    }

    public static final void cMABX() {
        try {
            if (!lMABX.isEmpty()) {
                int i;
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                for (i = 0; i < lMABX.size(); ++i) {
                    tempList.add(lMABX.get(i));
                }
                lMABX.clear();
                for (i = 0; i < tempList.size(); ++i) {
                    CFG.core.getProv((Integer)tempList.get(i)).updateDrawArmyInProv();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void mABX() {
        try {
            int toProvinceID = CFG.chosenProvinceID;
            boolean armyMoved = false;
            int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            block2: for (int i = 0; i < lMABX.size(); ++i) {
                for (int j = 0; j < CFG.core.getProv((int)TouchManager.lMABX.get((int)i).intValue()).provGD.civsSize; ++j) {
                    int armyCivID = CFG.core.getProv(lMABX.get(i)).getCivId(j);
                    long armyUnits = CFG.core.getProv(lMABX.get(i)).getArmyID(j);
                    if (armyUnits <= 0) continue;
                    boolean isPlayerArmy = (armyCivID == playerCivID);
                    boolean isVassalArmy = false;
                    if (!isPlayerArmy && CFG.core.getCiv(armyCivID).getPuppetOfCiv() == playerCivID) {
                        if (!CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.VASSALS_INDEPENDENT_ARMY) {
                            isVassalArmy = true;
                        } else if (CFG.core.getProv(lMABX.get(i)).getCivId() != armyCivID) {
                            isVassalArmy = true;
                        }
                    }
                    if (!isPlayerArmy && !isVassalArmy) continue;
                    int moveCivID = armyCivID;
                    RegroupArmy currentRegroupArmy = new RegroupArmy(moveCivID, lMABX.get(i), toProvinceID);
                    long numOfUnitsToMove = armyUnits;
                    int vassalMPSave = 0;
                    int playerCostToDeduct = 0;
                    if (isVassalArmy && CFG.core.getProv(lMABX.get(i)).getCivId() == playerCivID && CFG.core.getCiv(armyCivID).getMovemPoints() <= 0 && currentRegroupArmy.getRouteSize() > 0) {
                        int firstDest = currentRegroupArmy.getRouteSize() == 1 ? toProvinceID : currentRegroupArmy.getRoute(0);
                        playerCostToDeduct = CFG.gameAction.costOfMoveArmy(lMABX.get(i), firstDest, playerCivID);
                        if (CFG.core.getCiv(playerCivID).getMovemPoints() >= playerCostToDeduct) {
                            vassalMPSave = CFG.core.getCiv(armyCivID).getMovemPoints();
                            int vassalCost = CFG.gameAction.costOfMoveArmy(lMABX.get(i), firstDest, armyCivID);
                            CFG.core.getCiv(armyCivID).setMovementPoints(vassalCost + 1);
                        }
                    }
                    if (currentRegroupArmy.getRouteSize() == 1) {
                        CFG.gameAction.moveArmyAction(lMABX.get(i), toProvinceID, numOfUnitsToMove, moveCivID, true, true);
                        if (vassalMPSave != 0) {
                            CFG.core.getCiv(armyCivID).setMovementPoints(vassalMPSave);
                            CFG.core.getCiv(playerCivID).setMovementPoints(CFG.core.getCiv(playerCivID).getMovemPoints() - playerCostToDeduct);
                        }
                        armyMoved = true;
                        continue block2;
                    }
                    if (currentRegroupArmy.getRouteSize() <= 0) {
                        if (vassalMPSave != 0) {
                            CFG.core.getCiv(armyCivID).setMovementPoints(vassalMPSave);
                        }
                        continue block2;
                    }
                    if (currentRegroupArmy.getRouteSize() == 1) {
                        CFG.gameAction.moveArmyAction(lMABX.get(i), currentRegroupArmy.getRoute(0), numOfUnitsToMove, moveCivID, true, true);
                        if (vassalMPSave != 0) {
                            CFG.core.getCiv(armyCivID).setMovementPoints(vassalMPSave);
                            CFG.core.getCiv(playerCivID).setMovementPoints(CFG.core.getCiv(playerCivID).getMovemPoints() - playerCostToDeduct);
                        }
                        continue block2;
                    }
                    if (!CFG.gameAction.moveArmyAction(lMABX.get(i), currentRegroupArmy.getRoute(0), numOfUnitsToMove, moveCivID, true, true)) {
                        if (vassalMPSave != 0) {
                            CFG.core.getCiv(armyCivID).setMovementPoints(vassalMPSave);
                        }
                        continue block2;
                    }
                    if (vassalMPSave != 0) {
                        CFG.core.getCiv(armyCivID).setMovementPoints(vassalMPSave);
                        CFG.core.getCiv(playerCivID).setMovementPoints(CFG.core.getCiv(playerCivID).getMovemPoints() - playerCostToDeduct);
                    }
                    currentRegroupArmy.setFromProvinceID(currentRegroupArmy.getRoute(0));
                    currentRegroupArmy.removeRoute(0);
                    currentRegroupArmy.setNumOfUnits((int)numOfUnitsToMove);
                    CFG.core.getCiv(moveCivID).addRegroupArmy(currentRegroupArmy);
                    armyMoved = true;
                    continue block2;
                }
            }

            if (armyMoved) {
                CFG.SFXManager.playSound(CFG.SFXManager.playMoveArmy());
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        CFG.menus.setVisible_InGame_ActionInfo(false);
        CFG.core.resetRegroupArmy_Data();
        CFG.core.checkProvinceActionMenu();
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setNoOrders(false);
        if (RTS.isEnabled() && !RTS.PAUSE) {
            RTS.updateTimePast_AfterAction(0.75f);
        }
        TouchManager.cMABX();
    }

    public final void aUSM(int nMaxX, int nMaxY) {
        try {
            int added = 0;
            int i;
            if (this.iSBXX == nMaxX || this.iSBXY == nMaxY) {
                return;
            }
            if (this.iSBXX > nMaxX) {
                int tX = this.iSBXX;
                this.iSBXX = nMaxX;
                nMaxX = tX;
            }
            if (this.iSBXY > nMaxY) {
                int tY = this.iSBXY;
                this.iSBXY = nMaxY;
                nMaxY = tY;
            }
            if (CFG.menus.getInCrScAs()) {
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.createScenarioAssignProvsCiv < 0) continue;
                    boolean cont = false;
                    for (int a = 1; a < CFG.core.getCivsSize(); ++a) {
                        if (CFG.core.getCiv(a).getCapitalProvID() != CFG.core.getPIV(i)) continue;
                        cont = true;
                        break;
                    }
                    if (cont || CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.createScenarioAssignProvsCiv || CFG.core.getProv(CFG.core.getPIV(i)).getWastelandLvl() >= 0) continue;
                    if (CFG.SCENARIO_EDITOR_OCCUPATION) {
                        CFG.core.getProv(CFG.core.getPIV(i)).setCivId(CFG.createScenarioAssignProvsCiv, false, false);
                        CFG.core.getProv(CFG.core.getPIV(i)).resetArmiesAll(-1);
                        CFG.core.getProv(CFG.core.getPIV(i)).buildProvinceCore();
                        CFG.core.setActiveProvID(CFG.core.getPIV(i));
                        continue;
                    }
                    CFG.addUndoAssignProvinces(CFG.core.getPIV(i), CFG.core.getProv(CFG.core.getPIV(i)).getCivId());
                    CFG.core.getProv(CFG.core.getPIV(i)).setCivId(CFG.createScenarioAssignProvsCiv, false, false);
                    CFG.core.getProv(CFG.core.getPIV(i)).setTrueOwnerOfProv(CFG.createScenarioAssignProvsCiv);
                    CFG.core.getProv(CFG.core.getPIV(i)).resetArmiesAll(-1);
                    CFG.core.getProv(CFG.core.getPIV(i)).buildProvinceCore();
                    CFG.core.setActiveProvID(CFG.core.getPIV(i));
                }
            } else if (CFG.menus.getInMapEditor_FormableCivs_Edit()) {
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getSeaProv() || !TouchManager.aUSMIIBXC(CFG.core.getPIV(i), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                    if (CFG.selectMode) {
                        if (CFG.core.getPIV(i) < 0 || CFG.core.getProv(CFG.core.getPIV(i)).getSeaProv()) continue;
                        CFG.core.getProvSelected().addProv(CFG.core.getPIV(i));
                        continue;
                    }
                    CFG.core.getProvSelected().removeProv(CFG.core.getPIV(i));
                }
            } else if (CFG.menus.getInCreateNewGame()) {
                added = 0;
                if (CFG.menus.getVisible_CreateNewGame_AddCiv()) {
                    for (int i2 = 0; i2 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i2) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i2), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                        if (Menu_CreateNewGame_AddCiv.addProvinceMode) {
                            if (CFG.core.getPIV(i2) < 0 || CFG.core.getProv(CFG.core.getPIV(i2)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getPIV(i2)).getSeaProv() || CFG.core.getProv(CFG.core.getPIV(i2)).getIsCapital2()) continue;
                            Menu_CreateNewGame_AddCiv.addProvince(CFG.core.getPIV(i2));
                            ++added;
                            continue;
                        }
                        Menu_CreateNewGame_AddCiv.removeProvince(CFG.core.getPIV(i2));
                        ++added;
                    }
                }
                if (added > 0) {
                    CFG.menus.rebuildCreateNewGame_AddCiv();
                }
            } else if (CFG.menus.getInGameAC()) {
                added = 0;
                for (int i3 = 0; i3 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i3) {
                    if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i3), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                    if (Menu_InGame_AddCiv.addProvinceMode) {
                        if (CFG.core.getPIV(i3) < 0 || CFG.core.getProv(CFG.core.getPIV(i3)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getPIV(i3)).getSeaProv() || CFG.core.getProv(CFG.core.getPIV(i3)).getIsCapital2()) continue;
                        Menu_InGame_AddCiv.addProvince(CFG.core.getPIV(i3));
                        ++added;
                        continue;
                    }
                    Menu_InGame_AddCiv.removeProvince(CFG.core.getPIV(i3));
                    ++added;
                }
                if (added > 0) {
                    CFG.menus.rebuildInGame_AddCiv();
                }
            } else if (CFG.menus.getInGame_PeaceTreaty()) {
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0 || !Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES || CFG.peaceTreatyData.drawProvOwners.get((int)CFG.core.getPIV((int)i)).isTaken > 0) continue;
                    CFG.peaceTreatyData.takeProvince(CFG.core.getPIV(i), CFG.peaceTreatyData.brushCivID, CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getIsPlayer() ? CFG.peaceTreatyData.brushCivID : CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
                }
            } else if (CFG.menus.getInGameView()) {
                int actionDone;
                if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                    actionDone = 0;
                    for (int i4 = 0; i4 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i4) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i4), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i4)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i4)).isOccupied() || Core.ISIP(CFG.core.getPIV(i4))) continue;
                        Core.MRPRV(CFG.core.getPIV(i4));
                        ++actionDone;
                    }
                    if (actionDone > 0) {
                        CFG.gameAction.IEU();
                        Core.dARA((int)CFG.menus.getInGame_ProvRecruitSlider().getCurrLong());
                        CFG.menus.updateInGame_ActionInfo_Recruit();
                    }
                } else if (CFG.menus.getInGame_SendMessage().getVisibleM() && CFG.menus.getInGame_SendMessage() instanceof Menu_InGame_RelocatePopulation) {
                    int clickedProv = -1;
                    for (int i8 = 0; i8 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i8) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i8), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                        if (CFG.core.getProv(CFG.core.getPIV(i8)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i8)).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            clickedProv = CFG.core.getPIV(i8);
                            break;
                        }
                    }
                    if (clickedProv >= 0) {
                        if (Menu_InGame_RelocatePopulation.fromProvinceIDs.isEmpty()) {
                            Menu_InGame_RelocatePopulation.addFromProvince(clickedProv);
                            CFG.menus.rebuildInGame_Build_RelocatePopulation(clickedProv);
                        } else if (!Menu_InGame_RelocatePopulation.fromProvinceIDs.contains(clickedProv)) {
                            Menu_InGame_RelocatePopulation.toProvinceID = clickedProv;
                            CFG.menus.rebuildInGame_Build_RelocatePopulation(Menu_InGame_RelocatePopulation.fromProvinceIDs.get(0));
                        }
                    }
                } else if (CFG.MISSILE_STRIKE_MODE && CFG.menus.getInGameView()) {
                    int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    boolean anyStrike = false;
                    for (int i8 = 0; i8 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i8) {
                        int targetPID = CFG.core.getPIV(i8);
                        if (!TouchManager.aUSMIIBXC(targetPID, this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                        if (!MissileManager.canStrikeProvince(playerCivID, targetPID, true)) continue;
                        MissileManager.strikeProvince(playerCivID, targetPID);
                        anyStrike = true;
                    }
                    if (!anyStrike) {
                        CFG.MISSILE_STRIKE_MODE = false;
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == -1 || CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ARMY_MODE) {
                    TouchManager.cMABX();
                    for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                        int tProvID = CFG.core.getPIV(i);
                        int tCivID = CFG.core.getProv(tProvID).getCivId();
                        int tPlayerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        if (tCivID != tPlayerCivID && CFG.core.getProv(tProvID).getArmyCivID1(tPlayerCivID) <= 0) {
                            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.VASSALS_INDEPENDENT_ARMY || CFG.core.getCiv(tCivID).getPuppetOfCiv() != tPlayerCivID || CFG.core.getProv(tProvID).getArmyCivID1(tCivID) <= 0) continue;
                        }
                        TouchManager.adMABX(tProvID);
                    }
                    for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPSVI(i), this.iSBXX, this.iSBXY, nMaxX, nMaxY)) continue;
                        int tProvID = CFG.core.getPSVI(i);
                        int tCivID = CFG.core.getProv(tProvID).getCivId();
                        int tPlayerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        if (tCivID != tPlayerCivID && CFG.core.getProv(tProvID).getArmyCivID1(tPlayerCivID) <= 0) {
                            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.VASSALS_INDEPENDENT_ARMY || CFG.core.getCiv(tCivID).getPuppetOfCiv() != tPlayerCivID || CFG.core.getProv(tProvID).getArmyCivID1(tCivID) <= 0) continue;
                        }
                        TouchManager.adMABX(tProvID);
                    }
                    TouchManager.mABXUP();
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                    actionDone = 0;
                    for (int i5 = 0; i5 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i5) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i5), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i5)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i5)).isOccupied()) continue;
                        long maxValue = GameManager.investMaxDevGold(CFG.core.getPIV(i5), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        if (!GameManager.investDevelopment(CFG.core.getPIV(i5), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), maxValue)) continue;
                        ++actionDone;
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_DEVELOPMENT_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i5)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest"), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoDev);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewDevelopment(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                    actionDone = 0;
                    for (int i6 = 0; i6 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i6) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i6), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i6)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i6)).isOccupied()) continue;
                        long maxValue = GameManager.invest_MaxEconomy_Gold(CFG.core.getPIV(i6), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        if (!GameManager.invest(CFG.core.getPIV(i6), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), maxValue)) continue;
                        ++actionDone;
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_ECONOMY_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i6)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest"), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoEconomy);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewEconomy(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    actionDone = 0;
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        int inCivID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                        for (int i7 = 0; i7 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i7) {
                            if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i7), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i7)).getCivId() != inCivID || CFG.core.getProv(CFG.core.getPIV(i7)).isOccupied()) continue;
                            ArrayList<Integer> provinces = new ArrayList<Integer>();
                            provinces.add(CFG.core.getPIV(i7));
                            if (!GameManager.spreadPropaganda(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), inCivID, provinces)) continue;
                            ++actionDone;
                            if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_HAPPINESS_MODE) continue;
                            CFG.core.getProv((int)CFG.core.getPIV((int)i7)).viewBool = true;
                        }
                        if (actionDone > 0) {
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("SpreadPropaganda") + ": " + actionDone, CFG.core.getCiv(inCivID).getCivName(), Images.infoDiplomacy);
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                                CFG.menus.setVisible_InGame_ViewHappiness(true);
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_CLICK);
                        } else {
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                            CFG.toastM.setTimeInView(3500);
                        }
                    } else {
                        for (int i8 = 0; i8 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i8) {
                            if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i8), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i8)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i8)).isOccupied() || !Festival.addFestival(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPIV(i8))) continue;
                            ++actionDone;
                            if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_HAPPINESS_MODE) continue;
                            CFG.core.getProv((int)CFG.core.getPIV((int)i8)).viewBool = true;
                        }
                        if (actionDone > 0) {
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Festival"), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoFestival);
                            CFG.SFXManager.playSound(SFXManager.SFX_CLICK);
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                                CFG.menus.setVisible_InGame_ViewHappiness(true);
                            }
                        } else {
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                            CFG.toastM.setTimeInView(3500);
                        }
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                    actionDone = 0;
                    for (int i9 = 0; i9 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i9) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i9), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i9)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i9)).isOccupied()) continue;
                        int nMax = 0;
                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(CFG.core.getPIV(i9), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX)) {
                            nMax = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX;
                        } else {
                            int a = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX - 1;
                            while (a >= 5) {
                                nMax = a--;
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(CFG.core.getPIV(i9), nMax)) break;
                            }
                        }
                        if (!GameManager.addAssi(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPIV(i9), nMax)) continue;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                            CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                        }
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                            CFG.core.getProv((int)CFG.core.getPIV((int)i9)).viewBool = true;
                        }
                        ++actionDone;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Assimilate"), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoStability);
                        CFG.SFXManager.playSound(SFXManager.SFX_ASSIMILATE);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewProvinceStability(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE) {
                    actionDone = 0;
                    for (int i10 = 0; i10 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i10) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i10), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i10)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i10)).isOccupied() || !BuildingsManager.constructFort(CFG.core.getPIV(i10), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i10)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getFort_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBForts(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE) {
                    actionDone = 0;
                    for (int i11 = 0; i11 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i11) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i11), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i11)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i11)).isOccupied() || !BuildingsManager.constructTower(CFG.core.getPIV(i11), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i11)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getTower_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBTowers(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_PORT_MODE) {
                    actionDone = 0;
                    for (int i12 = 0; i12 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i12) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i12), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i12)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i12)).isOccupied() || !BuildingsManager.constructPort(CFG.core.getPIV(i12), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_PORT_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i12)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getPort_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_PORT_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBPorts(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FARM_MODE) {
                    actionDone = 0;
                    for (int i13 = 0; i13 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i13) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i13), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i13)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i13)).isOccupied() || !BuildingsManager.constructFarm(CFG.core.getPIV(i13), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_FARM_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i13)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getFarm_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FARM_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBFarms(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE) {
                    actionDone = 0;
                    for (int i14 = 0; i14 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i14) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i14), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i14)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i14)).isOccupied() || !BuildingsManager.constructWorkshop(CFG.core.getPIV(i14), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i14)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBWorkshop(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_MARKET_MODE) {
                    actionDone = 0;
                    for (int i15 = 0; i15 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i15) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i15), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i15)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i15)).isOccupied() || !BuildingsManager.constructMarket(CFG.core.getPIV(i15), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_MARKET_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i15)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getMarket_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_MARKET_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBMarket(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE) {
                    actionDone = 0;
                    for (int i16 = 0; i16 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i16) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i16), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i16)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i16)).isOccupied() || !BuildingsManager.constructLibrary(CFG.core.getPIV(i16), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i16)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getLibrary_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBLibrary(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE) {
                    actionDone = 0;
                    for (int i17 = 0; i17 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i17) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i17), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i17)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i17)).isOccupied() || !BuildingsManager.constructArmoury(CFG.core.getPIV(i17), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i17)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getArmoury_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBArmoury(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE) {
                    actionDone = 0;
                    for (int i18 = 0; i18 < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i18) {
                        if (!TouchManager.aUSMIIBXC(CFG.core.getPIV(i18), this.iSBXX, this.iSBXY, nMaxX, nMaxY) || CFG.core.getProv(CFG.core.getPIV(i18)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getPIV(i18)).isOccupied() || !BuildingsManager.constructSupply(CFG.core.getPIV(i18), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) continue;
                        ++actionDone;
                        CFG.gameAction.updateInGame_ProvinceInfo();
                        if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE) continue;
                        CFG.core.getProv((int)CFG.core.getPIV((int)i18)).viewBool = true;
                    }
                    if (actionDone > 0) {
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get(BuildingsManager.getSupply_Name(1)), CFG.lang.get("Provinces") + ": " + actionDone, Images.infoBuild);
                        CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                            CFG.menus.setVisible_InGame_ViewBSupply(true);
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_NEGATIVE_2);
                        CFG.toastM.setTimeInView(3500);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final boolean aUSMIIBXC(int nProvinceID, int nMinX, int nMinY, int nMaxX, int nMaxY) {
        try {
            int nX = TouchManager.getDetailsPosX2N(nProvinceID);
            int nY = TouchManager.getDetailsPosY2N(nProvinceID);
            int nWidth = 1;
            int nHeight = 1;
            if ((nX < nMaxX && nX > nMinX || nX + nWidth < nMaxX && nX + nWidth > nMinX) && (nY > nMinY && nY < nMaxY || nY + nHeight > nMinY && nY + nHeight < nMaxY)) {
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final void actionUp_setActiveProvinceID(int nPosX, int nPosY) {
        try {
            if (CFG.brushMode || System.currentTimeMillis() - this.lSelectionTime < 350L && !CFG.map.getMpS().getScaleMode() && (float)this.actDPoX + (float)CFG.PADD * CFG.DENSITY > (float)nPosX && (float)this.actDPoX - (float)CFG.PADD * CFG.DENSITY < (float)nPosX && (float)this.actDPoY + (float)CFG.PADD * CFG.DENSITY > (float)nPosY && (float)this.actDPoY - (float)CFG.PADD * CFG.DENSITY < (float)nPosY) {
                com.badlogic.gdx.math.Vector2 worldPos = MapTransform.screenToWorld(nPosX, nPosY);
                CFG.core.setProvinceID((int)worldPos.x, (int)worldPos.y);
                if (!CFG.brushMode) {
                    CFG.SFXManager.playSound(SFXManager.SFX_PROVINCE, SFXManager.PERC_VOLUME_SELECT_PROVINCE);
                }
                this.mAcUSAPEAc.extraAction(nPosX, nPosY);
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void buildReversePosX() {
        this.revDirectionX = CFG.reverseDirectionX ? new ReverseDirection(){

            @Override
            public int getStartMovePos(int nPos) {
                return CFG.map.getMpC().getPX() - nPos;
            }
        } : new ReverseDirection(){

            @Override
            public int getStartMovePos(int nPos) {
                return CFG.map.getMpC().getPX() + nPos;
            }
        };
    }

    public final void buildReversePosY() {
        this.revDirectionY = CFG.reverseDirectionY ? new ReverseDirection(){

            @Override
            public int getStartMovePos(int nPos) {
                return CFG.map.getMpC().getPY() - nPos;
            }
        } : new ReverseDirection(){

            @Override
            public int getStartMovePos(int nPos) {
                return CFG.map.getMpC().getPY() + nPos;
            }
        };
    }

    public final void buildReversePosX2() {
        this.revDirectionX2 = CFG.reverseDirectionX ? new ReverseDirection2(){

            @Override
            public int getNewPos(int iStartMovePos, int nPos) {
                return iStartMovePos + nPos;
            }
        } : new ReverseDirection2(){

            @Override
            public int getNewPos(int iStartMovePos, int nPos) {
                return iStartMovePos - nPos;
            }
        };
    }

    public final void buildReversePosY2() {
        this.revDirectionY2 = CFG.reverseDirectionY ? new ReverseDirection2(){

            @Override
            public int getNewPos(int iStartMovePos, int nPos) {
                return iStartMovePos + nPos;
            }
        } : new ReverseDirection2(){

            @Override
            public int getNewPos(int iStartMovePos, int nPos) {
                return iStartMovePos - nPos;
            }
        };
    }

    public final void ueExA() {
        this.mAcUSAPEAc = null;
        this.mAcUSAPEAc = CFG.menus.getInSelectCiv() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(i).getCivId()) continue;
                        return;
                    }
                    CFG.setDialogType(DialogType.SELECT_CIVILIZATION);
                }
            }
        } : (CFG.menus.getInGameView() ? (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOAD_AI_RTO || CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOADING_NEXT_TURN ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.core.setActiveProvID(-1);
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.LOAD_AI_RTO && CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.LOADING_NEXT_TURN) {
                    TouchManager.this.ueExA();
                }
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.SPECTATOR_MODE) {
                    if (CFG.core.getActiveProvID() >= 0) {
                        if (CFG.SPECTATOR_MODE_DIPLOMACY_ACTIONS_MODE) {
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                int civID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                CFG.core.disableDrawCivilizationRegions(CFG.getActiveCivInfoId());
                                CFG.setActiveCivInfoId(civID);
                                CFG.updateActiveCivilizationInfoInGame();
                                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                                    if (CFG.FOG_OF_WAR == 2) {
                                        CFG.core.enableDrawCivilizationRegions_FogOfWar(CFG.getActiveCivInfoId(), 1);
                                    } else {
                                        CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 1);
                                    }
                                }
                            } else {
                                CFG.toastM.addM(CFG.lang.get("Denied"));
                            }
                            CFG.SPECTATOR_MODE_DIPLOMACY_ACTIONS_MODE = false;
                            return;
                        }
                        if (CFG.SPECTATOR_MODE_DECLARE_WAR_MODE == 0) {
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                CFG.menus.rebuildInGame_DeclareWar(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            } else {
                                CFG.toastM.addM(CFG.lang.get("Denied"));
                            }
                            CFG.SPECTATOR_MODE_DECLARE_WAR_MODE = -1;
                            return;
                        }
                        if (!CFG.SPECTATOR_MODE_LOCK_CIV) {
                            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setCivId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                                CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                CFG.updateActiveCivilizationInfoInGame();
                                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                                CFG.menus.rebuildInGame_Messages();
                                if (CFG.menus.getVisible_InGame_Budget()) {
                                    CFG.menus.setVisible_InGame_Budget(true);
                                }
                                if (CFG.menus.getVisible_InGame_FlagAction() && !CFG.menus.getVisible_InGame_FlagAction_Console()) {
                                    CFG.menus.setVisible_InGame_FlagAction(true);
                                }
                                if (CFG.menus.getVisibleInGame_VictoryConditions()) {
                                    CFG.menus.rebuildInGame_VictoryConditions();
                                }
                                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                                    CFG.core.disableDrawCivilizationRegions_Active();
                                    CFG.core.enableDrawCivilizationRegions_ActiveProvince();
                                } else if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewIncome(true);
                                }
                            }
                        } else if (CFG.core.getActiveProvID() >= 0) {
                            CFG.core.autoBuildChooseProvinceMode(false);
                            int nCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
                            if (nCivID > 0 && CFG.getActiveCivInfoId() != nCivID) {
                                if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                    CFG.mapModesManager.getActiveView().updateActiveCivInfo_ExtraAction(nCivID);
                                }
                                if (CFG.menus.getInGame_CivInfo().getVisibleM()) {
                                    CFG.setActiveCivInfoId(nCivID);
                                    CFG.updateActiveCivilizationInfoInGame();
                                    if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                        CFG.mapModesManager.getActiveView().setActiveProvinceAction();
                                    }
                                }
                            }
                            if (RTS.isEnabled() && !RTS.PAUSE) {
                                RTS.updateTimePast_AfterAction(0.5f);
                            }
                        }
                    }
                } else if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.OUDH == 0) {
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            for (int c = CFG.LPHE.size() - 1; c >= 0; --c) {
                                CFG.mvTFL(CFG.LPHE.get(c), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            }
                        } else {
                            CFG.toastM.addM(CFG.lang.get("Denied"));
                        }
                        CFG.OUDH = -1;
                        return;
                    }
                    CFG.core.autoBuildChooseProvinceMode(false);
                    int nCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
                    if (nCivID > 0 && CFG.getActiveCivInfoId() != nCivID) {
                        if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                            CFG.mapModesManager.getActiveView().updateActiveCivInfo_ExtraAction(nCivID);
                        }
                        if (CFG.menus.getInGame_CivInfo().getVisibleM()) {
                            CFG.setActiveCivInfoId(nCivID);
                            CFG.updateActiveCivilizationInfoInGame();
                            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                CFG.mapModesManager.getActiveView().setActiveProvinceAction();
                            }
                        }
                    }
                    if (RTS.isEnabled() && !RTS.PAUSE) {
                        RTS.updateTimePast_AfterAction(0.5f);
                    }
                }
            }
        }) : (CFG.menus.getInGame_Timeline() || CFG.menus.getInVictory() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        CFG.core.setActiveProvID(-1);
                    } else if (CFG.timelapseManager.timelineOwners.get(CFG.core.getActiveProvID()) > 0) {
                        CFG.toastM.addM(CFG.core.getCiv(CFG.timelapseManager.timelineOwners.get(CFG.core.getActiveProvID())).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.setTimeInView(1500);
                    }
                }
            }
        } : (CFG.menus.getInGame_Formable_Civ_Provinces() || CFG.menus.getInGame_FormAnimation() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.core.setActiveProvID(-1);
            }
        } : (CFG.menus.getInCreateNewGame() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                block14: {
                    try {
                        if (CFG.core.getActiveProvID() < 0) break block14;
                        try {
                            if (CFG.menus.getVisible_CreateNewGame_AddCiv()) {
                                if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                                    if (CFG.brushMode && !TouchManager.this.actionBrush) {
                                        TouchManager.this.actionMoveMap(nPX, nPY);
                                        TouchManager.this.actionBrushMove = true;
                                    }
                                    return;
                                }
                                if (CFG.brushMode) {
                                    if (TouchManager.this.actionBrushMove) {
                                        TouchManager.this.actionMoveMap(nPX, nPY);
                                        return;
                                    }
                                    TouchManager.this.actionBrush = true;
                                }
                                if (Menu_CreateNewGame_AddCiv.addProvinceMode) {
                                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                                        Menu_CreateNewGame_AddCiv.addProvince(CFG.core.getActiveProvID());
                                        CFG.menus.rebuildCreateNewGame_AddCiv();
                                    }
                                } else {
                                    Menu_CreateNewGame_AddCiv.removeProvince(CFG.core.getActiveProvID());
                                    CFG.menus.rebuildCreateNewGame_AddCiv();
                                }
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.getActiveCivInfoId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                                CFG.core.disableDrawCivilizationRegions(CFG.getActiveCivInfoId());
                            }
                            CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            CFG.updateActiveCivInfo_CreateNewGame();
                            CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 1);
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
        } : (CFG.menus.getInGameAC() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                block12: {
                    try {
                        if (CFG.core.getActiveProvID() < 0) break block12;
                        try {
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                                if (CFG.brushMode && !TouchManager.this.actionBrush) {
                                    TouchManager.this.actionMoveMap(nPX, nPY);
                                    TouchManager.this.actionBrushMove = true;
                                }
                                return;
                            }
                            if (CFG.brushMode) {
                                if (TouchManager.this.actionBrushMove) {
                                    TouchManager.this.actionMoveMap(nPX, nPY);
                                    return;
                                }
                                TouchManager.this.actionBrush = true;
                            }
                            if (Menu_InGame_AddCiv.provinceID < 0) {
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                                    Menu_InGame_AddCiv.provinceID = CFG.core.getActiveProvID();
                                    CFG.menus.rebuildInGame_AddCiv();
                                }
                                break block12;
                            }
                            if (Menu_InGame_AddCiv.addProvinceMode) {
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getIsCapital2()) {
                                    Menu_InGame_AddCiv.addProvince(CFG.core.getActiveProvID());
                                    CFG.menus.rebuildInGame_AddCiv();
                                }
                                break block12;
                            }
                            Menu_InGame_AddCiv.removeProvince(CFG.core.getActiveProvID());
                            CFG.menus.rebuildInGame_AddCiv();
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
        } : (CFG.menus.getInSelectAvailableCivilizations() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setVisibleE(true);
                    CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setClickable(true);
                    CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setCheckboxSt(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsAvailable());
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsAvailable()) {
                        CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setTextE(CFG.lang.get("Disable") + " - " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        if (CFG.core.getAvailableCivilizations() < 3) {
                            CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setClickable(false);
                        }
                    } else {
                        CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setTextE(CFG.lang.get("Enable") + " - " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    }
                    CFG.menus.getSelectAvailableCivilizations().updateButtonWidth(3, CFG.PADD, CFG.BUTTON_W * 2);
                } else {
                    CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getSelectAvailableCivilizations().getMenuElem(3).setClickable(false);
                }
            }
        } : (CFG.menus.getInGame_PeaceTreaty() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (Menu_PeaceTreaty_Response.DRAW_TREATY_PROVINCES) {
                    CFG.peaceTreatyData.takeProvince(CFG.core.getActiveProvID(), CFG.peaceTreatyData.brushCivID, CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getIsPlayer() ? CFG.peaceTreatyData.brushCivID : CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
                }
            }
        } : (CFG.menus.getInGame_PeaceTreaty_Response() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.core.setActiveProvID(-1);
            }
        } : (CFG.menus.getInCreateScenario_Civilizations() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.updateCreateScenario_Civilizations();
            }
        } : (CFG.menus.getInCreateScenario_Civilizations_Select() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.core.setActiveProvID(CFG.iCreateScenario_ActiveProvinceID);
            }
        } : (CFG.menus.getInCreateScenario_TechnologyLevels() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
                        if (CFG.createScenarioAssignProvsCiv > 0) {
                            CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                        }
                        CFG.createScenarioAssignProvsCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                        CFG.menus.set_CreateScenario_TechnologyLevels_Slider((int)(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getTechLevel() * 100.0f));
                        if (CFG.createScenarioAssignProvsCiv > 0) {
                            CFG.core.enableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv, 0);
                        }
                    } else {
                        CFG.menus.set_CreateScenario_TechnologyLevels_SliderCivs();
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_Happiness() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
                    if (CFG.createScenarioAssignProvsCiv > 0) {
                        CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                    }
                    CFG.createScenarioAssignProvsCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.set_CreateScenario_Happiness_Slider(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getHappiness());
                    if (CFG.createScenarioAssignProvsCiv > 0) {
                        CFG.core.enableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv, 0);
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_SetCivPopEco() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (age.of.civilizations2.jakowski.lukasz.Menus.Settings.Menu_CreateScenario_SetCivPopEco.iState == 0) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
                        if (CFG.createScenarioAssignProvsCiv > 0) {
                            CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                        }
                        CFG.createScenarioAssignProvsCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                        if (CFG.createScenarioAssignProvsCiv > 0) {
                            CFG.core.enableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv, 0);
                        }
                    }
                    CFG.core.setActiveProvID(-1);
                }
            }
        } : (CFG.menus.getInCreateScenario_StartingMoney() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
                    if (CFG.createScenarioAssignProvsCiv > 0) {
                        CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                    }
                    CFG.menus.set_CreateScenario_StartingMoney_Slider((int)(CFG.core.getCiv(CFG.createScenarioAssignProvsCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getGold() == -999999L ? (long)CFG.core.getGameScenars().getScenario_StartingMoney() : CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getGold()));
                    if (CFG.createScenarioAssignProvsCiv > 0) {
                        CFG.core.enableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv, 0);
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_Available_Provinces() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (!TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                    } else if (!TouchManager.this.actionBrushMove) {
                        if (!CFG.bSetWasteland_AvailableProvinces || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                            CFG.core.setWasteland(CFG.core.getActiveProvID(), CFG.bSetWasteland_AvailableProvinces);
                        }
                        CFG.updateNumOfAvailableProvinces();
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_WastelandMaps_Edit() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (!TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                    } else if (!TouchManager.this.actionBrushMove) {
                        if (CFG.bSetWasteland_AvailableProvinces) {
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                                CFG.core.setWasteland(CFG.core.getActiveProvID(), CFG.bSetWasteland_AvailableProvinces);
                            }
                        } else {
                            CFG.core.setWasteland(CFG.core.getActiveProvID(), CFG.bSetWasteland_AvailableProvinces);
                        }
                        CFG.updateNumOfAvailableProvinces();
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_ArmySeaBoxes_Add() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() < 0) {
                        Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.setPX(-CFG.map.getMpC().getPX() + (int)((float)nPX / CFG.map.getMpS().getCurrSc()));
                        Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.setPY(-CFG.map.getMpC().getPY() + (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    } else if (Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() < 0) {
                        Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.setPX(-CFG.map.getMpC().getPX() + (int)((float)nPX / CFG.map.getMpS().getCurrSc()));
                        Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.setPY(-CFG.map.getMpC().getPY() + (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    } else {
                        int tempWidthSecond;
                        int tempPosX = -CFG.map.getMpC().getPX() + (int)((float)nPX / CFG.map.getMpS().getCurrSc());
                        int tempPosY = -CFG.map.getMpC().getPY() + (int)((float)nPY / CFG.map.getMpS().getCurrSc());
                        int tempWidthFirst = (int)Math.ceil(Math.sqrt((Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() - tempPosX) * (Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() - tempPosX) + (tempPosY - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY()) * (tempPosY - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY())));
                        if (tempWidthFirst < (tempWidthSecond = (int)Math.ceil(Math.sqrt((Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - tempPosX) * (Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - tempPosX) + (tempPosY - Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY()) * (tempPosY - Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY()))))) {
                            Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.setPX(-CFG.map.getMpC().getPX() + (int)((float)nPX / CFG.map.getMpS().getCurrSc()));
                            Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.setPY(-CFG.map.getMpC().getPY() + (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                        } else {
                            Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.setPX(-CFG.map.getMpC().getPX() + (int)((float)nPX / CFG.map.getMpS().getCurrSc()));
                            Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.setPY(-CFG.map.getMpC().getPY() + (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                        }
                    }
                    if (CFG.core.getActiveProvID() != CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                        CFG.core.setActiveProvID(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                    }
                }
            }
        } : (CFG.menus.getInCrScAs() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (CFG.brushMode && !TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.createScenarioAssignProvsCiv >= 0) {
                        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                            if (CFG.core.getCiv(i).getCapitalProvID() != CFG.core.getActiveProvID()) continue;
                            if (!CFG.brushMode && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.createScenarioAssignProvsCiv) {
                                CFG.setDialogType(DialogType.CREATE_SCENARIO_ASSIGN_CIVILIZATION);
                            }
                            return;
                        }
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.createScenarioAssignProvsCiv && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                            if (CFG.SCENARIO_EDITOR_OCCUPATION) {
                                CFG.core.getProv(CFG.core.getActiveProvID()).setCivId(CFG.createScenarioAssignProvsCiv, false, false);
                                CFG.core.getProv(CFG.core.getActiveProvID()).resetArmiesAll(-1);
                                CFG.core.getProv(CFG.core.getActiveProvID()).buildProvinceCore();
                                CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                            } else {
                                CFG.addUndoAssignProvinces(CFG.core.getActiveProvID(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                CFG.core.getProv(CFG.core.getActiveProvID()).setCivId(CFG.createScenarioAssignProvsCiv, false, false);
                                CFG.core.getProv(CFG.core.getActiveProvID()).setTrueOwnerOfProv(CFG.createScenarioAssignProvsCiv);
                                CFG.core.getProv(CFG.core.getActiveProvID()).resetArmiesAll(-1);
                                CFG.core.getProv(CFG.core.getActiveProvID()).buildProvinceCore();
                                CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                            }
                        }
                    } else {
                        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                            if (CFG.core.getCiv(i).getCapitalProvID() != CFG.core.getActiveProvID()) continue;
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.createScenarioAssignProvsCiv) {
                                CFG.setDialogType(DialogType.CREATE_SCENARIO_ASSIGN_CIVILIZATION);
                            }
                            return;
                        }
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_SetUpArmy() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                        if (CFG.brushMode) {
                            if (!TouchManager.this.actionBrush) {
                                TouchManager.this.actionMoveMap(nPX, nPY);
                                TouchManager.this.actionBrushMove = true;
                            }
                        } else if (CFG.selectMode && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                            CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
                            if (CFG.menus.getVisible_CreateScenario_SetUpArmies_Civs()) {
                                CFG.menus.rebuildCreateScenario_SetUpArmies_Civs();
                            }
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.brushMode) {
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        } else {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                    }
                    CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
                    if (CFG.menus.getVisible_CreateScenario_SetUpArmies_Civs()) {
                        CFG.menus.rebuildCreateScenario_SetUpArmies_Civs();
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_Events_SelectProvinces() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (CFG.brushMode) {
                            if (!TouchManager.this.actionBrush) {
                                TouchManager.this.actionMoveMap(nPX, nPY);
                                TouchManager.this.actionBrushMove = true;
                            }
                        } else if (CFG.selectMode && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.brushMode) {
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        } else {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_Cores() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                        if (CFG.brushMode) {
                            if (!TouchManager.this.actionBrush) {
                                TouchManager.this.actionMoveMap(nPX, nPY);
                                TouchManager.this.actionBrushMove = true;
                            }
                        } else if (CFG.selectMode && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                        }
                        CFG.menus.rebuildCreateScenario_Cores_SetUp();
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.brushMode) {
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        } else {
                            CFG.core.getProvSelected().clearSelectedProvinces();
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                    }
                    CFG.menus.rebuildCreateScenario_Cores_SetUp();
                }
            }
        } : (CFG.menus.getInMapEditor_FormableCivs_Edit() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (CFG.brushMode && !TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.brushMode) {
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        } else {
                            CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                    }
                }
            }
        } : (CFG.menus.getInCreateScenario_HolyRomanEmpire() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (CFG.brushMode && !TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID()) && CFG.hreMgr.addProvince(CFG.core.getActiveProvID())) {
                            CFG.menus.rebuildCreateScenario_HolyRomanEmpire_Princes();
                        }
                    } else if (CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID()) && CFG.hreMgr.removeProvince(CFG.core.getActiveProvID())) {
                        CFG.menus.rebuildCreateScenario_HolyRomanEmpire_Princes();
                    }
                }
            }
        } : (CFG.menus.getInGame_CreateAVassal() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || !CFG.core.getProvSelected().canBeReleasedAsVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getActiveProvID())) {
                        if (CFG.brushMode && !TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.core.getProvSelected().canBeReleasedAsVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getActiveProvID())) {
                            if (CFG.brushMode) {
                                CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                                CFG.updateCreateAVassalCivInfo();
                            } else {
                                CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                                CFG.updateCreateAVassalCivInfo();
                            }
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                        boolean resetCapital = true;
                        for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                            if (CFG.createVassalData.iCapitalProvinceID != CFG.core.getProvSelected().getProv(i)) continue;
                            resetCapital = false;
                            break;
                        }
                        if (resetCapital) {
                            CFG.createVassalData.iCapitalProvinceID = -1;
                        }
                        CFG.updateCreateAVassalCivInfo();
                    }
                }
            }
        } : (CFG.menus.getInGame_SelectProvinces() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getActiveProvID()) || CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID || CFG.core.getProv(CFG.core.getActiveProvID()).getTrueOwnerOfProv() != CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                        if (CFG.brushMode && !TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                        return;
                    }
                    if (CFG.brushMode) {
                        if (TouchManager.this.actionBrushMove) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            return;
                        }
                        TouchManager.this.actionBrush = true;
                    }
                    if (CFG.selectMode) {
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getTrueOwnerOfProv()) {
                            if (CFG.brushMode) {
                                CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                            } else {
                                CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                            }
                        }
                    } else {
                        CFG.core.getProvSelected().removeProv(CFG.core.getActiveProvID());
                    }
                }
            }
        } : (CFG.menus.getInGame_TradeSelectCiv() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.tradeRequest.iCivLEFT && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.tradeRequest.iCivRIGHT && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getActiveProvID()))) {
                    int clickedCivID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    System.out.println("TRADE_DEBUG: province clicked, activeProvID=" + CFG.core.getActiveProvID() + " clickedCivID=" + clickedCivID + " typeOfAction=" + Menu_InGame_TradeRequest_SelectCiv.typeOfAction + " iCivLEFT=" + CFG.tradeRequest.iCivLEFT + " iCivRIGHT=" + CFG.tradeRequest.iCivRIGHT);
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = clickedCivID;
                    CFG.setDialogType(DialogType.TRADE_REQUEST_SELECT_CIV);
                    System.out.println("TRADE_DEBUG: dialog set, MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID=" + CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
                }
            }
        } : (CFG.menus.getInManageDiplomacy() ? (CFG.menus.getInManageDiplomacy_Relations_Interactive() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID) {
                        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(1).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(3).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setCurr((int)CFG.core.getCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2));
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(4).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(6).setClickable(true);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setCurr((int)CFG.core.getCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID));
                    } else {
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(1).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(3).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setCurr(0);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(4).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(6).setClickable(false);
                        CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setCurr(0);
                        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
                    }
                }
            }
        } : (CFG.menus.getInManageDiplomacy_Pacts3() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_Pacts_List();
                }
            }
        } : (CFG.menus.getInManageDiplomacy_Truces() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_Trcues_List();
                }
            }
        } : (CFG.menus.getInManageDiplomacy_Guarantee() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_Guarantee_List();
                }
            }
        } : (CFG.menus.getInManageDiplomacy_DefensivePact() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_DefensivePacts_List();
                }
            }
        } : (CFG.menus.getInManageDiplomacy_MilitaryAccess() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_MilitaryAccess_List();
                }
            }
        } : (CFG.menus.getInManageDiplomacy_Vassals() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.menus.rebuildManageDiplomacy_Vassals_List();
                }
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
            }
        }))))))) : (CFG.menus.getInCreateCity() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.editorCity.setPosX(((int)((float)nPX / CFG.map.getMpS().getCurrSc()) - CFG.map.getMpC().getPX()) / CFG.map.getMpB().getMapSc3());
                    CFG.editorCity.setPosY(((int)((float)nPY / CFG.map.getMpS().getCurrSc()) - CFG.map.getMpC().getPY()) / CFG.map.getMpB().getMapSc3());
                    if (CFG.editorCity.getPoX() > CFG.map.getMpB().getWidthM() / CFG.map.getMpB().getMapSc3()) {
                        CFG.editorCity.setPosX(CFG.editorCity.getPoX() % (CFG.map.getMpB().getWidthM() / CFG.map.getMpB().getMapSc3()));
                    }
                    CFG.menus.getCreateCity_UpdateSaveButton();
                }
            }
        } : (CFG.menus.getInMapEditor_Terrain() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (!TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                    } else if (!TouchManager.this.actionBrushMove) {
                        Editor_TerrainType.actionSave(true);
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_GrowthRate() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (!TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                    } else if (!TouchManager.this.actionBrushMove) {
                        Editor_GrowthRate.actionSave(true);
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_Continents() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (!TouchManager.this.actionBrushMove) {
                        Editor_Continents.actionSave(true);
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInMapEditor_Regions() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (!TouchManager.this.actionBrush) {
                            TouchManager.this.actionMoveMap(nPX, nPY);
                            TouchManager.this.actionBrushMove = true;
                        }
                    } else if (!TouchManager.this.actionBrushMove) {
                        Editor_MapRegions.actionSave(true);
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : (CFG.menus.getInGameEditor_Regions() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.core.getActiveProvID() >= 0) {
                    if (!TouchManager.this.actionBrushMove) {
                        Editor_Regions.actionUpdateRegionID(true);
                        TouchManager.this.actionBrush = true;
                    } else {
                        TouchManager.this.actionMoveMap(nPX, nPY);
                    }
                }
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
            }
        })))))))))))))))))))))))))))))))));
        this.mAxDEA = null;
        this.mAxDEA = CFG.menus.getInManageDiplomacy() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if ((CFG.menus.getManageDiplomacy_Alliances().getVisibleM() || CFG.menus.getInManageDiplomacy_Relations_Interactive() || CFG.menus.getInManageDiplomacy_Pacts3() || CFG.menus.getInManageDiplomacy_Truces() || CFG.menus.getInManageDiplomacy_MilitaryAccess() || CFG.menus.getInManageDiplomacy_DefensivePact() || CFG.menus.getInManageDiplomacy_Guarantee() || CFG.menus.getInManageDiplomacy_Vassals()) && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != 0) {
                    int tempOldActiveProvinceID = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() == tempOldActiveProvinceID) {
                        CFG.map.getMpC().setDisableMovingMap(true);
                        CFG.menus.getDrawCivilization().setVisible(true);
                        CFG.menus.getDrawCivilization().setCivID(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        CFG.menus.getDrawCivilization().setPosX(nPX);
                        CFG.menus.getDrawCivilization().setPosY(nPY);
                    } else {
                        CFG.core.setActiveProvID(tempOldActiveProvinceID);
                    }
                }
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
            }
        };
        this.mpAMEAc = null;
        this.mpAMEAc = CFG.menus.getInManageDiplomacy() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                CFG.menus.getDrawCivilization().setPosX(nPX);
                CFG.menus.getDrawCivilization().setPosY(nPY);
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
            }
        };
        this.mAcUEA = null;
        this.mAcUEA = CFG.menus.getInManageDiplomacy_Vassals() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Vassals().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Vassals().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Vassals().getMenuPosX() + CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Vassals().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Vassals().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Vassals().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                } else {
                                    int tempID = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
                                    CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2;
                                    CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = tempID;
                                }
                            } else if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                int tempID = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = tempID;
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Vassals().getMenuElem(CFG.menus.getManageDiplomacy_Vassals().getMenuElemsSize() - 1).setClickable(true);
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0) {
                                CFG.menus.getManageDiplomacy_Vassals().getMenuElem(0).setTextE(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getCivName());
                            } else {
                                CFG.menus.getManageDiplomacy_Vassals().getMenuElem(0).setTextE("");
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Vassals().getMenuElem(1).setTextE(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getCivName());
                                break;
                            }
                            CFG.menus.getManageDiplomacy_Vassals().getMenuElem(1).setTextE("");
                            break;
                        }
                    }
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.getDrawCivilization().setVisible(false);
                    CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                }
                CFG.map.getMpC().setDisableMovingMap(false);
            }
        } : (CFG.menus.getInManageDiplomacy() ? new ExtraAction(){

            
            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.menus.getManageDiplomacy_Alliances().getVisibleM() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Alliances().getMenuElemsSize(); ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Alliances().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Alliances().getMenuPosX() + CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Alliances().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Alliances().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Alliances().getMenuPosY()) continue;
                            if (i == 0) {
                                CFG.core.addAlliance("");
                                CFG.core.getAlliance(CFG.core.getAlliancesSize() - 1).addCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() != 0) {
                                    CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance()).removeCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                }
                                CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setAlliance(CFG.core.getAlliancesSize() - 1);
                                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getAlliancesSize() - 1;
                                CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE);
                                CFG.core.disableDrawCivilizationRegions_ActiveProvince();
                                CFG.menus.getDrawCivilization().setVisible(false);
                                CFG.core.setActiveProvID(-1);
                                CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                                return;
                            }
                            if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() != 0) {
                                if (i == CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance()) break;
                                CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance()).removeCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            }
                            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setAlliance(i);
                            CFG.core.getAlliance(i).addCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            CFG.core.checkAlliances();
                            CFG.menus.rebuildManageDiplomacy_Alliances();
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.core.setActiveProvID(-1);
                            CFG.map.getMpC().setDisableMovingMap(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            return;
                        }
                        int nProvinceBefore = CFG.core.getActiveProvID();
                        CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() > 0) {
                                if (CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).getAlliance() != 0) {
                                    CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).getAlliance()).removeCivilization(CFG.core.getProv(nProvinceBefore).getCivId());
                                }
                                CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).setAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance());
                                CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance()).addCivilization(CFG.core.getProv(nProvinceBefore).getCivId());
                                CFG.core.checkAlliances();
                                CFG.menus.rebuildManageDiplomacy_Alliances();
                            } else {
                                CFG.core.addAlliance("");
                                CFG.core.getAlliance(CFG.core.getAlliancesSize() - 1).addCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                CFG.core.getAlliance(CFG.core.getAlliancesSize() - 1).addCivilization(CFG.core.getProv(nProvinceBefore).getCivId());
                                if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() != 0) {
                                    CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance()).removeCivilization(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                }
                                if (CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).getAlliance() != 0) {
                                    CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).getAlliance()).removeCivilization(CFG.core.getProv(nProvinceBefore).getCivId());
                                }
                                CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setAlliance(CFG.core.getAlliancesSize() - 1);
                                CFG.core.getCiv(CFG.core.getProv(nProvinceBefore).getCivId()).setAlliance(CFG.core.getAlliancesSize() - 1);
                                CFG.core.checkAlliances();
                                CFG.menus.rebuildManageDiplomacy_Alliances();
                                CFG.core.disableDrawCivilizationRegions_ActiveProvince();
                            }
                        }
                        CFG.menus.getDrawCivilization().setVisible(false);
                        CFG.core.setActiveProvID(-1);
                        CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                    }
                } else if (CFG.menus.getInManageDiplomacy_Pacts3() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Pacts3().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Pacts3().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Pacts3().getMenuPosX() + CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Pacts3().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Pacts3().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(CFG.menus.getManageDiplomacy_Pacts3().getMenuElemsSize() - 1).setClickable(true);
                            }
                            CFG.menus.getManageDiplomacy_Pacts3().getMenuElem(i).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            CFG.map.getMpC().setDisableMovingMap(false);
                            return;
                        }
                    }
                    int nProvinceBefore = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getCivNonAggressionPact(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) == 0) {
                                CFG.core.setCivNonAggressionPact(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 5);
                                CFG.core.setActiveProvID(nProvinceBefore);
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                }
                                CFG.menus.rebuildManageDiplomacy_Pacts3();
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                            } else {
                                CFG.core.setActiveProvID(nProvinceBefore);
                            }
                        } else {
                            CFG.core.setActiveProvID(nProvinceBefore);
                        }
                    } else {
                        CFG.core.setActiveProvID(nProvinceBefore);
                    }
                } else if (CFG.menus.getInManageDiplomacy_Truces() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Truces().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Truces().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Truces().getMenuPosX() + CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Truces().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Truces().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Truces().getMenuElem(CFG.menus.getManageDiplomacy_Truces().getMenuElemsSize() - 1).setClickable(true);
                            }
                            CFG.menus.getManageDiplomacy_Truces().getMenuElem(i).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            CFG.map.getMpC().setDisableMovingMap(false);
                            return;
                        }
                    }
                    int nProvinceBefore = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getCivTruce(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) == 0) {
                                CFG.core.setCivTruce(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 5);
                                CFG.core.setActiveProvID(nProvinceBefore);
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                }
                                CFG.menus.rebuildManageDiplomacy_Truces();
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                            } else {
                                CFG.core.setActiveProvID(nProvinceBefore);
                            }
                        } else {
                            CFG.core.setActiveProvID(nProvinceBefore);
                        }
                    } else {
                        CFG.core.setActiveProvID(nProvinceBefore);
                    }
                } else if (CFG.menus.getInManageDiplomacy_MilitaryAccess() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuPosX() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElemsSize() - 1).setClickable(true);
                            }
                            CFG.menus.getManageDiplomacy_MilitaryAccess().getMenuElem(i).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            CFG.map.getMpC().setDisableMovingMap(false);
                            return;
                        }
                    }
                    int nProvinceBefore = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getMilitaryAccess(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) == 0) {
                                CFG.core.setMilitaryAccess(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 5);
                                CFG.core.setActiveProvID(nProvinceBefore);
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                }
                                CFG.menus.rebuildManageDiplomacy_MilitaryAccess();
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                            } else {
                                CFG.core.setActiveProvID(nProvinceBefore);
                            }
                        } else {
                            CFG.core.setActiveProvID(nProvinceBefore);
                        }
                    } else {
                        CFG.core.setActiveProvID(nProvinceBefore);
                    }
                } else if (CFG.menus.getInManageDiplomacy_Guarantee() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Guarantee().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Guarantee().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Guarantee().getMenuPosX() + CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Guarantee().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Guarantee().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(CFG.menus.getManageDiplomacy_Guarantee().getMenuElemsSize() - 1).setClickable(true);
                            }
                            CFG.menus.getManageDiplomacy_Guarantee().getMenuElem(i).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            CFG.map.getMpC().setDisableMovingMap(false);
                            return;
                        }
                    }
                    int nProvinceBefore = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getGuarantee(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) == 0) {
                                CFG.core.setGuarantee(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 5);
                                CFG.core.setActiveProvID(nProvinceBefore);
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                }
                                CFG.menus.rebuildManageDiplomacy_Guarantee();
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                            } else {
                                CFG.core.setActiveProvID(nProvinceBefore);
                            }
                        } else {
                            CFG.core.setActiveProvID(nProvinceBefore);
                        }
                    } else {
                        CFG.core.setActiveProvID(nProvinceBefore);
                    }
                } else if (CFG.menus.getInManageDiplomacy_DefensivePact() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.menus.getManageDiplomacy_Defensive().getMenuElemsSize() - 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Defensive().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Defensive().getMenuPosX() + CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Defensive().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Defensive().getMenuPosY()) continue;
                            if (i == 0) {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            } else {
                                if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) return;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                            }
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0 && CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 > 0) {
                                CFG.menus.getManageDiplomacy_Defensive().getMenuElem(CFG.menus.getManageDiplomacy_Defensive().getMenuElemsSize() - 1).setClickable(true);
                            }
                            CFG.menus.getManageDiplomacy_Defensive().getMenuElem(i).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.getDrawCivilization().setVisible(false);
                            CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = false;
                            CFG.map.getMpC().setDisableMovingMap(false);
                            return;
                        }
                    }
                    int nProvinceBefore = CFG.core.getActiveProvID();
                    CFG.core.setProvinceID((int)((float)nPX / CFG.map.getMpS().getCurrSc()), (int)((float)nPY / CFG.map.getMpS().getCurrSc()));
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(nProvinceBefore).getCivId() != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                            if (CFG.core.getDefensivePact(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) == 0) {
                                CFG.core.setDefensivePact(CFG.core.getProv(nProvinceBefore).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 5);
                                CFG.core.setActiveProvID(nProvinceBefore);
                                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                }
                                CFG.menus.rebuildManageDiplomacy_Defensive();
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                            } else {
                                CFG.core.setActiveProvID(nProvinceBefore);
                            }
                        } else {
                            CFG.core.setActiveProvID(nProvinceBefore);
                        }
                    } else {
                        CFG.core.setActiveProvID(nProvinceBefore);
                    }
                } else if (CFG.menus.getInManageDiplomacy_Relations_Interactive() && CFG.map.getMpC().getDisableMovingMap()) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < 1; ++i) {
                            if (nPX < CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuPosX() || nPX > CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getPosXE() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuPosX() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getWidthE() || nPY < CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuPosY() || nPY > CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getPosY() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).getHeightE() + CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuPosY()) continue;
                            if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID != CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                                CFG.toastM.addM(CFG.lang.get("CustomizeRelations") + ": " + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivName());
                                CFG.toastM.setTimeInView(2500);
                                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2) {
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(1).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(3).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(2).setCurr(0);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(4).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(6).setClickable(false);
                                    CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(5).setCurr(0);
                                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
                                }
                            }
                            CFG.menus.getManageDiplomacy_Relations_Interactive().getMenuElem(i).setTextE(CFG.lang.get("CustomizeRelations") + " [" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName() + "]");
                            break;
                        }
                    }
                    CFG.menus.getDrawCivilization().setVisible(false);
                    CFG.core.setActiveProvID(-1);
                }
                CFG.menus.getDrawCivilization().setVisible(false);
                CFG.map.getMpC().setDisableMovingMap(false);
            }
        } : (CFG.menus.getInCrScAs() ? new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
                if (CFG.brushMode) {
                    for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getCapitalProvID() != CFG.core.getActiveProvID()) continue;
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != CFG.createScenarioAssignProvsCiv) {
                            CFG.setDialogType(DialogType.CREATE_SCENARIO_ASSIGN_CIVILIZATION);
                        }
                        return;
                    }
                }
            }
        } : new ExtraAction(){

            @Override
            public void extraAction(int nPX, int nPY) {
            }
        }));
    }

    public static final int getDetailsPosX(int nProvinceID) {
        return (int)((float)(CFG.core.getProv(nProvinceID).getCeShX() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc());
    }

    public static final int getDetailsPosX2N(int nProvinceID) {
        return (int)((float)(CFG.core.getProv(nProvinceID).getCeShX() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc());
    }

    public static final int getDetailsPosY(int nProvinceID) {
        return (int)((float)(CFG.core.getProv(nProvinceID).getCeShY() + CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc());
    }

    public static final int getDetailsPosY2N(int nProvinceID) {
        return (int)((float)(CFG.core.getProv(nProvinceID).getCeShY() + CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc());
    }

    public final void setUpdateStartMovePosX(boolean updateStartMovePosX) {
        this.updateStartMovePosX = updateStartMovePosX;
    }

    public final void setUpdateStartMovePosY(boolean updateStartMovePosY) {
        this.updateStartMovePosY = updateStartMovePosY;
    }

    public final boolean getActionMap() {
        return this.actionMap;
    }

    public final void setActionMap(boolean actionMap) {
        this.actionMap = actionMap;
    }

    public final long getActionDownTime() {
        return this.actDTm;
    }

    public final void setActionDownTime(long lActionDownTime) {
        this.actDTm = lActionDownTime;
    }

    private static interface ReverseDirection {
        public int getStartMovePos(int var1);
    }

    public static interface ExtraAction {
        public void extraAction(int var1, int var2);
    }

    private static interface ReverseDirection2 {
        public int getNewPos(int var1, int var2);
    }
}

