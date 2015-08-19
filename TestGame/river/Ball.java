package river;

import java.awt.Color;
import java.awt.Graphics;

import com.rodneyxr.luckyengine.tools.Vector2;

public class Ball {

	private Vector2 position;
	private Vector2 velocity;
	private float size;
	private Color color;
	private boolean enabled;

	public Ball(float x, float y, float velocityX, float velocityY, float size,
			Color color) {
		this.position = new Vector2(x, y);
		this.velocity = new Vector2(velocityX, velocityY);
		this.size = size;
		this.color = color;
		this.enabled = true;
	}

	public void move(float x, float y) {
		if (!enabled)
			return;
		position.x += x;
		position.y += y;

	}

	public Vector2 getPosition() {
		return position;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void update(float delta) {
		if (!enabled)
			return;
		position.add(velocity.x * delta, velocity.y * delta);
	}

	public void render(Graphics g) {
		if (!enabled)
			return;
		g.setColor(color);
		g.fillOval((int) (position.x - size / 2),
				(int) (position.y - size / 2), (int) size, (int) size);
	}
}
