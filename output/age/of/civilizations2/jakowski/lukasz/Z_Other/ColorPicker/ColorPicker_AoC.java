/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_InGame_Alliance;
import age.of.civilizations2.jakowski.lukasz.Pallet_Manager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC_Action;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class ColorPicker_AoC {
    private int iPosX = 150;
    private int iPosY = 150;
    private boolean visible = false;
    private int iSVHeight;
    private int iHUEWidth;
    private int iResizeHeight;
    private boolean activeHUE = false;
    private boolean activeSV = false;
    private boolean activeResize = false;
    private boolean activeMove = false;
    private boolean activeClose = false;
    public static int activeRGB = -1;
    private int iActiveColorID = -1;
    private float fAlpha = 1.0f;
    private int iStartPosX;
    private int iStartPosY;
    private int iStartResizeHeight;
    private Color colorSVPos = Color.WHITE;
    private int iLastSVPosX;
    private int iLastSVPosY;
    private int iLastHUEPosY;
    private final float RGB_TEXT_SCALE = 0.9f;
    private int iRGBTextWidth;
    private int iRTextWidth;
    private int iGTextWidth;
    private int iBTextWidth;
    private List<Box> lRGBBoxes = new ArrayList<Box>();
    private List<Box> lColorsBoxes = new ArrayList<Box>();
    private List<Color> lColors = new ArrayList<Color>();
    public ColorPicker_AoC_Action ColorPicker_AoC_Action;
    private Color hueColor = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    private Color activeColor = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    private float[] hsv = new float[]{0.0f, 1.0f, 1.0f};
    private float hueVal = 1.0f;

    public final void updateColorPicker_Action(PickerAction nAction) {
        switch (nAction) {
            case ACTIVE_CIVILIZATION_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r * 255.0f));
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g * 255.0f));
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b * 255.0f));
                    }

                    @Override
                    public void setActiveProvince_Action() {
                        try {
                            if (CFG.menus.getIn_InitMenu() || CFG.menus.getIn_SaveTheGame()) {
                                return;
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        CFG.menus.getColorPicker().setActiveRGBColor(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getR(), CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getG(), CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getB());
                        CFG.menus.getColorPicker().updateColors();
                    }
                };
                break;
            }
            case ACTIVE_ALLIANCE_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        try {
                            CFG.core.getAlliance(Menu_InGame_Alliance.ALLIANCE_ID).getColorOfAlliance().setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                            CFG.core.getAlliance(Menu_InGame_Alliance.ALLIANCE_ID).getColorOfAlliance().setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                            CFG.core.getAlliance(Menu_InGame_Alliance.ALLIANCE_ID).getColorOfAlliance().setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case CREATE_VASSAL_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.createVassalData.oColor = new Color(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b, 1.0f);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case CUSTOMIZE_ALLIANCE_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).setColorOfAlliance(new Color_GameData(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b));
                    }

                    @Override
                    public void setActiveProvince_Action() {
                        if (ColorPicker_AoC.this.getVisible() && CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance() != CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getAlliance();
                            CFG.menus.getColorPicker().setActiveRGBColor(CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getColorOfAlliance().getB());
                        }
                    }
                };
                break;
            }
            case MAP_EDITOR_CONTINENT_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editor_Continent_GameData.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.editor_Continent_GameData.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.editor_Continent_GameData.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case MAP_EDITOR_REGION_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editor_Region_GameData.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.editor_Region_GameData.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.editor_Region_GameData.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case PALLET_OF_COLORS: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setR((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r * 255.0f));
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setG((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g * 255.0f));
                        CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setB((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b * 255.0f));
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                            CFG.editorPalletOfCivsColors_Data.setCivColor(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag(), new Color_GameData(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b));
                        }
                    }

                    @Override
                    public void setActiveProvince_Action() {
                        CFG.menus.getColorPicker().setActiveRGBColor(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getR(), CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getG(), CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getB());
                        CFG.menus.getColorPicker().updateColors();
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_OWN_PROVINCES: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_ALLIANCE: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_AT_WAR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_VASSAL: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_PACT: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_PACT_MAX: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_INDEPENDENCE: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_MILITARY_ACCESS: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_DEFENSIVE_PACT: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_NEUTRAL: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case PB_STRA: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.borderStraight.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.borderStraight.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.borderStraight.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                        CFG.COLOR_PROVINCE_STRAIGHT = new Color(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b, CFG.COLOR_PROVINCE_STRAIGHT.a);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case PB_DASH: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.borderDashed.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.borderDashed.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.borderDashed.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                        CFG.COLOR_PROVINCE_DASHED = new Color(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b, CFG.COLOR_PROVINCE_DASHED.a);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case CIV_NAMES_OVER_PROVINCES: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.civNamesFontColor.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.civNamesFontColor.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.civNamesFontColor.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                        CFG.loadFontBorder();
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case CIV_NAMES_OVER_PROVINCES_BORDER: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.civNamesFontColorBorder.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.civNamesFontColorBorder.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.civNamesFontColorBorder.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                        CFG.loadFontBorder();
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case PROVINCE_SETTINGS_WASTELAND_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.COLOR_PROVINCE_BG_WASTELAND.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case PROVINCE_SETTINGS_DISCOVERY_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_NEGATIVE: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case COLOR_DIPLOMACY_POSITIVE: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID].setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_TERRAIN_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editorTerrain_Data2.setColor(new Color_GameData(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b));
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_SERVICE_RIBBON_OVERLAY: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editorServiceRibbon_Colors.set(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, new Color(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g, ((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b, 1.0f));
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_CIV_GAME_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editorCivilization_GameData.setR((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r * 255.0f));
                        CFG.editorCivilization_GameData.setG((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g * 255.0f));
                        CFG.editorCivilization_GameData.setB((int)(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b * 255.0f));
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_CIV_GAME_COLOR_SR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.editorCivilization_GameData.sr_GameData.getColor(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_CIV_FLAG_DIVISION_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            case EDITOR_CIV_FLAG_OVERLAY_COLOR: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                        CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.setR(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.r);
                        CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.setG(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.g);
                        CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.setB(((ColorPicker_AoC)ColorPicker_AoC.this).activeColor.b);
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
                break;
            }
            default: {
                this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                    @Override
                    public void update() {
                    }

                    @Override
                    public void setActiveProvince_Action() {
                    }
                };
            }
        }
    }

    public ColorPicker_AoC() {
        CFG.glyphLay.setText(CFG.fontMain.get(0), "G 255");
        this.iRGBTextWidth = (int)CFG.glyphLay.width;
        this.updateRGBWidth();
        this.lRGBBoxes.add(new Box(CFG.PADD, IMGManager.getIMG(Images.btnClose).getHeight() + IMGManager.getIMG(Images.btnClose).getHeight() / 2, this.iRGBTextWidth + CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2));
        this.lRGBBoxes.add(new Box(CFG.PADD, IMGManager.getIMG(Images.btnClose).getHeight() + IMGManager.getIMG(Images.btnClose).getHeight() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, this.iRGBTextWidth + CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2));
        this.lRGBBoxes.add(new Box(CFG.PADD, IMGManager.getIMG(Images.btnClose).getHeight() + IMGManager.getIMG(Images.btnClose).getHeight() / 2 + CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2, this.iRGBTextWidth + CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2));
        this.updateColorPicker_Action(PickerAction.ACTIVE_CIVILIZATION_COLOR);
    }

    public final void buildColors() {
        this.lColorsBoxes.add(new Box(0, CFG.PADD, this.getColorBoxWidth(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2));
        this.lColors.add(new Color(this.activeColor.r, this.activeColor.g, this.activeColor.b, 1.0f));
        for (int i = this.lColorsBoxes.get(0).getPosX() + this.lColorsBoxes.get(0).getWidth(); i < CFG.GAMEWIDTH; i += this.getColorBoxWidth()) {
            this.lColorsBoxes.add(new Box(i, CFG.PADD, this.getColorBoxWidth(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2));
            this.addColor(CFG.oR.nextInt(Pallet_Manager.NUM_OF_COLORS));
        }
    }

    public final void updateColors() {
        try {
            this.lColors.set(0, new Color(this.activeColor.r, this.activeColor.g, this.activeColor.b, 1.0f));
            for (int i = 1; i < this.lColors.size(); ++i) {
                this.lColors.set(i, new Color((float)CFG.oR.nextInt(256) / 255.0f, (float)CFG.oR.nextInt(256) / 255.0f, (float)CFG.oR.nextInt(256) / 255.0f, 1.0f));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void draw(SpriteBatch oSB, int iTranslateX) {
        oSB.setColor(1.0f, 1.0f, 1.0f, this.fAlpha);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.iPosX - CFG.PADD * 2 + iTranslateX, this.iPosY - CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), this.getWidth() + CFG.PADD * 4 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeight() + CFG.PADD * 4 - IMGManager.getIMG(Images.gameTopEdge).getHeight());
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.iPosX + this.getWidth() + CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.iPosY - CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeight() + CFG.PADD * 4 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.iPosX - CFG.PADD * 2 + iTranslateX, this.iPosY + this.getHeight() + CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2, this.getWidth() + CFG.PADD * 4 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), false, true);
        IMGManager.getIMG(Images.gameTopEdge).drawO(oSB, this.iPosX + this.getWidth() + CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.iPosY + this.getHeight() + CFG.PADD * 2 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), true, true);
        IMGManager.getIMG(Images.pickerHUE).drawO(oSB, this.iPosX + this.iSVHeight + CFG.PADD + iTranslateX, this.iPosY - IMGManager.getIMG(Images.pickerHUE).getHeight(), this.iHUEWidth, this.iSVHeight);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.iPosX + iTranslateX, this.iPosY - IMGManager.getIMG(Images.pix255).getHeight(), this.iSVHeight, this.iSVHeight);
        oSB.setColor(this.hueColor);
        IMGManager.getIMG(Images.pickerSV).drawO(oSB, this.iPosX + iTranslateX, this.iPosY - IMGManager.getIMG(Images.pickerSV).getHeight(), this.iSVHeight, this.iSVHeight);
        if (!this.activeResize) {
            block6: {
                Rectangle clipBounds = new Rectangle(this.iPosX + iTranslateX, CFG.GAMEHEIGHT - this.iPosY, this.iSVHeight, -this.iSVHeight);
                oSB.flush();
                ScissorStack.pushScissors(clipBounds);
                oSB.setColor(this.colorSVPos);
                IMGManager.getIMG(Images.pickerSVPos).drawO(oSB, this.iPosX + this.iLastSVPosX - IMGManager.getIMG(Images.pickerSVPos).getWidth() / 2 + iTranslateX, this.iPosY + this.iLastSVPosY - IMGManager.getIMG(Images.pickerSVPos).getHeight() / 2);
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException ex) {
                    if (!CFG.LOGs) break block6;
                    CFG.exceptionStack(ex);
                }
            }
            oSB.setColor(0.0f, 0.0f, 0.0f, this.fAlpha);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.iPosX + this.iSVHeight + CFG.PADD + CFG.PADD + iTranslateX, this.iPosY + this.iLastHUEPosY - 1, this.iHUEWidth - CFG.PADD * 2 + 1, 1);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.pickerEdge).drawO(oSB, this.iPosX + this.iSVHeight - IMGManager.getIMG(Images.pickerEdge).getWidth() + iTranslateX, this.iPosY + this.iSVHeight - IMGManager.getIMG(Images.pickerEdge).getHeight() - 1);
        }
        if (this.activeMove) {
            oSB.setColor(Color.BLACK);
            IMGManager.getIMG(Images.pickerEdge).drawO(oSB, this.iPosX + 1 + iTranslateX, this.iPosY + 1, true, true);
        }
        oSB.setColor(Color.BLACK);
        CFG.drawRect(oSB, this.iPosX + iTranslateX, this.iPosY - 1, this.iSVHeight, this.iSVHeight);
        CFG.drawRect(oSB, this.iPosX + CFG.PADD + this.iSVHeight + iTranslateX, this.iPosY - 1, this.iHUEWidth, this.iSVHeight);
        this.drawRGBText(oSB, 0, this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + this.lRGBBoxes.get(0).getPosX() + iTranslateX, this.iPosY + this.lRGBBoxes.get(0).getPosY(), this.lRGBBoxes.get(0).getWidth(), this.lRGBBoxes.get(0).getHeight(), "R", "" + (int)(this.activeColor.r * 255.0f), this.iRTextWidth);
        this.drawRGBText(oSB, 1, this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + this.lRGBBoxes.get(1).getPosX() + iTranslateX, this.iPosY + this.lRGBBoxes.get(1).getPosY(), this.lRGBBoxes.get(1).getWidth(), this.lRGBBoxes.get(1).getHeight(), "G", "" + (int)(this.activeColor.g * 255.0f), this.iGTextWidth);
        this.drawRGBText(oSB, 2, this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + this.lRGBBoxes.get(2).getPosX() + iTranslateX, this.iPosY + this.lRGBBoxes.get(2).getPosY(), this.lRGBBoxes.get(2).getWidth(), this.lRGBBoxes.get(2).getHeight(), "B", "" + (int)(this.activeColor.b * 255.0f), this.iBTextWidth);
        this.drawColors(oSB, this.iPosX + iTranslateX, this.iPosY + this.iSVHeight);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.iPosX + this.lColorsBoxes.get(0).getPosX() + iTranslateX, this.iPosY + this.iSVHeight + this.lColorsBoxes.get(0).getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidth(), this.lColorsBoxes.get(this.lColorsBoxes.size() - 1).getHeight(), false, true);
        if (this.iActiveColorID >= 0) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.iPosX + this.lColorsBoxes.get(this.iActiveColorID).getPosX() + iTranslateX, this.iPosY + this.iSVHeight + this.lColorsBoxes.get(0).getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), this.lColorsBoxes.get(this.iActiveColorID).getWidth(), this.lColorsBoxes.get(this.lColorsBoxes.size() - 1).getHeight());
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, this.fAlpha));
        CFG.drawRect(oSB, this.iPosX + this.lColorsBoxes.get(0).getPosX() + iTranslateX, this.iPosY + this.iSVHeight + this.lColorsBoxes.get(0).getPosY(), this.getWidth(), this.lColorsBoxes.get(this.lColorsBoxes.size() - 1).getHeight());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.activeClose ? Images.btnhClose : Images.btnClose).drawO(oSB, this.getPosX() + this.getWidth() - IMGManager.getIMG(Images.btnClose).getWidth() + iTranslateX, this.getPosY());
    }

    public final void drawRGBText(SpriteBatch oSB, int boxID, int nPosX, int nPosY, int nWidth, int nHeight, String sLeft, String sRight, int nRightWidth) {
        oSB.setColor(CFG.COLOR_COLOR_PICKER_RGB_BG);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY, nWidth, nHeight);
        if (activeRGB == boxID || Keyboard.activeColor_RGB_ID == boxID) {
            oSB.setColor(CFG.COLOR_LOADING_SPLIT_ACTIVE);
        } else {
            oSB.setColor(CFG.COLOR_LOADING_SPLIT);
        }
        CFG.drawRect(oSB, nPosX, nPosY, nWidth, nHeight);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        CFG.drawRect(oSB, nPosX - 1, nPosY - 1, nWidth + 2, nHeight + 2);
        oSB.setColor(Color.WHITE);
        CFG.drawTextDefault(oSB, sLeft, nPosX + CFG.PADD, nPosY + nHeight / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(0.84f, 0.84f, 0.88f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(0.9f);
        CFG.drawTextDefault(oSB, sRight, nPosX + nWidth - CFG.PADD - (int)((float)nRightWidth * 0.9f), nPosY + nHeight / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, CFG.COLOR_TEXT_RANK);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    public final void drawColors(SpriteBatch oSB, int nPosX, int nPosY) {
        for (int i = this.lColorsBoxes.size() - 1; i >= 0; --i) {
            if (!this.lColorsBoxes.get(i).getVisible()) continue;
            oSB.setColor(this.lColors.get((int)i).r, this.lColors.get((int)i).g, this.lColors.get((int)i).b, this.fAlpha);
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + this.lColorsBoxes.get(i).getPosX(), nPosY + this.lColorsBoxes.get(i).getPosY(), this.lColorsBoxes.get(i).getWidth(), this.lColorsBoxes.get(i).getHeight());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + this.lColorsBoxes.get(i).getPosX() + this.lColorsBoxes.get(i).getWidth(), nPosY + this.lColorsBoxes.get(i).getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), 1, this.lColorsBoxes.get(i).getHeight());
        }
    }

    public final void touchUp() {
        if (this.activeResize) {
            this.iLastSVPosX = (int)((float)(this.iLastSVPosX * this.iSVHeight) / (float)this.iStartResizeHeight);
            this.iLastSVPosY = (int)((float)(this.iLastSVPosY * this.iSVHeight) / (float)this.iStartResizeHeight);
            this.iLastHUEPosY = (int)((float)(this.iLastHUEPosY * this.iSVHeight) / (float)this.iStartResizeHeight);
        } else if (this.activeClose && this.iLastSVPosX >= this.getPosX() + this.getWidth() - IMGManager.getIMG(Images.btnClose).getWidth() && this.iLastSVPosX <= this.getPosX() + this.getWidth() && this.iLastSVPosY >= this.iPosY && this.iLastSVPosY <= this.iPosY + IMGManager.getIMG(Images.btnClose).getHeight()) {
            this.setVisible(false, null);
        }
        this.activeSV = false;
        this.activeHUE = false;
        this.activeResize = false;
        this.activeMove = false;
        this.activeClose = false;
        this.iActiveColorID = -1;
        if (activeRGB >= 0) {
            Keyboard.activeColor_RGB_ID = activeRGB;
            CFG.showKeyboard_ColorPickerRGB(activeRGB == 0 ? "R: " + (int)(this.activeColor.r * 255.0f) : (activeRGB == 1 ? "G: " + (int)(this.activeColor.g * 255.0f) : "B: " + (int)(this.activeColor.b * 255.0f)));
            activeRGB = -1;
        }
        this.fAlpha = 1.0f;
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public final void touch(int screenX, int screenY) {
        if (this.activeHUE) {
            if (screenY <= this.iPosY) {
                screenY = this.iPosY + 1;
            } else if (screenY > this.iPosY + this.iSVHeight) {
                screenY = this.iPosY + this.iSVHeight;
            }
            if (screenX < this.iPosX + this.iSVHeight + CFG.PADD) {
                screenX = this.iPosX + this.iSVHeight + CFG.PADD;
            } else if (screenX > this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth) {
                screenX = this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth;
            }
            this.updateHUE(screenY);
            this.updateSV(this.iPosX + this.iLastSVPosX, this.iPosY + this.iLastSVPosY);
        } else if (this.activeSV) {
            if (screenY < this.iPosY) {
                screenY = this.iPosY;
            } else if (screenY > this.iPosY + this.iSVHeight) {
                screenY = this.iPosY + this.iSVHeight;
            }
            if (screenX < this.iPosX) {
                screenX = this.iPosX;
            } else if (screenX > this.iPosX + this.iSVHeight) {
                screenX = this.iPosX + this.iSVHeight;
            }
            this.updateSV(screenX, screenY);
            this.iLastSVPosX = screenX - this.iPosX;
            this.iLastSVPosY = screenY - this.iPosY;
        } else {
            if (this.activeResize) {
                this.setSVHeight(screenY - this.iPosY - this.iStartPosY);
                return;
            }
            if (this.activeMove) {
                this.setPosX(screenX - this.iStartPosX);
                this.setPosY(screenY - this.iStartPosY);
                this.fAlpha = 0.75f;
                return;
            }
            if (this.iActiveColorID >= 0) {
                for (int i = 0; i < this.lColorsBoxes.size(); ++i) {
                    if (!this.lColorsBoxes.get(i).getVisible() || screenX < this.iPosX + this.lColorsBoxes.get(i).getPosX() || screenX > this.iPosX + this.lColorsBoxes.get(i).getPosX() + this.lColorsBoxes.get(i).getWidth()) continue;
                    this.iActiveColorID = i;
                    if ((int)(this.activeColor.r * 255.0f) != (int)(this.lColors.get((int)i).r * 255.0f) && (int)(this.activeColor.r * 255.0f) != (int)(this.lColors.get((int)i).g * 255.0f) && (int)(this.activeColor.r * 255.0f) != (int)(this.lColors.get((int)i).b * 255.0f)) {
                        this.RGBtoHSV((int)(this.lColors.get((int)i).r * 255.0f), (int)(this.lColors.get((int)i).g * 255.0f), (int)(this.lColors.get((int)i).b * 255.0f));
                    }
                    break;
                }
            } else if (activeRGB >= 0) {
                this.setActiveRGB_Box(screenX, screenY);
            } else if (this.activeClose) {
                this.iLastSVPosX = screenX;
                this.iLastSVPosY = screenY;
            } else {
                if (screenX >= this.iPosX + this.iSVHeight - this.iResizeHeight && screenX <= this.iPosX + this.iSVHeight && screenY >= this.iPosY + this.iSVHeight - this.iResizeHeight && screenY <= this.iPosY + this.iSVHeight) {
                    this.activeResize = true;
                    this.iStartPosY = screenY - this.iPosY - this.iSVHeight;
                    this.iStartResizeHeight = this.iSVHeight;
                    this.fAlpha = 0.75f;
                    return;
                }
                if (screenX >= this.iPosX && screenX <= this.iPosX + this.iResizeHeight && screenY >= this.iPosY && screenY <= this.iPosY + this.iResizeHeight) {
                    this.activeMove = true;
                    this.iStartPosX = screenX - this.iPosX;
                    this.iStartPosY = screenY - this.iPosY;
                    return;
                }
                if (screenX >= this.iPosX + this.iSVHeight + CFG.PADD && screenX <= this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth && screenY >= this.iPosY && screenY <= this.iPosY + this.iSVHeight) {
                    this.updateHUE(screenY);
                    this.updateSV(this.iPosX + this.iLastSVPosX, this.iPosY + this.iLastSVPosY);
                    this.activeHUE = true;
                    Keyboard.activeColor_RGB_ID = -1;
                    CFG.menus.getKeyboard().setVisibleM(false);
                } else if (screenX >= this.iPosX && screenX <= this.iPosX + this.iSVHeight && screenY >= this.iPosY && screenY <= this.iPosY + this.iSVHeight) {
                    this.updateSV(screenX, screenY);
                    this.activeSV = true;
                    this.iLastSVPosX = screenX - this.iPosX;
                    this.iLastSVPosY = screenY - this.iPosY;
                    Keyboard.activeColor_RGB_ID = -1;
                    CFG.menus.getKeyboard().setVisibleM(false);
                } else if (screenX >= this.iPosX + this.lColorsBoxes.get(0).getPosX() && screenX <= this.iPosX + this.getWidth() && screenY >= this.iPosY + this.iSVHeight + this.lColorsBoxes.get(0).getPosY() && screenY <= this.iPosY + this.iSVHeight + this.lColorsBoxes.get(0).getPosY() + this.lColorsBoxes.get(0).getHeight()) {
                    for (int i = 0; i < this.lColorsBoxes.size(); ++i) {
                        if (!this.lColorsBoxes.get(i).getVisible() || screenX < this.iPosX + this.lColorsBoxes.get(i).getPosX() || screenX > this.iPosX + this.lColorsBoxes.get(i).getPosX() + this.lColorsBoxes.get(i).getWidth() || screenY < this.iPosY + this.iSVHeight + this.lColorsBoxes.get(i).getPosY() || screenY > this.iPosY + this.iSVHeight + this.lColorsBoxes.get(i).getPosY() + this.lColorsBoxes.get(i).getHeight()) continue;
                        this.iActiveColorID = i;
                        if ((int)(this.activeColor.r * 255.0f) == (int)(this.lColors.get((int)i).r * 255.0f) || (int)(this.activeColor.r * 255.0f) == (int)(this.lColors.get((int)i).g * 255.0f) || (int)(this.activeColor.r * 255.0f) == (int)(this.lColors.get((int)i).b * 255.0f)) break;
                        this.RGBtoHSV((int)(this.lColors.get((int)i).r * 255.0f), (int)(this.lColors.get((int)i).g * 255.0f), (int)(this.lColors.get((int)i).b * 255.0f));
                        break;
                    }
                    Keyboard.activeColor_RGB_ID = -1;
                    CFG.menus.getKeyboard().setVisibleM(false);
                } else if (screenX >= this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + CFG.PADD + this.lRGBBoxes.get(0).getPosX() && screenX <= this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + CFG.PADD + this.lRGBBoxes.get(0).getPosX() + this.lRGBBoxes.get(0).getWidth() && screenY >= this.iPosY + this.lRGBBoxes.get(0).getPosY() && screenY <= this.iPosY + this.lRGBBoxes.get(2).getPosY() + this.lRGBBoxes.get(2).getHeight()) {
                    activeRGB = 0;
                    this.setActiveRGB_Box(screenX, screenY);
                    Keyboard.activeColor_RGB_ID = -1;
                    CFG.menus.getKeyboard().setVisibleM(false);
                } else if (screenX >= this.getPosX() + this.getWidth() - IMGManager.getIMG(Images.btnClose).getWidth() && screenX <= this.getPosX() + this.getWidth() && screenY >= this.iPosY && screenY <= this.iPosY + IMGManager.getIMG(Images.btnClose).getHeight()) {
                    this.activeClose = true;
                }
            }
        }
        this.ColorPicker_AoC_Action.update();
    }

    private final void setActiveRGB_Box(int screenX, int screenY) {
        for (int i = 0; i < this.lRGBBoxes.size(); ++i) {
            if (screenX < this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + CFG.PADD + this.lRGBBoxes.get(i).getPosX() || screenX > this.iPosX + this.iSVHeight + CFG.PADD + this.iHUEWidth + CFG.PADD + this.lRGBBoxes.get(i).getPosX() + this.lRGBBoxes.get(i).getWidth() || screenY < this.iPosY + this.lRGBBoxes.get(i).getPosY() || screenY > this.iPosY + this.lRGBBoxes.get(i).getPosY() + this.lRGBBoxes.get(i).getHeight()) continue;
            activeRGB = i;
            break;
        }
    }

    private final void updateHUE(int screenY) {
        float perc = 1.0f - (float)(screenY - this.iPosY) / (float)this.iSVHeight;
        this.hsv[0] = this.hueVal = perc * 360.0f;
        this.hsv[2] = 1.0f;
        this.hsv[1] = 1.0f;
        this.HSVtoRGB(this.hsv, this.hueColor);
        this.updateSV(this.iLastSVPosX, this.iLastSVPosY);
        this.iLastHUEPosY = screenY - this.iPosY;
    }

    private final void updateSV(int screenX, int screenY) {
        float sat = (float)(screenX - this.iPosX) / (float)this.iSVHeight;
        float val = 1.0f - (float)(screenY - this.iPosY) / (float)this.iSVHeight;
        this.hsv[0] = this.hueVal;
        this.hsv[1] = sat;
        this.hsv[2] = val;
        this.updateColorSVPos(screenY - this.iPosY);
        this.HSVtoRGB(this.hsv, this.activeColor);
        this.updateRGBWidth();
    }

    private final void updateColorSVPos(int nPosY) {
        this.colorSVPos = (float)this.iSVHeight * 0.1f > (float)nPosY ? Color.BLACK : Color.WHITE;
    }

    public final void setActiveRGBColor(float R, float G, float B2) {
        this.setActiveRGBColor((int)(R * 255.0f), (int)(G * 255.0f), (int)(B2 * 255.0f));
    }

    public final void setActiveRGBColor(int R, int G, int B2) {
        if (CFG.menus.getKeyboard().getVisibleM() || Keyboard.activeColor_RGB_ID >= 0) {
            Keyboard.activeColor_RGB_ID = -1;
            CFG.menus.getKeyboard().setVisibleM(false);
        }
        this.RGBtoHSV(R, G, B2);
    }

    public final void RGBtoHSV(int R, int G, int B2) {
        float val;
        float x = Math.min(Math.min(R, G), B2);
        if (x == (val = (float)Math.max(Math.max(R, G), B2))) {
            this.hsv[0] = 0.0f;
            this.hsv[1] = 0.0f;
        } else {
            float f = 0.0f;
            if (R == (int)x) {
                f = (float)(G - B2);
            } else if (G == (int)x) {
                f = (float)(B2 - R);
            } else {
                f = (float)(R - G);
            }
            float i = R == (int)x ? 3.0f : (float)(G == (int)x ? 5 : 1);
            this.hsv[0] = (i - f / (val - x)) * 60.0f % 360.0f;
            this.hsv[1] = (val - x) / val;
        }
        this.hsv[2] = val / 255.0f;
        this.hueVal = this.hsv[0];
        this.iLastSVPosX = (int)(this.hsv[1] * (float)this.iSVHeight);
        this.iLastSVPosY = (int)(-this.hsv[2] * (float)this.iSVHeight + (float)this.iSVHeight);
        this.iLastHUEPosY = (int)((float)this.iSVHeight - this.hsv[0] / 360.0f * (float)this.iSVHeight);
        this.updateSV(this.iPosY + this.iLastSVPosX, this.iPosY + this.iLastSVPosY);
        this.updateHUE(this.iPosY + this.iLastHUEPosY);
        this.activeColor.r = (float)R / 255.0f;
        this.activeColor.g = (float)G / 255.0f;
        this.activeColor.b = (float)B2 / 255.0f;
        this.updateRGBWidth();
    }

    private final void HSVtoRGB(float[] hsv, Color rgbOut) {
        float r;
        float g;
        float b;
        float h = hsv[0];
        float s = hsv[1];
        float v = hsv[2];
        if (s == 0.0f) {
            g = b = v;
            r = b;
        } else {
            int i = (int)(h /= 60.0f);
            float f = h - (float)i;
            float p = v * (1.0f - s);
            float q = v * (1.0f - s * f);
            float t = v * (1.0f - s * (1.0f - f));
            switch (i) {
                case 0: {
                    r = v;
                    g = t;
                    b = p;
                    break;
                }
                case 1: {
                    r = q;
                    g = v;
                    b = p;
                    break;
                }
                case 2: {
                    r = p;
                    g = v;
                    b = t;
                    break;
                }
                case 3: {
                    r = p;
                    g = q;
                    b = v;
                    break;
                }
                case 4: {
                    r = t;
                    g = p;
                    b = v;
                    break;
                }
                default: {
                    r = v;
                    g = p;
                    b = q;
                }
            }
        }
        rgbOut.r = r;
        rgbOut.g = g;
        rgbOut.b = b;
        rgbOut.a = 1.0f;
    }

    public final void updateRGBWidth() {
        CFG.glyphLay.setText(CFG.fontMain.get(0), "" + (int)(this.activeColor.r * 255.0f));
        this.iRTextWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "" + (int)(this.activeColor.g * 255.0f));
        this.iGTextWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), "" + (int)(this.activeColor.b * 255.0f));
        this.iBTextWidth = (int)CFG.glyphLay.width;
    }

    public final void setPosX(int iPosX) {
        if (iPosX > CFG.GAMEWIDTH - IMGManager.getIMG(Images.pickerSV).getHeight() / 2) {
            iPosX = CFG.GAMEWIDTH - IMGManager.getIMG(Images.pickerSV).getHeight() / 2;
        } else if (iPosX < CFG.PADD * 2) {
            iPosX = CFG.PADD * 2;
        }
        this.iPosX = iPosX;
    }

    public final int getPosX() {
        return this.iPosX;
    }

    public final void setPosY(int iPosY) {
        if (iPosY > CFG.GAMEHEIGHT - IMGManager.getIMG(Images.pickerSV).getHeight() / 2) {
            iPosY = CFG.GAMEHEIGHT - IMGManager.getIMG(Images.pickerSV).getHeight() / 2;
        } else if (iPosY < CFG.PADD * 2) {
            iPosY = CFG.PADD * 2;
        }
        this.iPosY = iPosY;
    }

    public final int getPosY() {
        return this.iPosY;
    }

    public final int getWidth() {
        return this.iSVHeight + this.iHUEWidth + CFG.PADD + this.iRGBTextWidth + CFG.PADD * 3;
    }

    public final int getHeight() {
        return this.iSVHeight + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3;
    }

    public final Color getActiveColor() {
        return this.activeColor;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean visible, PickerAction nAction) {
        if (nAction != null) {
            this.updateColorPicker_Action(nAction);
        } else {
            this.ColorPicker_AoC_Action = new ColorPicker_AoC_Action(){

                @Override
                public void update() {
                }

                @Override
                public void setActiveProvince_Action() {
                }
            };
        }
        this.visible = visible;
        if (!visible && CFG.menus.getKeyboard().getVisibleM()) {
            Keyboard.activeColor_RGB_ID = -1;
            CFG.menus.getKeyboard().setVisibleM(false);
        }
    }

    public ColorPicker_AoC_Action getColorPickerAction() {
        return this.ColorPicker_AoC_Action;
    }

    public final void setHueWidth(int iHUEWidth) {
        this.iHUEWidth = iHUEWidth;
    }

    public final void setSVHeight(int iSVHeight) {
        int i;
        if (iSVHeight < IMGManager.getIMG(Images.pickerSV).getHeight()) {
            iSVHeight = IMGManager.getIMG(Images.pickerSV).getHeight();
        } else if (this.getPosY() + iSVHeight + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 5 > CFG.GAMEHEIGHT) {
            iSVHeight = CFG.GAMEHEIGHT - this.getPosY() - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 5);
        }
        this.iSVHeight = iSVHeight;
        for (i = 1; i < this.lColorsBoxes.size(); ++i) {
            this.lColorsBoxes.get(i).setWidth(this.lColorsBoxes.get(0).getWidth());
            this.lColorsBoxes.get(i).setVisible(true);
        }
        for (i = this.lColorsBoxes.size() - 1; i > 0; --i) {
            if (this.lColorsBoxes.get(i).getPosX() > this.getWidth()) {
                this.lColorsBoxes.get(i).setVisible(false);
                continue;
            }
            this.lColorsBoxes.get(i).setVisible(true);
            if (this.lColorsBoxes.get(i).getPosX() + this.lColorsBoxes.get(i).getWidth() <= this.getWidth()) continue;
            this.lColorsBoxes.get(i).setWidth(this.getWidth() - this.lColorsBoxes.get(i).getPosX());
        }
    }

    public final int getColorBoxWidth() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
    }

    public final void addColor(int nID) {
        this.lColors.add(new Color((float)CFG.oR.nextInt(256) / 255.0f, (float)CFG.oR.nextInt(256) / 255.0f, (float)CFG.oR.nextInt(256) / 255.0f, 1.0f));
    }

    public final void setResizeHeight(int iResizeHeight) {
        this.iResizeHeight = iResizeHeight;
    }

    public static enum PickerAction {
        ACTIVE_CIVILIZATION_COLOR,
        CUSTOMIZE_ALLIANCE_COLOR,
        MAP_EDITOR_CONTINENT_COLOR,
        MAP_EDITOR_REGION_COLOR,
        CREATE_VASSAL_COLOR,
        ACTIVE_ALLIANCE_COLOR,
        COLOR_DIPLOMACY_OWN_PROVINCES,
        COLOR_DIPLOMACY_ALLIANCE,
        COLOR_DIPLOMACY_AT_WAR,
        COLOR_DIPLOMACY_VASSAL,
        COLOR_DIPLOMACY_PACT,
        COLOR_DIPLOMACY_PACT_MAX,
        COLOR_DIPLOMACY_INDEPENDENCE,
        COLOR_DIPLOMACY_NEGATIVE,
        COLOR_DIPLOMACY_POSITIVE,
        COLOR_DIPLOMACY_NEUTRAL,
        COLOR_DIPLOMACY_MILITARY_ACCESS,
        COLOR_DIPLOMACY_DEFENSIVE_PACT,
        EDITOR_RELIGION_COLOR,
        PALLET_OF_COLORS,
        CIV_NAMES_OVER_PROVINCES,
        CIV_NAMES_OVER_PROVINCES_BORDER,
        PROVINCE_SETTINGS_WASTELAND_COLOR,
        PROVINCE_SETTINGS_DISCOVERY_COLOR,
        EDITOR_TERRAIN_COLOR,
        EDITOR_SERVICE_RIBBON_OVERLAY,
        EDITOR_CIV_GAME_COLOR,
        EDITOR_CIV_GAME_COLOR_SR,
        EDITOR_CIV_FLAG_DIVISION_COLOR,
        EDITOR_CIV_FLAG_OVERLAY_COLOR,
        MAP_EDITOR_TRADE_ZONES,
        PB_STRA,
        PB_DASH;

    }

    public class Box {
        private int iPosX;
        private int iPosY;
        private int iWidth;
        private int iHeight;
        private boolean visible = true;

        public Box(int iPosX, int iPosY, int iWidth, int iHeight) {
            this.iPosX = iPosX;
            this.iPosY = iPosY;
            this.iWidth = iWidth;
            this.iHeight = iHeight;
        }

        public final int getPosX() {
            return this.iPosX;
        }

        public final void setPosX(int iPosX) {
            this.iPosX = iPosX;
        }

        public final int getPosY() {
            return this.iPosY;
        }

        public final void setPosY(int iPosY) {
            this.iPosY = iPosY;
        }

        public final int getWidth() {
            return this.iWidth;
        }

        public final int getHeight() {
            return this.iHeight;
        }

        public final void setWidth(int iWidth) {
            this.iWidth = iWidth;
        }

        public final void setHeight(int iHeight) {
            this.iHeight = iHeight;
        }

        public final void setVisible(boolean visible) {
            this.visible = visible;
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }
}

