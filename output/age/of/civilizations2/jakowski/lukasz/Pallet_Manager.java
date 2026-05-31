
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game2;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Civ_GameData;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Pallet_Manager {
    public static int NUM_OF_COLORS = 500;
    private int iActivePalletID = 0;
    private List<String> lPalletsTags;
    private List<Boolean> isInternal;
    private int iNumOfPallets = 0;
    private List<List<Color>> lSampleColors;
    private List<Integer> lColorsInPallet;
    private final int SAMPLE_COLORS_SIZE = 10;

    public Pallet_Manager() {
        this.updatePalletsOfCivsColorsTags();
    }

    public final void updatePalletsOfCivsColorsTags() {
        try {
            FileHandle tempFileT = FileManager.loadFile("game/pallets_of_civs_colors/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            this.lPalletsTags = new ArrayList<String>();
            this.isInternal = new ArrayList<Boolean>();
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                this.lPalletsTags.add(tagsSPLITED[i]);
                this.isInternal.add(true);
            }
            if (CFG.readLocalFiles()) {
                try {
                    FileHandle tempFileT_Local = Gdx.files.local("game/pallets_of_civs_colors/Age_of_Civilizations");
                    String tempT_Local = tempFileT_Local.readString();
                    String[] tagsSPLITED_Local = tempT_Local.split(";");
                    for (int i = 0; i < tagsSPLITED_Local.length; ++i) {
                        this.lPalletsTags.add(tagsSPLITED_Local[i]);
                        this.isInternal.add(false);
                    }
                }
                catch (GdxRuntimeException tempFileT_Local) {
                    
                }
                CFG.menus.INIT_GAME = 8;
            }
            this.lSampleColors = new ArrayList<List<Color>>();
            this.lColorsInPallet = new ArrayList<Integer>();
            this.iNumOfPallets = this.lPalletsTags.size();
            for (int i = 0; i < this.iNumOfPallets; ++i) {
                FileHandle tempFileT2;
                if (this.isInternal.get(i).booleanValue()) {
                    tempFileT2 = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + "Age_of_Civilizations");
                } else {
                    try {
                        tempFileT2 = Gdx.files.local("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + "Age_of_Civilizations");
                    }
                    catch (Exception ex) {
                        tempFileT2 = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + "Age_of_Civilizations");
                    }
                }
                String tempT2 = tempFileT2.readString();
                String[] tagsSPLITED2 = tempT2.split(";");
                this.lColorsInPallet.add(tagsSPLITED2.length);
                ArrayList<Color> tempSampleColors = new ArrayList<Color>();
                for (int j = 0; j < 10 && j < tagsSPLITED2.length; ++j) {
                    try {
                        try {
                            PalletOfCivsColors_Civ_GameData tempColor;
                            if (this.isInternal.get(i).booleanValue()) {
                                tempColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + tagsSPLITED2[j]).readBytes());
                            } else {
                                try {
                                    tempColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(Gdx.files.local("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + tagsSPLITED2[j]).readBytes());
                                }
                                catch (Exception ex) {
                                    tempColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(i) + "/" + tagsSPLITED2[j]).readBytes());
                                }
                            }
                            tempSampleColors.add(new Color(tempColor.getColor().getR(), tempColor.getColor().getG(), tempColor.getColor().getB(), 1.0f));
                        }
                        catch (ClassNotFoundException e) {
                        }
                        catch (IOException e) {}
                        continue;
                    }
                    catch (GdxRuntimeException ex) {
                        
                    }
                }
                this.lSampleColors.add(tempSampleColors);
            }
            if (!Button_Game2.getGlyphText().equals(Pallet_Manager.b())) {
                CFG.menus.INIT_GAME = 15;
            }
            Object var4_9 = null;
        }
        catch (Exception exception) {
            
        }
    }

    public final void loadCivilizationsPaletteOfColors(int nPaletteID) {
        if (nPaletteID == 0) {
            this.loadCivilizationStandardColors();
        } else {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getPuppetOfCiv() != i) continue;
                FileHandle file = null;
                try {
                    if (this.isInternal.get(nPaletteID - 1).booleanValue()) {
                        file = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(i).getCivTag());
                    } else {
                        try {
                            file = Gdx.files.local("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(i).getCivTag());
                        }
                        catch (Exception ex) {
                            file = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(i).getCivTag());
                        }
                    }
                    try {
                        PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                        CFG.core.getCiv(i).setR((int)(nCivColor.getColor().getR() * 255.0f));
                        CFG.core.getCiv(i).setG((int)(nCivColor.getColor().getG() * 255.0f));
                        CFG.core.getCiv(i).setB((int)(nCivColor.getColor().getB() * 255.0f));
                    }
                    catch (ClassNotFoundException e) {
                        this.loadCivilizationStandardColor(i);
                    }
                    catch (IOException e) {
                        this.loadCivilizationStandardColor(i);
                    }
                    continue;
                }
                catch (GdxRuntimeException ex) {
                    this.loadCivilizationStandardColor(i);
                }
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public final void loadCivilizationPalletColor(int nPaletteID, int nCivID) {
        try {
            FileHandle file;
            if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
                return;
            }
            if (this.isInternal.get(nPaletteID - 1).booleanValue()) {
                file = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(nCivID).getCivTag());
            } else {
                try {
                    file = Gdx.files.local("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(nCivID).getCivTag());
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("game/pallets_of_civs_colors/" + this.lPalletsTags.get(nPaletteID - 1) + "/" + CFG.core.getCiv(nCivID).getCivTag());
                }
            }
            try {
                PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                CFG.core.getCiv(nCivID).setR((int)(nCivColor.getColor().getR() * 255.0f));
                CFG.core.getCiv(nCivID).setG((int)(nCivColor.getColor().getG() * 255.0f));
                CFG.core.getCiv(nCivID).setB((int)(nCivColor.getColor().getB() * 255.0f));
            }
            catch (ClassNotFoundException e) {
                this.loadCivilizationStandardColor(nCivID);
                return;
            }
            catch (IOException e) {
                this.loadCivilizationStandardColor(nCivID);
                return;
            }
        }
        catch (GdxRuntimeException ex) {
            this.loadCivilizationStandardColor(nCivID);
            return;
        }
    }

    public final void loadCivilizationStandardColors() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.loadCivilizationStandardColor(i);
        }
    }

    public final void loadCivilizationStandardColor(int nCivID) {
        try {
            try {
                FileHandle fileCiv = FileManager.loadFile("game/civilizations/" + CFG.core.getCiv(nCivID).getCivTag());
                Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
            }
            catch (GdxRuntimeException ex) {
                try {
                    FileHandle fileCiv = Gdx.files.local("game/civilizations/" + CFG.core.getCiv(nCivID).getCivTag());
                    Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                    CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                    CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                    CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                }
                catch (GdxRuntimeException ex2) {
                    try {
                        FileHandle fileCiv = FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()));
                        Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                        CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                        CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                        CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                    }
                    catch (GdxRuntimeException exe) {
                        try {
                            FileHandle fileCiv = Gdx.files.local("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()));
                            Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                            CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                            CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                            CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                        }
                        catch (GdxRuntimeException exr) {
                            try {
                                FileHandle fileCiv = FileManager.loadFile("game/civilizations_editor/" + CFG.core.getCiv(nCivID).getCivTag() + "/" + CFG.core.getCiv(nCivID).getCivTag());
                                Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                                CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                                CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                            }
                            catch (GdxRuntimeException exd) {
                                try {
                                    FileHandle fileCiv = Gdx.files.local("game/civilizations_editor/" + CFG.core.getCiv(nCivID).getCivTag() + "/" + CFG.core.getCiv(nCivID).getCivTag());
                                    Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                    CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                                    CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                                    CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                                }
                                catch (GdxRuntimeException exc) {
                                    try {
                                        FileHandle fileCiv = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()));
                                        Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                        CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                                        CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                                        CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                                    }
                                    catch (GdxRuntimeException exx) {
                                        try {
                                            FileHandle fileCiv = Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()));
                                            Civilization_GameData3 tempCivGameData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                            CFG.core.getCiv(nCivID).setR(tempCivGameData.getR());
                                            CFG.core.getCiv(nCivID).setG(tempCivGameData.getG());
                                            CFG.core.getCiv(nCivID).setB(tempCivGameData.getB());
                                        }
                                        catch (GdxRuntimeException gdxRuntimeException) {}
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    private static String a() {
        return "QWdlIG9mIEhpc3Rvcnk";
    }

    private static String c() {
        return "gMjogRGVmaW5pdGl2ZSBFZGl0aW9u";
    }

    private static String b() {
        return new String(Base64.getDecoder().decode(Pallet_Manager.z()));
    }

    private static String z() {
        return Pallet_Manager.a() + Pallet_Manager.c();
    }

    public final void drawSampleColors(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int nPalletID, boolean isActive) {
        try {
            oSB.setColor(this.lSampleColors.get(nPalletID).get(0));
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
            int iSize = this.lSampleColors.get(nPalletID).size();
            for (int i = 1; i < iSize; ++i) {
                oSB.setColor(this.lSampleColors.get(nPalletID).get(i));
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + nWidth / iSize * i, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth / iSize, nHeight);
            }
            this.drawSampleColors_BORDER(oSB, nPosX, nPosY, nWidth, nHeight, nPalletID, isActive);
        }
        catch (Exception exception) {
            
        }
    }

    public final void drawSampleColors_Standard(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int nPalletID, boolean isActive) {
        oSB.setColor(new Color(0.35675678f, 0.0f, 0.28f, 1.0f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        for (int i = 1; i < 10; ++i) {
            oSB.setColor(new Color(0.032432433f * (float)(10 - i + 1), 0.0f, 0.28f, 1.0f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + nWidth / 10 * i, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth / 10, nHeight);
        }
        this.drawSampleColors_BORDER(oSB, nPosX, nPosY, nWidth, nHeight, nPalletID, isActive);
    }

    public final void drawSampleColors_BORDER(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, int nPalletID, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, isActive ? 0.95f : 0.7f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight() + nHeight - nHeight / 4, nWidth, nHeight / 4, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        CFG.drawRect(oSB, nPosX, nPosY - 1, nWidth, nHeight);
        oSB.setColor(isActive ? CFG.COLOR_FLAG_FRAME : CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        CFG.drawRect(oSB, nPosX - 1, nPosY - 2, nWidth + 2, nHeight + 2);
        oSB.setColor(Color.WHITE);
    }

    public final String getPalletTag(int i) {
        return this.lPalletsTags.get(i);
    }

    public final boolean getIsInternal(int i) {
        return this.isInternal.get(i);
    }

    public final int getNumOfPallets() {
        return this.iNumOfPallets;
    }

    public final int getActivePalletID() {
        return this.iActivePalletID;
    }

    public final void setActivePalletID(int iActivePalletID) {
        this.iActivePalletID = iActivePalletID;
    }

    public final int getNumOfColorsInPallet(int i) {
        return this.lColorsInPallet.get(i);
    }
}

