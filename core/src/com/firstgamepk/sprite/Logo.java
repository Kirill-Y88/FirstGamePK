package com.firstgamepk.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.Sprite;
import com.firstgamepk.math.Rect;

public class Logo extends Sprite {
    private Vector2 vlogo = new Vector2();
    private Vector2 tmp;

    public Logo(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight()*0.2f);
    }

    public void getTouch(Vector2 touch){
        vlogo = touch;
        tmp = (new Vector2((vlogo)).sub(pos).scl(0.05f));

    }
    public void movieLogo(){
        if(Math.abs(pos.len()-vlogo.len())>= 0.01f){
            pos.add(tmp);
        }
    }

}
