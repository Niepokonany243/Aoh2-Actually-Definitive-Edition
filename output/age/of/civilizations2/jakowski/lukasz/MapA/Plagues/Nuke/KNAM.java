/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class KNAM {
    public int oXS = 0;
    public static long tKSO = 0L;
    public int eZY = 0;
    public int eRTR = 0;
    public boolean mRM = false;
    public long URS = 0L;
    public int mGCR = 0;
    public int iDPO = 0;

    public void draw(SpriteBatch oSB) {
        if (GameCalendar.TURNID - this.eRTR > 10) {
            this.mRM = true;
        }
        if (this.iDPO >= CFG.core.getProvinSize()) {
            this.mRM = true;
            return;
        }
        try {
            if (CFG.core.getProv(this.iDPO).getDrawProv() && !this.mRM) {
                if (this.URS == 0L) {
                    this.URS = CFG.currentTimeMillis;
                    if (tKSO + (long)GameValues.gvAtomic.ATOMIC_BOMB_SOUND_EFFECT_LOCK_TIME < CFG.currentTimeMillis) {
                        tKSO = CFG.currentTimeMillis;
                        CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
                    }
                }
                float fProgress = 0.1f + 0.9f * Math.min(1.0f, (float)((CFG.currentTimeMillis - this.URS) / (long)GameValues.gvAtomic.ATOMIC_BOMB_ANIMATION_TIME));
                int currentW = (int)((float)IMGManager.getIMG(Images.nukeImg.get(0)).getWidth() * CFG.map.getMpS().getCurrSc());
                int currentH = (int)((float)IMGManager.getIMG(Images.nukeImg.get(0)).getHeight() * CFG.map.getMpS().getCurrSc());
                int nPosX = (int)((float)(this.oXS + CFG.core.getProv(this.iDPO).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc());
                int nPosY = (int)((float)(this.eZY + CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc());
                float fProgress2 = 1.0f - 0.9f * Math.min(1.0f, (float)this.mGCR / (float)Images.nukeIMGSize);
                oSB.setColor(new Color(Colors.HOVER_YELLOW.r, Colors.HOVER_YELLOW.g, Colors.HOVER_YELLOW.b, 0.2f * fProgress2));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX - currentW, nPosY - currentH, currentW * 2, currentH);
                IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX - currentW, nPosY + currentH - currentH, currentW * 2, currentH, false, true);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                IMGManager.getIMG(Images.nukeImg.get(this.mGCR)).draw(oSB, nPosX - currentW / 2, nPosY - currentH / 2, currentW, currentH);
                if (fProgress >= 1.0f) {
                    ++this.mGCR;
                    this.URS = CFG.currentTimeMillis;
                    if (this.mGCR >= Images.nukeIMGSize) {
                        this.mGCR = 0;
                        this.mRM = true;
                    }
                }
                oSB.setColor(Color.WHITE);
            }
        }
        catch (Exception ex) {
            this.mRM = true;
        }
    }

    public KNAM(int iDPO) {
        this.iDPO = iDPO;
        if (CFG.core.getProv(iDPO).getCitSize() > 0) {
            this.oXS = CFG.core.getProv(iDPO).getCit(0).getPoX() * CFG.map.getMpB().getMapSc3();
            this.eZY = CFG.core.getProv(iDPO).getCit(0).getPosY() * CFG.map.getMpB().getMapSc3();
        } else {
            this.oXS = CFG.core.getProv(iDPO).getCeShX();
            this.eZY = CFG.core.getProv(iDPO).getCeShY();
        }
        this.eRTR = GameCalendar.TURNID;
    }
}

