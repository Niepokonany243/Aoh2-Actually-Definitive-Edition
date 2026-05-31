/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.MacOSXLibraryBundle;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

public abstract class MacOSXLibrary
extends SharedLibrary.Default {
    protected MacOSXLibrary(String name, long handle) {
        super(name, handle);
    }

    public static MacOSXLibrary getWithIdentifier(String bundleID) {
        APIUtil.apiLog("Loading library: " + bundleID);
        MacOSXLibraryBundle lib = MacOSXLibraryBundle.getWithIdentifier(bundleID);
        APIUtil.apiLog("\tSuccess");
        return lib;
    }

    public static MacOSXLibrary create(String name) {
        return name.endsWith(".framework") ? MacOSXLibraryBundle.create(name) : new MacOSXLibraryDL(name);
    }
}

