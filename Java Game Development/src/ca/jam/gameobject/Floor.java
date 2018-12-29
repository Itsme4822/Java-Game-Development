package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Floor extends GameObject{

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
	//hi
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.magenta);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void collisionWithPlayer(Player player) {
		//Player lands ontop of the floor
		if (player.getX() >= x && player.getX() + player.getWidth() <= x + width && player.getVelY() > 0) {
			if (player.getY() + player.getHeight() >= y ) {
				player.setY(y - player.getHeight() - player.getVelY());
				player.setGrounded(true);
			} else {
				player.setGrounded(false);
			}
		}
	}
	
	
}
