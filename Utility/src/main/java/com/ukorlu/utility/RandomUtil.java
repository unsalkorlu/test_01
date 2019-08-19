package com.ukorlu.utility;

import java.util.Random;

public class RandomUtil {

	private static final String RANDOM_PASSWORD_UPPERCASE_LETTER_SET = "ABCDEFGHIJKLMNOPRSTUVYZ";
	private static final String RANDOM_PASSWORD_LOWERCASE_LETTER_SET = "abcdefghijklmnoprstuvyz";
	private static final String RANDOM_PASSWORD_NUMBER_SET = "0123456789";
	private static final int PASSWORD_LENGTH = 9;
	private static final int HASH_PREFIX_POSTFIX_LENGTH = 4;
	private static Random random = new Random();

	public static String generateRandomHashPrePostFix() {
		StringBuilder sb = new StringBuilder(HASH_PREFIX_POSTFIX_LENGTH);
		for (int i = 0; i < HASH_PREFIX_POSTFIX_LENGTH; i++) {
			if (i % 2 == 0) {
				sb.append(RANDOM_PASSWORD_UPPERCASE_LETTER_SET.charAt(random.nextInt(RANDOM_PASSWORD_UPPERCASE_LETTER_SET.length())));
			} else if (i % 2 == 1) {
				sb.append(RANDOM_PASSWORD_NUMBER_SET.charAt(random.nextInt(RANDOM_PASSWORD_NUMBER_SET.length())));
			}
		}
		return sb.toString();
	}

	public static String generateRandomPassword() {
		StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			if (i % 3 == 0) {
				sb.append(RANDOM_PASSWORD_UPPERCASE_LETTER_SET.charAt(random.nextInt(RANDOM_PASSWORD_UPPERCASE_LETTER_SET.length())));
			} else if (i % 3 == 1) {
				sb.append(RANDOM_PASSWORD_NUMBER_SET.charAt(random.nextInt(RANDOM_PASSWORD_NUMBER_SET.length())));
			} else if (i % 3 == 2) {
				sb.append(RANDOM_PASSWORD_LOWERCASE_LETTER_SET.charAt(random.nextInt(RANDOM_PASSWORD_LOWERCASE_LETTER_SET.length())));
			}
		}
		return sb.toString();
	}
}
