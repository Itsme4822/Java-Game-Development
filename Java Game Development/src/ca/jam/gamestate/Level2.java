package ca.jam.gamestate;

import java.awt.Graphics2D;

import ca.jam.gameobject.Floor;
import ca.jam.gameobject.Player;
import ca.jam.main.Game;

public class Level2 extends GameState{

	private Player player;
	private Floor floor;
	private Floor floor2;
	private Floor floor3;
	private Floor floor4;
	
	
	public Level2(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		player = new Player(100, 100);
		floor = new Floor(225, 350, 550, 45, player);
		floor2 = new Floor(145, 190, 150, 15, player);
		floor3 = new Floor(750, 270, 100, 15, player);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		floor.tick();
		floor2.tick();
		floor3.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		player.render(g);
		floor.render(g);
		floor2.render(g);
		floor3.render(g);
	}
	//comment
	@Override
	public void keyInput() {
		// TODO Auto-generated method stub
		
	}

}
