package com.rodneyxr.luckyengine;

import java.awt.Graphics;

public interface Engine extends Runnable {
	void create();

	void update(float delta);

	void render(Graphics g);
}
