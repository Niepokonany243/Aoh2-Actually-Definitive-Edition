
package age.of.civilizations2.jakowski.lukasz.Clouds;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;

public class Cloud {
    private boolean animationStart = true;
    public int iCloudImageID;
    public boolean isInView;
    public float iPosX;
    public int iPosX_SecondSideOfMap;
    public float iPosY;
    public float fScale;
    public int iRotate;
    public float fAlpha;
    public float fFinalAlpha;
    public int iShadowX;
    public int iShadowY;
    private long lTime;
    public int iMax_WidthHeight = 0;
    public int iHeight_RemoveCloud = 0;

    public Cloud(int iCloudImageID, int nPosX, int nPosY, float fScale, int iRotate) {
        this.init(iCloudImageID, nPosX, nPosY, fScale, iRotate);
    }

    public final void init(int iCloudImageID, int nPosX, int nPosY, float fScale, int iRotate) {
        this.iCloudImageID = iCloudImageID;
        this.iRotate = iRotate;
        this.iPosX = nPosX;
        this.iPosY = nPosY;
        this.fScale = fScale;
        this.fFinalAlpha = CFG.cloudsAnimation.cloudsSettings.minAlpha + (float)CFG.oR.nextInt(Math.max(1, (int)(CFG.cloudsAnimation.cloudsSettings.randomAlpha * 1000.0f))) / 1000.0f;
        this.fAlpha = 0.0f;
        this.iShadowX = (int)((float)CFG.cloudsAnimation.cloudsSettings.shadowX * Math.max(1.0f, fScale));
        this.iShadowY = (int)((float)CFG.cloudsAnimation.cloudsSettings.shadowY * Math.max(1.0f, fScale));
        this.lTime = CFG.currentTimeMillis;
        this.iMax_WidthHeight = (int)((float)CFG.cloudsAnimation.iCLMD.get(iCloudImageID).intValue() * fScale);
        this.iHeight_RemoveCloud = (int)((float)(-CFG.cloudsAnimation.iCL.get(iCloudImageID).getHeight()) * fScale);
    }

    public final void update() {
        this.iPosX += CFG.cloudsAnimation.cloudsSettings.moveSpeedX;
        this.iPosY -= CFG.cloudsAnimation.cloudsSettings.moveSpeedY;
        if (this.iPosX + (float)CFG.cloudsAnimation.iCL.get(this.iCloudImageID).getWidth() * this.fScale > (float)CFG.map.getMpB().getWidthM()) {
            this.iPosX -= (float)CFG.map.getMpB().getWidthM();
        }
        if (this.animationStart) {
            this.fAlpha = Math.min(this.fFinalAlpha * ((float)(CFG.currentTimeMillis - this.lTime) / (float)CFG.cloudsAnimation.cloudsSettings.spawnAnimationTime), this.fFinalAlpha);
            if (CFG.currentTimeMillis - this.lTime > (long)CFG.cloudsAnimation.cloudsSettings.spawnAnimationTime) {
                this.animationStart = false;
                this.fAlpha = this.fFinalAlpha;
            }
        }
    }

    public final void updateIsInView() {
        if (this.inViewY()) {
            if (this.inViewX()) {
                this.isInView = true;
                this.iPosX_SecondSideOfMap = 0;
                return;
            }
            if (CFG.map.getMpC().getSecondSideOfMap() && this.inViewX2()) {
                this.isInView = true;
                this.iPosX_SecondSideOfMap = CFG.map.getMpB().getWidthM();
                return;
            }
        }
        this.isInView = false;
    }

    public final boolean inViewY() {
        return (float)(Core.inViewY_CordsY_Height + this.iMax_WidthHeight) >= this.iPosY && (float)(Core.inViewY_CordsY - this.iMax_WidthHeight) <= this.iPosY + (float)this.iMax_WidthHeight;
    }

    public final boolean inViewX() {
        return (float)(Core.inViewX_CordsX_Width + this.iMax_WidthHeight) >= this.iPosX && (float)(Core.inViewX_CordsX - this.iMax_WidthHeight) <= this.iPosX + (float)this.iMax_WidthHeight;
    }

    public final boolean inViewX2() {
        return (float)(Core.inViewX_CordsX_Width + this.iMax_WidthHeight) >= this.iPosX + (float)CFG.map.getMpB().getWidthM() && (float)(Core.inViewX_CordsX - this.iMax_WidthHeight) <= this.iPosX + (float)CFG.map.getMpB().getWidthM() + (float)this.iMax_WidthHeight;
    }

    public final boolean removeCloud() {
        return this.iPosY < (float)this.iHeight_RemoveCloud;
    }
}

