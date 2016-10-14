/*
 * @(#)PstmtExecute.java  2016.07.08
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @author yuwook
 */
@Slf4j
public class PstmtExecute {

    public static void main(String[] args) {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch (ClassNotFoundException e) {
//            log.error("", e);
//        }

        String url = "jdbc:oracle:thin:@10.113.164.163:1728:UMONDEV";
        String userName = "umonivkpi";
        String password = "umonivkpi";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement pstmt = connection.prepareStatement("select * from cont_mstr_iv where user_id = ?");
             SomeResource someResource = new SomeResource()) {

            pstmt.setString(1, "nv1umon104");
//            pstmt.setString(1, null);
//            pstmt.setNull(1, Types.VARCHAR);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                log.info(resultSet.getString("content_id"));
            }

        } catch (SQLException e) {
            log.error("", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    log.info("close resultSet"); // finally 보다 try with resource 부분이 먼저 처리된다.
                } catch (SQLException e) {

                }
            }
        }


    }

    static class SomeResource implements AutoCloseable {

        @Override
        public void close() throws Exception {
            log.info("close");
        }
    }
}
