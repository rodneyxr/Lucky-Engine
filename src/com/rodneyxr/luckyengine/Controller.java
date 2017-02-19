package com.rodneyxr.luckyengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class Controller implements KeyListener {

	// MVC
	private Model model;
	private View view;

	// Input

	private static float DOWN = -1;
	private static float UP = 1;
	private static float LEFT = -1;
	private static float RIGHT = 1;
	public boolean down;
	public boolean up;
	public boolean right;
	public boolean left;

	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				up = true;
				Input.Y = UP;
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				down = true;
				Input.Y = DOWN;
				break;
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				left = true;
				Input.X = LEFT;
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				right = true;
				Input.X = RIGHT;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		switch (k.getKeyCode()) {
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				up = false;
				Input.Y = down ? DOWN : 0;
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				down = false;
				Input.Y = up ? UP : 0;
				break;
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				left = false;
				Input.X = right ? RIGHT : 0;
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				right = false;
				Input.X = left ? LEFT : 0;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
