package com.rodneyxr.luckyengine.tools;

import java.util.Scanner;

public class Tools {

	private static final Scanner INPUT = new Scanner(System.in);

	public static String input(String prompt) {
		System.out.print(prompt);
		return INPUT.nextLine();
	}

}
