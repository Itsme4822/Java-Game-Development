package ca.jam.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import ca.jam.gameobject.*;
import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class Level1 extends GameState {
	/*
	 * Declare variables and objects here.
	 */
	private Player player;
	private Floor floor;
	private Floor floor2;
	private Floor floor3;
	private ObjectHandler collisions;

	public Level1(Game game, GameStateManager gsm) {
		super(game, gsm);
	}

	@Override
	public void init() {
		/*
		 * Define variables and objects here
		 */
		collisions = new ObjectHandler();
		player = new Player(200, 100, Game.username, collisions);
		floor = new Floor(155, 450, 700, 25, player);
		floor2 = new Floor(315, 350, 350, 15, player);
		floor3 = new Floor(425, 250, 125, 5, player);
		collisions.addObject(floor);
		collisions.addObject(floor2);
		collisions.addObject(floor3);
	}
	//hi

	@Override
	public void tick() {
		/*
		 * This is where game logic goes. Every update/tick that happens in the game,
		 * this function is run. There are 60 ticks per second.
		 */
		player.tick();
		collisions.tick();
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
		collisions.render(g);
	}

	@Override
	public void keyInput() {
		/*
		 * This is where we handle keyboard input. Example of how to use this: 
		 * if (KeyHandler.isPressed(key)) { ... }
		 */
		player.keyInput();
	}

}
