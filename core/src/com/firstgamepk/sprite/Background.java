package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.firstgamepk.base.Sprite;
import com.firstgamepk.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
         //Выравниваем наш фон и задаем ему высоту равную высоте экрана
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
