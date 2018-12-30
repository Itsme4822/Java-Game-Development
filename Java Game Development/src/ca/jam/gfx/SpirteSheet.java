package ca.jam.gfx;

import java.awt.image.BufferedImage;

public class SpirteSheet {

	private BufferedImage spriteSheet;
	
	public SpirteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	public BufferedImage grabImage(int column, int row, int width, int height) {
		BufferedImage sprite = spriteSheet.getSubimage(column * 32, height * 32, width, height);
		return sprite;
	}
	
}
