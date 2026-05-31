
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Civilization_Region {
    private int iRegionID;
    private List<Integer> lProvinces;
    private int iProvincesSize;
    private boolean isSupplied = false;
    private boolean seaAccess = false;
    private boolean seaAccess_HavePort = false;
    private boolean haveNotOccupiedProvince = false;
    public boolean isKeyRegion = false;
    public int iAveragePotential = 0;
    protected List<Integer> lCoastlineProvinces = new ArrayList<Integer>();
    private List<Integer> shortestLine = new ArrayList<Integer>();
    private int iMinX = 0;
    private int iMaxX = 0;
    private int iMinY = 0;
    private int iMaxY = 0;
    public int iAveragePointPosX = 0;
    public int iAveragePointPosY = 0;
    private float fontScale = 1.0f;
    private float fAngle = 0.0f;
    private float fAngle_Low = 0.0f;
    private int iCharMaxWidth = 0;
    private int iCharMaxHeight = 0;
    public List<Point_XY2> lPoints = new ArrayList<Point_XY2>();
    public List<Matrix4> drawMatrix4 = new ArrayList<Matrix4>();
    public Point_XY2 centerCharXY;
    protected boolean drawName = true;
    private List<Boolean> triedToUse = new ArrayList<Boolean>();
    private int numOfTries = 0;

    public Civilization_Region() {
    }

    public Civilization_Region(int nProvinceID, int iRegionID) {
        this.lProvinces = new ArrayList<Integer>();
        this.shortestLine = new ArrayList<Integer>();
        this.lCoastlineProvinces = new ArrayList<Integer>();
        this.iRegionID = iRegionID;
        this.addProvince(nProvinceID);
    }

    public final boolean checkRegionBordersWithEnemy(int nCivID) {
        for (int i = 0; i < this.getProvincesSize(); ++i) {
            if (!CFG.core.getProv(this.getProvince(i)).getBordersWithEnemy()) continue;
            return true;
        }
        return false;
    }

    public final void addProvince(int nProvinceID) {
        this.lProvinces.add(nProvinceID);
        this.iProvincesSize = this.lProvinces.size();
        if (CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize() > 0) {
            this.lCoastlineProvinces.add(nProvinceID);
        }
        if (CFG.core.getProv(nProvinceID).isCapital()) {
            this.isKeyRegion = true;
        }
        CFG.core.getProv(nProvinceID).setCivRegionID(this.iRegionID);
        if (!this.seaAccess) {
            for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighSeaProvinces(i)).getLvlOfPort() != -2) continue;
                this.seaAccess = true;
                break;
            }
        }
        if (this.seaAccess && !this.seaAccess_HavePort && CFG.core.getProv(nProvinceID).getLvlOfPort() > 0) {
            this.seaAccess_HavePort = true;
        }
        if (!this.haveNotOccupiedProvince && !CFG.core.getProv(nProvinceID).isOccupied()) {
            this.haveNotOccupiedProvince = true;
        }
    }

    public final void removeProvinceID(int nProvinceID) {
        int k;
        for (int i = 0; i < this.iProvincesSize; ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            this.lProvinces.remove(i);
            this.iProvincesSize = this.lProvinces.size();
            for (int j = 0; j < this.lCoastlineProvinces.size(); ++j) {
                if (this.lCoastlineProvinces.get(j) != nProvinceID) continue;
                this.lCoastlineProvinces.remove(j);
                break;
            }
            CFG.core.getProv(nProvinceID).setCivRegionID(-1);
            break;
        }
        if (this.seaAccess) {
            this.seaAccess = false;
            block2: for (k = 0; k < this.iProvincesSize; ++k) {
                for (int i = 0; i < CFG.core.getProv(this.getProvince(k)).getNeighSeaProvincesSize(); ++i) {
                    if (CFG.core.getProv(CFG.core.getProv(this.getProvince(k)).getNeighSeaProvinces(i)).getLvlOfPort() != -2) continue;
                    this.seaAccess = true;
                    k = this.iProvincesSize;
                    continue block2;
                }
            }
            if (!this.seaAccess) {
                this.seaAccess_HavePort = false;
            } else if (this.seaAccess_HavePort) {
                this.seaAccess_HavePort = false;
                for (k = 0; k < this.iProvincesSize; ++k) {
                    if (CFG.core.getProv(this.getProvince(k)).getLvlOfPort() <= 0) continue;
                    this.seaAccess_HavePort = true;
                    break;
                }
            }
        }
        if (this.haveNotOccupiedProvince && !CFG.core.getProv(nProvinceID).isOccupied()) {
            this.haveNotOccupiedProvince = false;
            for (k = 0; k < this.iProvincesSize; ++k) {
                if (CFG.core.getProv(this.getProvince(k)).isOccupied()) continue;
                this.haveNotOccupiedProvince = true;
                break;
            }
        }
    }

    public final void removeProvince(int i) {
        CFG.core.getProv(this.lProvinces.get(i)).setCivRegionID(-1);
        for (int j = 0; j < this.lCoastlineProvinces.size(); ++j) {
            if (this.lCoastlineProvinces.get(j) != this.lProvinces.get(i)) continue;
            this.lCoastlineProvinces.remove(j);
            break;
        }
        this.lProvinces.remove(i);
        this.iProvincesSize = this.lProvinces.size();
    }

    public final boolean containsProvince(int nProvinceID) {
        for (int i = 0; i < this.iProvincesSize; ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void updateDrawRegionName() {
        this.drawName = true;
        if (CFG.FOG_OF_WAR == 2) {
            for (int i = 0; i < this.lProvinces.size(); ++i) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.lProvinces.get(i))) continue;
                this.drawName = false;
                break;
            }
        }
    }

    public final void buildRegionPath_TriedToUse() {
        int i;
        this.triedToUse.clear();
        for (i = 0; i < this.iProvincesSize; ++i) {
            this.triedToUse.add(false);
        }
        for (i = 0; i < this.iProvincesSize; ++i) {
            if (!CFG.core.getProv(this.lProvinces.get(i)).getIsBelowZero()) continue;
            this.triedToUse.set(i, true);
        }
        this.numOfTries = 0;
    }

    public final boolean buildRegionPath() {
        try {
            this.drawName = false;
            this.buildMinMaxBounds();
            if (this.lProvinces.size() == 1) {
                return false;
            }
            if (this.lProvinces.size() > 1) {
                if (!CFG.settingsGD.DRAW_CIVILIZATIONS_NAMES_OVER_PROVINCES_IN_GAME) {
                    return false;
                }
                int startID = -1;
                for (int i = 0; i < this.iProvincesSize; ++i) {
                    if (this.triedToUse.get(i).booleanValue()) continue;
                    startID = i;
                    break;
                }
                if (startID == -1) {
                    return false;
                }
                int fromProvinceID_LEFTRIGHT = startID;
                int toProvinceID_LEFTRIGHT = startID;
                int fromProvinceID_RIGHTLEFT = startID;
                int toProvinceID_RIGHTLEFT = startID;
                int fromProvinceID_BOTTOM = startID;
                int toProvinceID_TOP = startID;
                int fromProvinceID_LR = startID;
                int toProvinceID_LR = startID;
                int leftBottomDistance = (int)Math.sqrt(Math.pow(this.iMinX - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeX(), 2.0) + Math.pow(this.iMaxY - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeY(), 2.0));
                int rightTopDistance = (int)Math.sqrt(Math.pow(this.iMaxX - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeX(), 2.0) + Math.pow(this.iMinY - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeY(), 2.0));
                int rightBottomDistance = (int)Math.sqrt(Math.pow(this.iMaxX - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeX(), 2.0) + Math.pow(this.iMaxY - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeY(), 2.0));
                int leftTopDistance = (int)Math.sqrt(Math.pow(this.iMinX - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeX(), 2.0) + Math.pow(this.iMinY - CFG.core.getProv(this.lProvinces.get(fromProvinceID_LEFTRIGHT)).getCeY(), 2.0));
                for (int i = startID + 1; i < this.iProvincesSize; ++i) {
                    if (this.triedToUse.get(i).booleanValue()) continue;
                    int tempDistance = Civilization_Region.getLineWidth(this.iMinX, this.iMaxY, CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX(), CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY());
                    if (tempDistance < leftBottomDistance) {
                        leftBottomDistance = tempDistance;
                        fromProvinceID_LEFTRIGHT = i;
                    }
                    if ((tempDistance = Civilization_Region.getLineWidth(this.iMaxX, this.iMinY, CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX(), CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY())) < rightTopDistance) {
                        rightTopDistance = tempDistance;
                        toProvinceID_LEFTRIGHT = i;
                    }
                    if ((tempDistance = Civilization_Region.getLineWidth(this.iMaxX, this.iMaxY, CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX(), CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY())) < rightBottomDistance) {
                        rightBottomDistance = tempDistance;
                        fromProvinceID_RIGHTLEFT = i;
                    }
                    if ((tempDistance = Civilization_Region.getLineWidth(this.iMinX, this.iMinY, CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX(), CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY())) < leftTopDistance) {
                        leftTopDistance = tempDistance;
                        toProvinceID_RIGHTLEFT = i;
                    }
                    if (CFG.core.getProv(this.lProvinces.get(fromProvinceID_BOTTOM)).getCeY() + CFG.core.getProv(this.lProvinces.get(fromProvinceID_BOTTOM)).getShPY() < CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY()) {
                        fromProvinceID_BOTTOM = i;
                    }
                    if (CFG.core.getProv(this.lProvinces.get(toProvinceID_TOP)).getCeY() + CFG.core.getProv(this.lProvinces.get(toProvinceID_TOP)).getShPY() > CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY()) {
                        toProvinceID_TOP = i;
                    }
                    if (CFG.core.getProv(this.lProvinces.get(fromProvinceID_LR)).getCeX() + CFG.core.getProv(this.lProvinces.get(fromProvinceID_LR)).getShPX() > CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX() && CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY() >= this.iMinY + (this.iMaxY - this.iMinY) / 2) {
                        fromProvinceID_LR = i;
                    }
                    if (CFG.core.getProv(this.lProvinces.get(toProvinceID_LR)).getCeX() + CFG.core.getProv(this.lProvinces.get(toProvinceID_LR)).getShPX() >= CFG.core.getProv(this.lProvinces.get(i)).getCeX() + CFG.core.getProv(this.lProvinces.get(i)).getShPX() || CFG.core.getProv(this.lProvinces.get(i)).getCeY() + CFG.core.getProv(this.lProvinces.get(i)).getShPY() > this.iMinY + (this.iMaxY - this.iMinY) / 2) continue;
                    toProvinceID_LR = i;
                }
                if (this.getLineWidth(fromProvinceID_LEFTRIGHT, toProvinceID_LEFTRIGHT) > this.getLineWidth(fromProvinceID_RIGHTLEFT, toProvinceID_RIGHTLEFT)) {
                    if (this.getLineWidth(fromProvinceID_LEFTRIGHT, toProvinceID_LEFTRIGHT) > this.getLineWidth(fromProvinceID_BOTTOM, toProvinceID_TOP)) {
                        if (this.getLineWidth(fromProvinceID_LEFTRIGHT, toProvinceID_LEFTRIGHT) > this.getLineWidth(fromProvinceID_LR, toProvinceID_LR)) {
                            this.shortestLine.add(fromProvinceID_LEFTRIGHT);
                            this.shortestLine.add(toProvinceID_LEFTRIGHT);
                        } else {
                            this.shortestLine.add(fromProvinceID_LR);
                            this.shortestLine.add(toProvinceID_LR);
                        }
                    } else if (this.getLineWidth(fromProvinceID_BOTTOM, toProvinceID_TOP) > this.getLineWidth(fromProvinceID_LR, toProvinceID_LR)) {
                        this.shortestLine.add(fromProvinceID_BOTTOM);
                        this.shortestLine.add(toProvinceID_TOP);
                    } else {
                        this.shortestLine.add(fromProvinceID_LR);
                        this.shortestLine.add(toProvinceID_LR);
                    }
                } else if (this.getLineWidth(fromProvinceID_RIGHTLEFT, toProvinceID_RIGHTLEFT) > this.getLineWidth(fromProvinceID_BOTTOM, toProvinceID_TOP)) {
                    if (this.getLineWidth(fromProvinceID_RIGHTLEFT, toProvinceID_RIGHTLEFT) > this.getLineWidth(fromProvinceID_LR, toProvinceID_LR)) {
                        this.shortestLine.add(fromProvinceID_RIGHTLEFT);
                        this.shortestLine.add(toProvinceID_RIGHTLEFT);
                    } else {
                        this.shortestLine.add(fromProvinceID_LR);
                        this.shortestLine.add(toProvinceID_LR);
                    }
                } else if (this.getLineWidth(fromProvinceID_BOTTOM, toProvinceID_TOP) > this.getLineWidth(fromProvinceID_LR, toProvinceID_LR)) {
                    this.shortestLine.add(fromProvinceID_BOTTOM);
                    this.shortestLine.add(toProvinceID_TOP);
                } else {
                    this.shortestLine.add(fromProvinceID_LR);
                    this.shortestLine.add(toProvinceID_LR);
                }
                if (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getCeX() > CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getCeX()) {
                    int tempS = this.shortestLine.get(0);
                    this.shortestLine.set(0, this.shortestLine.get(1));
                    this.shortestLine.set(1, tempS);
                }
                if (this.shortestLine.size() == 0 || this.shortestLine.get(0) == this.shortestLine.get(1)) {
                    this.shortestLine.clear();
                    this.triedToUse.clear();
                    return false;
                }
                Point_XY2 tD = this.canDrawTextProperly(this.lProvinces.get(this.shortestLine.get(0)), this.lProvinces.get(this.shortestLine.get(1)));
                if (tD != null) {
                    if (Civilization_Region.getLineWidth(tD.getPX(), tD.getPY(), CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getCeShX(), CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getCeShY()) < Civilization_Region.getLineWidth(tD.getPX(), tD.getPY(), CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getCeShX(), CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getCeShY())) {
                        this.triedToUse.set(this.shortestLine.get(0), true);
                    } else {
                        this.triedToUse.set(this.shortestLine.get(1), true);
                    }
                    this.shortestLine.clear();
                    return this.numOfTries++ < 100 ? this.buildRegionPath() : false;
                }
                tD = null;
                this.triedToUse.clear();
            }
            this.updateDrawRegionName();
            return true;
        }
        catch (StackOverflowError ex) {
            CFG.exceptionStack(ex);
            return false;
        }
    }

    private final void buildMinMaxBounds() {
        try {
            this.iMinX = CFG.core.getProv(this.lProvinces.get(0)).getMiX2();
            this.iMaxX = CFG.core.getProv(this.lProvinces.get(0)).getMaX7();
            this.iMinY = CFG.core.getProv(this.lProvinces.get(0)).getMiY4();
            this.iMaxY = CFG.core.getProv(this.lProvinces.get(0)).getMaY6();
            for (int i = 1; i < this.iProvincesSize; ++i) {
                if (CFG.core.getProv(this.lProvinces.get(i)).getMiX2() < this.iMinX) {
                    this.iMinX = CFG.core.getProv(this.lProvinces.get(i)).getMiX2();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMaX7() > this.iMaxX) {
                    this.iMaxX = CFG.core.getProv(this.lProvinces.get(i)).getMaX7();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMiY4() < this.iMinY) {
                    this.iMinY = CFG.core.getProv(this.lProvinces.get(i)).getMiY4();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMaY6() <= this.iMaxY) continue;
                this.iMaxY = CFG.core.getProv(this.lProvinces.get(i)).getMaY6();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    private final Point_XY2 canDrawTextProperly(int fromProvinceID, int toProvinceID) {
        int i;
        float acceptableWidth;
        Vector2[] vPoints;
        int iPrecision;
        ArrayList<Point_XY2> tempPoints;
        block8: {
            this.buildAveragePoint();
            tempPoints = new ArrayList<Point_XY2>();
            int tX = CFG.core.getProv(fromProvinceID).getCeShX();
            int tX2 = CFG.core.getProv(toProvinceID).getCeShX();
            int extra10X = tX + (int)Math.abs((float)(tX2 - tX) * 0.15f) * (tX > tX2 ? -1 : 1);
            int extra10X2 = tX2 + (int)Math.abs((float)(tX2 - tX) * 0.15f) * (tX2 > tX ? -1 : 1);
            int tY = CFG.core.getProv(fromProvinceID).getCeShY();
            int tY2 = CFG.core.getProv(toProvinceID).getCeShY();
            int extra10Y = tY + (int)Math.abs((float)(tY2 - tY) * 0.15f) * (tY > tY2 ? -1 : 1);
            int extra10Y2 = tY2 + (int)Math.abs((float)(tY2 - tY) * 0.15f) * (tY2 > tY ? -1 : 1);
            iPrecision = CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength() * 10;
            vPoints = new Vector2[iPrecision];
            Vector[] dataSet = new Vector2[]{new Vector2(extra10X, extra10Y), new Vector2(extra10X, extra10Y), new Vector2(this.iAveragePointPosX, this.iAveragePointPosY), new Vector2(extra10X2, extra10Y2), new Vector2(extra10X2, extra10Y2)};
            CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
            for (int i2 = 0; i2 < iPrecision; ++i2) {
                vPoints[i2] = new Vector2();
                oCatmull.valueAt(vPoints[i2], (float)i2 / ((float)iPrecision - 1.0f));
            }
            float tempPrecisionWidth = 0.0f;
            for (int i3 = 0; i3 < iPrecision - 1; ++i3) {
                tempPrecisionWidth += Civilization_Region.getLineWidth2((int)vPoints[i3].x, (int)vPoints[i3].y, (int)vPoints[i3 + 1].x, (int)vPoints[i3 + 1].y);
            }
            tempPoints.add(new Point_XY2((int)vPoints[0].x, (int)vPoints[0].y));
            acceptableWidth = 0.0f;
            try {
                acceptableWidth = tempPrecisionWidth / (float)(CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength() - 1);
            }
            catch (ArithmeticException ex) {
                if (!CFG.LOGs) break block8;
                CFG.exceptionStack(ex);
            }
        }
        float currentPointsWidth = 0.0f;
        int startPrecision = 0;
        block4: for (i = 1; i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength(); ++i) {
            while (startPrecision < iPrecision - 1) {
                float tempPrecisionWidth2 = Civilization_Region.getLineWidth2((int)vPoints[startPrecision].x, (int)vPoints[startPrecision].y, (int)vPoints[startPrecision + 1].x, (int)vPoints[startPrecision + 1].y);
                if (currentPointsWidth + tempPrecisionWidth2 >= acceptableWidth && currentPointsWidth <= acceptableWidth) {
                    tempPoints.add(new Point_XY2((int)vPoints[startPrecision].x, (int)vPoints[startPrecision].y));
                    currentPointsWidth = acceptableWidth - (currentPointsWidth + tempPrecisionWidth2);
                    continue block4;
                }
                currentPointsWidth += tempPrecisionWidth2;
                ++startPrecision;
            }
        }
        this.buildScaleOfText();
        tempPoints.add(new Point_XY2((int)vPoints[vPoints.length - 1].x, (int)vPoints[vPoints.length - 1].y));
        for (i = tempPoints.size() - 1; i >= 0; --i) {
            int nNewChosenProvinceID = CFG.core.setProviPoint(((Point_XY2)tempPoints.get(i)).getPX(), ((Point_XY2)tempPoints.get(i)).getPY());
            if (nNewChosenProvinceID < 0 || CFG.core.getProv(fromProvinceID).getCivId() == CFG.core.getProv(nNewChosenProvinceID).getCivId()) continue;
            return (Point_XY2)tempPoints.get(i);
        }
        return null;
    }

    private final void buildAveragePoint() {
        long lAverageX = 0L;
        long lAverageY = 0L;
        int tempMinX = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getMiX2();
        int tempMaxX = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getMaX7();
        int tempMinY = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getMiY4();
        int tempMaxY = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getMaY6();
        if (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMiX2() < tempMinX) {
            tempMinX = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMiX2();
        }
        if (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMaX7() > tempMaxX) {
            tempMaxX = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMaX7();
        }
        if (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMiY4() < tempMinY) {
            tempMinY = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMiY4();
        }
        if (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMaY6() > tempMaxY) {
            tempMaxY = CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getMaY6();
        }
        int tSize = 0;
        for (int i = 0; i < this.getProvincesSize(); ++i) {
            if (CFG.core.getProv(this.getProvince(i)).getCeShX() >= tempMinX && CFG.core.getProv(this.getProvince(i)).getCeShX() <= tempMaxX) {
                if (CFG.core.getProv(this.getProvince(i)).getCeShY() < tempMinY || CFG.core.getProv(this.getProvince(i)).getCeShY() > tempMaxY) continue;
                lAverageX += (long)CFG.core.getProv(this.getProvince(i)).getCeShX();
                lAverageY += (long)CFG.core.getProv(this.getProvince(i)).getCeShY();
                ++tSize;
                continue;
            }
            if ((CFG.core.getProv(this.getProvince(i)).getMiX2() <= tempMinX || CFG.core.getProv(this.getProvince(i)).getMiX2() > tempMaxX) && (CFG.core.getProv(this.getProvince(i)).getMaX7() <= tempMinX || CFG.core.getProv(this.getProvince(i)).getMaX7() > tempMaxX) || (CFG.core.getProv(this.getProvince(i)).getMiY4() < tempMinY || CFG.core.getProv(this.getProvince(i)).getMiY4() > tempMaxY) && (CFG.core.getProv(this.getProvince(i)).getMaY6() < tempMinY || CFG.core.getProv(this.getProvince(i)).getMaY6() > tempMaxY)) continue;
            lAverageX += (long)CFG.core.getProv(this.getProvince(i)).getCeShX();
            lAverageY += (long)CFG.core.getProv(this.getProvince(i)).getCeShY();
            ++tSize;
        }
        if (tSize == 0) {
            tSize = 1;
        }
        if (this.shortestLine == null || this.shortestLine.size() < 2) {
            this.iAveragePointPosX = (int)(lAverageX / (long)tSize);
            this.iAveragePointPosY = (int)(lAverageY / (long)tSize);
            return;
        }
        int tAveX = (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getCeX() + CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getCeX()) / 2;
        int tAveY = (CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(0))).getCeY() + CFG.core.getProv(this.lProvinces.get(this.shortestLine.get(1))).getCeY()) / 2;
        this.iAveragePointPosX = (int)(lAverageX / (long)tSize);
        this.iAveragePointPosY = (int)(lAverageY / (long)tSize);
        this.iAveragePointPosX = (int)((float)tAveX + (float)(tAveX - this.iAveragePointPosX) * 0.6f);
        this.iAveragePointPosY = (int)((float)tAveY + (float)(tAveY - this.iAveragePointPosY) * 0.6f);
    }

    public final void buildScaleOfText() {
        if (this.shortestLine == null || this.shortestLine.size() < 2) {
            return;
        }
        synchronized (CFG.FONT_LOCK) {
            try {
                if (this.lProvinces == null || this.shortestLine == null || this.shortestLine.size() < 2) {
                    return;
                }
                int p0 = this.lProvinces.get(this.shortestLine.get(0));
                int p1 = this.lProvinces.get(this.shortestLine.get(1));
                if (CFG.core.getProv(p0) == null || CFG.core.getProv(p1) == null) {
                    return;
                }
                
                int iDistance = (int)Math.sqrt(Math.pow(CFG.core.getProv(p0).getCeX() + CFG.core.getProv(p0).getShPX() - CFG.core.getProv(p1).getCeX() - CFG.core.getProv(p1).getShPX(), 2.0) + Math.pow(CFG.core.getProv(p0).getCeY() + CFG.core.getProv(p0).getShPY() - CFG.core.getProv(p1).getCeY() - CFG.core.getProv(p1).getShPY(), 2.0));
                
                Civilization civ = CFG.core.getCiv(CFG.core.getProv(p0).getCivId());
                if (civ == null) return;
                
                String civName = civ.getCivName();
                if (civName == null || civName.length() == 0) {
                    civName = " ";
                }
                
                GlyphLayout tGlyphLayout = CFG.glyphLay;
                try {
                    tGlyphLayout.setText(CFG.fontBorder2, civName);
                } catch (Exception ex) {
                    civName = " ";
                    tGlyphLayout.setText(CFG.fontBorder2, civName);
                }
                
                float originalScale = 1.0f;
                try {
                    originalScale = CFG.fontBorder2.getData().scaleX;
                } catch (Exception e) {}

                int tempNumOfInterations = 0;
                try {
                    while (tGlyphLayout.width < (float)iDistance * 0.85f && tempNumOfInterations < 50) {
                        CFG.fontBorder2.getData().setScale(CFG.fontBorder2.getData().scaleX + 0.05f);
                        tGlyphLayout.setText(CFG.fontBorder2, civName);
                        tempNumOfInterations++;
                        if (CFG.fontBorder2.getData().scaleX > 1.15f) break;
                    }
                    while (tGlyphLayout.width > (float)iDistance * 0.95f && tempNumOfInterations < 100) {
                        CFG.fontBorder2.getData().setScale(CFG.fontBorder2.getData().scaleX - 0.05f);
                        tGlyphLayout.setText(CFG.fontBorder2, civName);
                        tempNumOfInterations++;
                    }
                } catch (Exception ex) {}
                
                this.fontScale = Math.min(CFG.fontBorder2.getData().scaleX, 1.25f);
                CFG.fontBorder2.getData().setScale(originalScale);
                
                this.buildAveragePoint();
                this.buildDrawData();
            } catch (Exception ex) {
                this.fontScale = 0.9f;
                CFG.fontBorder2.getData().setScale(0.9f);
            }
        }
    }

    
    public final void buildDrawData() {
        Civilization_Region civilization_Region = this;
        synchronized (CFG.FONT_LOCK) {
            CFG.fontBorder2.getData().setScale(this.fontScale);
            this.iCharMaxWidth = 1;
            this.iCharMaxHeight = 1;
            try {
                if (this.lProvinces == null || this.shortestLine == null || this.shortestLine.size() < 2) return;
                int p0 = this.lProvinces.get(this.shortestLine.get(0));
                if (CFG.core.getProv(p0) == null) return;
                
                int civID = CFG.core.getProv(p0).getCivId();
                Civilization civ = CFG.core.getCiv(civID);
                if (civ == null || CFG.fontBorder2 == null) return;
                for (int i = 0; i < civ.getCivNameLength(); ++i) {
                    try {
                        GlyphLayout glyphLayout = new GlyphLayout();
                        if (CFG.fontBorder2 != null) {
                            String charStr = "" + civ.getCivNameCharacter(i);
                            glyphLayout.setText(CFG.fontBorder2, charStr);
                            if (glyphLayout.width > (float)this.iCharMaxWidth) {
                                this.iCharMaxWidth = (int)glyphLayout.width;
                            }
                            if (glyphLayout.height > (float)this.iCharMaxHeight) {
                                this.iCharMaxHeight = (int)glyphLayout.height;
                            }
                        }
                    } catch (Exception ex) {}
                }
            }
            catch (IndexOutOfBoundsException ex) {
                CFG.exceptionStack(ex);
            }
            catch (NullPointerException ex) {
                CFG.exceptionStack(ex);
                try {
                    CFG.core.getCiv(CFG.core.getProv(this.lProvinces.get(0)).getCivId()).setUpdateRegions(true);
                }
                catch (Exception glyphLayout) {}
            }
            catch (IllegalStateException ex) {
                CFG.exceptionStack(ex);
            }
        }
        try {
            if (this.shortestLine == null || this.shortestLine.size() < 2) return;
            this.fAngle = (float)(Math.atan2(CFG.core.getProv(this.getProvince(this.shortestLine.get(0))).getCeShY() - CFG.core.getProv(this.getProvince(this.shortestLine.get(1))).getCeShY(), -CFG.core.getProv(this.getProvince(this.shortestLine.get(0))).getCeShX() + CFG.core.getProv(this.getProvince(this.shortestLine.get(1))).getCeShX()) * 180.0 / Math.PI);
            this.fAngle_Low = (float)(Math.atan2(CFG.core.getProv(this.getProvince(this.shortestLine.get(0))).getCeShY() - CFG.core.getProv(this.getProvince(this.shortestLine.get(this.shortestLine.size() - 1))).getCeShY(), -CFG.core.getProv(this.getProvince(this.shortestLine.get(0))).getCeShX() + CFG.core.getProv(this.getProvince(this.shortestLine.get(this.shortestLine.size() - 1))).getCeShX()) * 180.0 / Math.PI);
        } catch (Exception ex) {
             this.fAngle = 0.0f;
             this.fAngle_Low = 0.0f;
        }
        this.lPoints.clear();
        this.drawMatrix4.clear();
        ArrayList<Float> lPointsAngle = new ArrayList<Float>();
        try {
            block52: {
                int i;
                if (this.shortestLine == null || this.shortestLine.size() < 2) break block52;
                int fromProvinceID = this.lProvinces.get(this.shortestLine.get(0));
                int toProvinceID = this.lProvinces.get(this.shortestLine.get(1));
                int tX = CFG.core.getProv(fromProvinceID).getCeShX();
                int tX2 = CFG.core.getProv(toProvinceID).getCeShX();
                int extra10X = tX + (int)Math.abs((float)(tX2 - tX) * 0.15f) * (tX > tX2 ? -1 : 1);
                int extra10X2 = tX2 + (int)Math.abs((float)(tX2 - tX) * 0.15f) * (tX2 > tX ? -1 : 1);
                int tY = CFG.core.getProv(fromProvinceID).getCeShY();
                int tY2 = CFG.core.getProv(toProvinceID).getCeShY();
                int extra10Y = tY + (int)Math.abs((float)(tY2 - tY) * 0.15f) * (tY > tY2 ? -1 : 1);
                int extra10Y2 = tY2 + (int)Math.abs((float)(tY2 - tY) * 0.15f) * (tY2 > tY ? -1 : 1);
                int iPrecision = Math.max(3, CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength()) * 100;
                Vector2[] vPoints = new Vector2[iPrecision];
                Vector[] dataSet = new Vector2[]{new Vector2(extra10X, extra10Y), new Vector2(extra10X, extra10Y), new Vector2(this.iAveragePointPosX, this.iAveragePointPosY), new Vector2(extra10X2, extra10Y2), new Vector2(extra10X2, extra10Y2)};
                CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
                for (int i2 = 0; i2 < iPrecision; ++i2) {
                    vPoints[i2] = new Vector2();
                    oCatmull.valueAt(vPoints[i2], (float)i2 / ((float)iPrecision - 1.0f));
                }
                float tempPrecissionWidth = 0.0f;
                for (int i3 = 0; i3 < iPrecision - 1; ++i3) {
                    tempPrecissionWidth += Civilization_Region.getLineWidth2((int)vPoints[i3].x, (int)vPoints[i3].y, (int)vPoints[i3 + 1].x, (int)vPoints[i3 + 1].y);
                }
                this.lPoints.add(new Point_XY2((int)vPoints[0].x, (int)vPoints[0].y));
                float acceptableWidth = 0.0f;
                try {
                    acceptableWidth = tempPrecissionWidth / (float)(CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength() - 1);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                float currentPointsWidth = 0.0f;
                int startPrecision = 0;
                block37: for (i = 1; i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength(); ++i) {
                    while (startPrecision < iPrecision - 1) {
                        float tempPrecisionWidth = Civilization_Region.getLineWidth2((int)vPoints[startPrecision].x, (int)vPoints[startPrecision].y, (int)vPoints[startPrecision + 1].x, (int)vPoints[startPrecision + 1].y);
                        if (currentPointsWidth + tempPrecisionWidth >= acceptableWidth) {
                            this.lPoints.add(new Point_XY2((int)vPoints[startPrecision].x, (int)vPoints[startPrecision].y));
                            currentPointsWidth = acceptableWidth - (currentPointsWidth + tempPrecisionWidth);
                            continue block37;
                        }
                        currentPointsWidth += tempPrecisionWidth;
                        ++startPrecision;
                    }
                }
                this.lPoints.add(new Point_XY2((int)vPoints[vPoints.length - 1].x, (int)vPoints[vPoints.length - 1].y));
                try {
                    for (i = 0; i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength(); ++i) {
                        float tempPointsAngle = 0.0f;
                        try {
                            if (i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength() - 1) {
                                tempPointsAngle = Civilization_Region.getLinesAngle(this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY(), this.lPoints.get(i + 1).getPX(), this.lPoints.get(i + 1).getPY());
                            } else if (i - 1 >= 0) {
                                tempPointsAngle = Civilization_Region.getLinesAngle(this.lPoints.get(i - 1).getPX(), this.lPoints.get(i - 1).getPY(), this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY());
                            }
                            lPointsAngle.add(Float.valueOf(tempPointsAngle));
                            continue;
                        }
                        catch (IndexOutOfBoundsException ex) {
                            if (i == 0) {
                                try {
                                    lPointsAngle.add(Float.valueOf(Civilization_Region.getLinesAngle(this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY(), this.lPoints.get(i + 1).getPX(), this.lPoints.get(i + 1).getPY())));
                                }
                                catch (IndexOutOfBoundsException e) {
                                    lPointsAngle.add(Float.valueOf(this.fAngle));
                                }
                                continue;
                            }
                            try {
                                lPointsAngle.add(Float.valueOf(Civilization_Region.getLinesAngle(this.lPoints.get(i - 1).getPX(), this.lPoints.get(i - 1).getPY(), this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY())));
                            }
                            catch (IndexOutOfBoundsException e) {
                                lPointsAngle.add(Float.valueOf(this.fAngle));
                            }
                            continue;
                        }
                        catch (NullPointerException ex) {
                            if (i == 0) {
                                try {
                                    lPointsAngle.add(Float.valueOf(Civilization_Region.getLinesAngle(this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY(), this.lPoints.get(i + 1).getPX(), this.lPoints.get(i + 1).getPY())));
                                }
                                catch (IndexOutOfBoundsException e) {
                                    lPointsAngle.add(Float.valueOf(this.fAngle));
                                }
                            } else {
                                try {
                                    lPointsAngle.add(Float.valueOf(Civilization_Region.getLinesAngle(this.lPoints.get(i - 1).getPX(), this.lPoints.get(i - 1).getPY(), this.lPoints.get(i).getPX(), this.lPoints.get(i).getPY())));
                                }
                                catch (IndexOutOfBoundsException e) {
                                    lPointsAngle.add(Float.valueOf(this.fAngle));
                                }
                            }
                            try {
                                CFG.core.getCiv(CFG.core.getProv(this.lProvinces.get(0)).getCivId()).setUpdateRegions(true);
                                continue;
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                continue;
                            }
                            catch (NullPointerException nullPointerException) {
                                
                            }
                        }
                    }
                }
                catch (IndexOutOfBoundsException ex) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(ex);
                    }
                }
                catch (NullPointerException ex) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        CFG.core.getCiv(CFG.core.getProv(this.lProvinces.get(0)).getCivId()).setUpdateRegions(true);
                    }
                    catch (IndexOutOfBoundsException tempPointsAngle) {
                    }
                    catch (NullPointerException tempPointsAngle) {}
                }
                catch (IllegalStateException ex) {
                    if (!CFG.LOGs) break block52;
                    CFG.exceptionStack(ex);
                }
            }
            float tempAngle = 0.0f;
            int iSize = lPointsAngle.size();
            if (iSize > 0) {
                for (int i = 0; i < iSize; ++i) {
                    tempAngle += ((Float)lPointsAngle.get(i)).floatValue();
                }
                this.centerCharXY = new Point_XY2((int)((float)(this.getCharMaxWidth() / 2) * (1.0f - (90.0f - Math.min(Math.abs(tempAngle /= (float)lPointsAngle.size()), 90.0f)) / 90.0f)), (int)((float)(this.getCharMaxHeight() / 2) * ((90.0f - Math.min(Math.abs(tempAngle), 90.0f)) / 90.0f)));
            } else {
                this.centerCharXY = new Point_XY2(0, 0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        int iSize = lPointsAngle.size();
        for (int i = 0; i < iSize; ++i) {
            this.drawMatrix4.add(new Matrix4().rotate(Renderer.textRotatedVector3, ((Float)lPointsAngle.get(i)).floatValue()));
        }
    }

    public static float getLinesAngle(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        return (float)(Math.atan2(fromPosY - toPosY, -fromPosX + toPosX) * 180.0 / Math.PI);
    }

    public static float getLinesAngle2(float fromPosX, float fromPosY, float toPosX, float toPosY) {
        return (float)(Math.atan2(fromPosY - toPosY, -fromPosX + toPosX) * 180.0 / Math.PI);
    }

    protected int getLineWidth(int fromCenterPosProvinceID, int toCenterPosProvinceID) {
        return Civilization_Region.getLineWidth(CFG.core.getProv(this.lProvinces.get(fromCenterPosProvinceID)).getCeShX(), CFG.core.getProv(this.lProvinces.get(fromCenterPosProvinceID)).getCeShY(), CFG.core.getProv(this.lProvinces.get(toCenterPosProvinceID)).getCeShX(), CFG.core.getProv(this.lProvinces.get(toCenterPosProvinceID)).getCeShY());
    }

    public static int getLineWidth(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        return (int)Math.sqrt(Math.pow(fromPosX - toPosX, 2.0) + Math.pow(fromPosY - toPosY, 2.0));
    }

    public static float getLineWidth2(int fromPosX, int fromPosY, int toPosX, int toPosY) {
        return (float)Math.sqrt(Math.pow(fromPosX - toPosX, 2.0) + Math.pow(fromPosY - toPosY, 2.0));
    }

    public static float getLineWidth3(float fromPosX, float fromPosY, float toPosX, float toPosY) {
        return (float)Math.sqrt(Math.pow(fromPosX - toPosX, 2.0) + Math.pow(fromPosY - toPosY, 2.0));
    }

    public final synchronized void drawCivilizationName(SpriteBatch oSB, int fromProvinceID, float fontScale) {
        CFG.fontBorder.getData().setScale(fontScale);
        for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength(); ++i) {
            Renderer.drawTextRotatedBorder(oSB, "" + CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameCharacter(i), CFG.map.getMpC().getPX() + this.lPoints.get(i).getPX() - this.centerCharXY.getPX(), CFG.map.getMpC().getPY() + this.lPoints.get(i).getPY() - this.centerCharXY.getPY(), this.drawMatrix4.get(i));
        }
    }

    protected final synchronized void drawCivilizationName_SecondSideOfMap(SpriteBatch oSB, int fromProvinceID, float fontScale) {
        if (CFG.core.getProv(fromProvinceID).getTranslateProvPosX() > 0) {
            CFG.fontBorder.getData().setScale(fontScale);
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameLength(); ++i) {
                Renderer.drawTextRotatedBorder(oSB, "" + CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getCivNameCharacter(i), CFG.map.getMpC().getSecondSideOfMap_MoveX() + CFG.map.getMpC().getPX() + this.lPoints.get(i).getPX() - this.centerCharXY.getPX(), CFG.map.getMpC().getPY() + this.lPoints.get(i).getPY() - this.centerCharXY.getPY(), this.drawMatrix4.get(i));
            }
        }
    }

    public final int getProvince(int i) {
        return this.lProvinces.get(i);
    }

    public final int getProvincesSize() {
        return this.iProvincesSize;
    }

    public final boolean getSeaAccess() {
        return this.seaAccess;
    }

    public final boolean getSeaAccess_HavePort() {
        return this.seaAccess_HavePort;
    }

    public final boolean getSeaAccess_HavePort_Check() {
        for (int i = 0; i < this.getProvincesSize(); ++i) {
            if (CFG.core.getProv(this.getProvince(i)).getLvlOfPort() <= 0) continue;
            return true;
        }
        return false;
    }

    public final void setSeaAccess_HavePort(boolean seaAccess_HavePort) {
        this.seaAccess_HavePort = seaAccess_HavePort;
    }

    public final boolean getHaveNotOccupiedProvince() {
        return this.haveNotOccupiedProvince;
    }

    public final List<Integer> getShortestPath() {
        return this.shortestLine;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final int getRegionID() {
        return this.iRegionID;
    }

    public final void setRegionID(int iRegionID) {
        this.iRegionID = iRegionID;
        for (int i = 0; i < this.iProvincesSize; ++i) {
            CFG.core.getProv(i).setCivRegionID(iRegionID);
        }
    }

    public final float getAngle() {
        return this.fAngle;
    }

    public final int getCharMaxWidth() {
        return this.iCharMaxWidth;
    }

    public final int getCharMaxHeight() {
        return this.iCharMaxHeight;
    }

    public final boolean getIsSupplied() {
        return this.isSupplied;
    }

    public final boolean setIsSupplied(boolean isSupplied) {
        this.isSupplied = isSupplied;
        return this.getIsSupplied();
    }
}
