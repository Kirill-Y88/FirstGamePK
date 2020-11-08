package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.firstgamepk.base.BaseButton;
import com.firstgamepk.screen.GameScreen;

public class ButtonNewGame extends BaseButton {

    private static final float HEIGHT = 0.05f;
    private static final float TOP_MARGIN = -0.012f;

    private GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(HEIGHT);
        setTop(TOP_MARGIN);
        this.gameScreen = gameScreen;
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
