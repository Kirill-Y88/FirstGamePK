package com.firstgamepk.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.base.BaseScreen;
import com.firstgamepk.math.Rect;
import com.firstgamepk.sprite.Background;
import com.firstgamepk.sprite.Logo;

public class MenuScreen extends BaseScreen {
    //private Texture img;
   // private Vector2 pos;
    private Texture bg;
    private Texture lg;
    private Logo logo;
    private Background background;


    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
          //Gdx.graphics.getHeight() - Начало координат у сетки отображения и сетки событий различно(Левый верхний и нижний углы)
        //поэтому приводим систему к едино системе координат
        return super.touchDown(screenX, screenY, pointer, button);
    }

   // private Texture img2;

    @Override
    public void show() {
        super.show();
        bg = new Texture("bg.png");
        background = new Background(new TextureRegion(bg));
        lg = new Texture("badlogic.jpg");
        logo = new Logo(new TextureRegion(lg));
        //img = new Texture("badlogic.jpg");
        //img2 = new Texture("fil.jpg");
       // pos = new Vector2(-0.5f, -0.5f);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        logo.movieLogo();
        batch.end();

    }

    @Override
    public void resize(Rect wordBounds) {
        background.resize(wordBounds);
        logo.resize(wordBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        lg.dispose();
        super.dispose();
    }
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.getTouch(touch);
        return false;
    }

}