
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextChal
extends Text {
    public String sT2 = "";
    public int iT2W = 0;
    public int iT2H = 0;

    public TextChal(String nText, int posX, int posY, int nW, int nH) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.setTextE(nText);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setWidthE(nW);
        this.setHeightE(nH);
        this.setTextE(this.sText);
        this.sT2 = CFG.getNumberWthSpaces("" + Math.min(ChallengesManager.challengesCompleted.size(), ChallengesManager.challengeList.size())) + " / " + CFG.getNumberWthSpaces("" + ChallengesManager.challengeList.size());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sT2);
        this.iT2W = (int)CFG.glyphLay.width;
        this.iT2H = (int)CFG.glyphLay.height;
        this.textPosition = new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.225f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.325f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        this.drawE2(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        Renderer.drawText(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, this.getColor(isActive));
    }

    public void drawE2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sT2, this.getPosXE() + this.getWidthE() - this.iT2W - CFG.PADD * 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.iT2H) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        int iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Challenges") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + Math.min(ChallengesManager.challengesCompleted.size(), ChallengesManager.challengeList.size())), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text_Big(" / ", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + ChallengesManager.challengeList.size()), CFG.COLOR_HOVER_TITLE));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ChallengeDesc"), CFG.COLOR_NEUTRAL, CFG.FONT_REGULAR_SMALL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc("Age of History 2: Definitive Edition", CFG.COLOR_NEUTRAL, CFG.FONT_REGULAR_SMALL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

