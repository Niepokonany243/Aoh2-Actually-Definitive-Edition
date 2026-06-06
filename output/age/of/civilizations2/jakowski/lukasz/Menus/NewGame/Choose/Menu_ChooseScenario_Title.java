
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_ChooseScenario_Title
extends Menu {
    public static boolean drawBigPreview = false;
    public static boolean drawPreview = false;
    public static int iPreviewScenarioID = 0;
    private static Image previewImage = null;
    private static List<String> sTexts;
    private static final int BIGGER_SCALE = 2;

    public Menu_ChooseScenario_Title() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempCenterPosition = (CFG.BUTTON_H * 3 - CFG.BUTTON_H * 2 - CFG.PADD) / 2;
        int nBUTTON_WIDTH = CFG.isAndroid() && !CFG.LANDSCAPE ? CFG.BUTTON_W : CFG.BUTTON_W * 2;
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - nBUTTON_WIDTH - CFG.PADD * 2, CFG.PADD + tempCenterPosition, nBUTTON_WIDTH, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME : (this.getIsClickable() ? CFG.COLOR_TEXT_RANK : new Color(0.674f, 0.09f, 0.066f, 0.5f));
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - nBUTTON_WIDTH - CFG.PADD * 2, tempCenterPosition + CFG.BUTTON_H + CFG.PADD * 2, nBUTTON_WIDTH, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME : (this.getIsClickable() ? CFG.COLOR_TEXT_RANK : new Color(0.674f, 0.09f, 0.066f, 0.5f));
            }
        });
        menuElements.add(new Button_Transparent(CFG.PADD, CFG.PADD, CFG.PADD, CFG.PADD, true){

            @Override
            public int getWidthE() {
                try {
                    return (int)((float)previewImage.getWidth() * CFG.GUI_SCALE);
                }
                catch (NullPointerException ex) {
                    return super.getWidthE();
                }
            }

            @Override
            public int getHeightE() {
                try {
                    return (int)((float)previewImage.getHeight() * CFG.GUI_SCALE);
                }
                catch (NullPointerException ex) {
                    return super.getHeightE();
                }
            }
        });
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H * 3 + CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("LoadScenario"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("ChooseScenario"));
    }

    public static final void loadPreview(int nPreviewID) {
        if (iPreviewScenarioID != nPreviewID) {
            iPreviewScenarioID = nPreviewID;
            Menu_ChooseScenario_Title.loadPreview();
        }
    }

    public static final void loadPreview() {
        block12: {
            Menu_ChooseScenario_Title.disposePreview();
            try {
                if (CFG.core.getGameScenars().getScenarioIsInternal(iPreviewScenarioID)) {
                    try {
                        previewImage = new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "previewSpecial.png")), Texture.TextureFilter.Linear);
                    }
                    catch (Exception ex) {
                        previewImage = new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "preview.png")), Texture.TextureFilter.Linear);
                    }
                    break block12;
                }
                try {
                    try {
                        previewImage = new Image(new Texture(Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "previewSpecial.png")), Texture.TextureFilter.Linear);
                    }
                    catch (Exception ex) {
                        previewImage = new Image(new Texture(Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "preview.png")), Texture.TextureFilter.Linear);
                    }
                }
                catch (Exception exr) {
                    try {
                        previewImage = new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "previewSpecial.png")), Texture.TextureFilter.Linear);
                    }
                    catch (Exception ex) {
                        previewImage = new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().getScenarioTagID(iPreviewScenarioID) + "/" + "preview.png")), Texture.TextureFilter.Linear);
                    }
                }
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                
            }
        }
        sTexts = new ArrayList<String>();
        sTexts.add(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(iPreviewScenarioID)));
        sTexts.add(CFG.core.getGameScenars().getScenarioDay(iPreviewScenarioID) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(iPreviewScenarioID)) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(iPreviewScenarioID)));
        sTexts.add(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(iPreviewScenarioID)).getName());
        sTexts.add(CFG.lang.get("Civilizations") + ": " + CFG.getNumberWthSpaces("" + CFG.core.getGameScenars().getScenarioNumOfCivs(iPreviewScenarioID)));
        sTexts.add(CFG.lang.get("Author") + ": " + CFG.core.getGameScenars().getScenarioAuthorID(iPreviewScenarioID));
        if (CFG.core.getGameScenars().getScenarioWiki(iPreviewScenarioID).length() > 0) {
            sTexts.add(CFG.lang.get("Wiki") + ": " + CFG.core.getGameScenars().getScenarioWiki(iPreviewScenarioID).replace('_', ' '));
        }
        drawBigPreview = false;
    }

    public static final void disposePreview() {
        if (previewImage != null) {
            previewImage.getTexture().dispose();
            previewImage = null;
            sTexts.clear();
            sTexts = null;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() * 3 / 4, this.getHeightM() - CFG.PADD);
        IMGManager.getIMG(Images.sliderGradient).draw2O(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() * 3 / 4 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() * 3 / 4, this.getHeightM() - CFG.PADD, true, false);
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.25f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() - CFG.PADD);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.55f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 3 + CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() - CFG.PADD - 6);
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.3f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.patternReversed).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() - CFG.PADD);
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD * 3 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 3, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() - this.getMenuElem(0).getPosY());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosX() - 1 + this.getMenuElem(0).getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() - this.getMenuElem(0).getPosY());
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosX() + 1 + this.getMenuElem(0).getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() - this.getMenuElem(0).getPosY());
        oSB.setColor(Color.WHITE);
        if (Menu_ChooseScenario.iFHR >= 0) {
            try {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE), (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE));
                oSB.setColor(Color.WHITE);
                Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE), (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE));
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight());
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight(), true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), false, true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), true, true);
                oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
                CFG.drawRect(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - 1 + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE), (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE));
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                CFG.drawRect(oSB, this.getPosX() + 1 + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) - 2, (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * CFG.GUI_SCALE) - 2);
                oSB.setColor(Color.WHITE);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, sTexts.get(0), this.getPosX() + CFG.PADD * 3 + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + CFG.PADD * 4 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                for (int i = 1; i < sTexts.size(); ++i) {
                    Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, sTexts.get(i), this.getPosX() + CFG.PADD * 3 + (int)((float)Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + CFG.PADD * 6 + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f) + CFG.PADD) * i + CFG.PADD * i + iTranslateY, CFG.COLOR_NEUTRAL);
                }
            }
            catch (Exception i) {}
        } else if (drawPreview && !drawBigPreview) {
            try {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE), (int)((float)previewImage.getHeight() * CFG.GUI_SCALE));
                oSB.setColor(Color.WHITE);
                previewImage.drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - previewImage.getHeight() + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE), (int)((float)previewImage.getHeight() * CFG.GUI_SCALE));
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)previewImage.getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight());
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)previewImage.getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight(), true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)previewImage.getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), false, true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)previewImage.getHeight() * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), true, true);
                oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
                CFG.drawRect(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - 1 + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE), (int)((float)previewImage.getHeight() * CFG.GUI_SCALE));
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                CFG.drawRect(oSB, this.getPosX() + 1 + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) - 2, (int)((float)previewImage.getHeight() * CFG.GUI_SCALE) - 2);
                oSB.setColor(Color.WHITE);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, sTexts.get(0), this.getPosX() + CFG.PADD * 3 + (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + CFG.PADD * 4 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                for (int i = 1; i < sTexts.size(); ++i) {
                    Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, sTexts.get(i), this.getPosX() + CFG.PADD * 3 + (int)((float)previewImage.getWidth() * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + CFG.PADD * 6 + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f) + CFG.PADD) * i + CFG.PADD * i + iTranslateY, CFG.COLOR_NEUTRAL);
                }
            }
            catch (Exception exception) {
                
            }
        }
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (Menu_ChooseScenario.iFHR >= 0 && drawBigPreview) {
            try {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE));
                oSB.setColor(Color.WHITE);
                Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE));
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight());
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight(), true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), false, true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), true, true);
                oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
                CFG.drawRect(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - 1 + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE));
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                CFG.drawRect(oSB, this.getPosX() + 1 + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getWidth() * 2) * CFG.GUI_SCALE) - 2, (int)((float)(Menu_ChooseScenario.preview.get(Menu_ChooseScenario.iFHR).getHeight() * 2) * CFG.GUI_SCALE) - 2);
                oSB.setColor(Color.WHITE);
            }
            catch (Exception exception) {}
        } else if (drawPreview && drawBigPreview) {
            try {
                oSB.setColor(Color.BLACK);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE));
                oSB.setColor(Color.WHITE);
                previewImage.drawO(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - previewImage.getHeight() + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE));
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight());
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight(), true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), false, true);
                CFG.map.getMpB().getMinimapOverlay().draw2O(oSB, this.getPosX() + CFG.PADD + (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getWidth() + iTranslateX, this.getPosY() + CFG.PADD * 2 - CFG.map.getMpB().getMinimapOverlay().getHeight() + (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE) - CFG.map.getMpB().getMinimapOverlay().getHeight() + iTranslateY, CFG.map.getMpB().getMinimapOverlay().getWidth(), CFG.map.getMpB().getMinimapOverlay().getHeight(), true, true);
                oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
                CFG.drawRect(oSB, this.getPosX() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 - 1 + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE), (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE));
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
                CFG.drawRect(oSB, this.getPosX() + 1 + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, (int)((float)(previewImage.getWidth() * 2) * CFG.GUI_SCALE) - 2, (int)((float)(previewImage.getHeight() * 2) * CFG.GUI_SCALE) - 2);
                oSB.setColor(Color.WHITE);
            }
            catch (Exception exception) {
                
            }
        }
        Menu_ChooseScenario.iFHR = -1;
    }

    public static final void clickLoadScenario() {
        CFG.core.setActiveProvID(-1);
        CFG.mapModesManager.disableAllViews();
        CFG.core.setScenarioID(iPreviewScenarioID);
        Menu_LoadScenario.editor = false;
        Menu_LoadScenario.goToView = null;
        Menu_LoadScenario.loadActionEND = 4;
        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Menu_ChooseScenario_Title.clickLoadScenario();
                break;
            }
            case 1: {
                this.onBackPressed();
                drawPreview = false;
                Menu_ChooseScenario_Title.disposePreview();
                CFG.menus.disposeChooseScenarioFlags();
                break;
            }
            case 2: {
                drawBigPreview = !drawBigPreview;
            }
        }
        RenderProvince.updateDrawProvinces();
    }

    @Override
    public final void onBackPressed() {
        CFG.core.setActiveProvID(-1);
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            drawPreview = true;
            iPreviewScenarioID = CFG.core.getScenarioID();
            Menu_ChooseScenario_Title.loadPreview();
        } else {
            drawPreview = false;
            Menu_ChooseScenario_Title.disposePreview();
            CFG.menus.disposeChooseScenarioFlags();
        }
        drawBigPreview = false;
        super.setVisibleM(visible);
    }
}

