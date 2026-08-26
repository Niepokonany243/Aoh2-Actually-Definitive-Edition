import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
# 1. Remove early update at 2279 (single attacker) - make it no-op comment to preserve line numbers
old2279 = "                                CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(attackersArmy - defendersArmy);"
if old2279 in t:
    t = t.replace(old2279, "                                // survivors deferred to after setCivId", 1)
    print("removed 2279 early update")
else:
    print("2279 not found")
# 2. Remove early update at 2133 (multi attacker) - need exact text
old2133 = "                                CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4((long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));"
if old2133 in t:
    t = t.replace(old2133, "                                // survivors deferred to after setCivId (multi)", 1)
    print("removed 2133 early update")
else:
    print("2133 not found, searching")
    # Try alternative - maybe spacing different
    import re
    m = re.search(r'CFG\.core\.getProv\(moveUnits\.getMoveUnits\(0\)\.getToProvID\(\)\)\.updateArmy4\(\(long\)Math\.ceil', t)
    if m:
        print("found pattern near", t[m.start()-100:m.start()+200])

# 3. Add army after each setCivId(attacker) in single attacker branches
# Branch at 2305: after setCivId attacker true without army
old_a = "                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                            this.updateInGame_ProvinceInfo();\n                                        }\n                                    } else if (CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() < 1 || CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() == moveUnits.getCivID(0)) {"
new_a = "                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(moveUnits.getCivID(0), attackerRemainingAfterBattle);\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                            this.updateInGame_ProvinceInfo();\n                                        }\n                                    } else if (CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() < 1 || CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() == moveUnits.getCivID(0)) {"
if old_a in t:
    t = t.replace(old_a, new_a, 1)
    print("fixed branch 2305")
else:
    print("branch 2305 not found")

old_b = "                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, moveUnits.getCivID(0), CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getCivId(0));\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                    if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                        this.updateInGame_ProvinceInfo();\n                                    }\n                                } else if (CFG.core.getCivsAtWar"
new_b = "                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, moveUnits.getCivID(0), CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getCivId(0));\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(moveUnits.getCivID(0), attackerRemainingAfterBattle);\n                                    if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                        this.updateInGame_ProvinceInfo();\n                                    }\n                                } else if (CFG.core.getCivsAtWar"
if old_b in t:
    t = t.replace(old_b, new_b, 1)
    print("fixed branch 2310")
else:
    print("branch 2310 not found")

# Final else branch at 2352-2353
old_c = "                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, moveUnits.getCivID(0), CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getCivId(0));\n                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                            this.updateInGame_ProvinceInfo();\n                                        }\n                                    }\n                                 }"
# Need to be precise - there are two similar, need the last one (final else)
# The final else is after the core loop
# Let's find the last occurrence
idx = t.rfind(old_c)
if idx != -1:
    # Check context: after this is the closing of the big if-else chain for single attacker win
    t = t[:idx] + new_b.replace("                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, moveUnits.getCivID(0), CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getCivId(0));\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(moveUnits.getCivID(0), attackerRemainingAfterBattle);", "                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, moveUnits.getCivID(0), CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getCivId(0));\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                    CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(moveUnits.getCivID(0), attackerRemainingAfterBattle);") + t[idx+len(old_c):]
    print("fixed final branch - but reused new_b, may duplicate")
else:
    print("final branch not found")

# For multi-attacker, need to fix its branches too - but they are more complex, defer for now
# Let's just ensure multi's early update removed, and its conquest branches already have army sets? Check
# Multi conquest at ~2184 also does setCivId attacker without army - need to add there too
old_multi_conquest = "                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                            this.updateInGame_ProvinceInfo();\n                                        }\n                                    } else if (CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() < 1"
# This is same as single, but multi's first conquest branch is at 2184
# Actually multi's 2184 is also trueOwner revolutionary else branch - same pattern
# Our fix for 2305 already covers single, but multi's 2184 is similar - let's fix it too
# Find multi's 2184 pattern
multi_need = t.count("CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);")
print(f"total setCivId attacker remaining: {multi_need}")

p.write_text(t, encoding='utf-8')
print("done")
