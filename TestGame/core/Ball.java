package core;

import java.awt.Color;
import java.awt.Graphics;

import com.rodneyxr.luckyengine.tools.Vector2;

public class Ball {

	private Vector2 position;
	private Vector2 velocity;
	private float size;
	private Color color;

	public Ball(Vector2 position, Vector2 velocity, float size, Color color) {
		this.position = position;
		this.velocity = velocity;
		this.size = size;
		this.color = color;
	}

	public void move(float x, float y) {
		position.x += x;
		position.y += y;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void update(float delta) {
//		position.add(velocity.x * delta, velocity.y * delta);
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (position.x - size / 2), (int) (position.y - size / 2), (int) size, (int) size);
	}
}
