package ca.jam.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import ca.jam.gameobject.*;
import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class TestState extends GameState {
	/*
	 * Declare variables and objects here.
	 */
	private TestObject object;

	public TestState(Game game, GameStateManager gsm) {
		super(game, gsm);
	}

	@Override
	public void init() {
		/*
		 * Define variables and objects here
		 */
		object = new TestObject(100, 100);
	}

	@Override
	public void tick() {
		/*
		 * This is where game logic goes. Every update/tick that happens in the game,
		 * this function is run. There are 60 ticks per second.
		 */
		object.tick();
	}

	@Override
	public void render(Graphics2D g) {
		/*
		 * This is where we can draw things. Use the object g to draw things you want.
		 * Right now you can only use basic shapes and colours. We can add graphics
		 * after.
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		object.render(g);
	}

	@Override
	public void keyInput() {
		/*
		 * This is where we handle keyboard input. Example of how to use this: if
		 * (KeyHandler.isPressed(key)) { ... }
		 */
		if (KeyHandler.isPressed(KeyHandler.UP)) {
			object.setVelY(-5);
		} else if (KeyHandler.isPressed(KeyHandler.DOWN)) {
			object.setVelY(5);
		} else {
			object.setVelY(0);
		}

		if (KeyHandler.isPressed(KeyHandler.LEFT)) {
			object.setVelX(-5);
		}

		else if (KeyHandler.isPressed(KeyHandler.RIGHT)) {
			object.setVelX(5);
		} else {
			object.setVelX(0);
		}
	}

}
