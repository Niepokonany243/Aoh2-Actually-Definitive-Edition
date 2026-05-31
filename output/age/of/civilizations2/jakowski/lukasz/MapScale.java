/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class MapScale {
    public static float MINSCALE = 0.01f;
    private static final float MAXSCALE = 500.0f;
    public static float STANDARD_SCALE = 1.0f;
    private float fCurrScale = 1.0f;
    private float newScale = -1.0f;
    private float startScale = -1.0f;
    private boolean scaleByYAxis = true;
    private int iStartScalePosY;
    private int iStartScalePosY2;
    private int iStartScalePosX;
    private int iStartScalePosX2;
    private int iStartScaleMapPosX = -1;
    private int iStartScaleMapPosY = -1;
    private boolean scaleMode = false;
    private float fMinimapScaleX;
    private float fMinimapScaleY;
    private static final short REQUIRED_TIME_TO_RESET_SCALE = 175;
    private float fScaleBeforeReset = 1.5f;
    private float fDifferenceScale;
    private boolean scaleChangeByTouch = true;
    public int definedScale = 1;
    private int definedScaleBeforeReset = 1;
    public int definedScalesLength = 1;
    public static DefinedScales defScales = new DefinedScales();
    protected static int animation_TIME_TO_END = 100;
    protected long animation_TIME_STARTED = 0L;
    protected float animation_StartingScale = 1.0f;
    private float changeCurrentScaleByX;
    public static int SCALE_ANIMATION_TIME = 125;
    private long iScaleAnimationTime = 0L;
    private float fStartScaling_Scale = 1.0f;
    private float fScaleAnimation_PercX = 1.0f;
    private float fScaleAnimation_PercY = 1.0f;

    public final void initDefinedScales() {
        try {
            Json json = new Json();
            FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "DefinedScales.json");
            defScales = json.fromJson(DefinedScales.class, file);
            this.definedScale = MapScale.defScales.definedScale_Default;
            this.definedScaleBeforeReset = MapScale.defScales.definedScale_Default;
            this.definedScalesLength = MapScale.defScales.definedScale_Default;
            int iSize = MapScale.defScales.definedScales.length;
            for (int i = 0; i < iSize; ++i) {
                if (!(MapScale.defScales.definedScales[i] < MINSCALE)) continue;
                MapScale.defScales.definedScales[i] = MINSCALE;
            }
            if (MapScale.defScales.definedScales[MapScale.defScales.definedScales.length - 1] > MINSCALE) {
                MapScale.defScales.definedScales[MapScale.defScales.definedScales.length - 1] = MINSCALE;
            }
            this.definedScalesLength = MapScale.defScales.definedScales.length;
        }
        catch (Exception ex) {
            try {
                this.definedScale = MapScale.defScales.definedScale_Default;
                this.definedScaleBeforeReset = MapScale.defScales.definedScale_Default;
                this.definedScalesLength = MapScale.defScales.definedScale_Default;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private float getDefinedScale() {
        try {
            return MapScale.defScales.definedScales[this.definedScale];
        }
        catch (IndexOutOfBoundsException ex) {
            return 1.0f;
        }
    }

    public final void startScaleTheMap2(int nX, int nX2, int nY, int nY2) {
        this.scaleMode = true;
        this.iStartScalePosX = nX;
        this.iStartScalePosX2 = nX2;
        this.iStartScalePosY = nY;
        this.iStartScalePosY2 = nY2;
    }

    public final void scaleTheMap2(int nX, int nX2, int nY, int nY2) {
        if (this.iStartScalePosX != nX || this.iStartScalePosY != nY) {
            float fScaleDifference = 0.0f;
            if (this.iStartScalePosX != nX) {
                fScaleDifference += (float)(this.iStartScalePosX - nX) / 150.0f / CFG.GUI_SCALE;
            } else if (this.iStartScalePosY != nY) {
                fScaleDifference += (float)(this.iStartScalePosY - nY) / 150.0f / CFG.GUI_SCALE;
            }
            this.setNewScale_ByTouch2(fScaleDifference, nX2, nY2);
        } else if (this.iStartScalePosX2 != nX2 || this.iStartScalePosY2 != nY2) {
            float fScaleDifference = 0.0f;
            if (this.iStartScalePosX2 != nX2) {
                this.iStartScalePosX2 = (int)((float)this.iStartScalePosX2 + (float)(this.iStartScalePosX2 - nX) / 150.0f / CFG.GUI_SCALE);
            } else if (this.iStartScalePosY2 != nY) {
                fScaleDifference += (float)(this.iStartScalePosY2 - nY) / 150.0f / CFG.GUI_SCALE;
            }
            this.setNewScale_ByTouch2(fScaleDifference, nX2, nY2);
        }
        this.iStartScalePosX = nX;
        this.iStartScalePosX2 = nX2;
        this.iStartScalePosY = nY;
        this.iStartScalePosY2 = nY2;
        CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
        CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
        this.resetScaleAnimation();
    }

    public final void setNewScale_ByTouch2(float nDifference, int nXCenter, int nYCenter) {
        if (nDifference == 0.0f) {
            return;
        }
        this.newScale = this.fCurrScale + nDifference;
        if (this.newScale > 500.0f) {
            this.newScale = 500.0f;
        } else if (this.newScale < MINSCALE) {
            this.newScale = MINSCALE;
        }
        this.scaleChangeByTouch = true;
        if (this.newScale > 0.0f) {
            if (this.fCurrScale != this.newScale) {
                this.fCurrScale = this.newScale;
                this.newScale = 0.0f;
            }
            CFG.map.getMpC().checkPositionOfMapY();
            CFG.map.getMpC().checkPositionOfMapX();
            CFG.map.getMpC().updateSecondSideOfMap();
        }
    }

    public final void startScaleTheMap(int nX, int nX2, int nY, int nY2) {
        this.scaleMode = true;
        if (Math.max(nX, nX2) - Math.min(nX, nX2) > Math.max(nY, nY2) - Math.min(nY, nY2)) {
            this.scaleByYAxis = false;
            this.iStartScalePosY = nX;
            this.iStartScalePosY2 = nX2;
        } else {
            this.scaleByYAxis = true;
            this.iStartScalePosY = nY;
            this.iStartScalePosY2 = nY2;
        }
    }

    public final void scaleTheMap(int nX, int nX2, int nY, int nY2) {
        if (this.scaleByYAxis) {
            this.scaleTheMap(nY, nY2, Math.abs((float)(nX + nX2) / 2.0f), Math.abs((float)(nY + nY2) / 2.0f));
        } else {
            this.scaleTheMap(nX, nX2, Math.abs((float)(nX + nX2) / 2.0f), Math.abs((float)(nY + nY2) / 2.0f));
        }
    }

    private final void scaleTheMap(int nY, int nY2, float fCenterX, float fCenterY) {
        if (this.startScale < 0.0f) {
            this.iStartScaleMapPosX = CFG.map.getMpC().getPX();
            this.iStartScaleMapPosY = CFG.map.getMpC().getPY();
            this.startScale = this.fCurrScale;
        }
        if (this.iStartScalePosY != nY) {
            this.setNewCurrentScaleByTouch(this.fCurrScale + (float)(nY < nY2 ? this.iStartScalePosY - nY : nY - this.iStartScalePosY) / 150.0f / CFG.GUI_SCALE, fCenterX, fCenterY);
            this.iStartScalePosY = nY;
            CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
            CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
            this.resetScaleAnimation();
        }
        if (this.iStartScalePosY2 != nY2) {
            this.setNewCurrentScaleByTouch(this.fCurrScale + (float)(nY > nY2 ? this.iStartScalePosY2 - nY2 : nY2 - this.iStartScalePosY2) / 150.0f / CFG.GUI_SCALE, fCenterX, fCenterY);
            this.iStartScalePosY2 = nY2;
            CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
            CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
            this.resetScaleAnimation();
        }
    }

    protected final void resetScaleOfMap(long nActionDownTime) {
        if (nActionDownTime > 0L && this.changeCurrentScaleByX == 0.0f && CFG.currentTimeMillis < CFG.map.getTouchMgr().getActionDownTime() + 0L && !CFG.map.getMpC().getDisableMovingMap()) {
            this.resetScaleAnimation();
            this.scaleChangeByTouch = true;
            this.animation_StartingScale = this.fCurrScale;
            if (this.fCurrScale != STANDARD_SCALE) {
                this.fScaleBeforeReset = this.fCurrScale;
                this.changeCurrentScaleByX = STANDARD_SCALE - this.fCurrScale;
                this.definedScale = this.definedScaleBeforeReset;
            } else {
                this.changeCurrentScaleByX = this.fScaleBeforeReset - this.fCurrScale;
                this.fScaleBeforeReset = STANDARD_SCALE;
                this.definedScaleBeforeReset = this.definedScale;
                this.definedScale = MapScale.defScales.definedScale_Default;
            }
            this.animation_TIME_STARTED = CFG.currentTimeMillis;
            this.updateAnimationScale_CenterToXY(Touch.getMousePosX(), Touch.getMousePosY());
            animation_TIME_TO_END = 100;
            CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
            CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
            CFG.map.getMpSl().resetScrollInfo();
        }
        CFG.map.getTouchMgr().setActionDownTime(nActionDownTime);
    }

    public final void resetStartScalePosition() {
        this.iStartScalePosY2 = -1;
        this.iStartScalePosY = -1;
    }

    public final void resetScaleInfo() {
        this.resetStartScalePosition();
        this.scaleMode = false;
        this.startScale = -1.0f;
    }

    public final void setNewCurrentScaleByTouch(float nCurrentScale, float fCenterX, float fCenterY) {
        this.newScale = nCurrentScale > 500.0f ? 500.0f : (nCurrentScale < MINSCALE ? MINSCALE : nCurrentScale);
        this.scaleChangeByTouch = true;
        if (this.newScale > 0.0f) {
            if (this.fCurrScale != this.newScale) {
                this.fScaleAnimation_PercX = fCenterX / (float)CFG.GAMEWIDTH;
                this.fScaleAnimation_PercY = fCenterY / (float)CFG.GAMEHEIGHT;
                if (this.startScale < this.fCurrScale) {
                    CFG.map.getMpC().setNewPosX(this.iStartScaleMapPosX - (int)(((float)CFG.GAMEWIDTH / this.startScale - (float)CFG.GAMEWIDTH / this.newScale) * this.fScaleAnimation_PercX));
                    CFG.map.getMpC().setNewPosY(this.iStartScaleMapPosY - (int)(((float)CFG.GAMEHEIGHT / this.startScale - (float)CFG.GAMEHEIGHT / this.newScale) * this.fScaleAnimation_PercY));
                } else {
                    CFG.map.getMpC().setNewPosX(this.iStartScaleMapPosX - (int)(((float)CFG.GAMEWIDTH / this.startScale - (float)CFG.GAMEWIDTH / this.newScale) / 2.0f));
                    CFG.map.getMpC().setNewPosY(this.iStartScaleMapPosY - (int)(((float)CFG.GAMEHEIGHT / this.startScale - (float)CFG.GAMEHEIGHT / this.newScale) / 2.0f));
                }
                this.fCurrScale = this.newScale;
                this.newScale = 0.0f;
            }
            CFG.map.getMpC().checkPositionOfMapY();
            CFG.map.getMpC().checkPositionOfMapX();
            CFG.map.getMpC().updateSecondSideOfMap();
        }
    }

    protected final void updateAnimationScale_CenterToXY(int nPosX, int nPosY) {
        this.fScaleAnimation_PercX = (float)nPosX / (float)CFG.GAMEWIDTH;
        this.fScaleAnimation_PercY = (float)nPosY / (float)CFG.GAMEHEIGHT;
    }

    public final void scrollScale(int changeScaleByX) {
        float newMapScale;
        block12: {
            int i;
            this.definedScale += changeScaleByX;
            if (this.definedScale < 0) {
                this.definedScale = 0;
            } else if (this.definedScale >= MapScale.defScales.definedScales.length) {
                this.definedScale = MapScale.defScales.definedScales.length - 1;
                try {
                    if (GameValues.gvMapScroll.USE_MAP_SCALE_SCROLL_FIX_FOR_SMALL_MAPS) {
                        for (i = MapScale.defScales.definedScales.length - 2; i >= 0; --i) {
                            if (MapScale.defScales.definedScales[this.definedScale] != MapScale.defScales.definedScales[i]) continue;
                            this.definedScale = i;
                        }
                    }
                }
                catch (Exception i2) {
                    // empty catch block
                }
            }
            newMapScale = this.getDefinedScale();
            if (GameValues.gvMapScroll.USE_MAP_SCALE_SCROLL_FIX_FOR_SMALL_MAPS && newMapScale >= 0.995f && newMapScale <= 1.005f) {
                newMapScale = STANDARD_SCALE;
            }
            try {
                if (!(newMapScale < MINSCALE)) break block12;
                for (i = MapScale.defScales.definedScales.length - 1; i >= 0; --i) {
                    if (!(MapScale.defScales.definedScales[i] >= MINSCALE)) continue;
                    this.definedScale = i;
                    break;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (newMapScale != this.fCurrScale && newMapScale >= MINSCALE - 0.05f) {
            this.resetScaleAnimation();
            this.scaleChangeByTouch = false;
            animation_TIME_TO_END = 125;
            this.animation_StartingScale = this.fCurrScale;
            this.changeCurrentScaleByX = newMapScale - this.fCurrScale;
            this.fScaleBeforeReset = newMapScale;
            this.animation_TIME_STARTED = CFG.currentTimeMillis;
            this.updateAnimationScale_CenterToXY(Touch.getMousePosX(), Touch.getMousePosY());
        }
    }

    public final void setNewCurrentScaleByButton2(float newScale) {
        if (this.fDifferenceScale != 0.0f) {
            newScale += this.fDifferenceScale;
        }
        if ((newScale = this.fCurrScale + newScale) >= 0.995f && newScale <= 1.005f) {
            newScale = 1.0f;
        }
        if (newScale != this.fCurrScale && newScale >= MINSCALE) {
            if (System.currentTimeMillis() - this.iScaleAnimationTime > (long)SCALE_ANIMATION_TIME) {
                this.resetScaleAnimation();
                this.scaleChangeByTouch = false;
                SCALE_ANIMATION_TIME = 50;
                this.fStartScaling_Scale = this.fCurrScale;
                this.fDifferenceScale = newScale - this.fCurrScale;
                this.fScaleBeforeReset = newScale;
                this.iScaleAnimationTime = System.currentTimeMillis();
                this.updateScaleAnimation_PercXY(Touch.getMousePosX(), Touch.getMousePosY());
            }
            CFG.map.getMpSl().resetScrollInfo();
        }
    }

    public final void updateScaleAnimation_PercXY(int nPosX, int nPosY) {
        this.fScaleAnimation_PercX = (float)nPosX / (float)CFG.GAMEWIDTH;
        this.fScaleAnimation_PercY = (float)nPosY / (float)CFG.GAMEHEIGHT;
    }

    public final void update() {
        if (this.changeCurrentScaleByX != 0.0f) {
            this.updateScale();
        }
    }

    private final void updateScale() {
        float oldCurrentScale = this.fCurrScale;
        this.setCurrScale(this.animation_StartingScale + this.changeCurrentScaleByX * (float)Math.min(CFG.currentTimeMillis - this.animation_TIME_STARTED, (long)animation_TIME_TO_END) / (float)animation_TIME_TO_END);
        if (CFG.currentTimeMillis - this.animation_TIME_STARTED > (long)animation_TIME_TO_END) {
            if (this.fScaleBeforeReset != STANDARD_SCALE && this.scaleChangeByTouch || this.fCurrScale > 0.9925f && this.fCurrScale < 1.0075f) {
                this.setCurrScale(STANDARD_SCALE);
            }
            this.resetScaleAnimation();
        }
        CFG.map.getMpC().setNewPosX((int)((float)CFG.map.getMpC().getPX() - ((float)CFG.GAMEWIDTH / oldCurrentScale - (float)CFG.GAMEWIDTH / this.fCurrScale) * this.fScaleAnimation_PercX));
        CFG.map.getMpC().setNewPosY((int)((float)CFG.map.getMpC().getPY() - ((float)CFG.GAMEHEIGHT / oldCurrentScale - (float)CFG.GAMEHEIGHT / this.fCurrScale) * this.fScaleAnimation_PercY));
    }

    private final void resetScaleAnimation() {
        this.fDifferenceScale = 0.0f;
        this.iScaleAnimationTime = 0L;
        this.changeCurrentScaleByX = 0.0f;
        this.animation_TIME_STARTED = 0L;
    }

    public final void setCurrScale(float currentScale) {
        if (500.0f < currentScale) {
            currentScale = 500.0f;
        } else if (MINSCALE > currentScale) {
            currentScale = MINSCALE;
        }
        this.fCurrScale = currentScale;
        CFG.core.setuPRV(true);
    }

    public final float getCurrSc() {
        return this.fCurrScale;
    }

    public final float getMinimapScaleX() {
        return this.fMinimapScaleX;
    }

    public final float getMinimapScaled_ScaleX() {
        return (float)CFG.map.getMpB().iMinimapScaled_Width / ((float)CFG.map.getMpB().getMinimapWidth() - 2.0f);
    }

    public final float getMinimapScaled_ScaleY() {
        return (float)CFG.map.getMpB().iMinimapScaled_Height / ((float)CFG.map.getMpB().getMinimapHeight() - 2.0f);
    }

    public final void updateMinimapScaleXY() {
        this.fMinimapScaleX = (float)CFG.map.getMpB().getWidthM() / ((float)CFG.map.getMpB().getMinimapWidth() - 2.0f);
        this.fMinimapScaleY = (float)CFG.map.getMpB().getHeightM() / ((float)CFG.map.getMpB().getMinimapHeight() - 2.0f);
    }

    public final float getMinimapScaleY() {
        return this.fMinimapScaleY;
    }

    public final boolean getScaleMode() {
        return this.scaleMode;
    }

    public final void setScaleMode(boolean scaleMode) {
        this.scaleMode = scaleMode;
    }

    public final int getStartScalePosY() {
        return this.iStartScalePosY;
    }

    public final void setScaleBeforeReset(float fScaleBeforeReset) {
        this.fScaleBeforeReset = fScaleBeforeReset;
    }

    public static class DefinedScales {
        public int definedScale_Default = 15;
        public float[] definedScales = new float[]{10.0f, 9.0f, 8.0f, 7.0f, 6.0f, 5.0f, 4.0f, 3.52f, 3.0f, 2.52f, 2.0f, 1.76f, 1.52f, 1.24f, 1.0f, 0.92f, 0.8f, 0.68f, 0.6f, 0.52f, 0.44f, 0.4f, 0.32f, 0.24f, 0.16f, 0.12f, 0.092f, 0.08f, 0.06f, 0.06f};
    }
}

