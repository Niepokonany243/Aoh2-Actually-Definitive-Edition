import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')

# 1. volatile
t = t.replace('private MoveUnits_TurnData currentMoveUnits = null;', 'private volatile MoveUnits_TurnData currentMoveUnits = null;', 1)
print("1 volatile done")

# 2. int -> long (2 occurrences - careful to only do the two attackingArmy ones)
# They are exactly these strings
t = t.replace('                        int attackingArmy = 0;', '                        long attackingArmy = 0L;', 1)
t = t.replace('                            int attackingArmy = 0;', '                            long attackingArmy = 0L;', 1)
print("2 int->long done, count long:", t.count('long attackingArmy = 0L;'))

# 3. nextTurn gate
old_next = """    public final void nextTurn() {
        if (this.actionsTask != null && this.actionsTask.isDone()) {
            Future<?> completedTask = this.actionsTask;
            this.actionsTask = null;
            if (!this.taskCompletedSuccessfully(completedTask, "Turn actions")) {
                throw new IllegalStateException("Turn actions failed; refusing to advance partial state");
            }
        }
        this.resetTurnData();"""
new_next = """    public final void nextTurn() {
        if (this.actionsTask != null) {
            if (!this.actionsTask.isDone()) {
                return;
            }
            Future<?> completedTask = this.actionsTask;
            this.actionsTask = null;
            if (!this.taskCompletedSuccessfully(completedTask, "Turn actions")) {
                throw new IllegalStateException("Turn actions failed; refusing to advance partial state");
            }
        }
        this.resetTurnData();"""
t = t.replace(old_next, new_next, 1)
print("3 nextTurn gate done")

# 4. JustMove local capture
old_just = """    private final void turnMoves_MoveCurrentArmy_JustMove() {
        try {
            for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(i)) - this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getToProvID()).getArmyCivID1(this.currentMoveUnits.getCivID(i)) + this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
            }
        }"""
new_just = """    private final void turnMoves_MoveCurrentArmy_JustMove() {
        MoveUnits_TurnData moveUnits = this.currentMoveUnits;
        if (moveUnits == null) {
            return;
        }
        try {
            for (int i = 0; i < moveUnits.getMoveUnitsSize(); ++i) {
                CFG.core.getProv(moveUnits.getMoveUnits(i).getFromProviID()).updateArmy4(moveUnits.getCivID(i), CFG.core.getProv(moveUnits.getMoveUnits(i).getFromProviID()).getArmyCivID1(moveUnits.getCivID(i)) - moveUnits.getMoveUnits(i).getNumberOfUnits());
                CFG.core.getProv(moveUnits.getMoveUnits(i).getToProvID()).updateArmy4(moveUnits.getCivID(i), CFG.core.getProv(moveUnits.getMoveUnits(i).getToProvID()).getArmyCivID1(moveUnits.getCivID(i)) + moveUnits.getMoveUnits(i).getNumberOfUnits());
            }
        }"""
if old_just in t:
    t = t.replace(old_just, new_just, 1)
    print("4 JustMove done")
else:
    print("4 JustMove NOT FOUND")

# 5. MoveCurrentArmy local capture (method 1895-2800)
start_marker = '    private final void turnMoves_MoveCurrentArmy() {'
end_marker = '    private final void rollDices() {'
s = t.find(start_marker)
e = t.find(end_marker, s)
if s != -1 and e != -1:
    before = t[:s]
    method = t[s:e]
    after = t[e:]
    old_head = """    private final void turnMoves_MoveCurrentArmy() {
        try {"""
    new_head = """    private final void turnMoves_MoveCurrentArmy() {
        MoveUnits_TurnData moveUnits = this.currentMoveUnits;
        if (moveUnits == null) {
            return;
        }
        try {"""
    if old_head in method:
        method = method.replace(old_head, new_head, 1)
        print("5a MoveCurrentArmy head done")
    # Replace this.currentMoveUnits. -> moveUnits. within method (reads only, not = null)
    cnt = method.count('this.currentMoveUnits.')
    method = method.replace('this.currentMoveUnits.', 'moveUnits.')
    print(f"5b MoveCurrentArmy body: replaced {cnt} reads")
    t = before + method + after
else:
    print("5 MoveCurrentArmy markers not found")

# 6. turnMoves two blocks - need to add snapshot guards
# First block: 24 spaces indent, second: 28 spaces
# After step 2, they are long attackingArmy = 0L;
# Replace first block's int attackingArmy pattern which is now long
old_block1 = """                        long attackingArmy = 0L;
                        for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                            attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                        }
                        if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {"""
