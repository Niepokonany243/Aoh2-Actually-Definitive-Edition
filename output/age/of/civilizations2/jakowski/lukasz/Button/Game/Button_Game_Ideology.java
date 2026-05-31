
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Game_Ideology
extends Button_Game {
    private int iIdeologyID;
    private int iIdeologyTextWidth = 0;

    public Button_Game_Ideology(String sText, int nIdeologyID, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
        this.iIdeologyID = nIdeologyID;
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getName());
        this.iIdeologyTextWidth = (int)CFG.glyphLay.width;
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getWidthE() - (CFG.PADD + CFG.CIV_FLAG_WIDTH + super.getTextWidthU())) / 2 + (CFG.PADD + CFG.CIV_FLAG_WIDTH) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.iTextHeight + iTranslateY, this.getColorE(isActive));
        } else {
            CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getWidthE() - (CFG.PADD + CFG.CIV_FLAG_WIDTH + super.getTextWidthU())) / 2 + (CFG.PADD + CFG.CIV_FLAG_WIDTH) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.iTextHeight + iTranslateY, this.getColorE(isActive));
        }
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getName(), this.getPosXE() + (this.getWidthE() - this.iIdeologyTextWidth) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, this.getIsClickable() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : new Color(CFG.COLOR_BUTTON_GAME_TEXT_HOVERED.r, CFG.COLOR_BUTTON_GAME_TEXT_HOVERED.g, CFG.COLOR_BUTTON_GAME_TEXT_HOVERED.b, 0.65f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(this.getCurr()).getName(), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Ideology(this.iIdeologyID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return this.iIdeologyID;
    }

    @Override
    public int getTextWidthU() {
        return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH > this.iIdeologyTextWidth ? super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH : this.iIdeologyTextWidth;
    }

    @Override
    public int getTextPosElem() {
        return super.getTextWidthU();
    }
}

