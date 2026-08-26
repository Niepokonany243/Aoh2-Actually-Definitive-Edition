import pathlib
p = pathlib.Path(r'E:\SteamLibrary\steamapps\common\Aoh2 Actually Definitive Edition\output\age\of\civilizations2\jakowski\lukasz\GameAction.java')
t = p.read_text(encoding='utf-8')
old = 'private MoveUnits_TurnData currentMoveUnits = null;'
new = 'private volatile MoveUnits_TurnData currentMoveUnits = null;'
if old in t:
    t = t.replace(old, new, 1)
    print('volatile added')
else:
    print('volatile not found')
c1 = t.count('int attackingArmy = 0;')
print(f'found int attackingArmy: {c1}')
t = t.replace('                        int attackingArmy = 0;', '                        long attackingArmy = 0L;')
t = t.replace('                            int attackingArmy = 0;', '                            long attackingArmy = 0L;')
print(f'after long count: {t.count("long attackingArmy = 0L;")}')
# Also fix the second loop's long required comparison already handled, but also need to handle if attackingArmy compared to int MIN - now long vs int is fine
p.write_text(t, encoding='utf-8')
print('done')
