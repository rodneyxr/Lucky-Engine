package com.rodneyxr.luckyengine.tools;

import com.rodneyxr.luckyengine.LuckyEngine;

import javax.swing.*;

/**
 * Created by Rodney on 2/18/2017.
 * <p>
 * This class provides a developer friendly way to send messages to the user
 * using pop up dialogs.
 */
public class Message {

	static final JFrame FRAME = new JFrame();

	public static void send(String message) {
		new Thread(() ->
				JOptionPane.showMessageDialog(FRAME, message, LuckyEngine.APPLICATION_NAME, JOptionPane.PLAIN_MESSAGE)
		).start();
	}

	public static void sendInfo(String title, String message) {
		new Thread(() ->
				JOptionPane.showMessageDialog(FRAME, message, title, JOptionPane.INFORMATION_MESSAGE)
		).start();
	}

	public static void sendWarning(String message) {
		new Thread(() ->
				JOptionPane.showMessageDialog(FRAME, message, "Warning", JOptionPane.WARNING_MESSAGE)
		).start();
	}

	public static void sendError(String title, String message) {
		new Thread(() ->
				JOptionPane.showMessageDialog(FRAME, message, title, JOptionPane.ERROR_MESSAGE)
		).start();
	}

}
