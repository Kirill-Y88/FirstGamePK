package com.firstgamepk.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.BaseScreen;
import com.firstgamepk.math.Rect;
import com.firstgamepk.sprite.Background;
import com.firstgamepk.sprite.Logo;
import com.firstgamepk.sprite.Star;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Texture img;
    private Logo logo;
    private TextureAtlas atlas;
    private static final int STAR_COUNT = 256;
    private Star[] stars;

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("menuAtlas.tpack");
        bg = new Texture("bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i] = new Star(atlas);
        }
        img = new Texture("badlogic.jpg");
        logo = new Logo(img);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logo.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        img.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        logo.update(delta);
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        batch.end();
    }
}