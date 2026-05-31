
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Classic_Classic_Wiki
extends Button_Classic {
    public Button_Classic_Classic_Wiki(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(null, 0, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_Classic_Wiki(int nID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(null, nID, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive || this.getIsHovered()) {
            IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        } else {
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        }
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.getIsClickable()) {
            oSB.setColor(Color.WHITE);
        } else {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.55f));
        }
        IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.wikipedia).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() / 2 + iTranslateY);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ".", CFG.COLOR_HOVER_TITLE));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return this.iTextPositionX;
    }
}

