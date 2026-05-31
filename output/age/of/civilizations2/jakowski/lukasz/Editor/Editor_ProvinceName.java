/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PND;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;

public class Editor_ProvinceName
extends Editor {
    public static boolean firstPoint = true;
    public static boolean centerPoint = false;

    @Override
    public void keyDown(int keycode) {
        if (keycode == 62) {
            firstPoint = !firstPoint;
            centerPoint = false;
            return;
        }
        if (keycode == 31) {
            centerPoint = !centerPoint;
            return;
        }
        if (CFG.core.getActiveProvID() >= 0) {
            if (PNM.pND.get(CFG.core.getActiveProvID()) != null) {
                if (keycode == 46) {
                    CFG.settingsGD.SPROVN = CFG.settingsGD.SPROVN == 3 ? 2 : 3;
                    Core.addSimpleTask(new Core.SimpleTask("updateDrawProvinceNames"){

                        @Override
                        public void update() {
                            PNM.uDPN();
                        }
                    });
                }
                if (centerPoint) {
                    if (keycode == 21) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterX += -1.0f;
                    }
                    if (keycode == 22) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterX += 1.0f;
                    }
                    if (keycode == 19) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterY += -1.0f;
                    }
                    if (keycode == 20) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterY += 1.0f;
                    }
                    if (keycode == 29) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterX += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 32) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterX += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 51) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterY += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 47) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterY += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                } else if (firstPoint) {
                    if (keycode == 21) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX += -1.0f;
                    }
                    if (keycode == 22) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX += 1.0f;
                    }
                    if (keycode == 19) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY += -1.0f;
                    }
                    if (keycode == 20) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY += 1.0f;
                    }
                    if (keycode == 29) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 32) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 51) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 47) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                } else {
                    if (keycode == 21) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 += -1.0f;
                    }
                    if (keycode == 22) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 += 1.0f;
                    }
                    if (keycode == 19) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 += -1.0f;
                    }
                    if (keycode == 20) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 += 1.0f;
                    }
                    if (keycode == 29) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 32) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 51) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 += (float)(-3 * CFG.map.getMpB().getMapSc3());
                    }
                    if (keycode == 47) {
                        PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 += (float)(3 * CFG.map.getMpB().getMapSc3());
                    }
                }
                if (keycode == 44) {
                    if (PNM.pND.get(CFG.core.getActiveProvID()) == null) {
                        return;
                    }
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX();
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX();
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX();
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fCenterY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                }
                if (PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 < PNM.pND.get((int)CFG.core.getActiveProvID()).fX) {
                    float tSw = PNM.pND.get((int)CFG.core.getActiveProvID()).fX;
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fX = PNM.pND.get((int)CFG.core.getActiveProvID()).fX2;
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fX2 = tSw;
                    tSw = PNM.pND.get((int)CFG.core.getActiveProvID()).fY;
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fY = PNM.pND.get((int)CFG.core.getActiveProvID()).fY2;
                    PNM.pND.get((int)CFG.core.getActiveProvID()).fY2 = tSw;
                    firstPoint = !firstPoint;
                }
                PNM.cPND(CFG.core.getActiveProvID());
                PNM.bPND(CFG.core.getActiveProvID(), false);
            } else {
                PND newProvinceName = new PND();
                newProvinceName.fCenterX = CFG.core.getProv(CFG.core.getActiveProvID()).getCeX();
                newProvinceName.fCenterY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                newProvinceName.fX = CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2();
                newProvinceName.fY = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                newProvinceName.fX2 = CFG.core.getProv(CFG.core.getActiveProvID()).getMaX7();
                newProvinceName.fY2 = CFG.core.getProv(CFG.core.getActiveProvID()).getCeY();
                PNM.pND.set(CFG.core.getActiveProvID(), newProvinceName);
                PNM.cPND(CFG.core.getActiveProvID());
                PNM.bPND(CFG.core.getActiveProvID(), false);
            }
        }
    }

    @Override
    public String toString() {
        String name = "";
        try {
            name = CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getProvName() : "";
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "Province Name: " + name + "\nW A S D x3\nArrows x1\nSpace - Change Point Mode\nC - Center Point On/Off\nP - Reset";
    }
}

