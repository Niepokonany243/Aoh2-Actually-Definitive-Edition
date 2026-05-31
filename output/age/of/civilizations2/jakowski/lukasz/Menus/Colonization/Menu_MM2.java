/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Colonization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MM2
extends Menu {
    public long resultAnimStart = 0L;
    public boolean showResultAnim = false;
    public boolean lastAnswerCorrect = false;
    public final String[] TEXT_CORRECT = new String[]{"Correct!", "That's right!", "Well done!", "Good answer!", "You're correct!", "Nice one!", "Impressive.", "That\u2019s a correct answer.", "Exactly right!", "You're getting better.", "Well played."};
    public final String[] TEXT_WRONG = new String[]{"Wrong.", "That\u2019s not correct.", "Incorrect.", "Not quite.", "Nice try\u2026 but wrong.", "That\u2019s not it.", "Unfortunately, no.", "Wrong answer.", "Better luck next time.", "You were close\u2026 but no.", "That\u2019s incorrect."};
    public final String[] TEXT_NEXT = new String[]{"Next question.", "Let\u2019s continue.", "Moving on..", "Next up.", "Let\u2019s go further.", "On to the next question.", "Keep going."};
    public final String[] TEXT_RESTART = new String[]{"Game over.", "Better luck next time.", "Try again.", "Start over.", "You can do better.", "Back to the beginning.", "Another attempt?", "Let\u2019s try again.", "Reset and go again."};

    public Menu_MM2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempW = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Text_Desc2_Special("Hosted by: Lukasz Jakowski", CFG.PADD, tY, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special("Question " + (Menu_MM.questionID + 1) + " / " + Menu_MM.money.length, CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new TextBuildTitle(this.getQuestionTitle(), -1, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new ButtonFlagBig(tempW / 2 - IMGManager.getIMG(Images.flagBigMask).getWidth() / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, true, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("What country does this flag belong to?", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploAZ, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public int getFlagCivID() {
                return Menu_MM.questionCivID;
            }
        });
        menuElements.add(new Text_Desc2_Special(this.getPrizeText(), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        menuElements.add(new Text_Desc2_Special((Menu_MM.questionID == Menu_MM.money.length - 1 ? "This is the final question. " : "") + this.getQuestionText(), CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return Colors.getColorButton(isActive, this.getIsHovered());
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 0; i < Menu_MM.answers.size(); ++i) {
            menuElements.add(new Button_InGameAction((i == 0 ? "A" : (i == 1 ? "B" : (i == 2 ? "C" : "D"))) + ": " + CFG.core.getCiv(Menu_MM.answers.get(i)).getCivName(), -1, CFG.PADD, tY, tempW - CFG.PADD * 2, true){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public void actionElem(int iID) {
                    if (Menu_MM.answerChosen < 0) {
                        Menu_MM.answerChosen = this.id;
                        Menu_MM.answerClickTime = System.currentTimeMillis();
                        Menu_MM.isAnimating = true;
                        Menu_MM.textUpdated = false;
                    }
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                    super.setCurr(nCurrent);
                }

                @Override
                public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                    if (Menu_MM.answerChosen >= 0) {
                        if (Menu_MM.isAnimating) {
                            if (Menu_MM.answerChosen == this.id) {
                                float alpha = 0.5f;
                                long time = System.currentTimeMillis() - Menu_MM.answerClickTime;
                                float speed = 0.005f;
                                alpha = 0.4f + 0.3f * (float)Math.sin((float)time * speed);
                                if (time > 1450L) {
                                    Menu_MM.isAnimating = false;
                                    alpha = 0.7f;
                                }
                                oSB.setColor(new Color(1.0f, 0.7f, 0.1f, alpha));
                                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
                            }
                        } else if (Menu_MM.answerChosen == this.id || Menu_MM.answers.get(this.id) == Menu_MM.questionCivID) {
                            if (Menu_MM.answers.get(this.id) == Menu_MM.questionCivID) {
                                oSB.setColor(new Color(0.2f, 1.0f, 0.2f, 0.35f));
                            } else {
                                oSB.setColor(new Color(1.0f, 0.2f, 0.2f, 0.35f));
                            }
                            IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
                        }
                    }
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (Menu_MM.answerChosen >= 0) {
                        if (Menu_MM.isAnimating) {
                            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.95f, 0.95f, 0.95f, 1.0f));
                        } else if (Menu_MM.answers.get(this.id) == Menu_MM.questionCivID) {
                            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.6f, 1.0f, 0.6f, 1.0f));
                        } else {
                            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(1.0f, 0.5f, 0.5f, 1.0f));
                        }
                    } else {
                        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new Button_InGameBox("", -1, CFG.PADD, tY, tempW - CFG.PADD * 2, true){
            Color textClr;
            {
                this.textClr = CFG.COLOR_POSITIVE;
            }

            @Override
            public void actionElem(int iID) {
                if (Menu_MM.answerChosen >= 0 && !Menu_MM.isAnimating) {
                    if (Menu_MM.answers.get(Menu_MM.answerChosen) == Menu_MM.questionCivID) {
                        if (++Menu_MM.questionID >= Menu_MM.money.length) {
                            Menu_MM.questionID = 0;
                        }
                    } else {
                        Menu_MM.questionID = 0;
                    }
                    if (Menu_MM.gameWon) {
                        Menu_MM.gameWon = false;
                        Menu_MM.questionID = 0;
                    }
                    Menu_MM.nextQuestion();
                    CFG.menus.rebuildMM2();
                }
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (Menu_MM.answerChosen >= 0 && !Menu_MM.isAnimating) {
                    if (!Menu_MM.textUpdated) {
                        if (Menu_MM.questionID == Menu_MM.money.length - 1) {
                            Menu_MM.gameWon = true;
                            Menu_MM2.this.getMenuElem(Menu_MM2.this.getMenuElemsSize() - 1).setTextE("Congratulations! You did it! The world is yours!");
                            this.textClr = CFG.COLOR_GOLD;
                            Menu_MM2.this.lastAnswerCorrect = true;
                        } else if (Menu_MM.answers.get(Menu_MM.answerChosen) == Menu_MM.questionCivID) {
                            Menu_MM2.this.getMenuElem(Menu_MM2.this.getMenuElemsSize() - 1).setTextE(Menu_MM2.this.TEXT_CORRECT[CFG.oR.nextInt(Menu_MM2.this.TEXT_CORRECT.length)] + " - " + Menu_MM2.this.TEXT_NEXT[CFG.oR.nextInt(Menu_MM2.this.TEXT_NEXT.length)]);
                            this.textClr = CFG.COLOR_POSITIVE;
                            Menu_MM2.this.lastAnswerCorrect = true;
                        } else {
                            Menu_MM2.this.getMenuElem(Menu_MM2.this.getMenuElemsSize() - 1).setTextE(Menu_MM2.this.TEXT_WRONG[CFG.oR.nextInt(Menu_MM2.this.TEXT_WRONG.length)] + " - " + Menu_MM2.this.TEXT_RESTART[CFG.oR.nextInt(Menu_MM2.this.TEXT_RESTART.length)]);
                            this.textClr = CFG.COLOR_NEGATIVE_2;
                            Menu_MM2.this.lastAnswerCorrect = false;
                        }
                        Menu_MM2.this.resultAnimStart = System.currentTimeMillis();
                        Menu_MM2.this.showResultAnim = true;
                        Menu_MM.textUpdated = true;
                    }
                    super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (Menu_MM.answerChosen >= 0 && !Menu_MM.isAnimating) {
                    Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getIsHovered() ? this.getColorE(isActive) : this.textClr);
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenu(new TitleM_TextSmall("Who Wants to Rule the World?", CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + Core.PADDING * 2 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.45f, 0.2f, 0.8f, 0.075f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.45f, 0.2f, 0.8f, 0.175f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT + CFG.PADD + Core.PADDING, IMGManager.getIMG(Images.topBar2).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(CFG.GAMEHEIGHT - CFG.BUTTON_H, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.showResultAnim) {
            float duration;
            long now = System.currentTimeMillis();
            float time = now - this.resultAnimStart;
            if (time <= (duration = 2000.0f)) {
                float progress = time / duration;
                float alpha = 0.6f * (1.0f - progress);
                if (alpha < 0.0f) {
                    alpha = 0.0f;
                }
                if (this.lastAnswerCorrect) {
                    oSB.setColor(new Color(0.2f, 1.0f, 0.3f, alpha));
                } else {
                    oSB.setColor(new Color(1.0f, 0.2f, 0.2f, alpha));
                }
                IMGManager.getIMG(Images.gradientVertical).draw(oSB, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2, CFG.GAMEWIDTH, CFG.BUTTON_H * 2, false, true);
                oSB.setColor(Color.WHITE);
            } else {
                this.showResultAnim = false;
            }
        }
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.175f));
        IMGManager.getIMG(Images.gameLogo).draw(oSB, CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.PADD * 3 - IMGManager.getIMG(Images.gameLogo).getHeight() - CFG.TEXT_HEIGHT_DEFAULT);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, "Age of History 2: Definitive Edition", CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, 0.25f));
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public String getPrizeText() {
        int level = Menu_MM.questionID;
        int money = Menu_MM.money[Math.min(level, Menu_MM.money.length - 1)];
        String m = CFG.getNumberWthSpaces("" + money);
        if (level <= 3) {
            return "This question is for " + m + ".";
        }
        if (level <= 7) {
            return "You're playing for " + m + ".";
        }
        if (level <= 11) {
            return "This one is worth " + m + ".";
        }
        return "Okay.. this is for " + m + ". Don't mess it up.";
    }

    public String getQuestionText() {
        switch (Menu_MM.questionID % 5) {
            case 0: {
                return "Which nation is represented by this flag?";
            }
            case 1: {
                return "Can you identify this country's flag?";
            }
            case 2: {
                return "Which civilization uses this flag?";
            }
            case 3: {
                return "This flag belongs to which country?";
            }
            case 4: {
                return "Name the country shown by this flag.";
            }
        }
        return "Which civilization uses this flag?";
    }

    public String getQuestionTitle() {
        switch (Menu_MM.questionID) {
            case 0: {
                return "Let's begin... here's your first question.";
            }
            case 1: {
                return "Let's see your next question..";
            }
            case 2: {
                return "Take a look at this flag.";
            }
            case 3: {
                return "You're doing well so far...";
            }
            case 4: {
                return "Keep going, stay focused.";
            }
            case 5: {
                return "This one might be tricky.";
            }
            case 6: {
                return "Think carefully before you answer.";
            }
            case 7: {
                return "Don't rush\u2014this one matters.";
            }
            case 8: {
                return "You're getting into harder territory now.";
            }
            case 9: {
                return "This is where many players struggle.";
            }
            case 10: {
                return "One mistake and the game is over.";
            }
            case 11: {
                return "This question is very important.";
            }
            case 12: {
                return "This decision could cost you everything.";
            }
            case 13: {
                return "Everything is on the line now.";
            }
            case 14: {
                return "This is your final challenge.";
            }
        }
        return "This is for the highest prize..";
    }
}

