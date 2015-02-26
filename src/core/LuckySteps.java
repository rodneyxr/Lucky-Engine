package core;

import java.awt.Color;
import java.awt.Graphics;

import engine.Game;

public class LuckySteps extends Game {

	@Override
	public void create() {
		System.out.println("+==========================+");
		System.out.println("| Program: Lucky Steps     |");
		System.out.println("| Author: Rodney Rodriguez |");
		System.out.println("| Date: January 2, 2015    |");
		System.out.println("+==========================+");
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(0, 0, 100, 100);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 100, 100);
	}

	public static void main(String args[]) {
		new LuckySteps();
	}

}
