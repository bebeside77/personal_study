package com.may.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * hash extract.
 *
 * @author bebeside77
 */
public class MessageDigesting {

	public String getMd5Hash(String str) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());

			byte[] byteData = messageDigest.digest();

			StringBuilder sb = new StringBuilder();
			for (byte aByteData : byteData) {
				sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}


	public static void main(String[] args) {
		MessageDigesting messageDigesting = new MessageDigesting();

		System.out.println(messageDigesting.getMd5Hash("hello bebeside77!"));
	}
}
