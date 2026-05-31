
package age.of.civilizations2.jakowski.lukasz.Files;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.nio.ByteBuffer;

public class FileManager {
    public static LoadInterface loadInterface;
    public static boolean IS_MAC;

    public static FileHandle getSaveType(String sFile) {
        return loadInterface.getSaveType(sFile);
    }

    public static void initLoadInterface() {
        loadInterface = CFG.getIsDesktop() ? (IS_MAC ? new LoadInterface(){

            @Override
            public FileHandle loadFile(String sFile) {
                int i;
                for (i = 0; i < sUM.sUFS; ++i) {
                    if (Gdx.files.external(sUM.sUF.get(i) + sFile).exists()) {
                        return Gdx.files.external(sUM.sUF.get(i) + sFile);
                    }
                    if (!Gdx.files.internal(sUM.sUF.get(i) + sFile).exists()) continue;
                    return Gdx.files.internal(sUM.sUF.get(i) + sFile);
                }
                for (i = 0; i < sUM.sUIIS; ++i) {
                    if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile).exists()) continue;
                    return Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile);
                }
                if (Gdx.files.external(sFile).exists()) {
                    return Gdx.files.external(sFile);
                }
                return Gdx.files.internal(sFile);
            }

            @Override
            public FileHandle getSaveType(String sFile) {
                return Gdx.files.external(sFile);
            }
        } : new LoadInterface(){

            @Override
            public FileHandle loadFile(String sFile) {
                int i;
                for (i = 0; i < sUM.sUFS; ++i) {
                    if (!Gdx.files.internal(sUM.sUF.get(i) + sFile).exists()) continue;
                    return Gdx.files.internal(sUM.sUF.get(i) + sFile);
                }
                for (i = 0; i < sUM.sUIIS; ++i) {
                    if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile).exists()) continue;
                    return Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + sFile);
                }
                if (Gdx.files.local(sFile).exists()) {
                    return Gdx.files.local(sFile);
                }
                if (Gdx.files.internal(sFile).exists()) {
                    return Gdx.files.internal(sFile);
                }
                return Gdx.files.internal(sFile);
            }

            @Override
            public FileHandle getSaveType(String sFile) {
                return Gdx.files.local(sFile);
            }
        }) : new LoadInterface(){

            @Override
            public FileHandle loadFile(String sFile) {
                if (Gdx.files.local(sFile).exists()) {
                    return Gdx.files.local(sFile);
                }
                return Gdx.files.internal(sFile);
            }

            @Override
            public FileHandle getSaveType(String sFile) {
                return Gdx.files.local(sFile);
            }
        };
    }

    public static FileHandle loadFile(String sFile) {
        return loadInterface.loadFile(sFile);
    }

    public boolean saveFile(String name, ByteBuffer data) {
        try {
            return sUM.sUR.fileWrite(name, data);
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int loadFile(String name, ByteBuffer buffer) {
        try {
            return sUM.sUR.fileRead(name, buffer);
        }
        catch (Exception exception) {
            return -1;
        }
    }

    public boolean deleteFile(String name) {
        return sUM.sUR.fileDelete(name);
    }

    public boolean fileExists(String name) {
        return sUM.sUR.fileExists(name);
    }

    public int getFileSize(String name) {
        return sUM.sUR.getFileSize(name);
    }

    public int getFileCount() {
        return sUM.sUR.getFileCount();
    }

    public String getFileName(int index) {
        return sUM.sUR.getFileNameAndSize(index, null);
    }

    public boolean forgetFile(String name) {
        return sUM.sUR.fileForget(name);
    }

    public boolean persistFile(String name) {
        return sUM.sUR.filePersisted(name);
    }

    static {
        IS_MAC = false;
    }

    public static interface LoadInterface {
        public FileHandle loadFile(String var1);

        public FileHandle getSaveType(String var1);
    }
}

