package com.rodneyxr.luckyengine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * This class will handle the buffering and drawing to the gameScreen. It will
 * create a buffer and pass it to the game class's render method so that the
 * engine has an easy way to draw to the canvas.
 * 
 * @author Rodney
 *
 */
public class GameScreen extends Canvas {
	private static final long serialVersionUID = 1L;

	private Game game; // this class will pass the Graphics to render method

	/* Double Buffer */
	private Image dbImage;
	private Graphics dbg;

	public GameScreen(Game game) {
		this.game = game;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.setFocusable(true);
	}

	public void update(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		game.render(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

}
