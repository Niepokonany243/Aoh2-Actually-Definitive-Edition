/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Flag_Overlay_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Flag_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iDivisionID;
    public List<Color_GameData> lDivisionColors = new ArrayList<Color_GameData>();
    public List<Flag_Overlay_GameData> lOverlays = new ArrayList<Flag_Overlay_GameData>();
}

