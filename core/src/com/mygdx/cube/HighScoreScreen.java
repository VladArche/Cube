package com.mygdx.cube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class HighScoreScreen implements Screen {

    public OrthographicCamera camera;
    public SpriteBatch Batch;
    public static Preferences prefs;
    public BitmapFont font;
    public Texture Background;
    public Object[] values;

    public HighScoreScreen(){

        prefs = Gdx.app.getPreferences("HighScoreScreen");
        font = new BitmapFont();
        font.getData().setScale(4);
        camera = new OrthographicCamera();
        camera.setToOrtho(true, CubeMenu.width, CubeMenu.height);
        Batch = new SpriteBatch();
        Background = new Texture("HighScoreBackground.png");

        values = prefs.get().values().toArray();
        Arrays.sort(values);
    }


    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        Batch.begin();

        Batch.draw(Background,0,0, CubeMenu.width, CubeMenu.height);
        for (int i = 0; i < Math.min(10, values.length); i++) {
            int score = (int) values[i];
            font.draw(Batch,score/60+"min "+score%60+"sec", CubeMenu.width/2f-130, CubeMenu.height-150-90*i);
        }

        Batch.end();

        if(Gdx.input.isTouched()){
            CubeMenu.cube.setScreen(new CubeMenu(CubeMenu.cube));
        }

    }

    @Override
    public void resize(int width, int height) {

    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {
        Batch.dispose();
        font.dispose();
    }
}
