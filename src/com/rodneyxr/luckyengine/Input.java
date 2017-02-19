package com.rodneyxr.luckyengine;

/**
 * Created by Rodney on 2/19/2017.
 * <p>
 * This class holds information about real-time user input.
 */
public final class Input {

	// X and Y axis (left, right, up, down or WASD)
	static float X = 0;
	static float Y = 0;

	/**
	 * -1: Keys.LEFT | Keys.A
	 * 0 : No input
	 * 1 : Keys.RIGHT | Keys.D
	 *
	 * @return X axis input values.
	 */
	public static float getX() {
		return X;
	}

	/**
	 * -1: Keys.DOWN | Keys.S
	 * 0 : No input
	 * 1 : Keys.UP | Keys.W
	 *
	 * @return Y axis input values.
	 */
	public static float getY() {
		return Y;
	}

}
