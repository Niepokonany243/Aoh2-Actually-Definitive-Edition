
package age.of.civilizations2.jakowski.lukasz.Provinces;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DiploAnimation {
    public int iProvinceID = 0;
    public int civID = 0;
    public int imageID = 0;
    public int iPosX = 0;
    public int iPosY = 0;
    public long lTime = 0L;
    public int TURN_ID = 0;
    public boolean remove = false;
    public Color colorN = Color.WHITE;

    public DiploAnimation(int civID, int iProvinceID, int imageID) {
        this.iProvinceID = iProvinceID;
        this.civID = civID;
        this.imageID = imageID;
        this.iPosX = CFG.core.getProv(iProvinceID).getCeShX();
        this.iPosY = CFG.core.getProv(iProvinceID).getCeShY();
        this.TURN_ID = GameCalendar.TURNID;
        this.colorN = CFG.COLOR_WAR_DARK;
    }

    public void draw(SpriteBatch oSB) {
        if (GameCalendar.TURNID - this.TURN_ID > 5) {
            this.remove = true;
            return;
        }
        if (this.iProvinceID >= CFG.core.getProvinSize()) {
            this.remove = true;
            return;
        }
        if (GameCalendar.TURNID < this.TURN_ID) {
            this.remove = true;
            return;
        }
        try {
            if (CFG.core.getProv(this.iProvinceID).getDrawProv() && !this.remove) {
                if (this.lTime == 0L) {
                    this.lTime = CFG.currentTimeMillis;
                }
                float fProgress = Math.min(1.0f, (float)(CFG.currentTimeMillis - this.lTime) / (float)GameValues.gvProvinceAnimation.DIPLOMACY_ANIMATION_TIME);
                int currentW = (int)((float)IMGManager.getIMG(this.imageID).getWidth() * CFG.map.getMpS().getCurrSc());
                int currentH = (int)((float)IMGManager.getIMG(this.imageID).getHeight() * CFG.map.getMpS().getCurrSc());
                float moveProgress = Math.min(1.0f, fProgress / 0.85f);
                float yOffset = (float)currentH * 0.225f * moveProgress;
                int nPosX = (int)((float)(this.iPosX + CFG.core.getProv(this.iProvinceID).getTranslateProvPosX()) * CFG.map.getMpS().getCurrSc());
                int nPosY = (int)((float)(this.iPosY + CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc());
                float alpha = 1.0f;
                if (fProgress > 0.85f) {
                    float fadeProgress = (fProgress - 0.85f) / 0.15f;
                    alpha = 1.0f - fadeProgress;
                }
                oSB.setColor(new Color(this.colorN.r, this.colorN.g, this.colorN.b, alpha));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX - currentW, (int)((float)(nPosY - currentH) - yOffset), currentW * 2, currentH / 2);
                IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX - currentW, (int)((float)nPosY - yOffset - (float)(currentH / 2)), currentW * 2, currentH / 2, false, true);
                oSB.setColor(1.0f, 1.0f, 1.0f, alpha);
                IMGManager.getIMG(this.imageID).draw(oSB, nPosX - currentW / 2, (int)((float)nPosY - yOffset - (float)currentH), currentW, currentH);
                oSB.setColor(1.0f, 1.0f, 1.0f, alpha);
                oSB.setShader(Renderer.shaderAlpha);
                CFG.core.getCiv(this.civID).getFlagC().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                currentW = (int)((float)IMGManager.getIMG(Images.flagCapitalOver).getWidth() * CFG.map.getMpS().getCurrSc());
                int currentH2 = (int)((float)IMGManager.getIMG(Images.flagCapitalOver).getHeight() * CFG.map.getMpS().getCurrSc());
                nPosY = nPosY - (int)yOffset - currentH / 2;
                IMGManager.getIMG(Images.flagCapitalMask).draw(oSB, nPosX -= currentW / 2, nPosY, currentW, currentH2);
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
                IMGManager.getIMG(Images.flagCapitalOver).draw(oSB, nPosX, nPosY, currentW, currentH2);
                oSB.setColor(Color.WHITE);
                if (fProgress >= 1.0f) {
                    this.remove = true;
                }
                oSB.setColor(Color.WHITE);
            }
        }
        catch (Exception ex) {
            this.remove = true;
        }
    }
}

