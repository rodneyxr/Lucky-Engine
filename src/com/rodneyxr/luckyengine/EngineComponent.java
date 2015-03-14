package com.rodneyxr.luckyengine;

import java.awt.Graphics;

public interface EngineComponent extends Runnable {
	public void create();

	public void update(float delta);

	public void render(Graphics g);
}
