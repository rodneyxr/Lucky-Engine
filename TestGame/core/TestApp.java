package core;

import java.awt.Color;
import java.awt.Graphics;

import com.rodneyxr.luckyengine.Application;
import com.rodneyxr.luckyengine.LuckyEngine;
import com.rodneyxr.luckyengine.tools.Vector2;

public class TestApp extends Application {

	private Ball ball1;
	private Ball ball2;

	@Override
	public void create() {
		ball1 = new Ball(0f, 0f, 25f, 25f, 50f, Color.RED);
		ball2 = new Ball(800f, 800f, -25f, -25f, 50f, Color.BLUE);
	}

	@Override
	public void update(float delta) {
		ball1.update(delta);
		ball2.update(delta);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + LuckyEngine.getFPS(), 0, g.getFont().getSize());
		g.drawString(Float.toString(Vector2.distance(ball1.getPosition(), ball2.getPosition())), 0, g.getFont().getSize() * 2);
		
		ball1.render(g);
		ball2.render(g);
	}

	public static void main(String[] args) {
		new TestApp();
	}
}
