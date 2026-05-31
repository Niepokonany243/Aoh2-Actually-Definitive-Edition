/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Ships;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Ships.Ship2;
import age.of.civilizations2.jakowski.lukasz.Ships.ShipLine;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class ShipManager {
    public static List<ShipLine> shipLines = new ArrayList<ShipLine>();
    public static int shipLinesSize = 0;
    public static List<Ship2> ships = new ArrayList<Ship2>();
    public static List<List<Image>> shipImg = new ArrayList<List<Image>>();
    public static int limitOfShipsAtSea = 0;
    public static List<Integer> shipsAtSea = new ArrayList<Integer>();
    public static int shipsAtSeaSize = 0;
    public static List<Integer> shipsInPort = new ArrayList<Integer>();
    public static int shipsInPortSize = 0;

    public static final void clearShips() {
        try {
            shipLines.clear();
            shipLinesSize = 0;
            shipsInPort.clear();
            shipsInPortSize = 0;
            shipsAtSea.clear();
            shipsAtSeaSize = 0;
            ships.clear();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void update() {
        if (shipsAtSeaSize < limitOfShipsAtSea) {
            ShipManager.addShipAtSea();
        }
    }

    public static final void addShipAtSea() {
        if (shipsInPortSize > 0) {
            int tID = CFG.oR.nextInt(shipsInPortSize);
            ShipManager.ships.get((int)ShipManager.shipsInPort.get((int)tID).intValue()).remove = false;
            shipsAtSea.add(shipsInPort.get(tID));
            shipsInPort.remove(tID);
            shipsAtSeaSize = shipsAtSea.size();
            shipsInPortSize = shipsInPort.size();
        }
    }

    public static final void drawCurrentScale(SpriteBatch oSB) {
        try {
            if (CFG.settingsGD.SHIPS_ON_MAP > 0) {
                ShipManager.update();
                int ageGroup = CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).SHIP_GROUP;
                oSB.setColor(Color.WHITE);
                int i = shipsAtSeaSize - 1;
                while (i >= 0) {
                    ships.get(shipsAtSea.get(i)).update();
                    if (ShipManager.ships.get((int)ShipManager.shipsAtSea.get((int)i).intValue()).remove) {
                        shipsInPort.add(shipsAtSea.get(i));
                        shipsAtSea.remove(i);
                        shipsAtSeaSize = shipsAtSea.size();
                        shipsInPortSize = shipsInPort.size();
                    } else {
                        ships.get(shipsAtSea.get(i)).drawCurrentScale(oSB, ageGroup);
                    }
                    --i;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void draw(SpriteBatch oSB) {
        try {
            if (CFG.settingsGD.SHIPS_ON_MAP > 0) {
                ShipManager.update();
                int ageGroup = CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).SHIP_GROUP;
                oSB.setColor(Color.WHITE);
                int i = shipsAtSeaSize - 1;
                while (i >= 0) {
                    ships.get(shipsAtSea.get(i)).update();
                    if (ShipManager.ships.get((int)ShipManager.shipsAtSea.get((int)i).intValue()).remove) {
                        shipsInPort.add(shipsAtSea.get(i));
                        shipsAtSea.remove(i);
                        shipsAtSeaSize = shipsAtSea.size();
                        shipsInPortSize = shipsInPort.size();
                    } else {
                        ships.get(shipsAtSea.get(i)).draw(oSB, ageGroup);
                    }
                    --i;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void loadShipLines() {
        block12: {
            try {
                if (!FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "Lines_Sea.txt").exists()) break block12;
                FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "Lines_Sea.txt");
                String text = file.readString();
                String[] allLines = text.split("\n");
                try {
                    if (allLines.length > 0) {
                        int i;
                        int n = i = allLines[0].length() > 0 ? 0 : 1;
                        while (i < allLines.length) {
                            String[] lineX = allLines[i].split(";");
                            String[] lineY = allLines[i + 1].split(";");
                            ShipLine nShipLine = new ShipLine();
                            for (int j = 0; j < lineX.length; ++j) {
                                nShipLine.addNewPoint_Just(Integer.parseInt(lineX[j]) * CFG.map.getMpB().getMapSc3(), Integer.parseInt(lineY[j]) * CFG.map.getMpB().getMapSc3());
                            }
                            nShipLine.buildData();
                            ShipManager.addShipLine(nShipLine);
                            i += 2;
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        try {
            for (int a = 0; a < GameValues.gvShips.SHIP_AGES; ++a) {
                ArrayList<Image> tImages = new ArrayList<Image>();
                for (int i = 0; i < GameValues.gvShips.SHIP_IMAGES; ++i) {
                    tImages.add(new Image(IMGManager.loadTexture("UI/ships/ship_" + a + "_" + i + ".png"), Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
                }
                shipImg.add(tImages);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        for (int i = 0; i < shipLinesSize; ++i) {
            ships.add(new Ship2(i));
            shipsInPort.add(i);
        }
        shipsInPortSize = shipsInPort.size();
        ShipManager.updateLimitOfShipsAtSea();
    }

    public static final void loadShipLines_Provinces() {
        int j;
        int i;
        int paddingCheck = 2 * CFG.map.getMpB().getMapSc3();
        block0: for (i = 0; i < shipLinesSize; ++i) {
            for (j = 0; j < CFG.core.getProvinSize(); ++j) {
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(0).getPX() && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(0).getPX() && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(0).getPX(), ShipManager.shipLines.get((int)i).points.get(0).getPY())) {
                    ShipManager.shipLines.get((int)i).fromProvinceID = j;
                    continue block0;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(0).getPX() + paddingCheck && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(0).getPX() + paddingCheck && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(0).getPX() + paddingCheck, ShipManager.shipLines.get((int)i).points.get(0).getPY())) {
                    ShipManager.shipLines.get((int)i).fromProvinceID = j;
                    continue block0;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(0).getPX() - paddingCheck && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(0).getPX() - paddingCheck && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(0).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(0).getPX() - paddingCheck, ShipManager.shipLines.get((int)i).points.get(0).getPY())) {
                    ShipManager.shipLines.get((int)i).fromProvinceID = j;
                    continue block0;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(0).getPX() && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(0).getPX() && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(0).getPY() + paddingCheck && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(0).getPY() + paddingCheck && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(0).getPX(), ShipManager.shipLines.get((int)i).points.get(0).getPY() + paddingCheck)) {
                    ShipManager.shipLines.get((int)i).fromProvinceID = j;
                    continue block0;
                }
                if (CFG.core.getProv(j).getMiX2() > ShipManager.shipLines.get((int)i).points.get(0).getPX() || CFG.core.getProv(j).getMaX7() < ShipManager.shipLines.get((int)i).points.get(0).getPX() || CFG.core.getProv(j).getMiY4() > ShipManager.shipLines.get((int)i).points.get(0).getPY() - paddingCheck || CFG.core.getProv(j).getMaY6() < ShipManager.shipLines.get((int)i).points.get(0).getPY() - paddingCheck || !CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(0).getPX(), ShipManager.shipLines.get((int)i).points.get(0).getPY() - paddingCheck)) continue;
                ShipManager.shipLines.get((int)i).fromProvinceID = j;
                continue block0;
            }
        }
        block2: for (i = 0; i < shipLinesSize; ++i) {
            for (j = 0; j < CFG.core.getProvinSize(); ++j) {
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX(), ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY())) {
                    ShipManager.shipLines.get((int)i).toProvinceID = j;
                    continue block2;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() + paddingCheck && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() + paddingCheck && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() + paddingCheck, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY())) {
                    ShipManager.shipLines.get((int)i).toProvinceID = j;
                    continue block2;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() - paddingCheck && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() - paddingCheck && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() - paddingCheck, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY())) {
                    ShipManager.shipLines.get((int)i).toProvinceID = j;
                    continue block2;
                }
                if (CFG.core.getProv(j).getMiX2() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() && CFG.core.getProv(j).getMaX7() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() && CFG.core.getProv(j).getMiY4() <= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() + paddingCheck && CFG.core.getProv(j).getMaY6() >= ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() + paddingCheck && CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX(), ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() + paddingCheck)) {
                    ShipManager.shipLines.get((int)i).toProvinceID = j;
                    continue block2;
                }
                if (CFG.core.getProv(j).getMiX2() > ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() || CFG.core.getProv(j).getMaX7() < ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX() || CFG.core.getProv(j).getMiY4() > ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() - paddingCheck || CFG.core.getProv(j).getMaY6() < ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() - paddingCheck || !CFG.core.ptCS(j, ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPX(), ShipManager.shipLines.get((int)i).points.get(ShipManager.shipLines.get((int)i).pointsSize - 1).getPY() - paddingCheck)) continue;
                ShipManager.shipLines.get((int)i).toProvinceID = j;
                continue block2;
            }
        }
    }

    public static final void addShipLine(ShipLine nShipLine) {
        shipLines.add(nShipLine);
        shipLinesSize = shipLines.size();
    }

    public static final void updateLimitOfShipsAtSea() {
        limitOfShipsAtSea = (int)Math.min((float)shipLinesSize, (float)CFG.settingsGD.SHIPS_ON_MAP / 100.0f * (float)shipLinesSize);
    }
}

