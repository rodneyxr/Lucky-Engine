package core;

import java.awt.Color;
import java.awt.Graphics;

import engine.Game;

public class TestApp extends Game {

	@Override
	public void create() {
		// LuckyEngine.setLogFPS(true);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(0, 0, 100, 100);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 100, 100);
	}

	public static void main(String args[]) {
		new TestApp();
	}

}
