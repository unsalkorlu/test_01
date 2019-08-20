package com.ukorlu;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.ukorlu.utility.ReadConsoleUtil;
import com.ukorlu.utility.SecureUtil;

public class App {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		System.out.println("generateOTPCode. enter digitCount");
		BufferedReader reader = ReadConsoleUtil.readConsole();
		System.out.println("generateSixDigitOTPCode : " + SecureUtil.generateOTPCode(Integer.parseInt(reader.readLine())));
	}

}
