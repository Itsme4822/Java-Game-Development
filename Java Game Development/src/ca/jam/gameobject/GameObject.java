package ca.jam.gameobject;

import java.awt.Graphics2D;

public abstract class GameObject {

	protected float x, y;
	protected float velX = 0, velY = 0;
	protected int width, height;
	protected ObjectId id;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	// Getter and setters for the gameObject (Any variables that we will need)
		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public float getY() {
			return y;
		}

		public void setY(float y) {
			this.y = y;
		}

		public float getVelX() {
			return velX;
		}

		public void setVelX(float velX) {
			this.velX = velX;
		}

		public float getVelY() {
			return velY;
		}

		public void setVelY(float velY) {
			this.velY = velY;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public ObjectId getId() {
			return id;
		}
	
}
