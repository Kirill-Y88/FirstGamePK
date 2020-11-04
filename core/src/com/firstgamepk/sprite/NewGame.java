package com.firstgamepk.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.firstgamepk.FirstGamePK;
import com.firstgamepk.base.BaseButton;

import com.firstgamepk.math.Rect;
import com.firstgamepk.screen.MenuScreen;

public class NewGame extends BaseButton {
    private static final float MARGIN = 0.25f;
    private Game game;

    public NewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setTop(worldBounds.getHalfHeight()-MARGIN);
    }

    @Override
    public void action() {
        System.out.println("newwwwww");
        game.setScreen(new MenuScreen(game));
    }
}