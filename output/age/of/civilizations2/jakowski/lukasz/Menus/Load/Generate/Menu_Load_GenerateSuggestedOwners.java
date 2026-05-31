
package age.of.civilizations2.jakowski.lukasz.Menus.Load.Generate;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Load_GenerateSuggestedOwners
extends Menu {
    public Menu_Load_GenerateSuggestedOwners() {
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
                        Menu_Load_GenerateSuggestedOwners.this.loadData();
                    }
                });
            }
        }).start();
        CFG.drawVersionLB(oSB, iTranslateX);
        CFG.setRenderO(true);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    private final void loadData() {
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < Game_Scenarios.SCENARIOS_SIZE) {
            CFG.core.build_SuggestedOwners(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
            ++CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
        } else {
            CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
            CFG.map.getMpC().centerToRandomMapPos();
        }
    }
}

