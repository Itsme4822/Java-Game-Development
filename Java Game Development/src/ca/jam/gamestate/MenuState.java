package ca.jam.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ca.jam.main.Game;
import ca.jam.main.KeyHandler;

public class MenuState extends GameState {

	private BufferedImage background, play, controls, quit;
	private int cursor = 0;
	private boolean cursorMove = true;
	private int CURSOR_RESET = 10;
	private int cursorTimer = 0;

	public MenuState(Game game, GameStateManager gsm) {
		super(game, gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		background = Game.IMAGELOADER.loadImage("/backgrounds/menu.png");
		play = Game.IMAGELOADER.loadImage("/menu/play_button.png");
		controls = Game.IMAGELOADER.loadImage("/menu/controls_button.png");
		quit = Game.IMAGELOADER.loadImage("/menu/quit_button.png");
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
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.setColor(Color.WHITE);
		g.drawImage(play, 400, 150, null);
		g.drawImage(controls, 400, 250, null);
		g.drawImage(quit, 400, 350, null);
		g.setColor(Color.BLACK);
		g.fillRect(315, 175 + (100 * cursor), 64, 5);
		g.fillRect(670, 175 + (100 * cursor), 64, 5);

	}

	@Override
	public void keyInput() {
		if (KeyHandler.isPressed(KeyHandler.DOWN) && cursorMove) {
			if (cursor == 2) {
				cursor = 0;
			} else {
				cursor++;
			}
			cursorMove = false;
		}

		if (KeyHandler.isPressed(KeyHandler.UP) && cursorMove) {
			if (cursor == 0) {
				cursor = 2;
			} else {
				cursor--;
			}
			cursorMove = false;
		}
		
		if (KeyHandler.isPressed(KeyHandler.ENTER) && cursorMove) {
			if (cursor == 0) {
				//PLAY
				gsm.setState(gsm.LEVELSELECT);
			} else if (cursor == 1) {
				//CONTROLS
			} else {
				//QUIT
				System.exit(0);
			}
		}

	}

}
