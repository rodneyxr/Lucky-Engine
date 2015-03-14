package core;

import java.awt.Color;
import java.awt.Graphics;

import com.rodneyxr.luckyengine.Application;

public class TestApp extends Application {

	@Override
	public void create() {
		log("create");
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

	public static void main(String[] args) {
		new TestApp();
	}
}
