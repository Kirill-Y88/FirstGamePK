package com.firstgamepk.utils;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.firstgamepk.base.EnemySettingsDto;
import com.firstgamepk.dto.EnemyBigSettingsDto;
import com.firstgamepk.dto.EnemyMediumSettingsDto;
import com.firstgamepk.dto.EnemySmallSettingsDto;
import com.firstgamepk.math.Rect;
import com.firstgamepk.math.Rnd;
import com.firstgamepk.pool.EnemyShipPool;
import com.firstgamepk.sprite.EnemyShip;

public class EnemyEmitter {

    private static final float GENERATE_INTERVAL = 4f;

    private Rect worldBounds;
    private EnemyShipPool enemyShipPool;
    private float generateTimer;

    private EnemySettingsDto enemySmallSettingsDto;
    private EnemySettingsDto enemyMediumSettingsDto;
    private EnemySettingsDto enemyBigSettingsDto;

    private int level = 1;

    public EnemyEmitter(Rect worldBounds, EnemyShipPool enemyShipPool, Sound bulletSound, TextureAtlas atlas) {
        this.worldBounds = worldBounds;
        this.enemyShipPool = enemyShipPool;
        enemySmallSettingsDto = new EnemySmallSettingsDto(atlas, bulletSound);
        enemyMediumSettingsDto = new EnemyMediumSettingsDto(atlas, bulletSound);
        enemyBigSettingsDto = new EnemyBigSettingsDto(atlas, bulletSound);
    }

    public int getLevel() {
        return level;
    }

    public void generate(float delta, int frags) {
        level = frags / 10 + 1;
        generateTimer += delta;
        if (generateTimer >= GENERATE_INTERVAL) {
            generateTimer = 0;
            EnemyShip enemyShip = enemyShipPool.obtain();
            float type = (float) Math.random();
            if (type < 0.5f) {
                enemySmallSettingsDto.setDamageForLevel(level);
                enemyShip.set(enemySmallSettingsDto);
            } else if (type < 0.8f) {
                enemyMediumSettingsDto.setDamageForLevel(level);
                enemyShip.set(enemyMediumSettingsDto);
            } else {
                enemyBigSettingsDto.setDamageForLevel(level);
                enemyShip.set(enemyBigSettingsDto);
            }
            enemyShip.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemyShip.getHalfWidth(), worldBounds.getRight() - enemyShip.getHalfWidth());
            enemyShip.setBottom(worldBounds.getTop());
        }


    }
}
