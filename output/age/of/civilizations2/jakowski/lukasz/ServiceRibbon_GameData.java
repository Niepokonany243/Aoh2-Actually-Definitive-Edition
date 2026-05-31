
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Overlay_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceRibbon_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<ServiceRibbon_Overlay_GameData> lLayers = new ArrayList<ServiceRibbon_Overlay_GameData>();

    public final ServiceRibbon_Overlay_GameData getServiceRibbon_Overlay(int i) {
        return this.lLayers.get(i);
    }

    public final void addServiceRibbonOverlay(ServiceRibbon_Overlay_GameData nOverlay) {
        this.lLayers.add(nOverlay);
    }

    public final void removeServiceRibbon_Overlay(int i) {
        this.lLayers.remove(i);
    }

    public final int getSize() {
        return this.lLayers.size();
    }
}

