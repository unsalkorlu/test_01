package com.ukorlu;

import java.util.Scanner;

import com.ukorlu.utility.ReadConsoleUtil;

public class App {

	public static void main(String[] args) {
		String command = "";
		while (!"exit".equalsIgnoreCase(command)) {
			Scanner scanner = ReadConsoleUtil.readConsoleWithScanner();
			command = scanner.nextLine();
			System.out.println(command);
		}
		System.out.println("Program end.");
	}
}
