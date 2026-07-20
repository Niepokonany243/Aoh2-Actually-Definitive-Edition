
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Editor.EditorManager;
import age.of.civilizations2.jakowski.lukasz.EventsManager;
import age.of.civilizations2.jakowski.lukasz.LangManager;
import age.of.civilizations2.jakowski.lukasz.Map;
import age.of.civilizations2.jakowski.lukasz.Toast;
import com.badlogic.gdx.Gdx;

public class InitGame {
    InitGame() {
        Gdx.app.postRunnable(this::Init);
    }

    public final void Init() {
        CFG.lang = new LangManager(CFG.settingsGD.LANG_TAG == null ? "" : CFG.settingsGD.LANG_TAG);
        CFG.loadFontMain();
        CFG.editorManager = new EditorManager();
        CFG.core = new Core();
        CFG.eventsManager = new EventsManager();
        CFG.map = new Map();
        CFG.map.loadSettings_ActiveMap();
        CFG.map.updateWorldMap();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.menus.initExtraMenus();
        CFG.toastM = new Toast();
        CFG.glyphLay.setText(CFG.fontMain.get(0), "Age of History 2: Definitive Edition");
        CFG.iAgeOfCivilizationsWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), CFG.gLG());
        CFG.iJGW = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "presents");
        CFG.iJGPW = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "Age of History 2: Definitive Edition");
        CFG.iDXW = (int)CFG.glyphLay.width;
        CFG.map.getMpS().initDefinedScales();
        CFG.loadRandomProvinceNames();
    }
}

