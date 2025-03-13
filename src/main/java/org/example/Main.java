package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String sql = "Select name from Students where id=1";
        String url = "jdbc:postgresql://localhost:5432/JDBCTestDb";
        String username = "postgres";
        String password = "0000";



        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            try( ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()) {
                    String name = rs.getString(1);
                    System.out.println("Student Name: " + name);
                }
                else {
                    System.out.println("No student found with ID 1");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}