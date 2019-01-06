package ca.jam.gamestate;

import java.awt.event.MouseEvent;

import ca.jam.main.Game;

public class GameStateManager {

	// All the classes that the gamestates may need
	private Game game;

	private GameState[] gameStates; // List that holds all the gamestates in the game
	private int currentState; // ID of the current gamestate

	// How many gamestates there are in the game. Must change when you add new
	// states.
	public static final int NUMGAMESTATES = 6;

	// GAMESTATE IDs. These IDs must be unique.
	public final int MENUSTATE = 0;
	public final int LEVELSELECT = 1;
	public final int LEVEL1 = 2;
	public final int LEVEL2 = 3;
	public final int LEVEL3 = 4;
	public final int LEVEL4 = 5;

	// hello
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new GameState[NUMGAMESTATES];
		currentState = MENUSTATE;
		setState(currentState);
	}

	private void loadState(int state) { // Loads all the states in the game
		if (state == MENUSTATE) {
			gameStates[state] = new MenuState(game, this);
		} else if (state == LEVELSELECT) {
			gameStates[state] = new LevelSelectState(game, this);
		} else if (state == LEVEL1) {
			gameStates[state] = new Level1(game, this);
		} else if (state == LEVEL2) {
			gameStates[state] = new Level2(game, this);
		} else if (state == LEVEL3) {
			gameStates[state] = new Level3(game, this);
		} else if (state == LEVEL4) {
			gameStates[state] = new Level4(game, this);
		}
	}

	private void unloadState(int state) {
		gameStates[state] = null;
	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
		Game.currentState = gameStates[currentState];
		gameStates[currentState].init();
	}

	public void tick() {
		gameStates[currentState].keyInput();
		gameStates[currentState].tick();
	}

	public void render(java.awt.Graphics2D g) {
		try {
			gameStates[currentState].render(g);
		} catch (Exception e) {

		}
	}
}
