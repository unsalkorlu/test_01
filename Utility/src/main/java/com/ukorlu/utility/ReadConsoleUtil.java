package com.ukorlu.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadConsoleUtil {

	/**
	 * reader.readLine();
	 * 
	 */
	public static BufferedReader readConsole() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
}
