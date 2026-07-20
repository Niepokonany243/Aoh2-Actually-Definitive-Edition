package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

/** Mobile platform entry point. Desktop services are intentionally unavailable. */
public final class Platform {
    private Platform() {
    }

    public static void init() {
        sUM.loadSubscribedItems();
    }

    public static void shutdown() {
    }

    public static int getValue(String key) {
        return 0;
    }

    public static Object getContext() {
        return null;
    }

    public static void store() {
    }
}
