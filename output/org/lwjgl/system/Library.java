/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryLoader;

public final class Library {
    public static final String JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
    static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final Pattern PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
    private static final Pattern NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");

    private Library() {
    }

    public static void initialize() {
    }

    public static void loadSystem(String module, String name) throws UnsatisfiedLinkError {
        Library.loadSystem(System::load, System::loadLibrary, Library.class, module, name);
    }

    public static void loadSystem(Consumer<String> load, Consumer<String> loadLibrary, Class<?> context, String module, String name) throws UnsatisfiedLinkError {
        boolean bundledWithLWJGL;
        String libName;
        block28: {
            APIUtil.apiLog("Loading JNI library: " + name);
            APIUtil.apiLog("\tModule: " + module);
            if (Paths.get(name, new String[0]).isAbsolute()) {
                load.accept(name);
                APIUtil.apiLog("\tSuccess");
                return;
            }
            libName = Platform.get().mapLibraryName(name);
            URL libURL = Library.findResource(context, module, libName, bundledWithLWJGL = name.contains("lwjgl"));
            if (libURL == null) {
                if (Library.loadSystemFromLibraryPath(load, context, module, libName, bundledWithLWJGL)) {
                    return;
                }
            } else {
                boolean debugLoader = Configuration.DEBUG_LOADER.get(false);
                try {
                    String regular = Library.getRegularFilePath(libURL);
                    if (regular != null) {
                        load.accept(regular);
                        APIUtil.apiLog("\tLoaded from classpath: " + regular);
                        return;
                    }
                    if (debugLoader) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel ignored = SharedLibraryLoader.load(name, libName, libURL);){
                        if (Library.loadSystemFromLibraryPath(load, context, module, libName, bundledWithLWJGL)) {
                            return;
                        }
                    }
                }
                catch (Exception e) {
                    if (!debugLoader) break block28;
                    e.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        String javaLibraryPath = System.getProperty(JAVA_LIBRARY_PATH);
        if (bundledWithLWJGL && javaLibraryPath != null && Library.loadSystem(load, context, module, Library.getBundledPath(module, libName), false, JAVA_LIBRARY_PATH, javaLibraryPath)) {
            return;
        }
        try {
            Path libFile;
            loadLibrary.accept(name);
            Path path = libFile = javaLibraryPath == null ? null : Library.findFile(javaLibraryPath, module, libName, bundledWithLWJGL);
            if (libFile != null) {
                APIUtil.apiLog(String.format("\tLoaded from %s: %s", JAVA_LIBRARY_PATH, libFile));
                Library.checkHash(context, libFile);
            } else {
                APIUtil.apiLog("\tLoaded from a ClassLoader provided path.");
            }
            return;
        }
        catch (Throwable t) {
            APIUtil.apiLog(String.format("\t%s not found in %s", libName, JAVA_LIBRARY_PATH));
            Library.printError(true);
            throw new UnsatisfiedLinkError("Failed to locate library: " + libName);
        }
    }

    private static boolean loadSystemFromLibraryPath(Consumer<String> load, Class<?> context, String module, String libName, boolean bundledWithLWJGL) {
        String paths = Configuration.LIBRARY_PATH.get();
        return paths != null && Library.loadSystem(load, context, module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths);
    }

    private static boolean loadSystem(Consumer<String> load, Class<?> context, String module, String libName, boolean bundledWithLWJGL, String property, String paths) {
        Path libFile = Library.findFile(paths, module, libName, bundledWithLWJGL);
        if (libFile == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", libName, property, paths));
            return false;
        }
        load.accept(libFile.toAbsolutePath().toString());
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", property, libFile));
        Library.checkHash(context, libFile);
        return true;
    }

    public static SharedLibrary loadNative(String module, String name) {
        return Library.loadNative(Library.class, module, name);
    }

    public static SharedLibrary loadNative(Class<?> context, String module, String name) {
        return Library.loadNative(context, module, name, false);
    }

    public static SharedLibrary loadNative(Class<?> context, String module, String name, boolean bundledWithLWJGL) {
        return Library.loadNative(context, module, name, bundledWithLWJGL, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SharedLibrary loadNative(Class<?> context, String module, String name, boolean bundledWithLWJGL, boolean printError) {
        String paths;
        SharedLibrary lib;
        String libName;
        block30: {
            APIUtil.apiLog("Loading library: " + name);
            APIUtil.apiLog("\tModule: " + module);
            if (Paths.get(name, new String[0]).isAbsolute()) {
                SharedLibrary lib2 = APIUtil.apiCreateLibrary(name);
                APIUtil.apiLog("\tSuccess");
                return lib2;
            }
            libName = Platform.get().mapLibraryName(name);
            URL libURL = Library.findResource(context, module, libName, bundledWithLWJGL);
            if (libURL == null) {
                lib = Library.loadNativeFromLibraryPath(context, module, libName, bundledWithLWJGL);
                if (lib != null) {
                    return lib;
                }
            } else {
                boolean debugLoader = Configuration.DEBUG_LOADER.get(false);
                try {
                    String regular = Library.getRegularFilePath(libURL);
                    if (regular != null) {
                        SharedLibrary lib3 = APIUtil.apiCreateLibrary(regular);
                        APIUtil.apiLog("\tLoaded from classpath: " + regular);
                        return lib3;
                    }
                    if (debugLoader) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel ignored = SharedLibraryLoader.load(name, libName, libURL);){
                        lib = Library.loadNativeFromLibraryPath(context, module, libName, bundledWithLWJGL);
                        if (lib != null) {
                            SharedLibrary sharedLibrary = lib;
                            return sharedLibrary;
                        }
                    }
                }
                catch (Exception e) {
                    if (!debugLoader) break block30;
                    e.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if (!bundledWithLWJGL && (lib = Library.loadNativeFromSystem(libName)) != null) {
            return lib;
        }
        if (Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(false).booleanValue()) {
            try {
                Method findLibrary = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                findLibrary.setAccessible(true);
                String libPath = (String)findLibrary.invoke((Object)context.getClassLoader(), name);
                if (libPath != null) {
                    lib = APIUtil.apiCreateLibrary(libPath);
                    APIUtil.apiLog(String.format("\tLoaded from ClassLoader provided path: %s", libPath));
                    return lib;
                }
            }
            catch (Exception findLibrary) {
                // empty catch block
            }
        }
        if ((paths = System.getProperty(JAVA_LIBRARY_PATH)) != null && (lib = Library.loadNative(context, module, libName, bundledWithLWJGL, JAVA_LIBRARY_PATH, paths)) != null) {
            return lib;
        }
        if (bundledWithLWJGL && (lib = Library.loadNativeFromSystem(libName)) != null) {
            return lib;
        }
        if (!printError) throw new UnsatisfiedLinkError("Failed to locate library: " + libName);
        Library.printError(bundledWithLWJGL);
        throw new UnsatisfiedLinkError("Failed to locate library: " + libName);
    }

    @Nullable
    private static SharedLibrary loadNativeFromSystem(String libName) {
        SharedLibrary lib;
        try {
            lib = APIUtil.apiCreateLibrary(libName);
            String path = lib.getPath();
            APIUtil.apiLog(path == null ? "\tLoaded from system paths" : "\tLoaded from system paths: " + path);
        }
        catch (UnsatisfiedLinkError e) {
            lib = null;
            APIUtil.apiLog(String.format("\t%s not found in system paths", libName));
        }
        return lib;
    }

    @Nullable
    private static SharedLibrary loadNativeFromLibraryPath(Class<?> context, String module, String libName, boolean bundledWithLWJGL) {
        String paths = Configuration.LIBRARY_PATH.get();
        if (paths == null) {
            return null;
        }
        return Library.loadNative(context, module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths);
    }

    @Nullable
    private static SharedLibrary loadNative(Class<?> context, String module, String libName, boolean bundledWithLWJGL, String property, String paths) {
        Path libFile = Library.findFile(paths, module, libName, bundledWithLWJGL);
        if (libFile == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", libName, property, paths));
            return null;
        }
        SharedLibrary lib = APIUtil.apiCreateLibrary(libFile.toAbsolutePath().toString());
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", property, libFile));
        Library.checkHash(context, libFile);
        return lib;
    }

    public static SharedLibrary loadNative(Class<?> context, String module, @Nullable Configuration<String> name, String ... defaultNames) {
        return Library.loadNative(context, module, name, null, defaultNames);
    }

    public static SharedLibrary loadNative(Class<?> context, String module, @Nullable Configuration<String> name, @Nullable Supplier<SharedLibrary> fallback, String ... defaultNames) {
        String libraryName;
        if (defaultNames.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        if (name != null && (libraryName = name.get()) != null) {
            return Library.loadNative(context, module, libraryName);
        }
        if (fallback == null && defaultNames.length <= 1) {
            return Library.loadNative(context, module, defaultNames[0]);
        }
        try {
            return Library.loadNative(context, module, defaultNames[0], false, false);
        }
        catch (Throwable t) {
            for (int i = 1; i < defaultNames.length; ++i) {
                try {
                    return Library.loadNative(context, module, defaultNames[i], false, fallback == null && i == defaultNames.length - 1);
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

    private static String getBundledPath(String module, String resource) {
        return Platform.mapLibraryPathBundled(module.replace('.', '/') + "/" + resource);
    }

    @Nullable
    static URL findResource(Class<?> context, String module, String resource, boolean bundledWithLWJGL) {
        String bundledResource;
        URL url = null;
        if (bundledWithLWJGL && !(bundledResource = Library.getBundledPath(module, resource)).equals(resource)) {
            url = context.getClassLoader().getResource(bundledResource);
        }
        return url == null ? context.getClassLoader().getResource(resource) : url;
    }

    @Nullable
    static String getRegularFilePath(URL url) {
        if (url.getProtocol().equals("file")) {
            try {
                Path path = Paths.get(url.toURI());
                if (path.isAbsolute() && Files.isReadable(path)) {
                    return path.toString();
                }
            }
            catch (URISyntaxException uRISyntaxException) {
                // empty catch block
            }
        }
        return null;
    }

    @Nullable
    static Path findFile(String path, String module, String file, boolean bundledWithLWJGL) {
        Path p;
        String bundledFile;
        if (bundledWithLWJGL && !(bundledFile = Library.getBundledPath(module, file)).equals(file) && (p = Library.findFile(path, bundledFile)) != null) {
            return p;
        }
        return Library.findFile(path, file);
    }

    @Nullable
    private static Path findFile(String path, String file) {
        for (String directory : PATH_SEPARATOR.split(path)) {
            Path p = Paths.get(directory, file);
            if (!Files.isReadable(p)) continue;
            return p;
        }
        return null;
    }

    private static void printError(boolean bundledWithLWJGL) {
        Library.printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (bundledWithLWJGL ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
    }

    static void printError(String message) {
        APIUtil.DEBUG_STREAM.println(message);
        if (!Checks.DEBUG) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.");
            if (!Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                APIUtil.DEBUG_STREAM.println("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.");
            }
        }
    }

    private static void checkHash(Class<?> context, Path libFile) {
        block7: {
            if (!Checks.CHECKS) {
                return;
            }
            try {
                byte[] actual;
                URL classesURL = null;
                URL nativesURL = null;
                Enumeration<URL> resources = context.getClassLoader().getResources(libFile.getFileName() + ".sha1");
                while (resources.hasMoreElements()) {
                    URL url = resources.nextElement();
                    if (NATIVES_JAR.matcher(url.toExternalForm()).find()) {
                        nativesURL = url;
                        continue;
                    }
                    classesURL = url;
                }
                if (classesURL == null) {
                    return;
                }
                byte[] expected = Library.getSHA1(classesURL);
                byte[] byArray = actual = Checks.DEBUG || nativesURL == null ? Library.getSHA1(libFile) : Library.getSHA1(nativesURL);
                if (!Arrays.equals(expected, actual)) {
                    APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
                }
            }
            catch (Throwable t) {
                if (!Checks.DEBUG) break block7;
                APIUtil.apiLog("Failed to verify native library.");
                t.printStackTrace();
            }
        }
    }

    private static byte[] getSHA1(URL hashURL) throws IOException {
        byte[] hash = new byte[20];
        try (InputStream sha1 = hashURL.openStream();){
            for (int i = 0; i < 20; ++i) {
                hash[i] = (byte)(Character.digit(sha1.read(), 16) << 4 | Character.digit(sha1.read(), 16));
            }
        }
        return hash;
    }

    private static byte[] getSHA1(Path libFile) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        try (InputStream input = Files.newInputStream(libFile, new OpenOption[0]);){
            int n;
            byte[] buffer = new byte[8192];
            while ((n = input.read(buffer)) != -1) {
                digest.update(buffer, 0, n);
            }
        }
        return digest.digest();
    }

    static {
        if (Checks.DEBUG) {
            APIUtil.apiLog("Version: " + Version.getVersion());
            APIUtil.apiLog("\t OS: " + System.getProperty("os.name") + " v" + System.getProperty("os.version"));
            APIUtil.apiLog("\tJRE: " + System.getProperty("java.version") + " " + System.getProperty("os.arch"));
            APIUtil.apiLog("\tJVM: " + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor"));
        }
        Library.loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
    }
}

