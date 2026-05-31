/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

public final class VertexAttribute {
    public final int usage;
    public final int numComponents;
    public final boolean normalized;
    public final int type;
    public int offset;
    public String alias;
    public int unit;
    private final int usageIndex;

    public VertexAttribute(int usage, int numComponents, String alias) {
        this(usage, numComponents, alias, 0);
    }

    public VertexAttribute(int usage, int numComponents, String alias, int unit) {
        this(usage, numComponents, usage == 4 ? 5121 : 5126, usage == 4, alias, unit);
    }

    public VertexAttribute(int usage, int numComponents, int type, boolean normalized, String alias) {
        this(usage, numComponents, type, normalized, alias, 0);
    }

    public VertexAttribute(int usage, int numComponents, int type, boolean normalized, String alias, int unit) {
        this.usage = usage;
        this.numComponents = numComponents;
        this.type = type;
        this.normalized = normalized;
        this.alias = alias;
        this.unit = unit;
        this.usageIndex = Integer.numberOfTrailingZeros(usage);
    }

    public VertexAttribute copy() {
        return new VertexAttribute(this.usage, this.numComponents, this.type, this.normalized, this.alias, this.unit);
    }

    public static VertexAttribute Position() {
        return new VertexAttribute(1, 3, "a_position");
    }

    public static VertexAttribute TexCoords(int unit) {
        return new VertexAttribute(16, 2, "a_texCoord" + unit, unit);
    }

    public static VertexAttribute Normal() {
        return new VertexAttribute(8, 3, "a_normal");
    }

    public static VertexAttribute ColorPacked() {
        return new VertexAttribute(4, 4, 5121, true, "a_color");
    }

    public static VertexAttribute ColorUnpacked() {
        return new VertexAttribute(2, 4, 5126, false, "a_color");
    }

    public static VertexAttribute Tangent() {
        return new VertexAttribute(128, 3, "a_tangent");
    }

    public static VertexAttribute Binormal() {
        return new VertexAttribute(256, 3, "a_binormal");
    }

    public static VertexAttribute BoneWeight(int unit) {
        return new VertexAttribute(64, 2, "a_boneWeight" + unit, unit);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VertexAttribute)) {
            return false;
        }
        return this.equals((VertexAttribute)obj);
    }

    public boolean equals(VertexAttribute other) {
        return other != null && this.usage == other.usage && this.numComponents == other.numComponents && this.type == other.type && this.normalized == other.normalized && this.alias.equals(other.alias) && this.unit == other.unit;
    }

    public int getKey() {
        return (this.usageIndex << 8) + (this.unit & 0xFF);
    }

    public int getSizeInBytes() {
        switch (this.type) {
            case 5126: 
            case 5132: {
                return 4 * this.numComponents;
            }
            case 5120: 
            case 5121: {
                return this.numComponents;
            }
            case 5122: 
            case 5123: {
                return 2 * this.numComponents;
            }
        }
        return 0;
    }

    public int hashCode() {
        int result = this.getKey();
        result = 541 * result + this.numComponents;
        result = 541 * result + this.alias.hashCode();
        return result;
    }
}

