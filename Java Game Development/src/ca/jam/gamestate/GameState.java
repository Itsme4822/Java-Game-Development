package ca.jam.gamestate;

import java.awt.event.MouseEvent;

import ca.jam.main.Game;

public abstract class GameState {
	/*
	 * Abstract class for gamestates. This tells the gamestate classes what functions they need.
	 */
	public Game game;
	protected GameStateManager gsm;

	public GameState(Game game, GameStateManager gsm) {
		this.game = game;
		this.gsm = gsm;
	}

	public abstract void init();

	public abstract void tick();

	public abstract void render(java.awt.Graphics2D g);
	
	public abstract void keyInput();
	
	/*
	public abstract void mousePressed(MouseEvent e);
	
	public abstract void mouseReleased(MouseEvent e);

	public abstract void mouseMoved(MouseEvent e);
	*/
}
