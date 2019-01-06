package ca.jam.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.ObjectHandler;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class Level3 extends GameState{
	
	private Player player;
	private BufferedImage background;
	private ObjectHandler collisions;
	
	public Level3(Game game, GameStateManager gsm) {
		super(game, gsm);
		
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public void init() {
		background = game.IMAGELOADER.loadImage("/Backgrounds/Glacier.png");
		collisions = new ObjectHandler();
		player = new Player(100, 100, Game.username, collisions);
		collisions.addObject(new Floor(80,475,190,25,player));
		collisions.addObject(new Floor(360, 465, 340, 25, player));
		collisions.addObject(new Floor(790, 470, 150, 25, player));
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
		player.keyInput();
		
	}

}
