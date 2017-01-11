package com.may.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bebeside77
 */
@Slf4j
public class BOMLearn {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D:\\aa.txt");

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        log.info(line);

        for (char c : line.toCharArray()) {
            log.info(Integer.toHexString(c));
        }

    }
}
