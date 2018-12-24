package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectile extends GameObject	{
	/*TODO:
	 * Fix the graivty. Its falling too fast
	 */
	private final double GRAVITY = 0.5;
	private double drag;
	
	public Projectile(float x, float y, int width, int height, GameObject parent) {
		super(x, y);
		this.x = parent.x;
		this.y = parent.y;
		this.width = width;
		this.height = height;
		velX = 20;
		velY = 3;
		drag = 0.03 * height;
	}

	public void tick() {
		x += velX;
		y += velY;
		velY += GRAVITY;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
	}

	
	
}
