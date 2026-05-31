/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Tribute_Vassal
extends Button_Build {
    private int iIdelogyID;
    private int iCivID;

    public Button_Tribute_Vassal(String sText, int nIdelogyID, int iPosX, int iPosY, int nCivID) {
        super(sText, Images.diploVassal, 0, 0, iPosX, iPosY, ButtonDiplomacy.iDiploWidth, true, false, 0, 0.0f);
        this.setHeightE(CFG.BUTTON_H * 3 / 4);
        this.iIdelogyID = nIdelogyID;
        this.iCivID = nCivID;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.ideologiesMgr.getIdeologyID(this.iIdelogyID).getCrownImageScaled().drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - CFG.ideologiesMgr.getIdeologyID(this.iIdelogyID).getCrownImageScaled().getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.ideologiesMgr.getIdeologyID(this.iIdelogyID).getCrownImageScaled().getHeight() / 2 + iTranslateY);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        }
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover_Just(this.iIdelogyID);
    }

    @Override
    public void actionElem(int iID) {
        if (CFG.core.getCiv(this.iCivID).getCapitalProvID() >= 0) {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.iCivID).getCapitalProvID());
            CFG.toastM.addM(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getCapitalProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
    }
}


