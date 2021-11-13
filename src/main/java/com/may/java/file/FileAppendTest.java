/**
 * @(#) FileAppendTest.class 1.0.0 2019. 10. 21.
 *
 * Copyright 2019 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
public class FileAppendTest {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("/tmp/append-file", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);

		out.println("text");
		out.close();
		bw.close();
		fw.close();
	}
}
