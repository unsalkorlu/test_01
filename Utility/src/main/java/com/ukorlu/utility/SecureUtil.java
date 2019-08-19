package com.ukorlu.utility;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureUtil {

	private static final String SHA1_PRNG = "SHA1PRNG";
	private static final byte NUMBER_OF_OTP_CODE_DIGIT = 6;

	public static String generateSixDigitOTPCode() throws NoSuchAlgorithmException {
		SecureRandom rnd = SecureRandom.getInstance(SHA1_PRNG);
		String randomNumber = "";
		for (int i = 0; i < NUMBER_OF_OTP_CODE_DIGIT; i++) {
			randomNumber += rnd.nextInt(NUMBER_OF_OTP_CODE_DIGIT);
		}
		return randomNumber;
	}

	public static String generateOTPCode(int digitCount) throws NoSuchAlgorithmException {
		SecureRandom rnd = SecureRandom.getInstance(SHA1_PRNG);
		String randomNumber = "";
		for (int i = 0; i < digitCount; i++) {
			randomNumber += rnd.nextInt(10);
		}
		return randomNumber;
	}
}
