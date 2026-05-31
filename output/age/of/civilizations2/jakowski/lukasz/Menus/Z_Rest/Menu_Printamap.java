
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

public class Menu_Printamap
extends Menu {
    private int iMapPosX = 0;
    private int iMapPosY = 0;
    private int id = 0;

    public Menu_Printamap() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getMpC().setNewPosX(this.iMapPosX);
        CFG.map.getMpC().setNewPosY(this.iMapPosY);
        this.iMapPosX -= CFG.GAMEWIDTH;
        if (-this.iMapPosX >= CFG.map.getMpB().getWidthM()) {
            this.iMapPosX = 0;
            this.iMapPosY -= CFG.GAMEHEIGHT;
            if (-this.iMapPosY >= CFG.map.getMpB().getHeightM()) {
                this.onBackPressed();
                CFG.toastM.addM(CFG.lang.get("Saved"), CFG.COLOR_HOVER_TITLE);
            }
        }
        this.saveScenarioMinimapPreviewTexture(oSB);
        CFG.setRenderO(true);
    }

    @Override
    public void actionEL(int nMenuElementID) {
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }

    public final void saveScenarioMinimapPreviewTexture(SpriteBatch oSB) {
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        Image tempMinimapPrerivew = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - CFG.GAMEHEIGHT, CFG.GAMEWIDTH, CFG.GAMEHEIGHT)));
        try {
            tempMinimapPrerivew.getTexture().getTextureData().prepare();
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        PixmapIO.writePNG(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "PRINT/map" + this.id++ + ".png"), tempMinimapPrerivew.getTexture().getTextureData().consumePixmap());
        CFG.setRenderO(true);
        tempMinimapPrerivew.getTexture().dispose();
        tempMinimapPrerivew = null;
    }
}

