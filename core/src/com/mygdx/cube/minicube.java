package com.mygdx.cube;

public class minicube {
    public int x;
    public int y;
    public byte move;

    public minicube(int x, int y, byte move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }

    public void tap(int x, int y){
        if(x > this.x-300 & x < this.x+450 & y>CubeMenu.height-this.y-300 & y<CubeMenu.height-this.y+450){
                 if(x > this.x-300 & x < this.x+75 & y > CubeMenu.height-this.y-300 & y < CubeMenu.height-this.y) move = 2;
            else if(x > this.x+75 & x < this.x+300 & y > CubeMenu.height-this.y-300 & y < CubeMenu.height-this.y) move = 3;
            else if(x > this.x-300 & x < this.x+75 & y > CubeMenu.height-this.y-75) move = 1;
            else if(x > this.x+75 & x < this.x+300 & y > CubeMenu.height-this.y-75) move = 4;

        }
    }

    public boolean ifCrash(minicube c){
        return(x > c.x-150 & x < c.x+150 & y > c.y-150 & y < c.y+150);
    }

    public void reflectMoving() {
        move = (byte)((move+2)%5);
    }

    public void setMove(){
        switch(move){
            case 1:{
                x +=1.5;
                y +=1.5;
                if(x > CubeMenu.width-150) {move = 4;}
                else if(y > CubeMenu.height-150) move = 2;
            }break;
            case 2:{
                x+=1.5;
                y-=1.5;
                if(x > CubeMenu.width-150) {move = 3;}
                else if(y < 0) move = 1;
            }break;
            case 3:{
                x-=1.5;
                y-=1.5;
                if(x < 0) {move = 2;}
                else if(y < 0) move = 4;
            }break;
            case 4:{
                y+=1.5;
                x-=1.5;
                if(x < 0) {move = 1;}
                else if(y > CubeMenu.height-150) move = 3;
            }break;
        }

    }
}
