package com.mygdx.cube;

import com.badlogic.gdx.Game;

public class Cube extends Game {

	@Override
	public void create () {
		setScreen(new CubeMenu(this));
	}

}