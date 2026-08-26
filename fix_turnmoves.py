import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
old_block = """                        if (this.currentMoveUnits == null) {
                            continue;
                        }
                        long attackingArmy = 0L;
                        for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                            attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                        }"""
new_block = """                        MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;
                        if (curMoveUnits == null) {
                            continue;
                        }
                        long attackingArmy = 0L;
                        for (o = 0; o < curMoveUnits.getMoveUnitsSize(); ++o) {
                            attackingArmy += curMoveUnits.getMoveUnits(o).getNumberOfUnits();
                        }"""
if old_block in t:
    # Need to replace both occurrences, but they have different indent (first is 24 spaces, second 28?)
    # Our old_block is 24 spaces version (first loop). Check counts
    print("found old_block, replacing")
    # Replace both by doing two specific indents
    # First loop is at 24 spaces before if, second at 28
    # Our old_block has 24 spaces. For second, need 28
    # Let's replace 24 version first
    t2 = t.replace(old_block, new_block, 1)
    # Now second version has 28 spaces: create it
    old_block2 = """                            if (this.currentMoveUnits == null) {
                                continue;
                            }
                            long attackingArmy = 0L;
                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                                attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                            }"""
    new_block2 = """                            MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;
                            if (curMoveUnits2 == null) {
                                continue;
                            }
                            long attackingArmy = 0L;
                            for (o = 0; o < curMoveUnits2.getMoveUnitsSize(); ++o) {
                                attackingArmy += curMoveUnits2.getMoveUnits(o).getNumberOfUnits();
                            }"""
    # Check if second exists (with 28 spaces)
    if old_block2 in t2:
        t2 = t2.replace(old_block2, new_block2, 1)
        print("second block replaced")
    else:
        print("second block NOT found - trying alternative")
        # Try to find what second block looks like now (after first replace, second still has this.currentMoveUnits)
        # Let's just global replace remaining this.currentMoveUnits in turnMoves second block context
        # For now, do a targeted fix: within the second RTO loop, replace this.currentMoveUnits. with curMoveUnits2. after the guard
        # Simpler: just do global for the second block's remaining this.currentMoveUnits reads within that block
        # Find the second block's start
        idx = t2.find("MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;")
        # There should be one now, find second occurrence of if (this.currentMoveUnits == null)
        # Actually second block still has if (this.currentMoveUnits == null) - let's snapshot it too
        # Let's just do a second pass: replace the second guard's following uses
        pass
    # For the second block, we need to also replace subsequent this.currentMoveUnits. with curMoveUnits2. within that block until its continue/return
    # To avoid complexity, let's just do a global within the file for the second block's region: find the second curMoveUnits2 block and replace following this.currentMoveUnits reads until next method
    # Simpler: after creating curMoveUnits2, replace the next ~80 lines of this.currentMoveUnits. with curMoveUnits2.
    # Let's do a manual region replace: find second block start, then find the next "                        if (attackingArmy <" and replace within
    # For now, just do a global replace of this.currentMoveUnits. -> curMoveUnits. within the whole file is dangerous (affects MoveCurrentArmy)
    # Instead, do limited: after new_block2, the code still has this.currentMoveUnits.getMoveUnits(0) etc. We need to replace those with curMoveUnits2.
    # Let's do a second script pass for the second block's body
    # Find second block's body start after new_block2
    if "curMoveUnits2" in t2:
        # Find the second block's body and replace this.currentMoveUnits. with curMoveUnits2. up to its continue
        parts = t2.split("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;")
        if len(parts) == 2:
            # parts[0] is before second block, parts[1] is after
            # Find the end of second block: look for "                            this.currentMoveUnits = null;" after second block start
            # Actually second block's insufficient army path does this.currentMoveUnits = null; continue;
            # And the main path does not null there, goes to rollDices etc using curMoveUnits2
            # Let's isolate second block's code: from after curMoveUnits2 guard to the next "                            for (o = 0; o < curMoveUnits2"
            # Simpler: replace all remaining this.currentMoveUnits. in the second block's scope (until the next "                        if (required >")
            # Let's just replace the immediate next occurrences: the if (attackingArmy < ...) line and the following for loops that still use this.currentMoveUnits
            # We'll replace the specific lines:
            # "if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0)"
            # -> curMoveUnits2
            t2 = t2.replace("if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {", "if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(curMoveUnits2.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(curMoveUnits2.getMoveUnits(0).getToProvID()).getCivId())) {", 1)
            t2 = t2.replace("                                this.currentMoveUnits = null;\n                                continue;", "                                this.currentMoveUnits = null;\n                                continue;", 1) # keep field write
            # Also need to replace the following for loops that use this.currentMoveUnits in second block
            # There are: for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o)  after the if
            # And later this.currentMoveUnits.getMoveUnits(0) etc.
            # Let's do a limited replace in the second block region only: from curMoveUnits2 guard to the next "                        if (required >"
            start2 = t2.find("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;")
            # Find the second block's end marker: "                            for (o = 0; o < curMoveUnits2.getMoveUnitsSize"
            # Actually after our replacement, that line already uses curMoveUnits2, so find the next this.currentMoveUnits. after start2
            # Let's just replace any this.currentMoveUnits. that appears within 2000 chars after start2, except the = null line
            idx_start = start2
            idx_end = t2.find("                        if (required > 0 && attackingArmy < required", idx_start)
            if idx_end != -1:
                region = t2[idx_start:idx_end]
                region_fixed = region.replace("this.currentMoveUnits.", "curMoveUnits2.")
                # But this would also replace the guard's this.currentMoveUnits == null - no dot, so safe
                # Also need to keep this.currentMoveUnits = null intact - it has no dot, so not replaced
                t2 = t2[:idx_start] + region_fixed + t2[idx_end:]
                print("fixed second block region this.currentMoveUnits. -> curMoveUnits2.")
            # For the second block's later part (after required check), there is "for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o)" etc.
            # That is after idx_end, find it
            idx2 = t2.find("for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o)", idx_end)
            if idx2 != -1 and idx2 < idx_end + 3000: # within second block
                # This for is part of second block's rollDices etc? Actually need to check context
                # The second block has: for (o = 0; o < curMoveUnits2.getMoveUnitsSize(); ++o) for updateMoveTime, then rollDices using curMoveUnits2
                # Let's find the region from idx_end to the next "                            this.turnMoves_MoveCurrentArmy();"
                idx_end2 = t2.find("                            this.turnMoves_MoveCurrentArmy();", idx_end)
                if idx_end2 != -1:
                    region2 = t2[idx_end:idx_end2+50]
                    region2_fixed = region2.replace("this.currentMoveUnits.", "curMoveUnits2.")
                    t2 = t2[:idx_end] + region2_fixed + t2[idx_end2:]
                    print("fixed second block tail")
    p.write_text(t2, encoding='utf-8')
    print("done")
else:
    print("old_block not found")
