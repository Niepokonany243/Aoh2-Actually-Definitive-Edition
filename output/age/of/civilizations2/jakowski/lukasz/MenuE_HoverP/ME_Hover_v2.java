
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.List;

public class ME_Hover_v2
implements ME_Hover {
    private List<MEHover_2E> lElements;
    private int iElementsSize = 0;
    public static long ANIMATION_TIME;
    public static float ANIMATION_ALPHA;
    public static float ANIMATION_PADDING;
    public static int ANIMATION_INTERVAL;
    public int iHeight = 0;
    public int iWidth = 0;
    public int iMaxWidth = 0;
    private int iWidthOver = 0;
    private int iScrollPosX = 0;
    private boolean backAnimation = true;
    private long lTime = 0L;

    public static final void resetAnimation() {
        ANIMATION_TIME = System.currentTimeMillis();
        ANIMATION_ALPHA = 0.01f;
        ANIMATION_PADDING = CFG.PADD;
    }

    public static final void resetAnimation_2() {
        ANIMATION_TIME = System.currentTimeMillis();
        ANIMATION_ALPHA = 0.3f;
        ANIMATION_PADDING = CFG.PADD;
    }

    public ME_Hover_v2(List<MEHover_2E> nElements) {
        int i;
        this.lElements = nElements;
        this.iElementsSize = this.lElements.size();
        this.iWidth = 0;
        for (i = 0; i < this.iElementsSize; ++i) {
            if (this.lElements.get(i).getWidth() <= CFG.GAMEWIDTH - CFG.PADD * 2 || this.lElements.get(i).getWidth() - CFG.GAMEWIDTH - CFG.PADD * 2 <= this.iWidthOver) continue;
            this.iWidthOver = this.lElements.get(i).getWidth() - CFG.GAMEWIDTH - CFG.PADD * 2;
        }
        if (this.iWidthOver > 0) {
            this.iScrollPosX = this.iWidthOver + CFG.PADD * 10;
            this.lTime = System.currentTimeMillis();
        }
        for (i = 0; i < this.iElementsSize; ++i) {
            if (this.lElements.get(i).getWidth() <= this.iWidth) continue;
            this.iWidth = this.lElements.get(i).getWidth();
        }
        for (i = 0; i < this.iElementsSize; ++i) {
            if (this.lElements.get(i).getWidth() <= this.iMaxWidth) continue;
            this.iMaxWidth = this.lElements.get(i).getWidth();
        }
        this.iWidth += CFG.PADD * 6;
        this.iHeight = CFG.PADD * 4;
        for (i = 0; i < this.iElementsSize; ++i) {
            this.iHeight += this.lElements.get(i).getHeight() + CFG.PADD;
        }
        this.iHeight -= CFG.PADD * 2;
    }

    @Override
    public final void draw(SpriteBatch oSB, int nPosX, int nPosY) {
        if ((nPosX = (int)((float)nPosX + ANIMATION_PADDING)) + this.iWidth > CFG.GAMEWIDTH - CFG.PADD) {
            nPosX = CFG.GAMEWIDTH - this.iWidth - CFG.PADD;
        }
        if (nPosY < 0) {
            nPosY = CFG.PADD;
        } else if (nPosY + this.iHeight > CFG.GAMEHEIGHT) {
            nPosY = CFG.GAMEHEIGHT - this.iHeight - CFG.PADD;
        }
        this.drawHover(oSB, nPosX, nPosY);
    }

    @Override
    public final void drawAlwaysOverM(SpriteBatch oSB, int nPosX, int nPosY) {
        nPosX = (int)((float)nPosX + ANIMATION_PADDING);
        nPosY = nPosY - this.iHeight - CFG.PADD;
        if ((nPosX += CFG.PADD) + this.iWidth > CFG.GAMEWIDTH - CFG.PADD) {
            nPosX = CFG.GAMEWIDTH - this.iWidth - CFG.PADD;
        }
        if (nPosY < 0) {
            nPosY = CFG.PADD;
        } else if (nPosY + this.iHeight > CFG.GAMEHEIGHT) {
            nPosY = CFG.GAMEHEIGHT - this.iHeight - CFG.PADD;
        }
        this.drawHover(oSB, nPosX, nPosY);
    }

    @Override
    public final void drawAlwaysOverMobile(SpriteBatch oSB, int nPosX, int nPosY) {
        nPosX = (int)((float)nPosX + ANIMATION_PADDING);
        nPosY = nPosY - this.iHeight - CFG.PADD * 4;
        if ((nPosX -= this.iWidth / 4) < CFG.PADD) {
            nPosX = CFG.PADD;
        }
        if (nPosX + this.iWidth > CFG.GAMEWIDTH - CFG.PADD) {
            nPosX = CFG.GAMEWIDTH - this.iWidth - CFG.PADD;
        }
        if (nPosY < 0) {
            nPosY = CFG.PADD;
        } else if (nPosY + this.iHeight > CFG.GAMEHEIGHT) {
            nPosY = CFG.GAMEHEIGHT - this.iHeight - CFG.PADD;
        }
        this.drawHover(oSB, nPosX, nPosY);
    }

    @Override
    public final void drawAlwaysBelowMEH(SpriteBatch oSB, int nPosX, int nPosY) {
        nPosX = (int)((float)nPosX + ANIMATION_PADDING);
        nPosY += CFG.PADD;
        if ((nPosX += CFG.PADD) + this.iWidth > CFG.GAMEWIDTH - CFG.PADD) {
            nPosX = CFG.GAMEWIDTH - this.iWidth - CFG.PADD;
        }
        if (nPosY < 0) {
            nPosY = CFG.PADD;
        } else if (nPosY + this.iHeight > CFG.GAMEHEIGHT) {
            nPosY = CFG.GAMEHEIGHT - this.iHeight - CFG.PADD;
        }
        this.drawHover(oSB, nPosX, nPosY);
    }

    @Override
    public final void drawProvinceInfo(SpriteBatch oSB, int nPosX, int nPosY) {
        nPosX = (int)((float)nPosX + ANIMATION_PADDING);
        this.drawHover(oSB, nPosX, nPosY);
    }

    public final int getScrollPosX() {
        if (this.iWidthOver > 0) {
            if (this.backAnimation) {
                if (this.lTime + 1500L < System.currentTimeMillis() && this.iScrollPosX-- < -CFG.PADD) {
                    this.backAnimation = !this.backAnimation;
                    this.lTime = System.currentTimeMillis();
                }
            } else if (this.lTime + 1000L < System.currentTimeMillis() && this.iScrollPosX++ > this.iWidthOver + CFG.PADD * 10) {
                this.backAnimation = !this.backAnimation;
                this.lTime = System.currentTimeMillis();
            }
            CFG.setRenderO(true);
            return this.iScrollPosX;
        }
        return 0;
    }

    @Override
    public final void drawHover(SpriteBatch oSB, int nPosX, int nPosY) {
        int tempScrollX = this.getScrollPosX();
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ANIMATION_ALPHA));
        CFG.drawRect_NewGameBoxDefault(oSB, nPosX + tempScrollX, nPosY, this.iWidth, this.iHeight);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.15f * ANIMATION_ALPHA));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + tempScrollX, nPosY + 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iWidth, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + tempScrollX, nPosY + this.iHeight - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iWidth, 1);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, ANIMATION_ALPHA));
        nPosY += CFG.PADD;
        for (int i = 0; i < this.iElementsSize; ++i) {
            this.lElements.get(i).draw(oSB, nPosX + tempScrollX + CFG.PADD * 3, nPosY, ANIMATION_ALPHA, this.iMaxWidth);
            nPosY += CFG.PADD + this.lElements.get(i).getHeight();
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void drawHoverWithoutAnim(SpriteBatch oSB, int nPosX, int nPosY) {
        int tempScrollX = this.getScrollPosX();
        if (nPosY + this.iHeight > CFG.GAMEHEIGHT - CFG.PADD * 2) {
            nPosY = CFG.GAMEHEIGHT - CFG.PADD * 2 - this.iHeight;
        }
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        CFG.drawRect_NewGameBoxEDGE(oSB, nPosX + tempScrollX, nPosY, this.iWidth, this.iHeight);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.15f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + tempScrollX, nPosY + 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iWidth, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + tempScrollX, nPosY + this.iHeight - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.iWidth, 1);
        nPosY += CFG.PADD;
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        for (int i = 0; i < this.iElementsSize; ++i) {
            this.lElements.get(i).draw(oSB, nPosX + tempScrollX + CFG.PADD * 3, nPosY, 1.0f, this.iMaxWidth);
            nPosY += CFG.PADD + this.lElements.get(i).getHeight();
        }
        oSB.setColor(Color.WHITE);
    }

    static {
        ANIMATION_INTERVAL = 2450;
    }
}

