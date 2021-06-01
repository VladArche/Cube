package com.mygdx.cube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseScreen implements Screen {

    public OrthographicCamera camera;
    public Texture Background;
    public SpriteBatch Batch;

    private Stage stage;
    private Texture BackButtonTexture, MenuButtonTexture, HintOn,HintOff, BreakTexture;

    public PauseScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CubeMenu.width, CubeMenu.height);
        Gdx.input.setCatchBackKey(true);
        Batch = new SpriteBatch();

        Background = new Texture("PauseBackground.png");

        BackButtonTexture = new Texture("BackButton.png");
        ImageButton backButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(BackButtonTexture)));
        backButton.setPosition(CubeMenu.width/2f-500, CubeMenu.height/2f+100);
        backButton.addListener(new ClickListener(){
            @Override public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                CubeMenu.cube.setScreen(new CubeScreen(CubeMenu.cubeGame));
                return true;
            }
        });
        MenuButtonTexture = new Texture("MenuButton.png");
        ImageButton menuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(MenuButtonTexture)));
        menuButton.setPosition(CubeMenu.width/2f-500, CubeMenu.height/2f-300);
        menuButton.addListener(new ClickListener(){
            @Override public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                CubeMenu.cube.setScreen(new CubeMenu(CubeMenu.cube));
                return true;
            }
        });
        HintOn = new Texture("HintOn.png");
        HintOff = new Texture("HintOff.png");
        TextureRegionDrawable On = new TextureRegionDrawable(new TextureRegion(HintOn));
        TextureRegionDrawable Off = new TextureRegionDrawable(new TextureRegion(HintOff));
        ImageButton hintButton = new ImageButton((CubeGame.HintOn ? Off : On),(CubeGame.HintOn ? Off : On),(CubeGame.HintOn ? On : Off));
        hintButton.setPosition(CubeMenu.width/2f+100, CubeMenu.height/2f-300);
        hintButton.addListener(new ClickListener(){
            @Override public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                CubeGame.HintOn = !CubeGame.HintOn;
                return true;
            }
        });
        BreakTexture = new Texture("Break.png");
        ImageButton breakButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(BreakTexture)));
        breakButton.setPosition(CubeMenu.width/2f+100,CubeMenu.height/2f+100);
        breakButton.addListener(new ClickListener(){
            @Override public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                CubeScreen.sideRotations.Break();
                CubeGame.Broken = true;
                CubeMenu.cube.setScreen(new CubeScreen(CubeMenu.cubeGame));
                return true;
            }
        });

        stage = new Stage(new ScreenViewport());
        stage.addActor(backButton);
        stage.addActor(menuButton);
        stage.addActor(hintButton);
        stage.addActor(breakButton);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        Batch.begin();
        Batch.draw(Background,0,0, CubeMenu.width,CubeMenu.height);
        Batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            CubeMenu.cube.setScreen(new CubeScreen(CubeMenu.cubeGame));
        }

    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void show() {}

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        Background.dispose();
        stage.dispose();
        BackButtonTexture.dispose();
        HintOff.dispose();
        HintOn.dispose();
        MenuButtonTexture.dispose();
        BreakTexture.dispose();
    }
}
