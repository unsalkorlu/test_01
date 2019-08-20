package com.ukorlu.utility;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64EncoderUtil {

	public static String getSHA1Text(String text) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		return (new BASE64Encoder()).encode(sha1.digest(text.getBytes("UTF-8")));
	}

	public static String getSHA1Text(String text, String encoding) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		return (new BASE64Encoder()).encode(sha1.digest(text.getBytes(encoding)));
	}

	public static String getSHA256Text(String text) throws Exception {
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		return (new BASE64Encoder()).encode(sha256.digest(text.getBytes("UTF-8")));
	}
}