new_block1 = """                        MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;
                        if (curMoveUnits == null) {
                            continue;
                        }
                        long attackingArmy = 0L;
                        for (o = 0; o < curMoveUnits.getMoveUnitsSize(); ++o) {
                            attackingArmy += curMoveUnits.getMoveUnits(o).getNumberOfUnits();
                        }
                        if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(curMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(curMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {"""
if old_block1 in t:
    t = t.replace(old_block1, new_block1, 1)
    print("6a first block snapshot done")
    # Now fix the rest of first block's this.currentMoveUnits. -> curMoveUnits. within that block's body
    # Find first block's region: from curMoveUnits guard to next civE.removeMove
    idx1 = t.find("MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;")
    idx2 = t.find("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;", idx1+1)
    # Actually second block not yet created, so find the second occurrence of long attackingArmy
    # Simpler: region1 is from first guard to second guard (which hasn't been created yet, so search for second block's old pattern)
    # Let's just replace the first block's tail: from after new_block1 to the next "                            for (o = 0; o < this.currentMoveUnits"
    # The first block has: for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) { updateMoveTime }
    # That should be curMoveUnits
    region_start = t.find("MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;")
    region_end = t.find("                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o)", region_start)
    if region_end != -1:
        # This is the second for loop in first block (updateMoveTime)
        # Replace it
        old_for = "                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {\n                                this.currentMoveUnits.getMoveUnits(o).getMoveUnits_Line().updateMoveTime();"
        new_for = "                            for (o = 0; o < curMoveUnits.getMoveUnitsSize(); ++o) {\n                                curMoveUnits.getMoveUnits(o).getMoveUnits_Line().updateMoveTime();"
        if old_for in t:
            t = t.replace(old_for, new_for, 1)
            print("6a first block second for fixed")
    # Fix the SAVE_REPORT and subsequent this.currentMoveUnits in first block
    # From after that for to "                        this.turnMoves_MoveCurrentArmy();"
    # Let's do a limited region replace: from first guard to the first "                        this.turnMoves_MoveCurrentArmy();"
    idx_guard1 = t.find("MoveUnits_TurnData curMoveUnits = this.currentMoveUnits;")
    idx_end1 = t.find("                        this.turnMoves_MoveCurrentArmy();", idx_guard1)
    if idx_guard1 != -1 and idx_end1 != -1:
        region = t[idx_guard1:idx_end1]
        fixed = region.replace("this.currentMoveUnits.", "curMoveUnits.")
        # Keep the field write this.currentMoveUnits = null intact
        fixed = fixed.replace("curMoveUnits = null;", "this.currentMoveUnits = null;")
        t = t[:idx_guard1] + fixed + t[idx_end1:]
        print(f"6a first block tail fixed, {region.count('this.currentMoveUnits.')} occurrences")
else:
    print("6a first block NOT FOUND")

# Second block
old_block2 = """                            long attackingArmy = 0L;
                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                                attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                            }
                        long required;"""
new_block2 = """                            MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;
                            if (curMoveUnits2 == null) {
                                continue;
                            }
                            long attackingArmy = 0L;
                            for (o = 0; o < curMoveUnits2.getMoveUnitsSize(); ++o) {
                                attackingArmy += curMoveUnits2.getMoveUnits(o).getNumberOfUnits();
                            }
                        long required;"""
if old_block2 in t:
    t = t.replace(old_block2, new_block2, 1)
    print("6b second block snapshot done")
    # Fix second block's tail: from after guard to civE.removeMove
    idx_g2 = t.find("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;")
    idx_end2 = t.find("                     }\n                     civE.removeMove(i--);", idx_g2)
    if idx_g2 != -1 and idx_end2 != -1:
        region2 = t[idx_g2:idx_end2]
        fixed2 = region2.replace("this.currentMoveUnits.", "curMoveUnits2.")
        fixed2 = fixed2.replace("curMoveUnits2 = null;", "this.currentMoveUnits = null;")
        t = t[:idx_g2] + fixed2 + t[idx_end2:]
        print(f"6b second block tail fixed, {region2.count('this.currentMoveUnits.')} occurrences")
else:
    print("6b second block NOT FOUND")

p.write_text(t, encoding='utf-8')
print("all done")
print(f"final count this.currentMoveUnits. in turnMoves: {t[t.find('    public final void turnMoves() {'):t.find('        catch (Exception exr) {', t.find('    public final void turnMoves() {'))].count('this.currentMoveUnits.')}")
