/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main_Games;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_NV
extends Menu {
    public int SHIP_PADD = 5;
    public int ingameW = 0;
    public int partW = 0;
    public int leftBoardX = 0;
    public int rightBoardX = 0;
    public int boardHeight = 0;
    public int paddingY = 0;
    public int[] aiShipsLength = new int[]{5, 4, 3, 3, 2};
    public String shipsSt = "5, 4, 3, 3, 2";
    public boolean deployShips = true;
    public boolean shipDeploy = false;
    public int iLastXPos = -1;
    public int iLastYPos = -1;
    public boolean GameEnd = false;
    public int iPlayerTurn = 0;
    private int iPositionInGame = 0;
    private int iDeployDirection = 0;
    private int deployUP = 0;
    private int deployRIGHT = 0;
    private int deployDOWN = 0;
    private int deployLEFT = 0;
    private String[] asAlphabet = new String[]{"_", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " ", "-"};
    public static String[] PositionsY = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static View goBack = View.eMAINMENU;
    public PlayerNV oP1;
    public PlayerNV oP2;
    public int opponentID = 0;
    public AI_BS oAI = new AI_BS();

    public Menu_NV() {
        int i;
        int j;
        int i2;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Main_Games("Battleship, developed in 2012 by Lukasz Jakowski", -1, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://www.youtube.com/watch?v=PQvF16Qt3VQ";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        menuElements.add(new Button_Classic_LR_Main(CFG.lang.get("Back"), -1, CFG.GAMEWIDTH / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuIDWithoutAnim(goBack);
            }
        });
        menuElements.add(new Text("Mom, can we have the navy.", CFG.PADD * 2, CFG.PADD * 2){

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://lukaszjakowski.pl/navyAoH2DE/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.COLOR_HOVER_TITLE;
            }
        });
        menuElements.add(new Text("No, we have the navy at home.", CFG.PADD * 2, CFG.PADD * 3 + CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://lukaszjakowski.pl/navyAoH2DE/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.COLOR_HOVER_TITLE;
            }
        });
        menuElements.add(new Text("The navy at home:", CFG.PADD * 2, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT * 2){

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://lukaszjakowski.pl/navyAoH2DE/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.COLOR_HOVER_TITLE;
            }
        });
        this.opponentID = CFG.oR.nextInt(8);
        this.init();
        this.paddingY = (int)((float)(CFG.GAMEHEIGHT - CFG.BUTTON_H) * 0.25f);
        this.boardHeight = CFG.GAMEHEIGHT - CFG.BUTTON_H - this.paddingY * 2;
        this.partW = this.boardHeight / 10;
        this.boardHeight = this.partW * 10;
        this.leftBoardX = CFG.GAMEWIDTH / 4 - this.boardHeight / 2;
        this.rightBoardX = CFG.GAMEWIDTH * 3 / 4 - this.boardHeight / 2;
        for (i2 = 0; i2 < this.oP1.Map.length; ++i2) {
            for (j = 0; j < this.oP1.Map[i2].length; ++j) {
                menuElements.add(new Button_Transparent(this.leftBoardX + this.partW * i2, this.paddingY + this.partW * j, this.partW, this.partW, true){
                    int idX;
                    int idY;
                    {
                        this.idX = 0;
                        this.idY = 0;
                    }

                    @Override
                    public void buildElemHover() {
                        if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.SHIP) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Ship", CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.SHIP_DESTROYED) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Destroyed ship", CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.SHOT) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Fired here"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.WATER) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Water"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    }

                    @Override
                    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.SHIP) {
                            oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 2, this.getHeightE() - Menu_NV.this.SHIP_PADD * 2, 1.0f);
                            oSB.setColor(new Color(0.54509807f, 0.72156864f, 0.13725491f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 2 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 2 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 4, this.getHeightE() - Menu_NV.this.SHIP_PADD * 4, 1.0f);
                        } else if (Menu_NV.this.oP1.Map[this.idX][this.idY] == MapBS.SHIP_DESTROYED) {
                            oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 2, this.getHeightE() - Menu_NV.this.SHIP_PADD * 2, 1.0f);
                            oSB.setColor(new Color(0.7137255f, 0.28627452f, 0.16470589f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 2 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 2 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 4, this.getHeightE() - Menu_NV.this.SHIP_PADD * 4, 1.0f);
                        } else if (Menu_NV.this.oP2.MapShoots[this.idX][this.idY] == MapBS.SHOT) {
                            oSB.setColor(new Color(0.68235296f, 0.75686276f, 0.84705883f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                            oSB.setColor(new Color(0.49019608f, 0.5529412f, 0.654902f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                        }
                        if (this.getIsHovered()) {
                            oSB.setColor(new Color(0.3019608f, 0.53333336f, 0.74509805f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 0.75f);
                        }
                        oSB.setColor(Color.WHITE);
                    }

                    @Override
                    public void actionElemPPM() {
                        if (Menu_NV.this.deployShips && Menu_NV.this.shipDeploy) {
                            int i;
                            boolean canBeDeployed = false;
                            for (i = Menu_NV.this.iDeployDirection + 1; i < 5; ++i) {
                                Menu_NV.this.iDeployDirection = i;
                                if (!Menu_NV.this.CheckDirection(1, Menu_NV.this.iLastXPos, Menu_NV.this.iLastYPos)) continue;
                                canBeDeployed = true;
                                break;
                            }
                            if (!canBeDeployed) {
                                for (i = 1; i < 5; ++i) {
                                    Menu_NV.this.iDeployDirection = i;
                                    if (!Menu_NV.this.CheckDirection(1, Menu_NV.this.iLastXPos, Menu_NV.this.iLastYPos)) continue;
                                    canBeDeployed = true;
                                    break;
                                }
                            }
                            if (!canBeDeployed) {
                                Menu_NV.this.iLastXPos = -1;
                                Menu_NV.this.iLastYPos = -1;
                                Menu_NV.this.shipDeploy = false;
                                Menu_NV.this.iDeployDirection = 0;
                                Menu_NV.this.ResetDeployDirections();
                                CFG.toastM.addM("P1: No space for the selected position", CFG.COLOR_NEGATIVE_2);
                            }
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (Menu_NV.this.GameEnd) {
                            CFG.toastM.addM("The game has ended!", CFG.COLOR_NEGATIVE_2);
                        } else if (Menu_NV.this.deployShips) {
                            if (Menu_NV.this.shipDeploy) {
                                if (Menu_NV.this.iDeployDirection != 0 && Menu_NV.this.CheckDirection(1, Menu_NV.this.iLastXPos, Menu_NV.this.iLastYPos)) {
                                    Menu_NV.this.setShip(1);
                                    Menu_NV.this.iDeployDirection = 0;
                                    Menu_NV.this.shipDeploy = false;
                                    switch (CFG.oR.nextInt(4)) {
                                        case 0: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Ship deployed successfully", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        case 1: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Ship positioned", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        case 2: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Deployment successful", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        default: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Deployed", CFG.COLOR_POSITIVE);
                                        }
                                    }
                                    CFG.SFXManager.playSound(SFXManager.SFX_PORT);
                                }
                                if (Menu_NV.this.oP1.getDeployedShips() >= Menu_NV.this.aiShipsLength.length) {
                                    Menu_NV.this.setPositionInGame(1111);
                                    Menu_NV.this.AutoDeploy(2);
                                    Menu_NV.this.deployShips = false;
                                }
                                Menu_NV.this.ResetDeployDirections();
                                Menu_NV.this.shipDeploy = false;
                            } else {
                                Menu_NV.this.iLastXPos = this.idX;
                                Menu_NV.this.iLastYPos = this.idY;
                                if (Menu_NV.this.iDeployDirection == 0) {
                                    boolean canBeDeployed = false;
                                    for (int i = 1; i < 5; ++i) {
                                        Menu_NV.this.iDeployDirection = i;
                                        if (!Menu_NV.this.CheckDirection(1, Menu_NV.this.iLastXPos, Menu_NV.this.iLastYPos)) continue;
                                        canBeDeployed = true;
                                        break;
                                    }
                                    if (!canBeDeployed) {
                                        Menu_NV.this.iLastXPos = -1;
                                        Menu_NV.this.iLastYPos = -1;
                                        Menu_NV.this.shipDeploy = false;
                                        Menu_NV.this.iDeployDirection = 0;
                                        Menu_NV.this.ResetDeployDirections();
                                        CFG.toastM.addM("P1: No space for the selected position", CFG.COLOR_NEGATIVE_2);
                                        return;
                                    }
                                    Menu_NV.this.shipDeploy = true;
                                }
                            }
                        }
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.idX = nCurrent;
                    }

                    @Override
                    public void setMax(int iMax) {
                        this.idY = iMax;
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i2);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(j);
            }
        }
        for (i2 = 0; i2 < this.oP2.Map.length; ++i2) {
            for (j = 0; j < this.oP2.Map[i2].length; ++j) {
                menuElements.add(new Button_Transparent(this.rightBoardX + this.partW * i2, this.paddingY + this.partW * j, this.partW, this.partW, true){
                    int idX;
                    int idY;
                    {
                        this.idX = 0;
                        this.idY = 0;
                    }

                    @Override
                    public void buildElemHover() {
                        if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHIP_DESTROYED) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Destroyed ship", CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHOT) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Fired here"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHIP && Menu_NV.this.GameEnd) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Ship", CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big("Water"));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    }

                    @Override
                    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (Menu_NV.this.GameEnd) {
                            if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHIP) {
                                oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 2, this.getHeightE() - Menu_NV.this.SHIP_PADD * 2, 1.0f);
                                oSB.setColor(new Color(0.54509807f, 0.72156864f, 0.13725491f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 2 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 2 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 4, this.getHeightE() - Menu_NV.this.SHIP_PADD * 4, 1.0f);
                            } else if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHIP_DESTROYED) {
                                oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 2, this.getHeightE() - Menu_NV.this.SHIP_PADD * 2, 1.0f);
                                oSB.setColor(new Color(0.7137255f, 0.28627452f, 0.16470589f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 2 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 2 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 4, this.getHeightE() - Menu_NV.this.SHIP_PADD * 4, 1.0f);
                            } else if (Menu_NV.this.oP1.MapShoots[this.idX][this.idY] == MapBS.SHOT) {
                                oSB.setColor(new Color(0.68235296f, 0.75686276f, 0.84705883f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                                oSB.setColor(new Color(0.49019608f, 0.5529412f, 0.654902f, 1.0f));
                                Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                            }
                        } else if (Menu_NV.this.oP2.Map[this.idX][this.idY] == MapBS.SHIP_DESTROYED) {
                            oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 2, this.getHeightE() - Menu_NV.this.SHIP_PADD * 2, 1.0f);
                            oSB.setColor(new Color(0.7137255f, 0.28627452f, 0.16470589f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 2 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 2 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 4, this.getHeightE() - Menu_NV.this.SHIP_PADD * 4, 1.0f);
                        } else if (Menu_NV.this.oP1.MapShoots[this.idX][this.idY] == MapBS.SHOT) {
                            oSB.setColor(new Color(0.68235296f, 0.75686276f, 0.84705883f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                            oSB.setColor(new Color(0.49019608f, 0.5529412f, 0.654902f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 1.0f);
                        }
                        if (this.getIsHovered()) {
                            oSB.setColor(new Color(0.3019608f, 0.53333336f, 0.74509805f, 1.0f));
                            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + Menu_NV.this.SHIP_PADD * 3 + iTranslateX, this.getPosY() + Menu_NV.this.SHIP_PADD * 3 + iTranslateY, this.getWidthE() - Menu_NV.this.SHIP_PADD * 6, this.getHeightE() - Menu_NV.this.SHIP_PADD * 6, 0.75f);
                        }
                        oSB.setColor(Color.WHITE);
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (Menu_NV.this.deployShips) {
                            if (Menu_NV.this.shipDeploy) {
                                CFG.toastM.addM("Ship deployment canceled");
                                Menu_NV.this.iLastXPos = -1;
                                Menu_NV.this.iLastYPos = -1;
                                Menu_NV.this.shipDeploy = false;
                                Menu_NV.this.iDeployDirection = 0;
                                Menu_NV.this.ResetDeployDirections();
                            } else {
                                CFG.toastM.addM("Deploy ships on your grid");
                            }
                        } else if (Menu_NV.this.GameEnd) {
                            CFG.toastM.addM("The game has ended!", CFG.COLOR_NEGATIVE_2);
                        } else {
                            Menu_NV.this.iLastXPos = this.idX;
                            Menu_NV.this.iLastYPos = this.idY;
                            if (Menu_NV.this.CheckPositionToShoot(1)) {
                                if (Menu_NV.this.oP2.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP) {
                                    switch (CFG.oR.nextInt(4)) {
                                        case 0: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Hit!", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        case 1: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Direct hit!", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        case 2: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Ship hit!", CFG.COLOR_POSITIVE);
                                            break;
                                        }
                                        default: {
                                            CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Enemy ship hit!", CFG.COLOR_POSITIVE);
                                        }
                                    }
                                    Menu_NV.this.oP1.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHIP_DESTROYED;
                                    Menu_NV.this.oP2.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHIP_DESTROYED;
                                    Menu_NV.this.oP1.setNumOfHits(Menu_NV.this.oP1.getNumOfHits() + 1);
                                    CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
                                    if (Menu_NV.this.CheckShip(1)) {
                                        switch (CFG.oR.nextInt(4)) {
                                            case 0: {
                                                CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Ship sunk!", CFG.COLOR_POSITIVE);
                                                break;
                                            }
                                            case 1: {
                                                CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Enemy ship sunk!", CFG.COLOR_POSITIVE);
                                                break;
                                            }
                                            case 2: {
                                                CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - Target destroyed!", CFG.COLOR_POSITIVE);
                                                break;
                                            }
                                            default: {
                                                CFG.toastM.addM(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos] + " - All ship parts destroyed!", CFG.COLOR_POSITIVE);
                                            }
                                        }
                                        Menu_NV.this.oP2.setNumOfLostShips(Menu_NV.this.oP2.getNumOfLostShips() + 1);
                                        Menu_NV.this.ShipUnderWater(1, Menu_NV.this.oP1.MapShoots);
                                    }
                                    if (Menu_NV.this.oP2.getNumOfLostShips() < Menu_NV.this.aiShipsLength.length) {
                                        Menu_NV.this.iPlayerTurn = 1;
                                    } else {
                                        Menu_NV.this.GameEnd = true;
                                        Menu_NV.this.iPlayerTurn = 0;
                                    }
                                } else {
                                    switch (CFG.oR.nextInt(4)) {
                                        case 0: {
                                            CFG.toastM.addM("Miss", CFG.COLOR_NEGATIVE_1);
                                            break;
                                        }
                                        case 1: {
                                            CFG.toastM.addM("Splash", CFG.COLOR_NEGATIVE_1);
                                            break;
                                        }
                                        case 2: {
                                            CFG.toastM.addM("No hit", CFG.COLOR_NEGATIVE_1);
                                            break;
                                        }
                                        default: {
                                            CFG.toastM.addM("Water hit", CFG.COLOR_NEGATIVE_1);
                                        }
                                    }
                                    Menu_NV.this.oP1.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHOT;
                                    Menu_NV.this.oP2.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHOT;
                                    Menu_NV.this.iPlayerTurn = 2;
                                    Menu_NV.this.oAI.setAINextShoot();
                                    CFG.SFXManager.playSound(SFXManager.SFX_CLICK);
                                }
                                Menu_NV.this.oP1.setNumOfShoots(Menu_NV.this.oP1.getNumOfShoots() + 1);
                            } else {
                                CFG.toastM.addM("You cannot fire here", CFG.COLOR_NEGATIVE_2);
                            }
                        }
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.idX = nCurrent;
                    }

                    @Override
                    public void setMax(int iMax) {
                        this.idY = iMax;
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i2);
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(j);
            }
        }
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), "A");
        int tAW = (int)CFG.glyphLay.width;
        for (i = 0; i < this.oP1.Map.length; ++i) {
            menuElements.add(new Text(i + 1 + "", -1, this.leftBoardX + this.partW * i, this.paddingY - CFG.PADD * 3 - CFG.TEXT_HEIGHT_DEFAULT, this.partW, CFG.TEXT_HEIGHT_DEFAULT));
            menuElements.add(new Text((char)(65 + i) + "", 0, this.leftBoardX - CFG.PADD * 4 - tAW, this.paddingY + this.partW * i + this.partW / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, tAW + CFG.PADD, CFG.TEXT_HEIGHT_DEFAULT + 1));
        }
        for (i = 0; i < this.oP2.Map.length; ++i) {
            menuElements.add(new Text(i + 1 + "", -1, this.rightBoardX + this.partW * i, this.paddingY - CFG.PADD * 3 - CFG.TEXT_HEIGHT_DEFAULT, this.partW, CFG.TEXT_HEIGHT_DEFAULT));
            menuElements.add(new Text((char)(65 + i) + "", 0, this.rightBoardX - CFG.PADD * 4 - tAW, this.paddingY + this.partW * i + this.partW / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, tAW + CFG.PADD, CFG.TEXT_HEIGHT_DEFAULT + 1));
        }
        menuElements.add(new Text("Your Grid: " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), -1, this.leftBoardX, this.paddingY + this.boardHeight + CFG.PADD * 3, this.boardHeight, CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public Color getColor(boolean isActive) {
                if (Menu_NV.this.GameEnd) {
                    if (Menu_NV.this.oP1.getNumOfLostShips() <= 4) {
                        return CFG.COLOR_POSITIVE;
                    }
                    return CFG.COLOR_NEGATIVE_2;
                }
                return super.getColor(isActive);
            }
        });
        menuElements.add(new Text("Place your ships here", -1, this.leftBoardX, this.paddingY + this.boardHeight + CFG.PADD * 5 + CFG.TEXT_HEIGHT_DEFAULT, this.boardHeight, CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public boolean getVisibleE() {
                if (!Menu_NV.this.deployShips) {
                    return false;
                }
                return super.getVisibleE();
            }
        });
        menuElements.add(new Text("Opponent's Grid: " + this.getOpponentName(), -1, this.rightBoardX, this.paddingY + this.boardHeight + CFG.PADD * 3, this.boardHeight, CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public Color getColor(boolean isActive) {
                if (Menu_NV.this.GameEnd) {
                    if (Menu_NV.this.oP1.getNumOfLostShips() <= 4) {
                        return CFG.COLOR_NEGATIVE_2;
                    }
                    return CFG.COLOR_POSITIVE;
                }
                return super.getColor(isActive);
            }
        });
        menuElements.add(new Text("Shoot here", -1, this.rightBoardX, this.paddingY + this.boardHeight + CFG.PADD * 5 + CFG.TEXT_HEIGHT_DEFAULT, this.boardHeight, CFG.TEXT_HEIGHT_DEFAULT));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), "All ships deployed, the battle is on!");
        this.ingameW = (int)CFG.glyphLay.width;
    }

    public int getMapSize() {
        return 10;
    }

    public void ResetDeployDirections() {
        this.deployUP = 0;
        this.deployRIGHT = 0;
        this.deployDOWN = 0;
        this.deployLEFT = 0;
    }

    public void AutoDeploy(int nPlayerID) {
        this.iLastXPos = CFG.oR.nextInt(this.getMapSize());
        this.iLastYPos = CFG.oR.nextInt(this.getMapSize());
        this.setDeployDirection(CFG.oR.nextInt(4) + 1);
        if (nPlayerID == 2 && this.oP2.getDeployedShips() < this.aiShipsLength.length) {
            if (this.CheckDirection(2, this.iLastXPos, this.iLastYPos)) {
                this.setShip(nPlayerID);
            }
            this.AutoDeploy(nPlayerID);
        }
    }

    public boolean CheckShip(int nPlayerID) {
        int i;
        int iLine = 2;
        for (i = 1; i < iLine; ++i) {
            if (!this.CheckXPosition(this.iLastXPos - i)) continue;
            if (nPlayerID == 1) {
                if (this.oP2.Map[this.iLastXPos - i][this.iLastYPos] == MapBS.SHIP) {
                    return false;
                }
                if (this.oP2.Map[this.iLastXPos - i][this.iLastYPos] != MapBS.SHIP_DESTROYED) continue;
                ++iLine;
                continue;
            }
            if (this.oP1.Map[this.iLastXPos - i][this.iLastYPos] == MapBS.SHIP) {
                return false;
            }
            if (this.oP1.Map[this.iLastXPos - i][this.iLastYPos] != MapBS.SHIP_DESTROYED) continue;
            ++iLine;
        }
        iLine = 2;
        for (i = 1; i < iLine; ++i) {
            if (!this.CheckYPosition(this.iLastYPos - i)) continue;
            if (nPlayerID == 1) {
                if (this.oP2.Map[this.iLastXPos][this.iLastYPos - i] == MapBS.SHIP) {
                    return false;
                }
                if (this.oP2.Map[this.iLastXPos][this.iLastYPos - i] != MapBS.SHIP_DESTROYED) continue;
                ++iLine;
                continue;
            }
            if (this.oP1.Map[this.iLastXPos][this.iLastYPos - i] == MapBS.SHIP) {
                return false;
            }
            if (this.oP1.Map[this.iLastXPos][this.iLastYPos - i] != MapBS.SHIP_DESTROYED) continue;
            ++iLine;
        }
        iLine = 2;
        for (i = 1; i < iLine; ++i) {
            if (!this.CheckXPosition(this.iLastXPos + i)) continue;
            if (nPlayerID == 1) {
                if (this.oP2.Map[this.iLastXPos + i][this.iLastYPos] == MapBS.SHIP) {
                    return false;
                }
                if (this.oP2.Map[this.iLastXPos + i][this.iLastYPos] != MapBS.SHIP_DESTROYED) continue;
                ++iLine;
                continue;
            }
            if (this.oP1.Map[this.iLastXPos + i][this.iLastYPos] == MapBS.SHIP) {
                return false;
            }
            if (this.oP1.Map[this.iLastXPos + i][this.iLastYPos] != MapBS.SHIP_DESTROYED) continue;
            ++iLine;
        }
        iLine = 2;
        for (i = 1; i < iLine; ++i) {
            if (!this.CheckYPosition(this.iLastYPos + i)) continue;
            if (nPlayerID == 1) {
                if (this.oP2.Map[this.iLastXPos][this.iLastYPos + i] == MapBS.SHIP) {
                    return false;
                }
                if (this.oP2.Map[this.iLastXPos][this.iLastYPos + i] != MapBS.SHIP_DESTROYED) continue;
                ++iLine;
                continue;
            }
            if (this.oP1.Map[this.iLastXPos][this.iLastYPos + i] == MapBS.SHIP) {
                return false;
            }
            if (this.oP1.Map[this.iLastXPos][this.iLastYPos + i] != MapBS.SHIP_DESTROYED) continue;
            ++iLine;
        }
        return true;
    }

    public void ShipUnderWater(int nPlayerID, MapBS[][] nMapShoots) {
        this.setFirstPartOfTheShip(nMapShoots);
        for (int i = 1; i < 2; ++i) {
            if (nMapShoots[this.iLastXPos][this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                this.ShipDestroyed(nPlayerID);
            }
            if (this.CheckYPosition(this.iLastYPos + 1) && nMapShoots[this.iLastXPos][this.iLastYPos + 1] == MapBS.SHIP_DESTROYED) {
                ++this.iLastYPos;
                --i;
            }
            if (!this.CheckXPosition(this.iLastXPos + 1) || nMapShoots[this.iLastXPos + 1][this.iLastYPos] != MapBS.SHIP_DESTROYED) continue;
            ++this.iLastXPos;
            --i;
        }
    }

    public void setFirstPartOfTheShip(MapBS[][] nMapShoots) {
        for (int i = 1; i < 2; ++i) {
            if (this.CheckXPosition(this.iLastXPos - 1) && nMapShoots[this.iLastXPos - 1][this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                --this.iLastXPos;
                --i;
            }
            if (!this.CheckYPosition(this.iLastYPos - 1) || nMapShoots[this.iLastXPos][this.iLastYPos - 1] != MapBS.SHIP_DESTROYED) continue;
            --this.iLastYPos;
            --i;
        }
    }

    public void ShipDestroyed(int nPlayerID) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (!this.CheckXPosition(this.iLastXPos + j) || !this.CheckYPosition(this.iLastYPos + i)) continue;
                this.setShot(nPlayerID, this.iLastXPos + j, this.iLastYPos + i);
            }
        }
    }

    public void setShot(int nPlayerID, int nX, int nY) {
        switch (nPlayerID) {
            case 1: {
                if (this.oP1.MapShoots[nX][nY] == MapBS.SHIP_DESTROYED) break;
                this.oP1.MapShoots[nX][nY] = MapBS.SHOT;
                break;
            }
            case 2: {
                if (this.oP2.MapShoots[nX][nY] == MapBS.SHIP_DESTROYED) break;
                this.oP2.MapShoots[nX][nY] = MapBS.SHOT;
            }
        }
    }

    public int getPositionInGame() {
        return this.iPositionInGame;
    }

    public void setPositionInGame(int nPositionInGame) {
        this.iPositionInGame = nPositionInGame;
    }

    public int getDeployDirection() {
        return this.iDeployDirection;
    }

    public void setDeployDirection(int nDir) {
        this.iDeployDirection = nDir;
    }

    public String[] getPositionY() {
        return PositionsY;
    }

    public void setShip(int nPlayerID) {
        if (nPlayerID == 1) {
            for (int i = 0; i < this.aiShipsLength[this.oP1.getDeployedShips()]; ++i) {
                if (this.getDeployDirection() == 2 || this.getDeployDirection() == 4) {
                    this.oP1.Map[this.iLastXPos + i * this.setDirectionOnMap()][this.iLastYPos] = MapBS.SHIP;
                    continue;
                }
                this.oP1.Map[this.iLastXPos][this.iLastYPos + i * this.setDirectionOnMap()] = MapBS.SHIP;
            }
            this.oP1.setDeployedShips(this.oP1.getDeployedShips() + 1);
        } else if (nPlayerID == 2) {
            for (int i = 0; i < this.aiShipsLength[this.oP2.getDeployedShips()]; ++i) {
                if (this.getDeployDirection() == 2 || this.getDeployDirection() == 4) {
                    this.oP2.Map[this.iLastXPos + i * this.setDirectionOnMap()][this.iLastYPos] = MapBS.SHIP;
                    continue;
                }
                this.oP2.Map[this.iLastXPos][this.iLastYPos + i * this.setDirectionOnMap()] = MapBS.SHIP;
            }
            this.oP2.setDeployedShips(this.oP2.getDeployedShips() + 1);
        }
    }

    public boolean CheckPositionToShoot(int nPlayerID) {
        if (this.CheckXPosition(this.iLastXPos) && this.CheckYPosition(this.iLastYPos)) {
            if (nPlayerID == 1 && (this.oP1.MapShoots[this.iLastXPos][this.iLastYPos] == MapBS.SHOT || this.oP1.MapShoots[this.iLastXPos][this.iLastYPos] == MapBS.SHIP_DESTROYED)) {
                return false;
            }
            return nPlayerID != 2 || this.oP2.MapShoots[this.iLastXPos][this.iLastYPos] != MapBS.SHOT && this.oP2.MapShoots[this.iLastXPos][this.iLastYPos] != MapBS.SHIP_DESTROYED;
        }
        return false;
    }

    public int setDirectionOnMap() {
        if (this.getDeployDirection() == 1 || this.getDeployDirection() == 4) {
            return -1;
        }
        return 1;
    }

    public boolean CheckDirection(int nPlayerID, int nXPos, int nYPos) {
        int iDirection = this.setDirectionOnMap();
        int iX = 0;
        int iY = 0;
        int iDeployedShips = nPlayerID == 1 ? this.oP1.getDeployedShips() : this.oP2.getDeployedShips();
        if (this.getDeployDirection() == 1 || this.getDeployDirection() == 3) {
            iY = nYPos + (this.aiShipsLength[iDeployedShips] - 1) * iDirection;
        } else {
            iX = nXPos + (this.aiShipsLength[iDeployedShips] - 1) * iDirection;
        }
        if (!this.CheckXPosition(iX) || !this.CheckYPosition(iY)) {
            return false;
        }
        for (int i = 0; i < this.aiShipsLength[iDeployedShips]; ++i) {
            if (!(this.getDeployDirection() == 2 || this.getDeployDirection() == 4 ? !this.CheckPlace(nPlayerID, nXPos + i * iDirection, nYPos) : !this.CheckPlace(nPlayerID, nXPos, nYPos + i * iDirection))) continue;
            return false;
        }
        return true;
    }

    public boolean CheckPlace(int nPlayerID, int nX, int nY) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (!this.CheckXPosition(nX + i) || !this.CheckYPosition(nY + j)) continue;
                if (nPlayerID == 1) {
                    if (this.oP1.Map[nX + i][nY + j] != MapBS.SHIP) continue;
                    CFG.toastM.addM("P1: No space for the selected position", CFG.COLOR_NEGATIVE_2);
                    return false;
                }
                if (this.oP2.Map[nX + i][nY + j] != MapBS.SHIP) continue;
                return false;
            }
        }
        return true;
    }

    public boolean CheckXPosition(int nX) {
        return nX >= 0 && nX < this.getMapSize();
    }

    public boolean CheckYPosition(int nY) {
        return nY >= 0 && nY < this.getMapSize();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int i;
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        IMGManager.getIMG(Images.pix255).draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.15f));
        IMGManager.getIMG(Images.pattern).draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        if (this.GameEnd) {
            oSB.setColor(new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 0.35f));
            IMGManager.getIMG(Images.pattern).draw2(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
            if (this.oP1.getNumOfLostShips() <= 4) {
                oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.85f));
                IMGManager.getIMG(Images.gradientVertical).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.GAMEHEIGHT / 4 + iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT / 4, false, true);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Victory! You have won the game!", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 5 + CFG.TEXT_HEIGHT_DEFAULT * 3, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            } else {
                oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.85f));
                IMGManager.getIMG(Images.gradientVertical).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.GAMEHEIGHT / 4 + iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT / 4, false, true);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Game over. You were defeated!", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 5 + CFG.TEXT_HEIGHT_DEFAULT * 3, CFG.COLOR_NEGATIVE_2);
            }
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Lost ships: " + this.oP1.getNumOfLostShips(), this.leftBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 6 + CFG.TEXT_HEIGHT_DEFAULT * 4, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Total shots fired: " + this.oP1.getNumOfShoots(), this.leftBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 7 + CFG.TEXT_HEIGHT_DEFAULT * 5, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Successful hits: " + this.oP1.getNumOfHits(), this.leftBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 8 + CFG.TEXT_HEIGHT_DEFAULT * 6, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Lost ships: " + this.oP2.getNumOfLostShips(), this.rightBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 6 + CFG.TEXT_HEIGHT_DEFAULT * 4, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Total shots fired: " + this.oP2.getNumOfShoots(), this.rightBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 7 + CFG.TEXT_HEIGHT_DEFAULT * 5, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Successful hits: " + this.oP2.getNumOfHits(), this.rightBoardX + this.boardHeight / 2 + iTranslateX, CFG.PADD * 8 + CFG.TEXT_HEIGHT_DEFAULT * 6, CFG.COLOR_NEUTRAL);
        }
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX - CFG.PADD + iTranslateX, this.paddingY - CFG.PADD + iTranslateY, this.boardHeight + CFG.PADD * 2, this.boardHeight + CFG.PADD * 2, 1.0f);
        oSB.setColor(new Color(0.53333336f, 0.53333336f, 0.53333336f, 1.0f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.leftBoardX - CFG.PADD + iTranslateX, this.paddingY - CFG.PADD + iTranslateY, this.boardHeight + CFG.PADD * 2, this.boardHeight + CFG.PADD * 2, 1.0f);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.rightBoardX - CFG.PADD + iTranslateX, this.paddingY - CFG.PADD + iTranslateY, this.boardHeight + CFG.PADD * 2, this.boardHeight + CFG.PADD * 2, 1.0f);
        oSB.setColor(new Color(0.53333336f, 0.53333336f, 0.53333336f, 1.0f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.rightBoardX - CFG.PADD + iTranslateX, this.paddingY - CFG.PADD + iTranslateY, this.boardHeight + CFG.PADD * 2, this.boardHeight + CFG.PADD * 2, 1.0f);
        oSB.setColor(new Color(0.6509804f, 0.7490196f, 0.85882354f, 1.0f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.leftBoardX + iTranslateX, this.paddingY + iTranslateY, this.boardHeight, this.boardHeight);
        oSB.setColor(new Color(0.6509804f, 0.7490196f, 0.85882354f, 1.0f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.rightBoardX + iTranslateX, this.paddingY + iTranslateY, this.boardHeight, this.boardHeight);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.deployShips && this.shipDeploy && this.iLastXPos >= 0 && this.iLastYPos >= 0) {
            oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD + iTranslateY, this.partW - this.SHIP_PADD * 2, this.partW - this.SHIP_PADD * 2, 1.0f);
            oSB.setColor(new Color(0.54509807f, 0.63529414f, 0.72156864f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD * 2 + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD * 2 + iTranslateY, this.partW - this.SHIP_PADD * 4, this.partW - this.SHIP_PADD * 4, 1.0f);
            if (this.iDeployDirection > 0) {
                if (this.iDeployDirection == 1) {
                    for (i = 1; i < this.aiShipsLength[this.oP1.getDeployedShips()]; ++i) {
                        oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD + iTranslateX, this.paddingY + (this.iLastYPos - i) * this.partW + this.SHIP_PADD + iTranslateY, this.partW - this.SHIP_PADD * 2, this.partW - this.SHIP_PADD * 2, 1.0f);
                        oSB.setColor(new Color(0.54509807f, 0.63529414f, 0.72156864f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD * 2 + iTranslateX, this.paddingY + (this.iLastYPos - i) * this.partW + this.SHIP_PADD * 2 + iTranslateY, this.partW - this.SHIP_PADD * 4, this.partW - this.SHIP_PADD * 4, 1.0f);
                    }
                } else if (this.iDeployDirection == 2) {
                    for (i = 1; i < this.aiShipsLength[this.oP1.getDeployedShips()]; ++i) {
                        oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + (this.iLastXPos + i) * this.partW + this.SHIP_PADD + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD + iTranslateY, this.partW - this.SHIP_PADD * 2, this.partW - this.SHIP_PADD * 2, 1.0f);
                        oSB.setColor(new Color(0.54509807f, 0.63529414f, 0.72156864f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + (this.iLastXPos + i) * this.partW + this.SHIP_PADD * 2 + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD * 2 + iTranslateY, this.partW - this.SHIP_PADD * 4, this.partW - this.SHIP_PADD * 4, 1.0f);
                    }
                } else if (this.iDeployDirection == 3) {
                    for (i = 1; i < this.aiShipsLength[this.oP1.getDeployedShips()]; ++i) {
                        oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD + iTranslateX, this.paddingY + (this.iLastYPos + i) * this.partW + this.SHIP_PADD + iTranslateY, this.partW - this.SHIP_PADD * 2, this.partW - this.SHIP_PADD * 2, 1.0f);
                        oSB.setColor(new Color(0.54509807f, 0.63529414f, 0.72156864f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + this.iLastXPos * this.partW + this.SHIP_PADD * 2 + iTranslateX, this.paddingY + (this.iLastYPos + i) * this.partW + this.SHIP_PADD * 2 + iTranslateY, this.partW - this.SHIP_PADD * 4, this.partW - this.SHIP_PADD * 4, 1.0f);
                    }
                } else if (this.iDeployDirection == 4) {
                    for (i = 1; i < this.aiShipsLength[this.oP1.getDeployedShips()]; ++i) {
                        oSB.setColor(new Color(0.40784314f, 0.4862745f, 0.59607846f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + (this.iLastXPos - i) * this.partW + this.SHIP_PADD + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD + iTranslateY, this.partW - this.SHIP_PADD * 2, this.partW - this.SHIP_PADD * 2, 1.0f);
                        oSB.setColor(new Color(0.54509807f, 0.63529414f, 0.72156864f, 1.0f));
                        Renderer.drawBox2(oSB, Images.statsRectBG, this.leftBoardX + (this.iLastXPos - i) * this.partW + this.SHIP_PADD * 2 + iTranslateX, this.paddingY + this.iLastYPos * this.partW + this.SHIP_PADD * 2 + iTranslateY, this.partW - this.SHIP_PADD * 4, this.partW - this.SHIP_PADD * 4, 1.0f);
                    }
                }
            }
        }
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.25f));
        for (i = 1; i < this.oP1.Map.length; ++i) {
            IMGManager.getIMG(Images.line32Vertical).draw2(oSB, this.leftBoardX + this.partW * i + iTranslateX, this.paddingY + iTranslateY, 1, this.boardHeight);
            IMGManager.getIMG(Images.line32).draw2(oSB, this.leftBoardX + iTranslateX, this.paddingY + this.partW * i + iTranslateY, this.boardHeight, 1);
        }
        for (i = 1; i < this.oP2.Map.length; ++i) {
            IMGManager.getIMG(Images.line32Vertical).draw2(oSB, this.rightBoardX + this.partW * i + iTranslateX, this.paddingY + iTranslateY, 1, this.boardHeight);
            IMGManager.getIMG(Images.line32).draw2(oSB, this.rightBoardX + iTranslateX, this.paddingY + this.partW * i + iTranslateY, this.boardHeight, 1);
        }
        oSB.setColor(Color.WHITE);
        if (this.deployShips) {
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Left-click on your grid to start placing a ship", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 2, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Right-click to change the ship's orientation.", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 3 + CFG.TEXT_HEIGHT_DEFAULT, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Left-click on your grid to confirm deployment.", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT * 2, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Click opponent grid to cancel.", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 5 + CFG.TEXT_HEIGHT_DEFAULT * 3, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Ships cannot be deployed next to each other. ", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 6 + CFG.TEXT_HEIGHT_DEFAULT * 4, CFG.COLOR_NEUTRAL);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "There must be at least one empty grid cell between them.", this.leftBoardX + this.boardHeight + iTranslateX, CFG.PADD * 7 + CFG.TEXT_HEIGHT_DEFAULT * 5, CFG.COLOR_NEUTRAL);
        } else if (!this.GameEnd) {
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "All ships deployed, the battle is on!", CFG.GAMEWIDTH / 2 - this.ingameW / 2 + iTranslateX, this.paddingY / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, CFG.COLOR_NEUTRAL);
        }
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "FPS: over 9000", CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 4 - CFG.TEXT_HEIGHT_DEFAULT * 3, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Ship lengths: " + this.shipsSt, CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - CFG.TEXT_HEIGHT_DEFAULT * 2, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Age of History 2: Definitive Edition", CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - CFG.TEXT_HEIGHT_DEFAULT, CFG.COLOR_NEUTRAL);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.25f));
        IMGManager.getIMG(Images.gameLogo).draw(oSB, CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth(), CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H - IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
    }

    public void startGame() {
        this.deployShips = true;
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void endClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(goBack);
        CFG.menus.setBackAnimation(true);
    }

    public void init() {
        int j;
        int i;
        this.oP1 = new PlayerNV();
        this.oP2 = new PlayerNV();
        for (i = 0; i < this.oP1.Map.length; ++i) {
            for (j = 0; j < this.oP1.Map[i].length; ++j) {
                this.oP1.Map[i][j] = MapBS.WATER;
            }
        }
        for (i = 0; i < this.oP2.Map.length; ++i) {
            for (j = 0; j < this.oP2.Map[i].length; ++j) {
                this.oP2.Map[i][j] = MapBS.WATER;
            }
        }
    }

    public String getOpponentName() {
        switch (this.opponentID) {
            case 0: {
                return "Lukasz Jakowski";
            }
            case 1: {
                return "Napoleon Bonaparte";
            }
            case 2: {
                return "Julius Caesar";
            }
            case 3: {
                return "Alexander the Great";
            }
            case 4: {
                return "Genghis Khan";
            }
            case 5: {
                return "Georgy Zhukov";
            }
            case 6: {
                return "Douglas MacArthur";
            }
            case 7: {
                return "Otto von Bismarck";
            }
        }
        return "Napoleon Bonaparte";
    }

    public void setLastXPos(int iLastXPos) {
        this.iLastXPos = iLastXPos;
    }

    public void setLastYPos(int iLastYPos) {
        this.iLastYPos = iLastYPos;
    }

    public class AI_BS {
        private int AIXPositionToCheck = -1;
        private int AIYPositionToCheck = -1;
        private boolean AIHard = false;
        private int iRandom = 0;
        private int iSinkLEFT = 0;
        private int iSinkRIGHT = 0;
        private int iSinkTOP = 0;
        private int iSinkDOWN;

        public void AIRandom() {
            if (this.AIHard) {
                this.SinkThisShip();
            } else if (CFG.oR.nextInt(2) % 2 == 0) {
                if (Menu_NV.this.iLastXPos - 1 >= 0 && CFG.oR.nextInt(2) == 0) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos - 1);
                } else if (Menu_NV.this.iLastXPos + 1 < Menu_NV.this.getMapSize()) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos + 1);
                } else {
                    this.AIRandom();
                }
            } else if (Menu_NV.this.iLastYPos - 1 >= 0 && CFG.oR.nextInt(2) % 2 == 0) {
                Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos - 1);
            } else if (Menu_NV.this.iLastYPos + 1 < Menu_NV.this.getMapSize()) {
                Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos + 1);
            } else {
                this.AIRandom();
            }
        }

        public boolean CheckNextRandomAIShoot() {
            int iNum = 0;
            if (Menu_NV.this.iLastXPos + 1 < Menu_NV.this.getMapSize()) {
                if (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos + 1][Menu_NV.this.iLastYPos] == MapBS.SHOT) {
                    ++iNum;
                }
            } else {
                ++iNum;
            }
            if (Menu_NV.this.iLastXPos - 1 >= 0) {
                if (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos - 1][Menu_NV.this.iLastYPos] == MapBS.SHOT) {
                    ++iNum;
                }
            } else {
                ++iNum;
            }
            if (Menu_NV.this.iLastYPos + 1 < Menu_NV.this.getMapSize()) {
                if (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos + 1] == MapBS.SHOT) {
                    ++iNum;
                }
            } else {
                ++iNum;
            }
            if (Menu_NV.this.iLastYPos - 1 >= 0) {
                if (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos - 1] == MapBS.SHOT) {
                    ++iNum;
                }
            } else {
                ++iNum;
            }
            return iNum <= 3;
        }

        public void SinkThisShip() {
            boolean bFound = false;
            if (Menu_NV.this.iLastXPos - 1 >= 0 && Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos - 1][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                if (Menu_NV.this.iLastXPos + 1 >= Menu_NV.this.getMapSize() || Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos + 1][Menu_NV.this.iLastYPos] == MapBS.SHOT) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos - 1);
                    while (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                        if (Menu_NV.this.iLastXPos - 1 < 0) continue;
                        Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos - 1);
                    }
                } else if (Menu_NV.this.iLastXPos + 1 < Menu_NV.this.getMapSize()) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos + 1);
                }
                bFound = true;
            }
            if (Menu_NV.this.iLastXPos + 1 < Menu_NV.this.getMapSize() && !bFound && Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos + 1][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                if (Menu_NV.this.iLastXPos - 1 < 0 || Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos - 1][Menu_NV.this.iLastYPos] == MapBS.SHOT) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos + 1);
                    while (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                        if (Menu_NV.this.iLastXPos + 1 < 0) continue;
                        Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos + 1);
                    }
                } else if (Menu_NV.this.iLastXPos - 1 < Menu_NV.this.getMapSize()) {
                    Menu_NV.this.setLastXPos(Menu_NV.this.iLastXPos - 1);
                }
                bFound = true;
            }
            if (Menu_NV.this.iLastYPos - 1 >= 0 && !bFound && Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos - 1] == MapBS.SHIP_DESTROYED) {
                if (Menu_NV.this.iLastYPos + 1 >= Menu_NV.this.getMapSize() || Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos + 1] == MapBS.SHOT) {
                    Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos - 1);
                    while (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                        if (Menu_NV.this.iLastYPos - 1 < 0) continue;
                        Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos - 1);
                    }
                } else if (Menu_NV.this.iLastYPos + 1 < Menu_NV.this.getMapSize()) {
                    Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos + 1);
                }
                bFound = true;
            }
            if (Menu_NV.this.iLastYPos + 1 < Menu_NV.this.getMapSize() && !bFound && Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos + 1] == MapBS.SHIP_DESTROYED) {
                if (Menu_NV.this.iLastYPos - 1 < 0 || Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos - 1] == MapBS.SHOT) {
                    Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos + 1);
                    while (Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP_DESTROYED) {
                        if (Menu_NV.this.iLastYPos + 1 < 0) continue;
                        Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos + 1);
                    }
                } else if (Menu_NV.this.iLastYPos + 1 < Menu_NV.this.getMapSize()) {
                    Menu_NV.this.setLastYPos(Menu_NV.this.iLastYPos - 1);
                }
            }
        }

        public void setRandomShot() {
            Menu_NV.this.setLastXPos(CFG.oR.nextInt(Menu_NV.this.getMapSize()));
            Menu_NV.this.setLastYPos(CFG.oR.nextInt(Menu_NV.this.getMapSize()));
        }

        public void setAINextShoot() {
            if (Menu_NV.this.oP1.getNumOfLostShips() < Menu_NV.this.aiShipsLength.length) {
                this.setRandomShot();
                while (!this.CheckNextRandomAIShoot()) {
                    this.setRandomShot();
                }
                if (this.AIXPositionToCheck >= 0 || this.AIYPositionToCheck >= 0) {
                    Menu_NV.this.setLastXPos(this.AIXPositionToCheck);
                    Menu_NV.this.setLastYPos(this.AIYPositionToCheck);
                    this.AIRandom();
                }
                if (Menu_NV.this.CheckPositionToShoot(2)) {
                    Menu_NV.this.oP2.setNumOfShoots(Menu_NV.this.oP2.getNumOfShoots() + 1);
                    if (Menu_NV.this.oP1.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] == MapBS.SHIP) {
                        Menu_NV.this.oP2.setPlayerLastMessage(Menu_NV.this.iLastXPos + 1 + Menu_NV.this.getPositionY()[Menu_NV.this.iLastYPos]);
                        Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHIP_DESTROYED;
                        Menu_NV.this.oP1.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHIP_DESTROYED;
                        Menu_NV.this.oP2.setNumOfHits(Menu_NV.this.oP2.getNumOfHits() + 1);
                        CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
                        if (Menu_NV.this.CheckShip(2)) {
                            this.ResetAI();
                            Menu_NV.this.oP1.setNumOfLostShips(Menu_NV.this.oP1.getNumOfLostShips() + 1);
                            Menu_NV.this.ShipUnderWater(2, Menu_NV.this.oP2.MapShoots);
                        } else {
                            if (this.AIYPositionToCheck >= 0) {
                                this.AIHard = true;
                            }
                            this.AIXPositionToCheck = Menu_NV.this.iLastXPos;
                            this.AIYPositionToCheck = Menu_NV.this.iLastYPos;
                        }
                        this.setAINextShoot();
                    } else {
                        Menu_NV.this.oP2.MapShoots[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHOT;
                        Menu_NV.this.oP1.Map[Menu_NV.this.iLastXPos][Menu_NV.this.iLastYPos] = MapBS.SHOT;
                        Menu_NV.this.iPlayerTurn = 1;
                    }
                } else {
                    this.setAINextShoot();
                }
            } else {
                Menu_NV.this.GameEnd = true;
            }
        }

        public void ResetAI() {
            this.AIYPositionToCheck = -1;
            this.AIXPositionToCheck = -1;
            this.iSinkLEFT = 0;
            this.iSinkRIGHT = 0;
            this.AIHard = false;
        }
    }

    public class PlayerNV {
        private String sPlayerName = " ";
        private String sPlayerLastMessage = "";
        public MapBS[][] Map = new MapBS[Menu_NV.this.getMapSize()][Menu_NV.this.getMapSize()];
        public MapBS[][] MapShoots = new MapBS[Menu_NV.this.getMapSize()][Menu_NV.this.getMapSize()];
        private int iDeployedShips = 0;
        private int iNumOfLostShips = 0;
        private int iNumOfShoots = 0;
        private int iNumOfHits = 0;

        PlayerNV() {
        }

        public String getPlayerName() {
            return this.sPlayerName;
        }

        public void setPlayerName(String nPlayerName) {
            this.sPlayerName = nPlayerName;
        }

        public int getDeployedShips() {
            return this.iDeployedShips;
        }

        public void setDeployedShips(int nDeployedShips) {
            this.iDeployedShips = nDeployedShips;
        }

        public int getNumOfLostShips() {
            return this.iNumOfLostShips;
        }

        public void setNumOfLostShips(int nNumOfLostShips) {
            this.iNumOfLostShips = nNumOfLostShips;
        }

        public int getNumOfShoots() {
            return this.iNumOfShoots;
        }

        public void setNumOfShoots(int nNumOfShoots) {
            this.iNumOfShoots = nNumOfShoots;
        }

        public int getNumOfHits() {
            return this.iNumOfHits;
        }

        public void setNumOfHits(int nNumOfHits) {
            this.iNumOfHits = nNumOfHits;
        }

        public String getPlayerLastMessage() {
            return this.sPlayerLastMessage;
        }

        public void setPlayerLastMessage(String nMessage) {
            this.sPlayerLastMessage = nMessage;
        }
    }

    public static enum MapBS {
        SHIP,
        SHIP_DESTROYED,
        SHOT,
        WATER;

    }
}

