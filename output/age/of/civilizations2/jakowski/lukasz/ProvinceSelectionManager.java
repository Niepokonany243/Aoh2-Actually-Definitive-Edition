package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Next-Gen Province Selection Manager
 * Centralizes selection state and notifies listeners.
 */
public class ProvinceSelectionManager {
    private static int activeProvinceID = -1;
    private static List<SelectionListener> listeners = new ArrayList<SelectionListener>();

    public interface SelectionListener {
        void onSelectionChanged(int oldID, int newID);
    }

    public static void addListener(SelectionListener listener) {
        listeners.add(listener);
    }

    public static void removeListener(SelectionListener listener) {
        listeners.remove(listener);
    }

    public static int getSelectedProvinceID() {
        return activeProvinceID;
    }

    public static void setSelectedProvinceID(int newID) {
        if (activeProvinceID == newID) return;

        int oldID = activeProvinceID;
        activeProvinceID = newID;

        // Legacy compatibility - update Core state
        CFG.core.iActiveProv(newID);

        notifyListeners(oldID, newID);
        handleLegacySideEffects(oldID, newID);
    }

    private static void notifyListeners(int oldID, int newID) {
        for (SelectionListener listener : listeners) {
            listener.onSelectionChanged(oldID, newID);
        }
    }

    /**
     * Handles legacy side effects in a controlled manner.
     * This will be refactored further to decouple more systems.
     */
    private static void handleLegacySideEffects(int oldID, int newID) {
        // Update army drawing for old and new
        if (oldID >= 0 && oldID < CFG.core.getProvinSize()) {
            CFG.core.getProv(oldID).updateDrawArmyInProv();
        }
        if (newID >= 0 && newID < CFG.core.getProvinSize()) {
            CFG.core.getProv(newID).updateDrawArmyInProv();
            // Color picker support
            if (CFG.menus.getColorPicker() != null) {
                CFG.menus.getColorPicker().getColorPickerAction().setActiveProvince_Action();
            }
        }

        if (CFG.menus.getInGameView()) {
            // Check province action menu visibility
            if (!CFG.chooseProvinceMode && !CFG.regroupArmyMode) {
                CFG.core.checkProvinceActionMenu();
            }

            // Province "More" info menu
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                if (newID < 0) {
                    CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                } else {
                    int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    int ownerCivID = CFG.core.getProv(newID).getCivId();
                    if (ownerCivID != playerCivID && CFG.core.getCiv(ownerCivID).getPuppetOfCiv() != playerCivID) {
                        CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                    } else {
                        BuildingsManager.iBuildInProvinceID = newID;
                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                    }
                }
            }

            // Notify map modes
            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                CFG.mapModesManager.getActiveView().updateActiveProvinceID_ExtraAction(oldID, newID);
            }

            // Update main province info UI
            CFG.gameAction.updateInGame_ProvinceInfo();
        }

        // Reset hover and animation
        if (CFG.isAndroid()) {
            CFG.menus.resetHoverActive();
        }
        CFG.core.resetActiveProvAnimationData();
        CFG.core.updateLTimeActiveCities();
    }
}
