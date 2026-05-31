/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ConfigINI {
    public static int iWidth = -1;
    public static int iHeight = -1;
    public static boolean fullscreen = true;
    public static int iSamples = -1;
    public static boolean vSync = false;
    public static boolean landscape = true;
    public static int iUIScale = -1;

    public static final void readConfig() {
        try {
            FileHandle file = FileManager.IS_MAC ? Gdx.files.external("settings/config.txt") : Gdx.files.local("settings/config.txt");
            String tempTags = file.readString();
            String[] tSplited = tempTags.replace("\n", "").split(";");
            for (int i = 0; i < tSplited.length; ++i) {
                String[] tempR = tSplited[i].split("=");
                try {
                    if (tempR[0].equals("FULLSCREEN")) {
                        fullscreen = Boolean.parseBoolean(tempR[1]);
                        continue;
                    }
                    if (tempR[0].equals("WIDTH")) {
                        iWidth = Integer.parseInt(tempR[1]);
                        continue;
                    }
                    if (tempR[0].equals("HEIGHT")) {
                        iHeight = Integer.parseInt(tempR[1]);
                        continue;
                    }
                    if (tempR[0].equals("ANTIALIASING")) {
                        iSamples = Integer.parseInt(tempR[1]);
                        continue;
                    }
                    if (tempR[0].equals("VSYNC")) {
                        vSync = Boolean.parseBoolean(tempR[1]);
                        continue;
                    }
                    if (tempR[0].equals("LANDSCAPE")) {
                        landscape = Boolean.parseBoolean(tempR[1]);
                        continue;
                    }
                    if (!tempR[0].equals("UISCALE")) continue;
                    iUIScale = Integer.parseInt(tempR[1]);
                    continue;
                }
                catch (Exception ex) {
                    iWidth = -1;
                    iHeight = -1;
                    fullscreen = true;
                    iSamples = -1;
                    vSync = false;
                    landscape = true;
                    iUIScale = -1;
                    break;
                }
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
    }

    public static final void saveConfig() {
        FileHandle fileSave = FileManager.IS_MAC ? Gdx.files.external("settings/config.txt") : Gdx.files.local("settings/config.txt");
        fileSave.writeString("FULLSCREEN=" + fullscreen + ";\n", false);
        fileSave.writeString("WIDTH=" + iWidth + ";\n", true);
        fileSave.writeString("HEIGHT=" + iHeight + ";\n", true);
        fileSave.writeString("ANTIALIASING=" + iSamples + ";\n", true);
        fileSave.writeString("VSYNC=" + vSync + ";\n", true);
        fileSave.writeString("LANDSCAPE=" + landscape + ";\n", true);
        fileSave.writeString("UISCALE=" + iUIScale + ";", true);
    }
}

