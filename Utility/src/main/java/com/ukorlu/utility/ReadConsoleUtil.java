package com.ukorlu.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleUtil {

	/**
	 * reader.readLine();
	 */
	public static BufferedReader readConsole() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * in.nextLine();
	 */
	public static Scanner readConsoleWithScanner() {
		return new Scanner(System.in);
	}

	public static String readLine() {
		return System.console().readLine();
	}
}
