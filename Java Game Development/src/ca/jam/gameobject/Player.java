package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	private double gravity = 0.2;
	private boolean isGrounded = false;
	private ObjectHandler objects;

	public Player(float x, float y) {
		super(x, y);
		width = 64;
		height = 64;
	}

	public Player(float x, float y, ObjectHandler objects) {
		super(x, y);
		width = 32;
		height = 32;
		this.objects = objects;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		velY += gravity;
		collisionNoBoxes();
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
				Floor tempFloor = (Floor) tempObject;
				if (getBoundsBottom().intersects(tempFloor.getCollisionBox())) {
					y = tempFloor.getY() - height;
					isGrounded = true;
				} else {
					isGrounded = false;
				}
			}
		}
	}

	public void collisionNoBoxes() {
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
				
				//Collision with top and bottom of floors
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
