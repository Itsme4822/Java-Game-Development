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
	private Player player;

	public TestState(Game game, GameStateManager gsm) {
		super(game, gsm);
	}

	@Override
	public void init() {
		/*
		 * Define variables and objects here
		 */
		player = new Player(100, 100);
	}

	@Override
	public void tick() {
		/*
		 * This is where game logic goes. Every update/tick that happens in the game,
		 * this function is run. There are 60 ticks per second.
		 */
		player.tick();
	}

	@Override
	public void render(Graphics2D g) {
		/*
		 * This is where we can draw things. Use the object g to draw things you want.
		 * Right now you can only use basic shapes and colours. We can add graphics
		 * after.
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		player.render(g);
	}

	@Override
	public void keyInput() {
		/*
		 * This is where we handle keyboard input. Example of how to use this: 
		 * if (KeyHandler.isPressed(key)) { ... }
		 */
		if (KeyHandler.isPressed(KeyHandler.LEFT)) {
			player.setVelX(-6);
		} else if (KeyHandler.isPressed(KeyHandler.RIGHT)) {
			player.setVelX(6);
		} else {
			player.setVelX(0);
		}
		
		if (KeyHandler.isPressed(KeyHandler.UP) && player.isGrounded()) {
			player.setVelY(-8);
			player.setGrounded(false);
		}
		if (KeyHandler.isPressed(KeyHandler.DOWN)) {
			player.setVelY(5);
		}
	}

}
