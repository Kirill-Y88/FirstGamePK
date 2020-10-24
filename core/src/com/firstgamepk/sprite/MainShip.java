package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.Sprite;
import com.firstgamepk.math.Rect;

public class MainShip extends Sprite {

    private static final float V_LEN = 0.01f;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;
    private Rect worldBounds;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom());
        this.worldBounds = worldBounds;
    }

    public void update(float delta) {
        tmp.set(touch);
        if (tmp.sub(pos).len() <= V_LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.sub(pos).setLength(V_LEN));
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        this.touch.set(pos);
        return false;
    }

    public boolean keyDown(int keycode) {
        switch (keycode){
            case 19: this.touch.set(pos.x, worldBounds.getTop());
                break;
            case 20: this.touch.set(pos.x, worldBounds.getBottom());
                break;
            case 21: this.touch.set(worldBounds.getLeft(), pos.y);
                break;
            case 22: this.touch.set(worldBounds.getRight(), pos.y);
                break;
        }
        v.set(touch.sub(pos).setLength(V_LEN));
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode){
            case 19: this.touch.set(pos);
                break;
            case 20: this.touch.set(pos);
                break;
            case 21: this.touch.set(pos);
                break;
            case 22: this.touch.set(pos);
                break;

        }
        return false;
    }

}
