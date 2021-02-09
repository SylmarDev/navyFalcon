package com.sylmardev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Game extends ApplicationAdapter {
	private Stage stage;

	private Table table;
	private TextButton startButton;
	private TextButton quitButton;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
		Skin skin = new Skin(Gdx.files.internal("skin/files/uiskin.json"));

		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center);

		table.setPosition(0, Gdx.graphics.getHeight()/2);

		startButton = new TextButton("New Game", skin, "default");
        startButton.setWidth(500);
        startButton.setHeight(50);

		quitButton = new TextButton("Quit Game", skin);
        quitButton.setWidth(200);
        quitButton.setHeight(50);

        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                System.exit(0);
            }
        });

		table.add(startButton).pad(10);
		table.row();
		table.add(quitButton).pad(10);

		stage.addActor(table);

		Gdx.input.setInputProcessor(stage); // re-set input processor whenever stage changes
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}
	
	@Override
	public void dispose () {

	}
}
