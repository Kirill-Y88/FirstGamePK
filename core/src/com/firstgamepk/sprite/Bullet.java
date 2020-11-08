package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.firstgamepk.base.Sprite;
import com.firstgamepk.math.Rect;

public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 v;
    private int damage;
    private Sprite owner;
    private float procent;

    public Bullet() {
        v = new Vector2();
        regions = new TextureRegion[1];
        procent = (float)Math.random();
    }

    public void set(
            Sprite owner,
            TextureRegion region,
            Vector2 pos,
            Vector2 v,
            Rect worldBounds,
            int damage,
            float height
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos);
        this.v.set(v);
        this.worldBounds = worldBounds;
        this.damage = damage;
        setHeightProportion(height);
    }

    @Override
    public void update(float delta) {
    if(v.y > 0f) {
        this.pos.mulAdd(v.scl(1.0f), delta);
        if (isOutside(worldBounds)) {
        destroy();
        }
    }else {
        if(procent > 0.75){
        this.pos.mulAdd(v.scl(1.02f), delta);
        }else {
            this.pos.mulAdd(v.scl(1.0f), delta);
        }
        if (isOutside(worldBounds)) {
            destroy();
        }

    }

    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
