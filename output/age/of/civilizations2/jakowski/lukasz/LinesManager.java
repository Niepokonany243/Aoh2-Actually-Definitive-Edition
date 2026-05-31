
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Line_GameData;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;

public class LinesManager {
    public String highlightTAG = null;
    public Image highlightImage = null;
    public boolean highlightFlipX;
    public boolean highlightMovable;
    public String moveLandTAG = null;
    public Image moveLandImage = null;
    public boolean moveLandFlipX;
    public boolean moveLandMovable;
    public String migrateTAG = null;
    public Image migrateImage = null;
    public boolean migrateFlipX;
    public boolean migrateMovable;

    public LinesManager() {
        this.highlightTAG = CFG.settingsGD.sHighlightLine;
        this.moveLandTAG = CFG.settingsGD.sMoveLine;
        this.migrateTAG = "1";
        this.loadHighlight();
        this.loadMoveLand();
        this.loadMigrate();
    }

    public final String loadNext(String sCurrent, boolean right) {
        FileHandle tempFileT = FileManager.loadFile("game/lines/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        for (int i = 0; i < tagsSPLITED.length; ++i) {
            if (!tagsSPLITED[i].equals(sCurrent)) continue;
            if (right) {
                if (i + 1 < tagsSPLITED.length) {
                    return tagsSPLITED[i + 1];
                }
                return tagsSPLITED[0];
            }
            if (i - 1 >= 0) {
                return tagsSPLITED[i - 1];
            }
            return tagsSPLITED[tagsSPLITED.length - 1];
        }
        return "default";
    }

    public final void loadHighlight() {
        if (this.highlightImage != null) {
            this.highlightImage.getTexture().dispose();
            this.highlightImage = null;
        }
        FileHandle tGameData = FileManager.loadFile("game/lines/" + this.highlightTAG);
        try {
            CFG.editorLine_GameData = (Line_GameData)CFG.deserialize(tGameData.readBytes());
            this.highlightImage = new Image(new Texture(FileManager.loadFile("game/lines/" + CFG.editorLine_GameData.getImageName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.ClampToEdge);
            this.highlightFlipX = CFG.editorLine_GameData.getFlipX();
            this.highlightMovable = CFG.editorLine_GameData.getMovable();
            CFG.editorLine_GameData = null;
            return;
        }
        catch (Exception exception) {
            this.highlightImage = new Image(new Texture(FileManager.loadFile("UI/pix"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.Repeat);
            return;
        }
    }

    public final void loadMigrate() {
        if (this.migrateImage != null) {
            this.migrateImage.getTexture().dispose();
            this.migrateImage = null;
        }
        FileHandle tGameData = FileManager.loadFile("game/lines/" + this.migrateTAG);
        try {
            CFG.editorLine_GameData = (Line_GameData)CFG.deserialize(tGameData.readBytes());
            this.migrateImage = new Image(new Texture(FileManager.loadFile("game/lines/" + CFG.editorLine_GameData.getImageName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.ClampToEdge);
            this.migrateFlipX = CFG.editorLine_GameData.getFlipX();
            this.migrateMovable = CFG.editorLine_GameData.getMovable();
            CFG.editorLine_GameData = null;
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.migrateImage = new Image(new Texture(FileManager.loadFile("UI/pix"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.ClampToEdge);
    }

    public final void loadMoveLand() {
        if (this.moveLandImage != null) {
            this.moveLandImage.getTexture().dispose();
            this.moveLandImage = null;
        }
        FileHandle tGameData = FileManager.loadFile("game/lines/" + this.moveLandTAG);
        try {
            CFG.editorLine_GameData = (Line_GameData)CFG.deserialize(tGameData.readBytes());
            this.moveLandImage = new Image(new Texture(FileManager.loadFile("game/lines/" + CFG.editorLine_GameData.getImageName() + ".png"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.ClampToEdge);
            this.moveLandFlipX = CFG.editorLine_GameData.getFlipX();
            this.moveLandMovable = CFG.editorLine_GameData.getMovable();
            CFG.editorLine_GameData = null;
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.moveLandImage = new Image(new Texture(FileManager.loadFile("UI/pix"), Pixmap.Format.RGBA8888, true), Texture.TextureFilter.Linear, CFG.editorLine_GameData.getRapeatImage() ? Texture.TextureWrap.Repeat : Texture.TextureWrap.ClampToEdge);
    }
}

