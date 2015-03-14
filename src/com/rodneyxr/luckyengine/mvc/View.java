package com.rodneyxr.luckyengine.mvc;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.rodneyxr.luckyengine.Application;
import com.rodneyxr.luckyengine.GameScreen;
import com.rodneyxr.luckyengine.LuckyEngine;

public class View extends JFrame {
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

	public void registerListeners(Input controller) {
		gameScreen.addKeyListener(controller);
	}
}
