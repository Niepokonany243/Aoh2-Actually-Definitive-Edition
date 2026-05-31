/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;

final class SharedLibraryLoader {
    private static final Lock EXTRACT_PATH_LOCK = new ReentrantLock();
    @Nullable
    @GuardedBy(value="EXTRACT_PATH_LOCK")
    private static Path extractPath;

    private SharedLibraryLoader() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static FileChannel load(String name, String filename, URL resource) {
        try {
            Path extractedFile;
            EXTRACT_PATH_LOCK.lock();
            try {
                if (extractPath != null) {
                    extractedFile = extractPath.resolve(filename);
                } else {
                    extractedFile = SharedLibraryLoader.getExtractPath(filename, resource);
                    if (Platform.get() != Platform.WINDOWS || SharedLibraryLoader.workaroundJDK8195129(extractedFile)) {
                        extractPath = extractedFile.getParent();
                        SharedLibraryLoader.initExtractPath(extractPath);
                    }
                }
            }
            finally {
                EXTRACT_PATH_LOCK.unlock();
            }
            return SharedLibraryLoader.extract(extractedFile, resource);
        }
        catch (Exception e) {
            throw new RuntimeException("\tFailed to extract " + name + " library", e);
        }
    }

    private static void initExtractPath(Path extractPath) {
        String newLibPath = extractPath.toAbsolutePath().toString();
        String libPath = Configuration.LIBRARY_PATH.get();
        if (libPath != null && !libPath.isEmpty()) {
            newLibPath = newLibPath + File.pathSeparator + libPath;
        }
        System.setProperty(Configuration.LIBRARY_PATH.getProperty(), newLibPath);
        Configuration.LIBRARY_PATH.set(newLibPath);
    }

    private static Path getExtractPath(String filename, URL resource) {
        Path file;
        String override = Configuration.SHARED_LIBRARY_EXTRACT_PATH.get();
        if (override != null) {
            return Paths.get(override, filename);
        }
        String version = Version.getVersion().replace(' ', '-');
        Path tempDirectory = Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl" + System.getProperty("user.name")), version, filename);
        Path root = Paths.get(System.getProperty("java.io.tmpdir"), new String[0]);
        if (SharedLibraryLoader.canWrite(root, file = root.resolve(tempDirectory), resource)) {
            return file;
        }
        tempDirectory = Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl"), version, filename);
        root = Paths.get(System.getProperty("user.home"), new String[0]);
        if (SharedLibraryLoader.canWrite(root, file = root.resolve(tempDirectory), resource)) {
            return file;
        }
        root = Paths.get("", new String[0]).toAbsolutePath();
        if (SharedLibraryLoader.canWrite(root, file = root.resolve(tempDirectory), resource)) {
            return file;
        }
        if (Platform.get() == Platform.WINDOWS) {
            String env = System.getenv("SystemRoot");
            if (env != null && SharedLibraryLoader.canWrite(root = Paths.get(env, "Temp"), file = root.resolve(tempDirectory), resource)) {
                return file;
            }
            env = System.getenv("SystemDrive");
            if (env != null && SharedLibraryLoader.canWrite(root = Paths.get(env + "/", new String[0]), file = root.resolve(Paths.get("Temp", new String[0]).resolve(tempDirectory)), resource)) {
                return file;
            }
        }
        try {
            file = Files.createTempDirectory("lwjgl", new FileAttribute[0]);
            root = file.getParent();
            file = file.resolve(filename);
            if (SharedLibraryLoader.canWrite(root, file, resource)) {
                return file;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        throw new RuntimeException("Failed to find an appropriate directory to extract the native library");
    }

    private static FileChannel extract(Path file, URL resource) throws IOException {
        Throwable throwable;
        InputStream source;
        if (Files.exists(file, new LinkOption[0])) {
            source = resource.openStream();
            throwable = null;
            try (InputStream target = Files.newInputStream(file, new OpenOption[0]);){
                if (SharedLibraryLoader.crc(source) == SharedLibraryLoader.crc(target)) {
                    if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                        APIUtil.apiLog(String.format("\tFound at: %s", file));
                    }
                    FileChannel fileChannel = SharedLibraryLoader.lock(file);
                    return fileChannel;
                }
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                if (source != null) {
                    if (throwable != null) {
                        try {
                            source.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    } else {
                        source.close();
                    }
                }
            }
        }
        APIUtil.apiLog(String.format("    Extracting: %s", resource.getPath()));
        if (extractPath == null) {
            APIUtil.apiLog(String.format("            to: %s", file));
        }
        Files.createDirectories(file.getParent(), new FileAttribute[0]);
        source = resource.openStream();
        throwable = null;
        try {
            Files.copy(source, file, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Throwable throwable4) {
            throwable = throwable4;
            throw throwable4;
        }
        finally {
            if (source != null) {
                if (throwable != null) {
                    try {
                        source.close();
                    }
                    catch (Throwable throwable5) {
                        throwable.addSuppressed(throwable5);
                    }
                } else {
                    source.close();
                }
            }
        }
        return SharedLibraryLoader.lock(file);
    }

    private static FileChannel lock(Path file) {
        try {
            FileChannel fc = FileChannel.open(file, new OpenOption[0]);
            if (fc.tryLock(0L, Long.MAX_VALUE, true) == null) {
                if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                    APIUtil.apiLog("\tFile is locked by another process, waiting...");
                }
                fc.lock(0L, Long.MAX_VALUE, true);
            }
            return fc;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to lock file.", e);
        }
    }

    private static long crc(InputStream input) throws IOException {
        int n;
        CRC32 crc = new CRC32();
        byte[] buffer = new byte[8192];
        while ((n = input.read(buffer)) != -1) {
            crc.update(buffer, 0, n);
        }
        return crc.getValue();
    }

    private static boolean canWrite(Path root, Path file, URL resource) {
        Path testFile;
        if (Files.exists(file, new LinkOption[0])) {
            if (!Files.isWritable(file)) {
                return false;
            }
            testFile = file.getParent().resolve(".lwjgl.test");
        } else {
            try {
                Files.createDirectories(file.getParent(), new FileAttribute[0]);
            }
            catch (IOException ignored) {
                return false;
            }
            testFile = file;
        }
        try {
            Files.write(testFile, new byte[0], new OpenOption[0]);
            Files.delete(testFile);
            if (SharedLibraryLoader.workaroundJDK8195129(file)) {
                try (FileChannel ignored = SharedLibraryLoader.extract(file, resource);){
                    System.load(file.toAbsolutePath().toString());
                }
            }
            return true;
        }
        catch (Throwable ignored) {
            if (file == testFile) {
                SharedLibraryLoader.canWriteCleanup(root, file);
            }
            return false;
        }
    }

    private static void canWriteCleanup(Path root, Path file) {
        try {
            Files.deleteIfExists(file);
            Path parent = file.getParent();
            while (!Files.isSameFile(parent, root)) {
                block17: {
                    try (Stream<Path> dir = Files.list(parent);){
                        if (!dir.findAny().isPresent()) break block17;
                        break;
                    }
                }
                Files.delete(parent);
                parent = parent.getParent();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private static boolean workaroundJDK8195129(Path file) {
        return Platform.get() == Platform.WINDOWS && file.toString().endsWith(".dll");
    }
}

