/*
 * @(#)SqlMake.java  2016.05.30
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yuwook
 */
public class SqlMake {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\NAVER.AD01150159\\Desktop\\cafe.txt";

        FileReader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);

        FileWriter fileWriter = new FileWriter("C:\\Users\\NAVER.AD01150159\\Desktop\\cafe_sql.sql");

        for (;;) {
            String line = bufferedReader.readLine();

            if (line == null) break;

            String sql = String.format("INSERT INTO iv_remonitor_log (content_id, umon_in_tdt, service_code, virtual_service_code, wk_status, all_monitored)" +
                    " VALUES(%s, SYSDATE, 'CAF', 'CAF', 'AA02', 'N');", line);

            fileWriter.write(sql + "\n");
        }

        reader.close();
        fileWriter.close();

    }
}
