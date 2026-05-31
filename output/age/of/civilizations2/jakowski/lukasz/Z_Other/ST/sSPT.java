/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other.ST;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

public class sSPT
extends Thread {
    public static String key;

    @Override
    public void run() {
        sUM.createItem(key);
    }
}

