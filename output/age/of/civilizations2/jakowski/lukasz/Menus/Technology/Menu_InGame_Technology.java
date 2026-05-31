
package age.of.civilizations2.jakowski.lukasz.Menus.Technology;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Icon;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Technology;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_GraphMain;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.SkillsManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear_Adm;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear_Tech;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Technology
extends Menu {
    public int iCivID;
    public long lTime = 0L;

    public Menu_InGame_Technology() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2 + CFG.BUTTON_W * 3 / 4;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 4 / 5;
        this.initMenu(new TitleM(CFG.lang.get("TechnologyPoints"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth * 3 / 8, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public static int getButtonH() {
        return Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6);
    }

    public Menu_InGame_Technology(int nCivID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2 + CFG.BUTTON_W * 3 / 4;
        int tY = 0;
        this.iCivID = nCivID;
        int buttonH = Menu_InGame_Technology.getButtonH();
        menuElements.add(new Button_Technology(nCivID, 2, tY, CFG.BUTTON_W * 2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Technology.this.getElementW() * 2;
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_TECHNOLOGY_MODE, false);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        if (CFG.getIsDesktop()) {
            menuElements.add(new Text_Desc(CFG.lang.get("TechnologyText"), 2, tY, tempWidth - 4){

                @Override
                protected Color getColor(boolean isActive) {
                    return Colors.getColorButtonHover2(isActive, this.getIsHovered());
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Technology.this.getElementW() * 2;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TechnologyPoints"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TechnologyText")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new Button_Icon(Images.topMovementPoints, 0, tY));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f, CFG.lang.get("MovementPoints"), ButtonDiplomacy.iDiploWidth + CFG.PADD, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_MOVEMENT, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_MOVEMENT){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_MOVEMENT, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 2, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_MOVEMENT, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Movement(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MOVEMENT, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MOVEMENT * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_MOVEMENT, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Movement(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MOVEMENT);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.diploStability, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f, CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost"), ButtonDiplomacy.iDiploWidth + CFG.PADD, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_ASSIMILATE){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_PROVINCE_STABILITY_MAX.r, CFG.COLOR_PROVINCE_STABILITY_MAX.g, CFG.COLOR_PROVINCE_STABILITY_MAX.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public String getTextLeft() {
                if (this.getCurr() > 0) {
                    return "" + (float)((int)((float)this.getCurr() * this.fModifier * 100.0f)) / 100.0f + "%";
                }
                return "";
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Flag_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Assimilate(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Flag_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ASSIMILATE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_ASSIMILATE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Assimilate(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ASSIMILATE);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.popGrowth, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_POP_GROWTH, CFG.lang.get("PopulationGrowthModifier"), ButtonDiplomacy.iDiploWidth + CFG.PADD, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_POP_GROWTH){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_POPULATION.r, CFG.COLOR_POPULATION.g, CFG.COLOR_POPULATION.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_POP_GROWTH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_PopGrowth(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_POP_GROWTH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_POP_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_POP_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_PopGrowth(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_POP_GROWTH);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.diploArmy, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f, CFG.lang.get("RecruitablePopulation"), ButtonDiplomacy.iDiploWidth + CFG.PADD, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_RECRUITABLE){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_ARMY_TEXT.r, CFG.COLOR_ARMY_TEXT.g, CFG.COLOR_ARMY_TEXT.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public String getTextLeft() {
                if (this.getCurr() > 0) {
                    return "+" + (float)((int)((float)this.getCurr() * this.fModifier * 100.0f)) / 100.0f + "%";
                }
                return "";
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RecruitablePopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitablePopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RecruitablePopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Recruitable(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitablePopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f, 100) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RecruitablePopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RECRUITABLE * 100.0f * (float)GameValues.gvTechnology.MAX_POINTS_RECRUITABLE, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Recruitable(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RECRUITABLE);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.economy, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH, CFG.lang.get("EconomyGrowthModifier"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_ECONOMY.r, CFG.COLOR_ECONOMY.g, CFG.COLOR_ECONOMY.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_EcoGrowth(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH * (float)GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_EcoGrowth(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.topGold(), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION, CFG.lang.get("IncomeTaxation"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GOLD.r, CFG.COLOR_GOLD.g, CFG.COLOR_GOLD.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_INCOME_TAXATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_IncomeTaxation(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_INCOME_TAXATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_TAXATION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_IncomeTaxation(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_TAXATION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.development, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION, CFG.lang.get("IncomeProduction"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GOLD_ACTIVE.r, CFG.COLOR_GOLD_ACTIVE.g, CFG.COLOR_GOLD_ACTIVE.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_IncomeProduction(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION * (float)GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_IncomeProduction(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.administration, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Adm(GameValues.gvTechnology.PER_POINT_ADMINISTRATION, CFG.lang.get("Administration"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_ACTIVE.r, CFG.COLOR_NEGATIVE_ACTIVE.g, CFG.COLOR_NEGATIVE_ACTIVE.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_ADMINISTRATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Administration(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_ADMINISTRATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_ADMINISTRATION * (float)GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Administration(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_ADMINISTRATION);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.diploArmy, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Adm(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP, CFG.lang.get("MilitaryUpkeep"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_ARMY_TEXT.r, CFG.COLOR_ARMY_TEXT.g, CFG.COLOR_ARMY_TEXT.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_MilitaryUpkeep(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP * (float)GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_MilitaryUpkeep(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.provinces, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Adm(GameValues.gvTechnology.PER_POINT_COLONIZATION, CFG.lang.get("ColonizationCost"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_COLONIZATION, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_COLONIZATION){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)GameValues.gvTechnology.MAX_POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ColonizationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_COLONIZATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)GameValues.gvTechnology.MAX_POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Colonization(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ColonizationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("-" + GameValues.gvTechnology.PER_POINT_COLONIZATION + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_COLONIZATION, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_COLONIZATION * (float)GameValues.gvTechnology.MAX_POINTS_COLONIZATION * -1.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Colonization(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_COLONIZATION);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_Icon(Images.research, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD));
        menuElements.add(new Slider_InGame_Clear_Tech(GameValues.gvTechnology.PER_POINT_RESEARCH, CFG.lang.get("Research"), CFG.PADD + ButtonDiplomacy.iDiploWidth, tY, tempWidth - CFG.PADD * 3 - CFG.BUTTON_W, buttonH, 0, GameValues.gvTechnology.MAX_POINTS_RESEARCH, CFG.core.getCiv((int)this.iCivID).civGD.techPoints.POINTS_RESEARCH){

            @Override
            public int getWidthE() {
                return Math.max(Menu_InGame_Technology.this.getElementW() * 2 - CFG.BUTTON_W * 3 / 4 * 2 - CFG.PADD * 5 - ButtonDiplomacy.iDiploWidth, 0);
            }

            @Override
            public Color getColorLEFT() {
                return new Color(CFG.COLOR_RESEARCH.r, CFG.COLOR_RESEARCH.g, CFG.COLOR_RESEARCH.b, 0.65f);
            }

            @Override
            public void actionElem(int iID) {
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)GameValues.gvTechnology.MAX_POINTS_RESEARCH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction("+", -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() * 2 - CFG.PADD * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_RESEARCH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)GameValues.gvTechnology.MAX_POINTS_RESEARCH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                SkillsManager.add_Research(Menu_InGame_Technology.this.iCivID);
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 1).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_InGameAction("+" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, -1, tempWidth - CFG.BUTTON_W * 3 / 4 - CFG.PADD, tY, CFG.BUTTON_W * 3 / 4, buttonH, this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

            @Override
            public int getPosXE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - this.getWidthE() - CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPoint") + ": +" + GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + GameValues.gvTechnology.PER_POINT_RESEARCH + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" / " + GameValues.gvTechnology.MAX_POINTS_RESEARCH, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH, 100) + "%", CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text(" / " + CFG.getPrecision2(GameValues.gvTechnology.PER_POINT_RESEARCH * (float)GameValues.gvTechnology.MAX_POINTS_RESEARCH, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                for (int a = 0; a < GameValues.gvTechnology.ADD_TECH_POINTS_PER_CLICK; ++a) {
                    SkillsManager.add_Research(Menu_InGame_Technology.this.iCivID);
                }
                Menu_InGame_Technology.this.getMenuElem(0).setMin(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.getPointsLeft(Menu_InGame_Technology.this.iCivID));
                Menu_InGame_Technology.this.getMenuElem(iID - 2).setCurr(CFG.core.getCiv((int)Menu_InGame_Technology.this.iCivID).civGD.techPoints.POINTS_RESEARCH);
                Menu_InGame_Technology.this.rebuildBudgetView();
                Menu_InGame_2.updateOverBudget();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Text_Desc(CFG.lang.get("AttackDefenseDesc"), 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - 4){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButtonHover2(isActive, this.getIsHovered());
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Technology.this.getElementW() * 2;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getTechLevel(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big("/" + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_Technology.this.iCivID, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Attack") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(Menu_InGame_Technology.this.iCivID), 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.attack, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float fEff = CFG.gameUpdate.getAdministrationEfficiency(Menu_InGame_Technology.this.iCivID);
                int nAdmin = (int)((fEff - 0.5f) * 100.0f);
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text((nAdmin >= 0 ? "+" : "") + nAdmin + "%", nAdmin >= 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Defense") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(Menu_InGame_Technology.this.iCivID), 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.defense, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_InGameAction(CFG.lang.get("Close"), -1, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getWidthE() {
                return Menu_InGame_Technology.this.getElementW() * 2 - CFG.PADD * 2;
            }
        });
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("TechnologyPoints"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_Technology.this.iCivID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.425f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.325f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        this.lTime = System.currentTimeMillis();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(this.getMenuElem(i).getCurr());
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)Menu_InGame_Message_Alliance.ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + 4, -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - this.lTime) / (float)Menu_InGame_Message_Alliance.ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            CFG.setRenderO(true);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            this.setVisibleM(false);
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }

    public void rebuildBudgetView() {
        if (CFG.menus.getVisible_InGame_Budget()) {
            CFG.menus.setVisible_InGame_Budget(true);
            Menu_InGame_FA_GraphMain.lTime = 1L;
        } else if (CFG.menus.getVisible_InGame_FlagAction()) {
            CFG.menus.rebuildInGame_FlagActionLeft();
        } else {
            CFG.gameUpdate.getBalance_UpdateBudgetPrepare(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
        CFG.menus.setOrderOfTechPoints();
    }
}

