
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Toast {
    public static final int TIME_INVIEW_SHORT = 1500;
    public static final int TIME_INVIEW_STANDARD = 2000;
    public static final int TIME_INVIEW_LONG = 2500;
    public static final int TIME_INVIEW_VERY_LONG = 3500;
    public static final int TIME_INVIEW_VERY_VERY_LONG = 4500;
    private static final float TIME_START_OPACITY_PERCENTAGE = 0.4f;
    private boolean inView = false;
    private List<String> lMessage = new ArrayList<String>();
    private List<Integer> lMessageWidth = new ArrayList<Integer>();
    private List<Color> lMessageColor = new ArrayList<Color>();
    private int iMessagesSize = 0;
    private int iMaxWidth = 0;
    private int iTimeInView = 2000;
    private long lTime = 0L;
    private float fAlpha = 1.0f;

    public final void draw(SpriteBatch oSB) {
        if (this.lTime + (long)this.iTimeInView < System.currentTimeMillis()) {
            this.inView = false;
        } else if (this.lTime + (long)((int)((float)this.iTimeInView * 0.4f)) < System.currentTimeMillis()) {
            this.fAlpha = CFG.getColorStep(255, 0, (int)(System.currentTimeMillis() - this.lTime - (long)((int)((float)this.iTimeInView * 0.4f))), this.iTimeInView - (int)((float)this.iTimeInView * 0.4f));
            if (this.fAlpha < 0.0f) {
                this.fAlpha = 0.0f;
            }
        }
        oSB.setColor(1.0f, 1.0f, 1.0f, this.fAlpha);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXT() - CFG.PADD * 3, this.getPosYT() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1) - CFG.PADD * 2 - IMGManager.getIMG(Images.gameBox).getHeight(), this.getWidthT() + CFG.PADD * 6 - IMGManager.getIMG(Images.gameBox).getWidth(), (int)Math.ceil((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f));
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXT() + this.getWidthT() + CFG.PADD * 3 - IMGManager.getIMG(Images.gameBox).getWidth(), this.getPosYT() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1) - CFG.PADD * 2 - IMGManager.getIMG(Images.gameBox).getHeight(), IMGManager.getIMG(Images.gameBox).getWidth(), (int)Math.ceil((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f), true, false);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXT() - CFG.PADD * 3, this.getPosYT() + this.getHeightT() + CFG.PADD * 2 - (int)Math.floor((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f) - IMGManager.getIMG(Images.gameBox).getHeight(), this.getWidthT() + CFG.PADD * 6 - IMGManager.getIMG(Images.gameBox).getWidth(), (int)Math.floor((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f), false, true);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXT() + this.getWidthT() + CFG.PADD * 3 - IMGManager.getIMG(Images.gameBox).getWidth(), this.getPosYT() + this.getHeightT() + CFG.PADD * 2 - (int)Math.floor((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f) - IMGManager.getIMG(Images.gameBox).getHeight(), IMGManager.getIMG(Images.gameBox).getWidth(), (int)Math.floor((float)(this.getHeightT() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1)) / 2.0f), true, true);
        try {
            for (int i = 0; i < this.iMessagesSize; ++i) {
                try {
                    CFG.drawTextDefault(oSB, this.lMessage.get(i), CFG.GAMEWIDTH / 2 - this.lMessageWidth.get(i) / 2, this.getPosYT() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1 - i), new Color(this.lMessageColor.get((int)i).r, this.lMessageColor.get((int)i).g, this.lMessageColor.get((int)i).b, this.fAlpha));
                    continue;
                }
                catch (Exception ex) {
                    CFG.drawTextDefault(oSB, this.lMessage.get(i), CFG.GAMEWIDTH / 2 - this.lMessageWidth.get(i) / 2, this.getPosYT() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * (this.iMessagesSize - 1 - i) + (int)((float)(CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2.0f), new Color(0.925f, 0.925f, 0.925f, this.fAlpha));
                }
            }
        }
        catch (Exception exception) {
            
        }
        oSB.setColor(Color.WHITE);
    }

    private final int getPosXT() {
        return CFG.GAMEWIDTH / 2 - this.iMaxWidth / 2;
    }

    private final int getPosYT() {
        return CFG.GAMEHEIGHT - CFG.PADD * 4 - CFG.TEXT_HEIGHT_DEFAULT;
    }

    private final int getWidthT() {
        return this.iMaxWidth;
    }

    private final int getHeightT() {
        return CFG.TEXT_HEIGHT_DEFAULT;
    }

    public final boolean getInView() {
        return this.inView;
    }

    public final void addM(boolean inView) {
        this.inView = inView;
    }

    public final void addM(String sMessage) {
        this.lMessage.clear();
        this.lMessageWidth.clear();
        this.lMessageColor.clear();
        this.lMessage.add(sMessage);
        CFG.glyphLay.setText(CFG.fontMain.get(0), sMessage);
        this.lMessageWidth.add((int)CFG.glyphLay.width);
        this.iMaxWidth = this.lMessageWidth.get(0);
        this.iMessagesSize = this.lMessage.size();
        this.addM();
    }

    public final void addM(String sMessage, Color tColor) {
        try {
            MenuManager.TOAST_TIME = CFG.currentTimeMillis;
            this.lMessage.clear();
            this.lMessageWidth.clear();
            this.lMessageColor.clear();
            this.lMessage.add(sMessage);
            this.lMessageColor.add(tColor);
            try {
                CFG.glyphLay.setText(CFG.fontMain.get(0), sMessage);
                this.lMessageWidth.add((int)CFG.glyphLay.width);
            }
            catch (Exception ex) {
                try {
                    CFG.glyphLay.setText(CFG.fontMain.get(0), sMessage);
                    this.lMessageWidth.add((int)CFG.glyphLay.width);
                }
                catch (Exception exception) {
                    
                }
            }
            this.iMaxWidth = this.lMessageWidth.get(0);
            this.iMessagesSize = this.lMessage.size();
            this.addM();
        }
        catch (Exception exception) {
            
        }
    }

    public final void addM(List<String> nMessages) {
        int i;
        MenuManager.TOAST_TIME = CFG.currentTimeMillis;
        this.lMessage.clear();
        this.lMessageWidth.clear();
        this.lMessageColor.clear();
        for (i = 0; i < nMessages.size(); ++i) {
            this.lMessage.add(nMessages.get(i));
            try {
                CFG.glyphLay.setText(CFG.fontMain.get(0), nMessages.get(i));
                this.lMessageWidth.add((int)CFG.glyphLay.width);
                continue;
            }
            catch (Exception ex) {
                try {
                    CFG.glyphLay.setText(CFG.fontMain.get(0), nMessages.get(i));
                    this.lMessageWidth.add((int)CFG.glyphLay.width);
                    continue;
                }
                catch (Exception exception) {
                    
                }
            }
        }
        this.iMaxWidth = 0;
        this.iMessagesSize = this.lMessage.size();
        for (i = 0; i < this.iMessagesSize; ++i) {
            if (this.iMaxWidth >= this.lMessageWidth.get(i)) continue;
            this.iMaxWidth = this.lMessageWidth.get(i);
        }
        this.addM();
    }

    public final void addM(List<String> nMessages, List<Color> nColor) {
        int i;
        MenuManager.TOAST_TIME = CFG.currentTimeMillis;
        this.lMessage.clear();
        this.lMessageWidth.clear();
        this.lMessageColor = nColor;
        for (i = 0; i < nMessages.size(); ++i) {
            this.lMessage.add(nMessages.get(i));
            try {
                CFG.glyphLay.setText(CFG.fontMain.get(0), nMessages.get(i));
                this.lMessageWidth.add((int)CFG.glyphLay.width);
                continue;
            }
            catch (Exception ex) {
                try {
                    CFG.glyphLay.setText(CFG.fontMain.get(0), nMessages.get(i));
                    this.lMessageWidth.add((int)CFG.glyphLay.width);
                    continue;
                }
                catch (Exception exception) {
                    
                }
            }
        }
        this.iMaxWidth = 0;
        this.iMessagesSize = this.lMessage.size();
        for (i = 0; i < this.iMessagesSize; ++i) {
            if (this.iMaxWidth >= this.lMessageWidth.get(i)) continue;
            this.iMaxWidth = this.lMessageWidth.get(i);
        }
        this.addM();
    }

    private final void addM() {
        this.inView = true;
        this.fAlpha = 1.0f;
        this.lTime = System.currentTimeMillis();
        this.iTimeInView = 2000;
    }

    public final void setTimeInView(int iTimeInView) {
        this.iTimeInView = iTimeInView;
    }
}

