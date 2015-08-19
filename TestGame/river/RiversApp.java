package river;

import java.awt.Color;
import java.awt.Graphics;

import com.rodneyxr.luckyengine.Application;
import com.rodneyxr.luckyengine.LuckyEngine;
import com.rodneyxr.luckyengine.tools.Vector2;

public class RiversApp extends Application {
	Ball ball1;
	Ball ball2;

	@Override
	public void create() {
		System.out.println("Hello Rodney.");
		ball1 = new Ball(0, 0, 50, 50, 50, Color.CYAN);
		ball2 = new Ball(800, 800, -50, -50, 50, Color.RED);
	}

	@Override
	public void update(float delta) {
		if (Vector2.distance(ball1.getPosition(), ball2.getPosition()) <= 50) {
			ball1.setEnabled(false);
			ball2.setEnabled(false);
		}

		ball1.update(delta);
		ball2.update(delta);
	}

	@Override
	public void render(Graphics g) {
		ball1.render(g);
		ball2.render(g);
		g.drawString(String.valueOf(LuckyEngine.getFPS()), 0, 10);
	}

	public static void main(String[] args) {
		new RiversApp();
	}

}
