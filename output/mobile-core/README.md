# Mobile Runtime Boundary

`mobile-core` is the Android-facing runtime capsule. It reuses the original game and save-model sources without depending on the desktop `core` artifact.

The module deliberately excludes:

- desktop Steam initialization and callbacks;
- Steam-backed workshop, stats, friends, and remote-storage types;
- the desktop and shared legacy launchers;
- legacy permanent turn-thread implementations;
- LWJGL, JLayer, Box2D, and desktop native libraries.

Mobile replacements under `src/main/java` provide deterministic local/no-service behavior for optional desktop platform features. Android owns its application listener, lifecycle ordering, bounded worker policy, backend, and native ABI dependencies.

The original simulation, save DTO package names, menus, and libGDX drawing implementation remain shared so existing assets and serialized data keep their identities. On Android, drawing is executed only by the Android GLES backend; no desktop rendering backend is on the mobile dependency path.
