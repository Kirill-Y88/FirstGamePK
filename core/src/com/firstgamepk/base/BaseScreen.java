package com.firstgamepk.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.firstgamepk.math.MatrixUtils;
import com.firstgamepk.math.Rect;

import javax.swing.plaf.BorderUIResource;

public class BaseScreen implements Screen, InputProcessor {
    protected SpriteBatch batch;
    private Rect screenBounds;  //прямоугольник для описания координат в пикселях (которые по умолчанию)
    private Rect wordBounds;  //мировая система координат (наша)
    private Rect glBounds;  //система координат openGL

    private Matrix4 worldToGl; //матрица для проецирования из wordBound в glBounds
    private Matrix3 screenToWorld; // матрица для обработки событий
    private Vector2 touch;

    @Override
    public void show() {   //срабатывает при открытии экрана
        System.out.println("show must go on!");
        batch = new SpriteBatch();
        //batch.getProjectionMatrix().idt(); // вызываем матрицу Matrix4 и приводим ее к единичной (idt())
        screenBounds = new Rect();
        wordBounds = new Rect();
        glBounds = new Rect(0,0,1f,1f);
        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();
        touch = new Vector2();

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
        screenBounds.setSize(width,height); //передаем актуальные параметры окна
        screenBounds.setLeft(0);  // смещаем точку в левый нижний угол
        screenBounds.setBottom(0);

        float aspect = width/(float)height;
        wordBounds.setHeight(1);
        wordBounds.setWidth(1f*aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, wordBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, wordBounds);
        resize(wordBounds);
    }


    public void resize(Rect wordBounds) {
        System.out.println("int width, int height = " + wordBounds.getWidth() + wordBounds.getHeight() );
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
        touch.set(screenX, Gdx.graphics.getHeight() - screenY).mul(screenToWorld); //умножаем вектор на заданную мматрицу и переводим его в мировую систему координат
        touchDown(touch, pointer, button);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {  //нажатие клавиши мыши/прикосновения (координаты, pointer - параметры мультитача, button номер кнопки при использовании мыши)
        System.out.println("touchUp touchX = " + touch.x + " touchY = " + touch.x);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY).mul(screenToWorld);
        touchUp(touch, pointer, button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        System.out.println("touchUp touch.X = " + touch.x + " touch.Y = " + touch.y);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged screenX = " + screenX + " screenY = " + screenY);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY).mul(screenToWorld);
        touchDragged(touch, pointer);
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        System.out.println("touchDragged touch.X = " + touch.x + " touch.Y = " + touch.y);
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