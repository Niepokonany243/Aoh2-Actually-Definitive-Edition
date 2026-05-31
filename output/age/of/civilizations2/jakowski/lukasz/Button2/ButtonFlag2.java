
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonFlag2
extends ButtonM {
    public int iCivID;

    public ButtonFlag2(int iCivID, int iPosX, int iPosY, boolean isClickable) {
        this.init("", this.iTextPositionX, iPosX, iPosY, IMGManager.getIMG(Images.flagRect2).getWidth(), IMGManager.getIMG(Images.flagRect2).getHeight(), isClickable, true, false, false);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.iCivID = iCivID;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    public int getFlagCivID() {
        return this.iCivID;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void actionElemPPM() {
        try {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.getCurr()).getCapitalProvID());
        }
        catch (Exception exception) {
            
        }
    }
}

