package ca.jam.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;

public class Level4 extends GameState{

	private Player player;
	private BufferedImage background;
	private Floor floor;
	private Floor floor2;
	private Floor floor3;
	private Floor floor4;
	private Floor floor5;
	private Floor floor6;
	
	
	public Level4(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		background = game.IMAGELOADER.loadImage("/Backgrounds/mario.jpg");
		floor = new Floor(265,0,155,215,player);
		floor2 = new Floor(0,278,177,45,player);
		floor3 = new Floor(177, 324, 320,47,player);
		floor4 = new Floor(745,250,200,300,player);
		floor5 = new Floor(600,500,450,70,player);
		floor6 = new Floor(0,500,300,70,player);
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
		floor4.render(g);
		floor5.render(g);
		floor6.render(g);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyInput() {
		// TODO Auto-generated method stub
		
	}

}
