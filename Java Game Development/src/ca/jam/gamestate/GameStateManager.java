package ca.jam.gamestate;

import java.awt.event.MouseEvent;

import ca.jam.main.Game;

public class GameStateManager {

	//All the classes that the gamestates may need
	private Game game;
	
	private GameState[] gameStates; // List that holds all the gamestates in the game
	private int currentState; // ID of the current gamestate
	
	// How many gamestates there are in the game. Must change when you add new states.
	public static final int NUMGAMESTATES = 1; 
	
	//GAMESTATE IDs. These IDs must be unique.
	public final int TESTSTATE = 0;
	
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new GameState[NUMGAMESTATES];
		currentState = TESTSTATE;
		setState(currentState);
	}
	
	private void loadState(int state) { // Loads all the states in the game
		if (state == TESTSTATE) {
			gameStates[state] = new TestState(game, this);
		}
	}

	private void unloadState(int state) {
		gameStates[state] = null;
	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
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
