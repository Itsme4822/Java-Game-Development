package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

import ca.jam.main.Game;

public class TestObject extends GameObject{
	
	
	public TestObject(float x, float y) {
		super(x, y);
		id = ObjectId.testObject;
		width = 64;
		height = 64;
	}

	@Override
	public void tick() {
		/*
		 * Update object game logic in here
		 */
		x += velX;
		y += velY;
		
		// Checks for collisions with walls
		if (x < 0) {
			x = 0;
		}
		
		if (x + width > Game.WIDTH * Game.SCALE) {
			x = Game.WIDTH * Game.SCALE - width;
		}
		
		if (y < 0) {
			y = 0;
		}
		
		if (y + height > Game.HEIGHT * Game.SCALE) {
			y = Game.HEIGHT * Game.SCALE - height;
		}
		
		
	}

	@Override
	public void render(Graphics2D g) {
		/*
		 * Update the graphics of the object here
		 */
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, width, height);
		
	}

}
