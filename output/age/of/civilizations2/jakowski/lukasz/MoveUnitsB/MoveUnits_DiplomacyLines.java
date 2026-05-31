
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrewer.JoinType;

public class MoveUnits_DiplomacyLines {
    public List<Integer> lRoute = new ArrayList<Integer>();
    public int iRouteSize = 0;
    public long lMovingTime = 0L;
    public float fMovingPercentage = 0.0f;
    public float widthPercentage = 1.0f;
    public Color mainColor;
    public Color mainColor2 = CFG.COLOR_POSITIVE;
    MoveUnits.LittleAnimation littleAnimationMainLine;
    public Color ColorLine = new Color(0.57254905f, 0.50980395f, 0.4509804f, 1.0f);
    public Color ColorLine2 = new Color(0.04f, 0.04f, 0.04f, 1.0f);
    public int iPrecision;
    public Vector2[] vPoints;
    public static final int PRECISION = 15;

    public MoveUnits_DiplomacyLines(int nCivID, int iFromProvinceID, int iToProvinceID) {
        this.buildRoute(nCivID, iFromProvinceID, iToProvinceID);
        this.mainColor = Colors.HOVER_GOLD;
        if (this.iRouteSize > 1) {
            this.mainColor2 = CFG.core.getCiv(CFG.core.getProv(this.lRoute.get(0)).getCivId()).getColor(1.0f);
            this.buildMoveUnitsLine(true);
        }
    }

    public MoveUnits_DiplomacyLines(int nCivID, int iFromProvinceID, int iToProvinceID, Color nColor) {
        this.buildRoute(nCivID, iFromProvinceID, iToProvinceID);
        this.mainColor = nColor;
        if (this.iRouteSize > 1) {
            this.mainColor2 = CFG.core.getCiv(CFG.core.getProv(this.lRoute.get(0)).getCivId()).getColor(1.0f);
            this.buildMoveUnitsLine(true);
        }
    }

    public MoveUnits_DiplomacyLines(int nCivID, int iFromProvinceID, int iToProvinceID, Color nColor, Color nColor2) {
        this.buildRoute(nCivID, iFromProvinceID, iToProvinceID);
        this.mainColor = nColor;
        this.mainColor2 = nColor2;
        if (this.iRouteSize > 1) {
            this.buildMoveUnitsLine(true);
        }
    }

    public void update() {
        this.littleAnimationMainLine.update();
    }

