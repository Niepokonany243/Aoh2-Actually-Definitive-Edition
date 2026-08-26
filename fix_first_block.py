import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
# Fix first block's curMoveUnits2 -> curMoveUnits at 1162
t = t.replace(
    "                        if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(curMoveUnits2.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(curMoveUnits2.getMoveUnits(0).getToProvID()).getCivId())) {",
    "                        if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(curMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(curMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {",
    1
)
# Fix 1312 which still uses this.currentMoveUnits in second block tail - should be curMoveUnits2
# Find the specific snippet after second block's return
t = t.replace(
    "                                CFG.map.getMpC().centerToProvID(this.currentMoveUnits.getMoveUnits(0).getToProvID());\n                                if (CFG.mapModesManager.getActiveMapModeID() >= 0) {\n                                    CFG.mapModesManager.disableAllViews();\n                                }\n                                return;\n                            }\n                            this.turnMoves_MoveCurrentArmy();\n                            continue;\n                     }\n                     civE.removeMove(i--);",
    "                                CFG.map.getMpC().centerToProvID(curMoveUnits2.getMoveUnits(0).getToProvID());\n                                if (CFG.mapModesManager.getActiveMapModeID() >= 0) {\n                                    CFG.mapModesManager.disableAllViews();\n                                }\n                                return;\n                            }\n                            this.turnMoves_MoveCurrentArmy();\n                            continue;\n                     }\n                     civE.removeMove(i--);",
    1
)
# Fix first block tail: from first curMoveUnits guard to second curMoveUnits2 guard, replace this.currentMoveUnits. with curMoveUnits.
first_idx = t.find("MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;")
second_idx = t.find("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;")
region1 = t[first_idx:second_idx]
fixed1 = region1.replace("this.currentMoveUnits.", "curMoveUnits.")
fixed1 = fixed1.replace("curMoveUnits = null;", "this.currentMoveUnits = null;")
# The guard itself already is curMoveUnits == null, correct. But we replaced this.currentMoveUnits. so guard's this. not affected (no dot)
t = t[:first_idx] + fixed1 + t[second_idx:]
print("fixed first block tail, replaced", region1.count("this.currentMoveUnits."), "occurrences")
p.write_text(t, encoding='utf-8')
print("done")
