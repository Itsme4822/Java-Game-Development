package ca.jam.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.ObjectHandler;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class Level2 extends GameState{

	private Player player;
	private ObjectHandler collisions;
	private BufferedImage background;
	
	public Level2(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		collisions = new ObjectHandler();
		player = new Player(200, 100, Game.username, collisions);
		collisions.addObject(new Floor(225, 350, 550, 45, player));
		collisions.addObject(new Floor(145, 190, 150, 15, player));
		collisions.addObject(new Floor(750, 270, 100, 15, player));
		background = Game.IMAGELOADER.loadImage("/Backgrounds/Back1.png");
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		collisions.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		player.render(g);
		collisions.render(g);
	}
	//comment
	@Override
	public void keyInput() {
		/*
		 * This is where we handle keyboard input. Example of how to use this: 
		 * if (KeyHandler.isPressed(key)) { ... }
		 */
		player.keyInput();
	}

}
