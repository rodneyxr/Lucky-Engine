package com.rodneyxr.luckyengine;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.rodneyxr.luckyengine.mvc.Input;
import com.rodneyxr.luckyengine.mvc.Model;
import com.rodneyxr.luckyengine.mvc.View;

/**
 * This class will handle all global operations such as FPS and logging.
 * 
 * @author Rodney
 *
 */
public abstract class LuckyEngine implements Engine {

	private static boolean debug = true;

	/**
	 * MVC
	 */
	private Model model;
	private View view;
	private Input input;

	/**
	 * Loop
	 */
	private boolean running;

	/**
	 * FPS
	 */
	private static int fps; // frames per second
	private static float delta; // the time between two frames
	private static int ticks; // number of the ticks in one frame
	private static long tSec; // time of last second
	private static long tTick; // time of last tick
	private static boolean logFPS; // true to log FPS to stdout

	/**
	 * Initializes the Engine
	 */
	public LuckyEngine() {
		System.out.println("+==========================+");
		System.out.println("| Program: Lucky Engine    |");
		System.out.println("| Author: Rodney Rodriguez |");
		System.out.println("| Date: January 2, 2015    |");
		System.out.println("+==========================+");
		logFPS = false;
		init();
		create();
	}

	public void init() {
		// setup MVC
		model = new Model();
		view = new View(this);
		input = new Input(model, view);

		// register listeners
		view.registerListeners(input);

		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 800);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		view.setVisible(true);

		running = true;
		new Thread(this).start();
	}

	/**
	 * 
	 * @return the frames per second
	 */
	public static int getFPS() {
		return fps;
	}

	/**
	 * 
	 * @return the time in seconds between frames
	 */
	public static float getDeltaTime() {
		return delta;
	}

	/**
	 * If true, the Lucky Engine will log the FPS to stdout once a second
	 * 
	 * @param logFPS
	 */
	public static void setLogFPS(boolean logFPS) {
		LuckyEngine.logFPS = logFPS;
	}

	public static void log(String msg) {
		if (debug)
			System.out.println(msg);
	}

	public static void log(String format, Object... args) {
		log(String.format(format, args));
	}

	/**
	 * Performs calculations for the fps
	 */
	public void tick() {
		delta = (System.nanoTime() - tTick);
		tTick = System.nanoTime();
		if (System.nanoTime() - tSec < 1000000000) {
			ticks++;
		} else {
			tSec = tTick;
			fps = ticks;
			ticks = 0;
			if (logFPS)
				System.out.printf("FPS: %d\n", fps);
		}
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (running) {
			tick();
			update(LuckyEngine.getDeltaTime());
			view.draw(); // this will call render
			sleep(16);
		}
	}

	@Override
	public abstract void create();

	@Override
	public abstract void update(float delta);

	@Override
	public abstract void render(Graphics g);

}
