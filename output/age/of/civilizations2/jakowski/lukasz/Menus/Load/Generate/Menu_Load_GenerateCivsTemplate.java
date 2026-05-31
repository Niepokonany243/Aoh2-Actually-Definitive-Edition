/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load.Generate;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivTemplate;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;

public class Menu_Load_GenerateCivsTemplate
extends Menu {
    public Menu_Load_GenerateCivsTemplate() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = 0;
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 / (float)(Game_Scenarios.SCENARIOS_SIZE + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        new Thread(new Runnable(){

            @Override
            public void run() {
                Gdx.app.postRunnable(new Runnable(){

                    @Override
                    public void run() {
                        Menu_Load_GenerateCivsTemplate.this.loadData();
                    }
                });
            }
        }).start();
        CFG.drawVersionLB(oSB, iTranslateX);
        CFG.setRenderO(true);
    }

    private final void loadData() {
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < Game_Scenarios.SCENARIOS_SIZE) {
            this.buildTemplates(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
            ++CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
        } else {
            CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
            CFG.map.getMpC().centerToRandomMapPos();
        }
    }

    public final void buildTemplates(int nScenarioID) {
        CFG.core.setScenarioID(nScenarioID);
        CFG.core.loadScenario(true);
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 1 || CFG.core.getCiv(i).getCapitalProvID() < 0 || CFG.core.getCiv(i).getCivTag().equals("ran") || CFG.ideologiesMgr.REBELS_ID == CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(i).getCivTag())) continue;
            try {
                CivTemplate civTemplate;
                FileHandle file = null;
                if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "civs_template/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag())).exists()) {
                    try {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "civs_template/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()));
                        civTemplate = (CivTemplate)CFG.deserialize(file.readBytes());
                    }
                    catch (Exception ex) {
                        civTemplate = new CivTemplate();
                        CFG.exceptionStack(ex);
                    }
                } else {
                    civTemplate = new CivTemplate();
                }
                ArrayList<Integer> provs = new ArrayList<Integer>();
                for (int a = 0; a < CFG.core.getCiv(i).getNumOfProvs(); ++a) {
                    provs.add(CFG.core.getCiv(i).getProvID(a));
                }
                civTemplate.addNewTemplate(CFG.core.getCiv(i).getCivTag(), GameCalendar.currYear, provs);
                try {
                    FileHandle file2 = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "civs_template/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()));
                    file2.writeBytes(CFG.serialize(civTemplate), false);
                }
                catch (IOException exr) {
                    CFG.exceptionStack(exr);
                }
                continue;
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                // empty catch block
            }
        }
        CFG.toastM.addM(CFG.lang.get("Done") + " #" + CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(nScenarioID)), CFG.COLOR_HOVER_TITLE);
    }
}

