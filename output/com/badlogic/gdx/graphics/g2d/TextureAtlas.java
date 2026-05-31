/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class TextureAtlas
implements Disposable {
    private final ObjectSet<Texture> textures = new ObjectSet(4);
    private final Array<AtlasRegion> regions = new Array();

    public TextureAtlas() {
    }

    public TextureAtlas(String internalPackFile) {
        this(Gdx.files.internal(internalPackFile));
    }

    public TextureAtlas(FileHandle packFile) {
        this(packFile, packFile.parent());
    }

    public TextureAtlas(FileHandle packFile, boolean flip) {
        this(packFile, packFile.parent(), flip);
    }

    public TextureAtlas(FileHandle packFile, FileHandle imagesDir) {
        this(packFile, imagesDir, false);
    }

    public TextureAtlas(FileHandle packFile, FileHandle imagesDir, boolean flip) {
        this(new TextureAtlasData(packFile, imagesDir, flip));
    }

    public TextureAtlas(TextureAtlasData data) {
        this.load(data);
    }

    public void load(TextureAtlasData data) {
        this.textures.ensureCapacity(data.pages.size);
        for (TextureAtlasData.Page page : data.pages) {
            if (page.texture == null) {
                page.texture = new Texture(page.textureFile, page.format, page.useMipMaps);
            }
            page.texture.setFilter(page.minFilter, page.magFilter);
            page.texture.setWrap(page.uWrap, page.vWrap);
            this.textures.add(page.texture);
        }
        this.regions.ensureCapacity(data.regions.size);
        for (TextureAtlasData.Region region : data.regions) {
            AtlasRegion atlasRegion = new AtlasRegion(region.page.texture, region.left, region.top, region.rotate ? region.height : region.width, region.rotate ? region.width : region.height);
            atlasRegion.index = region.index;
            atlasRegion.name = region.name;
            atlasRegion.offsetX = region.offsetX;
            atlasRegion.offsetY = region.offsetY;
            atlasRegion.originalHeight = region.originalHeight;
            atlasRegion.originalWidth = region.originalWidth;
            atlasRegion.rotate = region.rotate;
            atlasRegion.degrees = region.degrees;
            atlasRegion.names = region.names;
            atlasRegion.values = region.values;
            if (region.flip) {
                atlasRegion.flip(false, true);
            }
            this.regions.add(atlasRegion);
        }
    }

    public AtlasRegion addRegion(String name, Texture texture, int x, int y, int width, int height) {
        this.textures.add(texture);
        AtlasRegion region = new AtlasRegion(texture, x, y, width, height);
        region.name = name;
        this.regions.add(region);
        return region;
    }

    public AtlasRegion addRegion(String name, TextureRegion textureRegion) {
        this.textures.add(textureRegion.texture);
        AtlasRegion region = new AtlasRegion(textureRegion);
        region.name = name;
        this.regions.add(region);
        return region;
    }

    public Array<AtlasRegion> getRegions() {
        return this.regions;
    }

    @Null
    public AtlasRegion findRegion(String name) {
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            if (!this.regions.get((int)i).name.equals(name)) continue;
            return this.regions.get(i);
        }
        return null;
    }

    @Null
    public AtlasRegion findRegion(String name, int index) {
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            AtlasRegion region = this.regions.get(i);
            if (!region.name.equals(name) || region.index != index) continue;
            return region;
        }
        return null;
    }

    public Array<AtlasRegion> findRegions(String name) {
        Array<AtlasRegion> matched = new Array<AtlasRegion>(AtlasRegion.class);
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            AtlasRegion region = this.regions.get(i);
            if (!region.name.equals(name)) continue;
            matched.add(new AtlasRegion(region));
        }
        return matched;
    }

    public Array<Sprite> createSprites() {
        Array<Sprite> sprites = new Array<Sprite>(true, this.regions.size, Sprite.class);
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            sprites.add(this.newSprite(this.regions.get(i)));
        }
        return sprites;
    }

    @Null
    public Sprite createSprite(String name) {
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            if (!this.regions.get((int)i).name.equals(name)) continue;
            return this.newSprite(this.regions.get(i));
        }
        return null;
    }

    @Null
    public Sprite createSprite(String name, int index) {
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            AtlasRegion region = this.regions.get(i);
            if (region.index != index || !region.name.equals(name)) continue;
            return this.newSprite(this.regions.get(i));
        }
        return null;
    }

    public Array<Sprite> createSprites(String name) {
        Array<Sprite> matched = new Array<Sprite>(Sprite.class);
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            AtlasRegion region = this.regions.get(i);
            if (!region.name.equals(name)) continue;
            matched.add(this.newSprite(region));
        }
        return matched;
    }

    private Sprite newSprite(AtlasRegion region) {
        if (region.packedWidth == region.originalWidth && region.packedHeight == region.originalHeight) {
            if (region.rotate) {
                Sprite sprite = new Sprite(region);
                sprite.setBounds(0.0f, 0.0f, region.getRegionHeight(), region.getRegionWidth());
                sprite.rotate90(true);
                return sprite;
            }
            return new Sprite(region);
        }
        return new AtlasSprite(region);
    }

    @Null
    public NinePatch createPatch(String name) {
        int n = this.regions.size;
        for (int i = 0; i < n; ++i) {
            AtlasRegion region = this.regions.get(i);
            if (!region.name.equals(name)) continue;
            int[] splits = region.findValue("split");
            if (splits == null) {
                throw new IllegalArgumentException("Region does not have ninepatch splits: " + name);
            }
            NinePatch patch = new NinePatch((TextureRegion)region, splits[0], splits[1], splits[2], splits[3]);
            int[] pads = region.findValue("pad");
            if (pads != null) {
                patch.setPadding(pads[0], pads[1], pads[2], pads[3]);
            }
            return patch;
        }
        return null;
    }

    public ObjectSet<Texture> getTextures() {
        return this.textures;
    }

    @Override
    public void dispose() {
        for (Texture texture : this.textures) {
            texture.dispose();
        }
        this.textures.clear(0);
    }

    public static class AtlasSprite
    extends Sprite {
        final AtlasRegion region;
        float originalOffsetX;
        float originalOffsetY;

        public AtlasSprite(AtlasRegion region) {
            this.region = new AtlasRegion(region);
            this.originalOffsetX = region.offsetX;
            this.originalOffsetY = region.offsetY;
            this.setRegion(region);
            this.setOrigin((float)region.originalWidth / 2.0f, (float)region.originalHeight / 2.0f);
            int width = region.getRegionWidth();
            int height = region.getRegionHeight();
            if (region.rotate) {
                super.rotate90(true);
                super.setBounds(region.offsetX, region.offsetY, height, width);
            } else {
                super.setBounds(region.offsetX, region.offsetY, width, height);
            }
            this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public AtlasSprite(AtlasSprite sprite) {
            this.region = sprite.region;
            this.originalOffsetX = sprite.originalOffsetX;
            this.originalOffsetY = sprite.originalOffsetY;
            this.set(sprite);
        }

        @Override
        public void setPosition(float x, float y) {
            super.setPosition(x + this.region.offsetX, y + this.region.offsetY);
        }

        @Override
        public void setX(float x) {
            super.setX(x + this.region.offsetX);
        }

        @Override
        public void setY(float y) {
            super.setY(y + this.region.offsetY);
        }

        @Override
        public void setBounds(float x, float y, float width, float height) {
            float widthRatio = width / (float)this.region.originalWidth;
            float heightRatio = height / (float)this.region.originalHeight;
            this.region.offsetX = this.originalOffsetX * widthRatio;
            this.region.offsetY = this.originalOffsetY * heightRatio;
            int packedWidth = this.region.rotate ? this.region.packedHeight : this.region.packedWidth;
            int packedHeight = this.region.rotate ? this.region.packedWidth : this.region.packedHeight;
            super.setBounds(x + this.region.offsetX, y + this.region.offsetY, (float)packedWidth * widthRatio, (float)packedHeight * heightRatio);
        }

        @Override
        public void setSize(float width, float height) {
            this.setBounds(this.getX(), this.getY(), width, height);
        }

        @Override
        public void setOrigin(float originX, float originY) {
            super.setOrigin(originX - this.region.offsetX, originY - this.region.offsetY);
        }

        @Override
        public void setOriginCenter() {
            super.setOrigin(this.width / 2.0f - this.region.offsetX, this.height / 2.0f - this.region.offsetY);
        }

        @Override
        public void flip(boolean x, boolean y) {
            if (this.region.rotate) {
                super.flip(y, x);
            } else {
                super.flip(x, y);
            }
            float oldOriginX = this.getOriginX();
            float oldOriginY = this.getOriginY();
            float oldOffsetX = this.region.offsetX;
            float oldOffsetY = this.region.offsetY;
            float widthRatio = this.getWidthRatio();
            float heightRatio = this.getHeightRatio();
            this.region.offsetX = this.originalOffsetX;
            this.region.offsetY = this.originalOffsetY;
            this.region.flip(x, y);
            this.originalOffsetX = this.region.offsetX;
            this.originalOffsetY = this.region.offsetY;
            this.region.offsetX *= widthRatio;
            this.region.offsetY *= heightRatio;
            this.translate(this.region.offsetX - oldOffsetX, this.region.offsetY - oldOffsetY);
            this.setOrigin(oldOriginX, oldOriginY);
        }

        @Override
        public void rotate90(boolean clockwise) {
            super.rotate90(clockwise);
            float oldOriginX = this.getOriginX();
            float oldOriginY = this.getOriginY();
            float oldOffsetX = this.region.offsetX;
            float oldOffsetY = this.region.offsetY;
            float widthRatio = this.getWidthRatio();
            float heightRatio = this.getHeightRatio();
            if (clockwise) {
                this.region.offsetX = oldOffsetY;
                this.region.offsetY = (float)this.region.originalHeight * heightRatio - oldOffsetX - (float)this.region.packedWidth * widthRatio;
            } else {
                this.region.offsetX = (float)this.region.originalWidth * widthRatio - oldOffsetY - (float)this.region.packedHeight * heightRatio;
                this.region.offsetY = oldOffsetX;
            }
            this.translate(this.region.offsetX - oldOffsetX, this.region.offsetY - oldOffsetY);
            this.setOrigin(oldOriginX, oldOriginY);
        }

        @Override
        public float getX() {
            return super.getX() - this.region.offsetX;
        }

        @Override
        public float getY() {
            return super.getY() - this.region.offsetY;
        }

        @Override
        public float getOriginX() {
            return super.getOriginX() + this.region.offsetX;
        }

        @Override
        public float getOriginY() {
            return super.getOriginY() + this.region.offsetY;
        }

        @Override
        public float getWidth() {
            return super.getWidth() / this.region.getRotatedPackedWidth() * (float)this.region.originalWidth;
        }

        @Override
        public float getHeight() {
            return super.getHeight() / this.region.getRotatedPackedHeight() * (float)this.region.originalHeight;
        }

        public float getWidthRatio() {
            return super.getWidth() / this.region.getRotatedPackedWidth();
        }

        public float getHeightRatio() {
            return super.getHeight() / this.region.getRotatedPackedHeight();
        }

        public AtlasRegion getAtlasRegion() {
            return this.region;
        }

        public String toString() {
            return this.region.toString();
        }
    }

    public static class AtlasRegion
    extends TextureRegion {
        public int index = -1;
        public String name;
        public float offsetX;
        public float offsetY;
        public int packedWidth;
        public int packedHeight;
        public int originalWidth;
        public int originalHeight;
        public boolean rotate;
        public int degrees;
        @Null
        public String[] names;
        @Null
        public int[][] values;

        public AtlasRegion(Texture texture, int x, int y, int width, int height) {
            super(texture, x, y, width, height);
            this.originalWidth = width;
            this.originalHeight = height;
            this.packedWidth = width;
            this.packedHeight = height;
        }

        public AtlasRegion(AtlasRegion region) {
            this.setRegion(region);
            this.index = region.index;
            this.name = region.name;
            this.offsetX = region.offsetX;
            this.offsetY = region.offsetY;
            this.packedWidth = region.packedWidth;
            this.packedHeight = region.packedHeight;
            this.originalWidth = region.originalWidth;
            this.originalHeight = region.originalHeight;
            this.rotate = region.rotate;
            this.degrees = region.degrees;
            this.names = region.names;
            this.values = region.values;
        }

        public AtlasRegion(TextureRegion region) {
            this.setRegion(region);
            this.packedWidth = region.getRegionWidth();
            this.packedHeight = region.getRegionHeight();
            this.originalWidth = this.packedWidth;
            this.originalHeight = this.packedHeight;
        }

        @Override
        public void flip(boolean x, boolean y) {
            super.flip(x, y);
            if (x) {
                this.offsetX = (float)this.originalWidth - this.offsetX - this.getRotatedPackedWidth();
            }
            if (y) {
                this.offsetY = (float)this.originalHeight - this.offsetY - this.getRotatedPackedHeight();
            }
        }

        public float getRotatedPackedWidth() {
            return this.rotate ? (float)this.packedHeight : (float)this.packedWidth;
        }

        public float getRotatedPackedHeight() {
            return this.rotate ? (float)this.packedWidth : (float)this.packedHeight;
        }

        @Null
        public int[] findValue(String name) {
            if (this.names != null) {
                int n = this.names.length;
                for (int i = 0; i < n; ++i) {
                    if (!name.equals(this.names[i])) continue;
                    return this.values[i];
                }
            }
            return null;
        }

        public String toString() {
            return this.name;
        }
    }

    public static class TextureAtlasData {
        final Array<Page> pages = new Array();
        final Array<Region> regions = new Array();

        public TextureAtlasData() {
        }

        public TextureAtlasData(FileHandle packFile, FileHandle imagesDir, boolean flip) {
            this.load(packFile, imagesDir, flip);
        }

        public void load(FileHandle packFile, FileHandle imagesDir, boolean flip) {
            final String[] entry = new String[5];
            ObjectMap<String, Field<Page>> pageFields = new ObjectMap<String, Field<Page>>(15, 0.99f);
            pageFields.put("size", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.width = Integer.parseInt(entry[1]);
                    page.height = Integer.parseInt(entry[2]);
                }
            });
            pageFields.put("format", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.format = Pixmap.Format.valueOf(entry[1]);
                }
            });
            pageFields.put("filter", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.minFilter = Texture.TextureFilter.valueOf(entry[1]);
                    page.magFilter = Texture.TextureFilter.valueOf(entry[2]);
                    page.useMipMaps = page.minFilter.isMipMap();
                }
            });
            pageFields.put("repeat", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    if (entry[1].indexOf(120) != -1) {
                        page.uWrap = Texture.TextureWrap.Repeat;
                    }
                    if (entry[1].indexOf(121) != -1) {
                        page.vWrap = Texture.TextureWrap.Repeat;
                    }
                }
            });
            pageFields.put("pma", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.pma = entry[1].equals("true");
                }
            });
            final boolean[] hasIndexes = new boolean[]{false};
            ObjectMap<String, Field<Region>> regionFields = new ObjectMap<String, Field<Region>>(127, 0.99f);
            regionFields.put("xy", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.left = Integer.parseInt(entry[1]);
                    region.top = Integer.parseInt(entry[2]);
                }
            });
            regionFields.put("size", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.width = Integer.parseInt(entry[1]);
                    region.height = Integer.parseInt(entry[2]);
                }
            });
            regionFields.put("bounds", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.left = Integer.parseInt(entry[1]);
                    region.top = Integer.parseInt(entry[2]);
                    region.width = Integer.parseInt(entry[3]);
                    region.height = Integer.parseInt(entry[4]);
                }
            });
            regionFields.put("offset", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.offsetX = Integer.parseInt(entry[1]);
                    region.offsetY = Integer.parseInt(entry[2]);
                }
            });
            regionFields.put("orig", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.originalWidth = Integer.parseInt(entry[1]);
                    region.originalHeight = Integer.parseInt(entry[2]);
                }
            });
            regionFields.put("offsets", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.offsetX = Integer.parseInt(entry[1]);
                    region.offsetY = Integer.parseInt(entry[2]);
                    region.originalWidth = Integer.parseInt(entry[3]);
                    region.originalHeight = Integer.parseInt(entry[4]);
                }
            });
            regionFields.put("rotate", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    String value = entry[1];
                    if (value.equals("true")) {
                        region.degrees = 90;
                    } else if (!value.equals("false")) {
                        region.degrees = Integer.parseInt(value);
                    }
                    region.rotate = region.degrees == 90;
                }
            });
            regionFields.put("index", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.index = Integer.parseInt(entry[1]);
                    if (region.index != -1) {
                        hasIndexes[0] = true;
                    }
                }
            });
            BufferedReader reader = new BufferedReader(new InputStreamReader(packFile.read()), 1024);
            try {
                String line = reader.readLine();
                while (line != null && line.trim().length() == 0) {
                    line = reader.readLine();
                }
                while (line != null && line.trim().length() != 0 && TextureAtlasData.readEntry(entry, line) != 0) {
                    line = reader.readLine();
                }
                Page page = null;
                Array<String> names = null;
                Array<int[]> values = null;
                while (line != null) {
                    int count;
                    if (line.trim().length() == 0) {
                        page = null;
                        line = reader.readLine();
                        continue;
                    }
                    if (page == null) {
                        page = new Page();
                        page.textureFile = imagesDir.child(line);
                        while (TextureAtlasData.readEntry(entry, line = reader.readLine()) != 0) {
                            Field field = (Field)pageFields.get(entry[0]);
                            if (field == null) continue;
                            field.parse(page);
                        }
                        this.pages.add(page);
                        continue;
                    }
                    Region region = new Region();
                    region.page = page;
                    region.name = line.trim();
                    if (flip) {
                        region.flip = true;
                    }
                    while ((count = TextureAtlasData.readEntry(entry, line = reader.readLine())) != 0) {
                        Field field = (Field)regionFields.get(entry[0]);
                        if (field != null) {
                            field.parse(region);
                            continue;
                        }
                        if (names == null) {
                            names = new Array<String>(8);
                            values = new Array<int[]>(8);
                        }
                        names.add(entry[0]);
                        int[] entryValues = new int[count];
                        for (int i = 0; i < count; ++i) {
                            try {
                                entryValues[i] = Integer.parseInt(entry[i + 1]);
                                continue;
                            }
                            catch (NumberFormatException numberFormatException) {
                                // empty catch block
                            }
                        }
                        values.add(entryValues);
                    }
                    if (region.originalWidth == 0 && region.originalHeight == 0) {
                        region.originalWidth = region.width;
                        region.originalHeight = region.height;
                    }
                    if (names != null && names.size > 0) {
                        region.names = names.toArray(String.class);
                        region.values = values.toArray(int[].class);
                        names.clear();
                        values.clear();
                    }
                    this.regions.add(region);
                }
            }
            catch (Exception ex) {
                throw new GdxRuntimeException("Error reading texture atlas file: " + packFile, ex);
            }
            finally {
                StreamUtils.closeQuietly(reader);
            }
            if (hasIndexes[0]) {
                this.regions.sort(new Comparator<Region>(){

                    @Override
                    public int compare(Region region1, Region region2) {
                        int i2;
                        int i1 = region1.index;
                        if (i1 == -1) {
                            i1 = Integer.MAX_VALUE;
                        }
                        if ((i2 = region2.index) == -1) {
                            i2 = Integer.MAX_VALUE;
                        }
                        return i1 - i2;
                    }
                });
            }
        }

        public Array<Page> getPages() {
            return this.pages;
        }

        public Array<Region> getRegions() {
            return this.regions;
        }

        private static int readEntry(String[] entry, @Null String line) throws IOException {
            if (line == null) {
                return 0;
            }
            if ((line = line.trim()).length() == 0) {
                return 0;
            }
            int colon = line.indexOf(58);
            if (colon == -1) {
                return 0;
            }
            entry[0] = line.substring(0, colon).trim();
            int i = 1;
            int lastMatch = colon + 1;
            while (true) {
                int comma;
                if ((comma = line.indexOf(44, lastMatch)) == -1) {
                    entry[i] = line.substring(lastMatch).trim();
                    return i;
                }
                entry[i] = line.substring(lastMatch, comma).trim();
                lastMatch = comma + 1;
                if (i == 4) {
                    return 4;
                }
                ++i;
            }
        }

        public static class Region {
            public Page page;
            public String name;
            public int left;
            public int top;
            public int width;
            public int height;
            public float offsetX;
            public float offsetY;
            public int originalWidth;
            public int originalHeight;
            public int degrees;
            public boolean rotate;
            public int index = -1;
            @Null
            public String[] names;
            @Null
            public int[][] values;
            public boolean flip;

            @Null
            public int[] findValue(String name) {
                if (this.names != null) {
                    int n = this.names.length;
                    for (int i = 0; i < n; ++i) {
                        if (!name.equals(this.names[i])) continue;
                        return this.values[i];
                    }
                }
                return null;
            }
        }

        public static class Page {
            @Null
            public FileHandle textureFile;
            @Null
            public Texture texture;
            public float width;
            public float height;
            public boolean useMipMaps;
            public Pixmap.Format format = Pixmap.Format.RGBA8888;
            public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
            public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
            public Texture.TextureWrap uWrap = Texture.TextureWrap.ClampToEdge;
            public Texture.TextureWrap vWrap = Texture.TextureWrap.ClampToEdge;
            public boolean pma;
        }

        private static interface Field<T> {
            public void parse(T var1);
        }
    }
}

