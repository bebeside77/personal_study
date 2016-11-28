/*
 * @(#)HttpClient.java  2016.11.17
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author yuwook
 */
@Slf4j
public class HttpClient {
    public void request() throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 80);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        for (;;) {
            String line = br.readLine();
            log.info("line ===> " + line);

            if (line == null) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (;;) {
            new HttpClient().request();

            Thread.sleep(5000);
        }
    }
}
