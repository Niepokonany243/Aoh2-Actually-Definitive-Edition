
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_Classic_ReflectedCheckbox
extends Button_Classic_Classic {
    public Button_Classic_Classic_ReflectedCheckbox(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_Classic_ReflectedCheckbox(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Classic_Classic_ReflectedCheckbox.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.25f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.25f));
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Classic_Classic_ReflectedCheckbox.this.getPosXE() + Button_Classic_Classic_ReflectedCheckbox.this.getWidthE() - Button_Classic_Classic_ReflectedCheckbox.this.getWidthE() / 4 + iTranslateX, Button_Classic_Classic_ReflectedCheckbox.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Classic_Classic_ReflectedCheckbox.this.getWidthE() / 4, Button_Classic_Classic_ReflectedCheckbox.this.getHeightE() - 2, true, false);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }
}

