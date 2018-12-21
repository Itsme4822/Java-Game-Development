package ca.jam.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{
	// Number of keyboard controls in the game. Should change if we add more keys or just make it to 101 (number keys on keyboard)
	public static int NUM_KEYS = 4;
	// Array tracks which keys are pressed
	private static boolean keysPressed[] = new boolean[NUM_KEYS];
	
	// These are the IDs of the keys in the game. Key constants. These constants must be unique.
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public void keyPressed(KeyEvent e) {
		/*
		 * Example of how to add a keyPressed Event:
		 * if (key == KeyEvent.VK_"key you want") {
		 * 		keyPressed["key constant"] = true;
		 * }
		 */
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) keysPressed[UP] = true;
		if (key == KeyEvent.VK_DOWN) keysPressed[DOWN] = true;
		if (key == KeyEvent.VK_LEFT) keysPressed[LEFT] = true;
		if (key == KeyEvent.VK_RIGHT) keysPressed[RIGHT] = true;
		
	}
	
	public void keyReleased(KeyEvent e) {
		/*
		 * Example of how to add a keyReleased Event:
		 * if (key == KeyEvent.VK_"key you want") {
		 * 		keyPressed["key constant"] = false;
		 * }
		 */
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) keysPressed[UP] = false;
		if (key == KeyEvent.VK_DOWN) keysPressed[DOWN] = false;
		if (key == KeyEvent.VK_LEFT) keysPressed[LEFT] = false;
		if (key == KeyEvent.VK_RIGHT) keysPressed[RIGHT] = false;
		
	}
	
	public static boolean isPressed(int key) {
		// Just a method to check if a key is pressed
		return keysPressed[key];
	}
}
