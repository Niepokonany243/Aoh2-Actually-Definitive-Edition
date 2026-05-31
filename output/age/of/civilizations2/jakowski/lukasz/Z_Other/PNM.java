/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_ProvinceName;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Provinces.Point_XY;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SaveLoad.SPNM;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PND;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class PNM {
    public static int NULL_INDICATOR = 666;
    public static List<PND> pND = new ArrayList<PND>();
    public static DPNAM dPN = new DPNAM(){

        @Override
        public void dPNA(SpriteBatch oSB) {
        }
    };

    public static void bPNP(int i) {
        PND nameData = new PND();
        float wMU = 0.0f;
        ArrayList<Boolean> nS = new ArrayList<Boolean>();
        for (int j = 0; j < CFG.core.getProv(i).getPointsSize(); ++j) {
            nS.add(false);
        }
        int checkedWidthNum = 0;
        while (checkedWidthNum < CFG.core.getProv(i).getPointsSize() - 2 && checkedWidthNum < 299) {
            int j;
            int iID = 0;
            int jID = 1;
            checkedWidthNum += 2;
            wMU = 0.0f;
            for (int j2 = 0; j2 < CFG.core.getProv(i).getPointsSize() - 1; ++j2) {
                if (((Boolean)nS.get(j2)).booleanValue()) continue;
                for (int k = j2 + 1; k < CFG.core.getProv(i).getPointsSize(); ++k) {
                    float tWidth;
                    if (((Boolean)nS.get(k)).booleanValue() || !((tWidth = (float)Math.ceil(Math.sqrt((CFG.core.getProv(i).getPoX9(k) - CFG.core.getProv(i).getPoX9(j2)) * (CFG.core.getProv(i).getPoX9(k) - CFG.core.getProv(i).getPoX9(j2)) + (CFG.core.getProv(i).getPoY2(j2) - CFG.core.getProv(i).getPoY2(k)) * (CFG.core.getProv(i).getPoY2(j2) - CFG.core.getProv(i).getPoY2(k))))) > wMU)) continue;
                    wMU = tWidth;
                    nameData.fX = CFG.core.getProv(i).getPoX9(j2);
                    nameData.fX2 = CFG.core.getProv(i).getPoX9(k);
                    nameData.fY = CFG.core.getProv(i).getPoY2(j2);
                    nameData.fY2 = CFG.core.getProv(i).getPoY2(k);
                    nameData.fCenterX = CFG.core.getProv(i).getCeX();
                    nameData.fCenterY = CFG.core.getProv(i).getCeY();
                    iID = j2;
                    jID = k;
                }
            }
            nS.set(iID, true);
            nS.set(jID, true);
            if (nameData.fX2 < nameData.fX) {
                float tSw = nameData.fX;
                nameData.fX = nameData.fX2;
                nameData.fX2 = tSw;
                tSw = nameData.fY;
                nameData.fY = nameData.fY2;
                nameData.fY2 = tSw;
            }
            float tfX = nameData.fX + ((float)CFG.core.getProv(i).getCeX() - nameData.fX) * 0.4f;
            float tfY = nameData.fY + ((float)CFG.core.getProv(i).getCeY() - nameData.fY) * 0.4f;
            float tfX2 = nameData.fX2 + ((float)CFG.core.getProv(i).getCeX() - nameData.fX2) * 0.4f;
            float tfY2 = nameData.fY2 + ((float)CFG.core.getProv(i).getCeY() - nameData.fY2) * 0.4f;
            int iPrecision = CFG.core.getProv(i).getProvName().length() * 4;
            Vector2[] vPoints = new Vector2[iPrecision];
            Vector[] dataSet = new Vector2[]{new Vector2(tfX, tfY), new Vector2(tfX, tfY), new Vector2(CFG.core.getProv(i).getCeX(), CFG.core.getProv(i).getCeY()), new Vector2(tfX2, tfY2), new Vector2(tfX2, tfY2)};
            boolean isInProvince = true;
            CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
            for (j = 0; j < iPrecision; ++j) {
                vPoints[j] = new Vector2();
                oCatmull.valueAt(vPoints[j], (float)j / ((float)iPrecision - 1.0f));
            }
            for (j = vPoints.length - 1; j >= 0; --j) {
                if (CFG.core.setProviPoint((int)vPoints[j].x, (int)vPoints[j].y) == i && CFG.core.setProviPoint((int)vPoints[j].x + CFG.PADD, (int)vPoints[j].y) == i && CFG.core.setProviPoint((int)vPoints[j].x - CFG.PADD, (int)vPoints[j].y) == i && CFG.core.setProviPoint((int)vPoints[j].x, (int)vPoints[j].y + CFG.PADD) == i && CFG.core.setProviPoint((int)vPoints[j].x, (int)vPoints[j].y - CFG.PADD) == i) continue;
                isInProvince = false;
                break;
            }
            if (!isInProvince) continue;
            checkedWidthNum = -1;
            break;
        }
        if (checkedWidthNum > 0) {
            pND.add(null);
        } else {
            pND.add(nameData);
        }
    }

    public static final void bPND() {
        boolean saveData = false;
        int iPNamesSize = pND.size();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (iPNamesSize <= i) {
                PNM.bPNP(i);
                iPNamesSize = pND.size();
                saveData = true;
            }
            PNM.bPND(i, false);
        }
        if (saveData) {
            SPNM.saveProvinceNamesPoints();
        }
    }

    public static void cPND(int i) {
        if (pND.get(i) != null) {
            PNM.pND.get((int)i).drawPoints.clear();
            PNM.pND.get((int)i).drawMatrix4.clear();
            PNM.pND.get((int)i).fontScale = 1.0f;
            PNM.pND.get((int)i).drawAngleLow = 0.0f;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void bPND(int i, boolean rebuild) {
        if (pND.get(i) != null) {
            try {
                if (rebuild) {
                    PNM.pND.get((int)i).drawPoints.clear();
                    PNM.pND.get((int)i).drawMatrix4.clear();
                    PNM.pND.get((int)i).fontScale = 1.0f;
                    PNM.pND.get((int)0).drawAngleLow = 0.0f;
                }
                float maxWidth = Core.getLineWidth3(PNM.pND.get((int)i).fX, PNM.pND.get((int)i).fY, PNM.pND.get((int)i).fX2, PNM.pND.get((int)i).fY2);
                float tfX = PNM.pND.get((int)i).fX + (PNM.pND.get((int)i).fCenterX - PNM.pND.get((int)i).fX) * 0.4f;
                float tfY = PNM.pND.get((int)i).fY + (PNM.pND.get((int)i).fCenterY - PNM.pND.get((int)i).fY) * 0.4f;
                float tfX2 = PNM.pND.get((int)i).fX2 + (PNM.pND.get((int)i).fCenterX - PNM.pND.get((int)i).fX2) * 0.4f;
                float tfY2 = PNM.pND.get((int)i).fY2 + (PNM.pND.get((int)i).fCenterY - PNM.pND.get((int)i).fY2) * 0.4f;
                int iPrecision = CFG.core.getProv(i).getProvName().length() * 8;
                Vector2[] vPoints = new Vector2[iPrecision];
                Vector[] dataSet = new Vector2[]{new Vector2(tfX, tfY), new Vector2(tfX, tfY), new Vector2(PNM.pND.get((int)i).fCenterX, PNM.pND.get((int)i).fCenterY), new Vector2(tfX2, tfY2), new Vector2(tfX2, tfY2)};
                CatmullRomSpline oCatmull = new CatmullRomSpline(dataSet, false);
                for (int j = 0; j < iPrecision; ++j) {
                    vPoints[j] = new Vector2();
                    oCatmull.valueAt(vPoints[j], (float)j / ((float)iPrecision - 1.0f));
                }
                float tempPrecisionWidth = 0.0f;
                for (int j = 0; j < iPrecision - 1; ++j) {
                    tempPrecisionWidth += Core.getLineWidth3(vPoints[j].x, vPoints[j].y, vPoints[j + 1].x, vPoints[j + 1].y);
                }
                float acceptableWidth = 0.0f;
                try {
                    acceptableWidth = tempPrecisionWidth / (float)(CFG.core.getProv(i).getProvName().length() - 1);
                }
                catch (ArithmeticException ex) {
                    CFG.exceptionStack(ex);
                }
                ArrayList<Vector2> tempPoints = new ArrayList<Vector2>();
                tempPoints.add(new Vector2(vPoints[0].x, vPoints[0].y));
                float currentPointsWidth = 0.0f;
                int startPrecision = 0;
                block17: for (int j = 1; j < CFG.core.getProv(i).getProvName().length(); ++j) {
                    while (startPrecision < iPrecision - 1) {
                        float tempPrecisionWidth2 = Core.getLineWidth3(vPoints[startPrecision].x, vPoints[startPrecision].y, vPoints[startPrecision + 1].x, vPoints[startPrecision + 1].y);
                        if (currentPointsWidth + tempPrecisionWidth2 >= acceptableWidth) {
                            tempPoints.add(new Vector2(vPoints[startPrecision].x, vPoints[startPrecision].y));
                            currentPointsWidth = acceptableWidth - (currentPointsWidth + tempPrecisionWidth2);
                            continue block17;
                        }
                        currentPointsWidth += tempPrecisionWidth2;
                        ++startPrecision;
                    }
                }
                tempPoints.add(new Vector2(vPoints[vPoints.length - 1].x, vPoints[vPoints.length - 1].y));
                ArrayList<Float> lPointsAngle = new ArrayList<Float>();
                float fAngle = (float)(Math.atan2(((Vector2)tempPoints.get((int)0)).y - ((Vector2)tempPoints.get((int)1)).y, -((Vector2)tempPoints.get((int)0)).x + ((Vector2)tempPoints.get((int)1)).y) * 180.0 / Math.PI);
                int jSize = Math.min(tempPoints.size(), CFG.core.getProv(i).getProvName().length());
                for (int j = 0; j < jSize; ++j) {
                    try {
                        float tempPointsAngle = j < CFG.core.getProv(i).getProvName().length() - 1 ? Core.getLinesAngle2(((Vector2)tempPoints.get((int)j)).x, ((Vector2)tempPoints.get((int)j)).y, ((Vector2)tempPoints.get((int)(j + 1))).x, ((Vector2)tempPoints.get((int)(j + 1))).y) : Core.getLinesAngle2(((Vector2)tempPoints.get((int)(j - 1))).x, ((Vector2)tempPoints.get((int)(j - 1))).y, ((Vector2)tempPoints.get((int)j)).x, ((Vector2)tempPoints.get((int)j)).y);
                        lPointsAngle.add(Float.valueOf(tempPointsAngle));
                        continue;
                    }
                    catch (Exception ex) {
                        if (j == 0) {
                            try {
                                lPointsAngle.add(Float.valueOf(Core.getLinesAngle2(((Vector2)tempPoints.get((int)j)).x, ((Vector2)tempPoints.get((int)j)).y, ((Vector2)tempPoints.get((int)(j + 1))).x, ((Vector2)tempPoints.get((int)(j + 1))).y)));
                            }
                            catch (IndexOutOfBoundsException e) {
                                lPointsAngle.add(Float.valueOf(fAngle));
                            }
                            continue;
                        }
                        try {
                            lPointsAngle.add(Float.valueOf(Core.getLinesAngle2(((Vector2)tempPoints.get((int)(j - 1))).x, ((Vector2)tempPoints.get((int)(j - 1))).y, ((Vector2)tempPoints.get((int)j)).x, ((Vector2)tempPoints.get((int)j)).y)));
                            continue;
                        }
                        catch (IndexOutOfBoundsException e) {
                            lPointsAngle.add(Float.valueOf(fAngle));
                        }
                    }
                }
                float iDistance = maxWidth * 0.8f;
                GlyphLayout glyphLayout = new GlyphLayout();
                Class<PNM> tempPointsAngle = PNM.class;
                synchronized (PNM.class) {
                    int j;
                    block31: {
                        CFG.fontBorder2.getData().setScale(1.0f);
                        glyphLayout.setText(CFG.fontBorder2, CFG.core.getProv(i).getProvNameUpperCase());
                        int tempNumOfIterations = 0;
                        float tempScale = Math.max(0.1f, iDistance / glyphLayout.width);
                        if (glyphLayout.width > 0.1f) {
                            CFG.fontBorder2.getData().setScale(tempScale);
                        }
                        try {
                            if (!(iDistance > 0.0f)) break block31;
                            do {
                                if (iDistance > glyphLayout.width) {
                                    CFG.fontBorder2.getData().setScale(Math.max(0.001f, tempScale += 0.025f));
                                    glyphLayout.setText(CFG.fontBorder2, CFG.core.getProv(i).getProvNameUpperCase());
                                    if (!(iDistance < glyphLayout.width)) continue;
                                    PNM.pND.get((int)i).fontScale = Math.max(1.0E-4f, tempScale - 0.0125f);
                                } else {
                                    CFG.fontBorder2.getData().setScale(Math.max(0.001f, tempScale -= 0.025f));
                                    glyphLayout.setText(CFG.fontBorder2, CFG.core.getProv(i).getProvNameUpperCase());
                                    if (!(iDistance > glyphLayout.width)) continue;
                                    PNM.pND.get((int)i).fontScale = Math.max(1.0E-4f, tempScale + 0.0125f);
                                }
                                break block31;
                            } while (tempNumOfIterations++ <= 999);
                            PNM.pND.get((int)i).fontScale = 1.0E-4f;
                        }
                        catch (Exception ex) {
                            PNM.pND.get((int)i).fontScale = 1.0E-4f;
                        }
                    }
                    // ** MonitorExit[tempPointsAngle] (shouldn't be in output)
                    int jSize2 = tempPoints.size();
                    for (j = 0; j < jSize2; ++j) {
                        PNM.pND.get((int)i).drawPoints.add(new Point_XY((int)((Vector2)tempPoints.get((int)j)).x, (int)((Vector2)tempPoints.get((int)j)).y));
                    }
                    jSize2 = lPointsAngle.size();
                    for (j = 0; j < jSize2; ++j) {
                        PNM.pND.get((int)i).drawMatrix4.add(new Matrix4().rotate(Renderer.textRotatedVector3, ((Float)lPointsAngle.get(j)).floatValue()));
                    }
                    PNM.pND.get((int)i).drawAngleLow = Core.getLinesAngle2(((Vector2)tempPoints.get((int)0)).x, ((Vector2)tempPoints.get((int)0)).y, ((Vector2)tempPoints.get((int)(tempPoints.size() - 1))).x, ((Vector2)tempPoints.get((int)(tempPoints.size() - 1))).y);
                    for (int a = PNM.pND.get((int)i).drawMatrix4.size(); a < CFG.core.getProv(i).getProvNameUpperCase().length(); ++a) {
                        PNM.pND.get((int)i).drawMatrix4.add(new Matrix4().rotate(Renderer.textRotatedVector3, 0.0f));
                    }
                    PNM.pND.get((int)i).drawMatrix4.add(new Matrix4().rotate(Renderer.textRotatedVector3, PNM.pND.get((int)i).drawAngleLow));
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static final void uDPN() {
        dPN = CFG.menus.getIn_InitMenu() || CFG.menus.getInGamesMenu() || CFG.menus.getInEditorMenu() || CFG.menus.getIn_SKMenu() || CFG.menus.getIn_MMMenu() || CFG.menus.getIn_FBMenu() || CFG.menus.getIn_NVMenu() || CFG.menus.getInNextPlayerTurn() || CFG.menus.getIn_Game_CivilizationView() || CFG.menus.getInLoadMap() || CFG.menus.getInLoadSave() || CFG.menus.getIn_SaveTheGame() ? new DPNAM(){

            @Override
            public void dPNA(SpriteBatch oSB) {
            }
        } : (CFG.settingsGD.SPROVN == 0 ? new DPNAM(){

            @Override
            public void dPNA(SpriteBatch oSB) {
                PNM.uDPNA();
            }
        } : (CFG.settingsGD.SPROVN == 1 || !CFG.map.getMapProvinceNames(CFG.map.getActiveMapIDN()) ? new DPNAM(){

            @Override
            public void dPNA(SpriteBatch oSB) {
                PNM.uDPNA();
            }
        } : (CFG.settingsGD.SPROVN == 2 ? new DPNAM(){

            @Override
            public void dPNA(SpriteBatch oSB) {
                PNM.uDPNA();
                if (CFG.map.getMpS().getCurrSc() >= Core.DRAW_CIV_NAMES_START_DRAWING_MAP_SCALE) {
                    PNM.dPNJMD(oSB);
                } else if (Core.DRAW_PROVINCE_NAMES_ALPHA > 0.05f) {
                    PNM.dPNJMD(oSB);
                }
            }
        } : new DPNAM(){

            @Override
            public void dPNA(SpriteBatch oSB) {
                PNM.uDPNA();
                if (CFG.map.getMpS().getCurrSc() >= Render.CIV_NAMES_START_DRAWING_NAMES_MAP_SCALE) {
                    PNM.dPNJD(oSB);
                } else if (Core.DRAW_PROVINCE_NAMES_ALPHA > 0.05f) {
                    PNM.dPNJD(oSB);
                }
            }
        })));
    }

    public static void uDPNA() {
        try {
            long now = CFG.currentTimeMillis;
            if (CFG.map.getMpS().getCurrSc() >= Render.CIV_NAMES_START_DRAWING_NAMES_MAP_SCALE) {
                if (Core.DRAW_PROVINCE_NAMES_ALPHA < 1.0f) {
                    float progress;
                    if (Core.DRAW_PROVINCE_NAMES_TIME == 0L) {
                        Core.DRAW_PROVINCE_NAMES_TIME = now;
                    }
                    if ((Core.DRAW_PROVINCE_NAMES_ALPHA = Math.min(1.0f, progress = (float)(now - Core.DRAW_PROVINCE_NAMES_TIME) / Core.CIVILIZATIONS_NAMES_INTERVAL)) >= 1.0f) {
                        Core.DRAW_PROVINCE_NAMES_ALPHA = 1.0f;
                        Core.DRAW_PROVINCE_NAMES_TIME = 0L;
                    }
                } else {
                    Core.DRAW_PROVINCE_NAMES_TIME = 0L;
                }
            } else if (Core.DRAW_PROVINCE_NAMES_ALPHA > 0.0f) {
                float progress;
                if (Core.DRAW_PROVINCE_NAMES_TIME == 0L) {
                    Core.DRAW_PROVINCE_NAMES_TIME = now;
                }
                if ((Core.DRAW_PROVINCE_NAMES_ALPHA = Math.max(0.0f, 1.0f - (progress = (float)(now - Core.DRAW_PROVINCE_NAMES_TIME) / Core.CIVILIZATIONS_NAMES_INTERVAL))) <= 0.0f) {
                    Core.DRAW_PROVINCE_NAMES_ALPHA = 0.0f;
                    Core.DRAW_PROVINCE_NAMES_TIME = 0L;
                }
            } else {
                Core.DRAW_PROVINCE_NAMES_TIME = 0L;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final synchronized void dPNJD(SpriteBatch oSB) {
        Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
        CFG.fontBorder.setColor(new Color(1.0f, 1.0f, 1.0f, CFG.settingsGD.PROVINCE_NAMES_ALPHA * Core.DRAW_PROVINCE_NAMES_ALPHA));
        PNM.dPNJDI(oSB);
        oSB.setTransformMatrix(oldTransformMatrix);
    }

    public static final void dPNJDI(SpriteBatch oSB) {
        try {
            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                PNM.dPRNA(oSB, CFG.core.getPIV(i), 0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final synchronized void dPNJMD(SpriteBatch oSB) {
        try {
            Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
            CFG.fontBorder.setColor(new Color(1.0f, 1.0f, 1.0f, CFG.settingsGD.PROVINCE_NAMES_ALPHA * Core.DRAW_PROVINCE_NAMES_ALPHA));
            PNM.dPNJMDI(oSB);
            oSB.setTransformMatrix(oldTransformMatrix);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void dPNJMDI(SpriteBatch oSB) {
        try {
            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                PNM.dPNM(oSB, CFG.core.getPIV(i), 0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final synchronized void dPRNA(SpriteBatch oSB, int i, int extraX) {
        if (pND.get(i) == null) {
            return;
        }
        try {
            PND tPN = pND.get(i);
            float fontScale = tPN.fontScale * CFG.map.getMpS().getCurrSc();
            if (fontScale > CFG.settingsGD.PROVINCE_NAMES_SCALE) {
                CFG.fontBorder.getData().setScale(fontScale);
                extraX = CFG.core.getProv(i).getTranslateProvPosX() + extraX;
                for (int j = CFG.core.getProv((int)i).iProvinceNameLength_Minus1; j >= 0; --j) {
                    Renderer.drawTextRotatedBorder(oSB, String.valueOf(CFG.core.getProv(i).getProvNameUpperCase().charAt(j)), (int)((float)(extraX + tPN.drawPoints.get(j).getPosX()) * CFG.map.getMpS().getCurrSc()), (int)((float)(CFG.map.getMpC().getPY() + tPN.drawPoints.get(j).getPosY()) * CFG.map.getMpS().getCurrSc()), tPN.drawMatrix4.get(j));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final synchronized void dPNM(SpriteBatch oSB, int i, int extraX) {
        if (pND.get(i) == null) {
            return;
        }
        if (PNM.pND.get((int)i).drawPoints.isEmpty()) {
            return;
        }
        float fontScale = PNM.pND.get((int)i).fontScale * CFG.map.getMpS().getCurrSc();
        if (fontScale > CFG.settingsGD.PROVINCE_NAMES_SCALE) {
            CFG.fontBorder.getData().setScale(fontScale);
            Renderer.drawTextRotatedBorder_2(oSB, "" + CFG.core.getProv(i).getProvNameUpperCase(), (int)((float)(CFG.core.getProv(i).getTranslateProvPosX() + extraX + PNM.pND.get((int)i).drawPoints.get(0).getPosX()) * CFG.map.getMpS().getCurrSc()), (int)((float)(CFG.map.getMpC().getPY() + PNM.pND.get((int)i).drawPoints.get(0).getPosY()) * CFG.map.getMpS().getCurrSc()), PNM.pND.get((int)i).drawAngleLow);
        }
    }

    public static final void dPNP(SpriteBatch oSB, int i) {
        if (pND.get(i) != null) {
            if (Editor_ProvinceName.firstPoint && !Editor_ProvinceName.centerPoint) {
                oSB.setColor(Color.RED);
            }
            Images.pix.draw(oSB, (int)((float)CFG.map.getMpC().getPX() + PNM.pND.get((int)i).fX) - 1, (int)((float)CFG.map.getMpC().getPY() + PNM.pND.get((int)i).fY) - 1, 3, 3);
            oSB.setColor(Color.WHITE);
            if (Editor_ProvinceName.centerPoint) {
                oSB.setColor(Color.RED);
            }
            Images.pix.draw(oSB, (int)((float)CFG.map.getMpC().getPX() + PNM.pND.get((int)i).fCenterX) - 1, (int)((float)CFG.map.getMpC().getPY() + PNM.pND.get((int)i).fCenterY) - 1, 3, 3);
            oSB.setColor(Color.WHITE);
            if (!Editor_ProvinceName.firstPoint && !Editor_ProvinceName.centerPoint) {
                oSB.setColor(Color.RED);
            }
            Images.pix.draw(oSB, (int)((float)CFG.map.getMpC().getPX() + PNM.pND.get((int)i).fX2) - 1, (int)((float)CFG.map.getMpC().getPY() + PNM.pND.get((int)i).fY2) - 1, 3, 3);
            oSB.setColor(Color.WHITE);
        }
    }

    public static interface DPNAM {
        public void dPNA(SpriteBatch var1);
    }
}

