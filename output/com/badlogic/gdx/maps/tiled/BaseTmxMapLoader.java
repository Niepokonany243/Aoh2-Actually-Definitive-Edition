/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.XmlReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public abstract class BaseTmxMapLoader<P extends Parameters>
extends AsynchronousAssetLoader<TiledMap, P> {
    protected static final int FLAG_FLIP_HORIZONTALLY = Integer.MIN_VALUE;
    protected static final int FLAG_FLIP_VERTICALLY = 0x40000000;
    protected static final int FLAG_FLIP_DIAGONALLY = 0x20000000;
    protected static final int MASK_CLEAR = -536870912;
    protected XmlReader xml = new XmlReader();
    protected XmlReader.Element root;
    protected boolean convertObjectToTileSpace;
    protected boolean flipY = true;
    protected int mapTileWidth;
    protected int mapTileHeight;
    protected int mapWidthInPixels;
    protected int mapHeightInPixels;
    protected TiledMap map;

    public BaseTmxMapLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle tmxFile, P parameter) {
        this.root = this.xml.parse(tmxFile);
        TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
        if (parameter != null) {
            textureParameter.genMipMaps = ((Parameters)parameter).generateMipMaps;
            textureParameter.minFilter = ((Parameters)parameter).textureMinFilter;
            textureParameter.magFilter = ((Parameters)parameter).textureMagFilter;
        }
        return this.getDependencyAssetDescriptors(tmxFile, textureParameter);
    }

    protected abstract Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle var1, TextureLoader.TextureParameter var2);

    protected TiledMap loadTiledMap(FileHandle tmxFile, P parameter, ImageResolver imageResolver) {
        XmlReader.Element properties;
        this.map = new TiledMap();
        if (parameter != null) {
            this.convertObjectToTileSpace = ((Parameters)parameter).convertObjectToTileSpace;
            this.flipY = ((Parameters)parameter).flipY;
        } else {
            this.convertObjectToTileSpace = false;
            this.flipY = true;
        }
        String mapOrientation = this.root.getAttribute("orientation", null);
        int mapWidth = this.root.getIntAttribute("width", 0);
        int mapHeight = this.root.getIntAttribute("height", 0);
        int tileWidth = this.root.getIntAttribute("tilewidth", 0);
        int tileHeight = this.root.getIntAttribute("tileheight", 0);
        int hexSideLength = this.root.getIntAttribute("hexsidelength", 0);
        String staggerAxis = this.root.getAttribute("staggeraxis", null);
        String staggerIndex = this.root.getAttribute("staggerindex", null);
        String mapBackgroundColor = this.root.getAttribute("backgroundcolor", null);
        MapProperties mapProperties = this.map.getProperties();
        if (mapOrientation != null) {
            mapProperties.put("orientation", mapOrientation);
        }
        mapProperties.put("width", mapWidth);
        mapProperties.put("height", mapHeight);
        mapProperties.put("tilewidth", tileWidth);
        mapProperties.put("tileheight", tileHeight);
        mapProperties.put("hexsidelength", hexSideLength);
        if (staggerAxis != null) {
            mapProperties.put("staggeraxis", staggerAxis);
        }
        if (staggerIndex != null) {
            mapProperties.put("staggerindex", staggerIndex);
        }
        if (mapBackgroundColor != null) {
            mapProperties.put("backgroundcolor", mapBackgroundColor);
        }
        this.mapTileWidth = tileWidth;
        this.mapTileHeight = tileHeight;
        this.mapWidthInPixels = mapWidth * tileWidth;
        this.mapHeightInPixels = mapHeight * tileHeight;
        if (mapOrientation != null && "staggered".equals(mapOrientation) && mapHeight > 1) {
            this.mapWidthInPixels += tileWidth / 2;
            this.mapHeightInPixels = this.mapHeightInPixels / 2 + tileHeight / 2;
        }
        if ((properties = this.root.getChildByName("properties")) != null) {
            this.loadProperties(this.map.getProperties(), properties);
        }
        Array<XmlReader.Element> tilesets = this.root.getChildrenByName("tileset");
        for (XmlReader.Element element : tilesets) {
            this.loadTileSet(element, tmxFile, imageResolver);
            this.root.removeChild(element);
        }
        int j = this.root.getChildCount();
        for (int i = 0; i < j; ++i) {
            XmlReader.Element element = this.root.getChild(i);
            this.loadLayer(this.map, this.map.getLayers(), element, tmxFile, imageResolver);
        }
        return this.map;
    }

    protected void loadLayer(TiledMap map, MapLayers parentLayers, XmlReader.Element element, FileHandle tmxFile, ImageResolver imageResolver) {
        String name = element.getName();
        if (name.equals("group")) {
            this.loadLayerGroup(map, parentLayers, element, tmxFile, imageResolver);
        } else if (name.equals("layer")) {
            this.loadTileLayer(map, parentLayers, element);
        } else if (name.equals("objectgroup")) {
            this.loadObjectGroup(map, parentLayers, element);
        } else if (name.equals("imagelayer")) {
            this.loadImageLayer(map, parentLayers, element, tmxFile, imageResolver);
        }
    }

    protected void loadLayerGroup(TiledMap map, MapLayers parentLayers, XmlReader.Element element, FileHandle tmxFile, ImageResolver imageResolver) {
        if (element.getName().equals("group")) {
            MapGroupLayer groupLayer = new MapGroupLayer();
            this.loadBasicLayerInfo(groupLayer, element);
            XmlReader.Element properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(groupLayer.getProperties(), properties);
            }
            int j = element.getChildCount();
            for (int i = 0; i < j; ++i) {
                XmlReader.Element child = element.getChild(i);
                this.loadLayer(map, groupLayer.getLayers(), child, tmxFile, imageResolver);
            }
            for (MapLayer layer : groupLayer.getLayers()) {
                layer.setParent(groupLayer);
            }
            parentLayers.add(groupLayer);
        }
    }

    protected void loadTileLayer(TiledMap map, MapLayers parentLayers, XmlReader.Element element) {
        if (element.getName().equals("layer")) {
            int width = element.getIntAttribute("width", 0);
            int height = element.getIntAttribute("height", 0);
            int tileWidth = map.getProperties().get("tilewidth", Integer.class);
            int tileHeight = map.getProperties().get("tileheight", Integer.class);
            TiledMapTileLayer layer = new TiledMapTileLayer(width, height, tileWidth, tileHeight);
            this.loadBasicLayerInfo(layer, element);
            int[] ids = BaseTmxMapLoader.getTileIds(element, width, height);
            TiledMapTileSets tilesets = map.getTileSets();
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    int id = ids[y * width + x];
                    boolean flipHorizontally = (id & Integer.MIN_VALUE) != 0;
                    boolean flipVertically = (id & 0x40000000) != 0;
                    boolean flipDiagonally = (id & 0x20000000) != 0;
                    TiledMapTile tile = tilesets.getTile(id & 0x1FFFFFFF);
                    if (tile == null) continue;
                    TiledMapTileLayer.Cell cell = this.createTileLayerCell(flipHorizontally, flipVertically, flipDiagonally);
                    cell.setTile(tile);
                    layer.setCell(x, this.flipY ? height - 1 - y : y, cell);
                }
            }
            XmlReader.Element properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(layer.getProperties(), properties);
            }
            parentLayers.add(layer);
        }
    }

    protected void loadObjectGroup(TiledMap map, MapLayers parentLayers, XmlReader.Element element) {
        if (element.getName().equals("objectgroup")) {
            MapLayer layer = new MapLayer();
            this.loadBasicLayerInfo(layer, element);
            XmlReader.Element properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(layer.getProperties(), properties);
            }
            for (XmlReader.Element objectElement : element.getChildrenByName("object")) {
                this.loadObject(map, layer, objectElement);
            }
            parentLayers.add(layer);
        }
    }

    protected void loadImageLayer(TiledMap map, MapLayers parentLayers, XmlReader.Element element, FileHandle tmxFile, ImageResolver imageResolver) {
        if (element.getName().equals("imagelayer")) {
            float x = 0.0f;
            float y = 0.0f;
            x = element.hasAttribute("offsetx") ? Float.parseFloat(element.getAttribute("offsetx", "0")) : Float.parseFloat(element.getAttribute("x", "0"));
            y = element.hasAttribute("offsety") ? Float.parseFloat(element.getAttribute("offsety", "0")) : Float.parseFloat(element.getAttribute("y", "0"));
            if (this.flipY) {
                y = (float)this.mapHeightInPixels - y;
            }
            TextureRegion texture = null;
            XmlReader.Element image = element.getChildByName("image");
            if (image != null) {
                String source = image.getAttribute("source");
                FileHandle handle = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, source);
                texture = imageResolver.getImage(handle.path());
                y -= (float)texture.getRegionHeight();
            }
            TiledMapImageLayer layer = new TiledMapImageLayer(texture, x, y);
            this.loadBasicLayerInfo(layer, element);
            XmlReader.Element properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(layer.getProperties(), properties);
            }
            parentLayers.add(layer);
        }
    }

    protected void loadBasicLayerInfo(MapLayer layer, XmlReader.Element element) {
        String name = element.getAttribute("name", null);
        float opacity = Float.parseFloat(element.getAttribute("opacity", "1.0"));
        boolean visible = element.getIntAttribute("visible", 1) == 1;
        float offsetX = element.getFloatAttribute("offsetx", 0.0f);
        float offsetY = element.getFloatAttribute("offsety", 0.0f);
        layer.setName(name);
        layer.setOpacity(opacity);
        layer.setVisible(visible);
        layer.setOffsetX(offsetX);
        layer.setOffsetY(offsetY);
    }

    protected void loadObject(TiledMap map, MapLayer layer, XmlReader.Element element) {
        this.loadObject(map, layer.getObjects(), element, this.mapHeightInPixels);
    }

    protected void loadObject(TiledMap map, TiledMapTile tile, XmlReader.Element element) {
        this.loadObject(map, tile.getObjects(), element, tile.getTextureRegion().getRegionHeight());
    }

    protected void loadObject(TiledMap map, MapObjects objects, XmlReader.Element element, float heightInPixels) {
        if (element.getName().equals("object")) {
            int id;
            String type;
            MapObject object = null;
            float scaleX = this.convertObjectToTileSpace ? 1.0f / (float)this.mapTileWidth : 1.0f;
            float scaleY = this.convertObjectToTileSpace ? 1.0f / (float)this.mapTileHeight : 1.0f;
            float x = element.getFloatAttribute("x", 0.0f) * scaleX;
            float y = (this.flipY ? heightInPixels - element.getFloatAttribute("y", 0.0f) : element.getFloatAttribute("y", 0.0f)) * scaleY;
            float width = element.getFloatAttribute("width", 0.0f) * scaleX;
            float height = element.getFloatAttribute("height", 0.0f) * scaleY;
            if (element.getChildCount() > 0) {
                String[] point;
                float[] vertices;
                String[] points;
                XmlReader.Element child = null;
                child = element.getChildByName("polygon");
                if (child != null) {
                    points = child.getAttribute("points").split(" ");
                    vertices = new float[points.length * 2];
                    for (int i = 0; i < points.length; ++i) {
                        point = points[i].split(",");
                        vertices[i * 2] = Float.parseFloat(point[0]) * scaleX;
                        vertices[i * 2 + 1] = Float.parseFloat(point[1]) * scaleY * (float)(this.flipY ? -1 : 1);
                    }
                    Polygon polygon = new Polygon(vertices);
                    polygon.setPosition(x, y);
                    object = new PolygonMapObject(polygon);
                } else {
                    child = element.getChildByName("polyline");
                    if (child != null) {
                        points = child.getAttribute("points").split(" ");
                        vertices = new float[points.length * 2];
                        for (int i = 0; i < points.length; ++i) {
                            point = points[i].split(",");
                            vertices[i * 2] = Float.parseFloat(point[0]) * scaleX;
                            vertices[i * 2 + 1] = Float.parseFloat(point[1]) * scaleY * (float)(this.flipY ? -1 : 1);
                        }
                        Polyline polyline = new Polyline(vertices);
                        polyline.setPosition(x, y);
                        object = new PolylineMapObject(polyline);
                    } else {
                        child = element.getChildByName("ellipse");
                        if (child != null) {
                            object = new EllipseMapObject(x, this.flipY ? y - height : y, width, height);
                        }
                    }
                }
            }
            if (object == null) {
                String gid = null;
                gid = element.getAttribute("gid", null);
                if (gid != null) {
                    int id2 = (int)Long.parseLong(gid);
                    boolean flipHorizontally = (id2 & Integer.MIN_VALUE) != 0;
                    boolean flipVertically = (id2 & 0x40000000) != 0;
                    TiledMapTile tile = map.getTileSets().getTile(id2 & 0x1FFFFFFF);
                    TiledMapTileMapObject tiledMapTileMapObject = new TiledMapTileMapObject(tile, flipHorizontally, flipVertically);
                    TextureRegion textureRegion = tiledMapTileMapObject.getTextureRegion();
                    tiledMapTileMapObject.getProperties().put("gid", id2);
                    tiledMapTileMapObject.setX(x);
                    tiledMapTileMapObject.setY(this.flipY ? y : y - height);
                    float objectWidth = element.getFloatAttribute("width", textureRegion.getRegionWidth());
                    float objectHeight = element.getFloatAttribute("height", textureRegion.getRegionHeight());
                    tiledMapTileMapObject.setScaleX(scaleX * (objectWidth / (float)textureRegion.getRegionWidth()));
                    tiledMapTileMapObject.setScaleY(scaleY * (objectHeight / (float)textureRegion.getRegionHeight()));
                    tiledMapTileMapObject.setRotation(element.getFloatAttribute("rotation", 0.0f));
                    object = tiledMapTileMapObject;
                } else {
                    object = new RectangleMapObject(x, this.flipY ? y - height : y, width, height);
                }
            }
            object.setName(element.getAttribute("name", null));
            String rotation = element.getAttribute("rotation", null);
            if (rotation != null) {
                object.getProperties().put("rotation", Float.valueOf(Float.parseFloat(rotation)));
            }
            if ((type = element.getAttribute("type", null)) != null) {
                object.getProperties().put("type", type);
            }
            if ((id = element.getIntAttribute("id", 0)) != 0) {
                object.getProperties().put("id", id);
            }
            object.getProperties().put("x", Float.valueOf(x));
            if (object instanceof TiledMapTileMapObject) {
                object.getProperties().put("y", Float.valueOf(y));
            } else {
                object.getProperties().put("y", Float.valueOf(this.flipY ? y - height : y));
            }
            object.getProperties().put("width", Float.valueOf(width));
            object.getProperties().put("height", Float.valueOf(height));
            object.setVisible(element.getIntAttribute("visible", 1) == 1);
            XmlReader.Element properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(object.getProperties(), properties);
            }
            objects.add(object);
        }
    }

    protected void loadProperties(MapProperties properties, XmlReader.Element element) {
        if (element == null) {
            return;
        }
        if (element.getName().equals("properties")) {
            for (XmlReader.Element property : element.getChildrenByName("property")) {
                String name = property.getAttribute("name", null);
                String value = property.getAttribute("value", null);
                String type = property.getAttribute("type", null);
                if (value == null) {
                    value = property.getText();
                }
                Object castValue = this.castProperty(name, value, type);
                properties.put(name, castValue);
            }
        }
    }

    protected Object castProperty(String name, String value, String type) {
        if (type == null) {
            return value;
        }
        if (type.equals("int")) {
            return Integer.valueOf(value);
        }
        if (type.equals("float")) {
            return Float.valueOf(value);
        }
        if (type.equals("bool")) {
            return Boolean.valueOf(value);
        }
        if (type.equals("color")) {
            String opaqueColor = value.substring(3);
            String alpha = value.substring(1, 3);
            return Color.valueOf(opaqueColor + alpha);
        }
        throw new GdxRuntimeException("Wrong type given for property " + name + ", given : " + type + ", supported : string, bool, int, float, color");
    }

    protected TiledMapTileLayer.Cell createTileLayerCell(boolean flipHorizontally, boolean flipVertically, boolean flipDiagonally) {
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        if (flipDiagonally) {
            if (flipHorizontally && flipVertically) {
                cell.setFlipHorizontally(true);
                cell.setRotation(3);
            } else if (flipHorizontally) {
                cell.setRotation(3);
            } else if (flipVertically) {
                cell.setRotation(1);
            } else {
                cell.setFlipVertically(true);
                cell.setRotation(3);
            }
        } else {
            cell.setFlipHorizontally(flipHorizontally);
            cell.setFlipVertically(flipVertically);
        }
        return cell;
    }

    public static int[] getTileIds(XmlReader.Element element, int width, int height) {
        int[] ids;
        block17: {
            String encoding;
            block18: {
                XmlReader.Element data;
                block16: {
                    data = element.getChildByName("data");
                    encoding = data.getAttribute("encoding", null);
                    if (encoding == null) {
                        throw new GdxRuntimeException("Unsupported encoding (XML) for TMX Layer Data");
                    }
                    ids = new int[width * height];
                    if (!encoding.equals("csv")) break block16;
                    String[] array = data.getText().split(",");
                    for (int i = 0; i < array.length; ++i) {
                        ids[i] = (int)Long.parseLong(array[i].trim());
                    }
                    break block17;
                }
                if (!encoding.equals("base64")) break block18;
                InputStream is = null;
                try {
                    String compression = data.getAttribute("compression", null);
                    byte[] bytes = Base64Coder.decode(data.getText());
                    if (compression == null) {
                        is = new ByteArrayInputStream(bytes);
                    } else if (compression.equals("gzip")) {
                        is = new BufferedInputStream(new GZIPInputStream((InputStream)new ByteArrayInputStream(bytes), bytes.length));
                    } else if (compression.equals("zlib")) {
                        is = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(bytes)));
                    } else {
                        throw new GdxRuntimeException("Unrecognised compression (" + compression + ") for TMX Layer Data");
                    }
                    byte[] temp = new byte[4];
                    for (int y = 0; y < height; ++y) {
                        for (int x = 0; x < width; ++x) {
                            int read;
                            int curr;
                            for (read = is.read(temp); read < temp.length && (curr = is.read(temp, read, temp.length - read)) != -1; read += curr) {
                            }
                            if (read != temp.length) {
                                throw new GdxRuntimeException("Error Reading TMX Layer Data: Premature end of tile data");
                            }
                            ids[y * width + x] = BaseTmxMapLoader.unsignedByteToInt(temp[0]) | BaseTmxMapLoader.unsignedByteToInt(temp[1]) << 8 | BaseTmxMapLoader.unsignedByteToInt(temp[2]) << 16 | BaseTmxMapLoader.unsignedByteToInt(temp[3]) << 24;
                        }
                    }
                }
                catch (IOException e) {
                    try {
                        throw new GdxRuntimeException("Error Reading TMX Layer Data - IOException: " + e.getMessage());
                    }
                    catch (Throwable throwable) {
                        StreamUtils.closeQuietly(is);
                        throw throwable;
                    }
                }
                StreamUtils.closeQuietly(is);
                break block17;
            }
            throw new GdxRuntimeException("Unrecognised encoding (" + encoding + ") for TMX Layer Data");
        }
        return ids;
    }

    protected static int unsignedByteToInt(byte b) {
        return b & 0xFF;
    }

    protected static FileHandle getRelativeFileHandle(FileHandle file, String path) {
        StringTokenizer tokenizer = new StringTokenizer(path, "\\/");
        FileHandle result = file.parent();
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            if (token.equals("..")) {
                result = result.parent();
                continue;
            }
            result = result.child(token);
        }
        return result;
    }

    /*
     * Unable to fully structure code
     */
    protected void loadTileSet(XmlReader.Element element, FileHandle tmxFile, ImageResolver imageResolver) {
        if (element.getName().equals("tileset")) {
            firstgid = element.getIntAttribute("firstgid", 1);
            imageSource = "";
            imageWidth = 0;
            imageHeight = 0;
            image = null;
            source = element.getAttribute("source", null);
            if (source != null) {
                tsx = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, source);
                try {
                    element = this.xml.parse(tsx);
                    imageElement = element.getChildByName("image");
                    if (imageElement == null) ** GOTO lbl27
                    imageSource = imageElement.getAttribute("source");
                    imageWidth = imageElement.getIntAttribute("width", 0);
                    imageHeight = imageElement.getIntAttribute("height", 0);
                    image = BaseTmxMapLoader.getRelativeFileHandle(tsx, imageSource);
                }
                catch (SerializationException e) {
                    throw new GdxRuntimeException("Error parsing external tileset.");
                }
            } else {
                imageElement = element.getChildByName("image");
                if (imageElement != null) {
                    imageSource = imageElement.getAttribute("source");
                    imageWidth = imageElement.getIntAttribute("width", 0);
                    imageHeight = imageElement.getIntAttribute("height", 0);
                    image = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, imageSource);
                }
            }
