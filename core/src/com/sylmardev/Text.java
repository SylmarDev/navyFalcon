package com.sylmardev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Text extends Actor {
    private final String text;
    private final BitmapFont bitmapfont;

    public Text(String text) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/berkshireswash-regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 42;
        // parameter.color = Color.WHITE;
        bitmapfont = generator.generateFont(parameter);
        generator.dispose();

        this.text = text;
        // bitmapfont.getData().setScale(0.4f, 0.4f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bitmapfont.draw(batch, text, 100, 100);
    }
}
