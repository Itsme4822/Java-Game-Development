package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import ca.jam.main.KeyHandler;

public class Player extends GameObject {

	private String username;
	private double gravity = 0.2;
	private boolean isGrounded = false;
	private ObjectHandler objects;

	public Player(float x, float y, String username, ObjectHandler objects) {
		super(x, y);
		width = 32;
		height = 32;
		this.username = username;
		this.objects = objects;
	}
	public Player(float x, float y, String username) {
		super(x, y);
		width = 32;
		height = 32;
		this.username = username;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		velY += gravity;
		collision();
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fill(getHitBox());

		// Collision bounds
		g.setColor(Color.RED);
		g.draw(getBoundsTop());

		g.setColor(Color.CYAN);
		g.draw(getBoundsBottom());

		g.setColor(Color.YELLOW);
		g.draw(getBoundsLeft());

		g.setColor(Color.GREEN);
		g.draw(getBoundsRight());
	}

	public void collision() {
		for (int i = 0; i < objects.objects.size(); i++) {
			GameObject tempObject = objects.objects.get(i);
			if (tempObject.getId() == ObjectId.floor) {
				Floor floor = (Floor) tempObject;

				if (getBoundsLeft().intersects(floor.getCollisionBox())) {
					x = floor.getX() + floor.getWidth();
				}

				if (getBoundsRight().intersects(floor.getCollisionBox())) {
					x = floor.getX() - width;
				}

				// Collision with top and bottom of floors
				if (x + width > floor.getX() && x < floor.getX() + floor.getWidth()) {

					if (y < floor.getY() + floor.getHeight() && y > floor.getY()) {
						y = floor.getY() + floor.getHeight() + 1;
						velY = 2;
					}

					if (y + height > floor.getY() && y + height < floor.getY() + floor.getHeight()) {
						y = floor.getY() - height + 1;
						velY = 0;
						isGrounded = true;
					}
				}
			}
		}
	}

	public void keyInput() {
		if (KeyHandler.isPressed(KeyHandler.LEFT)) {
			velX = -6;
		} else if (KeyHandler.isPressed(KeyHandler.RIGHT)) {
			velX = 6;
		} else {
			velX = 0;
		}

		if (KeyHandler.isPressed(KeyHandler.UP) && isGrounded) {
			velY = -6;
			isGrounded = false;
		}
		if (KeyHandler.isPressed(KeyHandler.DOWN)) {
			velY = 5;
		}
	}

	public boolean isGrounded() {
		return isGrounded;
	}

	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}

	public Rectangle getHitBox() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + 10, (int) y, width - 20, height / 8);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle((int) x + 10, (int) y + height - (height / 8), width - 20, height / 8);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 10, width / 8, height - 20);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + width - (width / 8), (int) y + 10, width / 8, height - 20);
	}

}
