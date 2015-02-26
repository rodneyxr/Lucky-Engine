package engine;

import java.awt.Graphics;

import javax.swing.JFrame;

import core.mvc.Controller;
import core.mvc.Model;
import core.mvc.View;

public abstract class Game implements EngineComponent {

	protected Model model;
	protected View view;
	protected Controller controller;

	protected boolean running;

	public Game() {
		create();
		init();
	}

	public void init() {
		// setup MVC
		model = new Model();
		view = new View(this);
		controller = new Controller(model, view);

		// register listeners
		view.registerListeners(controller);

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
			update(0);
			view.draw(); // this will call render
		}
	}

}
