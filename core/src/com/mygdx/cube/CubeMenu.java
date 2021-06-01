package com.mygdx.cube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CubeMenu implements Screen {

    public static Cube cube;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    public static CubeGame cubeGame = new CubeGame();

    public static int width;
    public static int height;

    private Texture Background, startbutton, MinicubeTexture, highscore, ExitButton;
    private minicube minicube1, minicube2;


    public CubeMenu(Cube cube) {
        CubeMenu.cube = cube;

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        batch = new SpriteBatch();

        Background = new Texture("Background.jpg");
        startbutton = new Texture("startbutton.png");
        MinicubeTexture = new Texture("minicube.png");
        highscore = new Texture("highscore.png");
        ExitButton = new Texture("ExitButton.png");
        minicube1 = new minicube(100,100, (byte)1);
        minicube2 = new minicube(width-500,50, (byte)4);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();

            batch.draw(Background, 0, 0, width, height);
            batch.draw(MinicubeTexture, minicube1.x, minicube1.y);
            batch.draw(MinicubeTexture, minicube2.x, minicube2.y);
            batch.draw(startbutton, width/2f - 200, height/2f);
            batch.draw(highscore, width/2f-200,height/2f - 250);
            batch.draw(ExitButton, width/2f-200, height/2f - 470);


        batch.end();

        minicube1.setMove();
        minicube2.setMove();
        if(minicube1.ifCrash(minicube2)) {
            minicube1.reflectMoving();
            minicube2.reflectMoving();
        }

        if(Gdx.input.isTouched()){
            int x, y;
            x = Gdx.input.getX();
            y = Gdx.input.getY();

            if(x>width/2-200 & x<width/2+200 & y>height/2-150 & y<height/2+100){
                cubeGame.create();
                if(CubeGame.HintOn) {
                    cube.setScreen(new HintScreen(0));
                }else{
                    CubeGame.Broken = false;
                    cube.setScreen(new CubeScreen(cubeGame));
                }
            }else if(x>width/2-200 & x<width/2+200 & y<height/2+350 & y>height/2+150){
                cube.setScreen(new HighScoreScreen());
            }
            else if (x>width/2-200 & x<width/2+200 & y<height/2+570 & y>height/2+370){
                Gdx.app.exit();
            }
            else {
                minicube1.tap(x,y);
                minicube2.tap(x,y);
            }
        }


    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        CubeMenu.height = height;
        CubeMenu.width = width;
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
        Background.dispose();
        startbutton.dispose();
        batch.dispose();
        MinicubeTexture.dispose();
    }
}
