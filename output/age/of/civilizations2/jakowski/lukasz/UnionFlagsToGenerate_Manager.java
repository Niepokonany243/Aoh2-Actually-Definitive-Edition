
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class UnionFlagsToGenerate_Manager {
    public List<Image> lFlags_Small = new ArrayList<Image>();
    public List<Image> lFlags_H = new ArrayList<Image>();
    public List<UnionFlagsToGenerate> lFlags = new ArrayList<UnionFlagsToGenerate>();
    public List<Integer> lCivs_FlagsToLoad = new ArrayList<Integer>();

    public UnionFlagsToGenerate_Manager() {
        this.loadImages();
    }

    public final void generateFlags(SpriteBatch oSB) {
        try {
            while (!(CFG.menus.getInGameView() && CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS || this.lFlags.size() <= 0)) {
                if (this.lFlags.get(0).generateFlag(oSB)) {
                    this.lFlags.remove(0);
                    continue;
                }
                return;
            }
            while (!(CFG.menus.getInGameView() && CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS || this.lCivs_FlagsToLoad.size() <= 0)) {
                block13: {
                    try {
                        if (CFG.core.getCiv(this.lCivs_FlagsToLoad.get(0)).loadFlag()) {
                            if (CFG.core.getCiv(this.lCivs_FlagsToLoad.get(0)).getIsPlayer()) {
                                CFG.core.getPlayer(CFG.core.getPlayerIDbyCivID(this.lCivs_FlagsToLoad.get(0))).loadPlayersFlag();
                            }
                            break block13;
                        }
                        return;
                    }
                    catch (IndexOutOfBoundsException ex) {
                        try {
                            this.lCivs_FlagsToLoad.remove(0);
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                        return;
                    }
                    catch (Exception ex) {
                        this.lCivs_FlagsToLoad.remove(0);
                        return;
                    }
                }
                if (CFG.core.getCiv(this.lCivs_FlagsToLoad.get(0)).getFlag_IsNull()) {
                    return;
                }
                this.lCivs_FlagsToLoad.remove(0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void loadImages() {
        for (int i = 0; i < 4; ++i) {
            this.lFlags_Small.add(new Image(new Texture(Gdx.files.internal("game/unions/union_0_" + i + ".png")), Texture.TextureFilter.Nearest));
            this.lFlags_H.add(new Image(new Texture(Gdx.files.internal("game/unions/unionH_0_" + i + ".png")), Texture.TextureFilter.Nearest));
        }
    }

    public final void addFlagToLoad(int nCivID) {
        for (int i = this.lCivs_FlagsToLoad.size() - 1; i >= 0; --i) {
            if (this.lCivs_FlagsToLoad.get(i) != nCivID) continue;
            return;
        }
        this.lCivs_FlagsToLoad.add(nCivID);
    }
}

