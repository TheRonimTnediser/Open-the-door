package dev.ronimtnediser.openthedoor;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ronimtnediser.openthedoor.display.Display;
import dev.ronimtnediser.openthedoor.gfx.Assets;
import dev.ronimtnediser.openthedoor.managers.MouseManager;
import dev.ronimtnediser.openthedoor.managers.MouseMotionManager;
import dev.ronimtnediser.openthedoor.states.GameState;
import dev.ronimtnediser.openthedoor.states.State;

public class Game implements Runnable {
	// DISPLAY
	private Display display;

	private float width, height;
	private String title;

	private BufferStrategy bs;
	private Graphics g;

	// THREAD
	private Thread thread;

	private boolean running;

	// STATES
	private State gameState;

	// MANAGERS
	private MouseManager mouseManager;
	private MouseMotionManager mouseMotionManager;
	
	public Game(float width, float height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;

	}

	public void init() {
		new Assets();
		
		mouseManager = new MouseManager();
		mouseMotionManager = new MouseMotionManager();
		
		display = new Display(width, height, title);
		display.getCanvas().addMouseListener(getMouseManager());
		display.getCanvas().addMouseMotionListener(getMouseMotionManager());

		gameState = new GameState(this);
		State.setCurrentState(gameState);
	}

	public void tick() {
		if (State.getCurrentState() != null)
			State.getCurrentState().tick();
	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// DRAW
		g.clearRect(0, 0, (int) width, (int) height);

		if (State.getCurrentState() != null)
			State.getCurrentState().render(g);

		// END DRAW

		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();

		while (running) {
			tick();
			render();
		}

		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public MouseMotionManager getMouseMotionManager() {
		return mouseMotionManager;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
}
