package core.mvc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	// MVC
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent k) {

	}

	@Override
	public void keyReleased(KeyEvent k) {

	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

}
