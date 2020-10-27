package com.firstgamepk.pool;


import com.firstgamepk.base.SpritesPool;
import com.firstgamepk.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
