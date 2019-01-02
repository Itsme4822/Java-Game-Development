package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Floor extends GameObject {

	private Player player;

	public Floor(float x, float y, int width, int height, Player player) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.player = player;
		id = ObjectId.floor;
	}

	@Override
	public void tick() {

	}

	// hi
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.magenta);
		g.fillRect((int) x, (int) y, width, height);
	}

	public Rectangle getCollisionBox() {
		return new Rectangle((int) x, (int) y, width, height);
	}
	/*
	 * else { if (player.getY() < y + height && player.getY() > y) { player.setY(y +
	 * height); player.setVelY(5); } }
	 */

}
