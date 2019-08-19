package com.ukorlu;

import com.ukorlu.utility.RandomUtil;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("generateSixDigitOTPCode :" + RandomUtil.generateRandomHashPrePostFix());
		System.out.println("generateRandomPassword :" + RandomUtil.generateRandomPassword());
	}
}
