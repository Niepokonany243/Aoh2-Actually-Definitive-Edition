/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_GameData;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Overlay_GameData;
import age.of.civilizations2.jakowski.lukasz.StatsCivGD;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceRibbon_Manager {
    private List<ServiceRibbon_GameData> lSR;
    private List<String> lTags;
    private int iSRSize;
    private List<List<Image>> lSRImages = null;
    private int iSRImagesSize;
    private List<Image> lSROverlayImages = null;
    private int iSROverlayImagesSize;

    public final StatsCivGD loadStatistics_Civ(String nTag) {
        try {
            return (StatsCivGD)CFG.deserialize(FileManager.loadFile("saves/stats/civ/" + nTag).readBytes());
        }
        catch (Exception exception) {
            return new StatsCivGD(nTag);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void saveStatistics_Civ(StatsCivGD stats_Civ_GD) {
        if (stats_Civ_GD.sTag.length() == 0) {
            return;
        }
        OutputStream os = null;
        try {
            FileHandle fileData = FileManager.IS_MAC ? Gdx.files.external("saves/stats/civ/" + stats_Civ_GD.sTag) : Gdx.files.local("saves/stats/civ/" + stats_Civ_GD.sTag);
            fileData.writeBytes(CFG.serialize(stats_Civ_GD), false);
            try {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external("saves/stats/civ/Age_of_Civilizations") : Gdx.files.local("saves/stats/civ/Age_of_Civilizations");
                String tempTags = file.readString();
                String[] tData = tempTags.split(";");
                boolean tAdd = true;
                for (int i = 0; i < tData.length; ++i) {
                    if (!tData[i].equals(stats_Civ_GD.sTag)) continue;
                    tAdd = false;
                    break;
                }
                if (tAdd) {
                    FileHandle fileSave = FileManager.getSaveType("saves/stats/civ/Age_of_Civilizations");
                    fileSave.writeString(tempTags + stats_Civ_GD.sTag + ";", false);
                }
            }
            catch (GdxRuntimeException ex) {
                FileHandle fileSave = FileManager.getSaveType("saves/stats/civ/Age_of_Civilizations");
                fileSave.writeString(stats_Civ_GD.sTag + ";", false);
            }
        }
        catch (IOException iOException) {
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    public boolean check_RequestTurns(long nNumOfTurns) {
        return nNumOfTurns == (long)this.getRequestTurns(this.getRequestTurns_Level(nNumOfTurns));
    }

    public int getRequestTurns(int iLevel) {
        switch (iLevel) {
            case 0: {
                return GameValues.gvServiceRibbon.REQUIRED_TURNS_0;
            }
            case 1: {
                return GameValues.gvServiceRibbon.REQUIRED_TURNS_1;
            }
            case 2: {
                return GameValues.gvServiceRibbon.REQUIRED_TURNS_2;
            }
            case 3: {
                return GameValues.gvServiceRibbon.REQUIRED_TURNS_3;
            }
            case 4: {
                return GameValues.gvServiceRibbon.REQUIRED_TURNS_4;
            }
        }
        return 0;
    }

    public int getRequestTurns_Level(long nNumOfTurns) {
        if (nNumOfTurns >= (long)this.getRequestTurns(4)) {
            return 5;
        }
        if (nNumOfTurns >= (long)this.getRequestTurns(3)) {
            return 4;
        }
        if (nNumOfTurns >= (long)this.getRequestTurns(2)) {
            return 3;
        }
        if (nNumOfTurns >= (long)this.getRequestTurns(1)) {
            return 2;
        }
        if (nNumOfTurns >= (long)this.getRequestTurns(0)) {
            return 1;
        }
        return 0;
    }

    public int getRequestRecruitedArmy(int iLevel) {
        switch (iLevel) {
            case 0: {
                return GameValues.gvServiceRibbon.REQUIRED_RECRUITED_ARMY_0;
            }
            case 1: {
                return GameValues.gvServiceRibbon.REQUIRED_RECRUITED_ARMY_1;
            }
            case 2: {
                return GameValues.gvServiceRibbon.REQUIRED_RECRUITED_ARMY_2;
            }
            case 3: {
                return GameValues.gvServiceRibbon.REQUIRED_RECRUITED_ARMY_3;
            }
            case 4: {
                return GameValues.gvServiceRibbon.REQUIRED_RECRUITED_ARMY_4;
            }
        }
        return 0;
    }

    public int getRequestRecruitedArmy_Level(long nNumOfUnits) {
        if (nNumOfUnits >= (long)this.getRequestRecruitedArmy(4)) {
            return 5;
        }
        if (nNumOfUnits >= (long)this.getRequestRecruitedArmy(3)) {
            return 4;
        }
        if (nNumOfUnits >= (long)this.getRequestRecruitedArmy(2)) {
            return 3;
        }
        if (nNumOfUnits >= (long)this.getRequestRecruitedArmy(1)) {
            return 2;
        }
        if (nNumOfUnits >= (long)this.getRequestRecruitedArmy(0)) {
            return 1;
        }
        return 0;
    }

    public boolean check_Request_ConquredProvinces(long nNum) {
        return nNum == (long)this.getRequestProvinces(this.getRequestProvinces_Level(nNum - 1L));
    }

    public int getRequestProvinces(int i) {
        switch (i) {
            case 0: {
                return GameValues.gvServiceRibbon.REQUIRED_PROVINCES_0;
            }
            case 1: {
                return GameValues.gvServiceRibbon.REQUIRED_PROVINCES_1;
            }
            case 2: {
                return GameValues.gvServiceRibbon.REQUIRED_PROVINCES_2;
            }
            case 3: {
                return GameValues.gvServiceRibbon.REQUIRED_PROVINCES_3;
            }
            case 4: {
                return GameValues.gvServiceRibbon.REQUIRED_PROVINCES_4;
            }
        }
        return 0;
    }

    public int getRequestProvinces_Level(long nNum) {
        if (nNum >= (long)this.getRequestProvinces(4)) {
            return 5;
        }
        if (nNum >= (long)this.getRequestProvinces(3)) {
            return 4;
        }
        if (nNum >= (long)this.getRequestProvinces(2)) {
            return 3;
        }
        if (nNum >= (long)this.getRequestProvinces(1)) {
            return 2;
        }
        if (nNum >= (long)this.getRequestProvinces(0)) {
            return 1;
        }
        return 0;
    }

    public ServiceRibbon_Manager() {
        this.loadSR();
        this.loadSRImages();
    }

    public final void loadSR() {
        try {
            this.lSR = new ArrayList<ServiceRibbon_GameData>();
            this.lTags = new ArrayList<String>();
            FileHandle tempFileT = FileManager.loadFile("game/service_ribbons/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                try {
                    this.lSR.add((ServiceRibbon_GameData)CFG.deserialize(FileManager.loadFile("game/service_ribbons/" + tagsSPLITED[i]).readBytes()));
                    this.lTags.add(tagsSPLITED[i]);
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            this.iSRSize = this.lSR.size();
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
    }

    public final void drawSR(SpriteBatch oSB, int nPosX, int nPosY, int nID, List<Color> nColors) {
        try {
            for (int i = 0; i < this.lSR.get(nID).getSize(); ++i) {
                this.drawSROverlay(oSB, nPosX, nPosY, this.lSR.get(nID).getServiceRibbon_Overlay(i), nColors.get(i), 1);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawSR(SpriteBatch oSB, int nPosX, int nPosY, ServiceRibbon_GameData nSR, List<Color> nColors, int nExtraScale) {
        try {
            for (int i = 0; i < nSR.getSize(); ++i) {
                this.drawSROverlay(oSB, nPosX, nPosY, nSR.getServiceRibbon_Overlay(i), nColors.get(i), nExtraScale);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    public final void drawSROverlay(SpriteBatch oSB, int nPosX, int nPosY, ServiceRibbon_Overlay_GameData nSROverlay, Color nColor, int nExtraScale) {
        oSB.setColor(nColor);
        if (nSROverlay.getReflected()) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + (int)((float)nSROverlay.getPosX() * CFG.GUI_SCALE * (float)nExtraScale), nPosY - IMGManager.getIMG(Images.pix255).getHeight(), (int)((float)nSROverlay.getWidth() * CFG.GUI_SCALE * (float)nExtraScale), CFG.SERVICE_RIBBON_HEIGHT * nExtraScale);
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + CFG.SERVICE_RIBBON_WIDTH * nExtraScale - (int)((float)nSROverlay.getPosX() * CFG.GUI_SCALE * (float)nExtraScale) - (int)((float)nSROverlay.getWidth() * CFG.GUI_SCALE * (float)nExtraScale), nPosY - IMGManager.getIMG(Images.pix255).getHeight(), (int)((float)nSROverlay.getWidth() * CFG.GUI_SCALE * (float)nExtraScale), CFG.SERVICE_RIBBON_HEIGHT * nExtraScale);
        } else {
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + (int)((float)nSROverlay.getPosX() * CFG.GUI_SCALE * (float)nExtraScale), nPosY - IMGManager.getIMG(Images.pix255).getHeight(), (int)((float)nSROverlay.getWidth() * CFG.GUI_SCALE * (float)nExtraScale), CFG.SERVICE_RIBBON_HEIGHT * nExtraScale);
        }
    }

    public final void drawSROver(SpriteBatch oSB, int nPosX, int nPosY, int nExtraScale) {
        try {
            this.lSROverlayImages.get(0).drawO(oSB, nPosX, nPosY - this.lSROverlayImages.get(0).getHeight(), CFG.SERVICE_RIBBON_WIDTH * nExtraScale, CFG.SERVICE_RIBBON_HEIGHT * nExtraScale);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void drawSRLevel(SpriteBatch oSB, int nPosX, int nPosY, int iSRLevel, int iSRStyle, int iSROverStyle, int nID, List<Color> nColors) {
        try {
            this.drawSR(oSB, nPosX, nPosY, nID, nColors);
            this.lSROverlayImages.get(iSROverStyle).drawO(oSB, nPosX, nPosY - this.lSROverlayImages.get(iSROverStyle).getHeight(), CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT);
            if (iSRLevel > 0) {
                this.lSRImages.get(iSRStyle).get(iSRLevel - 1).drawO(oSB, nPosX, nPosY - this.lSRImages.get(iSRStyle).get(iSRLevel - 1).getHeight(), CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT);
            }
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight() + CFG.SERVICE_RIBBON_HEIGHT - CFG.SERVICE_RIBBON_HEIGHT / 4, CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            CFG.drawRect(oSB, nPosX, nPosY - 1, CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT);
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            CFG.drawRect(oSB, nPosX - 1, nPosY - 2, CFG.SERVICE_RIBBON_WIDTH + 2, CFG.SERVICE_RIBBON_HEIGHT + 2);
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void saveData() {
        OutputStream os = null;
        try {
            FileHandle fileData = FileManager.getSaveType("game/service_ribbons/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            fileData.writeBytes(CFG.serialize(CFG.editorServiceRibbon_GameData), false);
            try {
                FileHandle file = FileManager.loadFile("game/service_ribbons/Age_of_Civilizations");
                String tempTags = file.readString();
                if (tempTags.indexOf(CFG.EDITOR_ACTIVE_GAMEDATA_TAG) < 0) {
                    FileHandle fileSave = FileManager.getSaveType("game/service_ribbons/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
                }
            }
            catch (GdxRuntimeException ex) {
                FileHandle fileSave = FileManager.getSaveType("game/service_ribbons/Age_of_Civilizations");
                fileSave.writeString(CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
            }
        }
        catch (IOException iOException) {
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    private final void loadSRImages() {
        int i;
        if (this.lSRImages != null) {
            for (i = 0; i < this.lSRImages.size(); ++i) {
                int j = 0;
                while (j < this.lSRImages.get(i).size()) {
                    this.lSRImages.get(i).get(j).getTexture().dispose();
                    this.lSRImages.get(i).remove(j);
                }
            }
            this.lSRImages.clear();
        }
        if (this.lSROverlayImages != null) {
            i = 0;
            while (i < this.lSROverlayImages.size()) {
                this.lSROverlayImages.get(i).getTexture().dispose();
                this.lSROverlayImages.remove(i);
            }
        }
        this.lSRImages = new ArrayList<List<Image>>();
        this.lSROverlayImages = new ArrayList<Image>();
        FileHandle tempFileT = FileManager.loadFile("UI/" + CFG.getResPath() + "sr/" + "Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        for (int i2 = 0; i2 < tagsSPLITED.length; ++i2) {
            try {
                ArrayList<Image> tempSRImages = new ArrayList<Image>();
                for (int j = 1; j < 6; ++j) {
                    tempSRImages.add(new Image(new Texture("UI/" + CFG.getResPath() + "sr/" + tagsSPLITED[i2] + "/" + j + ".png"), Texture.TextureFilter.Linear));
                }
                this.lSRImages.add(tempSRImages);
                continue;
            }
            catch (GdxRuntimeException tempSRImages) {
                // empty catch block
            }
        }
        int oRa = IMGManager.getIMG(Images.mainMenuEdge2).getWidth() + IMGManager.getIMG(Images.mainMenuEdge2).getHeight();
        FileHandle tempFileT2 = FileManager.loadFile("UI/" + CFG.getResPath() + "sr_over/" + "Age_of_Civilizations");
        String tempT2 = tempFileT2.readString();
        String[] tagsSPLITED2 = tempT2.split(";");
        for (int i3 = 0; i3 < tagsSPLITED2.length; ++i3) {
            try {
                this.lSROverlayImages.add(new Image(new Texture("UI/" + CFG.getResPath() + "sr_over/" + tagsSPLITED2[i3] + ".png"), Texture.TextureFilter.Linear));
                continue;
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                // empty catch block
            }
        }
        this.iSRImagesSize = this.lSRImages.size();
        this.iSROverlayImagesSize = this.lSROverlayImages.size();
        if (oRa != 306 && oRa != 278 && oRa != 550) {
            AoCGame.disposeImages().remove(5);
            AoCGame.disposeImages().add(AoCGame.disposeImages().get(1));
        }
    }

    public final ServiceRibbon_GameData getSR(int i) {
        return this.lSR.get(i);
    }

    public final int getSRID(String nTag) {
        for (int i = 0; i < this.iSRSize; ++i) {
            if (!this.lTags.get(i).equals(nTag)) continue;
            return i;
        }
        return 0;
    }

    public final ServiceRibbon_GameData getSR(String nTag) {
        for (int i = 0; i < this.iSRSize; ++i) {
            if (!this.lTags.get(i).equals(nTag)) continue;
            return this.lSR.get(i);
        }
        return this.lSR.get(0);
    }

    public final String getTag(int i) {
        return this.lTags.get(i);
    }

    public final int getSRSize() {
        return this.iSRSize;
    }

    public final int getSRImagesSize() {
        return this.iSRImagesSize;
    }

    public final int getSROverlayImagesSize() {
        return this.iSROverlayImagesSize;
    }
}

