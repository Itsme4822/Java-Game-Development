package ca.jam.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import ca.jam.gamestate.GameStateManager;
import ca.jam.gfx.BufferedImageLoader;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	/**
	 * This is the game class. This is where the actual game is going to be. In here
	 * we should only access the Gamestatemanager.
	 */
	private static final long serialVersionUID = 1L;

	// Variables for the window
	public static final int WIDTH = 1024;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final String TITLE = "Java Game";
	public static int FPS;

	private BufferedImage image  = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	
	// Variables for the game
	public static final BufferedImageLoader IMAGELOADER = new BufferedImageLoader();
	private boolean running = false;
	private Thread game;
	private GameStateManager gsm;

	public Game() {
		new GameWindow(WIDTH, HEIGHT, TITLE, this);
	}

	public void init() {
		gsm = new GameStateManager(this);
		addKeyListener(new KeyHandler());
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public synchronized void start() {
		if (running)
			return;
		game = new Thread(this);
		running = true;
		game.start();
	}

	public synchronized void stop() {
		running = false;
		if (game != null) {
			try {
				game.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;

		init();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				FPS = frames;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	public void tick() {
		gsm.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// ///////////////////////////////
		// DRAW HERE
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		gsm.render(g);
		// ///////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		System.out.println("WIDTH: " + game.getWidth() + " HEIGHT: " + game.getHeight());
		game.start();
		game.requestFocus();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
