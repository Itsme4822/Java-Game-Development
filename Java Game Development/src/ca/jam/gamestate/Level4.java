package ca.jam.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.ObjectHandler;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class Level4 extends GameState {

	private Player player;
	private ObjectHandler collisions;
	private BufferedImage background;

	public Level4(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		background = game.IMAGELOADER.loadImage("/Backgrounds/mario.jpg");
		collisions = new ObjectHandler();
		player = new Player(100, 100, Game.username, collisions);
		collisions.addObject(new Floor(265, 0, 155, 215, player));
		collisions.addObject(new Floor(0, 278, 177, 45, player));
		collisions.addObject(new Floor(177, 324, 320, 47, player));
		collisions.addObject(new Floor(745, 250, 200, 300, player));
		collisions.addObject(new Floor(600, 500, 450, 70, player));
		collisions.addObject(new Floor(0, 500, 300, 70, player));
		// TODO Auto-generated method stub

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		collisions.tick();
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		collisions.render(g);
		player.render(g);
		// TODO Auto-generated method stub

	}

	@Override
	public void keyInput() {
		// TODO Auto-generated method stub
		player.keyInput();
	}

}
