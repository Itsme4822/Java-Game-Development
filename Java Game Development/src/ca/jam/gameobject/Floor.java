package ca.jam.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Floor extends GameObject{

	public Floor(float x, float y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	//hi
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.magenta);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	
	
}
