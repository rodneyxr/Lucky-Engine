package com.rodneyxr.luckyengine;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.rodneyxr.luckyengine.mvc.Input;
import com.rodneyxr.luckyengine.mvc.Model;
import com.rodneyxr.luckyengine.mvc.View;

public abstract class Game implements EngineComponent {

	private static LuckyEngine luckyEngine = new LuckyEngine();

	/**
	 * MVC
	 */
	private Model model;
	private View view;
	private Input input;

	/**
	 * GameLoop
	 */
	private boolean running;

	public Game() {
		init();
		create();
	}

	public void init() {
		// setup MVC
		model = new Model();
		view = new View(this);
		input = new Input(model, view);

		// register listeners
		view.registerListeners(input);

		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 800);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		view.setVisible(true);

		running = true;
		new Thread(this).start();
	}

	public abstract void create();

	public abstract void update(float delta);

	public abstract void render(Graphics g);

	@Override
	public void run() {
		while (running) {
			luckyEngine.tick();
			sleep(16);
			update(LuckyEngine.getDeltaTime());
			view.draw(); // this will call render
		}
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
