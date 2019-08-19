package com.ukorlu;

import com.ukorlu.utility.FileUtil;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		FileUtil.writeFile("output.txt", FileUtil.readFile("input.txt"));
		System.out.println("Replacement Finished!");
	}
	
}
