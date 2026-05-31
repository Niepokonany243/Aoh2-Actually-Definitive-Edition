
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Game_Colonize
extends Button_Game {
    private long lTime = 0L;
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;
    private long lTimeAnimation = System.currentTimeMillis();
    private int animationState = 0;
    public static final int ANIMATION_T = 1000;
    private int iProvinceID = 0;
    public static final float TEXT_MAIN_SCALE = 0.9f;
    public static final float TEXT_TERRAIN_SCALE = 0.8f;
    private String sTerrain;
    private int iTerrainWidth;
    public static float TEXT_COST_SCALE = 0.6f;
    private int iLeftWidth = 0;
    private int iRightWidth = 0;
    private int iRightIconWidth = 0;
    private String sGold;
    private int iGoldWidth;
    private Color colorGold;
    private String sMovement;
    private int iMovementWidth;
    private Color colorMovement;
    private String sDiplomacy;
    private int iDiplomacyWidth;
    private Color colorDiplomacy;

    public Button_Game_Colonize(String sText, int nProvinceID, int iPosX, int iPosY, boolean isClickable) {
        super(sText, 0, iPosX, iPosY, isClickable);
        this.setWidthE(CFG.BUTTON_W + CFG.BUTTON_W / 2);
        nProvinceID = Math.max(nProvinceID, 0);
        try {
            this.iProvinceID = nProvinceID;
            this.sTerrain = CFG.terrainTypesManager.getName(CFG.core.getProv(nProvinceID).getTerrainTypeID());
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sTerrain);
            this.iTerrainWidth = (int)(CFG.glyphLay.width * 0.8f);
            this.iLeftWidth = (int)(Math.max((float)super.getTextWidthU() * 0.9f, (float)this.iTerrainWidth) + (float)(CFG.PADD * 7) + (float)CFG.CIV_FLAG_WIDTH);
            for (TEXT_COST_SCALE = 0.7f; TEXT_COST_SCALE > 0.25f && !((float)(this.getHeightE() - CFG.PADD * 2) >= (float)CFG.TEXT_HEIGHT_DEFAULT * TEXT_COST_SCALE * 3.0f + (float)(CFG.PADD * 2)); TEXT_COST_SCALE -= 0.01f) {
            }
            int tempCostGold = GameManager.getColonizeCost(this.iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            int tempCostMovement = GameManager.getColonizeCost_Movement(this.iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            this.colorGold = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)tempCostGold ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2;
            this.colorDiplomacy = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2;
            this.colorMovement = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= tempCostMovement ? CFG.COLOR_MOVEMENT : CFG.COLOR_NEGATIVE_2;
            this.sGold = CFG.getNumberWthSpaces("" + tempCostGold);
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sGold);
            this.iGoldWidth = (int)(CFG.glyphLay.width * TEXT_COST_SCALE);
            this.sMovement = "" + (float)tempCostMovement / 10.0f;
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sMovement);
            this.iMovementWidth = (int)(CFG.glyphLay.width * TEXT_COST_SCALE);
            this.sDiplomacy = "" + (float)CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS / 10.0f;
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sDiplomacy);
            this.iDiplomacyWidth = (int)(CFG.glyphLay.width * TEXT_COST_SCALE);
            this.iRightIconWidth = (int)Math.max(Math.max((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), TEXT_COST_SCALE), (float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, TEXT_COST_SCALE)), (float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints, TEXT_COST_SCALE));
            this.iRightWidth = Math.max(Math.max(this.iGoldWidth, this.iMovementWidth), this.iDiplomacyWidth) + CFG.PADD * 3 + this.iRightIconWidth;
            this.setClickable(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)tempCostGold && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= tempCostMovement && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS);
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            this.setVisibleE(false);
            this.setClickable(false);
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (this.lTime < System.currentTimeMillis() - 26L) {
            if (this.backAnimation) {
                this.fAlphaMod -= 0.02f;
                if (this.fAlphaMod < 0.0f) {
                    this.backAnimation = false;
                }
            } else {
                this.fAlphaMod += 0.02f;
                if (this.fAlphaMod > 0.4f) {
                    this.backAnimation = true;
                }
            }
            this.lTime = System.currentTimeMillis();
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f - this.fAlphaMod));
        CFG.setRenderO(true);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        if (this.animationState >= 0) {
            if (this.animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1000.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.625f : 0.525f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 1000L) {
                    ++this.animationState;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1000.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.625f : 0.525f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 1000L) {
                    this.animationState = 0;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            }
            CFG.setRenderO(true);
        }
        oSB.setColor(Color.WHITE);
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - CFG.CIV_FLAG_HEIGHT - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - CFG.CIV_FLAG_HEIGHT + iTranslateY);
        CFG.fontMain.get(0).getData().setScale(0.9f);
        if (isActive) {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - CFG.CIV_FLAG_HEIGHT / 2 - (int)((float)this.getTextHeight() * 0.9f / 2.0f) + iTranslateY, this.getColorE(isActive));
        } else {
            CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - CFG.CIV_FLAG_HEIGHT / 2 - (int)((float)this.getTextHeight() * 0.9f / 2.0f) + iTranslateY, this.getColorE(isActive));
        }
        CFG.terrainTypesManager.getIcon(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 - CFG.terrainTypesManager.getIcon(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sTerrain, this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + CFG.CIV_FLAG_HEIGHT / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f) + iTranslateY, CFG.COLOR_BUTTON_GAME_TEXT);
        CFG.fontMain.get(0).getData().setScale(TEXT_COST_SCALE);
        CFG.drawTextDefaultWithShadow(oSB, this.sMovement, this.getPosXE() + this.getWidthE() - this.iRightIconWidth - CFG.PADD * 2 - this.iMovementWidth - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * TEXT_COST_SCALE / 2.0f) + iTranslateY, this.colorMovement);
        CFG.drawTextDefaultWithShadow(oSB, this.sGold, this.getPosXE() + this.getWidthE() - this.iRightIconWidth - CFG.PADD * 2 - this.iGoldWidth - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * TEXT_COST_SCALE / 2.0f) - (int)((float)this.getTextHeight() * TEXT_COST_SCALE) - CFG.PADD + iTranslateY, this.colorGold);
        CFG.drawTextDefaultWithShadow(oSB, this.sDiplomacy, this.getPosXE() + this.getWidthE() - this.iRightIconWidth - CFG.PADD * 2 - this.iDiplomacyWidth - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + (int)((float)this.getTextHeight() * TEXT_COST_SCALE / 2.0f) + CFG.PADD + iTranslateY, this.colorDiplomacy);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), TEXT_COST_SCALE)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)this.getTextHeight() * TEXT_COST_SCALE) / 2 - (int)((float)this.getTextHeight() * TEXT_COST_SCALE) / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), TEXT_COST_SCALE) / 2.0f) - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), TEXT_COST_SCALE)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), TEXT_COST_SCALE)));
        IMGManager.getIMG(Images.topMovementPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints, TEXT_COST_SCALE)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * this.getImageScale(Images.topMovementPoints, TEXT_COST_SCALE) / 2.0f) - IMGManager.getIMG(Images.topMovementPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints, TEXT_COST_SCALE)), (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * this.getImageScale(Images.topMovementPoints, TEXT_COST_SCALE)));
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, TEXT_COST_SCALE)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + (int)((float)this.getTextHeight() * TEXT_COST_SCALE) / 2 + (int)((float)this.getTextHeight() * TEXT_COST_SCALE) - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints, TEXT_COST_SCALE)) - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, TEXT_COST_SCALE)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints, TEXT_COST_SCALE)));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public int getWidthE() {
        return Math.max(this.iLeftWidth + this.iRightWidth + CFG.PADD * 4, super.getWidthE());
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Colonize"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameManager.getColonizeCost(this.iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_GOLD));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)GameManager.getColonizeCost_Movement(this.iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_DIPLOMACY_POINTS));
        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Terrain") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(this.iProvinceID).getTerrainTypeID(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

