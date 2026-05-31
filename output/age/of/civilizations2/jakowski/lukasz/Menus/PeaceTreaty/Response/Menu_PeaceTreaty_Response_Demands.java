/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Government;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Province2;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_ReleaseVassal;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_Religion;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_TakeAll;
import age.of.civilizations2.jakowski.lukasz.Button.Peace.Button_PeaceTreaty_Demands_WarReparations;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty_Response_Demands
extends Menu {
    public Menu_PeaceTreaty_Response_Demands() {
        int j;
        boolean addCiv;
        int i;
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.2f);
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = 0;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID <= 0) continue;
            addCiv = CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.size() > 0 || CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID > 0 || CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID > 0;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size(); ++j) {
                if (CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getTrueOwnerOfProv() == CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID) continue;
                addCiv = true;
                break;
            }
            if (!addCiv && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.size() <= 0) continue;
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                @Override
                public void actionElem(int iID) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_ReleaseVassal(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID, this.countPoints(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 5, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID > 0) {
                menuElements.add(new Button_PeaceTreaty_Demands_Government(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID > 0) {
                menuElements.add(new Button_PeaceTreaty_Demands_Religion(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_WarReparations(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.get(j), CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.get(j), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size(); ++j) {
                if (CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getTrueOwnerOfProv() == CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID) continue;
                menuElements.add(new Button_PeaceTreaty_Demands_Province2(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                        CFG.core.setActiveProvID(this.getCurr());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.size() <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID <= 0 && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID <= 0) continue;
            addCiv = CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.size() > 0 || CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID > 0 || CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID > 0;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size(); ++j) {
                if (CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getTrueOwnerOfProv() == CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID) continue;
                addCiv = true;
                break;
            }
            if (!addCiv && CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.size() <= 0) continue;
            menuElements.add(new Button_PeaceTreaty_Demands_TakeAll(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                @Override
                public void actionElem(int iID) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_ReleaseVassal(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID, this.countPoints(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 5, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID > 0) {
                menuElements.add(new Button_PeaceTreaty_Demands_Government(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID > 0) {
                menuElements.add(new Button_PeaceTreaty_Demands_Religion(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.size(); ++j) {
                menuElements.add(new Button_PeaceTreaty_Demands_WarReparations(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.get(j), CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.get(j), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size(); ++j) {
                if (CFG.core.getProv(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getTrueOwnerOfProv() == CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID) continue;
                menuElements.add(new Button_PeaceTreaty_Demands_Province2(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j), 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, true){

                    @Override
                    public void actionElem(int iID) {
                        CFG.core.setActiveProvID(this.getCurr());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        for (i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setCurr(i % 2);
        }
        int tempPosY = Math.max(Math.max(Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 2), Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD);
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + 2 + Core.PADDING, this.getHeightT() + Core.PADDING);
                oSB.setColor(new Color(0.27450982f, 0.43137255f, 0.64705884f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.27450982f, 0.43137255f, 0.64705884f, 0.375f));
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
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH - tempW, tempPosY + CFG.BUTTON_H * 3 / 4, tempW, Math.min(menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD : CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD * 2 + CFG.BUTTON_H / 2) - CFG.BUTTON_H * 2 - CFG.PADD * 4 - CFG.BUTTON_H - CFG.PADD * 2), menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Demands"));
    }

    public final int countPoints(int iCivID, int iReleaseCivID, int toReleaseByCivID) {
        int k;
        int j;
        int i;
        int out = 0;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != toReleaseByCivID) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.size(); ++j) {
                if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).iCivID != iReleaseCivID) continue;
                for (k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).lProvinces.size(); ++k) {
                    out += CFG.core.getProvinceValue(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).lProvinces.get(k));
                }
            }
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != toReleaseByCivID) continue;
            for (j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.size(); ++j) {
                if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).iCivID != iReleaseCivID) continue;
                for (k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).lProvinces.size(); ++k) {
                    out += CFG.core.getProvinceValue(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).lProvinces.get(k));
                }
            }
        }
        return out;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 4 + Core.PADDING, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM() + 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void actionCloseMenu() {
        this.setVisibleM(false);
        CFG.menus.hidePeaceTreaty_ResponseProvinces();
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && !this.getVisibleM()) {
            Menu_Civilization_Info.lTime = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }
}