lbl27:
            // 5 sources

            name = element.get("name", null);
            tilewidth = element.getIntAttribute("tilewidth", 0);
            tileheight = element.getIntAttribute("tileheight", 0);
            spacing = element.getIntAttribute("spacing", 0);
            margin = element.getIntAttribute("margin", 0);
            offset = element.getChildByName("tileoffset");
            offsetX = 0;
            offsetY = 0;
            if (offset != null) {
                offsetX = offset.getIntAttribute("x", 0);
                offsetY = offset.getIntAttribute("y", 0);
            }
            tileSet = new TiledMapTileSet();
            tileSet.setName(name);
            tileSetProperties = tileSet.getProperties();
            properties = element.getChildByName("properties");
            if (properties != null) {
                this.loadProperties(tileSetProperties, properties);
            }
            tileSetProperties.put("firstgid", firstgid);
            tileElements = element.getChildrenByName("tile");
            this.addStaticTiles(tmxFile, imageResolver, tileSet, element, tileElements, name, firstgid, tilewidth, tileheight, spacing, margin, source, offsetX, offsetY, imageSource, imageWidth, imageHeight, image);
            animatedTiles = new Array<AnimatedTiledMapTile>();
            for (XmlReader.Element tileElement : tileElements) {
                localtid = tileElement.getIntAttribute("id", 0);
                tile = tileSet.getTile(firstgid + localtid);
                if (tile == null) continue;
                animatedTile = this.createAnimatedTile(tileSet, tile, tileElement, firstgid);
                if (animatedTile != null) {
                    animatedTiles.add(animatedTile);
                    tile = animatedTile;
                }
                this.addTileProperties(tile, tileElement);
                this.addTileObjectGroup(tile, tileElement);
            }
            for (AnimatedTiledMapTile animatedTile : animatedTiles) {
                tileSet.putTile(animatedTile.getId(), animatedTile);
            }
            this.map.getTileSets().addTileSet(tileSet);
        }
    }

    protected abstract void addStaticTiles(FileHandle var1, ImageResolver var2, TiledMapTileSet var3, XmlReader.Element var4, Array<XmlReader.Element> var5, String var6, int var7, int var8, int var9, int var10, int var11, String var12, int var13, int var14, String var15, int var16, int var17, FileHandle var18);

    protected void addTileProperties(TiledMapTile tile, XmlReader.Element tileElement) {
        XmlReader.Element properties;
        String probability;
        String terrain = tileElement.getAttribute("terrain", null);
        if (terrain != null) {
            tile.getProperties().put("terrain", terrain);
        }
        if ((probability = tileElement.getAttribute("probability", null)) != null) {
            tile.getProperties().put("probability", probability);
        }
        if ((properties = tileElement.getChildByName("properties")) != null) {
            this.loadProperties(tile.getProperties(), properties);
        }
    }

    protected void addTileObjectGroup(TiledMapTile tile, XmlReader.Element tileElement) {
        XmlReader.Element objectgroupElement = tileElement.getChildByName("objectgroup");
        if (objectgroupElement != null) {
            for (XmlReader.Element objectElement : objectgroupElement.getChildrenByName("object")) {
                this.loadObject(this.map, tile, objectElement);
            }
        }
    }

    protected AnimatedTiledMapTile createAnimatedTile(TiledMapTileSet tileSet, TiledMapTile tile, XmlReader.Element tileElement, int firstgid) {
        XmlReader.Element animationElement = tileElement.getChildByName("animation");
        if (animationElement != null) {
            Array<StaticTiledMapTile> staticTiles = new Array<StaticTiledMapTile>();
            IntArray intervals = new IntArray();
            for (XmlReader.Element frameElement : animationElement.getChildrenByName("frame")) {
                staticTiles.add((StaticTiledMapTile)tileSet.getTile(firstgid + frameElement.getIntAttribute("tileid")));
                intervals.add(frameElement.getIntAttribute("duration"));
            }
            AnimatedTiledMapTile animatedTile = new AnimatedTiledMapTile(intervals, staticTiles);
            animatedTile.setId(tile.getId());
            return animatedTile;
        }
        return null;
    }

    protected void addStaticTiledMapTile(TiledMapTileSet tileSet, TextureRegion textureRegion, int tileId, float offsetX, float offsetY) {
        StaticTiledMapTile tile = new StaticTiledMapTile(textureRegion);
        tile.setId(tileId);
        tile.setOffsetX(offsetX);
        tile.setOffsetY(this.flipY ? -offsetY : offsetY);
        tileSet.putTile(tileId, tile);
    }

    public static class Parameters
    extends AssetLoaderParameters<TiledMap> {
        public boolean generateMipMaps = false;
        public Texture.TextureFilter textureMinFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter textureMagFilter = Texture.TextureFilter.Nearest;
        public boolean convertObjectToTileSpace = false;
        public boolean flipY = true;
    }
}

