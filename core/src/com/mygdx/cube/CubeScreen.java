package com.mygdx.cube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CubeScreen implements Screen {

    public static SideRotations sideRotations;
    public CubeGame cubeGame;
    private int panX, panY;

    public static int level;

    public CubeScreen(CubeGame game) {
        this.cubeGame = game;

        sideRotations = new SideRotations(cubeGame);
        Gdx.input.setInputProcessor(new GestureDetector(new CubeListener()));

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        cubeGame.modelBatch.begin(cubeGame.camera);

        cubeGame.modelBatch.render(cubeGame.WhiteCubeInstances[0],cubeGame.environment);
        cubeGame. modelBatch.render(cubeGame.WhiteCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.RedCubeInstances[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.RedCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.GreenCubeInstances[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.GreenCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.BlueCubeInstances[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.BlueCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.OrangeCubeInstances[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.OrangeCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.YellowCubeInstances[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.YellowCubeInstances[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[2],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[3],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[4],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[5],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[6],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[7],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[8],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[9],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[10],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[11],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[12],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[13],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[14],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[15],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[16],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[17],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[18],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[19],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[20],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[21],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[22],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[23],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[24],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[25],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[26],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[27],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[28],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[29],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[30],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[31],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[32],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[33],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[34],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.DoubleModels[35],cubeGame.environment);

        cubeGame.modelBatch.render(cubeGame.TripleModels[0],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[1],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[2],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[3],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[4],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[5],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[6],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[7],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[8],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[9],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[10],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[11],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[12],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[13],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[14],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[15],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[16],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[17],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[18],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[19],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[20],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[21],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[22],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[23],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[24],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[25],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[26],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[27],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[28],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[29],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[30],cubeGame.environment);
        cubeGame.modelBatch.render(cubeGame.TripleModels[31],cubeGame.environment);

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            CubeMenu.cube.setScreen(new CubeMenu(CubeMenu.cube));
        }

        cubeGame.modelBatch.end();

    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {
    }

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {cubeGame.dispose(); }

    protected class CubeListener implements GestureDetector.GestureListener {
        float Y = 0, X = 0;

        @Override
        public boolean touchDown(float x, float y, int pointer, int button) { return false; }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            return false;
        }

        @Override
        public boolean longPress(float x, float y) {

            CubeMenu.cube.setScreen(new PauseScreen());

            return true;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            return false;
        }

        @Override
        public boolean pan(float x,float y,float deltaX,float deltaY) {
            if(panX == 0 | panY == 0) {
                panX = (int) x;
                panY = (int) y;

            }
            return true;
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {
            if(panX*panX-x*x > 100 || panY*panY-y*y > 100 & pointer == 0) {
                sideRotations.Rotate((int) x, (int) y, panX, panY);

                int checkLayer = sideRotations.checkLayer();
                if(checkLayer == 5 & CubeGame.Broken){
                    CubeMenu.cube.setScreen(new HintScreen(5));
                }
                else if(checkLayer > level & CubeGame.HintOn & CubeGame.Broken) {
                    level = checkLayer;
                    CubeMenu.cube.setScreen(new HintScreen(checkLayer));
                }
            }
            panX = 0;
            panY = 0;
            return true;
        }

        @Override
        public boolean zoom(float initialDistance, float distance) {
            return false;
        }

        @Override
        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                if ((pointer2.x - initialPointer2.x) * (pointer2.x - initialPointer2.x) > (pointer2.y - initialPointer2.y) * (pointer2.y - initialPointer2.y)) {
                    X = (initialPointer2.x - pointer2.x) / 400;
                    cubeGame.camera.rotateAround(new Vector3(0, cubeGame.camera.position.y, 0), Vector3.Y, X);
                } else if(cubeGame.camera.position.y > -126 & cubeGame.camera.position.y < 126)
                     {

                    if(cubeGame.camera.position.z>90){
                        Y = (initialPointer2.y - pointer2.y) / 400;
                        cubeGame.camera.rotateAround(new Vector3(cubeGame.camera.position.x, 0, 0), Vector3.X, Y);
                        if (cubeGame.camera.position.y > 126 || cubeGame.camera.position.y < -126){
                            cubeGame.camera.rotateAround(new Vector3(cubeGame.camera.position.x, 0, 0), Vector3.X, -Y);
                        }
                    }else if (cubeGame.camera.position.x > 86){
                        Y = (pointer2.y - initialPointer2.y) / 400;
                        cubeGame.camera.rotateAround(new Vector3(0, 0, cubeGame.camera.position.z), Vector3.Z, Y);
                        if (cubeGame.camera.position.y > 126 || cubeGame.camera.position.y < -126){
                            cubeGame.camera.rotateAround(new Vector3(0, 0, cubeGame.camera.position.z), Vector3.Z, -Y);
                        }
                    }else if(cubeGame.camera.position.x < -86){
                        Y = (initialPointer2.y - pointer2.y) / 400;
                        cubeGame.camera.rotateAround(new Vector3(0, 0, cubeGame.camera.position.z), Vector3.Z, Y);
                        if (cubeGame.camera.position.y > 126 || cubeGame.camera.position.y < -126){
                            cubeGame.camera.rotateAround(new Vector3(0, 0, cubeGame.camera.position.z), Vector3.Z, -Y);
                        }
                    }else{
                        Y = (pointer2.y - initialPointer2.y) / 400;
                        cubeGame.camera.rotateAround(new Vector3(cubeGame.camera.position.x, 0, 0), Vector3.X, Y);
                        if (cubeGame.camera.position.y > 126 || cubeGame.camera.position.y < -126){
                            cubeGame.camera.rotateAround(new Vector3(cubeGame.camera.position.x, 0, 0), Vector3.X, -Y);
                        }
                    }
                }
                cubeGame.camera.lookAt(0, 0, 0);
                cubeGame.camera.update();

            return true;
        }

        @Override
        public void pinchStop() {
        }
    }
}
