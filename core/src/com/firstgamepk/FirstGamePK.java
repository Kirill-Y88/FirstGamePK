package com.firstgamepk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstGamePK extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img2;
	float point = 0f;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		img2 = new Texture("fil.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f, 0.6f, 0.4f, 1);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img2, 0, 0, 736, 736);
		batch.setColor(0.2f, 0.3f, 0.4f, 1f);
		batch.draw(img, 100, 100);
		batch.setColor(0.9f, 0.3f, 0.4f, 0.5f);
		batch.draw(img, 330, 330, 100, 100);
		batch.draw(img, point, point);
		batch.end();
		point += 1;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}