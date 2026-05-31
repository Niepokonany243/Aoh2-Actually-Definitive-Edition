/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.function.Function;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;

public enum Platform {
    LINUX("Linux", "linux"){
        private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");

        @Override
        String mapLibraryName(String name) {
            if (this.SO.matcher(name).find()) {
                return name;
            }
            return System.mapLibraryName(name);
        }
    }
    ,
    MACOSX("macOS", "macos"){
        private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");

        @Override
        String mapLibraryName(String name) {
            if (this.DYLIB.matcher(name).find()) {
                return name;
            }
            return System.mapLibraryName(name);
        }
    }
    ,
    WINDOWS("Windows", "windows"){

        @Override
        String mapLibraryName(String name) {
            if (name.endsWith(".dll")) {
                return name;
            }
            return System.mapLibraryName(name);
        }
    };

    private static final Platform current;
    private static final Function<String, String> bundledLibraryNameMapper;
    private static final Function<String, String> bundledLibraryPathMapper;
    private final String name;
    private final String nativePath;

    private Platform(String name, String nativePath) {
        this.name = name;
        this.nativePath = nativePath;
    }

    public String getName() {
        return this.name;
    }

    abstract String mapLibraryName(String var1);

    public static Platform get() {
        return current;
    }

    public static Architecture getArchitecture() {
        return Architecture.current;
    }

    public static String mapLibraryNameBundled(String name) {
        return bundledLibraryNameMapper.apply(name);
    }

    static String mapLibraryPathBundled(String name) {
        return bundledLibraryPathMapper.apply(name);
    }

    private static Function<String, String> getMapper(@Nullable Object mapper, Function<String, String> defaultMapper, Function<String, String> legacyMapper) {
        if (mapper == null || "default".equals(mapper)) {
            return defaultMapper;
        }
        if ("legacy".equals(mapper)) {
            return legacyMapper;
        }
        if (mapper instanceof Function) {
            return (Function)mapper;
        }
        String className = mapper.toString();
        try {
            return (Function)Class.forName(className).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Throwable t) {
            if (Checks.DEBUG) {
                t.printStackTrace(APIUtil.DEBUG_STREAM);
            }
            APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", className));
            return defaultMapper;
        }
    }

    static {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            current = WINDOWS;
        } else if (osName.startsWith("Linux") || osName.startsWith("FreeBSD") || osName.startsWith("SunOS") || osName.startsWith("Unix")) {
            current = LINUX;
        } else if (osName.startsWith("Mac OS X") || osName.startsWith("Darwin")) {
            current = MACOSX;
        } else {
            throw new LinkageError("Unknown platform: " + osName);
        }
        bundledLibraryNameMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER.get("default"), name -> name, name -> Architecture.current.is64Bit ? name : name + "32");
        bundledLibraryPathMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER.get("default"), name -> Platform.current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + name, name -> name.substring(name.lastIndexOf(47)));
    }

    public static final class Architecture
    extends Enum<Architecture> {
        public static final /* enum */ Architecture X64;
        public static final /* enum */ Architecture X86;
        public static final /* enum */ Architecture ARM64;
        public static final /* enum */ Architecture ARM32;
        static final Architecture current;
        final boolean is64Bit;
        private static final /* synthetic */ Architecture[] $VALUES;

        public static Architecture[] values() {
            return (Architecture[])$VALUES.clone();
        }

        public static Architecture valueOf(String name) {
            return Enum.valueOf(Architecture.class, name);
        }

        private Architecture(boolean is64Bit) {
            this.is64Bit = is64Bit;
        }

        static {
            boolean is64Bit;
            X64 = new Architecture(true);
            X86 = new Architecture(false);
            ARM64 = new Architecture(true);
            ARM32 = new Architecture(false);
            $VALUES = new Architecture[]{X64, X86, ARM64, ARM32};
            String osArch = System.getProperty("os.arch");
            boolean bl = is64Bit = osArch.contains("64") || osArch.startsWith("armv8");
            current = osArch.startsWith("arm") || osArch.startsWith("aarch64") ? (is64Bit ? ARM64 : ARM32) : (is64Bit ? X64 : X86);
        }
    }
}

