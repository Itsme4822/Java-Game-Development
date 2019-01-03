package ca.jam.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class LevelSelectState extends GameState {

	private BufferedImage background;
	private BufferedImage level1, level2, level3, level4;
	private BufferedImage border;
	private int cursor = 0;
	private boolean cursorMove = true;
	private int CURSOR_RESET = 10;
	private int cursorTimer = 0;
	
	public LevelSelectState(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		background = Game.IMAGELOADER.loadImage("/backgrounds/menu.png");
		border = Game.IMAGELOADER.loadImage("/levelselect/border.png");
		level2 = Game.IMAGELOADER.loadImage("/Backgrounds/Back1.png");
		level3 = Game.IMAGELOADER.loadImage("/Backgrounds/Glacier.png");
		level4 = Game.IMAGELOADER.loadImage("/Backgrounds/mario.jpg");	
		
	}

	@Override
	public void tick() {
		if (!cursorMove) {
			if (cursorTimer >= CURSOR_RESET) {
				cursorMove = true;
				cursorTimer = 0;
			} else {
				cursorTimer++;
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.setColor(Color.BLACK);
		g.fillRect(120, 150, 180, 135);
		g.drawImage(level2, 320, 150, 180, 135, null);
		g.drawImage(level3, 520, 150, 180, 135, null);
		g.drawImage(level4, 720, 150, 180, 135, null);
		g.drawImage(border, 120, 150, null);
		g.drawImage(border, 320, 150, null);
		g.drawImage(border, 520, 150, null);
		g.drawImage(border, 720, 150, null);
		g.setColor(Color.RED);
		g.fillRect(135 + (200 * cursor), 300, 150, 10);
		
	}

	@Override
	public void keyInput() {
		if (KeyHandler.isPressed(KeyHandler.RIGHT) && cursorMove) {
			if (cursor == 3) {
				cursor = 0;
			} else {
				cursor++;
			}
			cursorMove = false;
		}

		if (KeyHandler.isPressed(KeyHandler.LEFT) && cursorMove) {
			if (cursor == 0) {
				cursor = 3;
			} else {
				cursor--;
			}
			cursorMove = false;
		}
		
		if (KeyHandler.isPressed(KeyHandler.ENTER) && cursorMove) {
			if (cursor == 0) {
				gsm.setState(gsm.LEVEL1);
			} else if (cursor == 1) {
				gsm.setState(gsm.LEVEL2);
			} else if (cursor == 2) {
				gsm.setState(gsm.LEVEL3);
			} else {
				gsm.setState(gsm.LEVEL4);
			}
		}
	}

}
