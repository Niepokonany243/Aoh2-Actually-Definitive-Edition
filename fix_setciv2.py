import pathlib, re
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
# Find all setCivId attacker true followed by activeProv check without intervening updateArmy4
pattern = r'CFG\.core\.getProv\(moveUnits\.getMoveUnits\(0\)\.getToProvID\(\)\)\.setCivId\(moveUnits\.getCivID\(0\), true\);\n                                        if \(moveUnits\.getMoveUnits\(0\)\.getToProvID\(\) == CFG\.core\.getActiveProvID\(\)\)'
def repl(m):
    # Check context: is this in multi or single? Look back 2000 chars for variable name
    start = m.start()
    context = t[max(0,start-2000):start+500]
    if 'mainAttackerRemaining' in context or 'mainAttackerCivID' in context:
        army_var = 'mainAttackerRemaining'
        civ_var = 'mainAttackerCivID'
        # For multi, the moveUnits.getCivID(0) is main attacker, so use mainAttackerCivID
        insert = f'CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4({civ_var}, {army_var});\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID())'
    else:
        army_var = 'attackerRemainingAfterBattle'
        insert = f'CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).setCivId(moveUnits.getCivID(0), true);\n                                        CFG.core.getProv(moveUnits.getMoveUnits(0).getToProvID()).updateArmy4(moveUnits.getCivID(0), {army_var});\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID())'
    return insert

# Need to handle all occurrences
# Use re.sub with function
new_t, n = re.subn(pattern, repl, t)
print(f"replaced {n} occurrences")
# Also need to check for setCivId that is at end of chain without activeProv check (final else)
# That one is: setCivId(...); if (moveUnits... == activeProv) updateInfo; else? Actually final else is:
# CFG.core.getProv(...).setCivId(moveUnits.getCivID(0), true);\n                                        if (moveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {\n                                            this.updateInGame_ProvinceInfo();\n                                        }\n                                    }\n                                 }
# That's same pattern, already handled

p.write_text(new_t, encoding='utf-8')
print("done")
# Verify counts
t2 = p.read_text(encoding='utf-8')
print("remaining setCivId without following update:", t2.count("setCivId(moveUnits.getCivID(0), true);"))
# Count how many of those are followed by update
import re as re2
cnt_with_update = len(re2.findall(r'setCivId\(moveUnits\.getCivID\(0\), true\);\s*\n\s*CFG\.core\.getProv\(moveUnits\.getMoveUnits\(0\)\.getToProvID\(\)\)\.updateArmy4', t2))
print(f"with following updateArmy4: {cnt_with_update}")
