
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonFlagBigCh
extends ButtonM {
    public int id;
    public boolean isFlagNearest;
    public String sPlayAs;
    public int iPlayAsW;
    public boolean COMPLETED;
    public static int year = 1799;
    public String sCivTag;

    public static int getButtonW() {
        return IMGManager.getIMG(Images.flagBigMask).getWidth() + CFG.PADD * 2;
    }

    public static int getButtonH() {
        return IMGManager.getIMG(Images.flagBigMask).getHeight() + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) + CFG.PADD * 3 + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT);
    }

    public ButtonFlagBigCh(int id, String nCivTag, int iPosX, int iPosY, boolean isClickable) {
        block4: {
            this.id = 0;
            this.isFlagNearest = false;
            this.iPlayAsW = 0;
            this.COMPLETED = false;
            this.sCivTag = null;
            this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
            this.id = id;
            this.sCivTag = nCivTag;
            this.fontID = CFG.FONT_REGULAR_SMALL;
            this.init(CFG.lang.getCiv(nCivTag), this.iTextPositionX, iPosX, iPosY, ButtonFlagBigCh.getButtonW(), ButtonFlagBigCh.getButtonH(), isClickable, true, false, false);
            try {
                this.sPlayAs = CFG.lang.getCiv(ChallengesManager.challengeList.get((int)id).PLAY_AS);
                CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPlayAs);
                this.iPlayAsW = (int)CFG.glyphLay.width;
            }
            catch (Exception ex) {
                if (this.sPlayAs != null) break block4;
                this.sPlayAs = "";
            }
        }
        this.COMPLETED = ChallengesManager.challengeList.get((int)id).COMPLETED;
        int tWMax = 0;
        while (this.iTextWidth > this.getWidthE() - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
            super.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + "..");
        }
        tWMax = 0;
        while (this.iPlayAsW > this.getWidthE() - CFG.PADD && this.sPlayAs.length() > 5 && ++tWMax < 100) {
            this.sPlayAs = this.sPlayAs.substring(0, Math.max(1, this.sPlayAs.length() - 3)) + "..";
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPlayAs);
            this.iPlayAsW = (int)CFG.glyphLay.width;
        }
    }

    protected void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.COMPLETED) {
            if (isActive) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG_GREEN.r, Colors.COLOR_NOTIFICATION_BG_GREEN.g, Colors.COLOR_NOTIFICATION_BG_GREEN.b, 0.9f));
            } else if (this.getIsHovered()) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG_GREEN.r, Colors.COLOR_NOTIFICATION_BG_GREEN.g, Colors.COLOR_NOTIFICATION_BG_GREEN.b, 0.775f));
            } else {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG_GREEN.r, Colors.COLOR_NOTIFICATION_BG_GREEN.g, Colors.COLOR_NOTIFICATION_BG_GREEN.b, 0.675f));
            }
        } else if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_MENU_BLUE.r, CFG.COLOR_GRADIENT_MENU_BLUE.g, CFG.COLOR_GRADIENT_MENU_BLUE.b, 0.75f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_MENU_BLUE.r, CFG.COLOR_GRADIENT_MENU_BLUE.g, CFG.COLOR_GRADIENT_MENU_BLUE.b, 0.65f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_MENU_BLUE.r, CFG.COLOR_GRADIENT_MENU_BLUE.g, CFG.COLOR_GRADIENT_MENU_BLUE.b, 0.425f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        if (this.COMPLETED) {
            if (isActive) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.2f));
            } else if (this.getIsHovered()) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.15f));
            } else {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.085f));
            }
        } else if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.2f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.15f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.085f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD), 1.0f);
        if (this.COMPLETED) {
            oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER_GREEN.r, Colors.COLOR_NOTIFICATION_OVER_GREEN.g, Colors.COLOR_NOTIFICATION_OVER_GREEN.b, 0.375f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.175f));
        }
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD));
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.325f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + 1 + CFG.PADD + iTranslateX, this.getPosY() + 1 + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2 - 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) - 2, 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD), 1.0f);
        if (isActive) {
            oSB.setColor(Colors.COLOR_GRADIENT_OVER_BLUE);
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.85f));
        } else {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) - 1 + CFG.PADD + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawText(oSB, this.fontID, this.sPlayAs, this.getPosXE() + this.getWidthE() / 2 - this.iPlayAsW / 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? new Color(0.44f, 0.44f, 0.44f, 1.0f) : CFG.COLOR_BTN_M_NOT_CLICKABLE);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive);
        this.drawFlag(oSB, iTranslateX, iTranslateY, isActive);
    }

    protected void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        int scenarioID;
        int pY = this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.flagBigOver).getHeight() + iTranslateY;
        int pX = this.getPosXE() + CFG.PADD + iTranslateX;
        if (GameCalendar.currYear > year) {
            if (this.isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                this.getFlag().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask2).draw(oSB, pX, pY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask2).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                this.getFlag().draw(oSB, pX, pY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            IMGManager.getIMG(Images.flagBigOver2).draw(oSB, pX + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2, pY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver2).draw(oSB, pX + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2, pY);
            }
        } else {
            if (this.isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                this.getFlag().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask).draw(oSB, pX, pY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                this.getFlag().draw(oSB, pX, pY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            IMGManager.getIMG(Images.flagBigOver).draw(oSB, pX + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2, pY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver).draw(oSB, pX + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2, pY);
            }
        }
        if (this.getIsHovered() && (scenarioID = CFG.core.getGameScenars().getScenarioIDbyTag(ChallengesManager.challengeList.get((int)this.id).SCENARIO_TAG)) >= 0) {
            String iYear = "";
            int iYearW = 0;
            iYear = "" + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(scenarioID));
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), iYear);
            iYearW = (int)CFG.glyphLay.width;
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, iYear, pX + IMGManager.getIMG(Images.flagBigOver).getWidth() / 2 - iYearW / 2, pY + IMGManager.getIMG(Images.flagBigOver).getHeight() - CFG.PADD * 2 - CFG.TEXT_HEIGHT_DEFAULT, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        oSB.setColor(Color.WHITE);
    }

    public Image getFlag() {
        try {
            if (this.getFlagOfCivH() != null) {
                return this.getFlagOfCivH();
            }
            return IMGManager.getIMG(Images.randomCivilizationFlag);
        }
        catch (Exception ex) {
            return IMGManager.getIMG(Images.randomCivilizationFlag);
        }
    }

    public final Image getFlagOfCivH() {
        return CFG.flagOfCivilizationH.get(this.id);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        try {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Challenge") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Text("#" + ChallengesManager.challengeList.get((int)this.id).ID, CFG.COLOR_NEUTRAL));
            if (this.COMPLETED) {
                nData.add(new ME_Hover_2Type_Image(Images.iconTrue, CFG.PADD, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PlayAs") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.getCiv(ChallengesManager.challengeList.get((int)this.id).PLAY_AS), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big2(Images.iconTrue, CFG.PADD, 0));
            if (ChallengesManager.challengeList.get((int)this.id).PROVINCES.size() > 0 && ChallengesManager.challengeList.get((int)this.id).PROVINCES_FORM.size() > 0) {
                nData.add(new ME_Hover_2Type_Text_Big(" " + CFG.getNumberWthSpaces("" + ChallengesManager.challengeList.get((int)this.id).PROVINCES), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big2(Images.provinces, CFG.PADD, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FormCivilization") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big2(Images.victoryPoints, CFG.PADD, 0));
            if (ChallengesManager.challengeList.get((int)this.id).PROVINCES.size() > 0 && ChallengesManager.challengeList.get((int)this.id).PROVINCES_FORM.size() > 0) {
                nData.add(new ME_Hover_2Type_Text_Big(" " + CFG.getNumberWthSpaces("" + ChallengesManager.challengeList.get((int)this.id).PROVINCES_FORM), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big2(Images.provinces, CFG.PADD, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (ChallengesManager.challengeList.get((int)this.id).DESC != null && ChallengesManager.challengeList.get((int)this.id).DESC.length() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(ChallengesManager.challengeList.get((int)this.id).DESC), CFG.COLOR_NEUTRAL, CFG.FONT_REGULAR_SMALL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            int scenarioID = CFG.core.getGameScenars().getScenarioIDbyTag(ChallengesManager.challengeList.get((int)this.id).SCENARIO_TAG);
            if (scenarioID >= 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Scenario") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(scenarioID)), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (ChallengesManager.challengeList.get((int)this.id).ADD_CIV_PROVINCES != null && ChallengesManager.challengeList.get((int)this.id).ADD_CIV_PROVINCES.size() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AddNewCivilization")));
                nData.add(new ME_Hover_2Type_Image(Images.iconTrue, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + ChallengesManager.challengeList.get((int)this.id).ADD_CIV_PROVINCES.size()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        catch (Exception exception) {
            
        }
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void actionElem(int iID) {
        ChallengesManager.START_CHALLENGE_ID = this.id;
        CFG.setDialogType(DialogType.START_CHALLENGE_ID);
    }

    @Override
    public int getCurr() {
        return this.id;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.id = nCurrent;
    }
}

