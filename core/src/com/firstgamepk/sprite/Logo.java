package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.Sprite;
import com.firstgamepk.math.Rect;

public class Logo extends Sprite {

    private static final float V_LEN = 0.01f;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;

    public Logo(Texture region) {
        super(new TextureRegion(region));
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
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
}