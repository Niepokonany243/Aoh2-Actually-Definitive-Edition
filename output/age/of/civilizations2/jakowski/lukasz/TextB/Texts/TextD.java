/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class TextD {
    public String text;
    public int textW;

    public TextD(String nText) {
        this.text = nText;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.text);
        this.textW = (int)CFG.glyphLay.width;
    }

    public TextD(String nText, int fontID) {
        this.text = nText;
        CFG.glyphLay.setText(CFG.fontMain.get(fontID), this.text);
        this.textW = (int)CFG.glyphLay.width;
    }
}

