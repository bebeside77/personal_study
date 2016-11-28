/*
 * @(#)HttpServer.java  2016.11.17
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuwook
 */
@Slf4j
public class HttpServer {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);

        for (;;) {
            log.info("Server is waiting request...");

            Socket socket = serverSocket.accept();
            handleRequest(socket);

            log.info("Handled request.");
        }


    }

    public void handleRequest(Socket socket) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        bw.write("hello client, now " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new HttpServer().start();
    }
}
