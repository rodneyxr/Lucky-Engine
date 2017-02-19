package com.rodneyxr.luckyengine;

import java.awt.*;

/**
 * This class will handle the buffering and drawing to the gameScreen. It will
 * create a buffer and pass it to the game class's render method so that the
 * engine has an easy way to draw to the canvas.
 *
 * @author Rodney
 */
public class GameScreen extends Canvas {
	private static final long serialVersionUID = 1L;

	private static int WIDTH = 0;
	private static int HEIGHT = 0;
	private static int CENTER_X = 0;
	private static int CENTER_Y = 0;

	private LuckyEngine luckyEngine; // this class will pass the Graphics to render method

	/* Double Buffer */
	private Image dbImage;
	private Graphics dbg;

	public GameScreen(LuckyEngine instance) {
		this.luckyEngine = instance;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.setFocusable(true);
	}

	public static int width() {
		return WIDTH;
	}

	public static int height() {
		return HEIGHT;
	}

	public static int centerX() {
		return CENTER_X;
	}

	public static int centerY() {
		return CENTER_Y;
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		GameScreen.WIDTH = width;
		GameScreen.HEIGHT = height;
		GameScreen.CENTER_X = WIDTH / 2;
		GameScreen.CENTER_Y = HEIGHT / 2;
	}

	public void update(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		luckyEngine.render(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

}
