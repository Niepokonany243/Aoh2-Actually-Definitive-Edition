
package age.of.civilizations2.jakowski.lukasz.Menus.Connections;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Connections
extends Menu {
    public Menu_MapEditor_Connections() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD * 3 + CFG.BUTTON_W * 3, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W, true, CFG.VIEW_SHOW_VALUES){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 4 + CFG.BUTTON_W * 4, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("UpdateProvinceData"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Lines"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Generate"));
        this.updatedButtonsWidthFromToID(1, 4, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_W);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE() + CFG.PADD, CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.editorManager.resetInUseEditors();
                CFG.menus.setMenuID(View.eMAP_EDITOR_UPDATE_PROVINCE_DATA);
                return;
            }
            case 2: {
                CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                return;
            }
            case 3: {
                Menu_MapEditor_Connections.generateConnections();
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }

    public static void generateConnections() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            for (int j = i + 1; j < CFG.core.getProvinSize(); ++j) {
                if (!Menu_MapEditor_Connections.generateConnections_BoxInBox(i, j)) continue;
                boolean addConnection = false;
                for (int i2 = 0; i2 < CFG.core.getProv(i).getPointsSize(); ++i2) {
                    for (int j2 = 0; j2 < CFG.core.getProv(j).getPointsSize(); ++j2) {
                        if (CFG.core.getProv(i).getPoX9(i2) == CFG.core.getProv(j).getPoX9(j2) && CFG.core.getProv(i).getPoY2(i2) == CFG.core.getProv(j).getPoY2(j2)) {
                            int tj2;
                            int ti2;
                            try {
                                if (CFG.core.getProv(i).getPoX9(i2 + 1) == CFG.core.getProv(j).getPoX9(j2 + 1) && CFG.core.getProv(i).getPoY2(i2 + 1) == CFG.core.getProv(j).getPoY2(j2 + 1)) {
                                    addConnection = true;
                                    break;
                                }
                            }
                            catch (IndexOutOfBoundsException ex) {
                                ti2 = i2 + 1;
                                tj2 = j2 + 1;
                                if (CFG.core.getProv(i).getPointsSize() == ti2) {
                                    ti2 = 0;
                                }
                                if (CFG.core.getProv(j).getPointsSize() == tj2) {
                                    tj2 = 0;
                                }
                                try {
                                    if (CFG.core.getProv(i).getPoX9(ti2) == CFG.core.getProv(j).getPoX9(tj2) && CFG.core.getProv(i).getPoY2(ti2) == CFG.core.getProv(j).getPoY2(tj2)) {
                                        addConnection = true;
                                        break;
                                    }
                                }
                                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    
                                }
                            }
                            try {
                                if (CFG.core.getProv(i).getPoX9(i2 + 1) == CFG.core.getProv(j).getPoX9(j2 - 1) && CFG.core.getProv(i).getPoY2(i2 + 1) == CFG.core.getProv(j).getPoY2(j2 - 1)) {
                                    addConnection = true;
                                    break;
                                }
                            }
                            catch (IndexOutOfBoundsException ex) {
                                ti2 = i2 + 1;
                                tj2 = j2 - 1;
                                if (CFG.core.getProv(i).getPointsSize() == ti2) {
                                    ti2 = 0;
                                }
                                if (tj2 < 0) {
                                    tj2 = CFG.core.getProv(j).getPointsSize() - 1;
                                }
                                try {
                                    if (CFG.core.getProv(i).getPoX9(ti2) == CFG.core.getProv(j).getPoX9(tj2) && CFG.core.getProv(i).getPoY2(ti2) == CFG.core.getProv(j).getPoY2(tj2)) {
                                        addConnection = true;
                                        break;
                                    }
                                }
                                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    
                                }
                            }
                            try {
                                if (CFG.core.getProv(i).getPoX9(i2 - 1) == CFG.core.getProv(j).getPoX9(j2 + 1) && CFG.core.getProv(i).getPoY2(i2 - 1) == CFG.core.getProv(j).getPoY2(j2 + 1)) {
                                    addConnection = true;
                                    break;
                                }
                            }
                            catch (IndexOutOfBoundsException ex) {
                                ti2 = i2 - 1;
                                tj2 = j2 + 1;
                                if (ti2 < 0) {
                                    ti2 = CFG.core.getProv(i).getPointsSize() - 1;
                                }
                                if (CFG.core.getProv(j).getPointsSize() == tj2) {
                                    tj2 = 0;
                                }
                                try {
                                    if (CFG.core.getProv(i).getPoX9(ti2) == CFG.core.getProv(j).getPoX9(tj2) && CFG.core.getProv(i).getPoY2(ti2) == CFG.core.getProv(j).getPoY2(tj2)) {
                                        addConnection = true;
                                        break;
                                    }
                                }
                                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    
                                }
                            }
                        }
                        if (addConnection) break;
                    }
                    if (addConnection) break;
                }
                if (!addConnection) continue;
                Menu_MapEditor_Connections.addConnection(i, j);
            }
        }
    }

    public static boolean addConnection(int nProvinceID, int nProvinceID2) {
        if (nProvinceID != nProvinceID2) {
            int n;
            boolean addT;
            int h;
            int o;
            boolean t1;
            boolean startID;
            int n2;
            int nSize;
            boolean end;
            int n3;
            int nSize2;
            int o2;
            boolean f1;
            int o3;
            int oSize;
            boolean l1;
            int j;
            boolean found;
            int i;
            int i2;
            for (i2 = 0; i2 < CFG.core.getProv(nProvinceID2).getNeighProvincesSize(); ++i2) {
                if (CFG.core.getProv(nProvinceID2).getNeighProvinces(i2) != nProvinceID) continue;
                return true;
            }
            for (i2 = 0; i2 < CFG.core.getProv(nProvinceID2).getNeighSeaProvincesSize(); ++i2) {
                if (CFG.core.getProv(nProvinceID2).getNeighSeaProvinces(i2) != nProvinceID) continue;
                return true;
            }
            for (i2 = 0; i2 < CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize(); ++i2) {
                if (CFG.core.getProv(nProvinceID).getNeighSeaProvinces(i2) != nProvinceID2) continue;
                return true;
            }
            if (CFG.core.getProv(nProvinceID).getSeaProv()) {
                CFG.core.getProv(nProvinceID).addNeighboringProv(nProvinceID2);
            } else if (CFG.core.getProv(nProvinceID2).getSeaProv()) {
                CFG.core.getProv(nProvinceID).addNeighboringSeaProvince(nProvinceID2);
                CFG.core.getProv(nProvinceID).setLvlOfPort(1);
            } else {
                CFG.core.getProv(nProvinceID).addNeighboringProv(nProvinceID2);
            }
            if (CFG.core.getProv(nProvinceID2).getSeaProv()) {
                CFG.core.getProv(nProvinceID2).addNeighboringProv(nProvinceID);
            } else if (CFG.core.getProv(nProvinceID).getSeaProv()) {
                CFG.core.getProv(nProvinceID2).addNeighboringSeaProvince(nProvinceID);
                CFG.core.getProv(nProvinceID2).setLvlOfPort(1);
            } else {
                CFG.core.getProv(nProvinceID2).addNeighboringProv(nProvinceID);
            }
            ArrayList<Integer> nPointsX = new ArrayList<Integer>();
            ArrayList<Integer> nPointsY = new ArrayList<Integer>();
            for (i = 0; i < CFG.core.getProv(nProvinceID2).getPointsSize(); ++i) {
                found = false;
                j = 0;
                if (j < CFG.core.getProv(nProvinceID).getPointsSize()) {
                    found = true;
                    l1 = false;
                    oSize = CFG.core.getProv(nProvinceID).getPointsSize();
                    for (o3 = 0; o3 < oSize; ++o3) {
                        if (CFG.core.getProv(nProvinceID2).getPoX9(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) != CFG.core.getProv(nProvinceID).getPoX9(o3) || CFG.core.getProv(nProvinceID2).getPoY2(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) != CFG.core.getProv(nProvinceID).getPoY2(o3)) continue;
                        l1 = true;
                    }
                    if (l1) {
                        l1 = false;
                        oSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                        for (o3 = 0; o3 < oSize; ++o3) {
                            if (CFG.core.getProv(nProvinceID).getPoX9(CFG.core.getProv(nProvinceID).getPointsSize() - 1) != CFG.core.getProv(nProvinceID2).getPoX9(o3) || CFG.core.getProv(nProvinceID).getPoY2(CFG.core.getProv(nProvinceID).getPointsSize() - 1) != CFG.core.getProv(nProvinceID2).getPoY2(o3)) continue;
                            l1 = true;
                        }
                        if (!l1) {
                            f1 = false;
                            block6: for (o2 = CFG.core.getProv(nProvinceID).getPointsSize() - 1; o2 >= 0; --o2) {
                                if (!f1) {
                                    nSize2 = CFG.core.getProv(nProvinceID2).getPointsSize();
                                    for (n3 = 0; n3 < nSize2; ++n3) {
                                        if (CFG.core.getProv(nProvinceID).getPoX9(o2) != CFG.core.getProv(nProvinceID2).getPoX9(n3) || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n3)) continue;
                                        f1 = true;
                                        nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                        nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                        continue block6;
                                    }
                                    continue;
                                }
                                end = true;
                                nSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                                for (n2 = 0; n2 < nSize; ++n2) {
                                    if (CFG.core.getProv(nProvinceID).getPoX9(o2) != CFG.core.getProv(nProvinceID2).getPoX9(n2) || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n2)) continue;
                                    end = false;
                                    nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                    nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                    break;
                                }
                                if (!end) {
                                    continue;
                                }
                                break;
                            }
                        } else {
                            startID = false;
                            t1 = false;
                            for (o = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o >= 0; --o) {
                                t1 = false;
                                nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                                for (n2 = 0; n2 < nSize; ++n2) {
                                    if (CFG.core.getProv(nProvinceID2).getPoX9(o) != CFG.core.getProv(nProvinceID).getPoX9(n2) || CFG.core.getProv(nProvinceID2).getPoY2(o) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                    t1 = true;
                                    break;
                                }
                                if (t1) continue;
                                ++o;
                                while (o < CFG.core.getProv(nProvinceID2).getPointsSize() - 1) {
                                    nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o));
                                    nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o));
                                    ++o;
                                }
                                break;
                            }
                            for (h = 0; h < CFG.core.getProv(nProvinceID2).getPointsSize(); ++h) {
                                addT = false;
                                for (n = 0; n < CFG.core.getProv(nProvinceID).getPointsSize(); ++n) {
                                    if (CFG.core.getProv(nProvinceID2).getPoX9(h) != CFG.core.getProv(nProvinceID).getPoX9(n) || CFG.core.getProv(nProvinceID2).getPoY2(h) != CFG.core.getProv(nProvinceID).getPoY2(n)) continue;
                                    addT = true;
                                    break;
                                }
                                if (addT) {
                                    nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(h));
                                    nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(h));
                                    continue;
                                }
                                break;
                            }
                        }
                    } else {
                        f1 = false;
                        block14: for (o2 = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o2 >= 0; --o2) {
                            if (!f1) {
                                nSize2 = CFG.core.getProv(nProvinceID).getPointsSize();
                                for (n3 = 0; n3 < nSize2; ++n3) {
                                    if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n3) || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n3)) continue;
                                    f1 = true;
                                    nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                    nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
                                    continue block14;
                                }
                                continue;
                            }
                            end = true;
                            nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                            for (n2 = 0; n2 < nSize; ++n2) {
                                if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n2) || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                end = false;
                                nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
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
            if (nPointsX.size() == 0) {
                for (i = 0; i < CFG.core.getProv(nProvinceID2).getPointsSize(); ++i) {
                    found = false;
                    j = 0;
                    if (j < CFG.core.getProv(nProvinceID).getPointsSize()) {
                        found = true;
                        l1 = false;
                        oSize = CFG.core.getProv(nProvinceID).getPointsSize();
                        for (o3 = 0; o3 < oSize; ++o3) {
                            if (CFG.core.getProv(nProvinceID2).getPoX9(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) != CFG.core.getProv(nProvinceID).getPoX9(o3) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) != CFG.core.getProv(nProvinceID).getPoY2(o3)) continue;
                            l1 = true;
                        }
                        if (l1) {
                            l1 = false;
                            oSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                            for (o3 = 0; o3 < oSize; ++o3) {
                                if (CFG.core.getProv(nProvinceID).getPoX9(CFG.core.getProv(nProvinceID).getPointsSize() - 1) + CFG.map.getMpB().getWidthM() != CFG.core.getProv(nProvinceID2).getPoX9(o3) || CFG.core.getProv(nProvinceID).getPoY2(CFG.core.getProv(nProvinceID).getPointsSize() - 1) != CFG.core.getProv(nProvinceID2).getPoY2(o3)) continue;
                                l1 = true;
                            }
                            if (!l1) {
                                f1 = false;
                                block20: for (o2 = CFG.core.getProv(nProvinceID).getPointsSize() - 1; o2 >= 0; --o2) {
                                    if (!f1) {
                                        nSize2 = CFG.core.getProv(nProvinceID2).getPointsSize();
                                        for (n3 = 0; n3 < nSize2; ++n3) {
                                            if (CFG.core.getProv(nProvinceID).getPoX9(o2) + CFG.map.getMpB().getWidthM() != CFG.core.getProv(nProvinceID2).getPoX9(n3) || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n3)) continue;
                                            f1 = true;
                                            nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                            nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                            continue block20;
                                        }
                                        continue;
                                    }
                                    end = true;
                                    nSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                                    for (n2 = 0; n2 < nSize; ++n2) {
                                        if (CFG.core.getProv(nProvinceID).getPoX9(o2) + CFG.map.getMpB().getWidthM() != CFG.core.getProv(nProvinceID2).getPoX9(n2) || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n2)) continue;
                                        end = false;
                                        nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                        nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                        break;
                                    }
                                    if (!end) {
                                        continue;
                                    }
                                    break;
                                }
                            } else {
                                startID = false;
                                t1 = false;
                                for (o = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o >= 0; --o) {
                                    t1 = false;
                                    nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                                    for (n2 = 0; n2 < nSize; ++n2) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(o) != CFG.core.getProv(nProvinceID).getPoX9(n2) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                        t1 = true;
                                        break;
                                    }
                                    if (t1) continue;
                                    ++o;
                                    while (o < CFG.core.getProv(nProvinceID2).getPointsSize() - 1) {
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o));
                                        ++o;
                                    }
                                    break;
                                }
                                for (h = 0; h < CFG.core.getProv(nProvinceID2).getPointsSize(); ++h) {
                                    addT = false;
                                    for (n = 0; n < CFG.core.getProv(nProvinceID).getPointsSize(); ++n) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(h) != CFG.core.getProv(nProvinceID).getPoX9(n) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(h) != CFG.core.getProv(nProvinceID).getPoY2(n)) continue;
                                        addT = true;
                                        break;
                                    }
                                    if (addT) {
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(h));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(h));
                                        continue;
                                    }
                                    break;
                                }
                            }
                        } else {
                            f1 = false;
                            block28: for (o2 = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o2 >= 0; --o2) {
                                if (!f1) {
                                    nSize2 = CFG.core.getProv(nProvinceID).getPointsSize();
                                    for (n3 = 0; n3 < nSize2; ++n3) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n3) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n3)) continue;
                                        f1 = true;
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
                                        continue block28;
                                    }
                                    continue;
                                }
                                end = true;
                                nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                                for (n2 = 0; n2 < nSize; ++n2) {
                                    if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n2) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                    end = false;
                                    nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                    nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
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
            }
            if (nPointsX.size() == 0) {
                for (i = 0; i < CFG.core.getProv(nProvinceID2).getPointsSize(); ++i) {
                    found = false;
                    j = 0;
                    if (j < CFG.core.getProv(nProvinceID).getPointsSize()) {
                        found = true;
                        l1 = false;
                        oSize = CFG.core.getProv(nProvinceID).getPointsSize();
                        for (o3 = 0; o3 < oSize; ++o3) {
                            if (CFG.core.getProv(nProvinceID2).getPoX9(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) + CFG.map.getMpB().getWidthM() != CFG.core.getProv(nProvinceID).getPoX9(o3) || CFG.core.getProv(nProvinceID2).getPoY2(CFG.core.getProv(nProvinceID2).getPointsSize() - 1) != CFG.core.getProv(nProvinceID).getPoY2(o3)) continue;
                            l1 = true;
                        }
                        if (l1) {
                            l1 = false;
                            oSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                            for (o3 = 0; o3 < oSize; ++o3) {
                                if (CFG.core.getProv(nProvinceID).getPoX9(CFG.core.getProv(nProvinceID).getPointsSize() - 1) != CFG.core.getProv(nProvinceID2).getPoX9(o3) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID).getPoY2(CFG.core.getProv(nProvinceID).getPointsSize() - 1) != CFG.core.getProv(nProvinceID2).getPoY2(o3)) continue;
                                l1 = true;
                            }
                            if (!l1) {
                                f1 = false;
                                block34: for (o2 = CFG.core.getProv(nProvinceID).getPointsSize() - 1; o2 >= 0; --o2) {
                                    if (!f1) {
                                        nSize2 = CFG.core.getProv(nProvinceID2).getPointsSize();
                                        for (n3 = 0; n3 < nSize2; ++n3) {
                                            if (CFG.core.getProv(nProvinceID).getPoX9(o2) != CFG.core.getProv(nProvinceID2).getPoX9(n3) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n3)) continue;
                                            f1 = true;
                                            nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                            nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                            continue block34;
                                        }
                                        continue;
                                    }
                                    end = true;
                                    nSize = CFG.core.getProv(nProvinceID2).getPointsSize();
                                    for (n2 = 0; n2 < nSize; ++n2) {
                                        if (CFG.core.getProv(nProvinceID).getPoX9(o2) != CFG.core.getProv(nProvinceID2).getPoX9(n2) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID).getPoY2(o2) != CFG.core.getProv(nProvinceID2).getPoY2(n2)) continue;
                                        end = false;
                                        nPointsX.add(CFG.core.getProv(nProvinceID).getPoX9(o2));
                                        nPointsY.add(CFG.core.getProv(nProvinceID).getPoY2(o2));
                                        break;
                                    }
                                    if (!end) {
                                        continue;
                                    }
                                    break;
                                }
                            } else {
                                startID = false;
                                t1 = false;
                                for (o = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o >= 0; --o) {
                                    t1 = false;
                                    nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                                    for (n2 = 0; n2 < nSize; ++n2) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(o) != CFG.core.getProv(nProvinceID).getPoX9(n2) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                        t1 = true;
                                        break;
                                    }
                                    if (t1) continue;
                                    ++o;
                                    while (o < CFG.core.getProv(nProvinceID2).getPointsSize() - 1) {
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o));
                                        ++o;
                                    }
                                    break;
                                }
                                for (h = 0; h < CFG.core.getProv(nProvinceID2).getPointsSize(); ++h) {
                                    addT = false;
                                    for (n = 0; n < CFG.core.getProv(nProvinceID).getPointsSize(); ++n) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(h) != CFG.core.getProv(nProvinceID).getPoX9(n) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(h) != CFG.core.getProv(nProvinceID).getPoY2(n)) continue;
                                        addT = true;
                                        break;
                                    }
                                    if (addT) {
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(h));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(h));
                                        continue;
                                    }
                                    break;
                                }
                            }
                        } else {
                            f1 = false;
                            block42: for (o2 = CFG.core.getProv(nProvinceID2).getPointsSize() - 1; o2 >= 0; --o2) {
                                if (!f1) {
                                    nSize2 = CFG.core.getProv(nProvinceID).getPointsSize();
                                    for (n3 = 0; n3 < nSize2; ++n3) {
                                        if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n3) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n3)) continue;
                                        f1 = true;
                                        nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                        nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
                                        continue block42;
                                    }
                                    continue;
                                }
                                end = true;
                                nSize = CFG.core.getProv(nProvinceID).getPointsSize();
                                for (n2 = 0; n2 < nSize; ++n2) {
                                    if (CFG.core.getProv(nProvinceID2).getPoX9(o2) != CFG.core.getProv(nProvinceID).getPoX9(n2) + CFG.map.getMpB().getWidthM() || CFG.core.getProv(nProvinceID2).getPoY2(o2) != CFG.core.getProv(nProvinceID).getPoY2(n2)) continue;
                                    end = false;
                                    nPointsX.add(CFG.core.getProv(nProvinceID2).getPoX9(o2));
                                    nPointsY.add(CFG.core.getProv(nProvinceID2).getPoY2(o2));
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
            }
            for (int a = 0; a < nPointsX.size(); ++a) {
                nPointsX.set(a, (Integer)nPointsX.get(a) / CFG.map.getMpB().getMapSc3());
                nPointsY.set(a, (Integer)nPointsY.get(a) / CFG.map.getMpB().getMapSc3());
            }
            ArrayList<Short> sPointsX = new ArrayList<Short>();
            ArrayList<Short> sPointsY = new ArrayList<Short>();
            for (int i3 = 0; i3 < nPointsX.size(); ++i3) {
                sPointsX.add((short)((Integer)nPointsX.get(i3)).intValue());
                sPointsY.add((short)((Integer)nPointsY.get(i3)).intValue());
            }
            if (nProvinceID > nProvinceID2) {
                CFG.core.getProv(nProvinceID2).addProvBorder(nProvinceID, sPointsX, sPointsY);
            } else {
                CFG.core.getProv(nProvinceID).addProvBorder(nProvinceID2, sPointsX, sPointsY);
            }
        }
        return true;
    }

    public static final boolean generateConnections_BoxInBox(int i, int j) {
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(i, CFG.core.getProv(j).getMiX2(), CFG.core.getProv(j).getMiY4())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(i, CFG.core.getProv(j).getMaX7(), CFG.core.getProv(j).getMiY4())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(i, CFG.core.getProv(j).getMiX2(), CFG.core.getProv(j).getMaY6())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(i, CFG.core.getProv(j).getMaX7(), CFG.core.getProv(j).getMaY6())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(j, CFG.core.getProv(i).getMiX2(), CFG.core.getProv(i).getMiY4())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(j, CFG.core.getProv(i).getMaX7(), CFG.core.getProv(i).getMiY4())) {
            return true;
        }
        if (Menu_MapEditor_Connections.generateConnections_PointInBox(j, CFG.core.getProv(i).getMiX2(), CFG.core.getProv(i).getMaY6())) {
            return true;
        }
        return Menu_MapEditor_Connections.generateConnections_PointInBox(j, CFG.core.getProv(i).getMaX7(), CFG.core.getProv(i).getMaY6());
    }

    public static final boolean generateConnections_PointInBox(int nProvinceID, int iX, int iY) {
        return iX >= CFG.core.getProv(nProvinceID).getMiX2() && iX <= CFG.core.getProv(nProvinceID).getMaX7() && iY >= CFG.core.getProv(nProvinceID).getMiY4() && iY <= CFG.core.getProv(nProvinceID).getMaY6();
    }
}

