package com.firstgamepk.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.firstgamepk.base.BaseButton;
import com.firstgamepk.math.Rect;

public class GameOver extends BaseButton {
    private static final float MARGIN = 0.025f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setTop(worldBounds.getHalfHeight()-MARGIN);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
