package com.ukorlu.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

	public static void writeFile(String fileName, String data) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8)) {
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return sb.toString();
	}
}
