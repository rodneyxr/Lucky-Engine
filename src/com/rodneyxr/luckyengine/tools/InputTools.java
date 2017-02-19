package com.rodneyxr.luckyengine.tools;

import com.rodneyxr.luckyengine.LuckyEngine;

import javax.swing.*;

import static com.rodneyxr.luckyengine.tools.Message.FRAME;

/**
 * Created by Rodney on 2/18/2017.
 * <p>
 * This class is creates a developer friendly way to get input
 * from the user using pop up windows.
 */
public class InputTools {

	private static final String[] YES_NO_OPTIONS = {"Yes", "No"};

	public static boolean yesOrNo(String question) {
		int response = JOptionPane.showOptionDialog(
				FRAME, question,
				"Question", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				YES_NO_OPTIONS,
				YES_NO_OPTIONS[1]
		);
		return response == 0;
	}

	public static String getString(String message) {
		return JOptionPane.showInputDialog(FRAME, message, LuckyEngine.APPLICATION_NAME, JOptionPane.PLAIN_MESSAGE);
	}

}
