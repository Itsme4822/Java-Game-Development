package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;


public class Player extends GameObject{

	private double gravity = 0.2;
	private boolean isGrounded = false;
	
	public Player(float x, float y) {
		super(x, y);
		width = 32;
		height = 32;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y + height > 500) {
			y = 500 - height;
			isGrounded = true;
		} else {
			isGrounded = false;
		}
		
		if (!isGrounded) {
			velY += gravity;
		} else {
			velY = 0;
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) (y + height), 64, 10);
	}

	public boolean isGrounded() {
		return isGrounded;
	}

	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}

	
}
