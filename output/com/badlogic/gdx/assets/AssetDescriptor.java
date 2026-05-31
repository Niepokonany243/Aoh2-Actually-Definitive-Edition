/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.files.FileHandle;

public class AssetDescriptor<T> {
    public final String fileName;
    public final Class<T> type;
    public final AssetLoaderParameters params;
    public FileHandle file;

    public AssetDescriptor(String fileName, Class<T> assetType) {
        this(fileName, assetType, null);
    }

    public AssetDescriptor(FileHandle file, Class<T> assetType) {
        this(file, assetType, null);
    }

    public AssetDescriptor(String fileName, Class<T> assetType, AssetLoaderParameters<T> params) {
        this.fileName = fileName.replace('\\', '/');
        this.type = assetType;
        this.params = params;
    }

    public AssetDescriptor(FileHandle file, Class<T> assetType, AssetLoaderParameters<T> params) {
        this.fileName = file.path().replace('\\', '/');
        this.file = file;
        this.type = assetType;
        this.params = params;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fileName);
        sb.append(", ");
        sb.append(this.type.getName());
        return sb.toString();
    }
}

