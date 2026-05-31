
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;
import java.util.List;

public class Menu_FlagPixel_Color {
    private List<Float> lR = new ArrayList<Float>();
    private List<Float> lG = new ArrayList<Float>();
    private List<Float> lB = new ArrayList<Float>();
    private List<Float> lA = new ArrayList<Float>();

    public Menu_FlagPixel_Color() {
        for (int i = 0; i < CFG.CIV_FLAG_WIDTH; ++i) {
            for (int j = 0; j < CFG.CIV_FLAG_HEIGHT; ++j) {
                this.lR.add(Float.valueOf(1.0f));
                this.lG.add(Float.valueOf(1.0f));
                this.lB.add(Float.valueOf(1.0f));
                this.lA.add(Float.valueOf(1.0f));
            }
        }
        this.lA.set(0, Float.valueOf(0.0f));
        this.lA.set(CFG.CIV_FLAG_WIDTH - 1, Float.valueOf(0.0f));
        this.lA.set(CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT - 1, Float.valueOf(0.0f));
        this.lA.set(CFG.CIV_FLAG_WIDTH * CFG.CIV_FLAG_HEIGHT - 1 - CFG.CIV_FLAG_WIDTH + 1, Float.valueOf(0.0f));
    }

    public final float getR(int ID) {
        return this.lR.get(ID).floatValue();
    }

    public final void setR(int ID, float nR) {
        this.lR.set(ID, Float.valueOf(nR));
    }

    public final float getG(int ID) {
        return this.lG.get(ID).floatValue();
    }

    public final void setG(int ID, float nG) {
        this.lG.set(ID, Float.valueOf(nG));
    }

    public final float getB(int ID) {
        return this.lB.get(ID).floatValue();
    }

    public final void setB(int ID, float nB) {
        this.lB.set(ID, Float.valueOf(nB));
    }

    public final float getA(int ID) {
        return this.lA.get(ID).floatValue();
    }

    public final void setA(int ID, float nA) {
        this.lA.set(ID, Float.valueOf(nA));
    }
}

