
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class MapBG {
    private List<Image> lGMI = new ArrayList<Image>();
    public int iGMIS = 0;
    public boolean gMD = true;
    private int iWidth = 1;
    private int iHeight = 1;
    private int iMaxDistance = 1;
    public int iBSX = 1;
    public int iBSY = 1;
    private int iWOSBG = 1;
    private int iHOSBG = 1;
    private int iWOSBGM = 1;
    private int iHOSBGM = 1;
    public int iMapScaleBG = 1;
    private Image minimapOverlay = null;
    private Image minimapCivs = null;
    public boolean requestToDisposeMinimap = false;
    private int iMinimapHeight;
    private int iMinimapWidth;
    public final int ALPHA_MINIMAPS = 220;
    public final float EXTRA_XY = 0.125f;
    public int iMinimapScaled_PosX = 0;
    public int iMinimapScaled_PosY = 0;
    public int iMinimapScaled_Width = 1;
    public int iMinimapScaled_Height = 1;
    public float fMinimapScaled_Scale = 1.0f;
    public boolean minimapIsBelowZero = false;
    private WMP oWMP = null;
    private WorldMap_Shaders worldMap_Shaders;

    public final void updateWM() {
        this.oWMP = this.gMD ? (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN()) ? new WMP(){

            @Override
            public void dMP(SpriteBatch oSB, int nPosX, int nPosY) {
                try {
                    if (CFG.map.getMpC().getSecondSideOfMap()) {
                        ((Image)MapBG.this.lGMI.get(1)).drawO(oSB, nPosX - MapBG.this.getMapSc3() + ((Image)MapBG.this.lGMI.get(0)).getWidth() + MapBG.this.getWidthM() + ((Image)MapBG.this.lGMI.get(0)).getWidth() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getWidth(), nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                        ((Image)MapBG.this.lGMI.get(0)).drawO(oSB, nPosX + MapBG.this.getWidthM(), nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                    }
                    ((Image)MapBG.this.lGMI.get(1)).drawO(oSB, nPosX - MapBG.this.getMapSc3() + ((Image)MapBG.this.lGMI.get(0)).getWidth() + ((Image)MapBG.this.lGMI.get(0)).getWidth() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getWidth(), nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                    ((Image)MapBG.this.lGMI.get(0)).drawO(oSB, nPosX, nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                    CFG.map.mpOv.dMO(oSB, nPosX, nPosY, 1.0f);
                }
                catch (Exception exception) {
                    
                }
            }

            @Override
            public void dMPB(SpriteBatch oSB, int nPosX, int nPosY) {
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0);
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() + MapBG.this.getHeightM(), (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0, 0.0f, false, true);
            }
        } : new WMP(){

            @Override
            public void dMP(SpriteBatch oSB, int nPosX, int nPosY) {
                try {
                    ((Image)MapBG.this.lGMI.get(1)).drawO(oSB, nPosX - MapBG.this.getMapSc3() + ((Image)MapBG.this.lGMI.get(0)).getWidth() + ((Image)MapBG.this.lGMI.get(0)).getWidth() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getWidth(), nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                    ((Image)MapBG.this.lGMI.get(0)).drawO(oSB, nPosX, nPosY + ((Image)MapBG.this.lGMI.get(0)).getHeight() * MapBG.this.getMapSc3() - ((Image)MapBG.this.lGMI.get(0)).getHeight(), (float)MapBG.this.getMapSc3());
                    CFG.map.mpOv.dMO(oSB, nPosX, nPosY, 1.0f);
                }
                catch (Exception exception) {
                    
                }
            }

            @Override
            public void dMPB(SpriteBatch oSB, int nPosX, int nPosY) {
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0);
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() + MapBG.this.getHeightM(), (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0, 0.0f, false, true);
                if (-nPosY + (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()) > MapBG.this.getHeightM()) {
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX - IMGManager.getIMG(Images.mapBorder).getHeight(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, MapBG.this.getHeightM() + nPosY, IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, true);
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX + MapBG.this.getWidthM(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, MapBG.this.getHeightM() + nPosY, IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, false);
                } else {
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX - IMGManager.getIMG(Images.mapBorder).getHeight(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, true);
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX + MapBG.this.getWidthM(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, false);
                }
            }
        }) : (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN()) ? new WMP(){

            @Override
            public void dMP(SpriteBatch oSB, int nPosX, int nPosY) {
                try {
                    int i;
                    int tempWidth;
                    int j;
                    int tempHeight;
                    int currID;
                    if (CFG.map.getMpC().getSecondSideOfMap()) {
                        currID = MapBG.this.iGMIS - 1;
                        tempHeight = MapBG.this.getHeightM() - MapBG.this.iHOSBGM;
                        for (j = MapBG.this.iBSY - 1; j >= 0; --j) {
                            if (CFG.core.inViewY(tempHeight, tempHeight + MapBG.this.iHOSBGM)) {
                                tempWidth = MapBG.this.getWidthM() * 2;
                                for (i = MapBG.this.iBSX - 1; i >= 0; --i) {
                                    if (CFG.core.inViewX(tempWidth - MapBG.this.iWOSBGM, tempWidth) || CFG.core.inViewX2(tempWidth - MapBG.this.iWOSBGM, tempWidth)) {
                                        ((Image)MapBG.this.lGMI.get(currID)).draw(oSB, nPosX + tempWidth - MapBG.this.iWOSBGM, nPosY + tempHeight, (float)MapBG.this.iMapScaleBG);
                                    }
                                    tempWidth -= MapBG.this.iWOSBGM;
                                    --currID;
                                }
                            } else {
                                currID -= MapBG.this.iBSX;
                            }
                            tempHeight -= MapBG.this.iHOSBGM;
                        }
                    }
                    currID = MapBG.this.iGMIS - 1;
                    tempHeight = MapBG.this.getHeightM() - MapBG.this.iHOSBGM;
                    for (j = MapBG.this.iBSY - 1; j >= 0; --j) {
                        if (CFG.core.inViewY(tempHeight, tempHeight + MapBG.this.iHOSBGM)) {
                            tempWidth = MapBG.this.getWidthM();
                            for (i = MapBG.this.iBSX - 1; i >= 0; --i) {
                                if (CFG.core.inViewX(tempWidth - MapBG.this.iWOSBGM, tempWidth) || CFG.core.inViewX2(tempWidth - MapBG.this.iWOSBGM, tempWidth)) {
                                    ((Image)MapBG.this.lGMI.get(currID)).draw(oSB, nPosX + tempWidth - MapBG.this.iWOSBGM, nPosY + tempHeight, (float)MapBG.this.iMapScaleBG);
                                }
                                tempWidth -= MapBG.this.iWOSBGM;
                                --currID;
                            }
                        } else {
                            currID -= MapBG.this.iBSX;
                        }
                        tempHeight -= MapBG.this.iHOSBGM;
                    }
                    CFG.map.mpOv.dMO(oSB, nPosX, nPosY, 1.0f);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public void dMPB(SpriteBatch oSB, int nPosX, int nPosY) {
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0);
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() + MapBG.this.getHeightM(), (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0, 0.0f, false, true);
            }
        } : new WMP(){

            @Override
            public void dMP(SpriteBatch oSB, int nPosX, int nPosY) {
                try {
                    int currID = MapBG.this.iGMIS - 1;
                    int tempHeight = MapBG.this.getHeightM() - MapBG.this.iHOSBGM;
                    for (int j = MapBG.this.iBSY - 1; j >= 0; --j) {
                        if (CFG.core.inViewY(tempHeight, tempHeight + MapBG.this.iHOSBGM)) {
                            int tempWidth = MapBG.this.getWidthM();
                            for (int i = MapBG.this.iBSX - 1; i >= 0; --i) {
                                if (CFG.core.inViewX(tempWidth - MapBG.this.iWOSBGM, tempWidth) || CFG.core.inViewX2(tempWidth - MapBG.this.iWOSBGM, tempWidth)) {
                                    ((Image)MapBG.this.lGMI.get(currID)).draw(oSB, nPosX + tempWidth - MapBG.this.iWOSBGM, nPosY + tempHeight, (float)MapBG.this.iMapScaleBG);
                                }
                                tempWidth -= MapBG.this.iWOSBGM;
                                --currID;
                            }
                        } else {
                            currID -= MapBG.this.iBSX;
                        }
                        tempHeight -= MapBG.this.iHOSBGM;
                    }
                    CFG.map.mpOv.dMO(oSB, nPosX, nPosY, 1.0f);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }

            @Override
            public void dMPB(SpriteBatch oSB, int nPosX, int nPosY) {
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0);
                IMGManager.getIMG(Images.mapBorder).draw2O(oSB, 0, nPosY - IMGManager.getIMG(Images.mapBorder).getHeight() + MapBG.this.getHeightM(), (int)Math.ceil((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosX, 0, 0.0f, false, true);
                if (-nPosY + (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()) > MapBG.this.getHeightM()) {
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX - IMGManager.getIMG(Images.mapBorder).getHeight(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, MapBG.this.getHeightM() + nPosY, IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, true);
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX + MapBG.this.getWidthM(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, MapBG.this.getHeightM() + nPosY, IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, false);
                } else {
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX - IMGManager.getIMG(Images.mapBorder).getHeight(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, true);
                    IMGManager.getIMG(Images.mapBorder).draw2O(oSB, nPosX + MapBG.this.getWidthM(), -IMGManager.getIMG(Images.mapBorder).getHeight() * 2, (int)Math.ceil((float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc()), IMGManager.getIMG(Images.mapBorder).getHeight(), -nPosY, 0, 270.0f, false, false);
                }
            }
        });
    }

    public final void updateWorldMap_Shaders() {
        this.worldMap_Shaders = CFG.menus.getInNextPlayerTurn() || CFG.menus.getInVictory() || CFG.menus.getInGame_Formable_Civ_Provinces() || CFG.menus.getInGame_FormAnimation() || CFG.menus.getInGame_CreateAVassal() && !CFG.VIEW_SHOW_VALUES || CFG.menus.getInGameView() && (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOAD_AI_RTO || CFG.menus.getInGameView_Options() || CFG.menus.getInGameView_EndOfGame() || MapModesManager.VIEW_IMPERIAL_MODE == CFG.mapModesManager.getActiveMapModeID() || MapModesManager.VIEW_DISEASES_MODE == CFG.mapModesManager.getActiveMapModeID()) || CFG.menus.getInSelectLanguage() ? new WorldMap_Shaders(){

            @Override
            public void drawMap(SpriteBatch oSB, int nPosX, int nPosY) {
                oSB.setShader(AoCGame.nextPlayerTurnShdr);
                MapBG.this.oWMP.dMP(oSB, nPosX, nPosY);
                oSB.setShader(AoCGame.shaderDef);
            }
        } : new WorldMap_Shaders(){

            @Override
            public void drawMap(SpriteBatch oSB, int nPosX, int nPosY) {
                MapBG.this.oWMP.dMP(oSB, nPosX, nPosY);
            }
        };
    }

    public final void drawMap(SpriteBatch oSB, int nPosX, int nPosY) {
        this.worldMap_Shaders.drawMap(oSB, nPosX, nPosY);
        CFG.updateColorDashed();
    }

    public final void drawMapBorder(SpriteBatch oSB, int nPosX, int nPosY) {
        this.oWMP.dMPB(oSB, nPosX, nPosY);
    }

    public final void drawMap(SpriteBatch oSB, int nPosX, int nPosY, float scale) {
        if (this.lGMI.size() == 2) {
            this.lGMI.get(1).drawO(oSB, nPosX - 1 + this.lGMI.get(0).getWidth() + (int)((float)this.lGMI.get(0).getWidth() * (scale *= (float)this.getMapSc3())) - this.lGMI.get(0).getWidth(), nPosY + (int)((float)this.lGMI.get(0).getHeight() * scale) - this.lGMI.get(0).getHeight(), scale);
            this.lGMI.get(0).drawO(oSB, nPosX, nPosY + (int)((float)this.lGMI.get(0).getHeight() * scale) - this.lGMI.get(0).getHeight(), scale);
        } else {
            int tempWidth = 0;
            int currID = this.iGMIS - 1;
            int tempHeight = (int)((float)(this.getHeightM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * (scale *= this.getMapExtraScale()) - (float)(this.iHOSBGM / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * scale);
            for (int j = this.iBSY - 1; j >= 0; --j) {
                tempWidth = (int)((float)(this.getWidthM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * scale);
                for (int i = this.iBSX - 1; i >= 0; --i) {
                    this.lGMI.get(currID).draw(oSB, nPosX + tempWidth - (int)((float)(this.iWOSBGM / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * scale), nPosY + tempHeight, scale);
                    tempWidth = (int)((float)tempWidth - (float)(this.iWOSBGM / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * scale);
                    --currID;
                }
                tempHeight = (int)((float)tempHeight - (float)(this.iHOSBGM / CFG.map.getMapScale(CFG.map.getActiveMapIDN())) * scale);
            }
        }
    }

    public final void drawMinimapTexture(SpriteBatch oSB, int nPosX, int nPosY) {
        if (this.minimapCivs == null) {
            this.requestToDisposeMinimap = true;
            CFG.setRenderO(true);
            return;
        }
        try {
            oSB.setColor(Color.WHITE);
            this.minimapCivs.drawO(oSB, nPosX, nPosY, false, true);
        }
        catch (Exception eNull) {
            this.requestToDisposeMinimap = true;
            CFG.setRenderO(true);
        }
    }

    
    public final void drawMinimapTexture_Generate(SpriteBatch oSB) {
        if (!(this.minimapCivs != null || this.lGMI.isEmpty() || CFG.menus.getIn_InitMenu() || CFG.menus.getInLoadMap() || CFG.menus.getInLoadSave())) {
            boolean batchEndedInTry = false;
            try {
                int i;
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException illegalStateException) {
                    
                }
                oSB.end();
                batchEndedInTry = true;
                this.minimapIsBelowZero = false;
                int tMinX = this.getWidthM();
                int tMaxX = -this.getWidthM();
                int tMinY = this.getHeightM();
                int tMaxY = 0;
                int numOfProvinces = 0;
                if (CFG.FOG_OF_WAR == 2) {
                    for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                        try {
                            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || !CFG.getMetProv(i)) continue;
                            ++numOfProvinces;
                            if (CFG.core.getProv(i).getMiX2() < tMinX) {
                                tMinX = CFG.core.getProv(i).getMiX2();
                            }
                            if (CFG.core.getProv(i).getMaX7() > tMaxX) {
                                tMaxX = CFG.core.getProv(i).getMaX7();
                            }
                            if (CFG.core.getProv(i).getMiY4() < tMinY) {
                                tMinY = CFG.core.getProv(i).getMiY4();
                            }
                            if (CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
                            tMaxY = CFG.core.getProv(i).getMaY6();
                            continue;
                        }
                        catch (NullPointerException ex) {
                            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
                            if (CFG.core.getProv(i).getMiX2() < tMinX) {
                                tMinX = CFG.core.getProv(i).getMiX2();
                            }
                            if (CFG.core.getProv(i).getMaX7() > tMaxX) {
                                tMaxX = CFG.core.getProv(i).getMaX7();
                            }
                            if (CFG.core.getProv(i).getMiY4() < tMinY) {
                                tMinY = CFG.core.getProv(i).getMiY4();
                            }
                            if (CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
                            tMaxY = CFG.core.getProv(i).getMaY6();
                        }
                    }
                } else {
                    for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                        if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
                        ++numOfProvinces;
                        if (CFG.core.getProv(i).getMiX2() < tMinX) {
                            tMinX = CFG.core.getProv(i).getMiX2();
                        }
                        if (CFG.core.getProv(i).getMaX7() > tMaxX) {
                            tMaxX = CFG.core.getProv(i).getMaX7();
                        }
                        if (CFG.core.getProv(i).getMiY4() < tMinY) {
                            tMinY = CFG.core.getProv(i).getMiY4();
                        }
                        if (CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
                        tMaxY = CFG.core.getProv(i).getMaY6();
                    }
                }
                if (numOfProvinces == 0) {
                    tMinX = 0;
                    tMinY = 0;
                    tMaxX = this.getWidthM();
                    tMaxY = this.getHeightM();
                }
                int tempExtra = (int)((float)(tMaxX - tMinX) * 0.125f);
                tMinX -= tempExtra;
                tMaxX += tempExtra;
                tempExtra = (int)((float)(tMaxY - tMinY) * 0.125f);
                tMaxY += tempExtra;
                if ((tMinY -= tempExtra) < 0) {
                    tMinY = 0;
                }
                int tPosX = 0;
                int tPosY = 0;
                float tScale = 1.0f;
                tPosX = tMinX;
                tPosY = tMinY;
                tScale = Math.max((float)(tMaxX - tMinX) / (float)this.getWidthM(), (float)(tMaxY - tMinY) / (float)this.getHeightM());
                int tWidth = tMaxX - tMinX;
                int tHeight = tMaxY - tMinY;
                if ((float)(tMaxX - tMinX) / (float)this.getWidthM() >= (float)(tMaxY - tMinY) / (float)this.getHeightM()) {
                    tHeight = (int)((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
                    tPosY = tMinY + (tMaxY - tMinY) / 2 - tHeight / 2;
                    tScale = (float)this.getHeightM() / ((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
                } else {
                    tWidth = (int)((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
                    tPosX = tMinX + (tMaxX - tMinX) / 2 - tWidth / 2;
                    tScale = (float)this.getWidthM() / ((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
                }
                tPosY = Math.max(0, tPosY);
                if ((float)tWidth / (float)this.getWidthM() >= 0.95f || (float)tHeight / (float)this.getHeightM() >= 0.95f || tMinY < 0 || tMaxY >= this.getHeightM()) {
                    tPosX = 0;
                    tPosY = 0;
                    tScale = 1.0f;
                    tWidth = this.getWidthM();
                    tHeight = this.getHeightM();
                }
                this.iMinimapScaled_PosX = tPosX;
                this.iMinimapScaled_PosY = tPosY;
                this.iMinimapScaled_Width = tWidth;
                this.iMinimapScaled_Height = tHeight;
                this.fMinimapScaled_Scale = tScale;
                AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)this.getMinimapWidth()), (float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)this.getMinimapHeight()));
                AoCGame.viewport.apply();
                AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)this.getMinimapWidth()), -((float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)this.getMinimapHeight())));
                oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
                oSB.begin();
                Rectangle clipBounds = new Rectangle(0.0f, CFG.GAMEHEIGHT - this.getMinimapHeight(), this.getMinimapWidth(), this.getMinimapHeight());
                oSB.flush();
                ScissorStack.pushScissors(clipBounds);
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, 0, 0, this.getMinimapWidth(), this.getMinimapHeight());
                oSB.setColor(Color.WHITE);
                oSB.setColor(Color.WHITE);
                if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                    CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale);
                } else {
                    CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
                }
                float nScale = tScale;
                if (CFG.FOG_OF_WAR == 2) {
                    CFG.core.drawProvinces_FogOfWarDiscovery(oSB, -((int)((float)tPosX * nScale)), -((int)((float)tPosY * nScale)), nScale, 220);
                } else {
                    CFG.core.drawProvinces(oSB, -((int)((float)tPosX * nScale)), -((int)((float)tPosY * nScale)), nScale, 220);
                }
                if ((float)tPosX + (float)this.getWidthM() * tScale > (float)this.getWidthM()) {
                    if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                        CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
                    } else {
                        CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
                    }
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.core.drawProvinces_FogOfWarDiscovery(oSB, -((int)((float)tPosX * nScale)) + (int)((float)this.getWidthM() * nScale), -((int)((float)tPosY * nScale)), nScale, 220);
                    } else {
                        CFG.core.drawProvinces(oSB, -((int)((float)tPosX * nScale)) + (int)((float)this.getWidthM() * nScale), -((int)((float)tPosY * nScale)), nScale, 220);
                    }
                }
                if (tPosX < 0) {
                    if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                        CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
                    } else {
                        CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
                    }
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.core.drawProvinces_FogOfWarDiscovery(oSB, -((int)((float)tPosX * nScale)) - (int)((float)this.getWidthM() * nScale), -((int)((float)tPosY * nScale)), nScale, 220);
                    } else {
                        CFG.core.drawProvinces(oSB, -((int)((float)tPosX * nScale)) - (int)((float)this.getWidthM() * nScale), -((int)((float)tPosY * nScale)), nScale, 220);
                    }
                    this.minimapIsBelowZero = true;
                }
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException illegalStateException) {
                    
                }
                oSB.end();
            }
            finally {
                try { oSB.end(); } catch (Exception e) {}
                AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc());
                AoCGame.viewport.apply();
                AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)(-CFG.GAMEHEIGHT) / CFG.map.getMpS().getCurrSc());
                oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
                oSB.begin();
                this.minimapCivs = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - this.getMinimapHeight(), this.getMinimapWidth(), this.getMinimapHeight())));
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, 0, 0, this.getMinimapWidth(), this.getMinimapHeight());
                oSB.setColor(Color.WHITE);
                CFG.setRenderO(true);
                oSB.end();
                AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc());
                AoCGame.viewport.apply();
                AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)(-CFG.GAMEHEIGHT) / CFG.map.getMpS().getCurrSc());
                oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
                oSB.begin();
                oSB.setShader(AoCGame.shaderDef);
            }
        }
    }

    public final Image getScenarioMinimapPreviewTexture(SpriteBatch oSB) {
        int tempMinimapHeight = CFG.PREVIEW_HEIGHT;
        float tempScaleY = (float)this.getHeightM() / ((float)tempMinimapHeight - 2.0f);
        int tempMinimapWidth = (int)((float)this.getWidthM() / tempScaleY);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        oSB.end();
        int tMinX = this.getWidthM();
        int tMaxX = -this.getWidthM();
        int tMinY = this.getHeightM();
        int tMaxY = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(i).getMiX2() < tMinX) {
                tMinX = CFG.core.getProv(i).getMiX2();
            }
            if (CFG.core.getProv(i).getMaX7() > tMaxX) {
                tMaxX = CFG.core.getProv(i).getMaX7();
            }
            if (CFG.core.getProv(i).getMiY4() < tMinY) {
                tMinY = CFG.core.getProv(i).getMiY4();
            }
            if (CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
            tMaxY = CFG.core.getProv(i).getMaY6();
        }
        int tempExtra = (int)((float)(tMaxX - tMinX) * 0.125f);
        tMinX -= tempExtra;
        tMaxX += tempExtra;
        tempExtra = (int)((float)(tMaxY - tMinY) * 0.125f);
        tMaxY += tempExtra;
        if ((tMinY -= tempExtra) < 0) {
            tMinY = 0;
        }
        int tPosX = 0;
        int tPosY = 0;
        float tScale = 1.0f;
        tPosX = tMinX;
        tPosY = tMinY;
        tScale = Math.max((float)(tMaxX - tMinX) / (float)this.getWidthM(), (float)(tMaxY - tMinY) / (float)this.getHeightM());
        int tWidth = tMaxX - tMinX;
        int tHeight = tMaxY - tMinY;
        if ((float)(tMaxX - tMinX) / (float)this.getWidthM() >= (float)(tMaxY - tMinY) / (float)this.getHeightM()) {
            tHeight = (int)((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
            tPosY = tMinY + (tMaxY - tMinY) / 2 - tHeight / 2;
            tScale = (float)this.getHeightM() / ((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
        } else {
            tWidth = (int)((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
            tPosX = tMinX + (tMaxX - tMinX) / 2 - tWidth / 2;
            tScale = (float)this.getWidthM() / ((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
        }
        if ((float)tWidth / (float)this.getWidthM() >= 0.95f || (float)tHeight / (float)this.getHeightM() >= 0.95f || tMinY < 0 || tMaxY >= this.getHeightM()) {
            tPosX = 0;
            tPosY = 0;
            tScale = 1.0f;
        }
        AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)tempMinimapWidth), (float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)tempMinimapHeight));
        AoCGame.viewport.apply();
        AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)tempMinimapWidth), -((float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)tempMinimapHeight)));
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
        oSB.setColor(Color.WHITE);
        if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
            CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale);
        } else {
            CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
        }
        CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale, 220);
        if ((float)tPosX + (float)this.getWidthM() * tScale > (float)this.getWidthM()) {
            if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
            } else {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
            }
            CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale, 220);
        }
        if (tPosX < 0) {
            if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
            } else {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
            }
            CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale, 220);
        }
        oSB.end();
        AoCGame.cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
        AoCGame.viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        AoCGame.viewport.apply();
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
        return new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - tempMinimapHeight, tempMinimapWidth, tempMinimapHeight)));
    }

    public final void saveScenarioMinimapPreviewTexture(SpriteBatch oSB) {
        int tempMinimapHeight = CFG.PREVIEW_HEIGHT;
        float tempScaleY = (float)this.getHeightM() / ((float)tempMinimapHeight - 2.0f);
        int tempMinimapWidth = (int)((float)this.getWidthM() / tempScaleY);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        oSB.end();
        int tMinX = this.getWidthM();
        int tMaxX = -this.getWidthM();
        int tMinY = this.getHeightM();
        int tMaxY = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(i).getMiX2() < tMinX) {
                tMinX = CFG.core.getProv(i).getMiX2();
            }
            if (CFG.core.getProv(i).getMaX7() > tMaxX) {
                tMaxX = CFG.core.getProv(i).getMaX7();
            }
            if (CFG.core.getProv(i).getMiY4() < tMinY) {
                tMinY = CFG.core.getProv(i).getMiY4();
            }
            if (CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
            tMaxY = CFG.core.getProv(i).getMaY6();
        }
        int tempExtra = (int)((float)(tMaxX - tMinX) * 0.125f);
        tMinX -= tempExtra;
        tMaxX += tempExtra;
        tempExtra = (int)((float)(tMaxY - tMinY) * 0.125f);
        tMaxY += tempExtra;
        if ((tMinY -= tempExtra) < 0) {
            tMinY = 0;
        }
        int tPosX = 0;
        int tPosY = 0;
        float tScale = 1.0f;
        tPosX = tMinX;
        tPosY = tMinY;
        tScale = Math.max((float)(tMaxX - tMinX) / (float)this.getWidthM(), (float)(tMaxY - tMinY) / (float)this.getHeightM());
        int tWidth = tMaxX - tMinX;
        int tHeight = tMaxY - tMinY;
        if ((float)(tMaxX - tMinX) / (float)this.getWidthM() >= (float)(tMaxY - tMinY) / (float)this.getHeightM()) {
            tHeight = (int)((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
            tPosY = tMinY + (tMaxY - tMinY) / 2 - tHeight / 2;
            tScale = (float)this.getHeightM() / ((float)(tMaxX - tMinX) / (float)this.getWidthM() * (float)this.getHeightM());
        } else {
            tWidth = (int)((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
            tPosX = tMinX + (tMaxX - tMinX) / 2 - tWidth / 2;
            tScale = (float)this.getWidthM() / ((float)(tMaxY - tMinY) / (float)this.getHeightM() * (float)this.getWidthM());
        }
        if ((float)tWidth / (float)this.getWidthM() >= 0.95f || (float)tHeight / (float)this.getHeightM() >= 0.95f || tMinY < 0 || tMaxY >= this.getHeightM()) {
            tPosX = 0;
            tPosY = 0;
            tScale = 1.0f;
        }
        AoCGame.viewport.setWorldSize((float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)tempMinimapWidth), (float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)tempMinimapHeight));
        AoCGame.viewport.apply();
        AoCGame.cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH * ((float)CFG.map.getMpB().getWidthM() / (float)tempMinimapWidth), -((float)CFG.GAMEHEIGHT * ((float)CFG.map.getMpB().getHeightM() / (float)tempMinimapHeight)));
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
        oSB.setColor(Color.WHITE);
        if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
            CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale);
        } else {
            CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
        }
        CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)), -((int)((float)tPosY * tScale)), tScale, 220);
        if ((float)tPosX + (float)this.getWidthM() * tScale > (float)this.getWidthM()) {
            if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
            } else {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
            }
            CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)) + (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale, 220);
        }
        if (tPosX < 0) {
            if (this.lGMI.size() == 2 || this.getMapSc3() == 1 || GameValues.gvCommands.MINIMAP_FORCE_USE_DEFAULT) {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale);
            } else {
                CFG.map.getMpB().drawMap(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale * (float)this.getMapScale_PreExtra());
            }
            CFG.core.drawProvinces(oSB, -((int)((float)tPosX * tScale)) - (int)((float)this.getWidthM() * tScale), -((int)((float)tPosY * tScale)), tScale, 220);
        }
        oSB.end();
        AoCGame.cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
        AoCGame.viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        AoCGame.viewport.apply();
        oSB.setProjectionMatrix(AoCGame.cameraOrt.combined);
        oSB.begin();
        Image tempMinimapPrerivew = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - tempMinimapHeight, tempMinimapWidth, tempMinimapHeight)));
        try {
            tempMinimapPrerivew.getTexture().getTextureData().prepare();
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        PixmapIO.writePNG(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "preview.png"), tempMinimapPrerivew.getTexture().getTextureData().consumePixmap());
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, 0, 0, tempMinimapWidth, tempMinimapHeight);
        oSB.setColor(Color.WHITE);
        tempMinimapPrerivew.getTexture().dispose();
        tempMinimapPrerivew = null;
        Image tempImage = CFG.isAndroid() ? new Image(new Texture(Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "preview.png")), Texture.TextureFilter.Linear) : new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "preview.png")), Texture.TextureFilter.Linear);
        tempImage.drawO(oSB, 0, 0);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        oSB.end();
        oSB.begin();
        oSB.setColor(Color.WHITE);
        try {
            Image tempFlagImage2 = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - tempImage.getHeight(), tempImage.getWidth(), tempImage.getHeight())));
            try {
                tempFlagImage2.getTexture().getTextureData().prepare();
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                
            }
            PixmapIO.writePNG(FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "preview.png"), tempFlagImage2.getTexture().getTextureData().consumePixmap());
            tempFlagImage2.getTexture().dispose();
            tempFlagImage2 = null;
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, 0, 0, tempMinimapWidth, tempMinimapHeight);
        oSB.setColor(Color.WHITE);
        CFG.setRenderO(true);
        tempImage.getTexture().dispose();
        tempImage = null;
    }

    public final void disposeMinimapOfCivilizations() {
        try {
            if (this.minimapCivs != null) {
                this.requestToDisposeMinimap = true;
            }
        }
        catch (RuntimeException runtimeException) {
            
        }
    }

    public final void disposeMinimapOfCivilizations_Real() {
        try {
            if (this.minimapCivs != null) {
                this.minimapCivs.getTexture().dispose();
                this.minimapCivs = null;
                this.requestToDisposeMinimap = false;
            }
        }
        catch (RuntimeException runtimeException) {
            
        }
    }

    public final void drawMap_LogoSquare(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - nHeight, nWidth, nHeight);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        float tempPerc = (float)nHeight / (float)this.iHeight;
        this.lGMI.get(0).drawO(oSB, nPosX - (int)((float)this.iWidth / 2.0f * tempPerc) / 2, nPosY - this.lGMI.get(0).getHeight(), (int)((float)this.iWidth / 2.0f * tempPerc), nHeight);
        this.lGMI.get(1).drawO(oSB, nPosX + (int)((float)this.iWidth / 2.0f * tempPerc) / 2, nPosY - this.lGMI.get(1).getHeight(), (int)((float)this.iWidth / 2.0f * tempPerc), nHeight);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    public final void loadGameMap() {
        if (this.lGMI.size() > 0) {
            this.disposeGameMap();
        }
        Core.MAX_BELOW_ZERO_POINT_X = 0;
        if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "bg.txt").exists()) {
            int i;
            FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "bg.txt");
            String[] split = file.readString().split(";");
            this.iBSX = Integer.parseInt(split[0]);
            this.iBSY = Integer.parseInt(split[1]);
            int loadMapBG_FileID = 0;
            for (int j = loadMapBG_FileID++; j < this.iBSY; ++j) {
                for (int i2 = 0; i2 < this.iBSX; ++i2) {
                    this.lGMI.add(new Image(IMGManager.loadTexture("map/" + CFG.map.getFileActiveMapPath() + "background/" + j + "_" + i2 + ".png"), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                }
            }
            this.gMD = false;
            this.iGMIS = this.lGMI.size();
            this.iWidth = 0;
            for (i = 0; i < this.iBSX; ++i) {
                this.iWidth += this.lGMI.get(i).getWidth();
            }
            this.iHeight = 0;
            for (i = 0; i < this.iBSY; ++i) {
                this.iHeight += this.lGMI.get(i * this.iBSX).getHeight();
            }
            MapScale.MINSCALE = (float)CFG.GAMEHEIGHT / (float)this.getHeightM();
            this.iWOSBG = this.lGMI.get(this.iGMIS - 1).getWidth();
            this.iHOSBG = this.lGMI.get(this.iGMIS - 1).getHeight();
            this.iWOSBGM = this.iWOSBG * CFG.map.getMapScale(CFG.map.getActiveMapIDN());
            this.iHOSBGM = this.iHOSBG * CFG.map.getMapScale(CFG.map.getActiveMapIDN());
        } else {
            this.gMD = true;
            this.addGameMap(new Image(new Texture(FileManager.loadFile("map/backgrounds/" + CFG.map.getMapBGName(CFG.map.getActiveMapIDN()) + "_L.png")), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
            this.addGameMap(new Image(new Texture(FileManager.loadFile("map/backgrounds/" + CFG.map.getMapBGName(CFG.map.getActiveMapIDN()) + "_R.png")), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
            this.iWidth = this.lGMI.get(0).getWidth() * 2;
            this.iHeight = this.lGMI.get(0).getHeight();
            MapScale.MINSCALE = (float)CFG.GAMEHEIGHT / (float)this.getHeightM();
        }
        this.iMaxDistance = (int)Math.ceil(Math.sqrt(Math.pow(this.getWidthReal() / (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN()) ? 2 : 1), 2.0) + Math.pow(this.getHeightReal(), 2.0)));
        if ((float)CFG.GAMEWIDTH / (float)this.getWidthM() > MapScale.MINSCALE) {
            MapScale.MINSCALE = (float)CFG.GAMEWIDTH / (float)this.getWidthM();
        }
        this.iMapScaleBG = CFG.map.getMapScale(CFG.map.getActiveMapIDN());
        this.iMinimapScaled_PosX = 0;
        this.iMinimapScaled_PosY = 0;
        this.iMinimapScaled_Width = this.getWidthM();
        this.iMinimapScaled_Height = this.getHeightM();
        this.fMinimapScaled_Scale = 1.0f;
        this.updateMinimapResolution(1);
        this.updateWM();
    }

    public final void loadMinimap() {
        if (this.minimapOverlay != null) {
            this.minimapOverlay.getTexture().dispose();
            this.minimapOverlay = null;
        }
        this.minimapOverlay = new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "minimap_aoc2.png")), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
        this.updateMinimapResolution(1);
    }

    public final void updateMinimapResolution(int nScale) {
        this.iMinimapHeight = Menu_InGame_ProvInfo.getUseSmallProvinceInfo() ? (CFG.BUTTON_H + CFG.PADD * 2) * nScale : (CFG.BUTTON_H * 2 + CFG.PADD * 2) * nScale;
        if (this.iMinimapHeight < 3) {
            this.iMinimapHeight = 3;
        }
        float minimapScaleY = (float)this.getHeightM() / ((float)this.iMinimapHeight - 2.0f);
        this.iMinimapWidth = (int)((float)this.getWidthM() / minimapScaleY);
        if (this.iMinimapWidth < 3) {
            this.iMinimapWidth = 3;
        }
        CFG.map.getMpS().updateMinimapScaleXY();
    }

    public final void addGameMap(Image nGameMap) {
        this.lGMI.add(nGameMap);
    }

    public final void disposeGameMap() {
        for (int i = 0; i < this.lGMI.size(); ++i) {
            this.lGMI.get(i).getTexture().dispose();
        }
        this.lGMI.clear();
        this.iHeight = 0;
        this.iWidth = 0;
    }

    public final int getWidthM() {
        return this.iWidth * CFG.map.getMapScale(CFG.map.getActiveMapIDN());
    }

    public final int getWidthReal() {
        return this.iWidth;
    }

    public final int getHeightM() {
        return this.iHeight * CFG.map.getMapScale(CFG.map.getActiveMapIDN());
    }

    public final int getHeightReal() {
        return this.iHeight;
    }

    public final Image getMinimapOverlay() {
        return this.minimapOverlay;
    }

    public final int getMinimapWidth() {
        return this.iMinimapWidth;
    }

    public final int getMinimapHeight() {
        return this.iMinimapHeight;
    }

    public final int getMapSc3() {
        return CFG.map.getMapScale(CFG.map.getActiveMapIDN());
    }

    public final int getMapScale_PreExtra() {
        return CFG.map.getMapScale_PreExtra(CFG.map.getActiveMapIDN());
    }

    public final float getMapExtraScale() {
        return CFG.map.getMapExtraScale(CFG.map.getActiveMapIDN());
    }

    public final int getMinimapOfCivilizationsWidth() {
        try {
            return this.minimapCivs.getWidth();
        }
        catch (NullPointerException ex) {
            return 1;
        }
    }

    public final int getMinimapOfCivilizationsHeight() {
        try {
            return this.minimapCivs.getHeight();
        }
        catch (NullPointerException ex) {
            return 1;
        }
    }

    public final int getMaxDistance() {
        return this.iMaxDistance;
    }

    private static interface WMP {
        public void dMP(SpriteBatch var1, int var2, int var3);

        public void dMPB(SpriteBatch var1, int var2, int var3);
    }

    private static interface WorldMap_Shaders {
        public void drawMap(SpriteBatch var1, int var2, int var3);
    }
}

