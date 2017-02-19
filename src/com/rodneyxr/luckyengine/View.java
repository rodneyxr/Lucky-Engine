package com.rodneyxr.luckyengine;

import javax.swing.*;
import java.awt.*;

final class View extends JFrame {
	private static final long serialVersionUID = 1L;

	private GameScreen gameScreen;

	public View(LuckyEngine instance) {
		super("Lucky Engine - In Development");
		gameScreen = new GameScreen(instance);
		this.add(gameScreen);
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		gameScreen.setSize(width, height);
	}

	public Graphics getPaint() {
		return gameScreen.getGraphics();
	}

	public void draw() {
		gameScreen.repaint();
	}

	public void registerListeners(Controller controller) {
		gameScreen.addKeyListener(controller);
	}
}
