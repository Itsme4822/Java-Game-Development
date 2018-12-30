package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Floor extends GameObject {

	private Player player;

	public Floor(float x, float y, int width, int height, Player player) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.player = player;
	}

	@Override
	public void tick() {
		collisionWithPlayer(player);

	}

	// hi
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.magenta);
		g.fillRect((int) x, (int) y, width, height);
	}

	public void collisionWithPlayer(Player player) {
		// Possibly above or below the floor
		if (player.getX() + player.getWidth() >= x && player.getX() <= x + width) {
			// falling down, therefore landing on the floor
			if (player.getVelY() > 0) {
				if (player.getY() + player.getHeight() > y && player.getY() + player.getHeight() < y + height) {
					player.setGrounded(true);
					player.setVelY(0);
					player.setY(y - player.getHeight());
				}
			}
		} else {
			player.setGrounded(false);
		}
	}
	/*
	 * else { if (player.getY() < y + height && player.getY() > y) { player.setY(y +
	 * height); player.setVelY(5); } }
	 */

}
