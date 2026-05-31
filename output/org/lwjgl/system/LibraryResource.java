/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Library;
import org.lwjgl.system.SharedLibraryLoader;

public final class LibraryResource {
    private LibraryResource() {
    }

    public static Path load(String module, String name) {
        return LibraryResource.load(LibraryResource.class, module, name);
    }

    public static Path load(Class<?> context, String module, String name) {
        return LibraryResource.load(context, module, name, false, true);
    }

    public static Path load(Class<?> context, String module, String name, boolean bundledWithLWJGL) {
        return LibraryResource.load(context, module, name, bundledWithLWJGL, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Path load(Class<?> context, String module, String name, boolean bundledWithLWJGL, boolean printError) {
        String paths;
        Path path;
        block25: {
            APIUtil.apiLog("Loading library resource: " + name);
            APIUtil.apiLog("\tModule: " + module);
            path = Paths.get(name, new String[0]);
            if (path.isAbsolute()) {
                if (!Files.exists(path, new LinkOption[0])) {
                    if (!printError) throw new IllegalStateException("Failed to locate library resource: " + name);
                    LibraryResource.printError();
                    throw new IllegalStateException("Failed to locate library resource: " + name);
                }
                APIUtil.apiLog("\tSuccess");
                return path;
            }
            URL resourceURL = Library.findResource(context, module, name, bundledWithLWJGL);
            if (resourceURL == null) {
                path = LibraryResource.loadFromLibraryPath(module, name, bundledWithLWJGL);
                if (path != null) {
                    return path;
                }
            } else {
                boolean debugLoader = Configuration.DEBUG_LOADER.get(false);
                try {
                    String regular = Library.getRegularFilePath(resourceURL);
                    if (regular != null) {
                        APIUtil.apiLog("\tLoaded from classpath: " + regular);
                        return Paths.get(regular, new String[0]);
                    }
                    if (debugLoader) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel ignored = SharedLibraryLoader.load(name, name, resourceURL);){
                        path = LibraryResource.loadFromLibraryPath(module, name, bundledWithLWJGL);
                        if (path != null) {
                            Path path2 = path;
                            return path2;
                        }
                    }
                }
                catch (Exception e) {
                    if (!debugLoader) break block25;
                    e.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if ((paths = System.getProperty("java.library.path")) != null && (path = LibraryResource.load(module, name, bundledWithLWJGL, "java.library.path", paths)) != null) {
            return path;
        }
        if (!printError) throw new IllegalStateException("Failed to locate library resource: " + name);
        LibraryResource.printError();
        throw new IllegalStateException("Failed to locate library resource: " + name);
    }

    @Nullable
    private static Path loadFromLibraryPath(String module, String libName, boolean bundledWithLWJGL) {
        String paths = Configuration.LIBRARY_PATH.get();
        if (paths == null) {
            return null;
        }
        return LibraryResource.load(module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths);
    }

    @Nullable
    private static Path load(String module, String name, boolean bundledWithLWJGL, String property, String paths) {
        Path resource = Library.findFile(paths, module, name, bundledWithLWJGL);
        if (resource == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", name, property, paths));
            return null;
        }
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", property, resource));
        return resource;
    }

    public static Path load(Class<?> context, String module, Configuration<String> name, String ... defaultNames) {
        return LibraryResource.load(context, module, name, null, defaultNames);
    }

    public static Path load(Class<?> context, String module, Configuration<String> name, @Nullable Supplier<Path> fallback, String ... defaultNames) {
        if (defaultNames.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        String resourceName = name.get();
        if (resourceName != null) {
            return LibraryResource.load(context, module, resourceName);
        }
        if (fallback == null && defaultNames.length <= 1) {
            return LibraryResource.load(context, module, defaultNames[0]);
        }
        try {
            return LibraryResource.load(context, module, defaultNames[0], false, false);
        }
        catch (Throwable t) {
            for (int i = 1; i < defaultNames.length; ++i) {
                try {
                    return LibraryResource.load(context, module, defaultNames[i], false, fallback == null && i == defaultNames.length - 1);
                }
                catch (Throwable throwable) {
                    continue;
                }
            }
            if (fallback != null) {
                return fallback.get();
            }
            throw t;
        }
    }

    private static void printError() {
        Library.printError("[LWJGL] Failed to load a library resource. Possible solutions:\n\ta) Add the directory that contains the resource to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the resource to the classpath.");
    }

    static {
        Library.initialize();
    }
}

