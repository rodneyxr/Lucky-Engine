package core;

import com.rodneyxr.luckyengine.Application;
import com.rodneyxr.luckyengine.GameScreen;
import com.rodneyxr.luckyengine.Input;
import com.rodneyxr.luckyengine.LuckyEngine;
import com.rodneyxr.luckyengine.tools.Vector2;

import java.awt.*;

public class TestApp extends Application {

	private Ball ball1;
	private Ball ball2;
	private final float SPEED = 5f;

	@Override
	public void create() {
		ball1 = new Ball(Vector2.zero(), Vector2.zero(), 50f, Color.RED);
		ball2 = new Ball(new Vector2(GameScreen.centerX(), GameScreen.centerY()), Vector2.zero(), 50f, Color.BLUE);
	}

	@Override
	public void update(float delta) {
		float speed = SPEED;// * delta;
		ball1.move(Input.getX() * speed, Input.getY() * -speed);
		ball1.update(delta);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + LuckyEngine.getFPS(), 0, g.getFont().getSize());
		g.drawString(Float.toString(Vector2.distance(ball1.getPosition(), ball2.getPosition())), 0, g.getFont().getSize() * 2);
		g.drawString("Input.X: " + Input.getX(), 0, g.getFont().getSize() * 3);
		g.drawString("Input.Y: " + Input.getY(), 0, g.getFont().getSize() * 4);
		g.drawString("Hello World", GameScreen.centerX(), GameScreen.centerY());

		ball1.render(g);
		ball2.render(g);
	}

	public static void main(String[] args) {
		new TestApp();
	}
}
