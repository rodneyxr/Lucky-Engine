package com.rodneyxr.luckyengine.mvc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	// MVC
	private Model model;
	private View view;

	public Input(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		// System.out.printf("KeyPressed: '%c'\n", k.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent k) {
		// System.out.printf("KeyReleased: '%c'\n", k.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent k) {
		System.out.printf("KeyTyped: '%c'\n", k.getKeyChar());
	}

}
