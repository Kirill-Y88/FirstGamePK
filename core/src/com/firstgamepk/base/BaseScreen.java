package com.firstgamepk.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {
    protected SpriteBatch batch;

    @Override
    public void show() {   //срабатывает при открытии экрана
        System.out.println("show must go on!");
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this); //передаем в LibGDX класс BaseScreen, т.е. класс которы является "InputProcessor"(пользовательские методы)
    }

    @Override
    public void render(float delta) {   //работает 60раз в секунду,
        Gdx.gl.glClearColor(0.2f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {  //срабатывает сразу после метода show
        System.out.println("int width, int height = " + width + height);
    }

    @Override
    public void pause() {  // срабатывает при сворачивании экрана
        System.out.println("pause!");
    }

    @Override
    public void resume() {  // срабатывает при разворачивании экрана
        System.out.println("resume");
    }

    @Override
    public void hide() { //срабатывает при закрытии экрана
        System.out.println("hide");
        dispose();
    }

    @Override
    public void dispose() {  //метод не вызывается из LibGDX поэтому его нужно вызывать вручную
        System.out.println("dispose");
        batch.dispose();
    }
////
    @Override
    public boolean keyDown(int keycode) {   //нажатие клавиши, keycode - код клавиши
        System.out.println("keyDown keycode = " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {   //отпускание клавиши
        System.out.println("keyUp keycode = " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {  //фиксация факта нажатия кнопки и возврат символа кнопки
        System.out.println("keyTyped character = " + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {  //нажатие клавиши мыши/прикосновения (координаты, pointer - параметры мультитача, button номер кнопки при использовании мыши)
        System.out.println("touchDown screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) { //убрали палец, отпустили мышь
        System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {  //коснулись пальцем экрана и протащили
        System.out.println("touchDragged screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) { //любое движение мыши
        return false;
    }

    @Override
    public boolean scrolled(int amount) {  //скролл вверх/низ
        System.out.println("scrolled amount = " + amount);
        return false;
    }
}
