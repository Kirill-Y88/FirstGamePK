package com.firstgamepk.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Vector2 pos;
    private Vector2 pos2;
    private Vector2 speed;
    private float fps = 0.01f;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 19) pos.add(0, 1);
        if(keycode == 20) pos.add(0, -1);
        if(keycode == 21) pos.add(-1, 0);
        if(keycode == 22) pos.add(1, 0);
        return super.keyDown(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pos2.set(screenX, Gdx.graphics.getHeight()- screenY);  //Gdx.graphics.getHeight() - Начало координат у сетки отображения и сетки событий различно(Левый верхний и нижний углы)
        //поэтому приводим систему к едино системе координат
        return super.touchDown(screenX, screenY, pointer, button);
    }

    private Texture img2;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        img2 = new Texture("fil.jpg");
        pos = new Vector2(100, 100);
        pos2 = new Vector2(pos);
        speed = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        movePicture();
        batch.begin();
        batch.draw(img2, 0, 0, 736, 736);
        batch.draw(img, pos.x, pos.y);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public void movePicture (){
        if (Math.abs(pos.len() - pos2.len())>1.0f) {
            /*System.out.println("pos"+pos);
            System.out.println("pos2"+pos2);
            System.out.println("speed"+speed);
            System.out.println("pos.len() - pos2.len()" +(pos.len() - pos2.len()));*/
            speed = (new Vector2(pos2)).sub(pos).scl(fps);
            pos.add(speed);
        }


    }
}