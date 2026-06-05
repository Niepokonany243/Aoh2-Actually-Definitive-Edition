
package age.of.civilizations2.jakowski.lukasz.Console;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivInvest;
import age.of.civilizations2.jakowski.lukasz.CivTask;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_NeighboringProvinces;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_JoinAlliance;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menus.War.Menu_InGame_PrepareForWar;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.SignPeace.Message_WeCanSignPeace;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.List;

public class Commands {
    public static final int CONSOLE_LIMIT = 300;
    public static List<String> sConsole = new ArrayList<String>();
    public static List<Point_XY2> lFlagsParty = new ArrayList<Point_XY2>();
    public static long lFlagsPartyTime = 0L;

    public static void addMessage(String nMess) {
        sConsole.add(nMess);
        if (sConsole.size() > 300) {
            sConsole.remove(0);
        }
    }

    public static void execute(String nCommand) {
        block247: {
            if (nCommand.length() == 0) {
                return;
            }
            Commands.addMessage("");
            Commands.addMessage("#" + nCommand);
            String[] tempCommand = nCommand.toLowerCase().split(" ");
            try {
                if (tempCommand.length <= 0) break block247;
                if (tempCommand[0].equals("console")) {
                    CFG.menus.setVisible_InGame_FlagAction_Console(!CFG.menus.getVisible_InGame_FlagAction_Console());
                    if (CFG.menus.getVisible_InGame_FlagAction_Console()) {
                        CFG.toastM.addM("Hello");
                    }
                    return;
                }
                if (tempCommand[0].equals("info")) {
                    Commands.addMessage("FramesPerSecond: " + Gdx.graphics.getFramesPerSecond());
                    Commands.addMessage("Width: " + Gdx.graphics.getWidth());
                    Commands.addMessage("Height: " + Gdx.graphics.getHeight());
                    Commands.addMessage("PpiX: " + Gdx.graphics.getPpiX());
                    Commands.addMessage("PpiY: " + Gdx.graphics.getPpiY());
                    Commands.addMessage("Density: " + Gdx.graphics.getDensity());
                    Commands.addMessage("XHDPI: " + CFG.XHDPI);
                    Commands.addMessage("XXHDPI: " + CFG.XXHDPI);
                    Commands.addMessage("XXXHDPI: " + CFG.XXXHDPI);
                    return;
                }
                if (tempCommand[0].equals("debug")) {
                    CFG.DEBUG_MODE = !CFG.DEBUG_MODE;
                    Commands.addMessage(CFG.lang.get(CFG.lang.get("DEBUG") + ": " + (CFG.DEBUG_MODE ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled"))));
                    CFG.toastM.addM(CFG.lang.get(CFG.lang.get("DEBUG") + ": " + (CFG.DEBUG_MODE ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled"))));
                    return;
                }
                if (tempCommand[0].equals("neutral")) {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        if (CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getCivId() != 0 || CFG.core.getProv(i).getSeaProv()) continue;
                        CFG.core.setActiveProvID(i);
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                        break;
                    }
                    return;
                }
                if (tempCommand[0].equals("center")) {
                    if (tempCommand.length > 1) {
                        try {
                            int tempID = Integer.parseInt(tempCommand[1]);
                            if (tempID < CFG.core.getProvinSize()) {
                                CFG.map.getMpC().centerToProvID(tempID);
                                CFG.core.setActiveProvID(tempID);
                                CFG.toastM.addM(CFG.core.getProv(tempID).getName());
                            } else {
                                Commands.IllegalCommand();
                            }
                            return;
                        }
                        catch (IllegalArgumentException ex) {
                            Commands.IllegalCommand();
                        }
                        catch (IndexOutOfBoundsException ex) {
                            Commands.IllegalCommand();
                        }
                    } else {
                        CFG.map.getMpSl().stopScrollingTheMap();
                        CFG.map.getMpS().setCurrScale(MapScale.MINSCALE);
                        CFG.map.getMpC().setNewPosX(-((int)((float)(CFG.map.getMpB().getWidthM() / 2) - (float)CFG.GAMEWIDTH / MapScale.MINSCALE / 2.0f)));
                        CFG.map.getMpC().setNewPosY(-((int)((float)(CFG.map.getMpB().getHeightM() / 2) - (float)CFG.GAMEHEIGHT / MapScale.MINSCALE / 2.0f)));
                    }
                    return;
                }
                if (tempCommand[0].equals("centerciv")) {
                    if (tempCommand.length > 1) {
                        try {
                            int tempID = Integer.parseInt(tempCommand[1]);
                            if (tempID < CFG.core.getCivsSize() && tempID > 0) {
                                CFG.map.getMpC().centerToCivilizationBox(tempID, true);
                                CFG.toastM.addM(CFG.core.getCiv(tempID).getCivName());
                            }
                        }
                        catch (IllegalArgumentException ex) {
                            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                                if (!tempCommand[1].equals(CFG.core.getCiv(i).getCivName()) && !tempCommand[1].equals(CFG.core.getCiv(i).getCivTag())) continue;
                                CFG.map.getMpC().centerToCivilizationBox(i, true);
                                CFG.toastM.addM(CFG.core.getCiv(i).getCivName());
                                return;
                            }
                            Commands.IllegalCommand();
                        }
                        catch (IndexOutOfBoundsException ex) {
                            Commands.IllegalCommand();
                        }
                    } else {
                        Commands.IllegalCommand();
                    }
                    return;
                }
                if (tempCommand[0].equals("scale")) {
                    if (tempCommand.length > 1) {
                        try {
                            tempCommand[1] = tempCommand[1].replace(',', '.');
                            float tempS = Float.parseFloat(tempCommand[1]);
                            CFG.map.getMpS().setCurrScale(tempS);
                            return;
                        }
                        catch (IllegalArgumentException ex) {
                            Commands.IllegalCommand();
                        }
                    } else {
                        CFG.map.getMpS().setCurrScale(1.0f);
                    }
                    return;
                }
                if (tempCommand[0].equals("removeplayer") && tempCommand.length > 1) {
                    if (CFG.core.getPlayersSize() <= 1) break block247;
                    try {
                        int pTID = Integer.parseInt(tempCommand[1]);
                        CFG.core.removePlayer(pTID);
                        if (pTID > 0 && CFG.PLAYER_TURN_ID == pTID) {
                            CFG.PLAYER_TURN_ID = pTID - 1;
                        }
                        if (CFG.FOG_OF_WAR > 0) {
                            CFG.gameAction.buildFogOfWar(CFG.PLAYER_TURN_ID);
                        }
                        CFG.gameAction.loadActivePlayerData();
                    }
                    catch (Exception pTID) {}
                    break block247;
                }
                if (tempCommand[0].equals("removeplayer")) {
                    if (CFG.core.getPlayersSize() > 1) {
                        int pTID = CFG.PLAYER_TURN_ID;
                        CFG.core.removePlayer(CFG.PLAYER_TURN_ID);
                        if (pTID > 0) {
                            CFG.PLAYER_TURN_ID = pTID - 1;
                        }
                        if (CFG.FOG_OF_WAR > 0) {
                            CFG.gameAction.buildFogOfWar(CFG.PLAYER_TURN_ID);
                        }
                        CFG.gameAction.loadActivePlayerData();
                    }
                    break block247;
                }
                if (tempCommand[0].equals("close") || tempCommand[0].equals("bye")) {
                    if (CFG.menus.getVisible_InGame_FlagAction_Console()) {
                        CFG.menus.setVisible_InGame_FlagAction_Console(false);
                    }
                    CFG.menus.getKeyboard().setVisibleM(false);
                    return;
                }
                if (tempCommand[0].equals("fps")) {
                    AoCGame.drawFPS = !AoCGame.drawFPS;
                    return;
                }
                if (tempCommand[0].equals("psand") || tempCommand[0].equals("partial_sandbox") || tempCommand[0].equals("partsand")) {
                    CFG.PXSX = !CFG.PXSX;
                    CFG.toastM.addM(CFG.lang.get("Partial Sandbox") + ": " + (CFG.PXSX ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
                    Commands.addMessage(CFG.lang.get("Partial Sandbox") + ": " + (CFG.PXSX ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
                    return;
                }
                if (tempCommand[0].equals("hi") || tempCommand[0].equals("hello")) {
                    if (!CFG.menus.getVisible_InGame_FlagAction_Console()) {
                        CFG.menus.setVisible_InGame_FlagAction_Console(true);
                    }
                    CFG.toastM.addM(CFG.lang.get("Hello") + ", welcome to Age of History 2: Definitive Edition");
                    Commands.addMessage(CFG.lang.get("Hello") + ", welcome to Age of History 2: Definitive Edition");
                    return;
                }
                if (tempCommand[0].equals("spin") || tempCommand[0].equals("iss") || tempCommand[0].equals("wheee") || tempCommand[0].equals("whee")) {
                    CFG.map.getMpSl().setScrollPos(125000, 10);
                    CFG.map.getMpSl().setScrollPos(10, 10);
                    CFG.menus.getKeyboard().setVisibleM(false);
                    CFG.menus.setVisible_InGame_FlagAction(false);
                    CFG.map.getMpSl().startScrollingTheMap();
                    CFG.toastM.addM(CFG.lang.get("Wheee") + "!");
                    Commands.addMessage(CFG.lang.get("Wheee") + "!");
                    return;
                }
                if (tempCommand[0].equals("explode")) {
                    try {
                        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                            Menu_InGame_PrepareForWar.explode(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        }
                        break block247;
                    }
                    catch (Exception pTID) {}
                    break block247;
                }
                if (tempCommand[0].equals("help") || tempCommand[0].equals("commands")) {
                    if (!CFG.menus.getVisible_InGame_FlagAction_Console()) {
                        CFG.menus.setVisible_InGame_FlagAction_Console(true);
                    }
                    CFG.toastM.addM(CFG.lang.get("Help"));
                    Commands.addMessage("#" + CFG.sVERSION + ": " + "2.01 Definitive Edition");
                    Commands.addMessage("");
                    Commands.addMessage("console - Toggles the console visibility.");
                    Commands.addMessage("hi, hello - Greets the player and opens console if closed.");
                    Commands.addMessage("help, commands - Shows a list of basic commands and game version.");
                    Commands.addMessage("clear - Clears console output.");
                    Commands.addMessage("fps - Toggles FPS display.");
                    Commands.addMessage("info - Displays technical info: resolution, PPI, density.");
                    Commands.addMessage("debug - Toggles debug mode.");
                    Commands.addMessage("close, bye - Closes the console and keyboard.");
                    Commands.addMessage("spin, wheee, whee, iss - Makes the map spin with a Wheee! toast.");
                    Commands.addMessage("party, flags - Triggers flag party visual effect.");
                    Commands.addMessage("scale X - Sets map zoom scale to X. Resets to 1.0 if no argument.");
                    Commands.addMessage("center X - Centers the map on province ID X.");
                    Commands.addMessage("centerciv X - Centers the map on civ ID or tag.");
                    Commands.addMessage("neutral - Moves camera to a neutral (unclaimed) province.");
                    Commands.addMessage("ids, showids - Shows province/civ IDs on the map.");
                    Commands.addMessage("showarmy - Displays army positions on map.");
                    Commands.addMessage("buildport - Builds a port in the selected province.");
                    Commands.addMessage("buildfort - Builds a fort in the selected province.");
                    Commands.addMessage("buildtower - Builds a watch tower in the selected province.");
                    Commands.addMessage("economy - Increases economy in selected province by 80% of DEFAULT_ARMY.");
                    Commands.addMessage("invest - Invests in all provinces of the civ that owns the selected province.");
                    Commands.addMessage("addciv TAG - Adds a new civ with tag TAG to selected province.");
                    Commands.addMessage("addplayer - Adds selected province's civ as a player.");
                    Commands.addMessage("civ - Shows civ info (ID, name, tag) of selected province.");
                    Commands.addMessage("civs, tags - Lists all civilizations with their ID and tag.");
                    Commands.addMessage("md - Redirects you to the Manage Diplomacy menu, where you can create alliances, vassals, pacts, and adjust relations");
                    Commands.addMessage("union X Y - Unites civilizations with IDs X and Y into a union.");
                    Commands.addMessage("annex X Y - Civ X annexes all provinces of civ Y.");
                    Commands.addMessage("vassal X Y, puppet X Y - Makes civ X a vassal of civ Y.");
                    Commands.addMessage("noliberity - Toggles the No Liberation rule on/off.");
                    Commands.addMessage("diplo X - Sets diplomacy points to X.");
                    Commands.addMessage("relation A B X - Sets relationship between civ A and B to value X.");
                    Commands.addMessage("war X Y - Declares war between civs with IDs X and Y.");
                    Commands.addMessage("peace X Y - Signs peace between civs with IDs X and Y.");
                    Commands.addMessage("ally X Y, alliance X Y - Forms alliance between civs with IDs X and Y.");
                    Commands.addMessage("diplomacy - Adds diplomacy points (75% of ideology\u2019s move cost).");
                    Commands.addMessage("army X - Adds X units to selected province.");
                    Commands.addMessage("army - Adds default number of units (40% of DEFAULT_ARMY).");
                    Commands.addMessage("setarmy X, armyset X - Sets army size to X in selected province.");
                    Commands.addMessage("showarmy - Shows armies on map.");
                    Commands.addMessage("movement - Adds movement points (half ideology\u2019s move cost).");
                    Commands.addMessage("move X - Sets movement points to X.");
                    Commands.addMessage("ww X - Sets war weariness of selected province's civ to X%.");
                    Commands.addMessage("nuke - Player gets one atomic bomb");
                    Commands.addMessage("nuke X - Player gets X atomic bombs");
                    Commands.addMessage("population - Adds default population to selected province.");
                    Commands.addMessage("pop X, population X - Sets population of selected province to X (min 100).");
                    Commands.addMessage("as, assimilate - Starts assimilation in all player-owned provinces.");
                    Commands.addMessage("technology X, tech X - Sets tech level of civ in selected province to X%.");
                    Commands.addMessage("gold X - Sets player's money to X.");
                    Commands.addMessage("money, gold - Adds default gold (60% of DEFAULT_ARMY).");
                    Commands.addMessage("province - Shows detailed info of selected province.");
                    Commands.addMessage("id - Shows ID of selected province and its civ.");
                    Commands.addMessage("reloadprovince X - Reloads and selects province with ID X.");
                    Commands.addMessage("chaos - Toggles Age of Chaos mode.");
                    return;
                }
                if (tempCommand[0].equals("party") || tempCommand[0].equals("fuck") || tempCommand[0].equals("fuk") || tempCommand[0].equals("flags")) {
                    if (!CFG.menus.getVisible_InGame_FlagAction_Console()) {
                        CFG.menus.setVisible_InGame_FlagAction_Console(true);
                    }
                    lFlagsParty.clear();
                    for (int i = 0; i < CFG.GAMEWIDTH + CFG.GAMEHEIGHT; ++i) {
                        lFlagsParty.add(new Point_XY2(CFG.oR.nextInt(CFG.GAMEWIDTH), CFG.oR.nextInt(CFG.GAMEHEIGHT)));
                    }
                    lFlagsPartyTime = System.currentTimeMillis();
                    CFG.toastM.addM(CFG.lang.get("clear"));
                    CFG.menus.getKeyboard().setVisibleM(false);
                    return;
                }
                if (!CFG.menus.getVisible_InGame_FlagAction_Console()) break block247;
                if (tempCommand[0].equals("clear")) {
                    sConsole.clear();
                    lFlagsParty.clear();
                    return;
                }
                if (tempCommand[0].equals("Drew Durnil") || tempCommand[0].equals("drew durnil") || tempCommand[0].equals("drewdurnil") || tempCommand[0].equals("drew") || tempCommand[0].equals("Drew") || tempCommand[0].equals("Durnil") || tempCommand[0].equals("durnil") || tempCommand[0].equals("observe") || tempCommand[0].equals("noob") || tempCommand[0].equals("Spectator") || tempCommand[0].equals("spectator")) {
                    CFG.toastM.addM("Games -> New Game -> Options -> Spectactor Mode");
                    CFG.toastM.setTimeInView(3500);
                    Commands.addMessage("Games -> New Game -> Options -> Spectator Mode");
                    return;
                }
                if (tempCommand[0].equals("civs") || tempCommand[0].equals("tags")) {
                    for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                        Commands.addMessage("CIV ID: " + i + ", TAG: " + CFG.core.getCiv(i).getCivTag() + ", " + CFG.core.getCiv(i).getCivName());
                    }
                    return;
                }
                if (tempCommand[0].equals("civ")) {
                    if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                        Commands.addMessage("CIV ID: " + CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() + ", TAG: " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag() + ", " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("province")) {
                    if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                        Commands.addMessage("PROVINCE ID: " + CFG.core.getActiveProvID() + ", CIV TAG" + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag());
                        Commands.addMessage("POPULATION: " + CFG.core.getProv(CFG.core.getActiveProvID()).getPop().getPops() + ", ECONOMY" + CFG.core.getProv(CFG.core.getActiveProvID()).getEco());
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("showids") || tempCommand[0].equals("ids")) {
                    CFG.core.buildDrawArmy_ShowIDs();
                    CFG.toastM.addM("showarmy");
                    CFG.toastM.setTimeInView(3500);
                    Commands.addMessage(CFG.lang.get("Disable") + ": showarmy");
                    return;
                }
                if (tempCommand[0].equals("occupy")) {
                    if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince") + ": " + CFG.lang.get("NOT") + " " + CFG.lang.get("Player")));
                        } else {
                            Civilization nCiv = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            for (int i = nCiv.getNumOfProvs() - 1; i >= 0; --i) {
                                int provID = nCiv.getProvID(i);
                                long playerArmy = CFG.core.getProv(provID).getArmyCivID1(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                CFG.core.getProv(provID).updateArmy4(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
                                CFG.core.getProv(provID).setCivId(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
                                CFG.core.getProv(provID).updateArmy4(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), playerArmy);
                            }
                            nCiv.updateNumberOfUnits();
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("Occupy") + ": " + nCiv.getCivName()));
                        }
                    } else {
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                    }
                    return;
                }
                if (tempCommand[0].equals("md")) {
                    try {
                        CFG.core.setActiveProvID(-1);
                        CFG.menus.rebuildManageDiplomacy_Alliances();
                        CFG.core.disableDrawCivlizationsRegions_Players();
                        CFG.chosenAlphabetCharachter = null;
                        CFG.resetManageDiplomacyIDs();
                        CFG.backToMenu = View.eINGAME;
                        CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
                        RenderProvince.updateDrawProvinces();
                        CFG.map.getTouchMgr().ueExA();
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("relation") && tempCommand.length > 3) {
                    try {
                        int civA = Integer.parseInt(tempCommand[1]);
                        int civB = Integer.parseInt(tempCommand[2]);
                        int relation = Integer.parseInt(tempCommand[3]);
                        if (civA > 0 && civB > 0) {
                            CFG.core.getCiv(civA).setRelationD(civB, relation);
                            CFG.core.getCiv(civB).setRelationD(civA, relation);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Relations") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName() + ": " + relation);
                            Commands.addMessage(CFG.lang.get("Relations") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName() + ": " + relation);
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        }
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("showarmy")) {
                    CFG.core.buildDrawArmy();
                    return;
                }
                if (tempCommand[0].equals("chaos")) {
                    CFG.AGE_OF_CHAOS_MODE = !CFG.AGE_OF_CHAOS_MODE;
                    return;
                }
                if (tempCommand[0].equals("nukes")) {
                    CFG.ENABLE_NUKES = !CFG.ENABLE_NUKES;
                    Commands.addMessage(CFG.lang.get("EnableNuclearWeapons") + ": " + (CFG.ENABLE_NUKES ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
                    CFG.toastM.addM(CFG.lang.get("EnableNuclearWeapons") + ": " + (CFG.ENABLE_NUKES ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")), CFG.COLOR_NEGATIVE_2);
                    return;
                }
                if (tempCommand[0].equals("totalwar")) {
                    CFG.TOTAL_WARMODE = !CFG.TOTAL_WARMODE;
                    return;
                }
                if (tempCommand[0].equals("aiwar")) {
                    CFG.USE_NEW_DECLARE_WAR_SYSTEM = !CFG.USE_NEW_DECLARE_WAR_SYSTEM;
                    return;
                }
                if (tempCommand[0].equals("retreat2")) {
                    try {
                        CFG.ARMY_RETREAT = Float.parseFloat(tempCommand[1]);
                        CFG.ARMY_RETREAT = Math.min(Math.max(0.0f, CFG.ARMY_RETREAT), 0.99f);
                    }
                    catch (Exception ex) {
                        
                    }
                    return;
                }
                if (tempCommand[0].equals("retreat")) {
                    try {
                        CFG.ARMY_RETREAT = (float)Integer.parseInt(tempCommand[1]) / 100.0f;
                        CFG.ARMY_RETREAT = Math.min(Math.max(0.0f, CFG.ARMY_RETREAT), 0.99f);
                    }
                    catch (Exception ex) {
                        
                    }
                    return;
                }
                if (tempCommand[0].equals("minarmy")) {
                    try {
                        CFG.MIN_ARMY_REQUIRED_TO_ATTACK = Integer.parseInt(tempCommand[1]);
                    }
                    catch (Exception ex) {
                        
                    }
                    return;
                }
                if (!CFG.SPECTATOR_MODE && tempCommand[0].equals("addplayer")) {
                    if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && !CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsPlayer()) {
                        if (CFG.SPECTATOR_MODE) {
                            CFG.SPECTATOR_MODE = false;
                            if (CFG.core.getPlayersSize() == 1) {
                                CFG.core.removePlayer(0);
                            }
                        }
                        CFG.core.addPlayer(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        CFG.gameAction.buildFogOfWar(CFG.core.getPlayersSize() - 1);
                        if (CFG.FOG_OF_WAR == 2) {
                            CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).buildMetProvsAndCivs();
                        }
                        CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).loadPlayersFlag();
                        Commands.addMessage(CFG.lang.get("Added") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        return;
                    }
                    Commands.IllegalCommand();
                    CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                    Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                    Commands.addMessage("");
                    break block247;
                }
                if (tempCommand[0].equals("gold")) {
                    try {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setGold(Long.parseLong(tempCommand[1]));
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("sandbox")) {
                    try {
                        CFG.SANDBOX_MODE = !CFG.SANDBOX_MODE;
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("sandboxai")) {
                    try {
                        CFG.SANDBOX_MODE_AI = !CFG.SANDBOX_MODE_AI;
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("nuke") && tempCommand.length > 1) {
                    try {
                        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes = Integer.parseInt(tempCommand[1]);
                        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("nuke")) {
                    try {
                        ++CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes;
                        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("move")) {
                    try {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setMovementPoints(Integer.parseInt(tempCommand[1]));
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("diplo")) {
                    try {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setDiploPoints(Integer.parseInt(tempCommand[1]));
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        return;
                    }
                    catch (Exception ex) {
                        break block247;
                    }
                }
                if (tempCommand[0].equals("addciv")) {
                    if (tempCommand.length > 1) {
                        if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).isCapital()) {
                            int i;
                            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                                if (!CFG.core.getCiv(i).getCivTag().equals(tempCommand[1])) continue;
                                Commands.IllegalCommand();
                                Commands.addMessage(CFG.core.getCiv(i).getCivName() + ": IS IN THE GAME");
                                Commands.addMessage("");
                                return;
                            }
                            CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(0), 0);
                            CFG.core.createScenarioAddCivilization(tempCommand[1], CFG.core.getActiveProvID(), false, true, true, false);
                            if (CFG.FOG_OF_WAR == 2) {
                                for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                                    CFG.core.getPlayer(i).addMetCiv(true);
                                }
                            }
                            long tempPop = CFG.core.getProv(CFG.core.getActiveProvID()).getPop().getPops();
                            CFG.core.getProv(CFG.core.getActiveProvID()).getPop().clearData();
                            CFG.core.getProv(CFG.core.getActiveProvID()).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), tempPop);
                            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setGold(100L);
                            CFG.gameAction.updateCivsMovementPoints(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            CFG.gameAction.updateCivsDiploPoints(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            CFG.gameAction.buildRank_Score(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                            int tActiveProvince = CFG.core.getActiveProvID();
                            CFG.core.setActiveProvID(-1);
                            CFG.core.setActiveProvID(tActiveProvince);
                            Commands.addMessage(CFG.lang.get("Added") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                            Commands.addMessage("");
                        }
                    } else {
                        Commands.IllegalCommand();
                    }
                    return;
                }
                if (tempCommand[0].equals("union") && tempCommand.length > 2) {
                    try {
                        int civA = Integer.parseInt(tempCommand[1]);
                        int civB = Integer.parseInt(tempCommand[2]);
                        if (civA > 0 && civB > 0) {
                            CFG.core.setCivRelationOfCivB(civA, civB, Math.max(CFG.core.getCivRelationOfCivB(civA, civB), 25.0f));
                            CFG.core.setCivRelationOfCivB(civB, civA, Math.max(CFG.core.getCivRelationOfCivB(civB, civA), 25.0f));
                            ++CFG.core.getCiv((int)civA).civGD.numOfUnions;
                            ++CFG.core.getCiv((int)civB).civGD.numOfUnions;
                            CFG.createUnionCivs(civA, civB);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Union") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName());
                            Commands.addMessage(CFG.lang.get("Union") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName());
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        }
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("annex") && tempCommand.length > 2) {
                    try {
                        int civA = Integer.parseInt(tempCommand[1]);
                        int civB = Integer.parseInt(tempCommand[2]);
                        if (civA > 0 && civB > 0) {
                            int i;
                            ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
                            for (i = 0; i < CFG.core.getCiv(civB).getNumOfProvs(); ++i) {
                                tempProvinces.add(CFG.core.getCiv(civB).getProvID(i));
                            }
                            for (i = 0; i < tempProvinces.size(); ++i) {
                                if (CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId() != civB || CFG.core.getProv((Integer)tempProvinces.get(i)).getTrueOwnerOfProv() != civB) continue;
                                long nArmyNewOwnerArmy = CFG.core.getProv((Integer)tempProvinces.get(i)).getArmyCivID1(civA);
                                CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(0);
                                CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(civA, 0);
                                CFG.core.getProv((Integer)tempProvinces.get(i)).setTrueOwnerOfProv(civA);
                                CFG.core.getProv((Integer)tempProvinces.get(i)).setCivId(civA, false);
                                CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(civA, nArmyNewOwnerArmy);
                                for (int j = CFG.core.getProv((Integer)tempProvinces.get(i)).getCivsSize() - 1; j >= 0; --j) {
                                    if (CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getPuppetOfCiv() == civA || CFG.core.getCiv(civA).getPuppetOfCiv() == CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j) || CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getAlliance() == CFG.core.getCiv(civA).getAlliance() || CFG.core.getMilitaryAccess(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j), civA) > 0) continue;
                                    CFG.gameAction.accessLost_MoveArmyToClosetsProvince(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j), (Integer)tempProvinces.get(i));
                                }
                            }
                            if (CFG.core.getCiv(civB).getCapitalProvID() >= 0) {
                                CFG.core.getProv(CFG.core.getCiv(civB).getCapitalProvID()).setIsCapital(false);
                                for (i = 0; i < CFG.core.getProv(CFG.core.getCiv(civB).getCapitalProvID()).getCitSize(); ++i) {
                                    if (CFG.core.getProv(CFG.core.getCiv(civB).getCapitalProvID()).getCit(i).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                                    CFG.core.getProv(CFG.core.getCiv(civB).getCapitalProvID()).getCit(i).setCityLevel(CFG.getEditorCityLevel(1));
                                }
                            }
                            CFG.core.getCiv(civB).updateNumberOfUnits();
                            tempProvinces.clear();
                            CFG.core.buildCivilizationsRegions_TextOver(civB);
                            CFG.core.buildCivilizationsRegions_TextOver(civA);
                            CFG.core.getCiv(civB).setPuppetOfCivId(civB);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Annexation") + ": " + CFG.core.getCiv(civA).getCivName() + " -> " + CFG.core.getCiv(civB).getCivName());
                            Commands.addMessage(CFG.lang.get("Annexation") + ": " + CFG.core.getCiv(civA).getCivName() + " -> " + CFG.core.getCiv(civB).getCivName());
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        }
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if ((tempCommand[0].equals("vassal") || tempCommand[0].equals("puppet")) && tempCommand.length > 2) {
                    int civA = Integer.parseInt(tempCommand[2]);
                    int civB = Integer.parseInt(tempCommand[1]);
                    if (civA > 0 && civB > 0) {
                        CFG.core.getCiv(civA).setPuppetOfCivId(civB);
                        if (CFG.FOG_OF_WAR > 0) {
                            int i;
                            int tPlayerID;
                            if (CFG.core.getCiv(civA).getIsPlayer() && (tPlayerID = CFG.core.getPlayerIDbyCivID(civA)) >= 0) {
                                for (i = 0; i < CFG.core.getCiv(civB).getNumOfProvs(); ++i) {
                                    CFG.core.getProv(CFG.core.getCiv(civB).getProvID(i)).updateFogOfWar(tPlayerID);
                                }
                            }
                            if (CFG.core.getCiv(civB).getIsPlayer() && (tPlayerID = CFG.core.getPlayerIDbyCivID(civB)) >= 0) {
                                for (i = 0; i < CFG.core.getCiv(civA).getNumOfProvs(); ++i) {
                                    CFG.core.getProv(CFG.core.getCiv(civA).getProvID(i)).updateFogOfWar(tPlayerID);
                                }
                            }
                        }
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Lord") + ":  " + CFG.core.getCiv(civB).getCivName() + ", " + CFG.lang.get("Vassal") + ": " + CFG.core.getCiv(civA).getCivName());
                        Commands.addMessage(CFG.lang.get("Lord") + ":  " + CFG.core.getCiv(civB).getCivName() + ", " + CFG.lang.get("Vassal") + ": " + CFG.core.getCiv(civA).getCivName());
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("ww") && tempCommand.length > 1) {
                    try {
                        int value = Integer.parseInt(tempCommand[1]);
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setWarWeariness((float)value / 100.0f);
                        Commands.addMessage(CFG.lang.get("WarWeariness") + ": " + value + "% -> " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        Commands.addMessage("");
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("WarWeariness") + ": " + value + "% -> " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("as") || tempCommand[0].equals("assimilate")) {
                    try {
                        int num = 0;
                        for (int i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i) {
                            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).addAssimilate(new CivTask(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX));
                            ++num;
                        }
                        Commands.addMessage(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Provinces") + ": " + num);
                        Commands.addMessage("");
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Provinces") + ": " + num);
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                    }
                    return;
                }
                if (tempCommand[0].equals("technology") || tempCommand[0].equals("tech")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        if (tempCommand.length > 1) {
                            try {
                                int tempTech = Integer.parseInt(tempCommand[1]);
                                if (tempTech > 200) {
                                    tempTech = 200;
                                } else if (tempTech < 1) {
                                    tempTech = 1;
                                }
                                CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setTechLevel((float)tempTech / 100.0f);
                                Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Technology") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getTechLevel() + ", " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                                Commands.addMessage("");
                                int tActiveProvince = CFG.core.getActiveProvID();
                                CFG.core.setActiveProvID(-1);
                                CFG.core.setActiveProvID(tActiveProvince);
                                CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Technology"));
                            }
                            catch (IllegalArgumentException ex) {
                                Commands.IllegalCommand();
                            }
                        } else {
                            Commands.IllegalCommand();
                        }
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("population")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 750 + CFG.core.getProv(CFG.core.getActiveProvID()).getPop().getPopulationOfCivID(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()));
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Population") + ": +" + 750);
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Population"));
                        if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                            CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                        }
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("armyset") || tempCommand[0].equals("setarmy")) {
                    long tArmy = Long.parseLong(tempCommand[1]);
                    if (tArmy >= 0 && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getNumberOfUnits() - CFG.core.getProv(CFG.core.getActiveProvID()).getArmyID(0));
                        CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(tArmy);
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getNumberOfUnits() + tArmy);
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Army") + ": " + tArmy);
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Army"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("noliberity")) {
                    CFG.VASSALS_CAN_DECLARE_INDEPENDENCE = !CFG.VASSALS_CAN_DECLARE_INDEPENDENCE;
                    Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Liberation") + ": " + (CFG.VASSALS_CAN_DECLARE_INDEPENDENCE ? CFG.lang.get("Disabled") : CFG.lang.get("Enabled")));
                    Commands.addMessage("");
                    CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Liberation") + ": " + (CFG.VASSALS_CAN_DECLARE_INDEPENDENCE ? CFG.lang.get("Disabled") : CFG.lang.get("Enabled")));
                    return;
                }
                if (tempCommand[0].equals("id")) {
                    if (CFG.core.getActiveProvID() >= 0) {
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Province") + ": " + CFG.core.getActiveProvID());
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Civilization") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName() + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivId());
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("War"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("war")) {
                    int civA = Integer.parseInt(tempCommand[1]);
                    int civB = Integer.parseInt(tempCommand[2]);
                    if (civA >= 0 && civB >= 0 && CFG.core.getCiv(civA).getNumOfProvs() > 0 && CFG.core.getCiv(civB).getNumOfProvs() > 0) {
                        CFG.core.declareWar(civA, civB, true);
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("War") + ": " + CFG.core.getCiv(civA).getCivName() + " -> " + CFG.core.getCiv(civB).getCivName());
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("War"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("peace")) {
                    int civA = Integer.parseInt(tempCommand[1]);
                    int civB = Integer.parseInt(tempCommand[2]);
                    if (civA >= 0 && civB >= 0 && CFG.core.getCivsAtWar(civA, civB)) {
                        CFG.core.getCiv((int)civB).civGD.civDiploGD.messageBox.addMessage(new Message_WeCanSignPeace(civA));
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Added") + ": " + CFG.core.getCiv(civA).getCivName() + " -> " + CFG.core.getCiv(civB).getCivName());
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Added"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("ally") || tempCommand[0].equals("alliance")) {
                    try {
                        int civA = Integer.parseInt(tempCommand[1]);
                        int civB = Integer.parseInt(tempCommand[2]);
                        if (civA > 0 && civB > 0 && !CFG.core.getCivsAtWar(civA, civB)) {
                            if (CFG.core.getCiv(civA).getAlliance() == 0 && CFG.core.getCiv(civB).getAlliance() == 0) {
                                CFG.core.addAlliance(CFG.getRandomAllianceName(0));
                                int tempAllianceID = CFG.core.getAlliancesSize() - 1;
                                if (CFG.core.getCiv(civA).getIsPlayer()) {
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civA);
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civB);
                                } else if (CFG.core.getCiv(civB).getIsPlayer()) {
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civB);
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civA);
                                } else {
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civA);
                                    CFG.core.getAlliance(tempAllianceID).addCivilization(civB);
                                }
                                CFG.core.getCiv(civA).setAlliance(tempAllianceID);
                                CFG.core.getCiv(civB).setAlliance(tempAllianceID);
                                CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(civA, tempAllianceID));
                                CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(civB, tempAllianceID));
                            } else if (CFG.core.getCiv(civB).getAlliance() > 0 && CFG.core.getCiv(civA).getAlliance() == 0) {
                                CFG.core.getAlliance(CFG.core.getCiv(civB).getAlliance()).addCivilization(civA);
                                CFG.core.getCiv(civA).setAlliance(CFG.core.getCiv(civB).getAlliance());
                                CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(civA, CFG.core.getCiv(civB).getAlliance()));
                            } else if (CFG.core.getCiv(civA).getAlliance() > 0 && CFG.core.getCiv(civB).getAlliance() == 0) {
                                CFG.core.getAlliance(CFG.core.getCiv(civA).getAlliance()).addCivilization(civB);
                                CFG.core.getCiv(civB).setAlliance(CFG.core.getCiv(civA).getAlliance());
                                CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(civB, CFG.core.getCiv(civA).getAlliance()));
                            } else {
                                CFG.core.getAlliance(CFG.core.getCiv(civA).getAlliance()).removeCivilization(civA);
                                CFG.core.getAlliance(CFG.core.getCiv(civB).getAlliance()).addCivilization(civA);
                                CFG.core.getCiv(civA).setAlliance(CFG.core.getCiv(civB).getAlliance());
                                CFG.core.getCiv(civA).setAlliance(CFG.core.getCiv(civB).getAlliance());
                            }
                            if (CFG.core.getCiv(civA).getIsPlayer()) {
                                CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(civA));
                                CFG.core.getPlayer(CFG.core.getPlayerIDbyCivID(civA)).buildMetProvsAndCivs();
                            }
                            if (CFG.core.getCiv(civB).getIsPlayer()) {
                                CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(civB));
                                CFG.core.getPlayer(CFG.core.getPlayerIDbyCivID(civB)).buildMetProvsAndCivs();
                            }
                            Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Alliance") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName());
                            Commands.addMessage("");
                            int tActiveProvince = CFG.core.getActiveProvID();
                            CFG.core.setActiveProvID(-1);
                            CFG.core.setActiveProvID(tActiveProvince);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Alliance") + ": " + CFG.core.getCiv(civA).getCivName() + " - " + CFG.core.getCiv(civB).getCivName());
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                            Commands.addMessage("");
                        }
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("Error"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("Error")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("buildport")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getLvlOfPort() >= 0) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfPort(1);
                        Commands.addMessage(Commands.cheatMess() + "Port built");
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Port built"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("buildfort")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfFort(1);
                        CFG.core.getProv(CFG.core.getActiveProvID()).updateDrawArmyInProv();
                        Commands.addMessage(Commands.cheatMess() + "Fort built");
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Fort built"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("buildtower")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).setLvlOfWatchTower(1);
                        CFG.core.getProv(CFG.core.getActiveProvID()).updateDrawArmyInProv();
                        Commands.addMessage(Commands.cheatMess() + "Tower built");
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Tower built"));
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("economy")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).setEco(CFG.core.getProv(CFG.core.getActiveProvID()).getEco() + 600);
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Economy") + ": +" + 600);
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Economy"));
                        if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                            CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                        }
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("invest")) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getNumOfProvs(); ++i) {
                            long economy = CFG.core.getProv(CFG.core.getActiveProvID()).getPop().getPops() / 10L;
                            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).addInvest(new CivInvest(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getProvID(i), GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS, (int)economy, (int)economy / GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS));
                        }
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Invest") + ", " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName() + ", " + CFG.lang.get("Provinces") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getNumOfProvs());
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Invest") + ", " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName() + ", " + CFG.lang.get("Provinces") + ": " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getNumOfProvs());
                        if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                            CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                        }
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if ((tempCommand[0].equals("pop") || tempCommand[0].equals("population")) && tempCommand.length > 1) {
                    try {
                        if (CFG.core.getActiveProvID() >= 0) {
                            int population = Math.max(100, Integer.parseInt(tempCommand[1]));
                            CFG.core.getProv(CFG.core.getActiveProvID()).getPop().clearData();
                            CFG.core.getProv(CFG.core.getActiveProvID()).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), population);
                        }
                    }
                    catch (Exception population) {
                        
                    }
                    return;
                }
                if (tempCommand[0].equals("setarmy") && tempCommand.length > 1) {
                    try {
                        if (CFG.core.getActiveProvID() >= 0) {
                            CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID), Integer.parseInt(tempCommand[1]));
                            Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Army") + ": " + Integer.parseInt(tempCommand[1]));
                            Commands.addMessage("");
                            int tActiveProvince = CFG.core.getActiveProvID();
                            CFG.core.setActiveProvID(-1);
                            CFG.core.setActiveProvID(tActiveProvince);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Army"));
                            if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                                CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                            }
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                            Commands.addMessage("");
                        }
                    }
                    catch (Exception tActiveProvince) {
                        
                    }
                    return;
                }
                if (tempCommand[0].equals("army") && tempCommand.length > 1) {
                    try {
                        if (CFG.core.getActiveProvID() >= 0) {
                            CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID), CFG.core.getProv(CFG.core.getActiveProvID()).getArmyID(CFG.activeCivilizationArmyID) + Integer.parseInt(tempCommand[1]));
                            Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Army") + ": +" + Integer.parseInt(tempCommand[1]));
                            Commands.addMessage("");
                            int tActiveProvince = CFG.core.getActiveProvID();
                            CFG.core.setActiveProvID(-1);
                            CFG.core.setActiveProvID(tActiveProvince);
                            CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Army"));
                            if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                                CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                            }
                        } else {
                            Commands.IllegalCommand();
                            CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                            Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                            Commands.addMessage("");
                        }
                    }
                    catch (Exception tActiveProvince) {
                        
                    }
                    return;
                }
                if (tempCommand[0].equals("army")) {
                    if (CFG.core.getActiveProvID() >= 0) {
                        CFG.core.getProv(CFG.core.getActiveProvID()).updateArmy4(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(CFG.activeCivilizationArmyID), CFG.core.getProv(CFG.core.getActiveProvID()).getArmyID(CFG.activeCivilizationArmyID) + 300);
                        Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Army") + ": +" + 300);
                        Commands.addMessage("");
                        int tActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(tActiveProvince);
                        CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Army"));
                        if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                            CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                        }
                    } else {
                        Commands.IllegalCommand();
                        CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                        Commands.addMessage(CFG.lang.get(CFG.lang.get("ChooseAProvince")));
                        Commands.addMessage("");
                    }
                    return;
                }
                if (tempCommand[0].equals("money") || tempCommand[0].equals("Gold")) {
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setGold(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() + 450L);
                    Commands.addMessage(Commands.cheatMess() + CFG.lang.get("Treasury") + ": +" + 450);
                    Commands.addMessage("");
                    CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("Treasury"));
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    return;
                }
                if (tempCommand[0].equals("movement")) {
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setMovementPoints(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE * 10);
                    Commands.addMessage(Commands.cheatMess() + CFG.lang.get("MovementPoints") + ": +" + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE * 10);
                    Commands.addMessage("");
                    CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("movement"));
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    return;
                }
                if (tempCommand[0].equals("diplomacy")) {
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setDiploPoints(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE * 3 / 4);
                    Commands.addMessage(Commands.cheatMess() + CFG.lang.get("DiplomacyPoints") + ": +" + (float)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE * 3 / 4) / 10.0f);
                    Commands.addMessage("");
                    CFG.toastM.addM(Commands.cheatMess() + CFG.lang.get("diplomacy"));
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    return;
                }
                if (tempCommand[0].equals("reloadprovince")) {
                    try {
                        int tempID = Integer.parseInt(tempCommand[1]);
                        if (tempID < CFG.core.getProvinSize()) {
                            Editor_NeighboringProvinces.updateProvince(tempID);
                            CFG.core.setActiveProvID(tempID);
                            CFG.toastM.addM(CFG.core.getProv(tempID).getName());
                        } else {
                            Commands.IllegalCommand();
                        }
                        return;
                    }
                    catch (Exception ex) {
                        Commands.IllegalCommand();
                        return;
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        Commands.IllegalCommand();
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    private static final String cheatMess() {
        return "[" + CFG.lang.get("Cheat") + "] ";
    }

    private static final void IllegalCommand() {
        Commands.addMessage("# -- " + CFG.lang.get("UnknownCommand"));
        CFG.toastM.addM("# -- " + CFG.lang.get("UnknownCommand"), CFG.COLOR_NEGATIVE_2);
        Commands.addMessage("");
    }
}

