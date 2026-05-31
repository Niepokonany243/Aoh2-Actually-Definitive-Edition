/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class TextData {
    private String sText;
    private int iWidth;

    public TextData(String sText) {
        this.sText = sText;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
        this.iWidth = (int)CFG.glyphLay.width;
    }

    public String getString() {
        return this.sText;
    }

    public int getWidth() {
        return this.iWidth;
    }
}

