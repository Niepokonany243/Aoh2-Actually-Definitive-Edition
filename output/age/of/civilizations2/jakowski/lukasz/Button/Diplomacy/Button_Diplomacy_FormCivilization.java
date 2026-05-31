
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Button_Diplomacy_FormCivilization
extends ButtonM {
    private Image lFlag = null;
    private boolean row = false;
    private String sCivTag;
    private String sTextCostGold;
    private String sTextCostDiplomacy;
    private int iTextCostGoldWidth;
    private int iTextCostDiplomacyWidth;
    public SparksAnimation sparksAnimation;
    public int id = 0;

    public Button_Diplomacy_FormCivilization(String nTag, int iPosX, int iPosY, int iWidth, boolean isClickable, boolean nCheckbox, int nID, int minHeight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("FormX", CFG.lang.getCiv(nTag)), 0, iPosX, iPosY, iWidth, Math.max(minHeight, Math.max(Menu_InGame_Civ_Decisions.getButtonH(), Math.max(IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD))), isClickable, true, true, nCheckbox);
        this.id = nID;
        this.row = nID % 2 == 0;
        this.sparksAnimation = new SparksAnimation();
        this.sCivTag = nTag;
        this.sTextCostGold = "" + GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD;
        this.sTextCostDiplomacy = "" + (float)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS / 10.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sTextCostGold);
        this.iTextCostGoldWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sTextCostDiplomacy);
        this.iTextCostDiplomacyWidth = (int)CFG.glyphLay.width;
        this.loadFlag(this.sCivTag);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        if (this.getIsHovered()) {
            oSB.setColor(SparksAnimation.sparksColors2);
            this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_FormCivilization.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.3f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.3f));
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_FormCivilization.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization.this.getWidthE() / 6, Button_Diplomacy_FormCivilization.this.getHeightE() - 2, false, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_FormCivilization.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization.this.getWidthE() / 10, Button_Diplomacy_FormCivilization.this.getHeightE() - 2, false, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_FormCivilization.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization.this.getWidthE(), CFG.PADD, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_FormCivilization.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_FormCivilization.this.getHeightE() - 1 + iTranslateY - CFG.PADD, Button_Diplomacy_FormCivilization.this.getWidthE(), CFG.PADD, false, true);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    
    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        int posX = this.getPosXE() + (ButtonDiplomacy.iDiploWidth - IMGManager.getIMG(Images.flagRect2).getWidth()) / 2 + iTranslateX;
        int posY = this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY;
        try {
            oSB.setShader(Renderer.shaderAlpha);
            try {
                this.lFlag.getTexture().bind(1);
            }
            catch (Exception ex) {
                IMGManager.getIMG(Images.randomCivilizationFlag).getTexture().bind(1);
            }
            Gdx.gl.glActiveTexture(33984);
            IMGManager.getIMG(Images.flagRect2Mask).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight());
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        finally {
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            IMGManager.getIMG(Images.flagRect2).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2).getWidth(), IMGManager.getIMG(Images.flagRect2).getHeight());
        }
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold()) / 2.0f) - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints) / 2.0f) - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostGold, this.getPosXE() + this.getWidthE() - this.iTextCostGoldWidth - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2);
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostDiplomacy, this.getPosXE() + this.getWidthE() - this.iTextCostDiplomacyWidth - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - this.getRightWidth() - ButtonDiplomacy.iDiploWidth, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (Exception exception) {
            
        }
    }

    public final int getRightWidth() {
        return Math.max(this.iTextCostGoldWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), this.iTextCostDiplomacyWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topDiplomacyPoints)));
    }

    private final float getImageScale(int nImageID) {
        return Math.min(1.0f, (float)CFG.TEXT_HEIGHT_DEFAULT_SMALL / (float)IMGManager.getIMG(nImageID).getHeight());
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Image(this.getCheckboxSt() ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text("" + this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (float)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS / 10.0f, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Image(CFG.core.isAtPeace(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId()) ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AtPeace")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IsNotAVassal")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Image(CFG.doesNotExists_FormableCiv(this.sCivTag) ? Images.iconTrue : Images.iconFalse));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("XDoesNotExist", CFG.lang.getCiv(this.sCivTag))));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }

    @Override
    public void setMax(int nCurrent) {
        this.row = nCurrent == 1;
    }

    public void storeStats() {
        if (sUM.sUI == null) {
            return;
        }
        sUM.sUI.storeStats();
    }

    private final void loadFlag(String nTag) {
        block16: {
            this.disposeFlag();
            try {
                if (FileManager.loadFile("game/flagsH/" + nTag + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsXH/" + nTag + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                }
                if (this.lFlag != null) break block16;
                try {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + nTag + ".png")), Texture.TextureFilter.Nearest);
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Nearest);
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            break block16;
                        }
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                    }
                }
            }
            catch (Exception e) {
                this.lFlag = null;
            }
        }
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
        this.disposeFlag();
    }

    private final void disposeFlag() {
        if (this.lFlag != null) {
            this.lFlag.getTexture().dispose();
            this.lFlag = null;
        }
    }

    @Override
    public int getCurr() {
        return this.id;
    }
}