    public boolean draw(SpriteBatch oSB, float nScale) {
        block7: {
            try {
                if (this.iRouteSize <= 0) break block7;
                Array<Vector2> nPath = new Array<Vector2>();
                if (CFG.core.getProv(this.lRoute.get(0)).getDrawProv()) {
                    for (int j = 0; j < (int)((float)(this.iPrecision - 2) * this.fMovingPercentage); ++j) {
                        nPath.add(new Vector2((this.vPoints[j].x + (float)CFG.core.getProv(this.lRoute.get(0)).getTranslateProvPosX()) * nScale, (this.vPoints[j].y - (float)CFG.map.getMpC().getPY()) * nScale));
                    }
                } else {
                    for (int j = 0; j < (int)((float)this.iPrecision * this.fMovingPercentage); ++j) {
                        nPath.add(new Vector2((this.vPoints[j].x + (float)CFG.map.getMpC().getPX()) * nScale, (this.vPoints[j].y - (float)CFG.map.getMpC().getPY()) * nScale));
                    }
                }
                this.ColorLine2 = CFG.getColorStep(this.mainColor, this.mainColor2, (int)(this.fMovingPercentage * 100.0f), 100, 0.4f);
                
                
                if (this.fMovingPercentage > 0.99f && CFG.core.getProv(this.lRoute.get(this.lRoute.size() - 1)).getDrawProv()) {
                    
                    
                    
                    
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return this.widthPercentage < 0.05f;
    }

    public boolean draw2(SpriteBatch oSB, float nScale) {
        return false;
    }

    protected boolean buildRoute(int nCivID, int fromProvinceID, int toProvinceID) {
        ArrayList<Integer> tP;
        int i;
        this.lRoute.clear();
        if (fromProvinceID < 0 || toProvinceID < 0 || CFG.core.getProv(toProvinceID).getWastelandLvl() >= 0) {
            return false;
        }
        ArrayList<Integer> was = new ArrayList<Integer>();
        was.add(fromProvinceID);
        for (int i2 = 0; i2 < CFG.core.getProvinSize(); ++i2) {
            CFG.core.getProv((int)i2).wasCities = false;
        }
        CFG.core.getProv((int)fromProvinceID).wasCities = true;
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<List<Integer>> inPath = new ArrayList<List<Integer>>();
        for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
            if (!this.canBeUsedInPath(nCivID, CFG.core.getProv(fromProvinceID).getNeighProvinces(i), this.isFriendlyProvince(nCivID, toProvinceID), toProvinceID)) continue;
            in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            tP = new ArrayList();
            tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            inPath.add(tP);
            was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighProvinces((int)i)).getProvID()).wasCities = true;
        }
        if (!CFG.core.getProv(fromProvinceID).getSeaProv()) {
            for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighSeaProvincesSize(); ++i) {
                in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                tP = new ArrayList<Integer>();
                tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                inPath.add(tP);
                was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighSeaProvinces((int)i)).getProvID()).wasCities = true;
            }
        }
        this.buildPath(nCivID, was, in, inPath, fromProvinceID, toProvinceID, true);
        return true;
    }

    public boolean isFriendlyProvince(int nCivID, int toProvinceID) {
        return CFG.core.getProv(toProvinceID).getCivId() == nCivID;
    }

    public boolean canBeUsedInPath(int nCivID, int nProvinceID, boolean moveToFriendlyProvince, int toProvinceID) {
        if (CFG.core.getProv(nProvinceID).getWastelandLvl() >= 0) {
            return false;
        }
        return CFG.core.getProv(nProvinceID).getCivId() == nCivID;
    }

    protected boolean buildPath(int nCivID, List<Integer> was, List<Integer> in, List<List<Integer>> inPath, int from, int lookingFor, boolean forDirection) {
        int i;
        ArrayList<Integer> nIN = new ArrayList<Integer>();
        ArrayList<List<Integer>> nINPath = new ArrayList<List<Integer>>();
        for (i = 0; i < in.size(); ++i) {
            if (CFG.core.getProv(in.get(i)).getProvID() != lookingFor) continue;
            this.setPath(from, lookingFor, inPath.get(i), lookingFor, from);
            this.clearWas(was);
            return true;
        }
        if (forDirection) {
            for (i = 0; i < in.size(); ++i) {
                int u;
                ArrayList<Integer> tPL;
                int j;
                for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighProvincesSize(); ++j) {
                    if (!this.canBeUsedInPath(nCivID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), this.isFriendlyProvince(nCivID, lookingFor), lookingFor) || CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasCities) continue;
                    if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                        this.setPath(from, lookingFor, inPath.get(i), lookingFor, from);
                        this.clearWas(was);
                        return true;
                    }
                    nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                    tPL = new ArrayList<Integer>();
                    for (u = 0; u < inPath.get(i).size(); ++u) {
                        tPL.add(inPath.get(i).get(u));
                    }
                    tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                    nINPath.add(tPL);
                    CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasCities = true;
                    was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                }
                if (CFG.core.getProv(in.get(i)).getSeaProv()) continue;
                for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighSeaProvincesSize(); ++j) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasCities) continue;
                    if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID() == lookingFor) {
                        this.setPath(from, lookingFor, inPath.get(i), lookingFor, from);
                        this.clearWas(was);
                        return true;
                    }
                    nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                    tPL = new ArrayList();
                    for (u = 0; u < inPath.get(i).size(); ++u) {
                        tPL.add(inPath.get(i).get(u));
                    }
                    tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                    nINPath.add(tPL);
                    CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasCities = true;
                    was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                }
            }
        } else {
            for (i = 0; i < in.size(); ++i) {
                int u;
                ArrayList<Integer> tPL;
                int j;
                for (j = CFG.core.getProv(in.get(i)).getNeighProvincesSize() - 1; j >= 0; --j) {
                    if (!this.canBeUsedInPath(nCivID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), this.isFriendlyProvince(nCivID, lookingFor), lookingFor) || CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasCities) continue;
                    if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                        this.setPath(from, lookingFor, inPath.get(i), lookingFor, from);
                        this.clearWas(was);
                        return true;
                    }
                    nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                    tPL = new ArrayList<Integer>();
                    for (u = 0; u < inPath.get(i).size(); ++u) {
                        tPL.add(inPath.get(i).get(u));
                    }
                    tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                    nINPath.add(tPL);
                    CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasCities = true;
                    was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                }
                if (CFG.core.getProv(in.get(i)).getSeaProv()) continue;
                for (j = CFG.core.getProv(in.get(i)).getNeighSeaProvincesSize() - 1; j >= 0; --j) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasCities) continue;
                    if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID() == lookingFor) {
                        this.setPath(from, lookingFor, inPath.get(i), lookingFor, from);
                        this.clearWas(was);
                        return true;
                    }
                    nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                    tPL = new ArrayList();
                    for (u = 0; u < inPath.get(i).size(); ++u) {
                        tPL.add(inPath.get(i).get(u));
                    }
                    tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                    nINPath.add(tPL);
                    CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasCities = true;
                    was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                }
            }
        }
        if (nIN.isEmpty()) {
            return false;
        }
        try {
            return this.buildPath(nCivID, was, nIN, nINPath, from, lookingFor, !forDirection);
        }
        catch (StackOverflowError ex) {
            this.clearWas(was);
            return false;
        }
    }

    protected final void clearWas(List<Integer> was) {
        for (int i = was.size() - 1; i >= 0; --i) {
            CFG.core.getProv((int)was.get((int)i).intValue()).wasCities = false;
        }
    }

    protected final void setPath(int p1, int p2, List<Integer> lPath, int toProvinceID, int fromProvinceID) {
        this.lRoute.add(fromProvinceID);
        for (int i = 0; i < lPath.size(); ++i) {
            this.lRoute.add(lPath.get(i));
        }
        if (toProvinceID != this.lRoute.get(this.lRoute.size() - 1)) {
            this.lRoute.add(toProvinceID);
        }
        this.iRouteSize = this.lRoute.size();
    }

    public void buildAnimation(boolean updateAnimation) {
        if (updateAnimation) {
            this.lMovingTime = CFG.currentTimeMillis;
            this.fMovingPercentage = 0.01f;
            this.littleAnimationMainLine = new MoveUnits.LittleAnimation(){

                @Override
                public void update() {
                    MoveUnits_DiplomacyLines.this.fMovingPercentage += (float)(CFG.currentTimeMillis - MoveUnits_DiplomacyLines.this.lMovingTime) / (float)GameValues.gvDiplomacy.DIPLOMACY_LINES_ANIMATION_DURATION;
                    MoveUnits_DiplomacyLines.this.lMovingTime = CFG.currentTimeMillis;
                    if (MoveUnits_DiplomacyLines.this.fMovingPercentage >= 1.0f) {
                        MoveUnits_DiplomacyLines.this.fMovingPercentage = 1.0f;
                        MoveUnits_DiplomacyLines.this.lMovingTime = CFG.currentTimeMillis;
                        MoveUnits_DiplomacyLines.this.littleAnimationMainLine = new MoveUnits.LittleAnimation(){

                            @Override
                            public void update() {
                                MoveUnits_DiplomacyLines.this.widthPercentage -= (float)(CFG.currentTimeMillis - MoveUnits_DiplomacyLines.this.lMovingTime) / (float)GameValues.gvDiplomacy.DIPLOMACY_LINES_ANIMATION_DURATION;
                                MoveUnits_DiplomacyLines.this.lMovingTime = CFG.currentTimeMillis;
                            }
                        };
                    }
                }
            };
        }
    }

    public int getShiftPosXY() {
        return -15 + CFG.oR.nextInt(31);
    }

    public void buildMoveUnitsLine(boolean updateAnimation) {
        this.buildAnimation(updateAnimation);
        this.iPrecision = 15 * this.iRouteSize;
        this.vPoints = new Vector2[this.iPrecision];
        Vector[] dataSet = new Vector2[this.iRouteSize + 2];
        for (int i = 0; i < this.iRouteSize; ++i) {
            dataSet[i + 1] = CFG.core.getProv(this.lRoute.get(i)).getCitSize() > 0 ? new Vector2(CFG.core.getProv(this.lRoute.get(i)).getCit(0).getPoX() * CFG.map.getMpB().getMapSc3(), -(CFG.core.getProv(this.lRoute.get(i)).getCit(0).getPosY() * CFG.map.getMpB().getMapSc3())) : new Vector2(CFG.core.getProv(this.lRoute.get(i)).getCeShX(), -CFG.core.getProv(this.lRoute.get(i)).getCeShY());
        }
        dataSet[0] = CFG.core.getProv(this.lRoute.get(0)).getCitSize() > 0 ? new Vector2(CFG.core.getProv(this.lRoute.get(0)).getCit(0).getPoX() * CFG.map.getMpB().getMapSc3() + this.getShiftPosXY(), -(CFG.core.getProv(this.lRoute.get(0)).getCit(0).getPosY() * CFG.map.getMpB().getMapSc3() + this.getShiftPosXY())) : new Vector2(CFG.core.getProv(this.lRoute.get(0)).getCeShX() + this.getShiftPosXY(), -(CFG.core.getProv(this.lRoute.get(0)).getCeShY() + this.getShiftPosXY()));
        dataSet[this.iRouteSize + 1] = CFG.core.getProv(this.lRoute.get(this.iRouteSize - 1)).getCitSize() > 0 ? new Vector2(CFG.core.getProv(this.lRoute.get(this.iRouteSize - 1)).getCit(0).getPoX() * CFG.map.getMpB().getMapSc3(), -(CFG.core.getProv(this.lRoute.get(this.iRouteSize - 1)).getCit(0).getPosY() * CFG.map.getMpB().getMapSc3())) : new Vector2(CFG.core.getProv(this.lRoute.get(this.iRouteSize - 1)).getCeShX(), -CFG.core.getProv(this.lRoute.get(this.iRouteSize - 1)).getCeShY());
        CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
        for (int j = 0; j < this.iPrecision; ++j) {
            this.vPoints[j] = new Vector2();
            oCatmull.valueAt(this.vPoints[j], (float)j / ((float)this.iPrecision - 1.0f));
        }
    }

    public int getFromProvinceID() {
        return this.lRoute.get(0);
    }

    public int getToProvinceID() {
        return this.lRoute.get(1);
    }

    public int getToProvinceLastID() {
        return this.lRoute.get(this.iRouteSize - 1);
    }
}

