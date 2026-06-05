
package age.of.civilizations2.jakowski.lukasz.Menus.Change;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.civilizations2.jakowski.lukasz.Button.*;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.*;
import age.of.civilizations2.jakowski.lukasz.Button.Game.*;
import age.of.civilizations2.jakowski.lukasz.Button2.*;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.*;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_ChangeGovernment extends Menu {
    private int selectedGovID = -1;
    private Image previewFlag = null;
    private int previewFlagCivID = -1;
    private int previewFlagIdeologyID = -1;

    public Menu_InGame_ChangeGovernment(int nID) {
        this();
    }

    public Menu_InGame_ChangeGovernment() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int fixedWidth = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.5f);
        int tempWidth = Math.min(CFG.GAMEWIDTH - CFG.PADD * 4, fixedWidth);
        int tY = CFG.PADD;
        final int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        final Civilization civ = CFG.core.getCiv(civID);
        if (civ == null || civ.civGD == null) {
            this.initMenu(null, 0, 0, 0, 0, menuElements, false, false);
            return;
        }
        final int currentIdeology = civ.getIdeology();
        selectedGovID = -1;
        previewFlag = null;
        previewFlagCivID = -1;
        previewFlagIdeologyID = -1;

        List<Boolean> canChangeTo = CFG.ideologiesMgr.canChangeToIdeology(civID);
        int govButtonH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.BUTTON_H * 3 / 5);

        final int[] groupIDs = new int[]{0, 1, 2, 3};
        final String[] groupLabels = new String[]{"Democratic", "Communist", CFG.lang.get("Authoritarian"), CFG.lang.get("Uncivilized")};

        int itemCount = 0;
        for (int g = 0; g < groupIDs.length; g++) {
            final int targetGroup = groupIDs[g];

            boolean hasItems = false;
            for (int i = 1; i < CFG.ideologiesMgr.getIdeologiesSize(); i++) {
                if (CFG.ideologiesMgr.getIdeologyID(i).REVOLUTIONARY) continue;
                if (CFG.ideologiesMgr.getIdeologyID(i).GOV_GROUP_ID != targetGroup) continue;
                if (CFG.ideologiesMgr.getIdeologyID(i).CAN_BECOME_CIVILIZED >= 0) continue;
                hasItems = true;
                break;
            }
            if (!hasItems) continue;

            menuElements.add(new TextBuildTitle(groupLabels[g], -1, CFG.PADD, tY, tempWidth - CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){
                @Override
                public Color getColor(boolean isActive) {
                    return CFG.COLOR_HOVER_TITLE;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD / 2;

            for (int i = 1; i < CFG.ideologiesMgr.getIdeologiesSize(); i++) {
                if (CFG.ideologiesMgr.getIdeologyID(i).REVOLUTIONARY) continue;
                if (CFG.ideologiesMgr.getIdeologyID(i).GOV_GROUP_ID != targetGroup) continue;
                if (CFG.ideologiesMgr.getIdeologyID(i).CAN_BECOME_CIVILIZED >= 0) continue;
                final int govID = i;
                final Ideology govIdeology = CFG.ideologiesMgr.getIdeologyID(i);
                final boolean isCurrent = (i == currentIdeology);
                final boolean available = canChangeTo.get(i);

                menuElements.add(new Button_Game(govIdeology.getName(), -1, CFG.PADD + CFG.PADD, tY, tempWidth - CFG.PADD * 4, govButtonH, available && !isCurrent){
                    @Override
                    public void actionElem(int iID) {
                        if (!available || isCurrent) return;
                        selectedGovID = govID;
                        previewFlagCivID = -1;
                    }
                    @Override
                    public Color getColorE(boolean isActive) {
                        if (isCurrent) return CFG.COLOR_TEXT_GREEN;
                        if (!available) return new Color(0.5f, 0.5f, 0.5f, 0.6f);
                        if (selectedGovID == govID) return CFG.COLOR_TEXT_GREEN;
                        return super.getColorE(isActive);
                    }
                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        int crownW = govIdeology.getCrownImageScaled().getWidth();
                        int crownH = govIdeology.getCrownImageScaled().getHeight();
                        govIdeology.getCrownImageScaled().drawO(oSB,
                            this.getPosXE() + CFG.PADD + iTranslateX,
                            this.getPosY() + this.getHeightE() / 2 - crownH / 2 + iTranslateY);
                        int textX = this.getPosXE() + CFG.PADD * 3 + crownW + iTranslateX;
                        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), textX,
                            this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
                        if (isCurrent) {
                            String label = "[" + CFG.lang.get("Current") + "]";
                            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), label);
                            int labelW = (int)CFG.glyphLay.width;
                            int labelH = (int)CFG.glyphLay.height;
                            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, label,
                                this.getPosXE() + this.getWidthE() - CFG.PADD - labelW + iTranslateX,
                                this.getPosY() + this.getHeightE() / 2 - labelH / 2 + iTranslateY, CFG.COLOR_TEXT_GREEN);
                        } else if (selectedGovID == govID) {
                            String label = "[" + CFG.lang.get("Selected") + "]";
                            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), label);
                            int labelW = (int)CFG.glyphLay.width;
                            int labelH = (int)CFG.glyphLay.height;
                            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, label,
                                this.getPosXE() + this.getWidthE() - CFG.PADD - labelW + iTranslateX,
                                this.getPosY() + this.getHeightE() / 2 - labelH / 2 + iTranslateY, CFG.COLOR_TEXT_GREEN);
                        }
                    }
                    @Override
                    public int getTextWidthU() {
                        return super.getTextWidthU() + CFG.PADD * 3 + IdeologiesManager.MAX_CROWN_WIDTH;
                    }
                    @Override
                    public void buildElemHover() {
                        this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover_Just(govID);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(itemCount % 2);
                tY += govButtonH + CFG.PADD / 2;
                itemCount++;
            }
            tY += CFG.PADD / 2;
        }

        tY += CFG.PADD;
        final long govCost = currentIdeology >= 0 ? IdeologiesManager.getChangeGovernmentCost(civID) : 0;
        final String costStr = CFG.lang.get("Cost") + ": " + govCost + " " + CFG.lang.get("Gold") + ", "
            + GameValues.gvGovernment.CHANGE_GOV_MOVEMENT_COST + " " + CFG.lang.get("MovementPoints") + " | "
            + CFG.lang.get("Technology") + ": " + (int)(GameValues.gvGovernment.CHANGE_GOV_REQUIRED_TECH * 100.0f) + "%";
        menuElements.add(new TextScale(costStr, -1, 2, tY, tempWidth - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, 0.65f));
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;

        int btnW = (tempWidth - CFG.PADD * 3) / 2;
        menuElements.add(new Button_Game(CFG.lang.get("Cancel"), -1, CFG.PADD, tY, btnW, true){
            @Override
            public void actionElem(int iID) { Menu_InGame_ChangeGovernment.this.setVisibleM(false); }
        });
        menuElements.add(new Button_Game(CFG.lang.get("Confirm"), -1, CFG.PADD + btnW + CFG.PADD, tY, btnW, true){
            @Override
            public boolean getIsClickable() {
                if (selectedGovID < 0 || selectedGovID == currentIdeology) return false;
                if (civ.getMovemPoints() < GameValues.gvGovernment.CHANGE_GOV_MOVEMENT_COST) return false;
                if (civ.getGold() < (long)IdeologiesManager.getChangeGovernmentCost(civID)) return false;
                if (civ.getTechLevel() < GameValues.gvGovernment.CHANGE_GOV_REQUIRED_TECH) return false;
                return true;
            }
            @Override
            public void actionElem(int iID) {
                if (selectedGovID < 0 || selectedGovID == currentIdeology) return;
                if (GameManager.changeGovernmentType(civID, selectedGovID)) {
                    ArrayList<String> tMess = new ArrayList<String>();
                    ArrayList<Color> tColor = new ArrayList<Color>();
                    tMess.add(civ.getCivName());
                    tColor.add(CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getColor());
                    tMess.add(CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getName());
                    tColor.add(CFG.COLOR_HOVER_TITLE);
                    CFG.toastM.addM(tMess, tColor);
                    CFG.menus.rebuildMenu_InGame_Infobox(civ.getCivName() + ": " + CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).getName(), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                }
                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                CFG.setActiveCivInfoId(CFG.getActiveCivInfoId());
                CFG.updateActiveCivilizationInfoInGame();
                CFG.menus.updateInGameTopAll(civID);
                CFG.mapModesManager.disableAllViews();
                for (int i = 0; i < civ.getNumOfProvs(); i++) {
                    CFG.core.getProv(civ.getProvID(i)).setFromCivID(0);
                }
                Menu_InGame_ChangeGovernment.this.setVisibleM(false);
            }
        });
        tY += CFG.BUTTON_H + CFG.PADD;

        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("ChangeGovernment"), CFG.BUTTON_H * 4 / 5, true, true),
            CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, tY, menuElements, true, true);
    }

    private void loadPreviewFlag(int civID, int ideologyID) {
        if (previewFlagCivID == civID && previewFlagIdeologyID == ideologyID && previewFlag != null) return;
        previewFlagCivID = civID;
        previewFlagIdeologyID = ideologyID;
        if (previewFlag != null) {
            previewFlag = null;
        }
        try {
            String civTag = CFG.core.getCiv(civID).getCivTag();
            String extraTag = CFG.ideologiesMgr.getIdeologyID(ideologyID).getExtraTag();
            String flagPath = "game/flags/" + civTag + extraTag + ".png";
            try {
                previewFlag = new Image(new Texture(FileManager.loadFile(flagPath),
                    com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888, true),
                    Texture.TextureFilter.Linear);
            } catch (Exception ex) {
                previewFlag = null;
            }
        } catch (Exception e) {
            previewFlag = null;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        // Draw background
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getHeightM() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(Color.WHITE);
        // Draw border
        CFG.drawRectInfoBox_Left_Title(oSB, this.getPosX() + iTranslateX, this.getPosY() - this.getHeightM() + iTranslateY, this.getWidthM(), this.getHeightM());
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        // Draw selected gov flag on right side
        if (selectedGovID >= 0) {
            try {
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                if (civID > 0) {
                    loadPreviewFlag(civID, selectedGovID);
                    if (previewFlag != null) {
                        int flagX = this.getPosX() + this.getWidthM() - CFG.PADD * 2 - CFG.CIV_FLAG_WIDTH + iTranslateX;
                        int flagY = this.getPosY() - this.getHeightM() + CFG.PADD * 2 + iTranslateY;
                        previewFlag.drawO(oSB, flagX, flagY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, flagX, flagY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    }
                }
            } catch (Exception e) {
            }
        }
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void updateLang() {}

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            selectedGovID = -1;
            previewFlag = null;
            previewFlagCivID = -1;
            previewFlagIdeologyID = -1;
            for (int i = 0; i < this.getMenuElemsSize(); i++) {
                this.getMenuElem(i).setVisibleE(false);
            }
        }
    }
}
