
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Province_GameData2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;

public class Editor_ShiftPort
extends Editor {
    private int iDiff = 1;

    
    @Override
    public void keyDown(int keycode) {
        block29: {
            if (CFG.core.getActiveProvID() >= 0) {
                int tempX = 0;
                int tempY = 0;
                FileHandle fileProvinceData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "provinces/" + CFG.core.getActiveProvID());
                try {
                    Province_GameData2 tData = (Province_GameData2)CFG.deserialize(fileProvinceData.readBytes());
                    tempX = tData.iPort_ShiftX;
                    tempY = tData.iPort_ShiftY;
                    if (Gdx.input.isKeyPressed(51)) {
                        ++this.iDiff;
                    }
                    if (Gdx.input.isKeyPressed(45)) {
                        --this.iDiff;
                        if (this.iDiff < 1) {
                            this.iDiff = 1;
                        }
                    }
                    if (Gdx.input.isKeyPressed(21)) {
                        tempX -= this.iDiff;
                    }
                    if (Gdx.input.isKeyPressed(22)) {
                        tempX += this.iDiff;
                    }
                    if (Gdx.input.isKeyPressed(19)) {
                        tempY -= this.iDiff;
                    }
                    if (Gdx.input.isKeyPressed(20)) {
                        tempY += this.iDiff;
                    }
                    tData.iPort_ShiftX = tempX;
                    tData.iPort_ShiftY = tempY;
                    OutputStream osProvince = null;
                    try {
                        FileHandle fileProvince = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "provinces/" + CFG.core.getActiveProvID());
                        fileProvince.writeBytes(CFG.serialize(tData), false);
                    }
                    catch (IOException ex) {
                        if (CFG.LOGs) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    finally {
                        block28: {
                            if (osProvince != null) {
                                try {
                                    osProvince.close();
                                }
                                catch (Exception ex) {
                                    if (!CFG.LOGs) break block28;
                                    CFG.exceptionStack(ex);
                                }
                            }
                        }
                    }
                    Editor_ShiftPort.savePortPosition(tempX, tempY);
                }
                catch (ClassNotFoundException e) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(e);
                    }
                }
                catch (IOException e) {
                    if (CFG.LOGs) {
                        CFG.exceptionStack(e);
                    }
                }
                catch (GdxRuntimeException e) {
                    if (!CFG.LOGs) break block29;
                    CFG.exceptionStack(e);
                }
            }
        }
    }

    public static final void savePortPosition(int tempX, int tempY) {
        CFG.core.getProv(CFG.core.getActiveProvID()).updateProvincePort(tempX, tempY);
    }

    @Override
    public String toString() {
        return "SHIFT PORT: " + CFG.core.getActiveProvID() + "\nSHIFT: " + this.iDiff + " Q--, W++";
    }
}

