
package age.of.civilizations2.jakowski.lukasz.MapA.Mode;

import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;

public class MapMode {
    public boolean drawCivNamesOver = false;
    public boolean canMoveArmy = false;
    public Render.Renderer oRenderer;
    public RenderProvince.DrawProvinces drawProvinces;

    public void enableViewAction() {
    }

    public void disableViewAction() {
    }

    public void updateActiveCivInfo_ExtraAction(int newCivID) {
    }

    public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
    }

    public void setActiveProvinceAction() {
    }

    public ME_Hover getProvinceInformation() {
        return null;
    }

    public boolean canMoveArmy() {
        return this.canMoveArmy;
    }
}

