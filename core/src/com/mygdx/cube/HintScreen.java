package com.mygdx.cube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HintScreen implements Screen {

    public OrthographicCamera camera;
    public SpriteBatch Batch;
    public Texture Background;
    private BitmapFont font = new BitmapFont();

    public static int width;
    public static int height;
    public int seconds = 0, minutes = 0;
    public int level;

    public HintScreen(int level){
        this.level = level;
        font.setColor(Color.WHITE);
        font.getData().setScale(6);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        Batch = new SpriteBatch();

        switch (level) {
            case 5: {
                Background = new Texture("level7.png");
                GetSecondsAndMinutes((System.currentTimeMillis() - CubeGame.time));
                if(HighScoreScreen.prefs == null){
                    HighScoreScreen.prefs = Gdx.app.getPreferences("HighScoreScreen");
                }
                int time = GetTime(seconds,minutes);
                HighScoreScreen.prefs.putInteger(Integer.toString(time),time);
                HighScoreScreen.prefs.flush();

            }break;
            case 0:{
                Background = new Texture("level0.png");
            }break;
            case 1:{
                Background = new Texture("level1.png");
            }break;
            case 2:{
                Background = new Texture("level2.png");
            }break;
            case 3:{
                Background = new Texture("level3.png");
            }break;
            case 4:{
                Background = new Texture("level5.png");
            }break;
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        Batch.begin();

        Batch.draw(Background,0,0);
        if(seconds != 0 || minutes != 0){
            font.draw(Batch, minutes+" min : " + seconds+" sec", width/3f, height/4f-50);
        }

        Batch.end();

        if(Gdx.input.isTouched()){
            if(level == 5) {
                CubeScreen.level = 0;
                CubeMenu.cube.setScreen(new CubeMenu(CubeMenu.cube));
            }
            else if (level == 3){
                Background = new Texture("level4.png");
                level = 6;
            }
            else if (level == 4){
                Background = new Texture("level6.png");
                level = 6;
            }
            else{
                CubeMenu.cube.setScreen(new CubeScreen(CubeMenu.cubeGame));
            }
        }else if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            CubeMenu.cube.setScreen(new CubeScreen(CubeMenu.cubeGame));
        }

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        HintScreen.height = height;
        HintScreen.width = width;
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
        Background.dispose();
    }

    public static int GetTime(int seconds, int minutes){
        return seconds + minutes*60;
    }
    public void GetSecondsAndMinutes(long time){
        this.minutes = (int) (time/60)/1000;
        this.seconds = (int) (time/1000%60);
    }

}
