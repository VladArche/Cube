package com.mygdx.cube;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class SideRotations {

    private CubeGame cubeGame;
    private Quaternion Q;
    private Vector3 V;
    private Random random = new Random();

    public SideRotations(CubeGame cubeGame) {
        this.cubeGame = cubeGame;
    }
    public boolean checkDouble(int t) {
        Vector3 V = cubeGame.DoubleModels[t].transform.getTranslation(Vector3.Zero);
        return V.x > cubeGame.DoubleTranslation[t/3][0] - 10f & V.x < cubeGame.DoubleTranslation[t/3][0] + 10f &
                V.y > cubeGame.DoubleTranslation[t/3][1] - 10f & V.y < cubeGame.DoubleTranslation[t/3][1] + 10f &
                V.z > cubeGame.DoubleTranslation[t/3][2] - 10f & V.z < cubeGame.DoubleTranslation[t/3][2] + 10f;
    }

    public boolean checkTriple(int t) {
        Vector3 V = cubeGame.TripleModels[t].transform.getTranslation(Vector3.Zero);
        return V.x > cubeGame.TripleTranslation[t/4][0] - 10f & V.x < cubeGame.TripleTranslation[t/4][0] + 10f &
                V.y > cubeGame.TripleTranslation[t/4][1] - 10f & V.y < cubeGame.TripleTranslation[t/4][1] + 10f &
                V.z > cubeGame.TripleTranslation[t/4][2] - 10f & V.z < cubeGame.TripleTranslation[t/4][2] + 10f;
    }

    public byte checkLayer(){
        byte x = 0;
        boolean next = true;

        for (int i = 0; i < cubeGame.DoubleModels.length; i++) {
            if (cubeGame.DoubleModels[i].transform.getTranslation(Vector3.Zero).y < -10){
                next &= checkDouble(i);
            }
        }
        if(next){
            x++;
            for (int i = 0; i < cubeGame.TripleModels.length; i++) {
                if (cubeGame.TripleModels[i].transform.getTranslation(Vector3.Zero).y < -10){
                    next &= checkTriple(i);
                }
            }
            if(next){
                x++;
                for (int i = 0; i < cubeGame.DoubleModels.length; i++) {
                    if (cubeGame.DoubleModels[i].transform.getTranslation(Vector3.Zero).y < -10 & cubeGame.DoubleModels[i].transform.getTranslation(Vector3.Zero).y > 10){
                        next &= checkDouble(i);
                    }
                }
                if (next){
                    x++;
                    for (int i = 0; i < cubeGame.DoubleModels.length; i++) {
                        if (cubeGame.DoubleModels[i].transform.getTranslation(Vector3.Zero).y > 10){
                            next &= checkDouble(i);
                        }
                    }
                    if (next){
                        x++;
                        for (int i = 0; i < cubeGame.TripleModels.length; i++) {
                            if (cubeGame.TripleModels[i].transform.getTranslation(Vector3.Zero).y < 10){
                                next &= checkTriple(i);
                            }
                        }
                        if(next){
                            x++;
                        }
                    }
                }
            }
        }
        return x;
    }

    public byte getSide(){

        Vector3 P = cubeGame.camera.position;
        if(P.y<122 & P.y>-109 & P.z>90){
            return 1;
        }else if(P.x>90 & P.y<122 & P.y>-109){
            return 2;
        }else if(P.x<-80 & P.y<122 & P.y>-109){
            return 4;
        }else if(P.z<-80 & P.y<122 & P.y>-109){
            return 3;
        }else if(P.y>122){
            if(P.z>90){
                return 51;
            }else if(P.x>90){
                return 52;
            }else if(P.x<-80){
                return 53;
            }else if(P.z<-80){
                return 54;
            }
        }else if(P.y<-109){
            if(P.z>90){
                return 61;
            }else if(P.x>90){
                return 62;
            }else if(P.x<-80){
                return 64;
            }else if(P.z<-80){
                return 63;
            }
        }
        return -1;
    }

    public void rotateSide(ModelInstance m, Vector3 axis, boolean clockwise){
        int x;
        if(clockwise){
            x = -90;
        }else{
            x = 90;
        }
        Q = m.transform.getRotation(new Quaternion(0,0,0,0));
        V = m.transform.getTranslation(Vector3.Zero);
        m.transform.set(V, new Quaternion(0,0,0,0));
        m.transform.translate(-V.x,-V.y,-V.z);
        m.transform.rotate(axis, x);
        m.transform.translate(V);
        m.transform.rotate(Q);
    }

    public void Break(){
        CubeGame.Broken = true;
        CubeScreen.level = 0;
        for (int i = 0; i < 20; i++) {
            int axis = random.nextInt(3);
            boolean layer = random.nextBoolean(), clockwise = random.nextBoolean();

            if(axis == 1){
                if(layer){ rotateXplus(clockwise); }
                else rotateXmin(clockwise);
            }
            else if(axis == 2){
                if(layer){ rotateYplus(clockwise); }
                else rotateYmin(clockwise);
            }else{
                if(layer){ rotateZplus(clockwise); }
                else rotateZmin(clockwise);
            }
        }
    }

    public void Rotate(int x, int y, int deltaX, int deltaY){

        final boolean maxY = (deltaY-y)*(deltaY-y) > (deltaX-x)*(deltaX-x);
        final boolean down = deltaY < y;
        final boolean right = x - deltaX > 0;
        byte side = CubeScreen.sideRotations.getSide();

        if (x > CubeMenu.width*2/3 & maxY) {
            if (down) {
                switch (side) {
                    case 1:
                    case 51:
                    case 61:{rotateXplus(false); }break;
                    case 2:
                    case 52:
                    case 62:{ rotateZmin(true);}break;
                    case 3:
                    case 54:
                    case 63:{rotateXmin(true);}break;
                    case 4:
                    case 53:
                    case 64:{rotateZplus(false);}break;
                }
            }else{
                    switch (side) {
                        case 1:
                        case 51:
                        case 61:{rotateXplus(true); }break;
                        case 2:
                        case 52:
                        case 62:{rotateZmin(false); }break;
                        case 3:
                        case 54:
                        case 63:{rotateXmin(false); }break;
                        case 4:
                        case 53:
                        case 64:{rotateZplus(true); }break;
                    }
                }
        }else if (x < CubeMenu.width/3 & maxY){
            if(down) {
                switch (side) {
                    case 1:
                    case 51:
                    case 61:{rotateXmin(false);}break;
                    case 2:
                    case 52:
                    case 62: {rotateZplus(true); }break;
                    case 3:
                    case 54:
                    case 63:{rotateXplus(true); }break;
                    case 4:
                    case 53:
                    case 64:{rotateZmin(false); }break;
                }
            }else{
                switch(side) {
                    case 1:
                    case 51:
                    case 61:{rotateXmin(true); }break;
                    case 2:
                    case 52:
                    case 62:{rotateZplus(false); }break;
                    case 3:
                    case 54:
                    case 63:{rotateXplus(false); }break;
                    case 4:
                    case 53:
                    case 64:{rotateZmin(true); }break;
                }
            }
        } else if (y < CubeMenu.height/3 & !maxY){
            if(right) {
                if (side < 5) {rotateYplus(false);}
                switch (side) {
                    case 51:
                    case 63: {rotateZmin(true); }break;
                    case 52:
                    case 64:{rotateXmin(true); }break;
                    case 53:
                    case 62: {rotateXplus(false); }break;
                    case 54:
                    case 61: {rotateZplus(false); }break;
                }
            }else {
                if (side < 5) {rotateYplus(true); }
                else switch (side){
                    case 51:
                    case 63: {rotateZmin(false);}break;
                    case 52:
                    case 64:{rotateXmin(false); }break;
                    case 53:
                    case 62: {rotateXplus(true); }break;
                    case 54:
                    case 61: {rotateZplus(true); }break;
                }
            }
        } else if (y > CubeMenu.height*2/3 & !maxY){
            if(right) {
                if (side < 5) {rotateYmin(false); }
                else switch (side){
                    case 51:
                    case 63: {rotateZplus(true);}break;
                    case 52:
                    case 64:{rotateXplus(true);}break;
                    case 53:
                    case 62: {rotateXmin(false);}break;
                    case 54:
                    case 61: {rotateZmin(false);}break;
                }
            }else{
                if (side < 5) {rotateYmin(true); }
                else switch (side){
                    case 51:
                    case 63: {rotateZplus(false);}
                    break;
                    case 52:
                    case 64: {rotateXplus(false);}break;
                    case 53:
                    case 62: {rotateXmin(true);}break;
                    case 54:
                    case 61: {rotateZmin(true); }break;
                }
            }
        }
    }

    private void rotateYplus(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).y > 10) {
                rotateSide(m, Vector3.Y, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).y > 10) {
                rotateSide(m, Vector3.Y, clockwise);
            }
        }
    }
    private void rotateYmin(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).y < -10) {
                rotateSide(m, Vector3.Y, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).y < -10) {
                rotateSide(m, Vector3.Y, clockwise);
            }
        }
    }
    private void rotateXplus(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).x > 10) {
                rotateSide(m, Vector3.X, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).x > 10) {
                rotateSide(m, Vector3.X, clockwise);
            }
        }
    }
    private void rotateXmin(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).x < -10) {
                rotateSide(m, Vector3.X, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).x < -10) {
                rotateSide(m, Vector3.X, clockwise);
            }
        }
    }
    private void rotateZplus(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).z > 10) {
                rotateSide(m, Vector3.Z, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).z > 10) {
                rotateSide(m, Vector3.Z, clockwise);
            }
        }
    }
    private void rotateZmin(boolean clockwise){
        for (ModelInstance m : cubeGame.DoubleModels) {
            if (m.transform.getTranslation(Vector3.Zero).z < -10) {
                rotateSide(m, Vector3.Z, clockwise);
            }
        }
        for (ModelInstance m : cubeGame.TripleModels) {
            if (m.transform.getTranslation(Vector3.Zero).z < -10) {
                rotateSide(m, Vector3.Z, clockwise);
            }
        }
    }
}