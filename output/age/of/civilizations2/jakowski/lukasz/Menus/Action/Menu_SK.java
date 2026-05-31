
package age.of.civilizations2.jakowski.lukasz.Menus.Action;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Menu_SK
extends Menu {
    public static long lastMoveTime = 0L;
    public static int moveDelay = 120;
    public static int snakeW = 68;
    public static int snakeH = 44;
    public static SnakeGame snakeGame;
    public static View goBack;

    public Menu_SK() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.BUTTON_W / 2;
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.PADD, true){

            @Override
            public void actionElem(int iID) {
                Menu_SK.this.onBackPressed();
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        if (CFG.oR.nextInt(100) < 50) {
            snakeW = 68;
            snakeH = 44;
            moveDelay = 150;
        } else {
            snakeW = 27;
            snakeH = 18;
            moveDelay = 120;
        }
        snakeGame = new SnakeGame();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int i;
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.085f));
        IMGManager.getIMG(Images.pix255).draw(oSB, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        IMGManager.getIMG(Images.gradientVertical).draw(oSB, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.025f));
        for (i = 0; i < 500; ++i) {
            IMGManager.getIMG(Images.line32Vertical).draw2(oSB, i * snakeW, 0, 1, CFG.GAMEHEIGHT);
            if (i * snakeW > CFG.GAMEWIDTH) break;
        }
        for (i = 0; i < 500; ++i) {
            IMGManager.getIMG(Images.line32).draw2(oSB, 0, i * snakeH, CFG.GAMEWIDTH, 1);
            if (i * snakeH > CFG.GAMEHEIGHT) break;
        }
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
        IMGManager.getIMG(Images.gameLogo).draw(oSB, CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth(), CFG.GAMEHEIGHT - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
        long now = System.currentTimeMillis();
        if (now - lastMoveTime > (long)moveDelay) {
            snakeGame.update();
            lastMoveTime = now;
        }
        int tID = 0;
        for (Point p : Menu_SK.snakeGame.snake) {
            CFG.core.getCiv(Menu_SK.snakeGame.flags.get(tID++)).getFlagC().draw(oSB, p.x * snakeW, p.y * snakeH, snakeW, snakeH);
        }
        IMGManager.getIMG(Images.bFarm).draw(oSB, Menu_SK.snakeGame.food.x * snakeW, Menu_SK.snakeGame.food.y * snakeH, snakeW, snakeH);
        if (Menu_SK.snakeGame.gameOver) {
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Game Over", CFG.BUTTON_H / 2, CFG.BUTTON_H / 2, CFG.COLOR_NEGATIVE_2);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Flag Snake, Score: " + Menu_SK.snakeGame.flags.size(), CFG.BUTTON_H / 2, CFG.BUTTON_H / 2 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD, CFG.COLOR_NEUTRAL);
        } else {
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, "Flag Snake, Score: " + Menu_SK.snakeGame.flags.size(), CFG.BUTTON_H / 2, CFG.BUTTON_H / 2, CFG.COLOR_NEUTRAL);
        }
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, "Age of History 2: Definitive Edition", CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, 0.25f));
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
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(goBack);
        CFG.menus.setBackAnimation(true);
    }

    static {
        goBack = View.eMAINMENU;
    }

    public static class SnakeGame {
        int cols = CFG.GAMEWIDTH / snakeW;
        int rows = CFG.GAMEHEIGHT / snakeH;
        LinkedList<Point> snake = new LinkedList();
        List<Integer> flags = new ArrayList<Integer>();
        Point food;
        int dirX = 1;
        int dirY = 0;
        int nextDirX = 1;
        int nextDirY = 0;
        boolean gameOver = false;

        public SnakeGame() {
            this.init();
        }

        public void init() {
            this.snake.clear();
            this.snake.add(new Point(this.cols / 2, this.rows / 2));
            this.flags.add(CFG.oR.nextInt(CFG.core.getCivsSize()));
            this.snake.add(new Point(this.cols / 2 - 1, this.rows / 2));
            this.flags.add(CFG.oR.nextInt(CFG.core.getCivsSize()));
            this.snake.add(new Point(this.cols / 2 - 2, this.rows / 2));
            this.flags.add(CFG.oR.nextInt(CFG.core.getCivsSize()));
            this.spawnFood();
        }

        private void spawnFood() {
            this.food = new Point(CFG.oR.nextInt(this.cols), CFG.oR.nextInt(this.rows));
        }

        public void update() {
            if (this.gameOver) {
                return;
            }
            this.dirX = this.nextDirX;
            this.dirY = this.nextDirY;
            Point head = this.snake.getFirst();
            int newX = head.x + this.dirX;
            int newY = head.y + this.dirY;
            Point newHead = new Point(newX, newY);
            if (newX < 0 || newY < 0 || newX >= this.cols || newY >= this.rows) {
                this.gameOver = true;
                CFG.toastM.addM(CFG.lang.get("Defeat") + " - Game Over", CFG.COLOR_NEGATIVE_2);
                CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
                return;
            }
            if (this.snake.contains(newHead)) {
                this.gameOver = true;
                CFG.toastM.addM(CFG.lang.get("Defeat") + " - Game Over", CFG.COLOR_NEGATIVE_2);
                CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
                return;
            }
            this.snake.addFirst(newHead);
            if (newHead.equals(this.food)) {
                this.spawnFood();
                this.flags.add(CFG.oR.nextInt(CFG.core.getCivsSize()));
                CFG.SFXManager.playSound(SFXManager.SFX_GOLD);
            } else {
                this.snake.removeLast();
            }
        }

        public void setDirection(int dx, int dy) {
            if (dx == this.dirX && dy == this.dirY) {
                lastMoveTime -= (long)(moveDelay / 2);
                return;
            }
            this.nextDirX = dx;
            this.nextDirY = dy;
        }
    }
}

