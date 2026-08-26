import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
second_idx = t.find("MoveUnits_TurnData curMoveUnits2 = this.currentMoveUnits;")
# Find end of second block: the line "                     }\n                     civE.removeMove(i--);" that closes the for(i) loop of second block
# Search from second_idx for that pattern
end_marker = "                     }\n                     civE.removeMove(i--);"
# There are two such markers (first block and second), need the one after second_idx
first_end = t.find(end_marker)
second_end = t.find(end_marker, second_idx)
if second_end == -1:
    second_end = t.find("                GameManager.processAIGenocide", second_idx)
print(f"first_end {first_end}, second_end {second_end}, second_idx {second_idx}")
region2 = t[second_idx:second_end+len(end_marker)]
print(f"region2 length {len(region2)}, this.currentMoveUnits count {region2.count('this.currentMoveUnits.')}")
# Replace this.currentMoveUnits. with curMoveUnits2. within region2, but keep field writes
fixed2 = region2.replace("this.currentMoveUnits.", "curMoveUnits2.")
fixed2 = fixed2.replace("curMoveUnits2 = null;", "this.currentMoveUnits = null;")
# The guard already is curMoveUnits2, so no change there
t = t[:second_idx] + fixed2 + t[second_end+len(end_marker):]
print(f"fixed second block, replaced {region2.count('this.currentMoveUnits.')} occurrences")
p.write_text(t, encoding='utf-8')
print("done")
# Verify
t2 = p.read_text(encoding='utf-8')
# Count remaining this.currentMoveUnits. in turnMoves method (between turnMoves start and catch)
# Find turnMoves method
start = t2.find("    public final void turnMoves() {")
end = t2.find("        catch (Exception exr) {", start)
region = t2[start:end]
print(f"remaining this.currentMoveUnits. in turnMoves: {region.count('this.currentMoveUnits.')}")
print(f"curMoveUnits in turnMoves: {region.count('curMoveUnits')}")
