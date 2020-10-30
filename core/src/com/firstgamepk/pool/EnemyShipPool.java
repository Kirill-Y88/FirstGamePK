package com.firstgamepk.pool;

import com.firstgamepk.math.Rect;
import com.firstgamepk.sprite.EnemyShip;
import com.firstgamepk.base.SpritesPool;

public class EnemyShipPool extends SpritesPool<EnemyShip> {

    private BulletPool bulletPool;
    private Rect worldBounds;

    public EnemyShipPool(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, worldBounds);
    }
}