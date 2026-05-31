
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Start.Menu_StartTheGame;

public class Start_The_Game_Data {
    private long lTime;
    private float fProvincesAlpha;
    private float fCapitalsAlpha;
    private float fWastelandAlpha;
    private float fStaightLinePercentage;
    private float fDashedLinePercentage;
    private boolean ready = false;
    private boolean reverse = false;
    private final int TIME_PROVINCE_ALPHA = 3250;
    private final int TIME_CAPITALS_PROVINCE_ALPHA = 1500;
    private final int TIME_STRAIGHT_LINE = 1250;
    private final int TIME_DASHED_LINE = 3500;
    public final float TIMER_MODFIER_END_GAME = 1.3f;

    public Start_The_Game_Data(boolean reverse) {
        if (reverse) {
            this.lTime = System.currentTimeMillis();
            this.fProvincesAlpha = CFG.settingsGD.PROV_ALPHA;
            this.fCapitalsAlpha = CFG.settingsGD.PROV_ALPHA;
            this.fWastelandAlpha = CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 255.0f;
            this.fStaightLinePercentage = 100.0f;
            this.fDashedLinePercentage = 100.0f;
        } else {
            this.lTime = System.currentTimeMillis();
            this.fProvincesAlpha = 0.0f;
            this.fCapitalsAlpha = 0.0f;
            this.fWastelandAlpha = 0.0f;
            this.fStaightLinePercentage = 2.0f;
            this.fDashedLinePercentage = 2.0f;
        }
        this.reverse = reverse;
    }

    public final void updateData() {
        if (this.reverse) {
            this.fProvincesAlpha -= Math.abs((float)(System.currentTimeMillis() - this.lTime) / 4225.0f * (float)CFG.settingsGD.PROV_ALPHA);
            this.fCapitalsAlpha = this.fProvincesAlpha;
            if (this.fProvincesAlpha < 0.0f) {
                this.fProvincesAlpha = 0.0f;
                this.fCapitalsAlpha = 0.0f;
            }
            this.fWastelandAlpha -= Math.abs((float)(System.currentTimeMillis() - this.lTime) / 4225.0f * (CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 255.0f));
            if (this.fWastelandAlpha < 0.0f) {
                this.fWastelandAlpha = 0.0f;
            }
            this.fStaightLinePercentage -= (float)(System.currentTimeMillis() - this.lTime) / 4550.0f * 98.0f;
            if (this.fStaightLinePercentage < 0.0f) {
                this.fStaightLinePercentage = 0.0f;
                this.ready = true;
            }
            this.fDashedLinePercentage -= (float)(System.currentTimeMillis() - this.lTime) / 1625.0f * 98.0f;
            if (this.fDashedLinePercentage < 0.0f) {
                this.fDashedLinePercentage = 0.0f;
            }
            this.lTime = System.currentTimeMillis();
        } else {
            this.fProvincesAlpha += Math.abs((float)(System.currentTimeMillis() - this.lTime) / 3250.0f * (float)CFG.settingsGD.PROV_ALPHA);
            if (this.fProvincesAlpha > (float)CFG.settingsGD.PROV_ALPHA) {
                this.fProvincesAlpha = CFG.settingsGD.PROV_ALPHA;
            }
            this.fWastelandAlpha += Math.abs((float)(System.currentTimeMillis() - this.lTime) / 3250.0f * (CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 255.0f));
            if (this.fWastelandAlpha > CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 255.0f) {
                this.fWastelandAlpha = CFG.settingsGD.PROVINCE_ALPHA_WASTELAND * 255.0f;
            }
            this.fCapitalsAlpha += Math.abs((float)(System.currentTimeMillis() - this.lTime) / 1500.0f * (float)CFG.settingsGD.PROV_ALPHA);
            if (this.fCapitalsAlpha > (float)CFG.settingsGD.PROV_ALPHA) {
                this.fCapitalsAlpha = CFG.settingsGD.PROV_ALPHA;
            }
            this.fStaightLinePercentage += (float)(System.currentTimeMillis() - this.lTime) / 1250.0f * 98.0f;
            if (this.fStaightLinePercentage > 100.0f) {
                this.fStaightLinePercentage = 100.0f;
            }
            this.fDashedLinePercentage += (float)(System.currentTimeMillis() - this.lTime) / 3500.0f * 98.0f;
            if (this.fDashedLinePercentage > 100.0f) {
                this.fDashedLinePercentage = 100.0f;
                this.ready = true;
                Menu_StartTheGame.done();
            }
            this.lTime = System.currentTimeMillis();
        }
    }

    public final int getProvincesAlpha() {
        return (int)Math.abs(this.fProvincesAlpha);
    }

    public final int getCapitalsAlpha() {
        return (int)Math.abs(this.fCapitalsAlpha);
    }

    public final int getWastelandAlpha() {
        return (int)Math.abs(this.fWastelandAlpha);
    }

    public final float getStraightLinePercentage() {
        return this.fStaightLinePercentage / 100.0f;
    }

    public final float getDashedLinePercentage() {
        return this.fDashedLinePercentage / 100.0f;
    }

    public final boolean getIsDone() {
        return this.ready;
    }
}

