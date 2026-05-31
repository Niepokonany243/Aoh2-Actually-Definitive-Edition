/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Graph_Vertical_Info {
    private List<String> lTexts = null;
    private int iTextsSize = 0;
    private List<Integer> lTextWidths = null;
    private List<Color> lColors = null;
    private boolean moveable = false;
    private boolean moveRight = false;
    private int iTextWidth = 0;
    private int iTextPosX = 0;
    private long lTime = 0L;
    private List<Integer> lSortedIDs = null;

    public Graph_Vertical_Info(List<String> nTexts, List<Color> nColors, int iWidth, boolean nSortText) {
        int i;
        this.iTextsSize = nTexts.size();
        this.lTexts = new ArrayList<String>();
        this.lColors = new ArrayList<Color>();
        this.lSortedIDs = new ArrayList<Integer>();
        ArrayList<Boolean> tempAdded = new ArrayList<Boolean>();
        for (i = 0; i < this.iTextsSize; ++i) {
            this.lSortedIDs.add(i);
            tempAdded.add(false);
        }
        if (nSortText) {
            while (nTexts.size() != this.lTexts.size()) {
                int i2;
                int nMinID = 0;
                for (i2 = 0; i2 < this.iTextsSize; ++i2) {
                    if (((Boolean)tempAdded.get(i2)).booleanValue()) continue;
                    nMinID = i2;
                    break;
                }
                for (i2 = nMinID + 1; i2 < this.iTextsSize; ++i2) {
                    if (((Boolean)tempAdded.get(i2)).booleanValue() || !CFG.compareAlphabetic_TwoString(nTexts.get(nMinID), nTexts.get(i2))) continue;
                    nMinID = i2;
                }
                this.lTexts.add(nTexts.get(nMinID));
                this.lColors.add(nColors.get(nMinID));
                tempAdded.set(nMinID, true);
                this.lSortedIDs.set(nMinID, this.lTexts.size() - 1);
            }
        } else {
            this.lTexts = nTexts;
            this.lColors = nColors;
        }
        this.lTextWidths = new ArrayList<Integer>();
        CFG.fontMain.get(0).getData().setScale(0.7f);
        for (i = 0; i < this.iTextsSize; ++i) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.lTexts.get(i));
            this.iTextWidth += (int)CFG.glyphLay.width;
            this.lTextWidths.add((int)CFG.glyphLay.width);
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        this.iTextWidth += CFG.PADD * this.iTextsSize + CFG.PADD * (this.iTextsSize - 1) + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f * (float)this.iTextsSize);
        this.updateMoveable(iWidth);
    }

    public final void updateMoveable(int iWidth) {
        if (this.iTextWidth > iWidth) {
            this.moveable = true;
            this.resetMoveable();
        } else {
            this.resetMoveable();
            this.moveable = false;
            this.iTextPosX = iWidth / 2 - this.iTextWidth / 2;
        }
    }

    public final void draw(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        if (this.moveable) {
            Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - (((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f)) + CFG.PADD), nWidth, ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f)) + CFG.PADD);
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            if (this.lTime < System.currentTimeMillis() - 45L) {
                this.lTime = System.currentTimeMillis();
                if (this.moveRight) {
                    --this.iTextPosX;
                    if (-this.iTextPosX + nWidth >= this.iTextWidth + CFG.PADD) {
                        this.moveRight = !this.moveRight;
                    }
                    CFG.setRenderO(true);
                } else {
                    ++this.iTextPosX;
                    if (this.iTextPosX >= 0) {
                        this.moveRight = !this.moveRight;
                    }
                    CFG.setRenderO(true);
                }
            } else {
                CFG.setRenderO(true);
            }
        }
        int tempOffsetX = 0;
        for (int i = 0; i < this.iTextsSize; ++i) {
            oSB.setColor(this.lColors.get(i));
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + tempOffsetX + this.iTextPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f), (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f));
            oSB.setColor(new Color(this.lColors.get((int)i).r, this.lColors.get((int)i).g, this.lColors.get((int)i).b, 0.7f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + tempOffsetX + this.iTextPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f), (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f));
            CFG.drawTextDefaultWithShadow(oSB, this.lTexts.get(i), nPosX + (tempOffsetX += (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD) + this.iTextPosX, nPosY, new Color(this.lColors.get((int)i).r, this.lColors.get((int)i).g, this.lColors.get((int)i).b, 0.7f));
            tempOffsetX += this.lTextWidths.get(i) + CFG.PADD;
        }
        if (this.moveable) {
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
    }

    public final void resetMoveable() {
        this.iTextPosX = 0;
        this.moveRight = true;
    }

    public final int getTextSize() {
        return this.iTextsSize;
    }

    public final String getText(int i) {
        return this.lTexts.get(i);
    }

    public final int getSortedID(int i) {
        return this.lSortedIDs.get(i);
    }

    public final List<Color> getColors() {
        return this.lColors;
    }
}

