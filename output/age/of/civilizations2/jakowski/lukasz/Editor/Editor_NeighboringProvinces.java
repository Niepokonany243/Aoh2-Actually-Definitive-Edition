
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Editor_NeighboringProvinces
extends Editor {
    public int activeProvinceID = -1;

    @Override
    public void keyDown(int keycode) {
        ArrayList<Short> nPointsY;
        ArrayList<Short> nPointsX;
        if (Gdx.input.isKeyPressed(62)) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = this.activeProvinceID = CFG.core.getActiveProvID();
            CFG.menus.rebuildMapEditor_Connections_IDs(this.activeProvinceID);
        }
        if (CFG.core.getActiveProvID() >= 0) {
            if (Gdx.input.isKeyPressed(19)) {
                try {
                    FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "updatePB/" + CFG.core.getActiveProvID());
                    String[] tempSplit = file.readString().split(";");
                    String[] prov = tempSplit[0].split(",");
                    String[] tempX = tempSplit[1].split(",");
                    String[] tempY = tempSplit[2].split(",");
                    int provID = Integer.parseInt(prov[0]);
                    ArrayList<Short> tempPointsX = new ArrayList<Short>();
                    ArrayList<Short> tempPointsY = new ArrayList<Short>();
                    for (int j = 0; j < tempX.length; ++j) {
                        tempPointsX.add((short)Integer.parseInt(tempX[j]));
                        tempPointsY.add((short)Integer.parseInt(tempY[j]));
                    }
                    CFG.core.getProv(CFG.core.getActiveProvID()).removeProvBorder(provID);
                    CFG.core.getProv(CFG.core.getActiveProvID()).addProvBorder(provID, tempPointsX, tempPointsY);
                    CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
                }
                catch (GdxRuntimeException ex) {
                    CFG.toastM.addM("FILE NOT FOUND: [map/" + CFG.map.getFileActiveMapPath() + "updatePB/" + CFG.core.getActiveProvID() + "]");
                }
            } else if (Gdx.input.isKeyPressed(20)) {
                Editor_NeighboringProvinces.updateProvince(CFG.core.getActiveProvID());
            }
        }
        if (Gdx.input.isKeyPressed(45)) {
            if (CFG.core.getActiveProvID() < 0) {
                return;
            }
            String tempX = "";
            String tempY = "";
            for (int i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize(); ++i) {
                tempX = tempX + "" + CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(i) / CFG.map.getMpB().getMapSc3() + ",";
                tempY = tempY + "" + CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(i) / CFG.map.getMpB().getMapSc3() + ",";
            }
            FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "MAP_POINTS");
            fileSave.writeString("", false);
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                String tempX2 = "";
                String tempY2 = "";
                for (int j = 0; j < CFG.core.getProv(i).getPointsSize(); ++j) {
                    tempX2 = tempX2 + "" + CFG.core.getProv(i).getPoX9(j) / CFG.map.getMpB().getMapSc3() + (CFG.core.getProv(i).getPointsSize() - 1 == j ? "" : ",");
                    tempY2 = tempY2 + "" + CFG.core.getProv(i).getPoY2(j) / CFG.map.getMpB().getMapSc3() + (CFG.core.getProv(i).getPointsSize() - 1 == j ? "" : ",");
                }
                fileSave.writeString(tempX2 + "\n", true);
                fileSave.writeString(tempY2 + "\n", true);
            }
        }
        if (this.activeProvinceID < 0) {
            return;
        }
        if (Gdx.input.isKeyPressed(66) && this.activeProvinceID != CFG.core.getActiveProvID()) {
            int i;
            for (i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getNeighProvinces(i) != this.activeProvinceID) continue;
                return;
            }
            for (i = 0; i < CFG.core.getProv(CFG.core.getActiveProvID()).getNeighSeaProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getNeighSeaProvinces(i) != this.activeProvinceID) continue;
                return;
            }
            for (i = 0; i < CFG.core.getProv(this.activeProvinceID).getNeighSeaProvincesSize(); ++i) {
                if (CFG.core.getProv(this.activeProvinceID).getNeighSeaProvinces(i) != CFG.core.getActiveProvID()) continue;
                return;
            }
            if (CFG.core.getProv(this.activeProvinceID).getSeaProv()) {
                CFG.core.getProv(this.activeProvinceID).addNeighboringProv(CFG.core.getActiveProvID());
            } else if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                CFG.core.getProv(this.activeProvinceID).addNeighboringSeaProvince(CFG.core.getActiveProvID());
                CFG.core.getProv(this.activeProvinceID).setLvlOfPort(1);
            } else {
                CFG.core.getProv(this.activeProvinceID).addNeighboringProv(CFG.core.getActiveProvID());
            }
            if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).addNeighboringProv(this.activeProvinceID);
            } else if (CFG.core.getProv(this.activeProvinceID).getSeaProv()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).addNeighboringSeaProvince(this.activeProvinceID);
                CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfPort(1);
            } else {
                CFG.core.getProv(CFG.core.getActiveProvID()).addNeighboringProv(this.activeProvinceID);
            }
            nPointsX = new ArrayList();
            nPointsY = new ArrayList();
            for (int i2 = 0; i2 < CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize(); ++i2) {
                boolean found = false;
                int j = 0;
                if (j < CFG.core.getProv(this.activeProvinceID).getPointsSize()) {
                    int n;
                    int nSize;
                    boolean end;
                    int n2;
                    int nSize2;
                    int o;
                    boolean f1;
                    int o2;
                    found = true;
                    boolean l1 = false;
                    int oSize = CFG.core.getProv(this.activeProvinceID).getPointsSize();
                    for (o2 = 0; o2 < oSize; ++o2) {
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize() - 1) != CFG.core.getProv(this.activeProvinceID).getPoX9(o2) || CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize() - 1) != CFG.core.getProv(this.activeProvinceID).getPoY2(o2)) continue;
                        l1 = true;
                    }
                    if (l1) {
                        l1 = false;
                        oSize = CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize();
                        for (o2 = 0; o2 < oSize; ++o2) {
                            if (CFG.core.getProv(this.activeProvinceID).getPoX9(CFG.core.getProv(this.activeProvinceID).getPointsSize() - 1) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o2) || CFG.core.getProv(this.activeProvinceID).getPoY2(CFG.core.getProv(this.activeProvinceID).getPointsSize() - 1) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o2)) continue;
                            l1 = true;
                        }
                        if (!l1) {
                            f1 = false;
                            block12: for (o = CFG.core.getProv(this.activeProvinceID).getPointsSize() - 1; o >= 0; --o) {
                                if (!f1) {
                                    nSize2 = CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize();
                                    for (n2 = 0; n2 < nSize2; ++n2) {
                                        if (CFG.core.getProv(this.activeProvinceID).getPoX9(o) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(n2) || CFG.core.getProv(this.activeProvinceID).getPoY2(o) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(n2)) continue;
                                        f1 = true;
                                        nPointsX.add((short)CFG.core.getProv(this.activeProvinceID).getPoX9(o));
                                        nPointsY.add((short)CFG.core.getProv(this.activeProvinceID).getPoY2(o));
                                        continue block12;
                                    }
                                    continue;
                                }
                                end = true;
                                nSize = CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize();
                                for (n = 0; n < nSize; ++n) {
                                    if (CFG.core.getProv(this.activeProvinceID).getPoX9(o) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(n) || CFG.core.getProv(this.activeProvinceID).getPoY2(o) != CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(n)) continue;
                                    end = false;
                                    nPointsX.add((short)CFG.core.getProv(this.activeProvinceID).getPoX9(o));
                                    nPointsY.add((short)CFG.core.getProv(this.activeProvinceID).getPoY2(o));
                                    break;
                                }
                                if (!end) {
                                    continue;
                                }
                                break;
                            }
                        } else {
                            boolean startID = false;
                            boolean t1 = false;
                            for (int o3 = CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize() - 1; o3 >= 0; --o3) {
                                t1 = false;
                                nSize = CFG.core.getProv(this.activeProvinceID).getPointsSize();
                                for (n = 0; n < nSize; ++n) {
                                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o3) != CFG.core.getProv(this.activeProvinceID).getPoX9(n) || CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o3) != CFG.core.getProv(this.activeProvinceID).getPoY2(n)) continue;
                                    t1 = true;
                                    break;
                                }
                                if (t1) continue;
                                ++o3;
                                while (o3 < CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize() - 1) {
                                    nPointsX.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o3));
                                    nPointsY.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o3));
                                    ++o3;
                                }
                                break;
                            }
                            for (int h = 0; h < CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize(); ++h) {
                                boolean addT = false;
                                for (int n3 = 0; n3 < CFG.core.getProv(this.activeProvinceID).getPointsSize(); ++n3) {
                                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(h) != CFG.core.getProv(this.activeProvinceID).getPoX9(n3) || CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(h) != CFG.core.getProv(this.activeProvinceID).getPoY2(n3)) continue;
                                    addT = true;
                                    break;
                                }
                                if (addT) {
                                    nPointsX.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(h));
                                    nPointsY.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(h));
                                    continue;
                                }
                                break;
                            }
                        }
                    } else {
                        f1 = false;
                        block20: for (o = CFG.core.getProv(CFG.core.getActiveProvID()).getPointsSize() - 1; o >= 0; --o) {
                            if (!f1) {
                                nSize2 = CFG.core.getProv(this.activeProvinceID).getPointsSize();
                                for (n2 = 0; n2 < nSize2; ++n2) {
                                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o) != CFG.core.getProv(this.activeProvinceID).getPoX9(n2) || CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o) != CFG.core.getProv(this.activeProvinceID).getPoY2(n2)) continue;
                                    f1 = true;
                                    nPointsX.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o));
                                    nPointsY.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o));
                                    continue block20;
                                }
                                continue;
                            }
                            end = true;
                            nSize = CFG.core.getProv(this.activeProvinceID).getPointsSize();
                            for (n = 0; n < nSize; ++n) {
                                if (CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o) != CFG.core.getProv(this.activeProvinceID).getPoX9(n) || CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o) != CFG.core.getProv(this.activeProvinceID).getPoY2(n)) continue;
                                end = false;
                                nPointsX.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoX9(o));
                                nPointsY.add((short)CFG.core.getProv(CFG.core.getActiveProvID()).getPoY2(o));
                                break;
                            }
                            if (!end) {
                                continue;
                            }
                            break;
                        }
                    }
                }
                if (found) break;
            }
            for (int a = 0; a < nPointsX.size(); ++a) {
                nPointsX.set(a, (short)((Short)nPointsX.get(a) / CFG.map.getMpB().getMapSc3()));
                nPointsY.set(a, (short)((Short)nPointsY.get(a) / CFG.map.getMpB().getMapSc3()));
            }
            if (this.activeProvinceID > CFG.core.getActiveProvID()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).addProvBorder(this.activeProvinceID, nPointsX, nPointsY);
            } else {
                CFG.core.getProv(this.activeProvinceID).addProvBorder(CFG.core.getActiveProvID(), nPointsX, nPointsY);
            }
            CFG.core.buildGameProvinceData(this.activeProvinceID);
            CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
            CFG.toastM.addM(CFG.lang.get("Added") + " [" + this.activeProvinceID + " - " + CFG.core.getActiveProvID() + "]");
            CFG.menus.rebuildMapEditor_Connections_IDs(this.activeProvinceID);
        }
        if (Gdx.input.isKeyPressed(41) && this.activeProvinceID != CFG.core.getActiveProvID()) {
            nPointsX = new ArrayList<Short>();
            nPointsY = new ArrayList<Short>();
            if (this.activeProvinceID > CFG.core.getActiveProvID()) {
                int i;
                for (i = 0; i < CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandByLand((int)this.activeProvinceID).pX.size(); ++i) {
                    nPointsX.add(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandByLand((int)this.activeProvinceID).pX.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandByLand((int)this.activeProvinceID).pX.size() - 1 - i));
                    nPointsY.add((short)CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandByLand((int)this.activeProvinceID).pY.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandByLand((int)this.activeProvinceID).pY.size() - 1 - i));
                }
                if (nPointsX.size() == 0) {
                    for (i = 0; i < CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandBySea((int)this.activeProvinceID).pX.size(); ++i) {
                        nPointsX.add((short)CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandBySea((int)this.activeProvinceID).pX.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandBySea((int)this.activeProvinceID).pX.size() - 1 - i));
                        nPointsY.add((short)CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandBySea((int)this.activeProvinceID).pY.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersLandBySea((int)this.activeProvinceID).pY.size() - 1 - i));
                    }
                }
                if (nPointsX.size() == 0) {
                    for (i = 0; i < CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersSeaBySea((int)this.activeProvinceID).pX.size(); ++i) {
                        nPointsX.add((short)CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersSeaBySea((int)this.activeProvinceID).pX.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersSeaBySea((int)this.activeProvinceID).pX.size() - 1 - i));
                        nPointsY.add((short)CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersSeaBySea((int)this.activeProvinceID).pY.get(CFG.core.getProv((int)CFG.core.getActiveProvID()).getProvBordersSeaBySea((int)this.activeProvinceID).pY.size() - 1 - i));
                    }
                }
            } else {
                int i;
                for (i = 0; i < CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandByLand((int)CFG.core.getActiveProvID()).pX.size(); ++i) {
                    nPointsX.add(CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandByLand((int)CFG.core.getActiveProvID()).pX.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandByLand((int)CFG.core.getActiveProvID()).pX.size() - 1 - i));
                    nPointsY.add((short)CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandByLand((int)CFG.core.getActiveProvID()).pY.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandByLand((int)CFG.core.getActiveProvID()).pY.size() - 1 - i));
                }
                if (nPointsX.size() == 0) {
                    for (i = 0; i < CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandBySea((int)CFG.core.getActiveProvID()).pX.size(); ++i) {
                        nPointsX.add((short)CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandBySea((int)CFG.core.getActiveProvID()).pX.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandBySea((int)CFG.core.getActiveProvID()).pX.size() - 1 - i));
                        nPointsY.add((short)CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandBySea((int)CFG.core.getActiveProvID()).pY.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersLandBySea((int)CFG.core.getActiveProvID()).pY.size() - 1 - i));
                    }
                }
                if (nPointsX.size() == 0) {
                    for (i = 0; i < CFG.core.getProv((int)this.activeProvinceID).getProvBordersSeaBySea((int)CFG.core.getActiveProvID()).pX.size(); ++i) {
                        nPointsX.add((short)CFG.core.getProv((int)this.activeProvinceID).getProvBordersSeaBySea((int)CFG.core.getActiveProvID()).pX.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersSeaBySea((int)CFG.core.getActiveProvID()).pX.size() - 1 - i));
                        nPointsY.add((short)CFG.core.getProv((int)this.activeProvinceID).getProvBordersSeaBySea((int)CFG.core.getActiveProvID()).pY.get(CFG.core.getProv((int)this.activeProvinceID).getProvBordersSeaBySea((int)CFG.core.getActiveProvID()).pY.size() - 1 - i));
                    }
                }
            }
            if (this.activeProvinceID > CFG.core.getActiveProvID()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).removeProvBorder(this.activeProvinceID);
            } else {
                CFG.core.getProv(this.activeProvinceID).removeProvBorder(CFG.core.getActiveProvID());
            }
            if (this.activeProvinceID > CFG.core.getActiveProvID()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).addProvBorder(this.activeProvinceID, nPointsX, nPointsY);
            } else {
                CFG.core.getProv(this.activeProvinceID).addProvBorder(CFG.core.getActiveProvID(), nPointsX, nPointsY);
            }
            CFG.core.buildGameProvinceData(this.activeProvinceID);
            CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
        }
        if (Gdx.input.isKeyPressed(67) && this.activeProvinceID != CFG.core.getActiveProvID()) {
            CFG.core.getProv(CFG.core.getActiveProvID()).removeNeighboringProv(this.activeProvinceID);
            CFG.core.getProv(CFG.core.getActiveProvID()).removeNeighboringSeaProvince(this.activeProvinceID);
            CFG.core.getProv(this.activeProvinceID).removeNeighboringProv(CFG.core.getActiveProvID());
            CFG.core.getProv(this.activeProvinceID).removeNeighboringSeaProvince(CFG.core.getActiveProvID());
            if (!CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getNeighSeaProvincesSize() == 0) {
                CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfPort(-1);
            }
            if (!CFG.core.getProv(this.activeProvinceID).getSeaProv() && CFG.core.getProv(this.activeProvinceID).getNeighSeaProvincesSize() == 0) {
                CFG.core.getProv(this.activeProvinceID).setLvlOfPort(-1);
            }
            if (this.activeProvinceID > CFG.core.getActiveProvID()) {
                CFG.core.getProv(CFG.core.getActiveProvID()).removeProvBorder(this.activeProvinceID);
            } else {
                CFG.core.getProv(this.activeProvinceID).removeProvBorder(CFG.core.getActiveProvID());
            }
            CFG.core.buildGameProvinceData(this.activeProvinceID);
            CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
            CFG.toastM.addM(CFG.lang.get("Removed") + " [" + this.activeProvinceID + " - " + CFG.core.getActiveProvID() + "]");
            CFG.menus.rebuildMapEditor_Connections_IDs(this.activeProvinceID);
        }
    }

    public static final void updateProvince(int nID) {
        try {
            FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "update/" + nID);
            String[] tempSplit = file.readString().split(";");
            String[] tempX = tempSplit[0].split(",");
            String[] tempY = tempSplit[1].split(",");
            ArrayList<Short> tempPointsX = new ArrayList<Short>();
            ArrayList<Short> tempPointsY = new ArrayList<Short>();
            for (int j = 0; j < tempX.length; ++j) {
                tempPointsX.add((short)Integer.parseInt(tempX[j]));
                tempPointsY.add((short)Integer.parseInt(tempY[j]));
            }
            CFG.core.getProv(nID).setPoints(tempPointsX, tempPointsY);
            CFG.core.getProv(nID).buildProvinceBG(true);
            CFG.core.getProv(nID).loadProvinceBG();
            CFG.core.buildGameProvinceData(CFG.core.getActiveProvID());
        }
        catch (GdxRuntimeException ex) {
            CFG.toastM.addM("FILE NOT FOUND: [map/" + CFG.map.getFileActiveMapPath() + "update/" + nID + "]");
        }
    }

    @Override
    public String toString() {
        return "ACTIVE PROVINCE ID: " + this.activeProvinceID + "\n\nSPACE -> SET ACTIVE PROVINCE\nENTER -> ADD CONNECTION\nBACKSPACE -> REMOVE CONNECTION\nM -> REFLECT PROVINCE BORDER\n\nUP -> UPDATE PB VIA FILE\nDOWN -> UPDATE PROVINCE VIA FILE\nAoH2:DE";
    }
}

