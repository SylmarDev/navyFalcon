package com.sylmardev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
		Skin skin = new Skin(Gdx.files.internal("skin/files/uiskin.json"));

		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center|Align.top);

		table.setPosition(0, Gdx.graphics.getHeight());

		startButton = new TextButton("New Game", skin);
		quitButton = new TextButton("Quit Game", skin);

		table.add(startButton);
		table.add(quitButton);

		stage.addActor(table);

		Text title = new Text("Navy Falcon");
		stage.addActor(title);

		final TextButton button = new TextButton("Click Me", skin, "default");
		button.setWidth(200);
		button.setHeight(50);

		final Dialog dialog = new Dialog("Click Message", skin);

		button.addListener(new ClickListener() { // none of this works like its supposed to
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dialog.show(stage);
				Timer.schedule(new Timer.Task() {
					@Override
					public void run() {
						dialog.hide();
					}
				}, 5);
			}
		});

		stage.addActor(button);
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
