/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;

public class MapGroupLayer
extends MapLayer {
    private MapLayers layers = new MapLayers();

    public MapLayers getLayers() {
        return this.layers;
    }

    @Override
    public void invalidateRenderOffset() {
        super.invalidateRenderOffset();
        for (int i = 0; i < this.layers.size(); ++i) {
            MapLayer child = this.layers.get(i);
            child.invalidateRenderOffset();
        }
    }
}

