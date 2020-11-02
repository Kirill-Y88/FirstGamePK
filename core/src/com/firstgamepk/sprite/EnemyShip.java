package com.firstgamepk.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.firstgamepk.base.Ship;
import com.firstgamepk.base.EnemySettingsDto;
import com.firstgamepk.math.Rect;
import com.firstgamepk.pool.BulletPool;

public class EnemyShip extends Ship {

    int firecount = 0;

     public EnemyShip(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;

    }
/*  предыдущая версия метода
    @Override
    public void update(float delta) {
        bulletPos.set(pos.x, getBottom());
        super.update(delta);
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }
*/

// Версия метода без вызова метода апдейт суперкласса в данном классе
    @Override
    public void update(float delta) {
        bulletPos.set(pos.x, getBottom());

        if(pos.y<= 0.45f){
            pos.mulAdd(v, delta);
        } else pos.mulAdd(v0, delta);
            reloadTimer += delta;

            if (reloadTimer >= 1.0f/reloadInterval) {
                reloadTimer = 0;
                firecount++;
                if (firecount > 2)  {
                    firecount = 0;
                    super.shoot();
                }
            }

        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }




    public void set(EnemySettingsDto settings) {
        this.regions = settings.getRegions();
        this.v.set(settings.getV0());
        this.v0.set(settings.getV0().scl(2.0f*(float)settings.getHp()));
        this.bulletRegion = settings.getBulletRegion();
        this.bulletHeight = settings.getBulletHeight();
        this.bulletV.set(settings.getBulletV());
        this.bulletSound = settings.getBulletSound();
        this.damage = settings.getDamage();
        this.reloadInterval = settings.getReloadInterval();
        setHeightProportion(settings.getHeight());
        this.hp = settings.getHp();
    }

}
