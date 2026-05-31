/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.OrderedMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PixmapPacker
implements Disposable {
    boolean packToTexture;
    boolean disposed;
    int pageWidth;
    int pageHeight;
    Pixmap.Format pageFormat;
    int padding;
    boolean duplicateBorder;
    boolean stripWhitespaceX;
    boolean stripWhitespaceY;
    int alphaThreshold;
    Color transparentColor = new Color(0.0f, 0.0f, 0.0f, 0.0f);
    final Array<Page> pages = new Array();
    PackStrategy packStrategy;
    static Pattern indexPattern = Pattern.compile("(.+)_(\\d+)$");
    private Color c = new Color();

    public PixmapPacker(int pageWidth, int pageHeight, Pixmap.Format pageFormat, int padding, boolean duplicateBorder) {
        this(pageWidth, pageHeight, pageFormat, padding, duplicateBorder, false, false, new GuillotineStrategy());
    }

    public PixmapPacker(int pageWidth, int pageHeight, Pixmap.Format pageFormat, int padding, boolean duplicateBorder, PackStrategy packStrategy) {
        this(pageWidth, pageHeight, pageFormat, padding, duplicateBorder, false, false, packStrategy);
    }

    public PixmapPacker(int pageWidth, int pageHeight, Pixmap.Format pageFormat, int padding, boolean duplicateBorder, boolean stripWhitespaceX, boolean stripWhitespaceY, PackStrategy packStrategy) {
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
        this.pageFormat = pageFormat;
        this.padding = padding;
        this.duplicateBorder = duplicateBorder;
        this.stripWhitespaceX = stripWhitespaceX;
        this.stripWhitespaceY = stripWhitespaceY;
        this.packStrategy = packStrategy;
    }

    public void sort(Array<Pixmap> images) {
        this.packStrategy.sort(images);
    }

    public synchronized Rectangle pack(Pixmap image) {
        return this.pack(null, image);
    }

    public synchronized Rectangle pack(String name, Pixmap image) {
        PixmapPackerRectangle rect;
        if (this.disposed) {
            return null;
        }
        if (name != null && this.getRect(name) != null) {
            throw new GdxRuntimeException("Pixmap has already been packed with name: " + name);
        }
        Pixmap pixmapToDispose = null;
        if (name != null && name.endsWith(".9")) {
            rect = new PixmapPackerRectangle(0, 0, image.getWidth() - 2, image.getHeight() - 2);
            pixmapToDispose = new Pixmap(image.getWidth() - 2, image.getHeight() - 2, image.getFormat());
            pixmapToDispose.setBlending(Pixmap.Blending.None);
            rect.splits = this.getSplits(image);
            rect.pads = this.getPads(image, rect.splits);
            pixmapToDispose.drawPixmap(image, 0, 0, 1, 1, image.getWidth() - 1, image.getHeight() - 1);
            image = pixmapToDispose;
            name = name.split("\\.")[0];
        } else if (this.stripWhitespaceX || this.stripWhitespaceY) {
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int top = 0;
            int bottom = image.getHeight();
            if (this.stripWhitespaceY) {
                int alpha;
                int pixel;
                int x;
                int y;
                block0: for (y = 0; y < image.getHeight(); ++y) {
                    for (x = 0; x < image.getWidth(); ++x) {
                        pixel = image.getPixel(x, y);
                        alpha = pixel & 0xFF;
                        if (alpha > this.alphaThreshold) break block0;
                    }
                    ++top;
                }
                y = image.getHeight();
                block2: while (--y >= top) {
                    for (x = 0; x < image.getWidth(); ++x) {
                        pixel = image.getPixel(x, y);
                        alpha = pixel & 0xFF;
                        if (alpha > this.alphaThreshold) break block2;
                    }
                    --bottom;
                }
            }
            int left = 0;
            int right = image.getWidth();
            if (this.stripWhitespaceX) {
                int alpha;
                int pixel;
                int y;
                int x;
                block4: for (x = 0; x < image.getWidth(); ++x) {
                    for (y = top; y < bottom; ++y) {
                        pixel = image.getPixel(x, y);
                        alpha = pixel & 0xFF;
                        if (alpha > this.alphaThreshold) break block4;
                    }
                    ++left;
                }
                x = image.getWidth();
                block6: while (--x >= left) {
                    for (y = top; y < bottom; ++y) {
                        pixel = image.getPixel(x, y);
                        alpha = pixel & 0xFF;
                        if (alpha > this.alphaThreshold) break block6;
                    }
                    --right;
                }
            }
            int newWidth = right - left;
            int newHeight = bottom - top;
            pixmapToDispose = new Pixmap(newWidth, newHeight, image.getFormat());
            pixmapToDispose.setBlending(Pixmap.Blending.None);
            pixmapToDispose.drawPixmap(image, 0, 0, left, top, newWidth, newHeight);
            image = pixmapToDispose;
            rect = new PixmapPackerRectangle(0, 0, newWidth, newHeight, left, top, originalWidth, originalHeight);
        } else {
            rect = new PixmapPackerRectangle(0, 0, image.getWidth(), image.getHeight());
        }
        if (rect.getWidth() > (float)this.pageWidth || rect.getHeight() > (float)this.pageHeight) {
            if (name == null) {
                throw new GdxRuntimeException("Page size too small for pixmap.");
            }
            throw new GdxRuntimeException("Page size too small for pixmap: " + name);
        }
        Page page = this.packStrategy.pack(this, name, rect);
        if (name != null) {
            page.rects.put(name, rect);
            page.addedRects.add(name);
        }
        int rectX = (int)rect.x;
        int rectY = (int)rect.y;
        int rectWidth = (int)rect.width;
        int rectHeight = (int)rect.height;
        if (this.packToTexture && !this.duplicateBorder && page.texture != null && !page.dirty) {
            page.texture.bind();
            Gdx.gl.glTexSubImage2D(page.texture.glTarget, 0, rectX, rectY, rectWidth, rectHeight, image.getGLFormat(), image.getGLType(), image.getPixels());
        } else {
            page.dirty = true;
        }
        page.image.drawPixmap(image, rectX, rectY);
        if (this.duplicateBorder) {
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            page.image.drawPixmap(image, 0, 0, 1, 1, rectX - 1, rectY - 1, 1, 1);
            page.image.drawPixmap(image, imageWidth - 1, 0, 1, 1, rectX + rectWidth, rectY - 1, 1, 1);
            page.image.drawPixmap(image, 0, imageHeight - 1, 1, 1, rectX - 1, rectY + rectHeight, 1, 1);
            page.image.drawPixmap(image, imageWidth - 1, imageHeight - 1, 1, 1, rectX + rectWidth, rectY + rectHeight, 1, 1);
            page.image.drawPixmap(image, 0, 0, imageWidth, 1, rectX, rectY - 1, rectWidth, 1);
            page.image.drawPixmap(image, 0, imageHeight - 1, imageWidth, 1, rectX, rectY + rectHeight, rectWidth, 1);
            page.image.drawPixmap(image, 0, 0, 1, imageHeight, rectX - 1, rectY, 1, rectHeight);
            page.image.drawPixmap(image, imageWidth - 1, 0, 1, imageHeight, rectX + rectWidth, rectY, 1, rectHeight);
        }
        if (pixmapToDispose != null) {
            pixmapToDispose.dispose();
        }
        return rect;
    }

    public Array<Page> getPages() {
        return this.pages;
    }

    public synchronized Rectangle getRect(String name) {
        for (Page page : this.pages) {
            Rectangle rect = (Rectangle)page.rects.get(name);
            if (rect == null) continue;
            return rect;
        }
        return null;
    }

    public synchronized Page getPage(String name) {
        for (Page page : this.pages) {
            Rectangle rect = (Rectangle)page.rects.get(name);
            if (rect == null) continue;
            return page;
        }
        return null;
    }

    public synchronized int getPageIndex(String name) {
        for (int i = 0; i < this.pages.size; ++i) {
            Rectangle rect = (Rectangle)this.pages.get((int)i).rects.get(name);
            if (rect == null) continue;
            return i;
        }
        return -1;
    }

    @Override
    public synchronized void dispose() {
        for (Page page : this.pages) {
            if (page.texture != null) continue;
            page.image.dispose();
        }
        this.disposed = true;
    }

    public synchronized TextureAtlas generateTextureAtlas(Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps) {
        TextureAtlas atlas = new TextureAtlas();
        this.updateTextureAtlas(atlas, minFilter, magFilter, useMipMaps);
        return atlas;
    }

    public synchronized void updateTextureAtlas(TextureAtlas atlas, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps) {
        this.updateTextureAtlas(atlas, minFilter, magFilter, useMipMaps, true);
    }

    public synchronized void updateTextureAtlas(TextureAtlas atlas, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps, boolean useIndexes) {
        this.updatePageTextures(minFilter, magFilter, useMipMaps);
        for (Page page : this.pages) {
            if (page.addedRects.size <= 0) continue;
            for (String name : page.addedRects) {
                Matcher matcher;
                PixmapPackerRectangle rect = (PixmapPackerRectangle)page.rects.get(name);
                TextureAtlas.AtlasRegion region = new TextureAtlas.AtlasRegion(page.texture, (int)rect.x, (int)rect.y, (int)rect.width, (int)rect.height);
                if (rect.splits != null) {
                    region.names = new String[]{"split", "pad"};
                    region.values = new int[][]{rect.splits, rect.pads};
                }
                int imageIndex = -1;
                String imageName = name;
                if (useIndexes && (matcher = indexPattern.matcher(imageName)).matches()) {
                    imageName = matcher.group(1);
                    imageIndex = Integer.parseInt(matcher.group(2));
                }
                region.name = imageName;
                region.index = imageIndex;
                region.offsetX = rect.offsetX;
                region.offsetY = (int)((float)rect.originalHeight - rect.height - (float)rect.offsetY);
                region.originalWidth = rect.originalWidth;
                region.originalHeight = rect.originalHeight;
                atlas.getRegions().add(region);
            }
            page.addedRects.clear();
            atlas.getTextures().add(page.texture);
        }
    }

    public synchronized void updateTextureRegions(Array<TextureRegion> regions, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps) {
        this.updatePageTextures(minFilter, magFilter, useMipMaps);
        while (regions.size < this.pages.size) {
            regions.add(new TextureRegion(this.pages.get((int)regions.size).texture));
        }
    }

    public synchronized void updatePageTextures(Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps) {
        for (Page page : this.pages) {
            page.updateTexture(minFilter, magFilter, useMipMaps);
        }
    }

    public int getPageWidth() {
        return this.pageWidth;
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    public int getPageHeight() {
        return this.pageHeight;
    }

    public void setPageHeight(int pageHeight) {
        this.pageHeight = pageHeight;
    }

    public Pixmap.Format getPageFormat() {
        return this.pageFormat;
    }

    public void setPageFormat(Pixmap.Format pageFormat) {
        this.pageFormat = pageFormat;
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public boolean getDuplicateBorder() {
        return this.duplicateBorder;
    }

    public void setDuplicateBorder(boolean duplicateBorder) {
        this.duplicateBorder = duplicateBorder;
    }

    public boolean getPackToTexture() {
        return this.packToTexture;
    }

    public void setPackToTexture(boolean packToTexture) {
        this.packToTexture = packToTexture;
    }

    public Color getTransparentColor() {
        return this.transparentColor;
    }

    public void setTransparentColor(Color color) {
        this.transparentColor.set(color);
    }

    private int[] getSplits(Pixmap raster) {
        int startX = this.getSplitPoint(raster, 1, 0, true, true);
        int endX = this.getSplitPoint(raster, startX, 0, false, true);
        int startY = this.getSplitPoint(raster, 0, 1, true, false);
        int endY = this.getSplitPoint(raster, 0, startY, false, false);
        this.getSplitPoint(raster, endX + 1, 0, true, true);
        this.getSplitPoint(raster, 0, endY + 1, true, false);
        if (startX == 0 && endX == 0 && startY == 0 && endY == 0) {
            return null;
        }
        if (startX != 0) {
            --startX;
            endX = raster.getWidth() - 2 - (endX - 1);
        } else {
            endX = raster.getWidth() - 2;
        }
        endY = startY != 0 ? raster.getHeight() - 2 - (endY - 1) : raster.getHeight() - 2;
        return new int[]{startX, endX, --startY, endY};
    }

    private int[] getPads(Pixmap raster, int[] splits) {
        int bottom = raster.getHeight() - 1;
        int right = raster.getWidth() - 1;
        int startX = this.getSplitPoint(raster, 1, bottom, true, true);
        int startY = this.getSplitPoint(raster, right, 1, true, false);
        int endX = 0;
        int endY = 0;
        if (startX != 0) {
            endX = this.getSplitPoint(raster, startX + 1, bottom, false, true);
        }
        if (startY != 0) {
            endY = this.getSplitPoint(raster, right, startY + 1, false, false);
        }
        this.getSplitPoint(raster, endX + 1, bottom, true, true);
        this.getSplitPoint(raster, right, endY + 1, true, false);
        if (startX == 0 && endX == 0 && startY == 0 && endY == 0) {
            return null;
        }
        if (startX == 0 && endX == 0) {
            startX = -1;
            endX = -1;
        } else if (startX > 0) {
            --startX;
            endX = raster.getWidth() - 2 - (endX - 1);
        } else {
            endX = raster.getWidth() - 2;
        }
        if (startY == 0 && endY == 0) {
            startY = -1;
            endY = -1;
        } else {
            endY = startY > 0 ? raster.getHeight() - 2 - (endY - 1) : raster.getHeight() - 2;
        }
        int[] pads = new int[]{startX, endX, --startY, endY};
        if (splits != null && Arrays.equals(pads, splits)) {
            return null;
        }
        return pads;
    }

    private int getSplitPoint(Pixmap raster, int startX, int startY, boolean startPoint, boolean xAxis) {
        int[] rgba = new int[4];
        int end = xAxis ? raster.getWidth() : raster.getHeight();
        int breakA = startPoint ? 255 : 0;
        int x = startX;
        int y = startY;
        for (int next = xAxis ? startX : startY; next != end; ++next) {
            if (xAxis) {
                x = next;
            } else {
                y = next;
            }
            int colint = raster.getPixel(x, y);
            this.c.set(colint);
            rgba[0] = (int)(this.c.r * 255.0f);
            rgba[1] = (int)(this.c.g * 255.0f);
            rgba[2] = (int)(this.c.b * 255.0f);
            rgba[3] = (int)(this.c.a * 255.0f);
            if (rgba[3] == breakA) {
                return next;
            }
            if (startPoint || rgba[0] == 0 && rgba[1] == 0 && rgba[2] == 0 && rgba[3] == 255) continue;
            System.out.println(x + "  " + y + " " + rgba + " ");
        }
        return 0;
    }

    public static class PixmapPackerRectangle
    extends Rectangle {
        int[] splits;
        int[] pads;
        int offsetX;
        int offsetY;
        int originalWidth;
        int originalHeight;

        PixmapPackerRectangle(int x, int y, int width, int height) {
            super(x, y, width, height);
            this.offsetX = 0;
            this.offsetY = 0;
            this.originalWidth = width;
            this.originalHeight = height;
        }

        PixmapPackerRectangle(int x, int y, int width, int height, int left, int top, int originalWidth, int originalHeight) {
            super(x, y, width, height);
            this.offsetX = left;
            this.offsetY = top;
            this.originalWidth = originalWidth;
            this.originalHeight = originalHeight;
        }
    }

    public static class SkylineStrategy
    implements PackStrategy {
        Comparator<Pixmap> comparator;

        @Override
        public void sort(Array<Pixmap> images) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>(){

                    @Override
                    public int compare(Pixmap o1, Pixmap o2) {
                        return o1.getHeight() - o2.getHeight();
                    }
                };
            }
            images.sort(this.comparator);
        }

        @Override
        public Page pack(PixmapPacker packer, String name, Rectangle rect) {
            int padding = packer.padding;
            int pageWidth = packer.pageWidth - padding * 2;
            int pageHeight = packer.pageHeight - padding * 2;
            int rectWidth = (int)rect.width + padding;
            int rectHeight = (int)rect.height + padding;
            int n = packer.pages.size;
            for (int i = 0; i < n; ++i) {
                SkylinePage page = (SkylinePage)packer.pages.get(i);
                SkylinePage.Row bestRow = null;
                int nn = page.rows.size - 1;
                for (int ii = 0; ii < nn; ++ii) {
                    SkylinePage.Row row = page.rows.get(ii);
                    if (row.x + rectWidth >= pageWidth || row.y + rectHeight >= pageHeight || rectHeight > row.height || bestRow != null && row.height >= bestRow.height) continue;
                    bestRow = row;
                }
                if (bestRow == null) {
                    SkylinePage.Row row = page.rows.peek();
                    if (row.y + rectHeight >= pageHeight) continue;
                    if (row.x + rectWidth < pageWidth) {
                        row.height = Math.max(row.height, rectHeight);
                        bestRow = row;
                    } else if (row.y + row.height + rectHeight < pageHeight) {
                        bestRow = new SkylinePage.Row();
                        bestRow.y = row.y + row.height;
                        bestRow.height = rectHeight;
                        page.rows.add(bestRow);
                    }
                }
                if (bestRow == null) continue;
                rect.x = bestRow.x;
                rect.y = bestRow.y;
                bestRow.x += rectWidth;
                return page;
            }
            SkylinePage page = new SkylinePage(packer);
            packer.pages.add(page);
            SkylinePage.Row row = new SkylinePage.Row();
            row.x = padding + rectWidth;
            row.y = padding;
            row.height = rectHeight;
            page.rows.add(row);
            rect.x = padding;
            rect.y = padding;
            return page;
        }

        static class SkylinePage
        extends Page {
            Array<Row> rows = new Array();

            public SkylinePage(PixmapPacker packer) {
                super(packer);
            }

            static class Row {
                int x;
                int y;
                int height;

                Row() {
                }
            }
        }
    }

    public static class GuillotineStrategy
    implements PackStrategy {
        Comparator<Pixmap> comparator;

        @Override
        public void sort(Array<Pixmap> pixmaps) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>(){

                    @Override
                    public int compare(Pixmap o1, Pixmap o2) {
                        return Math.max(o1.getWidth(), o1.getHeight()) - Math.max(o2.getWidth(), o2.getHeight());
                    }
                };
            }
            pixmaps.sort(this.comparator);
        }

        @Override
        public Page pack(PixmapPacker packer, String name, Rectangle rect) {
            GuillotinePage page;
            if (packer.pages.size == 0) {
                page = new GuillotinePage(packer);
                packer.pages.add(page);
            } else {
                page = (GuillotinePage)packer.pages.peek();
            }
            int padding = packer.padding;
            rect.width += (float)padding;
            rect.height += (float)padding;
            Node node = this.insert(page.root, rect);
            if (node == null) {
                page = new GuillotinePage(packer);
                packer.pages.add(page);
                node = this.insert(page.root, rect);
            }
            node.full = true;
            rect.set(node.rect.x, node.rect.y, node.rect.width - (float)padding, node.rect.height - (float)padding);
            return page;
        }

        private Node insert(Node node, Rectangle rect) {
            if (!node.full && node.leftChild != null && node.rightChild != null) {
                Node newNode = this.insert(node.leftChild, rect);
                if (newNode == null) {
                    newNode = this.insert(node.rightChild, rect);
                }
                return newNode;
            }
            if (node.full) {
                return null;
            }
            if (node.rect.width == rect.width && node.rect.height == rect.height) {
                return node;
            }
            if (node.rect.width < rect.width || node.rect.height < rect.height) {
                return null;
            }
            node.leftChild = new Node();
            node.rightChild = new Node();
            int deltaWidth = (int)node.rect.width - (int)rect.width;
            int deltaHeight = (int)node.rect.height - (int)rect.height;
            if (deltaWidth > deltaHeight) {
                node.leftChild.rect.x = node.rect.x;
                node.leftChild.rect.y = node.rect.y;
                node.leftChild.rect.width = rect.width;
                node.leftChild.rect.height = node.rect.height;
                node.rightChild.rect.x = node.rect.x + rect.width;
                node.rightChild.rect.y = node.rect.y;
                node.rightChild.rect.width = node.rect.width - rect.width;
                node.rightChild.rect.height = node.rect.height;
            } else {
                node.leftChild.rect.x = node.rect.x;
                node.leftChild.rect.y = node.rect.y;
                node.leftChild.rect.width = node.rect.width;
                node.leftChild.rect.height = rect.height;
                node.rightChild.rect.x = node.rect.x;
                node.rightChild.rect.y = node.rect.y + rect.height;
                node.rightChild.rect.width = node.rect.width;
                node.rightChild.rect.height = node.rect.height - rect.height;
            }
            return this.insert(node.leftChild, rect);
        }

        static class GuillotinePage
        extends Page {
            Node root = new Node();

            public GuillotinePage(PixmapPacker packer) {
                super(packer);
                this.root.rect.x = packer.padding;
                this.root.rect.y = packer.padding;
                this.root.rect.width = packer.pageWidth - packer.padding * 2;
                this.root.rect.height = packer.pageHeight - packer.padding * 2;
            }
        }

        static final class Node {
            public Node leftChild;
            public Node rightChild;
            public final Rectangle rect = new Rectangle();
            public boolean full;

            Node() {
            }
        }
    }

    public static interface PackStrategy {
        public void sort(Array<Pixmap> var1);

        public Page pack(PixmapPacker var1, String var2, Rectangle var3);
    }

    public static class Page {
        OrderedMap<String, PixmapPackerRectangle> rects = new OrderedMap();
        Pixmap image;
        Texture texture;
        final Array<String> addedRects = new Array();
        boolean dirty;

        public Page(PixmapPacker packer) {
            this.image = new Pixmap(packer.pageWidth, packer.pageHeight, packer.pageFormat);
            this.image.setBlending(Pixmap.Blending.None);
            this.image.setColor(packer.getTransparentColor());
            this.image.fill();
        }

        public Pixmap getPixmap() {
            return this.image;
        }

        public OrderedMap<String, PixmapPackerRectangle> getRects() {
            return this.rects;
        }

        public Texture getTexture() {
            return this.texture;
        }

        public boolean updateTexture(Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, boolean useMipMaps) {
            if (this.texture != null) {
                if (!this.dirty) {
                    return false;
                }
                this.texture.load(this.texture.getTextureData());
            } else {
                this.texture = new Texture(new PixmapTextureData(this.image, this.image.getFormat(), useMipMaps, false, true)){

                    @Override
                    public void dispose() {
                        super.dispose();
                        Page.this.image.dispose();
                    }
                };
                this.texture.setFilter(minFilter, magFilter);
            }
            this.dirty = false;
            return true;
        }
    }
}

