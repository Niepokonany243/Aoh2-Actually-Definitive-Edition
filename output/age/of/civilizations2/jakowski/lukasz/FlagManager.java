
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Flag_Division;
import age.of.civilizations2.jakowski.lukasz.Flag_GameData;
import age.of.civilizations2.jakowski.lukasz.Flag_Overlay;
import age.of.civilizations2.jakowski.lukasz.Flag_OverlayImage;
import age.of.civilizations2.jakowski.lukasz.Flag_Overlay_GameData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ScreenUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlagManager {
    public List<Flag_Division> lDivisions = null;
    public List<Flag_Overlay> lOverlays = null;
    public static final int FLAG_WIDTH = 68;
    public static final int FLAG_HEIGHT = 44;
    public static final int FLAG_WIDTH_MIN = 27;
    public static final int FLAG_HEIGHT_MIN = 18;
    public static final int FLAG_WIDTH_BIG = 154;
    public static final int FLAG_HEIGHT_BIG = 100;
    public Flag_GameData flagEdit;
    private List<Image> divisionLayers = new ArrayList<Image>();
    public List<Flag_OverlayImage> lOverlaysImages = new ArrayList<Flag_OverlayImage>();
    public List<List<Image>> divisionLayersAll = new ArrayList<List<Image>>();
    public List<Color> divisionAllColors = new ArrayList<Color>();
    public List<Flag_OverlayImage> lOverlaysImagesAll = new ArrayList<Flag_OverlayImage>();

    public final void drawFlag(SpriteBatch oSB, int nPosX, int nPosY) {
        this.drawDivision(oSB, nPosX, nPosY);
        for (int i = 0; i < this.flagEdit.lOverlays.size(); ++i) {
            this.drawOverlay(oSB, nPosX, nPosY, i);
        }
    }

    public final void drawFlag_FlagFrameSize(SpriteBatch oSB, int nPosX, int nPosY) {
        this.drawDivision_FlagFrameSize(oSB, nPosX, nPosY);
        for (int i = 0; i < this.flagEdit.lOverlays.size(); ++i) {
            this.drawOverlay_FlagFrameSize(oSB, nPosX, nPosY, i);
        }
    }

    public final void drawDivision(SpriteBatch oSB, int nPosX, int nPosY) {
        this.beginClip(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(0).getR(), this.flagEdit.lDivisionColors.get(0).getG(), this.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        for (int i = 0; i < this.divisionLayers.size(); ++i) {
            oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(i + 1).getR(), this.flagEdit.lDivisionColors.get(i + 1).getG(), this.flagEdit.lDivisionColors.get(i + 1).getB(), 1.0f));
            this.divisionLayers.get(i).drawO(oSB, nPosX, nPosY - this.divisionLayers.get(i).getHeight(), 154, 100);
        }
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawDivision_FlagFrameSize(SpriteBatch oSB, int nPosX, int nPosY) {
        this.beginClip_FlagFrameSize(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(0).getR(), this.flagEdit.lDivisionColors.get(0).getG(), this.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        for (int i = 0; i < this.divisionLayers.size(); ++i) {
            oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(i + 1).getR(), this.flagEdit.lDivisionColors.get(i + 1).getG(), this.flagEdit.lDivisionColors.get(i + 1).getB(), 1.0f));
            this.divisionLayers.get(i).drawO(oSB, nPosX, nPosY - this.divisionLayers.get(i).getHeight(), 154, 100);
        }
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawDivision_FlagFrameSize2(SpriteBatch oSB, int nPosX, int nPosY, int id) {
        this.beginClip_FlagFrameSize(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.divisionAllColors.get((int)0).r, this.divisionAllColors.get((int)0).g, this.divisionAllColors.get((int)0).b, 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        for (int i = 0; i < this.divisionLayersAll.get(id).size(); ++i) {
            oSB.setColor(new Color(this.divisionAllColors.get((int)(i + 1)).r, this.divisionAllColors.get((int)(i + 1)).g, this.divisionAllColors.get((int)(i + 1)).b, 1.0f));
            this.divisionLayersAll.get(id).get(i).drawO(oSB, nPosX, nPosY - this.divisionLayersAll.get(id).get(i).getHeight(), 154, 100);
        }
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawDivisionBG(SpriteBatch oSB, int nPosX, int nPosY) {
        this.beginClip(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(0).getR(), this.flagEdit.lDivisionColors.get(0).getG(), this.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawDivision(SpriteBatch oSB, int nPosX, int nPosY, int nID) {
        this.beginClip(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(0).getR(), this.flagEdit.lDivisionColors.get(0).getG(), this.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(nID).getR(), this.flagEdit.lDivisionColors.get(nID).getG(), this.flagEdit.lDivisionColors.get(nID).getB(), 1.0f));
        this.divisionLayers.get(nID - 1).drawO(oSB, nPosX, nPosY - this.divisionLayers.get(nID - 1).getHeight(), 154, 100);
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawDivision_FlagFrameSize(SpriteBatch oSB, int nPosX, int nPosY, int nID) {
        this.beginClip_FlagFrameSize(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(0).getR(), this.flagEdit.lDivisionColors.get(0).getG(), this.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        oSB.setColor(new Color(this.flagEdit.lDivisionColors.get(nID).getR(), this.flagEdit.lDivisionColors.get(nID).getG(), this.flagEdit.lDivisionColors.get(nID).getB(), 1.0f));
        this.divisionLayers.get(nID - 1).drawO(oSB, nPosX, nPosY - this.divisionLayers.get(nID - 1).getHeight(), 154, 100);
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawOverlay(SpriteBatch oSB, int nPosX, int nPosY, int id) {
        this.beginClip(oSB, nPosX, nPosY);
        oSB.setColor(new Color(this.flagEdit.lOverlays.get((int)id).oColor.getR(), this.flagEdit.lOverlays.get((int)id).oColor.getG(), this.flagEdit.lOverlays.get((int)id).oColor.getB(), 1.0f));
        this.getOverlay(this.flagEdit.lOverlays.get((int)id).iOverlayID).drawO(oSB, nPosX + this.flagEdit.lOverlays.get((int)id).iPosX, nPosY + this.flagEdit.lOverlays.get((int)id).iPosY - this.getOverlay(this.flagEdit.lOverlays.get((int)id).iOverlayID).getHeight(), this.flagEdit.lOverlays.get((int)id).iWidth, this.flagEdit.lOverlays.get((int)id).iHeight);
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    public final void drawOverlay_FlagFrameSize(SpriteBatch oSB, int nPosX, int nPosY, int id) {
        this.beginClip_FlagFrameSize(oSB, nPosX, nPosY);
        float tScale = 1.0f;
        oSB.setColor(new Color(this.flagEdit.lOverlays.get((int)id).oColor.getR(), this.flagEdit.lOverlays.get((int)id).oColor.getG(), this.flagEdit.lOverlays.get((int)id).oColor.getB(), 1.0f));
        this.getOverlay(this.flagEdit.lOverlays.get((int)id).iOverlayID).drawO(oSB, nPosX + (int)((float)this.flagEdit.lOverlays.get((int)id).iPosX * tScale), nPosY + (int)((float)this.flagEdit.lOverlays.get((int)id).iPosY * tScale) - this.getOverlay(this.flagEdit.lOverlays.get((int)id).iOverlayID).getHeight(), (int)((float)this.flagEdit.lOverlays.get((int)id).iWidth * tScale), (int)((float)this.flagEdit.lOverlays.get((int)id).iHeight * tScale));
        oSB.setColor(Color.WHITE);
        this.endClip(oSB);
    }

    private final void beginClip(SpriteBatch oSB, int nPosX, int nPosY) {
        Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - 100.0f, 154.0f, 100.0f);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
    }

    private final void beginClip_FlagFrameSize(SpriteBatch oSB, int nPosX, int nPosY) {
        Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - 100.0f, 154.0f, 100.0f);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
    }

    private final void endClip(SpriteBatch oSB) {
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    public final void initFlagEdit() {
        this.flagEdit = new Flag_GameData();
        this.flagEdit.iDivisionID = CFG.oR.nextInt(this.lDivisions.size());
        this.loadDivision();
        this.loadOverlays();
    }

    public final void loadFlagEdit() {
        FileHandle file = null;
        FileHandle fileFlag = null;
        Json json = new Json();
        json.setIgnoreUnknownFields(true);

        String pathCiv = "game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG;
        String pathFlag = pathCiv + "_FD";

        try {
            
            FileHandle fileJsonCiv = Gdx.files.local(pathCiv + ".json");
            if (fileJsonCiv.exists()) {
                CFG.editorCivilization_GameData = json.fromJson(Civilization_GameData3.class, fileJsonCiv.readString("UTF-8"));
            } else {
                fileJsonCiv = FileManager.loadFile(pathCiv + ".json");
                if (fileJsonCiv.exists()) {
                    CFG.editorCivilization_GameData = json.fromJson(Civilization_GameData3.class, fileJsonCiv.readString("UTF-8"));
                }
            }

            
            FileHandle fileJsonFlag = Gdx.files.local(pathFlag + ".json");
            if (fileJsonFlag.exists()) {
                this.flagEdit = json.fromJson(Flag_GameData.class, fileJsonFlag.readString("UTF-8"));
            } else {
                fileJsonFlag = FileManager.loadFile(pathFlag + ".json");
                if (fileJsonFlag.exists()) {
                    this.flagEdit = json.fromJson(Flag_GameData.class, fileJsonFlag.readString("UTF-8"));
                }
            }

            
            if (CFG.editorCivilization_GameData == null) {
                file = Gdx.files.local(pathCiv).exists() ? Gdx.files.local(pathCiv) : FileManager.loadFile(pathCiv);
                if (file.exists()) {
                    CFG.editorCivilization_GameData = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                }
            }
            if (this.flagEdit == null) {
                fileFlag = Gdx.files.local(pathFlag).exists() ? Gdx.files.local(pathFlag) : FileManager.loadFile(pathFlag);
                if (fileFlag.exists()) {
                    this.flagEdit = (Flag_GameData)CFG.deserialize(fileFlag.readBytes());
                }
            }

            if (CFG.editorCivilization_GameData != null && this.flagEdit != null) {
                CFG.menus.setMenuID(View.eEDITOR_GAME_CIVS_EDIT);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        this.loadDivision();
        this.loadOverlays();
    }

    public final void updateDivision(boolean add) {
        this.flagEdit.iDivisionID = this.flagEdit.iDivisionID + (add ? 1 : -1);
        if (this.flagEdit.iDivisionID < 0) {
            this.flagEdit.iDivisionID = this.lDivisions.size() - 1;
        } else if (this.flagEdit.iDivisionID >= this.lDivisions.size()) {
            this.flagEdit.iDivisionID = 0;
        }
        this.loadDivision();
    }

    public final void updateDivision(int id) {
        this.flagEdit.iDivisionID = id;
        if (this.flagEdit.iDivisionID < 0) {
            this.flagEdit.iDivisionID = this.lDivisions.size() - 1;
        } else if (this.flagEdit.iDivisionID >= this.lDivisions.size()) {
            this.flagEdit.iDivisionID = 0;
        }
        this.loadDivision();
    }

    public final void loadDivision() {
        int i;
        for (i = 0; i < this.divisionLayers.size(); ++i) {
            this.divisionLayers.get(i).getTexture().dispose();
        }
        this.divisionLayers.clear();
        for (i = 0; i < this.lDivisions.get((int)this.flagEdit.iDivisionID).iLayers - 1; ++i) {
            this.divisionLayers.add(new Image(new Texture(FileManager.loadFile("game/flags_editor/divisions/" + this.lDivisions.get((int)this.flagEdit.iDivisionID).sName + "_" + i + ".png")), Texture.TextureFilter.Nearest));
        }
        for (i = this.flagEdit.lDivisionColors.size(); i < this.lDivisions.get((int)this.flagEdit.iDivisionID).iLayers; ++i) {
            if (i == 0) {
                this.flagEdit.lDivisionColors.add(new Color_GameData(1.0f, 1.0f, 1.0f));
                continue;
            }
            if (i == 1) {
                this.flagEdit.lDivisionColors.add(new Color_GameData(0.9843137f, 0.0f, 0.2f));
                continue;
            }
            if (i == 2) {
                this.flagEdit.lDivisionColors.add(new Color_GameData(0.0f, 0.19607843f, 0.39607844f));
                continue;
            }
            if (i == 3) {
                this.flagEdit.lDivisionColors.add(new Color_GameData(1.0f, 0.80784315f, 0.0f));
                continue;
            }
            Color tempColor = CFG.getRandomColor();
            this.flagEdit.lDivisionColors.add(new Color_GameData(tempColor.r, tempColor.g, tempColor.b));
        }
    }

    public final void loadDivisionAll() {
        if (this.divisionLayersAll.isEmpty()) {
            try {
                int z;
                for (z = 0; z < this.lDivisions.size(); ++z) {
                    int i;
                    ArrayList<Image> lDI = new ArrayList<Image>();
                    for (i = 0; i < this.lDivisions.get((int)z).iLayers - 1; ++i) {
                        lDI.add(new Image(new Texture(FileManager.loadFile("game/flags_editor/divisions/" + this.lDivisions.get((int)z).sName + "_" + i + ".png")), Texture.TextureFilter.Nearest));
                    }
                    this.divisionLayersAll.add(lDI);
                    for (i = this.divisionAllColors.size(); i < this.lDivisions.get((int)z).iLayers + 10; ++i) {
                        if (i == 0) {
                            this.divisionAllColors.add(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                            continue;
                        }
                        if (i == 1) {
                            this.divisionAllColors.add(new Color(0.9843137f, 0.0f, 0.2f, 1.0f));
                            continue;
                        }
                        if (i == 2) {
                            this.divisionAllColors.add(new Color(0.0f, 0.19607843f, 0.39607844f, 1.0f));
                            continue;
                        }
                        if (i == 3) {
                            this.divisionAllColors.add(new Color(1.0f, 0.80784315f, 0.0f, 1.0f));
                            continue;
                        }
                        Color tempColor = CFG.getRandomColor();
                        this.divisionAllColors.add(new Color(tempColor.r, tempColor.g, tempColor.b, 1.0f));
                    }
                }
                for (z = 0; z < this.lOverlays.size(); ++z) {
                    this.lOverlaysImagesAll.add(new Flag_OverlayImage(z));
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void updateOverlay(int nID, boolean add) {
        int tempOver = this.flagEdit.lOverlays.get((int)nID).iOverlayID;
        this.flagEdit.lOverlays.get((int)nID).iOverlayID = this.flagEdit.lOverlays.get((int)nID).iOverlayID + (add ? 1 : -1);
        if (this.flagEdit.lOverlays.get((int)nID).iOverlayID < 0) {
            this.flagEdit.lOverlays.get((int)nID).iOverlayID = this.lOverlays.size() - 1;
        } else if (this.flagEdit.lOverlays.get((int)nID).iOverlayID >= this.lOverlays.size()) {
            this.flagEdit.lOverlays.get((int)nID).iOverlayID = 0;
        }
        this.tryRemoveOverlay(tempOver);
        this.loadOverlayImage(this.flagEdit.lOverlays.get((int)nID).iOverlayID);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iWidth = (int)Math.abs((float)this.getOverlay(this.flagEdit.lOverlays.get((int)nID).iOverlayID).getWidth() * this.lOverlays.get((int)this.flagEdit.lOverlays.get((int)nID).iOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iHeight = (int)Math.abs((float)this.getOverlay(this.flagEdit.lOverlays.get((int)nID).iOverlayID).getHeight() * this.lOverlays.get((int)this.flagEdit.lOverlays.get((int)nID).iOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosX = 77 - this.flagEdit.lOverlays.get((int)nID).iWidth / 2;
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosY = 50 - this.flagEdit.lOverlays.get((int)nID).iHeight / 2;
    }

    public final void addOverlay() {
        int tempOverlayID = 0;
        this.flagEdit.lOverlays.add(new Flag_Overlay_GameData(tempOverlayID));
        this.loadOverlayImage(tempOverlayID);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iWidth = (int)Math.abs((float)this.getOverlay(tempOverlayID).getWidth() * this.lOverlays.get((int)tempOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iHeight = (int)Math.abs((float)this.getOverlay(tempOverlayID).getHeight() * this.lOverlays.get((int)tempOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosX = 77 - this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iWidth / 2;
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosY = 50 - this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iHeight / 2;
    }

    public final void addOverlay(int id) {
        int tempOverlayID = id;
        this.flagEdit.lOverlays.add(new Flag_Overlay_GameData(tempOverlayID));
        this.loadOverlayImage(tempOverlayID);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iWidth = (int)Math.abs((float)this.getOverlay(tempOverlayID).getWidth() * this.lOverlays.get((int)tempOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iHeight = (int)Math.abs((float)this.getOverlay(tempOverlayID).getHeight() * this.lOverlays.get((int)tempOverlayID).Scale);
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosX = 77 - this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iWidth / 2;
        this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iPosY = 50 - this.flagEdit.lOverlays.get((int)(this.flagEdit.lOverlays.size() - 1)).iHeight / 2;
    }

    public final void removeOverlay(int nID) {
        int tempOverlayID = this.flagEdit.lOverlays.get((int)nID).iOverlayID;
        this.flagEdit.lOverlays.remove(nID);
        this.tryRemoveOverlay(tempOverlayID);
    }

    public final void moveOverlayUp(int nID) {
        if (nID > 0) {
            Flag_Overlay_GameData tempD = this.flagEdit.lOverlays.get(nID);
            this.flagEdit.lOverlays.set(nID, this.flagEdit.lOverlays.get(nID - 1));
            this.flagEdit.lOverlays.set(nID - 1, tempD);
        }
    }

    public final void loadOverlayImage(int iOverlayID) {
        for (int i = 0; i < this.lOverlaysImages.size(); ++i) {
            if (iOverlayID != this.lOverlaysImages.get((int)i).iOverlayID) continue;
            return;
        }
        this.lOverlaysImages.add(new Flag_OverlayImage(iOverlayID));
    }

    public final void tryRemoveOverlay(int iOverlayID) {
        int i;
        for (i = 0; i < this.flagEdit.lOverlays.size(); ++i) {
            if (this.flagEdit.lOverlays.get((int)i).iOverlayID != iOverlayID) continue;
            return;
        }
        for (i = 0; i < this.lOverlaysImages.size(); ++i) {
            if (iOverlayID != this.lOverlaysImages.get((int)i).iOverlayID) continue;
            this.lOverlaysImages.get((int)i).imageOverlay.getTexture().dispose();
            this.lOverlaysImages.remove(i);
            return;
        }
    }

    public final Image getOverlay(int iOverlayID) {
        for (int i = 0; i < this.lOverlaysImages.size(); ++i) {
            if (iOverlayID != this.lOverlaysImages.get((int)i).iOverlayID) continue;
            return this.lOverlaysImages.get((int)i).imageOverlay;
        }
        return IMGManager.getIMG(Images.gameBoxHover);
    }

    public final void loadDivisions() {
        if (this.lDivisions != null) {
            this.lDivisions.clear();
        }
        this.lDivisions = new ArrayList<Flag_Division>();
        try {
            FileHandle fileList = FileManager.loadFile("game/flags_editor/divisions.json");
            String fileContent = fileList.readString();
            Json json = new Json();
            json.setElementType(ConfigDivisionsData.class, "Division", Data_Divisions.class);
            ConfigDivisionsData data = new ConfigDivisionsData();
            data = json.fromJson(ConfigDivisionsData.class, fileContent);
            for (Object e : data.Division) {
                Data_Divisions tempData = (Data_Divisions)e;
                this.lDivisions.add(new Flag_Division(tempData.Name, tempData.Layers));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
    }

    public final void loadOverlays() {
        if (this.lOverlays != null) {
            this.lOverlays.clear();
        }
        this.lOverlays = new ArrayList<Flag_Overlay>();
        try {
            FileHandle fileList = FileManager.loadFile("game/flags_editor/overlays.json");
            String fileContent = fileList.readString();
            Json json = new Json();
            json.setElementType(ConfigOverlayData.class, "Overlay", Data_Overlays.class);
            ConfigOverlayData data = new ConfigOverlayData();
            data = json.fromJson(ConfigOverlayData.class, fileContent);
            for (Object e : data.Overlay) {
                Data_Overlays tempData = (Data_Overlays)e;
                this.lOverlays.add(new Flag_Overlay(tempData.Name, tempData.Scale));
            }
            for (int i = 0; i < this.flagEdit.lOverlays.size(); ++i) {
                this.loadOverlayImage(this.flagEdit.lOverlays.get((int)i).iOverlayID);
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
    }

    public final void loadData() {
        this.clearData();
        this.loadDivisions();
    }

    public final void clearData() {
        int i;
        if (this.lDivisions != null) {
            this.lDivisions.clear();
        }
        if (this.lOverlays != null) {
            this.lOverlays.clear();
        }
        for (i = 0; i < this.divisionLayers.size(); ++i) {
            this.divisionLayers.get(i).getTexture().dispose();
        }
        this.divisionLayers.clear();
        for (i = 0; i < this.lOverlaysImages.size(); ++i) {
            this.lOverlaysImages.get((int)i).imageOverlay.getTexture().dispose();
        }
        this.lOverlaysImages.clear();
    }

    public final void saveFlagTexture(SpriteBatch oSB) {
        Image tempFlagImage22;
        this.drawFlag(oSB, 0, 0);
        Image tempFlagImage = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
        try {
            tempFlagImage.getTexture().getTextureData().prepare();
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        PixmapIO.writePNG(FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FLH.png"), tempFlagImage.getTexture().getTextureData().consumePixmap());
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, 0, -IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        oSB.setColor(Color.WHITE);
        tempFlagImage.getTexture().dispose();
        tempFlagImage = null;
        Image tempImage = CFG.isAndroid() ? new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FLH.png")), Texture.TextureFilter.Linear) : new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FLH.png")), Texture.TextureFilter.Linear);
        tempImage.drawO(oSB, 0, 0);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        oSB.end();
        oSB.begin();
        oSB.setColor(Color.WHITE);
        try {
            tempFlagImage22 = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 100, 154, 100)));
            try {
                tempFlagImage22.getTexture().getTextureData().prepare();
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                
            }
            PixmapIO.writePNG(FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FLH.png"), tempFlagImage22.getTexture().getTextureData().consumePixmap());
            tempFlagImage22.getTexture().dispose();
            tempFlagImage22 = null;
        }
        catch (GdxRuntimeException ex1) {
            
        }
        tempImage.drawO(oSB, 0, -tempImage.getHeight(), 27, 18);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException ex2) {
            
        }
        oSB.end();
        oSB.begin();
        oSB.setColor(Color.WHITE);
        try {
            tempFlagImage22 = new Image(new Texture(ScreenUtils.getFrameBufferPixmap(0, CFG.GAMEHEIGHT - 18, 27, 18)));
            try {
                tempFlagImage22.getTexture().getTextureData().prepare();
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                
            }
            PixmapIO.writePNG(FileManager.getSaveType("game/civilizations_editor/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "_FL.png"), tempFlagImage22.getTexture().getTextureData().consumePixmap());
            tempFlagImage22.getTexture().dispose();
            tempFlagImage22 = null;
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, 0, -IMGManager.getIMG(Images.pix255).getHeight(), 154, 100);
        oSB.setColor(Color.WHITE);
        tempImage.getTexture().dispose();
        tempImage = null;
    }

    public static class ConfigDivisionsData {
        public String Age_of_Civilizations;
        public ArrayList Division;
    }

    public static class Data_Divisions {
        public String Name;
        public int Layers;
    }

    public static class ConfigOverlayData {
        public String Age_of_Civilizations;
        public ArrayList Overlay;
    }

    public static class Data_Overlays {
        public String Name;
        public float Scale;
    }
}

