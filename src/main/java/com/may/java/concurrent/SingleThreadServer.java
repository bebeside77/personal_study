/*
 * @(#)com.may.java.concurrent.SingleThreadServer.java  2015.12.30
 *
 * Copyright 2015 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuwook
 */
public class SingleThreadServer {//

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket serverSocket = new ServerSocket(800);
				Socket socket = serverSocket.accept();

				handleRequest(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void handleRequest(Socket socket) {
		// do something...
	}
}
