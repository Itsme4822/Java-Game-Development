package ca.jam.gamestate;

import java.awt.Graphics2D;

import ca.jam.gameobject.Floor;
import ca.jam.main.Game;

public class Level2 extends GameState{

	
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
		floor = new Floor(225, 350, 550, 45);
		floor2 = new Floor(145, 190, 150, 15);
		floor3 = new Floor(750, 270, 100, 15);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		floor.tick();
		floor2.tick();
		floor3.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
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
