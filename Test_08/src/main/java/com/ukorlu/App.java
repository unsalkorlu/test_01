package com.ukorlu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {

	private static final Logger logger = Logger.getLogger(App.class.getName());
	private static final LogManager logManager = LogManager.getLogManager();
	static {
		try {
			logManager.readConfiguration(new FileInputStream("./log.properties"));
		} catch (IOException exception) {
			logger.log(Level.SEVERE, "Error in loading configuration", exception);
		}
	}

	public static void main(String[] args) {
		logger.log(Level.SEVERE, "Hello World!");
	}
}
