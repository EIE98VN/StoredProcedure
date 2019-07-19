package com.topica.jdbc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcedureJDBCDemo {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    public static void main(String[] args) {
        String sql = "{call selectAllStudents()}";
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Id: %-4s \tName: %-15s\tAge: %-5s\tClass: %-5s\n",
                        rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
