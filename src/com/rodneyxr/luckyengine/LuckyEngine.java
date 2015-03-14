package com.rodneyxr.luckyengine;

/**
 * This class will handle all global operations such as FPS and logging.
 * 
 * @author Rodney
 *
 */
public class LuckyEngine {

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

}
