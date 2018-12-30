package ca.jam.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;

public class Level3 extends GameState{
	
	private Player player;
	private BufferedImage background;
	private Floor floor;
	private Floor floor2;
	private Floor floor3;
	
	public Level3(Game game, GameStateManager gsm) {
		super(game, gsm);
		
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public void init() {
		background = game.IMAGELOADER.loadImage("/Backgrounds/Glacier.png");
		floor = new Floor(80,475,190,25,player);
		floor2 = new Floor(360, 465, 340, 25, player);
		floor3 = new Floor(790, 470, 150, 25, player);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		floor.render(g);
		floor2.render(g);
		floor3.render(g);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyInput() {
		// TODO Auto-generated method stub
		
	}

}
