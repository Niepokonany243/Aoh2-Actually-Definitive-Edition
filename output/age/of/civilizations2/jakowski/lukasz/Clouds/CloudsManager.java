
package age.of.civilizations2.jakowski.lukasz.Clouds;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Clouds.Cloud;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class CloudsManager {
    public List<Image> iCL = new ArrayList<Image>();
    public List<Integer> iCLMD = new ArrayList<Integer>();
    private List<Cloud> lC = new ArrayList<Cloud>();
    private int iCS = 0;
    private long lTDOA = 0L;
    private long lTDINA = 0L;
    private float fDA = 1.0f;
    public CloudsSettings cloudsSettings = new CloudsSettings();
    public static int updateInViewID = 0;
    public CloudsInterface cloudsInterface = new CloudsInterface(){

        @Override
        public void drawCloudsInterface(SpriteBatch oSB) {
        }
    };

    public boolean bLCL() {
        return CFG.getIsDesktop();
    }

    public final void loCI() {
        if (this.bLCL()) {
            int i;
            for (i = 0; i < this.cloudsSettings.numOfCloudImages; ++i) {
                this.iCL.add(IMGManager.loadImage("game/clouds/" + i + ".png"));
            }
            for (i = 0; i < this.cloudsSettings.numOfCloudImages; ++i) {
                this.iCLMD.add(Math.max(this.iCL.get(i).getWidth(), this.iCL.get(i).getHeight()));
            }
            for (i = 0; i < 25; ++i) {
                this.aCLO();
            }
        }
    }

    public final void readSettings() {
        Json json = new Json();
        FileHandle file = FileManager.loadFile("game/clouds/Config.json");
        this.cloudsSettings = json.fromJson(CloudsSettings.class, file);
        this.cloudsSettings.moveSpeedY = Math.max(0.1f, this.cloudsSettings.moveSpeedY);
        this.cloudsSettings.randomAlpha = Math.min(1.0f, this.cloudsSettings.randomAlpha);
        if (!this.bLCL()) {
            this.cloudsSettings.numOfCloudImages = 0;
        }
    }

    public final void aCLO() {
        this.aCLO(CFG.oR.nextInt(CFG.map.getMpB().getWidthM()), CFG.oR.nextInt(CFG.map.getMpB().getHeightM()));
    }

    public final void aCLO(int nPosX, int nPosY) {
        if (this.iCS < this.cloudsSettings.maxNumOfCloudsInTheGame && this.cloudsSettings.numOfCloudImages > 0) {
            int tempID = CFG.oR.nextInt(this.iCL.size());
            this.lC.add(new Cloud(tempID, nPosX, nPosY, (float)(10 + CFG.oR.nextInt(20) + CFG.oR.nextInt(25) + CFG.oR.nextInt(25) + CFG.oR.nextInt(46)) / 100.0f, CFG.oR.nextInt(360)));
            this.iCS = this.lC.size();
        }
    }

    public final void uCLO() {
        int i;
        for (i = this.lC.size() - 1; i >= 0; --i) {
            if (!this.lC.get(i).removeCloud()) continue;
            this.lC.remove(i);
            this.iCS = this.lC.size();
        }
        this.rSCL();
        Core.updateInView_CordsXY();
        for (i = 0; i < this.iCS; ++i) {
            this.lC.get(i).update();
        }
        for (i = updateInViewID = (updateInViewID + 1) % 8; i < this.iCS; i += 8) {
            this.lC.get(i).updateIsInView();
        }
    }

    public final void rSCL() {
        if (CFG.oR.nextFloat() < this.cloudsSettings.spawnCloudChance) {
            this.aCLO();
        }
    }

    public final void updateCloudsInterface() {
        if (!CFG.settingsGD.CLOUDS) {
            this.cloudsInterface = new CloudsInterface(){

                @Override
                public void drawCloudsInterface(SpriteBatch oSB) {
                }
            };
            this.lC.clear();
            this.iCS = 0;
        } else {
            this.cloudsInterface = new CloudsInterface(){

                @Override
                public void drawCloudsInterface(SpriteBatch oSB) {
                    CloudsManager.this.drC(oSB);
                }
            };
        }
    }

    public final void drC(SpriteBatch oSB) {
        if (CFG.map.getMpS().getCurrSc() > this.cloudsSettings.drawCloudsMinScale && CFG.map.getMpS().getCurrSc() < this.cloudsSettings.drawCloudsMaxScale) {
            this.lTDOA = CFG.currentTimeMillis;
            if (this.fDA < 1.0f) {
                this.fDA = Math.max(1.0f * ((float)(CFG.currentTimeMillis - this.lTDINA) / (float)CFG.cloudsAnimation.cloudsSettings.spawnAnimationTime), 0.0f);
                this.fDA = Math.min(this.fDA, 1.0f);
            }
            this.drC(oSB, this.fDA);
        } else {
            this.fDA = Math.max(1.0f - 1.0f * ((float)(CFG.currentTimeMillis - this.lTDOA) / (float)CFG.cloudsAnimation.cloudsSettings.spawnAnimationTime), 0.0f);
            this.lTDINA = CFG.currentTimeMillis - (long)((float)CFG.cloudsAnimation.cloudsSettings.spawnAnimationTime * this.fDA);
            if (this.fDA > 0.01f) {
                this.drC(oSB, this.fDA);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drC(SpriteBatch oSB, float modAlpha) {
        int i;
        this.uCLO();
        for (i = 0; i < this.iCS; ++i) {
            if (!this.lC.get((int)i).isInView) continue;
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, this.lC.get((int)i).fAlpha * modAlpha));
            this.iCL.get(this.lC.get((int)i).iCloudImageID).draw(oSB, (int)this.lC.get((int)i).iPosX + this.lC.get((int)i).iPosX_SecondSideOfMap + CFG.map.getMpC().getPX() + this.lC.get((int)i).iShadowX, (int)this.lC.get((int)i).iPosY + CFG.map.getMpC().getPY() + this.lC.get((int)i).iShadowY, this.lC.get((int)i).fScale * 0.75f, (float)this.lC.get((int)i).iRotate);
        }
        if (CFG.map.getMpS().getCurrSc() < 1.0f) {
            modAlpha *= 1.0f + (1.0f - CFG.map.getMpS().getCurrSc()) / 2.0f;
        }
        for (i = 0; i < this.iCS; ++i) {
            if (!this.lC.get((int)i).isInView) continue;
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.lC.get((int)i).fAlpha * modAlpha));
            this.iCL.get(this.lC.get((int)i).iCloudImageID).draw(oSB, (int)this.lC.get((int)i).iPosX + this.lC.get((int)i).iPosX_SecondSideOfMap + CFG.map.getMpC().getPX(), (int)this.lC.get((int)i).iPosY + CFG.map.getMpC().getPY(), this.lC.get((int)i).fScale, (float)this.lC.get((int)i).iRotate);
        }
        oSB.setColor(Color.WHITE);
    }

    public static class CloudsSettings {
        public int numOfCloudImages;
        public int maxNumOfCloudsInTheGame;
        public float spawnCloudChance;
        public int spawnAnimationTime;
        public float moveSpeedX;
        public float moveSpeedY;
        public int shadowX;
        public int shadowY;
        public float minAlpha;
        public float randomAlpha;
        public float drawCloudsMinScale;
        public float drawCloudsMaxScale;
    }

    public static interface CloudsInterface {
        public void drawCloudsInterface(SpriteBatch var1);
    }
}

