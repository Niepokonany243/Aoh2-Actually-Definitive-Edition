
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Button_Diplomacy_FormCivilization2
extends ButtonM {
    private Image lFlag = null;
    private boolean row = false;
    public boolean isNearest = false;
    private String sCivTag;
    private String sTextCostGold;
    private String sTextCostDiplomacy;
    private int iTextCostGoldWidth;
    private int iTextCostDiplomacyWidth;
    public SparksAnimation sparksAnimation;
    public int id = 0;
    public List<String> sLines = new ArrayList<String>();
    public int iLineSize = 0;

    public Button_Diplomacy_FormCivilization2(String nTag, int iPosX, int iPosY, int iWidth, boolean isClickable, boolean nCheckbox, int nID, int minHeight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("FormX", CFG.lang.getCiv(nTag)), 0, iPosX, iPosY, iWidth, Math.max(minHeight, Math.max(Menu_InGame_Civ_Decisions.getButtonH(), Math.max(IMGManager.getIMG(Images.flagBigOver).getHeight() + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD))), isClickable, true, true, nCheckbox);
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
        try {
            String pText = "";
            if (FileManager.loadFile("game/formableDescription/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".txt").exists()) {
                FileHandle file = FileManager.loadFile("game/formableDescription/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".txt");
                pText = CFG.lang.getForm(file.readString());
            } else {
                pText = CFG.lang.getForm(CFG.ideologiesMgr.getRealTag(this.sCivTag));
            }
            if (pText.length() > 0 && !pText.equals(CFG.ideologiesMgr.getRealTag(this.sCivTag))) {
                GlyphLayout_Game glyphLayout;
                String[] words = pText.split(" ");
                int textPosX = 0;
                int maxW = iWidth - (CFG.PADD * 6 + IMGManager.getIMG(Images.flagBigOver2).getWidth());
                String currentLine = "";
                int iSize = words.length;
                for (int i = 0; i < iSize; ++i) {
                    GlyphLayout_Game glyphLayout2 = new GlyphLayout_Game();
                    glyphLayout2.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), words[i] + " ");
                    this.iTextWidth = (int)glyphLayout2.width;
                    if ((textPosX += this.iTextWidth) < maxW) {
                        currentLine = currentLine + words[i] + " ";
                        continue;
                    }
                    if (currentLine.length() > 0) {
                        this.sLines.add(currentLine);
                    }
                    currentLine = words[i] + " ";
                    textPosX = this.iTextWidth;
                }
                if (currentLine.length() > 0) {
                    this.sLines.add(currentLine);
                }
                if (!this.sLines.isEmpty() && this.sLines.get(0).length() > 0) {
                    glyphLayout = new GlyphLayout_Game();
                    glyphLayout.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sLines.get(0));
                    this.iTextHeight = (int)glyphLayout.height;
                } else {
                    glyphLayout = new GlyphLayout_Game();
                    glyphLayout.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), "ABC");
                    this.iTextHeight = (int)glyphLayout.height;
                }
                this.iLineSize = this.sLines.size();
                for (int i = 0; i < this.iLineSize; ++i) {
                    GlyphLayout_Game glyphLayout3 = new GlyphLayout_Game();
                    glyphLayout3.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sLines.get(i));
                    if (!(glyphLayout3.width > (float)this.getWidthE())) continue;
                    this.setWidthE((int)glyphLayout3.width);
                }
                this.setHeightE(Math.max(this.getHeightE(), this.getTextHeight() + CFG.PADD * 4 + CFG.PADD * 4 + (this.iTextHeight + CFG.PADD * 2) * this.iLineSize));
            }
        }
        catch (Exception exception) {
            
        }
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
                    if (Button_Diplomacy_FormCivilization2.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.3f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.3f));
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_FormCivilization2.this.getPosXE() + Button_Diplomacy_FormCivilization2.this.getWidthE() - Button_Diplomacy_FormCivilization2.this.getWidthE() / 6 + iTranslateX, Button_Diplomacy_FormCivilization2.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization2.this.getWidthE() / 6, Button_Diplomacy_FormCivilization2.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_FormCivilization2.this.getPosXE() + Button_Diplomacy_FormCivilization2.this.getWidthE() - Button_Diplomacy_FormCivilization2.this.getWidthE() / 10 + iTranslateX, Button_Diplomacy_FormCivilization2.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization2.this.getWidthE() / 10, Button_Diplomacy_FormCivilization2.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_FormCivilization2.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_FormCivilization2.this.getWidthE(), CFG.PADD, true, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_FormCivilization2.this.getPosXE() + iTranslateX, Button_Diplomacy_FormCivilization2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_FormCivilization2.this.getHeightE() - 1 + iTranslateY - CFG.PADD, Button_Diplomacy_FormCivilization2.this.getWidthE(), CFG.PADD, true, true);
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
        int posX = this.getPosXE() + CFG.PADD * 2 + iTranslateX;
        int posY = this.getPosY() + CFG.PADD * 2 + iTranslateY;
        if (this.isNearest || GameN.FUEVG) {
            oSB.setShader(Renderer.shaderAlpha);
            this.lFlag.getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            IMGManager.getIMG(Images.flagBigMask2).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
        } else {
            Renderer.setShaderWater3(oSB);
            Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
            Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
            IMGManager.getIMG(Images.flagBigMask2).getTexture().bind(1);
            Gdx.gl.glActiveTexture(33984);
            this.lFlag.draw(oSB, posX, posY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
        }
        oSB.flush();
        oSB.setShader(AoCGame.shaderDef);
        IMGManager.getIMG(Images.flagBigOver2).draw(oSB, posX + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2, posY);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
            IMGManager.getIMG(Images.flagBigOver2).draw(oSB, posX + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2, posY);
        }
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.225f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + (CFG.PADD * 4 + IMGManager.getIMG(Images.flagBigOver2).getWidth()) + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - (CFG.PADD * 6 + IMGManager.getIMG(Images.flagBigOver2).getWidth()), this.getTextHeight() + CFG.PADD * 4, 1.0f);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.325f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + (CFG.PADD * 4 + IMGManager.getIMG(Images.flagBigOver2).getWidth()) + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - (CFG.PADD * 6 + IMGManager.getIMG(Images.flagBigOver2).getWidth()), this.getTextHeight() + CFG.PADD * 4, 1.0f);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + CFG.PADD * 4 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold()) / 2.0f) + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostGold, this.getPosXE() + this.getWidthE() - this.iTextCostGoldWidth - CFG.PADD * 5 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) + iTranslateX, this.getPosY() + CFG.PADD * 4 + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2);
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 6 - this.iTextCostGoldWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() + CFG.PADD * 4 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints) / 2.0f) - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostDiplomacy, this.getPosXE() + this.getWidthE() - CFG.PADD * 7 - this.iTextCostGoldWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())) - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX - this.iTextCostDiplomacyWidth, this.getPosY() + CFG.PADD * 4 + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + (CFG.PADD * 6 + IMGManager.getIMG(Images.flagBigOver2).getWidth()) + iTranslateX, this.getPosY() + CFG.PADD * 4 + iTranslateY, this.getColorE(isActive));
        for (int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sLines.get(i), this.getPosXE() + (CFG.PADD * 4 + IMGManager.getIMG(Images.flagBigOver2).getWidth()) + iTranslateX, this.getPosY() + (this.getTextHeight() + CFG.PADD * 4) + CFG.PADD * 4 + (this.iTextHeight + CFG.PADD * 2) * i + iTranslateY, this.getColorE(isActive));
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
            try {
                String pText = "";
                if (FileManager.loadFile("game/formableDescription/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".txt").exists()) {
                    FileHandle file = FileManager.loadFile("game/formableDescription/" + CFG.ideologiesMgr.getRealTag(this.sCivTag) + ".txt");
                    pText = CFG.lang.getForm(file.readString());
                } else {
                    pText = CFG.lang.getForm(CFG.ideologiesMgr.getRealTag(this.sCivTag));
                }
                if (pText.length() > 0 && !pText.equals(CFG.ideologiesMgr.getRealTag(this.sCivTag))) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(pText));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            catch (Exception exception) {
                
            }
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
                if (FileManager.loadFile("game/flagsXH/" + nTag + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsH/" + nTag + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                } else if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png").exists()) {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                }
                if (this.lFlag != null) break block16;
                try {
                    this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + nTag + ".png")), Texture.TextureFilter.Nearest);
                    this.isNearest = true;
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Nearest);
                        this.isNearest = true;
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                                this.isNearest = true;
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                                this.isNearest = true;
                            }
                            break block16;
                        }
                        this.lFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + nTag + "/" + nTag + "_FL.png")), Texture.TextureFilter.Nearest);
                        this.isNearest = true;
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

