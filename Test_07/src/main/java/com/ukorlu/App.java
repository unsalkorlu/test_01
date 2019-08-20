package com.ukorlu;

import java.util.Scanner;

import com.ukorlu.utility.ReadConsoleUtil;
import com.ukorlu.utility.StringUtil;

public class App {

	public static void main(String[] args) {
		String command = "";
		while (!"exit".equalsIgnoreCase(command)) {
			if (command.length() > 0) {
				if ("help".equalsIgnoreCase(command)) {
					printHelp();
				} else {
					String parts[] = command.split("\\s");
					if (parts.length == 2) {
						if (parts[0].equalsIgnoreCase("trim")) {
							System.out.println(StringUtil.trim(parts[1]));
						} else if (parts[0].equalsIgnoreCase("trimAndSetNullIfBlank")) {
							System.out.println(StringUtil.trimAndSetNullIfBlank(parts[1]));
						} else {
							System.out.println("Command Not Found!");
						}
					} else {
						System.out.println("Invalid Command! For help write help command.");
					}
				}
			}
			Scanner scanner = ReadConsoleUtil.readConsoleWithScanner();
			command = scanner.nextLine();
		}
		System.out.println("Program end!");
	}

	private static void printHelp() {
		System.out.println("trim param : trim space from param");
		System.out.println("trimAndSetNullIfBlank param : trim space if param blank return null");
	}
}
